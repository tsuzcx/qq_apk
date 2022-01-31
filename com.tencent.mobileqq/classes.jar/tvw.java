import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import java.util.ArrayList;
import java.util.List;

public class tvw
  extends tvv
{
  private final int jdField_a_of_type_Int;
  private QCircleComponentPageView jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView;
  private final ArrayList<yhy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  private int c;
  
  public tvw()
  {
    this(0);
  }
  
  public tvw(int paramInt)
  {
    this(paramInt, null);
  }
  
  public tvw(int paramInt, List<yhy> paramList)
  {
    this(paramInt, paramList, 3, 1);
  }
  
  public tvw(int paramInt1, List<yhy> paramList, int paramInt2, int paramInt3)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    this.c = paramInt2;
    this.b = paramInt3;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public QCircleComponentPageView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView;
  }
  
  public QCircleStatusView a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView != null) {
      return (QCircleStatusView)this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.a();
    }
    return null;
  }
  
  public String a()
  {
    return "ComponentPageViewPart";
  }
  
  public ArrayList<yhy> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (this.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView = ((QCircleComponentPageView)paramView.findViewById(this.jdField_a_of_type_Int));
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView == null) {
      this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView = new QCircleComponentPageView(paramView.getContext());
    }
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.setLayoutManagerType(this.c, this.b);
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.setPartWrapper(this);
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.setParentFragment(a());
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.c();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleComponentQCircleComponentPageView.a())) {
      return true;
    }
    return super.a();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityDestroyed(paramActivity);
    }
    if (a() != null) {
      a().b();
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
 * Qualified Name:     tvw
 * JD-Core Version:    0.7.0.1
 */