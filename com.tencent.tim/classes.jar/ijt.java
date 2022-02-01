import android.util.SparseArray;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectMutexManager.1;
import com.tencent.qphone.base.util.QLog;

public class ijt
  extends ijo
{
  private volatile SparseArray<ijt.a> T = new SparseArray();
  
  protected ijt(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public void X(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("EffectMutexManager", 1, "notifyMutex, fromMuteKey[" + paramInt + "], data[" + paramString + "]");
    }
    this.mApp.runOnUiThread(new EffectMutexManager.1(this, paramInt, paramString));
  }
  
  public void a(int paramInt, ijt.a parama)
  {
    if (parama == null) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("EffectMutexManager", 1, "registerMutexItem, key[" + paramInt + "]");
    }
    this.T.remove(paramInt);
    this.T.put(paramInt, parama);
  }
  
  protected boolean cs(String paramString)
  {
    return false;
  }
  
  protected void onCreate() {}
  
  public static abstract interface a
  {
    public abstract void Y(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijt
 * JD-Core Version:    0.7.0.1
 */