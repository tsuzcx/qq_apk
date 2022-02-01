package com.tencent.qqmail.model.protocol;

import android.util.Log;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoRspInfo;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import java.io.File;

class QMPrivateProtocolManager$12
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$12(QMPrivateProtocolManager paramQMPrivateProtocolManager, String paramString1, QMCallback paramQMCallback, String paramString2, String paramString3) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    int j = 0;
    int i = 0;
    QMLog.log(4, "QMPrivateProtocolManager", "syncEmailIconByRedirect error code " + paramCloudProtocolResult.error_code_);
    String str2;
    Object localObject1;
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      paramCloudProtocolResult = paramCloudProtocolResult.sync_photo_list_;
      if ((paramCloudProtocolResult != null) && (paramCloudProtocolResult.length > 0))
      {
        j = paramCloudProtocolResult.length;
        if (i >= j) {
          break label428;
        }
        str2 = paramCloudProtocolResult[i];
        String str1 = str2.email;
        localObject1 = this.val$emailIconDir + File.separator + str1;
        Object localObject2 = new File((String)localObject1);
        if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory())) {
          ((File)localObject2).mkdirs();
        }
        if (str2.result == 0)
        {
          localObject1 = str2.data.toByteArray();
          localObject2 = str2.sha;
          str2 = str2.lastmodifytime.trim();
          QMPrivateProtocolManager.access$1500(this.this$0, str1, (String)localObject2);
          this.this$0.saveAvatarLastModify(str1, str2);
          ImageUtil.cutPhotoAndSave(ImageUtil.getBitmapFromBytes((byte[])localObject1), str1);
          QMLog.log(4, "QMPrivateProtocolManager", "syncEmailIconByRedirect success:" + str1 + ",sha:" + (String)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject1 = new File((String)localObject1 + File.separator + "sha");
          if (!((File)localObject1).exists()) {
            break label402;
          }
          if ((str2.result == -10007) || (str2.result == -10022))
          {
            if (str2.sha == null) {
              break label375;
            }
            QMPrivateProtocolManager.access$1500(this.this$0, str1, str2.sha);
            QMLog.log(4, "QMPrivateProtocolManager", "syncEmailIconByRedirect save sha is:" + str2.sha + "," + str1);
          }
        }
        label375:
        QMLog.log(4, "QMPrivateProtocolManager", "syncEmailIconByRedirect save sha is null:" + str1);
      }
    }
    label402:
    label428:
    do
    {
      for (;;)
      {
        return;
        try
        {
          ((File)localObject1).createNewFile();
        }
        catch (Exception localException)
        {
          QMLog.log(6, "QMPrivateProtocolManager", Log.getStackTraceString(localException));
        }
      }
      break;
      this.val$callback.handleSuccess(null, null);
      return;
      if (paramCloudProtocolResult.error_code_ == -10022)
      {
        SyncEMailPhotoRspInfo[] arrayOfSyncEMailPhotoRspInfo = paramCloudProtocolResult.sync_photo_list_;
        int k;
        if ((arrayOfSyncEMailPhotoRspInfo != null) && (arrayOfSyncEMailPhotoRspInfo.length > 0))
        {
          QMLog.log(4, "QMPrivateProtocolManager", "UMAR_NO_CHANGE lastModify");
          k = arrayOfSyncEMailPhotoRspInfo.length;
          i = j;
        }
        while (i < k)
        {
          str2 = arrayOfSyncEMailPhotoRspInfo[i];
          QMPrivateProtocolManager.access$1500(this.this$0, str2.email, str2.sha);
          i += 1;
          continue;
          QMLog.log(4, "QMPrivateProtocolManager", "UMAR_NO_CHANGE sha");
          QMPrivateProtocolManager.access$1500(this.this$0, this.val$reqEmail, this.val$reqSha);
        }
        QMLog.log(4, "QMPrivateProtocolManager", "SyncPhoto-nochange  SyncPhoto err. errcode:" + paramCloudProtocolResult.error_code_);
        return;
      }
      QMLog.log(4, "QMPrivateProtocolManager", this.val$reqEmail + " SyncPhoto err. errcode:" + paramCloudProtocolResult.error_code_);
      QMPrivateProtocolManager.access$1500(this.this$0, this.val$reqEmail, this.val$reqSha);
    } while ((paramCloudProtocolResult.error_code_ == -10007) || (paramCloudProtocolResult.error_code_ == -10022));
    new QMUMAError(paramCloudProtocolResult.error_code_, " CloudProtocolService.SyncPhotoBy302");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.12
 * JD-Core Version:    0.7.0.1
 */