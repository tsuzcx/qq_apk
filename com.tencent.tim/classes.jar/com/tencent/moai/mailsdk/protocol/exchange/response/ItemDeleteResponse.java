package com.tencent.moai.mailsdk.protocol.exchange.response;

import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;

public class ItemDeleteResponse
  extends ExchangeResponse
{
  public ItemDeleteResponse(String paramString, HttpResponse paramHttpResponse)
  {
    super(paramString, paramHttpResponse);
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {}
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
        Node localNode = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "DeleteItemResponse");
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
      localObject = XmlDocumentHelper.getChildNodesByLocalName((Node)localObject, "DeleteItemResponseMessage");
    } while (localObject == null);
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      this.responseCode = XmlDocumentHelper.getChildTextByLocalName((Node)((Iterator)localObject).next(), "ResponseCode");
      if ((this.responseCode == null) || ("NoError".equalsIgnoreCase(this.responseCode))) {}
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.response.ItemDeleteResponse
 * JD-Core Version:    0.7.0.1
 */