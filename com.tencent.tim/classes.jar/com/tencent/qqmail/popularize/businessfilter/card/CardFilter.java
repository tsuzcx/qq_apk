package com.tencent.qqmail.popularize.businessfilter.card;

import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.businessfilter.PopularizeFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeAppConfig;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardFilter
  implements PopularizeFilter
{
  public ArrayList<Popularize> filter(ArrayList<Popularize> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = new AllCardFilter().filter(paramArrayList);
    if (paramArrayList.size() > 0)
    {
      paramArrayList = (Popularize)paramArrayList.get(0);
      localArrayList.add(paramArrayList);
      Object localObject;
      if (paramArrayList.getSubItems().size() > 0)
      {
        localObject = paramArrayList.getSubItems().iterator();
        while (((Iterator)localObject).hasNext())
        {
          PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)((Iterator)localObject).next();
          if ((!StringExtention.isNullOrEmpty(localPopularizeSubItem.getImageUrl())) && (PopularizeThumbManager.sharedInstance().getPopularizeThumb(localPopularizeSubItem.getImageUrl()) == null)) {
            PopularizeThumbManager.sharedInstance().loadPopularizeThumbCheckMd5(localPopularizeSubItem.getImageUrl(), localPopularizeSubItem.getImageMd5(), null);
          }
        }
      }
      if ((paramArrayList.getAppConfig() != null) && (paramArrayList.getAppConfig().getSubitems() != null))
      {
        paramArrayList = paramArrayList.getAppConfig().getSubitems().iterator();
        while (paramArrayList.hasNext())
        {
          localObject = (PopularizeSubItem)paramArrayList.next();
          if ((!StringExtention.isNullOrEmpty(((PopularizeSubItem)localObject).getImageUrl())) && (PopularizeThumbManager.sharedInstance().getPopularizeThumb(((PopularizeSubItem)localObject).getImageUrl()) == null)) {
            PopularizeThumbManager.sharedInstance().loadPopularizeThumbCheckMd5(((PopularizeSubItem)localObject).getImageUrl(), ((PopularizeSubItem)localObject).getImageMd5(), null);
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.card.CardFilter
 * JD-Core Version:    0.7.0.1
 */