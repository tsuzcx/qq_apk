package android.support.v7.widget;

import android.content.res.Resources.Theme;
import android.support.annotation.Nullable;
import android.widget.SpinnerAdapter;

public abstract interface ThemedSpinnerAdapter
  extends SpinnerAdapter
{
  @Nullable
  public abstract Resources.Theme getDropDownViewTheme();
  
  public abstract void setDropDownViewTheme(@Nullable Resources.Theme paramTheme);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ThemedSpinnerAdapter
 * JD-Core Version:    0.7.0.1
 */