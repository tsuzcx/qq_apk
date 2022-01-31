package btmsdkobf;

import android.content.Context;
import android.os.Handler;
import java.util.LinkedList;

public class cb
{
  private static String TAG = "HttpNetworkManager";
  private final Object V = new Object();
  private cl he;
  private dp hf;
  private boolean hi = false;
  private int hj = 0;
  private LinkedList hk = new LinkedList();
  private Context mContext;
  private Handler mHandler = new fl(this, cx.getLooper());
  
  public cb(Context paramContext, cl paramcl, dp paramdp, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.he = paramcl;
    this.hf = paramdp;
    this.hi = paramBoolean;
  }
  
  private void b(cy.f paramf, byte[] paramArrayOfByte, ca.a parama)
  {
    paramf = new fm(this, paramf, paramArrayOfByte, parama);
    paramArrayOfByte = ee.cT();
    if (cx.ay())
    {
      paramArrayOfByte.addUrgentTask(paramf, "shark-http-send");
      return;
    }
    paramArrayOfByte.addTask(paramf, "shark-http-send");
  }
  
  public void a(cy.f paramf, byte[] paramArrayOfByte, ca.a parama)
  {
    synchronized (this.V)
    {
      this.hk.add(new fo(this, paramArrayOfByte, paramf, parama));
      eh.i(TAG, "[http_control]sendDataAsyn(), waiting tasks: " + this.hk.size());
      this.mHandler.sendEmptyMessage(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cb
 * JD-Core Version:    0.7.0.1
 */