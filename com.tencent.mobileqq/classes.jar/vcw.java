import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import qqcircle.QQCircleFeedBase.StBusiInfoData;

public class vcw
  extends uzu
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 2;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private biau jdField_a_of_type_Biau;
  private FeedCloudMeta.StTagInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private vcz jdField_a_of_type_Vcz = new vcz(this, null);
  private zxl<QCircleReportBean> jdField_a_of_type_Zxl;
  private boolean jdField_a_of_type_Boolean;
  
  public vcw(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramStUser;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo == null) {
      return;
    }
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "QcircleCertifyTagUrl", "https://h5.qzone.qq.com/v2/wezone/auth?type={type}&busitype=1&groupname={groupname}&_wv=3&_proxy=1");
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagType.get() == 2) {}
    for (int i = 0;; i = 1)
    {
      localObject = ((String)localObject).replace("{type}", String.valueOf(i));
      try
      {
        String str = ((String)localObject).replace("{groupname}", URLEncoder.encode(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get(), "utf-8"));
        localObject = str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          QLog.e("QCirclePublishFeedPart", 1, "goToH5CertifyTag encodeTag failed.", localUnsupportedEncodingException);
        }
      }
      uxo.a(a(), (String)localObject);
      return;
    }
  }
  
  private void c()
  {
    boolean bool = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
    this.jdField_a_of_type_Biau.show();
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    if (LocalMultiProcConfig.getInt4Uin("_qq_circle_publish", 0, l) == 1) {
      bool = true;
    }
    QLog.i("QCirclePublishFeedPart", 1, "plus button clicked. hasDraft=" + bool);
    Bundle localBundle = new Bundle();
    localBundle.putLong("PhotoConst.timestamp", System.currentTimeMillis());
    localBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
    Object localObject = new QQCircleFeedBase.StBusiInfoData();
    ((QQCircleFeedBase.StBusiInfoData)localObject).schoolInfos.set(uxc.a());
    ((QQCircleFeedBase.StBusiInfoData)localObject).companyInfos.set(uxc.b());
    localBundle.putByteArray("key_qcircle_publish_busi_info", ((QQCircleFeedBase.StBusiInfoData)localObject).toByteArray());
    localObject = a().getIntent().getStringExtra("key_scheme");
    localBundle.putSerializable("key_bundle_common_init_bean", new uxk().a(a().clone().setElementIdStr("post")).a());
    localBundle.putInt("key_qcircle_entrance_type", 3);
    localBundle.putAll(a().getIntent().getExtras());
    if ((bool) && (TextUtils.isEmpty((CharSequence)localObject)))
    {
      uxo.a(a(), localBundle, String.valueOf(l), this.jdField_a_of_type_Int);
      return;
    }
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo != null)
    {
      localBundle.putString("key_qcircle_publish_default_tag_id", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagId.get());
      localBundle.putString("key_qcircle_publish_default_tag_name", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get());
    }
    uxo.a(a(), localBundle, null, this.jdField_a_of_type_Int);
  }
  
  public String a()
  {
    return "QCirclePublishFeedPart";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.performClick();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373153));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (uxx.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser))) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Biau = new biau(a());
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = paramStTagInfo;
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    int i;
    if (TextUtils.equals(paramString, "tab_changed")) {
      if ((paramObject instanceof Integer))
      {
        i = ((Integer)paramObject).intValue();
        if (i != 1) {
          break label42;
        }
        this.jdField_a_of_type_Int = 2;
      }
    }
    label41:
    label42:
    do
    {
      boolean bool;
      do
      {
        do
        {
          do
          {
            break label41;
            break label41;
            do
            {
              return;
            } while (i != 6);
            this.jdField_a_of_type_Int = 3;
            return;
            if (!TextUtils.equals(paramString, "tab_rsp")) {
              break;
            }
          } while (!(paramObject instanceof FeedCloudMeta.StTagInfo));
          this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = ((FeedCloudMeta.StTagInfo)paramObject);
          return;
          if (!TextUtils.equals(paramString, "publish_show_or_hide")) {
            break;
          }
        } while (!(paramObject instanceof Boolean));
        bool = ((Boolean)paramObject).booleanValue();
      } while ((!uxx.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
      paramString = this.jdField_a_of_type_AndroidWidgetImageView;
      if (bool) {}
      for (i = 0;; i = 8)
      {
        paramString.setVisibility(i);
        return;
      }
    } while (!TextUtils.equals(paramString, "publish_on_click"));
    a();
  }
  
  public void a(zxl<QCircleReportBean> paramzxl)
  {
    this.jdField_a_of_type_Zxl = paramzxl;
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getParentPageId(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getParentPageId(a(), (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
    }
    return 0;
  }
  
  protected int c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getPageId(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getPageId(a(), (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
    }
    return 0;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("action_update_native_auth_info");
    paramActivity.registerReceiver(this.jdField_a_of_type_Vcz, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    paramActivity.unregisterReceiver(this.jdField_a_of_type_Vcz);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      paramActivity = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("ext1", String.valueOf(uxx.c(this.jdField_a_of_type_Int))) }));
      vrf.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 14, 1, 0, paramActivity, null, c());
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    this.jdField_a_of_type_Biau.dismiss();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      ((AppActivity)a()).requestPermissions(new vcy(this), 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("ext1", String.valueOf(uxx.c(this.jdField_a_of_type_Int))) }));
      vrf.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 14, 2, 0, localArrayList, null, c());
      break;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcw
 * JD-Core Version:    0.7.0.1
 */