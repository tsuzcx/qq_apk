package com.tencent.qqmail.popularize;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.popularize.model.Popularize;
import java.util.ArrayList;

class PopularizeSQLiteHelper$3
  implements IQuery<Popularize>
{
  PopularizeSQLiteHelper$3(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, int paramInt, ArrayList paramArrayList) {}
  
  public boolean map(Popularize paramPopularize)
  {
    return paramPopularize.getPage() == this.val$page;
  }
  
  public void reduce(Popularize paramPopularize)
  {
    this.val$popularizes.add(paramPopularize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.3
 * JD-Core Version:    0.7.0.1
 */