package com.tencent.qqmail.popularize.businessfilter;

import androidx.annotation.IntRange;
import com.tencent.qqmail.popularize.model.Popularize;
import java.util.ArrayList;
import java.util.Iterator;

public class FolderListItemFilter
  implements PopularizeFilter
{
  public static final int OPEN_ALL = 3;
  public static final int OPEN_FALSE = 2;
  public static final int OPEN_TRUE = 1;
  public static final int SHOWHOME_ALL = 3;
  public static final int SHOWHOME_FALSE = 2;
  public static final int SHOWHOME_TRUE = 1;
  private final int mOpen;
  private final int showHome;
  
  public FolderListItemFilter(@IntRange(from=1L, to=3L) int paramInt1, @IntRange(from=1L, to=3L) int paramInt2)
  {
    this.showHome = paramInt1;
    this.mOpen = paramInt2;
  }
  
  public ArrayList<Popularize> filter(ArrayList<Popularize> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Popularize localPopularize = (Popularize)paramArrayList.next();
      if (((this.mOpen != 1) || (localPopularize.isOpen())) && ((this.mOpen != 2) || (!localPopularize.isOpen())))
      {
        int i;
        if ((localPopularize.getPage() == 0) && (localPopularize.getType() == 1))
        {
          i = localPopularize.getMove();
          if ((this.showHome == 1) && ((i == 0) || (i == 1))) {
            localArrayList.add(localPopularize);
          } else if ((this.showHome == 2) && (i == 2)) {
            localArrayList.add(localPopularize);
          } else if (this.showHome == 3) {
            localArrayList.add(localPopularize);
          }
        }
        else if ((localPopularize.getPage() == 10) && (localPopularize.getType() == 1))
        {
          i = localPopularize.getMove();
          if ((this.showHome == 1) && (i == 1)) {
            localArrayList.add(localPopularize);
          } else if ((this.showHome == 2) && ((i == 0) || (i == 2))) {
            localArrayList.add(localPopularize);
          } else if (this.showHome == 3) {
            localArrayList.add(localPopularize);
          }
        }
      }
    }
    return new CommFilter().filter(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.FolderListItemFilter
 * JD-Core Version:    0.7.0.1
 */