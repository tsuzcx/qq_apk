package com.tencent.mobileqq.activity.aio.item;

import accc;
import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import xpw;

public final class TroopFileItemBuilder$1
  implements Runnable
{
  public void run()
  {
    xpw.a(this.I, this.jdField_a_of_type_Apcy, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l1 = 0L;
    if (xpw.gQ.containsKey(this.fe)) {
      l1 = ((Long)xpw.gQ.get(this.fe)).longValue();
    }
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 10000L)
    {
      accc localaccc = (accc)this.val$app.getBusinessHandler(22);
      ((Activity)this.I).runOnUiThread(new TroopFileItemBuilder.1.1(this, localaccc));
      xpw.gQ.put(this.fe, Long.valueOf(l2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */