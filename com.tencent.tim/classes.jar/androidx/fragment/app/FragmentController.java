package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentController
{
  private final FragmentHostCallback<?> mHost;
  
  private FragmentController(FragmentHostCallback<?> paramFragmentHostCallback)
  {
    this.mHost = paramFragmentHostCallback;
  }
  
  @NonNull
  public static FragmentController createController(@NonNull FragmentHostCallback<?> paramFragmentHostCallback)
  {
    return new FragmentController((FragmentHostCallback)Preconditions.checkNotNull(paramFragmentHostCallback, "callbacks == null"));
  }
  
  public void attachHost(@Nullable Fragment paramFragment)
  {
    this.mHost.mFragmentManager.attachController(this.mHost, this.mHost, paramFragment);
  }
  
  public void dispatchActivityCreated()
  {
    this.mHost.mFragmentManager.dispatchActivityCreated();
  }
  
  public void dispatchConfigurationChanged(@NonNull Configuration paramConfiguration)
  {
    this.mHost.mFragmentManager.dispatchConfigurationChanged(paramConfiguration);
  }
  
  public boolean dispatchContextItemSelected(@NonNull MenuItem paramMenuItem)
  {
    return this.mHost.mFragmentManager.dispatchContextItemSelected(paramMenuItem);
  }
  
  public void dispatchCreate()
  {
    this.mHost.mFragmentManager.dispatchCreate();
  }
  
  public boolean dispatchCreateOptionsMenu(@NonNull Menu paramMenu, @NonNull MenuInflater paramMenuInflater)
  {
    return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
  }
  
  public void dispatchDestroy()
  {
    this.mHost.mFragmentManager.dispatchDestroy();
  }
  
  public void dispatchDestroyView()
  {
    this.mHost.mFragmentManager.dispatchDestroyView();
  }
  
  public void dispatchLowMemory()
  {
    this.mHost.mFragmentManager.dispatchLowMemory();
  }
  
  public void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  public boolean dispatchOptionsItemSelected(@NonNull MenuItem paramMenuItem)
  {
    return this.mHost.mFragmentManager.dispatchOptionsItemSelected(paramMenuItem);
  }
  
  public void dispatchOptionsMenuClosed(@NonNull Menu paramMenu)
  {
    this.mHost.mFragmentManager.dispatchOptionsMenuClosed(paramMenu);
  }
  
  public void dispatchPause()
  {
    this.mHost.mFragmentManager.dispatchPause();
  }
  
  public void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  public boolean dispatchPrepareOptionsMenu(@NonNull Menu paramMenu)
  {
    return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
  }
  
  @Deprecated
  public void dispatchReallyStop() {}
  
  public void dispatchResume()
  {
    this.mHost.mFragmentManager.dispatchResume();
  }
  
  public void dispatchStart()
  {
    this.mHost.mFragmentManager.dispatchStart();
  }
  
  public void dispatchStop()
  {
    this.mHost.mFragmentManager.dispatchStop();
  }
  
  @Deprecated
  public void doLoaderDestroy() {}
  
  @Deprecated
  public void doLoaderRetain() {}
  
  @Deprecated
  public void doLoaderStart() {}
  
  @Deprecated
  public void doLoaderStop(boolean paramBoolean) {}
  
  @Deprecated
  public void dumpLoaders(@NonNull String paramString, @Nullable FileDescriptor paramFileDescriptor, @NonNull PrintWriter paramPrintWriter, @Nullable String[] paramArrayOfString) {}
  
  public boolean execPendingActions()
  {
    return this.mHost.mFragmentManager.execPendingActions();
  }
  
  @Nullable
  public Fragment findFragmentByWho(@NonNull String paramString)
  {
    return this.mHost.mFragmentManager.findFragmentByWho(paramString);
  }
  
  @NonNull
  public List<Fragment> getActiveFragments(@SuppressLint({"UnknownNullness"}) List<Fragment> paramList)
  {
    return this.mHost.mFragmentManager.getActiveFragments();
  }
  
  public int getActiveFragmentsCount()
  {
    return this.mHost.mFragmentManager.getActiveFragmentCount();
  }
  
  @NonNull
  public FragmentManager getSupportFragmentManager()
  {
    return this.mHost.mFragmentManager;
  }
  
  @Deprecated
  @SuppressLint({"UnknownNullness"})
  public LoaderManager getSupportLoaderManager()
  {
    throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
  }
  
  public void noteStateNotSaved()
  {
    this.mHost.mFragmentManager.noteStateNotSaved();
  }
  
  @Nullable
  public View onCreateView(@Nullable View paramView, @NonNull String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    return this.mHost.mFragmentManager.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  @Deprecated
  public void reportLoaderStart() {}
  
  @Deprecated
  public void restoreAllState(@Nullable Parcelable paramParcelable, @Nullable FragmentManagerNonConfig paramFragmentManagerNonConfig)
  {
    this.mHost.mFragmentManager.restoreAllState(paramParcelable, paramFragmentManagerNonConfig);
  }
  
  @Deprecated
  public void restoreAllState(@Nullable Parcelable paramParcelable, @Nullable List<Fragment> paramList)
  {
    this.mHost.mFragmentManager.restoreAllState(paramParcelable, new FragmentManagerNonConfig(paramList, null, null));
  }
  
  @Deprecated
  public void restoreLoaderNonConfig(@SuppressLint({"UnknownNullness"}) SimpleArrayMap<String, LoaderManager> paramSimpleArrayMap) {}
  
  public void restoreSaveState(@Nullable Parcelable paramParcelable)
  {
    if (!(this.mHost instanceof ViewModelStoreOwner)) {
      throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }
    this.mHost.mFragmentManager.restoreSaveState(paramParcelable);
  }
  
  @Deprecated
  @Nullable
  public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig()
  {
    return null;
  }
  
  @Deprecated
  @Nullable
  public FragmentManagerNonConfig retainNestedNonConfig()
  {
    return this.mHost.mFragmentManager.retainNonConfig();
  }
  
  @Deprecated
  @Nullable
  public List<Fragment> retainNonConfig()
  {
    FragmentManagerNonConfig localFragmentManagerNonConfig = this.mHost.mFragmentManager.retainNonConfig();
    if ((localFragmentManagerNonConfig != null) && (localFragmentManagerNonConfig.getFragments() != null)) {
      return new ArrayList(localFragmentManagerNonConfig.getFragments());
    }
    return null;
  }
  
  @Nullable
  public Parcelable saveAllState()
  {
    return this.mHost.mFragmentManager.saveAllState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentController
 * JD-Core Version:    0.7.0.1
 */