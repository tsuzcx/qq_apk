package com.tencent.biz.qqstory.msgTabNode.model;

import java.util.ArrayList;
import java.util.Iterator;
import pum;
import pum.b;

public class MsgTabNodeListLoader$9
  implements Runnable
{
  public void run()
  {
    synchronized (this.this$0.mListeners)
    {
      Iterator localIterator = this.this$0.mListeners.iterator();
      if (localIterator.hasNext()) {
        ((pum.b)localIterator.next()).so(this.val$success);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.9
 * JD-Core Version:    0.7.0.1
 */