package com.example.identityservice.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.example.identityservice.common.ErrorConstants;
import com.example.identityservice.dao.DtoToEntityConveter;
import com.example.identityservice.dao.UserDAO;
import com.example.identityservice.dto.UserDto;
import com.example.identityservice.entities.User;
import com.example.identityservice.exception.IMSException;
import com.example.identityservice.repository.UserRepository;

@Repository
public class UserDAOImpl implements UserDAO, DtoToEntityConveter<UserDto, User> {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private UserRepository repository;

	@PersistenceContext
	private EntityManager em;

	private EntityManager getEntityManager() {
		return em;
	}

	@Override
	public User createUser(UserDto userDto) throws IMSException {

		logger.debug("create user dao started");
		User user = new User();
		this.dtoToEntityConvert(userDto, user);
		user = repository.save(user);
		logger.debug("create user dao finished");
		return user;
	}

	@Override
	public void dtoToEntityConvert(UserDto dto, User entity) {

		if (StringUtils.isNotEmpty(dto.getFirstName())) {
			entity.setFirstName(dto.getFirstName());
		}

		if (StringUtils.isNotEmpty(dto.getLastName())) {
			entity.setLastName(dto.getLastName());
		}

		if (StringUtils.isNotEmpty(dto.getEmail())) {
			entity.setEmail(dto.getEmail());
		}

		if (StringUtils.isNotEmpty(dto.getMobileNo())) {
			entity.setMobileNo(dto.getMobileNo());
		}

		if (StringUtils.isNotEmpty(dto.getAge())) {
			entity.setAge(dto.getAge());
		}
	}

	@Override
	public List<User> getAllUser(Integer startIndex, Integer count, String sortBy, String sortOrder)
			throws IMSException {
		logger.debug("get all user dao started");
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);

		if (!sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				cq.orderBy(cb.asc(root.get(sortBy)));
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				cq.orderBy(cb.desc(root.get(sortBy)));
			}
		}

		TypedQuery<User> query = getEntityManager().createQuery(cq);
		// int totalResult = query.getResultList().size();

		if (startIndex != 0 || count != 0) {
			query.setFirstResult(startIndex);
			query.setMaxResults(count);

		}
		List<User> userList = query.getResultList();

		logger.debug("get all  user dao finished");
		return userList;
	}

	@Override
	public User getUser(long userId) throws IMSException {
		User user = em.find(User.class, userId);
		if (user == null) {
			throw new IMSException(HttpStatus.NOT_FOUND.value(), ErrorConstants.RECORD_NOT_FOUND);
		}
		return user;
	}

	@Override
	public User updateUser(long userId, UserDto updateDto) throws IMSException {
		User user = em.find(User.class, userId);
		if (user == null) {
			throw new IMSException(HttpStatus.NOT_FOUND.value(), ErrorConstants.RECORD_NOT_FOUND);
		}
		this.dtoToEntityConvert(updateDto, user);
		user = repository.save(user);
		return user;
	}

	@Override
	public void deleteUser(long userId) throws IMSException {
		User user = em.find(User.class, userId);
		if (user == null) {
			throw new IMSException(HttpStatus.NOT_FOUND.value(), ErrorConstants.RECORD_NOT_FOUND);
		}
		repository.delete(user);
	}

}
