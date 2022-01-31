import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.fragments.QCircleHybirdFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.fragments.QCircleTagPageFragment;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentDetailFragment;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.net.URLDecoder;
import java.util.HashMap;
import mqq.app.AppRuntime;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class tqs
{
  public static void a(Activity paramActivity, Bundle paramBundle, String paramString, int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = ammv.a(paramActivity);
    }
    if (!bool)
    {
      bdcd.b(paramActivity);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("postUin", paramString);
    localIntent.putExtra("fromType", paramInt);
    localIntent.putExtra("publish_state_type", 2);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    bizm.a(paramActivity, localIntent);
  }
  
  public static void a(Activity paramActivity, String paramString, HashMap<String, String> paramHashMap)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if ("openwebview".equals(paramString))
      {
        a(paramHashMap);
        return;
      }
      if ("openmainpage".equals(paramString))
      {
        b(paramHashMap);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    if ("opentag".equals(paramString))
    {
      c(paramHashMap);
      return;
    }
    if ("opendetail".equals(paramString))
    {
      d(paramHashMap);
      return;
    }
    if ("openfolder".equals(paramString)) {
      e(paramHashMap);
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    tqj.a().a();
    tpz.a().b();
    yfo.a("2002");
    yfo.a("2002", new txv(tqj.a().a()));
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = paramContext;
    if (paramContext == null) {
      paramIntent = BaseApplicationImpl.getContext();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(paramIntent, QCircleFolderActivity.class);
    paramIntent.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, null);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent)
  {
    QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url:" + paramString);
    if (!tqr.a(paramString)) {
      QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url isEmpty or Invalid");
    }
    while (ytg.a("launchQCircleHybirdActivity:" + paramString, 2000L)) {
      return;
    }
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    paramContext = paramIntent;
    if (paramIntent == null) {
      paramContext = new Intent();
    }
    if (paramString != null) {
      paramContext.putExtra("url", paramString);
    }
    tyv.a(paramContext, paramString);
    paramContext.putExtra("titleBarStyle", 4);
    paramContext.putExtra("titleStyle", tyv.a().a((Context)localObject, paramString));
    paramContext.setClass(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    paramContext.putExtra("fragment_class", QCircleHybirdFragment.class.getCanonicalName());
    paramContext.addFlags(268435456);
    ((Context)localObject).startActivity(paramContext);
  }
  
  private static void a(Intent paramIntent)
  {
    paramIntent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
    BaseApplicationImpl.getContext().startActivity(paramIntent);
  }
  
  public static void a(QCircleInitBean paramQCircleInitBean, Intent paramIntent)
  {
    if (tra.a()) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.addFlags(268435456);
    localIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", QCircleContentDetailFragment.class.getName());
    a(localIntent);
  }
  
  public static void a(FeedCloudMeta.StUser paramStUser)
  {
    b(new tqo().a(paramStUser).a(), null);
  }
  
  public static void a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    b(new tqo().a(str).a(), null);
  }
  
  public static void a(String paramString, Intent paramIntent)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    b(new tqo().a(str).a(), paramIntent);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("QCircleLauncher", 1, "launchTagPage error tagId or tagName is Empty");
      return;
    }
    c(new tqo().a(paramString1, paramString2).a(), null);
  }
  
  public static void a(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.containsKey("url"))) {}
    try
    {
      String str = URLDecoder.decode((String)paramHashMap.get("url"));
      a(BaseApplicationImpl.getContext(), str);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleLauncher", 1, "parseUrl:" + (String)paramHashMap.get("url") + " error:" + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  public static void b(QCircleInitBean paramQCircleInitBean, Intent paramIntent)
  {
    Object localObject = paramQCircleInitBean.getUser().id.get();
    yfo.a("2001" + (String)localObject);
    yfo.a("2001" + (String)localObject, new txx((String)localObject));
    localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    ((Intent)localObject).putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    ((Intent)localObject).putExtra("public_fragment_class", QCirclePersonalDetailFragment.class.getName());
    a((Intent)localObject);
  }
  
  private static void b(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      Intent localIntent = new Intent();
      String str2 = (String)paramHashMap.get("from");
      String str1;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (TextUtils.isDigitsOnly(str2)) {}
      }
      else
      {
        str1 = str2;
        if (!tym.b()) {
          str1 = "8";
        }
      }
      localIntent.putExtra("key_jump_from", str1);
      if (paramHashMap.containsKey("pushid")) {
        localIntent.putExtra("key_push_id", (String)paramHashMap.get("pushid"));
      }
      if (paramHashMap.containsKey("uin"))
      {
        str1 = (String)paramHashMap.get("uin");
        paramHashMap = str1;
        if (TextUtils.isEmpty(str1)) {
          paramHashMap = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        }
        localIntent.putExtra("key_to_uin", paramHashMap);
        b(new tqo().a(paramHashMap).a(), localIntent);
      }
    }
  }
  
  private static void c(QCircleInitBean paramQCircleInitBean, Intent paramIntent)
  {
    yfo.a("2005");
    yfo.a("2005", new txz(paramQCircleInitBean));
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.putExtra("public_fragment_class", QCircleTagPageFragment.class.getName());
    a(localIntent);
  }
  
  private static void c(HashMap<String, String> paramHashMap)
  {
    Intent localIntent;
    String str1;
    if (paramHashMap != null)
    {
      localIntent = new Intent();
      String str2 = (String)paramHashMap.get("from");
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (TextUtils.isDigitsOnly(str2)) {}
      }
      else
      {
        str1 = str2;
        if (!tym.b()) {
          str1 = "8";
        }
      }
      localIntent.putExtra("key_jump_from", str1);
      if (paramHashMap.containsKey("pushid")) {
        localIntent.putExtra("key_push_id", (String)paramHashMap.get("pushid"));
      }
      if ((paramHashMap.containsKey("tagid")) || (paramHashMap.containsKey("tagname")))
      {
        str1 = (String)paramHashMap.get("tagid");
        paramHashMap = (String)paramHashMap.get("tagname");
        if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(paramHashMap))) {
          break label154;
        }
        QLog.e("QCircleLauncher", 1, "launchTagPage error tagId and tagName all Empty");
      }
    }
    return;
    label154:
    c(new tqo().a(str1, paramHashMap).a(), localIntent);
  }
  
  private static void d(HashMap<String, String> paramHashMap)
  {
    boolean bool2 = false;
    FeedCloudMeta.StFeed localStFeed;
    Object localObject1;
    if (paramHashMap != null)
    {
      localStFeed = new FeedCloudMeta.StFeed();
      if (paramHashMap.containsKey("feedid")) {
        localStFeed.id.set((String)paramHashMap.get("feedid"));
      }
      if (paramHashMap.containsKey("createtime")) {
        localStFeed.createTime.set(Long.parseLong((String)paramHashMap.get("createtime")));
      }
      if (paramHashMap.containsKey("uin"))
      {
        localObject1 = new FeedCloudMeta.StUser();
        ((FeedCloudMeta.StUser)localObject1).id.set((String)paramHashMap.get("uin"));
        localStFeed.poster.set((MessageMicro)localObject1);
      }
      if (!paramHashMap.containsKey("sourcetype")) {
        break label621;
      }
    }
    label621:
    for (int i = Integer.valueOf((String)paramHashMap.get("sourcetype")).intValue();; i = 0)
    {
      boolean bool1 = bool2;
      if (paramHashMap.containsKey("issinglefeed"))
      {
        bool1 = bool2;
        if (Integer.valueOf((String)paramHashMap.get("issinglefeed")).intValue() == 1) {
          bool1 = true;
        }
      }
      Intent localIntent = new Intent();
      Object localObject2 = (String)paramHashMap.get("from");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (TextUtils.isDigitsOnly((CharSequence)localObject2)) {}
      }
      else
      {
        localObject1 = localObject2;
        if (!tym.b()) {
          localObject1 = "8";
        }
      }
      localIntent.putExtra("key_jump_from", (String)localObject1);
      if (paramHashMap.containsKey("pushid")) {
        localIntent.putExtra("key_push_id", (String)paramHashMap.get("pushid"));
      }
      localObject2 = new ExtraTypeInfo();
      ((ExtraTypeInfo)localObject2).sourceType = i;
      localObject1 = null;
      if ((paramHashMap.containsKey("commentid")) || (paramHashMap.containsKey("replyid")) || (paramHashMap.containsKey("commentposterid")) || (paramHashMap.containsKey("replyposterid")))
      {
        localObject1 = new QQCircleFeedBase.StBusiInfoCommentListData();
        ((QQCircleFeedBase.StBusiInfoCommentListData)localObject1).comment.set(new FeedCloudMeta.StComment());
        ((QQCircleFeedBase.StBusiInfoCommentListData)localObject1).reply.set(new FeedCloudMeta.StReply());
        if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("commentid"))) {
          ((QQCircleFeedBase.StBusiInfoCommentListData)localObject1).comment.id.set((String)paramHashMap.get("commentid"));
        }
        if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("commentposterid")))
        {
          ((QQCircleFeedBase.StBusiInfoCommentListData)localObject1).comment.postUser.set(new FeedCloudMeta.StUser());
          ((QQCircleFeedBase.StBusiInfoCommentListData)localObject1).comment.postUser.id.set((String)paramHashMap.get("commentposterid"));
        }
        if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("replyid"))) {
          ((QQCircleFeedBase.StBusiInfoCommentListData)localObject1).reply.id.set((String)paramHashMap.get("replyid"));
        }
        if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("replyposterid")))
        {
          ((QQCircleFeedBase.StBusiInfoCommentListData)localObject1).reply.postUser.set(new FeedCloudMeta.StUser());
          ((QQCircleFeedBase.StBusiInfoCommentListData)localObject1).reply.postUser.id.set((String)paramHashMap.get("replyposterid"));
        }
      }
      paramHashMap = new tqo();
      paramHashMap.a(localStFeed);
      if (localObject1 != null) {
        paramHashMap.a(((QQCircleFeedBase.StBusiInfoCommentListData)localObject1).toByteArray());
      }
      paramHashMap.a((ExtraTypeInfo)localObject2);
      paramHashMap = paramHashMap.a();
      paramHashMap.isSingleFeed = bool1;
      a(paramHashMap, localIntent);
      return;
    }
  }
  
  private static void e(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      Intent localIntent = new Intent();
      if (paramHashMap.containsKey("tabtype")) {
        localIntent.putExtra("key_first_show_tab", (String)paramHashMap.get("tabtype"));
      }
      String str2 = (String)paramHashMap.get("from");
      String str1;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (TextUtils.isDigitsOnly(str2)) {}
      }
      else
      {
        str1 = str2;
        if (!tym.b()) {
          str1 = "8";
        }
      }
      localIntent.putExtra("key_jump_from", str1);
      if (paramHashMap.containsKey("pushid")) {
        localIntent.putExtra("key_push_id", (String)paramHashMap.get("pushid"));
      }
      if (paramHashMap.containsKey("uin")) {
        localIntent.putExtra("key_to_uin", (String)paramHashMap.get("uin"));
      }
      if (paramHashMap.containsKey("invite_id"))
      {
        paramHashMap = (String)paramHashMap.get("invite_id");
        if (!TextUtils.isEmpty(paramHashMap)) {
          tym.a().a(paramHashMap);
        }
      }
      tqj.a().a();
      tpz.a().b();
      yfo.a("2002");
      yfo.a("2002", new txv(tqj.a().a()));
      paramHashMap = BaseApplicationImpl.getContext();
      localIntent.addFlags(268435456);
      localIntent.setClass(paramHashMap, QCircleFolderActivity.class);
      paramHashMap.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqs
 * JD-Core Version:    0.7.0.1
 */