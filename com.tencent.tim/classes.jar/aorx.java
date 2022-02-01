import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;

public class aorx
  extends BroadcastReceiver
{
  public aorx(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("key_photo_delete_action".equals(paramContext))
    {
      int i = paramIntent.getIntExtra("key_photo_delete_position", -1);
      this.this$0.jM(i, 9);
    }
    do
    {
      return;
      if ("key_audio_delete_action".equals(paramContext))
      {
        this.this$0.Wd(0);
        this.this$0.a = null;
        aprv.d(this.this$0.cmV, this.this$0.mOpType, "del_record", this.this$0.mBid, this.this$0.cmL, "", "");
        return;
      }
    } while (!"key_audio_play_action".equals(paramContext));
    aprv.d(this.this$0.cmV, this.this$0.mOpType, "preview_record", this.this$0.mBid, this.this$0.cmL, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aorx
 * JD-Core Version:    0.7.0.1
 */