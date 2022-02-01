import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apoy
{
  private ArrayList<apou> Ch;
  private long arO;
  private long arP;
  private int dVh;
  private int dVi;
  private int dVj;
  private long en;
  
  public apoy()
  {
    this.en = 0L;
    this.dVh = 0;
    this.dVi = 0;
    this.Ch = null;
  }
  
  public apoy(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<apou> paramArrayList)
  {
    this.en = paramLong;
    this.arO = (System.currentTimeMillis() + paramInt1 * 1000);
    this.dVh = paramInt2;
    this.dVi = paramInt3;
    this.dVj = (paramInt4 * 1000);
    this.Ch = paramArrayList;
  }
  
  public int LC()
  {
    return this.dVh;
  }
  
  public int LD()
  {
    return this.dVi;
  }
  
  public int LE()
  {
    return this.dVj;
  }
  
  public void WU(int paramInt)
  {
    this.dVh = paramInt;
  }
  
  public void WV(int paramInt)
  {
    this.dVi = paramInt;
  }
  
  public void WW(int paramInt)
  {
    this.arO = paramInt;
  }
  
  public apou a(long paramLong)
  {
    Iterator localIterator = this.Ch.iterator();
    while (localIterator.hasNext())
    {
      apou localapou = (apou)localIterator.next();
      if (localapou.hw() == paramLong) {
        return localapou;
      }
    }
    return null;
  }
  
  public boolean cO(long paramLong)
  {
    Iterator localIterator = this.Ch.iterator();
    while (localIterator.hasNext())
    {
      apou localapou = (apou)localIterator.next();
      if ((localapou.hw() != paramLong) && (localapou.Lz() == 0)) {
        return false;
      }
    }
    return true;
  }
  
  public ArrayList<apou> dU()
  {
    return this.Ch;
  }
  
  public List<Long> gC()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Ch.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Long.valueOf(((apou)localIterator.next()).hw()));
    }
    return localArrayList;
  }
  
  public long hx()
  {
    return this.arO;
  }
  
  public long hy()
  {
    return this.arP;
  }
  
  public void lP(long paramLong)
  {
    this.arP = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apoy
 * JD-Core Version:    0.7.0.1
 */