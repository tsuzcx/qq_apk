package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

class CompoundButtonCompat$CompoundButtonCompatBaseImpl
{
  private static final String TAG = "CompoundButtonCompat";
  private static Field sButtonDrawableField;
  private static boolean sButtonDrawableFieldFetched;
  
  public Drawable getButtonDrawable(CompoundButton paramCompoundButton)
  {
    if (!sButtonDrawableFieldFetched) {}
    try
    {
      sButtonDrawableField = CompoundButton.class.getDeclaredField("mButtonDrawable");
      sButtonDrawableField.setAccessible(true);
      sButtonDrawableFieldFetched = true;
      if (sButtonDrawableField == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          paramCompoundButton = (Drawable)sButtonDrawableField.get(paramCompoundButton);
          return paramCompoundButton;
        }
        catch (IllegalAccessException paramCompoundButton)
        {
          Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", paramCompoundButton);
          sButtonDrawableField = null;
        }
        localNoSuchFieldException = localNoSuchFieldException;
        Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", localNoSuchFieldException);
      }
    }
    return null;
  }
  
  public ColorStateList getButtonTintList(CompoundButton paramCompoundButton)
  {
    if ((paramCompoundButton instanceof TintableCompoundButton)) {
      return ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton)
  {
    if ((paramCompoundButton instanceof TintableCompoundButton)) {
      return ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintMode();
    }
    return null;
  }
  
  public void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    if ((paramCompoundButton instanceof TintableCompoundButton)) {
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
    }
  }
  
  public void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    if ((paramCompoundButton instanceof TintableCompoundButton)) {
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintMode(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl
 * JD-Core Version:    0.7.0.1
 */