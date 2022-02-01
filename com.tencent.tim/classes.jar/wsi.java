import java.util.ArrayList;
import java.util.List;

public class wsi
{
  boolean bfN = false;
  int mSize = 2;
  public List<wsf> rS = new ArrayList();
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    wsf localwsf1 = new wsf();
    if (this.rS.size() == 0)
    {
      e(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    wsf localwsf2 = (wsf)this.rS.get(this.rS.size() - 1);
    localwsf1.a.a(localwsf2.b);
    localwsf1.c.a(localwsf2.d);
    localwsf1.b.c((localwsf1.c.mX + paramFloat1) / 2.0F, (localwsf1.c.mY + paramFloat2) / 2.0F, (localwsf1.c.mWidth + paramFloat3) / 2.0F, (localwsf1.c.mTime + paramLong) / 2L);
    localwsf1.d.c(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.rS.add(localwsf1);
    if (this.bfN)
    {
      this.bfN = false;
      this.rS.remove(0);
    }
    return this.rS.size() > this.mSize;
  }
  
  public List<wsf> bE()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.rS);
    this.rS.clear();
    wsf localwsf = new wsf();
    localwsf.a((wsf)localArrayList.get(localArrayList.size() - 1));
    this.rS.add(localwsf);
    this.bfN = true;
    return localArrayList;
  }
  
  public void e(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    wsf localwsf = new wsf();
    localwsf.e(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.rS.add(localwsf);
  }
  
  public void end()
  {
    if (this.rS.size() == 0) {
      return;
    }
    wsf localwsf = (wsf)this.rS.get(this.rS.size() - 1);
    localwsf.a.a(localwsf.b);
    localwsf.c.a(localwsf.d);
    localwsf.b.a(localwsf.d);
    this.rS.add(localwsf);
  }
  
  public void setMaxSize(int paramInt)
  {
    this.mSize = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wsi
 * JD-Core Version:    0.7.0.1
 */