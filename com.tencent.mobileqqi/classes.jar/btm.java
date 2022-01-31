import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import java.util.ArrayList;
import java.util.HashMap;

public class btm
  extends BroadcastReceiver
{
  public btm(TroopMemberApiPlugin paramTroopMemberApiPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getStringArrayListExtra("uinList");
      paramIntent = paramIntent.getStringArrayListExtra("headPathList");
      if ((paramContext != null) && (paramIntent != null))
      {
        int i = 0;
        while (i < paramContext.size())
        {
          String str = (String)paramContext.get(i);
          if (this.a.a.contains(str))
          {
            this.a.a.remove(str);
            Bitmap localBitmap = BitmapFactory.decodeFile((String)paramIntent.get(i));
            this.a.b.put(str, localBitmap);
          }
          if (this.a.a.size() == 0)
          {
            this.a.callJs(this.a.l, new String[] { TroopMemberApiPlugin.a(this.a, this.a.b) });
            this.a.b.clear();
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     btm
 * JD-Core Version:    0.7.0.1
 */