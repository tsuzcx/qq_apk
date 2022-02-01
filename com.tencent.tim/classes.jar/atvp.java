import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.WpsFileEditStore.2;
import com.tencent.tim.filemanager.core.WpsFileEditStore.5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class atvp
{
  private static atvp a;
  private String cIa = "_share_key2cloudid_pref";
  private String cIb = "_share_taskid2uploadinfo_pref";
  private boolean diF;
  boolean diG = false;
  private Set<String> dt = new HashSet();
  private byte[] hM;
  private Map<String, String> px = new HashMap();
  private Map<String, String> py = new HashMap();
  private Map<String, ArrayList<atvp.a>> pz = new HashMap();
  
  @TargetApi(9)
  private void Zk(String paramString)
  {
    QLog.i("WpsFileEditStore", 1, "[WPSEDIT] removeCloudIdFromPreference. filepath:" + paramString);
    try
    {
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(this.cIa, 0).edit();
      localEditor.remove(paramString);
      if (Build.VERSION.SDK_INT < 9)
      {
        localEditor.commit();
        return;
      }
      localEditor.apply();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void Zl(String paramString)
  {
    try
    {
      QLog.i("WpsFileEditStore", 1, "[WPSEDIT] delTaskId2UploadFileInfo. taskid:" + paramString);
      this.py.remove(String.valueOf(paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static atvp a()
  {
    try
    {
      if (a == null) {
        a = new atvp();
      }
      atvp localatvp = a;
      return localatvp;
    }
    finally {}
  }
  
  private void as(Map<String, String> paramMap)
  {
    if (paramMap != null) {
      try
      {
        if (paramMap.size() > 0)
        {
          QLog.i("WpsFileEditStore", 1, "[WPSEDIT] addTaskId2UploadFileInfos. size:" + paramMap.size());
          this.py.putAll(paramMap);
          if (this.py.size() <= 15)
          {
            paramMap = this.py.entrySet().iterator();
            while (paramMap.hasNext())
            {
              Object localObject = (Map.Entry)paramMap.next();
              String str = (String)((Map.Entry)localObject).getValue();
              localObject = (String)((Map.Entry)localObject).getKey();
              QLog.i("WpsFileEditStore", 1, "[WPSEDIT] addTaskId2UploadFileInfos. taskid:" + (String)localObject + " val:" + str);
            }
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private Set<Long> d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 57	java/util/HashSet
    //   5: dup
    //   6: invokespecial 58	java/util/HashSet:<init>	()V
    //   9: astore_2
    //   10: aload_0
    //   11: getfield 53	atvp:py	Ljava/util/Map;
    //   14: invokeinterface 201 1 0
    //   19: invokeinterface 207 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 212 1 0
    //   31: ifeq +120 -> 151
    //   34: aload_3
    //   35: invokeinterface 216 1 0
    //   40: checkcast 218	java/util/Map$Entry
    //   43: astore 4
    //   45: aload_1
    //   46: aload 4
    //   48: invokeinterface 221 1 0
    //   53: checkcast 135	java/lang/String
    //   56: invokevirtual 234	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   59: ifeq -34 -> 25
    //   62: aload 4
    //   64: invokeinterface 224 1 0
    //   69: checkcast 135	java/lang/String
    //   72: astore 4
    //   74: ldc 72
    //   76: iconst_1
    //   77: new 74	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   84: ldc 236
    //   86: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 4
    //   91: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 228
    //   96: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_2
    //   110: aload 4
    //   112: invokestatic 241	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   115: invokevirtual 245	java/lang/Long:longValue	()J
    //   118: invokestatic 248	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   121: invokeinterface 252 2 0
    //   126: pop
    //   127: aload_3
    //   128: invokeinterface 254 1 0
    //   133: goto -108 -> 25
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    //   141: astore 4
    //   143: aload 4
    //   145: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   148: goto -21 -> 127
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_2
    //   154: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	atvp
    //   0	155	1	paramString	String
    //   9	145	2	localHashSet	HashSet
    //   24	104	3	localIterator	Iterator
    //   43	68	4	localObject	Object
    //   141	3	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	25	136	finally
    //   25	109	136	finally
    //   109	127	136	finally
    //   127	133	136	finally
    //   143	148	136	finally
    //   109	127	141	java/lang/Exception
  }
  
  private String e(byte[] paramArrayOfByte, String paramString)
  {
    paramArrayOfByte = aqhs.bytes2HexStr(paramArrayOfByte);
    return paramArrayOfByte + "@" + paramString;
  }
  
  private void jj(String paramString1, String paramString2)
  {
    try
    {
      QLog.i("WpsFileEditStore", 1, "[WPSEDIT] addTaskId2UploadFileInfo. taskid:" + paramString1 + " val:" + paramString2);
      this.py.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static int n(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    return localSharedPreferences.getInt(paramContext, 0);
  }
  
  public static void n(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putInt(paramContext, paramInt);
    localEditor.commit();
  }
  
  private String rq(String paramString)
  {
    try
    {
      paramString = BaseApplication.getContext().getSharedPreferences(this.cIa, 0).getString(paramString, null);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @TargetApi(9)
  private void t(Set<Long> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() == 0)) {}
    for (;;)
    {
      return;
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        long l = ((Long)paramSet.next()).longValue();
        try
        {
          QLog.i("WpsFileEditStore", 1, "[WPSEDIT] removeOwCloudFileStopRecrdFromPref. taskid:" + l);
          SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(this.cIb, 0).edit();
          localEditor.remove(String.valueOf(l));
          if (Build.VERSION.SDK_INT >= 9) {
            break label128;
          }
          localEditor.commit();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        continue;
        label128:
        localException.apply();
      }
    }
  }
  
  public int a(String paramString, Bundle paramBundle, atvp.c paramc)
  {
    QLog.i("WpsFileEditStore", 1, "[WPSEDIT] checkIsLinkedCloudFile. filePath:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    if (paramc == null)
    {
      QLog.e("WpsFileEditStore", 1, "[WPSEDIT] checkIsLinkedCloudFile. cb = null:");
      return -2;
    }
    ArrayList localArrayList2 = (ArrayList)this.pz.get(paramString);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.pz.put(paramString, localArrayList1);
    }
    localArrayList1.add(new atvp.a(paramString, paramBundle, paramc));
    if (this.dt.contains(paramString))
    {
      QLog.w("WpsFileEditStore", 1, "[WPSEDIT] checkIsLinkedCloudFile. file is checking and wait");
      return 0;
    }
    paramBundle = (String)this.px.get(paramString);
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.i("WpsFileEditStore", 1, "[WPSEDIT] checkIsLinkedCloudFile. start query cloudid");
      new atvq(this).execute(new String[] { paramString });
    }
    for (;;)
    {
      return 0;
      jh(paramString, paramBundle);
    }
  }
  
  @TargetApi(9)
  public void a(long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("WpsFileEditStore", 1, "[WPSEDIT] saveOwCloudFileStopRecrd. error");
      return;
    }
    String str = aqhs.bytes2HexStr(paramArrayOfByte);
    QLog.i("WpsFileEditStore", 1, "[WPSEDIT] saveOwCloudFileStopRecrd. filepath:" + paramString + " strCloudId:" + str + " uploadTaskId:" + paramLong);
    paramArrayOfByte = e(paramArrayOfByte, paramString);
    jj(String.valueOf(paramLong), paramArrayOfByte);
    try
    {
      paramString = BaseApplication.getContext().getSharedPreferences(this.cIb, 0).edit();
      paramString.putString(String.valueOf(paramLong), paramArrayOfByte);
      if (Build.VERSION.SDK_INT < 9)
      {
        paramString.commit();
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    paramString.apply();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, atvp.b paramb)
  {
    Object localObject2 = new StringBuilder().append("[WPSEDIT] onCheckLinkedCloudFileCompleted. filePath:").append(paramString).append(" bCheckSuc:").append(paramBoolean1).append(" isUploaded:").append(paramBoolean2).append(" cloudfileinfo:");
    Object localObject1;
    if (paramb != null)
    {
      localObject1 = paramb.toString();
      QLog.i("WpsFileEditStore", 1, (String)localObject1);
      localObject1 = Looper.getMainLooper();
      if (Thread.currentThread() == ((Looper)localObject1).getThread()) {
        break label124;
      }
      new Handler((Looper)localObject1).post(new WpsFileEditStore.5(this, paramString, paramBoolean1, paramBoolean2, paramb));
    }
    for (;;)
    {
      return;
      localObject1 = "null";
      break;
      label124:
      this.dt.remove(paramString);
      localObject1 = (ArrayList)this.pz.remove(paramString);
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (atvp.a)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((atvp.a)localObject2).a != null)) {
            ((atvp.a)localObject2).a.a(paramString, paramBoolean1, paramBoolean2, paramb, ((atvp.a)localObject2).bH);
          }
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString, atvp.d paramd)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (TextUtils.isEmpty(paramString)) || (paramd == null))
    {
      QLog.e("WpsFileEditStore", 1, "[WPSEDIT] takeOutOwCloudFileStopRecrd. error");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("cloudId", paramArrayOfByte);
    localBundle.putString("filePath", paramString);
    new atvt(this, paramd).execute(new Bundle[] { localBundle });
  }
  
  public void cc(byte[] paramArrayOfByte)
  {
    this.hM = paramArrayOfByte;
  }
  
  protected void jg(String paramString1, String paramString2)
  {
    QLog.i("WpsFileEditStore", 1, "[WPSEDIT] onQueryCloudIdResult. filePath:" + paramString1 + " strCloudId:" + paramString2);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new WpsFileEditStore.2(this, paramString2, paramString1));
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      a(paramString1, false, false, null);
      return;
    }
    this.px.put(paramString1, paramString2);
    jh(paramString1, paramString2);
  }
  
  public void jh(String paramString1, String paramString2)
  {
    QLog.i("WpsFileEditStore", 1, "[WPSEDIT] findCloudFileInfo for filepath:" + paramString1 + " strCloudId:" + paramString2);
    if (this.diG)
    {
      ji(paramString1, paramString2);
      return;
    }
    QLog.i("WpsFileEditStore", 1, "[WPSEDIT] findCloudFileInfo need to fetch defaultdir list");
    if ((this.hM == null) || (this.hM.length == 0))
    {
      QLog.e("WpsFileEditStore", 1, "[WPSEDIT] findCloudFileInfo for dirkye is null");
      a(paramString1, false, false, null);
      return;
    }
    atgi.a().a(this.hM, null, false, 1000, new atvr(this, paramString1, paramString2));
  }
  
  protected void ji(String paramString1, String paramString2)
  {
    QLog.i("WpsFileEditStore", 1, "[WPSEDIT] onFetchedDefaultDirListFor strCloudId:" + paramString2 + " to getcloudItem");
    byte[] arrayOfByte = aqhs.hexStr2Bytes(paramString2);
    atgi.a().getCloudItemById(arrayOfByte, new atvs(this, paramString1, paramString2));
  }
  
  public void nq(long paramLong)
  {
    Zl(String.valueOf(paramLong));
    HashSet localHashSet = new HashSet();
    localHashSet.add(Long.valueOf(paramLong));
    t(localHashSet);
  }
  
  public class a
  {
    public atvp.c a;
    public Bundle bH;
    String filePath;
    
    a(String paramString, Bundle paramBundle, atvp.c paramc)
    {
      this.filePath = paramString;
      this.bH = paramBundle;
      this.a = paramc;
    }
  }
  
  public static class b
  {
    String cHU;
    String cIf;
    byte[] cloudId;
    byte[] hN;
    
    public String toString()
    {
      return "dirkey:" + aqhs.bytes2HexStr(this.hN) + " cloudId:" + aqhs.bytes2HexStr(this.cloudId) + " cloudFileName:" + this.cHU + " cloudSha:" + this.cIf;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, atvp.b paramb, Bundle paramBundle);
  }
  
  public static abstract interface d
  {
    public abstract void a(byte[] paramArrayOfByte, String paramString, Set<Long> paramSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvp
 * JD-Core Version:    0.7.0.1
 */