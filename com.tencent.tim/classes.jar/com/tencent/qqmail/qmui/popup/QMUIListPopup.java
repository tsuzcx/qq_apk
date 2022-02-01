package com.tencent.qqmail.qmui.popup;

import android.content.Context;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.qqmail.utilities.ui.WrapContentListView;

public class QMUIListPopup
  extends QMUIPopup
{
  private BaseAdapter mAdapter;
  private ListView mListView;
  
  public QMUIListPopup(Context paramContext, int paramInt, BaseAdapter paramBaseAdapter)
  {
    super(paramContext, paramInt);
    this.mAdapter = paramBaseAdapter;
  }
  
  public void create(int paramInt1, int paramInt2, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mListView = new WrapContentListView(this.mContext, paramInt2);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    this.mListView.setLayoutParams(localLayoutParams);
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setVerticalScrollBarEnabled(false);
    this.mListView.setOnItemClickListener(paramOnItemClickListener);
    setContentView(this.mListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.popup.QMUIListPopup
 * JD-Core Version:    0.7.0.1
 */