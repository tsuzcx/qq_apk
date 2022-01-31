import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqcircle.component.ComponentBaseFragment;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class tvn
  implements Application.ActivityLifecycleCallbacks
{
  private View jdField_a_of_type_AndroidViewView;
  private ComponentBaseFragment jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment;
  private final ConcurrentHashMap<String, tvg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public tvn(ComponentBaseFragment paramComponentBaseFragment, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment = paramComponentBaseFragment;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null) {
        ((tvg)localObject).a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null) {
        ((tvg)localObject).a(paramConfiguration);
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(String paramString, Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((tvg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).a(paramString, paramObject);
    }
  }
  
  public void a(List<tvg> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      tvg localtvg = (tvg)paramList.next();
      localtvg.a(this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment, this.jdField_a_of_type_AndroidViewView, this);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localtvg.getClass().getSimpleName(), localtvg);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if ((localObject != null) && (((tvg)localObject).a())) {
        return true;
      }
    }
    return false;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null)
      {
        ((tvg)localObject).onActivityCreated(paramActivity, paramBundle);
        ((tvg)localObject).a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null) {
        ((tvg)localObject).onActivityDestroyed(paramActivity);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment = null;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null) {
        ((tvg)localObject).onActivityPaused(paramActivity);
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    paramActivity = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (paramActivity.hasNext())
    {
      Object localObject = (String)paramActivity.next();
      localObject = (tvg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null) {
        ((tvg)localObject).onActivityResumed(this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment.getActivity());
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null) {
        ((tvg)localObject).onActivityStarted(paramActivity);
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null) {
        ((tvg)localObject).onActivityStopped(paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvn
 * JD-Core Version:    0.7.0.1
 */