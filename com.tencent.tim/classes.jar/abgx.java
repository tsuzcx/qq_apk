import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.TMG.utils.QLog;

public class abgx
{
  private SurfaceHolder.Callback b = new abgy(this);
  private Context mContext;
  private int mGameId;
  public SurfaceView mSurfaceView;
  
  public abgx(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mGameId = paramInt;
  }
  
  AVVideoCtrl a()
  {
    AVContext localAVContext = abvy.a(this.mContext).a();
    if (localAVContext != null) {
      return localAVContext.getVideoCtrl();
    }
    return null;
  }
  
  public void cBv()
  {
    WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = 1;
    localLayoutParams.height = 1;
    localLayoutParams.flags = 776;
    localLayoutParams.format = -3;
    localLayoutParams.windowAnimations = 0;
    localLayoutParams.gravity = 51;
    try
    {
      if (this.mSurfaceView == null)
      {
        this.mSurfaceView = new SurfaceView(this.mContext);
        SurfaceHolder localSurfaceHolder = this.mSurfaceView.getHolder();
        localSurfaceHolder.addCallback(this.b);
        localSurfaceHolder.setType(3);
        this.mSurfaceView.setZOrderMediaOverlay(true);
        localWindowManager.addView(this.mSurfaceView, localLayoutParams);
      }
      QLog.e("AVCameraCaptureModel", 0, "memoryLeak initCameraPreview");
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        localWindowManager.updateViewLayout(this.mSurfaceView, localLayoutParams);
        if (QLog.isColorLevel()) {
          QLog.d("AVCameraCaptureModel", 0, "add camera surface view fail: IllegalStateException." + localIllegalStateException);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVCameraCaptureModel", 0, "add camera surface view fail." + localException);
        }
      }
    }
  }
  
  public void cBw()
  {
    if ((this.mContext == null) || (this.mSurfaceView == null)) {
      return;
    }
    WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
    try
    {
      localWindowManager.removeView(this.mSurfaceView);
      this.mSurfaceView = null;
      QLog.e("AVCameraCaptureModel", 0, "memoryLeak unInitCameraaPreview");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AVCameraCaptureModel", 0, "remove camera view fail.", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgx
 * JD-Core Version:    0.7.0.1
 */