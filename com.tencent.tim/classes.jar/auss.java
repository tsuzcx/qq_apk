import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.List;

public class auss
{
  public static Dialog a(Context paramContext, View paramView)
  {
    return a(paramContext, paramView, -1, null);
  }
  
  public static Dialog a(Context paramContext, View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramContext = ausj.a(paramContext, paramInt, paramLayoutParams);
    paramContext.setActionContentView(paramView, null);
    return paramContext;
  }
  
  public static ausj a(Context paramContext, ausj paramausj, List<ausi> paramList, ausj.a parama)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    int i;
    if (paramausj == null)
    {
      paramausj = (ausj)a(paramContext, null);
      i = 0;
      label35:
      if (i >= paramList.size()) {
        break label116;
      }
      paramContext = (ausi)paramList.get(i);
      if (paramContext.visibility == 0)
      {
        if (paramContext.type != 1) {
          break label99;
        }
        paramausj.a(paramContext, 1);
      }
    }
    for (;;)
    {
      i += 1;
      break label35;
      paramausj.clear();
      paramausj.updateUI();
      break;
      label99:
      if (paramContext.type == 2) {
        paramausj.a(paramContext, 3);
      }
    }
    label116:
    paramausj.a(parama);
    return paramausj;
  }
  
  public static ausj a(Context paramContext, List<ausi> paramList, ausj.a parama)
  {
    return a(paramContext, null, paramList, parama);
  }
  
  public static void a(Activity paramActivity, ausj paramausj)
  {
    if ((paramActivity == null) || (paramausj == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        paramausj.show();
        return;
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    LogUtils.e("ActionSheetHelper", "showActionSheet when activity(" + paramActivity + ") is finish!");
  }
  
  public static Dialog b(Context paramContext, View paramView)
  {
    paramContext = ausj.c(paramContext);
    paramContext.setActionContentView(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static void b(Activity paramActivity, ausj paramausj)
  {
    if ((paramActivity == null) || (paramausj == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        paramausj.dismiss();
        return;
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    LogUtils.e("ActionSheetHelper", "dismissActionSheet when activity(" + paramActivity + ") is finish!");
  }
  
  public static String n(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getString(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auss
 * JD-Core Version:    0.7.0.1
 */