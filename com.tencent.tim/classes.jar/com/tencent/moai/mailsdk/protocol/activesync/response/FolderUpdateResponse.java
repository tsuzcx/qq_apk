package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.FolderUpdateStatus;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import org.w3c.dom.Node;

public class FolderUpdateResponse
  extends ActiveSyncResponse
{
  private CommonStatus commonStatus;
  private FolderUpdateStatus folderUpdateStatus;
  private String syncKey;
  
  public FolderUpdateResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    super(paramString1, paramString2, paramHttpResponse);
  }
  
  public CommonStatus getCommonStatus()
  {
    return this.commonStatus;
  }
  
  public int getErrorCode()
  {
    if (this.folderUpdateStatus != null) {
      return this.folderUpdateStatus.getStatus();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatus();
    }
    return super.getErrorCode();
  }
  
  public String getErrorMsg()
  {
    if (this.folderUpdateStatus != null) {
      return this.folderUpdateStatus.getStatusMsg();
    }
    if (this.commonStatus != null) {
      return this.commonStatus.getStatusMsg();
    }
    return super.getErrorMsg();
  }
  
  public FolderUpdateStatus getFolderUpdateStatus()
  {
    return this.folderUpdateStatus;
  }
  
  public String getSyncKey()
  {
    return this.syncKey;
  }
  
  public boolean isOk()
  {
    if (this.folderUpdateStatus != null) {
      return this.folderUpdateStatus.isStatusOk();
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
            localObject = XmlDocumentHelper.getChildNode((Node)localObject, "FolderUpdate");
          } while (localObject == null);
          i = XmlDocumentHelper.getChildIntContent((Node)localObject, "Status");
          this.commonStatus = new CommonStatus(i);
        } while (!this.commonStatus.isStatusOk());
        this.folderUpdateStatus = new FolderUpdateStatus(i);
      } while (!this.folderUpdateStatus.isStatusOk());
      this.syncKey = XmlDocumentHelper.getChildText((Node)localObject, "SyncKey");
    } while (this.syncKey == null);
    return true;
  }
  
  public void setCommonStatus(CommonStatus paramCommonStatus)
  {
    this.commonStatus = paramCommonStatus;
  }
  
  public void setFolderUpdateStatus(FolderUpdateStatus paramFolderUpdateStatus)
  {
    this.folderUpdateStatus = paramFolderUpdateStatus;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.FolderUpdateResponse
 * JD-Core Version:    0.7.0.1
 */