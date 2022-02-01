package android.support.v4.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.v4.os.BuildCompat;
import android.text.Editable;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TextViewCompat
{
  public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
  public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
  static final TextViewCompatBaseImpl IMPL = new TextViewCompatBaseImpl();
  
  static
  {
    if (BuildCompat.isAtLeastOMR1())
    {
      IMPL = new TextViewCompatApi27Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      IMPL = new TextViewCompatApi26Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      IMPL = new TextViewCompatApi23Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new TextViewCompatApi18Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      IMPL = new TextViewCompatApi17Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new TextViewCompatApi16Impl();
      return;
    }
  }
  
  public static int getAutoSizeMaxTextSize(@NonNull TextView paramTextView)
  {
    return IMPL.getAutoSizeMaxTextSize(paramTextView);
  }
  
  public static int getAutoSizeMinTextSize(@NonNull TextView paramTextView)
  {
    return IMPL.getAutoSizeMinTextSize(paramTextView);
  }
  
  public static int getAutoSizeStepGranularity(@NonNull TextView paramTextView)
  {
    return IMPL.getAutoSizeStepGranularity(paramTextView);
  }
  
  @NonNull
  public static int[] getAutoSizeTextAvailableSizes(@NonNull TextView paramTextView)
  {
    return IMPL.getAutoSizeTextAvailableSizes(paramTextView);
  }
  
  public static int getAutoSizeTextType(@NonNull TextView paramTextView)
  {
    return IMPL.getAutoSizeTextType(paramTextView);
  }
  
  @NonNull
  public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView paramTextView)
  {
    return IMPL.getCompoundDrawablesRelative(paramTextView);
  }
  
  public static int getMaxLines(@NonNull TextView paramTextView)
  {
    return IMPL.getMaxLines(paramTextView);
  }
  
  public static int getMinLines(@NonNull TextView paramTextView)
  {
    return IMPL.getMinLines(paramTextView);
  }
  
  public static void setAutoSizeTextTypeUniformWithConfiguration(@NonNull TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.setAutoSizeTextTypeUniformWithConfiguration(paramTextView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull TextView paramTextView, @NonNull int[] paramArrayOfInt, int paramInt)
  {
    IMPL.setAutoSizeTextTypeUniformWithPresetSizes(paramTextView, paramArrayOfInt, paramInt);
  }
  
  public static void setAutoSizeTextTypeWithDefaults(@NonNull TextView paramTextView, int paramInt)
  {
    IMPL.setAutoSizeTextTypeWithDefaults(paramTextView, paramInt);
  }
  
  public static void setCompoundDrawablesRelative(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    IMPL.setCompoundDrawablesRelative(paramTextView, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(paramTextView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(paramTextView, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setCustomSelectionActionModeCallback(@NonNull TextView paramTextView, @NonNull ActionMode.Callback paramCallback)
  {
    IMPL.setCustomSelectionActionModeCallback(paramTextView, paramCallback);
  }
  
  public static void setTextAppearance(@NonNull TextView paramTextView, @StyleRes int paramInt)
  {
    IMPL.setTextAppearance(paramTextView, paramInt);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface AutoSizeTextType {}
  
  @RequiresApi(16)
  static class TextViewCompatApi16Impl
    extends TextViewCompat.TextViewCompatBaseImpl
  {
    public int getMaxLines(TextView paramTextView)
    {
      return paramTextView.getMaxLines();
    }
    
    public int getMinLines(TextView paramTextView)
    {
      return paramTextView.getMinLines();
    }
  }
  
  @RequiresApi(17)
  static class TextViewCompatApi17Impl
    extends TextViewCompat.TextViewCompatApi16Impl
  {
    public Drawable[] getCompoundDrawablesRelative(@NonNull TextView paramTextView)
    {
      int i = 1;
      if (paramTextView.getLayoutDirection() == 1) {}
      for (;;)
      {
        paramTextView = paramTextView.getCompoundDrawables();
        if (i != 0)
        {
          Object localObject1 = paramTextView[2];
          Object localObject2 = paramTextView[0];
          paramTextView[0] = localObject1;
          paramTextView[2] = localObject2;
        }
        return paramTextView;
        i = 0;
      }
    }
    
    public void setCompoundDrawablesRelative(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
    {
      int i;
      Drawable localDrawable;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0) {
          break label42;
        }
        localDrawable = paramDrawable3;
        label20:
        if (i == 0) {
          break label48;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawables(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
        return;
        i = 0;
        break;
        label42:
        localDrawable = paramDrawable1;
        break label20;
        label48:
        paramDrawable1 = paramDrawable3;
      }
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
    {
      int i;
      int j;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0) {
          break label42;
        }
        j = paramInt3;
        label20:
        if (i == 0) {
          break label48;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(j, paramInt2, paramInt1, paramInt4);
        return;
        i = 0;
        break;
        label42:
        j = paramInt1;
        break label20;
        label48:
        paramInt1 = paramInt3;
      }
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
    {
      int i;
      Drawable localDrawable;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0) {
          break label42;
        }
        localDrawable = paramDrawable3;
        label20:
        if (i == 0) {
          break label48;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
        return;
        i = 0;
        break;
        label42:
        localDrawable = paramDrawable1;
        break label20;
        label48:
        paramDrawable1 = paramDrawable3;
      }
    }
  }
  
  @RequiresApi(18)
  static class TextViewCompatApi18Impl
    extends TextViewCompat.TextViewCompatApi17Impl
  {
    public Drawable[] getCompoundDrawablesRelative(@NonNull TextView paramTextView)
    {
      return paramTextView.getCompoundDrawablesRelative();
    }
    
    public void setCompoundDrawablesRelative(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
    {
      paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
    {
      paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
    {
      paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    }
  }
  
  @RequiresApi(23)
  static class TextViewCompatApi23Impl
    extends TextViewCompat.TextViewCompatApi18Impl
  {
    public void setTextAppearance(@NonNull TextView paramTextView, @StyleRes int paramInt)
    {
      paramTextView.setTextAppearance(paramInt);
    }
  }
  
  @RequiresApi(26)
  static class TextViewCompatApi26Impl
    extends TextViewCompat.TextViewCompatApi23Impl
  {
    public void setCustomSelectionActionModeCallback(final TextView paramTextView, final ActionMode.Callback paramCallback)
    {
      if ((Build.VERSION.SDK_INT != 26) && (Build.VERSION.SDK_INT != 27))
      {
        super.setCustomSelectionActionModeCallback(paramTextView, paramCallback);
        return;
      }
      paramTextView.setCustomSelectionActionModeCallback(new ActionMode.Callback()
      {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences = false;
        private Class mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        
        private Intent createProcessTextIntent()
        {
          return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
        
        private Intent createProcessTextIntentForResolveInfo(ResolveInfo paramAnonymousResolveInfo, TextView paramAnonymousTextView)
        {
          Intent localIntent = createProcessTextIntent();
          if (!isEditable(paramAnonymousTextView)) {}
          for (boolean bool = true;; bool = false) {
            return localIntent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", bool).setClassName(paramAnonymousResolveInfo.activityInfo.packageName, paramAnonymousResolveInfo.activityInfo.name);
          }
        }
        
        private List<ResolveInfo> getSupportedActivities(Context paramAnonymousContext, PackageManager paramAnonymousPackageManager)
        {
          ArrayList localArrayList = new ArrayList();
          if (!(paramAnonymousContext instanceof Activity)) {
            return localArrayList;
          }
          paramAnonymousPackageManager = paramAnonymousPackageManager.queryIntentActivities(createProcessTextIntent(), 0).iterator();
          while (paramAnonymousPackageManager.hasNext())
          {
            ResolveInfo localResolveInfo = (ResolveInfo)paramAnonymousPackageManager.next();
            if (isSupportedActivity(localResolveInfo, paramAnonymousContext)) {
              localArrayList.add(localResolveInfo);
            }
          }
          return localArrayList;
        }
        
        private boolean isEditable(TextView paramAnonymousTextView)
        {
          return ((paramAnonymousTextView instanceof Editable)) && (paramAnonymousTextView.onCheckIsTextEditor()) && (paramAnonymousTextView.isEnabled());
        }
        
        private boolean isSupportedActivity(ResolveInfo paramAnonymousResolveInfo, Context paramAnonymousContext)
        {
          boolean bool2 = false;
          boolean bool1;
          if (paramAnonymousContext.getPackageName().equals(paramAnonymousResolveInfo.activityInfo.packageName)) {
            bool1 = true;
          }
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!paramAnonymousResolveInfo.activityInfo.exported);
            if (paramAnonymousResolveInfo.activityInfo.permission == null) {
              break;
            }
            bool1 = bool2;
          } while (paramAnonymousContext.checkSelfPermission(paramAnonymousResolveInfo.activityInfo.permission) != 0);
          return true;
        }
        
        /* Error */
        private void recomputeProcessTextMenuItems(Menu paramAnonymousMenu)
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 38	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:val$textView	Landroid/widget/TextView;
          //   4: invokevirtual 177	android/widget/TextView:getContext	()Landroid/content/Context;
          //   7: astore 5
          //   9: aload 5
          //   11: invokevirtual 181	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
          //   14: astore 4
          //   16: aload_0
          //   17: getfield 43	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:mInitializedMenuBuilderReferences	Z
          //   20: ifne +45 -> 65
          //   23: aload_0
          //   24: iconst_1
          //   25: putfield 43	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:mInitializedMenuBuilderReferences	Z
          //   28: aload_0
          //   29: ldc 183
          //   31: invokestatic 189	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
          //   34: putfield 191	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:mMenuBuilderClass	Ljava/lang/Class;
          //   37: aload_0
          //   38: aload_0
          //   39: getfield 191	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:mMenuBuilderClass	Ljava/lang/Class;
          //   42: ldc 193
          //   44: iconst_1
          //   45: anewarray 185	java/lang/Class
          //   48: dup
          //   49: iconst_0
          //   50: getstatic 198	java/lang/Integer:TYPE	Ljava/lang/Class;
          //   53: aastore
          //   54: invokevirtual 202	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
          //   57: putfield 204	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:mMenuBuilderRemoveItemAtMethod	Ljava/lang/reflect/Method;
          //   60: aload_0
          //   61: iconst_1
          //   62: putfield 206	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:mCanUseMenuBuilderReferences	Z
          //   65: aload_0
          //   66: getfield 206	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:mCanUseMenuBuilderReferences	Z
          //   69: ifeq +112 -> 181
          //   72: aload_0
          //   73: getfield 191	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:mMenuBuilderClass	Ljava/lang/Class;
          //   76: aload_1
          //   77: invokevirtual 209	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
          //   80: ifeq +101 -> 181
          //   83: aload_0
          //   84: getfield 204	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:mMenuBuilderRemoveItemAtMethod	Ljava/lang/reflect/Method;
          //   87: astore_3
          //   88: aload_1
          //   89: invokeinterface 215 1 0
          //   94: iconst_1
          //   95: isub
          //   96: istore_2
          //   97: iload_2
          //   98: iflt +106 -> 204
          //   101: aload_1
          //   102: iload_2
          //   103: invokeinterface 219 2 0
          //   108: astore 6
          //   110: aload 6
          //   112: invokeinterface 224 1 0
          //   117: ifnull +38 -> 155
          //   120: ldc 51
          //   122: aload 6
          //   124: invokeinterface 224 1 0
          //   129: invokevirtual 227	android/content/Intent:getAction	()Ljava/lang/String;
          //   132: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   135: ifeq +20 -> 155
          //   138: aload_3
          //   139: aload_1
          //   140: iconst_1
          //   141: anewarray 4	java/lang/Object
          //   144: dup
          //   145: iconst_0
          //   146: iload_2
          //   147: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   150: aastore
          //   151: invokevirtual 237	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
          //   154: pop
          //   155: iload_2
          //   156: iconst_1
          //   157: isub
          //   158: istore_2
          //   159: goto -62 -> 97
          //   162: astore_3
          //   163: aload_0
          //   164: aconst_null
          //   165: putfield 191	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:mMenuBuilderClass	Ljava/lang/Class;
          //   168: aload_0
          //   169: aconst_null
          //   170: putfield 204	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:mMenuBuilderRemoveItemAtMethod	Ljava/lang/reflect/Method;
          //   173: aload_0
          //   174: iconst_0
          //   175: putfield 206	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:mCanUseMenuBuilderReferences	Z
          //   178: goto -113 -> 65
          //   181: aload_1
          //   182: invokevirtual 241	java/lang/Object:getClass	()Ljava/lang/Class;
          //   185: ldc 193
          //   187: iconst_1
          //   188: anewarray 185	java/lang/Class
          //   191: dup
          //   192: iconst_0
          //   193: getstatic 198	java/lang/Integer:TYPE	Ljava/lang/Class;
          //   196: aastore
          //   197: invokevirtual 202	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
          //   200: astore_3
          //   201: goto -113 -> 88
          //   204: aload_0
          //   205: aload 5
          //   207: aload 4
          //   209: invokespecial 243	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:getSupportedActivities	(Landroid/content/Context;Landroid/content/pm/PackageManager;)Ljava/util/List;
          //   212: astore_3
          //   213: iconst_0
          //   214: istore_2
          //   215: iload_2
          //   216: aload_3
          //   217: invokeinterface 244 1 0
          //   222: if_icmpge +63 -> 285
          //   225: aload_3
          //   226: iload_2
          //   227: invokeinterface 248 2 0
          //   232: checkcast 76	android/content/pm/ResolveInfo
          //   235: astore 5
          //   237: aload_1
          //   238: iconst_0
          //   239: iconst_0
          //   240: iload_2
          //   241: bipush 100
          //   243: iadd
          //   244: aload 5
          //   246: aload 4
          //   248: invokevirtual 252	android/content/pm/ResolveInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
          //   251: invokeinterface 255 5 0
          //   256: aload_0
          //   257: aload 5
          //   259: aload_0
          //   260: getfield 38	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:val$textView	Landroid/widget/TextView;
          //   263: invokespecial 257	android/support/v4/widget/TextViewCompat$TextViewCompatApi26Impl$1:createProcessTextIntentForResolveInfo	(Landroid/content/pm/ResolveInfo;Landroid/widget/TextView;)Landroid/content/Intent;
          //   266: invokeinterface 261 2 0
          //   271: iconst_1
          //   272: invokeinterface 265 2 0
          //   277: iload_2
          //   278: iconst_1
          //   279: iadd
          //   280: istore_2
          //   281: goto -66 -> 215
          //   284: astore_1
          //   285: return
          //   286: astore_1
          //   287: return
          //   288: astore_1
          //   289: return
          //   290: astore_3
          //   291: goto -128 -> 163
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	294	0	this	1
          //   0	294	1	paramAnonymousMenu	Menu
          //   96	185	2	i	int
          //   87	52	3	localMethod	Method
          //   162	1	3	localClassNotFoundException	java.lang.ClassNotFoundException
          //   200	26	3	localObject1	Object
          //   290	1	3	localNoSuchMethodException	java.lang.NoSuchMethodException
          //   14	233	4	localPackageManager	PackageManager
          //   7	251	5	localObject2	Object
          //   108	15	6	localMenuItem	MenuItem
          // Exception table:
          //   from	to	target	type
          //   28	65	162	java/lang/ClassNotFoundException
          //   65	88	284	java/lang/IllegalAccessException
          //   88	97	284	java/lang/IllegalAccessException
          //   101	155	284	java/lang/IllegalAccessException
          //   181	201	284	java/lang/IllegalAccessException
          //   65	88	286	java/lang/NoSuchMethodException
          //   88	97	286	java/lang/NoSuchMethodException
          //   101	155	286	java/lang/NoSuchMethodException
          //   181	201	286	java/lang/NoSuchMethodException
          //   65	88	288	java/lang/reflect/InvocationTargetException
          //   88	97	288	java/lang/reflect/InvocationTargetException
          //   101	155	288	java/lang/reflect/InvocationTargetException
          //   181	201	288	java/lang/reflect/InvocationTargetException
          //   28	65	290	java/lang/NoSuchMethodException
        }
        
        public boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
        {
          return paramCallback.onActionItemClicked(paramAnonymousActionMode, paramAnonymousMenuItem);
        }
        
        public boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
        {
          return paramCallback.onCreateActionMode(paramAnonymousActionMode, paramAnonymousMenu);
        }
        
        public void onDestroyActionMode(ActionMode paramAnonymousActionMode)
        {
          paramCallback.onDestroyActionMode(paramAnonymousActionMode);
        }
        
        public boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
        {
          recomputeProcessTextMenuItems(paramAnonymousMenu);
          return paramCallback.onPrepareActionMode(paramAnonymousActionMode, paramAnonymousMenu);
        }
      });
    }
  }
  
  @RequiresApi(27)
  static class TextViewCompatApi27Impl
    extends TextViewCompat.TextViewCompatApi26Impl
  {
    public int getAutoSizeMaxTextSize(TextView paramTextView)
    {
      return paramTextView.getAutoSizeMaxTextSize();
    }
    
    public int getAutoSizeMinTextSize(TextView paramTextView)
    {
      return paramTextView.getAutoSizeMinTextSize();
    }
    
    public int getAutoSizeStepGranularity(TextView paramTextView)
    {
      return paramTextView.getAutoSizeStepGranularity();
    }
    
    public int[] getAutoSizeTextAvailableSizes(TextView paramTextView)
    {
      return paramTextView.getAutoSizeTextAvailableSizes();
    }
    
    public int getAutoSizeTextType(TextView paramTextView)
    {
      return paramTextView.getAutoSizeTextType();
    }
    
    public void setAutoSizeTextTypeUniformWithConfiguration(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramTextView.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void setAutoSizeTextTypeUniformWithPresetSizes(TextView paramTextView, @NonNull int[] paramArrayOfInt, int paramInt)
    {
      paramTextView.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    
    public void setAutoSizeTextTypeWithDefaults(TextView paramTextView, int paramInt)
    {
      paramTextView.setAutoSizeTextTypeWithDefaults(paramInt);
    }
  }
  
  static class TextViewCompatBaseImpl
  {
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompatBase";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;
    
    private static Field retrieveField(String paramString)
    {
      Object localObject = null;
      try
      {
        Field localField = TextView.class.getDeclaredField(paramString);
        localObject = localField;
        localField.setAccessible(true);
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("TextViewCompatBase", "Could not retrieve " + paramString + " field.");
      }
      return localObject;
    }
    
    private static int retrieveIntFromField(Field paramField, TextView paramTextView)
    {
      try
      {
        int i = paramField.getInt(paramTextView);
        return i;
      }
      catch (IllegalAccessException paramTextView)
      {
        Log.d("TextViewCompatBase", "Could not retrieve value of " + paramField.getName() + " field.");
      }
      return -1;
    }
    
    public int getAutoSizeMaxTextSize(TextView paramTextView)
    {
      if ((paramTextView instanceof AutoSizeableTextView)) {
        return ((AutoSizeableTextView)paramTextView).getAutoSizeMaxTextSize();
      }
      return -1;
    }
    
    public int getAutoSizeMinTextSize(TextView paramTextView)
    {
      if ((paramTextView instanceof AutoSizeableTextView)) {
        return ((AutoSizeableTextView)paramTextView).getAutoSizeMinTextSize();
      }
      return -1;
    }
    
    public int getAutoSizeStepGranularity(TextView paramTextView)
    {
      if ((paramTextView instanceof AutoSizeableTextView)) {
        return ((AutoSizeableTextView)paramTextView).getAutoSizeStepGranularity();
      }
      return -1;
    }
    
    public int[] getAutoSizeTextAvailableSizes(TextView paramTextView)
    {
      if ((paramTextView instanceof AutoSizeableTextView)) {
        return ((AutoSizeableTextView)paramTextView).getAutoSizeTextAvailableSizes();
      }
      return new int[0];
    }
    
    public int getAutoSizeTextType(TextView paramTextView)
    {
      if ((paramTextView instanceof AutoSizeableTextView)) {
        return ((AutoSizeableTextView)paramTextView).getAutoSizeTextType();
      }
      return 0;
    }
    
    public Drawable[] getCompoundDrawablesRelative(@NonNull TextView paramTextView)
    {
      return paramTextView.getCompoundDrawables();
    }
    
    public int getMaxLines(TextView paramTextView)
    {
      if (!sMaxModeFieldFetched)
      {
        sMaxModeField = retrieveField("mMaxMode");
        sMaxModeFieldFetched = true;
      }
      if ((sMaxModeField != null) && (retrieveIntFromField(sMaxModeField, paramTextView) == 1))
      {
        if (!sMaximumFieldFetched)
        {
          sMaximumField = retrieveField("mMaximum");
          sMaximumFieldFetched = true;
        }
        if (sMaximumField != null) {
          return retrieveIntFromField(sMaximumField, paramTextView);
        }
      }
      return -1;
    }
    
    public int getMinLines(TextView paramTextView)
    {
      if (!sMinModeFieldFetched)
      {
        sMinModeField = retrieveField("mMinMode");
        sMinModeFieldFetched = true;
      }
      if ((sMinModeField != null) && (retrieveIntFromField(sMinModeField, paramTextView) == 1))
      {
        if (!sMinimumFieldFetched)
        {
          sMinimumField = retrieveField("mMinimum");
          sMinimumFieldFetched = true;
        }
        if (sMinimumField != null) {
          return retrieveIntFromField(sMinimumField, paramTextView);
        }
      }
      return -1;
    }
    
    public void setAutoSizeTextTypeUniformWithConfiguration(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if ((paramTextView instanceof AutoSizeableTextView)) {
        ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public void setAutoSizeTextTypeUniformWithPresetSizes(TextView paramTextView, @NonNull int[] paramArrayOfInt, int paramInt)
    {
      if ((paramTextView instanceof AutoSizeableTextView)) {
        ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      }
    }
    
    public void setAutoSizeTextTypeWithDefaults(TextView paramTextView, int paramInt)
    {
      if ((paramTextView instanceof AutoSizeableTextView)) {
        ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeWithDefaults(paramInt);
      }
    }
    
    public void setCompoundDrawablesRelative(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
    {
      paramTextView.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    }
    
    public void setCustomSelectionActionModeCallback(TextView paramTextView, ActionMode.Callback paramCallback)
    {
      paramTextView.setCustomSelectionActionModeCallback(paramCallback);
    }
    
    public void setTextAppearance(TextView paramTextView, @StyleRes int paramInt)
    {
      paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.TextViewCompat
 * JD-Core Version:    0.7.0.1
 */