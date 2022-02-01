import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class aute
{
  public static void a(Context paramContext, TextView paramTextView, int paramInt, boolean paramBoolean)
  {
    if ((paramTextView == null) || (paramInt == 0)) {}
    do
    {
      return;
      int i = paramContext.getResources().getDimensionPixelSize(2131297372);
      int j = paramContext.getResources().getDimensionPixelSize(2131297370);
      switch (paramInt)
      {
      case 4: 
      case 6: 
      default: 
        paramInt = j;
      case 1: 
      case 7: 
      case 3: 
      case 9: 
      case 8: 
      case 2: 
      case 5: 
        for (;;)
        {
          paramContext = (ViewGroup.MarginLayoutParams)paramTextView.getLayoutParams();
          if ((paramContext == null) || ((paramContext.leftMargin == i) && (paramContext.bottomMargin == paramInt))) {
            break;
          }
          paramContext.setMargins(i, 0, 0, paramInt);
          return;
          i = paramContext.getResources().getDimensionPixelSize(2131297372);
          paramInt = paramContext.getResources().getDimensionPixelSize(2131297370);
          paramTextView.measure(0, 0);
          int k = paramTextView.getMeasuredWidth();
          j = paramTextView.getMeasuredHeight();
          k /= 2;
          j /= 2;
          i -= k;
          paramInt -= j;
          continue;
          i = paramContext.getResources().getDimensionPixelSize(2131297372);
          paramInt = paramContext.getResources().getDimensionPixelSize(2131297370);
          paramTextView.measure(0, 0);
          k = paramTextView.getMeasuredWidth();
          j = paramTextView.getMeasuredHeight();
          k /= 2;
          j /= 2;
          i -= k;
          paramInt -= j;
          continue;
          i = paramContext.getResources().getDimensionPixelSize(2131297375);
          paramInt = paramContext.getResources().getDimensionPixelSize(2131297373);
          continue;
          i = paramContext.getResources().getDimensionPixelSize(2131297376);
          paramInt = paramContext.getResources().getDimensionPixelSize(2131297374);
          continue;
          k = paramContext.getResources().getDimensionPixelSize(2131297372);
          i = paramContext.getResources().getDimensionPixelSize(2131297371);
          paramInt = i;
          if (paramBoolean) {
            paramInt = i + aqnm.dip2px(8.0F);
          }
          paramTextView.measure(0, 0);
          i = paramTextView.getMeasuredWidth();
          j = paramTextView.getMeasuredHeight();
          if (i > j) {
            j = i;
          }
          for (;;)
          {
            paramTextView.setWidth(j);
            paramTextView.setHeight(i);
            j = k - j / 2;
            paramInt -= i / 2;
            i = j;
            break;
            i = j;
          }
          i = paramContext.getResources().getDimensionPixelSize(2131297375);
          paramInt = paramContext.getResources().getDimensionPixelSize(2131297373);
          continue;
          i = paramContext.getResources().getDimensionPixelSize(2131297375);
          paramInt = paramContext.getResources().getDimensionPixelSize(2131297373);
        }
      }
    } while (!(paramTextView.getLayoutParams() instanceof RelativeLayout.LayoutParams));
    paramTextView = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
    paramTextView.addRule(15, -1);
    paramTextView.setMargins(0, 0, paramContext.getResources().getDimensionPixelSize(2131297377), 0);
  }
  
  public static void updateCustomNoteTxt(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    updateCustomNoteTxt(paramTextView, paramInt1, paramInt2, paramInt3, 99, null);
  }
  
  public static void updateCustomNoteTxt(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      paramString = "";
      paramInt2 = 0;
      paramInt1 = 0;
      if (paramString == null) {
        paramString = "";
      }
      break;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramString)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramTextView.setVisibility(8);
        return;
        if (paramInt3 > 0)
        {
          paramString = "";
          paramInt1 = paramInt3;
          paramInt2 = 0;
          break;
        }
        paramString = "";
        paramInt1 = 2130851400;
        paramInt2 = 0;
        break;
        if (paramInt3 > 0) {}
        for (paramInt2 = paramInt3;; paramInt2 = 2130851404)
        {
          paramString = "NEW";
          paramInt1 = 0;
          break;
        }
        if (paramInt3 > 0)
        {
          paramString = "";
          paramInt1 = paramInt3;
          paramInt2 = 0;
          break;
        }
        paramString = "";
        paramInt1 = 2130851403;
        paramInt2 = 0;
        break;
        if (paramInt3 > 0) {}
        for (;;)
        {
          if (paramInt2 <= paramInt4) {
            break label219;
          }
          paramString = String.valueOf(paramInt4) + "+";
          paramInt1 = 0;
          paramInt2 = paramInt3;
          break;
          paramInt3 = 2130851404;
        }
        label219:
        paramString = String.valueOf(paramInt2);
        paramInt1 = 0;
        paramInt2 = paramInt3;
        break;
        if (paramInt3 > 0) {}
        for (;;)
        {
          if (paramInt2 <= 99) {
            break label259;
          }
          paramString = "";
          paramInt1 = 0;
          paramInt2 = paramInt3;
          break;
          paramInt3 = 2130851404;
        }
        label259:
        paramString = String.valueOf(paramInt2);
        paramInt1 = 0;
        paramInt2 = paramInt3;
        break;
        if (paramInt3 > 0) {}
        for (;;)
        {
          if (paramInt2 <= paramInt4) {
            break label320;
          }
          paramString = String.valueOf(paramInt4) + "+";
          paramInt1 = 0;
          paramInt2 = paramInt3;
          break;
          paramInt3 = 2130851404;
        }
        label320:
        paramString = String.valueOf(paramInt2);
        paramInt1 = 0;
        paramInt2 = paramInt3;
        break;
        if (paramInt3 > 0) {}
        for (paramInt2 = paramInt3;; paramInt2 = 2130851404)
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label362;
          }
          paramString = "";
          paramInt1 = 0;
          break;
        }
        label362:
        paramInt1 = 0;
        break;
      }
      Object localObject = paramTextView.getTag(2131381288);
      if (((localObject == null) && (paramInt1 == 0)) || (((localObject instanceof Integer)) && (((Integer)localObject).intValue() == paramInt1))) {}
      for (;;)
      {
        paramTextView.setBackgroundResource(paramInt2);
        if (!aqft.equalsWithNullCheck(paramTextView.getText().toString(), paramString))
        {
          paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          paramTextView.setText(paramString);
        }
        paramTextView.setVisibility(0);
        return;
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt1, 0, 0, 0);
        paramTextView.setTag(2131381288, Integer.valueOf(paramInt1));
        paramTextView.setText(paramString);
        paramTextView.setPadding(0, 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aute
 * JD-Core Version:    0.7.0.1
 */