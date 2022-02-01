import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import java.util.ArrayList;

public class aowi
  extends BroadcastReceiver
{
  public aowi(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("key_photo_delete_action".equals(paramContext))
    {
      int i = paramIntent.getIntExtra("key_photo_delete_position", -1);
      if ((i >= 0) && (i < this.this$0.cu.size())) {
        this.this$0.cu.remove(i);
      }
    }
    do
    {
      do
      {
        return;
        if (!"key_audio_delete_action".equals(paramContext)) {
          break;
        }
        this.this$0.a = null;
        this.this$0.b.removeAllItem();
      } while (!this.this$0.cPd);
      aprv.d(this.this$0.cmV, this.this$0.mOpType, "del_record", this.this$0.mBid, "", "", "");
      return;
    } while (!"key_photo_add_action".equals(paramContext));
    this.this$0.dXn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aowi
 * JD-Core Version:    0.7.0.1
 */