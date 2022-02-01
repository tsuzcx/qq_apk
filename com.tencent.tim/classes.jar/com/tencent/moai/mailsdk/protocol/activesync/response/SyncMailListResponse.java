package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.ActiveSyncMailParser;
import com.tencent.moai.mailsdk.protocol.activesync.Status.SyncStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SyncMailListResponse
  extends ActiveSyncResponse
{
  private ArrayList<Mail> addMailList = new ArrayList();
  private String collectionId;
  private ArrayList<Mail> deleteMailList = new ArrayList();
  private ArrayList<String> flagList = new ArrayList();
  private boolean moreAvailable;
  private ArrayList<String> readList = new ArrayList();
  private String syncKey;
  private SyncStatus syncStatus;
  private ArrayList<String> unFlagList = new ArrayList();
  private ArrayList<String> unreadList = new ArrayList();
  
  public SyncMailListResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  private void parseChangeData(Node paramNode)
  {
    String str = XmlDocumentHelper.getChildText(paramNode, "ServerId");
    paramNode = XmlDocumentHelper.getChildNode(paramNode, "ApplicationData");
    Node localNode = XmlDocumentHelper.getChildNode(paramNode, "email:Flag");
    int i;
    if (localNode != null)
    {
      i = XmlDocumentHelper.getChildIntContent(localNode, "email:Status");
      if (i != 1) {
        break label75;
      }
    }
    label75:
    do
    {
      this.unFlagList.add(str);
      for (;;)
      {
        paramNode = XmlDocumentHelper.getChildText(paramNode, "email:Read");
        if (!"0".equals(paramNode)) {
          break;
        }
        this.unreadList.add(str);
        return;
        if (i == 2) {
          this.flagList.add(str);
        }
      }
    } while (!"1".equals(paramNode));
    this.readList.add(str);
  }
  
  public ArrayList<Mail> getAddMailList()
  {
    return this.addMailList;
  }
  
  public String getCollectionId()
  {
    return this.collectionId;
  }
  
  public ArrayList<Mail> getDeleteMailList()
  {
    return this.deleteMailList;
  }
  
  public int getErrorCode()
  {
    if (this.syncStatus != null) {
      return this.syncStatus.getStatus();
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.syncStatus != null) {
      return this.syncStatus.getStatusMsg();
    }
    return super.getErrorMsg();
  }
  
  public ArrayList<String> getFlagList()
  {
    return this.flagList;
  }
  
  public ArrayList<String> getReadList()
  {
    return this.readList;
  }
  
  public String getSyncKey()
  {
    return this.syncKey;
  }
  
  public SyncStatus getSyncStatus()
  {
    return this.syncStatus;
  }
  
  public ArrayList<String> getUnFlagList()
  {
    return this.unFlagList;
  }
  
  public ArrayList<String> getUnreadList()
  {
    return this.unreadList;
  }
  
  public boolean isMoreAvailable()
  {
    return this.moreAvailable;
  }
  
  public boolean isOk()
  {
    if (this.syncStatus != null) {
      return this.syncStatus.isStatusOk();
    }
    return super.isOk();
  }
  
  public boolean parseResponse()
  {
    int j = 0;
    if (this.httpResponse == null) {
      return false;
    }
    if (!this.httpResponse.isOk()) {
      return false;
    }
    if (this.httpResponse.getContent() == null) {
      return true;
    }
    if (this.httpResponse.getContent().length == 0) {
      return true;
    }
    Object localObject1 = XmlDocumentHelper.bytes2XmlDoc(this.httpResponse.getContent());
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = XmlDocumentHelper.getChildNode((Node)localObject1, "Sync");
    if (localObject2 == null) {
      return false;
    }
    localObject2 = XmlDocumentHelper.getChildNode((Node)localObject2, "Collections");
    if (localObject2 == null) {
      return false;
    }
    localObject2 = XmlDocumentHelper.getChildNodes((Node)localObject2, "Collection");
    if (localObject2 == null) {
      return false;
    }
    localObject2 = (Node)((ArrayList)localObject2).get(0);
    if (localObject2 == null) {
      return false;
    }
    this.syncStatus = new SyncStatus(XmlDocumentHelper.getChildIntContent((Node)localObject2, "Status"));
    if (!this.syncStatus.isStatusOk()) {
      return true;
    }
    this.collectionId = XmlDocumentHelper.getChildText((Node)localObject2, "CollectionId");
    if (this.collectionId == null) {
      return false;
    }
    this.syncKey = XmlDocumentHelper.getChildText((Node)localObject2, "SyncKey");
    if (this.syncKey == null) {
      return false;
    }
    this.moreAvailable = XmlDocumentHelper.isNodeExist((Document)localObject1, "MoreAvailable");
    localObject2 = ((Document)localObject1).getElementsByTagName("Add");
    int k = ((NodeList)localObject2).getLength();
    int i = 0;
    Object localObject3;
    String str;
    while (i < k)
    {
      localObject3 = ((NodeList)localObject2).item(i);
      str = XmlDocumentHelper.getChildText((Node)localObject3, "ServerId");
      localObject3 = ActiveSyncMailParser.getMail(XmlDocumentHelper.getChildNode((Node)localObject3, "ApplicationData"));
      ((Mail)localObject3).setRemoteId(str);
      ((Mail)localObject3).setIsNew(true);
      this.addMailList.add(localObject3);
      i += 1;
    }
    localObject2 = ((Document)localObject1).getElementsByTagName("Delete");
    k = ((NodeList)localObject2).getLength();
    i = 0;
    while (i < k)
    {
      localObject3 = ((NodeList)localObject2).item(i);
      str = XmlDocumentHelper.getChildText((Node)localObject3, "ServerId");
      localObject3 = ActiveSyncMailParser.getMail(XmlDocumentHelper.getChildNode((Node)localObject3, "ApplicationData"));
      ((Mail)localObject3).setRemoteId(str);
      this.deleteMailList.add(localObject3);
      i += 1;
    }
    localObject2 = ((Document)localObject1).getElementsByTagName("SoftDelete");
    k = ((NodeList)localObject2).getLength();
    i = 0;
    while (i < k)
    {
      localObject3 = ((NodeList)localObject2).item(i);
      str = XmlDocumentHelper.getChildText((Node)localObject3, "ServerId");
      localObject3 = ActiveSyncMailParser.getMail(XmlDocumentHelper.getChildNode((Node)localObject3, "ApplicationData"));
      ((Mail)localObject3).setRemoteId(str);
      this.deleteMailList.add(localObject3);
      i += 1;
    }
    localObject1 = ((Document)localObject1).getElementsByTagName("Change");
    k = ((NodeList)localObject1).getLength();
    i = j;
    while (i < k)
    {
      parseChangeData(((NodeList)localObject1).item(i));
      i += 1;
    }
    return true;
  }
  
  public void setAddMailList(ArrayList<Mail> paramArrayList)
  {
    this.addMailList = paramArrayList;
  }
  
  public void setCollectionId(String paramString)
  {
    this.collectionId = paramString;
  }
  
  public void setDeleteMailList(ArrayList<Mail> paramArrayList)
  {
    this.deleteMailList = paramArrayList;
  }
  
  public void setFlagList(ArrayList<String> paramArrayList)
  {
    this.flagList = paramArrayList;
  }
  
  public void setMoreAvailable(boolean paramBoolean)
  {
    this.moreAvailable = paramBoolean;
  }
  
  public void setReadList(ArrayList<String> paramArrayList)
  {
    this.readList = paramArrayList;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
  
  public void setSyncStatus(SyncStatus paramSyncStatus)
  {
    this.syncStatus = paramSyncStatus;
  }
  
  public void setUnFlagList(ArrayList<String> paramArrayList)
  {
    this.unFlagList = paramArrayList;
  }
  
  public void setUnreadList(ArrayList<String> paramArrayList)
  {
    this.unreadList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailListResponse
 * JD-Core Version:    0.7.0.1
 */