package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lit;

class ReadInJoyUserInfoModule$2
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ig.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = ReadInJoyUserInfoModule.a(this.this$0).D(str);
      if ((localList == null) || (localList.size() <= 0)) {
        localArrayList.add(str);
      }
    }
    if (localArrayList.size() > 0) {
      this.this$0.a(localArrayList, this.aPl, this.aPm, this.aPn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.2
 * JD-Core Version:    0.7.0.1
 */