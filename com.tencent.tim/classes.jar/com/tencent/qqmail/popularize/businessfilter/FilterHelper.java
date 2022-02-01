package com.tencent.qqmail.popularize.businessfilter;

import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeAppConfig;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Iterator;

final class FilterHelper
{
  private static final String TAG = "FilterHelper";
  
  public static boolean loadPopularizeThumb(Popularize paramPopularize)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!StringExtention.isNullOrEmpty(paramPopularize.getImageUrl()))
    {
      bool1 = bool2;
      if (PopularizeThumbManager.sharedInstance().getPopularizeThumb(paramPopularize.getImageUrl()) == null)
      {
        PopularizeThumbManager.sharedInstance().loadPopularizeThumbCheckMd5(paramPopularize.getImageUrl(), paramPopularize.getImageMd5(), null);
        QMLog.log(4, "FilterHelper", "renderPopularizeView getImageUrl not load " + paramPopularize.getImageUrl());
        bool1 = false;
      }
    }
    Object localObject;
    if (paramPopularize.getSubItems().size() > 0)
    {
      localObject = paramPopularize.getSubItems().iterator();
      bool2 = bool1;
      bool1 = bool2;
      if (((Iterator)localObject).hasNext())
      {
        PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)((Iterator)localObject).next();
        if ((StringExtention.isNullOrEmpty(localPopularizeSubItem.getImageUrl())) || (PopularizeThumbManager.sharedInstance().getPopularizeThumb(localPopularizeSubItem.getImageUrl()) != null)) {
          break label292;
        }
        PopularizeThumbManager.sharedInstance().loadPopularizeThumbCheckMd5(localPopularizeSubItem.getImageUrl(), localPopularizeSubItem.getImageMd5(), null);
        QMLog.log(4, "FilterHelper", "renderPopularizeView getSubItem ImageUrl not load " + localPopularizeSubItem.getImageUrl());
      }
    }
    label292:
    for (bool1 = false;; bool1 = bool2)
    {
      bool2 = bool1;
      break;
      bool2 = bool1;
      if (paramPopularize.getAppConfig() != null)
      {
        bool2 = bool1;
        if (paramPopularize.getAppConfig().getSubitems() != null)
        {
          paramPopularize = paramPopularize.getAppConfig().getSubitems().iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!paramPopularize.hasNext()) {
              break;
            }
            localObject = (PopularizeSubItem)paramPopularize.next();
            if ((!StringExtention.isNullOrEmpty(((PopularizeSubItem)localObject).getImageUrl())) && (PopularizeThumbManager.sharedInstance().getPopularizeThumb(((PopularizeSubItem)localObject).getImageUrl()) == null))
            {
              PopularizeThumbManager.sharedInstance().loadPopularizeThumbCheckMd5(((PopularizeSubItem)localObject).getImageUrl(), ((PopularizeSubItem)localObject).getImageMd5(), null);
              bool1 = false;
            }
          }
        }
      }
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.FilterHelper
 * JD-Core Version:    0.7.0.1
 */