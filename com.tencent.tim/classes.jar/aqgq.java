import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.BubbleContextMenu.1;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuImageLayout;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuLayout;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.b;

public class aqgq
{
  public static boolean cTW;
  
  public static View a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, aqoa paramaqoa, View.OnClickListener paramOnClickListener)
  {
    return a(paramBubblePopupWindow, paramContext, paramaqoa, paramOnClickListener, false);
  }
  
  public static View a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, aqoa paramaqoa, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    int i;
    int n;
    int j;
    label21:
    int k;
    if (paramBoolean)
    {
      i = 8;
      int m = 1;
      n = paramaqoa.size();
      j = 0;
      k = m;
      if (j < n)
      {
        if (paramaqoa.a(j).getDrawable() != 0) {
          break label182;
        }
        k = 0;
      }
      if (!paramBoolean) {
        break label191;
      }
      if (QQCustomMenuNoIconLayout.screenWidth == 0)
      {
        localObject = paramContext.getResources();
        QQCustomMenuNoIconLayout.screenWidth = ((Resources)localObject).getDisplayMetrics().widthPixels;
        QQCustomMenuNoIconLayout.mDensity = ((Resources)localObject).getDisplayMetrics().density;
        QQCustomMenuNoIconLayout.mPadding = wja.dp2px(QQCustomMenuNoIconLayout.mPadding, (Resources)localObject);
        QQCustomMenuNoIconLayout.mItemPadding = wja.dp2px(QQCustomMenuNoIconLayout.mItemPadding, (Resources)localObject);
      }
    }
    for (;;)
    {
      if ((paramBoolean) || (k == 0) || (QQCustomMenuImageLayout.screenWidth < 480)) {
        break label281;
      }
      paramContext = new QQCustomMenuImageLayout(paramContext);
      paramContext.setGravity(17);
      paramContext.setPadding(QQCustomMenuImageLayout.mPadding, 0, 0, 0);
      paramContext.setPopup(paramBubblePopupWindow);
      paramContext.setMenu(paramaqoa);
      paramContext.setMenuIconClickListener(paramOnClickListener);
      paramContext.eev();
      return paramContext;
      i = 6;
      break;
      label182:
      j += 1;
      break label21;
      label191:
      if (QQCustomMenuImageLayout.screenWidth == 0)
      {
        localObject = paramContext.getResources();
        QQCustomMenuImageLayout.screenWidth = ((Resources)localObject).getDisplayMetrics().widthPixels;
        QQCustomMenuImageLayout.mDensity = ((Resources)localObject).getDisplayMetrics().density;
        QQCustomMenuImageLayout.mPadding = wja.dp2px(QQCustomMenuImageLayout.mPadding, (Resources)localObject);
        QQCustomMenuImageLayout.eak = wja.dp2px(QQCustomMenuImageLayout.eak, (Resources)localObject);
        QQCustomMenuImageLayout.eal = wja.dp2px(QQCustomMenuImageLayout.eal, (Resources)localObject);
        QQCustomMenuImageLayout.eam = (QQCustomMenuImageLayout.screenWidth - wja.dp2px(36.0F, (Resources)localObject)) / i;
      }
    }
    label281:
    if (paramBoolean)
    {
      paramContext = new QQCustomMenuNoIconLayout(paramContext);
      paramContext.setGravity(17);
      paramContext.setPadding(0, 0, 0, 0);
      paramContext.setPopup(paramBubblePopupWindow);
      paramContext.setMenu(paramaqoa);
      paramContext.setMenuIconClickListener(paramOnClickListener);
      paramContext.eev();
      return paramContext;
    }
    Object localObject = new QQCustomMenuLayout(paramContext);
    ((QQCustomMenuLayout)localObject).setGravity(17);
    a(paramBubblePopupWindow, paramContext, paramaqoa, paramOnClickListener, (QQCustomMenuLayout)localObject, n);
    return localObject;
  }
  
  private static QQCustomMenuLayout a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, aqoa paramaqoa, View.OnClickListener paramOnClickListener, QQCustomMenuLayout paramQQCustomMenuLayout, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      Object localObject = paramaqoa.a(i);
      BubbleContextMenu.1 local1 = new BubbleContextMenu.1(paramContext, paramBubblePopupWindow);
      local1.setText(((aqob)localObject).getTitle());
      local1.setTextSize(13.0F);
      Resources localResources = paramContext.getResources();
      TextPaint localTextPaint = new TextPaint(1);
      localTextPaint.density = localResources.getDisplayMetrics().density;
      int k = (int)Layout.getDesiredWidth(((aqob)localObject).getTitle(), localTextPaint);
      int j = 5;
      if (localTextPaint.density >= 2.0F) {
        j = 10;
      }
      j = (int)(j * localTextPaint.density);
      local1.setMinimumWidth(j * 2 + k);
      local1.setPadding(j, 0, j, 0);
      local1.setContentDescription(((aqob)localObject).getTitle());
      local1.setId(((aqob)localObject).getItemId());
      local1.setTextColor(-1);
      local1.setBackgroundDrawable(null);
      local1.setIncludeFontPadding(true);
      local1.setOnClickListener(paramOnClickListener);
      local1.setGravity(17);
      paramQQCustomMenuLayout.addView(local1, new LinearLayout.LayoutParams(-2, -2, 1.0F));
      if (i != paramInt - 1)
      {
        localObject = new ImageView(paramContext);
        ((ImageView)localObject).setBackgroundResource(2130839072);
        paramQQCustomMenuLayout.addView((View)localObject, -2, -2);
      }
      i += 1;
    }
    paramQQCustomMenuLayout.eex();
    return paramQQCustomMenuLayout;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, int paramInt3, aqoa paramaqoa, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), paramaqoa, paramOnClickListener));
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(false);
    localBubblePopupWindow.setFocusable(true);
    localBubblePopupWindow.setSoftInputMode(1);
    localBubblePopupWindow.setInputMethodMode(2);
    localBubblePopupWindow.setTouchModal(false);
    localBubblePopupWindow.abe(paramInt3);
    localBubblePopupWindow.setAnimationStyle(0);
    localBubblePopupWindow.d(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, aqoa paramaqoa)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), paramaqoa, null));
    localBubblePopupWindow.a(null);
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(true);
    localBubblePopupWindow.setFocusable(false);
    localBubblePopupWindow.showAsDropDown(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, aqoa paramaqoa, View.OnClickListener paramOnClickListener)
  {
    return a(paramView, paramInt1, paramInt2, paramaqoa, paramOnClickListener, false);
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, aqoa paramaqoa, View.OnClickListener paramOnClickListener, BubblePopupWindow.b paramb)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), paramaqoa, paramOnClickListener));
    localBubblePopupWindow.a(paramb);
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(true);
    localBubblePopupWindow.setFocusable(true);
    localBubblePopupWindow.showAsDropDown(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, aqoa paramaqoa, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), paramaqoa, paramOnClickListener, paramBoolean));
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(true);
    localBubblePopupWindow.setFocusable(true);
    localBubblePopupWindow.setSoftInputMode(1);
    localBubblePopupWindow.setInputMethodMode(2);
    localBubblePopupWindow.b(paramView, paramInt1, paramInt2, paramBoolean);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, aqoa paramaqoa, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), paramaqoa, paramOnClickListener));
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(true);
    localBubblePopupWindow.setFocusable(true);
    localBubblePopupWindow.showAsDropDown(paramView);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, aqoa paramaqoa, View.OnClickListener paramOnClickListener, BubblePopupWindow.b paramb)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), paramaqoa, paramOnClickListener));
    localBubblePopupWindow.a(paramb);
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(true);
    localBubblePopupWindow.setFocusable(true);
    localBubblePopupWindow.showAsDropDown(paramView);
    return localBubblePopupWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqgq
 * JD-Core Version:    0.7.0.1
 */