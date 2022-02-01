import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aeae
{
  private static aeae a;
  public final boolean DEBUG = false;
  public boolean bSD;
  public boolean beBlurredPreviewAfterTakePic;
  public String bww;
  public String bwx;
  public int cLL = -1;
  public boolean disableCameraSDK;
  public boolean disableFrontCamera;
  public boolean frontCamFlipH;
  public int int_backCamRotate0 = -1;
  public int int_backCamRotate180 = -1;
  public int int_backCamRotate270 = -1;
  public int int_backCamRotate90 = -1;
  public int int_frontCamRotate0 = -1;
  public int int_frontCamRotate180 = -1;
  public int int_frontCamRotate270 = -1;
  public int int_frontCamRotate90 = -1;
  public boolean readCamNumException;
  private final ArrayList<String> vf = new ArrayList();
  
  public static aeae a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aeae();
      }
      return a;
    }
    finally {}
  }
  
  private void d(SharedPreferences paramSharedPreferences)
  {
    QLog.i("Q.camera.adapter.CameraAttrs", 1, "[loadValueFromPref] + BEGIN");
    this.bSD = paramSharedPreferences.getBoolean("sysCameraOn", false);
    this.bww = paramSharedPreferences.getString("str_sysMinVersion", "1.0.0");
    this.bwx = paramSharedPreferences.getString("str_sysMaxVersion", "1000.0.0");
    this.disableCameraSDK = paramSharedPreferences.getBoolean("disableCameraSDK", true);
    this.readCamNumException = paramSharedPreferences.getBoolean("readCamNumException", false);
    this.disableFrontCamera = paramSharedPreferences.getBoolean("disableFrontCamera", false);
    this.beBlurredPreviewAfterTakePic = paramSharedPreferences.getBoolean("beBlurredPreviewAfterTakePic", false);
    this.int_frontCamRotate0 = paramSharedPreferences.getInt("int_frontCamRotate0", -1);
    this.int_frontCamRotate90 = paramSharedPreferences.getInt("int_frontCamRotate90", -1);
    this.int_frontCamRotate180 = paramSharedPreferences.getInt("int_frontCamRotate180", -1);
    this.int_frontCamRotate270 = paramSharedPreferences.getInt("int_frontCamRotate270", -1);
    this.int_backCamRotate0 = paramSharedPreferences.getInt("int_backCamRotate0", -1);
    this.int_backCamRotate90 = paramSharedPreferences.getInt("int_backCamRotate90", -1);
    this.int_backCamRotate180 = paramSharedPreferences.getInt("int_backCamRotate180", -1);
    this.int_backCamRotate270 = paramSharedPreferences.getInt("int_backCamRotate270", -1);
    this.frontCamFlipH = paramSharedPreferences.getBoolean("frontCamFlipH", false);
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "[loadValueFromPref] + END");
    }
  }
  
  public void a(SharedPreferences paramSharedPreferences, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 4, "[loadConfigAndSave] + BEGIN");
    }
    int i = paramSharedPreferences.getInt("qcamera_conf_version", 0);
    if ((i != this.cLL) && (paramBoolean))
    {
      this.cLL = i;
      d(paramSharedPreferences);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 4, "[loadConfigAndSave] + END");
    }
  }
  
  public void cVo()
  {
    if (this.vf.contains("sysCameraOn")) {
      return;
    }
    SharedPreferences localSharedPreferences = aeah.f(BaseApplicationImpl.getContext());
    this.bSD = localSharedPreferences.getBoolean("sysCameraOn", false);
    this.bww = localSharedPreferences.getString("str_sysMinVersion", "1.0.0");
    this.bwx = localSharedPreferences.getString("str_sysMaxVersion", "1000.0.0");
    this.vf.add("sysCameraOn");
  }
  
  public void cVp()
  {
    if (this.vf.contains("disableCameraSDK")) {
      return;
    }
    this.disableCameraSDK = aeah.f(BaseApplicationImpl.getContext()).getBoolean("disableCameraSDK", true);
    this.vf.add("disableCameraSDK");
  }
  
  public void cVq()
  {
    if (this.vf.contains("readCamNumException")) {
      return;
    }
    SharedPreferences localSharedPreferences = aeah.f(BaseApplicationImpl.getContext());
    this.readCamNumException = localSharedPreferences.getBoolean("readCamNumException", false);
    this.disableFrontCamera = localSharedPreferences.getBoolean("disableFrontCamera", false);
    this.vf.add("readCamNumException");
  }
  
  public void cVr()
  {
    if (this.vf.contains("int_frontCamRotate0")) {
      return;
    }
    SharedPreferences localSharedPreferences = aeah.f(BaseApplicationImpl.getContext());
    this.int_frontCamRotate0 = localSharedPreferences.getInt("int_frontCamRotate0", -1);
    this.int_frontCamRotate90 = localSharedPreferences.getInt("int_frontCamRotate90", -1);
    this.int_frontCamRotate180 = localSharedPreferences.getInt("int_frontCamRotate180", -1);
    this.int_frontCamRotate270 = localSharedPreferences.getInt("int_frontCamRotate270", -1);
    this.int_backCamRotate0 = localSharedPreferences.getInt("int_backCamRotate0", -1);
    this.int_backCamRotate90 = localSharedPreferences.getInt("int_backCamRotate90", -1);
    this.int_backCamRotate180 = localSharedPreferences.getInt("int_backCamRotate180", -1);
    this.int_backCamRotate270 = localSharedPreferences.getInt("int_backCamRotate270", -1);
    this.vf.add("int_frontCamRotate0");
  }
  
  public void cVs()
  {
    if (this.vf.contains("frontCamFlipH")) {
      return;
    }
    this.frontCamFlipH = aeah.f(BaseApplicationImpl.getContext()).getBoolean("frontCamFlipH", false);
    this.vf.add("frontCamFlipH");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeae
 * JD-Core Version:    0.7.0.1
 */