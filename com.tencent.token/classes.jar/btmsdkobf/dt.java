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
      int j = -1;
      int k;
      for (int i = 0; i < 3; i = k)
      {
        if (paramf.bP())
        {
          eh.h("TmsTcpNetwork", "[tcp_control][time_out]sendDataAsync(), send time out");
          return -17;
        }
        j = this.nz.a(paramf, paramArrayOfByte);
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[tcp_control]sendDataAsync(), ret: ");
        localStringBuilder1.append(j);
        localStringBuilder1.append(" times: ");
        k = i + 1;
        localStringBuilder1.append(k);
        localStringBuilder1.append(" data.length: ");
        localStringBuilder1.append(paramArrayOfByte.length);
        eh.e("TmsTcpNetwork", localStringBuilder1.toString());
        if (j == 0) {
          return j;
        }
        if (2 != i) {
          try
          {
            Thread.sleep(300L);
          }
          catch (InterruptedException localInterruptedException)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("[tcp_control]sendDataAsync() InterruptedException e: ");
            localStringBuilder2.append(localInterruptedException.toString());
            eh.h("TmsTcpNetwork", localStringBuilder2.toString());
          }
        }
      }
      return j;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ocean] connect |ret|");
    localStringBuilder.append(i);
    eh.e("TmsTcpNetwork", localStringBuilder.toString());
    return i;
  }
  
  public int cN()
  {
    int i = this.nz.cC();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ocean] reconnect |ret|");
    localStringBuilder.append(i);
    eh.e("TmsTcpNetwork", localStringBuilder.toString());
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