package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

public class i
{
  public static int a(Activity paramActivity)
  {
    if ((paramActivity.getWindow().getAttributes().flags & 0x400) == 1024) {}
    for (int i = 1; i != 0; i = 0) {
      return 16973841;
    }
    return 16973840;
  }
  
  public static Shape a(int paramInt)
  {
    return new RoundRectShape(new float[] { paramInt, paramInt, paramInt, paramInt, paramInt, paramInt, paramInt, paramInt }, null, null);
  }
  
  public static Animation a(long paramLong)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(paramLong);
    return localAlphaAnimation;
  }
  
  public static void a(@NonNull View paramView, int paramInt, boolean paramBoolean)
  {
    SizeUtil.init(paramView.getContext());
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    if (paramBoolean) {}
    for (int i = SizeUtil.dp20;; i = 0)
    {
      localShapeDrawable.setShape(a(i));
      localShapeDrawable.getPaint().setColor(paramInt);
      ViewCompat.setBackground(paramView, localShapeDrawable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.i
 * JD-Core Version:    0.7.0.1
 */