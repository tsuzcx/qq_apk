import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.PushRecommendBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class wkd
  implements AbsListView.OnScrollListener
{
  public wkd(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (SystemMsgListView.a(this.a) != null)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        SystemMsgListView.a(this.a).f();
      }
    }
    else {
      return;
    }
    SystemMsgListView.a(this.a).g();
    SystemMsgListView.a(this.a).e();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.newfriendSystemMsgListView", 2, "onScroll firstVisibleItem: " + paramInt1 + " visibleItemCount: " + paramInt2 + " totalItemCount: " + paramInt3);
    }
    SystemMsgListView.a(this.a, paramInt1);
    if (paramInt1 >= 1)
    {
      paramAbsListView = (NewFriendBaseBuilder)SystemMsgListView.a(this.a).getItem(paramInt1 - 1);
      if ((paramAbsListView instanceof PushRecommendBuilder)) {
        ((PushRecommendBuilder)paramAbsListView).c();
      }
    }
    if (paramInt1 + paramInt2 < paramInt3)
    {
      paramAbsListView = (NewFriendBaseBuilder)SystemMsgListView.a(this.a).getItem(paramInt1 + paramInt2);
      if ((paramAbsListView instanceof PushRecommendBuilder)) {
        ((PushRecommendBuilder)paramAbsListView).c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wkd
 * JD-Core Version:    0.7.0.1
 */