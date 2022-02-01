package com.tencent.tim.cloudfile.anima;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import atad;
import audn;
import aulh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

class CloudTeamWorkAnimActivity$5
  implements Runnable
{
  CloudTeamWorkAnimActivity$5(CloudTeamWorkAnimActivity paramCloudTeamWorkAnimActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      Object localObject = atad.toMD5(CloudTeamWorkAnimActivity.b(this.this$0) + CloudTeamWorkAnimActivity.a(this.this$0));
      localObject = new FileOutputStream(new File(audn.a().wb() + "teamwork-" + (String)localObject));
      this.es.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((FileOutputStream)localObject).close();
      if ((this.es != null) && (!this.es.isRecycled())) {
        this.es.recycle();
      }
      ((aulh)this.this$0.app.getBusinessHandler(122)).notifyUI(13, true, null);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CloudTeamWorkAnimActivity", 2, "saveTeamWorkThumb OutOfMemoryError", localOutOfMemoryError);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CloudTeamWorkAnimActivity", 2, "saveTeamWorkThumb Exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.anima.CloudTeamWorkAnimActivity.5
 * JD-Core Version:    0.7.0.1
 */