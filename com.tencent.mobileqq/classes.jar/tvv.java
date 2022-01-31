import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.qqcircle.component.ComponentBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class tvv
  implements Application.ActivityLifecycleCallbacks
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ComponentBaseFragment jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment;
  public QQAppInterface a;
  private tvx jdField_a_of_type_Tvx;
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public Context a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      return this.jdField_a_of_type_AndroidAppActivity;
    }
    return null;
  }
  
  public ComponentBaseFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment;
  }
  
  public abstract String a();
  
  public tvx a()
  {
    return this.jdField_a_of_type_Tvx;
  }
  
  public <T extends ubk> T a(ComponentBaseFragment paramComponentBaseFragment, String paramString, Class<T> paramClass)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment.a(paramComponentBaseFragment, paramString, paramClass);
    }
    return null;
  }
  
  public <T extends ubk> T a(Class<T> paramClass)
  {
    return a(null, paramClass);
  }
  
  public <T extends ubk> T a(String paramString, Class<T> paramClass)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment != null) {
      return a(this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment, paramString, paramClass);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  protected void a(View paramView)
  {
    QLog.d(a(), 1, a() + "->onInitView");
  }
  
  public void a(ComponentBaseFragment paramComponentBaseFragment, View paramView, tvx paramtvx)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramComponentBaseFragment.getActivity();
    this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment = paramComponentBaseFragment;
    this.jdField_a_of_type_Tvx = paramtvx;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramComponentBaseFragment.getActivity().app;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(String paramString, Object paramObject) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void b(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_Tvx.a(paramString, paramObject);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvv
 * JD-Core Version:    0.7.0.1
 */