import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class adjd
{
  long Ue;
  long Uf;
  private adja b;
  int cHi;
  AppInterface mAppInterface;
  Object mLock = new Object();
  
  public adjd(AppInterface paramAppInterface)
  {
    this.mAppInterface = paramAppInterface;
    this.b = new adja(paramAppInterface);
  }
  
  private int e(long paramLong, int paramInt)
  {
    this.Ue = Math.max(paramLong, this.Ue);
    this.cHi = Math.max(paramInt, this.cHi);
    if (this.Uf == 0L) {
      return this.cHi;
    }
    return Math.max((int)(100L * paramLong / this.Uf), this.cHi);
  }
  
  public void a(ArrayList<adja.b> paramArrayList, adjd.a parama)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad");
    this.Uf = 0L;
    this.Ue = 0L;
    this.cHi = 0;
    if (paramArrayList.size() < 1) {
      return;
    }
    Object localObject = paramArrayList.iterator();
    adja.b localb;
    while (((Iterator)localObject).hasNext())
    {
      localb = (adja.b)((Iterator)localObject).next();
      this.Uf = Math.max(this.Uf, localb.fileSize);
    }
    if (parama != null) {
      parama.cRX();
    }
    localObject = (ArrayList)paramArrayList.clone();
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad size is " + ((ArrayList)localObject).size());
    int i = 0;
    label129:
    if (i < paramArrayList.size())
    {
      if (((adja.b)paramArrayList.get(i)).type == 4) {
        break label187;
      }
      this.b.a((adja.b)paramArrayList.get(i), new adje(this, parama, paramArrayList, (ArrayList)localObject));
    }
    for (;;)
    {
      i += 1;
      break label129;
      break;
      label187:
      if (((adja.b)paramArrayList.get(i)).type == 4)
      {
        jpa.init();
        localb = (adja.b)paramArrayList.get(i);
        jpa.a(((adja.b)paramArrayList.get(i)).url, this.mAppInterface, new adjf(this, parama, (ArrayList)localObject, localb), true, 0, true);
      }
    }
  }
  
  public void cRV()
  {
    synchronized (this.mLock)
    {
      uo();
      return;
    }
  }
  
  public void uninit()
  {
    if (this.b != null) {
      this.b.stop();
    }
  }
  
  public void uo()
  {
    if (this.b != null) {
      this.b.cSb();
    }
  }
  
  public static abstract interface a
  {
    public abstract void Gl(boolean paramBoolean);
    
    public abstract void KV(int paramInt);
    
    public abstract void bs(int paramInt, boolean paramBoolean);
    
    public abstract void cRX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjd
 * JD-Core Version:    0.7.0.1
 */