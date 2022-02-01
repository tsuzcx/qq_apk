package com.tencent.qqmail.popularize.view;

import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;

final class PopularizeUIHelper$5
  implements Runnable
{
  PopularizeUIHelper$5(PopularizeSubItem paramPopularizeSubItem) {}
  
  public void run()
  {
    PopularizeManager.sharedInstance().updatePopularizeSubItemCancel(this.val$subItem.getPopularizeId(), this.val$subItem.getId(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeUIHelper.5
 * JD-Core Version:    0.7.0.1
 */