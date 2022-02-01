package com.tencent.mobileqq.troop.data;

import apan.a;
import com.tencent.mobileqq.data.MessageRecord;

class TroopAioKeywordTipManager$3$1
  implements Runnable
{
  TroopAioKeywordTipManager$3$1(TroopAioKeywordTipManager.3 param3, MessageRecord paramMessageRecord, Integer paramInteger) {}
  
  public void run()
  {
    String str = null;
    if (this.M != null) {
      str = this.M.getExtInfoFromExtStr("key_aio_keyword");
    }
    this.a.a.c(str, this.aq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.3.1
 * JD-Core Version:    0.7.0.1
 */