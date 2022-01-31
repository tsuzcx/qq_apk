package android.support.v7.widget;

import android.util.Property;

final class SwitchCompat$1
  extends Property
{
  SwitchCompat$1(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float get(SwitchCompat paramSwitchCompat)
  {
    return Float.valueOf(SwitchCompat.access$000(paramSwitchCompat));
  }
  
  public void set(SwitchCompat paramSwitchCompat, Float paramFloat)
  {
    paramSwitchCompat.setThumbPosition(paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.SwitchCompat.1
 * JD-Core Version:    0.7.0.1
 */