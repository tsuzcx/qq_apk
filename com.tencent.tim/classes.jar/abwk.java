import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class abwk
  implements Handler.Callback
{
  private abwi jdField_a_of_type_Abwi;
  private abxb jdField_a_of_type_Abxb;
  private AtomicInteger aZ = new AtomicInteger(-1);
  private Set<Integer> bJ = new CopyOnWriteArraySet();
  private Set<Integer> bK = new CopyOnWriteArraySet();
  private aurf c = new aurf(ThreadManager.getSubThreadLooper(), this);
  private ConcurrentHashMap<Integer, abxc> dB = new ConcurrentHashMap();
  private ConcurrentHashMap<String, abwy> dC = new ConcurrentHashMap();
  
  private void A(int paramInt, Bundle paramBundle)
  {
    abxc localabxc = (abxc)this.dB.get(Integer.valueOf(paramInt));
    if (localabxc == null) {
      return;
    }
    localabxc.cc(paramBundle);
  }
  
  public static boolean Zn()
  {
    return abxh.bGc;
  }
  
  public static abwk a()
  {
    return abwk.a.b();
  }
  
  private void x(int paramInt, Bundle paramBundle)
  {
    abxc localabxc = (abxc)this.dB.get(Integer.valueOf(paramInt));
    if (localabxc != null)
    {
      localabxc.cFT();
      this.dB.remove(Integer.valueOf(paramInt), localabxc);
    }
    localabxc = new abxc(paramInt);
    paramBundle.putBoolean("isSampleFocus", hW(paramInt));
    localabxc.bZ(paramBundle);
    this.dB.put(Integer.valueOf(paramInt), localabxc);
  }
  
  private void y(int paramInt, Bundle paramBundle)
  {
    abxc localabxc = (abxc)this.dB.get(Integer.valueOf(paramInt));
    if (localabxc == null)
    {
      QLog.e("TraceReport" + this.jdField_a_of_type_Abwi.dn(paramInt), 1, new Object[] { "already end the trace, featureId:", Integer.valueOf(paramInt) });
      return;
    }
    localabxc.cb(paramBundle);
    paramBundle = paramBundle.getString("featureKey");
    a().CW(paramBundle);
    this.dB.remove(Integer.valueOf(paramInt), localabxc);
    this.bK.add(Integer.valueOf(paramInt));
  }
  
  private void z(int paramInt, Bundle paramBundle)
  {
    abxc localabxc = (abxc)this.dB.get(Integer.valueOf(paramInt));
    if (localabxc == null) {
      return;
    }
    localabxc.ca(paramBundle);
  }
  
  public void CW(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.dC.remove(paramString);
  }
  
  public int a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      if (this.dC.containsKey(paramString)) {
        return ((abwy)this.dC.get(paramString)).ctg;
      }
    } while (!paramBoolean);
    if (this.aZ.get() <= -2147483648) {
      this.aZ.set(-1);
    }
    int i = this.aZ.decrementAndGet();
    abwy localabwy = new abwy(paramInt, i);
    this.dC.put(paramString, localabwy);
    return i;
  }
  
  public void a(TraceData paramTraceData)
  {
    if ((!Zn()) || (paramTraceData.featureId < 0)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Abxb != null) && (this.jdField_a_of_type_Abwi != null))
      {
        if (this.jdField_a_of_type_Abxb.a(paramTraceData))
        {
          this.c.removeMessages(6);
          this.c.sendEmptyMessageDelayed(6, abxb.ctn);
          return;
        }
        this.c.removeMessages(6);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TraceReport", 2, "sendTraceReport mTraceReportControl or config is null");
  }
  
  public abwi b()
  {
    return this.jdField_a_of_type_Abwi;
  }
  
  public void b(abwi paramabwi)
  {
    abwi localabwi = paramabwi;
    if (paramabwi == null)
    {
      localabwi = abwp.c();
      QLog.e("TraceReport", 1, "init error, outside not init config");
    }
    this.jdField_a_of_type_Abwi = localabwi;
    if (this.jdField_a_of_type_Abxb == null) {
      this.jdField_a_of_type_Abxb = new abxb();
    }
    this.jdField_a_of_type_Abxb.c(localabwi);
    this.c.sendEmptyMessage(0);
  }
  
  public void bl(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.bJ.add(Integer.valueOf(paramInt));
      return;
    }
    this.bJ.remove(Integer.valueOf(paramInt));
  }
  
  public void e(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Abwi == null) {
      b(null);
    }
    int i = a(paramInt, paramString, true);
    if (this.bJ.contains(Integer.valueOf(i))) {
      return;
    }
    this.bK.remove(Integer.valueOf(i));
    paramBundle.putInt("featureId", i);
    if (hW(paramInt))
    {
      paramBundle.putInt("initJavaHeap", abwp.zW());
      paramBundle.putInt("initNativeHeap", abwp.zX());
    }
    this.c.obtainMessage(1, paramBundle).sendToTarget();
  }
  
  public void f(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Abwi == null) {
      b(null);
    }
    int i = a(paramInt, paramString, false);
    if (this.bJ.contains(Integer.valueOf(i))) {
      return;
    }
    paramBundle.putInt("featureId", i);
    if (hW(paramInt))
    {
      paramBundle.putInt("endJavaHeap", abwp.zW());
      paramBundle.putInt("endNativeHeap", abwp.zX());
    }
    this.c.obtainMessage(2, paramBundle).sendToTarget();
  }
  
  public void g(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Abwi == null) {
      b(null);
    }
    paramInt = a(paramInt, paramString, false);
    if (this.bJ.contains(Integer.valueOf(paramInt))) {}
    while (this.bK.contains(Integer.valueOf(paramInt))) {
      return;
    }
    paramBundle.putInt("featureId", paramInt);
    this.c.obtainMessage(3, paramBundle).sendToTarget();
  }
  
  public boolean hW(int paramInt)
  {
    if (this.jdField_a_of_type_Abwi == null) {
      return false;
    }
    return this.jdField_a_of_type_Abwi.hW(paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = (Bundle)paramMessage.obj;
    switch (i)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Abxb != null)
      {
        this.jdField_a_of_type_Abxb.cFR();
        continue;
        x(paramMessage.getInt("featureId"), paramMessage);
        continue;
        y(paramMessage.getInt("featureId"), paramMessage);
        continue;
        z(paramMessage.getInt("featureId"), paramMessage);
        continue;
        if (this.jdField_a_of_type_Abxb != null)
        {
          this.jdField_a_of_type_Abxb.onDestroy();
          continue;
          A(paramMessage.getInt("featureId"), paramMessage);
          continue;
          if (this.jdField_a_of_type_Abxb != null) {
            this.jdField_a_of_type_Abxb.cFS();
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.c.sendEmptyMessage(4);
    this.dB.clear();
    this.bJ.clear();
    this.bK.clear();
    this.dC.clear();
    if (this.jdField_a_of_type_Abwi != null) {
      this.jdField_a_of_type_Abwi.a().onDestroy();
    }
    this.c.removeMessages(6);
  }
  
  public int p(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.dC.containsKey(paramString)) {
      return paramInt;
    }
    return ((abwy)this.dC.get(paramString)).featureId;
  }
  
  public void w(int paramInt, Bundle paramBundle)
  {
    this.c.obtainMessage(5, paramBundle).sendToTarget();
  }
  
  static class a
  {
    private static final abwk a = new abwk(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abwk
 * JD-Core Version:    0.7.0.1
 */