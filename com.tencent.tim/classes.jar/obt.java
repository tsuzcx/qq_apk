import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.1;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.2;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.3;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.4;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.5;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class obt
{
  public static String Yb;
  public static String Yc;
  public static String Yd;
  public static String Ye;
  public static String Yf;
  public static String Yg;
  public static String Yh = "";
  public static String Yi;
  public static String Yj;
  private static final AtomicBoolean aB = new AtomicBoolean(false);
  public static int aHM;
  public static int aHN;
  public static int aHO;
  public static int aHP;
  public static boolean adR;
  public static boolean adS;
  public static boolean adT;
  public static boolean adU;
  public static boolean adV;
  public static boolean adW;
  public static boolean adX;
  public static boolean adY;
  public static boolean adZ;
  public static boolean aea;
  public static boolean aeb;
  public static boolean aec;
  public static boolean aed;
  public static boolean aee;
  public static boolean aef;
  public static boolean aeg;
  public static boolean awi;
  public static boolean awj;
  private static QQHashMap<Integer, obt.a> b;
  public static int bdY;
  public static ArrayList<String> jZ = new ArrayList();
  public static long rL;
  
  static
  {
    Yb = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
    Yc = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
    adT = true;
    Yg = "";
    rL = 3000L;
    bdY = 10;
    aeg = true;
    Yi = "";
    Yj = "";
  }
  
  public static boolean GA()
  {
    String str1 = (String)spp.a().getValue("subscribe_entrance_enable", "0");
    String str2 = (String)spp.a().getValue("newfollowlist", "1");
    return ("1".equals(str1)) || ("1".equals(str2));
  }
  
  public static boolean Gy()
  {
    return adU;
  }
  
  public static boolean Gz()
  {
    return "1".equals((String)spp.a().getValue("subscribe_entrance_enable", "0"));
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramQQAppInterface, paramContext, 1);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    obt.a locala = a(paramQQAppInterface, paramContext, paramInt);
    if (locala != null) {
      return locala.getName();
    }
    return b(paramQQAppInterface, paramContext, paramInt);
  }
  
  public static obt.a a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 3) {
      i = 2;
    }
    if (!aB.get()) {
      a(paramQQAppInterface, paramContext);
    }
    if (b == null) {
      b = new PublicAccountConfigUtil.1(2011, 0, 1000);
    }
    return (obt.a)b.get(Integer.valueOf(i));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (b == null) {
      b = new PublicAccountConfigUtil.2(2011, 0, 1000);
    }
    if (!a(paramQQAppInterface, paramContext, aqmj.bn(paramContext)))
    {
      localObject = new obt.a(paramQQAppInterface, paramContext, 1, 2131698666, 2130841033);
      b.put(Integer.valueOf(1), localObject);
    }
    Object localObject = aqmj.bq(paramContext);
    String str = aqmj.br(paramContext);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str)))
    {
      paramQQAppInterface = new obt.a(paramQQAppInterface, paramContext, 2, 2131697443, 2130841038);
      b.put(Integer.valueOf(2), paramQQAppInterface);
    }
    for (;;)
    {
      aB.set(true);
      return;
      paramQQAppInterface = new obt.a(paramQQAppInterface, paramContext, 2, (String)localObject, str);
      b.put(Integer.valueOf(2), paramQQAppInterface);
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "parseConfigXml xml: " + paramString);
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8"))).getElementsByTagName("public-account-folder");
        int j = paramString.getLength();
        int i = 0;
        while (i < j)
        {
          Object localObject = (Element)paramString.item(i);
          int k = Integer.parseInt(((Element)localObject).getElementsByTagName("id").item(0).getFirstChild().getNodeValue());
          localObject = new obt.a(paramQQAppInterface, paramContext, k, ((Element)localObject).getElementsByTagName("name").item(0).getFirstChild().getNodeValue(), ((Element)localObject).getElementsByTagName("icon").item(0).getFirstChild().getNodeValue());
          if (b == null) {
            b = new PublicAccountConfigUtil.3(2011, 0, 1000);
          }
          b.put(Integer.valueOf(k), localObject);
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "parsePublicAccountConfigXml xml is empty");
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "parsePublicAccountConfigXml error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
    }
    return false;
    return true;
  }
  
  public static void aA(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject != null) {}
    try
    {
      paramQQAppInterface = new JSONObject();
      paramQQAppInterface.put("pacenter_url", Yb);
      paramQQAppInterface.put("pacategory_url", Yc);
      paramQQAppInterface.put("readinjoy_search_url", Yd);
      paramQQAppInterface.put("image_collection_comment", adR);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("public_account_center_url_config_data", paramQQAppInterface.toString());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "updatePublicAccountCenterUrlConfigData error", paramQQAppInterface);
      }
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void ay(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + str, 0);
    if (localSharedPreferences != null)
    {
      Ye = localSharedPreferences.getString("service_account_folder_name", null);
      Yf = localSharedPreferences.getString("service_account_folder_icon", null);
      adT = localSharedPreferences.getBoolean("service_account_folder_delete", true);
      adU = localSharedPreferences.getBoolean("service_folder_redclean_after_enter", false);
      adS = localSharedPreferences.getBoolean("service_account_folder_redspots", false);
      adV = localSharedPreferences.getBoolean("kandian_feeds_preload", false);
      adW = localSharedPreferences.getBoolean("kandian_feeds_preload_wifi", false);
      adX = localSharedPreferences.getBoolean("kandian_feeds_preload_4G", false);
      adY = localSharedPreferences.getBoolean("kandian_feeds_preload_3G", false);
      adZ = localSharedPreferences.getBoolean("kandian_feeds_preload_2G", false);
      aea = localSharedPreferences.getBoolean("public_account_bottom_bar", false);
      aeb = localSharedPreferences.getBoolean("kandian_feeds_image_preload", false);
      Yg = localSharedPreferences.getString("kandian_feeds_fling_LToR_host", "");
      rL = localSharedPreferences.getLong("kandian_ad_background_showtime", 3000L);
      aec = localSharedPreferences.getBoolean("readInJoy_ip_connect", false);
      aHM = localSharedPreferences.getInt("readInJoy_ip_connect_full_report", 0);
      Yh = localSharedPreferences.getString("readInJoy_ip_connect_report_tail", "");
      aed = localSharedPreferences.getBoolean("readInJoy_loading_img", false);
      aee = localSharedPreferences.getBoolean("service_account_folder_redspots_delete", false);
      aef = localSharedPreferences.getBoolean("big_data_share_channel", false);
      localSet = aqmk.a(localSharedPreferences, "big_data_share_channel_urls", null);
      if (localSet != null) {
        jZ = new ArrayList(localSet);
      }
      aHN = localSharedPreferences.getInt("album_predown_enable", 0);
      aHO = localSharedPreferences.getInt("album_predown_photo_rule", 0);
      aHP = localSharedPreferences.getInt("album_predown_slide_photocounts", 0);
      aeg = localSharedPreferences.getBoolean("ad_preload_tool_process", true);
      Yi = localSharedPreferences.getString("key_read_in_joy_preload_tool_config", "");
      Yj = localSharedPreferences.getString("key_read_in_joy_release_service_config", "");
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "getServiceAccountFolderConfigData success, uin:" + str + ", delete:" + adT + ", clean:" + adU + ", redspot:" + adS);
      }
    }
    while (!QLog.isColorLevel())
    {
      Set localSet;
      return;
    }
    QLog.d("PublicAccountConfigUtil", 2, "getServiceAccountFolderConfigData failed, uin:" + str);
  }
  
  public static void az(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new PublicAccountConfigUtil.4(paramQQAppInterface));
  }
  
  public static String b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramQQAppInterface, paramContext, 2);
  }
  
  public static String b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return paramContext.getString(2131698666);
    }
    return paramContext.getString(2131697443);
  }
  
  public static void bX(ArrayList<obt.a> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      if (b == null) {
        b = new PublicAccountConfigUtil.5(2011, 0, 1000);
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        obt.a locala = (obt.a)paramArrayList.next();
        b.put(Integer.valueOf(locala.mId), locala);
      }
    }
  }
  
  public static String c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramQQAppInterface, paramContext, 3);
  }
  
  public static boolean et(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
      return false;
    }
    return true;
  }
  
  public static boolean eu(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = jZ.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!TextUtils.isEmpty(str)) && (paramString.indexOf(str) != -1) && (paramString.endsWith(str))) {
        return true;
      }
    }
    return false;
  }
  
  public static void f(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("public_account_center_url_config_version", paramInt);
      paramQQAppInterface.commit();
    }
  }
  
  public static Drawable g(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramContext.getResources().getDrawable(2130840645);
    case 1: 
      return paramContext.getResources().getDrawable(2130841033);
    }
    return paramContext.getResources().getDrawable(2130841038);
  }
  
  public static int h(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + str, 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("service_account_folder_config_version", 0);
    }
    QLog.d("PublicAccountConfigUtil", 1, "getServiceAccountFolderConfigVersionCode  version:" + i);
    return i;
  }
  
  public static String h(QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    paramQQAppInterface = localObject;
    if (localSharedPreferences != null) {
      paramQQAppInterface = localSharedPreferences.getString("public_account_center_url_config_data", null);
    }
    return paramQQAppInterface;
  }
  
  public static void h(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str7 = null;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("tim_url")) {
        localJSONObject.getString("tim_url");
      }
      if (!localJSONObject.has("tim_url_card")) {
        break label576;
      }
      paramQQAppInterface = localJSONObject.getString("tim_url_card");
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        String str1;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        paramQQAppInterface.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("PublicAccountConfigUtil", 2, "update public account qq mail config error.", paramQQAppInterface);
          continue;
          str6 = null;
          continue;
          str5 = null;
          continue;
          str4 = null;
          continue;
          str3 = null;
          continue;
          str2 = null;
          continue;
          str1 = null;
          continue;
          paramString = null;
          continue;
          paramQQAppInterface = null;
        }
      }
    }
    if (localJSONObject.has("tim_wording"))
    {
      paramString = localJSONObject.getString("tim_wording");
      if (localJSONObject.has("tim_url_icon"))
      {
        str1 = localJSONObject.getString("tim_url_icon");
        if (localJSONObject.has("tim_url_icon_725"))
        {
          str2 = localJSONObject.getString("tim_url_icon_725");
          if (localJSONObject.has("qim_url_card"))
          {
            str3 = localJSONObject.getString("qim_url_card");
            if (localJSONObject.has("qim_wording"))
            {
              str4 = localJSONObject.getString("qim_wording");
              if (localJSONObject.has("qim_url_icon"))
              {
                str5 = localJSONObject.getString("qim_url_icon");
                if (localJSONObject.has("qim_url_icon_720"))
                {
                  str6 = localJSONObject.getString("qim_url_icon_720");
                  if (localJSONObject.has("qim_url_icon_story")) {
                    str7 = localJSONObject.getString("qim_url_icon_story");
                  }
                  if (et(paramQQAppInterface)) {
                    localEditor.putString("profile_card_tim_online_url", paramQQAppInterface);
                  }
                  if (et(str1)) {
                    localEditor.putString("profile_card_tim_online_icon_url", str1);
                  }
                  if (et(str2)) {
                    localEditor.putString("profile_card_tim_online_icon_725_url", str2);
                  }
                  if (!TextUtils.isEmpty(paramString)) {
                    localEditor.putString("profile_card_tim_online_wording", paramString);
                  }
                  if (et(str3)) {
                    localEditor.putString("profile_card_qim_online_url", str3);
                  }
                  if (et(str5)) {
                    localEditor.putString("profile_card_qim_online_icon_url", str5);
                  }
                  if (et(str6)) {
                    localEditor.putString("profile_card_qim_online_icon_url_720", str6);
                  }
                  if (et(str7)) {
                    localEditor.putString("key_story_qim_online_icon_url", str7);
                  }
                  if (!TextUtils.isEmpty(str4)) {
                    localEditor.putString("profile_card_qim_online_wording", str4);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountConfigUtil", 2, "updatePublicAccountQQMailConfigData url_card_tim_online:" + paramQQAppInterface + "; url_card_qim_online:" + str3);
                  }
                  localEditor.putInt("public_account_qq_mail_config_version", paramInt);
                  localEditor.commit();
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static int i(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("public_account_center_url_config_version", 0);
    }
    return i;
  }
  
  public static int j(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("public_account_qq_mail_config_version", 0);
    }
    return i;
  }
  
  public static boolean k(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeRecommendConfig xml: " + paramString);
    }
    label3076:
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        Object localObject1 = paramString.getElementsByTagName("recommendFullVersion");
        int j;
        Object localObject2;
        int k;
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          j = oac.e(paramQQAppInterface);
          if (i <= j) {
            continue;
          }
          localObject1 = (Element)paramString.getElementsByTagName("recommendFullScreen").item(0);
          localObject2 = (Element)paramString.getElementsByTagName("recommendURL").item(0);
          k = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = ((Element)localObject2).getFirstChild().getNodeValue();
          if (k != 1) {
            break label3064;
          }
          bool = true;
          oac.a(paramQQAppInterface, bool, (String)localObject1);
          oac.d(paramQQAppInterface, i);
          if (k == 1)
          {
            localObject2 = (WebProcessManager)paramQQAppInterface.getManager(13);
            if (localObject2 != null) {
              ((WebProcessManager)localObject2).Yc(66);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("SubscriptRecommendConfig update fullrecommend config. version : ").append(i).append(" switch : ");
            if (k != 1) {
              break label3070;
            }
            bool = true;
            QLog.d("PublicAccountConfigUtil", 2, bool + " url : " + (String)localObject1 + " oldVersion : " + j);
          }
        }
        localObject1 = paramString.getElementsByTagName("recommendBottomVersion");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          j = oac.f(paramQQAppInterface);
          if (i <= j) {
            break label2956;
          }
          k = Integer.valueOf(((Element)paramString.getElementsByTagName("recommendBottom").item(0)).getFirstChild().getNodeValue()).intValue();
          if (k != 1) {
            break label2950;
          }
          bool = true;
          oac.b(paramQQAppInterface, bool);
          oac.e(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig update innerrecommend config. preversion -> version " + j + "->" + i + " switch : " + k);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("kandian_read_data").item(0);
        if (localObject1 != null)
        {
          i = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.getApp();
          if (i != 1) {
            break label3076;
          }
          bool = true;
          aqmj.J((Context)localObject1, bool);
        }
        localObject1 = paramString.getElementsByTagName("channel_version");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          j = awit.au(paramQQAppInterface);
          if (i <= j) {
            break label2991;
          }
          localObject2 = (Element)paramString.getElementsByTagName("channel_id").item(0);
          Element localElement = (Element)paramString.getElementsByTagName("channel_name").item(0);
          localObject1 = (Element)paramString.getElementsByTagName("channel_type").item(0);
          k = Integer.valueOf(((Element)localObject2).getFirstChild().getNodeValue()).intValue();
          localObject2 = String.valueOf(localElement.getFirstChild().getNodeValue());
          int m = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          awit.b(paramQQAppInterface, k, (String)localObject2, m);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "update channelInfo config. preversion -> version " + j + "->" + i + " channelID : " + k + " channelName: " + (String)localObject2 + " channelType: " + m);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("video_sound").item(0);
        if (localObject1 != null)
        {
          i = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.getApp();
          if (i != 0) {
            break label3026;
          }
          bool = true;
          aqmj.K((Context)localObject1, bool);
          localObject1 = mzj.a();
          if (i != 0) {
            break label3032;
          }
          bool = true;
          ((mzj)localObject1).oT(bool);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "get video sound config " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("multi_video_support_enable");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (i <= 0) {
            break label3038;
          }
          bool = true;
          awit.as(paramQQAppInterface, bool);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "updateSupportMultiVideoSwitch， supportEnable = " + i);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("rn_switch").item(0);
        if (localObject1 != null)
        {
          i = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.getApp();
          if (i == 1) {
            break label3044;
          }
          bool = true;
          aqmj.d((Context)localObject1, bool, paramQQAppInterface.getCurrentUin());
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "get interesrLableRn config " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_struct_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          if (Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label3050;
          }
          bool = true;
          awit.au(paramQQAppInterface, bool);
        }
        localObject1 = paramString.getElementsByTagName("video_social_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          if (Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label3056;
          }
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "parse kandian video social switch = " + bool);
          }
          awit.m(paramQQAppInterface, bool);
        }
        localObject1 = paramString.getElementsByTagName("videochannel_video_autoplay");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video channel auto play switch default value = " + i);
          }
          awit.m(paramQQAppInterface, i);
        }
        localObject1 = paramString.getElementsByTagName("video_jump_to");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video jump default value = " + i);
          }
          awit.o(paramQQAppInterface, i);
        }
        localObject1 = paramString.getElementsByTagName("defaultBitRate");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          localObject1 = (Element)((NodeList)localObject1).item(0);
          awit.I(paramQQAppInterface, ((Element)localObject1).getFirstChild().getNodeValue());
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "defaultBitRate value = " + ((Element)localObject1).getFirstChild().getNodeValue());
          }
        }
        localObject1 = paramString.getElementsByTagName("CUKingCard_Dlg");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          awit.p(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "CUKingCardDlg value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_channel_style");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          awit.x(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_channel_style value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_strategyid");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          awit.y(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_strategyid value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_duration_limit");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          awit.z(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_duration_limit value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_duration_percent");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          float f = Float.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).floatValue();
          awit.a(paramQQAppInterface, f);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_duration_percent value = " + f);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_operator");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          awit.A(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_operator value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("web_viola_render_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          awit.B(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "web_viola_render_switch value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("web_viola_render_mode");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          awit.C(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "web_viola_render_mode value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("videochannel_video_autoplay_18mo");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video flow video channel auto play switch default value = " + i);
          }
          awit.n(paramQQAppInterface, i);
        }
        localObject1 = paramString.getElementsByTagName("click_videocard_jump_comment");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video channel feeds click switch default value = " + i);
          }
          awit.l(paramQQAppInterface, i);
        }
        localObject1 = paramString.getElementsByTagName("viola_dynamic_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          awit.D(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "viola dynamic default value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("viola_dynamic_weishi_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          awit.E(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "viola dynamic weishi default value = " + i);
          }
        }
        localObject1 = paramString.getElementsByTagName("viola_discover_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          awit.F(paramQQAppInterface, i);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "viola dynamic discover default value = " + i);
          }
        }
        paramString = paramString.getElementsByTagName("viola_message_box_switch");
        if ((paramString == null) || (paramString.getLength() <= 0)) {
          break label3062;
        }
        i = Integer.valueOf(((Element)paramString.item(0)).getFirstChild().getNodeValue()).intValue();
        awit.G(paramQQAppInterface, i);
        if (!QLog.isColorLevel()) {
          break label3062;
        }
        QLog.d("PublicAccountConfigUtil", 2, "viola dynamic message box default value = " + i);
        break label3062;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig same version ! " + i);
        continue;
        bool = false;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "update subscript recommend config error." + paramQQAppInterface);
        }
        return false;
      }
      label2950:
      continue;
      label2956:
      if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig update fail same version " + i);
        continue;
        label2991:
        if (QLog.isColorLevel())
        {
          QLog.d("PublicAccountConfigUtil", 2, "update channelInfo fail same version " + i);
          continue;
          label3026:
          bool = false;
          continue;
          label3032:
          bool = false;
          continue;
          label3038:
          bool = false;
          continue;
          label3044:
          bool = false;
          continue;
          label3050:
          bool = false;
          continue;
          label3056:
          bool = false;
          continue;
          label3062:
          return true;
          label3064:
          bool = false;
          continue;
          label3070:
          bool = false;
          continue;
          bool = false;
        }
      }
    }
  }
  
  public static boolean l(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      for (;;)
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountConfigUtil", 2, "update readinjoy folder xml: " + paramString);
        }
        try
        {
          paramString = paramString.trim();
          paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
          Object localObject = paramString.getElementsByTagName("id");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
          {
            i = Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue();
            if (i > aqmj.bj(paramQQAppInterface.getApp()))
            {
              localObject = (Element)paramString.getElementsByTagName("name").item(0);
              paramString = (Element)paramString.getElementsByTagName("icon").item(0);
              localObject = ((Element)localObject).getFirstChild().getNodeValue();
              paramString = paramString.getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString))) {
                aqmj.N(paramQQAppInterface.getApp(), (String)localObject, paramString);
              }
              aqmj.aJ(paramQQAppInterface.getApp(), i);
              return false;
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return false;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PublicAccountConfigUtil", 2, "readinjoy folder config same id ! " + i);
    return false;
  }
  
  public static final String lb()
  {
    if (Gz()) {
      return ld();
    }
    return acfp.m(2131716887);
  }
  
  public static final String lc()
  {
    if (Gz()) {
      return ld();
    }
    return acfp.m(2131716887);
  }
  
  private static final String ld()
  {
    return (String)spp.a().getValue("subscribe_account_title", spp.aFw);
  }
  
  public static void m(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Yb = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      Yc = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("pacenter_url");
        String str2 = paramString.getString("pacategory_url");
        if (et(str1))
        {
          Yb = str1;
          if (!et(str2)) {
            break label159;
          }
          Yc = str2;
          if (!paramString.has("readinjoy_search_url")) {
            break label167;
          }
          str1 = paramString.getString("readinjoy_search_url");
          if (et(str1)) {
            Yd = str1;
          }
          if (!paramString.has("image_collection_comment")) {
            break;
          }
          adR = paramString.getBoolean("image_collection_comment");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "loadPublicAccountCenterUrlConfig error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
        Yb = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
        Yc = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
        adR = false;
        return;
      }
      Yb = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      continue;
      label159:
      Yc = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      continue;
      label167:
      f(paramQQAppInterface, 0);
    }
    f(paramQQAppInterface, 0);
  }
  
  public static void pb(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "resetPublicAccountConfig uin:" + paramString);
    }
    Yb = "https://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
    Yc = "https://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
    adT = true;
    adS = false;
    aee = false;
    adR = false;
    adV = false;
    adW = false;
    adX = false;
    adY = false;
    adZ = false;
    aeb = false;
    Yg = "";
    rL = 3000L;
    aeg = true;
    aec = false;
    aHM = 0;
    Yh = "";
    aed = false;
    aef = false;
    jZ.clear();
    aHN = 0;
    aHO = 0;
    aHP = 0;
    Yi = "";
    Yj = "";
  }
  
  public static class a
  {
    Drawable mIcon = null;
    String mIconUrl = "";
    int mId = 0;
    String mName = "";
    String mUin = "";
    
    public a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
    {
      this.mId = paramInt1;
      this.mName = paramContext.getString(paramInt2);
      this.mIconUrl = "";
      try
      {
        this.mIcon = paramContext.getResources().getDrawable(paramInt3);
        label66:
        this.mUin = bH(paramInt1);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        break label66;
      }
    }
    
    public a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2)
    {
      this.mId = paramInt;
      this.mName = paramString1;
      this.mIconUrl = paramString2;
      this.mUin = bH(paramInt);
      this.mIcon = obt.g(paramContext, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder mId: " + this.mId + " | mName: " + this.mName + " | mIconUrl: " + this.mIconUrl + " | mUin : " + this.mUin);
      }
      if ((!TextUtils.isEmpty(this.mIconUrl)) && (!TextUtils.isEmpty(this.mUin)))
      {
        paramString1 = vfq.d(paramContext, paramString2);
        if (paramString1 != null) {
          this.mIcon = paramString1;
        }
      }
      while (!QLog.isColorLevel())
      {
        return;
        vfq.a(paramQQAppInterface, paramContext, paramString2, new vfq.a(paramContext, new obt.b(this, paramQQAppInterface, this.mUin), new Object[0]));
        return;
      }
      QLog.d("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder mIconUrl is empty");
    }
    
    private String bH(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "";
      case 1: 
        return String.valueOf(7210);
      case 2: 
        return String.valueOf(acbn.blw);
      }
      return String.valueOf(acbn.blx);
    }
    
    public Drawable getIcon()
    {
      return this.mIcon;
    }
    
    public String getName()
    {
      return this.mName;
    }
  }
  
  public static class b
    implements vfq.b
  {
    obt.a a = null;
    String mUin = "";
    WeakReference<QQAppInterface> n = null;
    
    public b(obt.a parama, QQAppInterface paramQQAppInterface, String paramString)
    {
      this.a = parama;
      this.n = new WeakReference(paramQQAppInterface);
      this.mUin = paramString;
    }
    
    public void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder IDownloadListener fail, status: " + paramInt + " | icon: " + paramDrawable + " | mFolder: " + this.a);
      }
      if ((paramInt == 2) && (paramDrawable != null) && (this.a != null)) {
        this.a.mIcon = paramDrawable;
      }
      try
      {
        ((QQAppInterface)this.n.get()).getBusinessHandler(1).notifyUI(4, true, new Object[] { this.mUin });
        return;
      }
      catch (Exception paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("PublicAccountConfigUtil", 2, "PublicAccountConfigFolder IDownloadListener fail", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obt
 * JD-Core Version:    0.7.0.1
 */