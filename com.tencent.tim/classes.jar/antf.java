import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;

public class antf
  extends anqv
{
  private LinearLayout b(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i = localResources.getDimensionPixelSize(2131299517);
    int j = localResources.getDimensionPixelSize(2131299518);
    paramContext.setPadding(i, localResources.getDimensionPixelSize(2131299519), j, localResources.getDimensionPixelSize(2131299516));
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  protected int IX()
  {
    return 21;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {}
    Resources localResources = paramContext.getResources();
    int i;
    int k;
    label102:
    Object localObject2;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
      i = paramView.getPaddingTop();
      j = paramView.getPaddingBottom();
      k = localResources.getDimensionPixelSize(2131299517);
      int m = localResources.getDimensionPixelSize(2131299518);
      hF(paramView);
      hI(paramView);
      paramView.setPadding(k, i, m, j);
      k = wja.dp2px(7.0F, localResources);
      i = 0;
      if (i >= this.rz.size()) {
        return paramView;
      }
      localObject2 = (anqu)this.rz.get(i);
      if (!(localObject2 instanceof anvd)) {
        break label216;
      }
      localObject1 = (anvd)localObject2;
      localObject2 = ((anvd)localObject1).a(paramContext, null, paramBundle);
      if (localObject2 != null)
      {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.topMargin = ((anvd)localObject1).topMargin;
        localLayoutParams.bottomMargin = ((anvd)localObject1).bottomMargin;
        paramView.addView((View)localObject2, localLayoutParams);
      }
    }
    label216:
    while (!(localObject2 instanceof anst))
    {
      LinearLayout.LayoutParams localLayoutParams;
      i += 1;
      break label102;
      paramView = b(paramContext);
      break;
    }
    Object localObject1 = ((anqu)localObject2).a(paramContext, null, paramBundle);
    if (((anst)localObject2).cJR) {}
    for (int j = 0;; j = wja.dp2px(2.0F, localResources))
    {
      localObject2 = new LinearLayout.LayoutParams(-1, j);
      ((LinearLayout.LayoutParams)localObject2).topMargin = k;
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = k;
      if (localObject1 == null) {
        break;
      }
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      break;
    }
    return paramView;
  }
  
  public String getName()
  {
    return "Layout21";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antf
 * JD-Core Version:    0.7.0.1
 */