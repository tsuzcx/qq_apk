import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.ColorInt;

public class tsj
  extends PorterDuffColorFilter
{
  public tsj(@ColorInt int paramInt)
  {
    super(paramInt, PorterDuff.Mode.SRC_ATOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tsj
 * JD-Core Version:    0.7.0.1
 */