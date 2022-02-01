package com.tencent.qqmail.qmui.helper;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class QMUIViewHelper
{
  public static ImageView crop(Context paramContext, ImageView paramImageView, Rect paramRect, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramContext = new ImageView(paramContext);; paramContext = paramImageView)
    {
      paramContext.setImageBitmap(Bitmap.createBitmap(QMUIDrawableHelper.drawableToBitmap(paramImageView.getDrawable()), paramRect.left, paramRect.top, paramRect.width(), paramRect.height()));
      paramContext.setLayoutParams(new ViewGroup.LayoutParams(paramRect.width(), paramRect.height()));
      return paramContext;
    }
  }
  
  public static void expendTouchArea(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      View localView = (View)paramView.getParent();
      localView.post(new QMUIViewHelper.1(paramView, paramInt, localView));
    }
  }
  
  public static boolean getIsLastLineSpacingExtraError()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  public static void playBackgroundBlinkAnimation(View paramView, int paramInt)
  {
    playViewBackgroundAnimation(paramView, paramInt, new int[] { 0, 255, 50, 255, 0 }, 300);
  }
  
  public static void playViewBackgroundAnimation(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int i = paramArrayOfInt.length;
    Object localObject = new ColorDrawable(paramInt1);
    Drawable localDrawable = paramView.getBackground();
    setBackgroundKeepingPadding(paramView, (Drawable)localObject);
    localObject = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < i - 1)
    {
      ((List)localObject).add(ObjectAnimator.ofInt(paramView.getBackground(), "alpha", new int[] { paramArrayOfInt[paramInt1], paramArrayOfInt[(paramInt1 + 1)] }));
      paramInt1 += 1;
    }
    paramArrayOfInt = new AnimatorSet();
    paramArrayOfInt.setDuration(paramInt2);
    paramArrayOfInt.addListener(new QMUIViewHelper.2(paramView, localDrawable));
    paramArrayOfInt.playSequentially((List)localObject);
    paramArrayOfInt.start();
  }
  
  public static void requestApplyInsets(Window paramWindow)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (Build.VERSION.SDK_INT < 21)) {
      paramWindow.getDecorView().requestFitSystemWindows();
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    paramWindow.getDecorView().requestApplyInsets();
  }
  
  public static ImageView scale(Context paramContext, ImageView paramImageView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramContext = new ImageView(paramContext);
      paramContext.setImageDrawable(paramImageView.getDrawable());
      paramImageView = paramImageView.getLayoutParams();
      paramContext.setLayoutParams(new ViewGroup.LayoutParams((int)(paramImageView.width * paramFloat1), (int)(paramImageView.height * paramFloat2)));
      return paramContext;
    }
    paramImageView.setScaleX(paramFloat1);
    paramImageView.setScaleY(paramFloat2);
    return paramImageView;
  }
  
  public static ImageView scale(Context paramContext, ImageView paramImageView, float paramFloat, boolean paramBoolean)
  {
    return scale(paramContext, paramImageView, paramFloat, paramFloat, paramBoolean);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.helper.QMUIViewHelper
 * JD-Core Version:    0.7.0.1
 */