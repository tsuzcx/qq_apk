import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import mqq.observer.BusinessObserver;

public class adxi
  implements BusinessObserver
{
  private static adxi a;
  private final SparseArray<adxh> cq = new SparseArray();
  private int id;
  
  public static adxi a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new adxi();
      }
      return a;
    }
    finally {}
  }
  
  public int a(adxh paramadxh)
  {
    synchronized (this.cq)
    {
      SparseArray localSparseArray2 = this.cq;
      int i = this.id + 1;
      this.id = i;
      localSparseArray2.append(i, paramadxh);
      i = this.id;
      return i;
    }
  }
  
  public int a(Context paramContext, adwq paramadwq)
  {
    return a(new adxh(paramContext, paramadwq));
  }
  
  public int a(Context paramContext, adwv paramadwv)
  {
    return a(new adxh(paramContext, paramadwv));
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("req_id");
    adxh localadxh = (adxh)this.cq.get(i);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.cq.delete(i);
      return;
      localadxh.b(paramBoolean, paramBundle.getBoolean("allow_download", true), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"), paramBundle.getString("jump_url"));
      continue;
      localadxh.d(paramBoolean, paramBundle.getInt("jump", 0), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxi
 * JD-Core Version:    0.7.0.1
 */