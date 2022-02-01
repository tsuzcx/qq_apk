package com.tencent.mobileqq.vas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqrt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class VipGrayConfigHelper$1
  implements Runnable
{
  public void run()
  {
    int i = aqrt.access$000().get();
    if ((i < 0) || (i >= aqrt.access$100().size())) {}
    for (;;)
    {
      return;
      String str = (String)aqrt.access$100().get(i);
      AtomicInteger localAtomicInteger = (AtomicInteger)aqrt.access$200().get(str);
      Object localObject = (AtomicInteger)aqrt.access$300().get(str);
      for (AtomicReference localAtomicReference = (AtomicReference)aqrt.K().get(str); localAtomicInteger.get() >= ((AtomicInteger)localObject).get(); localAtomicReference = (AtomicReference)aqrt.K().get(str))
      {
        i += 1;
        j = i;
        if (i >= aqrt.access$100().size()) {
          break label175;
        }
        str = (String)aqrt.access$100().get(i);
        localAtomicInteger = (AtomicInteger)aqrt.access$200().get(str);
        localObject = (AtomicInteger)aqrt.access$300().get(str);
      }
      int j = i;
      label175:
      aqrt.access$000().set(j);
      if (j >= aqrt.access$100().size()) {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipGrayConfigHelper", 2, "Entry: " + str + ", Case " + (localAtomicInteger.get() + 1) + " of " + ((AtomicInteger)localObject).get());
      }
      try
      {
        localObject = (Intent)localAtomicReference.get();
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        BaseApplicationImpl.getApplication().startActivity((Intent)localObject);
        localAtomicInteger.incrementAndGet();
        BaseApplicationImpl.getApplication().getSharedPreferences("vipGrayConfigSp", 0).edit().putInt(str, localAtomicInteger.get()).apply();
        label317:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VipGrayConfigHelper", 2, "start background webview.");
        return;
      }
      catch (Exception localException)
      {
        break label317;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VipGrayConfigHelper.1
 * JD-Core Version:    0.7.0.1
 */