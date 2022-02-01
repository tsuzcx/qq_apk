import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchLifeTimeManager;
import com.tencent.mobileqq.redtouch.RedTouchManager.2;
import com.tencent.mobileqq.redtouch.RedTouchManager.3;
import com.tencent.mobileqq.redtouch.RedTouchManager.4;
import com.tencent.mobileqq.redtouch.RedTouchManager.5;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportStaticsData;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xd40.DeviceInfo;
import tencent.im.oidb.cmd0xd40.ReqBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo;

public class altq
  extends Observable
  implements Manager
{
  private static AtomicInteger bF = new AtomicInteger();
  private static Object fileLock = new Object();
  protected BusinessInfoCheckUpdate.TimeRspBody a;
  private volatile long ahI;
  private RedTouchLifeTimeManager b;
  protected String bYj;
  public boolean czp;
  public AppInterface g;
  protected long lastClickTime;
  private final Object lock = new Object();
  
  public altq(AppInterface paramAppInterface)
  {
    this.g = paramAppInterface;
    this.b = RedTouchLifeTimeManager.a();
  }
  
  private void OR(String paramString)
  {
    if (a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RedPointManage", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody != null) && (localTimeRspBody.rptMsgAppInfo.has()))
        {
          i = 0;
          if (i < localTimeRspBody.rptMsgAppInfo.size())
          {
            BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i);
            if (!paramString.equals(localAppInfo.path.get())) {
              break label220;
            }
            localAppInfo.exposure_max.set(localAppInfo.exposure_max.get() - 1);
            QLog.i("RedPointManage", 1, "updateMaxExposeTimes" + paramString + "，max = " + localAppInfo.exposure_max.get());
            if (localAppInfo.exposure_max.get() < 0)
            {
              localAppInfo.iNewFlag.set(0);
              QLog.i("RedPointManage", 1, "updateMaxExposeTimes less than 0 " + paramString);
            }
          }
        }
        d(localTimeRspBody);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("RedPointManage", 1, "updateNewFlagByPath: " + paramString, localException);
        return;
      }
      label220:
      i += 1;
    }
  }
  
  private BusinessInfoCheckUpdate.NumRedInfo a(int paramInt)
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        Object localObject1 = a();
        if ((localObject1 != null) && (((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgNumRedInfo.has()))
        {
          localObject1 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgNumRedInfo.get();
          if (localObject1 == null)
          {
            onPrintLog("getNumRedShowNumByAppSet : numRedBusiList is null");
            return null;
          }
          Iterator localIterator = ((List)localObject1).iterator();
          if (localIterator.hasNext())
          {
            localObject1 = (BusinessInfoCheckUpdate.NumRedInfo)localIterator.next();
            if (paramInt != ((BusinessInfoCheckUpdate.NumRedInfo)localObject1).appid.get()) {
              continue;
            }
            if (localObject1 == null)
            {
              onPrintLog("getNumRedBusiInfoByAppId : cannot find the info by appid");
              return null;
            }
            return localObject1;
          }
        }
      }
      Object localObject3 = null;
    }
  }
  
  private List<String> a(List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
  {
    if (paramList3.size() < 1) {
      localObject = paramList1;
    }
    int i;
    do
    {
      return localObject;
      i = 0;
      localObject = paramList2;
    } while (i >= paramList1.size());
    Object localObject = (String)paramList1.get(i);
    if (!paramList4.contains(localObject))
    {
      paramList2.add(localObject);
      return paramList2;
    }
    int j = 0;
    label72:
    if (j < paramList3.size()) {
      if (!((String)localObject).equals((String)paramList3.get(j))) {}
    }
    for (j = 1;; j = 0)
    {
      if (j != 0) {
        paramList2.add(localObject);
      }
      i += 1;
      break;
      j += 1;
      break label72;
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if (paramInt == 6) {
      avug.a().b(paramAppInfo, 102);
    }
    while (paramInt != 1) {
      return;
    }
    avug.a().b(paramAppInfo, 101);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    synchronized (this.lock)
    {
      localObject2 = a(paramAppInfo.uiAppId.get());
      if (localObject2 == null) {
        return;
      }
      localObject3 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get();
      if (localObject3 == null)
      {
        onPrintLog("onReportShowMsgs : NumRedPaths is null");
        return;
      }
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject3).next();
      ((List)localObject2).add(Long.valueOf(localNumRedPath.uint64_msgid.get()));
      if (paramBoolean) {
        aW(paramAppInfo.uiAppId.get(), (int)localNumRedPath.uint64_msgid.get(), paramInt2);
      }
    }
    a(paramAppInfo, paramInt1, false, null, (List)localObject2, paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, String paramString1, boolean paramBoolean, List<Long> paramList, List<String> paramList1, String paramString2)
  {
    QLog.i("RedPointManage", 1, String.format("onReportSync id = %s type = %d", new Object[] { paramAppInfo.path.get(), Integer.valueOf(paramInt) }));
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.g.getCurrentAccountUin()));
    localReportReqBody.clientver.set("3.4.4.3058");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(dP(paramAppInfo.path.get()));
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(paramInt);
    if (paramAppInfo.extend.has()) {
      localReportReqBody.extend.set(paramAppInfo.extend.get());
    }
    if (paramList != null) {
      localReportReqBody.msgids.set(paramList);
    }
    if ((this.g instanceof QQAppInterface))
    {
      if (((QQAppInterface)this.g).bJe) {
        localReportReqBody.bHebaFlag.set(true);
      }
    }
    else if (paramBoolean)
    {
      if ((paramList1 == null) || (paramList1.size() <= 0)) {
        break label473;
      }
      localReportReqBody.missionid.set(paramList1);
    }
    for (;;)
    {
      paramList = new ArrayList();
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          paramList1 = new JSONObject(paramString2);
          if (paramList1 != null)
          {
            paramString2 = paramList1.keys();
            while (paramString2.hasNext())
            {
              String str = (String)paramString2.next();
              BusinessInfoCheckUpdate.ReportStaticsData localReportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
              localReportStaticsData.key.set(str);
              localReportStaticsData.value.set(paramList1.getString(str));
              paramList.add(localReportStaticsData);
            }
          }
        }
        localReportReqBody.bHebaFlag.set(false);
      }
      catch (JSONException paramList1)
      {
        QLog.e("RedPointManage", 2, "onReportSync parse json exception ", paramList1);
        paramList1 = new BusinessInfoCheckUpdate.ReportStaticsData();
        paramList1.key.set("qimei");
        paramList1.value.set(String.valueOf(UserAction.getQIMEI()));
        paramList.add(paramList1);
        if (!TextUtils.isEmpty(paramString1)) {
          localReportReqBody.buffer.set(paramString1);
        }
        localReportReqBody.reportdata.set(paramList);
        paramString1 = createToServiceMsg("RedTouchSvc.ClientReport");
        paramString1.putWupBuffer(localReportReqBody.toByteArray());
        sendPbReq(paramString1);
        a(paramAppInfo, paramInt);
        return;
      }
      break;
      label473:
      if (paramAppInfo.missions.has()) {
        localReportReqBody.missionid.set(paramAppInfo.missions.get());
      }
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, boolean paramBoolean, List<String> paramList, String paramString)
  {
    a(paramAppInfo, paramInt, paramBoolean, paramList, null, paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, boolean paramBoolean, List<String> paramList, List<Long> paramList1, String paramString)
  {
    a(paramAppInfo, paramInt, paramBoolean, paramList, paramList1, paramString, null);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, boolean paramBoolean, List<String> paramList, List<Long> paramList1, String paramString1, String paramString2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new RedTouchManager.5(this, paramAppInfo, paramInt, paramString2, paramBoolean, paramList1, paramList, paramString1), 2, null, true);
      return;
    }
    a(paramAppInfo, paramInt, paramString2, paramBoolean, paramList1, paramList, paramString1);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString1, String paramString2)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, "onRedTouchItemClick path = " + paramString1);
    }
    SharedPreferences localSharedPreferences = this.g.getApp().getSharedPreferences("redTouchPref", 4);
    if (paramAppInfo.iNewFlag.get() == 1) {
      localSharedPreferences.edit().putString("lastClickPath", paramString1).commit();
    }
    for (;;)
    {
      if (!paramString1.contains("."))
      {
        this.bYj = paramString1;
        this.lastClickTime = System.currentTimeMillis();
      }
      g(paramAppInfo, paramString2);
      j(paramAppInfo);
      cM(paramString1, false);
      setChanged();
      if (i != 0) {
        acks.cw((QQAppInterface)this.g);
      }
      return;
      localSharedPreferences.edit().putString("lastClickPath", "").commit();
      i = 0;
    }
  }
  
  public static void a(boolean paramBoolean, Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = paramContext.getSharedPreferences("redTouchPref", 4);
    } while (paramContext == null);
    paramContext.edit().putBoolean("isCacheChange", paramBoolean).commit();
  }
  
  private boolean a(Submsgtype0x89.NumRedBusiInfo paramNumRedBusiInfo)
  {
    if (paramNumRedBusiInfo == null) {}
    while ((paramNumRedBusiInfo.uint32_plat_id.get() != 109) && (paramNumRedBusiInfo.uint32_plat_id.get() != 109110)) {
      return false;
    }
    return true;
  }
  
  private int aI(int paramInt1, int paramInt2)
  {
    int j = 0;
    label228:
    label234:
    label239:
    label245:
    for (;;)
    {
      synchronized (this.lock)
      {
        Object localObject2 = a();
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.has())
          {
            localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.get();
            if (localObject2 == null)
            {
              onPrintLog("getNumFromFileByPathAndType : numRedBusiList is null");
              return 0;
            }
            localObject2 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject2).hasNext()) {
              break label245;
            }
            Object localObject4 = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next();
            if (((BusinessInfoCheckUpdate.NumRedInfo)localObject4).appid.get() != paramInt1) {
              continue;
            }
            localObject4 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject4).num_red_path.get();
            if (localObject4 == null) {
              continue;
            }
            localObject4 = ((List)localObject4).iterator();
            j = i;
            i = j;
            if (!((Iterator)localObject4).hasNext()) {
              continue;
            }
            BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject4).next();
            if (100 == paramInt2)
            {
              if (localNumRedPath.uint32_msg_status.get() == 0) {
                break label234;
              }
              if (1 != localNumRedPath.uint32_msg_status.get()) {
                break label228;
              }
              break label234;
            }
            if (localNumRedPath.uint32_msg_status.get() != paramInt2) {
              break label228;
            }
            i = j + 1;
            break label239;
          }
        }
        return i;
      }
      int i = j;
      break label239;
      i = j + 1;
      j = i;
    }
  }
  
  private void aW(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody == null) || (!localTimeRspBody.rptMsgNumRedInfo.has())) {
          break label223;
        }
        Object localObject3 = localTimeRspBody.rptMsgNumRedInfo.get();
        if (localObject3 == null)
        {
          onPrintLog("getNumFromFileByPathAndType : numRedBusiList is null");
          return;
        }
        localObject3 = ((List)localObject3).iterator();
        int i = 0;
        j = i;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject3).next();
          if (((BusinessInfoCheckUpdate.NumRedInfo)localObject4).appid.get() != paramInt1) {
            continue;
          }
          localObject4 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject4).num_red_path.get();
          if (localObject4 == null) {
            continue;
          }
          j = 0;
          if (j < ((List)localObject4).size())
          {
            if (((BusinessInfoCheckUpdate.NumRedPath)((List)localObject4).get(j)).uint64_msgid.get() != paramInt2) {
              break label214;
            }
            ((BusinessInfoCheckUpdate.NumRedPath)((List)localObject4).get(j)).uint32_msg_status.set(paramInt3);
            i = 1;
            break label211;
          }
        }
        else
        {
          if (j != 0) {
            d(localTimeRspBody);
          }
          return;
        }
      }
      label211:
      continue;
      label214:
      j += 1;
      continue;
      label223:
      int j = 0;
    }
  }
  
  /* Error */
  private int ah(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 47	altq:lock	Ljava/lang/Object;
    //   7: astore 5
    //   9: aload 5
    //   11: monitorenter
    //   12: aload_1
    //   13: ifnonnull +8 -> 21
    //   16: aload 5
    //   18: monitorexit
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: invokevirtual 63	altq:a	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody;
    //   25: astore 6
    //   27: iload 4
    //   29: istore_3
    //   30: aload 6
    //   32: ifnull +197 -> 229
    //   35: iload 4
    //   37: istore_3
    //   38: aload 6
    //   40: getfield 171	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:rptMsgNumRedInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   43: invokevirtual 88	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   46: ifeq +183 -> 229
    //   49: aload 6
    //   51: getfield 171	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:rptMsgNumRedInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   54: invokevirtual 174	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   57: astore 6
    //   59: aload 6
    //   61: ifnonnull +20 -> 81
    //   64: ldc_w 549
    //   67: invokestatic 179	altq:onPrintLog	(Ljava/lang/String;)V
    //   70: aload 5
    //   72: monitorexit
    //   73: iconst_0
    //   74: ireturn
    //   75: astore_1
    //   76: aload 5
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    //   81: aload 6
    //   83: invokeinterface 185 1 0
    //   88: astore 6
    //   90: iconst_0
    //   91: istore_3
    //   92: aload 6
    //   94: invokeinterface 190 1 0
    //   99: ifeq +152 -> 251
    //   102: aload 6
    //   104: invokeinterface 194 1 0
    //   109: checkcast 196	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo
    //   112: getfield 258	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo:num_red_path	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   115: invokevirtual 174	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   118: astore 7
    //   120: aload 7
    //   122: ifnull -30 -> 92
    //   125: aload 7
    //   127: invokeinterface 185 1 0
    //   132: astore 7
    //   134: iload_3
    //   135: istore 4
    //   137: iload 4
    //   139: istore_3
    //   140: aload 7
    //   142: invokeinterface 190 1 0
    //   147: ifeq -55 -> 92
    //   150: aload 7
    //   152: invokeinterface 194 1 0
    //   157: checkcast 265	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedPath
    //   160: astore 8
    //   162: aload 8
    //   164: getfield 557	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedPath:str_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   167: invokevirtual 107	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   170: aload_1
    //   171: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifeq -37 -> 137
    //   177: bipush 100
    //   179: iload_2
    //   180: if_icmpne +29 -> 209
    //   183: aload 8
    //   185: getfield 552	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedPath:uint32_msg_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   188: invokevirtual 121	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   191: ifeq +49 -> 240
    //   194: iconst_1
    //   195: aload 8
    //   197: getfield 552	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedPath:uint32_msg_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   200: invokevirtual 121	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   203: if_icmpne +31 -> 234
    //   206: goto +34 -> 240
    //   209: aload 8
    //   211: getfield 552	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedPath:uint32_msg_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   214: invokevirtual 121	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   217: iload_2
    //   218: if_icmpne +16 -> 234
    //   221: iload 4
    //   223: iconst_1
    //   224: iadd
    //   225: istore_3
    //   226: goto +19 -> 245
    //   229: aload 5
    //   231: monitorexit
    //   232: iload_3
    //   233: ireturn
    //   234: iload 4
    //   236: istore_3
    //   237: goto +8 -> 245
    //   240: iload 4
    //   242: iconst_1
    //   243: iadd
    //   244: istore_3
    //   245: iload_3
    //   246: istore 4
    //   248: goto -111 -> 137
    //   251: goto -22 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	altq
    //   0	254	1	paramString	String
    //   0	254	2	paramInt	int
    //   29	217	3	i	int
    //   1	246	4	j	int
    //   7	223	5	localObject1	Object
    //   118	33	7	localObject3	Object
    //   160	50	8	localNumRedPath	BusinessInfoCheckUpdate.NumRedPath
    // Exception table:
    //   from	to	target	type
    //   16	19	75	finally
    //   21	27	75	finally
    //   38	59	75	finally
    //   64	73	75	finally
    //   76	79	75	finally
    //   81	90	75	finally
    //   92	120	75	finally
    //   125	134	75	finally
    //   140	177	75	finally
    //   183	206	75	finally
    //   209	221	75	finally
    //   229	232	75	finally
  }
  
  private BusinessInfoCheckUpdate.AppInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      onPrintLog("getRedTouchAppInfoByPath: input path is Empty");
      return null;
    }
    Object localObject2 = a();
    if ((localObject2 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has()))
    {
      onPrintLog("TimeRspBody is Empty or msgAppInfo is Empty path = " + paramString);
      return c(paramString);
    }
    synchronized (this.lock)
    {
      localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject2).next();
        if (localAppInfo.path.get().equals(paramString))
        {
          onPrintLog("getRedTouchAppInfoByPath path = " + paramString + "inewflag = " + localAppInfo.iNewFlag.get());
          return localAppInfo;
        }
      }
    }
    return c(paramString);
  }
  
  private BusinessInfoCheckUpdate.AppInfo c(String paramString)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localAppInfo.path.set(paramString);
    localAppInfo.num.set(0);
    localAppInfo.type.set(-1);
    localAppInfo.iNewFlag.set(0);
    return localAppInfo;
  }
  
  private void c(String paramString, List<String> paramList1, List<String> paramList2)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("msg"))
        {
          paramString = paramString.getJSONObject("msg");
          if (paramString != null)
          {
            Iterator localIterator = paramString.keys();
            if (localIterator.hasNext())
            {
              new JSONObject();
              String str = (String)localIterator.next();
              JSONObject localJSONObject = paramString.getJSONObject(str);
              if (!localJSONObject.has("stat")) {
                break label141;
              }
              i = localJSONObject.getInt("stat");
              paramList2.add(str);
              if (i != 1) {
                continue;
              }
              paramList1.add(str);
              continue;
            }
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      paramString = null;
      continue;
      label141:
      int i = -1;
    }
  }
  
  private void cM(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, "setNewStatusByID,path = " + paramString);
    }
    if (a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RedPointManage", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody != null) && (localTimeRspBody.rptMsgAppInfo.has()))
        {
          i = 0;
          if (i < localTimeRspBody.rptMsgAppInfo.size())
          {
            Object localObject = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i);
            if (!paramString.equals(((BusinessInfoCheckUpdate.AppInfo)localObject).path.get())) {
              break label248;
            }
            if ((((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1) && (!paramBoolean)) {
              ((BusinessInfoCheckUpdate.AppInfo)localObject).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            }
            PBInt32Field localPBInt32Field = ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag;
            if (paramBoolean) {
              j = 1;
            }
            localPBInt32Field.set(j);
            localTimeRspBody.rptMsgAppInfo.set(i, (MessageMicro)localObject);
            localObject = (anec)this.g.getManager(12);
            if (localObject != null) {
              ((anec)localObject).Qr(paramString);
            }
          }
        }
        d(localTimeRspBody);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("RedPointManage", 1, "updateNewFlagByPath: " + paramString, localException);
        return;
      }
      label248:
      i += 1;
    }
  }
  
  private ToServiceMsg createToServiceMsg(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.g.getCurrentAccountUin(), paramString);
  }
  
  public static String d(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return "null";
    }
    StringBuilder localStringBuilder = wja.b().append(paramAppInfo.path.get()).append(":");
    paramAppInfo = RedTouchTextView.a(paramAppInfo);
    if (paramAppInfo != null)
    {
      paramAppInfo = paramAppInfo.iterator();
      while (paramAppInfo.hasNext()) {
        localStringBuilder.append(((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next()).red_type.get()).append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  private void d(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    ThreadManagerV2.excute(new RedTouchManager.3(this, paramTimeRspBody), 64, null, true);
  }
  
  private boolean d(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    return false;
  }
  
  private void dJG()
  {
    File localFile = new File(this.g.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.g.getCurrentAccountUin());
    if (!localFile.exists()) {
      onPrintLog("BusinessInfoCheckUpdateItem pb file does not exist");
    }
    try
    {
      localFile.createNewFile();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          byte[] arrayOfByte = aqhq.fileToBytes(localFile);
          if (arrayOfByte != null) {
            break;
          }
          onPrintLog("Can not translate BusinessInfoCheckUpdateItem pb file to byte");
          return;
        }
        finally {}
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
    try
    {
      localTimeRspBody.mergeFrom(localIOException);
      synchronized (this.lock)
      {
        this.a = localTimeRspBody;
        a(false, this.g.getApp());
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void dJI()
  {
    onPrintLog("handler after push");
    Object localObject = null;
    if ((this.g instanceof QQAppInterface)) {
      localObject = (QQAppInterface)this.g;
    }
    if (localObject == null) {
      return;
    }
    if (BaseActivity.mAppForground)
    {
      ((acks)((QQAppInterface)localObject).getBusinessHandler(87)).bJ(true, true);
      return;
    }
    localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("check_update_sp_key", 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("redtouch_force", true);
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  public static int dP(String paramString)
  {
    if (paramString == null) {
      onPrintLog("input path is empty");
    }
    do
    {
      return -1;
      if (!paramString.contains(".")) {
        break;
      }
      paramString = paramString.split("\\.");
    } while ((paramString == null) || (paramString.length <= 0));
    int i;
    try
    {
      i = Integer.parseInt(paramString[(paramString.length - 1)]);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      return -1;
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private void e(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    synchronized (this.lock)
    {
      this.a = paramTimeRspBody;
      return;
    }
  }
  
  private void f(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo == null) {}
    while (paramAppInfo.iNewFlag.get() == 0) {
      return;
    }
    a(paramAppInfo, 1, true, null, paramString);
  }
  
  private void g(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo == null) {
      return;
    }
    if (paramAppInfo.iNewFlag.get() == 0)
    {
      a(paramAppInfo, 6, false, null, paramString);
      return;
    }
    a(paramAppInfo, 6, true, null, paramString);
  }
  
  private void j(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    while ((paramAppInfo.iNewFlag.get() == 0) || (!TextUtils.equals(paramAppInfo.path.get(), "826"))) {
      return;
    }
    if (!TextUtils.isEmpty(paramAppInfo.icon_url.get())) {}
    for (int i = 1;; i = 2)
    {
      anot.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00899", "Grp_tribe", "", "dynamic", "Clk_tribe", 0, 0, i + "", "", "", "");
      paramAppInfo = new cmd0xd40.ReqBody();
      paramAppInfo.src.set(1);
      paramAppInfo.event.set(2);
      paramAppInfo.redtype.set(i);
      paramAppInfo.dev.uint32_os.set(2);
      sendPbReq(lup.makeOIDBPkg("OidbSvc.0xd40_0", 3392, 0, paramAppInfo.toByteArray()));
      return;
    }
  }
  
  public static void onPrintLog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, paramString);
    }
  }
  
  private final void sendPbReq(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg == null) || (!(this.g instanceof QQAppInterface))) {
      return;
    }
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    ((QQAppInterface)this.g).sendToService(paramToServiceMsg);
  }
  
  public void OS(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      onPrintLog("onRedTouchItemClick path is empty");
      return;
    }
    a(getAppInfoByPath(paramString), paramString, null);
  }
  
  public void OT(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      onPrintLog("onRedTouchItemClick path is empty");
      return;
    }
    Object localObject = this.g.getApp().getSharedPreferences("redTouchPref", 4);
    if (localObject != null)
    {
      if (getAppInfoByPath(paramString).iNewFlag.get() == 1) {
        ((SharedPreferences)localObject).edit().putString("lastClickPath", paramString).commit();
      }
    }
    else
    {
      localObject = getAppInfoByPath(paramString);
      if (localObject != null)
      {
        if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0) {
          break label146;
        }
        a((BusinessInfoCheckUpdate.AppInfo)localObject, 14, false, null, null);
      }
    }
    for (;;)
    {
      cM(paramString, false);
      setChanged();
      acks.cw((QQAppInterface)this.g);
      return;
      ((SharedPreferences)localObject).edit().putString("lastClickPath", "").commit();
      break;
      label146:
      a((BusinessInfoCheckUpdate.AppInfo)localObject, 14, true, null, null);
    }
  }
  
  public int a(int paramInt, boolean paramBoolean, long paramLong)
  {
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        BusinessInfoCheckUpdate.AppSetting localAppSetting = new BusinessInfoCheckUpdate.AppSetting();
        localAppSetting.appid.set(paramInt);
        localAppSetting.setting.set(paramBoolean);
        localAppSetting.modify_ts.set(paramLong);
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody != null) && ((localTimeRspBody.has()) || (localTimeRspBody.rptSetting.has())))
        {
          List localList = localTimeRspBody.rptSetting.get();
          int j = localList.size();
          i = 0;
          if (i < j)
          {
            if (paramInt == ((BusinessInfoCheckUpdate.AppSetting)((BusinessInfoCheckUpdate.AppSetting)localList.get(i)).get()).appid.get()) {
              localList.set(i, localAppSetting);
            }
          }
          else
          {
            if (i == j) {
              localList.add(localAppSetting);
            }
            d(localTimeRspBody);
            return 0;
          }
        }
        else
        {
          localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
          localTimeRspBody.rptSetting.add(localAppSetting);
          d(localTimeRspBody);
        }
      }
      i += 1;
    }
  }
  
  public int a(altq.b paramb)
  {
    return a(paramb, false);
  }
  
  public int a(altq.b paramb, boolean paramBoolean)
  {
    int n = 0;
    Object localObject1 = new StringBuilder().append("getPassiveRedNumQQCircle listener?");
    boolean bool;
    int j;
    label71:
    Object localObject2;
    int k;
    label97:
    int i;
    label113:
    int m;
    if (paramb != null)
    {
      bool = true;
      QLog.d("RedPointManage", 1, bool + ", forceGetMsg: " + paramBoolean);
      if ((paramb == null) && (this.ahI <= 0L) && (!paramBoolean)) {
        break label201;
      }
      j = 1;
      localObject2 = ai(140000);
      localObject1 = new ArrayList();
      if (localObject2 != null) {
        break label207;
      }
      k = 0;
      if (localObject2 == null) {
        break label219;
      }
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      BusinessInfoCheckUpdate.NumRedPath localNumRedPath;
      do
      {
        m = i;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject2).next();
      } while (localNumRedPath == null);
      if ((localNumRedPath.uint32_msg_status.get() != 0) && (1 != localNumRedPath.uint32_msg_status.get())) {
        break label372;
      }
      if (j != 0) {
        ((ArrayList)localObject1).add(Long.valueOf(localNumRedPath.uint64_msgid.get()));
      }
      i += 1;
    }
    label201:
    label207:
    label219:
    label372:
    for (;;)
    {
      break label113;
      bool = false;
      break;
      j = 0;
      break label71;
      k = ((List)localObject2).size();
      break label97;
      m = 0;
      QLog.d("RedPointManage", 1, "getPassiveRedNumQQCircle numRedPathsSize = " + k + ", num = " + m);
      try
      {
        k = ((ArrayList)localObject1).size();
        if ((j != 0) && (k > 0))
        {
          localObject2 = new long[k];
          i = n;
          while (i < k)
          {
            localObject2[i] = ((Long)((ArrayList)localObject1).get(i)).longValue();
            i += 1;
          }
          a((long[])localObject2, "QQCircleRedCircle", new altr(this, paramb, m));
          return m;
        }
        if (paramb == null) {
          break label375;
        }
        paramb.z(null, m);
        return m;
      }
      catch (Exception paramb)
      {
        paramb.printStackTrace();
        QLog.e("RedPointManage", 1, "getPassiveRedNumQQCircle", paramb);
        return m;
      }
    }
    label375:
    return m;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramString, paramInt3, true);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    return a(paramInt1, paramInt2, paramString, paramInt3, true, "");
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString1, int paramInt3, boolean paramBoolean, String paramString2)
  {
    paramString1 = c(paramString1);
    paramString1.uiAppId.set(paramInt2);
    paramString1.type.set(5);
    paramString1.iNewFlag.set(1);
    paramString1.appset.set(paramInt1);
    paramString1.mission_level.set(0);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.extend.set(paramString2);
    }
    paramString2 = new BusinessInfoCheckUpdate.RedDisplayInfo();
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(9);
    localRedTypeInfo.red_content.set("-1");
    localRedTypeInfo.red_desc.set("");
    paramString2.red_type_info.add(localRedTypeInfo);
    localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(5);
    localRedTypeInfo.red_content.set(paramInt3 + "");
    localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
    paramString2.tab_display_info.set(localRedTypeInfo);
    paramString2.red_type_info.add(localRedTypeInfo);
    paramString1.red_display_info.set(paramString2);
    if (paramBoolean)
    {
      b(paramString1, true);
      acks.cw((QQAppInterface)this.g);
    }
    return paramString1;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      onPrintLog("input path is Empty");
      return null;
    }
    onPrintLog("getAppInfoByPath path = " + paramString);
    int i = ah(paramString, 100);
    if (i > 0)
    {
      int j = Integer.parseInt(paramString.split("\\.")[0]);
      BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = a(j);
      String str = "";
      if (localNumRedInfo != null) {
        str = localNumRedInfo.extend.get();
      }
      return a(paramInt, j, paramString, i, false, str);
    }
    return b(paramString);
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a(QQAppInterface paramQQAppInterface, boolean paramBoolean, Map<Long, LebaPluginInfo> paramMap)
  {
    List localList1 = aj(0);
    if ((localList1 == null) || (localList1.size() == 0))
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    List localList2 = fV();
    Object localObject2 = null;
    Object localObject1 = null;
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("getRedTouchInfoForLeba:redpoint path List:");
    int i = 0;
    label61:
    Object localObject5;
    Object localObject4;
    if (i < localList1.size())
    {
      localObject5 = (BusinessInfoCheckUpdate.AppInfo)localList1.get(i);
      localStringBuilder.append(", for ").append(((BusinessInfoCheckUpdate.AppInfo)localObject5).path.get());
      if (((BusinessInfoCheckUpdate.AppInfo)localObject5).mission_level.get() != 0)
      {
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
      }
    }
    for (;;)
    {
      i += 1;
      localObject4 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break label61;
      if ((999999 == ((BusinessInfoCheckUpdate.AppInfo)localObject5).uiAppId.get()) || (((BusinessInfoCheckUpdate.AppInfo)localObject5).path.get().contains(".")))
      {
        localStringBuilder.append(" second ");
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else if ((((BusinessInfoCheckUpdate.AppInfo)localObject5).iNewFlag.get() != 1) || (((BusinessInfoCheckUpdate.AppInfo)localObject5).exposure_max.get() <= 0))
      {
        localStringBuilder.append(" isNewFlag exposure_max error").append(((BusinessInfoCheckUpdate.AppInfo)localObject5).iNewFlag.get()).append(((BusinessInfoCheckUpdate.AppInfo)localObject5).exposure_max.get());
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else if (!acgw.a(paramQQAppInterface, ((BusinessInfoCheckUpdate.AppInfo)localObject5).uiAppId.get(), paramBoolean, paramMap))
      {
        localStringBuilder.append(" !needShowRedDot");
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else
      {
        int j = 0;
        for (;;)
        {
          if ((j >= localList2.size()) || (((BusinessInfoCheckUpdate.AppInfo)localObject5).uiAppId.get() == ((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).appid.get()))
          {
            if ((j >= localList2.size()) || (((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).setting.get())) {
              break label427;
            }
            localStringBuilder.append(" hide ");
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
            break;
          }
          j += 1;
        }
        label427:
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((BusinessInfoCheckUpdate.AppInfo)localObject5).red_display_info.tab_display_info.get();
        if ((((BusinessInfoCheckUpdate.AppInfo)localObject5).uiAppId.get() == 100510) && (localRedTypeInfo.red_type.get() == 5) && (!d((BusinessInfoCheckUpdate.AppInfo)localObject5)))
        {
          localStringBuilder.append(" !nearby");
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
        }
        else
        {
          if (localObject2 != null)
          {
            localObject4 = localObject2;
            if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
          }
          else
          {
            localObject4 = localRedTypeInfo;
          }
          localStringBuilder.append(" show ");
          Object localObject3;
          if (localRedTypeInfo.red_type.get() == 5)
          {
            if (localObject1 == null)
            {
              localObject1 = localObject4;
              localObject2 = localRedTypeInfo;
            }
            else
            {
              try
              {
                if (QLog.isDevelopLevel()) {
                  QLog.e("RedPointManage", 4, "getRedTouchInfoForLeba, content=" + localObject1.red_content.get() + ", path=" + ((BusinessInfoCheckUpdate.AppInfo)localObject5).path.get() + ",redTypeInfoContent=" + localRedTypeInfo.red_content.get());
                }
                localObject2 = localObject1.red_content;
                localObject5 = new StringBuilder();
                j = Integer.parseInt(localObject1.red_content.get());
                ((PBStringField)localObject2).set(Integer.parseInt(localRedTypeInfo.red_content.get()) + j + "");
                localObject2 = localObject1;
                localObject1 = localObject4;
              }
              catch (NumberFormatException localNumberFormatException)
              {
                localNumberFormatException.printStackTrace();
                localObject3 = localObject1;
                localObject1 = localObject4;
              }
            }
          }
          else
          {
            if ((localObject4 == null) || (localObject4.red_priority.get() < localRedTypeInfo.red_priority.get()))
            {
              localObject3 = localObject1;
              localObject1 = localRedTypeInfo;
              continue;
              paramQQAppInterface = localObject1;
              if (localObject1 != null) {
                break;
              }
              if (localObject3 != null) {
                QLog.i("RedPointManage", 1, "getRedTouchInfoForLeba result != nullpathList = " + localStringBuilder.toString());
              }
              for (;;)
              {
                return localObject3;
                QLog.i("RedPointManage", 1, "getRedTouchInfoForLeba result = nullpathList = " + localStringBuilder.toString());
              }
            }
            localObject3 = localObject1;
            localObject1 = localObject4;
          }
        }
      }
    }
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a()
  {
    synchronized (this.lock)
    {
      if ((!auy()) && (this.a != null))
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = this.a;
        return localTimeRspBody;
      }
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.post(new RedTouchManager.2(this), 5, null, true);
        return null;
      }
    }
    dJG();
    return null;
  }
  
  public JSONObject a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramAppInfo.buffer.has())
        {
          JSONObject localJSONObject = new JSONObject(paramAppInfo.buffer.get());
          paramAppInfo = localJSONObject.optString("_show_mission");
          if (!TextUtils.isEmpty(paramAppInfo))
          {
            localJSONObject = localJSONObject.optJSONObject("param");
            if (localJSONObject != null)
            {
              paramAppInfo = localJSONObject.optJSONObject(paramAppInfo);
              return paramAppInfo;
            }
          }
        }
      }
      catch (Throwable paramAppInfo)
      {
        QLog.e("RedPointManage", 1, "getBufferExtParamAppInfo() JSONException ", paramAppInfo);
      }
    }
    return null;
  }
  
  public void a(int paramInt1, ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.g.getCurrentAccountUin()));
    localReportReqBody.clientver.set("3.4.4.3058");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(paramInt2);
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(paramInt1);
    if (paramArrayList != null) {
      localReportReqBody.missionid.set(paramArrayList);
    }
    paramInt1 = this.g.getApplication().getSharedPreferences("check_update_sp_key", 0).getInt("businessinfo_last_check_update_timestamp_" + this.g.getCurrentAccountUin(), 0);
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString3))
        {
          paramArrayList = new JSONObject();
          paramString3 = paramArrayList;
        }
      }
      catch (Exception paramArrayList)
      {
        paramString3 = null;
      }
      try
      {
        paramArrayList.put("msg", "");
        paramString3 = paramArrayList;
        paramArrayList.put("red", paramString1);
        paramString3 = paramArrayList;
        paramArrayList.put("ret", paramString2);
        paramString3 = paramArrayList;
        paramArrayList.put("lastTime", paramInt1);
        paramString3 = paramArrayList;
        paramArrayList.put("callback", paramString5);
        paramString3 = paramArrayList;
        paramArrayList.put("waterid", paramString4);
        paramString1 = paramArrayList;
        if (paramString1 != null) {
          localReportReqBody.buffer.set(paramString1.toString());
        }
        paramArrayList = createToServiceMsg("RedTouchSvc.ClientReport");
        paramArrayList.putWupBuffer(localReportReqBody.toByteArray());
        sendPbReq(paramArrayList);
        return;
      }
      catch (Exception paramArrayList)
      {
        break label308;
      }
      paramArrayList = new JSONObject(paramString3);
      continue;
      label308:
      paramString1 = paramString3;
      if (QLog.isColorLevel())
      {
        QLog.e("RedPointManage", 2, "getAndSetAppInfoJsReport buffer json is empty", paramArrayList);
        paramString1 = paramString3;
      }
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, String paramString)
  {
    ArrayList localArrayList;
    synchronized (this.lock)
    {
      localArrayList = new ArrayList();
      Object localObject2 = ai(140000);
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject2).next();
          localArrayList.add(Long.valueOf(localNumRedPath.uint64_msgid.get()));
          aW(140000, (int)localNumRedPath.uint64_msgid.get(), 3);
        }
      }
    }
    a(paramAppInfo, paramInt, false, null, localArrayList, paramString);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject != null)
    {
      BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
      localReportReqBody.uin.set(Long.parseLong(this.g.getCurrentAccountUin()));
      localReportReqBody.clientver.set("3.4.4.3058");
      localReportReqBody.platid.set(109);
      localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
      localReportReqBody.buffer.set(paramJSONObject.toString());
      localReportReqBody.cmd.set(paramInt);
      if (paramAppInfo != null)
      {
        localReportReqBody.appid.set(dP(paramAppInfo.path.get()));
        if (paramAppInfo.missions.has()) {
          localReportReqBody.missionid.set(paramAppInfo.missions.get());
        }
      }
      paramAppInfo = createToServiceMsg("RedTouchSvc.ClientReport");
      paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
      sendPbReq(paramAppInfo);
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, "onReportRedPointClickWithMissions");
    }
    if (paramAppInfo == null)
    {
      QLog.e("RedPointManage", 1, "onReportRedPointClickWithMissions appinfo = null");
      return;
    }
    a(paramAppInfo, 6, paramBoolean, paramList, null);
  }
  
  public void a(long[] paramArrayOfLong, String paramString, altk paramaltk)
  {
    ((altl)this.g.getManager(65)).a(paramArrayOfLong, paramString, paramaltk);
  }
  
  /* Error */
  public boolean a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	altq:g	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 304	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 47	altq:lock	Ljava/lang/Object;
    //   13: astore 4
    //   15: aload 4
    //   17: monitorenter
    //   18: aload_1
    //   19: invokevirtual 1064	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:toByteArray	()[B
    //   22: astore 6
    //   24: aload 4
    //   26: monitorexit
    //   27: getstatic 42	altq:fileLock	Ljava/lang/Object;
    //   30: astore 4
    //   32: aload 4
    //   34: monitorenter
    //   35: getstatic 37	altq:bF	Ljava/util/concurrent/atomic/AtomicInteger;
    //   38: invokevirtual 1067	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   41: istore_2
    //   42: new 662	java/io/File
    //   45: dup
    //   46: aload_0
    //   47: getfield 49	altq:g	Lcom/tencent/common/app/AppInterface;
    //   50: invokevirtual 666	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   53: invokevirtual 672	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   56: new 127	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 674
    //   66: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 5
    //   71: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 677	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   80: invokevirtual 1070	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   83: aload 6
    //   85: iconst_0
    //   86: invokestatic 1073	aqhq:a	(Ljava/lang/String;[BZ)Z
    //   89: istore_3
    //   90: iload_3
    //   91: ifeq +89 -> 180
    //   94: getstatic 1077	anec:io	Ljava/util/concurrent/ConcurrentHashMap;
    //   97: aload 5
    //   99: iconst_0
    //   100: invokestatic 1082	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   103: invokevirtual 1087	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: aload 4
    //   109: monitorexit
    //   110: aload_0
    //   111: getfield 47	altq:lock	Ljava/lang/Object;
    //   114: astore 4
    //   116: aload 4
    //   118: monitorenter
    //   119: iload_3
    //   120: ifeq +18 -> 138
    //   123: iload_2
    //   124: getstatic 37	altq:bF	Ljava/util/concurrent/atomic/AtomicInteger;
    //   127: invokevirtual 1088	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   130: if_icmpne +8 -> 138
    //   133: aload_0
    //   134: aload_1
    //   135: invokespecial 1090	altq:e	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody;)V
    //   138: aload 4
    //   140: monitorexit
    //   141: iload_3
    //   142: ireturn
    //   143: astore_1
    //   144: ldc 71
    //   146: iconst_1
    //   147: ldc_w 1092
    //   150: aload_1
    //   151: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   154: aload 4
    //   156: monitorexit
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_1
    //   160: aload 4
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    //   165: astore_1
    //   166: ldc 71
    //   168: iconst_1
    //   169: ldc_w 1094
    //   172: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload 4
    //   177: monitorexit
    //   178: iconst_0
    //   179: ireturn
    //   180: ldc 71
    //   182: iconst_1
    //   183: ldc_w 1096
    //   186: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: goto -82 -> 107
    //   192: astore_1
    //   193: aload 4
    //   195: monitorexit
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: aload 4
    //   201: monitorexit
    //   202: aload_1
    //   203: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	altq
    //   0	204	1	paramTimeRspBody	BusinessInfoCheckUpdate.TimeRspBody
    //   41	90	2	i	int
    //   89	53	3	bool	boolean
    //   7	91	5	str	String
    //   22	62	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	24	143	java/lang/Exception
    //   18	24	159	finally
    //   24	27	159	finally
    //   144	157	159	finally
    //   160	163	159	finally
    //   166	178	159	finally
    //   18	24	165	java/lang/OutOfMemoryError
    //   35	90	192	finally
    //   94	107	192	finally
    //   107	110	192	finally
    //   180	189	192	finally
    //   193	196	192	finally
    //   123	138	198	finally
    //   138	141	198	finally
    //   199	202	198	finally
  }
  
  public int aH(int paramInt1, int paramInt2)
  {
    onPrintLog("getExtraNumRedTotalNum appId = " + paramInt1);
    return aI(paramInt1, paramInt2);
  }
  
  public int ag(String paramString, int paramInt)
  {
    return ah(paramString, paramInt);
  }
  
  public List<BusinessInfoCheckUpdate.NumRedPath> ai(int paramInt)
  {
    synchronized (this.lock)
    {
      Object localObject2 = a(paramInt);
      if (localObject2 == null) {
        return null;
      }
      localObject2 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get();
      return localObject2;
    }
  }
  
  public List<BusinessInfoCheckUpdate.AppInfo> aj(int paramInt)
  {
    synchronized (this.lock)
    {
      Object localObject2 = a();
      if ((localObject2 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has()))
      {
        localObject2 = new ArrayList();
        return localObject2;
      }
      Object localObject3 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get();
      localObject2 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject3).next();
        if (localAppInfo.appset.get() == paramInt) {
          ((List)localObject2).add(localAppInfo);
        }
      }
    }
    return localList;
  }
  
  public boolean auy()
  {
    SharedPreferences localSharedPreferences = this.g.getApp().getSharedPreferences("redTouchPref", 4);
    if (localSharedPreferences == null) {
      return true;
    }
    return localSharedPreferences.getBoolean("isCacheChange", true);
  }
  
  public int b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    Object localObject = this.lock;
    if (paramAppInfo != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!paramAppInfo.path.has())
        {
          onPrintLog("updateAppInfo failed , appInfo is empty or appInfo path is null");
          return -3;
        }
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if (localTimeRspBody == null)
        {
          onPrintLog("updateAppInfo failed,TimeRspBody is Empty");
          return -3;
        }
        List localList = localTimeRspBody.rptMsgAppInfo.get();
        int j = localList.size();
        i = 0;
        if (i < j)
        {
          if (paramAppInfo.path.get().equals(((BusinessInfoCheckUpdate.AppInfo)localList.get(i)).path.get()))
          {
            onPrintLog("path is same = " + paramAppInfo.path);
            localList.set(i, paramAppInfo);
          }
        }
        else
        {
          if (i == j)
          {
            if (paramBoolean) {
              localTimeRspBody.rptMsgAppInfo.add(paramAppInfo);
            }
          }
          else
          {
            d(localTimeRspBody);
            return 0;
          }
          return -3;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public BusinessInfoCheckUpdate.AppInfo b(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      onPrintLog("input path is Empty");
    }
    int i;
    do
    {
      return null;
      onPrintLog("getAppInfoByPath path = " + paramString);
      i = ag(paramString, 100);
    } while (i <= 0);
    int j = Integer.parseInt(paramString.split("\\.")[0]);
    BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = a(j);
    String str = "";
    if (localNumRedInfo != null) {
      str = localNumRedInfo.extend.get();
    }
    return a(paramInt, j, paramString, i, false, str);
  }
  
  public String b(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInfo == null))
    {
      onPrintLog("url is empty or appInfo is Empty");
      return paramString;
    }
    int j = -1;
    int i = j;
    if (paramAppInfo != null)
    {
      i = j;
      if (paramAppInfo.iNewFlag.get() != 0)
      {
        new ArrayList();
        i = j;
        if (paramAppInfo.red_display_info != null)
        {
          i = j;
          if (paramAppInfo.red_display_info.red_type_info != null)
          {
            List localList = paramAppInfo.red_display_info.red_type_info.get();
            i = j;
            if (localList != null)
            {
              i = j;
              if (localList.size() >= 2) {
                i = ((BusinessInfoCheckUpdate.RedTypeInfo)localList.get(1)).red_type.get();
              }
            }
          }
        }
      }
    }
    paramString = new StringBuilder(paramString);
    paramString.append("&status=").append(i).append("&number=").append(paramAppInfo.num.get()).append("&path=").append(paramAppInfo.path.get());
    return paramString.toString();
  }
  
  public void bp(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        Object localObject = new Submsgtype0x89.MsgBody();
        ((Submsgtype0x89.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((Submsgtype0x89.MsgBody)localObject).rpt_msg_num_red.get();
        if (paramArrayOfByte == null) {
          return;
        }
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject = (Submsgtype0x89.NumRedBusiInfo)paramArrayOfByte.next();
          if ((a((Submsgtype0x89.NumRedBusiInfo)localObject)) && (altt.b((Submsgtype0x89.NumRedBusiInfo)localObject))) {
            a(a(((Submsgtype0x89.NumRedBusiInfo)localObject).int32_appset.get(), ((Submsgtype0x89.NumRedBusiInfo)localObject).uint32_app_id.get(), String.valueOf(((Submsgtype0x89.NumRedBusiInfo)localObject).uint64_msgid.get()), 1), 1, "", false, -1);
          }
        }
        dJI();
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
    }
  }
  
  public String bs(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    Object localObject3 = new ArrayList();
    Object localObject2 = new HashMap();
    Object localObject4;
    Object localObject1;
    int i;
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (paramString2.has("msg"))
      {
        paramString2 = paramString2.getJSONObject("msg");
        if (paramString2 == null) {
          break label228;
        }
        localObject4 = paramString2.keys();
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label228;
          }
          new JSONObject();
          String str = (String)((Iterator)localObject4).next();
          localObject1 = paramString2.getJSONObject(str);
          if (!((JSONObject)localObject1).has("stat")) {
            break;
          }
          i = ((JSONObject)localObject1).getInt("stat");
          label131:
          if (i == 2)
          {
            ((List)localObject3).add(str);
            if (!((JSONObject)localObject1).has("content")) {
              break label220;
            }
            localObject1 = ((JSONObject)localObject1).getString("content");
            label167:
            ((Map)localObject2).put(str, localObject1);
          }
        }
      }
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      paramString2 = null;
      localObject1 = null;
      for (;;)
      {
        if ((paramString2 != null) && (paramString2.size() >= 1)) {
          break label238;
        }
        return "";
        paramString2 = null;
        break;
        i = -1;
        break label131;
        label220:
        localObject1 = "";
        break label167;
        label228:
        localObject1 = localObject3;
        paramString2 = (String)localObject2;
      }
      label238:
      localObject2 = new ArrayList();
      paramString1 = getAppInfoByPath(paramString1);
      if (paramString1 == null) {}
    }
    for (paramString1 = paramString1.buffer.get();; paramString1 = null)
    {
      localObject3 = new ArrayList();
      localObject4 = new ArrayList();
      c(paramString1, (List)localObject3, (List)localObject4);
      paramString1 = a((List)localObject1, (List)localObject2, (List)localObject3, (List)localObject4);
      if (paramString1.size() > 0) {
        try
        {
          localObject1 = new JSONArray();
          i = 0;
          while (i < paramString1.size())
          {
            localObject2 = new JSONObject();
            localObject3 = (String)paramString1.get(i);
            ((JSONObject)localObject2).put((String)localObject3, (String)paramString2.get(localObject3));
            ((JSONArray)localObject1).put(localObject2);
            i += 1;
          }
          paramString1 = ((JSONArray)localObject1).toString();
          return paramString1;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          return "";
        }
      }
      return "";
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo c(int paramInt)
  {
    List localList1 = aj(paramInt);
    Object localObject4;
    if ((localList1 == null) || (localList1.size() == 0))
    {
      localObject4 = null;
      return localObject4;
    }
    List localList2 = fV();
    Object localObject2 = null;
    Object localObject1 = null;
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("getRedTouchInfoByAppSet:redpoint path List:");
    int i = 0;
    label62:
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (i < localList1.size())
    {
      localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localList1.get(i);
      if (localAppInfo.mission_level.get() != 0)
      {
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
      }
    }
    for (;;)
    {
      i += 1;
      localObject4 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break label62;
      Object localObject5 = localObject2;
      if (999999 != localAppInfo.uiAppId.get())
      {
        if (localAppInfo.path.get().contains("."))
        {
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          continue;
        }
        if (localAppInfo.iNewFlag.get() != 1)
        {
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          continue;
        }
        if (((paramInt == 0) || (paramInt == 1)) && (localAppInfo.exposure_max.get() <= 0))
        {
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          continue;
        }
        int j = 0;
        for (;;)
        {
          if ((j >= localList2.size()) || (localAppInfo.uiAppId.get() == ((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).appid.get()))
          {
            if ((j >= localList2.size()) || (((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).setting.get())) {
              break label334;
            }
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
            break;
          }
          j += 1;
        }
        label334:
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)localAppInfo.red_display_info.tab_display_info.get();
        if ((localAppInfo.uiAppId.get() == 100510) && (localRedTypeInfo.red_type.get() == 5) && (!d(localAppInfo)))
        {
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          continue;
        }
        if (localObject2 != null)
        {
          localObject4 = localObject2;
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
        }
        else
        {
          localObject4 = localRedTypeInfo;
        }
        localStringBuilder.append(localAppInfo.path.get()).append(",");
        if (localRedTypeInfo.red_type.get() == 5)
        {
          if (localObject1 == null)
          {
            localObject1 = localObject4;
            localObject2 = localRedTypeInfo;
            continue;
          }
          try
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("RedPointManage", 4, "getRedTouchInfoByAppSet, content=" + localObject1.red_content.get() + ", path=" + localAppInfo.path.get() + ",redTypeInfoContent=" + localRedTypeInfo.red_content.get());
            }
            localObject2 = localObject1.red_content;
            localObject5 = new StringBuilder();
            j = Integer.parseInt(localObject1.red_content.get());
            ((PBStringField)localObject2).set(Integer.parseInt(localRedTypeInfo.red_content.get()) + j + "");
            localObject2 = localObject1;
            localObject1 = localObject4;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
            localObject3 = localObject1;
            localObject1 = localObject4;
          }
          continue;
        }
        if (localObject4 != null)
        {
          localObject5 = localObject4;
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
        }
        else
        {
          localObject3 = localObject1;
          localObject1 = localRedTypeInfo;
          continue;
          localObject4 = localObject1;
          if (localObject1 != null) {
            break;
          }
          if (QLog.isColorLevel())
          {
            if (localObject3 == null) {
              break label744;
            }
            QLog.e("RedPointManage", 2, "getRedTouchInfoByAppSet appset = " + paramInt + ";result != nullpathList = " + localStringBuilder.toString());
          }
          for (;;)
          {
            return localObject3;
            label744:
            QLog.e("RedPointManage", 2, "getRedTouchInfoByAppSet appset = " + paramInt + ";result = null");
          }
        }
      }
      Object localObject3 = localObject1;
      localObject1 = localObject5;
    }
  }
  
  public void d(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo == null) {
      return;
    }
    String str = paramAppInfo.path.get();
    this.b.OQ(paramAppInfo.buffer.get());
    if (paramAppInfo.type.get() == 5)
    {
      a(paramAppInfo, 9, paramString, true, 3);
      return;
    }
    a(paramAppInfo, str, paramString);
  }
  
  public void dJF()
  {
    label193:
    label198:
    label207:
    for (;;)
    {
      int k;
      synchronized (this.lock)
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody == null) || (!localTimeRspBody.rptMsgNumRedInfo.has())) {
          break label193;
        }
        Object localObject3 = localTimeRspBody.rptMsgNumRedInfo.get();
        if (localObject3 == null) {
          return;
        }
        localObject3 = ((List)localObject3).iterator();
        i = 0;
        if (!((Iterator)localObject3).hasNext()) {
          break label207;
        }
        List localList = ((BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject3).next()).num_red_path.get();
        if (localList == null) {
          continue;
        }
        k = 0;
        j = i;
        i = j;
        if (k >= localList.size()) {
          continue;
        }
        BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)localList.get(k);
        if (localNumRedPath.uint32_push_num_red_ts.get() + localNumRedPath.uint32_expire_time.get() < (int)(System.currentTimeMillis() / 1000L))
        {
          localNumRedPath.uint32_msg_status.set(4);
          i = 1;
          break label198;
          if (i != 0) {
            d(localTimeRspBody);
          }
          return;
        }
      }
      int i = j;
      break label198;
      i = 0;
      continue;
      k += 1;
      int j = i;
    }
  }
  
  public void dJH()
  {
    QLog.d("RedPointManage", 2, "getNewFlagOp:send redInfo start");
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("check_update_sp_key", 0);
    long l1 = ((SharedPreferences)localObject).getLong("conversation_remain_last_report", -1L);
    long l2 = QzoneConfig.getInstance().getConfig("WNSSettting", "conversation_remain_report_control", 60);
    long l3 = System.currentTimeMillis() / 1000L;
    if (l1 > l3 - l2) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("conversation_remain_last_report", l3);
    ((SharedPreferences.Editor)localObject).apply();
    a(null, null, 50);
  }
  
  public void dx(int paramInt, String paramString)
  {
    synchronized (this.lock)
    {
      int i = ah(paramString, 100);
      if (i > 0)
      {
        BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = a(paramInt);
        if (localNumRedInfo != null)
        {
          String str = localNumRedInfo.extend.get();
          a(a(localNumRedInfo.appset.get(), paramInt, paramString, i, false, str), 9, "", true, 3);
        }
      }
      return;
    }
  }
  
  public void e(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo.type.get() == 5)
    {
      a(paramAppInfo, 8, paramString, false, -1);
      return;
    }
    f(paramAppInfo, paramString);
  }
  
  public List<BusinessInfoCheckUpdate.AppSetting> fV()
  {
    synchronized (this.lock)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = a();
      if ((localObject3 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject3).rptSetting.has())) {
        return localArrayList;
      }
      localObject3 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject3).rptSetting.get();
      if (localObject3 != null) {
        localArrayList.addAll((Collection)localObject3);
      }
      return localArrayList;
    }
  }
  
  public BusinessInfoCheckUpdate.AppInfo getAppInfoByPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      onPrintLog("input path is Empty");
      return null;
    }
    onPrintLog("getAppInfoByPath path = " + paramString);
    return b(paramString);
  }
  
  public void h(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if ((paramAppInfo == null) || (paramString == null) || (paramString.length() == 0)) {
      return;
    }
    OR(paramAppInfo.path.get());
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.g.getCurrentAccountUin()));
    localReportReqBody.clientver.set("3.4.4.3058");
    localReportReqBody.platid.set(109);
    localReportReqBody.missionid.set(paramAppInfo.missions.get());
    localReportReqBody.appid.set(paramAppInfo.uiAppId.get());
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(5);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramAppInfo = new JSONObject();
      if (paramAppInfo != null) {}
      try
      {
        paramAppInfo.put("cmd", 5);
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = paramAppInfo;
        if (localJSONObject == null) {
          break label265;
        }
        Iterator localIterator = localJSONObject.keys();
        for (;;)
        {
          paramString = paramAppInfo;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          BusinessInfoCheckUpdate.ReportStaticsData localReportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
          localReportStaticsData.key.set(paramString);
          localReportStaticsData.value.set(localJSONObject.getString(paramString));
          localArrayList.add(localReportStaticsData);
        }
        paramString.printStackTrace();
      }
      catch (JSONException paramString) {}
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        label265:
        paramAppInfo = null;
      }
    }
    paramString = paramAppInfo;
    if (paramString != null) {
      localReportReqBody.buffer.set(paramString.toString());
    }
    localReportReqBody.reportdata.set(localArrayList);
    paramAppInfo = createToServiceMsg("RedTouchSvc.ClientReport");
    paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
    sendPbReq(paramAppInfo);
  }
  
  public void i(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    f(paramAppInfo, null);
  }
  
  public int iK(int paramInt)
  {
    onPrintLog("getExtraNumRedTotalNum appId = " + paramInt);
    synchronized (this.lock)
    {
      BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = a(paramInt);
      if (localNumRedInfo == null)
      {
        onPrintLog("getNumFromFileByAppid : cannot find the info by appid");
        return 0;
      }
      paramInt = localNumRedInfo.red_total_num.get();
      return paramInt;
    }
  }
  
  public int iL(int paramInt)
  {
    int j = 0;
    label169:
    label172:
    label175:
    for (;;)
    {
      synchronized (this.lock)
      {
        Object localObject2 = a();
        int i = j;
        if (localObject2 != null)
        {
          i = j;
          if (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.has())
          {
            localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.get();
            if (localObject2 == null)
            {
              onPrintLog("getNumRedShowNumByAppSet : numRedBusiList is null");
              return 0;
            }
            localObject2 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject2).hasNext()) {
              break label175;
            }
            BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next();
            if (paramInt != localNumRedInfo.appset.get()) {
              break label169;
            }
            if (localNumRedInfo.appid.get() == 7719) {
              continue;
            }
            if (!kS(localNumRedInfo.appid.get())) {
              break label169;
            }
            i = aH(localNumRedInfo.appid.get(), 100) + i;
            break label172;
          }
        }
        return i;
      }
    }
  }
  
  public void jq(int paramInt1, int paramInt2)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = getAppInfoByPath(paramInt1 + "");
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {}
    switch (paramInt2)
    {
    default: 
    case 30: 
      do
      {
        return;
        OR(localAppInfo.path.get());
      } while (localAppInfo.exposure_max.get() < 0);
      a(localAppInfo, paramInt2, true, null, null);
      return;
    }
    this.b.OQ(localAppInfo.buffer.get());
    cM(localAppInfo.path.get(), false);
    a(localAppInfo, paramInt2, true, null, null);
    acks.cw((QQAppInterface)this.g);
  }
  
  public void kP(long paramLong)
  {
    if ((TextUtils.isEmpty(this.bYj)) || (this.bYj.contains("."))) {}
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      return;
      localAppInfo = getAppInfoByPath(this.bYj);
    } while ((localAppInfo == null) || (paramLong < 0L));
    paramLong = System.currentTimeMillis() - this.lastClickTime;
    if (QLog.isColorLevel()) {
      QLog.e("residenceReport", 2, "residenceReport time = " + paramLong + ";path = " + this.bYj);
    }
    this.bYj = null;
    ThreadManager.post(new RedTouchManager.4(this, localAppInfo, paramLong), 2, null, true);
  }
  
  public boolean kS(int paramInt)
  {
    boolean bool = false;
    if (aH(paramInt, 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public boolean kT(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	altq:lock	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: aload_3
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: invokevirtual 63	altq:a	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnonnull +7 -> 30
    //   26: aload_3
    //   27: monitorexit
    //   28: iconst_1
    //   29: ireturn
    //   30: aload 4
    //   32: getfield 171	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:rptMsgNumRedInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   35: invokevirtual 174	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +66 -> 108
    //   45: aload 4
    //   47: invokeinterface 185 1 0
    //   52: astore 4
    //   54: aload 4
    //   56: invokeinterface 190 1 0
    //   61: ifeq +47 -> 108
    //   64: aload 4
    //   66: invokeinterface 194 1 0
    //   71: checkcast 196	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo
    //   74: astore 5
    //   76: aload 5
    //   78: getfield 199	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   81: invokevirtual 121	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   84: iload_1
    //   85: if_icmpne -31 -> 54
    //   88: aload 5
    //   90: getfield 1290	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo:flag	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   93: invokevirtual 972	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   96: istore_2
    //   97: aload_3
    //   98: monitorexit
    //   99: iload_2
    //   100: ireturn
    //   101: astore 4
    //   103: aload_3
    //   104: monitorexit
    //   105: aload 4
    //   107: athrow
    //   108: aload_3
    //   109: monitorexit
    //   110: iconst_1
    //   111: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	altq
    //   0	112	1	paramInt	int
    //   96	4	2	bool	boolean
    //   4	105	3	localObject1	Object
    //   101	5	4	localObject3	Object
    //   74	15	5	localNumRedInfo	BusinessInfoCheckUpdate.NumRedInfo
    // Exception table:
    //   from	to	target	type
    //   11	13	101	finally
    //   15	21	101	finally
    //   26	28	101	finally
    //   30	40	101	finally
    //   45	54	101	finally
    //   54	99	101	finally
    //   103	105	101	finally
    //   108	110	101	finally
  }
  
  public void onDestroy() {}
  
  public boolean p(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, "parsePushRedTouchInfo start");
    }
    try
    {
      dJI();
      if (QLog.isColorLevel()) {
        QLog.e("RedPointManage", 2, "parsePushRedTouchInfo end");
      }
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        QLog.e("RedPointManage", 1, "push parse error : e = " + paramArrayOfByte.getMessage());
      }
    }
  }
  
  public String yz()
  {
    SharedPreferences localSharedPreferences = this.g.getApp().getSharedPreferences("redTouchPref", 4);
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("lastClickPath", "");
  }
  
  public static abstract interface a
  {
    public abstract boolean a(altu paramaltu);
  }
  
  public static abstract interface b
  {
    public abstract void z(List<String> paramList, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altq
 * JD-Core Version:    0.7.0.1
 */