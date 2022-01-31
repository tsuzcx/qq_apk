import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import java.util.ArrayList;

public class xkj
  implements xkk
{
  public void a(@NonNull ArrayList<xkl> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < xkl.a.length)
    {
      paramArrayList.add(new xkl(paramContext.getResources().getDrawable(xkl.b[i]), 0, xkl.a[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xkj
 * JD-Core Version:    0.7.0.1
 */