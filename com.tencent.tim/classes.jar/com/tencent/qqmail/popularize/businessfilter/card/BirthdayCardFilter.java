package com.tencent.qqmail.popularize.businessfilter.card;

import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.popularize.businessfilter.PopularizeFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import java.util.ArrayList;
import java.util.Iterator;

public class BirthdayCardFilter
  implements PopularizeFilter
{
  public ArrayList<Popularize> filter(ArrayList<Popularize> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis() / 1000L;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Popularize localPopularize = (Popularize)paramArrayList.next();
      if ((localPopularize.getType() == 6) && (!localPopularize.isCancel()) && (CardUtil.shouldShowBirthdayRedDot()) && (CardUtil.daysBetween(l * 1000L, (localPopularize.getStartTime() * 1000.0D)) < 7) && (localPopularize.getEndTime() >= l)) {
        localArrayList.add(localPopularize);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.card.BirthdayCardFilter
 * JD-Core Version:    0.7.0.1
 */