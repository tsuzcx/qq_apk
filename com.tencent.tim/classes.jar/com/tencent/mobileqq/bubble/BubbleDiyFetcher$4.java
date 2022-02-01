package com.tencent.mobileqq.bubble;

import adxn;
import adxo;
import adyk;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class BubbleDiyFetcher$4
  implements Runnable
{
  public BubbleDiyFetcher$4(adxn paramadxn, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (!this.this$0.h.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "now query mUnCacheDiyId: " + TextUtils.join(",", this.this$0.h));
      }
      this.this$0.bW(this.val$app);
      if (!this.this$0.h.isEmpty())
      {
        ((adxo)this.val$app.getBusinessHandler(70)).b(new ArrayList(this.this$0.h), null);
        this.this$0.h.clear();
      }
    }
    if (!this.this$0.i.isEmpty()) {
      this.this$0.cBr();
    }
    Object localObject;
    if (!this.this$0.j.isEmpty())
    {
      localIterator = this.this$0.j.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.this$0.Hd((String)localObject);
        }
      }
    }
    Iterator localIterator = this.this$0.E.iterator();
    while (localIterator.hasNext())
    {
      localObject = (adyk)localIterator.next();
      if ((localObject == null) || (((adyk)localObject).getCallback() == null)) {
        this.this$0.E.remove(localObject);
      }
    }
    adxn.Nl = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher.4
 * JD-Core Version:    0.7.0.1
 */