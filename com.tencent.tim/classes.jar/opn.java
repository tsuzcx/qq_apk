import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import UserGrowth.stGlobalConfig;
import UserGrowth.stImgReplacement;
import UserGrowth.stSimpleMetaFeed;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.4;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class opn
{
  public static SparseArray<String> aD = new SparseArray();
  public static String ara = "";
  public static boolean axW;
  private static long lastClickTime;
  
  public static boolean He()
  {
    boolean bool = true;
    QQAppInterface localQQAppInterface = getQQAppInterface();
    if (localQQAppInterface != null) {
      bool = localQQAppInterface.a.He();
    }
    return bool;
  }
  
  private static Bitmap a(URL paramURL, ImageView paramImageView)
  {
    if ((paramURL != null) && (paramImageView.getWidth() > 0))
    {
      noz localnoz = new noz();
      localnoz.url = paramURL;
      localnoz.reqWidth = paramImageView.getWidth();
      localnoz.reqHeight = paramImageView.getHeight();
      paramURL = aqgs.a(localnoz.getCacheKey());
      if (paramURL != null) {
        return paramURL.Q();
      }
    }
    return null;
  }
  
  public static WSRedDotPushMsg a(MessageForStructing paramMessageForStructing)
  {
    if (b(paramMessageForStructing))
    {
      paramMessageForStructing = paramMessageForStructing.structingMsg;
      if ((paramMessageForStructing != null) && (!TextUtils.isEmpty(paramMessageForStructing.mMsgActionData))) {
        return WSRedDotPushMsg.getInstance(paramMessageForStructing.mMsgActionData);
      }
    }
    return null;
  }
  
  public static String a(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    Object localObject2;
    if (paramstSimpleMetaFeed == null) {
      localObject2 = "";
    }
    Object localObject1;
    label73:
    do
    {
      return localObject2;
      localObject2 = "";
      localObject1 = localObject2;
      if (paramstSimpleMetaFeed.imgReplacements == null) {
        break;
      }
      localObject1 = localObject2;
      if (paramstSimpleMetaFeed.imgReplacements.size() <= 0) {
        break;
      }
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT <= 17) {
        break;
      }
      if ((paramBoolean) || (paramstSimpleMetaFeed.imgReplacements.size() <= 1)) {
        break label199;
      }
      localObject1 = ((stImgReplacement)paramstSimpleMetaFeed.imgReplacements.get(1)).img;
      ooz.d("WeishiUtils", "使用webp图片资源：" + (String)localObject1);
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    Object localObject3 = localObject1;
    if (paramstSimpleMetaFeed.images != null)
    {
      localObject3 = localObject1;
      if (paramstSimpleMetaFeed.images.size() > 0) {
        if ((paramBoolean) || (paramstSimpleMetaFeed.images.size() <= 1)) {
          break label217;
        }
      }
    }
    label199:
    label217:
    for (localObject3 = ((stMetaUgcImage)paramstSimpleMetaFeed.images.get(1)).url;; localObject3 = ((stMetaUgcImage)paramstSimpleMetaFeed.images.get(0)).url)
    {
      ooz.d("WeishiUtils", "使用服务器默认的图片格式资源：" + (String)localObject3);
      localObject2 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        break;
      }
      return "";
      localObject1 = ((stImgReplacement)paramstSimpleMetaFeed.imgReplacements.get(0)).img;
      break label73;
    }
  }
  
  public static lcr a()
  {
    Object localObject = getAppRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if ((((QQAppInterface)localObject).getManager(274) instanceof lcr)) {
        return (lcr)((QQAppInterface)localObject).getManager(274);
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView, URL paramURL, Drawable paramDrawable, String paramString)
  {
    if ((paramContext != null) && (paramKandianUrlImageView != null))
    {
      localObject = a(paramURL, paramKandianUrlImageView);
      if (localObject != null)
      {
        paramKandianUrlImageView.setImageBitmap((Bitmap)localObject);
        paramContext = "";
        if (paramURL != null) {
          paramContext = paramURL.toString();
        }
        oiu.m(1, paramContext);
      }
    }
    else
    {
      return;
    }
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      localObject = paramContext.getResources().getDrawable(2130842541);
    }
    if (paramURL == null)
    {
      paramKandianUrlImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    paramKandianUrlImageView.setIsRecyclerView(true);
    paramKandianUrlImageView.setImagePlaceHolder((Drawable)localObject).setImage(paramURL);
    paramKandianUrlImageView.setPublicAccountImageDownListener(new opo(paramString, paramKandianUrlImageView));
  }
  
  public static void a(Context paramContext, RoundImageView paramRoundImageView, String paramString)
  {
    ooz.d("AvatarImageLog", "WeishiUtils loadAvatarImage url:" + paramString + ", imageView:" + paramRoundImageView);
    URL localURL;
    if ((paramContext != null) && (paramRoundImageView != null))
    {
      localURL = b(paramString);
      paramContext = paramContext.getResources().getDrawable(2130840645);
      if (localURL == null) {
        paramRoundImageView.setImageDrawable(paramContext);
      }
    }
    else
    {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = paramContext;
    localURLDrawableOptions.mLoadingDrawable = paramContext;
    paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
    paramRoundImageView.setImageDrawable(paramContext);
    paramContext.setURLDrawableListener(new opp(paramString, paramRoundImageView));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, opn.a parama)
  {
    if (parama == null) {
      throw new RuntimeException("downloadOpenWeishiGoH5 must not be null!");
    }
    if (rpw.isWeishiInstalled(paramContext))
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        ooz.w("815", "走打开shemeUrl:" + paramString1);
        parama.aU(paramString1, paramInt);
        return;
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        ooz.w("833", "走打开小程序:" + paramString3);
        parama.aX(paramString3, paramInt);
        return;
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        ooz.w("815", "走打开h5Url:" + paramString2);
        parama.aV(paramString2, paramInt);
        return;
      }
      ooz.w("815", "走打开兜底:" + paramString1);
      parama.aU("weishi://main", paramInt);
      return;
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      ooz.w("833", "走打开小程序:" + paramString3);
      parama.aX(paramString3, paramInt);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      ooz.w("815", "走跳转h5Url:" + paramString2);
      parama.aV(paramString2, paramInt);
      return;
    }
    ooz.w("815", "走下载，shemeUrl:" + paramString1);
    parama.aW(paramString1, paramInt);
  }
  
  public static void a(Context paramContext, ArrayList<stSimpleMetaFeed> paramArrayList, int paramInt1, String paramString, stGlobalConfig paramstGlobalConfig, int paramInt2)
  {
    a(paramContext, paramArrayList, paramInt1, paramString, paramstGlobalConfig, null, paramInt2);
  }
  
  public static void a(Context paramContext, ArrayList<stSimpleMetaFeed> paramArrayList, int paramInt1, String paramString, stGlobalConfig paramstGlobalConfig, WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    axW = true;
    Intent localIntent = new Intent(paramContext, QzoneVerticalVideoDownloadActivity.class);
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty(paramString)) {}
    try
    {
      localBundle.putLong("key_current_feeduin", Long.parseLong(paramString));
      localBundle.putInt("key_request_from", 5);
      localBundle.putInt("key_weishi_scene_type", paramInt2);
      localBundle.putSerializable("key_video_weishi_public_account_feed", paramArrayList);
      localBundle.putInt("key_current_item_position", paramInt1);
      localBundle.putInt("start_param_pos", paramInt1);
      if (paramWSRedDotPushMsg != null) {
        localBundle.putParcelable("key_weishi_push_msg_data", paramWSRedDotPushMsg);
      }
      localIntent.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
      localIntent.putExtra("launch_time", System.currentTimeMillis());
      localIntent.putExtra("key_video_weishi_public_account_global_config", paramstGlobalConfig);
      paramstGlobalConfig = "";
      paramString = paramstGlobalConfig;
      if (paramArrayList != null)
      {
        paramString = paramstGlobalConfig;
        if (paramArrayList.size() > 0)
        {
          paramArrayList = (stSimpleMetaFeed)paramArrayList.get(0);
          paramString = ohy.a().fv(paramArrayList.traceId);
        }
      }
      localIntent.putExtra("key_video_weishi_server_response_header_map", paramString);
      localIntent.addFlags(268435456);
      localIntent.putExtras(localBundle);
      paramContext.startActivity(localIntent);
      ogk.awX = true;
      pQ("fullscreen_videoPlay");
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        ooz.e("openVerticalVideoLayerPage parseLong posterId : " + paramString);
      }
    }
  }
  
  public static void a(ImageView paramImageView, String paramString1, Drawable paramDrawable1, Drawable paramDrawable2, String paramString2)
  {
    if (paramImageView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramImageView.setImageDrawable(paramDrawable1);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = paramDrawable1;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable2;
    paramDrawable1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
    paramImageView.setImageDrawable(paramDrawable1);
    paramDrawable1.setURLDrawableListener(new opq(paramString2, paramImageView, paramString1));
    paramDrawable1.startDownload();
    if (1 != paramDrawable1.getStatus())
    {
      paramDrawable1.restartDownload();
      return;
    }
    ooz.i("815", "onLoad ~~~~~~" + paramString2);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, stSimpleMetaFeed paramstSimpleMetaFeed, Drawable paramDrawable, String paramString, boolean paramBoolean)
  {
    paramstSimpleMetaFeed = b(a(paramstSimpleMetaFeed, paramBoolean));
    a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView, paramstSimpleMetaFeed, paramDrawable, paramString);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, String paramString)
  {
    paramstSimpleMetaFeed = b(a(paramstSimpleMetaFeed, paramBoolean));
    a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView, paramstSimpleMetaFeed, null, paramString);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, String paramString)
  {
    if ((paramKandianUrlImageView != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = b(paramString);
      paramKandianUrlImageView.setImagePlaceHolder(BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDrawable(2130842635)).setImage(paramString);
    }
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, String paramString, Drawable paramDrawable)
  {
    if (paramKandianUrlImageView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramKandianUrlImageView.setImageDrawable(paramDrawable);
      return;
    }
    paramString = b(paramString);
    Bitmap localBitmap = a(paramString, paramKandianUrlImageView);
    if (localBitmap != null)
    {
      paramKandianUrlImageView.setImageBitmap(localBitmap);
      return;
    }
    paramKandianUrlImageView.setImagePlaceHolder(paramDrawable).setImage(paramString);
  }
  
  public static void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if (paramAppInfo != null)
    {
      ooz.d("WSRedDotLog", "saveRedDotAppInfo appInfo = " + paramAppInfo.iNewFlag.get());
      ooz.d("WSRedDotLog", "saveRedDotAppInfo hasWsRedDot = " + paramBoolean);
      LocalMultiProcConfig.putBooleanAsync("wsRedDot", paramBoolean);
    }
  }
  
  public static boolean a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if ((paramWSRedDotPushMsg.mStrategyInfo instanceof WSPushStrategyInfo))
    {
      paramWSRedDotPushMsg = (WSPushStrategyInfo)paramWSRedDotPushMsg.mStrategyInfo;
      if (paramWSRedDotPushMsg.mWSPushPreloadModel != null) {
        return paramWSRedDotPushMsg.mWSPushPreloadModel.axP;
      }
    }
    return false;
  }
  
  public static boolean a(lcr paramlcr)
  {
    if (paramlcr == null) {
      return false;
    }
    return b(paramlcr.c());
  }
  
  public static void aH(int paramInt, String paramString)
  {
    aD.put(paramInt, paramString);
  }
  
  public static WSRedDotPushMsg b()
  {
    Object localObject = a();
    if (a((lcr)localObject))
    {
      localObject = ((lcr)localObject).jl();
      ooz.e("WSPushLog", "WSRedDotPushMsg = " + (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return WSRedDotPushMsg.getInstance((String)localObject);
      }
    }
    return null;
  }
  
  public static String b(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    return fB(a(paramstSimpleMetaFeed, paramBoolean));
  }
  
  public static URL b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new URL(paramString);
        return paramString;
      }
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static boolean b(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {}
    do
    {
      return false;
      ooz.e("WSPushLog", "isMsgFromWeishiPush structMsg.frienduin: " + paramMessageForStructing.frienduin);
    } while ((!TextUtils.equals(acbn.blN, paramMessageForStructing.frienduin)) || (paramMessageForStructing.issend != 0));
    return true;
  }
  
  public static void bfZ()
  {
    lcr locallcr = a();
    if (locallcr != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
      localstSimpleMetaFeed.id = locallcr.jn();
      localstSimpleMetaFeed.feed_desc = locallcr.jo();
      locallcr.a(localstSimpleMetaFeed);
    }
  }
  
  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void cs(Context paramContext)
  {
    if (paramContext != null) {}
  }
  
  public static long dt()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getLongAccountUin();
    }
    return 0L;
  }
  
  public static String e(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return b(paramstSimpleMetaFeed, false);
  }
  
  public static String fA(String paramString)
  {
    return paramString + "&idx=" + ohy.a().ls();
  }
  
  public static String fB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (ImageUtil.isJpgFile(paramString)) {
      return "jpg";
    }
    if (ImageUtil.isPngFile(paramString)) {
      return "png";
    }
    if (ImageUtil.isWebpFile(paramString)) {
      return "webp";
    }
    return "";
  }
  
  public static String fz(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = paramString;
        if (paramString.contains("@{uid:"))
        {
          str1 = paramString;
          if (paramString.contains(",nick:"))
          {
            str1 = paramString;
            if (paramString.contains("}"))
            {
              int i = paramString.indexOf("@{uid:");
              int j = paramString.indexOf(",nick:");
              int k = paramString.indexOf("}");
              str1 = paramString.substring(i, k + 1);
              String str2 = paramString.substring(j + 6, k) + " ";
              str1 = fz(paramString.replace(str1, "@" + URLDecoder.decode(str2)));
            }
          }
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public static AppRuntime getAppRuntime()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  public static String getNetworkType()
  {
    String str = "unknown";
    if (AppNetConnInfo.isWifiConn()) {
      str = "Wi-Fi";
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return str;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return "unknown";
    case 1: 
      return "2G";
    case 2: 
      return "3G";
    case 3: 
      return "4G";
    }
    return "5G";
  }
  
  public static String getPersonId()
  {
    String str = LocalMultiProcConfig.getString4Uin("key_qq_connect_person_id", "", dt());
    ooz.bZ("WeishiUtils", "[qq_connect_person_id]" + str);
    return str;
  }
  
  public static QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String getRowKey()
  {
    Object localObject = a();
    if (!a((lcr)localObject)) {
      return "";
    }
    localObject = ((lcr)localObject).c();
    if ((localObject != null) && (((MessageForStructing)localObject).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mArticleIds)))
    {
      localObject = ((MessageForStructing)localObject).structingMsg.mArticleIds.split("\\|");
      if (localObject.length > 0) {
        return localObject[0];
      }
    }
    return "";
  }
  
  public static String getSceneTypeTestId(int paramInt)
  {
    String str = (String)aD.get(paramInt);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return "";
  }
  
  public static String getWifiBssid()
  {
    try
    {
      Object localObject = (WifiManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("wifi");
      if (localObject != null)
      {
        localObject = alkz.a((WifiManager)localObject);
        if (localObject != null)
        {
          localObject = ((WifiInfo)localObject).getBSSID();
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      ooz.e("WeishiUtils", "getWifiBssid : " + localException.toString());
    }
    return "";
  }
  
  public static String lL()
  {
    Object localObject = getAppRuntime();
    if (localObject != null)
    {
      String str = ((AppRuntime)localObject).getAccount();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      return localObject;
    }
    return "";
  }
  
  public static String lM()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static void m(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    do
    {
      int i;
      do
      {
        return;
        int j = paramView.getVisibility();
        i = j;
        if (paramView.getTag(-1) != null)
        {
          i = j;
          if (paramView.getAnimation() != null) {
            i = ((Integer)paramView.getTag(-1)).intValue();
          }
        }
        paramView.setTag(-1, Integer.valueOf(paramInt1));
      } while (i == paramInt1);
      if (paramInt1 == 0)
      {
        paramView.setVisibility(0);
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(paramInt2);
        localAlphaAnimation.setFillAfter(true);
        localAlphaAnimation.setAnimationListener(new ops(paramView));
        paramView.clearAnimation();
        paramView.startAnimation(localAlphaAnimation);
        return;
      }
    } while ((paramInt1 != 8) && (paramInt1 != 4));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt2);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new opt(paramView));
    paramView.clearAnimation();
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static void pQ(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      oni.aqT = "";
      oni.aqS = "";
      LocalMultiProcConfig.putString("weishi_usergrowth", "key_ref_page_id", "");
      return;
    }
    oni.aqT = oni.aqS;
    LocalMultiProcConfig.putString("weishi_usergrowth", "key_ref_page_id", oni.aqT);
    oni.aqS = paramString;
  }
  
  public static boolean qH()
  {
    long l = System.currentTimeMillis();
    if (l - lastClickTime <= 500L)
    {
      ooz.bZ("WeishiUtils", "click too fast");
      lastClickTime = l;
      return true;
    }
    lastClickTime = l;
    return false;
  }
  
  public static int rM()
  {
    Object localObject = getAppRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if ((((QQAppInterface)localObject).b() == null) || (((QQAppInterface)localObject).b().a() == null)) {
        return 0;
      }
      return ((QQAppInterface)localObject).b().a().A(acbn.blN, 1008);
    }
    return 0;
  }
  
  public static void setPersonId(String paramString)
  {
    LocalMultiProcConfig.putString4Uin("key_qq_connect_person_id", paramString, dt());
  }
  
  public static void t(List<stSimpleMetaFeed> paramList, boolean paramBoolean)
  {
    if (!aqiw.isWifiConnected(BaseApplication.getContext())) {}
    while ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ooz.d("PreloadCoverImgLog", "preloadImg size = " + paramList.size());
    ThreadManager.post(new WeishiUtils.4(new ArrayList(paramList), paramBoolean), 5, null, true);
  }
  
  public static void writeEncryptedDeviceIdToClipboard(String paramString)
  {
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    if (localContext == null) {
      return;
    }
    ClipboardManager localClipboardManager = (ClipboardManager)localContext.getSystemService("clipboard");
    if ((localClipboardManager != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = fA(paramString);
      ClipData localClipData = ClipData.newPlainText("", paramString);
      ooz.e("WeishiUtils", "Clipboard copyScheme: " + paramString + ", clip: " + localClipData);
      if (localClipData != null)
      {
        alkw.a(localClipboardManager, localClipData);
        localClipboardManager.setPrimaryClip(localClipData);
      }
    }
    cs(localContext);
  }
  
  public static abstract interface a
  {
    public abstract void aU(String paramString, int paramInt);
    
    public abstract void aV(String paramString, int paramInt);
    
    public abstract void aW(String paramString, int paramInt);
    
    public abstract void aX(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     opn
 * JD-Core Version:    0.7.0.1
 */