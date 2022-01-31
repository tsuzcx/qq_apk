import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
import java.util.concurrent.atomic.AtomicInteger;

public class xrn
  implements Runnable
{
  public xrn(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() != 4))
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label85;
      }
      if (this.jdField_a_of_type_Boolean) {
        break label54;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label54:
    label85:
    do
    {
      do
      {
        do
        {
          return;
        } while (this.b);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
      } while (this.jdField_a_of_type_Int != 1);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
      }
    } while ((this.b) || (NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity)));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_JavaLangString.equalsIgnoreCase(GestureFilterManager.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = GestureRecognitionUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, GestureFilterManager.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_JavaLangString = GestureFilterManager.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_d_of_type_AndroidWidgetTextView.setText(GestureFilterManager.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrn
 * JD-Core Version:    0.7.0.1
 */