package com.tencent.mobileqq.utils;

import android.os.Bundle;
import aqfz;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.File;

public class AntiFraudConfigFileUtil$4
  implements Runnable
{
  public AntiFraudConfigFileUtil$4(aqfz paramaqfz, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    String str1 = this.this$0.pn(this.csQ);
    File localFile = new File(str1);
    Object localObject = localFile.getParent();
    localObject = new File((String)localObject + "/download" + this.csQ + ".xml");
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (HttpDownloadUtil.a(null, MsfSdkUtils.insertMtype("QPSingle", this.val$url), (File)localObject))
    {
      String str2 = SecUtil.getFileMd5(((File)localObject).getAbsolutePath());
      if (!this.val$md5.equalsIgnoreCase(str2)) {
        aqfz.b(this.this$0).putInt(this.val$md5, 2);
      }
    }
    else
    {
      return;
    }
    if (((File)localObject).renameTo(localFile))
    {
      aqfz.b(this.this$0).putInt(this.val$md5, 3);
      this.this$0.bk(this.csQ, System.currentTimeMillis());
      this.this$0.ij(this.csQ, this.val$md5);
      aqfz.b(this.this$0, str1);
      return;
    }
    aqfz.b(this.this$0).putInt(this.val$md5, 2);
    ((File)localObject).delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.4
 * JD-Core Version:    0.7.0.1
 */