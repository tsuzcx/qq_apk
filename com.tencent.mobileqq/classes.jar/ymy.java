import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import java.util.ArrayList;

public class ymy
  implements ymz
{
  public void a(@NonNull ArrayList<yna> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < yna.a.length)
    {
      paramArrayList.add(new yna(paramContext.getResources().getDrawable(yna.b[i]), 0, yna.a[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymy
 * JD-Core Version:    0.7.0.1
 */