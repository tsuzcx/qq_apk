package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;

public final class ThemedSpinnerAdapter$Helper
{
  private final Context mContext;
  private LayoutInflater mDropDownInflater;
  private final LayoutInflater mInflater;
  
  public ThemedSpinnerAdapter$Helper(@NonNull Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  @NonNull
  public LayoutInflater getDropDownViewInflater()
  {
    if (this.mDropDownInflater != null) {
      return this.mDropDownInflater;
    }
    return this.mInflater;
  }
  
  @Nullable
  public Resources.Theme getDropDownViewTheme()
  {
    if (this.mDropDownInflater == null) {
      return null;
    }
    return this.mDropDownInflater.getContext().getTheme();
  }
  
  public void setDropDownViewTheme(@Nullable Resources.Theme paramTheme)
  {
    if (paramTheme == null)
    {
      this.mDropDownInflater = null;
      return;
    }
    if (paramTheme == this.mContext.getTheme())
    {
      this.mDropDownInflater = this.mInflater;
      return;
    }
    this.mDropDownInflater = LayoutInflater.from(new ContextThemeWrapper(this.mContext, paramTheme));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ThemedSpinnerAdapter.Helper
 * JD-Core Version:    0.7.0.1
 */