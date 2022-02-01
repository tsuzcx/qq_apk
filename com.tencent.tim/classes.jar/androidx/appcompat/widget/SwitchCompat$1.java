package androidx.appcompat.widget;

import android.util.Property;

final class SwitchCompat$1
  extends Property<SwitchCompat, Float>
{
  SwitchCompat$1(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float get(SwitchCompat paramSwitchCompat)
  {
    return Float.valueOf(paramSwitchCompat.mThumbPosition);
  }
  
  public void set(SwitchCompat paramSwitchCompat, Float paramFloat)
  {
    paramSwitchCompat.setThumbPosition(paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.SwitchCompat.1
 * JD-Core Version:    0.7.0.1
 */