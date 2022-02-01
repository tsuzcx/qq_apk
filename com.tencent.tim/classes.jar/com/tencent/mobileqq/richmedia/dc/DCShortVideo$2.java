package com.tencent.mobileqq.richmedia.dc;

import alyr;
import alyr.b;
import alyr.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$2
  implements Runnable
{
  public DCShortVideo$2(alyr paramalyr, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void run()
  {
    Object localObject = new alyr.b();
    this.this$0.a(this.val$app, this.dAl, this.alR, this.val$UIN, (alyr.c)localObject);
    ((alyr.b)localObject).dAu = this.dAm;
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportPreview]shortVideoType=" + ((alyr.b)localObject).dAw + ",uinType = " + ((alyr.b)localObject).uinType + ",groupMemCount = " + ((alyr.b)localObject).dAv + ",age = " + ((alyr.b)localObject).age + ",gender = " + ((alyr.b)localObject).gender + ",reprotHour = " + ((alyr.b)localObject).dAx + ",netType = " + ((alyr.b)localObject).netType + ",playAction = " + ((alyr.b)localObject).dAu);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Preview", ((alyr.b)localObject).v("ShortVideo.Preview"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.2
 * JD-Core Version:    0.7.0.1
 */