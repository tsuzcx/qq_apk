package com.tencent.qqmail.popularize.businessfilter;

import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class WelcomeFilter
  implements PopularizeFilter
{
  private static int lastWelcomePopularizeDayOfWeek = -1;
  private final boolean oncePerDay;
  
  public WelcomeFilter()
  {
    this(false);
  }
  
  public WelcomeFilter(boolean paramBoolean)
  {
    this.oncePerDay = paramBoolean;
  }
  
  public ArrayList<Popularize> filter(ArrayList<Popularize> paramArrayList)
  {
    Object localObject1 = new ArrayList();
    int i = new GregorianCalendar().get(7);
    if ((this.oncePerDay) && (lastWelcomePopularizeDayOfWeek == i)) {
      return localObject1;
    }
    lastWelcomePopularizeDayOfWeek = i;
    paramArrayList = paramArrayList.iterator();
    Object localObject2;
    while (paramArrayList.hasNext())
    {
      localObject2 = (Popularize)paramArrayList.next();
      if ((((Popularize)localObject2).getPage() == 3) && (((Popularize)localObject2).getType() == 4)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    paramArrayList = new CommFilter().filter((ArrayList)localObject1);
    if (paramArrayList.size() > 0)
    {
      localObject1 = new int[paramArrayList.size()];
      i = 0;
      while (i < paramArrayList.size())
      {
        localObject1[i] = ((Popularize)paramArrayList.get(i)).getWeight();
        i += 1;
      }
      localObject1 = (Popularize)paramArrayList.get(QMMath.randomWeightIndex((int[])localObject1));
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      Threads.runInBackground(new WelcomeFilter.1(this, (ArrayList)localObject2));
      paramArrayList.clear();
      if (FilterHelper.loadPopularizeThumb((Popularize)localObject1)) {
        paramArrayList.add(localObject1);
      }
    }
    return paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.WelcomeFilter
 * JD-Core Version:    0.7.0.1
 */