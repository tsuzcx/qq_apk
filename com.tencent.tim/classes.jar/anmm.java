import android.graphics.Bitmap;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.splashad.SplashADView.b;
import com.tencent.mobileqq.splashad.SplashADView.c;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.qphone.base.util.QLog;

public class anmm
  implements VideoPlayerCallback
{
  public anmm(SplashADView paramSplashADView) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.d("SplashAD", 2, "onPlayError , errorType = " + paramInt2 + ", errorCode=" + paramInt3 + " " + paramString);
    SplashADView.a(this.this$0).onPlayError(paramLong, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashAD", 2, "onStateChange , state = " + paramInt + ", msgUniseq=" + paramLong);
    }
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 3: 
      SplashADView.a(this.this$0);
      return;
    }
    SplashADView.a(this.this$0).dRB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anmm
 * JD-Core Version:    0.7.0.1
 */