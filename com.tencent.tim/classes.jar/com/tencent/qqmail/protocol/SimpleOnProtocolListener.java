package com.tencent.qqmail.protocol;

import java.util.HashMap;

public class SimpleOnProtocolListener
  implements OnProtocolListener
{
  public void OnCloudProtocolLogin(GeneralResult paramGeneralResult) {}
  
  public boolean onAbortRequest()
  {
    return false;
  }
  
  public void onBeforeSendMail(Mail paramMail) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult) {}
  
  public void onDownload(Mail paramMail, ProtocolResult paramProtocolResult) {}
  
  public boolean onDownloadProgress(Mail paramMail, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    return false;
  }
  
  public void onDownloadText(Mail paramMail, ProtocolResult paramProtocolResult) {}
  
  public boolean onDownloadTextProgress(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    return false;
  }
  
  public void onExchangeSyncFolderFinished(int paramInt, String paramString, ProtocolResult paramProtocolResult) {}
  
  public void onExchangeSyncFolderReadStatusFinished(int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4, ProtocolResult paramProtocolResult) {}
  
  public void onFetchImapCrawledContact(String paramString1, String paramString2) {}
  
  public void onFetchImapCrawledContactComplete() {}
  
  public void onGetAvatar(int paramInt, String paramString) {}
  
  public Exchange.ActiveSyncMobileInfo onGetMobileInfo()
  {
    return null;
  }
  
  public void onLogin(ProtocolResult paramProtocolResult) {}
  
  public void onParseMailAttachmentFromEml(Mail paramMail, ProtocolResult paramProtocolResult) {}
  
  public void onParseMailContentFromEml(Mail paramMail, ProtocolResult paramProtocolResult) {}
  
  public void onParseMailHeaderFromEml(Mail paramMail, ProtocolResult paramProtocolResult) {}
  
  public void onProtocolReceiveMail(Mail paramMail, String paramString, ProtocolResult paramProtocolResult) {}
  
  public void onProtocolReceiveMailList(Mail[] paramArrayOfMail, String paramString, ProtocolResult paramProtocolResult) {}
  
  public void onReceiving(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onResult(ProtocolResult paramProtocolResult) {}
  
  public void onRetrieveFolders(Mail.Folder[] paramArrayOfFolder1, Mail.Folder[] paramArrayOfFolder2, Mail.Folder[] paramArrayOfFolder3, ProtocolResult paramProtocolResult, int paramInt) {}
  
  public void onRetrieveMail(Mail paramMail, ProtocolResult paramProtocolResult) {}
  
  public void onRetrieveMailComplete(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, ProtocolResult paramProtocolResult) {}
  
  public void onRetrieveMails(Mail[] paramArrayOfMail, String paramString, ProtocolResult paramProtocolResult) {}
  
  public void onSearchMail(Mail paramMail, ProtocolResult paramProtocolResult) {}
  
  public void onSearchMailComplete(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, ProtocolResult paramProtocolResult) {}
  
  public void onSendMail(Mail paramMail, ProtocolResult paramProtocolResult) {}
  
  public boolean onSendMailProgress(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void onSyncFinished() {}
  
  public void onSyncKey(int paramInt, String paramString) {}
  
  public void onUpdateComplete(HashMap<String, Mail[]> paramHashMap, ProtocolResult paramProtocolResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.SimpleOnProtocolListener
 * JD-Core Version:    0.7.0.1
 */