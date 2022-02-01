package com.tencent.qqmail.popularize.businessfilter;

import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeAppConfig;
import java.util.ArrayList;

class WelcomeSubItemFilter$1
  implements Runnable
{
  WelcomeSubItemFilter$1(WelcomeSubItemFilter paramWelcomeSubItemFilter, ArrayList paramArrayList) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.addAll(this.val$data);
    if ((WelcomeSubItemFilter.access$000(this.this$0).getAppConfig() != null) && (WelcomeSubItemFilter.access$000(this.this$0).getAppConfig().getSubitems() != null))
    {
      ArrayList localArrayList2 = WelcomeSubItemFilter.access$000(this.this$0).getAppConfig().getSubitems();
      PopularizeManager.sharedInstance().updatePopularizeSubItemClickMyApp(localArrayList2, true);
      localArrayList1.addAll(localArrayList2);
    }
    PopularizeManager.sharedInstance().updatePopularizeSubItemRender(localArrayList1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.WelcomeSubItemFilter.1
 * JD-Core Version:    0.7.0.1
 */