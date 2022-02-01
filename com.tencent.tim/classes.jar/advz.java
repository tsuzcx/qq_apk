import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

public class advz
  implements View.OnTouchListener
{
  public advz(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.this$0.bwW) {
      bool = false;
    }
    do
    {
      return bool;
      if ((paramView == this.this$0.yn) || (paramView == this.this$0.h)) {}
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        return false;
      case 0: 
        this.this$0.fN.setVisibility(4);
        this.this$0.fO.setVisibility(4);
        this.this$0.QO.setText("0\"");
        this.this$0.QO.setVisibility(0);
        this.this$0.QP.setVisibility(4);
        this.this$0.OU.setVisibility(4);
        this.this$0.QQ.setVisibility(4);
        this.this$0.yn.setVisibility(4);
        this.this$0.yo.setVisibility(0);
        this.this$0.h.setVisibility(0);
        this.this$0.QR.setVisibility(4);
        this.this$0.h.setProgress(0.0F);
        this.this$0.c.mStartTime = System.currentTimeMillis();
        this.this$0.c.cyg();
        if (this.this$0.mSource == 1) {}
        for (int i = 0;; i = 1)
        {
          anot.a(null, "dc00898", "", "", "0X8007106", "0X8007106", i, 0, "", "", "", "");
          return true;
        }
      }
      if (!this.this$0.c.Xb()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("DynamicAvatarRecordActivity", 2, "ACTION_UP, current state is already preview!");
    return true;
    if (this.this$0.c != null) {
      this.this$0.c.Xf();
    }
    if (System.currentTimeMillis() - this.this$0.c.mStartTime < 500L)
    {
      this.this$0.c.CY(false);
      this.this$0.c.cyf();
      DynamicAvatarRecordActivity.a(this.this$0);
      return true;
    }
    DynamicAvatarRecordActivity.b(this.this$0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advz
 * JD-Core Version:    0.7.0.1
 */