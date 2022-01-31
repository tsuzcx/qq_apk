package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StructMsgItemLayout5
  extends AbsStructMsgItem
{
  public StructMsgItemLayout5()
  {
    this.l = 5;
  }
  
  public StructMsgItemLayout5(int paramInt)
  {
    super(paramInt);
    this.l = 5;
  }
  
  public StructMsgItemLayout5(Collection paramCollection)
  {
    super(paramCollection);
    this.l = 5;
  }
  
  private RelativeLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new RelativeLayout(paramContext);
    a(paramContext);
    b(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    int k = localResources.getDimensionPixelSize(2131492991);
    int m = localResources.getDimensionPixelSize(2131492992);
    int i;
    if (a(1))
    {
      i = localResources.getDimensionPixelSize(2131492993);
      if (!a(2)) {
        break label116;
      }
    }
    label116:
    for (int j = localResources.getDimensionPixelSize(2131492994);; j = localResources.getDimensionPixelSize(2131492994))
    {
      paramContext.setPadding(k, i, m, j);
      paramContext.setLayoutParams(localLayoutParams);
      return paramContext;
      i = AIOUtils.a(6.0F, localResources);
      break;
    }
  }
  
  public View b(Context paramContext, View paramView)
  {
    Resources localResources = paramContext.getResources();
    RelativeLayout localRelativeLayout;
    Object localObject1;
    label42:
    Object localObject2;
    Object localObject3;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      localRelativeLayout = (RelativeLayout)paramView;
      localRelativeLayout.removeAllViews();
      Iterator localIterator = this.a.iterator();
      paramView = null;
      localObject1 = null;
      if (!localIterator.hasNext()) {
        break label278;
      }
      localObject2 = (AbsStructMsgElement)localIterator.next();
      localObject3 = ((AbsStructMsgElement)localObject2).a;
      if (!"title".equals(localObject3)) {
        break label211;
      }
      localObject2 = (StructMsgItemTitle)localObject2;
      if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).b())) {
        break label344;
      }
      paramView = new TextView(paramContext);
      paramView.setText(((StructMsgItemTitle)localObject2).b());
      paramView.setId(2131296324);
      paramView.setTag(localObject2);
      paramView.setMaxLines(2);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(2, 16.0F);
      paramView.setBackgroundColor(paramContext.getResources().getColor(2131427390));
      paramView.setGravity(3);
      int i = AIOUtils.a(10.0F, localResources);
      int j = AIOUtils.a(8.0F, localResources);
      paramView.setPadding(i, j, i, j);
    }
    label211:
    label344:
    for (;;)
    {
      break label42;
      localRelativeLayout = a(paramContext);
      break;
      if ("picture".equals(localObject3))
      {
        localObject2 = ((AbsStructMsgElement)localObject2).a(paramContext, null);
        localObject3 = ((View)localObject2).findViewById(2131296323);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if ((localObject3 instanceof AnyScaleTypeImageView))
          {
            ((AnyScaleTypeImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
            localObject1 = localObject2;
          }
        }
      }
      continue;
      if (localObject1 != null) {
        localRelativeLayout.addView(localObject1, new RelativeLayout.LayoutParams(-1, (int)(TypedValue.applyDimension(1, 150.0F, localResources.getDisplayMetrics()) + 0.5F)));
      }
      if (paramView != null)
      {
        paramContext = new RelativeLayout.LayoutParams(-1, -2);
        paramContext.addRule(12);
        localRelativeLayout.addView(paramView, paramContext);
      }
      return localRelativeLayout;
    }
  }
  
  public String b()
  {
    return "Layout5";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5
 * JD-Core Version:    0.7.0.1
 */