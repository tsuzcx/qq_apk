package btmsdkobf;

import java.util.ArrayList;
import java.util.Iterator;

abstract class ib
  implements cy.b
{
  int b = 0;
  int c = 0;
  
  public ib(di paramdi, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  protected abstract void a(int paramInt1, int paramInt2);
  
  protected abstract void a(ba paramba);
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    if (paramInt1 != 0)
    {
      a(paramInt1, -1);
      return;
    }
    if ((this.b == 10999) && (paramInt1 == 0))
    {
      a(null);
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      a(-41250000, -1);
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ba localba = (ba)paramArrayList.next();
      if ((localba != null) && (localba.bM == this.b))
      {
        if ((localba.df == 0) && (localba.dg == 0))
        {
          a(localba);
          return;
        }
        a(localba.df, localba.dg);
        return;
      }
    }
    a(-41250000, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ib
 * JD-Core Version:    0.7.0.1
 */