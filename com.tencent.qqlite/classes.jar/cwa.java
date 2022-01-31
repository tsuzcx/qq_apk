import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.QZoneManager.FeedType;
import com.tencent.mobileqq.servlet.QZoneManagerImp;

public class cwa
  extends BroadcastReceiver
{
  public cwa(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    if (paramIntent.getAction().equals("com.tencent.qzone.cleanunreadcount"))
    {
      i = paramIntent.getIntExtra("clean_unread_feed_type", -1);
      paramContext = (QZoneManagerImp)this.a.getManager(9);
      if (paramContext != null)
      {
        if (i != 0) {
          break label62;
        }
        if (paramContext.a(QZoneManager.FeedType.friendSpace) > 0) {
          paramContext.a(QZoneManager.FeedType.friendSpace, 0, 0L, null);
        }
      }
    }
    label62:
    while ((i != 1) || (paramContext.a(QZoneManager.FeedType.mySpacefeed) <= 0)) {
      return;
    }
    paramContext.a(QZoneManager.FeedType.mySpacefeed, 0, 0L, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cwa
 * JD-Core Version:    0.7.0.1
 */