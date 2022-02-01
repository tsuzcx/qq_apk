package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

public class DialogRedirectImpl
  extends DialogRedirect
{
  private final Activity a;
  private final int b;
  private final Intent c;
  
  DialogRedirectImpl(Intent paramIntent, Activity paramActivity, int paramInt)
  {
    this.c = paramIntent;
    this.a = paramActivity;
    this.b = paramInt;
  }
  
  public final void redirect()
  {
    if (this.c != null) {
      this.a.startActivityForResult(this.c, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.DialogRedirectImpl
 * JD-Core Version:    0.7.0.1
 */