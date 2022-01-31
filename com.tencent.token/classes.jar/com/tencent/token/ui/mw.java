package com.tencent.token.ui;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Button;
import com.tencent.token.ui.base.by;
import com.tencent.token.utils.x;

class mw
  implements GestureDetector.OnGestureListener
{
  mw(KnowTokenActivity paramKnowTokenActivity) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    try
    {
      if (paramMotionEvent1.getX() - paramMotionEvent2.getX() > 0.0F) {
        if (KnowTokenActivity.access$000(this.a) < KnowTokenActivity.access$100() - 1)
        {
          paramMotionEvent1 = x.a(this.a, KnowTokenActivity.access$200()[KnowTokenActivity.access$004(this.a)], KnowTokenActivity.access$300(this.a));
          if (paramMotionEvent1 == null)
          {
            KnowTokenActivity.access$400(this.a);
            return true;
          }
          KnowTokenActivity.access$500(this.a).a(paramMotionEvent1);
          if ((KnowTokenActivity.access$000(this.a) != KnowTokenActivity.access$100() - 1) || (KnowTokenActivity.access$600(this.a) == null)) {
            break label250;
          }
          KnowTokenActivity.access$600(this.a).setVisibility(0);
          return true;
        }
      }
    }
    catch (OutOfMemoryError paramMotionEvent1)
    {
      paramMotionEvent1.printStackTrace();
      KnowTokenActivity.access$400(this.a);
      return true;
      this.a.finish();
      return true;
    }
    catch (Exception paramMotionEvent1)
    {
      paramMotionEvent1.printStackTrace();
      KnowTokenActivity.access$400(this.a);
      return true;
    }
    if ((paramMotionEvent2.getX() - paramMotionEvent1.getX() > 0.0F) && (KnowTokenActivity.access$000(this.a) > 0))
    {
      paramMotionEvent1 = x.a(this.a, KnowTokenActivity.access$200()[KnowTokenActivity.access$006(this.a)], KnowTokenActivity.access$300(this.a));
      if (paramMotionEvent1 == null)
      {
        KnowTokenActivity.access$400(this.a);
        return true;
      }
      KnowTokenActivity.access$500(this.a).b(paramMotionEvent1);
      if (KnowTokenActivity.access$600(this.a) != null) {
        KnowTokenActivity.access$600(this.a).setVisibility(8);
      }
    }
    label250:
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
 * Qualified Name:     com.tencent.token.ui.mw
 * JD-Core Version:    0.7.0.1
 */