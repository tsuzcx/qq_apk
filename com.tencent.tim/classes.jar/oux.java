import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.QCircleInitBean.a;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.fragments.QCircleHybirdFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.fragments.QCircleTagPageFragment;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentDetailFragment;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowTagListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleMessageListBlock;
import com.tencent.biz.richframework.part.list.base.PublicListFragment;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
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
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class oux
{
  public static void a(Activity paramActivity, String paramString, HashMap<String, String> paramHashMap)
  {
    try
    {
      QLog.d("QCircleLauncher", 1, "launchQCircleByScheme actionName" + paramString);
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if ("openwebview".equals(paramString))
      {
        r(paramHashMap);
        return;
      }
      if ("openmainpage".equals(paramString))
      {
        n(paramHashMap);
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
      o(paramHashMap);
      return;
    }
    if ("opendetail".equals(paramString))
    {
      p(paramHashMap);
      return;
    }
    if ("openfolder".equals(paramString))
    {
      q(paramHashMap);
      return;
    }
    if ("opennoticelist".equals(paramString))
    {
      s(paramHashMap);
      return;
    }
    if ("opencamera".equals(paramString)) {
      b(paramActivity, paramHashMap);
    }
  }
  
  public static void a(Context paramContext, QCircleInitBean paramQCircleInitBean, Intent paramIntent)
  {
    if (sox.i("QCircleLauncher_launchContentDetailPage", 500L)) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
      localIntent.addFlags(268435456);
      localIntent.setClass(BaseApplicationImpl.getContext(), PublicTransFragmentActivity.class);
      localIntent.putExtra("public_fragment_class", QCircleContentDetailFragment.class.getName());
      localIntent.putExtra("public_fragment_window_feature", 1);
      paramContext.startActivity(localIntent);
      paramContext.overridePendingTransition(0, 0);
      return;
    }
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.addFlags(268435456);
    localIntent.setClass(BaseApplicationImpl.getContext(), PublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", QCircleContentDetailFragment.class.getName());
    localIntent.putExtra("public_fragment_window_feature", 1);
    aW(localIntent);
  }
  
  public static void a(Intent paramIntent, String paramString, ArrayList paramArrayList, QCircleInitBean paramQCircleInitBean)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", PublicListFragment.class.getName());
    localIntent.putExtra("base_list_block_class", paramString);
    localIntent.putExtra("base_list_init_data", paramArrayList);
    localIntent.putExtra("base_list_init_bean", paramQCircleInitBean);
    localIntent.putExtra("fling_action_key", 2);
    localIntent.putExtra("fling_code_key", new Object().hashCode());
    localIntent.addFlags(268435456);
    aW(localIntent);
  }
  
  private static void a(QCircleInitBean paramQCircleInitBean, Intent paramIntent)
  {
    if (sox.i("QCircleLauncher_launchContentDetailPage", 500L)) {
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
    aW(localIntent);
  }
  
  public static void a(FeedCloudMeta.StUser paramStUser)
  {
    b(new QCircleInitBean.a().a(paramStUser).a(), null);
  }
  
  private static void aW(Intent paramIntent)
  {
    paramIntent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
    BaseApplicationImpl.getContext().startActivity(paramIntent);
  }
  
  public static void aX(Context paramContext, String paramString)
  {
    b(paramContext, paramString, null);
  }
  
  public static void aY(Context paramContext, String paramString)
  {
    int i = ovd.aY(paramString);
    if (i == 0) {
      aX(paramContext, paramString);
    }
    while (i != 1) {
      return;
    }
    Intent localIntent = new Intent(paramContext, JumpActivity.class);
    localIntent.setData(Uri.parse(paramString));
    paramContext.startActivity(localIntent);
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, String paramString, int paramInt)
  {
    if (sox.i("QCircleLauncher_launchQcirclePublishActiviy", 500L)) {
      return;
    }
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = aczy.bd(paramActivity);
    }
    if (!bool)
    {
      aqha.b(paramActivity);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("postUin", paramString);
    localIntent.putExtra("fromType", paramInt);
    localIntent.putExtra("publish_state_type", 2);
    if ((paramActivity != null) && (paramActivity.getIntent() != null)) {
      localIntent.putExtra("key_scheme", paramActivity.getIntent().getStringExtra("key_scheme"));
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    avpw.U(paramActivity, localIntent);
  }
  
  public static void b(Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    Intent localIntent = new Intent();
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("key_scheme");
      if (!TextUtils.isEmpty(paramHashMap)) {
        localIntent.putExtra("key_scheme", paramHashMap);
      }
    }
    if (!oue.a().Hu()) {
      localIntent.putExtra("key_is_publish", true);
    }
    localIntent.putExtra("key_jump_from", "8");
    u(paramActivity, localIntent);
  }
  
  public static void b(Context paramContext, String paramString, Intent paramIntent)
  {
    QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url:" + paramString);
    if (!ouw.eK(paramString)) {
      QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url isEmpty or Invalid");
    }
    while (sox.i("launchQCircleHybirdActivity:" + paramString, 1500L)) {
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
    pdi.g(paramContext, paramString);
    paramContext.putExtra("titleBarStyle", 4);
    paramContext.putExtra("titleStyle", pdi.a().a((Context)localObject, paramString));
    paramContext.setClass(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    paramContext.putExtra("fragment_class", QCircleHybirdFragment.class.getCanonicalName());
    paramContext.addFlags(268435456);
    ((Context)localObject).startActivity(paramContext);
  }
  
  public static void b(QCircleInitBean paramQCircleInitBean, Intent paramIntent)
  {
    if (sox.i("QCircleLauncher_launchPersonalDetailPage", 500L)) {
      return;
    }
    Object localObject = paramQCircleInitBean.getUser().id.get();
    ryo.remove("2001" + (String)localObject);
    ryo.a("2001" + (String)localObject, new pce((String)localObject));
    localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    ((Intent)localObject).putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    ((Intent)localObject).putExtra("public_fragment_class", QCirclePersonalDetailFragment.class.getName());
    aW((Intent)localObject);
  }
  
  private static void c(QCircleInitBean paramQCircleInitBean, Intent paramIntent)
  {
    if (sox.i("QCircleLauncher_launchTagPage", 500L)) {
      return;
    }
    ryo.remove("2005");
    ryo.a("2005", new pcg(paramQCircleInitBean));
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.putExtra("public_fragment_class", QCircleTagPageFragment.class.getName());
    aW(localIntent);
  }
  
  public static void ce(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("QCircleLauncher", 1, "launchTagPage error tagId or tagName is Empty");
      return;
    }
    c(new QCircleInitBean.a().a(paramString1, paramString2).a(), null);
  }
  
  public static void e(String paramString, Intent paramIntent)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    b(new QCircleInitBean.a().a(str).a(), paramIntent);
  }
  
  private static void n(HashMap<String, String> paramHashMap)
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
        if (!pcr.HN()) {
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
        b(new QCircleInitBean.a().a(paramHashMap).a(), localIntent);
      }
    }
  }
  
  private static void o(HashMap<String, String> paramHashMap)
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
        if (!pcr.HN()) {
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
    c(new QCircleInitBean.a().a(str1, paramHashMap).a(), localIntent);
  }
  
  public static void p(HashMap<String, String> paramHashMap)
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
        if (!pcr.HN()) {
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
      paramHashMap = new QCircleInitBean.a();
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
  
  private static void q(HashMap<String, String> paramHashMap)
  {
    if (sox.i("QCircleLauncher_launchFolderPageBySchema", 500L)) {}
    while (paramHashMap == null) {
      return;
    }
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
      if (!pcr.HN()) {
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
      if (!TextUtils.isEmpty(paramHashMap))
      {
        pcr.a().qz(paramHashMap);
        localIntent.putExtra("key_enable_splash", true);
      }
    }
    ouq.a().bhM();
    oue.a().bhz();
    ryo.remove("2002");
    ryo.a("2002", new pca(ouq.a().a()));
    ryo.remove("2006");
    ryo.a("2006", new pcc());
    paramHashMap = BaseApplicationImpl.getContext();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramHashMap, QCircleFolderActivity.class);
    paramHashMap.startActivity(localIntent);
  }
  
  public static void qm(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    b(new QCircleInitBean.a().a(str).a(), null);
  }
  
  public static void qn(String paramString)
  {
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    localExtraTypeInfo.userId = paramString;
    paramString = new QCircleInitBean.a();
    paramString.a(localExtraTypeInfo);
    a(null, QCircleFollowTagListBlock.class.getName(), null, paramString.a());
  }
  
  public static void r(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.containsKey("url"))) {
      try
      {
        Object localObject = URLDecoder.decode((String)paramHashMap.get("url"));
        if (((String)localObject).startsWith("https://h5.qzone.qq.com/v2/wezone/message"))
        {
          localObject = ouw.j((String)localObject);
          ((HashMap)localObject).put("from", String.valueOf(7));
          s((HashMap)localObject);
          return;
        }
        aX(BaseApplicationImpl.getContext(), (String)localObject);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("QCircleLauncher", 1, "parseUrl:" + (String)paramHashMap.get("url") + " error:" + localException.getMessage());
        localException.printStackTrace();
      }
    }
  }
  
  public static void s(HashMap<String, String> paramHashMap)
  {
    Intent localIntent = new Intent();
    if (paramHashMap != null)
    {
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
        if (!pcr.HN()) {
          str1 = "8";
        }
      }
      localIntent.putExtra("key_jump_from", str1);
      if (paramHashMap.containsKey("pushid")) {
        localIntent.putExtra("key_push_id", (String)paramHashMap.get("pushid"));
      }
    }
    a(localIntent, QCircleMessageListBlock.class.getName(), null, null);
  }
  
  public static void u(Context paramContext, Intent paramIntent)
  {
    if (sox.i("QCircleLauncher_launchFolderPage", 500L)) {
      return;
    }
    ouq.a().bhM();
    oue.a().bhz();
    ryo.remove("2002");
    ryo.remove("2006");
    ryo.a("2002", new pca(ouq.a().a()));
    ryo.a("2006", new pcc());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oux
 * JD-Core Version:    0.7.0.1
 */