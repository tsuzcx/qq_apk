import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.transfile.dns.InnerDns.4;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Laopc;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.mobileqq.configpush.DomainIp.NameRspBody;
import tencent.im.mobileqq.configpush.DomainIp.ServerList;
import tencent.im.mobileqq.configpush.DomainIp.SubCmd_name_Rsp;
import tencent.im.mobileqq.configpush.DomainIp.iplistInfo;

public class aopd
  extends QIPCModule
{
  public static volatile aopd a;
  private String bcr;
  private boolean bvf;
  private final boolean cJi;
  private volatile boolean cNN;
  private Random mRandom = new Random();
  private HashMap<String, HashMap<String, aopc>> nV;
  private BroadcastReceiver q = new aopg(this);
  
  private aopd()
  {
    super("InnerDnsModule");
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      this.cJi = bool;
      if (!this.cJi) {
        break label105;
      }
      localObject = w(BaseApplicationImpl.getApplication().getSharedPreferences("sp_inner_dns", 0).getString("sp_domain", null));
      if (localObject == null) {
        break;
      }
      this.nV = new HashMap((Map)localObject);
      return;
      bool = false;
    }
    this.nV = new HashMap();
    return;
    label105:
    QIPCClientHelper.getInstance().getClient().connect(new aope(this));
    QIPCClientHelper.getInstance().getClient().addListener(new aopf(this));
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.innerdns.domainAddressDataUpdateAction");
    try
    {
      BaseApplicationImpl.getApplication().registerReceiver(this.q, (IntentFilter)localObject, "com.tencent.tim.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private String AQ()
  {
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    String str2 = String.valueOf(aqiw.getSystemNetwork(localContext));
    String str1 = str2;
    if (!aqmr.isEmpty(str2))
    {
      str1 = str2;
      if (str2.equals(String.valueOf(1))) {
        str1 = alif.aF(localContext);
      }
    }
    return str1;
  }
  
  public static aopd a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aopd();
      }
      return a;
    }
    finally {}
  }
  
  private static HashMap<String, aopc> a(List<DomainIp.iplistInfo> paramList, HashMap<String, aopc> paramHashMap)
  {
    if (paramList == null) {}
    Object localObject1;
    String str;
    int i;
    label135:
    Object localObject2;
    do
    {
      return paramHashMap;
      localObject1 = paramHashMap;
      if (paramHashMap == null) {
        localObject1 = new HashMap();
      }
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramHashMap = (HashMap<String, aopc>)localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (DomainIp.iplistInfo)localIterator.next();
        str = paramList.string_dname.get();
        paramHashMap = (HashMap<String, aopc>)localObject1;
        if (aqmr.isEmpty(str)) {
          break;
        }
        paramHashMap = (HashMap<String, aopc>)localObject1;
        if (paramList.int32_result.get() != 0) {
          break;
        }
        i = paramList.uint32_type.get();
        if ((i == 1) || (i == 28)) {
          break label135;
        }
        if (QLog.isColorLevel()) {
          QLog.d("InnerDns", 2, "onDomainServerListUpdate unexpected type=" + i);
        }
      }
      localObject2 = paramList.ServerList_data.get();
      paramHashMap = (HashMap<String, aopc>)localObject1;
    } while (localObject2 == null);
    if ((((HashMap)localObject1).containsKey(str)) && (((HashMap)localObject1).get(str) != null))
    {
      paramList = (aopc)((HashMap)localObject1).get(str);
      if (paramList.xp != null) {
        break label391;
      }
      paramList.xp = new ArrayList();
    }
    label391:
    for (;;)
    {
      paramHashMap = ((List)localObject2).iterator();
      for (;;)
      {
        if (paramHashMap.hasNext())
        {
          localObject2 = (DomainIp.ServerList)paramHashMap.next();
          aoph localaoph = new aoph();
          localaoph.mIp = ((DomainIp.ServerList)localObject2).string_IP.get();
          localaoph.mPort = ((DomainIp.ServerList)localObject2).uint32_Port.get();
          localaoph.mType = i;
          paramList.xp.add(localaoph);
          if (QLog.isColorLevel())
          {
            QLog.d("InnerDns", 2, "onDomainServerListUpdate type=" + i + " d:" + str + " " + localaoph.mIp + " " + localaoph.mPort);
            continue;
            paramList = new aopc(str, new ArrayList());
            break;
          }
        }
      }
      if (paramList.xp.size() <= 0) {
        break;
      }
      ((HashMap)localObject1).put(str, paramList);
      break;
    }
  }
  
  private void a(ArrayList<String> paramArrayList, ArrayList<aoph> paramArrayList1, int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = paramArrayList1.iterator();
    aoph localaoph;
    String str;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localaoph = (aoph)localIterator.next();
        if (localaoph.mType == paramInt)
        {
          str = localaoph.mIp;
          if ((localaoph.mType == 1) && (localaoph.mPort != 80) && (paramBoolean)) {
            paramArrayList1 = str + ":" + localaoph.mPort;
          }
        }
      }
    }
    for (;;)
    {
      paramArrayList.add(paramArrayList1);
      break;
      paramArrayList1 = str;
      if (localaoph.mType == 28)
      {
        str = "[" + str + "]";
        paramArrayList1 = str;
        if (localaoph.mPort != 80)
        {
          paramArrayList1 = str;
          if (paramBoolean)
          {
            paramArrayList1 = str + ":" + localaoph.mPort;
            continue;
            return;
          }
        }
      }
    }
  }
  
  private ArrayList<aoph> ap(ArrayList<aoph> paramArrayList)
  {
    if (paramArrayList != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        int i = paramArrayList.size();
        if (i == 0)
        {
          localObject = null;
          return localObject;
        }
        localObject = paramArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (((aoph)((Iterator)localObject).next()).aON <= 0) {
            continue;
          }
          ((Iterator)localObject).remove();
          continue;
        }
        localObject = paramArrayList;
      }
      finally {}
      if (paramArrayList.size() > 1)
      {
        localObject = paramArrayList;
        if (this.mRandom.nextInt() % 10 == 0)
        {
          Collections.shuffle(paramArrayList);
          localObject = paramArrayList;
        }
      }
    }
  }
  
  public static aopd b()
  {
    return a;
  }
  
  public static String b(HashMap<String, HashMap<String, aopc>> paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      JSONArray localJSONArray = new JSONArray();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (HashMap)((Map.Entry)localObject).getValue();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("net_identifier", str);
        localJSONObject.put("domain_map", aopc.b((HashMap)localObject));
        localJSONArray.put(localJSONObject);
      }
      paramHashMap = localJSONArray.toString();
    }
    catch (Throwable paramHashMap)
    {
      paramHashMap.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("InnerDns", 2, "parse failed");
      }
      return null;
    }
    return paramHashMap;
  }
  
  public static String bK(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    Object localObject2;
    if (!aqmr.isEmpty(paramString2))
    {
      localObject1 = paramString1;
      if (!aqmr.isEmpty(paramString1))
      {
        localObject2 = null;
        localObject1 = paramString1;
        if (paramString1 != null)
        {
          if (!paramString1.startsWith("http://")) {
            break label71;
          }
          localObject1 = "http://" + paramString2 + "/";
        }
      }
    }
    for (;;)
    {
      localObject1 = aonc.bJ(paramString1, (String)localObject1);
      return localObject1;
      label71:
      localObject1 = localObject2;
      if (paramString1.startsWith("https://")) {
        localObject1 = "https://" + paramString2 + "/";
      }
    }
  }
  
  private void dWw()
  {
    if (this.bvf)
    {
      ThreadManager.postImmediately(new InnerDns.4(this), null, false);
      return;
    }
    QLog.e("InnerDns", 1, "syncAddressData fail, ipc is not connected.");
  }
  
  public static String getHostFromUrl(String paramString)
  {
    if (aqmr.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramString = new URL(paramString).getHost();
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private boolean s(byte[] paramArrayOfByte)
  {
    List localList = null;
    HashMap localHashMap = new HashMap();
    Object localObject = localHashMap;
    for (;;)
    {
      try
      {
        DomainIp.NameRspBody localNameRspBody = new DomainIp.NameRspBody();
        if (paramArrayOfByte != null)
        {
          localObject = localHashMap;
          localNameRspBody.mergeFrom(paramArrayOfByte);
        }
        localObject = localHashMap;
        paramArrayOfByte = (DomainIp.SubCmd_name_Rsp)localNameRspBody.SubCmd_name_Rsp.get();
        if (paramArrayOfByte == null) {
          break label243;
        }
        localObject = localHashMap;
        localList = paramArrayOfByte.iplistInfo.get();
        localObject = localHashMap;
        paramArrayOfByte = paramArrayOfByte.iplistInfoV6.get();
        if ((localList != null) || (paramArrayOfByte != null)) {
          continue;
        }
        paramArrayOfByte = localHashMap;
        bool = false;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = (byte[])localObject;
        boolean bool = false;
        continue;
      }
      if (bool) {
        localObject = AQ();
      }
      try
      {
        if (!aqmr.isEmpty((String)localObject))
        {
          if ((this.nV.size() >= 3) && (!this.nV.containsKey(localObject))) {
            this.nV.clear();
          }
          this.nV.put(localObject, paramArrayOfByte);
        }
        if (this.cJi) {
          BaseApplicationImpl.getApplication().getSharedPreferences("sp_inner_dns", 0).edit().putString("sp_domain", b(this.nV)).commit();
        }
        return bool;
      }
      finally {}
      localObject = localHashMap;
      localHashMap = a(localList, localHashMap);
      localObject = localHashMap;
      paramArrayOfByte = a(paramArrayOfByte, localHashMap);
      bool = true;
      continue;
      label243:
      paramArrayOfByte = null;
    }
  }
  
  public static HashMap<String, HashMap<String, aopc>> w(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        HashMap localHashMap = new HashMap();
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject = paramString.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("net_identifier");
          localObject = aopc.w(((JSONObject)localObject).getString("domain_map"));
          if (localObject != null) {
            localHashMap.put(str, localObject);
          }
          i += 1;
        }
        return localHashMap;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("InnerDns", 2, "unParse failed");
    return null;
  }
  
  public void X(String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "reportBadIp domian: " + paramString1 + " ip:" + paramString2 + " busiType:" + paramInt + " ServerProcName:" + this.bcr);
    }
    paramString2 = paramString2.replaceAll("\\[(.*)\\]", "$1");
    int i;
    boolean bool1;
    if ((aqmr.isEmpty(paramString1)) || (aqmr.isEmpty(paramString2)) || (paramString1.equals(paramString2)))
    {
      i = 40;
      bool1 = false;
    }
    label471:
    label481:
    label484:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("InnerDns", 2, "reportBadIp succeeded:" + bool1 + " error=" + i);
      }
      Object localObject = new HashMap();
      ((HashMap)localObject).put("domain", paramString1);
      ((HashMap)localObject).put("ip", paramString2);
      ((HashMap)localObject).put("businessType", String.valueOf(paramInt));
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actDnsBadIp", bool1, BaseApplicationImpl.sProcessId, 0L, (HashMap)localObject, "");
      return;
      localObject = AQ();
      if ((this.nV != null) && (this.nV.containsKey(localObject)))
      {
        try
        {
          localObject = (HashMap)this.nV.get(localObject);
          if (((HashMap)localObject).containsKey(paramString1))
          {
            localObject = (aopc)((HashMap)localObject).get(paramString1);
            if (((aopc)localObject).xp != null)
            {
              localObject = ((aopc)localObject).xp.iterator();
              while (((Iterator)localObject).hasNext())
              {
                aoph localaoph = (aoph)((Iterator)localObject).next();
                if (paramString2.equals(localaoph.mIp)) {
                  localaoph.aON += 1;
                }
              }
            }
          }
        }
        finally {}
        bool1 = true;
        i = 0;
        label378:
        if (this.cJi) {
          break label484;
        }
        if (!this.bvf) {
          break label471;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("domain", paramString1);
        ((Bundle)localObject).putString("ip", paramString2);
        ((Bundle)localObject).putInt("businessType", paramInt);
        if (QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "reportBadIp", (Bundle)localObject).isSuccess()) {
          break label481;
        }
        i = 20;
        bool1 = bool2;
      }
      for (;;)
      {
        break;
        i = 60;
        bool1 = false;
        break label378;
        i = 10;
        bool1 = false;
        break;
      }
    }
  }
  
  public String a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    paramString = a(paramString, paramInt1, paramBoolean, paramInt2, true);
    if ((paramString != null) && (paramString.size() > 0)) {}
    for (paramString = (String)paramString.get(0);; paramString = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("InnerDns", 2, "reqDns after dns:" + paramString);
      }
      return paramString;
    }
  }
  
  public ArrayList<String> a(String paramString, int paramInt)
  {
    ArrayList localArrayList = a(paramString, paramInt, true, 1, true);
    return aolo.i(a(paramString, paramInt, true, 28, true), localArrayList);
  }
  
  public ArrayList<String> a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return a(paramString, paramInt1, paramBoolean, paramInt2, true);
  }
  
  public ArrayList<String> a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "reqDns, p:" + BaseApplicationImpl.sProcessId + " d:" + paramString + " b:" + paramInt1 + "N:" + this.bcr + " t:" + paramInt2);
    }
    if (aqmr.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    boolean bool = true;
    Object localObject;
    if ((this.cJi) || ((this.nV != null) && (!this.nV.isEmpty()))) {
      localObject = AQ();
    }
    label518:
    label527:
    label530:
    do
    {
      for (;;)
      {
        try
        {
          if (this.nV.containsKey(localObject))
          {
            localObject = (HashMap)this.nV.get(localObject);
            if (!((HashMap)localObject).containsKey(paramString)) {
              break label544;
            }
            localObject = ap(((aopc)((HashMap)localObject).get(paramString)).xp);
            if ((localObject != null) && (((ArrayList)localObject).size() > 0))
            {
              if (((aoph)((ArrayList)localObject).get(0)).aON <= 0) {
                break label527;
              }
              i = 1;
              break label530;
              localObject = new HashMap();
              ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
              ((HashMap)localObject).put("domain", paramString);
              ((HashMap)localObject).put("ipType", String.valueOf(paramInt2));
              ((HashMap)localObject).put("businessType", String.valueOf(paramInt1));
              anpc.a(BaseApplication.getContext()).collectPerformance(null, "actDnsReq", paramBoolean1, BaseApplicationImpl.sProcessId, 0L, (HashMap)localObject, "");
              paramString = localArrayList;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("InnerDns", 2, "reqDnsForIpList succeeded:" + paramBoolean1 + " retList=" + localArrayList + " error=" + i);
              return localArrayList;
            }
            i = 1;
            break label530;
            a(localArrayList, (ArrayList)localObject, paramInt2, paramBoolean2);
            paramBoolean1 = true;
            i = 0;
            break label541;
          }
          dWx();
          paramBoolean1 = false;
          i = 60;
          continue;
          if (!this.bvf) {
            break label518;
          }
        }
        finally {}
        if (paramBoolean1)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("domain", paramString);
          ((Bundle)localObject).putInt("ipType", paramInt2);
          ((Bundle)localObject).putInt("businessType", paramInt1);
          localObject = QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "reqDomain2IpList", (Bundle)localObject);
          if (((EIPCResult)localObject).isSuccess())
          {
            localArrayList = ((EIPCResult)localObject).data.getStringArrayList("ip");
            paramBoolean1 = bool;
          }
          for (;;)
          {
            break;
            paramBoolean1 = false;
            i = 20;
          }
        }
        i = 10;
        paramBoolean1 = false;
      }
      i = 0;
    } while (i == 0);
    paramBoolean1 = false;
    for (i = 30;; i = 50)
    {
      label541:
      break;
      label544:
      paramBoolean1 = false;
    }
  }
  
  public String aC(String paramString, int paramInt)
  {
    return e(paramString, paramInt, true);
  }
  
  /* Error */
  public void aoq()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	aopd:cJi	Z
    //   4: ifeq +43 -> 47
    //   7: ldc 2
    //   9: monitorenter
    //   10: invokestatic 53	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   13: ldc 55
    //   15: iconst_0
    //   16: invokevirtual 59	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   19: invokeinterface 448 1 0
    //   24: ldc 61
    //   26: aload_0
    //   27: getfield 78	aopd:nV	Ljava/util/HashMap;
    //   30: invokestatic 449	aopd:b	(Ljava/util/HashMap;)Ljava/lang/String;
    //   33: invokeinterface 455 3 0
    //   38: invokeinterface 458 1 0
    //   43: pop
    //   44: ldc 2
    //   46: monitorexit
    //   47: invokestatic 53	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   50: aload_0
    //   51: getfield 41	aopd:q	Landroid/content/BroadcastReceiver;
    //   54: invokevirtual 614	com/tencent/common/app/BaseApplicationImpl:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   57: return
    //   58: astore_1
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: aload_1
    //   66: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   69: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	aopd
    //   58	5	1	localObject	Object
    //   64	2	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   10	47	58	finally
    //   59	62	58	finally
    //   47	57	64	java/lang/Exception
  }
  
  public void dWx()
  {
    if ((BaseApplicationImpl.sProcessId == 1) && (!this.cNN))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localQQAppInterface.startServlet(new NewIntent(localQQAppInterface.getApp(), anef.class));
      this.cNN = true;
    }
  }
  
  public String e(String paramString, int paramInt, boolean paramBoolean)
  {
    if (aolo.azX()) {
      return a(paramString, paramInt, paramBoolean, 28);
    }
    return a(paramString, paramInt, paramBoolean, 1);
  }
  
  public void j(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "onReceivePush:" + BaseApplicationImpl.sProcessId);
    }
    this.cNN = false;
    if (!this.cJi) {}
    Object localObject1;
    do
    {
      return;
      Object localObject2 = null;
      localObject1 = localObject2;
      try
      {
        ByteBuffer localByteBuffer = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject1 = localObject2;
        paramFromServiceMsg = new byte[localByteBuffer.getInt() - 4];
        localObject1 = paramFromServiceMsg;
        localByteBuffer.get(paramFromServiceMsg);
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          QLog.e("InnerDns", 1, "decode failed:" + paramFromServiceMsg.getMessage());
          paramFromServiceMsg = (FromServiceMsg)localObject1;
        }
      }
      try
      {
        if (s(paramFromServiceMsg))
        {
          paramFromServiceMsg = new Intent();
          paramFromServiceMsg.setAction("com.tencent.innerdns.domainAddressDataUpdateAction");
          BaseApplicationImpl.getApplication().sendBroadcast(paramFromServiceMsg, "com.tencent.tim.msg.permission.pushnotify");
          return;
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.e("InnerDns", 1, "onReceivePush sendBroadcast fail:" + paramFromServiceMsg.getMessage());
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("InnerDns", 2, "decode failed.");
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Bundle localBundle = new Bundle();
    if ("reqDomain2IpList".equals(paramString)) {
      localBundle.putStringArrayList("ip", a(paramBundle.getString("domain"), paramBundle.getInt("businessType"), false, paramBundle.getInt("ipType", 1), true));
    }
    for (;;)
    {
      return EIPCResult.createSuccessResult(localBundle);
      if ("reportBadIp".equals(paramString)) {
        X(paramBundle.getString("domain"), paramBundle.getString("ip"), paramBundle.getInt("businessType"));
      } else if ("syncAddressData".equals(paramString)) {
        localBundle.putString("addressData", b(this.nV));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopd
 * JD-Core Version:    0.7.0.1
 */