import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.open.widget.MaxHeightScrollView;

public class arsn
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public arsn(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onGlobalLayout()
  {
    if ((DisplayUtil.hasNavBar(this.this$0)) && (DisplayUtil.isNavigationBarExist(this.this$0)))
    {
      int i = QuickLoginAuthorityActivity.a(this.this$0).getMaxHeight();
      int j = DisplayUtil.getNavigationBarHeight(this.this$0);
      QuickLoginAuthorityActivity.a(this.this$0).setMaxHeight(i - j);
    }
    QuickLoginAuthorityActivity.a(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsn
 * JD-Core Version:    0.7.0.1
 */