package com.tencent.biz.pubaccount.readinjoy.comment;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import auts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ksk.a;
import ksu;
import ksv;
import txn;

public class ReadInJoyCommentListView
  extends XListView
{
  public boolean AJ;
  public b a;
  private ksk.a a;
  protected int aDC = 0;
  int aLI = 3;
  boolean ahD;
  private a b = new ksu(this);
  protected RelativeLayout ey;
  int lastFirstVisibleItem;
  protected TextView nI;
  protected ProgressBar z;
  
  public ReadInJoyCommentListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReadInJoyCommentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ReadInJoyCommentListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void Mh()
  {
    Object localObject = getAdapter();
    if ((localObject instanceof auts))
    {
      localObject = (auts)localObject;
      if ((((auts)localObject).getWrappedAdapter() instanceof BaseAdapter)) {
        ((BaseAdapter)((auts)localObject).getWrappedAdapter()).notifyDataSetChanged();
      }
    }
    while (!(localObject instanceof BaseAdapter)) {
      return;
    }
    ((BaseAdapter)localObject).notifyDataSetChanged();
  }
  
  private void aAb()
  {
    if ((yv()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$b != null))
    {
      QLog.d("ReadInJoyCommentListView", 2, "loadingMore| hasMore " + this.AJ);
      aGN();
      this.aDC = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$b.d(this);
    }
  }
  
  private void aGN()
  {
    this.ey.setVisibility(0);
    this.z.setVisibility(0);
    this.nI.setText(2131689615);
    this.nI.setOnClickListener(null);
    this.nI.setVisibility(0);
  }
  
  private void aGO()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$b != null)
    {
      QLog.d("ReadInJoyCommentListView", 2, "preLoadingMore | hasMore " + this.AJ);
      aGN();
      this.aDC = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$b.d(this);
    }
  }
  
  private void init()
  {
    setOnScrollListener(this.b);
  }
  
  private boolean yv()
  {
    if (getAdapter() == null) {}
    while ((getFooterViewsCount() <= 0) || (getLastVisiblePosition() != getAdapter().getCount() - 1)) {
      return false;
    }
    return true;
  }
  
  public void aAc()
  {
    if (this.ey != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentListView", 2, "loadMoreFail");
      }
      this.ey.setVisibility(0);
      this.nI.setVisibility(0);
      this.nI.setOnClickListener(new ksv(this));
      this.z.setVisibility(8);
      this.aDC = 0;
    }
  }
  
  public void aGP()
  {
    this.z.setVisibility(8);
    this.ey.setVisibility(8);
    this.nI.setVisibility(8);
    removeFooterView(this.ey);
  }
  
  public void aGQ()
  {
    if ((this.ey != null) && (getFooterViewsCount() > 0)) {
      this.ey.setVisibility(8);
    }
    QLog.d("ReadInJoyCommentListView", 2, "hideFooterView hasMoreData false");
    this.AJ = false;
  }
  
  public void aGR()
  {
    QLog.d("ReadInJoyCommentListView", 2, "resetFooterView");
    if (getFooterViewsCount() <= 0)
    {
      if (this.ey != null) {
        addFooterView(this.ey, null, false);
      }
    }
    else {
      return;
    }
    initFooterView();
  }
  
  public void aGS()
  {
    if ((this.ey != null) && (getFooterViewsCount() > 0))
    {
      QLog.d("ReadInJoyCommentListView", 2, "hideLoadingFooter");
      this.ey.setVisibility(8);
    }
  }
  
  public void b(AbsListView.e parame)
  {
    if (this.b != null) {
      this.b.b(parame);
    }
  }
  
  public void initFooterView()
  {
    this.ey = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560182, this, false));
    this.z = ((ProgressBar)this.ey.findViewById(2131373845));
    this.nI = ((TextView)this.ey.findViewById(2131373846));
    this.nI.setTextColor(Color.parseColor("#A6A6A6"));
    this.nI.setTextSize(2, 14.0F);
    this.z.setVisibility(8);
    addFooterView(this.ey, null, false);
    setFooterDividersEnabled(false);
  }
  
  public void mH(boolean paramBoolean)
  {
    if (this.ey == null) {
      initFooterView();
    }
    QLog.d("ReadInJoyCommentListView", 2, "loadingMoreComplete | hasNextPage " + paramBoolean);
    this.AJ = paramBoolean;
    if (!paramBoolean) {
      aGP();
    }
    this.aDC = 0;
    Mh();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > this.lastFirstVisibleItem) {
      this.ahD = true;
    }
    for (;;)
    {
      this.lastFirstVisibleItem = paramInt1;
      return;
      if (paramInt1 < this.lastFirstVisibleItem) {
        this.ahD = false;
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      VideoReport.traverseExposure();
      txn.a().stopMonitorScene("list_comment_kandian", false);
      if ((paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.AJ))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentListView", 2, "on the bottom ");
        }
        if (this.aDC == 1) {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyCommentListView", 2, "network request ing");
          }
        }
      }
      do
      {
        do
        {
          return;
          QLog.d("ReadInJoyCommentListView", 2, "loadmore comment by scroll");
          aAb();
          return;
        } while ((paramAbsListView.getCount() - paramAbsListView.getLastVisiblePosition() >= this.aLI) || (!this.AJ) || (!this.ahD));
        if (this.aDC != 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoyCommentListView", 2, "network request ing");
      return;
      QLog.d("ReadInJoyCommentListView", 2, "preLoadingmore comment");
      aGO();
      return;
    }
    txn.a().startMonitorScene("list_comment_kandian");
  }
  
  public void resetState()
  {
    QLog.d("ReadInJoyCommentListView", 2, "resetState hasMoreData false");
    aGR();
    this.AJ = false;
    this.aDC = 0;
    setEmptyView(null);
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    if ((parame instanceof a)) {
      super.setOnScrollListener(this.b);
    }
    while (this.b == null) {
      return;
    }
    this.b.c(parame);
  }
  
  public void setOnScrollOffsetYListener(ksk.a parama)
  {
    this.jdField_a_of_type_Ksk$a = parama;
  }
  
  public void setRefreshCallback(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$b = paramb;
  }
  
  public static class a
    implements AbsListView.e
  {
    private List<AbsListView.e> mListeners = new ArrayList();
    
    public void b(AbsListView.e parame)
    {
      if (this.mListeners != null) {
        this.mListeners.remove(parame);
      }
    }
    
    public void c(AbsListView.e parame)
    {
      if ((this.mListeners != null) && (!this.mListeners.contains(parame))) {
        this.mListeners.add(parame);
      }
    }
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((this.mListeners == null) || (this.mListeners.size() <= 0)) {}
      for (;;)
      {
        return;
        Iterator localIterator = this.mListeners.iterator();
        while (localIterator.hasNext())
        {
          AbsListView.e locale = (AbsListView.e)localIterator.next();
          if (locale != null) {
            locale.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
          }
        }
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((this.mListeners == null) || (this.mListeners.size() <= 0)) {}
      for (;;)
      {
        return;
        Iterator localIterator = this.mListeners.iterator();
        while (localIterator.hasNext())
        {
          AbsListView.e locale = (AbsListView.e)localIterator.next();
          if (locale != null) {
            locale.onScrollStateChanged(paramAbsListView, paramInt);
          }
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void d(ListView paramListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView
 * JD-Core Version:    0.7.0.1
 */