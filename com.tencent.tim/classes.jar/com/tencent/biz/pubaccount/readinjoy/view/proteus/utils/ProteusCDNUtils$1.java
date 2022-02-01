package com.tencent.biz.pubaccount.readinjoy.view.proteus.utils;

import aqhq;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import npx;

public final class ProteusCDNUtils$1
  implements Runnable
{
  public ProteusCDNUtils$1(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    File localFile = new File(this.val$localPath);
    if (localFile.exists())
    {
      aqhq.deleteFile(this.val$localPath);
      QLog.i("ProteusCDNUtils", 1, "[downloadByCDN], bid = " + this.val$bid + ", delete old compressFile, path = " + this.val$localPath);
    }
    boolean bool = HttpDownloadUtil.a(null, this.ans, localFile);
    QLog.i("ProteusCDNUtils", 1, "[downloadByCDN], bid = " + this.val$bid + ", isDownloadSucc = " + bool);
    if (bool)
    {
      npx.access$000(this.val$bid);
      return;
    }
    npx.access$100("0X800AC00", this.val$bid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.ProteusCDNUtils.1
 * JD-Core Version:    0.7.0.1
 */