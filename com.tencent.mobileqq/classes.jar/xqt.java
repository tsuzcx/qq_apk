import android.view.View;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class xqt
  implements ActionSheet.OnButtonClickListener
{
  public xqt(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a("PTV.NewFlowCameraActivity");
    NewFlowCameraActivity.e(this.a);
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqt
 * JD-Core Version:    0.7.0.1
 */