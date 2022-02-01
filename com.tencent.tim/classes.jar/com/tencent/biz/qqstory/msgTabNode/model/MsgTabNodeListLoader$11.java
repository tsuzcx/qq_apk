package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import puh;
import pum;
import pum.b;

public class MsgTabNodeListLoader$11
  implements Runnable
{
  public MsgTabNodeListLoader$11(pum parampum, puh parampuh, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2) {}
  
  public void run()
  {
    synchronized (this.this$0.mListeners)
    {
      Iterator localIterator = this.this$0.mListeners.iterator();
      if (localIterator.hasNext()) {
        ((pum.b)localIterator.next()).a(this.c, this.aBO, this.bku, this.bkv, this.aBP);
      }
    }
    if ((QLog.isDevelopLevel()) && (this.this$0.mListeners.isEmpty())) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "mListeners is empty!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.11
 * JD-Core Version:    0.7.0.1
 */