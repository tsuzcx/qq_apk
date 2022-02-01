import android.os.Handler;
import android.os.Message;
import java.util.Map;

public class rnb
{
  private Handler bt;
  protected int bts;
  protected int btt;
  protected int btu;
  private Map<String, rnb.a> gj;
  
  public byte[] a(String paramString, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.gj.containsKey(paramString);
        if (!bool)
        {
          paramString = null;
          return paramString;
        }
        byte[] arrayOfByte = ((rnb.a)this.gj.get(paramString)).data;
        if (arrayOfByte.length < paramLong1)
        {
          paramString = null;
          continue;
          int j = (int)(paramLong2 - paramLong1);
          int k = (int)(arrayOfByte.length - paramLong1);
          int i = k;
          if (j < k) {
            i = j;
          }
          paramString = new byte[i];
          System.arraycopy(arrayOfByte, (int)paramLong1, paramString, 0, i);
          continue;
        }
        if (paramLong1 < paramLong2) {
          continue;
        }
      }
      finally {}
      paramString = null;
    }
  }
  
  public void g(String paramString, long paramLong1, long paramLong2)
  {
    if (this.bt != null)
    {
      Message localMessage = this.bt.obtainMessage(1, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      localMessage.obj = paramString;
      this.bt.sendMessage(localMessage);
    }
  }
  
  public void release()
  {
    this.gj.clear();
    System.gc();
  }
  
  public void setTargetSampleSize(int paramInt)
  {
    this.bts = paramInt;
  }
  
  public void xM(int paramInt)
  {
    this.btt = paramInt;
  }
  
  public void xN(int paramInt)
  {
    this.btu = paramInt;
  }
  
  class a
  {
    byte[] data;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rnb
 * JD-Core Version:    0.7.0.1
 */