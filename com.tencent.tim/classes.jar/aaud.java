import java.util.LinkedList;
import java.util.Random;

class aaud
{
  private LinkedList<Integer> I = new LinkedList();
  private int ckz;
  private int[] jH;
  private Random mRandom = new Random();
  private int mSize;
  
  public aaud(int paramInt1, int paramInt2)
  {
    this.mSize = paramInt1;
    if (paramInt2 > 0)
    {
      this.jH = new int[paramInt2];
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        this.jH[paramInt1] = -1;
        paramInt1 += 1;
      }
    }
    this.jH = null;
  }
  
  public void Gx(int paramInt)
  {
    if ((this.jH != null) && (this.jH.length > this.ckz))
    {
      this.jH[this.ckz] = paramInt;
      this.ckz += 1;
      this.ckz %= this.jH.length;
    }
  }
  
  public boolean hE(int paramInt)
  {
    if ((this.jH == null) || (this.jH.length == 0)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jH.length)
      {
        if (this.jH[i] == paramInt) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public int nextInt()
  {
    if (this.I.size() == 0)
    {
      i = 0;
      if (i < this.mSize)
      {
        if (hE(i)) {}
        for (;;)
        {
          i += 1;
          break;
          this.I.add(Integer.valueOf(i));
        }
      }
    }
    int i = this.mRandom.nextInt(this.I.size()) % this.mSize;
    int j = ((Integer)this.I.get(i)).intValue();
    this.I.remove(i);
    Gx(j);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaud
 * JD-Core Version:    0.7.0.1
 */