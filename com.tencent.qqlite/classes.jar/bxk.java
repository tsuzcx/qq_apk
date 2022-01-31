import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import cooperation.troop.TroopProxyActivity;

public class bxk
  implements View.OnClickListener
{
  public bxk(TroopFileItemBuilder paramTroopFileItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    paramView = (Activity)paramView.getContext();
    Intent localIntent = new Intent();
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra(TroopProxyActivity.a, localChatMessage.frienduin);
    TroopProxyActivity.a(paramView, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bxk
 * JD-Core Version:    0.7.0.1
 */