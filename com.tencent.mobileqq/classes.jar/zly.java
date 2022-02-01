import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import java.util.ArrayList;

public class zly
  implements zlz
{
  public void a(@NonNull ArrayList<zma> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < zma.a.length)
    {
      paramArrayList.add(new zma(paramContext.getResources().getDrawable(zma.b[i]), 0, zma.a[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zly
 * JD-Core Version:    0.7.0.1
 */