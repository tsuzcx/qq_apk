package com.tencent.qqmail.popularize.view;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.businessfilter.TypePageFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.protocol.DataCollector;
import java.util.ArrayList;

public class PopularizeSubscribeListView
  extends LinearLayout
{
  private Context context;
  private ArrayList<Popularize> data;
  private boolean isRener;
  private OnSubscribeItemClickListener onSubscribeItemClickListener;
  private OnSubscribeItemLongClickListener onSubscribeItemLongClickListener;
  private int page;
  
  public PopularizeSubscribeListView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setOrientation(1);
  }
  
  public OnSubscribeItemClickListener getOnSubscribeItemClickListener()
  {
    return this.onSubscribeItemClickListener;
  }
  
  public OnSubscribeItemLongClickListener getOnSubscribeItemLongClickListener()
  {
    return this.onSubscribeItemLongClickListener;
  }
  
  public int getPage()
  {
    return this.page;
  }
  
  public boolean isRener()
  {
    return this.isRener;
  }
  
  public int render(boolean paramBoolean)
  {
    int j = 0;
    this.data = PopularizeManager.sharedInstance().getPopularize(new TypePageFilter(3, getPage()));
    if ((this.data != null) && ((paramBoolean) || (!isRener())))
    {
      removeAllViews();
      i = 0;
      while (i < this.data.size())
      {
        Popularize localPopularize = (Popularize)this.data.get(i);
        PopularizeSubscribeItemView localPopularizeSubscribeItemView = new PopularizeSubscribeItemView(this.context);
        localPopularizeSubscribeItemView.setPopularize(localPopularize);
        localPopularizeSubscribeItemView.setOnClickListener(new PopularizeSubscribeListView.1(this, i, localPopularize));
        localPopularizeSubscribeItemView.setOnLongClickListener(new PopularizeSubscribeListView.2(this, i, localPopularize));
        DataCollector.logEvent("Event_Bookmail_popularize_Show");
        DataCollector.logDetailEvent("DetailEvent_Bookmail_Popularize_Show", 0L, 0L, localPopularize.getReportId() + "");
        DataCollector.logDetailEventWithDetailMessage("DetailEvent_Bookmail_Popularize_Show", localPopularize.getReportId() + "", 0L, 0L, localPopularize.getReportId() + "");
        DataCollector.submit();
        addView(localPopularizeSubscribeItemView);
        i += 1;
      }
      setRener(true);
    }
    int i = j;
    if (this.data != null) {
      i = this.data.size();
    }
    return i;
  }
  
  public void setOnSubscribeItemClickListener(OnSubscribeItemClickListener paramOnSubscribeItemClickListener)
  {
    this.onSubscribeItemClickListener = paramOnSubscribeItemClickListener;
  }
  
  public void setOnSubscribeItemLongClickListener(OnSubscribeItemLongClickListener paramOnSubscribeItemLongClickListener)
  {
    this.onSubscribeItemLongClickListener = paramOnSubscribeItemLongClickListener;
  }
  
  public void setPage(int paramInt)
  {
    this.page = paramInt;
  }
  
  public void setRener(boolean paramBoolean)
  {
    this.isRener = paramBoolean;
  }
  
  public static abstract interface OnSubscribeItemClickListener
  {
    public abstract void onItemClick(int paramInt, Popularize paramPopularize, View paramView);
  }
  
  public static abstract interface OnSubscribeItemLongClickListener
  {
    public abstract void onItemLongClick(int paramInt, Popularize paramPopularize, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeSubscribeListView
 * JD-Core Version:    0.7.0.1
 */