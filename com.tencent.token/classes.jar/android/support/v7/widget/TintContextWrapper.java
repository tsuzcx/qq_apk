package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TintContextWrapper
  extends ContextWrapper
{
  private static final Object CACHE_LOCK = new Object();
  private static ArrayList sCache;
  private final Resources mResources;
  private final Resources.Theme mTheme;
  
  private TintContextWrapper(@NonNull Context paramContext)
  {
    super(paramContext);
    if (VectorEnabledTintResources.shouldBeUsed())
    {
      this.mResources = new VectorEnabledTintResources(this, paramContext.getResources());
      this.mTheme = this.mResources.newTheme();
      this.mTheme.setTo(paramContext.getTheme());
      return;
    }
    this.mResources = new TintResources(this, paramContext.getResources());
    this.mTheme = null;
  }
  
  private static boolean shouldWrap(@NonNull Context paramContext)
  {
    if (((paramContext instanceof TintContextWrapper)) || ((paramContext.getResources() instanceof TintResources)) || ((paramContext.getResources() instanceof VectorEnabledTintResources))) {}
    while ((Build.VERSION.SDK_INT >= 21) && (!VectorEnabledTintResources.shouldBeUsed())) {
      return false;
    }
    return true;
  }
  
  public static Context wrap(@NonNull Context paramContext)
  {
    if (shouldWrap(paramContext)) {}
    for (;;)
    {
      int i;
      synchronized (CACHE_LOCK)
      {
        if (sCache == null)
        {
          sCache = new ArrayList();
          paramContext = new TintContextWrapper(paramContext);
          sCache.add(new WeakReference(paramContext));
          return paramContext;
        }
        i = sCache.size() - 1;
        if (i >= 0)
        {
          localObject1 = (WeakReference)sCache.get(i);
          if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
            break label162;
          }
          sCache.remove(i);
          break label162;
        }
        i = sCache.size() - 1;
        if (i < 0) {
          continue;
        }
        localObject1 = (WeakReference)sCache.get(i);
        if (localObject1 == null) {
          break label169;
        }
        localObject1 = (TintContextWrapper)((WeakReference)localObject1).get();
        if ((localObject1 == null) || (((TintContextWrapper)localObject1).getBaseContext() != paramContext)) {
          break label174;
        }
        return localObject1;
      }
      return paramContext;
      label162:
      i -= 1;
      continue;
      label169:
      Object localObject1 = null;
      continue;
      label174:
      i -= 1;
    }
  }
  
  public AssetManager getAssets()
  {
    return this.mResources.getAssets();
  }
  
  public Resources getResources()
  {
    return this.mResources;
  }
  
  public Resources.Theme getTheme()
  {
    if (this.mTheme == null) {
      return super.getTheme();
    }
    return this.mTheme;
  }
  
  public void setTheme(int paramInt)
  {
    if (this.mTheme == null)
    {
      super.setTheme(paramInt);
      return;
    }
    this.mTheme.applyStyle(paramInt, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.TintContextWrapper
 * JD-Core Version:    0.7.0.1
 */