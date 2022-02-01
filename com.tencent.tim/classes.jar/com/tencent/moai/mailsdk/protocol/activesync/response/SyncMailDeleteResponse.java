package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.SyncStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;

public class SyncMailDeleteResponse
  extends ActiveSyncResponse
{
  private CommonStatus commonStatus;
  private String syncKey;
  private SyncStatus syncStatus;
  private ArrayList<SyncStatus> syncStatuses = new ArrayList();
  
  public SyncMailDeleteResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  public CommonStatus getCommonStatus()
  {
    return this.commonStatus;
  }
  
  public int getErrorCode()
  {
    if (this.syncStatuses.size() > 0)
    {
      Iterator localIterator = this.syncStatuses.iterator();
      while (localIterator.hasNext())
      {
        SyncStatus localSyncStatus = (SyncStatus)localIterator.next();
        if (!localSyncStatus.isStatusOk()) {
          return localSyncStatus.getStatus();
        }
      }
    }
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
    if (this.syncStatuses.size() > 0)
    {
      Iterator localIterator = this.syncStatuses.iterator();
      while (localIterator.hasNext())
      {
        SyncStatus localSyncStatus = (SyncStatus)localIterator.next();
        if (!localSyncStatus.isStatusOk()) {
          return localSyncStatus.getStatusMsg();
        }
      }
    }
    if (this.syncStatus != null) {
      return this.syncStatus.getStatusMsg();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatusMsg();
    }
    return super.getErrorMsg();
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
    if (this.syncStatuses.size() > 0)
    {
      Iterator localIterator = this.syncStatuses.iterator();
      while (localIterator.hasNext()) {
        if (!((SyncStatus)localIterator.next()).isStatusOk()) {
          return false;
        }
      }
    }
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
    localObject1 = XmlDocumentHelper.getChildNodes((Node)localObject1, "Delete");
    if (localObject1 == null) {
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Node)((Iterator)localObject1).next();
      if (XmlDocumentHelper.getChildText((Node)localObject2, "ServerId") == null) {
        return false;
      }
      localObject2 = new SyncStatus(XmlDocumentHelper.getChildIntContent((Node)localObject2, "Status"));
      this.syncStatuses.add(localObject2);
      if (!((SyncStatus)localObject2).isStatusOk()) {
        return false;
      }
    }
    return true;
  }
  
  public void setCommonStatus(CommonStatus paramCommonStatus)
  {
    this.commonStatus = paramCommonStatus;
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
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailDeleteResponse
 * JD-Core Version:    0.7.0.1
 */