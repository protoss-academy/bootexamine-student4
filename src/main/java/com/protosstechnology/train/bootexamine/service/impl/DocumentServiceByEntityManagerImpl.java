/**
 * 
 */
package com.protosstechnology.train.bootexamine.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.protosstechnology.train.bootexamine.entity.Document;
import com.protosstechnology.train.bootexamine.service.DocumentService;

/**
 * <description>
 *
 * @type com.protosstechnology.train.bootexamine.service.impl
 * @author nattawat.k
 * @contact nattawat.k@kbtg.tech
 * @date Aug 31, 2020 2:25:08 PM
 *
 */
@Service
@Transactional
public class DocumentServiceByEntityManagerImpl implements DocumentService {

	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.protosstechnology.train.bootexamine.service.DocumentService#create(com.
	 * protosstechnology.train.bootexamine.entity.Document)
	 */
	@Override
	public void create(Document document) {
		entityManager.persist(document);
		entityManager.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.protosstechnology.train.bootexamine.service.DocumentService#read(java.
	 * lang.Long)
	 */
	@Override
	public Document read(Long id) {
		return entityManager.find(Document.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.protosstechnology.train.bootexamine.service.DocumentService#update(com.
	 * protosstechnology.train.bootexamine.entity.Document)
	 */
	@Override
	public Document update(Document document) {
		return entityManager.merge(document);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.protosstechnology.train.bootexamine.service.DocumentService#delete(java.
	 * lang.Long)
	 */
	@Override
	public void delete(Long id) {
		Document document = entityManager.find(Document.class, id);
		entityManager.remove(document);
	}

}
