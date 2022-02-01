package com.tencent.biz.qqstory.msgTabNode.view;

import android.widget.TextView;
import pvz;
import ram;
import rpj;

public class MsgTabStoryNodeListManager$5
  implements Runnable
{
  public MsgTabStoryNodeListManager$5(pvz parampvz) {}
  
  public void run()
  {
    int i = rpj.ei(52);
    String str = this.this$0.a.xc.getText().toString();
    ram.b(pvz.access$100(), "redpoint update, update count = %s->%d", str, Integer.valueOf(i));
    this.this$0.a.wd(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.5
 * JD-Core Version:    0.7.0.1
 */