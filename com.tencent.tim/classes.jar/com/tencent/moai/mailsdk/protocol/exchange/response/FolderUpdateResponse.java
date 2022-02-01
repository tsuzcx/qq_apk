package com.tencent.moai.mailsdk.protocol.exchange.response;

import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.exchange.ExchangeXmlParser;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import org.w3c.dom.Node;

public class FolderUpdateResponse
  extends ExchangeResponse
{
  private Folder folder;
  
  public FolderUpdateResponse(String paramString, HttpResponse paramHttpResponse)
  {
    super(paramString, paramHttpResponse);
  }
  
  public Folder getFolder()
  {
    return this.folder;
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return false;
                  } while (this.httpResponse.getContent() == null);
                  localObject = XmlDocumentHelper.bytesToXmlDoc(this.httpResponse.getContent());
                } while (localObject == null);
                localObject = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "Envelope");
              } while (localObject == null);
              localObject = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "Body");
            } while (localObject == null);
            Node localNode = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "UpdateFolderResponse");
            if (localNode == null)
            {
              localObject = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "Fault");
              this.responseCode = XmlDocumentHelper.getChildTextByLocalName(XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "detail"), "ResponseCode");
              localObject = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "faultstring");
              if (localObject != null)
              {
                ((Node)localObject).getTextContent();
                return false;
              }
              return false;
            }
            localObject = XmlDocumentHelper.getChildNodeByLocalName(localNode, "ResponseMessages");
          } while (localObject == null);
          localObject = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "UpdateFolderResponseMessage");
        } while (localObject == null);
        this.responseCode = XmlDocumentHelper.getChildTextByLocalName((Node)localObject, "ResponseCode");
      } while ((this.responseCode == null) || (!"NoError".equalsIgnoreCase(this.responseCode)));
      localObject = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "Folders");
    } while (localObject == null);
    this.folder = ExchangeXmlParser.getFolder(XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "Folder"));
    return true;
  }
  
  public void setFolder(Folder paramFolder)
  {
    this.folder = paramFolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.response.FolderUpdateResponse
 * JD-Core Version:    0.7.0.1
 */