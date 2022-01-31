package android.support.v7.internal.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mobileqqi.R.styleable;

public class ActionBarPolicy
{
  private Context mContext;
  
  private ActionBarPolicy(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static ActionBarPolicy get(Context paramContext)
  {
    return new ActionBarPolicy(paramContext);
  }
  
  public boolean enableHomeButtonByDefault()
  {
    return this.mContext.getApplicationInfo().targetSdkVersion < 14;
  }
  
  public int getEmbeddedMenuWidthLimit()
  {
    return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
  }
  
  public int getMaxActionButtons()
  {
    return this.mContext.getResources().getInteger(2131492864);
  }
  
  public int getStackedTabMaxWidth()
  {
    return this.mContext.getResources().getDimensionPixelSize(2131427329);
  }
  
  public int getTabContainerHeight()
  {
    TypedArray localTypedArray = this.mContext.obtainStyledAttributes(null, R.styleable.c, 2130771979, 0);
    int j = localTypedArray.getLayoutDimension(1, 0);
    Resources localResources = this.mContext.getResources();
    int i = j;
    if (!hasEmbeddedTabs()) {
      i = Math.min(j, localResources.getDimensionPixelSize(2131427337));
    }
    localTypedArray.recycle();
    return i;
  }
  
  public boolean hasEmbeddedTabs()
  {
    return this.mContext.getResources().getBoolean(2131296256);
  }
  
  public boolean showsOverflowMenuButton()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.ActionBarPolicy
 * JD-Core Version:    0.7.0.1
 */