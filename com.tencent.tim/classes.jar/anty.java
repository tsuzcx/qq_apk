import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;

public class anty
  extends anqv
{
  private final int dMw = 16;
  
  private LinearLayout.LayoutParams a(Resources paramResources, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 50;; i = 58) {
      return new LinearLayout.LayoutParams(wja.dp2px(i, paramResources), wja.dp2px(i, paramResources));
    }
  }
  
  private LinearLayout b(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    hF(paramContext);
    hI(paramContext);
    int k = localResources.getDimensionPixelSize(2131299517);
    int m = localResources.getDimensionPixelSize(2131299518);
    int i;
    if (lI(1))
    {
      i = wja.dp2px(15.0F, localResources);
      if (!lI(2)) {
        break label121;
      }
    }
    label121:
    for (int j = wja.dp2px(15.0F, localResources);; j = wja.dp2px(6.0F, localResources))
    {
      paramContext.setPadding(k, i, m, j);
      paramContext.setLayoutParams(localLayoutParams);
      paramContext.setOrientation(0);
      return paramContext;
      i = wja.dp2px(6.0F, localResources);
      break;
    }
  }
  
  private void dTz()
  {
    if (this.rz.size() > 2) {}
    int k;
    int j;
    do
    {
      return;
      k = -1;
      j = -1;
      int i = 0;
      if (i < this.rz.size())
      {
        localanqu = (anqu)this.rz.get(i);
        int m;
        if ("title".equals(localanqu.mTypeName)) {
          m = i;
        }
        for (;;)
        {
          i += 1;
          j = m;
          break;
          m = j;
          if ("picture".equals(localanqu.mTypeName))
          {
            k = i;
            m = j;
          }
        }
      }
    } while ((j < 0) || (k < 0) || (j >= k));
    anqu localanqu = (anqu)this.rz.get(j);
    this.rz.set(j, this.rz.get(k));
    this.rz.set(k, localanqu);
  }
  
  protected int IX()
  {
    return 4;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("NAIOSub", false);
    int j;
    Object localObject2;
    Object localObject3;
    label79:
    Object localObject1;
    Object localObject4;
    if (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA)
    {
      j = 1;
      if ((paramView == null) || (!(paramView instanceof LinearLayout)) || (((LinearLayout)paramView).getChildCount() != this.rz.size())) {
        break label281;
      }
      localObject2 = (LinearLayout)paramView;
      if (j != 0) {
        dTz();
      }
      localObject3 = this.rz.iterator();
      j = 0;
      localObject1 = localObject2;
      if (!((Iterator)localObject3).hasNext()) {
        break label802;
      }
      localObject1 = (anqu)((Iterator)localObject3).next();
      ((anqu)localObject1).hU = this.hU;
      localObject4 = ((anqu)localObject1).mTypeName;
      if (("title".equals(localObject4)) || ("picture".equals(localObject4)) || ("video".equals(localObject4)))
      {
        ((anqu)localObject1).a(paramContext, ((LinearLayout)localObject2).getChildAt(j), paramBundle);
        if ((localObject1 instanceof StructMsgItemTitle))
        {
          ((StructMsgItemTitle)localObject1).bA(ayW(), this.dMj);
          if ((((StructMsgItemTitle)localObject1).As() == null) || (((StructMsgItemTitle)localObject1).As().equals(""))) {
            break label811;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(((StructMsgItemTitle)localObject1).As()) / 2;
        localObject1 = (TextView)paramView.findViewById(2131380976);
        if (localObject1 != null) {
          ((TextView)localObject1).setTextSize(2, i);
        }
        j += 1;
        break label79;
        j = 0;
      }
      catch (Exception localException1)
      {
        i = 16;
        continue;
      }
      label281:
      paramView = paramContext.getResources();
      LinearLayout localLinearLayout = b(paramContext);
      if (j != 0)
      {
        i = localLinearLayout.getPaddingTop();
        int k = localLinearLayout.getPaddingBottom();
        localLinearLayout.setPadding(paramView.getDimensionPixelSize(2131296465), i, paramView.getDimensionPixelOffset(2131296466), k);
        dTz();
      }
      localObject2 = this.rz.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject4 = (anqu)((Iterator)localObject2).next();
        ((anqu)localObject4).hU = this.hU;
        localObject3 = ((anqu)localObject4).mTypeName;
        if ("title".equals(localObject3))
        {
          localObject3 = ((anqu)localObject4).a(paramContext, null, paramBundle);
          if (((localObject3 instanceof TextView)) && (!TextUtils.isEmpty(((TextView)localObject3).getText()))) {
            localLinearLayout.setContentDescription(((TextView)localObject3).getText());
          }
          if (!(localObject4 instanceof StructMsgItemTitle)) {
            break label805;
          }
          ((StructMsgItemTitle)localObject4).bA(ayW(), this.dMj);
          if ((((StructMsgItemTitle)localObject4).As() == null) || (((StructMsgItemTitle)localObject4).As().equals(""))) {
            break label805;
          }
        }
      }
      for (;;)
      {
        try
        {
          i = Integer.parseInt(((StructMsgItemTitle)localObject4).As()) / 2;
          localObject4 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject4).gravity = 16;
          ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
          if (localLinearLayout.getChildCount() == 0)
          {
            ((LinearLayout.LayoutParams)localObject4).leftMargin = 0;
            ((LinearLayout.LayoutParams)localObject4).rightMargin = wja.dp2px(15.0F, paramView);
            localTextView = (TextView)((View)localObject3).findViewById(2131380976);
            if (localTextView != null)
            {
              localTextView.setEllipsize(TextUtils.TruncateAt.END);
              if (i == 0) {
                continue;
              }
              localTextView.setTextSize(2, i);
            }
            localLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          }
        }
        catch (Exception localException2)
        {
          TextView localTextView;
          i = 0;
          continue;
          localException2.leftMargin = wja.dp2px(15.0F, paramView);
          localException2.rightMargin = 0;
          if (j == 0) {
            continue;
          }
          localException2.leftMargin = wja.dp2px(10.0F, paramView);
          ((TextView)localObject3).setLineSpacing(wja.dp2px(2.5F, paramView), 1.0F);
          ((TextView)localObject3).setMaxLines(2);
          continue;
          localTextView.setTextSize(2, 16.0F);
          continue;
        }
        if (("picture".equals(localObject3)) || ("video".equals(localObject3)))
        {
          localLinearLayout.addView(localException2.a(paramContext, null, paramBundle), a(paramView, bool));
          break;
        }
        if (!"hr".equals(localObject3)) {
          break;
        }
        localObject3 = localException2.a(paramContext, null, paramBundle);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
        if (this.rz.size() == 1) {
          localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), 0, localLinearLayout.getPaddingRight(), 0);
        }
        localLinearLayout.addView((View)localObject3, localLayoutParams);
        break;
        label802:
        return localLinearLayout;
        label805:
        i = 0;
      }
      label811:
      int i = 16;
    }
  }
  
  public String getName()
  {
    return "Layout4";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anty
 * JD-Core Version:    0.7.0.1
 */