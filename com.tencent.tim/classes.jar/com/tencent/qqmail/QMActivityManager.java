package com.tencent.qqmail;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import moai.fragment.app.Fragment;

public class QMActivityManager
{
  private static final String TAG = "QMActivityManager";
  private static final QMActivityManager _instance = new QMActivityManager();
  private final List<WeakReference<BaseActivityImpl.PrivateAccess>> mPageList = new CopyOnWriteArrayList();
  
  private Object getPage(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.mPageList.size())) {}
    BaseActivityImpl.PrivateAccess localPrivateAccess2;
    do
    {
      return null;
      ListIterator localListIterator = this.mPageList.listIterator(paramInt);
      BaseActivityImpl.PrivateAccess localPrivateAccess1 = null;
      for (;;)
      {
        localPrivateAccess2 = localPrivateAccess1;
        if (!localListIterator.hasPrevious()) {
          break;
        }
        WeakReference localWeakReference = (WeakReference)localListIterator.previous();
        localPrivateAccess1 = (BaseActivityImpl.PrivateAccess)localWeakReference.get();
        if (localPrivateAccess1 != null)
        {
          localPrivateAccess2 = localPrivateAccess1;
          if (!(localPrivateAccess1.getPage() instanceof Fragment)) {
            break;
          }
          localPrivateAccess2 = localPrivateAccess1;
          if (((Fragment)localPrivateAccess1.getPage()).getActivity() != null) {
            break;
          }
        }
        dump("getPage, remove page which has been recycled");
        QMLog.log(5, "QMActivityManager", "page has been recycled but still in the pageList!!");
        this.mPageList.remove(localWeakReference);
      }
    } while (localPrivateAccess2 == null);
    return localPrivateAccess2.getPage();
  }
  
  private void removeReleasedItem()
  {
    int i = this.mPageList.size() - 1;
    while (i >= 0)
    {
      if (((WeakReference)this.mPageList.get(i)).get() == null) {
        this.mPageList.remove(i);
      }
      i -= 1;
    }
  }
  
  public static QMActivityManager shareInstance()
  {
    return _instance;
  }
  
  public void dump(String paramString) {}
  
  public boolean existPage(Class<?> paramClass)
  {
    return getPage(paramClass) != null;
  }
  
  public void finishAllActivity()
  {
    ValidateHelper.mainThread();
    Iterator localIterator = this.mPageList.iterator();
    while (localIterator.hasNext())
    {
      BaseActivityImpl.PrivateAccess localPrivateAccess = (BaseActivityImpl.PrivateAccess)((WeakReference)localIterator.next()).get();
      if (localPrivateAccess != null) {
        localPrivateAccess.super_finish();
      }
    }
    this.mPageList.clear();
    dump("finishAllActivity");
  }
  
  public void finishAllActivity(BaseActivity paramBaseActivity)
  {
    ValidateHelper.mainThread();
    Object localObject = null;
    Iterator localIterator = this.mPageList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      BaseActivityImpl.PrivateAccess localPrivateAccess = (BaseActivityImpl.PrivateAccess)localWeakReference.get();
      if (localPrivateAccess != null)
      {
        if (localPrivateAccess.getPage() == paramBaseActivity) {
          localObject = localWeakReference;
        }
        for (;;)
        {
          break;
          localPrivateAccess.super_finish();
        }
      }
    }
    this.mPageList.clear();
    if (localObject != null) {
      this.mPageList.add(localObject);
    }
    dump("finishAllActivityExcludedActivity");
  }
  
  public void finishTopActivity(Object paramObject)
  {
    
    if (paramObject == null) {
      return;
    }
    removeReleasedItem();
    int i = this.mPageList.size() - 1;
    while (i >= 0)
    {
      BaseActivityImpl.PrivateAccess localPrivateAccess = (BaseActivityImpl.PrivateAccess)((WeakReference)this.mPageList.remove(i)).get();
      if (localPrivateAccess != null)
      {
        if (localPrivateAccess.getPage() == paramObject) {
          break;
        }
        localPrivateAccess.removeSelf();
      }
      i -= 1;
    }
    dump("finishTopActivityActivity");
  }
  
  public boolean finishTopActivityExclusiveComposeMailActivity()
  {
    ValidateHelper.mainThread();
    removeReleasedItem();
    int i = this.mPageList.size() - 1;
    BaseActivityImpl.PrivateAccess localPrivateAccess;
    if (i >= 0)
    {
      localPrivateAccess = (BaseActivityImpl.PrivateAccess)((WeakReference)this.mPageList.get(i)).get();
      if ((localPrivateAccess == null) || (!(localPrivateAccess.getPage() instanceof ComposeMailActivity))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        i = this.mPageList.size() - 1;
      }
      for (;;)
      {
        if (i >= 0)
        {
          localPrivateAccess = (BaseActivityImpl.PrivateAccess)((WeakReference)this.mPageList.get(i)).get();
          if (localPrivateAccess == null) {
            break label143;
          }
          if (!(localPrivateAccess.getPage() instanceof ComposeMailActivity)) {}
        }
        else
        {
          return bool;
          i -= 1;
          break;
        }
        this.mPageList.remove(i);
        localPrivateAccess.removeSelf();
        label143:
        i -= 1;
      }
    }
  }
  
  public void finishTopActivityInclusive(Object paramObject)
  {
    
    if (paramObject == null) {}
    label94:
    for (;;)
    {
      return;
      removeReleasedItem();
      int i = 0;
      int j = this.mPageList.size() - 1;
      for (;;)
      {
        if (j < 0) {
          break label94;
        }
        BaseActivityImpl.PrivateAccess localPrivateAccess = (BaseActivityImpl.PrivateAccess)((WeakReference)this.mPageList.remove(j)).get();
        int k = i;
        if (localPrivateAccess != null)
        {
          if (localPrivateAccess.getPage() == paramObject) {
            i = 1;
          }
          localPrivateAccess.removeSelf();
          if (i != 0) {
            break;
          }
          k = i;
        }
        j -= 1;
        i = k;
      }
    }
  }
  
  public void finishTopPage(Class<?> paramClass)
  {
    
    if (paramClass == null) {
      return;
    }
    removeReleasedItem();
    int i = this.mPageList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        BaseActivityImpl.PrivateAccess localPrivateAccess = (BaseActivityImpl.PrivateAccess)((WeakReference)this.mPageList.get(i)).get();
        if ((localPrivateAccess == null) || (localPrivateAccess.getPage().getClass() != paramClass)) {}
      }
      else
      {
        if (i < 0) {
          break;
        }
        int j = this.mPageList.size() - 1;
        while (j > i)
        {
          paramClass = (BaseActivityImpl.PrivateAccess)((WeakReference)this.mPageList.remove(i)).get();
          if (paramClass != null) {
            paramClass.removeSelf();
          }
          j -= 1;
        }
        break;
      }
      i -= 1;
    }
  }
  
  public String getActivitiesStack(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = this.mPageList.size();
    localStringBuilder1.append("dump activities: ").append(paramString).append("\n");
    localStringBuilder1.append("========\n");
    i -= 1;
    if (i >= 0)
    {
      paramString = (BaseActivityImpl.PrivateAccess)((WeakReference)this.mPageList.get(i)).get();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("#").append(i).append(", ");
      if (paramString == null) {}
      for (paramString = null;; paramString = paramString.getPage())
      {
        localStringBuilder2.append(paramString).append("\n");
        i -= 1;
        break;
      }
    }
    localStringBuilder1.append("========\n");
    return localStringBuilder1.toString();
  }
  
  public int getActivitySize()
  {
    ValidateHelper.mainThread();
    removeReleasedItem();
    return this.mPageList.size();
  }
  
  @Nullable
  public Activity getFirstInvisibleActivity()
  {
    Object localObject = getFirstInvisiblePage();
    if ((localObject instanceof Activity)) {
      return (Activity)localObject;
    }
    if ((localObject instanceof Fragment)) {
      return ((Fragment)localObject).getActivity();
    }
    return null;
  }
  
  @Nullable
  public Object getFirstInvisiblePage()
  {
    Log.d("QMActivityManager", "getFirstInvisiblePage, pageSize: " + this.mPageList.size());
    Object localObject = getPage(this.mPageList.size());
    if ((AppStatusUtil.isAppOnBackGround()) && (this.mPageList.size() > 0)) {
      return localObject;
    }
    return getPage(this.mPageList.size() - 1);
  }
  
  public BaseActivityImpl.PrivateAccess getPage(Class<?> paramClass)
  {
    ValidateHelper.mainThread();
    Iterator localIterator = this.mPageList.iterator();
    while (localIterator.hasNext())
    {
      BaseActivityImpl.PrivateAccess localPrivateAccess = (BaseActivityImpl.PrivateAccess)((WeakReference)localIterator.next()).get();
      if ((localPrivateAccess != null) && (localPrivateAccess.getPage().getClass().equals(paramClass))) {
        return localPrivateAccess;
      }
    }
    return null;
  }
  
  @Nullable
  public Activity getVisibleActivity()
  {
    Object localObject = getVisiblePage();
    if ((localObject instanceof Activity)) {
      return (Activity)localObject;
    }
    if ((localObject instanceof Fragment)) {
      return ((Fragment)localObject).getActivity();
    }
    return null;
  }
  
  @Nullable
  public Object getVisiblePage()
  {
    int i = this.mPageList.size();
    Log.d("QMActivityManager", "getVisiblePage, pageSize: " + i);
    if (i == 0) {
      return null;
    }
    return getPage(i);
  }
  
  public void popActivity(BaseActivityImpl.PrivateAccess paramPrivateAccess)
  {
    
    if (this.mPageList.size() == 0) {
      return;
    }
    Iterator localIterator = this.mPageList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == paramPrivateAccess) {
        this.mPageList.remove(localWeakReference);
      }
    }
    dump("popActivity");
  }
  
  public void pushActivity(BaseActivityImpl.PrivateAccess paramPrivateAccess)
  {
    ValidateHelper.mainThread();
    this.mPageList.add(new WeakReference(paramPrivateAccess));
    dump("pushActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMActivityManager
 * JD-Core Version:    0.7.0.1
 */