package com.tencent.qqmail.popularize.businessfilter.card;

import com.tencent.qqmail.popularize.businessfilter.PopularizeFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CardWithSubitemFilter
  implements PopularizeFilter
{
  public ArrayList<Popularize> filter(ArrayList<Popularize> paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = new CardFilter().filter(paramArrayList);
    paramArrayList = new CardSubItemFilter();
    ArrayList localArrayList2 = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Popularize localPopularize = (Popularize)((Iterator)localObject).next();
      localArrayList2.clear();
      localArrayList2.add(localPopularize);
      if (paramArrayList.filter(localArrayList2).size() > 0) {
        localArrayList1.add(localPopularize);
      }
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.card.CardWithSubitemFilter
 * JD-Core Version:    0.7.0.1
 */