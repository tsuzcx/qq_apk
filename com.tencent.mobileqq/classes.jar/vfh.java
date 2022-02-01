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
import com.tencent.biz.qqcircle.launchbean.QCircleFollowUserBean;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleSettingBean;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleSpecialFollowListBlock;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class vfh
  extends vbk
  implements aaam, View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final vqu jdField_a_of_type_Vqu = vqu.a();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private void a()
  {
    int i = this.jdField_a_of_type_Vqu.a();
    QLog.i("QCircleSettingContentPart", 4, "updateSpecialCareCnt: " + i);
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    if (i < 100)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("" + i);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("99+");
  }
  
  public String a()
  {
    return "QCircleSettingContentPart";
  }
  
  protected void a(View paramView)
  {
    QCircleSettingBean localQCircleSettingBean = (QCircleSettingBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    this.jdField_a_of_type_Boolean = localQCircleSettingBean.canJumpProfile();
    this.b = localQCircleSettingBean.canSyncTroopARK();
    paramView.findViewById(2131374061).setOnClickListener(this);
    paramView.findViewById(2131374065).setOnClickListener(this);
    paramView.findViewById(2131369411).setOnClickListener(this);
    paramView.findViewById(2131374064).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374066));
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
    aaak.a().a(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    QLog.i("QCircleSettingContentPart", 4, "onActivityDestroyed");
    aaak.a().b(this);
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
      Object localObject = new QCircleSettingBean();
      ((QCircleSettingBean)localObject).setCanJumpProfile(this.jdField_a_of_type_Boolean);
      ((QCircleSettingBean)localObject).setCanSyncTroopARK(this.b);
      ((QCircleSettingBean)localObject).setFromReportBean(a().clone().setElementIdStr("portraitlist"));
      uyx.b(paramView.getContext(), (QCircleSettingBean)localObject);
      vtq.a("", 11, 22, 2);
      continue;
      if ((!a().onBackEvent()) && (a() != null))
      {
        a().finish();
        continue;
        localObject = new QCircleInitBean();
        ((QCircleInitBean)localObject).setFromReportBean(a().clone());
        uyx.d(paramView.getContext(), (QCircleInitBean)localObject);
        continue;
        localObject = new QCircleFollowUserBean();
        ((QCircleFollowUserBean)localObject).setFromReportBean(a());
        ((QCircleFollowUserBean)localObject).setAdapterClassName(QCircleSpecialFollowListBlock.class.getName());
        uyx.a(a(), (QCircleFollowUserBean)localObject);
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
 * Qualified Name:     vfh
 * JD-Core Version:    0.7.0.1
 */