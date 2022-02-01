package com.tencent.qqmail.popularize.businessfilter;

import com.tencent.qqmail.network.filter.TaskFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

public class WelcomeSubItemFilter
  implements PopularizeSubItemFilter
{
  private static final String TAG = "WelcomeSubItemFilter";
  private static int lastWelcomePopularizeDayOfWeek = -1;
  private final Popularize popularize;
  
  public WelcomeSubItemFilter(Popularize paramPopularize)
  {
    if (paramPopularize.getType() != 4) {
      throw new IllegalArgumentException("WelcomeSubItemFilter value:" + paramPopularize);
    }
    this.popularize = paramPopularize;
  }
  
  public HashMap<Popularize, ArrayList<PopularizeSubItem>> filter(ArrayList<Popularize> paramArrayList)
  {
    paramArrayList = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if (this.popularize == null) {
      return paramArrayList;
    }
    Object localObject = this.popularize.getSubItems();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
      return paramArrayList;
    }
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)((Iterator)localObject).next();
      if (localPopularizeSubItem.isCancel())
      {
        QMLog.log(4, "WelcomeSubItemFilter", "renderPopularizeSubItem item cancel.text:" + localPopularizeSubItem.getText() + " image:" + localPopularizeSubItem.getImageUrl());
      }
      else
      {
        int i = localPopularizeSubItem.getShowType();
        if ((i == 1) && (localPopularizeSubItem.isClick()))
        {
          QMLog.log(4, "WelcomeSubItemFilter", "renderPopularizeSubItem splash click once onBackground.text:" + localPopularizeSubItem.getText() + " image:" + localPopularizeSubItem.getImageUrl());
        }
        else if ((i == 0) && (localPopularizeSubItem.isRender()))
        {
          QMLog.log(4, "WelcomeSubItemFilter", "renderPopularizeSubItem splash once onBackground.text:" + localPopularizeSubItem.getText() + " image:" + localPopularizeSubItem.getImageUrl());
        }
        else if (i == 6)
        {
          i = localGregorianCalendar.get(7);
          if (i == lastWelcomePopularizeDayOfWeek) {
            QMLog.log(4, "WelcomeSubItemFilter", "renderPopularizeSubItem splash one day.text:" + localPopularizeSubItem.getText() + " image:" + localPopularizeSubItem.getImageUrl());
          } else {
            lastWelcomePopularizeDayOfWeek = i;
          }
        }
        else
        {
          localArrayList.add(localPopularizeSubItem);
        }
      }
    }
    TaskFilter.replaceTaskInBackground("Popularize_SubItems_" + this.popularize.getId(), new WelcomeSubItemFilter.1(this, localArrayList));
    paramArrayList.put(this.popularize, localArrayList);
    return paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.WelcomeSubItemFilter
 * JD-Core Version:    0.7.0.1
 */