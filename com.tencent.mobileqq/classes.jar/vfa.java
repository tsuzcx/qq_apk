import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleGuideBubbleView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LocalMultiProcConfig;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import qqcircle.QQCircleFeedBase.StBusiInfoData;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class vfa
  extends vbk
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 2;
  private aabg<QCircleReportBean> jdField_a_of_type_Aabg;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bjbs jdField_a_of_type_Bjbs;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean;
  private QCircleGuideBubbleView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleGuideBubbleView;
  private FeedCloudMeta.StTagInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private vfd jdField_a_of_type_Vfd = new vfd(this, null);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public vfa(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramStUser;
  }
  
  private void b()
  {
    if ((!uyk.a().a()) && (this.b) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleGuideBubbleView != null))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleGuideBubbleView.a(3000);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleGuideBubbleView.setOnShowListener(new vfb(this));
    }
  }
  
  private void c()
  {
    if (!vvw.a())
    {
      vvw.a(a(), 1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
    this.jdField_a_of_type_Bjbs.show();
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    if (LocalMultiProcConfig.getInt4Uin("_qq_circle_publish", 0, l) == 1) {}
    Bundle localBundle;
    for (boolean bool = true;; bool = false)
    {
      QLog.i("QCirclePublishFeedPart", 1, "plus button clicked. hasDraft=" + bool);
      localBundle = new Bundle();
      localBundle.putLong("PhotoConst.timestamp", System.currentTimeMillis());
      localBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
      Object localObject = new QQCircleFeedBase.StBusiInfoData();
      ((QQCircleFeedBase.StBusiInfoData)localObject).schoolInfos.set(uyn.a());
      ((QQCircleFeedBase.StBusiInfoData)localObject).companyInfos.set(uyn.b());
      localBundle.putByteArray("key_qcircle_publish_busi_info", ((QQCircleFeedBase.StBusiInfoData)localObject).toByteArray());
      localObject = new QCircleInitBean();
      ((QCircleInitBean)localObject).setFromReportBean(a().clone().setElementIdStr("post"));
      localBundle.putSerializable("key_bundle_common_init_bean", (Serializable)localObject);
      localBundle.putInt("key_qcircle_entrance_type", 3);
      localBundle.putBoolean("key_qcircle_reopen_carema", true);
      localBundle.putAll(a().getIntent().getExtras());
      if ((a() != null) && (a().getIntent() != null) && (a().getIntent().hasExtra("key_scheme")))
      {
        localBundle.putString("key_scheme", a().getIntent().getStringExtra("key_scheme"));
        a().getIntent().putExtra("key_scheme", "");
      }
      if (((this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean instanceof QCirclePolymerizationBean)) && ((((QCirclePolymerizationBean)this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean).getPolymerizationType() == 7) || (((QCirclePolymerizationBean)this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean).getPolymerizationType() == 20))) {
        localBundle.putBoolean("key_qcircle_publish_finish_jump_to_mainpage", true);
      }
      if (((this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean instanceof QCirclePolymerizationBean)) && (((QCirclePolymerizationBean)this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean).getPolymerizationType() == 20) && (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getSimulateData() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getSimulateData().simulate_schema.get()))) {
        localBundle.putString("key_scheme", this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getSimulateData().simulate_schema.get());
      }
      if ((!bool) || (!TextUtils.isEmpty(""))) {
        break;
      }
      uyx.a(a(), localBundle, String.valueOf(l), this.jdField_a_of_type_Int);
      return;
    }
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo != null)
    {
      localBundle.putString("key_qcircle_publish_default_tag_id", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagId.get());
      localBundle.putString("key_qcircle_publish_default_tag_name", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get());
    }
    uyx.a(a(), localBundle, null, this.jdField_a_of_type_Int);
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
  
  public void a(aabg<QCircleReportBean> paramaabg)
  {
    this.jdField_a_of_type_Aabg = paramaabg;
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373266));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) && (uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser))) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleGuideBubbleView = ((QCircleGuideBubbleView)paramView.findViewById(2131374026));
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleGuideBubbleView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleGuideBubbleView.setNeedFadeAnim(true);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleGuideBubbleView.setText(a().getResources().getString(2131697314));
      }
      this.jdField_a_of_type_Bjbs = new bjbs(a());
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(QCircleInitBean paramQCircleInitBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean = paramQCircleInitBean;
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
          break label46;
        }
        this.jdField_a_of_type_Int = 2;
      }
    }
    label45:
    label46:
    do
    {
      boolean bool;
      do
      {
        do
        {
          do
          {
            break label45;
            break label45;
            for (;;)
            {
              b();
              return;
              if (i == 6) {
                this.jdField_a_of_type_Int = 3;
              }
            }
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
      } while ((!uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
      paramString = this.jdField_a_of_type_AndroidWidgetImageView;
      if (bool) {}
      for (i = 0;; i = 8)
      {
        paramString.setVisibility(i);
        return;
      }
      if (TextUtils.equals(paramString, "publish_on_click"))
      {
        a();
        return;
      }
    } while (!TextUtils.equals(paramString, "show_publish_feed_guide_bubble"));
    b();
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getParentPageId(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getParentPageId(a(), (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return 0;
  }
  
  protected int c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getPageId(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getPageId(a(), (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return 0;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("action_update_native_auth_info");
    paramActivity.registerReceiver(this.jdField_a_of_type_Vfd, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    paramActivity.unregisterReceiver(this.jdField_a_of_type_Vfd);
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
      paramActivity = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("ext1", String.valueOf(uzg.c(this.jdField_a_of_type_Int))) }));
      vtq.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 14, 1, 0, paramActivity, null, c());
      this.jdField_a_of_type_Boolean = true;
    }
    this.b = uyk.a().c();
    b();
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
    if (Build.VERSION.SDK_INT >= 23) {
      ((AppActivity)a()).requestPermissions(new vfc(this), 0, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("ext1", String.valueOf(uzg.c(this.jdField_a_of_type_Int))) }));
      vtq.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 14, 2, 0, localArrayList, null, c());
      break;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfa
 * JD-Core Version:    0.7.0.1
 */