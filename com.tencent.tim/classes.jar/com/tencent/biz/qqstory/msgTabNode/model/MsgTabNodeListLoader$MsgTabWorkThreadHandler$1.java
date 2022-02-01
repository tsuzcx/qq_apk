package com.tencent.biz.qqstory.msgTabNode.model;

import java.util.ArrayList;
import java.util.Iterator;
import pum;
import pum.a;
import pum.b;

public class MsgTabNodeListLoader$MsgTabWorkThreadHandler$1
  implements Runnable
{
  public MsgTabNodeListLoader$MsgTabWorkThreadHandler$1(pum.a parama) {}
  
  public void run()
  {
    synchronized (this.a.this$0.mListeners)
    {
      Iterator localIterator = this.a.this$0.mListeners.iterator();
      if (localIterator.hasNext()) {
        ((pum.b)localIterator.next()).bmQ();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.MsgTabWorkThreadHandler.1
 * JD-Core Version:    0.7.0.1
 */