package com.tencent.moai.mailsdk.protocol.exchange.response;

import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.exchange.ExchangeXmlParser;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeItem;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class FindItemResponse
  extends ExchangeResponse
{
  private ArrayList<Mail> mailArrayList = new ArrayList();
  private int totalCnt = 0;
  
  public FindItemResponse(String paramString, HttpResponse paramHttpResponse)
  {
    super(paramString, paramHttpResponse);
  }
  
  public ArrayList<Mail> getMailArrayList()
  {
    return this.mailArrayList;
  }
  
  public int getTotalCnt()
  {
    return this.totalCnt;
  }
  
  public boolean parseResponse()
  {
    if (this.httpResponse == null) {}
    for (;;)
    {
      return false;
      if (this.httpResponse.getContent() == null) {
        continue;
      }
      Object localObject1 = XmlDocumentHelper.bytesToXmlDoc(this.httpResponse.getContent());
      if (localObject1 == null) {
        continue;
      }
      localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "Envelope");
      if (localObject1 == null) {
        continue;
      }
      localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "Body");
      if (localObject1 == null) {
        continue;
      }
      Object localObject2 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "FindItemResponse");
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
      if (localObject1 == null) {
        continue;
      }
      localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "FindItemResponseMessage");
      if (localObject1 == null) {
        continue;
      }
      this.responseCode = XmlDocumentHelper.getChildTextByLocalName((Node)localObject1, "ResponseCode");
      if ((this.responseCode == null) || (!"NoError".equalsIgnoreCase(this.responseCode))) {
        continue;
      }
      localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "RootFolder");
      if (localObject1 == null) {
        continue;
      }
      localObject2 = ((Node)localObject1).getAttributes();
      if (localObject2 != null) {
        localObject2 = ((NamedNodeMap)localObject2).getNamedItem("TotalItemsInView");
      }
      try
      {
        this.totalCnt = Integer.valueOf(((Node)localObject2).getNodeValue()).intValue();
        label209:
        localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "Items");
        if (localObject1 == null) {
          continue;
        }
        localObject1 = XmlDocumentHelper.getChildNodesByLocalName((Node)localObject1, "Message");
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Node)((Iterator)localObject1).next();
          ExchangeItem localExchangeItem = ExchangeXmlParser.getItemId((Node)localObject2);
          if (localExchangeItem != null)
          {
            Mail localMail = new Mail();
            localMail.setRemoteId(localExchangeItem.getId());
            localMail.setSvrKey(localExchangeItem.getChangeKey());
            localMail.setUtc(ExchangeXmlParser.getDateTimeSent((Node)localObject2));
            this.mailArrayList.add(localMail);
          }
        }
        return true;
      }
      catch (Exception localException)
      {
        break label209;
      }
    }
  }
  
  public void setMailArrayList(ArrayList<Mail> paramArrayList)
  {
    this.mailArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.response.FindItemResponse
 * JD-Core Version:    0.7.0.1
 */