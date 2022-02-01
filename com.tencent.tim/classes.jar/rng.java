import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import java.util.ArrayList;

public class rng
  implements rnh
{
  public void b(@NonNull ArrayList<rni> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < rni.ek.length)
    {
      paramArrayList.add(new rni(paramContext.getResources().getDrawable(rni.el[i]), 0, rni.ek[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rng
 * JD-Core Version:    0.7.0.1
 */