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

public class vgg
  extends vbk
  implements aaam
{
  private aabg<QCircleReportBean> jdField_a_of_type_Aabg;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private vai jdField_a_of_type_Vai;
  
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
      vtq.a(str, 8, 1, 0, i);
      if (this.jdField_a_of_type_Vai != null) {
        this.jdField_a_of_type_Vai.onRefreshData();
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(a().getRootView(), 81, 0, 0);
      return;
    }
  }
  
  public void a(aabg<QCircleReportBean> paramaabg)
  {
    this.jdField_a_of_type_Aabg = paramaabg;
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_Vai = new vai(null);
    if (this.jdField_a_of_type_Aabg != null) {
      this.jdField_a_of_type_Vai.a(this.jdField_a_of_type_Aabg);
    }
    for (;;)
    {
      a().add(this.jdField_a_of_type_Vai);
      super.a(paramView);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(a(), -1, -1);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131755543);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(a());
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      a().a().setBackgroundResource(2130844123);
      a().setBackgroundResource(2131165355);
      a().setOnClickListener(new vgh(this));
      a().setPadding(0, (int)(zft.b(a()) * 0.6D), 0, 0);
      return;
      if (a() != null) {
        this.jdField_a_of_type_Vai.a(a());
      }
    }
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
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getParentPageId("QCircleTaskCenterPart", (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
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
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getPageId("QCircleTaskCenterPart", (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
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
    aaak.a().a(this);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    aaak.a().b(this);
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
 * Qualified Name:     vgg
 * JD-Core Version:    0.7.0.1
 */