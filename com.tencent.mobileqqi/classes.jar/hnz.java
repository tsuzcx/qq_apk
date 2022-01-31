import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.open.agent.SwitchAccountActivity;
import com.tencent.qphone.base.util.QLog;

class hnz
  extends GestureDetector.SimpleOnGestureListener
{
  hnz(hny paramhny) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (Math.abs(paramFloat1) > 20.0F) && (!this.a.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity.a))
    {
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        paramMotionEvent1 = this.a.jdField_a_of_type_AndroidViewView.findViewById(2131230987);
        if (paramMotionEvent1 != null)
        {
          if (paramMotionEvent1.getVisibility() == 0) {
            break label115;
          }
          if (QLog.isColorLevel()) {
            QLog.i("AccountManage", 2, "show current selectedAccountView");
          }
          ((ShaderAnimLayout)paramMotionEvent1).a();
          this.a.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity.a = true;
          this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
        }
      }
      for (;;)
      {
        return true;
        label115:
        ((ShaderAnimLayout)paramMotionEvent1).d();
        this.a.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity.a = true;
        this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hnz
 * JD-Core Version:    0.7.0.1
 */