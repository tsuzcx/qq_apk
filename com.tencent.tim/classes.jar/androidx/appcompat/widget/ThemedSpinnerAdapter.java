package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;

public abstract interface ThemedSpinnerAdapter
  extends SpinnerAdapter
{
  @Nullable
  public abstract Resources.Theme getDropDownViewTheme();
  
  public abstract void setDropDownViewTheme(@Nullable Resources.Theme paramTheme);
  
  public static final class Helper
  {
    private final Context mContext;
    private LayoutInflater mDropDownInflater;
    private final LayoutInflater mInflater;
    
    public Helper(@NonNull Context paramContext)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.ThemedSpinnerAdapter
 * JD-Core Version:    0.7.0.1
 */