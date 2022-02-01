import android.view.View;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.AssociatedAccountActivity.14.1;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class ugl
  implements auuo
{
  public ugl(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.this$0.aRs)
    {
      this.this$0.a.pn();
      return;
    }
    this.this$0.a.Q(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.this$0.aRs) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onViewCompleteVisableAndReleased begin refresh");
    }
    if (this.this$0.QN())
    {
      this.this$0.a.S(0L);
      this.this$0.aRt = true;
      AssociatedAccountActivity.b(this.this$0, false, true);
      return true;
    }
    this.this$0.a.tT(1);
    this.this$0.b.postDelayed(new AssociatedAccountActivity.14.1(this), 800L);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.this$0.aRs) {
      return;
    }
    this.this$0.a.R(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugl
 * JD-Core Version:    0.7.0.1
 */