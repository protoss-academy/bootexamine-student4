/**
 * 
 */
package com.protosstechnology.train.bootexamine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protosstechnology.train.bootexamine.dto.DocumentDTO;
import com.protosstechnology.train.bootexamine.entity.Document;
import com.protosstechnology.train.bootexamine.service.DocumentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * <description>
 *
 * @type com.protosstechnology.train.bootexamine.controller
 * @author nattawat.k
 * @contact nattawat.k@kbtg.tech
 * @date Aug 31, 2020 2:27:04 PM
 *
 */
@RestController
@RequestMapping("/document")
@Slf4j
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@GetMapping("/{id}")
	@Operation(summary = "Get Document by id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the document", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Document.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id document", content = @Content),
			@ApiResponse(responseCode = "404", description = "Document not found", content = @Content) })
	public ResponseEntity<Document> getDocument(@PathVariable("id") String id) {
		log.info("========== In Method getDocument id={}", id);

		Document document = documentService.read(Long.parseLong(id));
		if (null != document) {
			log.info("Id : {}", document.getId());
			log.info("DocumentNumber : {}", document.getDocumentNumber());
			log.info("Description : {}", document.getDescription());
		} else {
			log.warn("Document not found");
		}

		return ResponseEntity.ok().body(document);
	}

	@PostMapping
	public ResponseEntity<Document> addDocument(@RequestBody DocumentDTO document) {
		log.info("========== In Method addDocument");

		Document persistentDocument = new Document();
		persistentDocument.setDocumentNumber(document.getDocumentNumber());
		persistentDocument.setDescription(document.getDescription());
		documentService.create(persistentDocument);

		log.info("Document Id = {}", persistentDocument.getId());
		return ResponseEntity.ok().body(persistentDocument);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Document> updateDocument(@PathVariable("id") String id, @RequestBody DocumentDTO document) {
		log.info("========== In Method updateDocument");

		Document persistentDocument = new Document();
		persistentDocument.setId(Long.parseLong(id));
		persistentDocument.setDocumentNumber(document.getDocumentNumber());
		persistentDocument.setDescription(document.getDescription());
		documentService.update(persistentDocument);

		log.info("Update Document Id = {}", persistentDocument.getId());
		return ResponseEntity.ok().body(persistentDocument);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDocument(@PathVariable("id") String id) {
		log.info("========== In Method deleteDocument");

		String responseStr;
		try {
			documentService.delete(Long.parseLong(id));
			responseStr = "Delete document {" + id + "} Successful";
		} catch (Exception e) {
			responseStr = "Delete document {" + id + "} Fail!";
		}

		return ResponseEntity.ok().body(responseStr);
	}

}
