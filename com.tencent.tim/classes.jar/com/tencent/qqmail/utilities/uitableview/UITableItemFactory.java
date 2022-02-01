package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class UITableItemFactory
{
  public static int UITableItemTypeBottom = 2;
  public static int UITableItemTypeMiddle;
  public static int UITableItemTypeSingle = 3;
  public static int UITableItemTypeTop = 0;
  
  static
  {
    UITableItemTypeMiddle = 1;
  }
  
  public static TextView addBodyTextView(Context paramContext)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setPadding(paramContext.getResources().getDimensionPixelSize(2131299392), paramContext.getResources().getDimensionPixelSize(2131299402), paramContext.getResources().getDimensionPixelSize(2131299392), paramContext.getResources().getDimensionPixelSize(2131299402));
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localTextView.setGravity(19);
    localTextView.setTextSize(2, 20.0F);
    localTextView.setTextColor(paramContext.getResources().getColor(2131167519));
    return localTextView;
  }
  
  public static TextView addCenterTextView(Context paramContext)
  {
    return addCenterTextView(paramContext, 2130845610);
  }
  
  public static TextView addCenterTextView(Context paramContext, int paramInt)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setBackgroundResource(paramInt);
    localTextView.setPadding(paramContext.getResources().getDimensionPixelSize(2131297032), 0, paramContext.getResources().getDimensionPixelSize(2131297032), 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, paramContext.getResources().getDimensionPixelSize(2131297616));
    localLayoutParams.setMargins(0, paramContext.getResources().getDimensionPixelSize(2131299376), 0, paramContext.getResources().getDimensionPixelSize(2131299375));
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setGravity(17);
    localTextView.setTextSize(2, 16.0F);
    localTextView.setTextColor(paramContext.getResources().getColorStateList(2131166580));
    return localTextView;
  }
  
  public static EditText addEditText(Context paramContext, int paramInt)
  {
    EditText localEditText = new EditText(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(0, paramContext.getResources().getDimensionPixelSize(2131299376), 0, paramContext.getResources().getDimensionPixelSize(2131299375));
    if (paramInt == UITableItemTypeTop)
    {
      localEditText.setBackgroundResource(2130841257);
      localLayoutParams.setMargins(0, paramContext.getResources().getDimensionPixelSize(2131299376), 0, 0);
    }
    for (;;)
    {
      localEditText.setPadding(paramContext.getResources().getDimensionPixelSize(2131299392), paramContext.getResources().getDimensionPixelSize(2131299402), paramContext.getResources().getDimensionPixelSize(2131299392), paramContext.getResources().getDimensionPixelSize(2131299402));
      localEditText.setGravity(3);
      localEditText.setLayoutParams(localLayoutParams);
      localEditText.setHintTextColor(paramContext.getResources().getColor(2131167534));
      localEditText.setTextColor(paramContext.getResources().getColor(2131165381));
      localEditText.setText("");
      localEditText.setCursorVisible(true);
      return localEditText;
      if (paramInt == UITableItemTypeMiddle)
      {
        localEditText.setBackgroundResource(2130841254);
        localLayoutParams.setMargins(0, 0, 0, 0);
      }
      else if (paramInt == UITableItemTypeBottom)
      {
        localEditText.setBackgroundResource(2130841245);
        localLayoutParams.setMargins(0, 0, 0, paramContext.getResources().getDimensionPixelSize(2131299375));
      }
      else if (paramInt == UITableItemTypeSingle)
      {
        localEditText.setBackgroundResource(2130841255);
        localLayoutParams.setMargins(0, paramContext.getResources().getDimensionPixelSize(2131299376), 0, paramContext.getResources().getDimensionPixelSize(2131299375));
      }
    }
  }
  
  public static LinearLayout addLoadingView(Context paramContext)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = ((int)(10.0F * QMUIKit.DENSITY));
    paramContext = new LinearLayout(paramContext);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setGravity(17);
    paramContext.addView(new QMLoading(QMApplicationContext.sharedInstance(), QMUIKit.dpToPx(36), 1));
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableItemFactory
 * JD-Core Version:    0.7.0.1
 */