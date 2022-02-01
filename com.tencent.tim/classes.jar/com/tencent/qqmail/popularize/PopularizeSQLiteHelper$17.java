package com.tencent.qqmail.popularize;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.popularize.model.Popularize;

class PopularizeSQLiteHelper$17
  implements IReducer<Popularize>
{
  PopularizeSQLiteHelper$17(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, int paramInt) {}
  
  public void reduce(Popularize paramPopularize)
  {
    paramPopularize.setMove(this.val$move);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.17
 * JD-Core Version:    0.7.0.1
 */