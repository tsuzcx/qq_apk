package com.tencent.mobileqq.activity.faceunlock;

import android.util.Base64;
import aqhq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import zef;

public class FaceUnblockCameraJsApiPlugin$2
  implements Runnable
{
  public FaceUnblockCameraJsApiPlugin$2(zef paramzef, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = aqhq.readFile(this.baa);
      if (localObject != null)
      {
        localObject = Base64.encodeToString((byte[])localObject, 0);
        ThreadManager.getUIHandler().post(new FaceUnblockCameraJsApiPlugin.2.1(this, (String)localObject));
        return;
      }
      QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock FileUtils.readFile returns null, filepath:" + this.baa);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock read from filePath error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.FaceUnblockCameraJsApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */