import BOSSStrategyCenter.tAdvDesc;
import NS_QBOSS_GATEWAY_PROTO.QbossGateWayRsp;
import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.entrance_cfg;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.master_info;
import NS_UNDEAL_COUNT.mobile_count_req;
import NS_UNDEAL_COUNT.mobile_count_rsp_new;
import NS_UNDEAL_COUNT.operat_data;
import NS_UNDEAL_COUNT.single_count;
import NS_UNDEAL_COUNT.stNuanNuanComment;
import NS_UNDEAL_COUNT.stPlusRecomInfo;
import NS_UNDEAL_COUNT.stVerticalVideoDisplay;
import NS_UNDEAL_COUNT.yellow_info;
import QZONE_OPERATION_ENTRANCE.EntranceRes;
import QZONE_OPERATION_ENTRANCE.OperEntranceInfo;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.service.qzone.QZoneTitleTabManager;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic.1;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic.2;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ands
{
  private static String cdo = "key_personalization_undeal_Count";
  public static HashMap<Integer, HashMap<Integer, avsd>> nh = new HashMap();
  
  public static void A(String paramString, ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = aqmr.listToString(paramArrayList, ",");
      QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, "setKuolieHotTags uin:" + paramString + " kuolieHotTags:" + paramArrayList);
      LocalMultiProcConfig.putString("KUOLIE_HOTTAGS" + paramString, paramArrayList);
      return;
    }
    LocalMultiProcConfig.putString("KUOLIE_HOTTAGS" + paramString, "");
  }
  
  public static void A(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      LocalMultiProcConfig.putString("BANNER_INFO" + paramString, Base64.encodeToString(paramArrayOfByte, 2));
      return;
    }
    LocalMultiProcConfig.putString("BANNER_INFO" + paramString, "");
  }
  
  public static void B(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      LocalMultiProcConfig.putString("BIRTHRECOM_INFO" + paramString, Base64.encodeToString(paramArrayOfByte, 2));
      return;
    }
    LocalMultiProcConfig.putString("BIRTHRECOM_INFO" + paramString, "");
  }
  
  public static boolean P(int paramInt, String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    ands.a locala;
    if (Build.VERSION.SDK_INT >= 21)
    {
      locala = new ands.a();
      bool1 = bool3;
      if (locala.load())
      {
        if (paramInt != 2) {
          break label58;
        }
        if (locala.dFb <= 0) {
          break label53;
        }
        bool1 = bool2;
      }
    }
    label53:
    label58:
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
        bool1 = bool3;
      } while (locala.dFc <= 0);
      bool1 = bool3;
    } while (locala.inBlackList(paramString));
    return true;
  }
  
  public static void Qq(String paramString) {}
  
  public static byte[] Y(String paramString)
  {
    return Base64.decode(LocalMultiProcConfig.getString("BANNER_INFO" + paramString, ""), 2);
  }
  
  public static byte[] Z(String paramString)
  {
    return Base64.decode(LocalMultiProcConfig.getString("BIRTHRECOM_INFO" + paramString, ""), 2);
  }
  
  public static Map<Long, Long> a(Long paramLong)
  {
    localHashMap = new HashMap();
    paramLong = LocalMultiProcConfig.getString4Uin("getMapLastGetTime", "", paramLong.longValue());
    QLog.i("UndealCount.QZoneUnreadServletLogic", 1, "getUdealCountLastGetTime: " + paramLong);
    if (!TextUtils.isEmpty(paramLong))
    {
      paramLong = new JSONTokener(paramLong);
      try
      {
        paramLong = (JSONArray)paramLong.nextValue();
        int i = 0;
        while (i < paramLong.length())
        {
          JSONObject localJSONObject = paramLong.getJSONObject(i);
          localHashMap.put(Long.valueOf(localJSONObject.getLong("key")), Long.valueOf(localJSONObject.getLong("value")));
          i += 1;
        }
        return localHashMap;
      }
      catch (JSONException paramLong)
      {
        QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "getMapLastGetTime JSONException", paramLong);
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null)
      {
        LocalMultiProcConfig.putInt4Uin("qzone_redpocket_plus_entry", paramInt1, Long.valueOf(paramQQAppInterface).longValue());
        LocalMultiProcConfig.putInt4Uin("qzone_redpocket_visitor_entry", paramInt2, Long.valueOf(paramQQAppInterface).longValue());
      }
    }
  }
  
  public static void a(int paramInt, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null)
      {
        LocalMultiProcConfig.putInt4Uin("creditlevel", paramInt, Long.valueOf(paramQQAppInterface).longValue());
        LocalMultiProcConfig.putString4Uin("creditmessage", paramString, Long.valueOf(paramQQAppInterface).longValue());
        QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "creditlevel:" + paramInt + " message:" + paramString);
      }
    }
  }
  
  private static void a(count_info paramcount_info)
  {
    if ((paramcount_info == null) || (paramcount_info.vecUinList == null)) {
      return;
    }
    QLog.i("UndealCount.QZoneUnreadServletLogic", 1, "recv Qzone Unread Push: Feed实时更新未读");
    Intent localIntent = new Intent("com.qzone.push_feed_unread");
    if (paramcount_info != null) {
      localIntent.putExtra("feeds_unread", paramcount_info);
    }
    BaseApplication.getContext().sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
  }
  
  public static void a(mobile_count_rsp_new parammobile_count_rsp_new, long paramLong)
  {
    if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.extendinfo != null) && (parammobile_count_rsp_new.extendinfo.containsKey(Integer.valueOf(1010))))
    {
      parammobile_count_rsp_new = (String)parammobile_count_rsp_new.extendinfo.get(Integer.valueOf(1010));
      QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, "handleRenZhenghaoInfo certified_puin:" + parammobile_count_rsp_new);
      if (!TextUtils.isEmpty(parammobile_count_rsp_new)) {
        LocalMultiProcConfig.putString4Uin("certified_puin", parammobile_count_rsp_new, paramLong);
      }
    }
    else
    {
      return;
    }
    LocalMultiProcConfig.putString4Uin("certified_puin", "0", paramLong);
  }
  
  public static void a(mobile_count_rsp_new parammobile_count_rsp_new, QbossGateWayRsp paramQbossGateWayRsp, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new.mapExtendinfo != null) && ("CLEARALL".equalsIgnoreCase((String)parammobile_count_rsp_new.mapExtendinfo.get("appid_2586"))))
    {
      LocalMultiProcConfig.putString4Uin("friendheadmenudata", "", paramQQAppInterface.getLongAccountUin());
      QLog.w("UndealCount.QZoneUnreadServletLogic", 1, "handleHeadMenuData:clearAll");
    }
    label52:
    label204:
    do
    {
      do
      {
        do
        {
          break label52;
          do
          {
            return;
          } while ((paramQbossGateWayRsp.mapAdv == null) || (paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2586)) == null));
          parammobile_count_rsp_new = (ArrayList)paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2586));
          if (parammobile_count_rsp_new.size() <= 0) {
            break label204;
          }
          parammobile_count_rsp_new = ((tAdvDesc)parammobile_count_rsp_new.get(0)).res_data;
          if (TextUtils.isEmpty(parammobile_count_rsp_new)) {
            break;
          }
          paramQbossGateWayRsp = LocalMultiProcConfig.getString4Uin("friendheadmenudata", "", paramQQAppInterface.getLongAccountUin());
          if (!parammobile_count_rsp_new.equals(paramQbossGateWayRsp)) {
            LocalMultiProcConfig.putString4Uin("friendheadmenudata", parammobile_count_rsp_new, paramQQAppInterface.getLongAccountUin());
          }
        } while (!QLog.isColorLevel());
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "headDropMenuUrl:" + paramQbossGateWayRsp);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "headDropMenuUrl: null");
      return;
    } while (!QLog.isColorLevel());
    QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "advDescs.size() = 0");
  }
  
  private static void a(mobile_count_rsp_new parammobile_count_rsp_new, aneq paramaneq)
  {
    if (parammobile_count_rsp_new == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramaneq == null);
        if (parammobile_count_rsp_new.iNextTimeout > 0)
        {
          paramaneq.akE = (parammobile_count_rsp_new.iNextTimeout * 1000);
          if (QLog.isColorLevel()) {
            QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "onReceive getFeedInterval:" + paramaneq.akE);
          }
        }
      } while (parammobile_count_rsp_new.switchTimeout <= 0);
      paramaneq.akF = (parammobile_count_rsp_new.switchTimeout * 1000);
    } while (!QLog.isColorLevel());
    QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "onReceive getActiveAppInterval:" + paramaneq.akF);
  }
  
  public static void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, QQAppInterface paramQQAppInterface, aneq paramaneq)
  {
    paramIntent = paramFromServiceMsg.getWupBuffer();
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        paramFromServiceMsg = andp.a(paramIntent, paramQQAppInterface, "getUndealCount");
      } while ((paramFromServiceMsg == null) || (!(paramFromServiceMsg instanceof mobile_count_rsp_new)));
      paramFromServiceMsg = (mobile_count_rsp_new)paramFromServiceMsg;
    } while (paramFromServiceMsg == null);
    if (QLog.isDevelopLevel()) {
      QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "onResponseCMD_STRING_GET_UNDEAL_COUNT rsp has data");
    }
    a(paramFromServiceMsg.mapLastGetTime, Long.valueOf(paramQQAppInterface.getCurrentAccountUin()));
    ajdp localajdp = (ajdp)paramQQAppInterface.getManager(10);
    if (localajdp != null) {
      localajdp.QD(0);
    }
    if ((paramFromServiceMsg.stMapCountInfo != null) && (paramFromServiceMsg.stMapCountInfo.get(Integer.valueOf(1)) != null)) {
      a((count_info)paramFromServiceMsg.stMapCountInfo.get(Integer.valueOf(1)));
    }
    LocalMultiProcConfig.putInt4Uin("qzone_preget_passive_open", paramFromServiceMsg.isPreLoad, paramQQAppInterface.getLongAccountUin());
    a(paramIntent, paramFromServiceMsg, paramQQAppInterface, paramaneq);
    b(paramFromServiceMsg, paramQQAppInterface);
    c(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg, paramaneq);
    e(paramFromServiceMsg, paramQQAppInterface);
    d(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg.sqDyncFeedsJson, paramaneq);
    j(paramFromServiceMsg, paramQQAppInterface);
    h(paramFromServiceMsg.isLiveShow, paramQQAppInterface);
    a(paramFromServiceMsg.isPlusRedBous, paramFromServiceMsg.isVistorRedBous, paramQQAppInterface);
    o(paramFromServiceMsg.strRedBousUrl, paramQQAppInterface);
    j(paramFromServiceMsg.vecOperateInfo, paramQQAppInterface.getCurrentAccountUin());
    g(paramFromServiceMsg.isSetMemorySeal, paramQQAppInterface);
    i(paramFromServiceMsg.grayOperateMask, paramQQAppInterface);
    j(paramFromServiceMsg.isGetActiveWeiShi, paramQQAppInterface);
    k(paramFromServiceMsg, paramQQAppInterface);
    b(paramFromServiceMsg, paramQQAppInterface.getLongAccountUin());
    c(paramFromServiceMsg);
    h(paramFromServiceMsg, paramQQAppInterface);
    b(paramFromServiceMsg);
    g(paramFromServiceMsg, paramQQAppInterface);
    i(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg, paramQQAppInterface.getLongAccountUin());
    f(paramFromServiceMsg, paramQQAppInterface);
    ap(paramFromServiceMsg.cancellation_status, paramQQAppInterface.getLongAccountUin());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, Long paramLong)
  {
    if (paramQQAppInterface == null) {}
    HashMap localHashMap;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.getManager(10);
      } while ((paramQQAppInterface == null) || (!(paramQQAppInterface instanceof aneo)));
      localHashMap = (HashMap)nh.get(Integer.valueOf(paramInt));
      nh.remove(Integer.valueOf(paramInt));
    } while ((localHashMap == null) || (localHashMap.isEmpty()));
    if ((paramLong.longValue() != -1L) && (localHashMap.get(Integer.valueOf(1)) != null))
    {
      avsd localavsd = (avsd)localHashMap.get(Integer.valueOf(1));
      localavsd.uCount = paramLong.longValue();
      localHashMap.put(Integer.valueOf(1), localavsd);
    }
    ((aneo)paramQQAppInterface).G(localHashMap);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, FromServiceMsg paramFromServiceMsg, aneq paramaneq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "inform QZONE_GET_UNREAD isSuccess false");
    }
    if (paramaneq != null) {
      paramaneq.notifyObserver(null, 1000, false, new Bundle(), akln.class);
    }
    if (paramQQAppInterface != null)
    {
      paramIntent = "|resultcode: " + paramFromServiceMsg.getResultCode() + "|reason: " + MessageHandler.b(paramFromServiceMsg);
      paramFromServiceMsg = new HashMap();
      paramFromServiceMsg.put("param_FailCode", String.valueOf(9311));
      paramFromServiceMsg.put("param_errorDesc", paramIntent);
      anpc.a(paramQQAppInterface.getApp()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "actQzoneUnread", false, aneq.receiveTime - aneq.akG, 0L, paramFromServiceMsg, "");
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, aneq paramaneq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "inform QZONE_GET_UNREAD isSuccess false");
    }
    if (paramaneq != null) {
      paramaneq.notifyObserver(null, 1000, false, new Bundle(), akln.class);
    }
    if (paramQQAppInterface != null)
    {
      paramArrayOfByte = "|wufbuf: " + aqhs.bytes2HexStr(paramArrayOfByte);
      paramaneq = new HashMap();
      paramaneq.put("param_FailCode", String.valueOf(9045));
      paramaneq.put("param_errorDesc", paramArrayOfByte);
      anpc.a(paramQQAppInterface.getApp()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "actQzoneUnread", false, aneq.receiveTime - aneq.akG, 0L, paramaneq, "");
    }
  }
  
  private static void a(String paramString, aneq paramaneq)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramaneq == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("sqDyncFeedsJson", paramString);
    paramaneq.notifyObserver(null, 1003, true, localBundle, akln.class);
  }
  
  public static void a(Map<Long, Long> paramMap, Long paramLong)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    JSONArray localJSONArray;
    do
    {
      return;
      localJSONArray = new JSONArray();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("key", localEntry.getKey());
          localJSONObject.put("value", localEntry.getValue());
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException paramMap)
        {
          QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "setMapLastGetTime JSONException", paramMap);
          return;
        }
      }
    } while (localJSONArray.length() <= 0);
    paramMap = localJSONArray.toString();
    LocalMultiProcConfig.putString4Uin("getMapLastGetTime", paramMap, paramLong.longValue());
    QLog.i("UndealCount.QZoneUnreadServletLogic", 1, "setUdealCountLastGetTime: " + paramMap);
  }
  
  private static void a(JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    int j;
    int i;
    if ((paramJSONArray != null) && (paramJSONObject != null))
    {
      j = paramJSONArray.length();
      i = 0;
    }
    for (;;)
    {
      if (i < j) {}
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        if (localJSONObject.optString("priority", "0").equalsIgnoreCase(paramJSONObject.optString("priority", "0")))
        {
          QLog.d("UndealCount.QZoneUnreadServletLogic", 1, "find one,oldData:" + localJSONObject.toString() + " ,newData:" + paramJSONObject.toString());
          paramJSONArray.put(i, paramJSONObject);
          if (i == j)
          {
            paramJSONArray.put(paramJSONObject);
            QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "add newData:" + paramJSONObject.toString());
          }
          return;
        }
        i += 1;
      }
      catch (Throwable paramJSONArray)
      {
        QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "updateSurpriseData error:", paramJSONArray);
      }
    }
  }
  
  private static void a(byte[] paramArrayOfByte, mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface, aneq paramaneq)
  {
    HashMap localHashMap = new HashMap();
    boolean bool = a(parammobile_count_rsp_new, localHashMap, paramQQAppInterface);
    int i = 0;
    if (bool) {
      i = avzf.a().a().ax(paramQQAppInterface.getLongAccountUin());
    }
    if (localHashMap == null) {}
    do
    {
      return;
      if (localHashMap.size() == 0) {
        break label129;
      }
      if (bool) {
        break;
      }
    } while (paramQQAppInterface == null);
    paramArrayOfByte = paramQQAppInterface.getManager(10);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof aneo)))
    {
      ((aneo)paramArrayOfByte).G(localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebanew", 2, "qzone redtypeinfo:recive undealcount rsp");
      }
    }
    for (;;)
    {
      dP(paramQQAppInterface);
      return;
      nh.put(Integer.valueOf(i), localHashMap);
    }
    label129:
    a(paramQQAppInterface, paramArrayOfByte, paramaneq);
  }
  
  private static boolean a(entrance_cfg paramentrance_cfg1, entrance_cfg paramentrance_cfg2)
  {
    if ((paramentrance_cfg1 == null) && (paramentrance_cfg2 == null)) {}
    do
    {
      return true;
      if (paramentrance_cfg1 == null) {
        return false;
      }
      if (paramentrance_cfg2 == null) {
        return false;
      }
    } while ((paramentrance_cfg1.iEntranceId == paramentrance_cfg2.iEntranceId) && (TextUtils.equals(paramentrance_cfg1.sEntranceAction, paramentrance_cfg2.sEntranceAction)) && (TextUtils.equals(paramentrance_cfg1.sEntranceName, paramentrance_cfg2.sEntranceName)) && (TextUtils.equals(paramentrance_cfg1.sEntranceIcon, paramentrance_cfg2.sEntranceIcon)) && (TextUtils.equals(paramentrance_cfg1.sQbossEntranceIcon, paramentrance_cfg2.sQbossEntranceIcon)));
    return false;
  }
  
  public static boolean a(mobile_count_rsp_new parammobile_count_rsp_new, HashMap<Integer, avsd> paramHashMap, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "onResponse");
    }
    boolean bool3 = false;
    boolean bool1 = false;
    if ((parammobile_count_rsp_new.extendinfo != null) && (paramQQAppInterface != null)) {
      i(paramQQAppInterface.getCurrentUin(), parammobile_count_rsp_new.extendinfo);
    }
    boolean bool2;
    if ((parammobile_count_rsp_new.veckuolieHotTag != null) && (!parammobile_count_rsp_new.veckuolieHotTag.isEmpty()) && (paramQQAppInterface != null))
    {
      A(paramQQAppInterface.getCurrentUin(), parammobile_count_rsp_new.veckuolieHotTag);
      if ((parammobile_count_rsp_new.mapTransData != null) && (paramQQAppInterface != null) && (parammobile_count_rsp_new.mapTransData.containsKey("unreadCountBanner"))) {
        A(paramQQAppInterface.getCurrentUin(), (byte[])parammobile_count_rsp_new.mapTransData.get("unreadCountBanner"));
      }
      if ((parammobile_count_rsp_new.mapTransData != null) && (paramQQAppInterface != null) && (parammobile_count_rsp_new.mapTransData.containsKey("frdBirthRecom"))) {
        B(paramQQAppInterface.getCurrentUin(), (byte[])parammobile_count_rsp_new.mapTransData.get("frdBirthRecom"));
      }
      if (parammobile_count_rsp_new != null) {
        break label193;
      }
      bool2 = bool1;
    }
    label193:
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool2;
            A(paramQQAppInterface.getCurrentUin(), null);
            break;
            bool2 = bool1;
          } while (parammobile_count_rsp_new.stMapCountInfo == null);
          bool2 = bool1;
        } while (parammobile_count_rsp_new.stMapCountInfo.size() == 0);
        bool2 = bool1;
      } while (paramHashMap == null);
      i = 1;
      bool1 = bool3;
      bool2 = bool1;
    } while (i >= 1010);
    count_info localcount_info = (count_info)parammobile_count_rsp_new.stMapCountInfo.get(Integer.valueOf(i));
    if (localcount_info != null)
    {
      avsd localavsd = new avsd();
      if (localcount_info.stCount != null)
      {
        localavsd.uCount = localcount_info.stCount.uCount;
        localavsd.iControl = localcount_info.stCount.iControl;
        if (QLog.isDevelopLevel())
        {
          QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "onResponse unread cout: " + localcount_info.stCount.uCount + "unread type: " + i);
          QLog.d("Q.lebanew", 2, "qzone redtypeinfo:onResponse unread cout: " + localcount_info.stCount.uCount + "unread type: " + i);
        }
        if ((i == 1) && (localavsd.uCount > 0L) && (paramQQAppInterface != null) && (parammobile_count_rsp_new.isPreLoad == 1) && (!TextUtils.isEmpty(parammobile_count_rsp_new.undealCountTime)) && (!LocalMultiProcConfig.getString4Uin("qzone_passive_undealtime", "", paramQQAppInterface.getLongAccountUin()).equals(parammobile_count_rsp_new.undealCountTime)))
        {
          bool1 = true;
          label466:
          QZoneCountUserInfo localQZoneCountUserInfo = null;
          Object localObject = localQZoneCountUserInfo;
          if (parammobile_count_rsp_new.mapTransData != null)
          {
            byte[] arrayOfByte = (byte[])parammobile_count_rsp_new.mapTransData.get("PassiveFeedsPush");
            localObject = localQZoneCountUserInfo;
            if (arrayOfByte != null) {
              localObject = (PassiveFeedsPush)awck.decodeWup(PassiveFeedsPush.class, arrayOfByte);
            }
          }
          if ((localcount_info.vecUinList != null) && (localcount_info.vecUinList.size() > 0))
          {
            int j = 0;
            while (j < localcount_info.vecUinList.size())
            {
              localQZoneCountUserInfo = new QZoneCountUserInfo();
              localQZoneCountUserInfo.uin = ((feed_host_info)localcount_info.vecUinList.get(j)).uUin;
              if (((feed_host_info)localcount_info.vecUinList.get(j)).OpuinYellowInfo != null)
              {
                localQZoneCountUserInfo.iYellowType = ((feed_host_info)localcount_info.vecUinList.get(j)).OpuinYellowInfo.iYellowType;
                localQZoneCountUserInfo.iYellowLevel = ((feed_host_info)localcount_info.vecUinList.get(j)).OpuinYellowInfo.iYellowLevel;
                localQZoneCountUserInfo.isAnnualVip = ((feed_host_info)localcount_info.vecUinList.get(j)).OpuinYellowInfo.isAnnualVip;
              }
              localQZoneCountUserInfo.vec_feedInfos = ((feed_host_info)localcount_info.vecUinList.get(j)).vec_feedInfos;
              localQZoneCountUserInfo.nickName = ((feed_host_info)localcount_info.vecUinList.get(j)).nickname;
              if ((localObject != null) && (((PassiveFeedsPush)localObject).stBubbleSkin != null) && (localQZoneCountUserInfo.uin == ((PassiveFeedsPush)localObject).stBubbleSkin.lUin)) {
                localQZoneCountUserInfo.a = ((PassiveFeedsPush)localObject);
              }
              localavsd.ES.add(localQZoneCountUserInfo);
              j += 1;
            }
            localavsd.cNl = ((feed_host_info)localcount_info.vecUinList.get(0)).actiondesc;
            if (QLog.isDevelopLevel()) {
              QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "onResponse unread list first uin: " + ((feed_host_info)localcount_info.vecUinList.get(0)).uUin + ",actiondesc: " + ((feed_host_info)localcount_info.vecUinList.get(0)).actiondesc);
            }
          }
          localavsd.trace_info = localcount_info.trace_info;
          localavsd.eyn = localcount_info.iSubCountID;
          localavsd.strShowMsg = localcount_info.strShowMsg;
          localavsd.cNn = localcount_info.strReportValue;
          localavsd.iconUrl = localcount_info.strIconUrl;
          localavsd.cTime = localcount_info.cTime;
          paramHashMap.put(Integer.valueOf(i), localavsd);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      break label466;
    }
  }
  
  private static boolean a(ArrayList<entrance_cfg> paramArrayList, entrance_cfg paramentrance_cfg)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return false;
      if (paramentrance_cfg != null)
      {
        int i = 0;
        while (i < paramArrayList.size())
        {
          if (a(paramentrance_cfg, (entrance_cfg)paramArrayList.get(i))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static byte[] a(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Map<Integer, count_info> paramMap, String paramString2, Map<Long, Long> paramMap1)
  {
    if (paramLong == 0L) {
      return null;
    }
    paramString1 = new mobile_count_req();
    paramString1.iRelationType = 1;
    paramString1.iVisitQZoneType = paramInt3;
    paramString1.mapTimeStamp = c(paramLong);
    paramString1.mapLastGetTime = a(Long.valueOf(paramLong));
    paramString1.stMapCountInfo = paramMap;
    paramString1.extendinfo = b(paramLong);
    paramString1.lastUndealCountTime = paramString2;
    paramString1.mapDyncShowTime = paramMap1;
    return andp.a(paramString1, "getUndealCount", paramLong, paramInt1, paramInt2, paramInt4);
  }
  
  public static int ad(long paramLong)
  {
    int i = LocalMultiProcConfig.getInt4Uin("cancellation_status", 0, paramLong);
    QLog.d("UndealCount.QZoneUnreadServletLogic", 1, "getCancellationStatus:" + i);
    return i;
  }
  
  public static void ap(int paramInt, long paramLong)
  {
    QLog.d("UndealCount.QZoneUnreadServletLogic", 1, "handleCancellationStatus status:" + paramInt);
    LocalMultiProcConfig.putInt4Uin("cancellation_status", paramInt, paramLong);
  }
  
  public static List<Integer> b(Map<Integer, avsd> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.keySet();
      if (paramMap != null)
      {
        paramMap = paramMap.iterator();
        while (paramMap.hasNext())
        {
          Integer localInteger = (Integer)paramMap.next();
          if (localInteger.intValue() >= 1006) {
            localArrayList.add(localInteger);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static Map<Integer, String> b(long paramLong)
  {
    QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, "getExtendInfo uin:" + paramLong + " extend_info:" + LocalMultiProcConfig.getString(new StringBuilder().append("EXTEND_INFO").append(paramLong).toString(), ""));
    Map localMap = andt.w(LocalMultiProcConfig.getString("EXTEND_INFO" + paramLong, ""));
    if (cH(paramLong)) {
      localMap.put(Integer.valueOf(1003), "0");
    }
    return localMap;
  }
  
  public static void b(long paramLong, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null) {
        LocalMultiProcConfig.putInt4Uin("qzone_jinyan", (int)(0x8000 & paramLong), Long.valueOf(paramQQAppInterface).longValue());
      }
    }
  }
  
  private static void b(mobile_count_rsp_new parammobile_count_rsp_new)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QZoneUnreadServletLogic.2(parammobile_count_rsp_new));
  }
  
  public static void b(mobile_count_rsp_new parammobile_count_rsp_new, long paramLong)
  {
    if (parammobile_count_rsp_new == null) {}
    for (;;)
    {
      return;
      try
      {
        long l;
        Object localObject;
        if ((parammobile_count_rsp_new.snnComment != null) && (parammobile_count_rsp_new.snnComment.iStatus != 0) && (paramLong != -1L))
        {
          l = System.currentTimeMillis();
          QLog.w("UndealCount.QZoneUnreadServletLogic", 1, "get dualwarm normal comment command, " + parammobile_count_rsp_new.snnComment.iStatus + "timestamp " + l);
          localObject = parammobile_count_rsp_new.snnComment;
          JceOutputStream localJceOutputStream = new JceOutputStream();
          localJceOutputStream.setServerEncoding("utf8");
          ((stNuanNuanComment)localObject).writeTo(localJceOutputStream);
          LocalMultiProcConfig.putString4Uin("qzone_dual_warm_comment_info", aqgo.encodeToString(localJceOutputStream.toByteArray(), 0), paramLong);
          LocalMultiProcConfig.putLong4Uin("qzone_dual_warm_comment_update_time", l, paramLong);
        }
        if ((parammobile_count_rsp_new.sContentOpComment != null) && (parammobile_count_rsp_new.sContentOpComment.iStatus != 0) && (paramLong != -1L))
        {
          l = System.currentTimeMillis();
          QLog.w("UndealCount.QZoneUnreadServletLogic", 1, "get dualwarm operation comment command, " + parammobile_count_rsp_new.sContentOpComment.iStatus + "timestamp " + l);
          parammobile_count_rsp_new = parammobile_count_rsp_new.sContentOpComment;
          localObject = new JceOutputStream();
          ((JceOutputStream)localObject).setServerEncoding("utf8");
          parammobile_count_rsp_new.writeTo((JceOutputStream)localObject);
          LocalMultiProcConfig.putString4Uin("qzone_dual_warm_operation_comment_info", aqgo.encodeToString(((JceOutputStream)localObject).toByteArray(), 0), paramLong);
          return;
        }
      }
      catch (Exception parammobile_count_rsp_new)
      {
        QLog.e("UndealCount.QZoneUnreadServletLogic", 100, "save dual warm data failed", parammobile_count_rsp_new);
      }
    }
  }
  
  public static void b(mobile_count_rsp_new parammobile_count_rsp_new, QbossGateWayRsp paramQbossGateWayRsp, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new.mapExtendinfo != null) && ("CLEARALL".equalsIgnoreCase((String)parammobile_count_rsp_new.mapExtendinfo.get("appid_2585"))))
    {
      LocalMultiProcConfig.putString4Uin("friendplusmenudata", "", paramQQAppInterface.getLongAccountUin());
      QLog.w("UndealCount.QZoneUnreadServletLogic", 1, "handlePlusMenuData:clearAll");
    }
    label52:
    label202:
    do
    {
      do
      {
        do
        {
          break label52;
          do
          {
            return;
          } while ((paramQbossGateWayRsp.mapAdv == null) || (paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2585)) == null));
          parammobile_count_rsp_new = (ArrayList)paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2585));
          if (parammobile_count_rsp_new.size() <= 0) {
            break label202;
          }
          parammobile_count_rsp_new = ((tAdvDesc)parammobile_count_rsp_new.get(0)).res_data;
          if (TextUtils.isEmpty(parammobile_count_rsp_new)) {
            break;
          }
          if (!parammobile_count_rsp_new.equals(LocalMultiProcConfig.getString4Uin("friendplusmenudata", "", paramQQAppInterface.getLongAccountUin()))) {
            LocalMultiProcConfig.putString4Uin("friendplusmenudata", parammobile_count_rsp_new, paramQQAppInterface.getLongAccountUin());
          }
        } while (!QLog.isColorLevel());
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "plusMenuData:" + parammobile_count_rsp_new);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "plusMenuData: null");
      return;
    } while (!QLog.isColorLevel());
    QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "handlePlusMenuData advDescs.size() = 0");
  }
  
  private static void b(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {}
    while ((parammobile_count_rsp_new.stYellowInfo == null) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin()))) {
      return;
    }
    avqy.a().a(parammobile_count_rsp_new.stYellowInfo.iYellowType, parammobile_count_rsp_new.stYellowInfo.iYellowLevel, parammobile_count_rsp_new.stYellowInfo.isAnnualVip, parammobile_count_rsp_new.stuStarInfo, parammobile_count_rsp_new.stuCombineDiamondInfo);
  }
  
  public static Map<Integer, Long> c(long paramLong)
  {
    Map localMap = v(LocalMultiProcConfig.getString("CTIME_MAP" + paramLong, ""));
    if (!localMap.containsKey(Integer.valueOf(0))) {
      localMap.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    return localMap;
  }
  
  public static void c(mobile_count_rsp_new parammobile_count_rsp_new)
  {
    if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.vec_soft_infos != null) && (parammobile_count_rsp_new.vec_soft_infos.size() != 0))
    {
      long l = System.currentTimeMillis();
      QLog.w("UndealCount.QZoneUnreadServletLogic", 1, "get FeedSoft command, " + parammobile_count_rsp_new.snnComment.iStatus + "timestamp " + l);
      parammobile_count_rsp_new = parammobile_count_rsp_new.vec_soft_infos;
      JceOutputStream localJceOutputStream = new JceOutputStream();
      localJceOutputStream.setServerEncoding("utf8");
      localJceOutputStream.write(parammobile_count_rsp_new, 1);
      LocalMultiProcConfig.putString("qzone_soft_infos", aqgo.encodeToString(localJceOutputStream.toByteArray(), 0));
    }
  }
  
  public static void c(mobile_count_rsp_new parammobile_count_rsp_new, QbossGateWayRsp paramQbossGateWayRsp, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new.mapExtendinfo != null) && ("CLEARALL".equalsIgnoreCase((String)parammobile_count_rsp_new.mapExtendinfo.get("appid_2595"))))
    {
      LocalMultiProcConfig.putString4Uin("surprise_config", "", paramQQAppInterface.getLongAccountUin());
      QLog.w("UndealCount.QZoneUnreadServletLogic", 1, "handleSurpriseData:clearAll");
    }
    while ((paramQbossGateWayRsp.mapAdv == null) || (paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2595)) == null)) {
      return;
    }
    parammobile_count_rsp_new = LocalMultiProcConfig.getString4Uin("surprise_config", "", paramQQAppInterface.getLongAccountUin());
    if (TextUtils.isEmpty(parammobile_count_rsp_new)) {
      parammobile_count_rsp_new = new JSONArray();
    }
    for (;;)
    {
      paramQbossGateWayRsp = ((ArrayList)paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2595))).iterator();
      while (paramQbossGateWayRsp.hasNext())
      {
        tAdvDesc localtAdvDesc = (tAdvDesc)paramQbossGateWayRsp.next();
        if (!TextUtils.isEmpty(localtAdvDesc.res_data)) {
          try
          {
            a(parammobile_count_rsp_new, new JSONObject(localtAdvDesc.res_data));
          }
          catch (Throwable localThrowable)
          {
            QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "parse advDesc.res_data error,catch an exception", localThrowable);
          }
        }
      }
      try
      {
        parammobile_count_rsp_new = new JSONArray(parammobile_count_rsp_new);
      }
      catch (Exception localException)
      {
        parammobile_count_rsp_new = new JSONArray();
        QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "parse local advDesc.res_data error,catch an exception", localException);
      }
    }
    LocalMultiProcConfig.putString4Uin("surprise_config", parammobile_count_rsp_new.toString(), paramQQAppInterface.getLongAccountUin());
    QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "all configs:" + parammobile_count_rsp_new.toString());
  }
  
  public static void c(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {}
    while ((parammobile_count_rsp_new.stMasterInfo == null) || (paramQQAppInterface == null)) {
      return;
    }
    a(parammobile_count_rsp_new.stMasterInfo.iLevel, parammobile_count_rsp_new.stMasterInfo.strMessage, paramQQAppInterface);
    b(parammobile_count_rsp_new.stMasterInfo.host_unimbitmap, paramQQAppInterface);
  }
  
  public static String[] c(long paramLong)
  {
    String str = LocalMultiProcConfig.getString("KUOLIE_HOTTAGS" + paramLong, "");
    QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, "getKuolieHotTags uin:" + paramLong + " getKuolieHotTags:" + str);
    if (!TextUtils.isEmpty(str)) {
      return str.split(",");
    }
    return null;
  }
  
  private static boolean cH(long paramLong)
  {
    Object localObject = LocalMultiProcConfig.getString4Uin("qzone_dual_warm_comment_info", "", paramLong);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return true;
    }
    try
    {
      localObject = (stNuanNuanComment)decodeWup(stNuanNuanComment.class, aqgo.decode((String)localObject, 0));
      if ((localObject != null) && (((stNuanNuanComment)localObject).vcOtherComments != null))
      {
        int i = ((stNuanNuanComment)localObject).vcOtherComments.size();
        if (i > 0) {
          break label68;
        }
      }
      label68:
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return true;
    }
    catch (Throwable localThrowable) {}
  }
  
  private static void d(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    QZoneTitleTabManager.a(parammobile_count_rsp_new, paramQQAppInterface);
  }
  
  private static void dP(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      long l = System.currentTimeMillis();
      HashMap localHashMap = new HashMap();
      anpc.a(paramQQAppInterface.getApp()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "actQzoneUnread", true, l - aneq.akG, 0L, localHashMap, "");
    }
  }
  
  private static <T extends JceStruct> T decodeWup(Class<T> paramClass, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramClass = (JceStruct)paramClass.newInstance();
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf8");
      paramClass.readFrom(paramArrayOfByte);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  private static void e(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {}
    do
    {
      do
      {
        return;
        LocalMultiProcConfig.putInt4Uin("navigator_bar_style", parammobile_count_rsp_new.isShowNewStyles, paramQQAppInterface.getLongAccountUin());
      } while ((parammobile_count_rsp_new.mapEntranceCfg == null) || (parammobile_count_rsp_new.mapEntranceCfg.size() == 0));
      parammobile_count_rsp_new = (ArrayList)parammobile_count_rsp_new.mapEntranceCfg.get(Integer.valueOf(2));
    } while ((parammobile_count_rsp_new == null) || (parammobile_count_rsp_new.size() == 0));
    if (QLog.isDevelopLevel()) {
      QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "handleNavigatorBarInfo rsp entracesize is:" + parammobile_count_rsp_new.size());
    }
    ThreadManager.post(new QZoneUnreadServletLogic.1(paramQQAppInterface, parammobile_count_rsp_new), 8, null, false);
  }
  
  private static void f(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    parammobile_count_rsp_new = parammobile_count_rsp_new.plusRecom;
    if (parammobile_count_rsp_new == null) {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "plusRecom null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "plusRecom.status=" + parammobile_count_rsp_new.status + "  plusRecom.strMinProgramJson=" + parammobile_count_rsp_new.strMinProgramJson);
      }
      if (parammobile_count_rsp_new.status == -1)
      {
        LocalMultiProcConfig.putString4Uin("friendplusmenurecom", "", paramQQAppInterface.getLongAccountUin());
        return;
      }
    } while (parammobile_count_rsp_new.status != 1);
    LocalMultiProcConfig.putString4Uin("friendplusmenurecom", parammobile_count_rsp_new.strMinProgramJson, paramQQAppInterface.getLongAccountUin());
  }
  
  private static boolean f(ArrayList<entrance_cfg> paramArrayList1, ArrayList<entrance_cfg> paramArrayList2)
  {
    boolean bool = true;
    if (paramArrayList1 == null) {}
    int j;
    label82:
    for (;;)
    {
      return false;
      if ((paramArrayList2 != null) && (paramArrayList1.size() == paramArrayList2.size()) && (paramArrayList1.size() != 0))
      {
        int i = 1;
        j = 0;
        if (j >= paramArrayList1.size()) {
          break;
        }
        entrance_cfg localentrance_cfg = (entrance_cfg)paramArrayList1.get(j);
        if ((i != 0) && (a(paramArrayList2, localentrance_cfg))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label82;
          }
          j += 1;
          break;
        }
      }
    }
    if (j == paramArrayList1.size()) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private static void g(int paramInt, QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("saveHasUserArchieveMemoryFlag:");
      if (paramInt != 0) {
        break label71;
      }
    }
    label71:
    for (String str = "未使用过记忆封存";; str = "已经使用过记忆封存")
    {
      QLog.d("ArchiveMemorySettingGuide", 2, str);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.getAccount();
        if (paramQQAppInterface != null) {
          LocalMultiProcConfig.putInt4Uin("qzone_memory_seal_key", paramInt, Long.valueOf(paramQQAppInterface).longValue());
        }
      }
      return;
    }
  }
  
  private static void g(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.stMapCountInfo != null) && (parammobile_count_rsp_new.stMapCountInfo.containsKey(Integer.valueOf(1009))) && (paramQQAppInterface != null))
    {
      parammobile_count_rsp_new = (count_info)parammobile_count_rsp_new.stMapCountInfo.get(Integer.valueOf(1009));
      if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.stCount != null) && (parammobile_count_rsp_new.stCount.uCount > 0L)) {
        LocalMultiProcConfig.putLong4Uin("need_show_story_tips", 1L, paramQQAppInterface.getLongAccountUin());
      }
    }
    else
    {
      return;
    }
    LocalMultiProcConfig.putLong4Uin("need_show_story_tips", 0L, paramQQAppInterface.getLongAccountUin());
  }
  
  public static void h(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null)
      {
        LocalMultiProcConfig.putInt4Uin("qzone_plus_live_show", paramInt, Long.valueOf(paramQQAppInterface).longValue());
        if (QLog.isColorLevel()) {
          QLog.e("UndealCount.QZoneUnreadServletLogic", 2, "saveFriendPlusLiveStatus:" + paramInt);
        }
      }
    }
  }
  
  private static void h(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    parammobile_count_rsp_new = (byte[])parammobile_count_rsp_new.mapTransData.get("OperEntrance");
    if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "saveMoreEntranceResConfig updateConfig");
      }
      localObject = new OperEntranceInfo();
      awck.b((JceStruct)localObject, parammobile_count_rsp_new);
      localObject = ((OperEntranceInfo)localObject).resTable.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        Qq(((EntranceRes)((Map.Entry)((Iterator)localObject).next()).getValue()).resUrl);
      }
      LocalMultiProcConfig.putString4Uin("key_plus_menu_config", Base64.encodeToString(parammobile_count_rsp_new, 0), paramQQAppInterface.getLongAccountUin());
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putByteArray("data", parammobile_count_rsp_new);
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "PlusMenuDecorates", "updateConfig", paramQQAppInterface, null);
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      return;
    }
    QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "saveMoreEntranceResConfig no Config update");
  }
  
  public static void i(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if (str != null)
      {
        LocalMultiProcConfig.putInt4Uin("qzone_feed_gray_mask", paramInt, Long.valueOf(str).longValue());
        awcr.eDj();
        paramQQAppInterface = (ajdp)paramQQAppInterface.getManager(10);
        if ((paramInt & 0x80) == 0) {
          break label84;
        }
      }
    }
    label84:
    for (boolean bool = true;; bool = false)
    {
      paramQQAppInterface.LP(bool);
      QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "saveGrayOperate: " + paramInt);
      return;
    }
  }
  
  public static void i(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramQQAppInterface = new ands.a();
      paramQQAppInterface.reportId = parammobile_count_rsp_new.strABTestId;
      paramQQAppInterface.dFb = parammobile_count_rsp_new.operate_nbp_type;
      paramQQAppInterface.dFc = parammobile_count_rsp_new.report_sq_switch;
      paramQQAppInterface.report_count = parammobile_count_rsp_new.report_counts;
      paramQQAppInterface.dFd = parammobile_count_rsp_new.report_nexttime;
      paramQQAppInterface.Ao = parammobile_count_rsp_new.vec_blackReportPid;
      paramQQAppInterface.save();
    }
  }
  
  public static void i(String paramString, Map<Integer, String> paramMap)
  {
    paramMap = andt.g(paramMap);
    QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, "setExtendInfo uin:" + paramString + " extend_info:" + paramMap);
    LocalMultiProcConfig.putString("EXTEND_INFO" + paramString, paramMap);
  }
  
  public static void j(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null) {
        LocalMultiProcConfig.putInt4Uin("qzone_call_weishi", paramInt, Long.valueOf(paramQQAppInterface).longValue());
      }
    }
  }
  
  public static void j(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {
      return;
    }
    QbossGateWayRsp localQbossGateWayRsp = new QbossGateWayRsp();
    Object localObject;
    boolean bool;
    if (parammobile_count_rsp_new.mapTransData != null)
    {
      localObject = (byte[])parammobile_count_rsp_new.mapTransData.get("QbossAdv");
      StringBuilder localStringBuilder = new StringBuilder().append("handleSurpriseData:rsp.mapTransData != null,data == null ? ");
      if (localObject == null)
      {
        bool = true;
        QLog.d("UndealCount.QZoneUnreadServletLogic", 4, bool);
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JceInputStream((byte[])localObject);
        ((JceInputStream)localObject).setServerEncoding("utf-8");
        localQbossGateWayRsp.readFrom((JceInputStream)localObject);
        c(parammobile_count_rsp_new, localQbossGateWayRsp, paramQQAppInterface);
        a(parammobile_count_rsp_new, localQbossGateWayRsp, paramQQAppInterface);
        b(parammobile_count_rsp_new, localQbossGateWayRsp, paramQQAppInterface);
        return;
        bool = false;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "handleSurpriseData error:", localThrowable);
        continue;
      }
      QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "handleSurpriseData rsp.mapTransData: null");
    }
  }
  
  public static void j(ArrayList<operat_data> paramArrayList, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "QZoneFeedCountPackeger execCmds");
    }
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        operat_data localoperat_data = (operat_data)paramArrayList.next();
        if (localoperat_data != null)
        {
          if (QLog.isDevelopLevel())
          {
            QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "QZoneFeedCountPackeger operat_data cmd: " + localoperat_data.cmd);
            QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "QZoneFeedCountPackeger operat_data desc: " + localoperat_data.desc);
          }
          awcy.a locala = new awcy.a();
          locala.cmd = localoperat_data.cmd;
          if ((localoperat_data.mapExt != null) && (localoperat_data.mapExt.size() > 0)) {
            locala.data.putAll(localoperat_data.mapExt);
          }
          locala.data.put("key_desc", localoperat_data.desc);
          awcy.a(paramString).a(locala);
        }
      }
    }
  }
  
  private static void k(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.vertVideoDisplay != null) && (parammobile_count_rsp_new.vertVideoDisplay.iType != 0) && (paramQQAppInterface != null))
    {
      LocalMultiProcConfig.putInt4Uin("qzone_vertical_video_display_type", parammobile_count_rsp_new.vertVideoDisplay.iType, paramQQAppInterface.getLongAccountUin());
      LocalMultiProcConfig.putInt4Uin("qzone_vertical_video_display_ratio", parammobile_count_rsp_new.vertVideoDisplay.iFeedAspectRatio, paramQQAppInterface.getLongAccountUin());
      LocalMultiProcConfig.putInt4Uin("qzone_vertical_video_display_width", parammobile_count_rsp_new.vertVideoDisplay.iAspectRatioWidth, paramQQAppInterface.getLongAccountUin());
      LocalMultiProcConfig.putInt4Uin("qzone_vertical_video_display_height", parammobile_count_rsp_new.vertVideoDisplay.iAspectRatioHeight, paramQQAppInterface.getLongAccountUin());
    }
  }
  
  public static void o(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null)
      {
        if (TextUtils.isEmpty(paramString)) {
          break label35;
        }
        LocalMultiProcConfig.putString4Uin("qzone_redpocket_guide_comment_icon_url", paramString, Long.valueOf(paramQQAppInterface).longValue());
      }
    }
    return;
    label35:
    LocalMultiProcConfig.putString4Uin("qzone_redpocket_guide_comment_icon_url", "", Long.valueOf(paramQQAppInterface).longValue());
  }
  
  public static Map<Integer, Long> v(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      return localHashMap;
    }
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    label30:
    String[] arrayOfString;
    if (i < j)
    {
      arrayOfString = paramString[i].split("=");
      if (arrayOfString.length == 2) {
        break label60;
      }
    }
    for (;;)
    {
      i += 1;
      break label30;
      break;
      try
      {
        label60:
        localHashMap.put(Integer.valueOf(URLDecoder.decode(arrayOfString[0], "UTF-8")), Long.valueOf(URLDecoder.decode(arrayOfString[1], "UTF-8")));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("UndealCount.QZoneUnreadServletLogic", 2, localUnsupportedEncodingException.toString());
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.QZoneUnreadServletLogic", 2, localThrowable.toString());
      }
    }
  }
  
  public static class a
  {
    ArrayList<String> Ao;
    int dFb;
    int dFc;
    public int dFd;
    public String reportId;
    public int report_count;
    
    public boolean inBlackList(String paramString)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.Ao != null)
      {
        bool1 = bool2;
        if (this.Ao.size() > 0)
        {
          bool1 = bool2;
          if (this.Ao.contains(paramString)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public boolean load()
    {
      boolean bool = false;
      try
      {
        Object localObject = LocalMultiProcConfig.getString4Uin("qzone_wmd_config", "", BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
        if (QLog.isColorLevel()) {
          QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "load wmd config:" + (String)localObject);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new JSONObject((String)localObject);
          this.reportId = ((JSONObject)localObject).optString("reportId");
          this.dFb = ((JSONObject)localObject).optInt("switch_qzone");
          this.dFc = ((JSONObject)localObject).optInt("switch_qq");
          this.report_count = ((JSONObject)localObject).optInt("report_count");
          this.dFd = ((JSONObject)localObject).optInt("report_time");
          localObject = ((JSONObject)localObject).optJSONArray("blacks");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            this.Ao = new ArrayList();
            int i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              if (!TextUtils.isEmpty(((JSONArray)localObject).optString(i))) {
                this.Ao.add(((JSONArray)localObject).optString(i));
              }
              i += 1;
            }
          }
          bool = true;
        }
        return bool;
      }
      catch (Exception localException) {}
      return false;
    }
    
    public void save()
    {
      JSONArray localJSONArray;
      if (!TextUtils.isEmpty(this.reportId)) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("reportId", this.reportId);
          localJSONObject.put("switch_qzone", this.dFb);
          localJSONObject.put("switch_qq", this.dFc);
          localJSONObject.put("report_count", this.report_count);
          localJSONObject.put("report_time", this.dFd);
          if ((this.Ao != null) && (this.Ao.size() > 0))
          {
            localJSONArray = new JSONArray();
            Iterator localIterator = this.Ao.iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (!TextUtils.isEmpty(str))
              {
                localJSONArray.put(str);
                continue;
                return;
              }
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("UndealCount.QZoneUnreadServletLogic", 1, localException, new Object[0]);
        }
      }
      do
      {
        do
        {
          localException.put("blacks", localJSONArray);
          LocalMultiProcConfig.putString4Uin("qzone_wmd_config", localException.toString(), BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
        } while (!QLog.isColorLevel());
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "save wmd config:" + localException.toString());
        return;
        LocalMultiProcConfig.putString4Uin("qzone_wmd_config", "", BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      } while (!QLog.isColorLevel());
      QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "save wmd config:null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ands
 * JD-Core Version:    0.7.0.1
 */