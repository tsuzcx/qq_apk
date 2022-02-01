package com.tencent.qqmail.popularize.view;

import com.tencent.qqmail.popularize.PopularizeManager;
import java.util.ArrayList;

final class PopularizeUIHelper$1
  implements Runnable
{
  PopularizeUIHelper$1(ArrayList paramArrayList) {}
  
  public void run()
  {
    PopularizeManager.sharedInstance().updatePopularizeSubItemRender(this.val$subitems, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeUIHelper.1
 * JD-Core Version:    0.7.0.1
 */