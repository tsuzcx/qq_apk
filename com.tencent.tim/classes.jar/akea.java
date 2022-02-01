import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class akea
  implements Animation.AnimationListener
{
  akea(akcx paramakcx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == akcx.b(this.this$0))
    {
      akcx.a(this.this$0).setVisibility(8);
      akcx.a(this.this$0).clearAnimation();
      akcx.a(this.this$0).setBackgroundResource(2130850013);
      akcx.a(this.this$0).setTextColor(this.this$0.a.getResources().getColor(2131166970));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == akcx.a(this.this$0))
    {
      akcx.a(this.this$0).setVisibility(0);
      akcx.a(this.this$0).setBackgroundResource(2130851758);
      akcx.a(this.this$0).setTextColor(this.this$0.a.getResources().getColor(2131167298));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akea
 * JD-Core Version:    0.7.0.1
 */