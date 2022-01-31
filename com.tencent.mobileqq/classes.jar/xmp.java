import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class xmp
  implements View.OnLayoutChangeListener
{
  public xmp(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.e.removeOnLayoutChangeListener(this);
    NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, this.jdField_a_of_type_Int, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.e.addOnLayoutChangeListener(new xmq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xmp
 * JD-Core Version:    0.7.0.1
 */