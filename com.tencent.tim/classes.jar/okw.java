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
import UserGrowth.stGetCollectionRsp;
import UserGrowth.stNotificationRsp;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stPublisherRsp;
import UserGrowth.stQQGetFeedCommentListRsp;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import UserGrowth.stRedDotRsp;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleGetFeedDetailRsp;
import UserGrowth.stSimpleGetFeedListReq;
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
import cooperation.qzone.QzoneExternalRequest;
import cooperation.qzone.WNSStream;
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

public class okw<T1>
  extends QzoneExternalRequest
  implements okl
{
  public static String DEFAULT_COMMAND_PREFIX = "QzoneNewService.";
  public static volatile int H265_REPORT_KEY_VERSION = 2;
  public static Map<Integer, Map<String, String>> fp = new HashMap();
  protected transient okn a;
  public okr a;
  private String aqh;
  private boolean canRequestRetry;
  private String cmd;
  public long endTime;
  protected volatile boolean isRetry;
  private String mCmd;
  private String mCommandPrefix = DEFAULT_COMMAND_PREFIX;
  public String mRequestId;
  protected boolean needCompress;
  private boolean needRetry;
  protected HashMap<Object, Object> params = new HashMap();
  private long pkgId;
  public JceStruct req;
  public long reqSize;
  public int requestId = 100000;
  private int requestRetryCount;
  public long respSize;
  public long startTime;
  
  public okw(String paramString)
  {
    this("WeishiGZH.", paramString, false);
    this.cmd = paramString;
  }
  
  public okw(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.aqh = paramString2;
    this.mCmd = (paramString1 + paramString2);
    this.canRequestRetry = paramBoolean;
    this.pkgId = System.currentTimeMillis();
  }
  
  private Map<String, String> M()
  {
    if ((this.req instanceof stWeishiReportReq))
    {
      Object localObject = ((stWeishiReportReq)this.req).report_list;
      if (((ArrayList)localObject).size() > 0)
      {
        stReportItem localstReportItem = (stReportItem)((ArrayList)localObject).get(0);
        Log.i("weishi-Request", "上报取 pageType: " + localstReportItem.pagetype);
        Map localMap = (Map)fp.get(Integer.valueOf(localstReportItem.pagetype));
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
      localstReqHeader.authInfo = oft.a().a((String)localObject2, (String)localObject1);
      localstReqHeader.iChid = 0;
      localstReqHeader.person_id = oku.person_id;
      localstReqHeader.platform = "Android";
      localstReqHeader.appversion = DeviceUtils.getVersionCode(BaseApplicationImpl.getContext());
      localstReqHeader.user_ip = DeviceUtils.getLocalIpAddress();
      localstReqHeader.strQua = avpq.getQUA3();
      localstReqHeader.device_info = DeviceUtils.getMachineInfo();
      ooz.d("weishi-810", "device_info:" + localstReqHeader.device_info);
      localstReqHeader.h265key = getMobileDetailInfo();
      localstReqHeader.appid = 1101083114;
      if ("stWeishiReportReq".equals(uniKey()))
      {
        localstReqHeader.mapExt = M();
        if (localstReqHeader.mapExt == null) {
          break label559;
        }
        localstReqHeader.mapExt.put("iAuthType", "2");
        localObject3 = localstReqHeader.mapExt;
        if (localObject2 != null) {
          break label546;
        }
        localObject2 = "";
        label244:
        ((Map)localObject3).put("sUid", localObject2);
        localObject3 = localstReqHeader.mapExt;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        ((Map)localObject3).put("sSessionKey", localObject2);
        localObject2 = ond.getImei(BaseApplicationImpl.getContext());
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "000000000000000";
        }
        localstReqHeader.mapExt.put("imei", localObject1);
        ooz.d("weishi-810", "imei:" + (String)localObject1);
        localObject2 = ond.aj(BaseApplicationImpl.getContext());
        localObject3 = localstReqHeader.mapExt;
        if (localObject2 != null) {
          break label549;
        }
        localObject1 = "";
        label363:
        ((Map)localObject3).put("qimei", localObject1);
        ooz.d("weishi-810", "qimei:" + (String)localObject2);
        localObject2 = ond.ak(BaseApplicationImpl.getContext());
        ooz.d("weishi-810", "ssid: " + (String)localObject2);
        localObject3 = localstReqHeader.mapExt;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((Map)localObject3).put("ssid", localObject1);
        localObject2 = intToIp(ond.aa(BaseApplicationImpl.getContext()));
        localObject3 = localstReqHeader.mapExt;
        if (localObject2 != null) {
          break label554;
        }
        localObject1 = "";
        label484:
        ((Map)localObject3).put("ssid_ip", localObject1);
        ooz.d("weishi-810", "ssid_ip: " + (String)localObject2);
      }
      for (;;)
      {
        localstReqHeader.iAppVersion = rA();
        return localstReqHeader;
        localstReqHeader.mapExt = new HashMap();
        break;
        label546:
        break label244;
        label549:
        localObject1 = localObject2;
        break label363;
        label554:
        localObject1 = localObject2;
        break label484;
        label559:
        ooz.i("weishi-Request", "header mapExt is null.");
      }
      localObject1 = "test-key";
    }
  }
  
  public static String getMobileDetailInfo()
  {
    String str = "" + Build.MODEL;
    str = str + "&";
    str = str + Build.VERSION.RELEASE;
    str = str + "&";
    str = str + Build.VERSION.SDK_INT;
    str = str + "&";
    return str + getNumberOfCores();
  }
  
  private static int getNumberOfCores()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Runtime.getRuntime().availableProcessors();
    }
    return DeviceUtils.getNumCores();
  }
  
  private long getTimestamp(Bundle paramBundle, String paramString)
  {
    if ((paramBundle == null) || (paramString == null)) {}
    while (!paramBundle.containsKey(paramString)) {
      return 0L;
    }
    return paramBundle.getLong(paramString);
  }
  
  public static String intToIp(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  private int rA()
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
  
  protected void a(UniAttribute paramUniAttribute, int paramInt1, int paramInt2, String paramString)
  {
    a(paramUniAttribute, paramInt1, paramInt2, paramString, true);
  }
  
  protected void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Log.i("weishi-request", "doSuccessCallback!!");
    if (this.jdField_a_of_type_Okn != null) {
      this.jdField_a_of_type_Okn.a(paramObject, paramInt1, paramInt2, paramString, paramBoolean, null);
    }
  }
  
  public void a(okn paramokn)
  {
    this.jdField_a_of_type_Okn = paramokn;
  }
  
  public void addParameter(Object paramObject1, Object paramObject2)
  {
    this.params.put(paramObject1, paramObject2);
  }
  
  protected void b(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, okp paramokp)
  {
    Log.i("weishi-request", "doSuccessCallback!!");
    if (this.jdField_a_of_type_Okn != null) {
      this.jdField_a_of_type_Okn.a(paramObject, paramInt1, paramInt2, paramString, paramBoolean, paramokp);
    }
  }
  
  public boolean canRequestRetry()
  {
    return this.canRequestRetry;
  }
  
  public void decodeAndCallback(byte[] paramArrayOfByte, FromServiceMsg paramFromServiceMsg)
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
        paramArrayOfByte = new okq();
        if ((localObject1 == null) || (((QmfDownstream)localObject1).WnsCode != 0)) {
          break label1561;
        }
        paramArrayOfByte.setEncodeName("utf-8");
        paramArrayOfByte.decode(((QmfDownstream)localObject1).Extra);
        localObject2 = (QmfServerInfo)paramArrayOfByte.get("server_info");
        if (awbn.a((QmfServerInfo)localObject2))
        {
          awbn.a().a((QmfServerInfo)localObject2);
          this.params.put("key_report_busi_serverip", NetworkState.IntAddr2Ip(((QmfServerInfo)localObject2).ipWebapp.ClientIpv4));
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
            break label1528;
          }
          paramArrayOfByte = (Class)localObject2.getActualTypeArguments()[0];
          if (paramArrayOfByte != stSimpleGetFeedListRsp.class) {
            break label614;
          }
          paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stSimpleGetFeedListRsp());
          i = ((stSimpleGetFeedListReq)this.req).scene;
          if (paramArrayOfByte == null) {
            Log.w("weishi-Request", "微视公众号 解包失败!!");
          }
          Log.i("weishi-Request", "pageType scene：" + i);
          localObject1 = (stRspHeader)decodePacket(((QmfDownstream)localObject1).BusiBuff, "stRspHeader", new stRspHeader());
          localObject2 = new okp();
          if ((localObject1 == null) || (((stRspHeader)localObject1).mapExt == null)) {
            break label1504;
          }
          ((okp)localObject2).mapExt = ((stRspHeader)localObject1).mapExt;
          localObject3 = ((stRspHeader)localObject1).mapExt;
          fp.put(Integer.valueOf(i), localObject3);
          localObject3 = ((Map)localObject3).entrySet().iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          Log.i("weishi-Request", lx() + " 存进去 》》》 key: " + (String)localEntry.getKey() + ", value: " + (String)localEntry.getValue());
          continue;
        }
        QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest decompress error");
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = QZLog.getStackTraceString(paramArrayOfByte);
        if (paramArrayOfByte != null) {
          addParameter("key_report_detail_msg", paramArrayOfByte);
        }
        QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest decodeAndCallback occur exception. stack info:" + paramArrayOfByte);
        a(null, 1000001, 1000001, "");
        return;
      }
      a(paramArrayOfByte, 1000002, 1000002, "");
      return;
      label614:
      if (paramArrayOfByte == stNotificationRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stNotificationRsp());
        i = 4;
      }
      else if (paramArrayOfByte == stQQGetFeedCommentListRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stQQGetFeedCommentListRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stQQGetFeedCommentListV2Rsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stQQGetFeedCommentListV2Rsp());
        i = 0;
      }
      else if (paramArrayOfByte == stPostFeedCommentV2Rsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stPostFeedCommentV2Rsp());
        i = 0;
      }
      else if (paramArrayOfByte == stPostCommentReplyV2Rsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stPostCommentReplyV2Rsp());
        i = 0;
      }
      else if (paramArrayOfByte == stGetCommentReplyListRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stGetCommentReplyListRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stDelCommentReplyRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stDelCommentReplyRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stPostCommentDingRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stPostCommentDingRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stDeleteFeedCommentRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stDeleteFeedCommentRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stPostFeedDingRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stPostFeedDingRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stWeishiReportRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stWeishiReportRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stFollowFeedsRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stFollowFeedsRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stRedDotRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stRedDotRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stSimpleGetFeedDetailRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stSimpleGetFeedDetailRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stBlockRecommPersonRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stBlockRecommPersonRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stFollowRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stFollowRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stPublisherRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stPublisherRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stWeishiDengtaReportRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stWeishiDengtaReportRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stUserConfigRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stUserConfigRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stGetCollectionRsp.class)
      {
        paramArrayOfByte = decodePacket(((QmfDownstream)localObject1).BusiBuff, lx(), new stGetCollectionRsp());
        i = 0;
      }
      else
      {
        Log.e("weishi-Request", "response无法匹配");
        paramArrayOfByte = null;
        i = 0;
      }
    }
    Object localObject3 = (String)((stRspHeader)localObject1).mapExt.get("qq_abtest");
    Log.i("weishi-Request", "stRspHeader: {iRet=" + ((stRspHeader)localObject1).iRet + ", sErrMsg=" + ((stRspHeader)localObject1).sErrmsg + ", abTestId=" + (String)localObject3 + "}");
    ((okp)localObject2).testId = ((String)localObject3);
    Log.d("weishi-Request", "stRspHeader: {scene=" + i + ", abTestId=" + (String)localObject3 + "}");
    opn.aH(i, (String)localObject3);
    localObject3 = (String)((stRspHeader)localObject1).mapExt.get("person_id");
    Log.d("weishi-Request", "stRspHeader: {personId=" + (String)localObject3 + "}");
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      opn.setPersonId((String)localObject3);
    }
    if (((stRspHeader)localObject1).iRet == -99) {
      oft.a().beo();
    }
    label1504:
    b(paramArrayOfByte, paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getBusinessFailMsg(), this.needRetry, (okp)localObject2);
    return;
    label1528:
    Log.w("weishi-Request", "泛型匹配错误");
    a(paramArrayOfByte, ((QmfDownstream)localObject1).WnsCode, ((QmfDownstream)localObject1).WnsCode, WnsError.getErrorMessage(((QmfDownstream)localObject1).WnsCode));
    return;
    label1561:
    if (localObject1 != null)
    {
      QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest decodeAndCallback wnscode=" + ((QmfDownstream)localObject1).WnsCode + ",msg=" + WnsError.getErrorMessage(((QmfDownstream)localObject1).WnsCode));
      a(paramArrayOfByte, ((QmfDownstream)localObject1).WnsCode, ((QmfDownstream)localObject1).WnsCode, WnsError.getErrorMessage(((QmfDownstream)localObject1).WnsCode));
      return;
    }
    QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest unpack error,result is null");
    a(paramArrayOfByte, 1000003, 1000003, "");
  }
  
  public final <T1> T1 decodePacket(byte[] paramArrayOfByte, String paramString, T1 paramT1)
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
  
  public byte[] encode()
  {
    Object localObject1 = getDeviceInfo();
    Object localObject2 = avpq.getQUA3();
    long l = getLoginUserId();
    RetryInfo localRetryInfo = (RetryInfo)getRetryInfo();
    localObject1 = new WNSStream(1000027, (String)localObject2, l, new byte[0], (String)localObject1, localRetryInfo);
    localObject2 = getEncodedUniParameter();
    if (localObject2 != null) {
      return aqnv.I(((WNSStream)localObject1).pack(MsfSdkUtils.getNextAppSeq(), getCmdString(), (byte[])localObject2, this.needCompress));
    }
    return null;
  }
  
  public String getCmdString()
  {
    return this.mCommandPrefix + this.mCmd;
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
        this.jdField_a_of_type_Okr = new okr();
        this.jdField_a_of_type_Okr.setRequestId(this.requestId);
        this.requestId += 1;
        this.jdField_a_of_type_Okr.setServantName("king");
        this.jdField_a_of_type_Okr.setFuncName(ly());
        this.jdField_a_of_type_Okr.setEncodeName("UTF-8");
        this.jdField_a_of_type_Okr.put("stReqHeader", localstReqHeader);
        this.jdField_a_of_type_Okr.uK(9999);
        if ((this.req != null) && (!TextUtils.isEmpty(getRequestCmd())))
        {
          this.jdField_a_of_type_Okr.put("st" + ly() + "Req", this.req);
          Log.i("weishi-Request", "req名 :st" + ly() + "Req");
        }
        return this.jdField_a_of_type_Okr.encode();
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
    return this.req;
  }
  
  public String getRequestCmd()
  {
    return this.mCmd;
  }
  
  public long getRequestPkgId()
  {
    return this.pkgId;
  }
  
  public int getRequestRetryCount()
  {
    return this.requestRetryCount;
  }
  
  public Object getRetryInfo()
  {
    if (canRequestRetry()) {}
    for (int i = 1;; i = 0) {
      return new RetryInfo((short)i, (short)getRequestRetryCount(), getRequestPkgId());
    }
  }
  
  public String lx()
  {
    return "st" + this.cmd + "Rsp";
  }
  
  public String ly()
  {
    return this.aqh;
  }
  
  protected boolean needClientRetry()
  {
    return false;
  }
  
  public void onDataResponse(FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = true;
    Object localObject1 = null;
    this.endTime = System.currentTimeMillis();
    if (paramFromServiceMsg != null)
    {
      Object localObject2 = paramFromServiceMsg.getAttribute("_tag_socket");
      if (localObject2 != null)
      {
        localObject2 = localObject2.toString().split(":");
        if ((localObject2 != null) && (localObject2.length > 1))
        {
          this.params.put("key_request_server_ip", localObject2[0]);
          this.params.put("key_request_server_port", localObject2[1]);
        }
      }
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject2 = paramFromServiceMsg.getWupBuffer();
        if (localObject2 != null) {
          this.respSize = localObject2.length;
        }
        Log.w("weishi-Server", "old cost=" + (this.endTime - this.startTime));
        Log.i("weishi-Server", "cmd=" + getRequestCmd() + ",response size=" + this.respSize + ",request size=" + this.reqSize);
        if (localObject2 != null) {
          localObject1 = aqnv.J((byte[])localObject2);
        }
        decodeAndCallback((byte[])localObject1, paramFromServiceMsg);
        return;
      }
      localObject1 = paramFromServiceMsg.extraData;
      localObject2 = paramFromServiceMsg.getBusinessFailMsg();
      Log.e("weishi-Request", "errMsg:" + (String)localObject2);
      addParameter("key_report_detail_msg", "errMsg:" + (String)localObject2);
      if ((!this.isRetry) && (needClientRetry()) && (localObject1 != null))
      {
        if (getTimestamp((Bundle)localObject1, "timestamp_msf2net_atMsfSite") <= 0L) {
          break label438;
        }
        bool1 = bool2;
        if (paramFromServiceMsg.getResultCode() != 1002) {
          if (paramFromServiceMsg.getResultCode() != 1013) {
            break label438;
          }
        }
      }
      label438:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.isRetry = bool1;
        Log.i("weishi-Request", "cmd=" + uniKey() + ", appSeq:" + paramFromServiceMsg.getAppSeq() + ", resultcode:" + paramFromServiceMsg.getResultCode() + " need retry send request");
        a(null, paramFromServiceMsg.getResultCode() + 300000, paramFromServiceMsg.getResultCode() + 300000, null);
        return;
      }
    }
    Log.e("weishi-Request", uniKey() + " MSF response is null");
    a(null, 1000000, 1000000, "");
  }
  
  public void setRequestRetryCount(int paramInt)
  {
    this.requestRetryCount = paramInt;
  }
  
  public String uniKey()
  {
    return "st" + this.cmd + "Req";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okw
 * JD-Core Version:    0.7.0.1
 */