import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import java.util.ArrayList;

public class xos
  implements xot
{
  public void a(@NonNull ArrayList<xou> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < xou.a.length)
    {
      paramArrayList.add(new xou(paramContext.getResources().getDrawable(xou.b[i]), 0, xou.a[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xos
 * JD-Core Version:    0.7.0.1
 */