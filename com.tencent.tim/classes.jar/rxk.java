import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class rxk
  implements Application.ActivityLifecycleCallbacks
{
  private BasePartFragment jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment;
  private rxl jdField_a_of_type_Rxl;
  public QQAppInterface app;
  private Activity mActivity;
  private View mRootView;
  
  public <T extends rxi> T a(BasePartFragment paramBasePartFragment, String paramString, Class<T> paramClass)
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment != null) {
      return this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment.a(paramBasePartFragment, paramString, paramClass);
    }
    return null;
  }
  
  public <T extends rxi> T a(String paramString, Class<T> paramClass)
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment != null) {
      return a(this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment, paramString, paramClass);
    }
    return null;
  }
  
  public rxl a()
  {
    return this.jdField_a_of_type_Rxl;
  }
  
  public void a(BasePartFragment paramBasePartFragment, View paramView, rxl paramrxl)
  {
    this.mActivity = paramBasePartFragment.getActivity();
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment = paramBasePartFragment;
    this.jdField_a_of_type_Rxl = paramrxl;
    this.app = paramBasePartFragment.getActivity().app;
    this.mRootView = paramView;
  }
  
  public BasePartFragment b()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment;
  }
  
  protected void dC(View paramView)
  {
    QLog.d(getLogTag(), 1, getLogTag() + "->onInitView");
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public Context getContext()
  {
    if (this.mActivity != null) {
      return this.mActivity;
    }
    return null;
  }
  
  public abstract String getLogTag();
  
  public <T extends rxi> T getViewModel(Class<T> paramClass)
  {
    return a(null, paramClass);
  }
  
  public void l(String paramString, Object paramObject) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void r(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_Rxl.r(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxk
 * JD-Core Version:    0.7.0.1
 */