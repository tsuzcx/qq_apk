import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.FixRatioPAHighLightImageView;
import com.tencent.mobileqq.widget.PAImageView;
import java.util.ArrayList;
import java.util.Iterator;

public class anub
  extends anqv
{
  public static int dMA = 200;
  public static int dMB = 300;
  public static int dMC = 400;
  public static int dMz = 100;
  private boolean cJY;
  
  private void a(Context paramContext, Resources paramResources, LinearLayout paramLinearLayout, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    int k = paramResources.getDimensionPixelSize(2131296465);
    int m = paramResources.getDimensionPixelSize(2131296466);
    Object localObject1 = paramBundle.getString("sType");
    Object localObject2;
    label157:
    Object localObject3;
    int i;
    int j;
    label222:
    Object localObject4;
    if (((localObject1 == null) || (!((String)localObject1).equals("1"))) || (paramLinearLayout.getChildCount() == this.rz.size()))
    {
      localObject1 = this.rz.iterator();
      paramInt = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (anqu)((Iterator)localObject1).next();
        ((anqu)localObject2).hU = this.hU;
        if ((localObject2 instanceof StructMsgItemTitle))
        {
          ((StructMsgItemTitle)localObject2).bA(ayW(), this.dMj);
          ((StructMsgItemTitle)localObject2).setSingleLine(false);
          if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).As())) {
            ((StructMsgItemTitle)localObject2).fK(String.valueOf(36));
          }
          localObject3 = paramLinearLayout.getChildAt(paramInt);
          ((anqu)localObject2).a(paramContext, (View)localObject3, paramBundle);
          i = ((View)localObject3).getPaddingTop();
          j = ((View)localObject3).getPaddingBottom();
          if (paramBoolean)
          {
            if ((!(localObject2 instanceof ansr)) && (!(localObject2 instanceof anst))) {
              break label431;
            }
            ((View)localObject3).setPadding(0, i, 0, j);
          }
          if (!(localObject2 instanceof StructMsgItemTitle)) {
            break label467;
          }
          if ((paramBoolean) && (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).At()))) {
            ((TextView)localObject3).setTypeface(Typeface.DEFAULT, 1);
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if (!(localObject2 instanceof anux)) {
            break label157;
          }
          localObject3 = (anux)localObject2;
          ((anux)localObject3).dTu();
          if ((localObject3 != null) && ((((anux)localObject3).As() == null) || (((anux)localObject3).As().equals("")))) {
            ((anux)localObject3).fK(String.valueOf(28));
          }
          localObject4 = ((anux)localObject3).Au();
          if ((localObject4 != null) && (((String)localObject4).equals("1")))
          {
            ((anux)localObject3).fK(String.valueOf(24));
            if ((!paramBoolean) || (!TextUtils.isEmpty(((anux)localObject3).getTextColor()))) {
              break label157;
            }
            ((anux)localObject3).setTextColor("#8e8e8e");
            break label157;
          }
          if (!paramBoolean) {
            break label157;
          }
          if (TextUtils.isEmpty(((anux)localObject3).As())) {
            ((anux)localObject3).fK(String.valueOf(32));
          }
          if (!TextUtils.isEmpty(((anux)localObject3).getTextColor())) {
            break label157;
          }
          ((anux)localObject3).setTextColor("#000000");
          break label157;
          label431:
          if ((localObject2 instanceof anru))
          {
            ((View)localObject3).setPadding(0, 0, 0, 0);
            break label222;
          }
          ((View)localObject3).setPadding(k, i, m, j);
          break label222;
          label467:
          if (((localObject2 instanceof anux)) && (paramBoolean)) {
            ((TextView)localObject3).setLineSpacing(wja.dp2px(2.0F, paramResources), 1.0F);
          }
        }
      }
    }
    else
    {
      paramLinearLayout.removeAllViews();
      localObject2 = this.rz.iterator();
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (anqu)((Iterator)localObject2).next();
        ((anqu)localObject1).hU = this.hU;
        localObject3 = ((anqu)localObject1).mTypeName;
        if ("title".equals(localObject3))
        {
          if ((localObject1 instanceof StructMsgItemTitle))
          {
            ((StructMsgItemTitle)localObject1).bA(ayW(), this.dMj);
            ((StructMsgItemTitle)localObject1).setSingleLine(false);
            if (TextUtils.isEmpty(((StructMsgItemTitle)localObject1).As())) {
              ((StructMsgItemTitle)localObject1).fK(String.valueOf(36));
            }
          }
          localObject3 = ((anqu)localObject1).a(paramContext, null, paramBundle);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).topMargin = wja.dp2px(2.5F, paramResources);
          ((LinearLayout.LayoutParams)localObject4).bottomMargin = wja.dp2px(1.5F, paramResources);
          if ((lI(1)) && (i == 0)) {
            ((LinearLayout.LayoutParams)localObject4).topMargin = wja.dp2px(20.0F, paramResources);
          }
          if (paramBoolean)
          {
            ((View)localObject3).setPadding(k, ((View)localObject3).getPaddingTop(), m, ((View)localObject3).getPaddingBottom());
            if (TextUtils.isEmpty(((StructMsgItemTitle)localObject1).At())) {
              ((TextView)localObject3).setTypeface(Typeface.DEFAULT, 1);
            }
          }
          paramLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
        }
        for (;;)
        {
          i += 1;
          break;
          if ("hr".equals(localObject3))
          {
            localObject1 = ((anqu)localObject1).a(paramContext, null, paramBundle);
            localObject3 = new LinearLayout.LayoutParams(-1, 1);
            if (i > 0) {
              ((LinearLayout.LayoutParams)localObject3).topMargin = wja.dp2px(7.5F, paramResources);
            }
            if (paramBoolean)
            {
              ((LinearLayout.LayoutParams)localObject3).leftMargin = k;
              ((LinearLayout.LayoutParams)localObject3).rightMargin = m;
            }
            if (localObject1 != null) {
              paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
            }
          }
          else
          {
            if ("summary".equals(localObject3))
            {
              if ((localObject1 instanceof anqw))
              {
                localObject3 = (anux)localObject1;
                ((anux)localObject3).dTu();
                if ((localObject3 != null) && ((((anux)localObject3).As() == null) || (((anux)localObject3).As().equals("")))) {
                  ((anux)localObject3).fK(String.valueOf(28));
                }
                localObject4 = ((anux)localObject1).Au();
                if ((localObject4 == null) || (!((String)localObject4).equals("1"))) {
                  break label1100;
                }
                ((anux)localObject3).fK(String.valueOf(24));
                if ((paramBoolean) && (TextUtils.isEmpty(((anux)localObject3).getTextColor()))) {
                  ((anux)localObject3).setTextColor("#8e8e8e");
                }
              }
              for (;;)
              {
                localObject1 = ((anqu)localObject1).a(paramContext, null, paramBundle);
                if (paramBoolean) {
                  ((TextView)localObject1).setLineSpacing(wja.dp2px(2.0F, paramResources), 1.0F);
                }
                localObject3 = new LinearLayout.LayoutParams(-2, -2);
                ((LinearLayout.LayoutParams)localObject3).topMargin = wja.dp2px(4.5F, paramResources);
                ((LinearLayout.LayoutParams)localObject3).bottomMargin = wja.dp2px(5.5F, paramResources);
                if ((lI(2)) && (i == this.rz.size() - 1)) {
                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = wja.dp2px(13.0F, paramResources);
                }
                if (paramBoolean) {
                  ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
                break;
                label1100:
                if (paramBoolean)
                {
                  if (TextUtils.isEmpty(((anux)localObject3).As())) {
                    ((anux)localObject3).fK(String.valueOf(32));
                  }
                  if (TextUtils.isEmpty(((anux)localObject3).getTextColor())) {
                    ((anux)localObject3).setTextColor("#000000");
                  }
                }
              }
            }
            if ("timer".equals(localObject3))
            {
              localObject1 = ((anqu)localObject1).a(paramContext, null, paramBundle);
              localObject3 = new LinearLayout.LayoutParams(-2, -2);
              if (i > 0) {
                ((LinearLayout.LayoutParams)localObject3).topMargin = paramInt;
              }
              if (paramBoolean) {
                ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
              }
              paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
            }
            else
            {
              if (("picture".equals(localObject3)) || ("video".equals(localObject3)))
              {
                localObject4 = ((anqu)localObject1).a(paramContext, null, paramBundle);
                localObject1 = ((View)localObject4).findViewById(2131369004);
                if (("picture".equals(localObject3)) && (paramBoolean) && (lI(1)) && (i == 0) && (paramBundle != null)) {
                  paramBundle.putBoolean("pa_should_change", true);
                }
                if ((localObject1 != null) && ((localObject1 instanceof AnyScaleTypeImageView)) && ("picture".equals(localObject3))) {
                  AnyScaleTypeImageView localAnyScaleTypeImageView = (AnyScaleTypeImageView)localObject1;
                }
                if (paramBoolean)
                {
                  ((View)localObject4).setPadding(0, ((View)localObject4).getPaddingTop(), 0, ((View)localObject4).getPaddingBottom());
                  if ((localObject1 instanceof FixRatioPAHighLightImageView))
                  {
                    ((FixRatioPAHighLightImageView)localObject1).setRatio(1.8F);
                    localObject1 = new LinearLayout.LayoutParams(-1, -2);
                    label1392:
                    if (i > 0) {
                      ((LinearLayout.LayoutParams)localObject1).topMargin = paramInt;
                    }
                    if ((!"picture".equals(localObject3)) || (!paramBoolean) || (!lI(1)) || (i != 0)) {
                      break label1599;
                    }
                    ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
                    if ((localObject4 != null) && ((localObject4 instanceof PAImageView))) {
                      ((PAImageView)localObject4).setUseRadiusRound(true, paramResources.getDimensionPixelSize(2131296467));
                    }
                  }
                }
                for (;;)
                {
                  ((LinearLayout.LayoutParams)localObject1).bottomMargin = wja.dp2px(7.5F, paramResources);
                  paramLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject1);
                  break;
                  j = BaseChatItemLayout.bOi;
                  if (!paramBundle.getBoolean("hasHeadIcon", true)) {
                    j = BaseChatItemLayout.bOj;
                  }
                  localObject1 = new LinearLayout.LayoutParams(-1, (int)(j / 1.8D));
                  break label1392;
                  if ((!paramBundle.getBoolean("hasHeadIcon", true)) && (paramBundle.getInt("serviceID", 0) == 21))
                  {
                    localObject1 = new LinearLayout.LayoutParams(-1, wja.dp2px(105.0F, paramResources));
                    break label1392;
                  }
                  localObject1 = new LinearLayout.LayoutParams(-1, wja.dp2px(175.0F, paramResources));
                  break label1392;
                  label1599:
                  ((LinearLayout.LayoutParams)localObject1).topMargin = wja.dp2px(7.5F, paramResources);
                }
              }
              if ("more".equals(localObject3))
              {
                localObject1 = ((anqu)localObject1).a(paramContext, null, paramBundle);
                localObject3 = new LinearLayout.LayoutParams(-1, wja.dp2px(36.0F, paramResources));
                if (paramBoolean) {
                  ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
              }
              else if ("item".equals(localObject3))
              {
                localObject1 = ((anqu)localObject1).a(paramContext, null, paramBundle);
                if (paramBoolean) {
                  ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1);
              }
              else if ("price".equals(localObject3))
              {
                localObject1 = ((anqu)localObject1).a(paramContext, null, paramBundle);
                if (paramBoolean) {
                  ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1);
              }
              else if ("pavideo".equals(localObject3))
              {
                localObject1 = ((anqu)localObject1).a(paramContext, null, paramBundle);
                ((AnyScaleTypeImageView)localObject1).setImageResource(2130842527);
                localObject3 = new LinearLayout.LayoutParams(-1, (int)(BaseChatItemLayout.widthPixels / 1.8D));
                if (paramBoolean)
                {
                  ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                  ((LinearLayout.LayoutParams)localObject3).topMargin = wja.dp2px(7.5F, paramResources);
                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = wja.dp2px(7.5F, paramResources);
                }
                paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
              }
              else if ("asyncmsg".equals(localObject3))
              {
                localObject1 = ((anqu)localObject1).a(paramContext, null, paramBundle);
                if (paramBoolean) {
                  ((View)localObject1).setPadding(k, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1);
              }
              else if ("group".equals(localObject3))
              {
                localObject1 = ((anqu)localObject1).a(paramContext, null, paramBundle);
                ((View)localObject1).setPadding(0, 0, 0, 0);
                localObject3 = new LinearLayout.LayoutParams(-1, -2);
                ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
                ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
                ((LinearLayout.LayoutParams)localObject3).topMargin = 0;
                ((LinearLayout.LayoutParams)localObject3).bottomMargin = 0;
                paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
                this.cJY = true;
              }
            }
          }
        }
      }
    }
    if (this.cJY) {
      paramLinearLayout.setPadding(0, 0, 0, 0);
    }
  }
  
  private void a(Context paramContext, Resources paramResources, LinearLayout paramLinearLayout, int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject1 = new StringBuffer();
    Object localObject2 = new ArrayList();
    Object localObject3 = this.rz.iterator();
    int i = -1;
    if (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (anqu)((Iterator)localObject3).next();
      ((anqu)localObject4).hU = this.hU;
      int j = i;
      if ((localObject4 instanceof anqw))
      {
        localObject4 = (anqw)localObject4;
        if (paramBoolean)
        {
          if (!(localObject4 instanceof anux)) {
            break label216;
          }
          if (TextUtils.isEmpty(((anqw)localObject4).As())) {
            ((anqw)localObject4).fK(String.valueOf(32));
          }
          if (TextUtils.isEmpty(((anqw)localObject4).getTextColor())) {
            ((anqw)localObject4).setTextColor("#000000");
          }
        }
      }
      for (;;)
      {
        localObject4 = ((anqw)localObject4).a(paramResources);
        j = i;
        if (localObject4 != null)
        {
          ((anqw.a)localObject4).beginIndex = (i + 1);
          ((anqw.a)localObject4).endIndex = (((anqw.a)localObject4).beginIndex + ((anqw.a)localObject4).text.length());
          j = i + ((anqw.a)localObject4).text.length();
          ((StringBuffer)localObject1).append(((anqw.a)localObject4).text);
          ((ArrayList)localObject2).add(localObject4);
        }
        i = j;
        break;
        label216:
        if (((localObject4 instanceof StructMsgItemTitle)) && (TextUtils.isEmpty(((anqw)localObject4).As()))) {
          ((anqw)localObject4).fK(String.valueOf(36));
        }
      }
    }
    localObject1 = new SpannableStringBuilder(((StringBuffer)localObject1).toString());
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (anqw.a)((Iterator)localObject2).next();
      ((SpannableStringBuilder)localObject1).setSpan(new TextAppearanceSpan(null, ((anqw.a)localObject3).style, (int)TypedValue.applyDimension(2, ((anqw.a)localObject3).size, paramResources.getDisplayMetrics()), ColorStateList.valueOf(((anqw.a)localObject3).color), null), ((anqw.a)localObject3).beginIndex, ((anqw.a)localObject3).endIndex, 33);
    }
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      paramContext = (TextView)paramView;
      paramContext.setText((CharSequence)localObject1);
      paramContext.requestLayout();
      return;
    }
    paramView = new LinearLayout.LayoutParams(-2, -2);
    paramContext = new TextView(paramContext);
    if (paramBoolean)
    {
      paramContext.setLineSpacing(wja.dp2px(2.0F, paramResources), 1.0F);
      paramView.topMargin = wja.dp2px(4.5F, paramResources);
      paramView.bottomMargin = wja.dp2px(5.5F, paramResources);
    }
    for (;;)
    {
      paramLinearLayout.addView(paramContext, paramView);
      break;
      paramContext.setLineSpacing(paramInt, 1.0F);
      if (lI(2)) {
        paramView.bottomMargin = wja.dp2px(10.0F, paramResources);
      }
      if (lI(1)) {
        paramView.topMargin = wja.dp2px(10.0F, paramResources);
      }
    }
  }
  
  private LinearLayout b(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setPadding(localResources.getDimensionPixelSize(2131299517), 0, localResources.getDimensionPixelSize(2131299518), 0);
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  protected int IX()
  {
    return 6;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool;
    Resources localResources;
    label38:
    int k;
    int m;
    int i;
    if (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA)
    {
      bool = true;
      localResources = paramContext.getResources();
      if ((paramView == null) || (!(paramView instanceof LinearLayout))) {
        break label161;
      }
      paramView = (LinearLayout)paramView;
      k = paramView.getPaddingTop();
      m = paramView.getPaddingBottom();
      j = localResources.getDimensionPixelSize(2131299517);
      i = localResources.getDimensionPixelSize(2131299518);
      hF(paramView);
      hI(paramView);
      if (bool)
      {
        if (this.dMi != 1) {
          break label170;
        }
        i = localResources.getDimensionPixelSize(2131296465);
      }
    }
    for (int j = i;; j = 0)
    {
      paramView.setPadding(j, k, i, m);
      i = wja.dp2px(8.0F, localResources);
      if (this.dMi != 1) {
        break label179;
      }
      a(paramContext, localResources, paramView, i, paramView.getChildAt(0), bool);
      return paramView;
      bool = false;
      break;
      label161:
      paramView = b(paramContext);
      break label38;
      label170:
      i = 0;
    }
    label179:
    a(paramContext, localResources, paramView, i, paramBundle, bool);
    return paramView;
  }
  
  public String getName()
  {
    return "Layout6";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anub
 * JD-Core Version:    0.7.0.1
 */