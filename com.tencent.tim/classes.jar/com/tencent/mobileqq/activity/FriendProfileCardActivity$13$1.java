package com.tencent.mobileqq.activity;

import android.os.Message;
import auru;
import com.tencent.mobileqq.data.Card;
import uys;

public class FriendProfileCardActivity$13$1
  implements Runnable
{
  public FriendProfileCardActivity$13$1(uys paramuys, Card paramCard) {}
  
  public void run()
  {
    boolean bool = this.a.this$0.a((int)this.c.lCurrentStyleId, (int)this.c.lCurrentBgId, this.c.backgroundUrl, (int)this.c.backgroundColor, this.c.templateRet, this.c.diyComplicatedInfo, this.c.cardId);
    Message localMessage = this.a.this$0.b.obtainMessage(13, Boolean.valueOf(bool));
    this.a.this$0.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.13.1
 * JD-Core Version:    0.7.0.1
 */