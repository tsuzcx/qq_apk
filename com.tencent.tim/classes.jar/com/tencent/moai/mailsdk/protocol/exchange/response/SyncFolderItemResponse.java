package com.tencent.moai.mailsdk.protocol.exchange.response;

import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.exchange.ExchangeXmlParser;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeItem;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;

public class SyncFolderItemResponse
  extends ExchangeResponse
{
  private ArrayList<Mail> addMailList = new ArrayList();
  private ArrayList<Mail> changeMailList = new ArrayList();
  private ArrayList<Mail> deleteMailList = new ArrayList();
  private boolean includesLastItemInRange = true;
  private String syncState;
  private ArrayList<Mail> updateMailList = new ArrayList();
  
  public SyncFolderItemResponse(String paramString, HttpResponse paramHttpResponse)
  {
    super(paramString, paramHttpResponse);
  }
  
  public ArrayList<Mail> getAddMailList()
  {
    return this.addMailList;
  }
  
  public ArrayList<Mail> getChangeMailList()
  {
    return this.changeMailList;
  }
  
  public ArrayList<Mail> getDeleteMailList()
  {
    return this.deleteMailList;
  }
  
  public String getSyncState()
  {
    return this.syncState;
  }
  
  public ArrayList<Mail> getUpdateMailList()
  {
    return this.updateMailList;
  }
  
  public boolean isIncludesLastItemInRange()
  {
    return this.includesLastItemInRange;
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
          localObject2 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "SyncFolderItemsResponse");
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
        localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "SyncFolderItemsResponseMessage");
      } while (localObject1 == null);
      this.responseCode = XmlDocumentHelper.getChildTextByLocalName((Node)localObject1, "ResponseCode");
    } while ((this.responseCode == null) || (!"NoError".equalsIgnoreCase(this.responseCode)));
    this.includesLastItemInRange = "true".equalsIgnoreCase(XmlDocumentHelper.getChildText((Node)localObject1, "m:IncludesLastItemInRange"));
    Object localObject2 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "SyncState");
    if (localObject2 != null) {
      this.syncState = ((Node)localObject2).getTextContent();
    }
    Object localObject1 = XmlDocumentHelper.getChildNodeByLocalName((Node)localObject1, "Changes");
    localObject2 = XmlDocumentHelper.getChildNodesByLocalName((Node)localObject1, "Create");
    Node localNode;
    ExchangeItem localExchangeItem;
    Mail localMail;
    if (localObject2 != null)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localNode = XmlDocumentHelper.getChildNodeByLocalName((Node)((Iterator)localObject2).next(), "Message");
        if (localNode != null)
        {
          localExchangeItem = ExchangeXmlParser.getItemId(localNode);
          if (localExchangeItem != null)
          {
            localMail = new Mail();
            localMail.setRemoteId(localExchangeItem.getId());
            localMail.setSvrKey(localExchangeItem.getChangeKey());
            localMail.setUtc(ExchangeXmlParser.getDateTimeSent(localNode));
            this.addMailList.add(localMail);
          }
        }
      }
    }
    localObject2 = XmlDocumentHelper.getChildNodesByLocalName((Node)localObject1, "Update");
    if (localObject2 != null)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localNode = XmlDocumentHelper.getChildNodeByLocalName((Node)((Iterator)localObject2).next(), "Message");
        if (localNode != null)
        {
          localExchangeItem = ExchangeXmlParser.getItemId(localNode);
          if (localExchangeItem != null)
          {
            localMail = new Mail();
            localMail.setRemoteId(localExchangeItem.getId());
            localMail.setSvrKey(localExchangeItem.getChangeKey());
            localMail.setUtc(ExchangeXmlParser.getDateTimeSent(localNode));
            this.updateMailList.add(localMail);
          }
        }
      }
    }
    localObject2 = XmlDocumentHelper.getChildNodesByLocalName((Node)localObject1, "Delete");
    if (localObject2 != null)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localNode = (Node)((Iterator)localObject2).next();
        localExchangeItem = ExchangeXmlParser.getItemId(localNode);
        if (localExchangeItem != null)
        {
          localMail = new Mail();
          localMail.setRemoteId(localExchangeItem.getId());
          localMail.setSvrKey(localExchangeItem.getChangeKey());
          localMail.setUtc(ExchangeXmlParser.getDateTimeSent(localNode));
          this.deleteMailList.add(localMail);
        }
      }
    }
    localObject1 = XmlDocumentHelper.getChildNodesByLocalName((Node)localObject1, "ReadFlagChange");
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localNode = (Node)((Iterator)localObject1).next();
        localExchangeItem = ExchangeXmlParser.getItemId(localNode);
        if (localExchangeItem != null)
        {
          localObject2 = new Mail();
          ((Mail)localObject2).setRemoteId(localExchangeItem.getId());
          ((Mail)localObject2).setSvrKey(localExchangeItem.getChangeKey());
          localNode = XmlDocumentHelper.getChildNodeByLocalName(localNode, "IsRead");
          if ((localNode != null) && ("true".equalsIgnoreCase(localNode.getTextContent()))) {}
          for (boolean bool = true;; bool = false)
          {
            ((Mail)localObject2).setIsRead(bool);
            this.changeMailList.add(localObject2);
            break;
          }
        }
      }
    }
    return true;
  }
  
  public void setAddMailList(ArrayList<Mail> paramArrayList)
  {
    this.addMailList = paramArrayList;
  }
  
  public void setChangeMailList(ArrayList<Mail> paramArrayList)
  {
    this.changeMailList = paramArrayList;
  }
  
  public void setDeleteMailList(ArrayList<Mail> paramArrayList)
  {
    this.deleteMailList = paramArrayList;
  }
  
  public void setIncludesLastItemInRange(boolean paramBoolean)
  {
    this.includesLastItemInRange = paramBoolean;
  }
  
  public void setSyncState(String paramString)
  {
    this.syncState = paramString;
  }
  
  public void setUpdateMailList(ArrayList<Mail> paramArrayList)
  {
    this.updateMailList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.response.SyncFolderItemResponse
 * JD-Core Version:    0.7.0.1
 */