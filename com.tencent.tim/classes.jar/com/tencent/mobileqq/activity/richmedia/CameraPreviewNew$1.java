package com.tencent.mobileqq.activity.richmedia;

import aaov;
import android.content.Context;
import android.view.WindowManager.BadTokenException;
import aqha;
import aqju;
import com.tencent.qphone.base.util.QLog;

public class CameraPreviewNew$1
  implements Runnable
{
  CameraPreviewNew$1(CameraPreviewNew paramCameraPreviewNew, String paramString, int paramInt, Context paramContext) {}
  
  public void run()
  {
    Object localObject = this.val$errMsg;
    if (this.val$errCode == 2002) {
      localObject = this.I.getString(2131701579);
    }
    localObject = aqha.a(this.I, 230).setMessage((CharSequence)localObject).setPositiveButton(this.I.getString(2131695681), new aaov(this));
    try
    {
      ((aqju)localObject).setCancelable(false);
      ((aqju)localObject).show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("CameraPreviewNew", 2, "", localBadTokenException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.CameraPreviewNew.1
 * JD-Core Version:    0.7.0.1
 */