package com.tencent.qqmail.popularize;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import java.util.ArrayList;
import java.util.Iterator;

class PopularizeSQLiteHelper$29
  implements IReducer<Popularize>
{
  PopularizeSQLiteHelper$29(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void reduce(Popularize paramPopularize)
  {
    paramPopularize = PopularizeUIHelper.getAllPopularizeSubItems(this.val$popularizeId);
    if ((paramPopularize != null) && (paramPopularize.size() > 0))
    {
      paramPopularize = paramPopularize.iterator();
      while (paramPopularize.hasNext())
      {
        PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)paramPopularize.next();
        if (localPopularizeSubItem.getId() == this.val$subItemId) {
          localPopularizeSubItem.setIsCancel(this.val$isCancel);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.29
 * JD-Core Version:    0.7.0.1
 */