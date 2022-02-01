import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qphone.base.util.QLog;

public class ucf
  implements View.OnTouchListener
{
  private GestureDetector.SimpleOnGestureListener a = new ucg(this);
  private GestureDetector mGestureDetector = new GestureDetector(this.a);
  View rk;
  
  public ucf(AccountManageActivity paramAccountManageActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("AccountManage", 2, "action = " + i);
    }
    if (i == 0)
    {
      this.rk = paramView;
      if (this.this$0.aQV == true) {
        this.this$0.aQV = false;
      }
    }
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel()) {
      QLog.i("AccountManage", 2, "onTouch return mHasSlide " + this.this$0.aQV);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucf
 * JD-Core Version:    0.7.0.1
 */