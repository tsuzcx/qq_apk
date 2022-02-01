package com.tencent.qqmail.popularize.businessfilter;

import com.tencent.qqmail.popularize.model.Popularize;
import java.util.ArrayList;
import java.util.Iterator;

public class TypePageFilter
  implements PopularizeFilter
{
  public static final int ALL = -1;
  private final int page;
  private final int type;
  
  public TypePageFilter(int paramInt1, int paramInt2)
  {
    this.type = paramInt1;
    this.page = paramInt2;
  }
  
  public ArrayList<Popularize> filter(ArrayList<Popularize> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Popularize localPopularize = (Popularize)paramArrayList.next();
      if (((this.type < 0) || (localPopularize.getType() == this.type)) && ((this.page < 0) || (localPopularize.getPage() == this.page))) {
        localArrayList.add(localPopularize);
      }
    }
    return new CommFilter().filter(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.TypePageFilter
 * JD-Core Version:    0.7.0.1
 */