package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

@RequiresApi(17)
class TextViewCompat$TextViewCompatApi17Impl
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl
 * JD-Core Version:    0.7.0.1
 */