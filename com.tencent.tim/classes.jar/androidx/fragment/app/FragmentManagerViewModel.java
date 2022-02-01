package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class FragmentManagerViewModel
  extends ViewModel
{
  private static final ViewModelProvider.Factory FACTORY = new FragmentManagerViewModel.1();
  private final HashMap<String, FragmentManagerViewModel> mChildNonConfigs = new HashMap();
  private boolean mHasBeenCleared = false;
  private boolean mHasSavedSnapshot = false;
  private final HashSet<Fragment> mRetainedFragments = new HashSet();
  private final boolean mStateAutomaticallySaved;
  private final HashMap<String, ViewModelStore> mViewModelStores = new HashMap();
  
  FragmentManagerViewModel(boolean paramBoolean)
  {
    this.mStateAutomaticallySaved = paramBoolean;
  }
  
  @NonNull
  static FragmentManagerViewModel getInstance(ViewModelStore paramViewModelStore)
  {
    return (FragmentManagerViewModel)new ViewModelProvider(paramViewModelStore, FACTORY).get(FragmentManagerViewModel.class);
  }
  
  boolean addRetainedFragment(@NonNull Fragment paramFragment)
  {
    return this.mRetainedFragments.add(paramFragment);
  }
  
  void clearNonConfigState(@NonNull Fragment paramFragment)
  {
    if (FragmentManagerImpl.DEBUG) {
      Log.d("FragmentManager", "Clearing non-config state for " + paramFragment);
    }
    Object localObject = (FragmentManagerViewModel)this.mChildNonConfigs.get(paramFragment.mWho);
    if (localObject != null)
    {
      ((FragmentManagerViewModel)localObject).onCleared();
      this.mChildNonConfigs.remove(paramFragment.mWho);
    }
    localObject = (ViewModelStore)this.mViewModelStores.get(paramFragment.mWho);
    if (localObject != null)
    {
      ((ViewModelStore)localObject).clear();
      this.mViewModelStores.remove(paramFragment.mWho);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (FragmentManagerViewModel)paramObject;
    } while ((this.mRetainedFragments.equals(paramObject.mRetainedFragments)) && (this.mChildNonConfigs.equals(paramObject.mChildNonConfigs)) && (this.mViewModelStores.equals(paramObject.mViewModelStores)));
    return false;
  }
  
  @NonNull
  FragmentManagerViewModel getChildNonConfig(@NonNull Fragment paramFragment)
  {
    FragmentManagerViewModel localFragmentManagerViewModel2 = (FragmentManagerViewModel)this.mChildNonConfigs.get(paramFragment.mWho);
    FragmentManagerViewModel localFragmentManagerViewModel1 = localFragmentManagerViewModel2;
    if (localFragmentManagerViewModel2 == null)
    {
      localFragmentManagerViewModel1 = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
      this.mChildNonConfigs.put(paramFragment.mWho, localFragmentManagerViewModel1);
    }
    return localFragmentManagerViewModel1;
  }
  
  @NonNull
  Collection<Fragment> getRetainedFragments()
  {
    return this.mRetainedFragments;
  }
  
  @Deprecated
  @Nullable
  FragmentManagerNonConfig getSnapshot()
  {
    if ((this.mRetainedFragments.isEmpty()) && (this.mChildNonConfigs.isEmpty()) && (this.mViewModelStores.isEmpty())) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.mChildNonConfigs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      FragmentManagerNonConfig localFragmentManagerNonConfig = ((FragmentManagerViewModel)localEntry.getValue()).getSnapshot();
      if (localFragmentManagerNonConfig != null) {
        localHashMap.put(localEntry.getKey(), localFragmentManagerNonConfig);
      }
    }
    this.mHasSavedSnapshot = true;
    if ((this.mRetainedFragments.isEmpty()) && (localHashMap.isEmpty()) && (this.mViewModelStores.isEmpty())) {
      return null;
    }
    return new FragmentManagerNonConfig(new ArrayList(this.mRetainedFragments), localHashMap, new HashMap(this.mViewModelStores));
  }
  
  @NonNull
  ViewModelStore getViewModelStore(@NonNull Fragment paramFragment)
  {
    ViewModelStore localViewModelStore2 = (ViewModelStore)this.mViewModelStores.get(paramFragment.mWho);
    ViewModelStore localViewModelStore1 = localViewModelStore2;
    if (localViewModelStore2 == null)
    {
      localViewModelStore1 = new ViewModelStore();
      this.mViewModelStores.put(paramFragment.mWho, localViewModelStore1);
    }
    return localViewModelStore1;
  }
  
  public int hashCode()
  {
    return (this.mRetainedFragments.hashCode() * 31 + this.mChildNonConfigs.hashCode()) * 31 + this.mViewModelStores.hashCode();
  }
  
  boolean isCleared()
  {
    return this.mHasBeenCleared;
  }
  
  public void onCleared()
  {
    if (FragmentManagerImpl.DEBUG) {
      Log.d("FragmentManager", "onCleared called for " + this);
    }
    this.mHasBeenCleared = true;
  }
  
  boolean removeRetainedFragment(@NonNull Fragment paramFragment)
  {
    return this.mRetainedFragments.remove(paramFragment);
  }
  
  @Deprecated
  void restoreFromSnapshot(@Nullable FragmentManagerNonConfig paramFragmentManagerNonConfig)
  {
    this.mRetainedFragments.clear();
    this.mChildNonConfigs.clear();
    this.mViewModelStores.clear();
    if (paramFragmentManagerNonConfig != null)
    {
      Object localObject = paramFragmentManagerNonConfig.getFragments();
      if (localObject != null) {
        this.mRetainedFragments.addAll((Collection)localObject);
      }
      localObject = paramFragmentManagerNonConfig.getChildNonConfigs();
      if (localObject != null)
      {
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          FragmentManagerViewModel localFragmentManagerViewModel = new FragmentManagerViewModel(this.mStateAutomaticallySaved);
          localFragmentManagerViewModel.restoreFromSnapshot((FragmentManagerNonConfig)localEntry.getValue());
          this.mChildNonConfigs.put(localEntry.getKey(), localFragmentManagerViewModel);
        }
      }
      paramFragmentManagerNonConfig = paramFragmentManagerNonConfig.getViewModelStores();
      if (paramFragmentManagerNonConfig != null) {
        this.mViewModelStores.putAll(paramFragmentManagerNonConfig);
      }
    }
    this.mHasSavedSnapshot = false;
  }
  
  boolean shouldDestroy(@NonNull Fragment paramFragment)
  {
    if (!this.mRetainedFragments.contains(paramFragment)) {}
    do
    {
      return true;
      if (this.mStateAutomaticallySaved) {
        return this.mHasBeenCleared;
      }
    } while (!this.mHasSavedSnapshot);
    return false;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FragmentManagerViewModel{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("} Fragments (");
    Iterator localIterator = this.mRetainedFragments.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(") Child Non Config (");
    localIterator = this.mChildNonConfigs.keySet().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(") ViewModelStores (");
    localIterator = this.mViewModelStores.keySet().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerViewModel
 * JD-Core Version:    0.7.0.1
 */