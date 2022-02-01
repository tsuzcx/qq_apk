import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.camera.adapter.CameraWrapper.1;
import com.tencent.qphone.base.util.QLog;

@TargetApi(9)
public class aeaf
{
  private static aeaf b;
  private static int cLM = -1;
  private volatile boolean bSE;
  
  private aeaf()
  {
    GX(false);
  }
  
  public static aeaf b()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new aeaf();
      }
      return b;
    }
    finally {}
  }
  
  public int Cd()
  {
    return 21;
  }
  
  public void GX(boolean paramBoolean)
  {
    aeae.a().a(aeah.f(BaseApplicationImpl.getContext()), paramBoolean);
  }
  
  public boolean afV()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraWrapper", 2, "[isSysVersionValid] ENTER sysCamerOn=" + aeae.a().bSD + " sysMinVersion=" + aeae.a().bww + " sysMaxVersion=" + aeae.a().bwx + " currVersion=" + Build.VERSION.RELEASE);
    }
    aeae.a().cVo();
    boolean bool1 = bool3;
    if (aeae.a().bSD) {}
    try
    {
      String[] arrayOfString2 = aeae.a().bww.split("\\.");
      String[] arrayOfString3 = aeae.a().bwx.split("\\.");
      String[] arrayOfString1;
      int j;
      int i;
      if (Build.VERSION.RELEASE != null)
      {
        arrayOfString1 = Build.VERSION.RELEASE.split("\\.");
        bool1 = bool3;
        if (arrayOfString1 != null)
        {
          bool1 = bool3;
          if (arrayOfString2.length == 3)
          {
            bool1 = bool3;
            if (arrayOfString3.length == 3)
            {
              j = Integer.parseInt(arrayOfString2[0]);
              int i3 = Integer.parseInt(arrayOfString2[1]);
              int i4 = Integer.parseInt(arrayOfString2[2]);
              int k = Integer.parseInt(arrayOfString1[0]);
              int m = Integer.parseInt(arrayOfString1[1]);
              if (arrayOfString1.length != 3) {
                break label356;
              }
              i = Integer.parseInt(arrayOfString1[2]);
              label231:
              int n = Integer.parseInt(arrayOfString3[0]);
              int i1 = Integer.parseInt(arrayOfString3[1]);
              int i2 = Integer.parseInt(arrayOfString3[2]);
              if ((k <= j) && ((k != j) || (m <= i3)) && ((j != k) || (i3 != m) || (i < i4))) {
                break label361;
              }
              j = 1;
              label295:
              if ((k >= n) && ((k != n) || (m >= i1)) && ((n != k) || (i1 != m) || (i > i2))) {
                break label366;
              }
              i = 1;
              label335:
              if ((j == 0) || (i == 0)) {
                break label371;
              }
            }
          }
        }
      }
      label356:
      label361:
      label366:
      label371:
      for (bool1 = bool2;; bool1 = false)
      {
        return bool1;
        arrayOfString1 = null;
        break;
        i = 0;
        break label231;
        j = 0;
        break label295;
        i = 0;
        break label335;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean afW()
  {
    aeae.a().cVs();
    return aeae.a().frontCamFlipH;
  }
  
  public boolean afX()
  {
    aeae.a().cVp();
    return aeae.a().disableCameraSDK;
  }
  
  public int av(int paramInt1, int paramInt2)
  {
    QLog.d("Q.camera.CameraWrapper", 2, "[getCameraOrientation] cameraId = " + paramInt1 + ", cameraOrientation = " + paramInt2);
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt1, localCameraInfo);
    paramInt1 = localCameraInfo.orientation;
    aeae.a().cVr();
    if (localCameraInfo.facing == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraWrapper", 2, "is FRONT camera, orientation = " + paramInt1);
      }
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraWrapper", 2, "return orientation = " + paramInt1);
      }
      return paramInt1;
      if (aeae.a().int_frontCamRotate0 != -1)
      {
        paramInt1 = aeae.a().int_frontCamRotate0;
        QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate0 = " + paramInt1);
        continue;
        if (aeae.a().int_frontCamRotate90 != -1)
        {
          paramInt1 = aeae.a().int_frontCamRotate90;
          QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate90 = " + paramInt1);
          continue;
          if (aeae.a().int_frontCamRotate180 != -1)
          {
            paramInt1 = aeae.a().int_frontCamRotate180;
            QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate180 = " + paramInt1);
            continue;
            if (aeae.a().int_frontCamRotate270 != -1)
            {
              paramInt1 = aeae.a().int_frontCamRotate270;
              QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate270 = " + paramInt1);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("Q.camera.CameraWrapper", 2, "is BACK camera, orientation = " + paramInt1);
              }
              switch (paramInt2)
              {
              default: 
                break;
              case -1: 
              case 0: 
                if (aeae.a().int_backCamRotate0 != -1)
                {
                  paramInt1 = aeae.a().int_backCamRotate0;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate0 = " + paramInt1);
                }
                break;
              case 90: 
                if (aeae.a().int_backCamRotate90 != -1)
                {
                  paramInt1 = aeae.a().int_backCamRotate90;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate90 = " + paramInt1);
                }
                break;
              case 180: 
                if (aeae.a().int_backCamRotate180 != -1)
                {
                  paramInt1 = aeae.a().int_backCamRotate180;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate180 = " + paramInt1);
                }
                break;
              case 270: 
                if (aeae.a().int_backCamRotate270 != -1)
                {
                  paramInt1 = aeae.a().int_backCamRotate270;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate270 = " + paramInt1);
                }
                break;
              }
            }
          }
        }
      }
    }
  }
  
  public int getNumberOfCameras()
  {
    int j;
    if (cLM != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraWrapper", 2, "[getNumberOfCameras] sNumberOfCameras = " + cLM);
      }
      j = cLM;
      return j;
    }
    SharedPreferences localSharedPreferences = aeah.g(BaseApplicationImpl.getContext());
    int i;
    if (localSharedPreferences.contains("localsp_camera_num"))
    {
      j = localSharedPreferences.getInt("localsp_camera_num", 0);
      i = j;
      if (j < 1)
      {
        i = Camera.getNumberOfCameras();
        anpc.report("event_camera_num_less_two");
      }
    }
    for (;;)
    {
      cLM = i;
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.camera.CameraWrapper", 2, new Object[] { "getNumberOfCameras, return ", Integer.valueOf(cLM) });
      return i;
      if (!this.bSE)
      {
        this.bSE = true;
        ThreadManager.excute(new CameraWrapper.1(this, localSharedPreferences), 64, null, false);
      }
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeaf
 * JD-Core Version:    0.7.0.1
 */