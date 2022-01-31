import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePart.4;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePart.5;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SerializableMap;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StShareQzoneInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class tsv
  extends tvg
{
  private bepp jdField_a_of_type_Bepp;
  private bevy jdField_a_of_type_Bevy;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private tru jdField_a_of_type_Tru;
  
  private Intent a()
  {
    if ((this.jdField_a_of_type_Tru == null) || (this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share == null) || (a() == null)) {
      return null;
    }
    Intent localIntent = new Intent(a().getApplicationContext(), ForwardRecentActivity.class);
    try
    {
      Object localObject = new JSONObject(this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.shareCardInfo.get());
      String str2 = ((JSONObject)localObject).optString("app");
      String str3 = ((JSONObject)localObject).optString("ver");
      String str4 = ((JSONObject)localObject).optString("view");
      String str1 = ((JSONObject)localObject).optString("meta");
      localObject = ((JSONObject)localObject).optString("prompt");
      localIntent.putExtra("forward_type", 27);
      localIntent.putExtra("is_ark_display_share", true);
      localIntent.putExtra("forward_ark_app_name", str2);
      localIntent.putExtra("forward_ark_app_view", str4);
      localIntent.putExtra("forward_ark_app_ver", str3);
      localIntent.putExtra("forward_ark_app_prompt", (String)localObject);
      localIntent.putExtra("forward_ark_app_meta", str1);
      localObject = str1;
      if (!TextUtils.isEmpty(str1))
      {
        localObject = str1;
        if (str1.contains("\"isAIO\":1")) {
          localObject = str1.replace("\"isAIO\":1", "\"isAIO\":0");
        }
      }
      localIntent.putExtras(bdfk.a(str2, str4, str3, (String)localObject, anjs.a(), null, null));
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return localIntent;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.length() > 30) {
        break;
      }
      str = paramString;
    } while (paramString.getBytes().length <= 100);
    String str = paramString;
    if (paramString.length() > 30) {
      str = paramString.substring(0, 30);
    }
    paramString = str;
    if (Math.min(str.getBytes().length, 100) == 100)
    {
      int i = str.length() / 2;
      paramString = new StringBuilder(str.substring(0, i));
      while (paramString.toString().getBytes().length < 100)
      {
        paramString.append(str.charAt(i));
        i += 1;
      }
      paramString = paramString.toString();
    }
    return paramString + "...";
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    if (QzoneConfig.getQQCircleShowShareQzone() == 1) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    }
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return localArrayList;
  }
  
  private void a()
  {
    ShareActionSheetV2.Param localParam = new ShareActionSheetV2.Param();
    localParam.context = a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(localParam);
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Tru == null) || (this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share == null) || (a() == null)) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.url.get();
    String str1 = a(this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.title.get());
    String str2 = a(this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.desc.get());
    Object localObject1 = new HashMap(1);
    if ((localObject2 == null) || (((String)localObject2).isEmpty()))
    {
      QQToast.a(a(), 1, alpo.a(2131715020), 0).a();
      return;
    }
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131721478;
    }
    for (;;)
    {
      if (i != -1)
      {
        xxb.a(0, i);
        label163:
        if (!tym.a().c(57)) {
          break label320;
        }
        if (paramInt != 9) {
          break label314;
        }
      }
      label314:
      for (paramInt = 27;; paramInt = 28)
      {
        tyk.a(paramInt, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        return;
        if (WXShareHelper.a().b()) {
          break label406;
        }
        i = 2131721479;
        break;
        e();
        localObject2 = new QCircleSharePart.4(this, (Map)localObject1, str1, str2, (String)localObject2, paramInt);
        if (TextUtils.isEmpty(this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get()))
        {
          ((Runnable)localObject2).run();
          break label163;
        }
        a(a());
        this.jdField_a_of_type_Bepp.c(2131694217);
        this.jdField_a_of_type_Bepp.show();
        ThreadManager.post(new QCircleSharePart.5(this, (Map)localObject1, (Runnable)localObject2), 8, null, false);
        break label163;
      }
      label320:
      if (tym.a().c(32))
      {
        localObject1 = this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get();
        if (paramInt == 9) {}
        for (long l = 3L;; l = 4L)
        {
          tyj.a((String)localObject1, 11, 9L, l);
          return;
        }
      }
      if (paramInt == 9) {}
      for (paramInt = 27;; paramInt = 28)
      {
        tyg.a(paramInt, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        return;
      }
      label406:
      i = -1;
    }
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Bepp == null) {
      this.jdField_a_of_type_Bepp = new bepp(paramActivity);
    }
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int i = paramActionSheetItem.action;
    Message localMessage = new Message();
    localMessage.what = i;
    b("share_action_sheet_click_callback", localMessage);
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      return;
      c();
      continue;
      b(paramActionSheetItem);
      continue;
      d();
      continue;
      a(i);
      continue;
      g();
      continue;
      f();
    }
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Tru == null) {}
    do
    {
      return localArrayList;
      if (this.jdField_a_of_type_Tru.b) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
      }
    } while (!this.jdField_a_of_type_Tru.c);
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
    return localArrayList;
  }
  
  private void b()
  {
    if ((a() == null) || (this.jdField_a_of_type_Tru == null))
    {
      QQToast.a(a(), alpo.a(2131715034), 0).a();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      return;
    }
    a().getIntent().putExtra("big_brother_source_key", "biz_src_jc_wezone");
    List localList1 = a();
    List localList2 = b();
    if (this.jdField_a_of_type_Tru.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localList1, localList2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new tsw(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new tsx(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new tsy(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      if (!tym.a().c(57)) {
        break;
      }
      tyk.a(21, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
      Intent localIntent = a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(localIntent);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    }
    if (tym.a().c(32))
    {
      tyj.a(this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 7L, 1L);
      return;
    }
    tyg.a(21, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
  }
  
  private void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_req", ForwardRecentActivity.f);
    localBundle.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
    localBundle.putString("key_direct_show_uin", paramActionSheetItem.uin);
    paramActionSheetItem = a();
    if (paramActionSheetItem != null)
    {
      paramActionSheetItem.putExtras(localBundle);
      arum.a(a(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 19005);
    }
    if (tym.a().c(57))
    {
      tyk.a(24, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
    }
    if (tym.a().c(32))
    {
      tyj.a(this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 9L, 0L);
      return;
    }
    tyg.a(24, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
  }
  
  private void c()
  {
    Intent localIntent = a();
    if ((localIntent == null) && (a() != null))
    {
      QQToast.a(a(), alpo.a(2131715023), 0).a();
      return;
    }
    if (a() != null) {
      a().startActivityForResult(localIntent, 21);
    }
    if (tym.a().c(57))
    {
      tyk.a(25, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
    }
    if (tym.a().c(32))
    {
      tyj.a(this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 9L, 1L);
      return;
    }
    tyg.a(25, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Tru == null) || (this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share == null) || (a() == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject1 = this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.shareQzoneInfo.entrys.get();
    Object localObject2;
    Object localObject3;
    String str1;
    String str2;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject2 = new SerializableMap();
      HashMap localHashMap = new HashMap();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (FeedCloudCommon.Entry)((Iterator)localObject1).next();
        localHashMap.put(((FeedCloudCommon.Entry)localObject3).key.get(), ((FeedCloudCommon.Entry)localObject3).value.get());
      }
      localObject1 = (String)localHashMap.get("COVERURL");
      localObject3 = (String)localHashMap.get("title");
      str1 = (String)localHashMap.get("summary");
      str2 = (String)localHashMap.get("actionurl");
      ((SerializableMap)localObject2).setMap(localHashMap);
    }
    for (;;)
    {
      localBundle.putSerializable("share_qzone_info", (Serializable)localObject2);
      localBundle.putString("title", (String)localObject3);
      localBundle.putString("desc", str1);
      localBundle.putString("detail_url", str2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new ArrayList(1);
        ((ArrayList)localObject2).add(localObject1);
        localBundle.putStringArrayList("image_url", (ArrayList)localObject2);
      }
      localBundle.putLong("req_share_id", 0L);
      bjao.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()), a(), localBundle, null, -1);
      if (tym.a().c(57))
      {
        tyk.a(26, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        return;
      }
      if (tym.a().c(32))
      {
        tyj.a(this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 9L, 2L);
        return;
      }
      tyg.a(26, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
      localObject2 = null;
      str2 = null;
      str1 = null;
      localObject3 = null;
      localObject1 = null;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bevy != null) {
      return;
    }
    this.jdField_a_of_type_Bevy = new tsz(this);
    WXShareHelper.a().a(this.jdField_a_of_type_Bevy);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Tru == null) || (this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {
      return;
    }
    tta localtta = new tta(this);
    bdcd.a(a(), 230, null, alpo.a(2131698297), 2131690648, 2131694951, localtta, localtta).show();
    if (tym.a().c(57))
    {
      tyk.a(22, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
    }
    tyg.a(22, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Tru == null) || (this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    ygx localygx = new ygx();
    localygx.jdField_a_of_type_JavaLangString = "android";
    localygx.b = AppSetting.f();
    localygx.c = "1";
    localygx.e = "KQQ";
    localygx.f = "2400002";
    if (this.jdField_a_of_type_Tru.jdField_a_of_type_Int == 0)
    {
      localygx.g = "wezone_feed";
      localygx.h = "25014";
      if (this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.isRecomFd.get())
      {
        localygx.d = this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.recomForward.poster.id.get();
        localStringBuilder.append("ctim=").append(this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.createTime.get()).append("|").append("feed_id=").append(this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get());
      }
    }
    for (;;)
    {
      localygx.j = localStringBuilder.toString();
      localygx.i = "0";
      ygv.a(a(), localygx);
      if (!tym.a().c(57)) {
        break label310;
      }
      tyk.a(23, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
      localygx.d = this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get();
      break;
      if (this.jdField_a_of_type_Tru.jdField_a_of_type_Int == 1)
      {
        localygx.g = "wezone_profile";
        localygx.h = "25015";
        localygx.d = this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get();
      }
    }
    label310:
    if (tym.a().c(32))
    {
      tyj.a(this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 8L);
      return;
    }
    tyg.a(23, 2, this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
  }
  
  protected void a(View paramView)
  {
    a();
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (TextUtils.equals(paramString, "share_action_show_share_sheet"))
    {
      if ((paramObject instanceof tru))
      {
        this.jdField_a_of_type_Tru = ((tru)paramObject);
        if ((this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo instanceof ReportExtraTypeInfo)) {
          ((ReportExtraTypeInfo)this.jdField_a_of_type_Tru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo).mFeed = this.jdField_a_of_type_Tru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
        }
      }
      b();
    }
    super.a(paramString, paramObject);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    WXShareHelper.a().b(this.jdField_a_of_type_Bevy);
    super.onActivityDestroyed(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsv
 * JD-Core Version:    0.7.0.1
 */