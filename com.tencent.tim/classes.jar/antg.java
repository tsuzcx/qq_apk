import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;

public class antg
  extends anqv
{
  private LinearLayout b(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i = wja.dp2px(12.0F, paramContext.getResources());
    localLinearLayout.setPadding(i, i, i, i);
    localLinearLayout.setLayoutParams(localLayoutParams);
    return localLinearLayout;
  }
  
  protected int IX()
  {
    return 22;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Iterator localIterator;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
      localIterator = this.rz.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return paramView;
      }
      Object localObject1 = (anqu)localIterator.next();
      Object localObject2 = ((anqu)localObject1).mTypeName;
      ((anqu)localObject1).hU = this.hU;
      if ("title".equals(localObject2))
      {
        localObject2 = (StructMsgItemTitle)localObject1;
        ((StructMsgItemTitle)localObject2).bA(ayW(), this.dMj);
        localObject1 = (TextView)((anqu)localObject1).a(paramContext, null, paramBundle);
        ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject1).setMaxLines(2);
        if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).As())) {
          ((TextView)localObject1).setTextSize(18.0F);
        }
        if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).getTextColor())) {
          ((TextView)localObject1).setTextColor(Color.parseColor("#000000"));
        }
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(12.0F, paramContext.getResources());
        paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        continue;
        paramView = b(paramContext);
        break;
      }
      if ("picture".equals(localObject2))
      {
        localObject1 = ((anqu)localObject1).a(paramContext, null, paramBundle);
        int i = wja.dp2px(50.0F, paramContext.getResources());
        paramView.addView((View)localObject1, new LinearLayout.LayoutParams(i, i));
      }
    }
    return paramView;
  }
  
  public String getName()
  {
    return "layout22";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antg
 * JD-Core Version:    0.7.0.1
 */