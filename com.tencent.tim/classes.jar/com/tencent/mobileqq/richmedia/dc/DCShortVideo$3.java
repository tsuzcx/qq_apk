package com.tencent.mobileqq.richmedia.dc;

import alyr;
import alyr.a;
import alyr.c;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$3
  implements Runnable
{
  public DCShortVideo$3(alyr paramalyr, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong) {}
  
  public void run()
  {
    Object localObject = new alyr.a();
    this.this$0.a(this.b, this.dAl, this.alR, this.val$UIN, (alyr.c)localObject);
    ((alyr.a)localObject).duration = this.Kq;
    ((alyr.a)localObject).aif = this.aie;
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportFullscreenPreview]shortVideoType=" + ((alyr.a)localObject).dAw + ", duration=" + ((alyr.a)localObject).duration + ",uinType = " + ((alyr.a)localObject).uinType + ",groupMemCount = " + ((alyr.a)localObject).dAv + ",age = " + ((alyr.a)localObject).age + ",gender = " + ((alyr.a)localObject).gender + ",reprotHour = " + ((alyr.a)localObject).dAx + ",netType = " + ((alyr.a)localObject).netType + ",playTimeCost = " + ((alyr.a)localObject).aif);
    }
    localObject = new DataReport.ReportTask("ShortVideo.FullscreenPreview", ((alyr.a)localObject).v("ShortVideo.FullscreenPreview"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.3
 * JD-Core Version:    0.7.0.1
 */