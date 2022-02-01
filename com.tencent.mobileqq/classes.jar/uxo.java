import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleHippyBean;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.fragments.QCircleDataEditFragment;
import com.tencent.biz.qqcircle.fragments.QCircleLoadingFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePrivacySettingFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePrivateMessageSettingFragment;
import com.tencent.biz.qqcircle.fragments.QCircleSettingFragment;
import com.tencent.biz.qqcircle.fragments.QCircleTagPageFragment;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentDetailFragment;
import com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailFragment;
import com.tencent.biz.qqcircle.fragments.hybird.QCircleHybirdFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleAggregationActivityFragment;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.hippy.QCircleHippyFragment;
import com.tencent.biz.qqcircle.list.bizblocks.QCicleUserHomeFollowUserListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleLikeListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleMessageListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleSpecialFollowListBlock;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.part.list.base.PublicListFragment;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class uxo
{
  public static void a(Activity paramActivity, Bundle paramBundle, String paramString, int paramInt)
  {
    if (aauy.a("QCircleLauncher_launchQcirclePublishActiviy", 500L)) {
      return;
    }
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = aoqb.a(paramActivity);
    }
    if (!bool)
    {
      bglp.b(paramActivity);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("postUin", paramString);
    localIntent.putExtra("fromType", paramInt);
    localIntent.putExtra("publish_state_type", 2);
    if ((paramActivity != null) && (paramActivity.getIntent() != null))
    {
      localIntent.putExtra("key_scheme", paramActivity.getIntent().getStringExtra("key_scheme"));
      paramActivity.getIntent().putExtra("key_scheme", "");
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    blsb.a(paramActivity, localIntent);
  }
  
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
        b(paramHashMap);
        return;
      }
      if ("openmainpage".equals(paramString))
      {
        c(paramHashMap);
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
      d(paramHashMap);
      return;
    }
    if ("opendetail".equals(paramString))
    {
      a(paramHashMap);
      return;
    }
    if ("openfolder".equals(paramString))
    {
      e(paramHashMap);
      return;
    }
    if ("opennoticelist".equals(paramString))
    {
      a(paramHashMap, 0, null);
      return;
    }
    if ("opencamera".equals(paramString))
    {
      a(paramActivity, paramHashMap);
      return;
    }
    if ("openpublish".equals(paramString))
    {
      b(paramActivity, paramHashMap);
      return;
    }
    if ("openhippy".equals(paramString)) {
      a(paramActivity, paramHashMap);
    }
  }
  
  public static void a(Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    Intent localIntent = new Intent();
    if (paramHashMap != null)
    {
      String str = (String)paramHashMap.get("key_scheme");
      if (!TextUtils.isEmpty(str)) {
        localIntent.putExtra("key_scheme", str);
      }
    }
    a(localIntent, paramHashMap);
    if (!uwz.a().b()) {
      localIntent.putExtra("key_is_publish", true);
    }
    localIntent.putExtra("key_jump_from", "8");
    a(paramActivity, localIntent);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    if (aauy.a("QCircleLauncher_launchFolderPage", 500L)) {
      return;
    }
    uxf.a().a();
    uwz.a().b();
    zzk.a("2002");
    zzk.a("2006");
    zzk.a("2002", new vqj(uxf.a().a()));
    zzk.a("2006", new vql());
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
  
  public static void a(Context paramContext, QCircleHippyBean paramQCircleHippyBean)
  {
    if ((paramContext != null) && (paramQCircleHippyBean != null))
    {
      if (TextUtils.isEmpty(paramQCircleHippyBean.getModuleName())) {
        break label67;
      }
      if (QzoneConfig.getQQCircleTaskUseHippySwitch())
      {
        Intent localIntent = new Intent();
        paramQCircleHippyBean.setStartTime(System.currentTimeMillis());
        localIntent.putExtra("key_hippy_bean", paramQCircleHippyBean);
        PublicFragmentActivity.a(paramContext, localIntent, QCircleHippyFragment.class);
      }
    }
    else
    {
      return;
    }
    a(paramContext, paramQCircleHippyBean.getDefaultUrl());
    return;
    label67:
    a(paramContext, paramQCircleHippyBean.getDefaultUrl());
  }
  
  public static void a(Context paramContext, QCircleInitBean paramQCircleInitBean, Intent paramIntent)
  {
    if (aauy.a("QCircleLauncher_launchContentDetailPage", 500L)) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (paramQCircleInitBean.getTagInfo().has())
    {
      zzk.a("2005");
      zzk.a("2005", new vqp(paramQCircleInitBean, true));
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
    b(localIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, null, -1);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent)
  {
    a(paramContext, paramString, paramIntent, -1);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url:" + paramString);
    if (!uxn.a(paramString)) {
      QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url isEmpty or Invalid");
    }
    while (aauy.a("launchQCircleHybirdActivity:" + paramString, 1500L)) {
      return;
    }
    if (paramContext == null) {
      paramContext = BaseApplicationImpl.getContext();
    }
    for (;;)
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      if (paramString != null) {
        localIntent.putExtra("url", paramString);
      }
      vsl.a(localIntent, paramString);
      localIntent.putExtra("titleBarStyle", 4);
      localIntent.putExtra("titleStyle", vsl.a().a(paramContext, paramString));
      if (vsl.a(paramString))
      {
        localIntent.putExtra("fromOneCLickCLose", false);
        localIntent.setClass(BaseApplicationImpl.getContext(), QQTranslucentBrowserActivity.class);
      }
      for (;;)
      {
        localIntent.putExtra("fragment_class", QCircleHybirdFragment.class.getCanonicalName());
        if ((!(paramContext instanceof Activity)) || (paramInt == -1)) {
          break;
        }
        localIntent.putExtra("fragment_class", QCircleHybirdFragment.class.getCanonicalName());
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
        return;
        localIntent.putExtra("fromOneCLickCLose", true);
        localIntent.setClass(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
      }
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
  }
  
  private static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    if ((paramHashMap != null) && (paramHashMap.containsKey("module"))) {
      try
      {
        paramContext = (String)paramHashMap.get("module");
        String str = URLDecoder.decode((String)paramHashMap.get("url"));
        a((Context)localObject, new QCircleHippyBean().setModuleName(paramContext).setDefaultUrl(str));
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("QCircleLauncher", 1, "parseUrl:" + (String)paramHashMap.get("url") + " error:" + paramContext.getMessage());
        paramContext.printStackTrace();
        b(paramHashMap);
        return;
      }
    }
    QLog.e("QCircleLauncher", 1, "launchHippyPageByScheme error no module name!");
    b(paramHashMap);
  }
  
  public static void a(Intent paramIntent)
  {
    if (aauy.a("QCircleLauncher_launchAggregationPage", 500L)) {
      return;
    }
    paramIntent.addFlags(268435456);
    paramIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    paramIntent.putExtra("public_fragment_class", QCircleAggregationActivityFragment.class.getName());
    b(paramIntent);
  }
  
  public static void a(Intent paramIntent, ArrayList<String> paramArrayList, ArrayList paramArrayList1, QCircleInitBean paramQCircleInitBean)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", PublicListFragment.class.getName());
    localIntent.putExtra("public_list_block_class_array", paramArrayList);
    localIntent.putExtra("public_list_init_data", paramArrayList1);
    localIntent.putExtra("public_list_init_bean", paramQCircleInitBean);
    localIntent.addFlags(268435456);
    b(localIntent);
  }
  
  public static void a(Intent paramIntent, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      paramIntent.putExtra("key_attrs", paramHashMap);
      if (paramHashMap.containsKey("image"))
      {
        String[] arrayOfString = ((String)paramHashMap.get("image")).split(";");
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < arrayOfString.length)
        {
          localArrayList.add(arrayOfString[i]);
          i += 1;
        }
        paramIntent.putExtra("images", localArrayList);
      }
      if (paramHashMap.containsKey("content")) {
        paramIntent.putExtra("summary", (String)paramHashMap.get("content"));
      }
      if (!paramHashMap.containsKey("frompage")) {}
    }
    try
    {
      paramIntent.putExtra("fromType", Integer.parseInt((String)paramHashMap.get("frompage")));
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public static void a(QCircleInitBean paramQCircleInitBean)
  {
    if (paramQCircleInitBean == null) {}
    while (aauy.a("QCircleLauncher_launchContentDetailPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.addFlags(268435456);
    localIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    localIntent.putExtra("fling_action_key", 2);
    localIntent.putExtra("fling_code_key", new Object().hashCode());
    localIntent.putExtra("public_fragment_class", QCircleFeedDetailFragment.class.getName());
    b(localIntent);
  }
  
  public static void a(QCircleInitBean paramQCircleInitBean, Intent paramIntent)
  {
    if (aauy.a("QCircleLauncher_launchPersonalDetailPage", 500L)) {
      return;
    }
    Object localObject = paramQCircleInitBean.getUser().id.get();
    zzk.a("2001" + (String)localObject);
    zzk.a("2001" + (String)localObject, new vqn((String)localObject));
    localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    ((Intent)localObject).putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    ((Intent)localObject).putExtra("public_fragment_class", QCirclePersonalDetailFragment.class.getName());
    b((Intent)localObject);
  }
  
  public static void a(QCircleReportBean paramQCircleReportBean)
  {
    if (aauy.a("QCircleLauncher_launchSpecialFollowListPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleSpecialFollowListBlock.class.getName());
    a(localIntent, localArrayList, null, new uxk().a(paramQCircleReportBean).a());
  }
  
  public static void a(FeedCloudMeta.StFeed paramStFeed, int paramInt, String paramString, QCircleReportBean paramQCircleReportBean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("StFeed", paramStFeed.toByteArray());
    localIntent.putExtra("requestType", paramInt);
    localIntent.putExtra("likeKey", paramString);
    paramStFeed = new ArrayList();
    paramStFeed.add(QCircleLikeListBlock.class.getName());
    a(localIntent, paramStFeed, null, new uxk().a(paramQCircleReportBean).a());
  }
  
  public static void a(FeedCloudMeta.StUser paramStUser)
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCicleUserHomeFollowUserListBlock.class.getName());
    a(localIntent, localArrayList, null, new uxk().a(paramStUser).a());
  }
  
  public static void a(FeedCloudMeta.StUser paramStUser, QCircleReportBean paramQCircleReportBean)
  {
    uxk localuxk = new uxk();
    localuxk.a(paramQCircleReportBean);
    a(localuxk.a(paramStUser).a(), null);
  }
  
  public static void a(String paramString)
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUserListBlock.class.getName());
    a(localIntent, localArrayList, null, new uxk().a(paramString).a());
  }
  
  public static void a(String paramString, Intent paramIntent)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    a(new uxk().a(str).a(), paramIntent);
  }
  
  public static void a(String paramString, QCircleReportBean paramQCircleReportBean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    paramString = new uxk();
    paramString.a(paramQCircleReportBean);
    a(paramString.a(str).a(), null);
  }
  
  public static void a(String paramString1, String paramString2, QCircleReportBean paramQCircleReportBean)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("QCircleLauncher", 1, "launchTagPage error tagId or tagName is Empty");
      return;
    }
    uxk localuxk = new uxk();
    localuxk.a(paramQCircleReportBean);
    c(localuxk.a(paramString1, paramString2).a(), null);
  }
  
  public static void a(HashMap<String, String> paramHashMap)
  {
    Object localObject1;
    Object localObject4;
    Object localObject2;
    if (paramHashMap != null)
    {
      localObject1 = "";
      localObject4 = new FeedCloudMeta.StFeed();
      if (paramHashMap.containsKey("feedid")) {
        ((FeedCloudMeta.StFeed)localObject4).id.set((String)paramHashMap.get("feedid"));
      }
      if (paramHashMap.containsKey("createtime")) {
        ((FeedCloudMeta.StFeed)localObject4).createTime.set(Long.parseLong((String)paramHashMap.get("createtime")));
      }
      if (paramHashMap.containsKey("uin"))
      {
        localObject2 = new FeedCloudMeta.StUser();
        ((FeedCloudMeta.StUser)localObject2).id.set((String)paramHashMap.get("uin"));
        ((FeedCloudMeta.StFeed)localObject4).poster.set((MessageMicro)localObject2);
      }
      if (!paramHashMap.containsKey("sourcetype")) {
        break label808;
      }
    }
    label808:
    for (int j = Integer.valueOf((String)paramHashMap.get("sourcetype")).intValue();; j = 0)
    {
      boolean bool;
      if (paramHashMap.containsKey("issinglefeed")) {
        if (Integer.valueOf((String)paramHashMap.get("issinglefeed")).intValue() == 1) {
          bool = true;
        }
      }
      for (;;)
      {
        int i;
        if (paramHashMap.containsKey("istag")) {
          if (Integer.valueOf((String)paramHashMap.get("istag")).intValue() == 1) {
            i = 1;
          }
        }
        for (;;)
        {
          if (paramHashMap.containsKey("tagname")) {
            localObject1 = (String)paramHashMap.get("tagname");
          }
          Intent localIntent = new Intent();
          Object localObject3 = (String)paramHashMap.get("from");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject2 = localObject3;
            if (TextUtils.isDigitsOnly((CharSequence)localObject3)) {}
          }
          else
          {
            localObject2 = localObject3;
            if (!vri.b()) {
              localObject2 = "8";
            }
          }
          localIntent.putExtra("key_jump_from", (String)localObject2);
          if (paramHashMap.containsKey("pushid")) {
            localIntent.putExtra("key_push_id", (String)paramHashMap.get("pushid"));
          }
          localObject3 = new ExtraTypeInfo();
          ((ExtraTypeInfo)localObject3).sourceType = j;
          localObject2 = null;
          if ((paramHashMap.containsKey("commentid")) || (paramHashMap.containsKey("replyid")) || (paramHashMap.containsKey("commentposterid")) || (paramHashMap.containsKey("replyposterid")))
          {
            localObject2 = new QQCircleFeedBase.StBusiInfoCommentListData();
            ((QQCircleFeedBase.StBusiInfoCommentListData)localObject2).comment.set(new FeedCloudMeta.StComment());
            ((QQCircleFeedBase.StBusiInfoCommentListData)localObject2).reply.set(new FeedCloudMeta.StReply());
            if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("commentid"))) {
              ((QQCircleFeedBase.StBusiInfoCommentListData)localObject2).comment.id.set((String)paramHashMap.get("commentid"));
            }
            if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("commentposterid")))
            {
              ((QQCircleFeedBase.StBusiInfoCommentListData)localObject2).comment.postUser.set(new FeedCloudMeta.StUser());
              ((QQCircleFeedBase.StBusiInfoCommentListData)localObject2).comment.postUser.id.set((String)paramHashMap.get("commentposterid"));
            }
            if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("replyid"))) {
              ((QQCircleFeedBase.StBusiInfoCommentListData)localObject2).reply.id.set((String)paramHashMap.get("replyid"));
            }
            if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("replyposterid")))
            {
              ((QQCircleFeedBase.StBusiInfoCommentListData)localObject2).reply.postUser.set(new FeedCloudMeta.StUser());
              ((QQCircleFeedBase.StBusiInfoCommentListData)localObject2).reply.postUser.id.set((String)paramHashMap.get("replyposterid"));
            }
          }
          uxk localuxk = new uxk();
          localuxk.a((FeedCloudMeta.StFeed)localObject4);
          if ((i != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject4 = new FeedCloudMeta.StTagInfo();
            ((FeedCloudMeta.StTagInfo)localObject4).tagName.set((String)localObject1);
            localuxk.a((FeedCloudMeta.StTagInfo)localObject4);
          }
          if (localObject2 != null) {
            localuxk.a(((QQCircleFeedBase.StBusiInfoCommentListData)localObject2).toByteArray());
          }
          localuxk.a((ExtraTypeInfo)localObject3);
          localObject1 = localuxk.a();
          ((QCircleInitBean)localObject1).isSingleFeed = bool;
          if ((paramHashMap.containsKey("is_feed_detail")) && ("1".equals(paramHashMap.get("is_feed_detail"))))
          {
            ((QCircleInitBean)localObject1).isSingleFeed = false;
            if ((paramHashMap.containsKey("without_recom")) && ("1".equals(paramHashMap.get("without_recom")))) {
              ((QCircleInitBean)localObject1).isSingleFeed = true;
            }
            a((QCircleInitBean)localObject1);
            return;
            bool = false;
            break;
            i = 0;
            continue;
          }
          b((QCircleInitBean)localObject1, localIntent);
          return;
          i = 0;
        }
        bool = false;
      }
    }
  }
  
  public static void a(HashMap<String, String> paramHashMap, int paramInt, QCircleReportBean paramQCircleReportBean)
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
        if (!vri.b()) {
          str1 = "8";
        }
      }
      localIntent.putExtra("key_jump_from", str1);
      if (paramHashMap.containsKey("pushid")) {
        localIntent.putExtra("key_push_id", (String)paramHashMap.get("pushid"));
      }
      if (paramHashMap.containsKey("to")) {
        paramHashMap = (String)paramHashMap.get("to");
      }
    }
    try
    {
      if (!TextUtils.isEmpty(paramHashMap)) {
        localIntent.putExtra("public_list_select_block_index", Integer.parseInt(paramHashMap));
      }
      localIntent.putExtra("key_page_id", 59);
      localIntent.putExtra("key_from_page_id", paramInt);
      paramHashMap = new ArrayList();
      paramHashMap.add(QCircleMessageListBlock.class.getName());
      paramHashMap.add(QCircleChatListBlock.class.getName());
      a(localIntent, paramHashMap, null, new uxk().a(paramQCircleReportBean).a());
      bmep.b();
      return;
    }
    catch (NumberFormatException paramHashMap)
    {
      for (;;)
      {
        QLog.d("QCircleLauncher", 1, "launchMessageNoticePage parseNumError:" + paramHashMap.getMessage());
      }
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, QCircleReportBean paramQCircleReportBean)
  {
    if (aauy.a("QCircleLauncher_launchSettingPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_support_mainpage_to_personalcard", paramBoolean1);
    localIntent.putExtra("key_bundle_support_new_msg_sync_to_troop", paramBoolean2);
    localIntent.putExtra("public_fragment_class", QCircleSettingFragment.class.getName());
    localIntent.putExtra("fling_action_key", 2);
    localIntent.putExtra("fling_code_key", new Object().hashCode());
    localIntent.putExtra("key_bundle_common_init_bean", new uxk().a(paramQCircleReportBean).a());
    b(localIntent);
  }
  
  public static void b(Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramHashMap);
    uwz.a().b();
    paramHashMap = new Bundle();
    paramHashMap.putLong("PhotoConst.timestamp", System.currentTimeMillis());
    paramHashMap.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
    paramHashMap.putInt("key_qcircle_entrance_type", 3);
    paramHashMap.putBoolean("key_is_take_photo", false);
    paramHashMap.putBoolean("key_qcircle_publish_finish_jump_to_mainpage", true);
    localIntent.putExtra("key_enable_splash", false);
    localIntent.putExtras(paramHashMap);
    localIntent.addFlags(268435456);
    PublicTransFragmentActivity.b(paramActivity, localIntent, QCircleLoadingFragment.class);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    int i = uxx.a(paramString);
    if (i == 0) {
      a(paramContext, paramString);
    }
    while (i != 1) {
      return;
    }
    Intent localIntent = new Intent(paramContext, JumpActivity.class);
    localIntent.setData(Uri.parse(paramString));
    paramContext.startActivity(localIntent);
  }
  
  private static void b(Intent paramIntent)
  {
    paramIntent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
    BaseApplicationImpl.getContext().startActivity(paramIntent);
  }
  
  public static void b(QCircleInitBean paramQCircleInitBean)
  {
    if (aauy.a("QCircleLauncher_launchDataEditPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.putExtra("public_fragment_class", QCircleDataEditFragment.class.getName());
    b(localIntent);
  }
  
  private static void b(QCircleInitBean paramQCircleInitBean, Intent paramIntent)
  {
    if (aauy.a("QCircleLauncher_launchContentDetailPage", 500L)) {
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
    b(localIntent);
  }
  
  public static void b(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.containsKey("url"))) {
      try
      {
        Object localObject = URLDecoder.decode((String)paramHashMap.get("url"));
        if (((String)localObject).startsWith("https://h5.qzone.qq.com/v2/wezone/message"))
        {
          localObject = uxn.a((String)localObject);
          ((HashMap)localObject).put("from", String.valueOf(7));
          a((HashMap)localObject, 0, null);
          return;
        }
        a(BaseApplicationImpl.getContext(), (String)localObject);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("QCircleLauncher", 1, "parseUrl:" + (String)paramHashMap.get("url") + " error:" + localException.getMessage());
        localException.printStackTrace();
      }
    }
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, QCircleReportBean paramQCircleReportBean)
  {
    if (aauy.a("QCircleLauncher_launchPrivacySettingPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_support_mainpage_to_personalcard", paramBoolean1);
    localIntent.putExtra("key_bundle_support_new_msg_sync_to_troop", paramBoolean2);
    localIntent.putExtra("fling_action_key", 2);
    localIntent.putExtra("fling_code_key", new Object().hashCode());
    localIntent.putExtra("public_fragment_class", QCirclePrivacySettingFragment.class.getName());
    localIntent.putExtra("key_bundle_common_init_bean", new uxk().a(paramQCircleReportBean).a());
    b(localIntent);
  }
  
  public static void c(QCircleInitBean paramQCircleInitBean)
  {
    if (aauy.a("QCircleLauncher_launchDataEditPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.putExtra("public_fragment_class", QCirclePrivateMessageSettingFragment.class.getName());
    b(localIntent);
  }
  
  private static void c(QCircleInitBean paramQCircleInitBean, Intent paramIntent)
  {
    if (aauy.a("QCircleLauncher_launchTagPage", 500L)) {
      return;
    }
    zzk.a("2005");
    zzk.a("2005", new vqp(paramQCircleInitBean, false));
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.putExtra("public_fragment_class", QCircleTagPageFragment.class.getName());
    b(localIntent);
  }
  
  private static void c(HashMap<String, String> paramHashMap)
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
        if (!vri.b()) {
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
        a(new uxk().a(paramHashMap).a(), localIntent);
      }
    }
  }
  
  private static void d(HashMap<String, String> paramHashMap)
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
        if (!vri.b()) {
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
          break label152;
        }
        QLog.e("QCircleLauncher", 1, "launchTagPage error tagId and tagName all Empty");
      }
    }
    return;
    label152:
    c(new uxk().a(str1, paramHashMap).a(), localIntent);
  }
  
  private static void e(HashMap<String, String> paramHashMap)
  {
    if (aauy.a("QCircleLauncher_launchFolderPageBySchema", 500L)) {}
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
      if (!vri.b()) {
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
      vri.a().b(str1);
      localIntent.putExtra("key_to_uin", str1);
    }
    if (paramHashMap.containsKey("invite_id"))
    {
      paramHashMap = (String)paramHashMap.get("invite_id");
      vri.a().a(paramHashMap);
      localIntent.putExtra("key_enable_splash", true);
    }
    for (;;)
    {
      uxf.a().a();
      uwz.a().b();
      zzk.a("2002");
      zzk.a("2002", new vqj(uxf.a().a()));
      zzk.a("2006");
      zzk.a("2006", new vql());
      paramHashMap = BaseApplicationImpl.getContext();
      localIntent.addFlags(268435456);
      localIntent.setClass(paramHashMap, QCircleFolderActivity.class);
      paramHashMap.startActivity(localIntent);
      return;
      vri.a().a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxo
 * JD-Core Version:    0.7.0.1
 */