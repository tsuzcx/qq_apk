import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;

class oaj
  implements Animation.AnimationListener
{
  oaj(oac paramoac) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.s.setVisibility(8);
    this.this$0.nn.setVisibility(8);
    ((ViewGroup)this.this$0.nn.getParent()).removeView(this.this$0.nn);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.this$0.bdA > 0) && (this.this$0.aji > 0)) {
      ((ImageView)((Activity)this.this$0.mContext.get()).findViewById(2131373775)).setLayoutParams(new LinearLayout.LayoutParams(this.this$0.aji, this.this$0.bdA));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oaj
 * JD-Core Version:    0.7.0.1
 */