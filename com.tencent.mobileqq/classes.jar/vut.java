import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import java.util.List;

public class vut
  extends bkif
{
  public static vus a(Context paramContext, View paramView)
  {
    paramContext = vus.a(paramContext);
    paramContext.a(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static vus a(Context paramContext, List<bkhn> paramList, bkhw parambkhw)
  {
    return a(paramContext, null, paramList, parambkhw);
  }
  
  public static vus a(Context paramContext, vus paramvus, List<bkhn> paramList, bkhw parambkhw)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    int i;
    if (paramvus == null)
    {
      paramvus = a(paramContext, null);
      i = 0;
      label32:
      if (i >= paramList.size()) {
        break label113;
      }
      paramContext = (bkhn)paramList.get(i);
      if (paramContext.d == 0)
      {
        if (paramContext.a != 1) {
          break label96;
        }
        paramvus.a(paramContext, 1);
      }
    }
    for (;;)
    {
      i += 1;
      break label32;
      paramvus.c();
      paramvus.a();
      break;
      label96:
      if (paramContext.a == 2) {
        paramvus.a(paramContext, 3);
      }
    }
    label113:
    paramvus.a(parambkhw);
    return paramvus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vut
 * JD-Core Version:    0.7.0.1
 */