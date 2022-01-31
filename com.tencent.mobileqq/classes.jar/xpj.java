import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.concurrent.atomic.AtomicInteger;

public class xpj
  implements Runnable
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  final int[] jdField_a_of_type_ArrayOfInt = { 255, 191, 127, 63, 0, 63, 127, 191 };
  
  public xpj(FlowCameraActivity2 paramFlowCameraActivity2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramFlowCameraActivity2.a.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int %= 32;
  }
  
  public void run()
  {
    Drawable[] arrayOfDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.b.getCompoundDrawables();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.v();
    }
    if (arrayOfDrawable[0] != null) {
      arrayOfDrawable[0].setAlpha(this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_Int / 4)]);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.a.b.get() == 2) && (arrayOfDrawable[0] != null))
    {
      arrayOfDrawable[0].setAlpha(255);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.a(arrayOfDrawable[0], -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpj
 * JD-Core Version:    0.7.0.1
 */