import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.search.rich.RichNodeController.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class amus
{
  private static String TAG = "RichNodeController";
  private static final Set<WeakReference<amuk>> cU = Collections.synchronizedSet(new HashSet());
  private Runnable ek;
  private int mEndPos;
  private Handler mHandler;
  private int mScrollState = 0;
  private int mStartPos;
  private Map<Integer, amus.a> mX = new ConcurrentHashMap();
  
  private void CL(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "restartPlayTimer:" + paramInt);
    }
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper());
    }
    if (this.ek != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    if (paramInt < 0) {
      return;
    }
    if (this.ek == null) {
      this.ek = new RichNodeController.1(this);
    }
    this.mHandler.postDelayed(this.ek, paramInt);
  }
  
  private void Py(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "pauseAll, puase:" + paramBoolean + " startPos:" + this.mStartPos + " endPos:" + this.mEndPos);
    }
    if (this.mX.size() == 0) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "pauseAll, map is empty");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.mX.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (amus.a)localIterator.next();
        if (localObject != null)
        {
          localObject = ((amus.a)localObject).hQ;
          if (localObject != null)
          {
            localObject = (amuk)((WeakReference)localObject).get();
            if (localObject != null) {
              if (paramBoolean) {
                ((amuk)localObject).pause();
              } else {
                ((amuk)localObject).resume();
              }
            }
          }
        }
      }
    }
  }
  
  private static void b(amuk paramamuk) {}
  
  private void dOu()
  {
    if (this.mX.size() == 0) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mX.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (amus.a)((Map.Entry)localObject1).getValue();
        if (localObject2 == null)
        {
          localIterator.remove();
        }
        else if (((amus.a)localObject2).hQ == null)
        {
          localIterator.remove();
        }
        else
        {
          localObject2 = (amuk)((amus.a)localObject2).hQ.get();
          if (localObject2 == null)
          {
            localIterator.remove();
          }
          else
          {
            localObject1 = (Integer)((Map.Entry)localObject1).getKey();
            if (localObject1 == null)
            {
              ((amuk)localObject2).pause();
              localIterator.remove();
            }
            else if ((((Integer)localObject1).intValue() < this.mStartPos) || (((Integer)localObject1).intValue() > this.mEndPos))
            {
              ((amuk)localObject2).pause();
              localIterator.remove();
            }
          }
        }
      }
    }
  }
  
  public static void onDestroy()
  {
    for (;;)
    {
      synchronized (cU)
      {
        Iterator localIterator = cU.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onDestroy.(item == null");
          }
          localIterator.remove();
        }
      }
      Object localObject2 = (amuk)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "onDestroy.(node == null");
        }
        localObject1.remove();
      }
      else
      {
        b((amuk)localObject2);
        ((amuk)localObject2).destroy();
      }
    }
    cU.clear();
  }
  
  public static void onPause() {}
  
  public static void onResume() {}
  
  public static void pauseAll()
  {
    for (;;)
    {
      synchronized (cU)
      {
        Iterator localIterator = cU.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onPause item == null");
          }
          localIterator.remove();
        }
      }
      Object localObject2 = (amuk)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "onPause node == null");
        }
        localObject1.remove();
      }
      else
      {
        ((amuk)localObject2).pause();
      }
    }
  }
  
  private static void resumeAll()
  {
    for (;;)
    {
      synchronized (cU)
      {
        Iterator localIterator = cU.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onPause item == null");
          }
          localIterator.remove();
        }
      }
      Object localObject2 = (amuk)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "onPause node == null");
        }
        localObject1.remove();
      }
      else
      {
        ((amuk)localObject2).resume();
      }
    }
  }
  
  public void a(int paramInt, amuk paramamuk)
  {
    if (paramamuk == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "registerNode, nPos:" + paramInt);
    }
    this.mX.put(Integer.valueOf(paramInt), new amus.a(paramInt, paramamuk));
    if (this.mScrollState != 0) {
      paramamuk.pause();
    }
    for (;;)
    {
      synchronized (cU)
      {
        Iterator localIterator = cU.iterator();
        if (!localIterator.hasNext()) {
          break label201;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference == null) || (localWeakReference.get() != paramamuk)) {
          continue;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "find in list:" + bool);
        }
        if (!bool) {
          cU.add(new WeakReference(paramamuk));
        }
        return;
      }
      paramamuk.resume();
      continue;
      label201:
      boolean bool = false;
    }
  }
  
  public void ba(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == this.mStartPos) && (this.mEndPos == paramInt1 + paramInt2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "setScorllData, mStartPos:" + this.mStartPos + " endPos:" + this.mEndPos);
    }
    this.mStartPos = paramInt1;
    this.mEndPos = (paramInt1 + paramInt2);
    dOu();
  }
  
  public void setScrollState(int paramInt)
  {
    this.mScrollState = paramInt;
    if (this.mScrollState == 0)
    {
      CL(100);
      return;
    }
    CL(-1);
    pauseAll();
  }
  
  static class a
  {
    WeakReference<amuk> hQ;
    int mPos = -1;
    
    public a(int paramInt, amuk paramamuk)
    {
      this.mPos = paramInt;
      this.hQ = new WeakReference(paramamuk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amus
 * JD-Core Version:    0.7.0.1
 */