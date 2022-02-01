import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class anih
{
  private static anih jdField_a_of_type_Anih;
  private static int cLJ;
  private static int cLK;
  private static int dGO;
  private Camera.Parameters jdField_a_of_type_AndroidHardwareCamera$Parameters;
  
  static
  {
    int j = 0;
    if (!anih.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cLJ = -1;
      cLK = -1;
      for (;;)
      {
        int i;
        try
        {
          long l = System.currentTimeMillis();
          Object localObject = aeah.g(BaseApplicationImpl.getContext());
          if (((SharedPreferences)localObject).contains("localsp_camera_num"))
          {
            dGO = ((SharedPreferences)localObject).getInt("localsp_camera_num", 0);
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.i("CameraAbility", 2, "getNumberOfCameras cost: " + (System.currentTimeMillis() - l));
              i = j;
            }
            if (i < dGO)
            {
              localObject = new Camera.CameraInfo();
              Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
              if (localObject == null) {
                break label194;
              }
              if ((((Camera.CameraInfo)localObject).facing != 0) || (cLJ != -1)) {
                break label181;
              }
              cLJ = i;
              break label194;
            }
          }
          else
          {
            dGO = Camera.getNumberOfCameras();
            continue;
          }
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("CameraAbility", 2, "", localRuntimeException);
          }
          dGO = 1;
        }
        label181:
        if (1 == localRuntimeException.facing) {
          cLK = i;
        }
        label194:
        i += 1;
      }
    }
  }
  
  public static int JB()
  {
    return cLK;
  }
  
  public static int JC()
  {
    return cLJ;
  }
  
  public static anih a()
  {
    if (jdField_a_of_type_Anih == null) {}
    try
    {
      if (jdField_a_of_type_Anih == null) {
        jdField_a_of_type_Anih = new anih();
      }
      return jdField_a_of_type_Anih;
    }
    finally {}
  }
  
  public static boolean agb()
  {
    return (axl()) && (cLK != -1);
  }
  
  public static boolean axl()
  {
    return dGO > 0;
  }
  
  public static boolean axm()
  {
    return (axl()) && (cLJ != -1);
  }
  
  public boolean a(Camera paramCamera)
  {
    reset();
    if (paramCamera == null) {}
    for (;;)
    {
      return false;
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera$Parameters = paramCamera.getParameters();
        if (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null) {
          continue;
        }
        return true;
      }
      catch (Exception paramCamera)
      {
        for (;;)
        {
          paramCamera.printStackTrace();
          this.jdField_a_of_type_AndroidHardwareCamera$Parameters = null;
        }
      }
    }
  }
  
  public boolean axn()
  {
    assert (this.jdField_a_of_type_AndroidHardwareCamera$Parameters != null);
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.isZoomSupported();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean axo()
  {
    assert (this.jdField_a_of_type_AndroidHardwareCamera$Parameters != null);
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedFlashModes();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains("torch");
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public List<Camera.Size> gk()
  {
    assert (this.jdField_a_of_type_AndroidHardwareCamera$Parameters != null);
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewSizes();
      if ((localList != null) && (QLog.isColorLevel()))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Camera.Size localSize = (Camera.Size)localIterator.next();
          if (localSize != null) {
            QLog.d("CameraAbility", 2, "[@] getPreviewSizes:w=" + localSize.width + ",h=" + localSize.height + " w/h=" + localSize.width / localSize.height);
          }
        }
      }
    }
    catch (Exception localException)
    {
      List<Camera.Size> localList1;
      for (;;)
      {
        localException.printStackTrace();
        localList1 = null;
      }
      return localList1;
    }
  }
  
  public List<Camera.Size> gl()
  {
    assert (this.jdField_a_of_type_AndroidHardwareCamera$Parameters != null);
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPictureSizes();
      if ((localList != null) && (QLog.isColorLevel()))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Camera.Size localSize = (Camera.Size)localIterator.next();
          if (localSize != null) {
            QLog.d("CameraAbility", 2, "[@] getPictureSizes:w=" + localSize.width + ",h=" + localSize.height + " w/h=" + localSize.width / localSize.height);
          }
        }
      }
    }
    catch (Exception localException)
    {
      List<Camera.Size> localList1;
      for (;;)
      {
        localException.printStackTrace();
        localList1 = null;
      }
      return localList1;
    }
  }
  
  @TargetApi(9)
  public List<int[]> gm()
  {
    assert (this.jdField_a_of_type_AndroidHardwareCamera$Parameters != null);
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewFpsRange();
      return localList;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean isSupportFocus(String paramString)
  {
    assert (this.jdField_a_of_type_AndroidHardwareCamera$Parameters != null);
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedFocusModes();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains(paramString);
      if (bool) {
        return true;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public boolean lz(int paramInt)
  {
    assert (this.jdField_a_of_type_AndroidHardwareCamera$Parameters != null);
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewFormats();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains(Integer.valueOf(paramInt));
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean pj(String paramString)
  {
    assert (this.jdField_a_of_type_AndroidHardwareCamera$Parameters != null);
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedSceneModes();
      if ((localList != null) && (!localList.isEmpty()))
      {
        boolean bool = localList.contains(paramString);
        return bool;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void reset()
  {
    this.jdField_a_of_type_AndroidHardwareCamera$Parameters = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anih
 * JD-Core Version:    0.7.0.1
 */