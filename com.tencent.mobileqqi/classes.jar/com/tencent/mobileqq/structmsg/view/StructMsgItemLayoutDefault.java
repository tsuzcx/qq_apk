package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Collection;

public class StructMsgItemLayoutDefault
  extends AbsStructMsgItem
{
  public StructMsgItemLayoutDefault()
  {
    this.l = 0;
  }
  
  public StructMsgItemLayoutDefault(int paramInt)
  {
    super(paramInt);
    this.l = 0;
  }
  
  public StructMsgItemLayoutDefault(Collection paramCollection)
  {
    super(paramCollection);
    this.l = 0;
  }
  
  public View b(Context paramContext, View paramView)
  {
    Resources localResources = paramContext.getResources();
    int m = localResources.getDimensionPixelSize(2131427488);
    int n = localResources.getDimensionPixelSize(2131427489);
    int j = AIOUtils.a(5.0F, localResources);
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      if (!a(1)) {
        break label915;
      }
    }
    label915:
    for (int i = a(paramContext) + j;; i = j)
    {
      int k = j;
      if (a(2)) {
        k = j + a(paramContext);
      }
      paramView.setPadding(m, i, n, k);
      if (!TextUtils.isEmpty(this.c)) {
        paramView.setBackgroundResource(2130837877);
      }
      View localView;
      if (paramView.getChildCount() == this.a.size())
      {
        k = this.a.size();
        j = 0;
        if (j < k)
        {
          localObject = (AbsStructMsgElement)this.a.get(j);
          if ((localObject instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localObject).a(a(), this.j);
          }
          localView = ((AbsStructMsgElement)localObject).a(paramContext, paramView.getChildAt(j));
          if (localView != null) {
            break label238;
          }
        }
      }
      label238:
      do
      {
        return paramView;
        paramView = new LinearLayout(paramContext);
        paramView.setOrientation(1);
        paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        break;
        i1 = AIOUtils.a(10.0F, localResources);
        i2 = AIOUtils.a(5.0F, localResources);
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (j > 0) {
          localLayoutParams.topMargin = i2;
        }
        localObject = ((AbsStructMsgElement)localObject).a;
        if ("picture".equals(localObject))
        {
          localView.setId(-1);
          localLayoutParams.height = (BaseChatItemLayout.g - i1 - i1);
        }
        for (;;)
        {
          j += 1;
          break;
          if ("title".equals(localObject))
          {
            localView.setId(-1);
          }
          else if ("summary".equals(localObject))
          {
            localView.setId(-1);
          }
          else if ("hr".equals(localObject))
          {
            localLayoutParams.height = 1;
            if (k == 1) {
              paramView.setPadding(0, 0, 0, 0);
            } else if (j == k - 1) {
              paramView.setPadding(m, i, n, 0);
            }
          }
          else if ("image".equals(localObject))
          {
            localLayoutParams.gravity = 1;
            paramView.setPadding(0, 0, 0, 0);
          }
          else if ("progress".equals(localObject))
          {
            localLayoutParams.height = AIOUtils.a(4.0F, localResources);
            if ((k == 1) && (localView.getVisibility() == 8))
            {
              paramView.setPadding(0, 0, 0, 0);
              if (a(1)) {
                paramView.setPadding(0, a(paramContext), 0, 0);
              }
              if (a(2)) {
                paramView.setPadding(0, 0, 0, a(paramContext));
              }
            }
          }
        }
        paramView.removeAllViews();
        k = this.a.size();
        j = 0;
        if (j >= k) {
          break label704;
        }
        localObject = (AbsStructMsgElement)this.a.get(j);
        if ((localObject instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject).a(a(), this.j);
        }
        localView = ((AbsStructMsgElement)localObject).a(paramContext, null);
      } while (localView == null);
      label551:
      int i1 = AIOUtils.a(10.0F, localResources);
      int i2 = AIOUtils.a(5.0F, localResources);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (j > 0) {
        localLayoutParams.topMargin = i2;
      }
      Object localObject = ((AbsStructMsgElement)localObject).a;
      if ("picture".equals(localObject))
      {
        localView.setId(-1);
        localLayoutParams.height = (BaseChatItemLayout.g - i1 - i1);
      }
      for (;;)
      {
        paramView.addView(localView, localLayoutParams);
        j += 1;
        break label551;
        label704:
        break;
        if ("title".equals(localObject))
        {
          localView.setId(-1);
        }
        else if ("summary".equals(localObject))
        {
          localView.setId(-1);
        }
        else if ("hr".equals(localObject))
        {
          localLayoutParams.height = 1;
          if (k == 1) {
            paramView.setPadding(0, 0, 0, 0);
          } else if (j == k - 1) {
            paramView.setPadding(m, i, n, 0);
          }
        }
        else if ("image".equals(localObject))
        {
          localLayoutParams.gravity = 1;
          paramView.setPadding(0, 0, 0, 0);
        }
        else if ("progress".equals(localObject))
        {
          localLayoutParams.height = AIOUtils.a(4.0F, localResources);
          if ((k == 1) && (localView.getVisibility() == 8))
          {
            paramView.setPadding(0, 0, 0, 0);
            if (a(1)) {
              paramView.setPadding(0, a(paramContext), 0, 0);
            }
            if (a(2)) {
              paramView.setPadding(0, 0, 0, a(paramContext));
            }
          }
        }
      }
    }
  }
  
  public String b()
  {
    return "Layout0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault
 * JD-Core Version:    0.7.0.1
 */