import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class vec
  extends uzu
  implements zwr
{
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private uyv jdField_a_of_type_Uyv;
  private zxl<QCircleReportBean> jdField_a_of_type_Zxl;
  
  public String a()
  {
    return "QCircleTaskCenterPart";
  }
  
  public void a()
  {
    String str;
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
    {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (!QCircleReportBean.isContentDetailPage(c())) {
        break label84;
      }
    }
    label84:
    for (int i = b();; i = c())
    {
      vrf.a(str, 8, 1, 0, i);
      if (this.jdField_a_of_type_Uyv != null) {
        this.jdField_a_of_type_Uyv.onRefreshData();
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(a().getRootView(), 81, 0, 0);
      return;
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_Uyv = new uyv(null);
    if (this.jdField_a_of_type_Zxl != null) {
      this.jdField_a_of_type_Uyv.a(this.jdField_a_of_type_Zxl);
    }
    for (;;)
    {
      a().add(this.jdField_a_of_type_Uyv);
      super.a(paramView);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(a(), -1, -1);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131755542);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(a());
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      a().a().setBackgroundResource(2130844110);
      a().setBackgroundResource(2131165355);
      a().setOnClickListener(new ved(this));
      a().setPadding(0, (int)(zby.b(a()) * 0.6D), 0, 0);
      return;
      if (a() != null) {
        this.jdField_a_of_type_Uyv.a(a());
      }
    }
  }
  
  public void a(zxl<QCircleReportBean> paramzxl)
  {
    this.jdField_a_of_type_Zxl = paramzxl;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
    {
      b();
      return true;
    }
    return super.a();
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getParentPageId("QCircleTaskCenterPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getParentPageId("QCircleTaskCenterPart", (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
    }
    return 0;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  protected int c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getPageId("QCircleTaskCenterPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getPageId("QCircleTaskCenterPart", (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
    }
    return 0;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleTaskCenterEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    b();
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    zwp.a().a(this);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof QCircleTaskCenterEvent)) || (((QCircleTaskCenterEvent)paramSimpleBaseEvent).mPopContextHashCode != a().hashCode())) {
      return;
    }
    if (((QCircleTaskCenterEvent)paramSimpleBaseEvent).mIsShowTaskPanel)
    {
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vec
 * JD-Core Version:    0.7.0.1
 */