import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleHippyBean;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.fragments.QCircleDataEditFragment;
import com.tencent.biz.qqcircle.fragments.QCircleLoadingFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePrivacySettingFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePrivateMessageSettingFragment;
import com.tencent.biz.qqcircle.fragments.QCircleSettingFragment;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentDetailFragment;
import com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailFragment;
import com.tencent.biz.qqcircle.fragments.hybird.QCircleHybirdFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleAggregationActivityFragment;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.hippy.QCircleHippyFragment;
import com.tencent.biz.qqcircle.launchbean.QCircleAggregationBean;
import com.tencent.biz.qqcircle.launchbean.QCircleFolderBean;
import com.tencent.biz.qqcircle.launchbean.QCircleFollowUserBean;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleLayerBean;
import com.tencent.biz.qqcircle.launchbean.QCircleLikeBean;
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.launchbean.QCircleSettingBean;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleBlackListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleLikeListBlock;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleMessageListBlock;
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
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.String;>;
import mqq.app.AppRuntime;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class uyx
{
  private static void a(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null)
    {
      QLog.e("QCircleLauncher", 1, "context is null,cannot start activity");
      return;
    }
    paramIntent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, String paramString, int paramInt)
  {
    if (aazb.a("QCircleLauncher_launchQcirclePublishActiviy", 500L)) {
      return;
    }
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = apdr.a(paramContext);
    }
    if ((!bool) && ((paramContext instanceof Activity)))
    {
      bhlq.b((Activity)paramContext);
      return;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("postUin", paramString);
    localBundle.putInt("fromType", paramInt);
    localBundle.putInt("publish_state_type", 2);
    localIntent.putExtras(localBundle);
    bmtd.a(paramContext, localIntent);
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
    a(paramContext, paramQCircleHippyBean.getDefaultUrl(), null, -1);
    return;
    label67:
    a(paramContext, paramQCircleHippyBean.getDefaultUrl(), null, -1);
  }
  
  public static void a(Context paramContext, QCircleAggregationBean paramQCircleAggregationBean)
  {
    if (aazb.a("QCircleLauncher_launchAggregationPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleAggregationBean);
    localIntent.putExtra("public_fragment_class", QCircleAggregationActivityFragment.class.getName());
    a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, QCircleFolderBean paramQCircleFolderBean)
  {
    if (aazb.a("QCircleLauncher_launchFolderPage", 500L)) {
      return;
    }
    uyq.a().a();
    uyk.a().b();
    aadg.a("2002");
    aadg.a("2006");
    aadg.a("2002", new vss(uyq.a().a()));
    aadg.a("2006", new vsu());
    Intent localIntent = new Intent();
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    if (paramQCircleFolderBean.getAttrs() != null) {
      a(localIntent, paramQCircleFolderBean.getAttrs());
    }
    localIntent.addFlags(268435456);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleFolderBean);
    localIntent.setClass((Context)localObject, QCircleFolderActivity.class);
    ((Context)localObject).startActivity(localIntent);
  }
  
  public static void a(Context paramContext, QCircleFollowUserBean paramQCircleFollowUserBean)
  {
    if (aazb.a("QCircleLauncher_launchSpecialFollowListPage", 500L)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramQCircleFollowUserBean.getAdapterClassName());
    a(paramContext, localArrayList, null, paramQCircleFollowUserBean);
  }
  
  public static void a(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    if (paramQCircleInitBean == null) {}
    while (aazb.a("QCircleLauncher_launchContentDetailPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("fling_action_key", 2);
    localIntent.putExtra("fling_code_key", new Object().hashCode());
    localIntent.putExtra("public_fragment_class", QCircleFeedDetailFragment.class.getName());
    a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, QCircleLayerBean paramQCircleLayerBean)
  {
    if (aazb.a("QCircleLauncher_launchContentDetailPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    if (paramQCircleLayerBean.getTagInfo().has())
    {
      aadg.a("2005");
      aadg.a("2005", new vta(paramQCircleLayerBean, true));
    }
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      localIntent.putExtra("key_bundle_common_init_bean", paramQCircleLayerBean);
      localIntent.addFlags(268435456);
      localIntent.setClass(paramContext, PublicTransFragmentActivity.class);
      localIntent.putExtra("public_fragment_class", QCircleContentDetailFragment.class.getName());
      localIntent.putExtra("public_fragment_window_feature", 1);
      localActivity.startActivity(localIntent);
      localActivity.overridePendingTransition(0, 0);
      return;
    }
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleLayerBean);
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, PublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", QCircleContentDetailFragment.class.getName());
    localIntent.putExtra("public_fragment_window_feature", 1);
    a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, QCircleLikeBean paramQCircleLikeBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleLikeListBlock.class.getName());
    a(paramContext, localArrayList, null, paramQCircleLikeBean);
  }
  
  public static void a(Context paramContext, QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    if (aazb.a("QCircleLauncher_launchPolymerizationPage", 500L)) {
      return;
    }
    aadg.a("2008");
    aadg.a("2008", new vsy(paramQCirclePolymerizationBean));
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(BaseApplicationImpl.getContext(), QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCirclePolymerizationBean);
    localIntent.putExtra("public_fragment_class", QCirclePolymerizationFragment.class.getName());
    a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, QCircleSettingBean paramQCircleSettingBean)
  {
    if (aazb.a("QCircleLauncher_launchSettingPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", QCircleSettingFragment.class.getName());
    localIntent.putExtra("fling_action_key", 2);
    localIntent.putExtra("fling_code_key", new Object().hashCode());
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleSettingBean);
    a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    int i = uzg.a(paramString);
    if (i == 0) {
      a(paramContext, paramString, null, -1);
    }
    while (i != 1) {
      return;
    }
    Intent localIntent = new Intent(paramContext, JumpActivity.class);
    localIntent.setData(Uri.parse(paramString));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url:" + paramString);
    if (!uyw.a(paramString)) {
      QLog.i("QCircleLauncher", 1, "launchQCircleHybirdActivity url isEmpty or Invalid");
    }
    while (aazb.a("launchQCircleHybirdActivity:" + paramString, 1500L)) {
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
      vvf.a(localIntent, paramString);
      localIntent.putExtra("titleBarStyle", 4);
      localIntent.putExtra("titleStyle", vvf.a().a(paramContext, paramString));
      if (vvf.a(paramString))
      {
        localIntent.putExtra("fromOneCLickCLose", false);
        localIntent.setClass(paramContext, QQTranslucentBrowserActivity.class);
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
        localIntent.setClass(paramContext, QQBrowserActivity.class);
      }
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    try
    {
      QLog.d("QCircleLauncher", 1, "launchQCircleByScheme actionName" + paramString);
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if ("openwebview".equals(paramString))
      {
        e(paramContext, paramHashMap);
        return;
      }
      if ("openmainpage".equals(paramString))
      {
        b(paramContext, paramHashMap);
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if ("opentag".equals(paramString))
    {
      paramHashMap.put("sourcetype", String.valueOf(7));
      g(paramContext, paramHashMap);
      return;
    }
    if ("opendetail".equals(paramString))
    {
      c(paramContext, paramHashMap);
      return;
    }
    if ("openfolder".equals(paramString))
    {
      d(paramContext, paramHashMap);
      return;
    }
    if ("opennoticelist".equals(paramString))
    {
      a(paramContext, paramHashMap);
      return;
    }
    if ("opencamera".equals(paramString))
    {
      h(paramContext, paramHashMap);
      return;
    }
    if ("openpublish".equals(paramString))
    {
      i(paramContext, paramHashMap);
      return;
    }
    if ("openhippy".equals(paramString))
    {
      f(paramContext, paramHashMap);
      return;
    }
    if ("openpolymerize".equals(paramString)) {
      g(paramContext, paramHashMap);
    }
  }
  
  private static void a(Context paramContext, ArrayList<String> paramArrayList, ArrayList paramArrayList1, QCircleInitBean paramQCircleInitBean)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", PublicListFragment.class.getName());
    localIntent.putExtra("public_list_block_class_array", paramArrayList);
    localIntent.putExtra("public_list_init_data", paramArrayList1);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.addFlags(268435456);
    a(paramContext, localIntent);
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
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
        if (!vtt.b()) {
          str1 = "8";
        }
      }
      localQCircleInitBean.setLaunchFrom(str1);
      if (paramHashMap.containsKey("pushid")) {
        localQCircleInitBean.setLaunchId((String)paramHashMap.get("pushid"));
      }
      if (paramHashMap.containsKey("to")) {
        paramHashMap = (String)paramHashMap.get("to");
      }
    }
    try
    {
      if (!TextUtils.isEmpty(paramHashMap)) {
        localQCircleInitBean.setLaunchTo(Integer.parseInt(paramHashMap));
      }
      f(paramContext, localQCircleInitBean);
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
  
  private static void a(Intent paramIntent, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      paramIntent.putExtra("key_attrs", paramHashMap);
      Object localObject = (String)paramHashMap.get("key_scheme");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramIntent.putExtra("key_scheme", (String)localObject);
      }
      if (paramHashMap.containsKey("image"))
      {
        localObject = ((String)paramHashMap.get("image")).split(";");
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localObject.length)
        {
          localArrayList.add(localObject[i]);
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
  
  public static void b(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    if (aazb.a("QCircleLauncher_launchPersonalDetailPage", 500L)) {
      return;
    }
    String str = paramQCircleInitBean.getUser().id.get();
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramQCircleInitBean.getUser().id.set((String)localObject);
    }
    aadg.a("2001" + (String)localObject);
    aadg.a("2001" + (String)localObject, new vsw((String)localObject));
    localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setClass(paramContext, QCircleFragmentActivity.class);
    ((Intent)localObject).putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    ((Intent)localObject).putExtra("public_fragment_class", QCirclePersonalDetailFragment.class.getName());
    a(paramContext, (Intent)localObject);
  }
  
  private static void b(Context paramContext, QCircleLayerBean paramQCircleLayerBean)
  {
    if (aazb.a("QCircleLauncher_launchContentDetailPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    if (paramQCircleLayerBean.getTagInfo().has())
    {
      aadg.a("2005");
      aadg.a("2005", new vta(paramQCircleLayerBean, true));
    }
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleLayerBean);
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", QCircleContentDetailFragment.class.getName());
    a(paramContext, localIntent);
  }
  
  public static void b(Context paramContext, QCircleSettingBean paramQCircleSettingBean)
  {
    if (aazb.a("QCircleLauncher_launchPrivacySettingPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("fling_action_key", 2);
    localIntent.putExtra("fling_code_key", new Object().hashCode());
    localIntent.putExtra("public_fragment_class", QCirclePrivacySettingFragment.class.getName());
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleSettingBean);
    a(paramContext, localIntent);
  }
  
  private static void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      QCircleInitBean localQCircleInitBean = new QCircleInitBean();
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
        if (!vtt.b()) {
          str1 = "8";
        }
      }
      localQCircleInitBean.setLaunchFrom(str1);
      if (paramHashMap.containsKey("pushid")) {
        localQCircleInitBean.setLaunchId((String)paramHashMap.get("pushid"));
      }
      if (paramHashMap.containsKey("uin"))
      {
        str1 = (String)paramHashMap.get("uin");
        paramHashMap = str1;
        if (TextUtils.isEmpty(str1)) {
          paramHashMap = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        }
        localQCircleInitBean.setUin(paramHashMap);
        b(paramContext, localQCircleInitBean);
      }
    }
  }
  
  public static void c(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    if (aazb.a("QCircleLauncher_launchDataEditPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.putExtra("public_fragment_class", QCircleDataEditFragment.class.getName());
    a(paramContext, localIntent);
  }
  
  private static void c(Context paramContext, HashMap<String, String> paramHashMap)
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
        break label865;
      }
    }
    label865:
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
          if ((paramHashMap.containsKey("istopfeed")) && (Integer.valueOf((String)paramHashMap.get("istopfeed")).intValue() == 1)) {}
          QCircleLayerBean localQCircleLayerBean = new QCircleLayerBean();
          Object localObject3 = (String)paramHashMap.get("from");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject2 = localObject3;
            if (TextUtils.isDigitsOnly((CharSequence)localObject3)) {}
          }
          else
          {
            localObject2 = localObject3;
            if (!vtt.b()) {
              localObject2 = "8";
            }
          }
          localQCircleLayerBean.setLaunchFrom((String)localObject2);
          if (paramHashMap.containsKey("pushid")) {
            localQCircleLayerBean.setLaunchId((String)paramHashMap.get("pushid"));
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
          localQCircleLayerBean.setFeed((FeedCloudMeta.StFeed)localObject4);
          if ((i != 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject4 = new FeedCloudMeta.StTagInfo();
            ((FeedCloudMeta.StTagInfo)localObject4).tagName.set((String)localObject1);
            localQCircleLayerBean.setTagInfo((FeedCloudMeta.StTagInfo)localObject4);
          }
          if (localObject2 != null) {
            localQCircleLayerBean.setBusiInfoData(((QQCircleFeedBase.StBusiInfoCommentListData)localObject2).toByteArray());
          }
          localQCircleLayerBean.setExtraTypeInfo((ExtraTypeInfo)localObject3);
          localQCircleLayerBean.setSingleFeed(bool);
          if ((paramHashMap.containsKey("is_feed_detail")) && ("1".equals(paramHashMap.get("is_feed_detail"))))
          {
            localQCircleLayerBean.setSingleFeed(false);
            if ((paramHashMap.containsKey("without_recom")) && ("1".equals(paramHashMap.get("without_recom")))) {
              localQCircleLayerBean.setSingleFeed(true);
            }
            if (paramHashMap.containsKey("from_page_report"))
            {
              localObject1 = new QCircleReportBean();
              ((QCircleReportBean)localObject1).setPageId(Integer.valueOf((String)paramHashMap.get("from_page_report")).intValue());
              localQCircleLayerBean.setFromReportBean((QCircleReportBean)localObject1);
            }
            a(paramContext, localQCircleLayerBean);
            return;
            bool = false;
            break;
            i = 0;
            continue;
          }
          b(paramContext, localQCircleLayerBean);
          return;
          i = 0;
        }
        bool = false;
      }
    }
  }
  
  public static void d(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    if (aazb.a("QCircleLauncher_launchPrivateMessageSettingPage", 500L)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleFragmentActivity.class);
    localIntent.putExtra("key_bundle_common_init_bean", paramQCircleInitBean);
    localIntent.putExtra("public_fragment_class", QCirclePrivateMessageSettingFragment.class.getName());
    a(paramContext, localIntent);
  }
  
  private static void d(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (aazb.a("QCircleLauncher_launchFolderPageBySchema", 500L)) {}
    while (paramHashMap == null) {
      return;
    }
    QCircleFolderBean localQCircleFolderBean = new QCircleFolderBean();
    if (paramHashMap.containsKey("tabtype")) {}
    try
    {
      localQCircleFolderBean.setAssignShowTabType(Integer.parseInt((String)paramHashMap.get("tabtype")));
      label54:
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
        if (!vtt.b()) {
          str1 = "8";
        }
      }
      localQCircleFolderBean.setLaunchFrom(str1);
      if (paramHashMap.containsKey("pushid")) {
        localQCircleFolderBean.setLaunchId((String)paramHashMap.get("pushid"));
      }
      if (paramHashMap.containsKey("uin"))
      {
        str1 = (String)paramHashMap.get("uin");
        vtt.a().b(str1);
        localQCircleFolderBean.setUin(str1);
      }
      if (paramHashMap.containsKey("invite_id"))
      {
        paramHashMap = (String)paramHashMap.get("invite_id");
        vtt.a().a(paramHashMap);
        localQCircleFolderBean.setEnableSplash(true);
      }
      for (;;)
      {
        a(paramContext, localQCircleFolderBean);
        return;
        vtt.a().a(null);
      }
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  public static void e(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleBlackListBlock.class.getName());
    a(paramContext, localArrayList, null, paramQCircleInitBean);
  }
  
  private static void e(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.containsKey("url"))) {
      try
      {
        Object localObject = URLDecoder.decode((String)paramHashMap.get("url"));
        if (((String)localObject).startsWith("https://h5.qzone.qq.com/v2/wezone/message"))
        {
          localObject = uyw.a((String)localObject);
          ((HashMap)localObject).put("from", String.valueOf(7));
          a(paramContext, (HashMap)localObject);
          return;
        }
        a(paramContext, (String)localObject, null, -1);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("QCircleLauncher", 1, "parseUrl:" + (String)paramHashMap.get("url") + " error:" + paramContext.getMessage());
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void f(Context paramContext, QCircleInitBean paramQCircleInitBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleMessageListBlock.class.getName());
    localArrayList.add(QCircleChatListBlock.class.getName());
    a(paramContext, localArrayList, null, paramQCircleInitBean);
    bnfr.b();
  }
  
  private static void f(Context paramContext, HashMap<String, String> paramHashMap)
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
        e((Context)localObject, paramHashMap);
        return;
      }
    }
    QLog.e("QCircleLauncher", 1, "launchHippyPageByScheme error no module name!");
    e((Context)localObject, paramHashMap);
  }
  
  private static void g(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {}
    String str1;
    do
    {
      return;
      str1 = (String)paramHashMap.get("sourcetype");
    } while (str1 == null);
    Object localObject = null;
    String str2;
    if (str1.equals(String.valueOf(7)))
    {
      localObject = (String)paramHashMap.get("tagid");
      str2 = (String)paramHashMap.get("tagname");
      paramHashMap = new FeedCloudMeta.StTagInfo();
      paramHashMap.tagId.set((String)localObject);
      paramHashMap.tagName.set(str2);
      localObject = new QCirclePolymerizationBean();
      ((QCirclePolymerizationBean)localObject).setTagInfo(paramHashMap);
    }
    for (;;)
    {
      paramHashMap = (HashMap<String, String>)localObject;
      if (localObject == null) {
        paramHashMap = new QCirclePolymerizationBean();
      }
      paramHashMap.setPolymerizationType(Integer.valueOf(str1).intValue());
      paramHashMap.setExt1From(5);
      a(paramContext, paramHashMap);
      return;
      if (str1.equals(String.valueOf(16)))
      {
        localObject = (String)paramHashMap.get("poiname");
        long l1 = Long.valueOf((String)paramHashMap.get("lat")).longValue();
        long l2 = Long.valueOf((String)paramHashMap.get("lon")).longValue();
        long l3 = Long.valueOf((String)paramHashMap.get("alt")).longValue();
        paramHashMap = new FeedCloudMeta.StPoiInfoV2();
        paramHashMap.name.set((String)localObject);
        localObject = new FeedCloudMeta.StGPSV2();
        ((FeedCloudMeta.StGPSV2)localObject).lat.set(l1);
        ((FeedCloudMeta.StGPSV2)localObject).lon.set(l2);
        ((FeedCloudMeta.StGPSV2)localObject).alt.set(l3);
        paramHashMap.gps.set((MessageMicro)localObject);
        localObject = new QCirclePolymerizationBean();
        ((QCirclePolymerizationBean)localObject).setPoiInfo(paramHashMap);
      }
      else if (str1.equals(String.valueOf(20)))
      {
        localObject = (String)paramHashMap.get("filterid");
        str2 = (String)paramHashMap.get("filtername");
        paramHashMap = new QQCircleFeedBase.StSimulateData();
        paramHashMap.material_id.set((String)localObject);
        paramHashMap.simulate_name.set(str2);
        paramHashMap.simulate_schema.set(brdx.a((String)localObject, ""));
        localObject = new QCirclePolymerizationBean();
        ((QCirclePolymerizationBean)localObject).setSimulateData(paramHashMap);
      }
    }
  }
  
  private static void h(Context paramContext, HashMap<String, String> paramHashMap)
  {
    QCircleFolderBean localQCircleFolderBean = new QCircleFolderBean();
    if (!uyk.a().b()) {
      localQCircleFolderBean.setPublish(true);
    }
    localQCircleFolderBean.setLaunchFrom("8");
    localQCircleFolderBean.setAttrs(paramHashMap);
    a(paramContext, localQCircleFolderBean);
  }
  
  private static void i(Context paramContext, HashMap<String, String> paramHashMap)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramHashMap);
    uyk.a().b();
    paramHashMap = new Bundle();
    paramHashMap.putLong("PhotoConst.timestamp", System.currentTimeMillis());
    paramHashMap.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
    paramHashMap.putInt("key_qcircle_entrance_type", 3);
    paramHashMap.putBoolean("key_is_take_photo", false);
    paramHashMap.putBoolean("key_qcircle_publish_finish_jump_to_mainpage", true);
    localIntent.putExtra("key_enable_splash", false);
    localIntent.putExtras(paramHashMap);
    localIntent.addFlags(268435456);
    PublicTransFragmentActivity.b(paramContext, localIntent, QCircleLoadingFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyx
 * JD-Core Version:    0.7.0.1
 */