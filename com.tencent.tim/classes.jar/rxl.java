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

public class rxl
  implements Application.ActivityLifecycleCallbacks
{
  private final LinkedHashMap<String, rxk> C = new LinkedHashMap();
  private BasePartFragment a;
  private View mRootView;
  
  public rxl(BasePartFragment paramBasePartFragment, View paramView)
  {
    this.a = paramBasePartFragment;
    this.mRootView = paramView;
  }
  
  public void dX(View paramView)
  {
    this.mRootView = paramView;
  }
  
  public void fc(List<rxk> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      rxk localrxk = (rxk)paramList.next();
      localrxk.a(this.a, this.mRootView, this);
      this.C.put(localrxk.getClass().getSimpleName(), localrxk);
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    Iterator localIterator = this.C.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (rxk)this.C.get(localObject);
      if (localObject != null)
      {
        ((rxk)localObject).onActivityCreated(paramActivity, paramBundle);
        ((rxk)localObject).dC(this.mRootView);
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.C.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (rxk)this.C.get(localObject);
      if (localObject != null) {
        ((rxk)localObject).onActivityDestroyed(paramActivity);
      }
    }
    this.C.clear();
    this.a = null;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Iterator localIterator = this.C.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (rxk)this.C.get(localObject);
      if (localObject != null) {
        ((rxk)localObject).onActivityPaused(paramActivity);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.C.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (rxk)this.C.get(localObject);
      if (localObject != null) {
        ((rxk)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    paramActivity = this.C.keySet().iterator();
    while (paramActivity.hasNext())
    {
      Object localObject = (String)paramActivity.next();
      localObject = (rxk)this.C.get(localObject);
      if (localObject != null) {
        ((rxk)localObject).onActivityResumed(this.a.getActivity());
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = this.C.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (rxk)this.C.get(localObject);
      if (localObject != null) {
        ((rxk)localObject).onActivityStarted(paramActivity);
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.C.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (rxk)this.C.get(localObject);
      if (localObject != null) {
        ((rxk)localObject).onActivityStopped(paramActivity);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    Iterator localIterator = this.C.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (rxk)this.C.get(localObject);
      if ((localObject != null) && (((rxk)localObject).onBackEvent())) {
        return true;
      }
    }
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Iterator localIterator = this.C.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (rxk)this.C.get(localObject);
      if (localObject != null) {
        ((rxk)localObject).onConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  public void r(String paramString, Object paramObject)
  {
    Iterator localIterator = this.C.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (rxk)this.C.get(localObject);
      if (localObject != null) {
        ((rxk)localObject).l(paramString, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxl
 * JD-Core Version:    0.7.0.1
 */