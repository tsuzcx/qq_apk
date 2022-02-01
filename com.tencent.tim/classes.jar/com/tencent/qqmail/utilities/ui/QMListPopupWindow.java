package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class QMListPopupWindow
  extends QMPopupWindow
  implements AdapterView.OnItemClickListener
{
  private boolean canceledOnItemClick = true;
  private ListView mList;
  
  public QMListPopupWindow(Context paramContext, View paramView, ListAdapter paramListAdapter)
  {
    this(paramContext, false);
    setAdapter(paramListAdapter);
    setAnchor(paramView);
  }
  
  public QMListPopupWindow(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }
  
  protected View initContentView(Context paramContext)
  {
    paramContext = (ViewGroup)LayoutInflater.from(paramContext).inflate(2131559773, null);
    this.mList = ((ListView)paramContext.findViewById(2131373504));
    this.mList.setOnItemClickListener(this);
    return paramContext;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    onListItemClick(paramAdapterView, paramView, paramInt, paramLong);
    if (this.canceledOnItemClick) {
      this.mWindow.dismiss();
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public abstract void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
  
  public void setCanceledOnItemClick(boolean paramBoolean)
  {
    this.canceledOnItemClick = paramBoolean;
  }
  
  public void show()
  {
    this.mList.setAdapter(this.mAdapter);
    super.show();
  }
  
  public void showDown()
  {
    this.mList.setAdapter(this.mAdapter);
    super.showDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMListPopupWindow
 * JD-Core Version:    0.7.0.1
 */