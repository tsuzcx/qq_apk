import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import java.util.ArrayList;

public class vvr
  implements vvs
{
  public void a(@NonNull ArrayList<vvt> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < vvt.a.length)
    {
      paramArrayList.add(new vvt(paramContext.getResources().getDrawable(vvt.b[i]), 0, vvt.a[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vvr
 * JD-Core Version:    0.7.0.1
 */