import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;

public class uws
  extends BroadcastReceiver
{
  public uws(FavEmosmManageActivity paramFavEmosmManageActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (FavEmosmManageActivity.a(this.a) != null) {
      FavEmosmManageActivity.a(this.a).O(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uws
 * JD-Core Version:    0.7.0.1
 */