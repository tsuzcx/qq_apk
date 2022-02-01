import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import java.util.ArrayList;

public class zbr
  implements zbs
{
  public void a(@NonNull ArrayList<zbt> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < zbt.a.length)
    {
      paramArrayList.add(new zbt(paramContext.getResources().getDrawable(zbt.b[i]), 0, zbt.a[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbr
 * JD-Core Version:    0.7.0.1
 */