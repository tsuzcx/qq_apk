import android.os.Handler;
import android.os.Looper;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Locale;

public class wyy
{
  private static boolean mEnabled;
  private static Handler mHandler;
  WeakReference<wyv> eb;
  LinkedList<WeakReference<wyv>> mList;
  
  public wyy()
  {
    mEnabled = Su();
    if (!mEnabled) {
      return;
    }
    this.mList = new LinkedList();
    mHandler = new wyz(this, Looper.getMainLooper());
    MagnifierSDK.a().a().a(new wza(this));
  }
  
  private boolean Su()
  {
    aeix.e locale = aeiy.b(380).a();
    if ((locale == null) || (locale.a() == null))
    {
      QLog.i("ArkApp.ArkAppContainerMRUUpdater", 1, "confBean.getConfig() get fail");
      return false;
    }
    return locale.a().bUm;
  }
  
  private void Zz()
  {
    xS("do clear");
    this.mList.clear();
  }
  
  public static wyy a()
  {
    return wyy.a.b;
  }
  
  private void cdx() {}
  
  public static void clear()
  {
    if (!mEnabled) {
      return;
    }
    mHandler.sendMessage(mHandler.obtainMessage(4));
  }
  
  public static void g(WeakReference<wyv> paramWeakReference)
  {
    if (!mEnabled) {
      return;
    }
    mHandler.sendMessage(mHandler.obtainMessage(1, paramWeakReference));
  }
  
  public static void h(WeakReference<wyv> paramWeakReference)
  {
    if (!mEnabled) {
      return;
    }
    mHandler.sendMessage(mHandler.obtainMessage(2, paramWeakReference));
  }
  
  public static void i(WeakReference<wyv> paramWeakReference)
  {
    if (!mEnabled) {
      return;
    }
    mHandler.sendMessage(mHandler.obtainMessage(3, paramWeakReference));
  }
  
  private void j(WeakReference<wyv> paramWeakReference)
  {
    if (paramWeakReference == null) {}
    while (this.eb != paramWeakReference) {
      return;
    }
    int i = this.mList.indexOf(this.eb);
    int j = this.mList.size();
    if ((i == -1) || (i == j - 1) || (j == 0))
    {
      this.eb = null;
      return;
    }
    this.eb = ((WeakReference)this.mList.get(i + 1));
  }
  
  private void k(WeakReference<wyv> paramWeakReference)
  {
    if (paramWeakReference == null)
    {
      xS("doMoveToFirst node is null");
      return;
    }
    j(paramWeakReference);
    xS(String.format("doMoveToFirst: %h", new Object[] { paramWeakReference.get() }));
    if ((!this.mList.isEmpty()) && (this.mList.getFirst() == paramWeakReference))
    {
      xS("doMoveToFirst node already in the first position");
      return;
    }
    if (this.mList.contains(paramWeakReference)) {
      this.mList.remove(paramWeakReference);
    }
    this.mList.addFirst(paramWeakReference);
    zp(false);
  }
  
  private void l(WeakReference<wyv> paramWeakReference)
  {
    if (paramWeakReference == null)
    {
      xS("doMoveToFirstInActive node is null");
      return;
    }
    xS(String.format("doMoveToFirstInActive: %h", new Object[] { paramWeakReference.get() }));
    if ((this.mList.isEmpty()) || (!this.mList.contains(paramWeakReference)))
    {
      xS("doMoveToFirstInActive node not in the list");
      return;
    }
    this.mList.remove(paramWeakReference);
    if (this.eb == null) {
      this.mList.addLast(paramWeakReference);
    }
    for (;;)
    {
      this.eb = paramWeakReference;
      zp(false);
      return;
      int i = this.mList.indexOf(this.eb);
      if (i > 0) {
        this.mList.add(i, paramWeakReference);
      }
    }
  }
  
  private void m(WeakReference<wyv> paramWeakReference)
  {
    if (paramWeakReference == null)
    {
      xS("doRemove node is null");
      return;
    }
    xS(String.format("doRemove %h", new Object[] { paramWeakReference.get() }));
    j(paramWeakReference);
    this.mList.remove(paramWeakReference);
  }
  
  private static void xS(String paramString) {}
  
  private static void xT(String paramString)
  {
    QLog.i("ArkApp.ArkAppContainerMRUUpdater", 1, String.format(Locale.CHINA, paramString, new Object[0]));
  }
  
  private void zp(boolean paramBoolean)
  {
    int j = 0;
    if (this.mList.isEmpty())
    {
      xS("removeLast, list is empty");
      return;
    }
    int m = this.mList.size();
    int i;
    label38:
    int k;
    if (paramBoolean)
    {
      i = m;
      if (i <= 0) {
        break label151;
      }
      k = this.mList.indexOf(this.eb);
      if (k > 0) {
        j = m - k;
      }
      k = i;
      if (i > j) {
        k = j;
      }
      xS("removeLast, size = " + m + ", toBeRemovedCount = " + k + " , numOfInactive = " + j);
    }
    for (;;)
    {
      WeakReference localWeakReference;
      if (k > 0)
      {
        localWeakReference = (WeakReference)this.mList.peekLast();
        if (localWeakReference != null) {}
      }
      else
      {
        cdx();
        return;
        i = m - 10;
        break;
        label151:
        i = 0;
        break label38;
      }
      wyv localwyv = (wyv)localWeakReference.get();
      if (localwyv != null)
      {
        localwyv.doOnEvent(2);
        wyv.a(localwyv);
        wyv.b(localwyv);
      }
      m(localWeakReference);
      k -= 1;
    }
  }
  
  static class a
  {
    public static final wyy b = new wyy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyy
 * JD-Core Version:    0.7.0.1
 */