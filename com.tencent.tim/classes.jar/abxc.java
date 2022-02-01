import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class abxc
  implements abxd.a, abxd.b
{
  private abwi jdField_a_of_type_Abwi;
  private abxd jdField_a_of_type_Abxd;
  private TraceData jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData = new TraceData();
  private int aNf = 0;
  private ConcurrentHashMap<Integer, abxa> dD = new ConcurrentHashMap();
  private boolean mIsEnd;
  
  public abxc(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureId = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.version = "3.4.4";
    this.jdField_a_of_type_Abxd = new abxd(this);
    this.jdField_a_of_type_Abwi = abwk.a().b();
    this.jdField_a_of_type_Abxd.a(this.jdField_a_of_type_Abwi.zV(), this);
  }
  
  private void cFU()
  {
    this.jdField_a_of_type_Abxd.cancel();
    this.jdField_a_of_type_Abxd.cFX();
    this.jdField_a_of_type_Abxd = null;
  }
  
  private void cFW()
  {
    Iterator localIterator = this.dD.values().iterator();
    while (localIterator.hasNext())
    {
      abxa localabxa = (abxa)localIterator.next();
      if (!localabxa.isEnd)
      {
        if (localabxa.l == null) {
          localabxa.l = new LinkedBlockingQueue();
        }
        abwx localabwx = a("timeout fail", 0L, 0L);
        localabxa.l.offer(localabwx);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue == null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue = new LinkedBlockingQueue();
        }
        localabxa.result = a(-101, localabxa.startTime, localabxa.startTime);
        localabxa.isEnd = true;
        this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue.offer(localabxa);
      }
    }
  }
  
  private long eP()
  {
    return (System.currentTimeMillis() & 0xFFFFFFFF) << 10 | (int)(Math.random() * 1000.0D) & 0x3FF;
  }
  
  private int t(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.traceId = eP();
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.timestamp = paramBundle.getLong("timestamp");
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.startTime = paramBundle.getLong("startTime");
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.serverTime = paramBundle.getLong("serverTime");
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureKey = paramBundle.getString("featureKey");
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.isSampleFocus = paramBundle.getBoolean("isSampleFocus");
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.initJavaHeap = paramBundle.getInt("initJavaHeap");
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.initNativeHeap = paramBundle.getInt("initNativeHeap");
    return -1;
  }
  
  private int u(Bundle paramBundle)
  {
    int i = paramBundle.getInt("spanId");
    int j = paramBundle.getInt("errCode", -100);
    Object localObject = paramBundle.getString("msg");
    long l1 = paramBundle.getLong("timestamp");
    long l2 = paramBundle.getLong("serverTime");
    long l3 = paramBundle.getLong("startTime");
    int k = paramBundle.getInt("extKey");
    long l4 = paramBundle.getLong("extValue");
    paramBundle = (abxa)this.dD.get(Integer.valueOf(i));
    if (paramBundle == null)
    {
      paramBundle = new abxa(i);
      paramBundle.startTime = l3;
      paramBundle.timestamp = l1;
      paramBundle.serverTime = l2;
      this.dD.put(Integer.valueOf(i), paramBundle);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (paramBundle.l == null) {
          paramBundle.l = new LinkedBlockingQueue();
        }
        localObject = a((String)localObject, l1, l2);
        paramBundle.l.offer(localObject);
      }
      if (k > 0)
      {
        if (paramBundle.je == null) {
          paramBundle.je = new HashMap();
        }
        paramBundle.je.put(Integer.valueOf(k), Long.valueOf(l4));
      }
      if (j != -100)
      {
        this.aNf = 2;
        return 0;
      }
      return -1;
    }
  }
  
  private int v(Bundle paramBundle)
  {
    int i = paramBundle.getInt("spanId");
    int j = paramBundle.getInt("errCode");
    long l = paramBundle.getLong("endTime");
    paramBundle = paramBundle.getString("featureKey");
    abwk.a().p(this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureId, paramBundle);
    paramBundle = (abxa)this.dD.get(Integer.valueOf(i));
    if (paramBundle == null) {
      throw new IllegalArgumentException("illegal span");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue = new LinkedBlockingQueue();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue.contains(paramBundle)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue.remove(paramBundle);
    }
    paramBundle.result = a(j, paramBundle.startTime, l);
    paramBundle.isEnd = true;
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue.offer(paramBundle);
    if (j != 0)
    {
      this.aNf = 3;
      return 0;
    }
    return -1;
  }
  
  private int w(Bundle paramBundle)
  {
    this.mIsEnd = true;
    int j = paramBundle.getInt("featureId");
    String str2 = paramBundle.getString("featureKey");
    int i = j;
    if (j == 0) {
      i = this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureId;
    }
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureKey;
    }
    j = abwk.a().p(i, str1);
    if (((i < 0) || (!TextUtils.isEmpty(str1))) && (QLog.isColorLevel())) {
      QLog.d("TraceReport" + this.jdField_a_of_type_Abwi.dn(j), 1, new Object[] { "featureId:", Integer.valueOf(j), ",traceId:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.traceId), ",mappingFeatureId:", Integer.valueOf(i), ",featureKey:", str1 });
    }
    i = paramBundle.getInt("errCode", 0);
    long l = paramBundle.getLong("endTime");
    if (i == -101) {
      cFW();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureId = j;
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.result = a(i, this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.startTime, l);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.isSampleFocus)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endJavaHeap = paramBundle.getInt("endJavaHeap");
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endNativeHeap = paramBundle.getInt("endNativeHeap");
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endJavaHeap == 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endNativeHeap == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endJavaHeap = abwp.zW();
        this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endNativeHeap = abwp.zX();
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.result.ctj = (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endJavaHeap - this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.initJavaHeap);
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.result.ctk = (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endNativeHeap - this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.initNativeHeap);
    }
    if (i != 0) {
      QLog.e("TraceReport" + this.jdField_a_of_type_Abwi.dn(j), 1, new Object[] { "traceEnd:", this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.toString() });
    }
    for (;;)
    {
      abwk.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData);
      this.aNf = 4;
      return 0;
      QLog.i("TraceReport" + this.jdField_a_of_type_Abwi.dn(j), 1, "traceEnd:" + this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.toString());
    }
  }
  
  public abwx a(String paramString, long paramLong1, long paramLong2)
  {
    return new abwx(paramString, paramLong1, paramLong2);
  }
  
  public abwz a(int paramInt, long paramLong1, long paramLong2)
  {
    long l = 0L;
    abwz localabwz = new abwz();
    localabwz.errCode = paramInt;
    localabwz.netType = aqiw.getSystemNetwork(null);
    if (paramLong2 > 0L)
    {
      paramLong1 = paramLong2 - paramLong1;
      if (paramLong1 >= 0L) {
        break label83;
      }
      paramLong1 = l;
    }
    label83:
    for (;;)
    {
      if (paramLong1 > 2147483647L) {}
      for (paramInt = 2147483647;; paramInt = (int)paramLong1)
      {
        localabwz.amq = paramInt;
        return localabwz;
        paramLong2 = SystemClock.uptimeMillis();
        break;
      }
    }
  }
  
  public void bZ(Bundle paramBundle)
  {
    if (this.mIsEnd) {
      return;
    }
    this.aNf = 0;
    this.jdField_a_of_type_Abxd.av(paramBundle);
  }
  
  public void cFT()
  {
    if (this.mIsEnd) {}
    while (this.aNf == 4) {
      return;
    }
    this.mIsEnd = true;
    this.aNf = 4;
    this.jdField_a_of_type_Abxd.av(new Bundle());
  }
  
  public void cFV()
  {
    this.aNf = 3;
    Bundle localBundle = new Bundle();
    if (this.dD.size() > 0) {
      localBundle.putInt("errCode", -101);
    }
    this.jdField_a_of_type_Abxd.av(localBundle);
  }
  
  public void ca(Bundle paramBundle)
  {
    if (this.mIsEnd) {
      return;
    }
    this.aNf = 1;
    this.jdField_a_of_type_Abxd.av(paramBundle);
  }
  
  public void cb(Bundle paramBundle)
  {
    if (this.mIsEnd) {
      return;
    }
    this.aNf = 3;
    this.jdField_a_of_type_Abxd.av(paramBundle);
  }
  
  public void cc(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData == null) {}
    do
    {
      return;
      String str = paramBundle.getString("tuid");
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.extra1 = paramBundle.getInt("extra1");
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.extra2 = paramBundle.getInt("extra2");
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.extra3 = paramBundle.getInt("extra3");
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.tUid = str;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TraceReport" + this.jdField_a_of_type_Abwi.dn(this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureId), 2, new Object[] { "updateTraceData:", paramBundle.toString() });
  }
  
  public int m(Bundle paramBundle)
  {
    int i = this.aNf;
    switch (this.aNf)
    {
    default: 
      cFU();
      return -1;
    case 0: 
      return t(paramBundle);
    case 3: 
      return w(paramBundle);
    case 1: 
      return u(paramBundle);
    }
    return v(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abxc
 * JD-Core Version:    0.7.0.1
 */