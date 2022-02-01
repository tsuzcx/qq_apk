import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.open.agent.SwitchAccountActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class arsw
  implements View.OnTouchListener
{
  protected GestureDetector.SimpleOnGestureListener a;
  WeakReference<View> iM;
  protected GestureDetector mGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
  View rk;
  
  public arsw(SwitchAccountActivity paramSwitchAccountActivity)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new arsx(this);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("AccountManage", 2, "action = " + i);
    }
    if (i == 0)
    {
      this.rk = paramView;
      if (this.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity.aQV == true) {
        this.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity.aQV = false;
      }
    }
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsw
 * JD-Core Version:    0.7.0.1
 */