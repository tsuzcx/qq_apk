import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class alwt
{
  public static int Ip()
  {
    int j = 2;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4);
    long l = localSharedPreferences.getLong("key_open_camera_time", 0L);
    int i = j;
    if (l != 0L)
    {
      i = j;
      if (System.currentTimeMillis() - l < 300000L) {
        i = localSharedPreferences.getInt("camera", 2);
      }
    }
    return i;
  }
  
  public static int Iq()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", 1);
  }
  
  public static void Ty(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    localEditor.putInt("camera", paramInt);
    localEditor.putLong("key_open_camera_time", System.currentTimeMillis());
    localEditor.apply();
  }
  
  public static boolean auI()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).contains("camera");
  }
  
  public static void dKq()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    localEditor.putLong("key_open_camera_time", System.currentTimeMillis());
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwt
 * JD-Core Version:    0.7.0.1
 */