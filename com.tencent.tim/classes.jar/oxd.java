import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import qqcircle.QQCircleFeedBase.StBusiInfoData;

public class oxd
  extends rxk
  implements View.OnClickListener
{
  private FeedCloudMeta.StTagInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private oxd.a jdField_a_of_type_Oxd$a = new oxd.a(null);
  private boolean ayX;
  private int fromType = 2;
  private ImageView lU;
  private arhz progressDialog;
  
  public oxd(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramStUser;
  }
  
  private void bio()
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
      oux.aX(getContext(), (String)localObject);
      return;
    }
  }
  
  private void bip()
  {
    boolean bool = false;
    this.lU.setClickable(false);
    this.progressDialog.show();
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    if (LocalMultiProcConfig.getInt4Uin("_qq_circle_publish", 0, l) == 1) {
      bool = true;
    }
    QLog.i("QCirclePublishFeedPart", 1, "plus button clicked. hasDraft=" + bool);
    Bundle localBundle = new Bundle();
    localBundle.putLong("PhotoConst.timestamp", System.currentTimeMillis());
    localBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
    QQCircleFeedBase.StBusiInfoData localStBusiInfoData = new QQCircleFeedBase.StBusiInfoData();
    localStBusiInfoData.schoolInfos.set(oum.bi());
    localStBusiInfoData.companyInfos.set(oum.bj());
    localBundle.putByteArray("key_qcircle_publish_busi_info", localStBusiInfoData.toByteArray());
    if (bool)
    {
      oux.b(getActivity(), localBundle, String.valueOf(l), this.fromType);
      return;
    }
    localBundle.putInt("key_qcircle_entrance_type", 3);
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo != null)
    {
      localBundle.putString("key_qcircle_publish_default_tag_id", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagId.get());
      localBundle.putString("key_qcircle_publish_default_tag_name", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get());
    }
    oux.b(getActivity(), localBundle, null, this.fromType);
  }
  
  public void bin()
  {
    if (this.lU != null) {
      this.lU.performClick();
    }
  }
  
  protected void dC(View paramView)
  {
    super.dC(paramView);
    this.lU = ((ImageView)paramView.findViewById(2131373892));
    this.lU.setOnClickListener(this);
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (ovd.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser))) {
      this.lU.setVisibility(0);
    }
    for (;;)
    {
      this.progressDialog = new arhz(getContext());
      return;
      this.lU.setVisibility(8);
    }
  }
  
  public String getLogTag()
  {
    return "QCirclePublishFeedPart";
  }
  
  public void l(String paramString, Object paramObject)
  {
    super.l(paramString, paramObject);
    if (TextUtils.equals(paramString, "tab_changed")) {
      if ((paramObject instanceof Integer))
      {
        i = ((Integer)paramObject).intValue();
        if (i != 1) {
          break label42;
        }
        this.fromType = 2;
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
      this.fromType = 3;
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = ((FeedCloudMeta.StTagInfo)paramObject);
  }
  
  public void nA(int paramInt)
  {
    this.fromType = paramInt;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("action_update_native_auth_info");
    paramActivity.registerReceiver(this.jdField_a_of_type_Oxd$a, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    paramActivity.unregisterReceiver(this.jdField_a_of_type_Oxd$a);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.lU != null) {
      this.lU.setClickable(true);
    }
    if (!this.ayX)
    {
      pco.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 14, 1L, 0L, String.valueOf(ovd.dM(this.fromType)));
      this.ayX = true;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    this.progressDialog.dismiss();
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
      ((AppActivity)getActivity()).requestPermissions(new oxf(this), 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
    for (;;)
    {
      pco.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 14, 2L, 0L, String.valueOf(ovd.dM(this.fromType)));
      break;
      bip();
    }
  }
  
  public void setTagInfo(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = paramStTagInfo;
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i;
      int j;
      if ("action_update_native_auth_info".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("type", 1);
        j = paramIntent.getIntExtra("status", 0);
        paramContext = paramIntent.getStringExtra("tagName");
        if (i != 2) {
          break label59;
        }
        i = ovd.dL(j);
        ovd.b(oum.bi(), i, paramContext);
      }
      for (;;)
      {
        oum.bhL();
        return;
        label59:
        if (i == 3)
        {
          i = ovd.dL(j);
          ovd.b(oum.bj(), i, paramContext);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxd
 * JD-Core Version:    0.7.0.1
 */