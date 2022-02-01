import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class xzc
  implements View.OnTouchListener
{
  long lastClickTime = 0L;
  
  xzc(xys paramxys) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.this$0.aSN) || (!(paramView instanceof ImageView))) {
      return false;
    }
    Object localObject = (ImageView)paramView;
    int i = paramMotionEvent.getAction();
    localObject = null;
    paramMotionEvent = (MotionEvent)localObject;
    if (paramView.getTag() != null)
    {
      paramMotionEvent = (MotionEvent)localObject;
      if ((paramView.getTag() instanceof ajoh)) {
        paramMotionEvent = (ajoh)paramView.getTag();
      }
    }
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      if (paramMotionEvent != null)
      {
        paramView.setAlpha(paramMotionEvent.bg() * 0.5F);
      }
      else
      {
        paramView.setAlpha(0.5F);
        continue;
        if (paramMotionEvent != null) {
          paramView.setAlpha(paramMotionEvent.bg());
        }
        while (System.currentTimeMillis() - this.lastClickTime < 800L)
        {
          return true;
          paramView.setAlpha(1.0F);
        }
        this.lastClickTime = System.currentTimeMillis();
        paramView = new Intent(this.this$0.mActivity, QQBrowserActivity.class);
        localObject = aelb.b().kj(this.this$0.sessionInfo.aTl);
        ajnk.a(this.this$0.app, this.this$0.sessionInfo.aTl, paramMotionEvent);
        paramView.putExtra("url", (String)localObject);
        paramView.putExtra("finish_animation_out_to_right", true);
        paramView.putExtra("is_wrap_content", true);
        paramView.putExtra("hide_left_button", false);
        if (this.this$0.mActivity != null)
        {
          this.this$0.mActivity.startActivity(paramView);
          continue;
          if (paramMotionEvent != null) {
            paramView.setAlpha(paramMotionEvent.bg());
          } else {
            paramView.setAlpha(1.0F);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzc
 * JD-Core Version:    0.7.0.1
 */