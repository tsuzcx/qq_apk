package com.tencent.qqpimsecure.pg;

import android.content.Intent;
import android.os.Bundle;
import tmsdk.common.module.pgsdk.PageNextCallback;

class c
  implements PageNextCallback
{
  c(PermissionGuideActivity paramPermissionGuideActivity, Intent paramIntent, int[] paramArrayOfInt) {}
  
  public void onCallback()
  {
    try
    {
      this.c.startActivity(this.a);
      i.a().a(this.b, this.c);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void setIntentExtras(Bundle paramBundle)
  {
    this.a.putExtras(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.c
 * JD-Core Version:    0.7.0.1
 */