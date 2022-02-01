import android.app.Dialog;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.d;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import java.util.concurrent.atomic.AtomicBoolean;

public class vns
  implements CameraCaptureView.d
{
  public vns(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult) {}
  
  public void a(CameraCaptureView.h paramh) {}
  
  public void ac(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
    {
      aqha.a(this.this$0, 230, this.this$0.getString(2131700589), acfp.m(2131711767), new vnt(this), null).show();
      return;
    }
    QQIdentiferActivity.a(this.this$0).set(false);
    QQIdentiferActivity.a(this.this$0).drL();
  }
  
  public void bST() {}
  
  public void bSU() {}
  
  public void bSV() {}
  
  public void onCaptureError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vns
 * JD-Core Version:    0.7.0.1
 */