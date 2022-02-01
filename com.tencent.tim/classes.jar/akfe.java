import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class akfe
  implements Animation.AnimationListener
{
  akfe(akef paramakef) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == akef.b(this.this$0))
    {
      akef.a(this.this$0).setVisibility(8);
      akef.a(this.this$0).setVisibility(4);
      akef.a(this.this$0).clearAnimation();
      akef.a(this.this$0).clearAnimation();
      akef.a(this.this$0).setBackgroundResource(2130850013);
      akef.a(this.this$0).setTextColor(this.this$0.a.getResources().getColor(2131166970));
      akef.b(this.this$0).setTextColor(this.this$0.a.getResources().getColor(2131166970));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == akef.a(this.this$0))
    {
      akef.a(this.this$0).setVisibility(0);
      akef.a(this.this$0).setVisibility(0);
      akef.a(this.this$0).setBackgroundResource(2130851758);
      akef.a(this.this$0).setTextColor(this.this$0.a.getResources().getColor(2131167298));
      akef.b(this.this$0).setTextColor(this.this$0.a.getResources().getColor(2131167298));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akfe
 * JD-Core Version:    0.7.0.1
 */