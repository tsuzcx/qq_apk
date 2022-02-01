import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.RadioGroup;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView;
import java.util.List;

public class sjl
  implements ViewPager.OnPageChangeListener
{
  public sjl(RelativePersonalBottomView paramRelativePersonalBottomView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    
    if ((RelativePersonalBottomView.a(this.this$0) != null) && (RelativePersonalBottomView.a(this.this$0).getChildCount() > paramInt)) {
      RelativePersonalBottomView.a(this.this$0).getChildAt(paramInt).performClick();
    }
    if (RelativePersonalBottomView.a(this.this$0).size() > paramInt) {
      ((SubscribeBaseBottomPersonalFragment)RelativePersonalBottomView.a(this.this$0).get(paramInt)).yr(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjl
 * JD-Core Version:    0.7.0.1
 */