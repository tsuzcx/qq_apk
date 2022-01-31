package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StructMsgItemLayout2
  extends AbsStructMsgItem
{
  public StructMsgItemLayout2()
  {
    this.l = 2;
  }
  
  public StructMsgItemLayout2(int paramInt)
  {
    super(paramInt);
    this.l = 2;
  }
  
  public StructMsgItemLayout2(Collection paramCollection)
  {
    super(paramCollection);
    this.l = 2;
  }
  
  private TextViewWrapLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    TextViewWrapLayout localTextViewWrapLayout = new TextViewWrapLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    int m = localResources.getDimensionPixelSize(2131492991);
    int n = localResources.getDimensionPixelSize(2131492992);
    int i = AIOUtils.a(5.0F, localResources);
    if (a(1)) {}
    for (int j = a(paramContext) + i;; j = i)
    {
      int k = i;
      if (a(2)) {
        k = i + a(paramContext);
      }
      localTextViewWrapLayout.setPadding(m, j, n, k);
      localTextViewWrapLayout.setLayoutParams(localLayoutParams);
      if (!TextUtils.isEmpty(this.c)) {
        localTextViewWrapLayout.setBackgroundResource(2130837928);
      }
      b(localTextViewWrapLayout);
      return localTextViewWrapLayout;
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    paramView.setVisibility(paramInt);
  }
  
  private void a(ViewGroup paramViewGroup, View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if ((paramViewGroup == null) || (paramView == null) || (paramLayoutParams == null)) {
      return;
    }
    paramViewGroup.addView(paramView, paramLayoutParams);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setMaxLines(paramInt);
  }
  
  public View b(Context paramContext, View paramView)
  {
    Resources localResources = paramContext.getResources();
    Object localObject8 = null;
    Object localObject3 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject7 = null;
    Object localObject2 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    int i;
    if ((paramView != null) && ((paramView instanceof TextViewWrapLayout)))
    {
      localObject5 = (TextViewWrapLayout)paramView;
      localObject6 = this.a.iterator();
      i = 0;
      paramView = (View)localObject4;
      if (((Iterator)localObject6).hasNext())
      {
        localObject4 = (AbsStructMsgElement)((Iterator)localObject6).next();
        localObject7 = ((AbsStructMsgElement)localObject4).a;
        if ((("picture".equals(localObject7)) || ("vote".equals(localObject7))) && (localObject3 == null))
        {
          localObject3 = ((AbsStructMsgElement)localObject4).a(paramContext, ((TextViewWrapLayout)localObject5).findViewById(2131296323));
          localObject4 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject4;
        }
      }
    }
    for (;;)
    {
      i += 1;
      localObject4 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break;
      if (("title".equals(localObject7)) && (localObject1 == null))
      {
        if ((localObject4 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject4).a(a(), this.j);
        }
        localObject4 = (TextView)((AbsStructMsgElement)localObject4).a(paramContext, ((TextViewWrapLayout)localObject5).findViewById(2131296324));
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else
      {
        if (localObject2 == null)
        {
          if (("summary".equals(localObject7)) || ("timer".equals(localObject7)))
          {
            localObject4 = (TextView)((AbsStructMsgElement)localObject4).a(paramContext, ((TextViewWrapLayout)localObject5).findViewById(2131296325));
            localObject2 = localObject1;
            localObject1 = localObject4;
            continue;
          }
          if ("checklist".equals(localObject7))
          {
            paramView = (LinearLayout)((AbsStructMsgElement)localObject4).a(paramContext, ((TextViewWrapLayout)localObject5).findViewById(2131296327));
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
            continue;
            paramContext = paramView;
            paramView = (View)localObject2;
            localObject3 = localObject5;
            localObject2 = localObject1;
            localObject1 = paramContext;
            paramContext = (Context)localObject3;
            i = 0;
            int k = 0;
            int j = i;
            if (localObject2 != null)
            {
              localObject3 = ((TextView)localObject2).getTag();
              j = i;
              if ((localObject3 instanceof StructMsgItemTitle))
              {
                localObject3 = (StructMsgItemTitle)localObject3;
                j = i;
                if (localObject3 != null)
                {
                  if (TextUtils.isEmpty(((StructMsgItemTitle)localObject3).b())) {
                    break label1276;
                  }
                  i = 1;
                  label403:
                  j = i;
                }
              }
            }
            i = k;
            if (paramView != null)
            {
              localObject3 = paramView.getTag();
              i = k;
              if ((localObject3 instanceof StructMsgItemSummary))
              {
                localObject3 = (StructMsgItemSummary)localObject3;
                i = k;
                if (localObject3 != null)
                {
                  if (TextUtils.isEmpty(((StructMsgItemSummary)localObject3).b())) {
                    break label1281;
                  }
                  i = 1;
                }
              }
            }
            label458:
            label503:
            boolean bool;
            if (localObject1 != null)
            {
              localObject1 = ((LinearLayout)localObject1).getTag();
              if ((localObject1 instanceof StructMsgItemVote))
              {
                localObject1 = ((StructMsgItemVote)localObject1).a;
                if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
                {
                  i = 1;
                  if (j == 0) {
                    break label1291;
                  }
                  a((TextView)localObject2, 2);
                  a((View)localObject2, 0);
                  a(paramView, 2);
                  label528:
                  if (i == 0) {
                    break label1308;
                  }
                  a(paramView, 0);
                  label538:
                  if (this.i == 1)
                  {
                    if ((paramView instanceof TextView)) {
                      a(paramView, 1);
                    }
                    if ((localObject2 instanceof TextView)) {
                      a((TextView)localObject2, 1);
                    }
                  }
                  if (this.i != 1) {
                    break label1318;
                  }
                  bool = false;
                  label585:
                  paramContext.a(bool);
                  return paramContext;
                  localObject4 = a(paramContext);
                  Iterator localIterator = this.a.iterator();
                  localObject3 = localObject8;
                  localObject2 = localObject7;
                  localObject1 = localObject6;
                  paramView = (View)localObject5;
                  label624:
                  if (localIterator.hasNext())
                  {
                    localObject5 = (AbsStructMsgElement)localIterator.next();
                    localObject6 = ((AbsStructMsgElement)localObject5).a;
                    if ((("picture".equals(localObject6)) || ("vote".equals(localObject6))) && (localObject3 == null))
                    {
                      localObject3 = ((AbsStructMsgElement)localObject5).a(paramContext, null);
                      localObject5 = localObject2;
                      localObject6 = localObject1;
                      localObject2 = paramView;
                      localObject1 = localObject5;
                      paramView = (View)localObject6;
                    }
                  }
                }
              }
            }
            for (;;)
            {
              localObject5 = localObject1;
              localObject1 = paramView;
              paramView = (View)localObject2;
              localObject2 = localObject5;
              break label624;
              if (("title".equals(localObject6)) && (paramView == null))
              {
                if ((localObject5 instanceof StructMsgItemTitle)) {
                  ((StructMsgItemTitle)localObject5).a(a(), this.j);
                }
                localObject5 = (TextView)((AbsStructMsgElement)localObject5).a(paramContext, null);
                paramView = (View)localObject1;
                localObject1 = localObject2;
                localObject2 = localObject5;
              }
              else
              {
                if (localObject2 == null)
                {
                  if (("summary".equals(localObject6)) || ("timer".equals(localObject6)))
                  {
                    localObject5 = (TextView)((AbsStructMsgElement)localObject5).a(paramContext, null);
                    localObject2 = paramView;
                    paramView = (View)localObject1;
                    localObject1 = localObject5;
                    continue;
                  }
                  if ("checklist".equals(localObject6))
                  {
                    localObject6 = (LinearLayout)((AbsStructMsgElement)localObject5).a(paramContext, null);
                    localObject5 = paramView;
                    localObject1 = localObject2;
                    paramView = (View)localObject6;
                    localObject2 = localObject5;
                    continue;
                    if (localObject3 == null)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e("StructMsg", 2, "generate 2 item failure.");
                      }
                      return null;
                    }
                    if (paramView == null)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e("StructMsg", 2, "generate 2 item titleview failure.");
                      }
                      return null;
                    }
                    if (this.i == 1)
                    {
                      localObject5 = new RelativeLayout.LayoutParams(AIOUtils.a(45.0F, localResources), AIOUtils.a(45.0F, localResources));
                      ((RelativeLayout.LayoutParams)localObject5).topMargin = AIOUtils.a(2.0F, localResources);
                    }
                    for (;;)
                    {
                      ((RelativeLayout.LayoutParams)localObject5).addRule(9);
                      ((RelativeLayout.LayoutParams)localObject5).addRule(10);
                      ((TextViewWrapLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject5);
                      i = AIOUtils.a(10.0F, localResources);
                      localObject5 = new RelativeLayout.LayoutParams(-1, -2);
                      ((RelativeLayout.LayoutParams)localObject5).topMargin = 0;
                      ((RelativeLayout.LayoutParams)localObject5).addRule(10);
                      localObject6 = new RelativeLayout.LayoutParams(-1, -2);
                      ((RelativeLayout.LayoutParams)localObject6).topMargin = 0;
                      ((RelativeLayout.LayoutParams)localObject6).addRule(3, paramView.getId());
                      if (this.i != 1) {
                        break label1171;
                      }
                      paramContext = new RelativeLayout(paramContext);
                      localObject7 = new RelativeLayout.LayoutParams(-1, -2);
                      ((RelativeLayout.LayoutParams)localObject7).addRule(15);
                      ((RelativeLayout.LayoutParams)localObject7).addRule(1, ((View)localObject3).getId());
                      ((RelativeLayout.LayoutParams)localObject7).leftMargin = i;
                      a(paramContext, paramView, (RelativeLayout.LayoutParams)localObject5);
                      a(paramContext, (View)localObject2, (RelativeLayout.LayoutParams)localObject6);
                      a(paramContext, (View)localObject1, (RelativeLayout.LayoutParams)localObject6);
                      ((TextViewWrapLayout)localObject4).addView(paramContext, (ViewGroup.LayoutParams)localObject7);
                      localObject3 = paramView;
                      paramContext = (Context)localObject4;
                      paramView = (View)localObject2;
                      localObject2 = localObject3;
                      break;
                      localObject5 = new RelativeLayout.LayoutParams(AIOUtils.a(70.0F, localResources), AIOUtils.a(70.0F, localResources));
                    }
                    label1171:
                    ((RelativeLayout.LayoutParams)localObject6).leftMargin = i;
                    ((RelativeLayout.LayoutParams)localObject5).leftMargin = i;
                    ((RelativeLayout.LayoutParams)localObject5).addRule(1, ((View)localObject3).getId());
                    ((RelativeLayout.LayoutParams)localObject5).addRule(11);
                    ((RelativeLayout.LayoutParams)localObject5).addRule(6, ((View)localObject3).getId());
                    ((RelativeLayout.LayoutParams)localObject6).addRule(11);
                    ((RelativeLayout.LayoutParams)localObject6).addRule(1, ((View)localObject3).getId());
                    a((ViewGroup)localObject4, paramView, (RelativeLayout.LayoutParams)localObject5);
                    a((ViewGroup)localObject4, (View)localObject2, (RelativeLayout.LayoutParams)localObject6);
                    a((ViewGroup)localObject4, (View)localObject1, (RelativeLayout.LayoutParams)localObject6);
                    localObject3 = paramView;
                    paramContext = (Context)localObject4;
                    paramView = (View)localObject2;
                    localObject2 = localObject3;
                    break;
                    label1276:
                    i = 0;
                    break label403;
                    label1281:
                    i = 0;
                    break label458;
                    i = 0;
                    break label503;
                    label1291:
                    a((View)localObject2, 8);
                    a(paramView, 4);
                    break label528;
                    label1308:
                    a(paramView, 8);
                    break label538;
                    label1318:
                    bool = true;
                    break label585;
                    break label503;
                  }
                }
                localObject5 = paramView;
                paramView = (View)localObject1;
                localObject1 = localObject2;
                localObject2 = localObject5;
              }
            }
          }
        }
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
    }
  }
  
  public String b()
  {
    return "Layout2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2
 * JD-Core Version:    0.7.0.1
 */