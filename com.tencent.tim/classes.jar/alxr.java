import android.graphics.Rect;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class alxr
  implements anim.b
{
  public alxr(CameraCaptureView paramCameraCaptureView, File paramFile, int paramInt, boolean paramBoolean) {}
  
  public void bm(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onAutoFocusCallback requestFocus when capture : " + paramBoolean1 + ", [Camera2]camera2:" + paramBoolean2);
    }
    CameraCaptureView.b.a(this.aJ, new Rect(0, 0, this.this$0.surfaceWidth, this.this$0.surfaceHeight), this.this$0, this.dzp, this.cAO, 1, this.this$0.dzm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxr
 * JD-Core Version:    0.7.0.1
 */