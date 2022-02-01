import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;

public class zcv
  extends auqs.a
{
  public zcv(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.L(true);
    EmoticonGroupStoreFragment.a(this.this$0, false);
    this.this$0.titleRoot.removeView(EmoticonGroupStoreFragment.a(this.this$0));
    this.this$0.titleRoot.removeView(EmoticonGroupStoreFragment.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zcv
 * JD-Core Version:    0.7.0.1
 */