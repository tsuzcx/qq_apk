package com.tencent.qqmail.model.mail;

import java.util.ArrayList;
import java.util.concurrent.Callable;

class QMMailListCursor$1
  implements Callable<long[]>
{
  QMMailListCursor$1(QMMailListCursor paramQMMailListCursor) {}
  
  public long[] call()
  {
    long[] arrayOfLong = this.this$0.getItemIds();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Long.valueOf(arrayOfLong[i]));
      i += 1;
    }
    arrayOfLong = new long[localArrayList.size()];
    i = 0;
    while (i < localArrayList.size())
    {
      arrayOfLong[i] = ((Long)localArrayList.get(i)).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor.1
 * JD-Core Version:    0.7.0.1
 */