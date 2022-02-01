package com.tencent.moai.mailsdk.protocol.exchange.response;

import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.exchange.ExchangeXmlParser;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;

public class GetItemResponse
  extends ExchangeResponse
{
  private ArrayList<Mail> mailArrayList = new ArrayList();
  
  public GetItemResponse(String paramString, HttpResponse paramHttpResponse)
  {
    super(paramString, paramHttpResponse);
  }
  
  public ArrayList<Mail> getMailArrayList()
  {
    return this.mailArrayList;
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {}
    Node localNode;
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
        localNode = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject, "GetItemResponse");
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
      localObject = XmlDocumentHelper.getChildNodesByLocalName((Node)localObject, "GetItemResponseMessage");
    } while ((localObject == null) || (((ArrayList)localObject).size() <= 0));
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localNode = (Node)((Iterator)localObject).next();
      this.responseCode = XmlDocumentHelper.getChildTextByLocalName(localNode, "ResponseCode");
      if ((this.responseCode != null) && ("NoError".equalsIgnoreCase(this.responseCode)))
      {
        localNode = XmlDocumentHelper.getChildNodeByLocalName(localNode, "Items");
        if (localNode != null)
        {
          localNode = XmlDocumentHelper.getChildNodeByLocalName(localNode, "Message");
          if (localNode != null) {
            this.mailArrayList.add(ExchangeXmlParser.getMail(localNode));
          }
        }
      }
    }
    return true;
  }
  
  public void setMailArrayList(ArrayList<Mail> paramArrayList)
  {
    this.mailArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.response.GetItemResponse
 * JD-Core Version:    0.7.0.1
 */