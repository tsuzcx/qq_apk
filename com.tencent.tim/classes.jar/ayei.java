import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

class ayei
  implements View.OnTouchListener
{
  ayei(ayeh paramayeh) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (ayeh.a(this.this$0) == null)
    {
      if (this.this$0.b.a == null) {
        return false;
      }
      ayeh.a(this.this$0, this.this$0.b.a.a());
    }
    if (this.this$0.a != null) {
      this.this$0.a.setTipsGone();
    }
    if (ayeh.a(this.this$0).aQO()) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    while ((this.this$0.dyJ) || (ayeh.a(this.this$0).getVisibility() == 8))
    {
      return false;
      this.this$0.mDownX = paramMotionEvent.getX();
      this.this$0.mDownY = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((Math.abs(f1 - this.this$0.mDownX) < 10.0F) && (Math.abs(f2 - this.this$0.mDownY) < 10.0F))
      {
        paramView = (aydg)this.this$0.a(aydg.class);
        if (paramView != null) {
          paramView.KS();
        }
      }
    }
    return ayeh.a(this.this$0).O(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayei
 * JD-Core Version:    0.7.0.1
 */