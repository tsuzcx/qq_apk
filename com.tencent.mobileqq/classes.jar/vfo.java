import NS_KING_INTERFACE.stDelCommentReplyRsp;
import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import NS_KING_INTERFACE.stGetCommentReplyListRsp;
import NS_KING_INTERFACE.stPostCommentDingRsp;
import NS_KING_INTERFACE.stPostFeedDingRsp;
import NS_KING_PUBLIC.stReqHeader;
import NS_KING_PUBLIC.stRspHeader;
import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfClientIpInfo;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.QmfServerInfo;
import QMF_PROTOCAL.RetryInfo;
import UserGrowth.stBlockRecommPersonRsp;
import UserGrowth.stFollowFeedsRsp;
import UserGrowth.stFollowRsp;
import UserGrowth.stFriendFeedRsp;
import UserGrowth.stGetAIOFeedDetailRsp;
import UserGrowth.stGetCollectionRsp;
import UserGrowth.stGetPersonalFeedListRsp;
import UserGrowth.stNotificationRsp;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stPublisherRsp;
import UserGrowth.stQQGetFeedCommentListRsp;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import UserGrowth.stQQGroupDetailRsp;
import UserGrowth.stRedDotRsp;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleGetFeedDetailRsp;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stUserConfigRsp;
import UserGrowth.stWeishiDengtaReportRsp;
import UserGrowth.stWeishiReportReq;
import UserGrowth.stWeishiReportRsp;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.qq.jce.wup.UniAttribute;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;
import cooperation.qzone.WNSStream;
import cooperation.qzone.statistic.serverip.WebAppIpManager;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.WnsError;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class vfo<T1>
  extends QzoneExternalRequest
  implements vfd
{
  public static volatile int a;
  public static String a;
  public static Map<Integer, Map<String, String>> a;
  public long a;
  public JceStruct a;
  protected HashMap<Object, Object> a;
  protected transient vff a;
  public vfj a;
  protected boolean a;
  public int b;
  public long b;
  public String b;
  protected volatile boolean b;
  private int jdField_c_of_type_Int;
  public long c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  public long d;
  private String jdField_d_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  public long e;
  private String e;
  protected long f;
  private String f;
  private long g;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QzoneNewService.";
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_Int = 2;
  }
  
  public vfo(String paramString)
  {
    this("WeishiGZH.", paramString, false);
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public vfo(String paramString, int paramInt)
  {
    this("WeishiGZH.", paramString, false);
    this.jdField_f_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public vfo(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_f_of_type_Long = 30000L;
    this.jdField_b_of_type_Int = 100000;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_JavaLangString = (paramString1 + paramString2);
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.g = System.currentTimeMillis();
  }
  
  private long a(Bundle paramBundle, String paramString)
  {
    if ((paramBundle == null) || (paramString == null)) {}
    while (!paramBundle.containsKey(paramString)) {
      return 0L;
    }
    return paramBundle.getLong(paramString);
  }
  
  private stReqHeader a()
  {
    stReqHeader localstReqHeader = new stReqHeader();
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = ((AppRuntime)localObject1).getAccount();
    Object localObject3 = (TicketManager)((AppRuntime)localObject1).getManager(2);
    if ((localObject3 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())))
    {
      localObject1 = ((TicketManager)localObject3).getSkey(((AppRuntime)localObject1).getAccount());
      Log.e("weishi", "session key:" + (String)localObject1);
    }
    for (;;)
    {
      localstReqHeader.authInfo = uya.a().a((String)localObject2, (String)localObject1);
      localstReqHeader.iChid = 0;
      localstReqHeader.person_id = vfm.jdField_a_of_type_JavaLangString;
      localstReqHeader.platform = "Android";
      localstReqHeader.appversion = DeviceUtils.getVersionCode(BaseApplicationImpl.getContext());
      localstReqHeader.user_ip = DeviceUtils.getLocalIpAddress();
      localstReqHeader.strQua = QUA.getQUA3();
      localstReqHeader.device_info = DeviceUtils.getMachineInfo();
      vmp.b("weishi-810", "device_info:" + localstReqHeader.device_info);
      localstReqHeader.h265key = a();
      localstReqHeader.appid = 1101083114;
      if ("stWeishiReportReq".equals(uniKey()))
      {
        localstReqHeader.mapExt = a();
        if (localstReqHeader.mapExt == null) {
          break label546;
        }
        localstReqHeader.mapExt.put("iAuthType", "2");
        localObject3 = localstReqHeader.mapExt;
        if (localObject2 != null) {
          break label533;
        }
        localObject2 = "";
        label237:
        ((Map)localObject3).put("sUid", localObject2);
        localObject3 = localstReqHeader.mapExt;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        ((Map)localObject3).put("sSessionKey", localObject2);
        localObject2 = vjx.a(BaseApplicationImpl.getContext());
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "000000000000000";
        }
        localstReqHeader.mapExt.put("imei", localObject1);
        vmp.b("weishi-810", "imei:" + (String)localObject1);
        localObject2 = vjx.b(BaseApplicationImpl.getContext());
        localObject3 = localstReqHeader.mapExt;
        if (localObject2 != null) {
          break label536;
        }
        localObject1 = "";
        label353:
        ((Map)localObject3).put("qimei", localObject1);
        vmp.b("weishi-810", "qimei:" + (String)localObject2);
        localObject2 = vjx.c(BaseApplicationImpl.getContext());
        vmp.b("weishi-810", "ssid: " + (String)localObject2);
        localObject3 = localstReqHeader.mapExt;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((Map)localObject3).put("ssid", localObject1);
        localObject2 = a(vjx.a(BaseApplicationImpl.getContext()));
        localObject3 = localstReqHeader.mapExt;
        if (localObject2 != null) {
          break label541;
        }
        localObject1 = "";
        label472:
        ((Map)localObject3).put("ssid_ip", localObject1);
        vmp.b("weishi-810", "ssid_ip: " + (String)localObject2);
      }
      for (;;)
      {
        localstReqHeader.iAppVersion = d();
        return localstReqHeader;
        localstReqHeader.mapExt = new HashMap();
        break;
        label533:
        break label237;
        label536:
        localObject1 = localObject2;
        break label353;
        label541:
        localObject1 = localObject2;
        break label472;
        label546:
        vmp.a("weishi-Request", "header mapExt is null.");
      }
      localObject1 = "test-key";
    }
  }
  
  public static String a()
  {
    String str = "" + Build.MODEL;
    str = str + "&";
    str = str + Build.VERSION.RELEASE;
    str = str + "&";
    str = str + Build.VERSION.SDK_INT;
    str = str + "&";
    return str + c();
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  private Map<String, String> a()
  {
    if ((this.jdField_a_of_type_ComQqTafJceJceStruct instanceof stWeishiReportReq))
    {
      Object localObject = ((stWeishiReportReq)this.jdField_a_of_type_ComQqTafJceJceStruct).report_list;
      if (((ArrayList)localObject).size() > 0)
      {
        stReportItem localstReportItem = (stReportItem)((ArrayList)localObject).get(0);
        Log.i("weishi-Request", "上报取 pageType: " + localstReportItem.pagetype);
        Map localMap = (Map)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(localstReportItem.pagetype));
        if ((localMap != null) && (localMap.size() > 0))
        {
          Iterator localIterator = localMap.entrySet().iterator();
          for (;;)
          {
            localObject = localMap;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (Map.Entry)localIterator.next();
            Log.i("weishi-Request", "取出来" + uniKey() + " --- key: " + (String)((Map.Entry)localObject).getKey() + ", value: " + (String)((Map.Entry)localObject).getValue());
            if (("qq_abtest".equals(((Map.Entry)localObject).getKey())) && (localstReportItem.optype == 121))
            {
              ((Map.Entry)localObject).setValue("");
              Log.w("weishi-Request", "初始化上报，qq_abtest");
              Log.w("weishi-Request", "清空后qq_abtest的值是" + (String)((Map.Entry)localObject).getValue());
            }
          }
        }
        Log.i("weishi-Request", "没有pageType为" + localstReportItem.pagetype + "的extMap");
        localObject = new HashMap();
        return localObject;
      }
    }
    return new HashMap();
  }
  
  private static int c()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Runtime.getRuntime().availableProcessors();
    }
    return DeviceUtils.getNumCores();
  }
  
  private int d()
  {
    String str = DeviceUtils.getVersionName(BaseApplicationImpl.getContext());
    if ((str == null) || (TextUtils.isEmpty(str))) {
      return 0;
    }
    String[] arrayOfString = str.split("\\.");
    str = "";
    int i = 0;
    if (i < arrayOfString.length)
    {
      int j = Integer.parseInt(arrayOfString[i]);
      if (j < 10) {}
      for (str = str + "0" + j;; str = str + j)
      {
        i += 1;
        break;
      }
    }
    return Integer.parseInt(str);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    return this.g;
  }
  
  public final <T1> T1 a(byte[] paramArrayOfByte, String paramString, T1 paramT1)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT1);
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("weishi-Request", paramArrayOfByte.getLocalizedMessage());
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  protected void a(UniAttribute paramUniAttribute, int paramInt1, int paramInt2, String paramString)
  {
    a(paramUniAttribute, paramInt1, paramInt2, paramString, true);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = true;
    Object localObject1 = null;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (paramFromServiceMsg != null)
    {
      Object localObject2 = paramFromServiceMsg.getAttribute("_tag_socket");
      if (localObject2 != null)
      {
        localObject2 = localObject2.toString().split(":");
        if ((localObject2 != null) && (localObject2.length > 1))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("key_request_server_ip", localObject2[0]);
          this.jdField_a_of_type_JavaUtilHashMap.put("key_request_server_port", localObject2[1]);
        }
      }
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject2 = paramFromServiceMsg.getWupBuffer();
        if (localObject2 != null) {
          this.jdField_d_of_type_Long = localObject2.length;
        }
        this.jdField_c_of_type_Long = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
        Log.w("weishi-Server", "old cost=" + this.jdField_c_of_type_Long);
        Log.i("weishi-Server", "cmd=" + c() + ",response size=" + this.jdField_d_of_type_Long + ",request size=" + this.jdField_e_of_type_Long);
        if (localObject2 != null) {
          localObject1 = bhjl.b((byte[])localObject2);
        }
        a((byte[])localObject1, paramFromServiceMsg);
        return;
      }
      localObject1 = paramFromServiceMsg.extraData;
      localObject2 = paramFromServiceMsg.getBusinessFailMsg();
      Log.e("weishi-Request", "errMsg:" + (String)localObject2);
      a("key_report_detail_msg", "errMsg:" + (String)localObject2);
      if ((!this.jdField_b_of_type_Boolean) && (b()) && (localObject1 != null))
      {
        if (a((Bundle)localObject1, "timestamp_msf2net_atMsfSite") <= 0L) {
          break label448;
        }
        bool1 = bool2;
        if (paramFromServiceMsg.getResultCode() != 1002) {
          if (paramFromServiceMsg.getResultCode() != 1013) {
            break label448;
          }
        }
      }
      label448:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jdField_b_of_type_Boolean = bool1;
        Log.i("weishi-Request", "cmd=" + uniKey() + ", appSeq:" + paramFromServiceMsg.getAppSeq() + ", resultcode:" + paramFromServiceMsg.getResultCode() + " need retry send request");
        a(null, paramFromServiceMsg.getResultCode() + 300000, paramFromServiceMsg.getResultCode() + 300000, null);
        return;
      }
    }
    Log.e("weishi-Request", uniKey() + " MSF response is null");
    a(null, 1000000, 1000000, "");
  }
  
  protected void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Log.i("weishi-request", "doSuccessCallback!!");
    if (this.jdField_a_of_type_Vff != null) {
      this.jdField_a_of_type_Vff.a(paramObject, paramInt1, paramInt2, paramString, paramBoolean, null);
    }
  }
  
  protected void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, vfh paramvfh)
  {
    Log.i("weishi-request", "doSuccessCallback!!");
    if (this.jdField_a_of_type_Vff != null) {
      this.jdField_a_of_type_Vff.a(paramObject, paramInt1, paramInt2, paramString, paramBoolean, paramvfh);
    }
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramObject1, paramObject2);
  }
  
  public void a(vff paramvff)
  {
    this.jdField_a_of_type_Vff = paramvff;
  }
  
  public void a(byte[] paramArrayOfByte, FromServiceMsg paramFromServiceMsg)
  {
    if (paramArrayOfByte == null)
    {
      QZLog.e("QZLog", "cmd=" + uniKey() + " QZoneRequest decodeAndCallback() data is null");
      a(null, 1000003, 1000003, "");
      return;
    }
    Object localObject1 = new WNSStream();
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        localObject1 = ((WNSStream)localObject1).unpack(paramArrayOfByte);
        paramArrayOfByte = new vfi();
        if ((localObject1 == null) || (((QmfDownstream)localObject1).WnsCode != 0)) {
          break label1637;
        }
        paramArrayOfByte.setEncodeName("utf-8");
        paramArrayOfByte.decode(((QmfDownstream)localObject1).Extra);
        localObject2 = (QmfServerInfo)paramArrayOfByte.get("server_info");
        if (WebAppIpManager.isValidServerInfo((QmfServerInfo)localObject2))
        {
          WebAppIpManager.getInstance().addWebAppIpRecord((QmfServerInfo)localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put("key_report_busi_serverip", NetworkState.IntAddr2Ip(((QmfServerInfo)localObject2).ipWebapp.ClientIpv4));
        }
        localObject2 = (QmfBusiControl)paramArrayOfByte.get("busiCompCtl");
        if ((localObject2 != null) && (1 == ((QmfBusiControl)localObject2).compFlag))
        {
          localObject2 = WNSStream.decompress(((QmfDownstream)localObject1).BusiBuff);
          if (localObject2 != null) {
            ((QmfDownstream)localObject1).BusiBuff = ((byte[])localObject2);
          }
        }
        else
        {
          localObject2 = (ParameterizedType)getClass().getGenericSuperclass();
          if (localObject2 == null) {
            break label1603;
          }
          paramArrayOfByte = (Class)localObject2.getActualTypeArguments()[0];
          i = this.jdField_d_of_type_Int;
          if (paramArrayOfByte != stSimpleGetFeedListRsp.class) {
            break label612;
          }
          paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stSimpleGetFeedListRsp());
          if (paramArrayOfByte == null) {
            Log.w("weishi-Request", "微视公众号 解包失败!!");
          }
          Log.i("weishi-Request", "pageType scene：" + i);
          localObject1 = (stRspHeader)a(((QmfDownstream)localObject1).BusiBuff, "stRspHeader", new stRspHeader());
          localObject2 = new vfh();
          if ((localObject1 == null) || (((stRspHeader)localObject1).mapExt == null)) {
            break label1579;
          }
          ((vfh)localObject2).jdField_a_of_type_JavaUtilMap = ((stRspHeader)localObject1).mapExt;
          localObject3 = ((stRspHeader)localObject1).mapExt;
          jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), localObject3);
          localObject3 = ((Map)localObject3).entrySet().iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          Log.i("weishi-Request", b() + " 存进去 》》》 key: " + (String)localEntry.getKey() + ", value: " + (String)localEntry.getValue());
          continue;
        }
        QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest decompress error");
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = QZLog.getStackTraceString(paramArrayOfByte);
        if (paramArrayOfByte != null) {
          a("key_report_detail_msg", paramArrayOfByte);
        }
        QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest decodeAndCallback occur exception. stack info:" + paramArrayOfByte);
        a(null, 1000001, 1000001, "");
        return;
      }
      a(paramArrayOfByte, 1000002, 1000002, "");
      return;
      label612:
      if (paramArrayOfByte == stNotificationRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stNotificationRsp());
      }
      else if (paramArrayOfByte == stQQGetFeedCommentListRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stQQGetFeedCommentListRsp());
      }
      else if (paramArrayOfByte == stQQGetFeedCommentListV2Rsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stQQGetFeedCommentListV2Rsp());
      }
      else if (paramArrayOfByte == stPostFeedCommentV2Rsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stPostFeedCommentV2Rsp());
      }
      else if (paramArrayOfByte == stPostCommentReplyV2Rsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stPostCommentReplyV2Rsp());
      }
      else if (paramArrayOfByte == stGetCommentReplyListRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stGetCommentReplyListRsp());
      }
      else if (paramArrayOfByte == stDelCommentReplyRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stDelCommentReplyRsp());
      }
      else if (paramArrayOfByte == stPostCommentDingRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stPostCommentDingRsp());
      }
      else if (paramArrayOfByte == stDeleteFeedCommentRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stDeleteFeedCommentRsp());
      }
      else if (paramArrayOfByte == stPostFeedDingRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stPostFeedDingRsp());
      }
      else if (paramArrayOfByte == stWeishiReportRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stWeishiReportRsp());
      }
      else if (paramArrayOfByte == stFollowFeedsRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stFollowFeedsRsp());
      }
      else if (paramArrayOfByte == stRedDotRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stRedDotRsp());
      }
      else if (paramArrayOfByte == stSimpleGetFeedDetailRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stSimpleGetFeedDetailRsp());
      }
      else if (paramArrayOfByte == stBlockRecommPersonRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stBlockRecommPersonRsp());
      }
      else if (paramArrayOfByte == stFollowRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stFollowRsp());
      }
      else if (paramArrayOfByte == stPublisherRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stPublisherRsp());
      }
      else if (paramArrayOfByte == stWeishiDengtaReportRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stWeishiDengtaReportRsp());
      }
      else if (paramArrayOfByte == stUserConfigRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stUserConfigRsp());
      }
      else if (paramArrayOfByte == stGetCollectionRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stGetCollectionRsp());
      }
      else if (paramArrayOfByte == stFriendFeedRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stFriendFeedRsp());
      }
      else if (paramArrayOfByte == stGetPersonalFeedListRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stGetPersonalFeedListRsp());
      }
      else if (paramArrayOfByte == stQQGroupDetailRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stQQGroupDetailRsp());
      }
      else if (paramArrayOfByte == stGetAIOFeedDetailRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stGetAIOFeedDetailRsp());
      }
      else
      {
        Log.e("weishi-Request", "response无法匹配");
        paramArrayOfByte = null;
      }
    }
    Object localObject3 = (String)((stRspHeader)localObject1).mapExt.get("qq_abtest");
    Log.i("weishi-Request", "stRspHeader: {iRet=" + ((stRspHeader)localObject1).iRet + ", sErrMsg=" + ((stRspHeader)localObject1).sErrmsg + ", scene=" + i + ", abTestId=" + (String)localObject3 + "}");
    if ("SimpleGetFeedList".equals(d())) {
      LocalMultiProcConfig.putString4Uin("key_default_test_id", (String)localObject3, vnd.a());
    }
    ((vfh)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
    vnd.a(i, (String)localObject3);
    localObject3 = (String)((stRspHeader)localObject1).mapExt.get("person_id");
    Log.d("weishi-Request", "stRspHeader: {personId=" + (String)localObject3 + "}");
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      vnd.c((String)localObject3);
    }
    if (((stRspHeader)localObject1).iRet == -99) {
      uya.a().b();
    }
    label1579:
    a(paramArrayOfByte, paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getBusinessFailMsg(), this.jdField_d_of_type_Boolean, (vfh)localObject2);
    return;
    label1603:
    Log.w("weishi-Request", "泛型匹配错误");
    a(paramArrayOfByte, ((QmfDownstream)localObject1).WnsCode, ((QmfDownstream)localObject1).WnsCode, WnsError.getErrorMessage(((QmfDownstream)localObject1).WnsCode));
    return;
    label1637:
    if (localObject1 != null)
    {
      QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest decodeAndCallback wnscode=" + ((QmfDownstream)localObject1).WnsCode + ",msg=" + WnsError.getErrorMessage(((QmfDownstream)localObject1).WnsCode));
      a(paramArrayOfByte, ((QmfDownstream)localObject1).WnsCode, ((QmfDownstream)localObject1).WnsCode, WnsError.getErrorMessage(((QmfDownstream)localObject1).WnsCode));
      return;
    }
    QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest unpack error,result is null");
    a(paramArrayOfByte, 1000003, 1000003, "");
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String b()
  {
    return "st" + this.jdField_f_of_type_JavaLangString + "Rsp";
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public String c()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public byte[] encode()
  {
    Object localObject1 = getDeviceInfo();
    Object localObject2 = QUA.getQUA3();
    long l = getLoginUserId();
    RetryInfo localRetryInfo = (RetryInfo)getRetryInfo();
    localObject1 = new WNSStream(1000027, (String)localObject2, l, new byte[0], (String)localObject1, localRetryInfo);
    localObject2 = getEncodedUniParameter();
    if (localObject2 != null) {
      return bhjl.a(((WNSStream)localObject1).pack(MsfSdkUtils.getNextAppSeq(), getCmdString(), (byte[])localObject2, this.jdField_a_of_type_Boolean));
    }
    return null;
  }
  
  public String getCmdString()
  {
    return this.jdField_d_of_type_JavaLangString + this.jdField_e_of_type_JavaLangString;
  }
  
  public byte[] getEncodedUniParameter()
  {
    stReqHeader localstReqHeader = a();
    if (localstReqHeader != null) {}
    try
    {
      Log.d("weishi-Request", "encode, reqHeader = " + localstReqHeader.toString());
      for (;;)
      {
        this.jdField_a_of_type_Vfj = new vfj();
        this.jdField_a_of_type_Vfj.b(this.jdField_b_of_type_Int);
        this.jdField_b_of_type_Int += 1;
        this.jdField_a_of_type_Vfj.a("king");
        this.jdField_a_of_type_Vfj.b(d());
        this.jdField_a_of_type_Vfj.setEncodeName("UTF-8");
        this.jdField_a_of_type_Vfj.put("stReqHeader", localstReqHeader);
        this.jdField_a_of_type_Vfj.a(9999);
        if ((this.jdField_a_of_type_ComQqTafJceJceStruct != null) && (!TextUtils.isEmpty(c())))
        {
          this.jdField_a_of_type_Vfj.put("st" + d() + "Req", this.jdField_a_of_type_ComQqTafJceJceStruct);
          Log.i("weishi-Request", "req名 :st" + d() + "Req");
        }
        return this.jdField_a_of_type_Vfj.encode();
        Log.d("weishi-Request", "encode, reqHeader = null");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("weishi-Request", "encode get header error, e = " + localException.toString());
      }
    }
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_ComQqTafJceJceStruct;
  }
  
  public Object getRetryInfo()
  {
    if (a()) {}
    for (int i = 1;; i = 0) {
      return new RetryInfo((short)i, (short)a(), a());
    }
  }
  
  public String uniKey()
  {
    return "st" + this.jdField_f_of_type_JavaLangString + "Req";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfo
 * JD-Core Version:    0.7.0.1
 */