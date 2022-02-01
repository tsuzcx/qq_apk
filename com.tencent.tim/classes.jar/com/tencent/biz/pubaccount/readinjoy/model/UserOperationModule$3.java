package com.tencent.biz.pubaccount.readinjoy.model;

import ljc;
import ljc.a;
import ljc.b;
import ljc.c;

public class UserOperationModule$3
  implements Runnable
{
  public UserOperationModule$3(ljc paramljc, boolean paramBoolean, ljc.a parama, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.val$isBatch)
    {
      ((ljc.b)this.a).a(false, null, this.val$retCode + "");
      return;
    }
    ((ljc.c)this.a).f(false, this.Qx, this.val$retCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.3
 * JD-Core Version:    0.7.0.1
 */