import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.biz.qrcode.CodeMaskManager.Callback;
import java.util.concurrent.atomic.AtomicBoolean;

public class blh
  implements Runnable
{
  public blh(CodeMaskManager paramCodeMaskManager, bli parambli, CodeMaskManager.Callback paramCallback) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager.a) {}
    while (!this.jdField_a_of_type_Bli.a.compareAndSet(false, true)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$Callback.a(CodeMaskManager.a(this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager));
    CodeMaskManager.a(this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blh
 * JD-Core Version:    0.7.0.1
 */