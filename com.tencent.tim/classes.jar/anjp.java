import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import org.json.JSONException;
import org.json.JSONObject;

class anjp
  extends BroadcastReceiver
{
  anjp(anjo paramanjo) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      paramContext = paramIntent.getStringExtra("event");
      if (paramContext != null)
      {
        paramIntent = paramIntent.getStringExtra("data");
        if ((paramIntent != null) && (paramContext.equals("ShortVideoHongbaoInfoUpdate"))) {
          try
          {
            paramContext = new JSONObject(paramIntent);
            paramIntent = paramContext.optString("shortVideoId");
            boolean bool = paramContext.optBoolean("isPaid");
            if ((anjo.a(this.this$0) != null) && (anjo.a(this.this$0).redBagStat != 1) && (bool) && (anjo.a(this.this$0).shortVideoId.equals(paramIntent)))
            {
              new anjo.b(this.this$0).execute(new String[0]);
              return;
            }
          }
          catch (JSONException paramContext) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjp
 * JD-Core Version:    0.7.0.1
 */