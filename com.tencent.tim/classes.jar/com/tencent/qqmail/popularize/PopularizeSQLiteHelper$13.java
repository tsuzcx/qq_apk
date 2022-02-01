package com.tencent.qqmail.popularize;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.popularize.model.Popularize;

class PopularizeSQLiteHelper$13
  implements IReducer<Popularize>
{
  PopularizeSQLiteHelper$13(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, boolean paramBoolean) {}
  
  public void reduce(Popularize paramPopularize)
  {
    paramPopularize.setCancel(this.val$isCancel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.13
 * JD-Core Version:    0.7.0.1
 */