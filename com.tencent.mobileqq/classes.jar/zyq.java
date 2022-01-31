import android.widget.TextView;
import com.tencent.mobileqq.ar.ARRecord.ARRecordUtils;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy;

public class zyq
  implements Runnable
{
  public zyq(ARVideoRecordViewProxy paramARVideoRecordViewProxy, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ARVideoRecordViewProxy.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy).setText(ARRecordUtils.a(this.jdField_a_of_type_Int / 1000));
    ARVideoRecordViewProxy.b(this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewProxy).setText(ARRecordUtils.b(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyq
 * JD-Core Version:    0.7.0.1
 */