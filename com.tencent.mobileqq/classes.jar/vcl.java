import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.qqcircle.launchbean.QCircleFolderBean;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LocalMultiProcConfig;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import qqcircle.QQCircleFeedBase.StBusiInfoData;

public class vcl
  extends vbk
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 5;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bjbs jdField_a_of_type_Bjbs;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    if (!vvw.a())
    {
      vvw.a(a(), 1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_Bjbs.show();
    if (LocalMultiProcConfig.getInt4Uin("_qq_circle_publish", 0, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("QCircleContentDetailPublishFeedPart", 1, "plus button clicked. hasDraft=" + bool);
      Bundle localBundle = new Bundle();
      localBundle.putLong("PhotoConst.timestamp", System.currentTimeMillis());
      localBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
      Object localObject = new QQCircleFeedBase.StBusiInfoData();
      ((QQCircleFeedBase.StBusiInfoData)localObject).schoolInfos.set(uyn.a());
      ((QQCircleFeedBase.StBusiInfoData)localObject).companyInfos.set(uyn.b());
      localBundle.putByteArray("key_qcircle_publish_busi_info", ((QQCircleFeedBase.StBusiInfoData)localObject).toByteArray());
      localBundle.putBoolean("key_need_use_draft", false);
      localObject = a().getIntent();
      if (localObject != null)
      {
        localBundle.putString("key_scheme", ((Intent)localObject).getStringExtra("key_scheme"));
        ((Intent)localObject).putExtra("key_scheme", "");
      }
      localBundle.putInt("key_qcircle_entrance_type", 3);
      if (paramStTagInfo != null)
      {
        localBundle.putString("key_qcircle_publish_default_tag_id", paramStTagInfo.tagId.get());
        localBundle.putString("key_qcircle_publish_default_tag_name", paramStTagInfo.tagName.get());
      }
      uyx.a(a(), localBundle, null, 100);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 37857) && (paramInt2 == -1)) {
      uyx.a(a(), new QCircleFolderBean());
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131374028));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_Bjbs = new bjbs(a());
    if (((QCircleInitBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean")).getTagInfo().has())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      paramActivity = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("ext1", String.valueOf(uzg.c(this.jdField_a_of_type_Int))) }));
      vtq.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 14, 1, 0, paramActivity, null, c());
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    this.jdField_a_of_type_Bjbs.dismiss();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject = ((QCircleInitBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean")).getTagInfo();
    if (Build.VERSION.SDK_INT >= 23) {
      ((AppActivity)a()).requestPermissions(new vcm(this, (FeedCloudMeta.StTagInfo)localObject), 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
    for (;;)
    {
      localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("ext1", String.valueOf(uzg.c(this.jdField_a_of_type_Int))) }));
      vtq.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 14, 2, 0, (List)localObject, null, c());
      break;
      a((FeedCloudMeta.StTagInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcl
 * JD-Core Version:    0.7.0.1
 */