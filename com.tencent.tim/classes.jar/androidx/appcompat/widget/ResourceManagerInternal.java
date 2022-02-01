package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResourceManagerInternal
{
  private static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
  private static final boolean DEBUG = false;
  private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  private static ResourceManagerInternal INSTANCE;
  private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
  private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
  private static final String TAG = "ResourceManagerInternal";
  private ArrayMap<String, InflateDelegate> mDelegates;
  private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap(0);
  private boolean mHasCheckedVectorDrawableSetup;
  private ResourceManagerHooks mHooks;
  private SparseArrayCompat<String> mKnownDrawableIdTags;
  private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
  private TypedValue mTypedValue;
  
  private void addDelegate(@NonNull String paramString, @NonNull InflateDelegate paramInflateDelegate)
  {
    if (this.mDelegates == null) {
      this.mDelegates = new ArrayMap();
    }
    this.mDelegates.put(paramString, paramInflateDelegate);
  }
  
  /* Error */
  private boolean addDrawableToCache(@NonNull Context paramContext, long paramLong, @NonNull Drawable paramDrawable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload 4
    //   4: invokevirtual 105	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   7: astore 7
    //   9: aload 7
    //   11: ifnull +68 -> 79
    //   14: aload_0
    //   15: getfield 84	androidx/appcompat/widget/ResourceManagerInternal:mDrawableCaches	Ljava/util/WeakHashMap;
    //   18: aload_1
    //   19: invokevirtual 109	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 111	androidx/collection/LongSparseArray
    //   25: astore 6
    //   27: aload 6
    //   29: astore 4
    //   31: aload 6
    //   33: ifnonnull +23 -> 56
    //   36: new 111	androidx/collection/LongSparseArray
    //   39: dup
    //   40: invokespecial 112	androidx/collection/LongSparseArray:<init>	()V
    //   43: astore 4
    //   45: aload_0
    //   46: getfield 84	androidx/appcompat/widget/ResourceManagerInternal:mDrawableCaches	Ljava/util/WeakHashMap;
    //   49: aload_1
    //   50: aload 4
    //   52: invokevirtual 113	java/util/WeakHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload 4
    //   58: lload_2
    //   59: new 115	java/lang/ref/WeakReference
    //   62: dup
    //   63: aload 7
    //   65: invokespecial 118	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   68: invokevirtual 121	androidx/collection/LongSparseArray:put	(JLjava/lang/Object;)V
    //   71: iconst_1
    //   72: istore 5
    //   74: aload_0
    //   75: monitorexit
    //   76: iload 5
    //   78: ireturn
    //   79: iconst_0
    //   80: istore 5
    //   82: goto -8 -> 74
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	ResourceManagerInternal
    //   0	90	1	paramContext	Context
    //   0	90	2	paramLong	long
    //   0	90	4	paramDrawable	Drawable
    //   72	9	5	bool	boolean
    //   25	7	6	localLongSparseArray	LongSparseArray
    //   7	57	7	localConstantState	Drawable.ConstantState
    // Exception table:
    //   from	to	target	type
    //   2	9	85	finally
    //   14	27	85	finally
    //   36	56	85	finally
    //   56	71	85	finally
  }
  
  private void addTintListToCache(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull ColorStateList paramColorStateList)
  {
    if (this.mTintLists == null) {
      this.mTintLists = new WeakHashMap();
    }
    SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.mTintLists.get(paramContext);
    SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
    if (localSparseArrayCompat2 == null)
    {
      localSparseArrayCompat1 = new SparseArrayCompat();
      this.mTintLists.put(paramContext, localSparseArrayCompat1);
    }
    localSparseArrayCompat1.append(paramInt, paramColorStateList);
  }
  
  private static boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void checkVectorDrawableSetup(@NonNull Context paramContext)
  {
    if (this.mHasCheckedVectorDrawableSetup) {}
    do
    {
      return;
      this.mHasCheckedVectorDrawableSetup = true;
      paramContext = getDrawable(paramContext, 2130837590);
    } while ((paramContext != null) && (isVectorDrawable(paramContext)));
    this.mHasCheckedVectorDrawableSetup = false;
    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
  }
  
  private static long createCacheKey(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  private Drawable createDrawableIfNeeded(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if (this.mTypedValue == null) {
      this.mTypedValue = new TypedValue();
    }
    TypedValue localTypedValue = this.mTypedValue;
    paramContext.getResources().getValue(paramInt, localTypedValue, true);
    long l = createCacheKey(localTypedValue);
    Object localObject = getCachedDrawable(paramContext, l);
    if (localObject != null) {
      return localObject;
    }
    if (this.mHooks == null) {}
    for (Drawable localDrawable = null;; localDrawable = this.mHooks.createDrawableFor(this, paramContext, paramInt))
    {
      localObject = localDrawable;
      if (localDrawable == null) {
        break;
      }
      localDrawable.setChangingConfigurations(localTypedValue.changingConfigurations);
      addDrawableToCache(paramContext, l, localDrawable);
      return localDrawable;
    }
  }
  
  private static PorterDuffColorFilter createTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int[] paramArrayOfInt)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return getPorterDuffColorFilter(paramColorStateList.getColorForState(paramArrayOfInt, 0), paramMode);
  }
  
  public static ResourceManagerInternal get()
  {
    try
    {
      if (INSTANCE == null)
      {
        INSTANCE = new ResourceManagerInternal();
        installDefaultInflateDelegates(INSTANCE);
      }
      ResourceManagerInternal localResourceManagerInternal = INSTANCE;
      return localResourceManagerInternal;
    }
    finally {}
  }
  
  /* Error */
  private Drawable getCachedDrawable(@NonNull Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	androidx/appcompat/widget/ResourceManagerInternal:mDrawableCaches	Ljava/util/WeakHashMap;
    //   6: aload_1
    //   7: invokevirtual 109	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 111	androidx/collection/LongSparseArray
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +9 -> 26
    //   20: aconst_null
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: aload 4
    //   28: lload_2
    //   29: invokevirtual 226	androidx/collection/LongSparseArray:get	(J)Ljava/lang/Object;
    //   32: checkcast 115	java/lang/ref/WeakReference
    //   35: astore 5
    //   37: aload 5
    //   39: ifnull +37 -> 76
    //   42: aload 5
    //   44: invokevirtual 229	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   47: checkcast 231	android/graphics/drawable/Drawable$ConstantState
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +16 -> 70
    //   57: aload 5
    //   59: aload_1
    //   60: invokevirtual 177	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   63: invokevirtual 235	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   66: astore_1
    //   67: goto -45 -> 22
    //   70: aload 4
    //   72: lload_2
    //   73: invokevirtual 239	androidx/collection/LongSparseArray:delete	(J)V
    //   76: aconst_null
    //   77: astore_1
    //   78: goto -56 -> 22
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ResourceManagerInternal
    //   0	86	1	paramContext	Context
    //   0	86	2	paramLong	long
    //   13	58	4	localLongSparseArray	LongSparseArray
    //   35	23	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	81	finally
    //   26	37	81	finally
    //   42	52	81	finally
    //   57	67	81	finally
    //   70	76	81	finally
  }
  
  public static PorterDuffColorFilter getPorterDuffColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      PorterDuffColorFilter localPorterDuffColorFilter2 = COLOR_FILTER_CACHE.get(paramInt, paramMode);
      PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
      if (localPorterDuffColorFilter2 == null)
      {
        localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
        COLOR_FILTER_CACHE.put(paramInt, paramMode, localPorterDuffColorFilter1);
      }
      return localPorterDuffColorFilter1;
    }
    finally {}
  }
  
  private ColorStateList getTintListFromCache(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if (this.mTintLists != null)
    {
      paramContext = (SparseArrayCompat)this.mTintLists.get(paramContext);
      if (paramContext != null) {
        return (ColorStateList)paramContext.get(paramInt);
      }
      return null;
    }
    return null;
  }
  
  private static void installDefaultInflateDelegates(@NonNull ResourceManagerInternal paramResourceManagerInternal)
  {
    if (Build.VERSION.SDK_INT < 24)
    {
      paramResourceManagerInternal.addDelegate("vector", new VdcInflateDelegate());
      paramResourceManagerInternal.addDelegate("animated-vector", new AvdcInflateDelegate());
      paramResourceManagerInternal.addDelegate("animated-selector", new AsldcInflateDelegate());
    }
  }
  
  private static boolean isVectorDrawable(@NonNull Drawable paramDrawable)
  {
    return ((paramDrawable instanceof VectorDrawableCompat)) || ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()));
  }
  
  private Drawable loadDrawableFromDelegates(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if ((this.mDelegates != null) && (!this.mDelegates.isEmpty()))
    {
      if (this.mKnownDrawableIdTags != null)
      {
        localObject1 = (String)this.mKnownDrawableIdTags.get(paramInt);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (this.mDelegates.get(localObject1) == null)))
        {
          localObject1 = null;
          return localObject1;
        }
      }
      else
      {
        this.mKnownDrawableIdTags = new SparseArrayCompat();
      }
      if (this.mTypedValue == null) {
        this.mTypedValue = new TypedValue();
      }
      TypedValue localTypedValue = this.mTypedValue;
      Object localObject1 = paramContext.getResources();
      ((Resources)localObject1).getValue(paramInt, localTypedValue, true);
      long l = createCacheKey(localTypedValue);
      Drawable localDrawable = getCachedDrawable(paramContext, l);
      if (localDrawable != null) {
        return localDrawable;
      }
      Object localObject2 = localDrawable;
      XmlResourceParser localXmlResourceParser;
      AttributeSet localAttributeSet;
      if (localTypedValue.string != null)
      {
        localObject2 = localDrawable;
        if (localTypedValue.string.toString().endsWith(".xml"))
        {
          localObject2 = localDrawable;
          try
          {
            localXmlResourceParser = ((Resources)localObject1).getXml(paramInt);
            localObject2 = localDrawable;
            localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
            int i;
            do
            {
              localObject2 = localDrawable;
              i = localXmlResourceParser.next();
            } while ((i != 2) && (i != 1));
            if (i != 2)
            {
              localObject2 = localDrawable;
              throw new XmlPullParserException("No start tag found");
            }
          }
          catch (Exception paramContext)
          {
            Log.e("ResourceManagerInternal", "Exception while inflating drawable", paramContext);
          }
        }
      }
      for (paramContext = (Context)localObject2;; paramContext = (Context)localObject1)
      {
        localObject1 = paramContext;
        if (paramContext != null) {
          break;
        }
        this.mKnownDrawableIdTags.append(paramInt, "appcompat_skip_skip");
        return paramContext;
        localObject2 = localDrawable;
        localObject1 = localXmlResourceParser.getName();
        localObject2 = localDrawable;
        this.mKnownDrawableIdTags.append(paramInt, localObject1);
        localObject2 = localDrawable;
        InflateDelegate localInflateDelegate = (InflateDelegate)this.mDelegates.get(localObject1);
        localObject1 = localDrawable;
        if (localInflateDelegate != null)
        {
          localObject2 = localDrawable;
          localObject1 = localInflateDelegate.createFromXmlInner(paramContext, localXmlResourceParser, localAttributeSet, paramContext.getTheme());
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
          localObject2 = localObject1;
          boolean bool = addDrawableToCache(paramContext, l, (Drawable)localObject1);
          if (!bool) {}
        }
      }
    }
    return null;
  }
  
  private void removeDelegate(@NonNull String paramString, @NonNull InflateDelegate paramInflateDelegate)
  {
    if ((this.mDelegates != null) && (this.mDelegates.get(paramString) == paramInflateDelegate)) {
      this.mDelegates.remove(paramString);
    }
  }
  
  private Drawable tintDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean, @NonNull Drawable paramDrawable)
  {
    Object localObject = getTintList(paramContext, paramInt);
    if (localObject != null)
    {
      paramContext = paramDrawable;
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramContext = DrawableCompat.wrap(paramContext);
      DrawableCompat.setTintList(paramContext, (ColorStateList)localObject);
      paramDrawable = getTintMode(paramInt);
      localObject = paramContext;
      if (paramDrawable != null)
      {
        DrawableCompat.setTintMode(paramContext, paramDrawable);
        localObject = paramContext;
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject;
          if (this.mHooks == null) {
            break;
          }
          localObject = paramDrawable;
        } while (this.mHooks.tintDrawable(paramContext, paramInt, paramDrawable));
        localObject = paramDrawable;
      } while (tintDrawableUsingColorFilter(paramContext, paramInt, paramDrawable));
      localObject = paramDrawable;
    } while (!paramBoolean);
    return null;
  }
  
  static void tintDrawable(Drawable paramDrawable, TintInfo paramTintInfo, int[] paramArrayOfInt)
  {
    if ((DrawableUtils.canSafelyMutateDrawable(paramDrawable)) && (paramDrawable.mutate() != paramDrawable)) {
      Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }
    label63:
    label91:
    label103:
    for (;;)
    {
      return;
      ColorStateList localColorStateList;
      if ((paramTintInfo.mHasTintList) || (paramTintInfo.mHasTintMode)) {
        if (paramTintInfo.mHasTintList)
        {
          localColorStateList = paramTintInfo.mTintList;
          if (!paramTintInfo.mHasTintMode) {
            break label91;
          }
          paramTintInfo = paramTintInfo.mTintMode;
          paramDrawable.setColorFilter(createTintFilter(localColorStateList, paramTintInfo, paramArrayOfInt));
        }
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT > 23) {
          break label103;
        }
        paramDrawable.invalidateSelf();
        return;
        localColorStateList = null;
        break;
        paramTintInfo = DEFAULT_MODE;
        break label63;
        paramDrawable.clearColorFilter();
      }
    }
  }
  
  public Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    try
    {
      paramContext = getDrawable(paramContext, paramInt, false);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean)
  {
    try
    {
      checkVectorDrawableSetup(paramContext);
      Object localObject2 = loadDrawableFromDelegates(paramContext, paramInt);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = createDrawableIfNeeded(paramContext, paramInt);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ContextCompat.getDrawable(paramContext, paramInt);
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = tintDrawable(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
      }
      if (localObject1 != null) {
        DrawableUtils.fixDrawable((Drawable)localObject1);
      }
      return localObject1;
    }
    finally {}
  }
  
  /* Error */
  ColorStateList getTintList(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iload_2
    //   5: invokespecial 447	androidx/appcompat/widget/ResourceManagerInternal:getTintListFromCache	(Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    //   8: astore_3
    //   9: aload_3
    //   10: astore 4
    //   12: aload_3
    //   13: ifnonnull +29 -> 42
    //   16: aload_0
    //   17: getfield 191	androidx/appcompat/widget/ResourceManagerInternal:mHooks	Landroidx/appcompat/widget/ResourceManagerInternal$ResourceManagerHooks;
    //   20: ifnonnull +27 -> 47
    //   23: aconst_null
    //   24: astore_3
    //   25: aload_3
    //   26: astore 4
    //   28: aload_3
    //   29: ifnull +13 -> 42
    //   32: aload_0
    //   33: aload_1
    //   34: iload_2
    //   35: aload_3
    //   36: invokespecial 449	androidx/appcompat/widget/ResourceManagerInternal:addTintListToCache	(Landroid/content/Context;ILandroid/content/res/ColorStateList;)V
    //   39: aload_3
    //   40: astore 4
    //   42: aload_0
    //   43: monitorexit
    //   44: aload 4
    //   46: areturn
    //   47: aload_0
    //   48: getfield 191	androidx/appcompat/widget/ResourceManagerInternal:mHooks	Landroidx/appcompat/widget/ResourceManagerInternal$ResourceManagerHooks;
    //   51: aload_1
    //   52: iload_2
    //   53: invokeinterface 452 3 0
    //   58: astore_3
    //   59: goto -34 -> 25
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	ResourceManagerInternal
    //   0	67	1	paramContext	Context
    //   0	67	2	paramInt	int
    //   8	51	3	localColorStateList1	ColorStateList
    //   10	35	4	localColorStateList2	ColorStateList
    // Exception table:
    //   from	to	target	type
    //   2	9	62	finally
    //   16	23	62	finally
    //   32	39	62	finally
    //   47	59	62	finally
  }
  
  PorterDuff.Mode getTintMode(int paramInt)
  {
    if (this.mHooks == null) {
      return null;
    }
    return this.mHooks.getTintModeForDrawableRes(paramInt);
  }
  
  public void onConfigurationChanged(@NonNull Context paramContext)
  {
    try
    {
      paramContext = (LongSparseArray)this.mDrawableCaches.get(paramContext);
      if (paramContext != null) {
        paramContext.clear();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  Drawable onDrawableLoadedFromResources(@NonNull Context paramContext, @NonNull VectorEnabledTintResources paramVectorEnabledTintResources, @DrawableRes int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iload_3
    //   5: invokespecial 434	androidx/appcompat/widget/ResourceManagerInternal:loadDrawableFromDelegates	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   8: astore 5
    //   10: aload 5
    //   12: astore 4
    //   14: aload 5
    //   16: ifnonnull +10 -> 26
    //   19: aload_2
    //   20: iload_3
    //   21: invokevirtual 467	androidx/appcompat/widget/VectorEnabledTintResources:superGetDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull +17 -> 45
    //   31: aload_0
    //   32: aload_1
    //   33: iload_3
    //   34: iconst_0
    //   35: aload 4
    //   37: invokespecial 441	androidx/appcompat/widget/ResourceManagerInternal:tintDrawable	(Landroid/content/Context;IZLandroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: aconst_null
    //   46: astore_1
    //   47: goto -6 -> 41
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	ResourceManagerInternal
    //   0	55	1	paramContext	Context
    //   0	55	2	paramVectorEnabledTintResources	VectorEnabledTintResources
    //   0	55	3	paramInt	int
    //   12	24	4	localDrawable1	Drawable
    //   8	7	5	localDrawable2	Drawable
    // Exception table:
    //   from	to	target	type
    //   2	10	50	finally
    //   19	26	50	finally
    //   31	41	50	finally
  }
  
  public void setHooks(ResourceManagerHooks paramResourceManagerHooks)
  {
    try
    {
      this.mHooks = paramResourceManagerHooks;
      return;
    }
    finally
    {
      paramResourceManagerHooks = finally;
      throw paramResourceManagerHooks;
    }
  }
  
  boolean tintDrawableUsingColorFilter(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable)
  {
    return (this.mHooks != null) && (this.mHooks.tintDrawableUsingColorFilter(paramContext, paramInt, paramDrawable));
  }
  
  @RequiresApi(11)
  static class AsldcInflateDelegate
    implements ResourceManagerInternal.InflateDelegate
  {
    public Drawable createFromXmlInner(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    {
      try
      {
        paramContext = AnimatedStateListDrawableCompat.createFromXmlInner(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", paramContext);
      }
      return null;
    }
  }
  
  static class AvdcInflateDelegate
    implements ResourceManagerInternal.InflateDelegate
  {
    public Drawable createFromXmlInner(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    {
      try
      {
        paramContext = AnimatedVectorDrawableCompat.createFromXmlInner(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", paramContext);
      }
      return null;
    }
  }
  
  static class ColorFilterLruCache
    extends LruCache<Integer, PorterDuffColorFilter>
  {
    public ColorFilterLruCache(int paramInt)
    {
      super();
    }
    
    private static int generateCacheKey(int paramInt, PorterDuff.Mode paramMode)
    {
      return (paramInt + 31) * 31 + paramMode.hashCode();
    }
    
    PorterDuffColorFilter get(int paramInt, PorterDuff.Mode paramMode)
    {
      return (PorterDuffColorFilter)get(Integer.valueOf(generateCacheKey(paramInt, paramMode)));
    }
    
    PorterDuffColorFilter put(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
    {
      return (PorterDuffColorFilter)put(Integer.valueOf(generateCacheKey(paramInt, paramMode)), paramPorterDuffColorFilter);
    }
  }
  
  static abstract interface InflateDelegate
  {
    public abstract Drawable createFromXmlInner(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  static abstract interface ResourceManagerHooks
  {
    public abstract Drawable createDrawableFor(@NonNull ResourceManagerInternal paramResourceManagerInternal, @NonNull Context paramContext, @DrawableRes int paramInt);
    
    public abstract ColorStateList getTintListForDrawableRes(@NonNull Context paramContext, @DrawableRes int paramInt);
    
    public abstract PorterDuff.Mode getTintModeForDrawableRes(int paramInt);
    
    public abstract boolean tintDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable);
    
    public abstract boolean tintDrawableUsingColorFilter(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable);
  }
  
  static class VdcInflateDelegate
    implements ResourceManagerInternal.InflateDelegate
  {
    public Drawable createFromXmlInner(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    {
      try
      {
        paramContext = VectorDrawableCompat.createFromXmlInner(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("VdcInflateDelegate", "Exception while inflating <vector>", paramContext);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.ResourceManagerInternal
 * JD-Core Version:    0.7.0.1
 */