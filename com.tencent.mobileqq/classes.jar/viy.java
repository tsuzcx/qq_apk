import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import java.util.ArrayList;

public class viy
  implements viz
{
  public void a(@NonNull ArrayList<vja> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < vja.a.length)
    {
      paramArrayList.add(new vja(paramContext.getResources().getDrawable(vja.b[i]), 0, vja.a[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     viy
 * JD-Core Version:    0.7.0.1
 */