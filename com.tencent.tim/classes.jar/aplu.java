import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.b;

public class aplu
  extends BroadcastReceiver
{
  public aplu(HWReciteItem paramHWReciteItem) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tnecnet.mobileqq.homework.recite.stopAudio".equals(paramIntent.getAction())) && (HWReciteItem.a(this.this$0)) && (this.this$0.a != null) && (this.this$0.a.a != null))
    {
      this.this$0.stopAudio();
      this.this$0.a.a.eaC();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aplu
 * JD-Core Version:    0.7.0.1
 */