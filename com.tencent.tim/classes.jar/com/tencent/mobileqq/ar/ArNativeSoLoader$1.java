package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anpc;
import aqmj;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.HashMap;

public final class ArNativeSoLoader$1
  implements Runnable
{
  public ArNativeSoLoader$1(String paramString, byte paramByte, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_soLoaderName", this.bss);
    ((HashMap)localObject).put("param_FailCode", String.valueOf(this.bf));
    anpc localanpc = anpc.a(BaseApplication.getContext());
    if (this.bf == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(null, "AREnable", bool, 0L, 0L, (HashMap)localObject, null);
      localObject = this.val$sp.edit();
      ((SharedPreferences.Editor)localObject).putInt("ar_native_so_load_result" + this.bss, this.bf);
      aqmj.b((SharedPreferences.Editor)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArNativeSoLoader.1
 * JD-Core Version:    0.7.0.1
 */