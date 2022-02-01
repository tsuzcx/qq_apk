package com.tencent.qqmail.popularize.view;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.businessfilter.TypePageFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.protocol.DataCollector;
import java.util.ArrayList;

public class PopularizeBannerView
  extends LinearLayout
{
  private Context context;
  @Nullable
  private ArrayList<Popularize> data;
  private boolean isRener;
  private OnBannerItemCancelListener onBannerCancelListener;
  private OnBannerItemClickListener onBannerClickListener;
  private int page;
  
  public PopularizeBannerView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setOrientation(1);
  }
  
  public OnBannerItemCancelListener getOnBannerCancelListener()
  {
    return this.onBannerCancelListener;
  }
  
  public OnBannerItemClickListener getOnBannerClickListener()
  {
    return this.onBannerClickListener;
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
    if ((this.data == null) || (paramBoolean)) {
      this.data = PopularizeManager.sharedInstance().getPopularize(new TypePageFilter(0, getPage()));
    }
    return render(paramBoolean, this.data);
  }
  
  int render(boolean paramBoolean, ArrayList<Popularize> paramArrayList)
  {
    int j = 0;
    this.data = paramArrayList;
    if ((this.data != null) && ((paramBoolean) || (!isRener())))
    {
      removeAllViews();
      i = 0;
      while (i < paramArrayList.size())
      {
        Popularize localPopularize = (Popularize)paramArrayList.get(i);
        PopularizeBannerItemView localPopularizeBannerItemView = new PopularizeBannerItemView(this.context);
        localPopularizeBannerItemView.setPopularize(localPopularize);
        localPopularizeBannerItemView.setOnImageClickListener(new PopularizeBannerView.1(this, i, localPopularize));
        localPopularizeBannerItemView.setOnCancelClickListener(new PopularizeBannerView.2(this, i, localPopularize));
        DataCollector.logEvent("Event_Banner_popularize_Show");
        DataCollector.logDetailEvent("DetailEvent_Banner_Popularize_Show", 0L, 0L, localPopularize.getReportId() + "");
        DataCollector.logDetailEventWithDetailMessage("DetailEvent_Banner_Popularize_Show", localPopularize.getReportId() + "", 0L, 0L, localPopularize.getReportId() + "");
        DataCollector.submit();
        addView(localPopularizeBannerItemView);
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
  
  public void setOnBannerCancelListener(OnBannerItemCancelListener paramOnBannerItemCancelListener)
  {
    this.onBannerCancelListener = paramOnBannerItemCancelListener;
  }
  
  public void setOnBannerClickListener(OnBannerItemClickListener paramOnBannerItemClickListener)
  {
    this.onBannerClickListener = paramOnBannerItemClickListener;
  }
  
  public void setPage(int paramInt)
  {
    this.page = paramInt;
  }
  
  public void setRener(boolean paramBoolean)
  {
    this.isRener = paramBoolean;
  }
  
  public static abstract interface OnBannerItemCancelListener
  {
    public abstract void onCancel(int paramInt, Popularize paramPopularize, View paramView);
  }
  
  public static abstract interface OnBannerItemClickListener
  {
    public abstract void onItemClick(int paramInt, Popularize paramPopularize, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeBannerView
 * JD-Core Version:    0.7.0.1
 */