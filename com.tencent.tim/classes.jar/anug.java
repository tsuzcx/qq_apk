import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class anug
  extends anqv
{
  protected int IX()
  {
    return 0;
  }
  
  @TargetApi(16)
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("sType");
    int i;
    Resources localResources;
    int k;
    int j;
    int m;
    if (((localObject1 == null) || (!((String)localObject1).equals("1"))) || (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA))
    {
      i = 1;
      localResources = paramContext.getResources();
      k = localResources.getDimensionPixelSize(2131299517);
      j = localResources.getDimensionPixelSize(2131299518);
      m = wja.dp2px(2.0F, localResources);
      if (i == 0) {
        break label1966;
      }
      k = wja.dp2px(12.0F, localResources);
      j = k;
    }
    label794:
    label1183:
    label1578:
    label1963:
    label1966:
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof LinearLayout)))
      {
        localObject1 = (LinearLayout)paramView;
        label105:
        if (!lI(1)) {
          break label1963;
        }
        m += t(paramContext, 10);
      }
      for (;;)
      {
        int n;
        if (!TextUtils.isEmpty(this.cgX))
        {
          ((LinearLayout)localObject1).setBackgroundResource(2130838396);
          n = wja.dp2px(1.0F, localResources);
          paramView = (LinearLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
          paramView.leftMargin = n;
          paramView.rightMargin = n;
          ((LinearLayout)localObject1).setLayoutParams(paramView);
        }
        ((LinearLayout)localObject1).setPadding(k, 0, j, 0);
        int i1;
        View localView;
        if (((LinearLayout)localObject1).getChildCount() == this.rz.size())
        {
          i1 = this.rz.size();
          n = 0;
          if (n < i1)
          {
            paramView = (anqu)this.rz.get(n);
            paramView.hU = this.hU;
            if ((paramView instanceof StructMsgItemTitle)) {
              ((StructMsgItemTitle)paramView).bA(ayW(), this.dMj);
            }
            localView = paramView.a(paramContext, ((LinearLayout)localObject1).getChildAt(n), paramBundle);
            if (localView != null) {
              break label328;
            }
          }
        }
        label328:
        Object localObject2;
        label639:
        do
        {
          return localObject1;
          i = 0;
          break;
          localObject1 = new LinearLayout(paramContext);
          ((LinearLayout)localObject1).setOrientation(1);
          ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          break label105;
          i2 = wja.dp2px(10.0F, localResources);
          i3 = wja.dp2px(5.0F, localResources);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          if (n > 0) {
            ((LinearLayout.LayoutParams)localObject2).topMargin = i3;
          }
          str = paramView.mTypeName;
          if ("picture".equals(str))
          {
            localView.setId(-1);
            ((LinearLayout.LayoutParams)localObject2).height = (BaseChatItemLayout.bNT - i2 - i2);
          }
          for (;;)
          {
            n += 1;
            break;
            if ("video".equals(str))
            {
              ((LinearLayout.LayoutParams)localObject2).height = (BaseChatItemLayout.bNT - i2 - i2);
            }
            else if ("title".equals(str))
            {
              if (i != 0)
              {
                if (TextUtils.isEmpty(((StructMsgItemTitle)paramView).As())) {
                  ((TextView)localView).setTextSize(18.0F);
                }
                if (TextUtils.isEmpty(((StructMsgItemTitle)paramView).At())) {
                  ((TextView)localView).setTypeface(Typeface.DEFAULT, 1);
                }
              }
              localView.setId(-1);
            }
            else
            {
              if ("summary".equals(str))
              {
                if (this.dMi == 1)
                {
                  ((TextView)localView).setTextSize(12.0F);
                  ((TextView)localView).setTextColor(-4473925);
                }
                if (i != 0)
                {
                  localObject2 = ((anux)paramView).Au();
                  if ((localObject2 == null) || (!((String)localObject2).equals("1"))) {
                    break label639;
                  }
                  if (TextUtils.isEmpty(((anux)paramView).As())) {
                    ((TextView)localView).setTextSize(12.0F);
                  }
                  if (TextUtils.isEmpty(((anux)paramView).getTextColor())) {
                    ((TextView)localView).setTextColor(Color.parseColor("#8e8e8e"));
                  }
                }
                for (;;)
                {
                  localView.setId(-1);
                  break;
                  if (TextUtils.isEmpty(((anux)paramView).As())) {
                    ((TextView)localView).setTextSize(16.0F);
                  }
                  if (TextUtils.isEmpty(((anux)paramView).getTextColor())) {
                    ((TextView)localView).setTextColor(-16777216);
                  }
                  ((TextView)localView).setLineSpacing(4.0F, 1.0F);
                }
              }
              if ("hr".equals(str))
              {
                if (((anst)paramView).cJR)
                {
                  ((LinearLayout.LayoutParams)localObject2).height = 0;
                  if ((i != 0) && (n != 0)) {
                    ((LinearLayout.LayoutParams)localObject2).topMargin += wja.dp2px(6.0F, localResources);
                  }
                  localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                  if (i == 0) {
                    break label794;
                  }
                  ((LinearLayout)localObject1).setPadding(k, 0, j, 0);
                }
                for (;;)
                {
                  localView.setVisibility(0);
                  break;
                  ((LinearLayout.LayoutParams)localObject2).height = 1;
                  break label725;
                  if (i1 == 1) {
                    ((LinearLayout)localObject1).setPadding(2, 0, 2, 0);
                  } else if (n == i1 - 1) {
                    ((LinearLayout)localObject1).setPadding(k, m, j, 0);
                  }
                }
              }
              if ("image".equals(str))
              {
                ((LinearLayout.LayoutParams)localObject2).gravity = 1;
                ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
              }
              else if ("progress".equals(str))
              {
                ((LinearLayout.LayoutParams)localObject2).height = wja.dp2px(4.0F, localResources);
                if ((i1 == 1) && (localView.getVisibility() == 8))
                {
                  ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
                  if (lI(1)) {
                    ((LinearLayout)localObject1).setPadding(0, t(paramContext, 10), 0, 0);
                  }
                  if (lI(2)) {
                    ((LinearLayout)localObject1).setPadding(0, 0, 0, t(paramContext, 10));
                  }
                }
              }
              else if ("more".equals(str))
              {
                localView.setVisibility(0);
              }
            }
          }
          ((LinearLayout)localObject1).removeAllViews();
          i1 = this.rz.size();
          n = 0;
          if (n >= i1) {
            break label1183;
          }
          localObject2 = (anqu)this.rz.get(n);
          ((anqu)localObject2).hU = this.hU;
          if ((localObject2 instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localObject2).bA(ayW(), this.dMj);
          }
          localView = ((anqu)localObject2).a(paramContext, null, paramBundle);
        } while (localView == null);
        label725:
        label999:
        int i2 = wja.dp2px(10.0F, localResources);
        int i3 = wja.dp2px(5.0F, localResources);
        paramView = new LinearLayout.LayoutParams(-1, -2);
        if (n > 0) {
          paramView.topMargin = i3;
        }
        String str = ((anqu)localObject2).mTypeName;
        if ("picture".equals(str))
        {
          localView.setId(-1);
          paramView.height = (BaseChatItemLayout.bNT - i2 - i2);
          paramView.topMargin = wja.dp2px(9.5F, localResources);
          paramView.bottomMargin = wja.dp2px(9.5F, localResources);
        }
        for (;;)
        {
          ((LinearLayout)localObject1).addView(localView, paramView);
          n += 1;
          break label999;
          break;
          if ("video".equals(str))
          {
            paramView.height = (BaseChatItemLayout.bNT - i2 - i2);
            paramView.topMargin = wja.dp2px(9.5F, localResources);
            paramView.bottomMargin = wja.dp2px(9.5F, localResources);
          }
          else if ("title".equals(str))
          {
            if (i != 0)
            {
              if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).As())) {
                ((TextView)localView).setTextSize(18.0F);
              }
              if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).At())) {
                ((TextView)localView).setTypeface(Typeface.DEFAULT, 1);
              }
            }
            paramView.topMargin = wja.dp2px(3.0F, localResources);
            paramView.bottomMargin = wja.dp2px(3.0F, localResources);
            if ((lI(1)) && (n == 0)) {
              paramView.topMargin += wja.dp2px(14.0F, localResources);
            }
            localView.setId(-1);
          }
          else
          {
            if ("summary".equals(str))
            {
              if (i != 0)
              {
                str = ((anux)localObject2).Au();
                if ((str == null) || (!str.equals("1"))) {
                  break label1578;
                }
                if (TextUtils.isEmpty(((anux)localObject2).As())) {
                  ((TextView)localView).setTextSize(12.0F);
                }
                if (TextUtils.isEmpty(((anux)localObject2).getTextColor())) {
                  ((TextView)localView).setTextColor(Color.parseColor("#8e8e8e"));
                }
              }
              label1454:
              localObject2 = ((anux)localObject2).Au();
              if ((localObject2 != null) && (((String)localObject2).equals("1")))
              {
                paramView.topMargin = wja.dp2px(3.0F, localResources);
                paramView.bottomMargin = wja.dp2px(8.0F, localResources);
                label1503:
                if (this.dMi == 1)
                {
                  ((TextView)localView).setTextSize(12.0F);
                  ((TextView)localView).setTextColor(-4473925);
                }
                if ((lI(2)) && (n == i1 - 1)) {
                  if (i == 0) {
                    break label1665;
                  }
                }
              }
              for (paramView.bottomMargin += wja.dp2px(12.0F, localResources);; paramView.bottomMargin += wja.dp2px(16.0F, localResources))
              {
                localView.setId(-1);
                break;
                if (TextUtils.isEmpty(((anux)localObject2).As())) {
                  ((TextView)localView).setTextSize(16.0F);
                }
                if (TextUtils.isEmpty(((anux)localObject2).getTextColor())) {
                  ((TextView)localView).setTextColor(-16777216);
                }
                ((TextView)localView).setLineSpacing(4.0F, 1.0F);
                break label1454;
                paramView.topMargin = wja.dp2px(5.0F, localResources);
                paramView.bottomMargin = wja.dp2px(5.0F, localResources);
                break label1503;
              }
            }
            if ("hr".equals(str))
            {
              if (((anst)localObject2).cJR) {}
              for (paramView.height = 0;; paramView.height = 1)
              {
                if ((i != 0) && (n != 0)) {
                  paramView.topMargin += wja.dp2px(6.0F, localResources);
                }
                if (i == 0) {
                  break label1763;
                }
                ((LinearLayout)localObject1).setPadding(k, 0, j, 0);
                break;
              }
              label1763:
              if (i1 == 1) {
                ((LinearLayout)localObject1).setPadding(2, 0, 2, 0);
              } else if (n == i1 - 1) {
                ((LinearLayout)localObject1).setPadding(k, m, j, 0);
              }
            }
            else if ("image".equals(str))
            {
              paramView.gravity = 1;
              ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
            }
            else if ("progress".equals(str))
            {
              paramView.height = wja.dp2px(4.0F, localResources);
              if ((i1 == 1) && (localView.getVisibility() == 8))
              {
                ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
                if (lI(1)) {
                  ((LinearLayout)localObject1).setPadding(0, t(paramContext, 10), 0, 0);
                }
                if (lI(2)) {
                  ((LinearLayout)localObject1).setPadding(0, 0, 0, t(paramContext, 10));
                }
              }
            }
            else if ("more".equals(str))
            {
              paramView = new LinearLayout.LayoutParams(-1, wja.dp2px(36.0F, localResources));
            }
          }
        }
      }
    }
  }
  
  public String getName()
  {
    return "Layout0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anug
 * JD-Core Version:    0.7.0.1
 */