import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class axji
{
  private static final String TAG = axji.class.getSimpleName();
  private FragmentManager c;
  private HashMap<Class<? extends AEEditorBaseFragment>, AEEditorBaseFragment> rg;
  
  public axji(FragmentManager paramFragmentManager)
  {
    this.c = paramFragmentManager;
    this.rg = new HashMap();
  }
  
  private AEEditorBaseFragment a()
  {
    Iterator localIterator = this.rg.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((AEEditorBaseFragment)localEntry.getValue()).isVisible()) {
        return (AEEditorBaseFragment)localEntry.getValue();
      }
    }
    return null;
  }
  
  private void a(AEEditorBaseFragment paramAEEditorBaseFragment, Class<? extends AEEditorBaseFragment> paramClass, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if ((!this.rg.containsKey(paramClass)) || (this.rg.get(paramClass) == null)) {}
    AEEditorBaseFragment localAEEditorBaseFragment;
    for (;;)
    {
      Map.Entry localEntry;
      try
      {
        localAEEditorBaseFragment = (AEEditorBaseFragment)paramClass.newInstance();
        localAEEditorBaseFragment.a(this);
        if (localAEEditorBaseFragment.getArguments() != null) {
          break label227;
        }
        localAEEditorBaseFragment.setArguments(paramBundle);
        localAEEditorBaseFragment.cVh = paramString;
        paramBundle = this.c.beginTransaction();
        paramString = null;
        Iterator localIterator = this.rg.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator.next();
        if ((!paramBoolean) || (paramAEEditorBaseFragment == null) || (!((AEEditorBaseFragment)localEntry.getValue()).equals(paramAEEditorBaseFragment))) {
          break label240;
        }
        paramString = (Class)localEntry.getKey();
        continue;
        localAEEditorBaseFragment = (AEEditorBaseFragment)this.rg.get(paramClass);
      }
      catch (IllegalAccessException paramAEEditorBaseFragment)
      {
        axiy.e(TAG, "replaceFragment: " + Log.getStackTraceString(paramAEEditorBaseFragment));
        return;
      }
      catch (InstantiationException paramAEEditorBaseFragment)
      {
        axiy.e(TAG, "replaceFragment: " + Log.getStackTraceString(paramAEEditorBaseFragment));
        return;
      }
      localAEEditorBaseFragment.a(this);
      continue;
      label227:
      localAEEditorBaseFragment.getArguments().putAll(paramBundle);
      continue;
      label240:
      paramBundle.hide((Fragment)localEntry.getValue());
    }
    if ((paramBoolean) && (paramAEEditorBaseFragment != null))
    {
      if (paramString != null) {
        this.rg.remove(paramString);
      }
      paramBundle.remove(paramAEEditorBaseFragment);
    }
    if (this.c.findFragmentByTag(paramClass.getName()) == null) {
      paramBundle.add(2131362331, localAEEditorBaseFragment, paramClass.getName()).commit();
    }
    for (;;)
    {
      this.rg.put(paramClass, localAEEditorBaseFragment);
      return;
      paramBundle.show(localAEEditorBaseFragment).commit();
    }
  }
  
  private void a(Class<? extends AEEditorBaseFragment> paramClass, String paramString, Bundle paramBundle)
  {
    a(null, paramClass, paramString, paramBundle, false);
  }
  
  public void L(String paramString, Bundle paramBundle)
  {
    axiy.i(TAG, "gotoImageEditModule from " + paramString);
    a(AEEditorImageEditFragment.class, paramString, paramBundle);
  }
  
  public void M(String paramString, Bundle paramBundle)
  {
    axiy.i(TAG, "gotoVideoClipModule from " + paramString);
    a(AEEditorVideoClipFragment.class, paramString, paramBundle);
  }
  
  public void N(String paramString, Bundle paramBundle)
  {
    axiy.i(TAG, "gotoVideoEditModule from " + paramString);
    a(AEEditorVideoEditFragment.class, paramString, paramBundle);
  }
  
  public void a(AEEditorBaseFragment paramAEEditorBaseFragment, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    axiy.i(TAG, "gotoImageClipModule from " + paramString);
    a(paramAEEditorBaseFragment, AEEditorImageClipFragment.class, paramString, paramBundle, paramBoolean);
  }
  
  public void b(AEEditorBaseFragment paramAEEditorBaseFragment, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    axiy.i(TAG, "gotoVideoClipModule from " + paramString);
    a(paramAEEditorBaseFragment, AEEditorVideoClipFragment.class, paramString, paramBundle, paramBoolean);
  }
  
  public void cL(Bundle paramBundle)
  {
    axiy.i(TAG, "enter");
    if (axjh.L(paramBundle))
    {
      L(null, paramBundle);
      return;
    }
    if (axjh.M(paramBundle))
    {
      M(null, paramBundle);
      return;
    }
    throw new RuntimeException("invalid editor type");
  }
  
  public void cR(Activity paramActivity)
  {
    m(paramActivity, false);
  }
  
  public void cS(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity.finish();
  }
  
  public void m(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null) {}
    AEEditorBaseFragment localAEEditorBaseFragment;
    do
    {
      boolean bool1;
      do
      {
        do
        {
          return;
          localAEEditorBaseFragment = a();
        } while (localAEEditorBaseFragment == null);
        boolean bool2 = false;
        bool1 = bool2;
        if (localAEEditorBaseFragment.isVisible())
        {
          bool1 = bool2;
          if (paramBoolean) {
            bool1 = false | localAEEditorBaseFragment.aOM();
          }
        }
      } while (bool1);
      try
      {
        localAEEditorBaseFragment.doOnBackPressed();
        if ((localAEEditorBaseFragment.cVh != null) && (localAEEditorBaseFragment.cVh.equals("AEEditorVideoEdit")) && (localAEEditorBaseFragment.getModuleId().equals("AEEditorVideoClip")))
        {
          paramActivity = new Bundle(localAEEditorBaseFragment.getArguments());
          N(localAEEditorBaseFragment.getModuleId(), paramActivity);
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        axiy.e(TAG, Log.getStackTraceString(paramActivity));
        return;
      }
      if ((localAEEditorBaseFragment.cVh != null) && (localAEEditorBaseFragment.cVh.equals("AEEditorImageClip")) && (localAEEditorBaseFragment.getModuleId().equals("AEEditorImageEdit")))
      {
        a(localAEEditorBaseFragment, null, new Bundle(localAEEditorBaseFragment.getArguments()), true);
        return;
      }
      if ((localAEEditorBaseFragment.cVh != null) && (localAEEditorBaseFragment.cVh.equals("AEEditorVideoClip")) && (localAEEditorBaseFragment.getModuleId().equals("AEEditorVideoEdit")))
      {
        b(localAEEditorBaseFragment, null, new Bundle(localAEEditorBaseFragment.getArguments()), true);
        return;
      }
    } while (localAEEditorBaseFragment.cVh != null);
    axiy.i(TAG, "goBack finish activity");
    cS(paramActivity);
    paramActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axji
 * JD-Core Version:    0.7.0.1
 */