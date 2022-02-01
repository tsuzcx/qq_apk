package com.tencent.qqmail.popularize.businessfilter.card;

import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.popularize.businessfilter.PopularizeSubItemFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CardSubItemFilter
  implements PopularizeSubItemFilter
{
  public HashMap<Popularize, ArrayList<PopularizeSubItem>> filter(ArrayList<Popularize> paramArrayList)
  {
    Object localObject1 = new CardFilter().filter(paramArrayList);
    if (((ArrayList)localObject1).size() > 0)
    {
      paramArrayList = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localObject1 = (Popularize)((ArrayList)localObject1).get(0);
      Object localObject2 = ((Popularize)localObject1).getSubItems();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)((Iterator)localObject2).next();
          if (!localPopularizeSubItem.isCancel()) {
            localArrayList.add(localPopularizeSubItem);
          }
        }
      }
      if (((Popularize)localObject1).getType() == 7)
      {
        paramArrayList.put(localObject1, localArrayList);
        return paramArrayList;
      }
      if ((((Popularize)localObject1).getType() == 6) && (paramArrayList != null) && (paramArrayList.size() > 0) && (CardUtil.shouldShowBirthdayRedDot()))
      {
        paramArrayList.put(localObject1, localArrayList);
        return paramArrayList;
      }
    }
    return new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.card.CardSubItemFilter
 * JD-Core Version:    0.7.0.1
 */