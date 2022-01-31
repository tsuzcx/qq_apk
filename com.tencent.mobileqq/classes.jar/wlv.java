import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class wlv
  extends AnimateUtils.AnimationAdapter
{
  public wlv(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a(true);
    EmoticonGroupStoreFragment.a(this.a, false);
    this.a.a.removeView(EmoticonGroupStoreFragment.a(this.a));
    this.a.a.removeView(EmoticonGroupStoreFragment.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wlv
 * JD-Core Version:    0.7.0.1
 */