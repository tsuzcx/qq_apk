package com.tencent.qqmail.popularize;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.popularize.model.Popularize;
import java.util.ArrayList;

class PopularizeSQLiteHelper$6
  implements IQuery<Popularize>
{
  PopularizeSQLiteHelper$6(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, int paramInt, ArrayList paramArrayList) {}
  
  public boolean map(Popularize paramPopularize)
  {
    return paramPopularize.getServerId() == this.val$svr_id;
  }
  
  public void reduce(Popularize paramPopularize)
  {
    this.val$popularizes.add(paramPopularize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.6
 * JD-Core Version:    0.7.0.1
 */