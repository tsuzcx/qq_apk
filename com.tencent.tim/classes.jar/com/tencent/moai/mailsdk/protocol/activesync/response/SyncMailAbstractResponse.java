package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.ActiveSyncMailParser;
import com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.SyncStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;

public class SyncMailAbstractResponse
  extends ActiveSyncResponse
{
  private CommonStatus commonStatus;
  private ArrayList<Mail> mailList = new ArrayList();
  private String syncKey;
  private SyncStatus syncStatus;
  
  public SyncMailAbstractResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  public CommonStatus getCommonStatus()
  {
    return this.commonStatus;
  }
  
  public int getErrorCode()
  {
    if (this.syncStatus != null) {
      return this.syncStatus.getStatus();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatus();
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.syncStatus != null) {
      return this.syncStatus.getStatusMsg();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatusMsg();
    }
    return super.getErrorMsg();
  }
  
  public ArrayList<Mail> getMailList()
  {
    return this.mailList;
  }
  
  public String getSyncKey()
  {
    return this.syncKey;
  }
  
  public SyncStatus getSyncStatus()
  {
    return this.syncStatus;
  }
  
  public boolean isOk()
  {
    if (this.syncStatus != null) {
      return this.syncStatus.isStatusOk();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.isStatusOk();
    }
    return super.isOk();
  }
  
  public boolean parseResponse()
  {
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
    localObject1 = XmlDocumentHelper.getChildNode((Node)localObject1, "Sync");
    if (localObject1 == null) {
      return false;
    }
    this.commonStatus = new CommonStatus(XmlDocumentHelper.getChildIntContent((Node)localObject1, "Status"));
    if (!this.commonStatus.isStatusOk()) {
      return false;
    }
    localObject1 = XmlDocumentHelper.getChildNode((Node)localObject1, "Collections");
    if (localObject1 == null) {
      return false;
    }
    localObject1 = XmlDocumentHelper.getChildNodes((Node)localObject1, "Collection");
    if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)) {
      return false;
    }
    localObject1 = (Node)((ArrayList)localObject1).get(0);
    this.syncStatus = new SyncStatus(XmlDocumentHelper.getChildIntContent((Node)localObject1, "Status"));
    if (!this.syncStatus.isStatusOk()) {
      return false;
    }
    this.syncKey = XmlDocumentHelper.getChildText((Node)localObject1, "SyncKey");
    if (this.syncKey == null) {
      return false;
    }
    localObject1 = XmlDocumentHelper.getChildNode((Node)localObject1, "Responses");
    if (localObject1 == null) {
      return false;
    }
    localObject1 = XmlDocumentHelper.getChildNodes((Node)localObject1, "Fetch");
    if (localObject1 == null) {
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Node)((Iterator)localObject1).next();
      String str = XmlDocumentHelper.getChildText((Node)localObject2, "ServerId");
      localObject2 = XmlDocumentHelper.getChildNode((Node)localObject2, "ApplicationData");
      if ((str != null) && (localObject2 != null))
      {
        localObject2 = ActiveSyncMailParser.getMail((Node)localObject2);
        ((Mail)localObject2).setRemoteId(str);
        this.mailList.add(localObject2);
      }
    }
    return true;
  }
  
  public void setCommonStatus(CommonStatus paramCommonStatus)
  {
    this.commonStatus = paramCommonStatus;
  }
  
  public void setMailList(ArrayList<Mail> paramArrayList)
  {
    this.mailList = paramArrayList;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
  
  public void setSyncStatus(SyncStatus paramSyncStatus)
  {
    this.syncStatus = paramSyncStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailAbstractResponse
 * JD-Core Version:    0.7.0.1
 */