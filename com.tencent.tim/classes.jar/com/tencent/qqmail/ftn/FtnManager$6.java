package com.tencent.qqmail.ftn;

import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.ftn.model.FtnDownloadInfo;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;
import moai.oss.OssHelper;

class FtnManager$6
  extends FtnDefine.FtnCallback
{
  FtnManager$6(FtnManager paramFtnManager, DownloadInfo paramDownloadInfo) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (paramInt1 != 3) {
      FtnManager.access$300(this.this$0, this.val$downloadInfo.getFid());
    }
    QMLog.log(6, "FtnManager", "DownloadBigAttachCallBack onError, fid:" + this.val$downloadInfo.getFid() + ",cgiExceptionCode:" + paramInt1 + ",logicCode:" + paramInt2 + ",errorType:" + paramInt3 + ",description:" + paramString);
  }
  
  public void onProcessData(long paramLong1, long paramLong2) {}
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    FtnManager.access$300(this.this$0, this.val$downloadInfo.getFid());
    QMLog.log(4, "TAG", "Ftn download file success ");
    paramArrayOfByte1 = new FtnDownloadInfo(this.val$downloadInfo.getFid(), this.val$downloadInfo.getFilePath(), this.val$downloadInfo.getCreateTime(), this.val$downloadInfo.getFtnBytes());
    this.this$0.insertDownloadInfo(paramArrayOfByte1);
    OssHelper.ftnattachDownloadSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "FtnManager", FileUtil.getFileNameSuffix(this.val$downloadInfo.getFileName()), "" });
    paramArrayOfByte1 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(this.val$downloadInfo.getFilePath())));
    QMApplicationContext.sharedInstance().sendBroadcast(paramArrayOfByte1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.6
 * JD-Core Version:    0.7.0.1
 */