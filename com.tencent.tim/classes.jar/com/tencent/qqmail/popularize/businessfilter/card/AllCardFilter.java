package com.tencent.qqmail.popularize.businessfilter.card;

import com.tencent.qqmail.popularize.businessfilter.PopularizeFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import java.util.ArrayList;

public class AllCardFilter
  implements PopularizeFilter
{
  public ArrayList<Popularize> filter(ArrayList<Popularize> paramArrayList)
  {
    ArrayList localArrayList = new FestivalCardFilter().filter(paramArrayList);
    localArrayList.addAll(new BirthdayCardFilter().filter(paramArrayList));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.card.AllCardFilter
 * JD-Core Version:    0.7.0.1
 */