package com.tencent.qqmail.popularize.businessfilter.card;

import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.popularize.businessfilter.PopularizeFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class CardRedPointFilter
  implements PopularizeFilter
{
  public ArrayList<Popularize> filter(ArrayList<Popularize> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = new CardFilter().filter(paramArrayList);
    paramArrayList = new CardSubItemFilter().filter(paramArrayList).entrySet().iterator();
    while (paramArrayList.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramArrayList.next();
      if ((localEntry.getValue() != null) && (((ArrayList)localEntry.getValue()).size() > 0)) {
        switch (((Popularize)localEntry.getKey()).getType())
        {
        default: 
          break;
        case 6: 
          if (CardUtil.shouldShowBirthdayRedDot()) {
            localArrayList.add(localEntry.getKey());
          }
          break;
        case 7: 
          localArrayList.add(localEntry.getKey());
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.card.CardRedPointFilter
 * JD-Core Version:    0.7.0.1
 */