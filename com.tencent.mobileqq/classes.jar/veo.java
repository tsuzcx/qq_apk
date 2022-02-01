import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleSettingBean;
import com.tencent.biz.qqcircle.requests.QCircleGetCircleUnCareListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import common.config.service.QzoneConfig;

public class veo
  extends vbk
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private Switch b;
  
  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    if (paramInt < 100)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("" + paramInt);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("99+");
  }
  
  public String a()
  {
    return "QCirclePrivacySettingContentPart";
  }
  
  protected void a(View paramView)
  {
    QCircleSettingBean localQCircleSettingBean = (QCircleSettingBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131374063));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setThumbResource(2130844108);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setTrackResource(2130844110);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(localQCircleSettingBean.canJumpProfile());
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new vep(this));
    View localView = paramView.findViewById(2131374060);
    this.b = ((Switch)paramView.findViewById(2131374062));
    this.b.setThumbResource(2130844108);
    this.b.setTrackResource(2130844110);
    this.b.setChecked(localQCircleSettingBean.canSyncTroopARK());
    this.b.setOnCheckedChangeListener(new ver(this));
    if (!QzoneConfig.isQQCircleShowTroopToolBarEntrance())
    {
      QLog.i("QCirclePrivacySettingContentPartonInitView", 2, "QzoneConfig.isQQCircleShowTroopToolBarEntrance()==false");
      localView.setVisibility(8);
    }
    paramView.findViewById(2131369411).setOnClickListener(this);
    paramView.findViewById(2131374059).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373892));
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    VSNetworkHelper.a().a(new QCircleGetCircleUnCareListRequest(1), new vet(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!a().onBackEvent()) && (a() != null))
      {
        a().finish();
        continue;
        uyx.e(paramView.getContext(), new QCircleInitBean());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     veo
 * JD-Core Version:    0.7.0.1
 */