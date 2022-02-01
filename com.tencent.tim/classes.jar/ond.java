import NS_KING_SOCIALIZE_META.stMetaTag;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stDevice;
import UserGrowth.stH5OpInfo;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;

public class ond
  implements oko
{
  private static String aqx = "";
  private static WifiManager c;
  private static String imei;
  private static String qimei;
  
  static
  {
    lB();
  }
  
  public static stReportItem a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    stReportItem localstReportItem = getInitialReportItem();
    localstReportItem.upos = (paramInt + 1);
    if (paramstSimpleMetaFeed == null)
    {
      ooz.e("weishi-report", "convertFeedToReport feed == null");
      return localstReportItem;
    }
    localstReportItem.map_pass_back = paramstSimpleMetaFeed.map_pass_back;
    localstReportItem.authorid = paramstSimpleMetaFeed.poster_id;
    localstReportItem.feedid = paramstSimpleMetaFeed.id;
    localstReportItem.title = paramstSimpleMetaFeed.feed_desc;
    if (paramstSimpleMetaFeed.video != null) {
      localstReportItem.video_time = paramstSimpleMetaFeed.video.duration;
    }
    if (paramstSimpleMetaFeed.poster != null)
    {
      localstReportItem.authorid = paramstSimpleMetaFeed.poster.id;
      localstReportItem.authorname = paramstSimpleMetaFeed.poster.nick;
    }
    if ((paramstSimpleMetaFeed.bt_style != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.bt_style.title))) {
      localstReportItem.ext_map = l(paramstSimpleMetaFeed.bt_style.title);
    }
    if (paramstSimpleMetaFeed.video_type == 7) {
      localstReportItem.video_type = 7;
    }
    for (;;)
    {
      localstReportItem.traceId = paramstSimpleMetaFeed.traceId;
      localstReportItem.feed_map_ext = paramstSimpleMetaFeed.map_ext;
      a(localstReportItem, paramstSimpleMetaFeed.waterFallCardStyle);
      localstReportItem.pool_type = paramstSimpleMetaFeed.videoPoolType;
      return localstReportItem;
      if (paramstSimpleMetaFeed.video_type == 6) {
        localstReportItem.video_type = 6;
      } else if ((paramstSimpleMetaFeed.h5_op_info != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.h5_op_info.h5Url))) {
        localstReportItem.video_type = 1;
      } else if (paramstSimpleMetaFeed.video_type == 0) {
        localstReportItem.video_type = 0;
      } else {
        localstReportItem.video_type = paramstSimpleMetaFeed.video_type;
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, stReportItem paramstReportItem)
  {
    stReportItem localstReportItem = paramstReportItem;
    if (paramstReportItem == null) {
      localstReportItem = getInitialReportItem();
    }
    localstReportItem.pagetype = paramInt2;
    localstReportItem.optype = paramInt1;
    localstReportItem.comment_loctaion = paramInt3;
    a(localstReportItem);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString)
  {
    paramstSimpleMetaFeed = a(paramstSimpleMetaFeed, paramInt3);
    paramstSimpleMetaFeed.optype = paramInt2;
    paramstSimpleMetaFeed.pagetype = paramInt1;
    if (!TextUtils.isEmpty(paramString)) {
      paramstSimpleMetaFeed.downloadscene = paramString;
    }
    a(paramInt2, paramstSimpleMetaFeed);
  }
  
  public static void a(int paramInt1, int paramInt2, stReportItem paramstReportItem)
  {
    stReportItem localstReportItem = paramstReportItem;
    if (paramstReportItem == null) {
      localstReportItem = getInitialReportItem();
    }
    localstReportItem.pagetype = paramInt2;
    localstReportItem.optype = paramInt1;
    a(localstReportItem);
  }
  
  public static void a(int paramInt, stReportItem paramstReportItem)
  {
    paramstReportItem.optype = paramInt;
    a(paramstReportItem);
  }
  
  public static void a(int paramInt1, Map<Integer, byte[]> paramMap, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6, int paramInt4)
  {
    stReportItem localstReportItem = getInitialReportItem();
    if (paramInt1 == 1) {}
    for (localstReportItem.pagetype = 9;; localstReportItem.pagetype = 14)
    {
      localstReportItem.optype = 112;
      localstReportItem.video_type = 1;
      localstReportItem.map_pass_back = paramMap;
      localstReportItem.feedid = paramString1;
      localstReportItem.video_time = paramInt2;
      localstReportItem.authorid = paramString2;
      localstReportItem.authorname = paramString3;
      localstReportItem.title = paramString4;
      localstReportItem.upos = (paramInt3 + 1);
      localstReportItem.tag = paramString5;
      localstReportItem.cid = paramInt4;
      localstReportItem.ext_map = l(paramString6);
      a(localstReportItem);
      return;
    }
  }
  
  public static void a(stReportItem paramstReportItem)
  {
    if (paramstReportItem == null)
    {
      ooz.e("weishi-report", "report error item = null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramstReportItem);
    ce(localArrayList);
  }
  
  private static void a(stReportItem paramstReportItem, stWaterFallCardStyle paramstWaterFallCardStyle)
  {
    if (paramstWaterFallCardStyle != null)
    {
      paramstReportItem.card_type = paramstWaterFallCardStyle.cardType;
      paramstReportItem.ratioW = paramstWaterFallCardStyle.ratioW;
      paramstReportItem.ratioH = paramstWaterFallCardStyle.ratioH;
      paramstReportItem.isFullSpan = paramstWaterFallCardStyle.isFullSpan;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    stReportItem localstReportItem = getInitialReportItem();
    localstReportItem.video_type = 6;
    localstReportItem.feedid = paramString1;
    localstReportItem.optype = paramInt2;
    localstReportItem.pagetype = paramInt3;
    localstReportItem.play_time = paramInt4;
    localstReportItem.authorid = paramString2;
    localstReportItem.authorname = paramString3;
    localstReportItem.title = paramString4;
    localstReportItem.upos = (paramInt1 + 1);
    a(localstReportItem);
  }
  
  public static int aa(Context paramContext)
  {
    if (c == null) {
      c = (WifiManager)paramContext.getSystemService("wifi");
    }
    paramContext = alkz.a(c);
    ooz.d("wifiInfo", paramContext.toString());
    ooz.d("SSID", "" + paramContext.getIpAddress());
    return paramContext.getIpAddress();
  }
  
  public static String aj(Context paramContext)
  {
    if (TextUtils.isEmpty(qimei)) {}
    try
    {
      ooz.d("weishi-810", "try get QIMei from UserAction.getQIMEI!");
      qimei = UserAction.getQIMEI();
      if (qimei == null)
      {
        ooz.e("weishi-810", "getImei finally encounter error and return empty");
        qimei = "";
      }
      return qimei;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        ooz.e("weishi-810", "UserAction.getQIMEI encounter error:" + paramContext);
      }
    }
  }
  
  public static String ak(Context paramContext)
  {
    if (c == null) {
      c = (WifiManager)paramContext.getSystemService("wifi");
    }
    paramContext = alkz.a(c);
    ooz.d("wifiInfo", paramContext.toString());
    return paramContext.getSSID().replace("\"", "");
  }
  
  public static void b(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2)
  {
    stReportItem localstReportItem = getInitialReportItem();
    localstReportItem.video_type = 0;
    localstReportItem.pagetype = 1;
    localstReportItem.optype = paramInt2;
    localstReportItem.upos = (paramInt1 + 1);
    localstReportItem.tag = "";
    if (paramstSimpleMetaFeed != null)
    {
      localstReportItem.map_pass_back = paramstSimpleMetaFeed.map_pass_back;
      localstReportItem.feedid = paramstSimpleMetaFeed.id;
      localstReportItem.authorid = paramstSimpleMetaFeed.poster_id;
      if (paramstSimpleMetaFeed.poster == null) {
        break label133;
      }
      str = paramstSimpleMetaFeed.poster.nick;
      localstReportItem.authorname = str;
      localstReportItem.title = paramstSimpleMetaFeed.feed_desc;
      if (paramstSimpleMetaFeed.bt_style != null) {
        break label139;
      }
    }
    label133:
    label139:
    for (String str = "";; str = paramstSimpleMetaFeed.bt_style.title)
    {
      localstReportItem.ext_map = l(str);
      a(localstReportItem, paramstSimpleMetaFeed.waterFallCardStyle);
      a(localstReportItem);
      return;
      str = "";
      break;
    }
  }
  
  public static void b(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    IWSPushBaseStrategy localIWSPushBaseStrategy;
    stReportItem localstReportItem;
    if (paramWSRedDotPushMsg != null)
    {
      localIWSPushBaseStrategy = paramWSRedDotPushMsg.mStrategyInfo;
      localstReportItem = getInitialReportItem();
      localstReportItem.pagetype = 15;
      localstReportItem.optype = 112;
      localstReportItem.pushid = paramWSRedDotPushMsg.mPushId;
      if (localIWSPushBaseStrategy == null) {
        break label54;
      }
    }
    label54:
    for (int i = localIWSPushBaseStrategy.getType();; i = 0)
    {
      localstReportItem.policy_type = i;
      a(localstReportItem);
      return;
    }
  }
  
  public static void bfP()
  {
    stReportItem localstReportItem = getInitialReportItem();
    localstReportItem.pagetype = 1;
    localstReportItem.optype = 121;
    a(localstReportItem);
  }
  
  public static void ce(ArrayList<stReportItem> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      ooz.e("weishi-report", "report error items: " + paramArrayList);
      return;
    }
    String str = t(((stReportItem)paramArrayList.get(0)).optype, ((stReportItem)paramArrayList.get(0)).pagetype);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      stReportItem localstReportItem = (stReportItem)localIterator.next();
      ooz.d("weishi-report", "report " + str + " stReportItem:" + localstReportItem.toString());
    }
    paramArrayList = new okz(new oob(paramArrayList), null, new one(str), 2001);
    oks.a().b(paramArrayList);
  }
  
  public static String getImei(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (TextUtils.isEmpty(imei)) {}
    try
    {
      imei = auri.getIMEI("1d76c6");
      return imei;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        ooz.e("weishi-810", "telephonyManager.getDeviceId encounter error:" + paramContext);
      }
    }
  }
  
  public static stReportItem getInitialReportItem()
  {
    long l = 0L;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    stReportItem localstReportItem = new stReportItem();
    localstReportItem.imp_date = ((int)(System.currentTimeMillis() / 1000L));
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localstReportItem.uin = l;
      localstReportItem.network_type = DeviceUtils.getNetworkTypeName(BaseApplicationImpl.getContext()).toLowerCase();
      localstReportItem.os = ("android" + DeviceUtils.getOSVersion() + " - " + DeviceUtils.getMachineInfo());
      localstReportItem.city = lB();
      localstReportItem.ip = DeviceUtils.getLocalIpAddress();
      localstReportItem.qua = avpq.getQUA3();
      localstReportItem.vendor = aqgz.BY();
      localObject = new stDevice();
      ((stDevice)localObject).encrypted_deviceid = ohy.a().ls();
      ((stDevice)localObject).imei = getImei(BaseApplicationImpl.getContext());
      ((stDevice)localObject).qimei = aj(BaseApplicationImpl.getContext());
      localstReportItem.device = ((stDevice)localObject);
      if (!rpw.isWeishiInstalled(BaseApplicationImpl.getContext())) {
        break label202;
      }
    }
    label202:
    for (int i = 2;; i = 1)
    {
      localstReportItem.exist_weishi = i;
      return localstReportItem;
      l = rpe.f((String)localObject, 0L);
      break;
    }
  }
  
  private static Map<String, String> l(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qq_bt_text", paramString);
    return localHashMap;
  }
  
  private static String lB()
  {
    if (TextUtils.isEmpty(aqx)) {
      aqx = aczc.getCity();
    }
    return aqx;
  }
  
  public static void reportBlockPage(int paramInt1, int paramInt2, int paramInt3)
  {
    stReportItem localstReportItem = getInitialReportItem();
    localstReportItem.pagetype = paramInt3;
    localstReportItem.optype = paramInt1;
    localstReportItem.cid = paramInt2;
    localstReportItem.video_type = 4;
    a(localstReportItem);
  }
  
  public static void reportRichBlockDialog(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    stReportItem localstReportItem = getInitialReportItem();
    localstReportItem.pagetype = paramInt2;
    localstReportItem.optype = paramInt1;
    localstReportItem.windowsid = paramInt4;
    localstReportItem.video_type = paramInt3;
    a(localstReportItem);
  }
  
  private static String t(int paramInt1, int paramInt2)
  {
    return "";
  }
  
  public void a(okz paramokz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ond
 * JD-Core Version:    0.7.0.1
 */