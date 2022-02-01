package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import pum;
import pum.b;

public class MsgTabNodeListLoader$10
  implements Runnable
{
  public MsgTabNodeListLoader$10(pum parampum, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void run()
  {
    synchronized (this.this$0.mListeners)
    {
      Iterator localIterator = this.this$0.mListeners.iterator();
      if (localIterator.hasNext()) {
        ((pum.b)localIterator.next()).b(this.mI, this.ahT, this.aBN, this.aBO);
      }
    }
    if ((QLog.isDevelopLevel()) && (this.this$0.mListeners.isEmpty())) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "mListeners is empty!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.10
 * JD-Core Version:    0.7.0.1
 */