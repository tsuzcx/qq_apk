package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import hfv;
import hfw;

public class BubbleContextMenu
{
  public static Dialog a(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, CharSequence paramCharSequence)
  {
    Dialog localDialog = new Dialog(paramView.getContext(), 2131624526);
    int i = paramView.getContext().getResources().getDisplayMetrics().widthPixels;
    float f = paramView.getContext().getResources().getDisplayMetrics().density;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i * 3 / 4, -2, 1.0F);
    LinearLayout localLinearLayout = new LinearLayout(paramView.getContext());
    localLinearLayout.setGravity(3);
    localLinearLayout.setOrientation(1);
    int j = paramQQCustomMenu.a();
    i = 0;
    while (i < j)
    {
      if ((i == 0) && (paramCharSequence != null))
      {
        localObject = new Button(paramView.getContext());
        ((Button)localObject).setText(paramCharSequence);
        ((Button)localObject).setContentDescription(paramCharSequence);
        ((Button)localObject).setBackgroundColor(paramView.getContext().getResources().getColor(2131361892));
        ((Button)localObject).setTextColor(paramView.getContext().getResources().getColor(2131361890));
        ((Button)localObject).setSingleLine(true);
        ((Button)localObject).setEllipsize(TextUtils.TruncateAt.END);
        ((Button)localObject).setIncludeFontPadding(true);
        ((Button)localObject).setTextSize(22.0F);
        ((Button)localObject).setGravity(3);
        ((Button)localObject).setPadding((int)(17.0F * f), (int)(11.0F * f), 0, (int)(11.0F * f));
        localLinearLayout.addView((View)localObject);
        localObject = new View(paramView.getContext());
        ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, 4));
        ((View)localObject).setBackgroundColor(paramView.getContext().getResources().getColor(2131361895));
        localLinearLayout.addView((View)localObject);
      }
      Object localObject = paramQQCustomMenu.a(i);
      Button localButton = new Button(paramView.getContext());
      localButton.setText(((QQCustomMenuItem)localObject).a());
      localButton.setContentDescription(((QQCustomMenuItem)localObject).a() + "操作");
      localButton.setBackgroundDrawable(paramView.getContext().getResources().getDrawable(2130837948));
      localButton.setId(((QQCustomMenuItem)localObject).a());
      localButton.setTextColor(paramView.getContext().getResources().getColor(2131361891));
      localButton.setSingleLine(true);
      localButton.setIncludeFontPadding(true);
      localButton.setOnClickListener(paramOnClickListener);
      localButton.setTextSize(18.0F);
      localButton.setGravity(3);
      localButton.setPadding((int)(17.0F * f), (int)(11.0F * f), 0, (int)(11.0F * f));
      localButton.postDelayed(new hfw(localButton), 1000L);
      localButton.setSelected(true);
      localLinearLayout.addView(localButton);
      if (i != j - 1)
      {
        localObject = new ImageView(paramView.getContext());
        ((ImageView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, 1));
        ((ImageView)localObject).setBackgroundColor(paramView.getContext().getResources().getColor(2131361896));
        localLinearLayout.addView((View)localObject);
      }
      i += 1;
    }
    localDialog.addContentView(localLinearLayout, localLayoutParams);
    localDialog.setCanceledOnTouchOutside(true);
    localDialog.show();
    return localDialog;
  }
  
  private static View a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setGravity(17);
    int j = paramQQCustomMenu.a();
    int i = 0;
    if (i < j)
    {
      Object localObject = paramQQCustomMenu.a(i);
      hfv localhfv = new hfv(paramContext, paramBubblePopupWindow);
      if (((QQCustomMenuItem)localObject).a() != null) {
        localhfv.setBackgroundDrawable(((QQCustomMenuItem)localObject).a());
      }
      for (;;)
      {
        localhfv.setContentDescription(((QQCustomMenuItem)localObject).a() + "操作");
        localhfv.setId(((QQCustomMenuItem)localObject).a());
        localhfv.setTextColor(-1);
        localhfv.setIncludeFontPadding(true);
        localhfv.setOnClickListener(paramOnClickListener);
        localhfv.setGravity(17);
        localLinearLayout.addView(localhfv, new LinearLayout.LayoutParams(-2, -2, 1.0F));
        if (i != j - 1)
        {
          localObject = new ImageView(paramContext);
          ((ImageView)localObject).setBackgroundResource(2130837742);
          localLinearLayout.addView((View)localObject, -2, -2);
        }
        i += 1;
        break;
        localhfv.setText(((QQCustomMenuItem)localObject).a());
        localhfv.setBackgroundDrawable(null);
      }
    }
    return localLinearLayout;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    a(paramView, paramQQCustomMenu, paramOnClickListener, null);
    return null;
  }
  
  public static BubblePopupWindow a(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    a(paramView, paramQQCustomMenu, paramOnClickListener, null);
    return null;
  }
  
  public static BubblePopupWindow a(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    a(paramView, paramQQCustomMenu, paramOnClickListener, null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BubbleContextMenu
 * JD-Core Version:    0.7.0.1
 */