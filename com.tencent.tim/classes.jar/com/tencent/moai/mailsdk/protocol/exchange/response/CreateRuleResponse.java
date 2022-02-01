package com.tencent.moai.mailsdk.protocol.exchange.response;

import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import org.w3c.dom.Node;

public class CreateRuleResponse
  extends ExchangeResponse
{
  public CreateRuleResponse(String paramString, HttpResponse paramHttpResponse)
  {
    super(paramString, paramHttpResponse);
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {}
    do
    {
      Object localObject;
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
      Node localNode = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "UpdateInboxRulesResponse");
      if (localNode == null)
      {
        localObject = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "Fault");
        this.responseCode = XmlDocumentHelper.getChildText(XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "detail"), "e:ResponseCode");
        localObject = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "faultstring");
        if (localObject != null)
        {
          ((Node)localObject).getTextContent();
          return false;
        }
        return false;
      }
      this.responseCode = XmlDocumentHelper.getChildTextByLocalName(localNode, "ResponseCode");
    } while ((this.responseCode == null) || (!"NoError".equalsIgnoreCase(this.responseCode)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.response.CreateRuleResponse
 * JD-Core Version:    0.7.0.1
 */