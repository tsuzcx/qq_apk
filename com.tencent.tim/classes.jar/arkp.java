import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;

public class arkp
  extends StateListDrawable
{
  public arkp(int paramInt1, int paramInt2)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(paramInt1);
    addState(new int[] { 16842919 }, localColorDrawable);
    localColorDrawable = new ColorDrawable(paramInt2);
    addState(new int[] { 16842921 }, localColorDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arkp
 * JD-Core Version:    0.7.0.1
 */