package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.annotation.RequiresApi;
import android.widget.CompoundButton;

@RequiresApi(21)
class CompoundButtonCompat$CompoundButtonCompatApi21Impl
  extends CompoundButtonCompat.CompoundButtonCompatBaseImpl
{
  public ColorStateList getButtonTintList(CompoundButton paramCompoundButton)
  {
    return paramCompoundButton.getButtonTintList();
  }
  
  public PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton)
  {
    return paramCompoundButton.getButtonTintMode();
  }
  
  public void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    paramCompoundButton.setButtonTintList(paramColorStateList);
  }
  
  public void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    paramCompoundButton.setButtonTintMode(paramMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatApi21Impl
 * JD-Core Version:    0.7.0.1
 */