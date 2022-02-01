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
  private LinkedList<ez.a> pw = new LinkedList();
  
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
      this.pw.add(new ez.a(this, paramArrayOfByte, paramd, parama));
      this.mHandler.sendEmptyMessage(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.ez
 * JD-Core Version:    0.7.0.1
 */