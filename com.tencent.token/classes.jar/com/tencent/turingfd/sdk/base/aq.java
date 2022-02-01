package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.File;
import java.util.HashSet;

public class aq
  extends Thread
{
  public aq(as paramas) {}
  
  public void run()
  {
    Context localContext = cm.a();
    bj.a(localContext, as.a(this.a));
    try
    {
      Thread.sleep(5000L);
      label23:
      as.a(this.a, localContext, 0, true);
      if (bd.a.a(Gooseberry.mk.value))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        for (;;)
        {
          try
          {
            localObject1 = new String(cm.c("/proc/self/maps"));
            String[] arrayOfString = ((String)localObject1).split("\n");
            localHashSet = new HashSet();
            int j = arrayOfString.length;
            i = 0;
            if (i < j)
            {
              localObject1 = arrayOfString[i];
              localObject1 = ((String)localObject1).split(" +");
              if (localObject1.length >= 2)
              {
                str = localObject1[(localObject1.length - 1)].trim();
                localObject1 = null;
              }
            }
          }
          catch (Throwable localThrowable1)
          {
            Object localObject1;
            HashSet localHashSet;
            int i;
            String str;
            Object localObject2;
            boolean bool;
            int k;
            continue;
          }
          try
          {
            localObject2 = new File(str);
            if (!((File)localObject2).exists()) {
              continue;
            }
            localObject2 = ((File)localObject2).getName();
            localObject1 = localObject2;
          }
          catch (Throwable localThrowable2)
          {
            continue;
          }
          if (localObject1 != null)
          {
            bool = ((String)localObject1).contains("res");
            if (bool)
            {
              bool = ((String)localObject1).endsWith(".apk");
              if (bool)
              {
                bool = ((String)localObject1).contains("mediatek");
                if ((!bool) && (!TextUtils.equals("/system/framework/framework-res.apk", str)) && (!localHashSet.contains(str)))
                {
                  localHashSet.add(str);
                  localObject1 = cm.a(localContext, str);
                  if (localObject1 != null)
                  {
                    bool = TextUtils.equals((CharSequence)localObject1, "android.auto_generated_rro__");
                    if ((!bool) && (!TextUtils.equals((CharSequence)localObject1, "android.overlay")))
                    {
                      k = localStringBuilder.length();
                      if (k > 0) {
                        localStringBuilder.append(":");
                      }
                      localStringBuilder.append((String)localObject1);
                    }
                  }
                }
              }
            }
          }
          i += 1;
        }
        localStringBuilder.append(",");
        localObject1 = Resources.getSystem().getClass().getName();
        if (!TextUtils.equals("android.content.res.Resources", (CharSequence)localObject1)) {
          localStringBuilder.append((String)localObject1);
        }
        localObject1 = localStringBuilder.toString().replace("(\\|)|\\s*|\t|\r|\n", "");
        as.a(this.a).a(localContext, "405", (String)localObject1, true);
      }
      localObject1 = this.a;
      as.a((as)localObject1, as.b((as)localObject1).j(), false);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.aq
 * JD-Core Version:    0.7.0.1
 */