import android.view.View;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class zgw
  implements auuo
{
  public zgw(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.this$0.KW == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.this$0.KW)
    {
      paramView.Q(l);
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewCompleteVisableAndReleased");
    }
    paramView = (PullRefreshHeader)paramView;
    if (this.this$0.KW == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.this$0.KW)
    {
      paramView.S(l);
      if (!aqiw.isNetworkAvailable(this.this$0.getActivity())) {
        break;
      }
      ChatHistoryTroopFileFragment.a(this.this$0).jP(0, 0);
      return true;
    }
    ChatHistoryTroopFileFragment.a(this.this$0, 1);
    apsv.A(this.this$0.mApp, ChatHistoryTroopFileFragment.a(this.this$0));
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewCompleteVisable");
    }
    paramView = (PullRefreshHeader)paramView;
    if (this.this$0.KW == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.this$0.KW)
    {
      paramView.R(l);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewNotCompleteVisableAndReleased");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zgw
 * JD-Core Version:    0.7.0.1
 */