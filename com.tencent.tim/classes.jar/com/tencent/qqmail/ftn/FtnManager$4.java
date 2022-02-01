package com.tencent.qqmail.ftn;

import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.ftn.Ftn.ItemGetDownloadUrlOutput;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import moai.oss.OssHelper;

class FtnManager$4
  extends FtnDefine.FtnCallback
{
  FtnManager$4(FtnManager paramFtnManager, DownloadInfo paramDownloadInfo) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(6, "FtnManager", "Ftn get download url error:" + FtnCommonUtils.netErrorFormat(paramInt1, paramInt2, paramInt3, paramString));
    QMWatcherCenter.triggerFtnGetDownloadUrlError(this.val$info.getFid(), paramInt1, paramInt2, paramInt3, paramString);
    OssHelper.ftnattachDownloadFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "FtnManager", FileUtil.getFileNameSuffix(this.val$info.getFileName()), "error:" + paramInt1 });
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte1 = new ItemGetDownloadUrlOutput().parseFrom(paramArrayOfByte2);
      QMWatcherCenter.triggerFtnGetDownloadUrlSuccess(this.val$info.getFid(), paramArrayOfByte1.downloadurl);
      this.val$info.setUrl(paramArrayOfByte1.downloadurl);
      this.val$info.setKey(paramArrayOfByte1.downloadurl);
      paramArrayOfByte2 = FileUtil.getAttachDownloadDir();
      this.val$info.setFilePath(paramArrayOfByte2 + FileUtil.rename(paramArrayOfByte2, this.val$info.getFileName()));
      QMLog.log(4, "FtnManager", "Ftn get download url success to download file");
      this.this$0.downloadFile(paramArrayOfByte1.cookiename, paramArrayOfByte1.cookievalue, this.val$info);
      return;
    }
    catch (IOException paramArrayOfByte1)
    {
      QMLog.log(6, "FtnManager", "Ftn get download url error:" + paramArrayOfByte1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.4
 * JD-Core Version:    0.7.0.1
 */