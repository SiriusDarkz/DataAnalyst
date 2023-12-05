package org.eugenio.documents;

public  sealed interface IDocumentType permits DOCX, TXT, PDF, UnSupportedIDocument {

}
