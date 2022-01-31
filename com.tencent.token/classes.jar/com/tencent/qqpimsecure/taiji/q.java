package com.tencent.qqpimsecure.taiji;

import java.util.HashMap;
import taiji.cl;
import tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager.IProfileUploadCallback;

class q
  implements ITaijiKVProfileManager.IProfileUploadCallback
{
  q(o paramo, boolean paramBoolean, HashMap paramHashMap1, HashMap paramHashMap2, Object paramObject) {}
  
  public void onUploadSuccess()
  {
    cl.b("Taiji", "onUploadSuccess:isToPull?" + this.a + ":profileUploadTimeInterval:" + (System.currentTimeMillis() - o.b(this.e)));
    u localu = u.a(o.a(this.e));
    localu.b(System.currentTimeMillis());
    localu.a(this.b, this.c);
    if (this.a) {
      o.c(this.e).sendMessageDelayed(o.c(this.e).obtainMessage(1, this.d), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.q
 * JD-Core Version:    0.7.0.1
 */