import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Collection;

public class ansv
  extends anqv
{
  public ansv() {}
  
  public ansv(Collection<anqu> paramCollection)
  {
    super(paramCollection);
  }
  
  protected int IX()
  {
    return 1;
  }
  
  protected int a(Resources paramResources, int paramInt, anqu paramanqu)
  {
    return wja.dp2px(5.0F, paramResources);
  }
  
  protected ArrayList<anqu> ao(ArrayList<anqu> paramArrayList)
  {
    return paramArrayList;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    int n = localResources.getDimensionPixelSize(2131299517);
    int i1 = localResources.getDimensionPixelSize(2131299518);
    int i = wja.dp2px(5.0F, localResources);
    if ((this.e != null) && (this.e.mMsgServiceID == 35)) {}
    for (int k = 6;; k = 10)
    {
      Object localObject1;
      Object localObject2;
      View localView;
      if ((paramView != null) && ((paramView instanceof LinearLayout)))
      {
        paramView = (LinearLayout)paramView;
        if (!TextUtils.isEmpty(this.cgX)) {
          paramView.setBackgroundResource(2130839682);
        }
        hI(paramView);
        localObject1 = ao(this.rz);
        if (paramView.getChildCount() != ((ArrayList)localObject1).size()) {
          break label529;
        }
        k = ((ArrayList)localObject1).size();
        j = 0;
        if (j < k)
        {
          localObject2 = (anqu)((ArrayList)localObject1).get(j);
          ((anqu)localObject2).hU = this.hU;
          if ((localObject2 instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localObject2).bA(ayW(), this.dMj);
          }
          localView = ((anqu)localObject2).a(paramContext, paramView.getChildAt(j), paramBundle);
          if (localView != null) {}
        }
        else
        {
          label197:
          return paramView;
        }
      }
      else
      {
        paramView = new LinearLayout(paramContext);
        paramView.setOrientation(1);
        localObject1 = new LinearLayout.LayoutParams(-1, -2);
        if (!lI(1)) {
          break label853;
        }
      }
      label529:
      label543:
      label705:
      label853:
      for (int j = t(paramContext, k) + i;; j = i)
      {
        int m = i;
        if (lI(2)) {
          m = i + t(paramContext, k);
        }
        paramView.setPadding(n, j, i1, m);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        i = j;
        break;
        m = wja.dp2px(10.0F, localResources);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (j > 0) {
          localLayoutParams.topMargin = a(localResources, j, (anqu)localObject2);
        }
        localObject2 = ((anqu)localObject2).mTypeName;
        if ("picture".equals(localObject2))
        {
          localView.setId(-1);
          localLayoutParams.height = (BaseChatItemLayout.bNT - m - m);
        }
        for (;;)
        {
          j += 1;
          break;
          if ("video".equals(localObject2))
          {
            localLayoutParams.height = (BaseChatItemLayout.bNT - m - m);
          }
          else if ("title".equals(localObject2))
          {
            localView.setId(-1);
          }
          else if ("summary".equals(localObject2))
          {
            localView.setId(-1);
          }
          else if ("hr".equals(localObject2))
          {
            localLayoutParams.height = 1;
            if (k == 1) {
              paramView.setPadding(0, 0, 0, 0);
            } else if (j == k - 1) {
              paramView.setPadding(n, i, i1, 0);
            }
          }
          else if ("image".equals(localObject2))
          {
            localLayoutParams.gravity = 1;
            paramView.setPadding(0, 0, 0, 0);
          }
        }
        paramView.removeAllViews();
        k = ((ArrayList)localObject1).size();
        j = 0;
        if (j < k)
        {
          localObject2 = (anqu)((ArrayList)localObject1).get(j);
          ((anqu)localObject2).hU = this.hU;
          if ((localObject2 instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localObject2).bA(ayW(), this.dMj);
          }
          localView = ((anqu)localObject2).a(paramContext, null, paramBundle);
          if (localView == null) {
            break label197;
          }
          m = wja.dp2px(10.0F, localResources);
          localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          if (j > 0) {
            localLayoutParams.topMargin = a(localResources, j, (anqu)localObject2);
          }
          localObject2 = ((anqu)localObject2).mTypeName;
          if (!"picture".equals(localObject2)) {
            break label705;
          }
          localView.setId(-1);
          localLayoutParams.height = (BaseChatItemLayout.bNT - m - m);
        }
        for (;;)
        {
          paramView.addView(localView, localLayoutParams);
          j += 1;
          break label543;
          break;
          if ("video".equals(localObject2))
          {
            localLayoutParams.height = (BaseChatItemLayout.bNT - m - m);
          }
          else if ("title".equals(localObject2))
          {
            localView.setId(-1);
          }
          else if ("summary".equals(localObject2))
          {
            localView.setId(-1);
          }
          else if ("hr".equals(localObject2))
          {
            localLayoutParams.height = 1;
            if (k == 1) {
              paramView.setPadding(0, 0, 0, 0);
            } else if (j == k - 1) {
              paramView.setPadding(n, i, i1, 0);
            }
          }
          else if ("image".equals(localObject2))
          {
            localLayoutParams.gravity = 1;
            paramView.setPadding(0, 0, 0, 0);
          }
        }
      }
    }
  }
  
  public String getName()
  {
    return "Layout1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansv
 * JD-Core Version:    0.7.0.1
 */