import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class antd
  extends anqv
{
  protected boolean cJU;
  
  private TextViewWrapLayout a(Context paramContext)
  {
    paramContext = new TextViewWrapLayout(paramContext);
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    if (!TextUtils.isEmpty(this.cgX)) {
      paramContext.setBackgroundResource(2130839682);
    }
    hI(paramContext);
    return paramContext;
  }
  
  private void a(ViewGroup paramViewGroup, View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if ((paramViewGroup == null) || (paramView == null) || (paramLayoutParams == null)) {
      return;
    }
    paramViewGroup.addView(paramView, paramLayoutParams);
  }
  
  private void as(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    paramView.setVisibility(paramInt);
  }
  
  private void b(Context paramContext, ViewGroup paramViewGroup)
  {
    Resources localResources = paramContext.getResources();
    int m = localResources.getDimensionPixelSize(2131299517);
    int n = localResources.getDimensionPixelSize(2131299518);
    int i = wja.dp2px(5.0F, localResources);
    if (lI(1)) {}
    for (int j = t(paramContext, 10) + i;; j = i)
    {
      int k = i;
      if (lI(2)) {
        k = i + t(paramContext, 10);
      }
      paramViewGroup.setPadding(m, j, n, k);
      return;
    }
  }
  
  private void c(Context paramContext, ViewGroup paramViewGroup)
  {
    if (!this.cJU)
    {
      paramContext = paramContext.getResources();
      int i = wja.dp2px(11.0F, paramContext);
      int j = wja.dp2px(14.0F, paramContext);
      paramViewGroup.setPadding(j, i, j, wja.dp2px(12.0F, paramContext));
    }
  }
  
  private void g(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {}
    while (paramInt <= 0) {
      return;
    }
    paramTextView.setMaxLines(paramInt);
  }
  
  protected int IX()
  {
    return 2;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject9 = paramContext.getResources();
    this.cJU = paramBundle.getBoolean("pre_dialog", false);
    Object localObject8 = null;
    Object localObject3 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    Object localObject7 = null;
    Object localObject1 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject10 = this.rz.iterator();
    while (((Iterator)localObject10).hasNext())
    {
      Object localObject11 = (anqu)((Iterator)localObject10).next();
      if ((localObject11 instanceof ansr))
      {
        localObject11 = (ansr)localObject11;
        if (((ansr)localObject11).mPicWidth == ansr.dMt) {
          ((ansr)localObject11).mPicWidth = ansr.dMr;
        }
      }
    }
    if ((paramView != null) && ((paramView instanceof TextViewWrapLayout)))
    {
      localObject8 = (TextViewWrapLayout)paramView;
      localObject9 = this.rz.iterator();
      paramView = (View)localObject4;
      localObject5 = localObject2;
      localObject7 = paramView;
      localObject6 = localObject1;
      localObject4 = localObject8;
      if (!((Iterator)localObject9).hasNext()) {
        break label967;
      }
      localObject4 = (anqu)((Iterator)localObject9).next();
      ((anqu)localObject4).hU = this.hU;
      localObject5 = ((anqu)localObject4).mTypeName;
      if ((("picture".equals(localObject5)) || ("vote".equals(localObject5)) || ("video".equals(localObject5))) && (localObject3 == null)) {
        localObject3 = ((anqu)localObject4).a(paramContext, ((TextViewWrapLayout)localObject8).findViewById(2131369004), paramBundle);
      }
    }
    for (;;)
    {
      break;
      if (("title".equals(localObject5)) && (localObject2 == null))
      {
        if ((localObject4 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject4).bA(ayW(), this.dMj);
        }
        localObject2 = (TextView)((anqu)localObject4).a(paramContext, ((TextViewWrapLayout)localObject8).findViewById(2131380976), paramBundle);
      }
      else if (localObject1 == null)
      {
        if (("summary".equals(localObject5)) || ("timer".equals(localObject5)))
        {
          localObject1 = (TextView)((anqu)localObject4).a(paramContext, ((TextViewWrapLayout)localObject8).findViewById(2131380951), paramBundle);
        }
        else if ("checklist".equals(localObject5))
        {
          paramView = (LinearLayout)((anqu)localObject4).a(paramContext, ((TextViewWrapLayout)localObject8).findViewById(2131380601), paramBundle);
          continue;
          localObject4 = a(paramContext);
          localObject10 = this.rz.iterator();
          localObject3 = localObject8;
          localObject1 = localObject7;
          paramView = (View)localObject6;
          localObject2 = localObject5;
          if (((Iterator)localObject10).hasNext())
          {
            localObject5 = (anqu)((Iterator)localObject10).next();
            ((anqu)localObject5).hU = this.hU;
            localObject6 = ((anqu)localObject5).mTypeName;
            if ((("picture".equals(localObject6)) || ("vote".equals(localObject6)) || ("video".equals(localObject6))) && (localObject3 == null)) {
              localObject3 = ((anqu)localObject5).a(paramContext, null, paramBundle);
            }
          }
          for (;;)
          {
            break;
            if (("title".equals(localObject6)) && (localObject2 == null))
            {
              if ((localObject5 instanceof StructMsgItemTitle)) {
                ((StructMsgItemTitle)localObject5).bA(ayW(), this.dMj);
              }
              localObject2 = (TextView)((anqu)localObject5).a(paramContext, null, paramBundle);
            }
            else if (localObject1 == null)
            {
              if (("summary".equals(localObject6)) || ("timer".equals(localObject6)))
              {
                localObject1 = (TextView)((anqu)localObject5).a(paramContext, null, paramBundle);
              }
              else if ("checklist".equals(localObject6))
              {
                paramView = (LinearLayout)((anqu)localObject5).a(paramContext, null, paramBundle);
                continue;
                if (localObject3 == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("StructMsg", 2, "generate 2 item failure.");
                  }
                  paramContext = null;
                  return paramContext;
                }
                localObject5 = localObject2;
                if (localObject2 == null)
                {
                  localObject5 = localObject2;
                  if (localObject1 != null) {
                    localObject5 = (TextView)new StructMsgItemTitle(((TextView)localObject1).getText().toString()).a(paramContext, null, paramBundle);
                  }
                }
                if (localObject5 == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("StructMsg", 2, "generate 2 item titleview failure.");
                  }
                  return null;
                }
                localObject6 = new RelativeLayout.LayoutParams(-1, -2);
                ((RelativeLayout.LayoutParams)localObject6).topMargin = 0;
                ((RelativeLayout.LayoutParams)localObject6).addRule(10);
                localObject7 = new RelativeLayout.LayoutParams(-1, -2);
                ((RelativeLayout.LayoutParams)localObject7).addRule(3, ((TextView)localObject5).getId());
                label819:
                label881:
                int i;
                label967:
                label990:
                int j;
                if ((this.dMi == 1) || (this.dMi == 3)) {
                  if (this.dMi == 1)
                  {
                    localObject2 = new RelativeLayout.LayoutParams(wja.dp2px(50.0F, (Resources)localObject9), wja.dp2px(50.0F, (Resources)localObject9));
                    ((RelativeLayout.LayoutParams)localObject2).topMargin = wja.dp2px(3.0F, (Resources)localObject9);
                    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
                    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                    localObject8 = new RelativeLayout(paramContext);
                    localObject10 = new RelativeLayout.LayoutParams(-1, -2);
                    if (this.dMi != 3) {
                      break label1400;
                    }
                    ((RelativeLayout.LayoutParams)localObject10).topMargin = wja.dp2px(12.0F, (Resources)localObject9);
                    ((RelativeLayout.LayoutParams)localObject7).topMargin = 5;
                    ((RelativeLayout.LayoutParams)localObject10).addRule(10);
                    ((RelativeLayout.LayoutParams)localObject10).addRule(1, ((View)localObject3).getId());
                    ((RelativeLayout.LayoutParams)localObject10).leftMargin = wja.dp2px(10.0F, (Resources)localObject9);
                    a((ViewGroup)localObject4, (View)localObject3, (RelativeLayout.LayoutParams)localObject2);
                    a((ViewGroup)localObject8, (View)localObject5, (RelativeLayout.LayoutParams)localObject6);
                    a((ViewGroup)localObject8, (View)localObject1, (RelativeLayout.LayoutParams)localObject7);
                    a((ViewGroup)localObject8, paramView, (RelativeLayout.LayoutParams)localObject7);
                    ((TextViewWrapLayout)localObject4).addView((View)localObject8, (ViewGroup.LayoutParams)localObject10);
                    localObject6 = localObject1;
                    localObject7 = paramView;
                    if ((this.dMi != 1) && (this.dMi != 3)) {
                      break label1715;
                    }
                    b(paramContext, (ViewGroup)localObject4);
                    i = 0;
                    int k = 0;
                    j = i;
                    if (localObject5 != null)
                    {
                      paramContext = ((TextView)localObject5).getTag();
                      j = i;
                      if ((paramContext instanceof StructMsgItemTitle))
                      {
                        paramContext = (StructMsgItemTitle)paramContext;
                        j = i;
                        if (paramContext != null)
                        {
                          if (TextUtils.isEmpty(paramContext.getText())) {
                            break label1725;
                          }
                          i = 1;
                          label1048:
                          j = i;
                        }
                      }
                    }
                    i = k;
                    if (localObject6 != null)
                    {
                      paramContext = ((TextView)localObject6).getTag();
                      i = k;
                      if ((paramContext instanceof anux))
                      {
                        paramContext = (anux)paramContext;
                        i = k;
                        if (paramContext != null)
                        {
                          if (TextUtils.isEmpty(paramContext.getText())) {
                            break label1731;
                          }
                          i = 1;
                        }
                      }
                    }
                    label1104:
                    if (localObject7 == null) {
                      break label1811;
                    }
                    paramContext = ((LinearLayout)localObject7).getTag();
                    if (!(paramContext instanceof anvl)) {
                      break label1811;
                    }
                    paramContext = ((anvl)paramContext).AU;
                    if ((paramContext == null) || (paramContext.isEmpty())) {
                      break label1737;
                    }
                    i = 1;
                  }
                }
                label1801:
                label1811:
                for (;;)
                {
                  label1144:
                  if (j != 0)
                  {
                    g((TextView)localObject5, 2);
                    as((View)localObject5, 0);
                    g((TextView)localObject6, 2);
                    if ((this.dMi == 1) || (this.dMi == 3))
                    {
                      ((TextView)localObject5).setTextSize(16.0F);
                      if (i == 0) {
                        break label1790;
                      }
                      as((View)localObject6, 0);
                      if ((this.dMi != 1) && (this.dMi != 3)) {
                        break label1801;
                      }
                      if (localObject6 != null) {
                        ((TextView)localObject6).setSingleLine(true);
                      }
                      if (localObject5 != null)
                      {
                        ((TextView)localObject5).setSingleLine(true);
                        ((TextView)localObject5).setMaxLines(1);
                      }
                    }
                  }
                  for (;;)
                  {
                    label1194:
                    label1206:
                    paramContext = (Context)localObject4;
                    if (!AppSetting.enableTalkBack) {
                      break;
                    }
                    paramContext = new StringBuilder();
                    if (localObject5 != null) {
                      paramContext.append(((TextView)localObject5).getText());
                    }
                    i = paramBundle.getInt("serviceID", 0);
                    if ((localObject6 != null) && ((i == 32) || (i == 14) || (i == 15) || (i == 16) || (i == 17))) {
                      paramContext.append(",").append(((TextView)localObject6).getText());
                    }
                    ((TextViewWrapLayout)localObject4).setContentDescription(paramContext.toString());
                    return localObject4;
                    localObject2 = new RelativeLayout.LayoutParams(wja.dp2px(115.0F, (Resources)localObject9), wja.dp2px(70.0F, (Resources)localObject9));
                    ((RelativeLayout.LayoutParams)localObject2).topMargin = wja.dp2px(3.0F, (Resources)localObject9);
                    break label819;
                    label1400:
                    ((RelativeLayout.LayoutParams)localObject10).topMargin = wja.dp2px(7.0F, (Resources)localObject9);
                    ((RelativeLayout.LayoutParams)localObject7).topMargin = 0;
                    break label881;
                    if (!this.cJU)
                    {
                      if (localObject1 != null) {
                        ((TextView)localObject1).setLineSpacing(wja.dp2px(1.0F, (Resources)localObject9), 1.0F);
                      }
                      localObject2 = new RelativeLayout.LayoutParams(wja.dp2px(50.0F, (Resources)localObject9), wja.dp2px(50.0F, (Resources)localObject9));
                      ((RelativeLayout.LayoutParams)localObject2).topMargin = wja.dp2px(7.0F, (Resources)localObject9);
                      ((RelativeLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(10.0F, (Resources)localObject9);
                      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((TextView)localObject5).getId());
                      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                      ((RelativeLayout.LayoutParams)localObject7).topMargin = wja.dp2px(5.0F, (Resources)localObject9);
                      ((RelativeLayout.LayoutParams)localObject7).addRule(0, ((View)localObject3).getId());
                      a((ViewGroup)localObject4, (View)localObject5, (RelativeLayout.LayoutParams)localObject6);
                      a((ViewGroup)localObject4, (View)localObject3, (RelativeLayout.LayoutParams)localObject2);
                      a((ViewGroup)localObject4, (View)localObject1, (RelativeLayout.LayoutParams)localObject7);
                      a((ViewGroup)localObject4, paramView, (RelativeLayout.LayoutParams)localObject7);
                      localObject7 = paramView;
                      localObject6 = localObject1;
                      break label967;
                    }
                    localObject2 = new RelativeLayout.LayoutParams(wja.dp2px(32.0F, (Resources)localObject9), wja.dp2px(32.0F, (Resources)localObject9));
                    ((RelativeLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(6.0F, (Resources)localObject9);
                    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
                    i = aqnm.dip2px(20.0F);
                    ((RelativeLayout.LayoutParams)localObject6).topMargin = i;
                    ((RelativeLayout.LayoutParams)localObject6).bottomMargin = i;
                    ((RelativeLayout.LayoutParams)localObject6).addRule(0, ((View)localObject3).getId());
                    ((RelativeLayout.LayoutParams)localObject6).addRule(9);
                    ((RelativeLayout.LayoutParams)localObject6).addRule(15);
                    a((ViewGroup)localObject4, (View)localObject3, (RelativeLayout.LayoutParams)localObject2);
                    a((ViewGroup)localObject4, (View)localObject5, (RelativeLayout.LayoutParams)localObject6);
                    localObject7 = paramView;
                    localObject6 = localObject1;
                    break label967;
                    label1715:
                    c(paramContext, (ViewGroup)localObject4);
                    break label990;
                    label1725:
                    i = 0;
                    break label1048;
                    label1731:
                    i = 0;
                    break label1104;
                    label1737:
                    i = 0;
                    break label1144;
                    if (!this.cJU) {}
                    for (float f = 17.0F;; f = 14.0F)
                    {
                      ((TextView)localObject5).setTextSize(f);
                      break;
                    }
                    as((View)localObject5, 8);
                    g((TextView)localObject6, 4);
                    break label1194;
                    label1790:
                    as((View)localObject6, 8);
                    break label1206;
                    g((TextView)localObject6, 3);
                  }
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
    return "Layout2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antd
 * JD-Core Version:    0.7.0.1
 */