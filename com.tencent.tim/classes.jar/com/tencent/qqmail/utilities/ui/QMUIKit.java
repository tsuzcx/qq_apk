package com.tencent.qqmail.utilities.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;

public final class QMUIKit
{
  public static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;
  public static final String ELLIPSIZE_FIXED;
  public static View.OnTouchListener onIconButtonTouchListener;
  private static int screenHeight;
  private static int screenWidth;
  public static final HashSet<String> unSupportBrands = new HashSet();
  
  static
  {
    unSupportBrands.add("BBK");
    if (unSupportBrands.contains(Build.BRAND)) {}
    for (String str = "";; str = "​")
    {
      ELLIPSIZE_FIXED = str;
      screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
      screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
      onIconButtonTouchListener = new QMUIKit.3();
      return;
    }
  }
  
  public static void ajustWindowPosition(Context paramContext, Dialog paramDialog)
  {
    WindowManager.LayoutParams localLayoutParams = paramDialog.getWindow().getAttributes();
    localLayoutParams.gravity = 48;
    int j = com.tencent.qqmail.utilities.deviceid.DeviceUtil.getScreenWidthHeight(paramContext)[1] / 4;
    int k = dpToPx(5);
    if (KeyBoardHelper.hasSoftMenu()) {}
    for (int i = dpToPx(50);; i = 0)
    {
      localLayoutParams.y = (k + (j - 120) - i);
      paramDialog.getWindow().setAttributes(localLayoutParams);
      return;
    }
  }
  
