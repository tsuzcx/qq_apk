package com.tencent.av.random;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

class RandomWebProtocol$1
  extends Thread
{
  RandomWebProtocol$1(RandomWebProtocol paramRandomWebProtocol, String paramString1, String paramString2) {}
  
  public void run()
  {
    RandomWebProtocol.i locali = new RandomWebProtocol.i(this.this$0);
    if ((!TextUtils.isEmpty(this.Qa)) && (!TextUtils.equals(this.Qa, "null"))) {
      locali.bg = this.this$0.c(this.Mu, this.Qa);
    }
    if (locali.bg != null) {}
    for (int i = 0;; i = -1)
    {
      Iterator localIterator = this.this$0.listeners.iterator();
      while (localIterator.hasNext()) {
        ((RandomWebProtocol.a)localIterator.next()).a(i, locali);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.1
 * JD-Core Version:    0.7.0.1
 */