package com.tencent.mobileqq.troop.quickat.ui;

import apnw;
import apnz;
import apol;
import java.util.List;

public class AllMemberItemViewWrapper$3$1
  implements Runnable
{
  public AllMemberItemViewWrapper$3$1(apnz paramapnz, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3) {}
  
  public void run()
  {
    this.a.a.a(this.val$isSuccess, this.aRc, this.bbA, 0, 0, this.aRd, this.aRe, this.bbB);
    if ((!this.bbB) && (apnw.a(this.a.a).aBp()))
    {
      List localList = apnw.a(this.a.a).gB();
      if (localList.size() >= 1) {
        localList.remove(0);
      }
      apnw.a(this.a.a).mS(localList);
      return;
    }
    apnw.a(this.a.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AllMemberItemViewWrapper.3.1
 * JD-Core Version:    0.7.0.1
 */