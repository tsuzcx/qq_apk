package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;

public class UITableButtonGroup
  extends LinearLayout
{
  private ArrayList<Button> btnList;
  private LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(-2, -2, 1.0F);
  private Context context;
  private final float density = getResources().getDisplayMetrics().density;
  private LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
  private LinearLayout.LayoutParams mItemLayout = new LinearLayout.LayoutParams(-2, -2, 1.0F);
  
  public UITableButtonGroup(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    this.btnList = new ArrayList();
  }
  
  public Button addBtn(int paramInt)
  {
    Button localButton = new Button(this.context);
    localButton.setBackgroundResource(2130839032);
    localButton.setTextSize(2, 16.0F);
    localButton.setTextColor(getResources().getColor(2131167519));
    localButton.setLayoutParams(this.mItemLayout);
    localButton.setText(paramInt);
    this.btnList.add(localButton);
    return localButton;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    removeAllViews();
    setLayoutParams(this.layoutParams);
    setPadding((int)(this.density * 10.0F), 0, (int)(this.density * 10.0F), 0);
    this.btnParams.leftMargin = ((int)(this.density * 10.0F));
    this.btnParams.rightMargin = ((int)(this.density * 10.0F));
    if ((this.btnList != null) && (this.btnList.size() > 0))
    {
      Iterator localIterator = this.btnList.iterator();
      while (localIterator.hasNext()) {
        addView((Button)localIterator.next(), this.btnParams);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableButtonGroup
 * JD-Core Version:    0.7.0.1
 */