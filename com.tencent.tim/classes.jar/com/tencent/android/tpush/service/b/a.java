package com.tencent.android.tpush.service.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.inappmessage.g;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.MessageManager;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.protocol.j;
import com.tencent.android.tpush.service.util.f;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.tencent.tpns.mqttchannel.api.MqttChannel;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JgClassChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.INTENTSCHEMECHECK, com.jg.EType.INTENTCHECK, com.jg.EType.RECEIVERCHECK})
public class a
{
  private static a a = new a();
  private static final byte[] b = new byte[0];
  private static long c = 0L;
  private static volatile boolean d = false;
  private static volatile boolean e = false;
  private static volatile boolean f = false;
  private static volatile boolean g = false;
  private static ConcurrentHashMap<Long, Map<String, List<Long>>> h = null;
  
  public static a a()
  {
    c();
    return a;
  }
  
  private Object a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = com.tencent.android.tpush.common.d.a(Rijndael.decrypt(com.tencent.android.tpush.service.util.d.a(paramContext, paramString1 + paramString2)));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("SrvMessageManager", "getSettings", paramContext);
    }
    return null;
  }
  
  private ArrayList<MessageId> a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!i.b(paramString)))
    {
      paramContext = a(paramContext, paramString, ".tpns.msg.id.send.sdk");
      if (paramContext == null) {}
    }
    for (paramContext = (ArrayList)paramContext;; paramContext = null)
    {
      paramString = paramContext;
      if (paramContext == null) {
        paramString = new ArrayList();
      }
      return paramString;
    }
  }
  
  private static List<Long> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        localArrayList.add(Long.valueOf(paramJSONArray.getLong(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void a(Context paramContext, MessageId paramMessageId) {}
  
  private void a(Context paramContext, String paramString1, String paramString2, ArrayList<?> paramArrayList)
  {
    try
    {
      if (paramArrayList.size() > 50) {
        paramArrayList.subList(0, 10).clear();
      }
      paramArrayList = Rijndael.encrypt(com.tencent.android.tpush.common.d.a(paramArrayList));
      com.tencent.android.tpush.service.util.d.a(paramContext, paramString1 + paramString2, paramArrayList);
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("SrvMessageManager", "putSettings", paramContext);
    }
  }
  
  private void a(j paramj, long paramLong, com.tencent.android.tpush.service.channel.a parama)
  {
    TLogger.d("SrvMessageManager", "distribute2SDK: " + paramj.toString());
    Context localContext = b.e();
    Intent localIntent = new Intent("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE");
    localIntent.setPackage(paramj.g);
    localIntent.putExtra("msgId", paramj.a);
    localIntent.putExtra("title", Rijndael.encrypt(paramj.d));
    localIntent.putExtra("content", Rijndael.encrypt(paramj.e));
    localIntent.putExtra("date", paramj.j);
    localIntent.putExtra("type", paramj.f);
    localIntent.putExtra("accId", paramj.b);
    localIntent.putExtra("busiMsgId", paramj.c);
    localIntent.putExtra("timestamps", paramj.h);
    localIntent.putExtra("multiPkg", paramj.i);
    localIntent.putExtra("server_time", paramj.k);
    localIntent.putExtra("ttl", paramj.l);
    localIntent.putExtra("group_id", paramj.r);
    localIntent.putExtra("targetType", paramj.t);
    localIntent.putExtra("source", paramj.u);
    localIntent.putExtra("revokeId", paramj.v);
    localIntent.putExtra("templateId", paramj.w);
    localIntent.putExtra("traceId", paramj.x);
    localIntent.putExtra("inMsg", Rijndael.encrypt(paramj.y));
    long l1 = paramj.m;
    if ((com.tencent.android.tpush.f.a.a(localContext)) && (!paramj.g.equals(localContext.getPackageName())))
    {
      localIntent.putExtra("pushChannel", com.tencent.android.tpush.f.a.a());
      localIntent.putExtra("groupId", paramj.s);
      localIntent.putExtra("svrAck", true);
      localIntent.putExtra("svrPkgName", b.h());
      if (paramj.v <= 0) {
        break label417;
      }
      ServiceStat.appReportRevokeMessageServiceReceived(b.e(), localIntent);
    }
    for (;;)
    {
      if ((paramj.f != 7L) || (!com.tencent.android.tpush.f.a.a(b.e()))) {
        break label428;
      }
      TLogger.w("SrvMessageManager", "receive inMsg but run as SysPush, discard it");
      return;
      localIntent.putExtra("pushChannel", 100);
      break;
      label417:
      ServiceStat.appReportServiceReceived(b.e(), localIntent);
    }
    label428:
    int i = paramj.l;
    long l3 = paramj.k;
    long l5 = paramj.h;
    long l4 = System.currentTimeMillis();
    long l2 = 259200000L;
    if (i > 0) {
      l1 = i * 1000L;
    }
    for (;;)
    {
      if ((l3 > 0L) && (l5 > 0L))
      {
        l1 += (l3 - l5) * 1000L + l4;
        localIntent.putExtra("time_gap", l4 - l3 * 1000L);
        localIntent.putExtra("expire_time", l1);
      }
      try
      {
        localIntent.putExtra("enKeySet", com.tencent.android.tpush.common.d.a(new String[] { "title", "content" }));
        localIntent.putExtra("extra_push_time", paramLong);
        paramLong = paramj.i;
        l1 = paramj.b;
        parama = null;
        if ((com.tencent.android.tpush.f.a.a(localContext)) && (!paramj.g.equals(localContext.getPackageName()))) {
          if (paramLong == 0L)
          {
            if (com.tencent.android.tpush.f.a.a(localContext, paramj.b, paramj.g))
            {
              localIntent.putExtra("third_app_pkgname", paramj.g);
              parama = localContext.getPackageName();
            }
            TLogger.i("SrvMessageManager", "distribute2SDK appPkgName: " + parama);
            try
            {
              TLogger.i("SrvMessageManager", "distribute2SDK pkgs msgid " + paramj.a + "  pkg " + paramj.g);
              if (!i.b(parama)) {
                break label963;
              }
              TLogger.d("SrvMessageManager", ">> msg.appPkgName is null!");
              ServiceStat.reportErrCode(localContext, -103, "distribute2SDK msgId:" + paramj.a, 0L, "inner");
              return;
            }
            catch (Throwable paramj)
            {
              TLogger.e("SrvMessageManager", "dispatchMessageOnTime", paramj);
              ServiceStat.reportErrCode(localContext, -104, "sendMsgByPkgName err:" + Util.getThrowableToString(paramj), 0L, "inner");
              return;
            }
            l1 = l2;
            if (paramj.a <= 0L) {
              continue;
            }
            l1 = l2;
            if (i != 0) {
              continue;
            }
            l1 = 30000L;
            continue;
            l1 += l4;
          }
        }
      }
      catch (Throwable parama)
      {
        for (;;)
        {
          TLogger.e("SrvMessageManager", "distribute2SDK", parama);
          continue;
          localObject = com.tencent.android.tpush.f.a.a(localContext, paramj.b);
          if (localObject != null)
          {
            localIntent.putExtra("third_app_pkgname", (String)localObject);
            parama = localContext.getPackageName();
            continue;
            if (paramLong == 0L)
            {
              if (paramj.g.equals(localContext.getPackageName())) {
                parama = paramj.g;
              } else {
                TLogger.w("SrvMessageManager", "receive message but package name is not right");
              }
            }
            else
            {
              localObject = CacheManager.findValidPackageByAccessid(l1);
              if (!i.b((String)localObject)) {
                parama = (com.tencent.android.tpush.service.channel.a)localObject;
              }
            }
          }
        }
        label963:
        if (!com.tencent.android.tpush.f.a.a(localContext)) {
          com.tencent.android.tpush.a.a.a(b.e()).a(parama);
        }
        Object localObject = CacheManager.getRegisterInfoByPkgName(parama);
        if (localObject == null)
        {
          TLogger.v("SrvMessageManager", "RegInfo is null " + parama);
          a(paramj.j, localIntent, parama);
          return;
        }
        if (((RegisterEntity)localObject).state > 0)
        {
          MessageManager.getInstance().deleteAllCachedMsgIntentByPkgName(b.e(), parama);
          ServiceStat.reportErrCode(localContext, -104, "regInfo.state:" + ((RegisterEntity)localObject).state, 0L, "inner");
          return;
        }
        localIntent.setPackage(parama);
        if (!com.tencent.android.tpush.a.a(b.e(), localIntent.getPackage(), localIntent))
        {
          a(paramj.j, localIntent, parama);
          return;
        }
        a(b.e(), localIntent);
      }
    }
  }
  
  private void a(String paramString)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    label167:
    for (;;)
    {
      try
      {
        boolean bool2 = i.b(paramString);
        if (bool2) {
          return;
        }
        int i;
        try
        {
          paramString = new JSONObject(paramString).getJSONObject("custom_content");
          JSONArray localJSONArray = paramString.getJSONArray("config");
          int j = paramString.getInt("version");
          bool2 = bool3;
          if (localJSONArray != null)
          {
            bool2 = bool3;
            if (localJSONArray.length() > 0)
            {
              i = 0;
              bool2 = bool1;
              if (i < localJSONArray.length())
              {
                bool2 = a(localJSONArray.getJSONObject(i));
                if (!bool2) {
                  break label167;
                }
                bool1 = bool2;
                break label167;
              }
            }
          }
          if (!bool2) {
            continue;
          }
          paramString = b();
          PushPreferences.putInt(b.e(), "GroupKeysConfigVersion", j);
          PushPreferences.putString(b.e(), "ChannelGroupKeysConfig", paramString.toString());
        }
        catch (Throwable paramString)
        {
          TLogger.e("SrvMessageManager", "handleGroupKeysConfig", paramString);
        }
        continue;
        i += 1;
      }
      finally {}
    }
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    for (;;)
    {
      Long localLong;
      boolean bool1;
      JSONArray localJSONArray;
      int i;
      try
      {
        localLong = Long.valueOf(paramJSONObject.getLong("channelId"));
        long l = localLong.longValue();
        if (l <= 0L)
        {
          bool1 = bool2;
          return bool1;
        }
        localJSONArray = paramJSONObject.getJSONArray("infos");
        bool1 = bool2;
        if (localJSONArray == null) {
          continue;
        }
        bool1 = bool2;
        if (localJSONArray.length() <= 0) {
          continue;
        }
        if (h.containsKey(localLong)) {
          break label360;
        }
        paramJSONObject = new HashMap();
        h.put(localLong, paramJSONObject);
      }
      finally {}
      if (i < localJSONArray.length())
      {
        Map localMap = (Map)h.get(localLong);
        paramJSONObject = localJSONArray.getJSONObject(i);
        String str = paramJSONObject.getString("groupKey");
        int j = paramJSONObject.getInt("op");
        Object localObject = paramJSONObject.getJSONArray("apps");
        bool2 = bool1;
        if (localObject != null)
        {
          bool2 = bool1;
          if (((JSONArray)localObject).length() > 0)
          {
            if (!localMap.containsKey(str)) {
              localMap.put(str, new ArrayList());
            }
            paramJSONObject = (List)localMap.get(str);
            localObject = a((JSONArray)localObject);
            if (j != 1) {
              continue;
            }
            paramJSONObject = (JSONObject)localObject;
            bool1 = true;
            localMap.put(str, paramJSONObject);
            bool2 = bool1;
          }
        }
        h.put(localLong, localMap);
        i += 1;
        bool1 = bool2;
        continue;
        if (j == 2)
        {
          ((List)localObject).removeAll(paramJSONObject);
          paramJSONObject.addAll((Collection)localObject);
          bool1 = true;
        }
        else if (j == 3)
        {
          paramJSONObject.removeAll((Collection)localObject);
          bool1 = true;
        }
        else
        {
          TLogger.e("SrvMessageManager", "error op type " + j);
        }
      }
      else
      {
        continue;
        label360:
        i = 0;
        bool1 = false;
      }
    }
  }
  
  private static JSONArray b()
  {
    JSONArray localJSONArray1 = new JSONArray();
    Iterator localIterator = h.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator.next();
      JSONObject localJSONObject1 = new JSONObject();
      System.out.println("Key = " + localEntry1.getKey());
      Object localObject = (Map)localEntry1.getValue();
      JSONArray localJSONArray2 = new JSONArray();
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)((Iterator)localObject).next();
        JSONObject localJSONObject2 = new JSONObject();
        JSONArray localJSONArray3 = new JSONArray((Collection)localEntry2.getValue());
        localJSONObject2.put((String)localEntry2.getKey(), localJSONArray3);
        localJSONArray2.put(localJSONObject2);
      }
      localJSONObject1.put(((Long)localEntry1.getKey()).toString(), localJSONArray2);
      localJSONArray1.put(localJSONObject1);
    }
    return localJSONArray1;
  }
  
  private void b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    for (;;)
    {
      long l1;
      long l2;
      long l3;
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("losePkt", 0);
        l1 = paramString.optLong("loseStart", 0L) * 1000L;
        l2 = paramString.optLong("loseEnd", 0L) * 1000L;
        l3 = System.currentTimeMillis();
        TLogger.i("SrvMessageManager", "checkIfCloudRefuse | losePkt : " + i + "; loseStart : " + l1 + "; loseEnd : " + l2 + "; current : " + l3);
        if (i != 1) {
          break;
        }
        if ((l3 <= l2) && (l3 >= l1))
        {
          MqttChannel.getInstance(paramContext).stopConnect(null);
          TLogger.i("SrvMessageManager", "checkIfCloudRefuse | stopConnect ");
          return;
        }
      }
      catch (JSONException paramContext)
      {
        TLogger.e("SrvMessageManager", "checkIfCloudRefuse", paramContext);
        return;
      }
      if (((l1 != 0L) || (l2 != 0L)) && ((l3 > l2) || (l1 != 0L))) {
        if ((l3 < l1) || (l2 != 0L)) {
          break;
        }
      }
    }
  }
  
  private static void c()
  {
    for (;;)
    {
      int i;
      try
      {
        if (h != null) {
          continue;
        }
        h = new ConcurrentHashMap();
        Object localObject1 = PushPreferences.getString(b.e(), "ChannelGroupKeysConfig", null);
        if (i.b((String)localObject1)) {
          continue;
        }
        localObject1 = new JSONArray((String)localObject1);
        if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
          continue;
        }
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          continue;
        }
        localJSONObject1 = ((JSONArray)localObject1).getJSONObject(i);
        localIterator1 = localJSONObject1.keys();
      }
      catch (Throwable localThrowable)
      {
        JSONObject localJSONObject1;
        Iterator localIterator1;
        Object localObject3;
        Long localLong;
        HashMap localHashMap;
        int j;
        JSONObject localJSONObject2;
        Iterator localIterator2;
        String str;
        TLogger.e("SrvMessageManager", "initChanellGroupKey", localThrowable);
        return;
        j += 1;
        continue;
        h.put(localLong, localHashMap);
        continue;
      }
      finally {}
      if (localIterator1.hasNext())
      {
        localObject3 = (String)localIterator1.next();
        localLong = Long.valueOf((String)localObject3);
        localObject3 = localJSONObject1.getJSONArray((String)localObject3);
        if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
          continue;
        }
        localHashMap = new HashMap();
        j = 0;
        if (j < ((JSONArray)localObject3).length())
        {
          localJSONObject2 = ((JSONArray)localObject3).getJSONObject(j);
          localIterator2 = localJSONObject2.keys();
          if (localIterator2.hasNext())
          {
            str = (String)localIterator2.next();
            localHashMap.put(str, a(localJSONObject2.getJSONArray(str)));
            continue;
          }
        }
      }
      i += 1;
    }
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null)) {}
    try
    {
      long l = System.currentTimeMillis();
      MessageId localMessageId = new MessageId();
      localMessageId.id = paramIntent.getLongExtra("msgId", -1L);
      if (localMessageId.id < 0L) {
        TLogger.v("SrvMessageManager", "@@ msgSendSDKAck: Not add LocalMsg");
      }
      for (;;)
      {
        return;
        localMessageId.accessId = paramIntent.getLongExtra("accId", -1L);
        localMessageId.host = paramIntent.getLongExtra("extra_host", -1L);
        localMessageId.port = paramIntent.getIntExtra("extra_port", -1);
        localMessageId.pact = paramIntent.getByteExtra("extra_pact", (byte)-1);
        localMessageId.apn = DeviceInfos.getNetworkType(b.e());
        localMessageId.isp = i.o(b.e());
        localMessageId.serviceHost = b.e().getPackageName();
        localMessageId.receivedTime = l;
        localMessageId.pkgName = paramIntent.getPackage();
        localMessageId.busiMsgId = paramIntent.getLongExtra("busiMsgId", -1L);
        localMessageId.timestamp = paramIntent.getLongExtra("timestamps", -1L);
        localMessageId.msgType = paramIntent.getLongExtra("type", -1L);
        localMessageId.multiPkg = paramIntent.getLongExtra("multiPkg", -1L);
        localMessageId.date = paramIntent.getStringExtra("date");
        localMessageId.channelId = paramIntent.getLongExtra("channel_id", -1L);
        String str = paramIntent.getStringExtra("group_id");
        if (!i.b(str)) {
          localMessageId.groupId = str;
        }
        paramIntent = paramIntent.getStringExtra("stat_tag");
        if (!i.b(paramIntent)) {
          localMessageId.statTag = paramIntent;
        }
        a(paramContext, "all", localMessageId);
        a(paramContext, localMessageId);
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TLogger.e("SrvMessageManager", "msgSendSDKAck", paramContext);
      }
    }
    finally {}
  }
  
  public void a(Context paramContext, String paramString, MessageId paramMessageId)
  {
    byte[] arrayOfByte = b;
    if (paramContext != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ((!i.b(paramString)) && (paramMessageId != null))
        {
          ArrayList localArrayList1 = a(paramContext, paramString);
          ArrayList localArrayList2 = new ArrayList();
          i = 0;
          if (i < localArrayList1.size())
          {
            MessageId localMessageId = (MessageId)localArrayList1.get(i);
            if (localMessageId.id == paramMessageId.id) {
              localArrayList2.add(localMessageId);
            }
          }
          else
          {
            localArrayList1.removeAll(localArrayList2);
            localArrayList1.add(paramMessageId);
            a(paramContext, paramString, localArrayList1);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void a(Context paramContext, String paramString, ArrayList<MessageId> paramArrayList)
  {
    byte[] arrayOfByte = b;
    if ((paramContext != null) && (paramArrayList != null)) {}
    try
    {
      a(paramContext, paramString, ".tpns.msg.id.send.sdk", paramArrayList);
      return;
    }
    finally {}
  }
  
  public void a(Intent paramIntent)
  {
    CommonWorkingThread.getInstance().execute(new a.1(this, paramIntent));
  }
  
  public void a(String paramString1, Intent paramIntent, String paramString2)
  {
    paramString2 = new SimpleDateFormat("yyyyMMdd");
    if ((i.b(paramString1)) || ((!i.b(paramString1)) && (paramString2.parse(paramString1).compareTo(paramString2.parse(paramString2.format(new Date()))) == 0))) {
      if (f.a(paramIntent))
      {
        TLogger.d("SrvMessageManager", ">> send rpc message intent:" + paramIntent);
        a(paramIntent);
      }
    }
    while ((i.b(paramString1)) || (paramString2.parse(paramString1).compareTo(paramString2.parse(paramString2.format(new Date()))) >= 0)) {
      return;
    }
    a(paramIntent);
  }
  
  public void a(ArrayList<j> paramArrayList, long paramLong, com.tencent.android.tpush.service.channel.a parama)
  {
    b(paramArrayList, paramLong, parama);
  }
  
  public void b(ArrayList<j> paramArrayList, long paramLong, com.tencent.android.tpush.service.channel.a parama)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (b.e() != null) {
        break label60;
      }
      ServiceStat.reportErrCode(b.e(), -103, "context is null, msgid:" + ((j)paramArrayList.get(0)).a, 0L, "inner");
    }
    label60:
    label723:
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        TLogger.ii("SrvMessageManager", "receive msg from service msgId = " + ((j)paramArrayList.get(i)).a + " pkg = " + ((j)paramArrayList.get(i)).g + " type = " + ((j)paramArrayList.get(i)).f);
        i += 1;
      }
      Iterator localIterator = paramArrayList.iterator();
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label723;
              }
              j localj = (j)localIterator.next();
              TLogger.d("SrvMessageManager", "distributeFromServer : accid=" + localj.b + " ,channelId=" + localj.m + ",busiId=" + localj.c + ",pkg=" + localj.g + ",msgId=" + localj.a + ",type=" + localj.f + ",ts=" + localj.h + ",multi=" + localj.i + ",date=" + localj.j + ",serverTime=" + localj.k + ",ttl=" + localj.l + ", size = " + paramArrayList.size() + ", groupId=" + localj.r + ", mgroupId=" + localj.s + ", revokeId=" + localj.v);
              TLogger.d("SrvMessageManager", "distributeFromServer content:" + localj.e);
              if (localj.f != 3L) {
                break label487;
              }
              try
              {
                if (localj.e == null) {
                  break;
                }
                a(localj.e);
              }
              catch (Throwable localThrowable1)
              {
                TLogger.e("SrvMessageManager", "distributeFromServerInAppMsg exception: ", localThrowable1);
              }
            }
            continue;
            label487:
            if (localThrowable1.f != 6L) {
              break label555;
            }
            try
            {
              if (localThrowable1.y == null) {
                break;
              }
              g.a(b.e()).a(localThrowable1);
            }
            catch (Throwable localThrowable2)
            {
              TLogger.e("SrvMessageManager", "distributeFromServerInAppMsg exception:" + localThrowable2.toString());
            }
          }
          continue;
          if (localThrowable2.f != 1000L) {
            break label635;
          }
          try
          {
            if (localThrowable2.e == null) {
              break;
            }
            String str = new JSONObject(localThrowable2.e).optString("custom_content", null);
            CloudManager.getInstance(b.e()).parseCloudConfig(str, 0L);
            b(b.e(), str);
          }
          catch (Throwable localThrowable3)
          {
            TLogger.w("SrvMessageManager", "unexpected for type:1000", localThrowable3);
          }
        }
        continue;
        label635:
        if ((i.b(localThrowable3.g)) && (localThrowable3.i == 0L) && (localThrowable3.m <= 0L))
        {
          TLogger.d("SrvMessageManager", ">> messageDistribute, msg.appPkgName is null!");
          ServiceStat.reportErrCode(b.e(), -103, "msgId:" + localThrowable3.a, 0L, "inner");
        }
        else
        {
          a(localThrowable3, paramLong, parama);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.b.a
 * JD-Core Version:    0.7.0.1
 */