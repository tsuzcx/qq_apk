import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;

public abstract interface wvt<T extends RecyclerView.ViewHolder>
{
  public abstract void a(@Nullable T paramT, int paramInt);
  
  public abstract void a(@Nullable T paramT, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wvt
 * JD-Core Version:    0.7.0.1
 */