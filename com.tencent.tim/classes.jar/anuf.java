import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;

public class anuf
  extends anqv
{
  protected int IX()
  {
    return 9;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    return b(paramContext, paramView, false, paramBundle);
  }
  
  public View b(Context paramContext, View paramView, boolean paramBoolean, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    int j = this.rz.size();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (paramView != null)
    {
      localObject1 = localObject2;
      if ((paramView instanceof RelativeLayout))
      {
        paramView = (RelativeLayout)paramView;
        if (paramView.getChildCount() == j)
        {
          i = 0;
          localObject1 = paramView;
          if (i >= j) {
            break label1053;
          }
          localObject1 = (anqu)this.rz.get(i);
          ((anqu)localObject1).hU = this.hU;
          localObject2 = ((anqu)localObject1).mTypeName;
          if ("summary".equals(localObject2))
          {
            localObject1 = (anux)localObject1;
            if (paramBoolean)
            {
              ((anux)localObject1).setTextColor("black");
              label122:
              localObject2 = ((anux)localObject1).Au();
              if ((localObject2 == null) || (!((String)localObject2).equals("1"))) {
                break label189;
              }
              ((anux)localObject1).fK("22");
              ((anux)localObject1).setSingleLine(true);
              ((anux)localObject1).a(paramContext, paramView.findViewById(2), paramBundle);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            ((anux)localObject1).setTextColor(null);
            break label122;
            label189:
            if ((localObject2 != null) && (((String)localObject2).equals("2")))
            {
              ((anux)localObject1).fK("44");
              ((anux)localObject1).setSingleLine(true);
              ((anux)localObject1).a(paramContext, paramView.findViewById(3), paramBundle);
            }
            else
            {
              ((anux)localObject1).fK("30");
              ((anux)localObject1).setMaxLines(20);
              ((anux)localObject1).a(paramContext, paramView.findViewById(4), paramBundle);
              continue;
              if ("picture".equals(localObject2))
              {
                localObject1 = (ansr)localObject1;
                if ((((ansr)localObject1).cgX != null) && (!((ansr)localObject1).cgX.equals("")))
                {
                  localObject2 = ((ansr)localObject1).a(paramContext, paramView.findViewById(6), true, paramBundle);
                  ((View)localObject2).setClickable(true);
                  ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
                }
                else
                {
                  ((ansr)localObject1).a(paramContext, paramView.findViewById(5), true, paramBundle);
                }
              }
            }
          }
        }
        paramView.removeAllViews();
        localObject1 = paramView;
      }
    }
    if (localObject1 == null)
    {
      localObject1 = new RelativeLayout(paramContext);
      ((RelativeLayout)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    }
    for (;;)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setGravity(3);
      localLinearLayout.setId(1);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(9, -1);
      paramView.rightMargin = wja.dp2px(20.0F, localResources);
      ((RelativeLayout)localObject1).addView(localLinearLayout, paramView);
      paramView = null;
      i = 0;
      Object localObject3;
      if (i < j)
      {
        localObject2 = (anqu)this.rz.get(i);
        ((anqu)localObject2).hU = this.hU;
        localObject3 = ((anqu)localObject2).mTypeName;
        if ("summary".equals(localObject3))
        {
          localObject2 = (anux)localObject2;
          if (paramBoolean)
          {
            ((anux)localObject2).setTextColor("black");
            label527:
            localObject3 = ((anux)localObject2).Au();
            if ((localObject3 == null) || (!((String)localObject3).equals("1"))) {
              break label621;
            }
            ((anux)localObject2).fK("22");
            ((anux)localObject2).setSingleLine(true);
            localObject2 = ((anux)localObject2).a(paramContext, null, paramBundle);
            ((View)localObject2).setId(2);
            ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            localLinearLayout.addView((View)localObject2, 0);
          }
        }
      }
      label1053:
      label1066:
      for (;;)
      {
        i += 1;
        break;
        ((anux)localObject2).setTextColor(null);
        break label527;
        label621:
        if ((localObject3 != null) && (((String)localObject3).equals("2")))
        {
          ((anux)localObject2).fK("44");
          ((anux)localObject2).setSingleLine(true);
          localObject2 = ((anux)localObject2).a(paramContext, null, paramBundle);
          ((View)localObject2).setId(3);
          localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject3).topMargin = wja.dp2px(-3.5F, localResources);
          localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
        else
        {
          ((anux)localObject2).fK("30");
          ((anux)localObject2).setMaxLines(20);
          localObject2 = ((anux)localObject2).a(paramContext, null, paramBundle);
          ((View)localObject2).setId(4);
          localObject3 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject3).addRule(1, 1);
          ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          continue;
          if ("picture".equals(localObject3))
          {
            localObject3 = (ansr)localObject2;
            localObject2 = ((ansr)localObject3).a(paramContext, null, true, paramBundle);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(40.0F, localResources), wja.dp2px(40.0F, localResources));
            if ((((ansr)localObject3).cgX != null) && (!((ansr)localObject3).cgX.equals("")))
            {
              ((View)localObject2).setId(6);
              localLayoutParams.addRule(11, -1);
              ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
              ((View)localObject2).setClickable(true);
              ((View)localObject2).setOnClickListener((View.OnClickListener)localObject3);
            }
            else
            {
              ((View)localObject2).setId(5);
              paramView = (View)localObject2;
              continue;
              if (localLinearLayout.getChildCount() == 0) {
                localLinearLayout.setVisibility(8);
              }
              if (paramView != null)
              {
                paramContext = new RelativeLayout.LayoutParams(wja.dp2px(40.0F, localResources), wja.dp2px(40.0F, localResources));
                if (((RelativeLayout)localObject1).findViewById(6) != null)
                {
                  paramContext.addRule(0, 6);
                  paramContext.rightMargin = wja.dp2px(7.5F, localResources);
                  ((RelativeLayout)localObject1).addView(paramView, paramContext);
                }
              }
              else
              {
                paramContext = ((RelativeLayout)localObject1).findViewById(4);
                if (paramContext != null)
                {
                  paramView = (RelativeLayout.LayoutParams)paramContext.getLayoutParams();
                  if (((RelativeLayout)localObject1).findViewById(5) == null) {
                    break label1066;
                  }
                  paramView.addRule(0, 5);
                }
              }
              for (;;)
              {
                paramContext.setLayoutParams(paramView);
                hF((View)localObject1);
                i = wja.dp2px(22.5F, localResources);
                j = wja.dp2px(22.5F, localResources);
                ((RelativeLayout)localObject1).setPadding(i, wja.dp2px(10.75F, localResources), j, wja.dp2px(11.75F, localResources));
                return localObject1;
                paramContext.addRule(11, -1);
                break;
                if (((RelativeLayout)localObject1).findViewById(6) != null) {
                  paramView.addRule(0, 6);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public String getName()
  {
    return "Layout9";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anuf
 * JD-Core Version:    0.7.0.1
 */