import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.open.agent.SwitchAccountActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class arsx
  extends GestureDetector.SimpleOnGestureListener
{
  arsx(arsw paramarsw) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Math.abs(paramFloat1) > Math.abs(paramFloat2))
    {
      bool1 = bool2;
      if (Math.abs(paramFloat1) > 20.0F)
      {
        bool1 = bool2;
        if (!this.a.a.aQV)
        {
          this.a.a.aQV = true;
          if (this.a.rk != null) {
            this.a.rk.setPressed(false);
          }
          if ((paramFloat1 < -20.0F) && (this.a.iM != null))
          {
            paramMotionEvent1 = (View)this.a.iM.get();
            if (paramMotionEvent1 != null)
            {
              paramMotionEvent1 = paramMotionEvent1.findViewById(2131378161);
              if ((paramMotionEvent1 != null) && (paramMotionEvent1.getVisibility() == 0)) {
                ((ShaderAnimLayout)paramMotionEvent1).hide();
              }
            }
            this.a.iM = null;
          }
          if (paramFloat1 > 20.0F)
          {
            if ((this.a.iM == null) || (this.a.iM.get() == null)) {
              break label245;
            }
            paramMotionEvent1 = (View)this.a.iM.get();
            if (paramMotionEvent1 != this.a.rk)
            {
              paramMotionEvent1 = paramMotionEvent1.findViewById(2131378161);
              if ((paramMotionEvent1 != null) && (paramMotionEvent1.getVisibility() == 0)) {
                ((ShaderAnimLayout)paramMotionEvent1).hide();
              }
            }
            this.a.iM = null;
          }
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label245:
      if (this.a.rk != null)
      {
        paramMotionEvent1 = this.a.rk.findViewById(2131378161);
        if ((paramMotionEvent1 != null) && (paramMotionEvent1.getVisibility() != 0))
        {
          if (QLog.isColorLevel()) {
            QLog.i("AccountManage", 2, "show current selectedAccountView");
          }
          ((ShaderAnimLayout)paramMotionEvent1).show();
          this.a.iM = new WeakReference(this.a.rk);
          this.a.rk = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsx
 * JD-Core Version:    0.7.0.1
 */