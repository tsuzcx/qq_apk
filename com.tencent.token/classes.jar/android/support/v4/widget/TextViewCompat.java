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
import java.lang.reflect.InvocationTargetException;
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
      int j = paramTextView.getLayoutDirection();
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      paramTextView = paramTextView.getCompoundDrawables();
      if (i != 0)
      {
        Object localObject1 = paramTextView[2];
        Object localObject2 = paramTextView[0];
        paramTextView[0] = localObject1;
        paramTextView[2] = localObject2;
      }
      return paramTextView;
    }
    
    public void setCompoundDrawablesRelative(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
    {
      int j = paramTextView.getLayoutDirection();
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      Drawable localDrawable;
      if (i != 0) {
        localDrawable = paramDrawable3;
      } else {
        localDrawable = paramDrawable1;
      }
      if (i == 0) {
        paramDrawable1 = paramDrawable3;
      }
      paramTextView.setCompoundDrawables(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
    {
      int j = paramTextView.getLayoutDirection();
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      if (i != 0) {
        j = paramInt3;
      } else {
        j = paramInt1;
      }
      if (i == 0) {
        paramInt1 = paramInt3;
      }
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(j, paramInt2, paramInt1, paramInt4);
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
    {
      int j = paramTextView.getLayoutDirection();
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      Drawable localDrawable;
      if (i != 0) {
        localDrawable = paramDrawable3;
      } else {
        localDrawable = paramDrawable1;
      }
      if (i == 0) {
        paramDrawable1 = paramDrawable3;
      }
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
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
          return createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", isEditable(paramAnonymousTextView) ^ true).setClassName(paramAnonymousResolveInfo.activityInfo.packageName, paramAnonymousResolveInfo.activityInfo.name);
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
          boolean bool2 = paramAnonymousContext.getPackageName().equals(paramAnonymousResolveInfo.activityInfo.packageName);
          boolean bool1 = true;
          if (bool2) {
            return true;
          }
          if (!paramAnonymousResolveInfo.activityInfo.exported) {
            return false;
          }
          if (paramAnonymousResolveInfo.activityInfo.permission != null)
          {
            if (paramAnonymousContext.checkSelfPermission(paramAnonymousResolveInfo.activityInfo.permission) == 0) {
              return true;
            }
            bool1 = false;
          }
          return bool1;
        }
        
        private void recomputeProcessTextMenuItems(Menu paramAnonymousMenu)
        {
          Object localObject2 = paramTextView.getContext();
          PackageManager localPackageManager = ((Context)localObject2).getPackageManager();
          if (!this.mInitializedMenuBuilderReferences) {
            this.mInitializedMenuBuilderReferences = true;
          }
          try
          {
            this.mMenuBuilderClass = Class.forName("com.android.internal.view.menu.MenuBuilder");
            this.mMenuBuilderRemoveItemAtMethod = this.mMenuBuilderClass.getDeclaredMethod("removeItemAt", new Class[] { Integer.TYPE });
            this.mCanUseMenuBuilderReferences = true;
          }
          catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
          {
            for (;;)
            {
              try
              {
                if ((this.mCanUseMenuBuilderReferences) && (this.mMenuBuilderClass.isInstance(paramAnonymousMenu))) {
                  localObject1 = this.mMenuBuilderRemoveItemAtMethod;
                } else {
                  localObject1 = paramAnonymousMenu.getClass().getDeclaredMethod("removeItemAt", new Class[] { Integer.TYPE });
                }
                int i = paramAnonymousMenu.size() - 1;
                if (i >= 0)
                {
                  MenuItem localMenuItem = paramAnonymousMenu.getItem(i);
                  if ((localMenuItem.getIntent() != null) && ("android.intent.action.PROCESS_TEXT".equals(localMenuItem.getIntent().getAction()))) {
                    ((Method)localObject1).invoke(paramAnonymousMenu, new Object[] { Integer.valueOf(i) });
                  }
                  i -= 1;
                  continue;
                }
                Object localObject1 = getSupportedActivities((Context)localObject2, localPackageManager);
                i = 0;
                if (i < ((List)localObject1).size())
                {
                  localObject2 = (ResolveInfo)((List)localObject1).get(i);
                  paramAnonymousMenu.add(0, 0, i + 100, ((ResolveInfo)localObject2).loadLabel(localPackageManager)).setIntent(createProcessTextIntentForResolveInfo((ResolveInfo)localObject2, paramTextView)).setShowAsAction(1);
                  i += 1;
                  continue;
                }
                return;
              }
              catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException paramAnonymousMenu) {}
              localClassNotFoundException = localClassNotFoundException;
            }
          }
          this.mMenuBuilderClass = null;
          this.mMenuBuilderRemoveItemAtMethod = null;
          this.mCanUseMenuBuilderReferences = false;
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
      Object localObject1 = null;
      try
      {
        localObject2 = TextView.class.getDeclaredField(paramString);
        localObject1 = localObject2;
        ((Field)localObject2).setAccessible(true);
        return localObject2;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Object localObject2;
        label18:
        break label18;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Could not retrieve ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" field.");
      Log.e("TextViewCompatBase", ((StringBuilder)localObject2).toString());
      return localObject1;
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
        label8:
        break label8;
      }
      paramTextView = new StringBuilder();
      paramTextView.append("Could not retrieve value of ");
      paramTextView.append(paramField.getName());
      paramTextView.append(" field.");
      Log.d("TextViewCompatBase", paramTextView.toString());
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
      Field localField = sMaxModeField;
      if ((localField != null) && (retrieveIntFromField(localField, paramTextView) == 1))
      {
        if (!sMaximumFieldFetched)
        {
          sMaximumField = retrieveField("mMaximum");
          sMaximumFieldFetched = true;
        }
        localField = sMaximumField;
        if (localField != null) {
          return retrieveIntFromField(localField, paramTextView);
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
      Field localField = sMinModeField;
      if ((localField != null) && (retrieveIntFromField(localField, paramTextView) == 1))
      {
        if (!sMinimumFieldFetched)
        {
          sMinimumField = retrieveField("mMinimum");
          sMinimumFieldFetched = true;
        }
        localField = sMinimumField;
        if (localField != null) {
          return retrieveIntFromField(localField, paramTextView);
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