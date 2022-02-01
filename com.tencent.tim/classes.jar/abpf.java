import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameScreenRotate.1;

public class abpf
{
  public int aUC = 1;
  private ApolloSurfaceView d;
  private CmGameInitParams g;
  private Activity mActivity;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public abpf(ApolloSurfaceView paramApolloSurfaceView, CmGameInitParams paramCmGameInitParams, Activity paramActivity)
  {
    this.d = paramApolloSurfaceView;
    this.g = paramCmGameInitParams;
    this.mActivity = paramActivity;
  }
  
  public static int ga(int paramInt)
  {
    if (paramInt == 1) {}
    do
    {
      return 1;
      if (paramInt == 3) {
        return 0;
      }
    } while (paramInt != 2);
    return 8;
  }
  
  public void HK(int paramInt)
  {
    if (this.mUIHandler != null) {
      this.mUIHandler.post(new CmGameScreenRotate.1(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abpf
 * JD-Core Version:    0.7.0.1
 */