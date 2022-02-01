package com.tencent.qqmail.popularize;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.popularize.model.Popularize;

class PopularizeSQLiteHelper$7
  implements IReducer<Popularize>
{
  PopularizeSQLiteHelper$7(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, long paramLong) {}
  
  public void reduce(Popularize paramPopularize)
  {
    paramPopularize.setLastRenderTime(this.val$time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.7
 * JD-Core Version:    0.7.0.1
 */