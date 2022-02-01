import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePart.5;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePart.6;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.requests.QCircleGetHeadUrlRequest;
import com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SerializableMap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
import feedcloud.FeedCloudMeta.StImageUrl;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StShareQzoneInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class vde
  extends uzw
{
  private biau jdField_a_of_type_Biau;
  private bihh jdField_a_of_type_Bihh;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private uzn jdField_a_of_type_Uzn;
  private vus jdField_a_of_type_Vus;
  private zxl<QCircleReportBean> jdField_a_of_type_Zxl;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public vde()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  private Intent a()
  {
    if ((this.jdField_a_of_type_Uzn == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share == null) || (a() == null)) {
      return null;
    }
    Intent localIntent = new Intent(a().getApplicationContext(), ForwardRecentActivity.class);
    try
    {
      Object localObject = new JSONObject(QCircleAsyncTextView.a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.shareCardInfo.get()));
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
      localIntent.putExtras(bgou.a(str2, str4, str3, (String)localObject, apoh.a(), null, null));
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
    if ((this.jdField_a_of_type_Uzn != null) && (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (!uxx.a((FeedCloudMeta.StUser)this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())))
    {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(162));
      vrf.a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 30, 6, 4, b());
    }
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
    int i = 4;
    if ((this.jdField_a_of_type_Uzn == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share == null) || (a() == null)) {
      return;
    }
    if (a(57)) {
      if (paramInt == 9)
      {
        i = 27;
        vrg.a(i, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, a());
      }
    }
    String str1;
    String str2;
    Object localObject1;
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.url.get();
      str1 = a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.title.get());
      str2 = a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.desc.get());
      localObject1 = new HashMap(1);
      if ((localObject2 != null) && (!((String)localObject2).isEmpty())) {
        break label320;
      }
      QQToast.a(a(), 1, anni.a(2131713333), 0).a();
      return;
      i = 28;
      break;
      if (!a(32)) {
        break label232;
      }
      localObject1 = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get();
      if (paramInt == 9) {
        i = 3;
      }
      vrf.a((String)localObject1, 11, 9, i, b());
    }
    label232:
    if (a(31))
    {
      localObject1 = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get();
      if (paramInt == 9) {}
      for (i = 3;; i = 4)
      {
        vrf.a((String)localObject1, 6, 4, i, b());
        break;
      }
    }
    if (paramInt == 9) {}
    for (i = 27;; i = 28)
    {
      vrc.a(i, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, b());
      break;
    }
    label320:
    if (!WXShareHelper.a().a())
    {
      zvc.a(0, 2131719199);
      return;
    }
    if (!WXShareHelper.a().b())
    {
      zvc.a(0, 2131719200);
      return;
    }
    h();
    Object localObject2 = new QCircleSharePart.5(this, (Map)localObject1, str1, str2, (String)localObject2, paramInt);
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get())) && (TextUtils.isEmpty(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.cover.picUrl.get())))
    {
      QLog.d("QCircleSharePart", 1, "shareToWeChat no picture");
      ((Runnable)localObject2).run();
      return;
    }
    a(a());
    this.jdField_a_of_type_Biau.c(2131693478);
    this.jdField_a_of_type_Biau.show();
    ThreadManager.post(new QCircleSharePart.6(this, (Map)localObject1, (Runnable)localObject2), 8, null, false);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Uzn == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {}
    label270:
    label279:
    do
    {
      return;
      FeedCloudMeta.StFeed localStFeed;
      ArrayList localArrayList;
      int i;
      String str;
      if (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.isRecomFd.get())
      {
        localStFeed = new FeedCloudMeta.StFeed();
        localStFeed.id.set(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.recomForward.id.get());
        localStFeed.poster.set(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.recomForward.poster.get());
        localArrayList = new ArrayList();
        localArrayList.add(vri.a("ext3", String.valueOf(localStFeed.createTime)));
        i = -1;
        if (this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) {
          i = this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.mDataPosition;
        }
        str = localStFeed.poster.id.get();
        if (!a(57)) {
          break label270;
        }
      }
      for (int j = a();; j = b())
      {
        vrc.a(str, 65, paramInt, i, localStFeed, localArrayList, j);
        zwp.a().a(new QCircleFeedEvent(localStFeed.id.get(), 3));
        if (paramInt != 4) {
          break label279;
        }
        VSNetworkHelper.a().a(new QCircleSetUnCareRequest(localStFeed.poster.id.get(), 1, null), new vdg(this, paramBoolean));
        return;
        localStFeed = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
        break;
      }
    } while (!paramBoolean);
    QQToast.a(a(), 2, 2131697134, 0).a();
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Biau == null) {
      this.jdField_a_of_type_Biau = new biau(paramActivity);
    }
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int i = paramActionSheetItem.action;
    Message localMessage = new Message();
    localMessage.what = i;
    b("share_action_sheet_click_callback", localMessage);
    QLog.d("QCircleSharePart", 1, "handleClickMenuItem  action:" + i + "  pageId:" + b() + "  parentPageId:" + a());
    switch (i)
    {
    }
    for (;;)
    {
      if ((i == 3) || (i == 9) || (i == 10) || (i == 72) || (i == 73) || (i == 2)) {
        zwp.a().a(new QCircleFuelAnimationEvent());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      return;
      e();
      continue;
      f();
      continue;
      b(paramActionSheetItem);
      continue;
      g();
      continue;
      a(i);
      continue;
      k();
      continue;
      a(false);
      continue;
      a(true);
      continue;
      i();
      continue;
      j();
      continue;
      a(3, false);
      continue;
      a(4, false);
      continue;
      d();
      continue;
      c();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Uzn == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {
      return;
    }
    QLog.d("QCircleSharePart", 1, "switchBarrage...");
    zwp localzwp = zwp.a();
    int i;
    if (paramBoolean)
    {
      i = 10;
      localzwp.a(new QCircleDanmakuEvent(i));
      if (paramBoolean) {
        break label75;
      }
    }
    label75:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
      i = 9;
      break;
    }
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == b();
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Uzn == null) {
      return localArrayList;
    }
    if (this.jdField_a_of_type_Uzn.jdField_a_of_type_Boolean) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
    }
    if (this.jdField_a_of_type_Uzn.jdField_b_of_type_Boolean) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
    }
    if ((this.jdField_a_of_type_Uzn.h) && (b())) {
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    }
    if ((QzoneConfig.getQQCircleIsOpenDanmaku()) && (this.jdField_a_of_type_Uzn.c))
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label202;
      }
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(143));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Uzn.d) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(44));
      }
      if (this.jdField_a_of_type_Uzn.f) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(141));
      }
      if (this.jdField_a_of_type_Uzn.e) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(86));
      }
      if (!this.jdField_a_of_type_Uzn.g) {
        break;
      }
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(140));
      return localArrayList;
      label202:
      localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(142));
    }
  }
  
  private void b()
  {
    if ((a() == null) || (this.jdField_a_of_type_Uzn == null))
    {
      QQToast.a(a(), anni.a(2131713347), 0).a();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localList1, localList2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new vdf(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
    QLog.d("QCircleSharePart", 1, "showActionSheet  pageId:" + b() + "  parentPageId:" + a());
    if (a(57))
    {
      vrg.a(21, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, a());
      return;
    }
    if (a(32))
    {
      if ((this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 9))
      {
        vrf.a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 15, 1, b());
        return;
      }
      vrf.a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 7, 1, b());
      return;
    }
    if (a(31))
    {
      vrf.a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 6, 3, 0, b());
      return;
    }
    vrc.a(21, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, b());
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
      aufz.a(a(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 19005);
      QLog.d("QCircleSharePart", 1, "shareToSpecifiedFriend  success");
    }
    if (a(57))
    {
      vrg.a(24, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, a());
      return;
    }
    if (a(32))
    {
      vrf.a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 9, 0, b());
      return;
    }
    vrc.a(24, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, b());
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.jdField_a_of_type_Uzn != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
      {
        if (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get() != 3) {
          break label125;
        }
        localObject = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.video.vecVideoUrl.get();
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((List)localObject).size() > 0)
          {
            i = 0;
            bool1 = bool2;
            if (i < ((List)localObject).size())
            {
              if (((FeedCloudMeta.StVideoUrl)((List)localObject).get(i)).levelType.get() != 20) {
                break label118;
              }
              bool1 = true;
            }
          }
        }
      }
    }
    label118:
    label125:
    do
    {
      do
      {
        do
        {
          return bool1;
          i += 1;
          break;
          bool1 = bool2;
        } while (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get() != 2);
        localObject = (FeedCloudMeta.StImage)this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.get(this.jdField_a_of_type_Uzn.jdField_b_of_type_Int);
        bool1 = bool2;
      } while (localObject == null);
      bool1 = bool2;
    } while (((FeedCloudMeta.StImage)localObject).vecImageUrl.size() <= 0);
    Object localObject = ((FeedCloudMeta.StImage)localObject).vecImageUrl.get().iterator();
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((FeedCloudMeta.StImageUrl)((Iterator)localObject).next()).levelType.get() != 4);
    return true;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Uzn == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {
      return;
    }
    if (!nmd.a(BaseApplicationImpl.context))
    {
      biti.a().a(anni.a(2131713345));
      QLog.d("QCircleSharePart", 4, "network not available");
      return;
    }
    Object localObject2 = "";
    viw localviw = new viw();
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get() == 3)
    {
      localObject1 = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.video.vecVideoUrl.get();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label576;
      }
      i = 0;
      if (i >= ((List)localObject1).size()) {
        break label576;
      }
      if (((FeedCloudMeta.StVideoUrl)((List)localObject1).get(i)).levelType.get() == 20)
      {
        localObject1 = ((FeedCloudMeta.StVideoUrl)((List)localObject1).get(i)).playUrl.get();
        QLog.d("QCircleSharePart", 1, "get video downLoad url success");
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.video.playUrl.get();
        QLog.d("QCircleSharePart", 1, "get origin video downLoad url success");
      }
      localviw.a((String)localObject2, 0);
      label217:
      localviw.a(new vdh(this));
      b("rich_media_download_show", null);
      vit.a().a(localviw);
      if (a(57))
      {
        localObject2 = this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
        if (localviw.a() == 0) {}
        for (localObject1 = "2";; localObject1 = "1")
        {
          vrg.a(90, 2, (ExtraTypeInfo)localObject2, new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("ext1", (String)localObject1) })), a());
          return;
          i += 1;
          break;
          if (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get() != 2) {
            break label217;
          }
          Object localObject3 = (FeedCloudMeta.StImage)this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.get(this.jdField_a_of_type_Uzn.jdField_b_of_type_Int);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((FeedCloudMeta.StImage)localObject3).vecImageUrl.size() > 0)
            {
              localObject3 = ((FeedCloudMeta.StImage)localObject3).vecImageUrl.get().iterator();
              do
              {
                localObject1 = localObject2;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject1 = (FeedCloudMeta.StImageUrl)((Iterator)localObject3).next();
              } while (((FeedCloudMeta.StImageUrl)localObject1).levelType.get() != 4);
              localObject1 = ((FeedCloudMeta.StImageUrl)localObject1).url.get();
              QLog.d("QCircleSharePart", 1, "get pic downLoad url success");
            }
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = ((FeedCloudMeta.StImage)this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.get(this.jdField_a_of_type_Uzn.jdField_b_of_type_Int)).picUrl.get();
            QLog.d("QCircleSharePart", 1, "get origin pic downLoad url success");
          }
          localviw.a((String)localObject2, 1);
          break label217;
        }
      }
      localObject2 = this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      if (localviw.a() == 0) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        vrc.a(90, 2, (ExtraTypeInfo)localObject2, new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("ext1", (String)localObject1) })), a());
        return;
      }
      label576:
      localObject1 = "";
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Uzn == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {
      return;
    }
    vdi localvdi = new vdi(this);
    bglp.a(a(), 230, null, anni.a(2131697135), 2131690582, 2131694081, localvdi, localvdi).show();
    vrf.a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 15, 1, b());
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Uzn == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {
      return;
    }
    Intent localIntent = new Intent(a(), ChatActivity.class);
    String str = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get();
    localIntent.putExtra("uin", str);
    localIntent.putExtra("open_chatfragment", true);
    if (uxx.a(a(), str)) {
      localIntent.putExtra("uintype", 0);
    }
    for (;;)
    {
      localIntent.putExtra("aio_msg_source", 3);
      Object localObject2 = null;
      if ((a() instanceof BaseActivity)) {
        localObject2 = bglf.b(((BaseActivity)a()).app, str, true);
      }
      Object localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!str.equals(localObject2)) {}
      }
      else
      {
        localObject1 = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.nick.get();
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localIntent.putExtra("uinname", (String)localObject2);
      a().startActivity(localIntent);
      return;
      localIntent.putExtra("uintype", 10008);
    }
  }
  
  private void f()
  {
    Intent localIntent = a();
    if ((localIntent == null) && (a() != null))
    {
      QQToast.a(a(), anni.a(2131713336), 0).a();
      return;
    }
    if (a() != null)
    {
      a().startActivityForResult(localIntent, 21);
      QLog.d("QCircleSharePart", 1, "shareToQQ  success");
    }
    if (a(57))
    {
      vrg.a(25, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, a());
      return;
    }
    if (a(32))
    {
      vrf.a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 9, 1, b());
      return;
    }
    if (a(31))
    {
      vrf.a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 6, 4, 1, b());
      return;
    }
    vrc.a(25, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, b());
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Uzn == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share == null) || (a() == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject1 = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.share.shareQzoneInfo.entrys.get();
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
      if (a(57)) {
        vrg.a(26, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, a());
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label503;
        }
        if (((String)localObject1).startsWith("avatar://")) {
          try
          {
            l = Long.parseLong(((String)localObject1).substring("avatar://".length()));
            if (l > 0L)
            {
              localObject2 = new QCircleGetHeadUrlRequest(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin(), l);
              VSNetworkHelper.a().a((VSBaseRequest)localObject2, new vdk(this, (String)localObject1, localBundle));
              return;
              if (a(32))
              {
                vrf.a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 9, 2, b());
                continue;
              }
              if (a(31))
              {
                vrf.a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 6, 4, 2, b());
                continue;
              }
              vrc.a(26, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, b());
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
      label503:
      bltb.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()), a(), localBundle, null, -1);
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
  
  private void h()
  {
    if (this.jdField_a_of_type_Bihh != null) {
      return;
    }
    this.jdField_a_of_type_Bihh = new vdm(this);
    WXShareHelper.a().a(this.jdField_a_of_type_Bihh);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Uzn == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {
      return;
    }
    vdn localvdn = new vdn(this);
    bglp.a(a(), 230, null, anni.a(2131697148), 2131690582, 2131694081, localvdn, localvdn).show();
    if (a(57))
    {
      vrg.a(22, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, a());
      return;
    }
    vrc.a(22, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, b());
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Uzn == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {}
    while ((this.jdField_a_of_type_Vus != null) && (this.jdField_a_of_type_Vus.isShowing())) {
      return;
    }
    localObject1 = new vdp(this);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new QQCircleFeedBase.StFeedBusiReqData();
    try
    {
      ((QQCircleFeedBase.StFeedBusiReqData)localObject2).mergeFrom(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.busiData.get().toByteArray());
      localObject2 = ((QQCircleFeedBase.StFeedBusiReqData)localObject2).uninterest_buttons.get();
      if (((List)localObject2).contains(Integer.valueOf(1))) {
        localArrayList.add(new bkhn(3, bkif.a(a(), 2131697201), 3, 0));
      }
      if (((List)localObject2).contains(Integer.valueOf(2))) {
        localArrayList.add(new bkhn(4, bkif.a(a(), 2131697199), 4, 0));
      }
      if (((List)localObject2).contains(Integer.valueOf(3))) {
        localArrayList.add(new bkhn(2, bkif.a(a(), 2131697200), 2, 0));
      }
      if (((List)localObject2).contains(Integer.valueOf(7))) {
        localArrayList.add(new bkhn(5, bkif.a(a(), 2131697202), 5, 0));
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        int i;
        localInvalidProtocolBufferMicroException.printStackTrace();
        continue;
        localObject1 = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
        continue;
        int j = b();
        continue;
        j = b();
      }
    }
    this.jdField_a_of_type_Vus = vut.a(a(), localArrayList, (bkhw)localObject1);
    this.jdField_a_of_type_Vus.c(2131690582);
    this.jdField_a_of_type_Vus.show();
    if (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.isRecomFd.get())
    {
      localObject1 = new FeedCloudMeta.StFeed();
      ((FeedCloudMeta.StFeed)localObject1).id.set(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.recomForward.id.get());
      ((FeedCloudMeta.StFeed)localObject1).poster.set(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.recomForward.poster.get());
      localArrayList = new ArrayList();
      localArrayList.add(vri.a("ext3", String.valueOf(((FeedCloudMeta.StFeed)localObject1).createTime)));
      i = -1;
      if (this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) {
        i = this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.mDataPosition;
      }
      localObject2 = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get();
      if (!a(57)) {
        break label528;
      }
      j = a();
      vrc.a((String)localObject2, 78, 2, i, (FeedCloudMeta.StFeed)localObject1, localArrayList, j);
      localObject2 = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get();
      if (!a(57)) {
        break label536;
      }
      j = a();
      vrc.a((String)localObject2, 79, 1, i, (FeedCloudMeta.StFeed)localObject1, localArrayList, j);
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_Uzn == null) || (this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (a() == null)) {
      return;
    }
    uzh localuzh = new uzh();
    uzg localuzg = new uzg();
    if (this.jdField_a_of_type_Uzn.jdField_a_of_type_Int == 0)
    {
      localuzg.c(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get()).b("25014").a("wezone_feed");
      localuzh.b(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()).e(String.valueOf(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.createTime.get()));
    }
    for (;;)
    {
      localuzg.d(localuzh.toString());
      vtl.a(localuzg.a());
      if (!a(57)) {
        break;
      }
      vrg.a(23, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, a());
      return;
      if (this.jdField_a_of_type_Uzn.jdField_a_of_type_Int == 1) {
        localuzg.c(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get()).a("wezone_profile").b("25015");
      }
    }
    if (a(32))
    {
      vrf.a(this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 11, 8, 0, "", "", "", "", "", b());
      return;
    }
    vrc.a(23, 2, this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, b());
  }
  
  public String a()
  {
    return "QCircleSharePart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("QCircleSharePart", 3, "onActivityResult:" + paramInt1 + "," + paramInt2);
    super.a(paramInt1, paramInt2, paramIntent);
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
      if ((paramObject instanceof uzn))
      {
        this.jdField_a_of_type_Uzn = ((uzn)paramObject);
        if ((this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo instanceof ReportExtraTypeInfo)) {
          ((ReportExtraTypeInfo)this.jdField_a_of_type_Uzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo).mFeed = this.jdField_a_of_type_Uzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
        }
      }
      b();
    }
    super.a(paramString, paramObject);
  }
  
  public void a(zxl<QCircleReportBean> paramzxl)
  {
    this.jdField_a_of_type_Zxl = paramzxl;
  }
  
  protected String b()
  {
    return "otheraction";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vde
 * JD-Core Version:    0.7.0.1
 */