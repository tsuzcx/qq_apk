package com.tencent.mobileqq.intervideo.now;

import aifa;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class FileUploadUtil$1
  implements Runnable
{
  public FileUploadUtil$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    aifa.access$002(aifa.access$100());
    HashMap localHashMap = new HashMap();
    String str = "qiqi" + UUID.randomUUID().toString().replace("-", "");
    Log.i("upload", str);
    localHashMap.put("taskUuid", str);
    localHashMap.put("taskType", "0");
    localHashMap.put("taskBusinessType", "2");
    localHashMap.put("taskTargetId", this.val$uin);
    try
    {
      aifa.b("https://upload.huayang.qq.com/cgi-bin/uploadfile", localHashMap, new File(this.bJC));
      return;
    }
    catch (Exception localException)
    {
      Log.e("HttpUtil", localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.FileUploadUtil.1
 * JD-Core Version:    0.7.0.1
 */