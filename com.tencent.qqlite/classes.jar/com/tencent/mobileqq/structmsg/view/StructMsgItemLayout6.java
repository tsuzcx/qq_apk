package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement.RichText;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StructMsgItemLayout6
  extends AbsStructMsgItem
{
  public static final int m = 1;
  
  public StructMsgItemLayout6()
  {
    this.l = 6;
  }
  
  public StructMsgItemLayout6(int paramInt)
  {
    super(paramInt);
    this.l = 6;
  }
  
  public StructMsgItemLayout6(Collection paramCollection)
  {
    super(paramCollection);
    this.l = 6;
  }
  
  private LinearLayout a(Context paramContext)
  {
    int j = 0;
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int k = localResources.getDimensionPixelSize(2131492991);
    int n = localResources.getDimensionPixelSize(2131492992);
    if (a(1)) {}
    for (int i = localResources.getDimensionPixelSize(2131492993);; i = 0)
    {
      if (a(2)) {
        j = localResources.getDimensionPixelSize(2131492994);
      }
      paramContext.setPadding(k, i, n, j);
      paramContext.setLayoutParams(localLayoutParams);
      return paramContext;
    }
  }
  
  private void a(Context paramContext, Resources paramResources, LinearLayout paramLinearLayout, int paramInt)
  {
    Object localObject1;
    if ((paramLinearLayout != null) && (paramLinearLayout.getChildCount() == this.a.size()))
    {
      paramResources = this.a.iterator();
      paramInt = 0;
      if (paramResources.hasNext())
      {
        localObject1 = (AbsStructMsgElement)paramResources.next();
        if ((localObject1 instanceof StructMsgItemTitle))
        {
          ((StructMsgItemTitle)localObject1).a(a(), this.j);
          ((StructMsgItemTitle)localObject1).a(false);
        }
        for (;;)
        {
          ((AbsStructMsgElement)localObject1).a(paramContext, paramLinearLayout.getChildAt(paramInt));
          paramInt += 1;
          break;
          if ((localObject1 instanceof StructMsgItemSummary)) {
            ((StructMsgItemSummary)localObject1).a();
          }
        }
      }
    }
    else
    {
      paramLinearLayout.removeAllViews();
      localObject1 = this.a.iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
        Object localObject3 = ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject3))
        {
          if ((localObject2 instanceof StructMsgItemTitle))
          {
            ((StructMsgItemTitle)localObject2).a(a(), this.j);
            ((StructMsgItemTitle)localObject2).a(false);
          }
          localObject2 = ((AbsStructMsgElement)localObject2).a(paramContext, null);
          localObject3 = new LinearLayout.LayoutParams(-2, -2);
          if (i > 0) {
            ((LinearLayout.LayoutParams)localObject3).topMargin = paramInt;
          }
          if (this.a.size() == 1) {
            ((LinearLayout.LayoutParams)localObject3).bottomMargin = paramInt;
          }
          paramLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
        for (;;)
        {
          i += 1;
          break;
          if ("hr".equals(localObject3))
          {
            localObject2 = ((AbsStructMsgElement)localObject2).a(paramContext, null);
            localObject3 = new LinearLayout.LayoutParams(-1, 1);
            if (i > 0) {
              ((LinearLayout.LayoutParams)localObject3).topMargin = paramInt;
            }
            paramLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
          else if ("summary".equals(localObject3))
          {
            if ((localObject2 instanceof AbsStructMsgTextElement)) {
              ((StructMsgItemSummary)localObject2).a();
            }
            localObject2 = ((AbsStructMsgElement)localObject2).a(paramContext, null);
            localObject3 = new LinearLayout.LayoutParams(-2, -2);
            if (i > 0) {
              ((LinearLayout.LayoutParams)localObject3).topMargin = paramInt;
            }
            paramLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
          else if ("timer".equals(localObject3))
          {
            localObject2 = ((AbsStructMsgElement)localObject2).a(paramContext, null);
            localObject3 = new LinearLayout.LayoutParams(-2, -2);
            if (i > 0) {
              ((LinearLayout.LayoutParams)localObject3).topMargin = paramInt;
            }
            paramLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
          else if ("picture".equals(localObject3))
          {
            localObject2 = ((AbsStructMsgElement)localObject2).a(paramContext, null);
            localObject3 = ((View)localObject2).findViewById(2131296323);
            if ((localObject3 != null) && ((localObject3 instanceof AnyScaleTypeImageView))) {
              ((AnyScaleTypeImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            localObject3 = new LinearLayout.LayoutParams(-1, AIOUtils.a(150.0F, paramResources));
            if (i > 0) {
              ((LinearLayout.LayoutParams)localObject3).topMargin = paramInt;
            }
            ((LinearLayout.LayoutParams)localObject3).topMargin += AIOUtils.a(4.0F, paramResources);
            ((LinearLayout.LayoutParams)localObject3).bottomMargin += AIOUtils.a(4.0F, paramResources);
            paramLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
          else if ("more".equals(localObject3))
          {
            localObject2 = ((AbsStructMsgElement)localObject2).a(paramContext, null);
            localObject3 = new LinearLayout.LayoutParams(-1, -2);
            if (i > 0) {
              ((LinearLayout.LayoutParams)localObject3).topMargin = paramInt;
            }
            paramLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
          else if ("item".equals(localObject3))
          {
            paramLinearLayout.addView(((AbsStructMsgElement)localObject2).a(paramContext, null));
          }
          else if ("price".equals(localObject3))
          {
            paramLinearLayout.addView(((AbsStructMsgElement)localObject2).a(paramContext, null));
          }
        }
      }
    }
  }
  
  private void a(Context paramContext, Resources paramResources, LinearLayout paramLinearLayout, int paramInt, View paramView)
  {
    Object localObject1 = new StringBuffer();
    Object localObject2 = new ArrayList();
    Object localObject3 = this.a.iterator();
    int j;
    for (int i = -1; ((Iterator)localObject3).hasNext(); i = j)
    {
      Object localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
      j = i;
      if ((localObject4 instanceof AbsStructMsgTextElement))
      {
        localObject4 = ((AbsStructMsgTextElement)localObject4).a(paramResources);
        j = i;
        if (localObject4 != null)
        {
          ((AbsStructMsgTextElement.RichText)localObject4).d = (i + 1);
          ((AbsStructMsgTextElement.RichText)localObject4).e = (((AbsStructMsgTextElement.RichText)localObject4).d + ((AbsStructMsgTextElement.RichText)localObject4).jdField_a_of_type_JavaLangString.length());
          j = i + ((AbsStructMsgTextElement.RichText)localObject4).jdField_a_of_type_JavaLangString.length();
          ((StringBuffer)localObject1).append(((AbsStructMsgTextElement.RichText)localObject4).jdField_a_of_type_JavaLangString);
          ((ArrayList)localObject2).add(localObject4);
        }
      }
    }
    localObject1 = new SpannableStringBuilder(((StringBuffer)localObject1).toString());
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (AbsStructMsgTextElement.RichText)((Iterator)localObject2).next();
      ((SpannableStringBuilder)localObject1).setSpan(new TextAppearanceSpan(null, ((AbsStructMsgTextElement.RichText)localObject3).b, (int)TypedValue.applyDimension(2, ((AbsStructMsgTextElement.RichText)localObject3).c, paramResources.getDisplayMetrics()), ColorStateList.valueOf(((AbsStructMsgTextElement.RichText)localObject3).jdField_a_of_type_Int), null), ((AbsStructMsgTextElement.RichText)localObject3).d, ((AbsStructMsgTextElement.RichText)localObject3).e, 33);
    }
    if ((paramView != null) && ((paramView instanceof TextView))) {
      paramContext = (TextView)paramView;
    }
    for (;;)
    {
      paramContext.setText((CharSequence)localObject1);
      paramContext.requestLayout();
      return;
      paramResources = new LinearLayout.LayoutParams(-2, -2);
      paramContext = new TextView(paramContext);
      paramContext.setLineSpacing(paramInt, 1.0F);
      paramLinearLayout.addView(paramContext, paramResources);
    }
  }
  
  public View b(Context paramContext, View paramView)
  {
    Resources localResources = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout))) {}
    int i;
    for (paramView = (LinearLayout)paramView;; paramView = a(paramContext))
    {
      i = paramView.getPaddingTop();
      int j = paramView.getPaddingBottom();
      int k = paramView.getPaddingLeft();
      int n = paramView.getPaddingRight();
      a(paramView);
      b(paramView);
      paramView.setPadding(k, i, n, j);
      i = AIOUtils.a(8.0F, localResources);
      if (this.i != 1) {
        break;
      }
      a(paramContext, localResources, paramView, i, paramView.getChildAt(0));
      return paramView;
    }
    a(paramContext, localResources, paramView, i);
    return paramView;
  }
  
  public String b()
  {
    return "Layout6";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6
 * JD-Core Version:    0.7.0.1
 */