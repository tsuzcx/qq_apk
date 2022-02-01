package com.tencent.qqmail.popularize;

import com.tencent.qqmail.model.cache.IQuery;
import com.tencent.qqmail.popularize.model.Popularize;

class PopularizeSQLiteHelper$31
  implements IQuery<Popularize>
{
  PopularizeSQLiteHelper$31(PopularizeSQLiteHelper paramPopularizeSQLiteHelper, String paramString1, String paramString2) {}
  
  public boolean map(Popularize paramPopularize)
  {
    return paramPopularize.getSubInformation().equals(this.val$subInfomation);
  }
  
  public void reduce(Popularize paramPopularize)
  {
    paramPopularize.setSubInformationData(this.val$subInformationData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.PopularizeSQLiteHelper.31
 * JD-Core Version:    0.7.0.1
 */