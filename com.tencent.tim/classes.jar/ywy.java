import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class ywy
  implements View.OnClickListener
{
  public ywy(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    int i = anze.a().af(this.this$0.app);
    MqqHandler localMqqHandler1 = this.this$0.app.getHandler(NotificationView.class);
    MqqHandler localMqqHandler2 = this.this$0.app.getHandler(TroopNotifyAndRecommendView.class);
    if (localMqqHandler1 != null) {
      localMqqHandler1.sendEmptyMessage(1014);
    }
    if (localMqqHandler2 != null) {
      localMqqHandler2.sendEmptyMessage(1014);
    }
    this.this$0.app.a().G(acbn.bkT, 9000, -i);
    ((ackm)this.this$0.app.getManager(33)).Q(acbn.bkT, 9000);
    localMqqHandler1 = this.this$0.app.getHandler(Conversation.class);
    if (localMqqHandler1 != null) {
      localMqqHandler1.sendMessage(localMqqHandler1.obtainMessage(1009));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywy
 * JD-Core Version:    0.7.0.1
 */