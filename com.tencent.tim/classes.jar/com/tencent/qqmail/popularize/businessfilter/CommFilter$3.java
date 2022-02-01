package com.tencent.qqmail.popularize.businessfilter;

import com.tencent.qqmail.popularize.model.Popularize;
import java.util.Comparator;

class CommFilter$3
  implements Comparator<Popularize>
{
  CommFilter$3(CommFilter paramCommFilter) {}
  
  public int compare(Popularize paramPopularize1, Popularize paramPopularize2)
  {
    if (paramPopularize1.getWeight() >= paramPopularize2.getWeight()) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.CommFilter.3
 * JD-Core Version:    0.7.0.1
 */