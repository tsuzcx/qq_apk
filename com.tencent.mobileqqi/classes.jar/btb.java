import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.biz.qrcode.CameraManager;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import java.io.IOException;

public class btb
  extends Thread
{
  public btb(ScannerActivity paramScannerActivity, SurfaceHolder paramSurfaceHolder) {}
  
  public void run()
  {
    if ((!this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.j) || (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.e)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.jdField_a_of_type_ComTencentBizQrcodeCameraManager.a(this.jdField_a_of_type_AndroidViewSurfaceHolder, this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.b());
      Message.obtain(this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity$ScannerActivityHandler, 111).sendToTarget();
      return;
    }
    catch (IOException localIOException)
    {
      Message.obtain(this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity$ScannerActivityHandler, 112).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Message.obtain(this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity$ScannerActivityHandler, 112).sendToTarget();
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     btb
 * JD-Core Version:    0.7.0.1
 */