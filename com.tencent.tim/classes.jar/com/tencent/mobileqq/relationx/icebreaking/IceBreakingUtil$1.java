package com.tencent.mobileqq.relationx.icebreaking;

import aluu;
import com.tencent.mobileqq.app.QQAppInterface;

public final class IceBreakingUtil$1
  implements Runnable
{
  public IceBreakingUtil$1(int paramInt, QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (aluu.kV(this.val$type)) {
      aluu.n(this.val$app, this.val$uin, this.czB);
    }
    do
    {
      return;
      if (aluu.kW(this.val$type))
      {
        aluu.aE(this.val$app, this.val$uin);
        return;
      }
    } while (!aluu.kX(this.val$type));
    aluu.aF(this.val$app, this.val$uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil.1
 * JD-Core Version:    0.7.0.1
 */