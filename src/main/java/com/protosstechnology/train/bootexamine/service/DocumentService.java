/**
 * 
 */
package com.protosstechnology.train.bootexamine.service;

import com.protosstechnology.train.bootexamine.entity.Document;

/**
 * <description>
 *
 * @type com.protosstechnology.train.bootexamine.service
 * @author nattawat.k
 * @contact nattawat.k@kbtg.tech
 * @date Aug 31, 2020 2:23:49 PM
 *
 */
public interface DocumentService {

	public void create(Document document);

	public Document read(Long id);

	public Document update(Document document);

	public void delete(Long id);

}
