package com.tencent.mobileqq.camera.adapter;

import aeae;
import aeaf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera;
import com.tencent.qphone.base.util.QLog;

public class CameraWrapper$1
  implements Runnable
{
  public CameraWrapper$1(aeaf paramaeaf, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    int i = Camera.getNumberOfCameras();
    aeae.a().cVq();
    if ((aeae.a().readCamNumException) || (aeae.a().disableFrontCamera))
    {
      QLog.d("Q.camera.CameraWrapper", 1, new Object[] { "getNumberOfCameras, readCamNumException:", Boolean.valueOf(aeae.a().readCamNumException) });
      i = 1;
    }
    aeaf.access$002(i);
    this.val$sp.edit().putInt("localsp_camera_num", i).commit();
    QLog.d("Q.camera.CameraWrapper", 1, new Object[] { "getNumberOfCameras init, return ", Integer.valueOf(aeaf.access$000()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.adapter.CameraWrapper.1
 * JD-Core Version:    0.7.0.1
 */