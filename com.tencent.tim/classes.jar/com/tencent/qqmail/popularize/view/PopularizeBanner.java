package com.tencent.qqmail.popularize.view;

import android.content.Context;
import android.widget.ListView;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.businessfilter.TypePageFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import java.util.ArrayList;

public class PopularizeBanner
{
  private ArrayList<Popularize> data;
  @Nullable
  private PopularizeBannerView.OnBannerItemCancelListener onBannerCancelListener;
  @Nullable
  private PopularizeBannerView.OnBannerItemClickListener onBannerClickListener;
  @Nullable
  private PopularizeBannerView popularizeBannerView;
  private final int popularizePage;
  
  public PopularizeBanner(@IntRange(from=-1L, to=11L) int paramInt)
  {
    this.popularizePage = paramInt;
    this.data = PopularizeManager.sharedInstance().getPopularize(new TypePageFilter(0, paramInt));
  }
  
  private void initPopularizeBannerView(ListView paramListView, int paramInt)
  {
    Context localContext = paramListView.getContext();
    this.popularizeBannerView = new PopularizeBannerView(localContext);
    this.popularizeBannerView.setPage(paramInt);
    this.popularizeBannerView.setOnBannerClickListener(new PopularizeBanner.1(this, localContext));
    this.popularizeBannerView.setOnBannerCancelListener(new PopularizeBanner.2(this));
    paramListView.addHeaderView(this.popularizeBannerView, null, false);
  }
  
  public int getDataCount()
  {
    if (this.data == null) {
      return 0;
    }
    return this.data.size();
  }
  
  public void remove(ListView paramListView)
  {
    if (this.popularizeBannerView != null) {
      paramListView.removeHeaderView(this.popularizeBannerView);
    }
  }
  
  public int render(ListView paramListView, boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.popularizeBannerView != null) && (this.popularizeBannerView.isRener())) {}
    label137:
    label149:
    label157:
    for (;;)
    {
      return 0;
      int i;
      int j;
      if (paramBoolean) {
        if (this.data == null)
        {
          i = 0;
          this.data = PopularizeManager.sharedInstance().getPopularize(new TypePageFilter(0, this.popularizePage));
          if (this.data != null) {
            break label137;
          }
          j = 0;
          label68:
          if (j == i) {
            break label149;
          }
          i = 1;
        }
      }
      for (;;)
      {
        if ((i == 0) && ((this.data == null) || (this.data.size() == 0))) {
          break label157;
        }
        if (this.popularizeBannerView == null) {
          initPopularizeBannerView(paramListView, this.popularizePage);
        }
        return this.popularizeBannerView.render(paramBoolean, this.data);
        i = this.data.size();
        break;
        j = this.data.size();
        break label68;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  public void setOnBannerCancelListener(PopularizeBannerView.OnBannerItemCancelListener paramOnBannerItemCancelListener)
  {
    this.onBannerCancelListener = paramOnBannerItemCancelListener;
  }
  
  public void setOnBannerClickListener(PopularizeBannerView.OnBannerItemClickListener paramOnBannerItemClickListener)
  {
    this.onBannerClickListener = paramOnBannerItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeBanner
 * JD-Core Version:    0.7.0.1
 */