package com.tencent.mobileqq.activity.aio.qim;

import com.tencent.mobileqq.troop.widget.RedDotImageView;
import java.util.ArrayList;
import java.util.Iterator;
import xva.a;

class QIMUserManager$5$1
  implements Runnable
{
  QIMUserManager$5$1(QIMUserManager.5 param5) {}
  
  public void run()
  {
    Iterator localIterator = this.a.qR.iterator();
    while (localIterator.hasNext())
    {
      xva.a locala = (xva.a)localIterator.next();
      if (locala.c != null) {
        locala.c.setImageDrawable(locala.icon);
      }
      locala.c = null;
      locala.icon = null;
    }
    this.a.qR.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.5.1
 * JD-Core Version:    0.7.0.1
 */