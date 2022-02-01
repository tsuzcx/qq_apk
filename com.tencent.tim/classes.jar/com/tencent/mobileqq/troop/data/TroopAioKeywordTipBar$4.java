package com.tencent.mobileqq.troop.data;

import android.util.Pair;
import apag;
import apak;
import apam;
import apan;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import wki;

public class TroopAioKeywordTipBar$4
  implements Runnable
{
  public TroopAioKeywordTipBar$4(apag paramapag) {}
  
  public void run()
  {
    apag.b(this.this$0, false);
    if (!apag.c(this.this$0)) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "checkMsgForShow, mIsCanCheck = false");
      }
    }
    apan localapan;
    ArrayList localArrayList1;
    do
    {
      ArrayList localArrayList2;
      do
      {
        int i;
        int j;
        do
        {
          return;
          i = this.this$0.b.getFirstVisiblePosition() - this.this$0.b.getHeaderViewsCount();
          j = this.this$0.b.getLastVisiblePosition() - this.this$0.b.getHeaderViewsCount();
          localapan = (apan)this.this$0.app.getManager(225);
        } while ((i < 0) || (j < 0));
        localArrayList1 = new ArrayList(10);
        localArrayList2 = new ArrayList(10);
        if (i <= j)
        {
          localObject = (MessageRecord)this.this$0.a.getItem(i);
          if (localObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            if (!((MessageRecord)localObject).isSend()) {
              localArrayList1.add(localObject);
            } else if (((MessageRecord)localObject).time > NetConnInfoCenter.getServerTime() - 5L) {
              localArrayList2.add(0, localObject);
            }
          }
        }
        if (localArrayList2.size() <= 0) {
          break;
        }
      } while ((apag.b(this.this$0) != null) && (apag.b(this.this$0) == localArrayList2.get(0)));
      Object localObject = localapan.a(localArrayList2, apag.a(this.this$0), 1);
      if ((apag.a(this.this$0)) && ((((Pair)localObject).second == null) || ((apag.a(this.this$0) != null) && (apag.a(this.this$0).ruleId != ((Integer)((Pair)localObject).second).intValue())))) {
        apag.a(this.this$0, false);
      }
      for (;;)
      {
        localapan.a(localArrayList2, apag.a(this.this$0), 1, new apak(this, localArrayList1, localapan));
        return;
        apag.b(this.this$0, (MessageRecord)localArrayList2.get(0));
      }
    } while ((localArrayList1.size() <= 0) || (apag.a(this.this$0)));
    localapan.a(localArrayList1, null, 2, new apam(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.4
 * JD-Core Version:    0.7.0.1
 */