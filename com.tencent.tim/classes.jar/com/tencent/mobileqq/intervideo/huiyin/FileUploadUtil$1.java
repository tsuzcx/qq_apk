package com.tencent.mobileqq.intervideo.huiyin;

import aidw;
import aidw.a;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class FileUploadUtil$1
  implements Runnable
{
  public FileUploadUtil$1(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, aidw.a parama) {}
  
  public void run()
  {
    aidw.access$002(aidw.access$100());
    HashMap localHashMap = new HashMap();
    aidw.access$202("sex=" + this.bNh + ";user_name=" + this.bNi + ";ilive_tinyid=" + this.bNj + ";ilive_a2=" + this.bNk + ";ilive_login_type=0;ilive_uin=" + this.val$uin + ";");
    localHashMap.put("sex", this.bNh);
    localHashMap.put("voice_word", Uri.encode(this.bNl));
    try
    {
      aidw.b(this.bNm, localHashMap, new File(this.bJC), this.a);
      return;
    }
    catch (Exception localException)
    {
      Log.e("HuiyinFileUpload", localException.getLocalizedMessage());
      this.a.onComplete(1, localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.FileUploadUtil.1
 * JD-Core Version:    0.7.0.1
 */