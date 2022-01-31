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

public class tjr
  implements tgt
{
  private static WifiManager jdField_a_of_type_AndroidNetWifiWifiManager;
  private static String jdField_a_of_type_JavaLangString;
  private static String b;
  private static String c = "";
  
  static
  {
    a();
  }
  
  public static int a(Context paramContext)
  {
    if (jdField_a_of_type_AndroidNetWifiWifiManager == null) {
      jdField_a_of_type_AndroidNetWifiWifiManager = (WifiManager)paramContext.getSystemService("wifi");
    }
    paramContext = jdField_a_of_type_AndroidNetWifiWifiManager.getConnectionInfo();
    tlo.b("wifiInfo", paramContext.toString());
    tlo.b("SSID", "" + paramContext.getIpAddress());
    return paramContext.getIpAddress();
  }
  
  public static stReportItem a()
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
      localstReportItem.city = a();
      localstReportItem.ip = DeviceUtils.getLocalIpAddress();
      localstReportItem.qua = bjdm.a();
      localstReportItem.vendor = bdgk.h();
      localObject = new stDevice();
      ((stDevice)localObject).encrypted_deviceid = tee.a().e();
      ((stDevice)localObject).imei = a(BaseApplicationImpl.getContext());
      ((stDevice)localObject).qimei = b(BaseApplicationImpl.getContext());
      localstReportItem.device = ((stDevice)localObject);
      if (!xsx.a(BaseApplicationImpl.getContext())) {
        break label200;
      }
    }
    label200:
    for (int i = 2;; i = 1)
    {
      localstReportItem.exist_weishi = i;
      return localstReportItem;
      l = xrp.a((String)localObject, 0L);
      break;
    }
  }
  
  public static stReportItem a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    stReportItem localstReportItem = a();
    localstReportItem.upos = (paramInt + 1);
    if (paramstSimpleMetaFeed == null)
    {
      tlo.d("weishi-report", "convertFeedToReport feed == null");
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
      localstReportItem.ext_map = a(paramstSimpleMetaFeed.bt_style.title);
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
  
  private static String a()
  {
    if (TextUtils.isEmpty(c)) {
      c = ampk.a();
    }
    if ((c.endsWith(alud.a(2131716368))) && (c.length() > 1)) {
      c = c.substring(0, c.length() - 1);
    }
    return c;
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    String str = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
        return str;
        str = alud.a(2131716364);
        continue;
        str = alud.a(2131716341);
        continue;
        str = alud.a(2131716351);
        continue;
        str = alud.a(2131716358);
        continue;
        str = alud.a(2131716348);
        continue;
        str = alud.a(2131716352);
        continue;
        str = alud.a(2131716367);
        continue;
        str = alud.a(2131716335);
        continue;
        str = alud.a(2131716338);
        continue;
        str = alud.a(2131716343);
        continue;
        str = alud.a(2131716365);
        continue;
        str = alud.a(2131716360);
        continue;
        str = alud.a(2131716354);
        switch (paramInt2)
        {
        default: 
          break;
        case 12: 
          str = alud.a(2131716330);
          continue;
          str = alud.a(2131716362);
          continue;
          str = alud.a(2131716369);
          continue;
          str = alud.a(2131716342);
          continue;
          str = alud.a(2131716363);
          continue;
          str = alud.a(2131716337);
          continue;
          str = alud.a(2131716333);
          continue;
          str = alud.a(2131716353);
          continue;
          str = alud.a(2131716331);
          continue;
          str = alud.a(2131716357);
          switch (paramInt2)
          {
          default: 
            break;
          case 12: 
            str = alud.a(2131716345);
            continue;
            str = alud.a(2131716339);
            switch (paramInt2)
            {
            default: 
              break;
            case 12: 
              str = alud.a(2131716347);
              continue;
              str = alud.a(2131716334);
              continue;
              str = alud.a(2131716344);
              continue;
              str = alud.a(2131716349);
              switch (paramInt2)
              {
              default: 
                break;
              case 2: 
                str = alud.a(2131716366);
                break;
              case 6: 
                str = alud.a(2131716355);
                continue;
                str = alud.a(2131716356);
                switch (paramInt2)
                {
                default: 
                  break;
                case 2: 
                  str = alud.a(2131716359);
                  break;
                case 14: 
                  str = alud.a(2131716336);
                  break;
                case 12: 
                  str = alud.a(2131716332);
                  break;
                case 6: 
                  str = alud.a(2131716340);
                  continue;
                  str = alud.a(2131716346);
                  switch (paramInt2)
                  {
                  case 10: 
                  case 11: 
                  default: 
                    break;
                  case 9: 
                    str = "进入H5";
                    break;
                  case 12: 
                    str = alud.a(2131716361);
                  }
                  break;
                }
                break;
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    }
    return alud.a(2131716350);
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    try
    {
      jdField_a_of_type_JavaLangString = bhsp.a("1d76c6");
      return jdField_a_of_type_JavaLangString;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        tlo.d("weishi-810", "telephonyManager.getDeviceId encounter error:" + paramContext);
      }
    }
  }
  
  private static Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qq_bt_text", paramString);
    return localHashMap;
  }
  
  public static void a()
  {
    stReportItem localstReportItem = a();
    localstReportItem.pagetype = 1;
    localstReportItem.optype = 121;
    a(localstReportItem);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    stReportItem localstReportItem = a();
    localstReportItem.pagetype = paramInt3;
    localstReportItem.optype = paramInt1;
    localstReportItem.cid = paramInt2;
    localstReportItem.video_type = 4;
    a(localstReportItem);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    stReportItem localstReportItem = a();
    localstReportItem.pagetype = paramInt2;
    localstReportItem.optype = paramInt1;
    localstReportItem.windowsid = paramInt4;
    localstReportItem.video_type = paramInt3;
    a(localstReportItem);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, stReportItem paramstReportItem)
  {
    stReportItem localstReportItem = paramstReportItem;
    if (paramstReportItem == null) {
      localstReportItem = a();
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
      localstReportItem = a();
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
    stReportItem localstReportItem = a();
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
      localstReportItem.ext_map = a(paramString6);
      a(localstReportItem);
      return;
    }
  }
  
  public static void a(stReportItem paramstReportItem)
  {
    if (paramstReportItem == null)
    {
      tlo.d("weishi-report", "report error item = null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramstReportItem);
    a(localArrayList);
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
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2)
  {
    stReportItem localstReportItem = a();
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
      localstReportItem.ext_map = a(str);
      a(localstReportItem, paramstSimpleMetaFeed.waterFallCardStyle);
      a(localstReportItem);
      return;
      str = "";
      break;
    }
  }
  
  public static void a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    IWSPushBaseStrategy localIWSPushBaseStrategy;
    stReportItem localstReportItem;
    if (paramWSRedDotPushMsg != null)
    {
      localIWSPushBaseStrategy = paramWSRedDotPushMsg.mStrategyInfo;
      localstReportItem = a();
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
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    stReportItem localstReportItem = a();
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
  
  public static void a(ArrayList<stReportItem> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      tlo.d("weishi-report", "report error items: " + paramArrayList);
      return;
    }
    String str = a(((stReportItem)paramArrayList.get(0)).optype, ((stReportItem)paramArrayList.get(0)).pagetype);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      stReportItem localstReportItem = (stReportItem)localIterator.next();
      tlo.b("weishi-report", "report " + str + " stReportItem:" + localstReportItem.toString());
    }
    paramArrayList = new the(new tkp(paramArrayList), null, new tjs(str), 2001);
    tgx.a().a(paramArrayList);
  }
  
  public static String b(Context paramContext)
  {
    if (TextUtils.isEmpty(b)) {}
    try
    {
      tlo.b("weishi-810", "try get QIMei from UserAction.getQIMEI!");
      b = UserAction.getQIMEI();
      if (b == null)
      {
        tlo.d("weishi-810", "getImei finally encounter error and return empty");
        b = "";
      }
      return b;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        tlo.d("weishi-810", "UserAction.getQIMEI encounter error:" + paramContext);
      }
    }
  }
  
  public static String c(Context paramContext)
  {
    if (jdField_a_of_type_AndroidNetWifiWifiManager == null) {
      jdField_a_of_type_AndroidNetWifiWifiManager = (WifiManager)paramContext.getSystemService("wifi");
    }
    paramContext = jdField_a_of_type_AndroidNetWifiWifiManager.getConnectionInfo();
    tlo.b("wifiInfo", paramContext.toString());
    return paramContext.getSSID().replace("\"", "");
  }
  
  public void a(the paramthe) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tjr
 * JD-Core Version:    0.7.0.1
 */