import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqcircle.component.ComponentPageView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import java.util.ArrayList;
import java.util.List;

public class tvm
  extends tvg
{
  private final int jdField_a_of_type_Int;
  private ComponentPageView jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView;
  private final ArrayList<ydp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  private int c;
  
  public tvm()
  {
    this(0);
  }
  
  public tvm(int paramInt)
  {
    this(paramInt, null);
  }
  
  public tvm(int paramInt, List<ydp> paramList)
  {
    this(paramInt, paramList, 3, 1);
  }
  
  public tvm(int paramInt1, List<ydp> paramList, int paramInt2, int paramInt3)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    this.c = paramInt2;
    this.b = paramInt3;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public ComponentPageView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView;
  }
  
  public QCircleStatusView a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView.a();
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void a(View paramView)
  {
    if (this.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView = ((ComponentPageView)paramView.findViewById(this.jdField_a_of_type_Int));
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView == null) {
      this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView = new ComponentPageView(paramView.getContext());
    }
    this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView.setLayoutManagerType(this.c, this.b);
    this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView.setPartWrapper(this);
    this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView.setParentFragment(a());
    this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView.e();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentPageView.a())) {
      return true;
    }
    return super.a();
  }
  
  public ArrayList<ydp> b()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityDestroyed(paramActivity);
    }
    if (a() != null) {
      a().d();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityPaused(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityResumed(paramActivity);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityStarted(paramActivity);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityStopped(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvm
 * JD-Core Version:    0.7.0.1
 */