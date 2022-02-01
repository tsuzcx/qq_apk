package com.tencent.qqmail.popularize;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import java.util.ArrayList;
import java.util.Iterator;

class PopularizeSQLiteHelper$21
  implements IReducer<Popularize>
{
  PopularizeSQLiteHelper$21(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, PopularizeSubItem paramPopularizeSubItem, boolean paramBoolean) {}
  
  public void reduce(Popularize paramPopularize)
  {
    paramPopularize = PopularizeUIHelper.getAllPopularizeSubItems(paramPopularize.getId());
    if ((paramPopularize != null) && (paramPopularize.size() > 0))
    {
      paramPopularize = paramPopularize.iterator();
      while (paramPopularize.hasNext())
      {
        PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)paramPopularize.next();
        if (this.val$subitem.getId() == localPopularizeSubItem.getId()) {
          localPopularizeSubItem.setIsRender(this.val$isRender);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.21
 * JD-Core Version:    0.7.0.1
 */