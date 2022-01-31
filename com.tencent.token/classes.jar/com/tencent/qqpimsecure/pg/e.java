package com.tencent.qqpimsecure.pg;

import Protocol.MGuide.MSolution;
import tmsdk.common.module.pgsdk.PageNextCallback;

class e
  implements Runnable
{
  e(PermissionGuideActivity paramPermissionGuideActivity, r paramr, MSolution paramMSolution, int[] paramArrayOfInt, PageNextCallback paramPageNextCallback) {}
  
  public void run()
  {
    if (this.a.d != null) {
      PermissionGuideActivity.a(this.e, this.b, this.a, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.e
 * JD-Core Version:    0.7.0.1
 */