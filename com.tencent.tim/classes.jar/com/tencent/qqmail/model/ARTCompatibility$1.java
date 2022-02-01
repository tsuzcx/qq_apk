package com.tencent.qqmail.model;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.Exchange.ActiveSyncMobileInfo;
import com.tencent.qqmail.protocol.GeneralResult;
import com.tencent.qqmail.protocol.Mail;
import com.tencent.qqmail.protocol.Mail.Folder;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.ProtocolResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class ARTCompatibility$1
  implements OnProtocolListener
{
  ARTCompatibility$1(OnProtocolListener paramOnProtocolListener) {}
  
  public void OnCloudProtocolLogin(GeneralResult paramGeneralResult)
  {
    this.val$listener.OnCloudProtocolLogin(paramGeneralResult);
  }
  
  public boolean onAbortRequest()
  {
    return this.val$listener.onAbortRequest();
  }
  
  public void onBeforeSendMail(Mail paramMail)
  {
    ARTCompatibility.access$000(paramMail);
    this.val$listener.onBeforeSendMail(paramMail);
  }
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    ARTCompatibility.access$000(paramCloudProtocolResult);
    this.val$listener.onCloudResult(paramCloudProtocolResult);
  }
  
  public void onDownload(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramMail);
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onDownload(paramMail, paramProtocolResult);
  }
  
  public boolean onDownloadProgress(Mail paramMail, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    ARTCompatibility.access$000(paramMail);
    return this.val$listener.onDownloadProgress(paramMail, paramInt, paramString1, paramString2, paramString3);
  }
  
  public void onDownloadText(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramMail);
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onDownloadText(paramMail, paramProtocolResult);
  }
  
  public boolean onDownloadTextProgress(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    return this.val$listener.onDownloadTextProgress(paramInt, paramString1, paramString2, paramString3);
  }
  
  public void onExchangeSyncFolderFinished(int paramInt, String paramString, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onExchangeSyncFolderFinished(paramInt, paramString, paramProtocolResult);
  }
  
  public void onExchangeSyncFolderReadStatusFinished(int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onExchangeSyncFolderReadStatusFinished(paramInt, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3, paramArrayOfString4, paramProtocolResult);
  }
  
  public void onFetchImapCrawledContact(String paramString1, String paramString2)
  {
    this.val$listener.onFetchImapCrawledContact(paramString1, paramString2);
  }
  
  public void onFetchImapCrawledContactComplete()
  {
    this.val$listener.onFetchImapCrawledContactComplete();
  }
  
  public void onGetAvatar(int paramInt, String paramString)
  {
    this.val$listener.onGetAvatar(paramInt, paramString);
  }
  
  public Exchange.ActiveSyncMobileInfo onGetMobileInfo()
  {
    return this.val$listener.onGetMobileInfo();
  }
  
  public void onLogin(ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onLogin(paramProtocolResult);
  }
  
  public void onParseMailAttachmentFromEml(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramMail);
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onParseMailAttachmentFromEml(paramMail, paramProtocolResult);
  }
  
  public void onParseMailContentFromEml(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramMail);
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onParseMailContentFromEml(paramMail, paramProtocolResult);
  }
  
  public void onParseMailHeaderFromEml(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramMail);
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onParseMailAttachmentFromEml(paramMail, paramProtocolResult);
  }
  
  public void onProtocolReceiveMail(Mail paramMail, String paramString, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramMail);
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onProtocolReceiveMail(paramMail, paramString, paramProtocolResult);
  }
  
  public void onProtocolReceiveMailList(Mail[] paramArrayOfMail, String paramString, ProtocolResult paramProtocolResult)
  {
    if (paramArrayOfMail != null)
    {
      int j = paramArrayOfMail.length;
      int i = 0;
      while (i < j)
      {
        ARTCompatibility.access$000(paramArrayOfMail[i]);
        i += 1;
      }
    }
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onProtocolReceiveMailList(paramArrayOfMail, paramString, paramProtocolResult);
  }
  
  public void onReceiving(int paramInt1, int paramInt2, int paramInt3)
  {
    this.val$listener.onReceiving(paramInt1, paramInt2, paramInt3);
  }
  
  public void onResult(ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onResult(paramProtocolResult);
  }
  
  public void onRetrieveFolders(Mail.Folder[] paramArrayOfFolder1, Mail.Folder[] paramArrayOfFolder2, Mail.Folder[] paramArrayOfFolder3, ProtocolResult paramProtocolResult, int paramInt)
  {
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onRetrieveFolders(paramArrayOfFolder1, paramArrayOfFolder2, paramArrayOfFolder3, paramProtocolResult, paramInt);
  }
  
  public void onRetrieveMail(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramMail);
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onRetrieveMail(paramMail, paramProtocolResult);
  }
  
  public void onRetrieveMailComplete(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onRetrieveMailComplete(paramInt1, paramInt2, paramInt3, paramArrayOfString1, paramArrayOfString2, paramProtocolResult);
  }
  
  public void onRetrieveMails(Mail[] paramArrayOfMail, String paramString, ProtocolResult paramProtocolResult)
  {
    int j = paramArrayOfMail.length;
    int i = 0;
    while (i < j)
    {
      ARTCompatibility.access$000(paramArrayOfMail[i]);
      i += 1;
    }
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onRetrieveMails(paramArrayOfMail, paramString, paramProtocolResult);
  }
  
  public void onSearchMail(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramMail);
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onSearchMail(paramMail, paramProtocolResult);
  }
  
  public void onSearchMailComplete(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onSearchMailComplete(paramInt1, paramInt2, paramInt3, paramArrayOfString1, paramArrayOfString2, paramProtocolResult);
  }
  
  public void onSendMail(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    ARTCompatibility.access$000(paramMail);
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onSendMail(paramMail, paramProtocolResult);
  }
  
  public boolean onSendMailProgress(int paramInt1, int paramInt2)
  {
    return this.val$listener.onSendMailProgress(paramInt1, paramInt2);
  }
  
  public void onSyncFinished()
  {
    this.val$listener.onSyncFinished();
  }
  
  public void onSyncKey(int paramInt, String paramString)
  {
    this.val$listener.onSyncKey(paramInt, paramString);
  }
  
  public void onUpdateComplete(HashMap<String, Mail[]> paramHashMap, ProtocolResult paramProtocolResult)
  {
    if (paramHashMap != null)
    {
      Iterator localIterator = paramHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Mail[] arrayOfMail = (Mail[])((Map.Entry)localIterator.next()).getValue();
        int j = arrayOfMail.length;
        int i = 0;
        while (i < j)
        {
          ARTCompatibility.access$000(arrayOfMail[i]);
          i += 1;
        }
      }
    }
    ARTCompatibility.access$000(paramProtocolResult);
    this.val$listener.onUpdateComplete(paramHashMap, paramProtocolResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.ARTCompatibility.1
 * JD-Core Version:    0.7.0.1
 */