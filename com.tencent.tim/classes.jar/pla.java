import java.util.List;

public class pla
  extends plb<pkd.a>
{
  private int bji = 200;
  
  protected long a(pkd.a parama1, pkd.a parama2)
  {
    if ((parama1 != parama2) && (parama1.mCreateTime == parama2.mCreateTime)) {
      return 1L;
    }
    return Math.abs(parama1.mCreateTime - parama2.mCreateTime);
  }
  
  protected pkd.a a(List<pkd.a> paramList)
  {
    long l = 0L;
    int i = 0;
    while (i < paramList.size())
    {
      l += ((pkd.a)paramList.get(i)).mCreateTime;
      i += 1;
    }
    pkd.a locala = new pkd.a();
    locala.mCreateTime = (l / paramList.size());
    return locala;
  }
  
  protected boolean a(pkd.a parama1, pkd.a parama2)
  {
    return parama1.mCreateTime == parama2.mCreateTime;
  }
  
  protected boolean aW(long paramLong)
  {
    int i = sk();
    if (i > 0) {
      if (paramLong / i >= 1500L) {}
    }
    while (paramLong < 200L)
    {
      return true;
      return false;
    }
    return false;
  }
  
  protected int sj()
  {
    return this.bji;
  }
  
  protected double u()
  {
    return 0.3D;
  }
  
  public void vF(int paramInt)
  {
    this.bji = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pla
 * JD-Core Version:    0.7.0.1
 */