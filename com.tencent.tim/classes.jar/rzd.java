import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
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

public class rzd
{
  private static long iu;
  
  public static void A(String paramString, int paramInt1, int paramInt2)
  {
    a(null, paramString, new CertifiedAccountMeta.StFeed(), new ExtraTypeInfo(paramInt1, paramInt2), null);
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
    if (fe(paramInt1))
    {
      paramString1 = new CertifiedAccountMeta.StVideo();
      paramString1.height.set(paramInt3);
      paramString1.width.set(paramInt2);
      localStFeed.video.set(paramString1);
    }
    return localStFeed;
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
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo)
  {
    a(paramContext, "", paramStFeed, paramExtraTypeInfo, null);
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser)
  {
    a(paramContext, paramStUser.id.get(), paramStUser, 0, null);
  }
  
  public static void a(Context paramContext, String paramString, CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo, Intent paramIntent)
  {
    if (Math.abs(System.currentTimeMillis() - iu) < 500L) {
      QLog.i("SubscribeLauncher", 2, "prevent SubscribeLaucher from doubleClick");
    }
    Intent localIntent;
    for (;;)
    {
      return;
      bxx();
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
      iu = System.currentTimeMillis();
      localIntent.putExtra("PERF_OPEN_PAGE_TIME", System.currentTimeMillis());
      if (paramContext == null) {}
      for (paramString = BaseApplicationImpl.getContext(); !a(paramString, paramStFeed, paramExtraTypeInfo, localIntent); paramString = paramContext)
      {
        localIntent.setClass(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
        localIntent.putExtra("fragment_class", SubscribeHybirdFragment.class.getCanonicalName());
        if (!(paramContext instanceof Activity)) {
          break label212;
        }
        paramContext.startActivity(localIntent);
        return;
      }
    }
    label212:
    localIntent.addFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, CertifiedAccountMeta.StUser paramStUser, int paramInt, Intent paramIntent)
  {
    ryo.remove("1001" + paramString);
    ryo.a("1001" + paramString, new sfv(paramString));
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo(7002, paramInt);
    paramString = a("", paramString, -1, 0, 0, 0L);
    if (paramStUser != null) {
      paramString.poster.set(paramStUser);
    }
    a(paramContext, null, paramString, localExtraTypeInfo, paramIntent);
  }
  
  private static boolean a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo, Intent paramIntent)
  {
    boolean bool2 = true;
    ExtraTypeInfo localExtraTypeInfo = paramExtraTypeInfo;
    if (paramExtraTypeInfo == null) {
      localExtraTypeInfo = new ExtraTypeInfo();
    }
    if ((localExtraTypeInfo.pageType == 0) && (paramStFeed != null)) {
      localExtraTypeInfo.pageType = br(paramStFeed.type.get());
    }
    boolean bool1;
    int i;
    switch (localExtraTypeInfo.pageType)
    {
    default: 
      bool1 = false;
      bool2 = false;
      i = 0;
    }
    for (;;)
    {
      paramIntent.putExtra("key_subscribe_intent_extra_type_info", localExtraTypeInfo);
      if (i != 0)
      {
        ryo.remove("1002" + paramStFeed.id.get());
        ryo.a("1002" + paramStFeed.id.get(), new sft(paramStFeed));
      }
      if (bool2)
      {
        if ((!bool1) || (!(paramContext instanceof Activity)) || (Build.VERSION.SDK_INT < 16)) {
          break;
        }
        paramContext = (Activity)paramContext;
        paramContext.startActivity(paramIntent, sge.i());
        paramContext.overridePendingTransition(0, 0);
      }
      return bool2;
      paramIntent.setClass(paramContext, PublicFragmentActivity.class);
      paramIntent.putExtra("public_fragment_class", SubscribeVideoDetailFragment.class.getName());
      paramIntent.addFlags(268435456);
      bool1 = sge.HP();
      i = 1;
      continue;
      paramIntent.setClass(paramContext, PublicFragmentActivity.class);
      paramIntent.putExtra("public_fragment_class", SubscribeMultiPicFragment.class.getName());
      paramIntent.addFlags(268435456);
      bool1 = sge.HP();
      i = 1;
      continue;
      paramIntent.setClass(paramContext, PublicFragmentActivity.class);
      paramIntent.putExtra("public_fragment_class", SubscribePersonalDetailFragment.class.getName());
      paramIntent.addFlags(268435456);
      bool1 = false;
      i = 0;
      continue;
      paramIntent.setClass(paramContext, ServiceAccountFolderActivity.class);
      paramIntent.setFlags(67108864);
      bool1 = false;
      i = 0;
    }
    paramContext.startActivity(paramIntent);
    return bool2;
  }
  
  public static void b(Activity paramActivity, String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramString != null)
    {
      if (paramString.startsWith("opendetail"))
      {
        QLog.i("SubscribeLauncher", 2, "launchSubscribeBySchema detail");
        paramActivity = a(gx((String)paramHashMap.get("feedid")), gx((String)paramHashMap.get("uin")), Integer.parseInt(gy((String)paramHashMap.get("type"))), Integer.parseInt(gy((String)paramHashMap.get("width"))), Integer.parseInt(gy((String)paramHashMap.get("height"))), Long.parseLong(gy((String)paramHashMap.get("createtime"))));
        paramString = (String)paramHashMap.get("commentid");
        if (TextUtils.isEmpty(paramString)) {
          a(null, paramActivity);
        }
      }
      do
      {
        return;
        ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo(0, 0);
        localExtraTypeInfo.setReplyId((String)paramHashMap.get("replyid"));
        localExtraTypeInfo.setCommentId(paramString);
        a(null, paramActivity, localExtraTypeInfo);
        return;
        if (paramString.startsWith("openhomepage"))
        {
          QLog.i("SubscribeLauncher", 2, "launchSubscribeBySchema personal page");
          bf(paramActivity, gx((String)paramHashMap.get("uid")));
          return;
        }
      } while (!paramString.startsWith("opendiscoverpage"));
      QLog.i("SubscribeLauncher", 2, "launchSubscribeBySchema ServiceAccountFolder page");
      a(paramActivity, 0, 7004, null);
      return;
    }
    QLog.e("SubscribeLauncher", 2, "launchSubscribeBySchema failed");
  }
  
  public static void bf(Context paramContext, String paramString)
  {
    i(paramContext, paramString, 0);
  }
  
  public static int br(int paramInt)
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
  
  private static void bxx()
  {
    ryz.a();
  }
  
  public static void bz(String paramString, int paramInt)
  {
    A(paramString, paramInt, 0);
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent)
  {
    a(paramContext, paramString, null, 0, paramIntent);
  }
  
  public static boolean fe(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 3) || (paramInt == 5) || (paramInt == 6);
  }
  
  public static boolean ff(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 7);
  }
  
  public static boolean fg(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8);
  }
  
  private static String gx(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    return str;
  }
  
  private static String gy(String paramString)
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
  
  public static void i(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, paramString, null, paramInt, null);
  }
  
  public static void sW(String paramString)
  {
    bz(paramString, 8000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzd
 * JD-Core Version:    0.7.0.1
 */