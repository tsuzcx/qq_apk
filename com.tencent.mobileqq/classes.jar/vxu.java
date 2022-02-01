import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import java.util.List;

public class vxu
  extends blji
{
  public static vxt a(Context paramContext, View paramView)
  {
    paramContext = vxt.a(paramContext);
    paramContext.a(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static vxt a(Context paramContext, List<bliq> paramList, bliz parambliz)
  {
    return a(paramContext, null, paramList, parambliz);
  }
  
  public static vxt a(Context paramContext, vxt paramvxt, List<bliq> paramList, bliz parambliz)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    int i;
    if (paramvxt == null)
    {
      paramvxt = a(paramContext, null);
      i = 0;
      label32:
      if (i >= paramList.size()) {
        break label113;
      }
      paramContext = (bliq)paramList.get(i);
      if (paramContext.d == 0)
      {
        if (paramContext.a != 1) {
          break label96;
        }
        paramvxt.a(paramContext, 1);
      }
    }
    for (;;)
    {
      i += 1;
      break label32;
      paramvxt.c();
      paramvxt.a();
      break;
      label96:
      if (paramContext.a == 2) {
        paramvxt.a(paramContext, 3);
      }
    }
    label113:
    paramvxt.a(parambliz);
    return paramvxt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxu
 * JD-Core Version:    0.7.0.1
 */