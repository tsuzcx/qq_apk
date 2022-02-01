package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import acqs;
import android.util.Pair;
import java.util.ArrayList;

public class DiscMessageProcessor$2
  implements Runnable
{
  public DiscMessageProcessor$2(acqs paramacqs, long paramLong1, long paramLong2, Pair paramPair1, MsgInfo paramMsgInfo, long paramLong3, long paramLong4, byte paramByte, long paramLong5, Pair paramPair2, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.Rk != this.Rh)
    {
      acqs.a(this.this$0, this.l, this.a, this.Rh, this.Ri, this.Rj, this.be, this.Rl, this.m);
      return;
    }
    acqs.a(this.this$0, this.l, this.a, this.ef, this.Rh, String.valueOf(this.Ri), this.be, this.Rl, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */