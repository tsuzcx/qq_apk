import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderActivityChipPart.1;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderActivityChipPart.2;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class vbf
  extends uzu
  implements View.OnClickListener, zwr
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleFuelAnimationEvent jdField_a_of_type_ComTencentBizQqcircleEventsQCircleFuelAnimationEvent;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private zxl<QCircleReportBean> jdField_a_of_type_Zxl;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private View d;
  private View e;
  
  private void a(QCircleFuelAnimationEvent paramQCircleFuelAnimationEvent)
  {
    vog.a().a(paramQCircleFuelAnimationEvent.getPublishTask());
    vog.a().a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, false);
  }
  
  private boolean b()
  {
    return c() == 3;
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleFolderActivityChipPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean).clone().setModuleIdStr(b());
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getReportBean("QCircleFolderActivityChipPart", (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean()).clone().setModuleIdStr(b());
    }
    return new QCircleReportBean();
  }
  
  public String a()
  {
    return "QCircleFolderActivityChipPart";
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373165);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131373163);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131373152);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.d = paramView.findViewById(2131373155);
    this.d.setOnClickListener(this);
    vrf.a("", 4, 1);
    this.e = paramView.findViewById(2131373151);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131373154));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373835));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373838));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373837));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373836));
    this.e.setOnClickListener(this);
    if ((a() != null) && ((a() instanceof BaseActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(aoch.a(((BaseActivity)a()).app, 1, 4, uxc.a()));
    }
  }
  
  public void a(zxl<QCircleReportBean> paramzxl)
  {
    this.jdField_a_of_type_Zxl = paramzxl;
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
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFuelAnimationEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    zwp.a().a(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    zwp.a().b(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new QCircleFolderActivityChipPart.2(this), 1000L);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onClick(View paramView)
  {
    String str = "1";
    if (b()) {
      str = "2";
    }
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((BaseActivity)a()).doOnBackPressed();
      vrf.a("", 21, 1, 0, str, "", "", "", "");
      continue;
      uxo.a(a(), uxn.a, null);
      vrf.a("", 4, 2);
      continue;
      vrf.a("", 21, 2, 0, str, "", "", "", "");
      uxo.a(uxc.a(), a().clone().setElementIdStr("portrait"));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFuelAnimationEvent)) {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new QCircleFolderActivityChipPart.1(this, paramSimpleBaseEvent), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbf
 * JD-Core Version:    0.7.0.1
 */