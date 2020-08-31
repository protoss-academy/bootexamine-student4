/**
 * 
 */
package com.protosstechnology.train.bootexamine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * <description>
 *
 * @type com.protosstechnology.train.bootexamine.entity
 * @author nattawat.k
 * @contact nattawat.k@kbtg.tech
 * @date Aug 31, 2020 2:21:03 PM
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Document {

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String documentNumber;

	@NonNull
	private String description;

}
