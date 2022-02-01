package com.tencent.mobileqq.profile.vote;

import acff;
import alhr;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.like.PraiseManager;

public class VoteHelper$1
  implements Runnable
{
  public VoteHelper$1(alhr paramalhr, long paramLong1, int paramInt, boolean paramBoolean, long paramLong2) {}
  
  public void run()
  {
    int j = 2;
    boolean bool = ((acff)this.this$0.app.getManager(51)).isFriend(Long.toString(this.agA));
    int i;
    if (this.val$type == 2) {
      if (bool)
      {
        i = 5;
        if (PraiseManager.f(this.this$0.app) <= 0) {
          break label139;
        }
        if (!this.cxc) {
          break label134;
        }
      }
    }
    for (;;)
    {
      anot.b(this.this$0.app, "CliOper", "", "", "P_prof", "Prof_good", i, 1, j, Long.toString(this.agB), "1", this.this$0.app.getCurrentAccountUin(), Long.toString(this.agA));
      return;
      i = 6;
      break;
      if (bool)
      {
        i = 7;
        break;
      }
      i = 8;
      break;
      label134:
      j = 3;
      continue;
      label139:
      if (this.cxc) {
        j = 0;
      } else {
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.vote.VoteHelper.1
 * JD-Core Version:    0.7.0.1
 */