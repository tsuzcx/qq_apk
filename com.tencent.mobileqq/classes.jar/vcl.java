import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import common.config.service.QzoneConfig;

public class vcl
  extends uzu
  implements View.OnClickListener
{
  private Switch a;
  private Switch b;
  
  public String a()
  {
    return "QCirclePrivacySettingContentPart";
  }
  
  protected void a(View paramView)
  {
    boolean bool1 = ((Activity)a()).getIntent().getBooleanExtra("key_bundle_support_mainpage_to_personalcard", true);
    boolean bool2 = ((Activity)a()).getIntent().getBooleanExtra("key_bundle_support_new_msg_sync_to_troop", true);
    this.a = ((Switch)paramView.findViewById(2131373925));
    this.a.setThumbResource(2130844094);
    this.a.setTrackResource(2130844096);
    this.a.setChecked(bool1);
    this.a.setOnCheckedChangeListener(new vcm(this));
    View localView = paramView.findViewById(2131373922);
    this.b = ((Switch)paramView.findViewById(2131373924));
    this.b.setThumbResource(2130844094);
    this.b.setTrackResource(2130844096);
    this.b.setChecked(bool2);
    this.b.setOnCheckedChangeListener(new vco(this));
    if (!QzoneConfig.isQQCircleShowTroopToolBarEntrance())
    {
      QLog.i("QCirclePrivacySettingContentPartonInitView", 2, "QzoneConfig.isQQCircleShowTroopToolBarEntrance()==false");
      localView.setVisibility(8);
    }
    paramView.findViewById(2131369322).setOnClickListener(this);
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
      if ((!a().onBackEvent()) && (a() != null)) {
        a().finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcl
 * JD-Core Version:    0.7.0.1
 */