package com.tencent.qqmail.advertise;

import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class AdvertiseManager$3$1
  implements Runnable
{
  AdvertiseManager$3$1(AdvertiseManager.3 param3, String paramString) {}
  
  public void run()
  {
    String str = StringExtention.fileMD5(this.val$path);
    QMLog.log(4, "AdvertiseManager", "downloadedFileMd5 = " + str + " correct md5 = " + this.this$1.val$md5);
    if (!str.equals(this.this$1.val$md5))
    {
      QMLog.log(4, "AdvertiseManager", "You have downloaded a file whose md5 has been modified");
      FileUtil.delFile(this.val$path);
      return;
    }
    AdvertiseImageDecoder.getInstance().startDecode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.advertise.AdvertiseManager.3.1
 * JD-Core Version:    0.7.0.1
 */