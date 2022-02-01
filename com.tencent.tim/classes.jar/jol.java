import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.util.WeakReference;

public class jol
{
  HashMap<Integer, WeakReference<jol.a>> mCallbacks = new HashMap();
  skj mClient;
  
  public jol(skj paramskj)
  {
    this.mClient = paramskj;
  }
  
  public void a(int paramInt, jol.a parama)
  {
    if (this.mCallbacks.containsKey(Integer.valueOf(paramInt))) {
      this.mCallbacks.remove(Integer.valueOf(paramInt));
    }
    this.mCallbacks.put(Integer.valueOf(paramInt), new WeakReference(parama));
  }
  
  public void al(Bundle paramBundle)
  {
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("WebPushClient", 2, "data is null");
      }
    }
    WeakReference localWeakReference;
    do
    {
      int i;
      do
      {
        return;
        i = paramBundle.getInt("msgType", -1);
        if (i != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("WebPushClient", 2, "type is 0");
      return;
      localWeakReference = (WeakReference)this.mCallbacks.get(Integer.valueOf(i));
    } while ((localWeakReference == null) || (localWeakReference.get() == null));
    ((jol.a)localWeakReference.get()).am(paramBundle);
  }
  
  public void clear()
  {
    this.mCallbacks.clear();
  }
  
  public void oa(int paramInt)
  {
    this.mCallbacks.remove(Integer.valueOf(paramInt));
  }
  
  public static abstract interface a
  {
    public abstract void am(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jol
 * JD-Core Version:    0.7.0.1
 */