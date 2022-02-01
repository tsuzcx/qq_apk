package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.base.Gooseberry;
import java.io.File;
import java.util.HashSet;

public final class adc
  extends Thread
{
  public adc(ade paramade) {}
  
  public final void run()
  {
    Context localContext = aey.a();
    adv.a(localContext, ade.a(this.a));
    try
    {
      Thread.sleep(5000L);
      label23:
      ade.a(this.a, localContext);
      if (adp.a.a(Gooseberry.mk.value))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        for (;;)
        {
          try
          {
            localObject = new String(aey.c("/proc/self/maps"));
            String[] arrayOfString = ((String)localObject).split("\n");
            localHashSet = new HashSet();
            int j = arrayOfString.length;
            i = 0;
            if (i < j)
            {
              localObject = arrayOfString[i];
              localObject = ((String)localObject).split(" +");
              if (localObject.length >= 2) {
                str = localObject[(localObject.length - 1)].trim();
              }
            }
          }
          catch (Throwable localThrowable1)
          {
            Object localObject;
            HashSet localHashSet;
            int i;
            String str;
            boolean bool;
            int k;
            continue;
          }
          try
          {
            localObject = new File(str);
            if (!((File)localObject).exists()) {
              continue;
            }
            localObject = ((File)localObject).getName();
          }
          catch (Throwable localThrowable2)
          {
            continue;
          }
          localObject = null;
          if (localObject != null)
          {
            bool = ((String)localObject).contains("res");
            if (bool)
            {
              bool = ((String)localObject).endsWith(".apk");
              if (bool)
              {
                bool = ((String)localObject).contains("mediatek");
                if ((!bool) && (!TextUtils.equals("/system/framework/framework-res.apk", str)) && (!localHashSet.contains(str)))
                {
                  localHashSet.add(str);
                  localObject = aey.a(localContext, str);
                  if (localObject != null)
                  {
                    bool = TextUtils.equals((CharSequence)localObject, "android.auto_generated_rro__");
                    if ((!bool) && (!TextUtils.equals((CharSequence)localObject, "android.overlay")))
                    {
                      k = localStringBuilder.length();
                      if (k > 0) {
                        localStringBuilder.append(":");
                      }
                      localStringBuilder.append((String)localObject);
                    }
                  }
                }
              }
            }
          }
          i += 1;
        }
        localStringBuilder.append(",");
        localObject = Resources.getSystem().getClass().getName();
        if (!TextUtils.equals("android.content.res.Resources", (CharSequence)localObject)) {
          localStringBuilder.append((String)localObject);
        }
        localObject = localStringBuilder.toString().replace("(\\|)|\\s*|\t|\r|\n", "");
        ade.a(this.a).a(localContext, "405", (String)localObject, true);
      }
      localObject = this.a;
      ade.a((ade)localObject, ade.b((ade)localObject).a, false);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adc
 * JD-Core Version:    0.7.0.1
 */