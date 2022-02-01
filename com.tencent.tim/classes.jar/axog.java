import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class axog
{
  public static int dip2px(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return 0;
    }
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axog
 * JD-Core Version:    0.7.0.1
 */