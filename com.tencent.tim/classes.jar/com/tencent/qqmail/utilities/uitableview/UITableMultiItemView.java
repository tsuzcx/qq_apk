package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.Iterator;

public class UITableMultiItemView
  extends UITableItemView
{
  private LinearLayout.LayoutParams mItemLayout = new LinearLayout.LayoutParams(-2, -2, 1.0F);
  private ArrayList<View> mViewList = new ArrayList();
  
  public UITableMultiItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public UITableMultiItemView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public void addItemView(View paramView)
  {
    this.mViewList.add(paramView);
  }
  
  public void drawViews()
  {
    removeAllViews();
    Iterator localIterator = this.mViewList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      addView((View)localIterator.next(), this.mItemLayout);
      i += 1;
    }
  }
  
  public final TextView generateTextView(String paramString)
  {
    this.titleView = new TextView(this.context);
    this.titleView.setTextSize(2, 18.0F);
    this.titleView.setGravity(16);
    this.titleView.setDuplicateParentStateEnabled(true);
    QMUIKit.setText(this.titleView, paramString);
    this.titleView.setTextColor(getResources().getColor(2131167519));
    this.titleView.setLayoutParams(this.mItemLayout);
    return this.titleView;
  }
  
  public void removeAllItemView()
  {
    this.mViewList.clear();
  }
  
  public void setTextByIndex(int paramInt, String paramString)
  {
    ((TextView)this.mViewList.get(paramInt)).setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableMultiItemView
 * JD-Core Version:    0.7.0.1
 */