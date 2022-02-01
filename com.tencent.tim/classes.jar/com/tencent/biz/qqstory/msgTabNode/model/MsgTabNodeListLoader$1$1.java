package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pum;
import pum.b;
import pun;
import pxs.b;

public class MsgTabNodeListLoader$1$1
  implements Runnable
{
  public MsgTabNodeListLoader$1$1(pun parampun, pxs.b paramb) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Pxs$b.c != null) {
      this.jdField_a_of_type_Pun.this$0.a(this.jdField_a_of_type_Pxs$b.c);
    }
    Object localObject2;
    if (this.jdField_a_of_type_Pxs$b.mX != null)
    {
      ??? = this.jdField_a_of_type_Pxs$b.mX.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (QQUserUIItem)((Iterator)???).next();
        this.jdField_a_of_type_Pun.this$0.a(this.jdField_a_of_type_Pxs$b.c);
      }
    }
    synchronized (this.jdField_a_of_type_Pun.this$0.mListeners)
    {
      localObject2 = this.jdField_a_of_type_Pun.this$0.mListeners.iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((pum.b)((Iterator)localObject2).next()).bmQ();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.1.1
 * JD-Core Version:    0.7.0.1
 */