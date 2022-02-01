import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ants
  extends ansv
{
  private TextView a(Context paramContext, List<anqu> paramList)
  {
    paramContext = new TextView(paramContext);
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      if ((paramList != null) && (i > 2))
      {
        paramList = (anqu)paramList.get(i - 1);
        if ((paramList instanceof anqw))
        {
          paramContext.setText(((anqw)paramList).getText());
          paramContext.setGravity(16);
          paramContext.setSingleLine(true);
        }
      }
      return paramContext;
    }
  }
  
  private void j(LinearLayout paramLinearLayout)
  {
    if (paramLinearLayout.getWidth() > 0)
    {
      k(paramLinearLayout);
      return;
    }
    paramLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new antt(this, paramLinearLayout));
  }
  
  private void k(LinearLayout paramLinearLayout)
  {
    int k = paramLinearLayout.getChildCount();
    int i = 4;
    int j = 1;
    Object localObject;
    if (j < k)
    {
      localObject = paramLinearLayout.getChildAt(j);
      if (!(localObject instanceof TextView)) {
        break label107;
      }
      localObject = (TextView)localObject;
      Layout localLayout = ((TextView)localObject).getLayout();
      if (localLayout == null) {
        break label107;
      }
      int m = localLayout.getLineCount();
      if (i > 0)
      {
        ((TextView)localObject).setVisibility(0);
        if (i < m)
        {
          ((TextView)localObject).setMaxLines(i);
          ((TextView)localObject).requestLayout();
        }
        label84:
        i -= m;
      }
    }
    label107:
    for (;;)
    {
      j += 1;
      break;
      ((TextView)localObject).setVisibility(8);
      break label84;
      return;
    }
  }
  
  protected int a(Resources paramResources, int paramInt, anqu paramanqu)
  {
    int i = 4;
    if (paramInt == 1) {
      i = 7;
    }
    return wja.dp2px(i, paramResources);
  }
  
  protected ArrayList<anqu> ao(ArrayList<anqu> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList();
    int m = paramArrayList.size();
    int j = 0;
    int i = 0;
    Object localObject2;
    int k;
    if (j < m)
    {
      localObject2 = (anqu)paramArrayList.get(j);
      if ((j == 0) && ((localObject2 instanceof StructMsgItemTitle)))
      {
        StructMsgItemTitle localStructMsgItemTitle = (StructMsgItemTitle)localObject2;
        if ((this.e.hasTSum()) && (localStructMsgItemTitle.getText().endsWith(acfp.m(2131715038))))
        {
          k = 1;
          label92:
          if (k == 0) {
            break label314;
          }
          i = 1;
          label99:
          if (!(localObject2 instanceof anst)) {
            break label254;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        paramArrayList = new StructMsgItemTitle(acfp.m(2131715024));
      }
      for (;;)
      {
        paramArrayList.Rr("34");
        paramArrayList.Rs("12");
        paramArrayList.Rt("2");
        paramArrayList.e = this.e;
        localArrayList.add(paramArrayList);
        paramArrayList = ((List)localObject1).iterator();
        while (paramArrayList.hasNext())
        {
          localObject1 = (anqu)paramArrayList.next();
          if ((localObject1 instanceof anqw))
          {
            localObject2 = (anqw)localObject1;
            ((anqw)localObject2).Rr("26");
            ((anqw)localObject2).Rq("#777777");
            ((anqw)localObject2).Rs("12");
            ((anqw)localObject2).Rt("2");
            ((anqu)localObject1).e = this.e;
            localArrayList.add(localObject1);
          }
        }
        k = 0;
        break label92;
        label254:
        if (((localObject2 instanceof StructMsgItemTitle)) || ((localObject2 instanceof anux))) {
          ((List)localObject1).add(localObject2);
        }
        j += 1;
        break;
        paramArrayList = (StructMsgItemTitle)((List)localObject1).get(0);
        ((List)localObject1).remove(0);
      }
      return localArrayList;
      label314:
      break label99;
    }
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    int k = 0;
    int j = 0;
    Resources localResources = paramContext.getResources();
    int i = localResources.getDimensionPixelSize(2131299524);
    int m = localResources.getDimensionPixelSize(2131299525);
    int n = localResources.getDimensionPixelSize(2131299523);
    LinearLayout localLinearLayout1;
    LinearLayout localLinearLayout2;
    Object localObject1;
    View localView;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout1 = (LinearLayout)paramView;
      localLinearLayout2 = (LinearLayout)localLinearLayout1.getChildAt(0);
      paramView = (TextView)localLinearLayout1.getChildAt(1);
      localObject1 = ao(this.rz);
      if (localLinearLayout2.getChildCount() != ((ArrayList)localObject1).size()) {
        break label486;
      }
      k = ((ArrayList)localObject1).size();
      i = j;
      if (i >= k) {
        break label672;
      }
      localObject2 = (anqu)((ArrayList)localObject1).get(i);
      ((anqu)localObject2).hU = this.hU;
      if ((localObject2 instanceof StructMsgItemTitle)) {
        ((StructMsgItemTitle)localObject2).bA(ayW(), this.dMj);
      }
      localView = ((anqu)localObject2).a(paramContext, localLinearLayout2.getChildAt(i), paramBundle);
      if (localView != null) {
        break label392;
      }
    }
    label392:
    label486:
    do
    {
      return localLinearLayout2;
      localLinearLayout1 = new LinearLayout(paramContext);
      localLinearLayout1.setOrientation(1);
      localLinearLayout2 = new LinearLayout(paramContext);
      localLinearLayout2.setOrientation(1);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout2.setPadding(i, m, m, n);
      localLinearLayout2.setLayoutParams(paramView);
      paramView = a(paramContext, this.rz);
      paramView.setBackgroundResource(2130851476);
      paramView.setPadding(i, 0, 0, 0);
      paramView.setTextSize(1, 13.0F);
      paramView.setGravity(16);
      if (Build.VERSION.SDK_INT > 22) {}
      for (i = localResources.getColor(2131165827, paramContext.getTheme());; i = localResources.getColor(2131165827))
      {
        paramView.setTextColor(i);
        localObject1 = new LinearLayout.LayoutParams(-1, wja.dp2px(30.0F, localResources));
        ((LinearLayout.LayoutParams)localObject1).leftMargin = wja.dp2px(2.0F, localResources);
        ((LinearLayout.LayoutParams)localObject1).rightMargin = wja.dp2px(2.0F, localResources);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localLinearLayout1.addView(localLinearLayout2);
        localLinearLayout1.addView(paramView);
        break;
      }
      wja.dp2px(10.0F, localResources);
      localObject3 = new LinearLayout.LayoutParams(-1, -2);
      if (i > 0) {
        ((LinearLayout.LayoutParams)localObject3).topMargin = a(localResources, i, (anqu)localObject2);
      }
      localObject2 = ((anqu)localObject2).mTypeName;
      if ("title".equals(localObject2)) {
        localView.setId(-1);
      }
      for (;;)
      {
        i += 1;
        break;
        if ("summary".equals(localObject2)) {
          localView.setId(-1);
        }
      }
      localLinearLayout2.removeAllViews();
      j = ((ArrayList)localObject1).size();
      i = k;
      if (i >= j) {
        break label672;
      }
      localObject3 = (anqu)((ArrayList)localObject1).get(i);
      ((anqu)localObject3).hU = this.hU;
      if ((localObject3 instanceof StructMsgItemTitle)) {
        ((StructMsgItemTitle)localObject3).bA(ayW(), this.dMj);
      }
      localView = ((anqu)localObject3).a(paramContext, null, paramBundle);
    } while (localView == null);
    wja.dp2px(10.0F, localResources);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -2);
    if (i > 0) {
      ((LinearLayout.LayoutParams)localObject2).topMargin = a(localResources, i, (anqu)localObject3);
    }
    Object localObject3 = ((anqu)localObject3).mTypeName;
    if ("title".equals(localObject3)) {
      localView.setId(-1);
    }
    for (;;)
    {
      localLinearLayout2.addView(localView, (ViewGroup.LayoutParams)localObject2);
      i += 1;
      break;
      if ("summary".equals(localObject3)) {
        localView.setId(-1);
      }
    }
    label672:
    j(localLinearLayout2);
    i = this.rz.size();
    paramContext = (anqu)this.rz.get(i - 1);
    if ((paramContext instanceof anqw)) {
      paramView.setText(((anqw)paramContext).text);
    }
    return localLinearLayout1;
  }
  
  public String getName()
  {
    return "Layout30";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ants
 * JD-Core Version:    0.7.0.1
 */