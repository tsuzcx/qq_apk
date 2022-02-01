import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;

public class anud
  extends anqv
{
  private static final int dMD = Color.rgb(255, 221, 227);
  
  private StateListDrawable a(Resources paramResources, int paramInt, float[] paramArrayOfFloat)
  {
    GradientDrawable[] arrayOfGradientDrawable = new GradientDrawable[2];
    int k = Color.red(paramInt);
    int i = Color.green(paramInt);
    int j = Color.blue(paramInt);
    paramInt = k;
    k = 0;
    if (k < arrayOfGradientDrawable.length)
    {
      arrayOfGradientDrawable[k] = new GradientDrawable();
      arrayOfGradientDrawable[k].setShape(0);
      int m = paramInt - (k << 5);
      paramInt = m;
      if (m < 0) {
        paramInt = 0;
      }
      m = i - (k << 5);
      i = m;
      if (m < 0) {
        i = 0;
      }
      m = j - (k << 5);
      j = m;
      if (m < 0) {
        j = 0;
      }
      arrayOfGradientDrawable[k].setColor(Color.rgb(paramInt, i, j));
      if (paramArrayOfFloat != null) {
        arrayOfGradientDrawable[k].setCornerRadii(paramArrayOfFloat);
      }
      for (;;)
      {
        k += 1;
        break;
        arrayOfGradientDrawable[k].setCornerRadius(wja.dp2px(14.0F, paramResources));
      }
    }
    paramResources = new StateListDrawable();
    paramArrayOfFloat = arrayOfGradientDrawable[1];
    paramResources.addState(new int[] { 16842919, 16842910 }, paramArrayOfFloat);
    paramResources.addState(StateSet.WILD_CARD, arrayOfGradientDrawable[0]);
    return paramResources;
  }
  
  private LinearLayout b(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    hF(paramContext);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setOrientation(1);
    return paramContext;
  }
  
  protected int IX()
  {
    return 7;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    LinearLayout localLinearLayout;
    anud.a locala;
    label148:
    Object localObject1;
    Object localObject2;
    if ((paramView != null) && ((paramView instanceof LinearLayout)) && (((LinearLayout)paramView).getChildCount() == 2) && ((((LinearLayout)paramView).getChildAt(0).getTag() instanceof anud.a)))
    {
      localLinearLayout = (LinearLayout)paramView;
      locala = (anud.a)localLinearLayout.getChildAt(0).getTag();
      if (locala.yg != null) {
        locala.yg.setVisibility(8);
      }
      if (locala.Hu != null) {
        locala.Hu.setVisibility(8);
      }
      if (locala.EY != null) {
        locala.EY.setVisibility(8);
      }
      if (locala.Hv != null) {
        locala.Hv.setVisibility(8);
      }
      paramView = null;
      Iterator localIterator = this.rz.iterator();
      if (!localIterator.hasNext()) {
        break label703;
      }
      localObject1 = (anqu)localIterator.next();
      ((anqu)localObject1).hU = this.hU;
      localObject2 = ((anqu)localObject1).mTypeName;
      if (!"title".equals(localObject2)) {
        break label447;
      }
      if ((localObject1 instanceof StructMsgItemTitle))
      {
        ((StructMsgItemTitle)localObject1).bA(ayW(), 0);
        ((StructMsgItemTitle)localObject1).setSingleLine(true);
      }
      localObject1 = ((anqu)localObject1).a(paramContext, locala.yg, paramBundle);
      localObject2 = (TextView)((View)localObject1).findViewById(2131380976);
      if (localObject2 != null) {
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      }
      if (locala.yg != null) {
        break label435;
      }
      locala.yg = ((View)localObject1);
      locala.ey.addView((View)localObject1);
    }
    for (;;)
    {
      break label148;
      locala = new anud.a();
      locala.ey = new LinearLayout(paramContext);
      ((LinearLayout)locala.ey).setOrientation(1);
      paramView = new LinearLayout.LayoutParams(0, -2);
      paramView.weight = 1.0F;
      paramView.gravity = 16;
      paramView.setMargins(wja.dp2px(15.0F, localResources), 0, 0, 0);
      locala.ex = new LinearLayout(paramContext);
      locala.ex.setTag(locala);
      locala.ex.addView(locala.ey, paramView);
      localLinearLayout = b(paramContext);
      localLinearLayout.addView(locala.ex, new LinearLayout.LayoutParams(-1, wja.dp2px(75.0F, localResources)));
      break;
      label435:
      locala.yg.setVisibility(0);
      continue;
      label447:
      if ("summary".equals(localObject2))
      {
        localObject1 = ((anqu)localObject1).a(paramContext, locala.Hu, paramBundle);
        if (locala.Hu == null)
        {
          locala.Hu = ((View)localObject1);
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject2).setMargins(0, wja.dp2px(4.0F, localResources), 0, 0);
          locala.ey.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          break;
          locala.Hu.setVisibility(0);
        }
      }
      if (("picture".equals(localObject2)) || ("video".equals(localObject2)))
      {
        int i = wja.dp2px(50.0F, localResources);
        localObject1 = ((anqu)localObject1).a(paramContext, locala.EY, paramBundle);
        if (locala.EY == null)
        {
          locala.EY = ((View)localObject1);
          localObject2 = new LinearLayout.LayoutParams(i, i);
          i = wja.dp2px(12.0F, localResources);
          int j = wja.dp2px(10.0F, localResources);
          ((LinearLayout.LayoutParams)localObject2).setMargins(j, i, j, i);
          ((LinearLayout.LayoutParams)localObject2).gravity = 16;
          locala.ex.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          break;
          locala.EY.setVisibility(0);
        }
      }
      if ("remark".equals(localObject2))
      {
        paramView = ((anqu)localObject1).a(paramContext, locala.Hv, paramBundle);
        continue;
        label703:
        if (locala.Hu != null) {
          locala.Hu.bringToFront();
        }
        if (paramView != null)
        {
          if (locala.Hv == null)
          {
            locala.Hv = paramView;
            localLinearLayout.addView(paramView, new LinearLayout.LayoutParams(-1, wja.dp2px(25.0F, localResources)));
            float f = wja.dp2px(14.0F, localResources);
            paramView.setBackgroundDrawable(a(localResources, -1, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f }));
            paramView.setPadding(wja.dp2px(12.0F, localResources), wja.dp2px(5.0F, localResources), 0, 0);
          }
        }
        else {
          return localLinearLayout;
        }
        locala.Hv.setVisibility(0);
        return localLinearLayout;
      }
    }
  }
  
  public String getName()
  {
    return "Layout7";
  }
  
  @TargetApi(16)
  public void hF(View paramView)
  {
    int i;
    Object localObject1;
    if (paramView != null)
    {
      i = wja.dp2px(14.0F, paramView.getResources());
      Object localObject2 = null;
      localObject1 = localObject2;
      switch (getStyle())
      {
      default: 
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject1 = a(paramView.getResources(), dMD, (float[])localObject1);
      if (Build.VERSION.SDK_INT >= 16) {
        break;
      }
      paramView.setBackgroundDrawable((Drawable)localObject1);
      return;
      localObject1 = new float[8];
      continue;
      localObject1 = new float[8];
      localObject1[0] = i;
      localObject1[1] = i;
      localObject1[2] = i;
      localObject1[3] = i;
      localObject1[4] = 0.0F;
      localObject1[5] = 0.0F;
      localObject1[6] = 0.0F;
      localObject1[7] = 0.0F;
      continue;
      localObject1 = new float[8];
      localObject1[0] = 0.0F;
      localObject1[1] = 0.0F;
      localObject1[2] = 0.0F;
      localObject1[3] = 0.0F;
      localObject1[4] = i;
      localObject1[5] = i;
      localObject1[6] = i;
      localObject1[7] = i;
    }
    paramView.setBackground((Drawable)localObject1);
  }
  
  static class a
  {
    public View EY;
    public View Hu;
    public View Hv;
    public ViewGroup ex;
    public ViewGroup ey;
    public View yg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anud
 * JD-Core Version:    0.7.0.1
 */