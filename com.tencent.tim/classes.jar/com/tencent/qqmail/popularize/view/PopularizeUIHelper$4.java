package com.tencent.qqmail.popularize.view;

import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import java.util.ArrayList;

final class PopularizeUIHelper$4
  implements Runnable
{
  PopularizeUIHelper$4(PopularizeSubItem paramPopularizeSubItem) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.val$subItem);
    PopularizeManager.sharedInstance().updatePopularizeSubItemClick(localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeUIHelper.4
 * JD-Core Version:    0.7.0.1
 */