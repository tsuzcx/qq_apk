import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;

public class ldn
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ldn(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, ReadInJoyStaticGridView paramReadInJoyStaticGridView, View paramView) {}
  
  public void onGlobalLayout()
  {
    if (this.a.getHeight() > 0) {
      if (this.kg.getVisibility() == 8) {
        this.kg.setVisibility(0);
      }
    }
    while (this.kg.getVisibility() != 0) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(400L);
    localAlphaAnimation.setAnimationListener(new ldo(this));
    this.kg.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ldn
 * JD-Core Version:    0.7.0.1
 */