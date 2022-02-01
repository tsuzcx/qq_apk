package com.facebook.stetho.common.android;

import android.app.Activity;
import android.os.Build.VERSION;
import com.facebook.stetho.common.ReflectionUtil;
import java.lang.reflect.Field;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public abstract class FragmentCompat<FRAGMENT, DIALOG_FRAGMENT, FRAGMENT_MANAGER, FRAGMENT_ACTIVITY extends Activity>
{
  private static FragmentCompat sFrameworkInstance;
  private static final boolean sHasMoaiFragment;
  private static final boolean sHasSupportFragment;
  private static FragmentCompat sMoaiInstance;
  private static FragmentCompat sSupportInstance;
  
  static
  {
    boolean bool2 = true;
    if (ReflectionUtil.tryGetClassForName("android.support.v4.app.Fragment") != null)
    {
      bool1 = true;
      sHasSupportFragment = bool1;
      if (ReflectionUtil.tryGetClassForName("moai.fragment.app.Fragment") == null) {
        break label36;
      }
    }
    label36:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      sHasMoaiFragment = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  @Nullable
  public static FragmentCompat getFrameworkInstance()
  {
    if ((sFrameworkInstance == null) && (Build.VERSION.SDK_INT >= 11)) {
      sFrameworkInstance = new FragmentCompatFramework();
    }
    return sFrameworkInstance;
  }
  
  @Nullable
  public static FragmentCompat getMoaiLibInstance()
  {
    if ((sMoaiInstance == null) && (sHasMoaiFragment)) {
      sMoaiInstance = new FragmentMoaiLib();
    }
    return sMoaiInstance;
  }
  
  @Nullable
  public static FragmentCompat getSupportLibInstance()
  {
    if ((sSupportInstance == null) && (sHasSupportFragment)) {
      sSupportInstance = new FragmentCompatSupportLib();
    }
    return sSupportInstance;
  }
  
  public abstract DialogFragmentAccessor<DIALOG_FRAGMENT, FRAGMENT, FRAGMENT_MANAGER> forDialogFragment();
  
  public abstract FragmentAccessor<FRAGMENT, FRAGMENT_MANAGER> forFragment();
  
  public abstract FragmentActivityAccessor<FRAGMENT_ACTIVITY, FRAGMENT_MANAGER> forFragmentActivity();
  
  public abstract FragmentManagerAccessor<FRAGMENT_MANAGER, FRAGMENT> forFragmentManager();
  
  public abstract Class<DIALOG_FRAGMENT> getDialogFragmentClass();
  
  public abstract Class<FRAGMENT_ACTIVITY> getFragmentActivityClass();
  
  public abstract Class<FRAGMENT> getFragmentClass();
  
  static class FragmentManagerAccessorViaReflection<FRAGMENT_MANAGER, FRAGMENT>
    implements FragmentManagerAccessor<FRAGMENT_MANAGER, FRAGMENT>
  {
    @Nullable
    private Field mFieldMAdded;
    
    @Nullable
    public List<FRAGMENT> getAddedFragments(FRAGMENT_MANAGER paramFRAGMENT_MANAGER)
    {
      if (this.mFieldMAdded == null)
      {
        Field localField = ReflectionUtil.tryGetDeclaredField(paramFRAGMENT_MANAGER.getClass(), "mAdded");
        if (localField != null)
        {
          localField.setAccessible(true);
          this.mFieldMAdded = localField;
        }
      }
      if (this.mFieldMAdded != null) {
        return (List)ReflectionUtil.getFieldValue(this.mFieldMAdded, paramFRAGMENT_MANAGER);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.android.FragmentCompat
 * JD-Core Version:    0.7.0.1
 */