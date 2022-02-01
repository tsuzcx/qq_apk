package android.support.v7.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.token.cl;
import com.tencent.token.da;
import com.tencent.token.di;
import com.tencent.token.di.a;
import com.tencent.token.dj;
import com.tencent.token.gu.a;
import com.tencent.token.gv;
import com.tencent.token.gw;
import com.tencent.token.ho;
import com.tencent.token.ho.a;
import com.tencent.token.kb;
import java.util.ArrayList;

public class AppCompatActivity
  extends FragmentActivity
  implements di.a, gv
{
  private gw mDelegate;
  private Resources mResources;
  private int mThemeId = 0;
  
  private boolean performMenuItemShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 26) && (!paramKeyEvent.isCtrlPressed()) && (!KeyEvent.metaStateHasNoModifiers(paramKeyEvent.getMetaState())) && (paramKeyEvent.getRepeatCount() == 0) && (!KeyEvent.isModifierKey(paramKeyEvent.getKeyCode())))
    {
      Window localWindow = getWindow();
      if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().dispatchKeyShortcutEvent(paramKeyEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().b(paramView, paramLayoutParams);
  }
  
  public void closeOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((getWindow().hasFeature(0)) && ((localActionBar == null) || (!localActionBar.e()))) {
      super.closeOptionsMenu();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    ActionBar localActionBar = getSupportActionBar();
    if ((i == 82) && (localActionBar != null) && (localActionBar.a(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    return getDelegate().a(paramInt);
  }
  
  public gw getDelegate()
  {
    if (this.mDelegate == null) {
      this.mDelegate = gw.a(this, this);
    }
    return this.mDelegate;
  }
  
  public gu.a getDrawerToggleDelegate()
  {
    return getDelegate().i();
  }
  
  public MenuInflater getMenuInflater()
  {
    return getDelegate().b();
  }
  
  public Resources getResources()
  {
    if ((this.mResources == null) && (kb.a())) {
      this.mResources = new kb(this, super.getResources());
    }
    Resources localResources2 = this.mResources;
    Resources localResources1 = localResources2;
    if (localResources2 == null) {
      localResources1 = super.getResources();
    }
    return localResources1;
  }
  
  public ActionBar getSupportActionBar()
  {
    return getDelegate().a();
  }
  
  public Intent getSupportParentActivityIntent()
  {
    return da.a(this);
  }
  
  public void invalidateOptionsMenu()
  {
    getDelegate().g();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getDelegate().a(paramConfiguration);
    if (this.mResources != null)
    {
      DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
      this.mResources.updateConfiguration(paramConfiguration, localDisplayMetrics);
    }
  }
  
  public void onContentChanged()
  {
    onSupportContentChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    gw localgw = getDelegate();
    localgw.j();
    localgw.a(paramBundle);
    if ((localgw.k()) && (this.mThemeId != 0)) {
      if (Build.VERSION.SDK_INT >= 23) {
        onApplyThemeResource(getTheme(), this.mThemeId, false);
      } else {
        setTheme(this.mThemeId);
      }
    }
    super.onCreate(paramBundle);
  }
  
  public void onCreateSupportNavigateUpTaskStack(di paramdi)
  {
    Object localObject2 = ((di.a)this).getSupportParentActivityIntent();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = da.a(this);
    }
    if (localObject1 != null)
    {
      ComponentName localComponentName = ((Intent)localObject1).getComponent();
      localObject2 = localComponentName;
      if (localComponentName == null) {
        localObject2 = ((Intent)localObject1).resolveActivity(paramdi.b.getPackageManager());
      }
      paramdi.a((ComponentName)localObject2);
      paramdi.a.add(localObject1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getDelegate().h();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (performMenuItemShortcut(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((localActionBar.a() & 0x4) != 0)) {
      return onSupportNavigateUp();
    }
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    getDelegate().c();
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    getDelegate().f();
  }
  
  public void onPrepareSupportNavigateUpTaskStack(di paramdi) {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    getDelegate().b(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    getDelegate().d();
  }
  
  public void onStop()
  {
    super.onStop();
    getDelegate().e();
  }
  
  public void onSupportActionModeFinished(ho paramho) {}
  
  public void onSupportActionModeStarted(ho paramho) {}
  
  @Deprecated
  public void onSupportContentChanged() {}
  
  public boolean onSupportNavigateUp()
  {
    Object localObject = getSupportParentActivityIntent();
    if (localObject != null) {
      if (supportShouldUpRecreateTask((Intent)localObject))
      {
        localObject = di.a(this);
        onCreateSupportNavigateUpTaskStack((di)localObject);
        onPrepareSupportNavigateUpTaskStack((di)localObject);
        if (!((di)localObject).a.isEmpty())
        {
          Intent[] arrayOfIntent = (Intent[])((di)localObject).a.toArray(new Intent[((di)localObject).a.size()]);
          arrayOfIntent[0] = new Intent(arrayOfIntent[0]).addFlags(268484608);
          dj.a(((di)localObject).b, arrayOfIntent);
        }
      }
    }
    try
    {
      cl.a(this);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label98:
      break label98;
    }
    finish();
    break label121;
    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    supportNavigateUpTo((Intent)localObject);
    label121:
    return true;
    return false;
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    getDelegate().a(paramCharSequence);
  }
  
  public ho onWindowStartingSupportActionMode(ho.a parama)
  {
    return null;
  }
  
  public void openOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((getWindow().hasFeature(0)) && ((localActionBar == null) || (!localActionBar.d()))) {
      super.openOptionsMenu();
    }
  }
  
  public void setContentView(int paramInt)
  {
    getDelegate().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    getDelegate().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().a(paramView, paramLayoutParams);
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    getDelegate().a(paramToolbar);
  }
  
  @Deprecated
  public void setSupportProgress(int paramInt) {}
  
  @Deprecated
  public void setSupportProgressBarIndeterminate(boolean paramBoolean) {}
  
  @Deprecated
  public void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean) {}
  
  @Deprecated
  public void setSupportProgressBarVisibility(boolean paramBoolean) {}
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    this.mThemeId = paramInt;
  }
  
  public ho startSupportActionMode(ho.a parama)
  {
    return getDelegate().a(parama);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    getDelegate().g();
  }
  
  public void supportNavigateUpTo(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      navigateUpTo(paramIntent);
      return;
    }
    paramIntent.addFlags(67108864);
    startActivity(paramIntent);
    finish();
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    return getDelegate().c(paramInt);
  }
  
  public boolean supportShouldUpRecreateTask(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return shouldUpRecreateTask(paramIntent);
    }
    paramIntent = getIntent().getAction();
    return (paramIntent != null) && (!paramIntent.equals("android.intent.action.MAIN"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatActivity
 * JD-Core Version:    0.7.0.1
 */