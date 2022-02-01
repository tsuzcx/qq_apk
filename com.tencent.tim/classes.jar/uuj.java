import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import java.util.ArrayList;

public class uuj
  extends BroadcastReceiver
{
  public uuj(DirectForwardActivity paramDirectForwardActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      paramContext = paramIntent.getStringArrayList("procNameList");
      paramIntent = paramIntent.getString("verify");
      if ((paramContext != null) && (paramContext.size() != 0) && (this.this$0.aMG != null) && (aqcv.isLegalBroadcast(paramIntent, paramContext))) {
        break label53;
      }
    }
    for (;;)
    {
      return;
      label53:
      int i = 0;
      while (i < paramContext.size())
      {
        if (this.this$0.aMG.equals(paramContext.get(i)))
        {
          this.this$0.finish();
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uuj
 * JD-Core Version:    0.7.0.1
 */