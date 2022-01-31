package com.tencent.qqpimsecure.pg;

import android.content.Context;
import tmsdk.common.module.pgsdk.IPermissionChecker;

class s
  implements IPermissionChecker
{
  s(r paramr, Context paramContext) {}
  
  public int checkPermission(int paramInt)
  {
    if (paramInt == 37) {
      return q.a(this.a);
    }
    if (paramInt == 5) {
      return q.b(this.a);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.s
 * JD-Core Version:    0.7.0.1
 */