  public static final void disableOrientationChange(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.setRequestedOrientation(1);
    }
  }
  
  private static Bitmap doBlur(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while (paramInt < 1)
    {
      return null;
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    }
    int i14 = paramBitmap.getWidth();
    int i15 = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[i14 * i15];
    paramBitmap.getPixels(arrayOfInt1, 0, i14, 0, 0, i14, i15);
    int i19 = i14 - 1;
    int i16 = i15 - 1;
    int i = i14 * i15;
    int i17 = paramInt + paramInt + 1;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[Math.max(i14, i15)];
    i = i17 + 1 >> 1;
    int j = i * i;
    int[] arrayOfInt6 = new int[j * 256];
    i = 0;
    while (i < j * 256)
    {
      arrayOfInt6[i] = (i / j);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i17, 3 });
    int i18 = paramInt + 1;
    int i7 = 0;
    int i6 = 0;
    i = 0;
    int m;
    int i8;
    int i2;
    int k;
    int i1;
    int i3;
    int i4;
    int i5;
    int n;
    int i9;
    int[] arrayOfInt7;
    int i10;
    int i11;
    int i12;
    while (i7 < i15)
    {
      m = 0;
      i8 = -paramInt;
      j = 0;
      i2 = 0;
      k = 0;
      i1 = 0;
      i3 = 0;
      i4 = 0;
      i5 = 0;
      n = 0;
      if (i8 <= paramInt)
      {
        i9 = arrayOfInt1[(Math.min(i19, Math.max(i8, 0)) + i)];
        arrayOfInt7 = arrayOfInt[(i8 + paramInt)];
        arrayOfInt7[0] = ((0xFF0000 & i9) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i9) >> 8);
        arrayOfInt7[2] = (i9 & 0xFF);
        i9 = i18 - Math.abs(i8);
        i3 += arrayOfInt7[0] * i9;
        i4 += arrayOfInt7[1] * i9;
        i5 += i9 * arrayOfInt7[2];
        if (i8 > 0)
        {
          m += arrayOfInt7[0];
          n += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 += 1;
          break;
          i2 += arrayOfInt7[0];
          k += arrayOfInt7[1];
          i1 += arrayOfInt7[2];
        }
      }
      i10 = i3;
      i11 = i1;
      i8 = n;
      i3 = paramInt;
      i12 = j;
      i9 = m;
      int i13 = 0;
      m = i5;
      i1 = i4;
      i4 = i10;
      j = i11;
      n = i2;
      i5 = i12;
      i2 = i13;
      while (i2 < i14)
      {
        arrayOfInt2[i] = arrayOfInt6[i4];
        arrayOfInt3[i] = arrayOfInt6[i1];
        arrayOfInt4[i] = arrayOfInt6[m];
        arrayOfInt7 = arrayOfInt[((i3 - paramInt + i17) % i17)];
        i12 = arrayOfInt7[0];
        i11 = arrayOfInt7[1];
        i10 = arrayOfInt7[2];
        if (i7 == 0) {
          arrayOfInt5[i2] = Math.min(i2 + paramInt + 1, i19);
        }
        i13 = arrayOfInt1[(arrayOfInt5[i2] + i6)];
        arrayOfInt7[0] = ((0xFF0000 & i13) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i13) >> 8);
        arrayOfInt7[2] = (i13 & 0xFF);
        i9 += arrayOfInt7[0];
        i8 += arrayOfInt7[1];
        i5 += arrayOfInt7[2];
        i4 = i4 - n + i9;
        i1 = i1 - k + i8;
        m = m - j + i5;
        i3 = (i3 + 1) % i17;
        arrayOfInt7 = arrayOfInt[(i3 % i17)];
        n = n - i12 + arrayOfInt7[0];
        k = k - i11 + arrayOfInt7[1];
        j = j - i10 + arrayOfInt7[2];
        i9 -= arrayOfInt7[0];
        i8 -= arrayOfInt7[1];
        i5 -= arrayOfInt7[2];
        i += 1;
        i2 += 1;
      }
      i7 += 1;
      i6 += i14;
    }
    i = 0;
    while (i < i14)
    {
      m = 0;
      i7 = -paramInt * i14;
      i6 = -paramInt;
      j = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i4 = 0;
      i5 = 0;
      k = 0;
      if (i6 <= paramInt)
      {
        i9 = Math.max(0, i7) + i;
        arrayOfInt7 = arrayOfInt[(i6 + paramInt)];
        arrayOfInt7[0] = arrayOfInt2[i9];
        arrayOfInt7[1] = arrayOfInt3[i9];
        arrayOfInt7[2] = arrayOfInt4[i9];
        i10 = i18 - Math.abs(i6);
        i8 = i3 + arrayOfInt2[i9] * i10;
        i4 += arrayOfInt3[i9] * i10;
        i5 += arrayOfInt4[i9] * i10;
        if (i6 > 0)
        {
          m += arrayOfInt7[0];
          k += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i3 = i7;
          if (i6 < i16) {
            i3 = i7 + i14;
          }
          i6 += 1;
          i7 = i3;
          i3 = i8;
          break;
          n += arrayOfInt7[0];
          i1 += arrayOfInt7[1];
          i2 += arrayOfInt7[2];
        }
      }
      i6 = 0;
      i7 = i;
      i9 = paramInt;
      i8 = j;
      j = i9;
      while (i6 < i15)
      {
        arrayOfInt1[i7] = (0xFF000000 & arrayOfInt1[i7] | arrayOfInt6[i3] << 16 | arrayOfInt6[i4] << 8 | arrayOfInt6[i5]);
        arrayOfInt7 = arrayOfInt[((j - paramInt + i17) % i17)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        i9 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt5[i6] = (Math.min(i6 + i18, i16) * i14);
        }
        i12 = arrayOfInt5[i6] + i;
        arrayOfInt7[0] = arrayOfInt2[i12];
        arrayOfInt7[1] = arrayOfInt3[i12];
        arrayOfInt7[2] = arrayOfInt4[i12];
        m += arrayOfInt7[0];
        k += arrayOfInt7[1];
        i8 += arrayOfInt7[2];
        i3 = i3 - n + m;
        i4 = i4 - i1 + k;
        i5 = i5 - i2 + i8;
        j = (j + 1) % i17;
        arrayOfInt7 = arrayOfInt[j];
        n = n - i11 + arrayOfInt7[0];
        i1 = i1 - i10 + arrayOfInt7[1];
        i2 = i2 - i9 + arrayOfInt7[2];
        m -= arrayOfInt7[0];
        k -= arrayOfInt7[1];
        i8 -= arrayOfInt7[2];
        i7 += i14;
        i6 += 1;
      }
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt1, 0, i14, 0, 0, i14, i15);
    return paramBitmap;
  }
  
  public static Bitmap doFrostedGlass(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      int i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight()) / 200;
      return Bitmap.createScaledBitmap(doBlur(Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / i, paramBitmap.getHeight() / i, false), 8, true), paramBitmap.getWidth(), paramBitmap.getHeight(), false);
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    }
  }
  
  public static int dpToPx(int paramInt)
  {
    return (int)(paramInt * DENSITY + 0.5F);
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    int i;
    int j;
    do
    {
      return null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
    } while ((i <= 0) || (j <= 0));
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
  }
  
  public static final void enableOrientationChange(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.setRequestedOrientation(2);
    }
  }
  
  public static void expendTouchArea(View paramView)
  {
    if (paramView != null) {
      expendTouchArea(paramView, (View)paramView.getParent());
    }
  }
  
  public static void expendTouchArea(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      View localView = (View)paramView.getParent();
      localView.post(new QMUIKit.1(paramView, paramInt, localView));
    }
  }
  
  public static void expendTouchArea(View paramView1, View paramView2)
  {
    if ((paramView1 != null) && (paramView2 != null)) {
      paramView1.post(new QMUIKit.2(paramView1, paramView2));
    }
  }
  
  public static Button getBlueFontButton(Context paramContext, int paramInt, boolean paramBoolean)
  {
    Button localButton = new Button(paramContext);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, dpToPx(48)));
    localButton.setText(paramContext.getResources().getString(paramInt));
    localButton.setBackgroundResource(2130845610);
    localButton.setTextSize(2, 16.0F);
    localButton.setGravity(17);
    localButton.setTextColor(paramContext.getResources().getColorStateList(2131167188));
    localButton.setPadding(0, 0, 0, 0);
    if (paramBoolean)
    {
      localButton.setEnabled(true);
      return localButton;
    }
    localButton.setEnabled(false);
    return localButton;
  }
  
  public static QMButton getButton(Context paramContext)
  {
    QMButton localQMButton = new QMButton(paramContext);
    localQMButton.setMinWidth(0);
    localQMButton.setMinHeight(0);
    localQMButton.setMinimumHeight(0);
    localQMButton.setMinimumWidth(0);
    int i = paramContext.getResources().getDimensionPixelSize(2131296729);
    localQMButton.setPadding(i, 0, i, 0);
    localQMButton.setGravity(17);
    localQMButton.setSingleLine(true);
    localQMButton.setEllipsize(TextUtils.TruncateAt.END);
    localQMButton.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131296726));
    return localQMButton;
  }
  
  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static int getNavMenuHeight(Context paramContext)
  {
    return getRealScreenSize(paramContext)[1] - getScreenHeight(paramContext);
  }
  
  public static int getPopularizeReqImageTimes()
  {
    int j = (int)Math.ceil(DENSITY);
    int i = j;
    if (j > 3) {
      i = 3;
    }
    if (i == 3) {
      return 2;
    }
    if (i == 2) {
      return 1;
    }
    return 0;
  }
  
  public static int[] getRealScreenSize(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Object localObject = new DisplayMetrics();
    paramContext.getMetrics((DisplayMetrics)localObject);
    i = ((DisplayMetrics)localObject).widthPixels;
    j = ((DisplayMetrics)localObject).heightPixels;
    try
    {
      k = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
      i = k;
      m = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(paramContext, new Object[0])).intValue();
      i = m;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int m;
        int k = i;
        i = j;
      }
    }
    j = k;
    try
    {
      localObject = new Point();
      j = k;
      Display.class.getMethod("getRealSize", new Class[] { Point.class }).invoke(paramContext, new Object[] { localObject });
      j = k;
      k = ((Point)localObject).x;
      j = k;
      m = ((Point)localObject).y;
      j = k;
      i = m;
    }
    catch (Exception paramContext)
    {
      label173:
      break label173;
    }
    return new int[] { j, i };
  }
  
  public static Button getRedButton(Context paramContext, int paramInt)
  {
    Button localButton = new Button(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, dpToPx(42));
    int i = dpToPx(10);
    localLayoutParams.setMargins(i, 0, i, 0);
    localButton.setLayoutParams(localLayoutParams);
    localButton.setText(paramContext.getResources().getString(paramInt));
    localButton.setBackgroundResource(2130850464);
    localButton.setTextSize(2, 18.0F);
    localButton.setGravity(17);
    localButton.setTextColor(-1);
    return localButton;
  }
  
  public static Button getRedFontButton(Context paramContext, int paramInt, boolean paramBoolean)
  {
    Button localButton = new Button(paramContext);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(-1, dpToPx(48)));
    localButton.setText(paramContext.getResources().getString(paramInt));
    localButton.setBackgroundResource(2130845610);
    localButton.setTextSize(2, 16.0F);
    localButton.setGravity(17);
    localButton.setTextColor(paramContext.getResources().getColorStateList(2131167189));
    localButton.setPadding(0, 0, 0, 0);
    if (paramBoolean)
    {
      localButton.setEnabled(true);
      return localButton;
    }
    localButton.setEnabled(false);
    return localButton;
  }
  
  public static int getScreenHeight()
  {
    if (screenHeight <= 0) {
      screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    }
    return screenHeight;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return getDisplayMetrics(paramContext).heightPixels;
  }
  
  public static int getScreenWidth()
  {
    if (screenWidth <= 0) {
      screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    }
    return screenWidth;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static boolean hasStatusBar(Context paramContext)
  {
    return (!(paramContext instanceof Activity)) || ((((Activity)paramContext).getWindow().getAttributes().flags & 0x400) != 1024);
  }
  
  public static boolean isColorClosedToWhite(int paramInt)
  {
    float[] arrayOfFloat = new float[3];
    Color.RGBToHSV(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), arrayOfFloat);
    return arrayOfFloat[2] >= 0.5D;
  }
  
  public static boolean isColorClosedToWhite(String paramString)
  {
    return isColorClosedToWhite(Color.parseColor(paramString));
  }
  
  public static Bitmap loadBitmapFromView(View paramView)
  {
    if (paramView == null) {
      localObject1 = null;
    }
    do
    {
      return localObject1;
      paramView.buildDrawingCache();
      localObject2 = paramView.getDrawingCache();
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject1 = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.RGB_565);
    Object localObject2 = new Canvas((Bitmap)localObject1);
    ((Canvas)localObject2).translate(-paramView.getScrollX(), -paramView.getScrollY());
    paramView.draw((Canvas)localObject2);
    return localObject1;
  }
  
  public static void playViewBackgroundAnimation(View paramView, int paramInt1, int paramInt2, Animator.AnimatorListener paramAnimatorListener)
  {
    Drawable localDrawable = paramView.getBackground();
    ValueAnimator localValueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localValueAnimator.addUpdateListener(new QMUIKit.4(paramView));
    localValueAnimator.setDuration(300L);
    localValueAnimator.setRepeatCount(3);
    localValueAnimator.setRepeatMode(2);
    localValueAnimator.addListener(new QMUIKit.5(paramView, localDrawable));
    if (paramAnimatorListener != null) {
      localValueAnimator.addListener(paramAnimatorListener);
    }
    localValueAnimator.start();
  }
  
  public static int px2sp(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static int pxToDp(float paramFloat)
  {
    return (int)(paramFloat / Resources.getSystem().getDisplayMetrics().density + 0.5F);
  }
  
  public static void setBackgroundKeepingPadding(View paramView, int paramInt)
  {
    setBackgroundKeepingPadding(paramView, paramView.getResources().getDrawable(paramInt));
  }
  
  @TargetApi(16)
  public static void setBackgroundKeepingPadding(View paramView, Drawable paramDrawable)
  {
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = paramView.getPaddingLeft();
    arrayOfInt[1] = paramView.getPaddingTop();
    arrayOfInt[2] = paramView.getPaddingRight();
    arrayOfInt[3] = paramView.getPaddingBottom();
    if (Build.VERSION.SDK_INT >= 16) {
      paramView.setBackground(paramDrawable);
    }
    for (;;)
    {
      paramView.setPadding(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
      return;
      paramView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public static void setDefaultFontScale(Activity paramActivity)
  {
    Configuration localConfiguration = paramActivity.getResources().getConfiguration();
    localConfiguration.fontScale = 1.0F;
    DisplayMetrics localDisplayMetrics = Resources.getSystem().getDisplayMetrics();
    localDisplayMetrics.scaledDensity = (localConfiguration.fontScale * localDisplayMetrics.density);
    paramActivity.getBaseContext().getResources().updateConfiguration(localConfiguration, localDisplayMetrics);
  }
  
  public static void setDrawableTintColor(Drawable paramDrawable, int paramInt)
  {
    paramDrawable.setColorFilter(new LightingColorFilter(Color.argb(255, 0, 0, 0), paramInt));
  }
  
  public static void setText(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString + ELLIPSIZE_FIXED);
  }
  
  public static int sp2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMUIKit
 * JD-Core Version:    0.7.0.1
 */