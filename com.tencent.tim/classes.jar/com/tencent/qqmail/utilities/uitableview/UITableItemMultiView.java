package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;

public class UITableItemMultiView
  extends UITableItemBaseView
{
  private LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
  private LinearLayout.LayoutParams mItemLayout = new LinearLayout.LayoutParams(-1, -1, 1.0F);
  private ArrayList<View> viewList = new ArrayList();
  
  public UITableItemMultiView(Context paramContext)
  {
    super(paramContext);
    setCustomerLayoutParmas(this.layoutParams);
    setCustomerPadding(getResources().getDimensionPixelSize(2131299391), 0, getResources().getDimensionPixelSize(2131299392), 0);
  }
  
  public View addItemView(View paramView)
  {
    if ((paramView != null) && (!this.viewList.contains(paramView))) {
      this.viewList.add(paramView);
    }
    return paramView;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    removeAllViews();
    if ((this.viewList != null) && (this.viewList.size() > 0))
    {
      Iterator localIterator = this.viewList.iterator();
      while (localIterator.hasNext()) {
        addView((View)localIterator.next(), this.mItemLayout);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableItemMultiView
 * JD-Core Version:    0.7.0.1
 */