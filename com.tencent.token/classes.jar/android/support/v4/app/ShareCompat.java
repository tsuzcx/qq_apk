package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

public final class ShareCompat
{
  public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
  public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
  private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";
  
  public static void configureMenuItem(Menu paramMenu, int paramInt, ShareCompat.IntentBuilder paramIntentBuilder)
  {
    paramMenu = paramMenu.findItem(paramInt);
    if (paramMenu == null) {
      throw new IllegalArgumentException("Could not find menu item with id " + paramInt + " in the supplied menu");
    }
    configureMenuItem(paramMenu, paramIntentBuilder);
  }
  
  public static void configureMenuItem(MenuItem paramMenuItem, ShareCompat.IntentBuilder paramIntentBuilder)
  {
    Object localObject = paramMenuItem.getActionProvider();
    if (!(localObject instanceof ShareActionProvider)) {}
    for (localObject = new ShareActionProvider(paramIntentBuilder.getActivity());; localObject = (ShareActionProvider)localObject)
    {
      ((ShareActionProvider)localObject).setShareHistoryFileName(".sharecompat_" + paramIntentBuilder.getActivity().getClass().getName());
      ((ShareActionProvider)localObject).setShareIntent(paramIntentBuilder.getIntent());
      paramMenuItem.setActionProvider((ActionProvider)localObject);
      if ((Build.VERSION.SDK_INT < 16) && (!paramMenuItem.hasSubMenu())) {
        paramMenuItem.setIntent(paramIntentBuilder.createChooserIntent());
      }
      return;
    }
  }
  
  public static ComponentName getCallingActivity(Activity paramActivity)
  {
    ComponentName localComponentName2 = paramActivity.getCallingActivity();
    ComponentName localComponentName1 = localComponentName2;
    if (localComponentName2 == null) {
      localComponentName1 = (ComponentName)paramActivity.getIntent().getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY");
    }
    return localComponentName1;
  }
  
  public static String getCallingPackage(Activity paramActivity)
  {
    String str2 = paramActivity.getCallingPackage();
    String str1 = str2;
    if (str2 == null) {
      str1 = paramActivity.getIntent().getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE");
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ShareCompat
 * JD-Core Version:    0.7.0.1
 */