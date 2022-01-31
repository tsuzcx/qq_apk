package com.tencent.token.ui;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Button;
import com.tencent.token.ui.base.by;
import com.tencent.token.utils.x;

class afp
  implements GestureDetector.OnGestureListener
{
  afp(WelcomeActivity paramWelcomeActivity) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    try
    {
      if (paramMotionEvent1.getX() - paramMotionEvent2.getX() > 0.0F)
      {
        if (WelcomeActivity.access$100(this.a) >= WelcomeActivity.access$200() - 1) {
          break label231;
        }
        paramMotionEvent1 = x.a(this.a, WelcomeActivity.access$300()[WelcomeActivity.access$104(this.a)], WelcomeActivity.access$400(this.a));
        if (paramMotionEvent1 == null)
        {
          WelcomeActivity.access$500(this.a);
          return true;
        }
        WelcomeActivity.access$600(this.a).a(paramMotionEvent1);
        if ((WelcomeActivity.access$100(this.a) != WelcomeActivity.access$200() - 1) || (WelcomeActivity.access$700(this.a) == null)) {
          break label231;
        }
        WelcomeActivity.access$700(this.a).setVisibility(0);
        return true;
      }
    }
    catch (OutOfMemoryError paramMotionEvent1)
    {
      paramMotionEvent1.printStackTrace();
      WelcomeActivity.access$500(this.a);
      return true;
      if ((paramMotionEvent2.getX() - paramMotionEvent1.getX() <= 0.0F) || (WelcomeActivity.access$100(this.a) <= 0)) {
        break label231;
      }
      paramMotionEvent1 = x.a(this.a, WelcomeActivity.access$300()[WelcomeActivity.access$106(this.a)], WelcomeActivity.access$400(this.a));
      if (paramMotionEvent1 == null)
      {
        WelcomeActivity.access$500(this.a);
        return true;
      }
    }
    catch (Exception paramMotionEvent1)
    {
      paramMotionEvent1.printStackTrace();
      WelcomeActivity.access$500(this.a);
      return true;
    }
    WelcomeActivity.access$600(this.a).b(paramMotionEvent1);
    WelcomeActivity.access$700(this.a).setVisibility(8);
    label231:
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afp
 * JD-Core Version:    0.7.0.1
 */