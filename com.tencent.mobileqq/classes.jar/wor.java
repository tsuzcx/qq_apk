import android.view.View;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.OnRefreshListener;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.SwipeRefreshTrigger;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.SwipeTrigger;

public class wor
  extends wos
{
  public wor(CommonRefreshLayout paramCommonRefreshLayout)
  {
    super(paramCommonRefreshLayout);
  }
  
  public void a()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof SwipeTrigger)) && (wot.a(CommonRefreshLayout.a(this.a))))
    {
      CommonRefreshLayout.a(this.a).setVisibility(0);
      ((SwipeTrigger)CommonRefreshLayout.a(this.a)).a();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof SwipeTrigger)) && (wot.c(CommonRefreshLayout.a(this.a))))
    {
      if (CommonRefreshLayout.a(this.a).getVisibility() != 0) {
        CommonRefreshLayout.a(this.a).setVisibility(0);
      }
      ((SwipeTrigger)CommonRefreshLayout.a(this.a)).a(paramInt, paramBoolean1, paramBoolean2);
    }
  }
  
  public void b()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof SwipeTrigger)) && (wot.e(CommonRefreshLayout.a(this.a)))) {
      ((SwipeTrigger)CommonRefreshLayout.a(this.a)).b();
    }
  }
  
  public void c()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && (wot.b(CommonRefreshLayout.a(this.a))))
    {
      if ((CommonRefreshLayout.a(this.a) instanceof SwipeRefreshTrigger)) {
        ((SwipeRefreshTrigger)CommonRefreshLayout.a(this.a)).c();
      }
      if (CommonRefreshLayout.a(this.a) != null) {
        CommonRefreshLayout.a(this.a).g();
      }
    }
  }
  
  public void d()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof SwipeTrigger)) && (wot.a(CommonRefreshLayout.a(this.a))))
    {
      ((SwipeTrigger)CommonRefreshLayout.a(this.a)).d();
      CommonRefreshLayout.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wor
 * JD-Core Version:    0.7.0.1
 */