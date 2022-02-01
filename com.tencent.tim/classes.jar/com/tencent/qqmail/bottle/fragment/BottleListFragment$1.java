package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.HashMap;

class BottleListFragment$1
  extends BottleListFragment.ActionTask
{
  BottleListFragment$1(BottleListFragment paramBottleListFragment, int paramInt, HashMap paramHashMap)
  {
    super(paramInt);
  }
  
  public void run()
  {
    int i = ((Integer)this.val$data.get("Action")).intValue();
    String str = (String)this.val$data.get("BottleId");
    QMLog.log(4, "BottleListFragment", "list_fragmenet_result:" + i + ", " + str);
    switch (i)
    {
    default: 
      throw new DevRuntimeException("bottleAction:" + i);
    }
    BottleListFragment.access$000(this.this$0, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.1
 * JD-Core Version:    0.7.0.1
 */