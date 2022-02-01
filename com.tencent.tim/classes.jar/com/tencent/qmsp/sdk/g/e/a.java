package com.tencent.qmsp.sdk.g.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

public class a
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = false;
    int i;
    ArrayList localArrayList;
    if ((paramContext != null) && (paramIntent != null))
    {
      i = paramIntent.getIntExtra("openIdNotifyFlag", 0);
      c.b("shouldUpdateId, notifyFlag : " + i);
      if (i == 1) {
        break label153;
      }
      if (i != 2) {
        break label109;
      }
      localArrayList = paramIntent.getStringArrayListExtra("openIdPackageList");
      if (localArrayList != null) {
        break label65;
      }
    }
    label65:
    label198:
    label202:
    for (;;)
    {
      return;
      bool2 = localArrayList.contains(paramContext.getPackageName());
      boolean bool1 = bool2;
      if (bool2)
      {
        paramContext = paramIntent.getStringExtra("openIdType");
        paramContext = c.a().a(paramContext);
        if (paramContext != null)
        {
          paramContext.b();
          return;
          label109:
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (i == 0)
        {
          bool2 = bool1;
          if (bool1)
          {
            paramContext = paramIntent.getStringExtra("openIdType");
            paramContext = c.a().a(paramContext);
            if (paramContext == null) {
              continue;
            }
            paramContext.b();
            return;
            if (TextUtils.equals(paramIntent.getStringExtra("openIdPackage"), paramContext.getPackageName())) {
              break label198;
            }
          }
        }
        for (;;)
        {
          if (!bool2) {
            break label202;
          }
          paramContext = paramIntent.getStringExtra("openIdType");
          paramContext = c.a().a(paramContext);
          if (paramContext == null) {
            break;
          }
          paramContext.b();
          return;
          bool2 = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.e.a
 * JD-Core Version:    0.7.0.1
 */