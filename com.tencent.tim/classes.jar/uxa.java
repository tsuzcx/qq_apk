import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uxa
  implements View.OnClickListener
{
  public uxa(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.app != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(this.this$0.getIntent().getExtras());
      localIntent.putExtra("extra_choose_friend_uin", this.this$0.app.getAccount());
      localIntent.putExtra("extra_choose_friend_name", this.this$0.app.getCurrentNickname());
      this.this$0.setResult(-1, localIntent);
      this.this$0.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uxa
 * JD-Core Version:    0.7.0.1
 */