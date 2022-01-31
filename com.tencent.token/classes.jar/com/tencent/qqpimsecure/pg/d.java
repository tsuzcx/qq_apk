package com.tencent.qqpimsecure.pg;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import tmsdk.common.module.pgsdk.PageNextCallback;

class d
  implements PageNextCallback
{
  d(PermissionGuideActivity paramPermissionGuideActivity, Intent paramIntent, int[] paramArrayOfInt) {}
  
  public void onCallback()
  {
    try
    {
      this.c.startActivity(this.a);
      this.c.overridePendingTransition(0, 0);
      i.a().a(this.b, this.c);
      if ((!PermissionGuideActivity.c(this.c).isEmpty()) && (((Integer)PermissionGuideActivity.c(this.c).get(0)).intValue() == 5))
      {
        q.b(this.c, 2);
        q.b(this.c, System.currentTimeMillis());
        q.a(this.c, 5, PermissionGuideActivity.a(this.c));
      }
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
 * Qualified Name:     com.tencent.qqpimsecure.pg.d
 * JD-Core Version:    0.7.0.1
 */