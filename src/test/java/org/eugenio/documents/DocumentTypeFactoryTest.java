package org.eugenio.documents;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentTypeFactoryTest {

    @Test
    void shouldReturnDOCX() {
       IDocumentType documentType =  DocumentTypeFactory.createDocumentType("DOCX",null,null);
       assertTrue(documentType instanceof DOCX);
    }

    @Test
    void shouldReturnDOCXFalse() {
        IDocumentType documentType =  DocumentTypeFactory.createDocumentType("DOCX",null,null);
        assertFalse(documentType instanceof PDF);
    }

    @Test
    void shouldReturnPDF() {
        IDocumentType documentType =  DocumentTypeFactory.createDocumentType("PDF",null,null);
        assertTrue(documentType instanceof PDF);
    }

    @Test
    void shouldReturnPDFFalse() {
        IDocumentType documentType =  DocumentTypeFactory.createDocumentType("PDF",null,null);
        assertFalse(documentType instanceof TXT);
    }

    @Test
    void shouldReturnTXT() {
        IDocumentType documentType =  DocumentTypeFactory.createDocumentType("TXT",null,null);
        assertTrue(documentType instanceof TXT);
    }

    @Test
    void shouldReturnTXTFalse() {
        IDocumentType documentType =  DocumentTypeFactory.createDocumentType("TXT",null,null);
        assertFalse(documentType instanceof PDF);
    }

    @Test
    void shouldReturnUnSupportedDocument() {
        IDocumentType documentType =  DocumentTypeFactory.createDocumentType("CSV",null,null);
        assertTrue(documentType instanceof UnSupportedIDocument);
    }

}
