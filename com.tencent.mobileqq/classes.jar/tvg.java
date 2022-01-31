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

public abstract class tvg
  implements Application.ActivityLifecycleCallbacks
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ComponentBaseFragment jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment;
  public QQAppInterface a;
  private tvn jdField_a_of_type_Tvn;
  
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
  
  public <T extends tyz> T a(ComponentBaseFragment paramComponentBaseFragment, String paramString, Class<T> paramClass)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment.a(paramComponentBaseFragment, paramString, paramClass);
    }
    return null;
  }
  
  public <T extends tyz> T a(Class<T> paramClass)
  {
    return a(null, paramClass);
  }
  
  public <T extends tyz> T a(String paramString, Class<T> paramClass)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment != null) {
      return a(this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment, paramString, paramClass);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  protected abstract void a(View paramView);
  
  public void a(ComponentBaseFragment paramComponentBaseFragment, View paramView, tvn paramtvn)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramComponentBaseFragment.getActivity();
    this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment = paramComponentBaseFragment;
    this.jdField_a_of_type_Tvn = paramtvn;
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
    this.jdField_a_of_type_Tvn.a(paramString, paramObject);
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
 * Qualified Name:     tvg
 * JD-Core Version:    0.7.0.1
 */