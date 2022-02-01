package com.huawei.hianalytics.ab.bc.kl;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserManager;
import com.huawei.hianalytics.ab.ab.bc;

public class gh
{
  private static gh ab = new gh();
  private boolean bc = false;
  private Context cd = bc.ik();
  
  public static gh ab()
  {
    return ab;
  }
  
  @TargetApi(24)
  public boolean bc()
  {
    if (!this.bc)
    {
      if (this.cd == null) {
        return false;
      }
      if (Build.VERSION.SDK_INT < 24) {
        break label62;
      }
      UserManager localUserManager = (UserManager)this.cd.getSystemService("user");
      if (localUserManager == null) {
        break label54;
      }
      this.bc = localUserManager.isUserUnlocked();
    }
    for (;;)
    {
      return this.bc;
      label54:
      this.bc = false;
      continue;
      label62:
      this.bc = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.kl.gh
 * JD-Core Version:    0.7.0.1
 */