package com.tencent.qqmail.protocol;

import java.util.HashMap;

public abstract interface OnProtocolListener
{
  public abstract void OnCloudProtocolLogin(GeneralResult paramGeneralResult);
  
  public abstract boolean onAbortRequest();
  
  public abstract void onBeforeSendMail(Mail paramMail);
  
  public abstract void onCloudResult(CloudProtocolResult paramCloudProtocolResult);
  
  public abstract void onDownload(Mail paramMail, ProtocolResult paramProtocolResult);
  
  public abstract boolean onDownloadProgress(Mail paramMail, int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract void onDownloadText(Mail paramMail, ProtocolResult paramProtocolResult);
  
  public abstract boolean onDownloadTextProgress(int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract void onExchangeSyncFolderFinished(int paramInt, String paramString, ProtocolResult paramProtocolResult);
  
  public abstract void onExchangeSyncFolderReadStatusFinished(int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4, ProtocolResult paramProtocolResult);
  
  public abstract void onFetchImapCrawledContact(String paramString1, String paramString2);
  
  public abstract void onFetchImapCrawledContactComplete();
  
  public abstract void onGetAvatar(int paramInt, String paramString);
  
  public abstract Exchange.ActiveSyncMobileInfo onGetMobileInfo();
  
  public abstract void onLogin(ProtocolResult paramProtocolResult);
  
  public abstract void onParseMailAttachmentFromEml(Mail paramMail, ProtocolResult paramProtocolResult);
  
  public abstract void onParseMailContentFromEml(Mail paramMail, ProtocolResult paramProtocolResult);
  
  public abstract void onParseMailHeaderFromEml(Mail paramMail, ProtocolResult paramProtocolResult);
  
  public abstract void onProtocolReceiveMail(Mail paramMail, String paramString, ProtocolResult paramProtocolResult);
  
  public abstract void onProtocolReceiveMailList(Mail[] paramArrayOfMail, String paramString, ProtocolResult paramProtocolResult);
  
  public abstract void onReceiving(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onResult(ProtocolResult paramProtocolResult);
  
  public abstract void onRetrieveFolders(Mail.Folder[] paramArrayOfFolder1, Mail.Folder[] paramArrayOfFolder2, Mail.Folder[] paramArrayOfFolder3, ProtocolResult paramProtocolResult, int paramInt);
  
  public abstract void onRetrieveMail(Mail paramMail, ProtocolResult paramProtocolResult);
  
  public abstract void onRetrieveMailComplete(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, ProtocolResult paramProtocolResult);
  
  public abstract void onRetrieveMails(Mail[] paramArrayOfMail, String paramString, ProtocolResult paramProtocolResult);
  
  public abstract void onSearchMail(Mail paramMail, ProtocolResult paramProtocolResult);
  
  public abstract void onSearchMailComplete(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, ProtocolResult paramProtocolResult);
  
  public abstract void onSendMail(Mail paramMail, ProtocolResult paramProtocolResult);
  
  public abstract boolean onSendMailProgress(int paramInt1, int paramInt2);
  
  public abstract void onSyncFinished();
  
  public abstract void onSyncKey(int paramInt, String paramString);
  
  public abstract void onUpdateComplete(HashMap<String, Mail[]> paramHashMap, ProtocolResult paramProtocolResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.OnProtocolListener
 * JD-Core Version:    0.7.0.1
 */