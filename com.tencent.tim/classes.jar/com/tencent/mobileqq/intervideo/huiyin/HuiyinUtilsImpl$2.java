package com.tencent.mobileqq.intervideo.huiyin;

import aien;
import android.util.Log;
import com.tencent.common.app.AppInterface;

public class HuiyinUtilsImpl$2
  implements Runnable
{
  public HuiyinUtilsImpl$2(aien paramaien, AppInterface paramAppInterface) {}
  
  public void run()
  {
    this.this$0.ckh = false;
    if (!aien.a(this.this$0))
    {
      aien.a(this.this$0, true);
      this.this$0.r(this.val$appInterface);
      Log.i("huiyin.login", "retry login");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.HuiyinUtilsImpl.2
 * JD-Core Version:    0.7.0.1
 */