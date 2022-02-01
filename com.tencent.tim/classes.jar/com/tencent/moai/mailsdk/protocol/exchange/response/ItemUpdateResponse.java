package com.tencent.moai.mailsdk.protocol.exchange.response;

import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.exchange.ExchangeXmlParser;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeItem;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;

public class ItemUpdateResponse
  extends ExchangeResponse
{
  private ArrayList<Mail> mailArrayList = new ArrayList();
  
  public ItemUpdateResponse(String paramString, HttpResponse paramHttpResponse)
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
    Object localObject2;
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
              localObject1 = XmlDocumentHelper.bytesToXmlDoc(this.httpResponse.getContent());
            } while (localObject1 == null);
            localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "Envelope");
          } while (localObject1 == null);
          localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "Body");
        } while (localObject1 == null);
        localObject2 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "UpdateItemResponse");
        if (localObject2 == null)
        {
          localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "Fault");
          this.responseCode = XmlDocumentHelper.getChildTextByLocalName(XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "detail"), "ResponseCode");
          localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "faultstring");
          if (localObject1 != null)
          {
            ((Node)localObject1).getTextContent();
            return false;
          }
          return false;
        }
        localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject2, "ResponseMessages");
      } while (localObject1 == null);
      localObject1 = XmlDocumentHelper.getChildNodesByLocalName((Node)localObject1, "UpdateItemResponseMessage");
    } while ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0));
    Object localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Node)((Iterator)localObject1).next();
      this.responseCode = XmlDocumentHelper.getChildText((Node)localObject2, "m:ResponseCode");
      if ((this.responseCode != null) && ("NoError".equalsIgnoreCase(this.responseCode)) && (XmlDocumentHelper.getChildNodeByLocalName((Node)localObject2, "Items") != null))
      {
        localObject2 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject2, "Message");
        if (localObject2 != null)
        {
          localObject2 = ExchangeXmlParser.getItemId((Node)localObject2);
          if (localObject2 != null)
          {
            Mail localMail = new Mail();
            localMail.setRemoteId(((ExchangeItem)localObject2).getId());
            localMail.setSvrKey(((ExchangeItem)localObject2).getChangeKey());
            this.mailArrayList.add(localMail);
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
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.response.ItemUpdateResponse
 * JD-Core Version:    0.7.0.1
 */