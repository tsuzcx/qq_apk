import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleGoToCardSettingEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowListLoadEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleSyncToTroopSettingEvent;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class vdd
  extends uzu
  implements View.OnClickListener, zwr
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final vol jdField_a_of_type_Vol = vol.a();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private void a()
  {
    int i = this.jdField_a_of_type_Vol.a();
    QLog.i("QCircleSettingContentPart", 4, "updateSpecialCareCnt: " + i);
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("特别关注");
      return;
    }
    if (i < 100)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("特别关注 (" + i + ")");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("特别关注 (99+)");
  }
  
  public String a()
  {
    return "QCircleSettingContentPart";
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_Boolean = ((Activity)a()).getIntent().getBooleanExtra("key_bundle_support_mainpage_to_personalcard", true);
    this.b = ((Activity)a()).getIntent().getBooleanExtra("key_bundle_support_new_msg_sync_to_troop", true);
    paramView.findViewById(2131373923).setOnClickListener(this);
    paramView.findViewById(2131373927).setOnClickListener(this);
    paramView.findViewById(2131369322).setOnClickListener(this);
    paramView.findViewById(2131373926).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373928));
    a();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleGoToCardSettingEvent.class);
    localArrayList.add(QCircleSpecialFollowUpdateEvent.class);
    localArrayList.add(QCircleSpecialFollowListLoadEvent.class);
    localArrayList.add(QCircleSyncToTroopSettingEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    QLog.i("QCircleSettingContentPart", 4, "onActivityCreated");
    zwp.a().a(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    QLog.i("QCircleSettingContentPart", 4, "onActivityDestroyed");
    zwp.a().b(this);
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
      uxo.b(this.jdField_a_of_type_Boolean, this.b, a().clone().setElementIdStr("portraitlist"));
      vrf.a("", 11, 22, 2);
      continue;
      if ((!a().onBackEvent()) && (a() != null))
      {
        a().finish();
        continue;
        uxo.c(new uxk().a(a()).a());
        continue;
        uxo.a(a());
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleGoToCardSettingEvent)) {
      this.jdField_a_of_type_Boolean = ((QCircleGoToCardSettingEvent)paramSimpleBaseEvent).mShowCard;
    }
    do
    {
      return;
      if ((paramSimpleBaseEvent instanceof QCircleSyncToTroopSettingEvent))
      {
        this.b = ((QCircleSyncToTroopSettingEvent)paramSimpleBaseEvent).mCanSyncTroopARK;
        return;
      }
      if ((paramSimpleBaseEvent instanceof QCircleSpecialFollowUpdateEvent))
      {
        a();
        return;
      }
    } while (!(paramSimpleBaseEvent instanceof QCircleSpecialFollowListLoadEvent));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdd
 * JD-Core Version:    0.7.0.1
 */