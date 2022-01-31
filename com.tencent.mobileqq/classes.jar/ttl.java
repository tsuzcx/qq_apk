import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePart.3;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePart.4;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.requests.QCircleGetHeadUrlRequest;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SerializableMap;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
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
import feedcloud.FeedCloudMeta.StImage;
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
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ttl
  extends tvv
{
  private bety jdField_a_of_type_Bety;
  private bfah jdField_a_of_type_Bfah;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private trz jdField_a_of_type_Trz;
  private boolean jdField_a_of_type_Boolean;
  
  private Intent a()
  {
    if ((this.jdField_a_of_type_Trz == null) || (this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share == null) || (a() == null)) {
      return null;
    }
    Intent localIntent = new Intent(a().getApplicationContext(), ForwardRecentActivity.class);
    try
    {
      Object localObject = new JSONObject(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.shareCardInfo.get());
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
      localIntent.putExtras(bdjt.a(str2, str4, str3, (String)localObject, anob.a(), null, null));
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        QLog.d("QCircleSharePart", 1, "getShareArkIntent  exception message: " + localJSONException.getMessage());
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
    if ((this.jdField_a_of_type_Trz == null) || (this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share == null) || (a() == null)) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.url.get();
    String str1 = a(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.title.get());
    String str2 = a(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.desc.get());
    Object localObject1 = new HashMap(1);
    if ((localObject2 == null) || (((String)localObject2).isEmpty()))
    {
      QQToast.a(a(), 1, alud.a(2131715032), 0).a();
      return;
    }
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131721491;
    }
    for (;;)
    {
      if (i != -1)
      {
        ybk.a(0, i);
        label164:
        if (!tzy.a().c(57)) {
          break label346;
        }
        if (paramInt != 9) {
          break label340;
        }
      }
      label340:
      for (paramInt = 27;; paramInt = 28)
      {
        tzw.a(paramInt, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        return;
        if (WXShareHelper.a().b()) {
          break label490;
        }
        i = 2131721492;
        break;
        e();
        localObject2 = new QCircleSharePart.3(this, (Map)localObject1, str1, str2, (String)localObject2, paramInt);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get())) && (TextUtils.isEmpty(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.cover.picUrl.get())))
        {
          ((Runnable)localObject2).run();
          break label164;
        }
        a(a());
        this.jdField_a_of_type_Bety.c(2131694219);
        this.jdField_a_of_type_Bety.show();
        ThreadManager.post(new QCircleSharePart.4(this, (Map)localObject1, (Runnable)localObject2), 8, null, false);
        break label164;
      }
      label346:
      long l;
      if (tzy.a().c(32))
      {
        localObject1 = this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get();
        if (paramInt == 9) {}
        for (l = 3L;; l = 4L)
        {
          tzv.a((String)localObject1, 11, 9L, l);
          return;
        }
      }
      if (tzy.a().c(31))
      {
        localObject1 = this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get();
        if (paramInt == 9) {}
        for (l = 3L;; l = 4L)
        {
          tzv.a((String)localObject1, 6, 4L, l);
          return;
        }
      }
      if (paramInt == 9) {}
      for (paramInt = 27;; paramInt = 28)
      {
        tzs.a(paramInt, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        return;
      }
      label490:
      i = -1;
    }
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Bety == null) {
      this.jdField_a_of_type_Bety = new bety(paramActivity);
    }
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int i = paramActionSheetItem.action;
    Message localMessage = new Message();
    localMessage.what = i;
    b("share_action_sheet_click_callback", localMessage);
    QLog.d("QCircleSharePart", 1, "handleClickMenuItem  action:" + i + "  pageId:" + tzy.a().a() + "  parentPageId:" + tzy.a().b());
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
      h();
      continue;
      f();
      continue;
      g();
    }
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Trz == null) {}
    do
    {
      return localArrayList;
      if (this.jdField_a_of_type_Trz.b) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
      }
      if (this.jdField_a_of_type_Trz.c) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
      }
    } while (!this.jdField_a_of_type_Trz.d);
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(44));
    return localArrayList;
  }
  
  private void b()
  {
    if ((a() == null) || (this.jdField_a_of_type_Trz == null))
    {
      QQToast.a(a(), alud.a(2131715046), 0).a();
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
    if (this.jdField_a_of_type_Trz.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localList1, localList2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new ttm(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      QLog.d("QCircleSharePart", 1, "showActionSheet  pageId:" + tzy.a().a() + "  parentPageId:" + tzy.a().b());
      if (!tzy.a().c(57)) {
        break;
      }
      tzw.a(21, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
      Intent localIntent = a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(localIntent);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    }
    if (tzy.a().c(32))
    {
      tzv.a(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 7L, 1L);
      return;
    }
    if (tzy.a().c(31))
    {
      tzv.a(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 6, 3L, 0L);
      return;
    }
    tzs.a(21, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
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
      aryv.a(a(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 19005);
      QLog.d("QCircleSharePart", 1, "shareToSpecifiedFriend  success");
    }
    if (tzy.a().c(57))
    {
      tzw.a(24, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
    }
    if (tzy.a().c(32))
    {
      tzv.a(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 9L, 0L);
      return;
    }
    tzs.a(24, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
  }
  
  private void c()
  {
    Intent localIntent = a();
    if ((localIntent == null) && (a() != null))
    {
      QQToast.a(a(), alud.a(2131715035), 0).a();
      return;
    }
    if (a() != null)
    {
      a().startActivityForResult(localIntent, 21);
      QLog.d("QCircleSharePart", 1, "shareToQQ  success");
    }
    if (tzy.a().c(57))
    {
      tzw.a(25, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
    }
    if (tzy.a().c(32))
    {
      tzv.a(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 9L, 1L);
      return;
    }
    if (tzy.a().c(31))
    {
      tzv.a(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 6, 4L, 1L);
      return;
    }
    tzs.a(25, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Trz == null) || (this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share == null) || (a() == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject1 = this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.shareQzoneInfo.entrys.get();
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
      localBundle.putLong("req_share_id", 0L);
      if (tzy.a().c(57)) {
        tzw.a(26, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label500;
        }
        if (((String)localObject1).startsWith("avatar://")) {
          try
          {
            l = Long.parseLong(((String)localObject1).substring("avatar://".length()));
            if (l > 0L)
            {
              localObject2 = new QCircleGetHeadUrlRequest(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin(), l);
              VSNetworkHelper.a().a((VSBaseRequest)localObject2, new ttn(this, (String)localObject1, localBundle));
              return;
              if (tzy.a().c(32))
              {
                tzv.a(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 9L, 2L);
                continue;
              }
              if (tzy.a().c(31))
              {
                tzv.a(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 6, 4L, 2L);
                continue;
              }
              tzs.a(26, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("QCircleSharePart", 1, "shareToQZone() parse uin error!", localException);
              long l = 0L;
            }
          }
        }
      }
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject1);
      localBundle.putStringArrayList("image_url", localArrayList);
      label500:
      bjev.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()), a(), localBundle, null, -1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QCircleSharePart", 1, "shareToQZone  success");
      return;
      localArrayList = null;
      str2 = null;
      str1 = null;
      localObject3 = null;
      localObject1 = null;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bfah != null) {
      return;
    }
    this.jdField_a_of_type_Bfah = new tto(this);
    WXShareHelper.a().a(this.jdField_a_of_type_Bfah);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Trz == null) || (this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {
      return;
    }
    ttp localttp = new ttp(this);
    bdgm.a(a(), 230, null, alud.a(2131698300), 2131690648, 2131694953, localttp, localttp).show();
    if (tzy.a().c(57))
    {
      tzw.a(22, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
    }
    tzs.a(22, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Trz == null) || (this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.isRecomFd.get())
    {
      localObject = new FeedCloudMeta.StFeed();
      ((FeedCloudMeta.StFeed)localObject).id.set(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.recomForward.id.get());
      ((FeedCloudMeta.StFeed)localObject).poster.set(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.recomForward.poster.get());
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(tzy.a("ext3", String.valueOf(((FeedCloudMeta.StFeed)localObject).createTime)));
      int i = -1;
      if (this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) {
        i = this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.mDataPosition;
      }
      tzs.a(((FeedCloudMeta.StFeed)localObject).poster.id.get(), 65, 2, i, (FeedCloudMeta.StFeed)localObject, localArrayList);
      localObject = ((FeedCloudMeta.StFeed)localObject).id.get();
      yiw.a().a(new QCircleFeedEvent((String)localObject, 3));
      QQToast.a(a(), 2, 2131698289, 0).a();
      return;
      localObject = this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Trz == null) || (this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    ylk localylk = new ylk();
    localylk.jdField_a_of_type_JavaLangString = "android";
    localylk.b = AppSetting.f();
    localylk.c = "1";
    localylk.e = "KQQ";
    localylk.f = "2400002";
    if (this.jdField_a_of_type_Trz.jdField_a_of_type_Int == 0)
    {
      localylk.g = "wezone_feed";
      localylk.h = "25014";
      if (this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.isRecomFd.get())
      {
        localylk.d = this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.recomForward.poster.id.get();
        localStringBuilder.append("ctim=").append(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.createTime.get()).append("|").append("feed_id=").append(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get());
      }
    }
    for (;;)
    {
      localylk.j = localStringBuilder.toString();
      localylk.i = "0";
      yli.a(a(), localylk);
      QLog.d("QCircleSharePart", 1, "report  success");
      if (!tzy.a().c(57)) {
        break label319;
      }
      tzw.a(23, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
      localylk.d = this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get();
      break;
      if (this.jdField_a_of_type_Trz.jdField_a_of_type_Int == 1)
      {
        localylk.g = "wezone_profile";
        localylk.h = "25015";
        localylk.d = this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get();
      }
    }
    label319:
    if (tzy.a().c(32))
    {
      tzv.a(this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 8L);
      return;
    }
    tzs.a(23, 2, this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
  }
  
  public String a()
  {
    return "QCircleSharePart";
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    a();
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (TextUtils.equals(paramString, "share_action_show_share_sheet"))
    {
      if ((paramObject instanceof trz))
      {
        this.jdField_a_of_type_Trz = ((trz)paramObject);
        if ((this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo instanceof ReportExtraTypeInfo)) {
          ((ReportExtraTypeInfo)this.jdField_a_of_type_Trz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo).mFeed = this.jdField_a_of_type_Trz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
        }
      }
      b();
    }
    super.a(paramString, paramObject);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttl
 * JD-Core Version:    0.7.0.1
 */