import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.widget.MaxHeightScrollView;

public class arow
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public arow(AuthorityActivity paramAuthorityActivity) {}
  
  public void onGlobalLayout()
  {
    if ((DisplayUtil.hasNavBar(this.this$0)) && (DisplayUtil.isNavigationBarExist(this.this$0)))
    {
      i = AuthorityActivity.a(this.this$0).getMaxHeight();
      int j = DisplayUtil.getNavigationBarHeight(this.this$0);
      AuthorityActivity.a(this.this$0).setMaxHeight(i - j);
    }
    int i = ((View)this.this$0.findViewById(2131377546).getParent()).getTop();
    if (i > 0) {
      AuthorityActivity.a(this.this$0).setMaxHeight(AuthorityActivity.a(this.this$0).getMaxHeight() - i);
    }
    AuthorityActivity.a(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arow
 * JD-Core Version:    0.7.0.1
 */