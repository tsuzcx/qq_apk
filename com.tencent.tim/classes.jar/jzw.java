import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.PublicAccountBrowser;

public class jzw
  extends auqs.a
{
  public jzw(PublicAccountBrowser paramPublicAccountBrowser, boolean paramBoolean, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.val$isShow)
    {
      this.val$view.setVisibility(0);
      return;
    }
    this.val$view.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzw
 * JD-Core Version:    0.7.0.1
 */