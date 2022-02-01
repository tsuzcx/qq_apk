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
    if (paramContext != null)
    {
      if (paramIntent == null) {
        return;
      }
      boolean bool = false;
      int i = paramIntent.getIntExtra("openIdNotifyFlag", 0);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shouldUpdateId, notifyFlag : ");
      ((StringBuilder)localObject).append(i);
      e.b(((StringBuilder)localObject).toString());
      if (i == 1)
      {
        if (!TextUtils.equals(paramIntent.getStringExtra("openIdPackage"), paramContext.getPackageName())) {
          break label115;
        }
      }
      else
      {
        if (i == 2)
        {
          localObject = paramIntent.getStringArrayListExtra("openIdPackageList");
          if (localObject == null) {
            break label115;
          }
          bool = ((ArrayList)localObject).contains(paramContext.getPackageName());
          break label115;
        }
        if (i != 0) {
          break label115;
        }
      }
      bool = true;
      label115:
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