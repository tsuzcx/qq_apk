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

class QMPrivateProtocolManager$11
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$11(QMPrivateProtocolManager paramQMPrivateProtocolManager, String paramString, QMCallback paramQMCallback) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "syncPhoto error code " + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      paramCloudProtocolResult = paramCloudProtocolResult.sync_photo_list_;
      if ((paramCloudProtocolResult != null) && (paramCloudProtocolResult.length > 0))
      {
        int j = paramCloudProtocolResult.length;
        int i = 0;
        if (i >= j) {
          break label416;
        }
        str2 = paramCloudProtocolResult[i];
        str1 = str2.email;
        localObject = this.val$emailIconDir + File.separator + str1;
        localFile = new File((String)localObject);
        if ((!localFile.exists()) || (!localFile.isDirectory())) {
          localFile.mkdirs();
        }
        if (str2.result == 0)
        {
          localObject = str2.data.toByteArray();
          str2 = str2.sha;
          QMPrivateProtocolManager.access$1500(this.this$0, str1, str2);
          ImageUtil.cutPhotoAndSave(ImageUtil.getBitmapFromBytes((byte[])localObject), str1);
          QMLog.log(4, "QMPrivateProtocolManager", "syncPhoto success:" + str1 + ",sha:" + str2);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = new File((String)localObject + File.separator + "sha");
          if (!((File)localObject).exists()) {
            break label390;
          }
          if ((str2.result == -10007) || (str2.result == -10022))
          {
            if (str2.sha == null) {
              break label352;
            }
            QMPrivateProtocolManager.access$1500(this.this$0, str1, str2.sha);
            QMLog.log(4, "QMPrivateProtocolManager", "syncPhoto save sha is:" + str2.sha + "," + str1);
          }
        }
        label352:
        QMLog.log(4, "QMPrivateProtocolManager", "syncPhoto save sha is null:" + str1);
        QMPrivateProtocolManager.access$1500(this.this$0, str1, "");
      }
      label390:
      label416:
      while (this.val$callback == null) {
        for (;;)
        {
          String str2;
          String str1;
          Object localObject;
          File localFile;
          return;
          try
          {
            ((File)localObject).createNewFile();
          }
          catch (Exception localException)
          {
            QMLog.log(6, "QMPrivateProtocolManager", Log.getStackTraceString(localException));
          }
        }
      }
      this.val$callback.handleSuccess(null, null);
      return;
    }
    new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.SyncPhoto");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.11
 * JD-Core Version:    0.7.0.1
 */