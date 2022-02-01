import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import mqq.os.MqqHandler;

public class aywm
  implements SurfaceHolder.Callback
{
  public aywm(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "surfaceCreated: mSavedCurPosition:" + this.this$0.cnv + ",mSavedPlayState : " + this.this$0.bA(this.this$0.cnw));
    }
    if ((this.this$0.cnw == 1) && (this.this$0.cnv > 0))
    {
      this.this$0.play(this.this$0.cnv);
      this.this$0.cnv = 0;
      this.this$0.cnw = 0;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "surfaceDestroyed ");
    }
    this.this$0.azR();
    if (this.this$0.B != null) {
      this.this$0.B.removeCallbacks(this.this$0.fo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aywm
 * JD-Core Version:    0.7.0.1
 */