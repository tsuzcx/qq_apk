package com.tencent.qqmail.popularize.businessfilter;

import androidx.annotation.IntRange;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FolderListSubItemFilter
  implements PopularizeSubItemFilter
{
  private static final String TAG = "FolderListSubItemFilter";
  private final int showHome;
  
  public FolderListSubItemFilter(@IntRange(from=1L, to=3L) int paramInt)
  {
    this.showHome = paramInt;
  }
  
  private static void handleSubItemCancel(PopularizeSubItem paramPopularizeSubItem)
  {
    Threads.runInBackground(new FolderListSubItemFilter.1(paramPopularizeSubItem));
  }
  
  public HashMap<Popularize, ArrayList<PopularizeSubItem>> filter(ArrayList<Popularize> paramArrayList)
  {
    Object localObject1 = new FolderListItemFilter(this.showHome, 3).filter(paramArrayList);
    paramArrayList = new HashMap();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Popularize localPopularize = (Popularize)((Iterator)localObject1).next();
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = localPopularize.getSubItems();
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)((Iterator)localObject2).next();
          if (localPopularizeSubItem.isCancel())
          {
            QMLog.log(4, "FolderListSubItemFilter", "FolderListSubItemFilter item cancel.text:" + localPopularizeSubItem.getText() + " image:" + localPopularizeSubItem.getImageUrl());
          }
          else
          {
            int i = localPopularizeSubItem.getShowType();
            if ((i == 1) && (localPopularizeSubItem.isClick()))
            {
              handleSubItemCancel(localPopularizeSubItem);
              QMLog.log(4, "FolderListSubItemFilter", "FolderListSubItemFilter item click once.text:" + localPopularizeSubItem.getText() + " image:" + localPopularizeSubItem.getImageUrl());
            }
            else if ((i == 0) && (localPopularizeSubItem.isRender()))
            {
              handleSubItemCancel(localPopularizeSubItem);
              QMLog.log(4, "FolderListSubItemFilter", "FolderListSubItemFilter item render once.text:" + localPopularizeSubItem.getText() + " image:" + localPopularizeSubItem.getImageUrl());
            }
            else
            {
              localArrayList.add(localPopularizeSubItem);
            }
          }
        }
      }
      paramArrayList.put(localPopularize, localArrayList);
    }
    return paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.FolderListSubItemFilter
 * JD-Core Version:    0.7.0.1
 */