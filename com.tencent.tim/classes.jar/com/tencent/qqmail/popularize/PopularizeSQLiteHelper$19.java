package com.tencent.qqmail.popularize;

import com.tencent.qqmail.model.cache.IReducer;
import com.tencent.qqmail.popularize.model.Popularize;

class PopularizeSQLiteHelper$19
  implements IReducer<Popularize>
{
  PopularizeSQLiteHelper$19(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, boolean paramBoolean) {}
  
  public void reduce(Popularize paramPopularize)
  {
    paramPopularize.setIsOpen(this.val$isOpen);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.19
 * JD-Core Version:    0.7.0.1
 */