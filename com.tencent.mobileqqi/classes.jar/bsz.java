import android.graphics.Rect;
import android.view.View;
import com.tencent.biz.qrcode.CameraManager;
import com.tencent.biz.qrcode.ViewfinderView;
import com.tencent.biz.qrcode.activity.ScannerActivity;

public class bsz
  implements Runnable
{
  public bsz(ScannerActivity paramScannerActivity) {}
  
  public void run()
  {
    Rect localRect1 = this.a.a();
    if (this.a.jdField_f_of_type_Boolean) {
      this.a.jdField_a_of_type_ComTencentBizQrcodeCameraManager.a(localRect1);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentBizQrcodeViewfinderView.setFlippedFrameingRect(localRect1);
      this.a.jdField_b_of_type_AndroidViewView.post(this.a.jdField_b_of_type_JavaLangRunnable);
      return;
      Rect localRect2 = new Rect(localRect1.left, localRect1.top + this.a.jdField_f_of_type_Int, localRect1.right, localRect1.bottom + this.a.jdField_f_of_type_Int);
      this.a.jdField_a_of_type_ComTencentBizQrcodeCameraManager.a(localRect2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bsz
 * JD-Core Version:    0.7.0.1
 */