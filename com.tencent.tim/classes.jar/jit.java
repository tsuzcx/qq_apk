import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jit
{
  public final String TAG = "AVRedBag_" + getClass().getSimpleName() + "_" + this.pC;
  public WeakReference<jht> bR;
  public VideoAppInterface mApp;
  public long pC = AudioHelper.hG();
  
  jit(jht paramjht)
  {
    this.bR = new WeakReference(paramjht);
    this.mApp = paramjht.b();
  }
  
  public jht a()
  {
    jht localjht = (jht)this.bR.get();
    if (localjht == null) {
      QLog.d(this.TAG, 1, "getRedBagMgr[" + getClass().getName() + "] is null");
    }
    return localjht;
  }
  
  protected void finalize()
    throws Throwable
  {
    QLog.d(this.TAG, 1, "finalize, " + toString());
    super.finalize();
  }
  
  public AVActivity getAVActivity()
  {
    jht localjht = (jht)this.bR.get();
    if (localjht != null) {
      return localjht.getAVActivity();
    }
    return null;
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jit
 * JD-Core Version:    0.7.0.1
 */