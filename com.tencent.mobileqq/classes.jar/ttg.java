import android.app.Activity;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import qqcircle.QQCircleFeedBase.StBusiInfoData;

public class ttg
  extends tvv
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 2;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bety jdField_a_of_type_Bety;
  private FeedCloudMeta.StTagInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private ttj jdField_a_of_type_Ttj = new ttj(this, null);
  private boolean jdField_a_of_type_Boolean;
  
  public ttg(FeedCloudMeta.StUser paramStUser)
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
      tqs.a(a(), (String)localObject);
      return;
    }
  }
  
  private void c()
  {
    boolean bool = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
    this.jdField_a_of_type_Bety.show();
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    if (LocalMultiProcConfig.getInt4Uin("_qq_circle_publish", 0, l) == 1) {
      bool = true;
    }
    QLog.i("QCirclePublishFeedPart", 1, "plus button clicked. hasDraft=" + bool);
    if (bool)
    {
      localBundle = new Bundle();
      localStBusiInfoData = new QQCircleFeedBase.StBusiInfoData();
      localStBusiInfoData.schoolInfos.set(tqg.a());
      localStBusiInfoData.companyInfos.set(tqg.b());
      localBundle.putLong("PhotoConst.timestamp", System.currentTimeMillis());
      localBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
      localBundle.putByteArray("key_qcircle_publish_busi_info", localStBusiInfoData.toByteArray());
      tqs.a(a(), localBundle, String.valueOf(l), this.jdField_a_of_type_Int);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_qcircle_entrance_type", 3);
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo != null)
    {
      localBundle.putString("key_qcircle_publish_default_tag_id", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagId.get());
      localBundle.putString("key_qcircle_publish_default_tag_name", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get());
    }
    QQCircleFeedBase.StBusiInfoData localStBusiInfoData = new QQCircleFeedBase.StBusiInfoData();
    localStBusiInfoData.schoolInfos.set(tqg.a());
    localStBusiInfoData.companyInfos.set(tqg.b());
    localBundle.putLong("PhotoConst.timestamp", System.currentTimeMillis());
    localBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
    localBundle.putByteArray("key_qcircle_publish_busi_info", localStBusiInfoData.toByteArray());
    tqs.a(a(), localBundle, null, this.jdField_a_of_type_Int);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372542));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser))) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bety = new bety(a());
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
    label42:
    while ((!TextUtils.equals(paramString, "tab_rsp")) || (!(paramObject instanceof FeedCloudMeta.StTagInfo)))
    {
      int i;
      do
      {
        return;
      } while (i != 6);
      this.jdField_a_of_type_Int = 3;
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = ((FeedCloudMeta.StTagInfo)paramObject);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("action_update_native_auth_info");
    paramActivity.registerReceiver(this.jdField_a_of_type_Ttj, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    paramActivity.unregisterReceiver(this.jdField_a_of_type_Ttj);
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
      tzv.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 14, 1L, 0L, String.valueOf(tra.b(this.jdField_a_of_type_Int)));
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    this.jdField_a_of_type_Bety.dismiss();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      ((AppActivity)a()).requestPermissions(new tti(this), 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
    for (;;)
    {
      tzv.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 14, 2L, 0L, String.valueOf(tra.b(this.jdField_a_of_type_Int)));
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttg
 * JD-Core Version:    0.7.0.1
 */