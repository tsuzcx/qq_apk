import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.mm.hardcoder.HCPerfManager.1;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class tzb
{
  static RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool;
  private static tzb jdField_a_of_type_Tzb;
  public static final String aKi = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/hc/hardcoder.so";
  public static final String aKj = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/hc/hardcoder_new.so";
  public static boolean aQM;
  static RecyclablePool b;
  private static final int[] fl = { 0, 1, 2, 3 };
  private static final int[] fm = { 0, 1, 2, 3 };
  private LinkedBlockingQueue<Object> m = new LinkedBlockingQueue();
  private boolean running;
  
  static
  {
    jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(tzb.a.class, 4);
    b = new RecyclablePool(tzb.b.class, 4);
  }
  
  public static tzb a()
  {
    if (jdField_a_of_type_Tzb == null) {}
    try
    {
      if (jdField_a_of_type_Tzb == null) {
        jdField_a_of_type_Tzb = new tzb();
      }
      return jdField_a_of_type_Tzb;
    }
    finally {}
  }
  
  private void run()
  {
    Log.i("HardCoder.HCPerfManager", String.format("HCPerfManager thread[%d] running", new Object[] { Long.valueOf(Thread.currentThread().getId()) }));
    Object localObject6 = new HashSet();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet2 = new HashSet();
    Object localObject5 = null;
    Object localObject4 = null;
    long l1 = 30000L;
    label441:
    label1091:
    label1116:
    label3676:
    for (;;)
    {
      int k;
      int i;
      int j;
      Object localObject3;
      HashSet localHashSet1;
      long l3;
      Object localObject8;
      Object localObject9;
      Object localObject2;
      long l2;
      Object localObject7;
      long l5;
      int n;
      int i1;
      if (this.running)
      {
        long l4 = System.currentTimeMillis();
        k = this.m.size();
        if (HardCoderJNI.hcDebug) {
          Log.d("HardCoder.HCPerfManager", "StartLoop queue:" + k + " startTask:" + localArrayList.size() + " nextWakeInterval:" + l1);
        }
        i = 0;
        if (k == 0)
        {
          j = 1;
          if (i >= j) {}
        }
        try
        {
          Object localObject1 = this.m.poll(l1, TimeUnit.MILLISECONDS);
          if (localObject1 == null)
          {
            l1 = 30000L;
            localObject1 = null;
            localObject3 = null;
            localHashSet1 = new HashSet();
            l3 = System.currentTimeMillis();
            if (HardCoderJNI.hcDebug) {
              Log.d("HardCoder.HCPerfManager", "InLoop startSize:" + localArrayList.size());
            }
            i = 0;
            for (;;)
            {
              if (i < localArrayList.size())
              {
                localObject8 = (tzb.a)localArrayList.get(i);
                if (localObject8 == null)
                {
                  localObject9 = localObject1;
                  j = i;
                  i = j + 1;
                  localObject1 = localObject9;
                  continue;
                  j = k;
                }
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("HardCoder.HCPerfManager", "queueTask poll: " + localException.getMessage());
            localObject2 = null;
            continue;
            if ((localObject2 instanceof tzb.a))
            {
              localArrayList.add((tzb.a)localObject2);
              localHashSet2.add(Integer.valueOf(((tzb.a)localObject2).hashCode()));
            }
            for (;;)
            {
              i += 1;
              break;
              if ((localObject2 instanceof tzb.b))
              {
                j = ((tzb.b)localObject2).hashCode;
                if (localHashSet2.contains(Integer.valueOf(j))) {
                  localHashMap.put(Integer.valueOf(j), (tzb.b)localObject2);
                } else {
                  ((tzb.b)localObject2).recycle();
                }
              }
              else
              {
                if (!HardCoderJNI.checkEnv) {
                  break label441;
                }
                auqu.fail("queueTask poll invalid object");
              }
            }
            uninit();
            continue;
            if (localHashMap.containsKey(Integer.valueOf(localObject8.hashCode())))
            {
              ((tzb.a)localObject8).stopTime = l3;
              ((tzb.a)localObject8).EY = ((tzb.b)localHashMap.get(Integer.valueOf(localObject8.hashCode()))).EY;
              localHashMap.remove(Integer.valueOf(localObject8.hashCode()));
            }
            l2 = ((tzb.a)localObject8).stopTime - l3;
            if (l2 <= 0L)
            {
              if (HardCoderJNI.hcDebug) {
                Log.d("HardCoder.HCPerfManager", "InLoop STOP:" + i + "/" + localArrayList.size() + " task:" + ((tzb.a)localObject8).toString(l3));
              }
              localArrayList.remove(localObject8);
              localHashSet2.remove(Integer.valueOf(localObject8.hashCode()));
              ((tzb.a)localObject8).recycle();
              j = i - 1;
              localObject9 = localObject2;
            }
            else
            {
              l2 = Math.min(l1, l2);
              l1 = ((tzb.a)localObject8).startTime - l3;
              if (l1 > 0L)
              {
                if (HardCoderJNI.hcDebug) {
                  Log.d("HardCoder.HCPerfManager", "InLoop WAIT:" + i + "/" + localArrayList.size() + " task:" + ((tzb.a)localObject8).toString(l3));
                }
                l1 = Math.min(l2, l1);
                j = i;
                localObject9 = localObject2;
              }
              else
              {
                if (HardCoderJNI.hcDebug) {
                  Log.d("HardCoder.HCPerfManager", "InLoop  RUN:" + i + "/" + localArrayList.size() + " task:" + ((tzb.a)localObject8).toString(l3));
                }
                localObject7 = localObject2;
                if (((tzb.a)localObject8).bDg > 0) {
                  if ((localObject2 != null) && (localObject2.bDg <= ((tzb.a)localObject8).bDg))
                  {
                    localObject7 = localObject2;
                    if (localObject2.bDg == ((tzb.a)localObject8).bDg)
                    {
                      localObject7 = localObject2;
                      if (localObject2.stopTime >= ((tzb.a)localObject8).stopTime) {}
                    }
                  }
                  else
                  {
                    localObject7 = localObject8;
                  }
                }
                localObject2 = localObject3;
                if (((tzb.a)localObject8).bDh > 0) {
                  if ((localObject3 != null) && (localObject3.bDh <= ((tzb.a)localObject8).bDh))
                  {
                    localObject2 = localObject3;
                    if (localObject3.bDh == ((tzb.a)localObject8).bDh)
                    {
                      localObject2 = localObject3;
                      if (localObject3.stopTime >= ((tzb.a)localObject8).stopTime) {}
                    }
                  }
                  else
                  {
                    localObject2 = localObject8;
                  }
                }
                j = i;
                l1 = l2;
                localObject3 = localObject2;
                localObject9 = localObject7;
                if (((tzb.a)localObject8).bDi > 0)
                {
                  localHashSet1.add(localObject8);
                  j = i;
                  l1 = l2;
                  localObject3 = localObject2;
                  localObject9 = localObject7;
                }
              }
            }
          }
          l5 = System.currentTimeMillis();
          if (HardCoderJNI.hcDebug)
          {
            Log.d("HardCoder.HCPerfManager", String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", new Object[] { Long.valueOf(l5 - l3), Long.valueOf(l5 - l4), Integer.valueOf(localArrayList.size()), Integer.valueOf(localHashMap.size()), Integer.valueOf(((HashSet)localObject6).size()), Integer.valueOf(localHashSet1.size()) }));
            localObject8 = new StringBuilder().append("EndLoop CurrCpu:");
            if (localObject4 != null) {
              break label1314;
            }
            localObject7 = "null";
            localObject8 = ((StringBuilder)localObject8).append((String)localObject7).append(" -> MaxCpu:");
            if (localObject2 != null) {
              break label1326;
            }
            localObject7 = "null";
            Log.d("HardCoder.HCPerfManager", (String)localObject7);
            localObject8 = new StringBuilder().append("EndLoop CurrIO:");
            if (localObject5 != null) {
              break label1338;
            }
            localObject7 = "null";
            localObject8 = ((StringBuilder)localObject8).append((String)localObject7).append(" -> MaxIO:");
            if (localObject3 != null) {
              break label1350;
            }
          }
          for (localObject7 = "null";; localObject7 = localObject3.toString(l3))
          {
            Log.d("HardCoder.HCPerfManager", (String)localObject7);
            Log.d("HardCoder.HCPerfManager", String.format("EndLoop BindCore.size cur: %d, need: %d", new Object[] { Integer.valueOf(((HashSet)localObject6).size()), Integer.valueOf(localHashSet1.size()) }));
            if ((localObject2 != localObject4) || (localObject3 != localObject5) || (((HashSet)localObject6).size() != localHashSet1.size())) {
              break label1362;
            }
            localObject7 = new HashSet();
            ((HashSet)localObject7).addAll((Collection)localObject6);
            ((HashSet)localObject7).removeAll(localHashSet1);
            if (!((HashSet)localObject7).isEmpty()) {
              break label1362;
            }
            if (!HardCoderJNI.hcDebug) {
              break label3676;
            }
            Log.i("HardCoder.HCPerfManager", "EndLoop Nothing Changed , Continue.");
            break;
            localObject7 = ((tzb.a)localObject4).toString(l3);
            break label1091;
            localObject7 = localObject2.toString(l3);
            break label1116;
            localObject7 = ((tzb.a)localObject5).toString(l3);
            break label1157;
          }
          l2 = 0L;
          j = 0;
          n = 2147483647;
          localObject8 = new HashSet();
          ((HashSet)localObject8).addAll((Collection)localObject6);
          ((HashSet)localObject8).removeAll(localHashSet1);
          i = ((HashSet)localObject8).size();
          if (i > 0)
          {
            localObject6 = new int[i];
            localObject7 = ((HashSet)localObject8).iterator();
            i = 0;
            while (((Iterator)localObject7).hasNext())
            {
              localObject9 = (tzb.a)((Iterator)localObject7).next();
              Log.i("HardCoder.HCPerfManager", "!cancelBindCore task:" + ((tzb.a)localObject9).toString(l3));
              if ((((tzb.a)localObject9).stopTime <= l3) || (HardCoderJNI.checkEnv))
              {
                if (((tzb.a)localObject9).bDi == 0)
                {
                  if (!HardCoderJNI.checkEnv) {
                    break label1799;
                  }
                  auqu.fail("bindTid:" + ((tzb.a)localObject9).bDi);
                }
                localObject6[i] = ((tzb.a)localObject9).bDi;
                i += 1;
              }
              else
              {
                uninit();
              }
            }
          }
          for (;;)
          {
            if ((!aQM) && (HardCoderJNI.checkEnv)) {
              HardCoderJNI.cancelCpuCoreForThread((int[])localObject6, android.os.Process.myTid(), SystemClock.elapsedRealtimeNanos());
            }
            localObject9 = new int[localHashSet1.size()];
            localObject6 = localHashSet1.iterator();
            i1 = 0;
            k = 0;
            i = n;
            n = i1;
            for (;;)
            {
              if (!((Iterator)localObject6).hasNext()) {
                break label1810;
              }
              localObject7 = (tzb.a)((Iterator)localObject6).next();
              Log.i("HardCoder.HCPerfManager", "requestBindCore task:" + ((tzb.a)localObject7).toString(l3));
              if (((tzb.a)localObject7).stopTime <= l3)
              {
                if (!HardCoderJNI.checkEnv) {
                  break;
                }
                auqu.fail("stopTime:" + (((tzb.a)localObject7).stopTime - l3));
              }
              if (((tzb.a)localObject7).bDi == 0)
              {
                if (!HardCoderJNI.checkEnv) {
                  break label2380;
                }
                auqu.fail("bindTid:" + ((tzb.a)localObject7).bDi);
              }
              localObject9[n] = ((tzb.a)localObject7).bDi;
              n += 1;
              k = ((tzb.a)localObject7).scene;
              l2 = ((tzb.a)localObject7).EW;
              j = ((tzb.a)localObject7).bDj;
              i = Math.min((int)(((tzb.a)localObject7).stopTime - l3), i);
            }
            uninit();
          }
          uninit();
        }
        if (localObject3 == null)
        {
          if (localObject5 != null)
          {
            Log.i("HardCoder.HCPerfManager", "!cancelHighIOFreq task:" + ((tzb.a)localObject5).toString(l3));
            if ((!aQM) && (HardCoderJNI.checkEnv)) {
              HardCoderJNI.cancelHighIOFreq(((tzb.a)localObject5).bDj, SystemClock.elapsedRealtimeNanos());
            }
          }
          if (localObject3 == null) {
            break label3670;
          }
          n = localObject3.bDh;
          k = localObject3.scene;
          l2 = localObject3.EW;
          j = localObject3.bDj;
          i = Math.min((int)(localObject3.stopTime - l3), i);
        }
      }
      for (;;)
      {
        int i2;
        if (localObject2 == null)
        {
          if (localObject4 != null)
          {
            Log.i("HardCoder.HCPerfManager", "!cancelCpuHighFreq task:" + ((tzb.a)localObject4).toString(l3));
            if ((!aQM) && (HardCoderJNI.checkEnv)) {
              HardCoderJNI.cancelCpuHighFreq(((tzb.a)localObject4).bDj, SystemClock.elapsedRealtimeNanos());
            }
          }
          if (localObject2 == null) {
            break label3652;
          }
          i2 = localObject2.bDg;
          k = localObject2.scene;
          l2 = localObject2.EW;
          i1 = localObject2.bDj;
          j = Math.min((int)(localObject2.stopTime - l3), i);
          i = i2;
        }
        for (;;)
        {
          if (j < 2147483647)
          {
            i2 = localObject9.length;
            if (localObject2 != null) {
              break label2591;
            }
            localObject4 = "null";
            if (localObject3 != null) {
              break label2603;
            }
            localObject5 = "null";
            if (localObject2 != null) {
              break label2615;
            }
            localObject6 = "null";
            if (localObject3 != null) {
              break label2627;
            }
            localObject7 = "null";
            Log.i("HardCoder.HCPerfManager", String.format("!UnifyRequest [%d,%d,%d] [%d,%d,%d] TO:%d max CPU:%s IO:%s cur CPU:%s IO:%s", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(i2), Integer.valueOf(j), localObject4, localObject5, localObject6, localObject7 }));
            if (j <= 0) {
              break label2639;
            }
            bool = true;
            auqu.assertTrue(bool);
            if ((k <= 0) && (l2 <= 0L)) {
              break label2645;
            }
            bool = true;
            auqu.assertTrue(bool);
            if (i1 <= 0) {
              break label2651;
            }
            bool = true;
            auqu.assertTrue(bool);
            if ((i <= 0) && (n <= 0) && (localObject9.length <= 0)) {
              break label2657;
            }
          }
          label2657:
          for (boolean bool = true;; bool = false)
          {
            auqu.assertTrue(bool);
            if (!aQM)
            {
              HardCoderJNI.requestUnifyCpuIOThreadCore(k, l2, i, n, (int[])localObject9, j, i1, SystemClock.elapsedRealtimeNanos());
              Log.i("HardCoder.HCPerfManager", String.format("hardcoder requestUnifyCpuIOThreadCore reqScene[%d, %d, %d, %d, %d]", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(j) }));
              if (localObject9.length > 0) {
                Log.i("HardCoder.HCPerfManager", String.format("hardcoder requestUnifyCpuIOThreadCore bindTid=%d", new Object[] { Integer.valueOf(localObject9[0]) }));
              }
            }
            if (aQM) {
              break label2663;
            }
            localObject6 = localHashSet1;
            localObject5 = localObject3;
            localObject4 = localObject2;
            break;
            uninit();
            break label1810;
            if ((localObject5 == localObject3) || (!HardCoderJNI.hcDebug)) {
              break label1876;
            }
            localObject6 = new StringBuilder().append("IOReq:");
            if (localObject5 == null) {}
            for (localObject5 = "null";; localObject5 = ((tzb.a)localObject5).toString(l3))
            {
              Log.d("HardCoder.HCPerfManager", (String)localObject5 + " -> " + localObject3.toString(l3) + " delay:" + (l5 - localObject3.startTime));
              break;
            }
            if ((localObject4 == localObject2) || (!HardCoderJNI.hcDebug)) {
              break label1987;
            }
            localObject5 = new StringBuilder().append("CPUReq:");
            if (localObject4 == null) {}
            for (localObject4 = "null";; localObject4 = ((tzb.a)localObject4).toString(l3))
            {
              Log.d("HardCoder.HCPerfManager", (String)localObject4 + " -> " + localObject2.toString(l3) + " delay:" + (l5 - localObject2.startTime));
              break;
            }
            localObject4 = localObject2.toString(l3);
            break label2058;
            localObject5 = localObject3.toString(l3);
            break label2068;
            localObject6 = localObject2.toString(l3);
            break label2078;
            localObject7 = localObject3.toString(l3);
            break label2088;
            bool = false;
            break label2190;
            bool = false;
            break label2209;
            bool = false;
            break label2222;
          }
          label2663:
          if (localObject2 == localObject2)
          {
            bool = true;
            auqu.assertTrue(bool);
            if (localObject3 != localObject3) {
              break label3195;
            }
            bool = true;
            auqu.assertTrue(bool);
            if (localArrayList.isEmpty())
            {
              if (l1 != 30000L) {
                break label3201;
              }
              bool = true;
              auqu.assertTrue(bool);
              if (j != 2147483647) {
                break label3207;
              }
              bool = true;
              auqu.assertTrue(bool);
              auqu.assertTrue(localHashSet1.isEmpty());
              if (localObject2 != null) {
                break label3213;
              }
              bool = true;
              auqu.assertTrue(bool);
              if (localObject3 != null) {
                break label3219;
              }
              bool = true;
              auqu.assertTrue(bool);
            }
            k = 0;
            if (k >= localArrayList.size()) {
              break label3636;
            }
            localObject4 = (tzb.a)localArrayList.get(k);
            if (HardCoderJNI.hcDebug) {
              Log.d("HardCoder.HCPerfManager", "CheckTask:" + k + "/" + localArrayList.size() + " task:" + ((tzb.a)localObject4).toString(l3));
            }
            if ((((tzb.a)localObject4).bDg <= 0) && (((tzb.a)localObject4).bDh <= 0) && (((tzb.a)localObject4).bDi <= 0)) {
              break label3225;
            }
            bool = true;
            auqu.assertTrue(bool);
            if ((((tzb.a)localObject4).EW <= 0L) && (((tzb.a)localObject4).scene <= 0)) {
              break label3231;
            }
            bool = true;
            auqu.assertTrue(bool);
            localObject5 = "taskInintTime:" + (((tzb.a)localObject4).initTime - l3);
            if (((tzb.a)localObject4).initTime > l3) {
              break label3237;
            }
            bool = true;
            auqu.assertTrue((String)localObject5, bool);
            localObject5 = "taskStopTime:" + (((tzb.a)localObject4).stopTime - l3);
            if (((tzb.a)localObject4).stopTime < l3) {
              break label3243;
            }
            bool = true;
            auqu.assertTrue((String)localObject5, bool);
            localObject5 = "taskHash:" + localObject4.hashCode();
            if (localHashMap.containsKey(Integer.valueOf(localObject4.hashCode()))) {
              break label3249;
            }
            bool = true;
            label3052:
            auqu.assertTrue((String)localObject5, bool);
            if (((tzb.a)localObject4).startTime <= l3) {
              break label3279;
            }
            if (localObject4 == localObject2) {
              break label3255;
            }
            bool = true;
            auqu.assertTrue(bool);
            if (localObject4 == localObject3) {
              break label3261;
            }
            bool = true;
            auqu.assertTrue(bool);
            if (localHashSet1.contains(localObject4)) {
              break label3267;
            }
            bool = true;
            auqu.assertTrue(bool);
            localObject5 = "next:" + l1 + " start:" + (((tzb.a)localObject4).startTime - l3);
            if (l1 > ((tzb.a)localObject4).startTime - l3) {
              break label3273;
            }
            bool = true;
            label3175:
            auqu.assertTrue((String)localObject5, bool);
          }
          label3195:
          do
          {
            k += 1;
            break label2769;
            bool = false;
            break;
            bool = false;
            break label2688;
            bool = false;
            break label2713;
            bool = false;
            break label2728;
            bool = false;
            break label2749;
            bool = false;
            break label2762;
            bool = false;
            break label2876;
            bool = false;
            break label2902;
            bool = false;
            break label2950;
            bool = false;
            break label3000;
            bool = false;
            break label3052;
            bool = false;
            break label3080;
            bool = false;
            break label3095;
            bool = false;
            break label3113;
            bool = false;
            break label3175;
            localObject5 = "nextWake:" + l1 + " stop:" + (((tzb.a)localObject4).stopTime - l3);
            if (l1 > ((tzb.a)localObject4).stopTime - l3) {
              break label3600;
            }
            bool = true;
            auqu.assertTrue((String)localObject5, bool);
            localObject5 = "reqTimeStamp:" + j;
            if ((j <= 0) || (j >= 9223372036854775807L)) {
              break label3606;
            }
            bool = true;
            auqu.assertTrue((String)localObject5, bool);
            localObject5 = "reqTimeStamp:" + j + " stop:" + (((tzb.a)localObject4).stopTime - l3);
            if (j > ((tzb.a)localObject4).stopTime - l3) {
              break label3612;
            }
            bool = true;
            auqu.assertTrue((String)localObject5, bool);
            localObject5 = "reqCpu:" + i + " task:" + ((tzb.a)localObject4).bDg;
            if (i > ((tzb.a)localObject4).bDg) {
              break label3618;
            }
            bool = true;
            auqu.assertTrue((String)localObject5, bool);
            localObject5 = "reqIO:" + n + " task:" + ((tzb.a)localObject4).bDh;
            if (n > ((tzb.a)localObject4).bDh) {
              break label3624;
            }
            bool = true;
            auqu.assertTrue((String)localObject5, bool);
          } while (((tzb.a)localObject4).bDi <= 0);
          label3444:
          auqu.assertTrue(localHashSet1.contains(localObject4));
          label3554:
          if (!((HashSet)localObject8).contains(localObject4)) {}
          for (bool = true;; bool = false)
          {
            auqu.assertTrue(bool);
            break;
            bool = false;
            break label3336;
            bool = false;
            break label3381;
            bool = false;
            break label3444;
            bool = false;
            break label3498;
            bool = false;
            break label3554;
          }
          localObject6 = localHashSet1;
          localObject5 = localObject3;
          localObject4 = localObject2;
          break;
          return;
          i1 = i;
          i2 = j;
          i = 0;
          j = i1;
          i1 = i2;
        }
        n = 0;
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    tzb.a locala = (tzb.a)jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(tzb.a.class);
    locala.delay = paramInt1;
    locala.bDg = paramInt2;
    locala.bDh = paramInt3;
    locala.bDi = paramInt4;
    locala.timeout = paramInt5;
    locala.scene = paramInt6;
    locala.EW = paramLong;
    locala.bDj = paramInt7;
    locala.initTime = System.currentTimeMillis();
    locala.startTime = (locala.initTime + paramInt1);
    locala.stopTime = (locala.initTime + paramInt1 + paramInt5);
    locala.tag = paramString;
    locala.lastUpdateTime = locala.startTime;
    locala.EX = locala.initTime;
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt5 <= 0) || ((paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0)))
    {
      Log.e("HardCoder.HCPerfManager", "ErrorParam task:" + locala.toString(locala.initTime));
      return 0;
    }
    boolean bool = this.m.offer(locala);
    if (HardCoderJNI.hcDebug) {
      Log.d("HardCoder.HCPerfManager", "OutCallAddTask ret:" + bool + " task:" + locala.toString(locala.initTime));
    }
    if (bool) {
      return locala.hashCode();
    }
    return 0;
  }
  
  public boolean fT(int paramInt)
  {
    tzb.b localb = (tzb.b)b.obtain(tzb.b.class);
    localb.EY = System.currentTimeMillis();
    localb.hashCode = paramInt;
    if (paramInt != 0) {}
    for (boolean bool = this.m.offer(localb);; bool = false)
    {
      if (HardCoderJNI.hcDebug) {
        Log.d("HardCoder.HCPerfManager", String.format("OutCallStopTask ret:%b, hashcode:%x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
      }
      return bool;
    }
  }
  
  int init()
  {
    int j = 0;
    Object localObject = null;
    try
    {
      str = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop persist.sys.hardcoder.name").getInputStream())).readLine();
      localObject = str;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          String str;
          int i;
          System.load(aKj);
          HardCoderJNI.initHardCoder((String)localObject, 0, "testapp.hardcoder.client.sock", false);
          this.running = true;
          localObject = new Thread(new HCPerfManager.1(this), "hardcoder-0");
          ((Thread)localObject).setPriority(1);
          ((Thread)localObject).start();
          return 10;
        }
        catch (Throwable localThrowable1)
        {
          QLog.d("HardCoder.HCPerfManager", 1, "", localThrowable1);
          return 7;
        }
        localThrowable2 = localThrowable2;
        QLog.d("HardCoder.HCPerfManager", 1, "", localThrowable2);
      }
    }
    str = Build.CPU_ABI;
    i = j;
    if (str != null)
    {
      i = j;
      if (!str.contains("x86"))
      {
        i = j;
        if (!str.contains("mips")) {
          i = 1;
        }
      }
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (i != 0))
    {
      if (new File(aKj).exists()) {}
      return 4;
    }
    return 1;
  }
  
  public void uninit()
  {
    this.running = false;
  }
  
  public static class a
    extends RecyclablePool.Recyclable
  {
    public long EW;
    public long EX;
    public long EY;
    public int bDg;
    public int bDh;
    public int bDi;
    public int bDj;
    int bDk = 0;
    int bDl = 0;
    public int delay;
    public int[] fn = new int[tzb.p().length];
    public int[] fo = new int[tzb.fm.length];
    public long initTime;
    long lastUpdateTime = 0L;
    public int scene;
    public long startTime;
    public long stopTime;
    public String tag;
    public int timeout;
    
    public String toString(long paramLong)
    {
      return String.format("h:%x[%d,%d,%d][%d,%d][%d,%d,%d][%d,%d,%d][%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.initTime - paramLong), Long.valueOf(this.startTime - paramLong), Long.valueOf(this.stopTime - paramLong), Integer.valueOf(this.delay), Integer.valueOf(this.timeout), Integer.valueOf(this.scene), Long.valueOf(this.EW), Integer.valueOf(this.bDj), Integer.valueOf(this.bDg), Integer.valueOf(this.bDh), Integer.valueOf(this.bDi), this.tag });
    }
  }
  
  public static final class b
    extends RecyclablePool.Recyclable
  {
    public long EY;
    public int hashCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzb
 * JD-Core Version:    0.7.0.1
 */