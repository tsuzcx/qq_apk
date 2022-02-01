package com.tencent.mm.hardcoder;

import arwu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import tzb;
import tzc;

public class HardCoderManager$3
  implements Runnable
{
  public HardCoderManager$3(tzc paramtzc, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QLog.d("HardCoder.QQManager", 1, "start download");
    File localFile = new File(tzb.aKj + "_tmp");
    int i = HttpDownloadUtil.a(this.val$app, "https://qd.myapp.com/myapp/qqteam/qq_tools/libhc4.jpg", localFile);
    if (i == 0) {
      if ((localFile.exists()) && ("5c08438266c3084212bb9307aa7c2aaa".equalsIgnoreCase(arwu.getFileMD5(localFile))))
      {
        localFile.renameTo(new File(tzb.aKj));
        tzc.a(this.this$0, 6);
      }
    }
    for (;;)
    {
      localFile = new File(tzb.aKi);
      if (localFile.exists()) {
        localFile.delete();
      }
      QLog.d("HardCoder.QQManager", 1, "downloadResult = " + i + ", state = " + tzc.a(this.this$0));
      return;
      QLog.d("HardCoder.QQManager", 1, "check md5 fail");
      localFile.delete();
      tzc.a(this.this$0, 5);
      continue;
      tzc.a(this.this$0, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderManager.3
 * JD-Core Version:    0.7.0.1
 */