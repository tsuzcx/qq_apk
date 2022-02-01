import java.util.ArrayList;
import java.util.Arrays;

public class adfg
{
  private int cEg;
  private int capacity;
  private ArrayList<Long> uj = new ArrayList();
  
  public adfg(int paramInt)
  {
    this.capacity = paramInt;
  }
  
  private int p(float paramFloat)
  {
    if ((paramFloat > 1.0F) || (paramFloat <= 0.0F)) {
      throw new IndexOutOfBoundsException("the percent out of index");
    }
    int j = (int)(this.uj.size() * paramFloat - 1.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  public adfg.a a()
  {
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    double d;
    synchronized (this.uj)
    {
      if (this.uj.size() <= 0)
      {
        localObject = new adfg.a(-1L, -1L, -1L, -1L, -1L, -1.0D, null, 0);
        return localObject;
      }
      Object localObject = new long[this.uj.size()];
      int i = 0;
      while (i < this.uj.size())
      {
        localObject[i] = ((Long)this.uj.get(i)).longValue();
        i += 1;
      }
      Arrays.sort((long[])localObject);
      l1 = localObject[p(0.9F)];
      l2 = localObject[p(0.8F)];
      l3 = localObject[p(0.7F)];
      l4 = localObject[0];
      l5 = localObject[(localObject.length - 1)];
      d = 0.0D;
      i = 0;
      if (i < localObject.length)
      {
        d += localObject[i];
        i += 1;
      }
    }
    return new adfg.a(l1, l2, l3, l4, l5, d / arrayOfLong.length, arrayOfLong, this.cEg);
  }
  
  public boolean bP(long paramLong)
  {
    synchronized (this.uj)
    {
      if (this.uj.size() >= this.capacity) {
        this.uj.remove(0);
      }
    }
    if (!this.uj.add(Long.valueOf(paramLong))) {
      return false;
    }
    this.cEg += 1;
    return true;
  }
  
  public void clear()
  {
    this.uj.clear();
    this.cEg = 0;
  }
  
  public int size()
  {
    return this.uj.size();
  }
  
  public static class a
  {
    public long Sx;
    public long Sy;
    public long Sz;
    public long[] ag;
    public long avg;
    public long max;
    public long min;
    public int num;
    
    public a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, double paramDouble, long[] paramArrayOfLong, int paramInt)
    {
      this.Sx = paramLong1;
      this.Sy = paramLong2;
      this.Sz = paramLong3;
      this.min = paramLong4;
      this.max = paramLong5;
      this.avg = ((0.9D + paramDouble));
      this.num = paramInt;
      this.ag = paramArrayOfLong;
    }
    
    public String toString()
    {
      return "70% :  " + this.Sz + " --------- 80% : " + this.Sy + " --------- 90% : " + this.Sx + " --------- min : " + this.min + " --------- max : " + this.max + " --------- num : " + this.num + "--------arr" + this.ag;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfg
 * JD-Core Version:    0.7.0.1
 */