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
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SerializableMap;
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
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
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

public class oxh
  extends rxk
{
  private String Qt;
  private WXShareHelper.a jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a;
  private ovz jdField_a_of_type_Ovz;
  private ShareActionSheet c;
  private arhz m;
  private boolean uA;
  
  private void NA()
  {
    if ((this.jdField_a_of_type_Ovz == null) || (this.jdField_a_of_type_Ovz.feed == null) || (getActivity() == null)) {
      return;
    }
    oxm localoxm = new oxm(this);
    aqha.a(getActivity(), 230, null, acfp.m(2131700090), 2131721058, 2131721079, localoxm, localoxm).show();
    if (pcr.a().ez(57))
    {
      pcp.b(22, 2, this.jdField_a_of_type_Ovz.a);
      return;
    }
    pcl.a(22, 2, this.jdField_a_of_type_Ovz.a);
  }
  
  private void Qq()
  {
    if ((getActivity() == null) || (this.jdField_a_of_type_Ovz == null))
    {
      QQToast.a(getActivity(), acfp.m(2131715072), 0).show();
      return;
    }
    if ((this.c != null) && (this.c.isShowing()))
    {
      this.c.dismiss();
      return;
    }
    getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_wezone");
    List localList1 = bu();
    List localList2 = bv();
    if (this.jdField_a_of_type_Ovz.ayI) {
      this.c.setRowVisibility(8, 0, 0);
    }
    for (;;)
    {
      this.c.setActionSheetItems(localList1, localList2);
      this.c.setItemClickListenerV2(new oxi(this));
      this.c.show();
      QLog.d("QCircleSharePart", 1, "showActionSheet  pageId:" + pcr.a().getPageId() + "  parentPageId:" + pcr.a().sb());
      if (!pcr.a().ez(57)) {
        break;
      }
      pcp.b(21, 2, this.jdField_a_of_type_Ovz.a);
      return;
      Intent localIntent = n();
      this.c.setIntentForStartForwardRecentActivity(localIntent);
      this.c.setRowVisibility(0, 0, 0);
    }
    if (pcr.a().ez(32))
    {
      pco.b(this.jdField_a_of_type_Ovz.feed.poster.id.get(), 11, 7L, 1L);
      return;
    }
    if (pcr.a().ez(31))
    {
      pco.b(this.jdField_a_of_type_Ovz.feed.poster.id.get(), 6, 3L, 0L);
      return;
    }
    pcl.a(21, 2, this.jdField_a_of_type_Ovz.a);
  }
  
  private void aT(Activity paramActivity)
  {
    if (this.m == null) {
      this.m = new arhz(paramActivity);
    }
  }
  
  private void biq()
  {
    ShareActionSheetV2.Param localParam = new ShareActionSheetV2.Param();
    localParam.context = getActivity();
    this.c = ShareActionSheetFactory.create(localParam);
  }
  
  private void bir()
  {
    if ((this.jdField_a_of_type_Ovz == null) || (this.jdField_a_of_type_Ovz.feed == null) || (this.jdField_a_of_type_Ovz.feed.share == null) || (getActivity() == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject1 = this.jdField_a_of_type_Ovz.feed.share.shareQzoneInfo.entrys.get();
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
      if (pcr.a().ez(57)) {
        pcp.b(26, 2, this.jdField_a_of_type_Ovz.a);
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
              VSNetworkHelper.a().a((VSBaseRequest)localObject2, new oxj(this, (String)localObject1, localBundle));
              return;
              if (pcr.a().ez(32))
              {
                pco.b(this.jdField_a_of_type_Ovz.feed.poster.id.get(), 11, 9L, 2L);
                continue;
              }
              if (pcr.a().ez(31))
              {
                pco.b(this.jdField_a_of_type_Ovz.feed.poster.id.get(), 6, 4L, 2L);
                continue;
              }
              pcl.a(26, 2, this.jdField_a_of_type_Ovz.a);
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
      avqq.a(String.valueOf(this.app.getAccount()), getActivity(), localBundle, null, -1);
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
  
  private void bis()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = new oxl(this);
    WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
  }
  
  private void bit()
  {
    if ((this.jdField_a_of_type_Ovz == null) || (this.jdField_a_of_type_Ovz.feed == null) || (getActivity() == null)) {
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_Ovz.feed.isRecomFd.get())
    {
      localObject = new FeedCloudMeta.StFeed();
      ((FeedCloudMeta.StFeed)localObject).id.set(this.jdField_a_of_type_Ovz.feed.recomForward.id.get());
      ((FeedCloudMeta.StFeed)localObject).poster.set(this.jdField_a_of_type_Ovz.feed.recomForward.poster.get());
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(pcr.a("ext3", String.valueOf(((FeedCloudMeta.StFeed)localObject).createTime)));
      int i = -1;
      if (this.jdField_a_of_type_Ovz.a != null) {
        i = this.jdField_a_of_type_Ovz.a.mDataPosition;
      }
      pcl.a(((FeedCloudMeta.StFeed)localObject).poster.id.get(), 65, 2, i, (FeedCloudMeta.StFeed)localObject, localArrayList);
      localObject = ((FeedCloudMeta.StFeed)localObject).id.get();
      rwv.a().a(new QCircleFeedEvent((String)localObject, 3));
      QQToast.a(getActivity(), 2, 2131700079, 0).show();
      return;
      localObject = this.jdField_a_of_type_Ovz.feed;
    }
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> bu()
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
  
  private List<ShareActionSheetBuilder.ActionSheetItem> bv()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Ovz == null) {}
    do
    {
      return localArrayList;
      if (this.jdField_a_of_type_Ovz.ayJ) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
      }
      if (this.jdField_a_of_type_Ovz.ayK) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
      }
    } while (!this.jdField_a_of_type_Ovz.ayL);
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(44));
    return localArrayList;
  }
  
  public static String cutString(String paramString)
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
  
  private void e(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int i = paramActionSheetItem.action;
    Message localMessage = new Message();
    localMessage.what = i;
    r("share_action_sheet_click_callback", localMessage);
    QLog.d("QCircleSharePart", 1, "handleClickMenuItem  action:" + i + "  pageId:" + pcr.a().getPageId() + "  parentPageId:" + pcr.a().sb());
    switch (i)
    {
    }
    for (;;)
    {
      this.c.dismiss();
      return;
      shareToQQ();
      continue;
      f(paramActionSheetItem);
      continue;
      bir();
      continue;
      vf(i);
      continue;
      report();
      continue;
      NA();
      continue;
      bit();
    }
  }
  
  private void f(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_req", ForwardRecentActivity.bGS);
    localBundle.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
    localBundle.putString("key_direct_show_uin", paramActionSheetItem.uin);
    paramActionSheetItem = n();
    if (paramActionSheetItem != null)
    {
      paramActionSheetItem.putExtras(localBundle);
      ahgq.a(getActivity(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 19005);
      QLog.d("QCircleSharePart", 1, "shareToSpecifiedFriend  success");
    }
    if (pcr.a().ez(57))
    {
      pcp.b(24, 2, this.jdField_a_of_type_Ovz.a);
      return;
    }
    if (pcr.a().ez(32))
    {
      pco.b(this.jdField_a_of_type_Ovz.feed.poster.id.get(), 11, 9L, 0L);
      return;
    }
    pcl.a(24, 2, this.jdField_a_of_type_Ovz.a);
  }
  
  private Intent n()
  {
    if ((this.jdField_a_of_type_Ovz == null) || (this.jdField_a_of_type_Ovz.feed == null) || (this.jdField_a_of_type_Ovz.feed.share == null) || (getActivity() == null)) {
      return null;
    }
    Intent localIntent = new Intent(getActivity().getApplicationContext(), ForwardRecentActivity.class);
    try
    {
      Object localObject = new JSONObject(this.jdField_a_of_type_Ovz.feed.share.shareCardInfo.get());
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
      localIntent.putExtras(aqjn.a.a(str2, str4, str3, (String)localObject, adqr.getDensity(), null, null));
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
  
  private void report()
  {
    if ((this.jdField_a_of_type_Ovz == null) || (this.jdField_a_of_type_Ovz.feed == null) || (getContext() == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    sgq.a locala = new sgq.a();
    locala.system = "android";
    locala.version = AppSetting.getVersion();
    locala.aDR = "1";
    locala.appname = "KQQ";
    locala.appid = "2400002";
    if (this.jdField_a_of_type_Ovz.type == 0)
    {
      locala.aDT = "wezone_feed";
      locala.scene = "25014";
      if (this.jdField_a_of_type_Ovz.feed.isRecomFd.get())
      {
        locala.aDS = this.jdField_a_of_type_Ovz.feed.recomForward.poster.id.get();
        localStringBuilder.append("ctim=").append(this.jdField_a_of_type_Ovz.feed.createTime.get()).append("|").append("feed_id=").append(this.jdField_a_of_type_Ovz.feed.id.get());
      }
    }
    for (;;)
    {
      locala.contentid = localStringBuilder.toString();
      locala.aDU = "0";
      sgq.a(getContext(), locala);
      QLog.d("QCircleSharePart", 1, "report  success");
      if (!pcr.a().ez(57)) {
        break label319;
      }
      pcp.b(23, 2, this.jdField_a_of_type_Ovz.a);
      return;
      locala.aDS = this.jdField_a_of_type_Ovz.feed.poster.id.get();
      break;
      if (this.jdField_a_of_type_Ovz.type == 1)
      {
        locala.aDT = "wezone_profile";
        locala.scene = "25015";
        locala.aDS = this.jdField_a_of_type_Ovz.feed.poster.id.get();
      }
    }
    label319:
    if (pcr.a().ez(32))
    {
      pco.h(this.jdField_a_of_type_Ovz.feed.poster.id.get(), 11, 8L);
      return;
    }
    pcl.a(23, 2, this.jdField_a_of_type_Ovz.a);
  }
  
  private void shareToQQ()
  {
    Intent localIntent = n();
    if ((localIntent == null) && (getActivity() != null))
    {
      QQToast.a(getActivity(), acfp.m(2131715061), 0).show();
      return;
    }
    if (getActivity() != null)
    {
      getActivity().startActivityForResult(localIntent, 21);
      QLog.d("QCircleSharePart", 1, "shareToQQ  success");
    }
    if (pcr.a().ez(57))
    {
      pcp.b(25, 2, this.jdField_a_of_type_Ovz.a);
      return;
    }
    if (pcr.a().ez(32))
    {
      pco.b(this.jdField_a_of_type_Ovz.feed.poster.id.get(), 11, 9L, 1L);
      return;
    }
    if (pcr.a().ez(31))
    {
      pco.b(this.jdField_a_of_type_Ovz.feed.poster.id.get(), 6, 4L, 1L);
      return;
    }
    pcl.a(25, 2, this.jdField_a_of_type_Ovz.a);
  }
  
  private void vf(int paramInt)
  {
    if ((this.jdField_a_of_type_Ovz == null) || (this.jdField_a_of_type_Ovz.feed == null) || (this.jdField_a_of_type_Ovz.feed.share == null) || (getActivity() == null)) {
      return;
    }
    String str1;
    String str2;
    Object localObject1;
    if (pcr.a().ez(57))
    {
      if (paramInt == 9) {}
      for (i = 27;; i = 28)
      {
        pcp.b(i, 2, this.jdField_a_of_type_Ovz.a);
        localObject2 = this.jdField_a_of_type_Ovz.feed.share.url.get();
        str1 = cutString(this.jdField_a_of_type_Ovz.feed.share.title.get());
        str2 = cutString(this.jdField_a_of_type_Ovz.feed.share.desc.get());
        localObject1 = new HashMap(1);
        if ((localObject2 != null) && (!((String)localObject2).isEmpty())) {
          break;
        }
        QQToast.a(getActivity(), 1, acfp.m(2131715058), 0).show();
        return;
      }
    }
    long l;
    if (pcr.a().ez(32))
    {
      localObject1 = this.jdField_a_of_type_Ovz.feed.poster.id.get();
      if (paramInt == 9) {}
      for (l = 3L;; l = 4L)
      {
        pco.b((String)localObject1, 11, 9L, l);
        break;
      }
    }
    if (pcr.a().ez(31))
    {
      localObject1 = this.jdField_a_of_type_Ovz.feed.poster.id.get();
      if (paramInt == 9) {}
      for (l = 3L;; l = 4L)
      {
        pco.b((String)localObject1, 6, 4L, l);
        break;
      }
    }
    if (paramInt == 9) {}
    for (int i = 27;; i = 28)
    {
      pcl.a(i, 2, this.jdField_a_of_type_Ovz.a);
      break;
    }
    if (!WXShareHelper.a().isWXinstalled())
    {
      rwt.ez(0, 2131721935);
      return;
    }
    if (!WXShareHelper.a().isWXsupportApi())
    {
      rwt.ez(0, 2131721936);
      return;
    }
    bis();
    Object localObject2 = new QCircleSharePart.3(this, (Map)localObject1, str1, str2, (String)localObject2, paramInt);
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Ovz.feed.poster.id.get())) && (TextUtils.isEmpty(this.jdField_a_of_type_Ovz.feed.share.cover.picUrl.get())))
    {
      QLog.d("QCircleSharePart", 1, "shareToWeChat no picture");
      ((Runnable)localObject2).run();
      return;
    }
    aT(getActivity());
    this.m.setMessage(2131695695);
    this.m.show();
    ThreadManager.post(new QCircleSharePart.4(this, (Map)localObject1, (Runnable)localObject2), 8, null, false);
  }
  
  protected void dC(View paramView)
  {
    super.dC(paramView);
    biq();
  }
  
  public String getLogTag()
  {
    return "QCircleSharePart";
  }
  
  public void l(String paramString, Object paramObject)
  {
    if (TextUtils.equals(paramString, "share_action_show_share_sheet"))
    {
      if ((paramObject instanceof ovz))
      {
        this.jdField_a_of_type_Ovz = ((ovz)paramObject);
        if ((this.jdField_a_of_type_Ovz.a instanceof ReportExtraTypeInfo)) {
          ((ReportExtraTypeInfo)this.jdField_a_of_type_Ovz.a).mFeed = this.jdField_a_of_type_Ovz.feed;
        }
      }
      Qq();
    }
    super.l(paramString, paramObject);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    this.uA = false;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.uA = false;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    this.uA = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxh
 * JD-Core Version:    0.7.0.1
 */