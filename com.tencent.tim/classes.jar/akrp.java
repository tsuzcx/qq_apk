import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.widget.SwipListView.a;

public class akrp
  implements SwipListView.a
{
  public akrp(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onRightIconMenuHide(View paramView)
  {
    if (AccountOnlineStateActivity.a(this.this$0) != null) {
      AccountOnlineStateActivity.a(this.this$0).setInterceptTouchFlag(true);
    }
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    if (AccountOnlineStateActivity.a(this.this$0) != null) {
      AccountOnlineStateActivity.a(this.this$0).setInterceptTouchFlag(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akrp
 * JD-Core Version:    0.7.0.1
 */