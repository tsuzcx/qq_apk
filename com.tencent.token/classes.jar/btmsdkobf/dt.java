package btmsdkobf;

import android.content.Context;

public class dt
{
  private final int ha = 3;
  private Context ny = null;
  private ds nz = null;
  
  public dt(Context paramContext, ds.a parama, dp paramdp)
  {
    this.ny = paramContext;
    this.nz = new ds(paramContext, parama, paramdp);
  }
  
  public int a(cy.f paramf, byte[] paramArrayOfByte)
  {
    if ((paramf != null) && (paramArrayOfByte != null))
    {
      int i = -1;
      int k;
      int m;
      for (int j = 0;; j = m)
      {
        k = i;
        if (j >= 3) {
          break;
        }
        if (paramf.bP())
        {
          eh.h("TmsTcpNetwork", "[tcp_control][time_out]sendDataAsync(), send time out");
          return -17;
        }
        i = this.nz.a(paramf, paramArrayOfByte);
        StringBuilder localStringBuilder1 = new StringBuilder("[tcp_control]sendDataAsync(), ret: ");
        localStringBuilder1.append(i);
        localStringBuilder1.append(" times: ");
        m = j + 1;
        localStringBuilder1.append(m);
        localStringBuilder1.append(" data.length: ");
        localStringBuilder1.append(paramArrayOfByte.length);
        eh.e("TmsTcpNetwork", localStringBuilder1.toString());
        k = i;
        if (i == 0) {
          break;
        }
        if (2 != j) {
          try
          {
            Thread.sleep(300L);
          }
          catch (InterruptedException localInterruptedException)
          {
            StringBuilder localStringBuilder2 = new StringBuilder("[tcp_control]sendDataAsync() InterruptedException e: ");
            localStringBuilder2.append(localInterruptedException.toString());
            eh.h("TmsTcpNetwork", localStringBuilder2.toString());
          }
        }
      }
      return k;
    }
    return -10;
  }
  
  public String cB()
  {
    return this.nz.cB();
  }
  
  public boolean cH()
  {
    return this.nz.cH();
  }
  
  public int cL()
  {
    eh.f("TmsTcpNetwork", "[tcp_control]close()");
    return this.nz.stop();
  }
  
  public int cM()
  {
    eh.f("TmsTcpNetwork", "[tcp_control]connect()");
    int i = this.nz.i(this.ny);
    eh.e("TmsTcpNetwork", "[ocean] connect |ret|".concat(String.valueOf(i)));
    return i;
  }
  
  public int cN()
  {
    int i = this.nz.cC();
    eh.e("TmsTcpNetwork", "[ocean] reconnect |ret|".concat(String.valueOf(i)));
    return i;
  }
  
  public dp cq()
  {
    return this.nz.cq();
  }
  
  public boolean isNetworkConnected()
  {
    return this.nz.isNetworkConnected();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dt
 * JD-Core Version:    0.7.0.1
 */