package wf7;

import android.content.Context;
import android.os.Handler;
import java.util.LinkedList;

public class ez
{
  private static String TAG = "HttpNetworkManager";
  private final Object hx = new Object();
  private boolean lh = false;
  private dt mC;
  private Context mContext;
  private Handler mHandler = new ez.1(this, ea.getLooper());
  private eu ps;
  private int pv = 0;
  private LinkedList<a> pw = new LinkedList();
  
  public ez(Context paramContext, dt paramdt, eu parameu, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mC = paramdt;
    this.ps = parameu;
    this.lh = paramBoolean;
  }
  
  private void b(em.d paramd, byte[] paramArrayOfByte, ey.a parama)
  {
    ea.bV().a(new ez.2(this, paramd, paramArrayOfByte, parama), "shark-http-send");
  }
  
  public void a(em.d paramd, byte[] paramArrayOfByte, ey.a parama)
  {
    synchronized (this.hx)
    {
      this.pw.add(new a(paramArrayOfByte, paramd, parama));
      this.mHandler.sendEmptyMessage(1);
      return;
    }
  }
  
  class a
  {
    public byte[] data = null;
    public em.d pE = null;
    public ey.a pF = null;
    
    public a(byte[] paramArrayOfByte, em.d paramd, ey.a parama)
    {
      this.data = paramArrayOfByte;
      this.pE = paramd;
      this.pF = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ez
 * JD-Core Version:    0.7.0.1
 */