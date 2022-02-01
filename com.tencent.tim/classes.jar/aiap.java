import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import com.tencent.youtufacetrack.YoutuFaceTracker;

public class aiap
{
  static String[] fm = { "libYTAGReflectLiveCheck.so", "libYTPoseDetect.so" };
  static String[] fn = { "libopencv_world.so", "libYTCommon.so", "libYTFaceTrackPro.so" };
  protected aiaj a;
  public YoutuFaceTracker a;
  public aiay.a b;
  
  @RequiresApi(api=18)
  public static aiap a(int paramInt, Intent paramIntent, aiay.a parama)
  {
    return new aiav(paramIntent, parama);
  }
  
  public void b(boolean paramBoolean, Activity paramActivity) {}
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Aiaj != null) {
      this.jdField_a_of_type_Aiaj.destroy();
    }
    if (this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker != null)
    {
      this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker.destroy();
      this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker = null;
      YoutuFaceTracker.GlobalRelease();
    }
  }
  
  public boolean e(String paramString, String[] paramArrayOfString)
  {
    return false;
  }
  
  public int y(Context paramContext, String paramString)
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiap
 * JD-Core Version:    0.7.0.1
 */