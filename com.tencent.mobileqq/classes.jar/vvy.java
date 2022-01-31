import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class vvy
{
  private static long a;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return 0;
    case 0: 
    case 3: 
    case 5: 
    case 6: 
      return 7000;
    case 2: 
    case 7: 
      return 7001;
    }
    return 8001;
  }
  
  public static CertifiedAccountMeta.StFeed a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    CertifiedAccountMeta.StFeed localStFeed = new CertifiedAccountMeta.StFeed();
    if (paramString1 != null) {
      localStFeed.id.set(paramString1);
    }
    localStFeed.type.set(paramInt1);
    localStFeed.createTime.set(paramLong);
    paramString1 = new CertifiedAccountMeta.StUser();
    if (paramString2 != null) {
      paramString1.id.set(paramString2);
    }
    localStFeed.poster.set(paramString1);
    if (a(paramInt1))
    {
      paramString1 = new CertifiedAccountMeta.StVideo();
      paramString1.height.set(paramInt3);
      paramString1.width.set(paramInt2);
      localStFeed.video.set(paramString1);
    }
    return localStFeed;
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    return str;
  }
  
  private static void a()
  {
    vvt.a();
  }
  
  public static void a(Activity paramActivity, String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramString != null)
    {
      if (paramString.startsWith("opendetail"))
      {
        QLog.i("SubscribeLaucher", 2, "launchSubscribeBySchema detail");
        a(paramActivity, a(a((String)paramHashMap.get("feedid")), a((String)paramHashMap.get("uin")), Integer.parseInt(b((String)paramHashMap.get("type"))), Integer.parseInt(b((String)paramHashMap.get("width"))), Integer.parseInt(b((String)paramHashMap.get("height"))), Long.parseLong(b((String)paramHashMap.get("createtime")))));
      }
      do
      {
        return;
        if (paramString.startsWith("openhomepage"))
        {
          QLog.i("SubscribeLaucher", 2, "launchSubscribeBySchema personal page");
          a(paramActivity, a((String)paramHashMap.get("uid")));
          return;
        }
      } while (!paramString.startsWith("opendiscoverpage"));
      QLog.i("SubscribeLaucher", 2, "launchSubscribeBySchema ServiceAccountFolder page");
      a(paramActivity, 0, 7004, null);
      return;
    }
    QLog.e("SubscribeLaucher", 2, "launchSubscribeBySchema failed");
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(paramContext, null, null, new ExtraTypeInfo(paramInt2, paramInt1), paramIntent);
  }
  
  public static void a(Context paramContext, int paramInt, Intent paramIntent)
  {
    int i = 0;
    int j = 7003;
    if (QzoneConfig.getInstance().getConfig("qqsubscribe", "DefaultSelectExplorePage", 0) > 0) {
      i = 1;
    }
    if (i != 0) {
      j = 7004;
    }
    a(paramContext, paramInt, j, paramIntent);
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed)
  {
    a(paramContext, paramStFeed, 0);
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, int paramInt)
  {
    a(paramContext, paramStFeed, paramInt, null);
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, int paramInt, Intent paramIntent)
  {
    a(paramContext, "", paramStFeed, new ExtraTypeInfo(0, paramInt), paramIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, 0);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, paramString, paramInt, null);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, Intent paramIntent)
  {
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo(7002, paramInt);
    a(paramContext, null, a("", paramString, -1, 0, 0, 0L), localExtraTypeInfo, paramIntent);
  }
  
  public static void a(Context paramContext, String paramString, CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo, Intent paramIntent)
  {
    if (Math.abs(System.currentTimeMillis() - a) < 500L) {
      QLog.i("SubscribeLaucher", 2, "prevent SubscribeLaucher from doubleClick");
    }
    Intent localIntent;
    do
    {
      return;
      a();
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      if (paramString != null) {
        localIntent.putExtra("url", paramString);
      }
      if (paramStFeed != null)
      {
        ((CertifiedAccountMeta.StUser)paramStFeed.poster.get()).setHasFlag(true);
        ((CertifiedAccountMeta.StImage)paramStFeed.cover.get()).setHasFlag(true);
        ((CertifiedAccountMeta.StVideo)paramStFeed.video.get()).setHasFlag(true);
        localIntent.putExtra("bundle_key_subscribe_feed_bytes_array", paramStFeed.toByteArray());
        localIntent.putExtra("bundle_key_feed_type", paramStFeed.type.get());
      }
      a = System.currentTimeMillis();
      localIntent.putExtra("PERF_OPEN_PAGE_TIME", System.currentTimeMillis());
      paramString = paramContext;
      if (paramContext == null) {
        paramString = BaseApplicationImpl.getContext();
      }
    } while (a(paramString, paramStFeed, paramExtraTypeInfo, localIntent));
    localIntent.setClass(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("fragment_class", SubscribeHybirdFragment.class.getCanonicalName());
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent)
  {
    a(paramContext, paramString, 0, paramIntent);
  }
  
  public static void a(String paramString)
  {
    a(paramString, 8000);
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    a(null, paramString, new CertifiedAccountMeta.StFeed(), new ExtraTypeInfo(paramInt1, paramInt2), null);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 3) || (paramInt == 5) || (paramInt == 6);
  }
  
  private static boolean a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo, Intent paramIntent)
  {
    boolean bool = true;
    ExtraTypeInfo localExtraTypeInfo = paramExtraTypeInfo;
    if (paramExtraTypeInfo == null) {
      localExtraTypeInfo = new ExtraTypeInfo();
    }
    if ((localExtraTypeInfo.pageType == 0) && (paramStFeed != null)) {
      localExtraTypeInfo.pageType = a(paramStFeed.type.get());
    }
    switch (localExtraTypeInfo.pageType)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      paramIntent.putExtra("key_subscribe_intent_extra_type_info", localExtraTypeInfo);
      if (bool) {
        paramContext.startActivity(paramIntent);
      }
      return bool;
      paramIntent.setClass(paramContext, PublicFragmentActivity.class);
      paramIntent.putExtra("public_fragment_class", SubscribeVideoDetailFragment.class.getName());
      paramIntent.addFlags(268435456);
      continue;
      paramIntent.setClass(paramContext, PublicFragmentActivity.class);
      paramIntent.putExtra("public_fragment_class", SubscribeMultiPicFragment.class.getName());
      paramIntent.addFlags(268435456);
      continue;
      paramIntent.setClass(paramContext, PublicFragmentActivity.class);
      paramIntent.putExtra("public_fragment_class", SubscribePersonalDetailFragment.class.getName());
      paramIntent.addFlags(268435456);
      continue;
      paramIntent.setClass(paramContext, ServiceAccountFolderActivity.class);
      paramIntent.setFlags(67108864);
    }
  }
  
  private static String b(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = "0";
    }
    return str;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 7);
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vvy
 * JD-Core Version:    0.7.0.1
 */