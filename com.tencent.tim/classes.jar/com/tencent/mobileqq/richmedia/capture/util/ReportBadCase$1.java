package com.tencent.mobileqq.richmedia.capture.util;

import alxf;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import aqhq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataFrame;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ReportBadCase$1
  implements Runnable
{
  public ReportBadCase$1(alxf paramalxf, BadcaseReportUtils.BadDataFrame paramBadDataFrame) {}
  
  public void run()
  {
    ??? = Bitmap.createBitmap(this.a.width, this.a.height, Bitmap.Config.ARGB_8888);
    ((Bitmap)???).copyPixelsFromBuffer(this.a.pictureBuffer);
    String str1 = alxf.access$000();
    boolean bool = alxf.f((Bitmap)???, str1);
    if (QLog.isColorLevel()) {
      QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils|writeBitmapToFile success=" + bool);
    }
    this.a.pictureBuffer = null;
    if (bool)
    {
      this.a.picturePath = str1;
      this.a.convertedPath = (str1 + "_ct_2");
      BadcaseReportUtils.convertDataFormat(this.a);
      synchronized (alxf.access$100())
      {
        alxf.access$200().add(this.a);
      }
    }
    synchronized (alxf.access$100())
    {
      int i = alxf.access$200().size();
      if (i == 3) {
        ThreadManager.postDownLoadTask(new ReportBadCase.1.1(this), 5, null, true);
      }
      return;
      str2 = finally;
      throw str2;
      aqhq.deleteFile(str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.ReportBadCase.1
 * JD-Core Version:    0.7.0.1
 */