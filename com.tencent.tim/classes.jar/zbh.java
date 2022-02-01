import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout.b;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout.c;

public class zbh
  extends CommonRefreshLayout.b
{
  public zbh(CommonRefreshLayout paramCommonRefreshLayout)
  {
    super(paramCommonRefreshLayout);
  }
  
  public void o(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((CommonRefreshLayout.a(this.this$0) != null) && ((CommonRefreshLayout.a(this.this$0) instanceof zbk)) && (CommonRefreshLayout.c.access$400(CommonRefreshLayout.a(this.this$0))))
    {
      if (CommonRefreshLayout.a(this.this$0).getVisibility() != 0) {
        CommonRefreshLayout.a(this.this$0).setVisibility(0);
      }
      ((zbk)CommonRefreshLayout.a(this.this$0)).o(paramInt, paramBoolean1, paramBoolean2);
    }
  }
  
  public void onPrepare()
  {
    if ((CommonRefreshLayout.a(this.this$0) != null) && ((CommonRefreshLayout.a(this.this$0) instanceof zbk)) && ((CommonRefreshLayout.c.access$000(CommonRefreshLayout.a(this.this$0))) || (CommonRefreshLayout.c.hi(CommonRefreshLayout.a(this.this$0)))))
    {
      CommonRefreshLayout.a(this.this$0).setVisibility(0);
      ((zbk)CommonRefreshLayout.a(this.this$0)).onPrepare();
    }
  }
  
  public void onRefresh()
  {
    if ((CommonRefreshLayout.a(this.this$0) != null) && (CommonRefreshLayout.c.he(CommonRefreshLayout.a(this.this$0))))
    {
      if ((CommonRefreshLayout.a(this.this$0) instanceof zbj)) {
        ((zbj)CommonRefreshLayout.a(this.this$0)).onRefresh();
      }
      if (CommonRefreshLayout.a(this.this$0) != null) {
        CommonRefreshLayout.a(this.this$0).onRefresh();
      }
    }
  }
  
  public void onRelease()
  {
    if ((CommonRefreshLayout.a(this.this$0) != null) && ((CommonRefreshLayout.a(this.this$0) instanceof zbk)) && (CommonRefreshLayout.c.access$600(CommonRefreshLayout.a(this.this$0)))) {
      ((zbk)CommonRefreshLayout.a(this.this$0)).onRelease();
    }
  }
  
  public void onReset()
  {
    if ((CommonRefreshLayout.a(this.this$0) != null) && ((CommonRefreshLayout.a(this.this$0) instanceof zbk)) && ((CommonRefreshLayout.c.access$000(CommonRefreshLayout.a(this.this$0))) || (CommonRefreshLayout.c.hi(CommonRefreshLayout.a(this.this$0))))) {
      ((zbk)CommonRefreshLayout.a(this.this$0)).onReset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zbh
 * JD-Core Version:    0.7.0.1
 */