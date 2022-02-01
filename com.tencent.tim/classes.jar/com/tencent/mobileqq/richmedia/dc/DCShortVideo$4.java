package com.tencent.mobileqq.richmedia.dc;

import alyr;
import alyr.c;
import alyr.d;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$4
  implements Runnable
{
  public DCShortVideo$4(alyr paramalyr, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new alyr.d();
    this.this$0.a(this.b, this.dAl, this.alR, this.val$UIN, (alyr.c)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((alyr.d)localObject).dAw + ",uinType = " + ((alyr.d)localObject).uinType + ",groupMemCount = " + ((alyr.d)localObject).dAv + ",age = " + ((alyr.d)localObject).age + ",gender = " + ((alyr.d)localObject).gender + ",reprotHour = " + ((alyr.d)localObject).dAx + ",netType = " + ((alyr.d)localObject).netType);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Save", ((alyr.d)localObject).v("ShortVideo.Save"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
 * JD-Core Version:    0.7.0.1
 */