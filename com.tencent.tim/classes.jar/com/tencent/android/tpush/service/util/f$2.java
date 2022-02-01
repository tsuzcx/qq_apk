package com.tencent.android.tpush.service.util;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.android.tpush.TypeStr;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.crosssp.ProviderMessage;
import java.util.Iterator;
import java.util.List;

final class f$2
  implements Runnable
{
  f$2(Context paramContext) {}
  
  public void run()
  {
    Object localObject1 = f.a(this.a);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      int i = 0;
      for (;;)
      {
        int j;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResolveInfo)((Iterator)localObject1).next();
          j = i + 1;
          if (!"oppo".equals(i.b())) {
            break label62;
          }
          if (j <= 2) {
            break label67;
          }
        }
        label62:
        while (j > 4) {
          return;
        }
        label67:
        Object localObject2 = ((ResolveInfo)localObject2).activityInfo.applicationInfo.packageName;
        i = j;
        if (!f.f(this.a, (String)localObject2))
        {
          i = j;
          if (!i.b((String)localObject2))
          {
            i = j;
            if (!this.a.getPackageName().equals(localObject2))
            {
              i = j;
              if (!f.b(this.a, (String)localObject2))
              {
                i = j;
                if (f.a(this.a, (String)localObject2)) {
                  try
                  {
                    String str = "content://" + (String)localObject2 + ".XGVIP_PUSH_AUTH/" + TypeStr.pullupxg.getStr();
                    Uri localUri = Uri.parse(str);
                    TLogger.d("ServiceUtil", "pull up by provider, pkgName: " + (String)localObject2 + ", uri:" + str);
                    ProviderMessage.getType(this.a, localUri);
                    Thread.sleep(200L);
                    i = j;
                  }
                  catch (Throwable localThrowable)
                  {
                    TLogger.e("ServiceUtil", "pull up by provider error" + localThrowable);
                    i = j;
                  }
                }
              }
            }
          }
        }
      }
    }
    TLogger.ii("ServiceUtil", "pullupXGServices  with null content");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.util.f.2
 * JD-Core Version:    0.7.0.1
 */