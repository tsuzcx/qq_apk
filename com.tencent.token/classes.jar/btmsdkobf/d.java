package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

public class d
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    if ((paramContext == null) || (paramIntent == null)) {}
    label130:
    label135:
    for (;;)
    {
      return;
      int i = paramIntent.getIntExtra("openIdNotifyFlag", 0);
      e.b("shouldUpdateId, notifyFlag : " + i);
      if (i == 1) {
        if (!TextUtils.equals(paramIntent.getStringExtra("openIdPackage"), paramContext.getPackageName())) {}
      }
      for (;;)
      {
        if (!bool) {
          break label135;
        }
        paramContext = paramIntent.getStringExtra("openIdType");
        paramContext = e.b().c(paramContext);
        if (paramContext == null) {
          break;
        }
        paramContext.a();
        return;
        do
        {
          ArrayList localArrayList;
          do
          {
            bool = false;
            break;
            if (i != 2) {
              break label130;
            }
            localArrayList = paramIntent.getStringArrayListExtra("openIdPackageList");
          } while (localArrayList == null);
          bool = localArrayList.contains(paramContext.getPackageName());
          break;
        } while (i != 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.d
 * JD-Core Version:    0.7.0.1
 */