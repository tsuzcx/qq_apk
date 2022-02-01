import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;

public class anue
  extends anqv
{
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
        arrayOfGradientDrawable[k].setCornerRadius(wja.dp2px(4.0F, paramResources));
      }
    }
    paramResources = new StateListDrawable();
    paramArrayOfFloat = arrayOfGradientDrawable[1];
    paramResources.addState(new int[] { 16842919, 16842910 }, paramArrayOfFloat);
    paramResources.addState(StateSet.WILD_CARD, arrayOfGradientDrawable[0]);
    return paramResources;
  }
  
  protected int IX()
  {
    return 8;
  }
  
  @TargetApi(16)
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    int j = this.rz.size();
    RelativeLayout localRelativeLayout;
    int i;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      localRelativeLayout = (RelativeLayout)paramView;
      paramView = localRelativeLayout;
      if (j == localRelativeLayout.getChildCount())
      {
        i = 0;
        paramView = localRelativeLayout;
        if (i < j)
        {
          if (i <= 2) {
            break label175;
          }
          paramView = localRelativeLayout;
        }
      }
      label67:
      paramContext = paramView.findViewById(2);
      if (paramContext != null)
      {
        paramBundle = (RelativeLayout.LayoutParams)paramContext.getLayoutParams();
        paramBundle.addRule(0, 3);
        paramBundle.rightMargin = wja.dp2px(7.5F, localResources);
        if (paramView.findViewById(1) == null) {
          break label873;
        }
        paramBundle.addRule(1, 1);
        paramContext.setPadding(wja.dp2px(7.5F, localResources), 0, 0, 0);
        label130:
        paramContext.setLayoutParams(paramBundle);
      }
      if (Build.VERSION.SDK_INT >= 16) {
        break label891;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      hF(paramView);
      paramView.setPadding(wja.dp2px(11.0F, localResources), 0, wja.dp2px(11.0F, localResources), 0);
      return paramView;
      label175:
      paramView = (anqu)this.rz.get(i);
      paramView.hU = this.hU;
      Object localObject = paramView.mTypeName;
      if ("picture".equals(localObject))
      {
        paramView = (ImageView)paramView.a(paramContext, localRelativeLayout.findViewById(1), paramBundle);
        localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      label353:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!"title".equals(localObject)) {
            break label353;
          }
          ((StructMsgItemTitle)paramView).fK("30");
          ((StructMsgItemTitle)paramView).setSingleLine(true);
          ((StructMsgItemTitle)paramView).bA(ayW(), this.dMj);
          paramView = paramView.a(paramContext, localRelativeLayout.findViewById(2), paramBundle);
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      } while (!"summary".equals(localObject));
      ((anux)paramView).fK("28");
      ((anux)paramView).setSingleLine(true);
      if (this.dMj != 0) {
        ((anux)paramView).bA(ayW(), this.dMj);
      }
      for (;;)
      {
        paramView = paramView.a(paramContext, localRelativeLayout.findViewById(3), paramBundle);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        break;
        ((anux)paramView).setTextColor("black");
      }
      localRelativeLayout = new RelativeLayout(paramContext);
      localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, wja.dp2px(40.0F, localResources)));
      i = 0;
      paramView = localRelativeLayout;
      if (i >= j) {
        break label67;
      }
      paramView = localRelativeLayout;
      if (i > 2) {
        break label67;
      }
      paramView = (anqu)this.rz.get(i);
      paramView.hU = this.hU;
      localObject = paramView.mTypeName;
      if ("picture".equals(localObject))
      {
        paramView = (ImageView)paramView.a(paramContext, null, paramBundle);
        paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.setId(1);
        localObject = new RelativeLayout.LayoutParams(wja.dp2px(40.0F, localResources), wja.dp2px(30.0F, localResources));
        ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      }
      label720:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!"title".equals(localObject)) {
            break label720;
          }
          ((StructMsgItemTitle)paramView).fK("30");
          ((StructMsgItemTitle)paramView).setSingleLine(true);
          ((StructMsgItemTitle)paramView).bA(ayW(), this.dMj);
          paramView = paramView.a(paramContext, null, paramBundle);
          paramView.setId(2);
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
        }
      } while (!"summary".equals(localObject));
      ((anux)paramView).fK("28");
      ((anux)paramView).setSingleLine(true);
      if (this.dMj != 0) {
        ((anux)paramView).bA(ayW(), this.dMj);
      }
      for (;;)
      {
        paramView = paramView.a(paramContext, null, paramBundle);
        int k = localResources.getDisplayMetrics().widthPixels;
        int m = wja.dp2px(89.5F, localResources);
        ((TextView)paramView).setMaxWidth(k - m);
        ((TextView)paramView).setSingleLine(true);
        paramView.setId(3);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
        break;
        ((anux)paramView).setTextColor("black");
      }
      label873:
      paramBundle.addRule(9, -1);
      paramContext.setPadding(0, 0, 0, 0);
      break label130;
      label891:
      paramView.setBackground(null);
    }
  }
  
  public String getName()
  {
    return "Layout8";
  }
  
  @TargetApi(16)
  public void hF(View paramView)
  {
    if (paramView != null)
    {
      if (this.dMj == 0) {
        super.hF(paramView);
      }
    }
    else {
      return;
    }
    int i = wja.dp2px(4.0F, paramView.getResources());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (getStyle())
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = a(paramView.getResources(), this.dMj, (float[])localObject1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anue
 * JD-Core Version:    0.7.0.1
 */