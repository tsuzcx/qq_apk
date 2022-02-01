package com.tencent.mobileqq.richmedia.dc;

import alyr;
import alyr.e;
import android.os.Environment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.b;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class DCShortVideo$1
  implements Runnable
{
  public DCShortVideo$1(alyr paramalyr, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    alyr.e locale = new alyr.e();
    Object localObject1 = new File(this.val$filePath);
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return;
      locale.fileSize = ((File)localObject1).length();
      if (locale.fileSize > 0L)
      {
        this.this$0.a(this.val$app, this.dAl, this.alR, this.val$UIN, locale);
        locale.duration = this.val$duration;
        locale.md5 = this.bWJ;
        try
        {
          Object localObject2 = this.val$filePath;
          String str = Environment.getExternalStorageDirectory().toString();
          localObject1 = localObject2;
          if (str != null)
          {
            localObject1 = localObject2;
            if (this.val$filePath.contains(str)) {
              localObject1 = this.val$filePath.replace(str, "");
            }
          }
          int i = ((String)localObject1).lastIndexOf("/");
          localObject2 = localObject1;
          if (i != -1) {
            localObject2 = ((String)localObject1).substring(0, i);
          }
          locale.bZD = ((String)localObject2).replace("/", "//");
          if (alyr.a(this.this$0, locale, this.val$filePath))
          {
            alyr.a(this.this$0, this.val$app, locale, this.tt, this.bPc, this.bZC);
            locale.isExist = this.ayn;
            locale.dAB = ((int)((System.currentTimeMillis() - new File(this.val$filePath).lastModified()) / 60000L));
            if (locale.dAB == 0) {
              locale.dAB = 1;
            }
            locale.status = VideoEnvironment.dFD;
            locale.userType = (VideoEnvironment.a.mIndex + 2000);
            if (QLog.isDevelopLevel()) {
              QLog.d("DCShortVideo", 4, "[reportSend]url=" + locale.bZD + ",shortVideoType=" + locale.dAw + ",shortVideoSourceType = " + locale.dAA + ",uinType = " + locale.uinType + ",groupMemCount = " + locale.dAv + ",isForward = " + locale.isForward + ",isExsit = " + locale.isExist + ",age = " + locale.age + ",gender = " + locale.gender + ",userType = " + locale.userType + ",reprotHour = " + locale.dAx + ",fileInterval = " + locale.dAB + ",netType = " + locale.netType + ",forwardSourceGroupMemCount = " + locale.dAz + ",forwardSourceUinType = " + locale.dAy + ",duration = " + locale.duration + ",fileSize = " + locale.fileSize + ",md5 = " + locale.md5 + ", status=" + locale.status);
            }
            localObject1 = new DataReport.ReportTask("ShortVideo.Send", locale.v("ShortVideo.Send"));
            DataReport.a().a((DataReport.ReportTask)localObject1);
            return;
          }
        }
        catch (Exception localException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.1
 * JD-Core Version:    0.7.0.1
 */