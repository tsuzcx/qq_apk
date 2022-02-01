package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import java.util.ArrayList;
import java.util.Iterator;
import kbp;

class ReadInJoySelectMemberAQFragment$3
  implements Runnable
{
  ReadInJoySelectMemberAQFragment$3(ReadInJoySelectMemberAQFragment paramReadInJoySelectMemberAQFragment, ArrayList paramArrayList, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = this.li.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      kbp.a(null, "", "0X8009543", "0X8009543", 0, 0, "", "", "", ReadInJoySelectMemberAQFragment.a(this.this$0, localResultRecord, this.Vu), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment.3
 * JD-Core Version:    0.7.0.1
 */