package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.FolderCreateStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import org.w3c.dom.Node;

public class FolderCreateResponse
  extends ActiveSyncResponse
{
  private CommonStatus commonStatus;
  private FolderCreateStatus folderCreateStatus;
  private String serverId;
  private String syncKey;
  
  public FolderCreateResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  public CommonStatus getCommonStatus()
  {
    return this.commonStatus;
  }
  
  public int getErrorCode()
  {
    if (this.folderCreateStatus != null) {
      return this.folderCreateStatus.getStatus();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatus();
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.folderCreateStatus != null) {
      return this.folderCreateStatus.getStatusMsg();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatusMsg();
    }
    return super.getErrorMsg();
  }
  
  public FolderCreateStatus getFolderCreateStatus()
  {
    return this.folderCreateStatus;
  }
  
  public String getServerId()
  {
    return this.serverId;
  }
  
  public String getSyncKey()
  {
    return this.syncKey;
  }
  
  public boolean isOk()
  {
    if (this.folderCreateStatus != null) {
      return this.folderCreateStatus.isStatusOk();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.isStatusOk();
    }
    return super.isOk();
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
          int i;
          do
          {
            do
            {
              do
              {
                do
                {
                  return false;
                } while (!this.httpResponse.isOk());
                if (this.httpResponse.getContent() == null) {
                  return true;
                }
                if (this.httpResponse.getContent().length == 0) {
                  return true;
                }
                localObject = XmlDocumentHelper.bytes2XmlDoc(this.httpResponse.getContent());
              } while (localObject == null);
              localObject = XmlDocumentHelper.getChildNode((Node)localObject, "FolderCreate");
            } while (localObject == null);
            i = XmlDocumentHelper.getChildIntContent((Node)localObject, "Status");
            this.commonStatus = new CommonStatus(i);
          } while (!this.commonStatus.isStatusOk());
          this.folderCreateStatus = new FolderCreateStatus(i);
        } while (!this.folderCreateStatus.isStatusOk());
        this.syncKey = XmlDocumentHelper.getChildText((Node)localObject, "SyncKey");
      } while (this.syncKey == null);
      this.serverId = XmlDocumentHelper.getChildText((Node)localObject, "ServerId");
    } while (this.serverId == null);
    return true;
  }
  
  public void setCommonStatus(CommonStatus paramCommonStatus)
  {
    this.commonStatus = paramCommonStatus;
  }
  
  public void setFolderCreateStatus(FolderCreateStatus paramFolderCreateStatus)
  {
    this.folderCreateStatus = paramFolderCreateStatus;
  }
  
  public void setServerId(String paramString)
  {
    this.serverId = paramString;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.FolderCreateResponse
 * JD-Core Version:    0.7.0.1
 */