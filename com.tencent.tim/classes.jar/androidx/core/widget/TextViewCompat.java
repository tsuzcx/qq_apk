package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.text.PrecomputedTextCompat.Params;
import androidx.core.text.PrecomputedTextCompat.Params.Builder;
import androidx.core.util.Preconditions;
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
  private static final int LINES = 1;
  private static final String LOG_TAG = "TextViewCompat";
  private static Field sMaxModeField;
  private static boolean sMaxModeFieldFetched;
  private static Field sMaximumField;
  private static boolean sMaximumFieldFetched;
  private static Field sMinModeField;
  private static boolean sMinModeFieldFetched;
  private static Field sMinimumField;
  private static boolean sMinimumFieldFetched;
  
  public static int getAutoSizeMaxTextSize(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeMaxTextSize();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeMaxTextSize();
    }
    return -1;
  }
  
  public static int getAutoSizeMinTextSize(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeMinTextSize();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeMinTextSize();
    }
    return -1;
  }
  
  public static int getAutoSizeStepGranularity(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeStepGranularity();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeStepGranularity();
    }
    return -1;
  }
  
  @NonNull
  public static int[] getAutoSizeTextAvailableSizes(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeTextAvailableSizes();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeTextAvailableSizes();
    }
    return new int[0];
  }
  
  public static int getAutoSizeTextType(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeTextType();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeTextType();
    }
    return 0;
  }
  
  @Nullable
  public static ColorStateList getCompoundDrawableTintList(@NonNull TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView);
    if (Build.VERSION.SDK_INT >= 23) {
      return paramTextView.getCompoundDrawableTintList();
    }
    if ((paramTextView instanceof TintableCompoundDrawablesView)) {
      return ((TintableCompoundDrawablesView)paramTextView).getSupportCompoundDrawablesTintList();
    }
    return null;
  }
  
  @Nullable
  public static PorterDuff.Mode getCompoundDrawableTintMode(@NonNull TextView paramTextView)
  {
    Preconditions.checkNotNull(paramTextView);
    if (Build.VERSION.SDK_INT >= 23) {
      return paramTextView.getCompoundDrawableTintMode();
    }
    if ((paramTextView instanceof TintableCompoundDrawablesView)) {
      return ((TintableCompoundDrawablesView)paramTextView).getSupportCompoundDrawablesTintMode();
    }
    return null;
  }
  
  @NonNull
  public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView paramTextView)
  {
    int i = 1;
    if (Build.VERSION.SDK_INT >= 18) {
      return paramTextView.getCompoundDrawablesRelative();
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
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
    return paramTextView.getCompoundDrawables();
  }
  
  public static int getFirstBaselineToTopHeight(@NonNull TextView paramTextView)
  {
    return paramTextView.getPaddingTop() - paramTextView.getPaint().getFontMetricsInt().top;
  }
  
  public static int getLastBaselineToBottomHeight(@NonNull TextView paramTextView)
  {
    return paramTextView.getPaddingBottom() + paramTextView.getPaint().getFontMetricsInt().bottom;
  }
  
  public static int getMaxLines(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramTextView.getMaxLines();
    }
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
  
  public static int getMinLines(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramTextView.getMinLines();
    }
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
  
  @RequiresApi(18)
  private static int getTextDirection(@NonNull TextDirectionHeuristic paramTextDirectionHeuristic)
  {
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {}
    do
    {
      do
      {
        return 1;
      } while (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR);
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
        return 2;
      }
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.LTR) {
        return 3;
      }
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.RTL) {
        return 4;
      }
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
        return 5;
      }
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
        return 6;
      }
    } while (paramTextDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_RTL);
    return 7;
  }
  
  @RequiresApi(18)
  private static TextDirectionHeuristic getTextDirectionHeuristic(@NonNull TextView paramTextView)
  {
    int i = 1;
    if ((paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
      return TextDirectionHeuristics.LTR;
    }
    if ((Build.VERSION.SDK_INT >= 28) && ((paramTextView.getInputType() & 0xF) == 3))
    {
      i = Character.getDirectionality(android.icu.text.DecimalFormatSymbols.getInstance(paramTextView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
      if ((i == 1) || (i == 2)) {
        return TextDirectionHeuristics.RTL;
      }
      return TextDirectionHeuristics.LTR;
    }
    if (paramTextView.getLayoutDirection() == 1) {}
    for (;;)
    {
      switch (paramTextView.getTextDirection())
      {
      default: 
        if (i == 0) {
          break label137;
        }
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
        i = 0;
      }
    }
    label137:
    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    return TextDirectionHeuristics.ANYRTL_LTR;
    return TextDirectionHeuristics.LTR;
    return TextDirectionHeuristics.RTL;
    return TextDirectionHeuristics.LOCALE;
    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
  }
  
  @NonNull
  public static PrecomputedTextCompat.Params getTextMetricsParams(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return new PrecomputedTextCompat.Params(paramTextView.getTextMetricsParams());
    }
    PrecomputedTextCompat.Params.Builder localBuilder = new PrecomputedTextCompat.Params.Builder(new TextPaint(paramTextView.getPaint()));
    if (Build.VERSION.SDK_INT >= 23)
    {
      localBuilder.setBreakStrategy(paramTextView.getBreakStrategy());
      localBuilder.setHyphenationFrequency(paramTextView.getHyphenationFrequency());
    }
    if (Build.VERSION.SDK_INT >= 18) {
      localBuilder.setTextDirection(getTextDirectionHeuristic(paramTextView));
    }
    return localBuilder.build();
  }
  
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
      Log.e("TextViewCompat", "Could not retrieve " + paramString + " field.");
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
      Log.d("TextViewCompat", "Could not retrieve value of " + paramField.getName() + " field.");
    }
    return -1;
  }
  
  public static void setAutoSizeTextTypeUniformWithConfiguration(@NonNull TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (Build.VERSION.SDK_INT >= 27) {
      paramTextView.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    while (!(paramTextView instanceof AutoSizeableTextView)) {
      return;
    }
    ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull TextView paramTextView, @NonNull int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    if (Build.VERSION.SDK_INT >= 27) {
      paramTextView.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    while (!(paramTextView instanceof AutoSizeableTextView)) {
      return;
    }
    ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  public static void setAutoSizeTextTypeWithDefaults(@NonNull TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      paramTextView.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    while (!(paramTextView instanceof AutoSizeableTextView)) {
      return;
    }
    ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  public static void setCompoundDrawableTintList(@NonNull TextView paramTextView, @Nullable ColorStateList paramColorStateList)
  {
    Preconditions.checkNotNull(paramTextView);
    if (Build.VERSION.SDK_INT >= 23) {
      paramTextView.setCompoundDrawableTintList(paramColorStateList);
    }
    while (!(paramTextView instanceof TintableCompoundDrawablesView)) {
      return;
    }
    ((TintableCompoundDrawablesView)paramTextView).setSupportCompoundDrawablesTintList(paramColorStateList);
  }
  
  public static void setCompoundDrawableTintMode(@NonNull TextView paramTextView, @Nullable PorterDuff.Mode paramMode)
  {
    Preconditions.checkNotNull(paramTextView);
    if (Build.VERSION.SDK_INT >= 23) {
      paramTextView.setCompoundDrawableTintMode(paramMode);
    }
    while (!(paramTextView instanceof TintableCompoundDrawablesView)) {
      return;
    }
    ((TintableCompoundDrawablesView)paramTextView).setSupportCompoundDrawablesTintMode(paramMode);
  }
  
  public static void setCompoundDrawablesRelative(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i;
      Drawable localDrawable;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0) {
          break label67;
        }
        localDrawable = paramDrawable3;
        label45:
        if (i == 0) {
          break label73;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawables(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
        return;
        i = 0;
        break;
        label67:
        localDrawable = paramDrawable1;
        break label45;
        label73:
        paramDrawable1 = paramDrawable3;
      }
    }
    paramTextView.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i;
      int j;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0) {
          break label67;
        }
        j = paramInt3;
        label45:
        if (i == 0) {
          break label73;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(j, paramInt2, paramInt1, paramInt4);
        return;
        i = 0;
        break;
        label67:
        j = paramInt1;
        break label45;
        label73:
        paramInt1 = paramInt3;
      }
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i;
      Drawable localDrawable;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0) {
          break label67;
        }
        localDrawable = paramDrawable3;
        label45:
        if (i == 0) {
          break label73;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
        return;
        i = 0;
        break;
        label67:
        localDrawable = paramDrawable1;
        break label45;
        label73:
        paramDrawable1 = paramDrawable3;
      }
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setCustomSelectionActionModeCallback(@NonNull TextView paramTextView, @NonNull ActionMode.Callback paramCallback)
  {
    paramTextView.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(paramTextView, paramCallback));
  }
  
  public static void setFirstBaselineToTopHeight(@NonNull TextView paramTextView, @IntRange(from=0L) @Px int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt);
    if (Build.VERSION.SDK_INT >= 28) {
      paramTextView.setFirstBaselineToTopHeight(paramInt);
    }
    for (;;)
    {
      return;
      Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
      if ((Build.VERSION.SDK_INT < 16) || (paramTextView.getIncludeFontPadding())) {}
      for (int i = localFontMetricsInt.top; paramInt > Math.abs(i); i = localFontMetricsInt.ascent)
      {
        i = -i;
        paramTextView.setPadding(paramTextView.getPaddingLeft(), paramInt - i, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
        return;
      }
    }
  }
  
  public static void setLastBaselineToBottomHeight(@NonNull TextView paramTextView, @IntRange(from=0L) @Px int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    if ((Build.VERSION.SDK_INT < 16) || (paramTextView.getIncludeFontPadding())) {}
    for (int i = localFontMetricsInt.bottom;; i = localFontMetricsInt.descent)
    {
      if (paramInt > Math.abs(i)) {
        paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramInt - i);
      }
      return;
    }
  }
  
  public static void setLineHeight(@NonNull TextView paramTextView, @IntRange(from=0L) @Px int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt);
    int i = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i) {
      paramTextView.setLineSpacing(paramInt - i, 1.0F);
    }
  }
  
  public static void setPrecomputedText(@NonNull TextView paramTextView, @NonNull PrecomputedTextCompat paramPrecomputedTextCompat)
  {
    if (!getTextMetricsParams(paramTextView).equalsWithoutTextDirection(paramPrecomputedTextCompat.getParams())) {
      throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }
    paramTextView.setText(paramPrecomputedTextCompat);
  }
  
  public static void setTextAppearance(@NonNull TextView paramTextView, @StyleRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramTextView.setTextAppearance(paramInt);
      return;
    }
    paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
  }
  
  public static void setTextMetricsParams(@NonNull TextView paramTextView, @NonNull PrecomputedTextCompat.Params paramParams)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramTextView.setTextDirection(getTextDirection(paramParams.getTextDirection()));
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      float f = paramParams.getTextPaint().getTextScaleX();
      paramTextView.getPaint().set(paramParams.getTextPaint());
      if (f == paramTextView.getTextScaleX()) {
        paramTextView.setTextScaleX(f / 2.0F + 1.0F);
      }
      paramTextView.setTextScaleX(f);
      return;
    }
    paramTextView.getPaint().set(paramParams.getTextPaint());
    paramTextView.setBreakStrategy(paramParams.getBreakStrategy());
    paramTextView.setHyphenationFrequency(paramParams.getHyphenationFrequency());
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static ActionMode.Callback wrapCustomSelectionActionModeCallback(@NonNull TextView paramTextView, @NonNull ActionMode.Callback paramCallback)
  {
    if ((Build.VERSION.SDK_INT < 26) || (Build.VERSION.SDK_INT > 27) || ((paramCallback instanceof OreoCallback))) {
      return paramCallback;
    }
    return new OreoCallback(paramCallback, paramTextView);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface AutoSizeTextType {}
  
  @RequiresApi(26)
  static class OreoCallback
    implements ActionMode.Callback
  {
    private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
    private final ActionMode.Callback mCallback;
    private boolean mCanUseMenuBuilderReferences;
    private boolean mInitializedMenuBuilderReferences;
    private Class mMenuBuilderClass;
    private Method mMenuBuilderRemoveItemAtMethod;
    private final TextView mTextView;
    
    OreoCallback(ActionMode.Callback paramCallback, TextView paramTextView)
    {
      this.mCallback = paramCallback;
      this.mTextView = paramTextView;
      this.mInitializedMenuBuilderReferences = false;
    }
    
    private Intent createProcessTextIntent()
    {
      return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    }
    
    private Intent createProcessTextIntentForResolveInfo(ResolveInfo paramResolveInfo, TextView paramTextView)
    {
      Intent localIntent = createProcessTextIntent();
      if (!isEditable(paramTextView)) {}
      for (boolean bool = true;; bool = false) {
        return localIntent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", bool).setClassName(paramResolveInfo.activityInfo.packageName, paramResolveInfo.activityInfo.name);
      }
    }
    
    private List<ResolveInfo> getSupportedActivities(Context paramContext, PackageManager paramPackageManager)
    {
      ArrayList localArrayList = new ArrayList();
      if (!(paramContext instanceof Activity)) {
        return localArrayList;
      }
      paramPackageManager = paramPackageManager.queryIntentActivities(createProcessTextIntent(), 0).iterator();
      while (paramPackageManager.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)paramPackageManager.next();
        if (isSupportedActivity(localResolveInfo, paramContext)) {
          localArrayList.add(localResolveInfo);
        }
      }
      return localArrayList;
    }
    
    private boolean isEditable(TextView paramTextView)
    {
      return ((paramTextView instanceof Editable)) && (paramTextView.onCheckIsTextEditor()) && (paramTextView.isEnabled());
    }
    
    private boolean isSupportedActivity(ResolveInfo paramResolveInfo, Context paramContext)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramContext.getPackageName().equals(paramResolveInfo.activityInfo.packageName)) {
        bool1 = true;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!paramResolveInfo.activityInfo.exported);
        if (paramResolveInfo.activityInfo.permission == null) {
          break;
        }
        bool1 = bool2;
      } while (paramContext.checkSelfPermission(paramResolveInfo.activityInfo.permission) != 0);
      return true;
    }
    
    /* Error */
    private void recomputeProcessTextMenuItems(Menu paramMenu)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 35	androidx/core/widget/TextViewCompat$OreoCallback:mTextView	Landroid/widget/TextView;
      //   4: invokevirtual 171	android/widget/TextView:getContext	()Landroid/content/Context;
      //   7: astore 5
      //   9: aload 5
      //   11: invokevirtual 175	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
      //   14: astore 4
      //   16: aload_0
      //   17: getfield 37	androidx/core/widget/TextViewCompat$OreoCallback:mInitializedMenuBuilderReferences	Z
      //   20: ifne +45 -> 65
      //   23: aload_0
      //   24: iconst_1
      //   25: putfield 37	androidx/core/widget/TextViewCompat$OreoCallback:mInitializedMenuBuilderReferences	Z
      //   28: aload_0
      //   29: ldc 177
      //   31: invokestatic 183	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   34: putfield 185	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderClass	Ljava/lang/Class;
      //   37: aload_0
      //   38: aload_0
      //   39: getfield 185	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderClass	Ljava/lang/Class;
      //   42: ldc 187
      //   44: iconst_1
      //   45: anewarray 179	java/lang/Class
      //   48: dup
      //   49: iconst_0
      //   50: getstatic 192	java/lang/Integer:TYPE	Ljava/lang/Class;
      //   53: aastore
      //   54: invokevirtual 196	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   57: putfield 198	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderRemoveItemAtMethod	Ljava/lang/reflect/Method;
      //   60: aload_0
      //   61: iconst_1
      //   62: putfield 200	androidx/core/widget/TextViewCompat$OreoCallback:mCanUseMenuBuilderReferences	Z
      //   65: aload_0
      //   66: getfield 200	androidx/core/widget/TextViewCompat$OreoCallback:mCanUseMenuBuilderReferences	Z
      //   69: ifeq +112 -> 181
      //   72: aload_0
      //   73: getfield 185	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderClass	Ljava/lang/Class;
      //   76: aload_1
      //   77: invokevirtual 203	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
      //   80: ifeq +101 -> 181
      //   83: aload_0
      //   84: getfield 198	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderRemoveItemAtMethod	Ljava/lang/reflect/Method;
      //   87: astore_3
      //   88: aload_1
      //   89: invokeinterface 209 1 0
      //   94: iconst_1
      //   95: isub
      //   96: istore_2
      //   97: iload_2
      //   98: iflt +106 -> 204
      //   101: aload_1
      //   102: iload_2
      //   103: invokeinterface 213 2 0
      //   108: astore 6
      //   110: aload 6
      //   112: invokeinterface 218 1 0
      //   117: ifnull +38 -> 155
      //   120: ldc 45
      //   122: aload 6
      //   124: invokeinterface 218 1 0
      //   129: invokevirtual 221	android/content/Intent:getAction	()Ljava/lang/String;
      //   132: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   135: ifeq +20 -> 155
      //   138: aload_3
      //   139: aload_1
      //   140: iconst_1
      //   141: anewarray 4	java/lang/Object
      //   144: dup
      //   145: iconst_0
      //   146: iload_2
      //   147: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   150: aastore
      //   151: invokevirtual 231	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   154: pop
      //   155: iload_2
      //   156: iconst_1
      //   157: isub
      //   158: istore_2
      //   159: goto -62 -> 97
      //   162: astore_3
      //   163: aload_0
      //   164: aconst_null
      //   165: putfield 185	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderClass	Ljava/lang/Class;
      //   168: aload_0
      //   169: aconst_null
      //   170: putfield 198	androidx/core/widget/TextViewCompat$OreoCallback:mMenuBuilderRemoveItemAtMethod	Ljava/lang/reflect/Method;
      //   173: aload_0
      //   174: iconst_0
      //   175: putfield 200	androidx/core/widget/TextViewCompat$OreoCallback:mCanUseMenuBuilderReferences	Z
      //   178: goto -113 -> 65
      //   181: aload_1
      //   182: invokevirtual 235	java/lang/Object:getClass	()Ljava/lang/Class;
      //   185: ldc 187
      //   187: iconst_1
      //   188: anewarray 179	java/lang/Class
      //   191: dup
      //   192: iconst_0
      //   193: getstatic 192	java/lang/Integer:TYPE	Ljava/lang/Class;
      //   196: aastore
      //   197: invokevirtual 196	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   200: astore_3
      //   201: goto -113 -> 88
      //   204: aload_0
      //   205: aload 5
      //   207: aload 4
      //   209: invokespecial 237	androidx/core/widget/TextViewCompat$OreoCallback:getSupportedActivities	(Landroid/content/Context;Landroid/content/pm/PackageManager;)Ljava/util/List;
      //   212: astore_3
      //   213: iconst_0
      //   214: istore_2
      //   215: iload_2
      //   216: aload_3
      //   217: invokeinterface 238 1 0
      //   222: if_icmpge +63 -> 285
      //   225: aload_3
      //   226: iload_2
      //   227: invokeinterface 242 2 0
      //   232: checkcast 70	android/content/pm/ResolveInfo
      //   235: astore 5
      //   237: aload_1
      //   238: iconst_0
      //   239: iconst_0
      //   240: iload_2
      //   241: bipush 100
      //   243: iadd
      //   244: aload 5
      //   246: aload 4
      //   248: invokevirtual 246	android/content/pm/ResolveInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
      //   251: invokeinterface 249 5 0
      //   256: aload_0
      //   257: aload 5
      //   259: aload_0
      //   260: getfield 35	androidx/core/widget/TextViewCompat$OreoCallback:mTextView	Landroid/widget/TextView;
      //   263: invokespecial 251	androidx/core/widget/TextViewCompat$OreoCallback:createProcessTextIntentForResolveInfo	(Landroid/content/pm/ResolveInfo;Landroid/widget/TextView;)Landroid/content/Intent;
      //   266: invokeinterface 255 2 0
      //   271: iconst_1
      //   272: invokeinterface 259 2 0
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
      //   0	294	0	this	OreoCallback
      //   0	294	1	paramMenu	Menu
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
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return this.mCallback.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mCallback.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      this.mCallback.onDestroyActionMode(paramActionMode);
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      recomputeProcessTextMenuItems(paramMenu);
      return this.mCallback.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.widget.TextViewCompat
 * JD-Core Version:    0.7.0.1
 */