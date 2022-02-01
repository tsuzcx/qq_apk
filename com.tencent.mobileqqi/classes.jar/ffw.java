import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import java.util.ArrayList;

public class ffw
  extends BroadcastReceiver
{
  public ffw(QQMapActivityProxy paramQQMapActivityProxy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("com.tencent.mobileqq.addLbsObserver")) {
      if (QQMapActivityProxy.a(this.a) != null) {
        QQMapActivityProxy.a(this.a).a(QQMapActivityProxy.a(this.a));
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!paramContext.equals("com.tencent.mobileqq.RemoveLbsObserver")) {
            break;
          }
        } while (QQMapActivityProxy.a(this.a) == null);
        QQMapActivityProxy.a(this.a).c(QQMapActivityProxy.a(this.a));
        return;
        if (paramContext.equals("com.tencent.mobileqq.getStreetViewUrl"))
        {
          ((LBSHandler)QQMapActivityProxy.a(this.a).a(3)).b((int)(paramIntent.getDoubleExtra("latitude", 0.0D) * 1000000.0D), (int)(paramIntent.getDoubleExtra("longitude", 0.0D) * 1000000.0D));
          return;
        }
        if (paramContext.equals("com.tencent.mobileqq.unregisterReceiver"))
        {
          QQMapActivityProxy.a(this.a).unregisterReceiver(QQMapActivityProxy.a(this.a));
          return;
        }
        int i;
        int j;
        int k;
        int m;
        int n;
        if (paramContext.equals("com.tencent.mobileqq.getLbsShareSearch"))
        {
          i = paramIntent.getIntExtra("latitude", 0);
          j = paramIntent.getIntExtra("longitude", 0);
          k = paramIntent.getIntExtra("coordinate", 0);
          paramContext = paramIntent.getStringExtra("keyword");
          String str = paramIntent.getStringExtra("category");
          m = paramIntent.getIntExtra("page", 0);
          n = paramIntent.getIntExtra("count", 0);
          int i1 = paramIntent.getIntExtra("requireMyLbs", 0);
          ((LBSHandler)QQMapActivityProxy.a(this.a).a(3)).a(i, j, k, paramContext, str, m, n, i1);
          return;
        }
        if (paramContext.equals("com.tencent.mobileqq.getLbsShareShop"))
        {
          i = paramIntent.getIntExtra("latitude", 0);
          j = paramIntent.getIntExtra("longitude", 0);
          k = paramIntent.getIntExtra("coordinate", 0);
          m = paramIntent.getIntExtra("begin", 0);
          n = paramIntent.getIntExtra("count", 0);
          ((LBSHandler)QQMapActivityProxy.a(this.a).a(3)).a(i, j, k, m, n);
          return;
        }
      } while (!paramContext.equals("com.tencent.mobileqq.getShareShopDetail"));
      paramContext = paramIntent.getStringExtra("shop_id");
    } while (TextUtils.isEmpty(paramContext));
    paramIntent = new ArrayList();
    paramIntent.add(paramContext);
    ((LBSHandler)QQMapActivityProxy.a(this.a).a(3)).a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ffw
 * JD-Core Version:    0.7.0.1
 */