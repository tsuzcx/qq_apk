import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class tua
  extends tvw
  implements yiy
{
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private trt jdField_a_of_type_Trt;
  
  public String a()
  {
    return "QCircleTaskCenterPart";
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
    {
      tzv.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 8, 1L);
      if (this.jdField_a_of_type_Trt != null) {
        this.jdField_a_of_type_Trt.onRefreshData();
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(a().getRootView(), 81, 0, 0);
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_Trt = new trt(null);
    a().add(this.jdField_a_of_type_Trt);
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(a(), -1, -1);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131755523);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(a());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    a().a().setBackgroundResource(2130843738);
    a().setBackgroundResource(2131165319);
    a().setOnClickListener(new tub(this));
    a().setPadding(0, (int)(xin.b(a()) * 0.6D), 0, 0);
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
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
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
    yiw.a().a(this);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    yiw.a().b(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tua
 * JD-Core Version:    0.7.0.1
 */