package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;

public class StructMsgItemLayout3
  extends AbsStructMsgItem
{
  public StructMsgItemLayout3()
  {
    this.l = 3;
  }
  
  public StructMsgItemLayout3(int paramInt)
  {
    super(paramInt);
    this.l = 3;
  }
  
  public StructMsgItemLayout3(Collection paramCollection)
  {
    super(paramCollection);
    this.l = 3;
  }
  
  public View b(Context paramContext, View paramView)
  {
    int i = 0;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      j = this.a.size();
      localObject1 = paramContext.getResources();
      while (i < j)
      {
        localObject2 = (AbsStructMsgElement)this.a.get(i);
        if ("picture".equals(((AbsStructMsgElement)localObject2).a)) {
          ((AbsStructMsgElement)localObject2).a(paramContext, paramView.getChildAt(i));
        }
        i += 1;
      }
      i = AIOUtils.a(10.0F, (Resources)localObject1);
      if (a(1))
      {
        j = i;
        if (!a(2)) {
          break label150;
        }
      }
      label150:
      for (k = i;; k = AIOUtils.a(5.0F, (Resources)localObject1))
      {
        paramView.setPadding(i, j, i, k);
        paramContext = paramView;
        a(paramContext);
        b(paramContext);
        return paramContext;
        j = AIOUtils.a(5.0F, (Resources)localObject1);
        break;
      }
    }
    paramView = new LinearLayout(paramContext);
    Object localObject1 = new ArrayList();
    int m = this.a.size();
    Object localObject2 = paramContext.getResources();
    int k = 0;
    int j = 0;
    label201:
    if (k < m)
    {
      localObject3 = (AbsStructMsgElement)this.a.get(k);
      if (!"picture".equals(((AbsStructMsgElement)localObject3).a)) {
        break label524;
      }
      if (j < 3) {}
    }
    else
    {
      if (((ArrayList)localObject1).size() != 0) {
        break label357;
      }
      if (QLog.isColorLevel()) {
        QLog.e("StructMsg", 2, "generate 3 item failed,item is:" + this.a);
      }
      return null;
    }
    Object localObject3 = ((AbsStructMsgElement)localObject3).a(paramContext, null);
    if (k == 0)
    {
      i = 2131230802;
      label302:
      ((View)localObject3).setId(i);
      ((ArrayList)localObject1).add(localObject3);
    }
    label524:
    for (i = j + 1;; i = j)
    {
      k += 1;
      j = i;
      break label201;
      if (k == 1)
      {
        i = 2131230803;
        break label302;
      }
      if (k == 2)
      {
        i = 2131230804;
        break label302;
        label357:
        i = AIOUtils.a(10.0F, (Resources)localObject2);
        if (a(1))
        {
          j = i;
          label376:
          if (!a(2)) {
            break label507;
          }
        }
        label507:
        for (k = i;; k = AIOUtils.a(5.0F, (Resources)localObject2))
        {
          paramView.setPadding(i, j, i, k);
          j = ((ArrayList)localObject1).size();
          k = (int)((BaseChatItemLayout.g - i - i - 2) / 3.0F);
          i = 0;
          for (;;)
          {
            paramContext = paramView;
            if (i >= j) {
              break;
            }
            paramContext = (View)((ArrayList)localObject1).get(i);
            localObject2 = new LinearLayout.LayoutParams(-1, -2);
            ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
            ((LinearLayout.LayoutParams)localObject2).width = 0;
            ((LinearLayout.LayoutParams)localObject2).height = k;
            if (i > 0) {
              ((LinearLayout.LayoutParams)localObject2).leftMargin = 1;
            }
            paramView.addView(paramContext, (ViewGroup.LayoutParams)localObject2);
            i += 1;
          }
          j = AIOUtils.a(5.0F, (Resources)localObject2);
          break label376;
        }
      }
      i = 0;
      break label302;
    }
  }
  
  public String b()
  {
    return "Layout3";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout3
 * JD-Core Version:    0.7.0.1
 */