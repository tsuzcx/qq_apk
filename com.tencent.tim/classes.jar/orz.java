import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout.a;

class orz
  implements WSVerticalVideoRelativeLayout.a
{
  orz(ory paramory, Runnable paramRunnable) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    Object localObject;
    float f3;
    float f4;
    float f2;
    if (ory.a(this.this$0) != null)
    {
      localObject = new Rect();
      ory.a(this.this$0).f((Rect)localObject);
      if ((ory.a(this.this$0)) || ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getX() > ((Rect)localObject).left) && (paramMotionEvent.getX() < ((Rect)localObject).right) && (paramMotionEvent.getY() >= ((Rect)localObject).top - ankt.dip2px(10.0F)) && (paramMotionEvent.getY() <= ((Rect)localObject).bottom + ankt.dip2px(10.0F))))
      {
        if (!ory.a(this.this$0))
        {
          ory.a(this.this$0, true);
          ory.a(this.this$0).J(this.df);
          ory.a(this.this$0).setSeekBarActivated(true);
          ory.a(this.this$0).setThumb(ory.b(this.this$0).getDrawable(2130842638));
          ory.a(this.this$0).requestDisallowInterceptTouchEvent(true);
        }
        f3 = ((Rect)localObject).top;
        f4 = ((Rect)localObject).height() / 2.0F;
        f2 = paramMotionEvent.getX() - ((Rect)localObject).left;
        if (f2 >= 0.0F) {}
      }
    }
    for (;;)
    {
      localObject = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), f1, f3 + f4, paramMotionEvent.getMetaState());
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        ory.a(this.this$0).postDelayed(this.df, 1000L);
        ory.a(this.this$0, false);
        ory.a(this.this$0).requestDisallowInterceptTouchEvent(false);
      }
      ory.a(this.this$0).D((MotionEvent)localObject);
      return true;
      if (f2 > ((Rect)localObject).width())
      {
        f1 = ((Rect)localObject).width();
        continue;
        return false;
      }
      else
      {
        f1 = f2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orz
 * JD-Core Version:    0.7.0.1
 */