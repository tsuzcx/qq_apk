import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.part.BasePartFragment;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class zol
  implements Application.ActivityLifecycleCallbacks
{
  private View jdField_a_of_type_AndroidViewView;
  private BasePartFragment jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment;
  private final LinkedHashMap<String, zok> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public zol(BasePartFragment paramBasePartFragment, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment = paramBasePartFragment;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (zok)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((zok)localObject).a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (zok)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((zok)localObject).a(paramConfiguration);
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(List<zok> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      zok localzok = (zok)paramList.next();
      localzok.a(this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment, this.jdField_a_of_type_AndroidViewView, this);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localzok.getClass().getSimpleName(), localzok);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (zok)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if ((localObject != null) && (((zok)localObject).a())) {
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
      localObject = (zok)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null)
      {
        ((zok)localObject).onActivityCreated(paramActivity, paramBundle);
        ((zok)localObject).a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (zok)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((zok)localObject).onActivityDestroyed(paramActivity);
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment = null;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (zok)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((zok)localObject).onActivityPaused(paramActivity);
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    paramActivity = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (paramActivity.hasNext())
    {
      Object localObject = (String)paramActivity.next();
      localObject = (zok)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((zok)localObject).onActivityResumed(this.jdField_a_of_type_ComTencentBizRichframeworkPartBasePartFragment.getActivity());
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
      localObject = (zok)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((zok)localObject).onActivityStarted(paramActivity);
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (zok)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((zok)localObject).onActivityStopped(paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zol
 * JD-Core Version:    0.7.0.1
 */