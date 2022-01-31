package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StructMsgItemLayout4
  extends AbsStructMsgItem
{
  public StructMsgItemLayout4()
  {
    this.l = 4;
  }
  
  public StructMsgItemLayout4(int paramInt)
  {
    super(paramInt);
    this.l = 4;
  }
  
  public StructMsgItemLayout4(Collection paramCollection)
  {
    super(paramCollection);
    this.l = 4;
  }
  
  private LinearLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    a(paramContext);
    b(paramContext);
    int k = localResources.getDimensionPixelSize(2131492991);
    int m = localResources.getDimensionPixelSize(2131492992);
    int i;
    if (a(1))
    {
      i = localResources.getDimensionPixelSize(2131492993);
      if (!a(2)) {
        break label121;
      }
    }
    label121:
    for (int j = localResources.getDimensionPixelSize(2131492994);; j = AIOUtils.a(6.0F, localResources))
    {
      paramContext.setPadding(k, i, m, j);
      paramContext.setLayoutParams(localLayoutParams);
      paramContext.setOrientation(0);
      return paramContext;
      i = AIOUtils.a(6.0F, localResources);
      break;
    }
  }
  
  public View b(Context paramContext, View paramView)
  {
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)paramView;
      localObject1 = this.a.iterator();
      int i = 0;
      for (;;)
      {
        paramView = localLinearLayout;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        paramView = (AbsStructMsgElement)((Iterator)localObject1).next();
        localObject2 = paramView.a;
        if (("title".equals(localObject2)) || ("picture".equals(localObject2)))
        {
          paramView.a(paramContext, localLinearLayout.getChildAt(i));
          if ((paramView instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)paramView).a(a(), this.j);
          }
        }
        i += 1;
      }
    }
    Object localObject1 = paramContext.getResources();
    LinearLayout localLinearLayout = a(paramContext);
    Object localObject2 = this.a.iterator();
    for (;;)
    {
      paramView = localLinearLayout;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      Object localObject3 = (AbsStructMsgElement)((Iterator)localObject2).next();
      paramView = ((AbsStructMsgElement)localObject3).a;
      if ("title".equals(paramView))
      {
        paramView = ((AbsStructMsgElement)localObject3).a(paramContext, null);
        if ((localObject3 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject3).a(a(), this.j);
        }
        localObject3 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject3).gravity = 16;
        ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
        TextView localTextView = (TextView)paramView.findViewById(2131296324);
        if (localTextView != null) {
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
        }
        localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject3);
      }
      else if ("picture".equals(paramView))
      {
        localLinearLayout.addView(((AbsStructMsgElement)localObject3).a(paramContext, null), new LinearLayout.LayoutParams(AIOUtils.a(50.0F, (Resources)localObject1), AIOUtils.a(50.0F, (Resources)localObject1)));
      }
    }
    return paramView;
  }
  
  public String b()
  {
    return "Layout4";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout4
 * JD-Core Version:    0.7.0.1
 */