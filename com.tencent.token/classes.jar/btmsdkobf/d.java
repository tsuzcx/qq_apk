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
    if ((paramContext != null) && (paramIntent != null))
    {
      boolean bool = false;
      int i = paramIntent.getIntExtra("openIdNotifyFlag", 0);
      e.b("shouldUpdateId, notifyFlag : ".concat(String.valueOf(i)));
      if (i == 1)
      {
        if (!TextUtils.equals(paramIntent.getStringExtra("openIdPackage"), paramContext.getPackageName())) {
          break label94;
        }
      }
      else
      {
        if (i == 2)
        {
          ArrayList localArrayList = paramIntent.getStringArrayListExtra("openIdPackageList");
          if (localArrayList == null) {
            break label94;
          }
          bool = localArrayList.contains(paramContext.getPackageName());
          break label94;
        }
        if (i != 0) {
          break label94;
        }
      }
      bool = true;
      label94:
      if (!bool) {
        return;
      }
      paramContext = paramIntent.getStringExtra("openIdType");
      paramContext = e.b().c(paramContext);
      if (paramContext == null) {
        return;
      }
      paramContext.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.d
 * JD-Core Version:    0.7.0.1
 */