import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.widget.DragView.b;

class agyg
  implements DragView.b
{
  agyg(agyc paramagyc) {}
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    agyc.a(this.this$0, true);
    Drawable localDrawable;
    if (agyc.a(this.this$0) != null)
    {
      localDrawable = agyc.a(this.this$0).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(0);
      }
    }
    if (agyc.b(this.this$0) != null)
    {
      localDrawable = agyc.b(this.this$0).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      agyc.a(this.this$0).setVisibility(8);
      agyc.c(this.this$0).setVisibility(8);
      this.this$0.kp.setVisibility(8);
    }
  }
  
  public void onGestureFinish()
  {
    agyc.a(this.this$0, false);
    this.this$0.a.djZ();
    this.this$0.mContext.overridePendingTransition(0, 0);
  }
  
  public void onResetPosition()
  {
    agyc.a(this.this$0, false);
    if (agyc.a(this.this$0)) {
      this.this$0.JW(true);
    }
    if (agyc.b(this.this$0)) {
      this.this$0.JX(true);
    }
    if (agyc.c(this.this$0)) {
      this.this$0.JK(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agyg
 * JD-Core Version:    0.7.0.1
 */