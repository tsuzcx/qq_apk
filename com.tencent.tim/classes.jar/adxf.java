import android.support.v4.util.SparseArrayCompat;

public class adxf
{
  private static final adxf a = new adxf();
  private int callbackId;
  private final SparseArrayCompat<adwr> f = new SparseArrayCompat();
  
  public static adxf a()
  {
    return a;
  }
  
  public int a(adwr paramadwr)
  {
    synchronized (this.f)
    {
      do
      {
        this.callbackId += 1;
      } while ((this.f.get(this.callbackId) != null) || (this.callbackId == 0));
      this.f.put(this.callbackId, paramadwr);
      int i = this.callbackId;
      return i;
    }
  }
  
  public void hE(int paramInt1, int paramInt2)
  {
    synchronized (this.f)
    {
      adwr localadwr = (adwr)this.f.get(paramInt1);
      if (localadwr != null) {
        localadwr.co(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  public void oa(int paramInt)
  {
    synchronized (this.f)
    {
      this.f.delete(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxf
 * JD-Core Version:    0.7.0.1
 */