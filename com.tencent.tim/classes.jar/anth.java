import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class anth
  extends anqv
{
  private LinearLayout b(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 17;
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  protected int IX()
  {
    return 23;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject2;
    if ((paramView != null) && ((paramView instanceof LinearLayout)) && ((paramView.getTag() instanceof anth.a)))
    {
      locala = (anth.a)paramView.getTag();
      localIterator = this.rz.iterator();
      for (;;)
      {
        localObject1 = paramView;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (anqu)localIterator.next();
        if ("button".equals(((anqu)localObject1).mTypeName))
        {
          localObject2 = (TextView)((anqu)localObject1).a(paramContext, locala.yg, paramBundle);
          if (TextUtils.isEmpty(((ansl)localObject1).As())) {
            ((TextView)localObject2).setTextSize(16.0F);
          }
          if (TextUtils.isEmpty(((ansl)localObject1).getTextColor())) {
            ((TextView)localObject2).setTextColor(Color.parseColor("#12b7f5"));
          }
        }
      }
    }
    Object localObject1 = b(paramContext);
    anth.a locala = new anth.a();
    Iterator localIterator = this.rz.iterator();
    paramView = null;
    while (localIterator.hasNext())
    {
      localObject2 = (anqu)localIterator.next();
      if ("button".equals(((anqu)localObject2).mTypeName))
      {
        paramView = (TextView)((anqu)localObject2).a(paramContext, null, paramBundle);
        if (TextUtils.isEmpty(((ansl)localObject2).As())) {
          paramView.setTextSize(16.0F);
        }
        if (TextUtils.isEmpty(((ansl)localObject2).getTextColor())) {
          paramView.setTextColor(Color.parseColor("#12b7f5"));
        }
        localObject2 = new LinearLayout.LayoutParams(-1, wja.dp2px(41.0F, paramContext.getResources()));
        ((LinearLayout.LayoutParams)localObject2).gravity = 17;
        ((LinearLayout)localObject1).addView(paramView, (ViewGroup.LayoutParams)localObject2);
      }
    }
    if (paramView != null) {
      locala.yg = paramView;
    }
    ((LinearLayout)localObject1).setTag(locala);
    return localObject1;
  }
  
  public String getName()
  {
    return "layout23";
  }
  
  static class a
  {
    View yg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anth
 * JD-Core Version:    0.7.0.1
 */