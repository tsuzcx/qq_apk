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
    if ((paramf == null) || (paramArrayOfByte == null))
    {
      i = -10;
      return i;
    }
    int i = -1;
    int j = 0;
    while (j < 3)
    {
      if (paramf.bP())
      {
        eh.h("TmsTcpNetwork", "[tcp_control][time_out]sendDataAsync(), send time out");
        return -17;
      }
      int k = this.nz.a(paramf, paramArrayOfByte);
      eh.e("TmsTcpNetwork", "[tcp_control]sendDataAsync(), ret: " + k + " times: " + (j + 1) + " data.length: " + paramArrayOfByte.length);
      i = k;
      if (k == 0) {
        break;
      }
      if (2 != j) {}
      try
      {
        Thread.sleep(300L);
        j += 1;
        i = k;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          eh.h("TmsTcpNetwork", "[tcp_control]sendDataAsync() InterruptedException e: " + localInterruptedException.toString());
        }
      }
    }
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
    eh.e("TmsTcpNetwork", "[ocean] connect |ret|" + i);
    return i;
  }
  
  public int cN()
  {
    int i = this.nz.cC();
    eh.e("TmsTcpNetwork", "[ocean] reconnect |ret|" + i);
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