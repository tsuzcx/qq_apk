import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.WeiyunSaveTipsFactory.1;

public class awpm
  implements View.OnTouchListener
{
  public awpm(WeiyunSaveTipsFactory.1 param1) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      QLog.d("hehe", 2, new Object[] { "", "toast touch event" });
      awpl.a(this.a.val$app, this.a.val$activity, this.a.val$activity.getApplicationContext());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpm
 * JD-Core Version:    0.7.0.1
 */