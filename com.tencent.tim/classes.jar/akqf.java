import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

class akqf
  implements View.OnTouchListener
{
  private float mTouchDownX;
  private float mTouchDownY;
  private long zP;
  
  akqf(akqe paramakqe) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    akqe.g localg;
    float f2;
    float f1;
    if (akqe.a(this.c) != null)
    {
      paramView = (akqe.f)akqe.a(this.c).getTag(2131362928);
      localg = (akqe.g)akqe.a(this.c).getTag();
      if ((paramView != null) && (localg != null))
      {
        f2 = paramMotionEvent.getX();
        f1 = paramMotionEvent.getY();
      }
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          do
          {
            return true;
            this.mTouchDownX = f2;
            this.mTouchDownY = f1;
            this.zP = System.currentTimeMillis();
          } while ((paramView.mTag != 1) || (paramView.mType != 2));
          localg.eo.setPressed(true);
          return true;
        } while ((paramView.mTag != 1) || (paramView.mType != 2));
        f2 -= this.mTouchDownX;
        f1 -= this.mTouchDownY;
      } while ((float)Math.sqrt(f2 * f2 + f1 * f1) < akqe.a(this.c).getScaledTouchSlop());
      localg.eo.setPressed(false);
      return true;
    case 1: 
      f2 -= this.mTouchDownX;
      f1 -= this.mTouchDownY;
      f2 = (float)Math.sqrt(f2 * f2 + f1 * f1);
      long l1 = System.currentTimeMillis();
      long l2 = this.zP;
      if (f2 < akqe.a(this.c).getScaledTouchSlop()) {
        if (paramView.mType == 2)
        {
          akqe.a(this.c).removeMessages(101);
          akqe.a(this.c).obtainMessage(101).sendToTarget();
          if (paramView.a != null) {
            paramView.a.cTm();
          }
        }
      }
      for (;;)
      {
        this.mTouchDownX = 0.0F;
        this.mTouchDownY = 0.0F;
        this.zP = 0L;
        localg.eo.setPressed(false);
        return true;
        if ((f2 > akqe.a(this.c).getScaledTouchSlop()) && (f1 > 50.0F) && ((float)(l1 - l2) < 300.0F) && (paramView.mTag == 1))
        {
          akqe.a(this.c).removeMessages(101);
          akqe.a(this.c).obtainMessage(101).sendToTarget();
        }
      }
    }
    this.mTouchDownX = 0.0F;
    this.mTouchDownY = 0.0F;
    this.zP = 0L;
    localg.eo.setPressed(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqf
 * JD-Core Version:    0.7.0.1
 */