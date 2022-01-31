import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.biz.qqcircle.component.ComponentPageView;
import com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class ttl
  extends tvm
  implements yel
{
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private tro jdField_a_of_type_Tro;
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleTaskCenterEvent.class);
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
    {
      tyj.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 8, 1L);
      if (this.jdField_a_of_type_Tro != null) {
        this.jdField_a_of_type_Tro.o();
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(a().getRootView(), 81, 0, 0);
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_Tro = new tro(null);
    b().add(this.jdField_a_of_type_Tro);
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(a(), -1, -1);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131755523);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(a());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    a().a().setBackgroundResource(2130843674);
    a().setBackgroundResource(2131165319);
    a().setOnClickListener(new ttm(this));
    a().setPadding(0, (int)(xee.b(a()) * 0.6D), 0, 0);
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
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
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    b();
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    yej.a().a(this);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    yej.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttl
 * JD-Core Version:    0.7.0.1
 */