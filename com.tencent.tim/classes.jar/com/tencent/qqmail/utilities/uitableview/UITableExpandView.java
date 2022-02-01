package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class UITableExpandView
  extends UITableView
{
  public static final int MAX_GROUP_EXPANDE = 3;
  public static final int MAX_GROUP_EXPANDE_THRESHOLD = 5;
  private boolean isExpand;
  private List<UITableItemView> itemViewList;
  private UITableItemView showExpandItemView;
  
  public UITableExpandView(Context paramContext)
  {
    super(paramContext);
    initExpandView();
  }
  
  public UITableExpandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initExpandView();
  }
  
  private void initExpandView()
  {
    this.itemViewList = new ArrayList();
    this.showExpandItemView = new UITableItemView(getContext());
    this.showExpandItemView.setTitle(getContext().getString(2131692085));
    this.showExpandItemView.getTitleView().setTextColor(getResources().getColor(2131167522));
    this.showExpandItemView.hideArrow();
    ViewGroup.LayoutParams localLayoutParams = this.showExpandItemView.getTitleView().getLayoutParams();
    localLayoutParams.width = -1;
    this.showExpandItemView.getTitleView().setLayoutParams(localLayoutParams);
    this.showExpandItemView.getTitleView().setGravity(17);
  }
  
  public UITableFormItemView addFormItem(int paramInt)
  {
    UITableFormItemView localUITableFormItemView = super.addFormItem(paramInt);
    this.itemViewList.add(localUITableFormItemView);
    return localUITableFormItemView;
  }
  
  public UITableFormItemView addFormItem(UITableFormItemView paramUITableFormItemView)
  {
    paramUITableFormItemView = super.addFormItem(paramUITableFormItemView);
    this.itemViewList.add(paramUITableFormItemView);
    return paramUITableFormItemView;
  }
  
  public UITableItemView addItem(int paramInt)
  {
    UITableItemView localUITableItemView = super.addItem(paramInt);
    this.itemViewList.add(localUITableItemView);
    return localUITableItemView;
  }
  
  public UITableItemView addItem(UITableItemView paramUITableItemView)
  {
    paramUITableItemView = super.addItem(paramUITableItemView);
    this.itemViewList.add(paramUITableItemView);
    return paramUITableItemView;
  }
  
  public UITableItemView addItem(String paramString)
  {
    paramString = super.addItem(paramString);
    this.itemViewList.add(paramString);
    return paramString;
  }
  
  public UITableItemView addItem(String paramString1, String paramString2)
  {
    paramString1 = super.addItem(paramString1, paramString2);
    this.itemViewList.add(paramString1);
    return paramString1;
  }
  
  public void commit()
  {
    List localList = getItemList();
    localList.clear();
    if (this.itemViewList.size() > 5) {
      if (!isExpand())
      {
        int i = 0;
        while (i < 3)
        {
          localList.add(this.itemViewList.get(i));
          i += 1;
        }
        localList.add(this.showExpandItemView);
      }
    }
    for (;;)
    {
      setItemList(localList);
      super.commit();
      return;
      localList.addAll(this.itemViewList);
      continue;
      localList.addAll(this.itemViewList);
    }
  }
  
  public boolean isExpand()
  {
    return this.isExpand;
  }
  
  public void setClickListener(UITableView.ClickListener paramClickListener)
  {
    super.setClickListener(new UITableExpandView.1(this, paramClickListener));
  }
  
  public void setIsExpand(boolean paramBoolean)
  {
    this.isExpand = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableExpandView
 * JD-Core Version:    0.7.0.1
 */