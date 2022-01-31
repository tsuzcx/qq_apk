import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqcircle.component.ComponentBaseFragment;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class tvx
  implements Application.ActivityLifecycleCallbacks
{
  private View jdField_a_of_type_AndroidViewView;
  private ComponentBaseFragment jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment;
  private final LinkedHashMap<String, tvv> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public tvx(ComponentBaseFragment paramComponentBaseFragment, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment = paramComponentBaseFragment;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvv)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((tvv)localObject).a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvv)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((tvv)localObject).a(paramConfiguration);
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(String paramString, Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((tvv)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).a(paramString, paramObject);
    }
  }
  
  public void a(List<tvv> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      tvv localtvv = (tvv)paramList.next();
      localtvv.a(this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment, this.jdField_a_of_type_AndroidViewView, this);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localtvv.getClass().getSimpleName(), localtvv);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvv)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if ((localObject != null) && (((tvv)localObject).a())) {
        return true;
      }
    }
    return false;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvv)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null)
      {
        ((tvv)localObject).onActivityCreated(paramActivity, paramBundle);
        ((tvv)localObject).a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvv)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((tvv)localObject).onActivityDestroyed(paramActivity);
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment = null;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvv)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((tvv)localObject).onActivityPaused(paramActivity);
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    paramActivity = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (paramActivity.hasNext())
    {
      Object localObject = (String)paramActivity.next();
      localObject = (tvv)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((tvv)localObject).onActivityResumed(this.jdField_a_of_type_ComTencentBizQqcircleComponentComponentBaseFragment.getActivity());
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvv)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((tvv)localObject).onActivityStarted(paramActivity);
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (tvv)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((tvv)localObject).onActivityStopped(paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvx
 * JD-Core Version:    0.7.0.1
 */