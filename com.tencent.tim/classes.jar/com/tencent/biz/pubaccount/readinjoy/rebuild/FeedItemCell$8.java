package com.tencent.biz.pubaccount.readinjoy.rebuild;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import lie;
import lwm;
import ndi;

public class FeedItemCell$8
  implements Runnable
{
  public FeedItemCell$8(lwm paramlwm, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, Object paramObject, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.kL.size())
    {
      localArrayList.add(((lie)this.kL.get(i)).a());
      i += 1;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("headerUninterestConfirm,");
      if (this.kM != null) {
        break label123;
      }
    }
    label123:
    for (String str = "null";; str = this.kM.toString())
    {
      QLog.d("FeedItemCell", 2, str);
      this.this$0.d.a(this.aPu, localArrayList, this.kM, this.val$object, false, this.alN);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.8
 * JD-Core Version:    0.7.0.1
 */