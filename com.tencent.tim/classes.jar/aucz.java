import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.widget.DragView.b;

class aucz
  implements DragView.b
{
  aucz(aucv paramaucv) {}
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    aucv.a(this.this$0, true);
    Drawable localDrawable;
    if (aucv.a(this.this$0) != null)
    {
      localDrawable = aucv.a(this.this$0).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(0);
      }
    }
    if (aucv.b(this.this$0) != null)
    {
      localDrawable = aucv.b(this.this$0).getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      aucv.a(this.this$0).setVisibility(8);
      aucv.c(this.this$0).setVisibility(8);
      this.this$0.kp.setVisibility(8);
    }
  }
  
  public void onGestureFinish()
  {
    aucv.a(this.this$0, false);
    this.this$0.mContext.overridePendingTransition(0, 0);
  }
  
  public void onResetPosition()
  {
    aucv.a(this.this$0, false);
    if (aucv.a(this.this$0)) {
      this.this$0.JW(true);
    }
    if (aucv.b(this.this$0)) {
      this.this$0.JX(true);
    }
    if (aucv.c(this.this$0)) {
      this.this$0.JK(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucz
 * JD-Core Version:    0.7.0.1
 */