import android.support.v4.util.SparseArrayCompat;

public class znl
{
  private SparseArrayCompat<SparseArrayCompat<wvs>> b = new SparseArrayCompat(17);
  private SparseArrayCompat<wvr> c = new SparseArrayCompat();
  
  public znl(zof paramzof)
  {
    a(1, new zos(paramzof));
    a(2, new zoe(paramzof));
    a(3, new znp(paramzof));
  }
  
  private void a(int paramInt, wvs paramwvs)
  {
    this.c.put(paramInt, paramwvs);
    int[] arrayOfInt = paramwvs.C();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.b.get(k);
      SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
      if (localSparseArrayCompat2 == null)
      {
        localSparseArrayCompat1 = new SparseArrayCompat();
        this.b.put(k, localSparseArrayCompat1);
      }
      localSparseArrayCompat1.put(paramInt, paramwvs);
      i += 1;
    }
  }
  
  public void CS(int paramInt)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.b.get(paramInt);
    if (localSparseArrayCompat == null) {}
    for (;;)
    {
      return;
      int j = localSparseArrayCompat.size();
      int i = 0;
      while (i < j)
      {
        ((wvs)localSparseArrayCompat.valueAt(i)).Ck(paramInt);
        i += 1;
      }
    }
  }
  
  public <T extends wvr> T a(int paramInt)
  {
    return (wvr)this.c.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znl
 * JD-Core Version:    0.7.0.1
 */