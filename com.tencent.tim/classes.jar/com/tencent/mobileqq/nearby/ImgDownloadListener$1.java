package com.tencent.mobileqq.nearby;

import ajpe;
import android.os.SystemClock;
import android.text.TextUtils;
import anpc;
import aqiw;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ImgDownloadListener$1
  implements Runnable
{
  public ImgDownloadListener$1(ajpe paramajpe, long paramLong) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime() - ajpe.a(this.this$0);
    Object localObject2 = aqiw.K(ajpe.a(this.this$0));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "wifi";
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("fileSize", String.valueOf(this.val$fileSize));
    ((HashMap)localObject2).put("costTime", String.valueOf(l));
    ((HashMap)localObject2).put("apn", localObject1);
    ((HashMap)localObject2).put("param_NetType", aqiw.getSystemNetwork(null) + "");
    anpc.a(ajpe.a(this.this$0)).collectPerformance("", ajpe.a(this.this$0), true, l, 0L, (HashMap)localObject2, "", true);
    if (QLog.isColorLevel()) {
      QLog.d("ImgDownloadListener", 2, "onFileDownloadSucceed, fileSize=" + this.val$fileSize);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ImgDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */