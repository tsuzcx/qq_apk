package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import atau.a;
import awit;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView.d;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ndi;
import nek;
import odv;
import wja;

public abstract class ReadInJoyBaseListView
  extends XListView
  implements AbsListView.e
{
  a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$a = new a();
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$b;
  protected c a;
  private d jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$d;
  public int aDC = 0;
  protected int aDD;
  protected int aYh;
  private boolean arF;
  public boolean arG;
  protected boolean arH;
  protected RelativeLayout ey;
  private ArrayList<ListView.d> lD = new ArrayList();
  public int mChannelId;
  protected boolean mIsScrolling;
  private View mn;
  protected TextView nI;
  protected ProgressBar z;
  
  public ReadInJoyBaseListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyBaseListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyBaseListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void aWa()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(62.0F, getResources())));
    TextView localTextView = new TextView(getContext());
    localTextView.setTextColor(-4473925);
    localTextView.setTextSize(14.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(0, 12, 0, 12);
    localTextView.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(localTextView);
    this.mn = localRelativeLayout;
  }
  
  private void op(int paramInt)
  {
    if (this.ey != null) {
      this.ey.setPadding(this.ey.getPaddingLeft(), 0, this.ey.getPaddingRight(), paramInt);
    }
  }
  
  private boolean yv()
  {
    if (getAdapter() == null) {}
    while ((getFooterViewsCount() <= 0) || (getLastVisiblePosition() != getAdapter().getCount() - 1)) {
      return false;
    }
    return true;
  }
  
  public void a(ListView.d paramd)
  {
    this.lD.add(paramd);
  }
  
  public void aWb()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$a.aWb();
    }
  }
  
  public void b(AbsListView.e parame)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$a.d(parame);
    }
  }
  
  public void c(AbsListView.e parame)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$a.c(parame);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$b != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$b.a(this);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$d != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$d.aUH();
      }
    }
  }
  
  protected void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.rE);
    this.arF = paramContext.getBoolean(0, false);
    paramContext.recycle();
    if (this.arF) {
      initFooterView();
    }
    if (odv.aT(this.mChannelId)) {
      aWa();
    }
    super.setOnScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$a);
    c(this);
  }
  
  protected void initFooterView()
  {
    this.ey = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560564, this, false));
    this.z = ((ProgressBar)this.ey.findViewById(2131373845));
    this.nI = ((TextView)this.ey.findViewById(2131373846));
    addFooterView(this.ey);
  }
  
  public void lA(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseListView", 2, "loadMoreComplete(): hasMoreData=" + paramBoolean);
    }
    this.aDC = 0;
    if (this.ey != null)
    {
      this.aYh = 0;
      this.nI.setText(2131701899);
      this.z.setVisibility(8);
      this.ey.setVisibility(8);
      op(-this.aDD);
    }
    setFooterView(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseListView", 2, new Object[] { "loadingMoreComplete mCurrentStatus = ", Integer.valueOf(this.aDC), ", hasMoreData = ", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.aDD < 0) && (this.ey != null))
    {
      this.aDD = this.ey.getHeight();
      op(-this.aDD);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.ey != null) && (this.aYh < 0) && (this.aDC != 1) && (paramInt1 >= paramInt3 - paramInt2 * 2) && ((!odv.aT(this.mChannelId)) || (!this.arG))) {
      ts(2);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.lD.iterator();
    while (localIterator.hasNext()) {
      ((ListView.d)localIterator.next()).j(this.mFirstPosition, getChildCount(), this.mItemCount);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1) {
      if (paramInt != 2) {
        break label25;
      }
    }
    label25:
    for (bool1 = bool2;; bool1 = false)
    {
      this.mIsScrolling = bool1;
      return;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter != null) && ((paramListAdapter instanceof ndi))) {
      ((ndi)paramListAdapter).a(new nek(this));
    }
  }
  
  public void setChannelId(int paramInt)
  {
    this.mChannelId = paramInt;
  }
  
  public void setFooterView(boolean paramBoolean)
  {
    this.arF = paramBoolean;
    if (paramBoolean)
    {
      if (odv.aT(this.mChannelId))
      {
        if (this.mn == null) {
          aWa();
        }
        removeFooterView(this.mn);
      }
      if (this.ey == null) {
        initFooterView();
      }
      if (getFooterViewsCount() <= 0) {
        addFooterView(this.ey);
      }
    }
    do
    {
      return;
      if (odv.aT(this.mChannelId))
      {
        removeFooterView(this.ey);
        if (this.mn == null) {
          aWa();
        }
        if (getFooterViewsCount() <= 0) {
          addFooterView(this.mn);
        }
      }
      if (this.ey == null) {
        initFooterView();
      }
      if ((awit.aMG()) && ((this.mChannelId == 0) || (this.mChannelId == 56)))
      {
        QLog.d("ReadInJoyBaseListView", 1, "independent kd recommend and video channel, keep footer view.");
        return;
      }
    } while (getFooterViewsCount() <= 0);
    removeFooterView(this.ey);
  }
  
  public void setNeedShowFootView(boolean paramBoolean)
  {
    this.arF = paramBoolean;
    initFooterView();
  }
  
  public void setNoMoreData(boolean paramBoolean)
  {
    if (paramBoolean != this.arG)
    {
      this.arG = paramBoolean;
      if (!this.arG) {
        break label74;
      }
      if (odv.aT(this.mChannelId))
      {
        if (this.mn == null) {
          aWa();
        }
        if (this.ey != null) {
          removeFooterView(this.ey);
        }
        if (getFooterViewsCount() <= 0) {
          addFooterView(this.mn);
        }
      }
    }
    label74:
    while (this.mn == null) {
      return;
    }
    removeFooterView(this.mn);
  }
  
  public void setOnDrawCompleteListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$b = paramb;
  }
  
  public final void setOnScrollListener(AbsListView.e parame)
  {
    throw new RuntimeException("use addScrollListener  or removeScrollListener，better call addScrollListener in ReadInJoyBaseAdapter.onAddScrollListeners for control the call sequence");
  }
  
  public void setRefreshCallback(c paramc)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$c = paramc;
  }
  
  public void setScrollEventCallback(d paramd)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$d = paramd;
  }
  
  public void ts(int paramInt)
  {
    if (this.arH) {}
    do
    {
      do
      {
        return;
        if (paramInt == 4) {
          break;
        }
      } while ((!yv()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$c == null));
      this.ey.setVisibility(0);
      this.nI.setText(2131701900);
      this.z.setVisibility(0);
      op(0);
      this.aDC = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$c.b(this, paramInt);
      return;
      if (yv())
      {
        this.ey.setVisibility(0);
        this.nI.setText(2131701900);
        this.z.setVisibility(0);
        op(0);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$c == null);
    this.aDC = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$c.b(this, paramInt);
  }
  
  public static class a
    implements AbsListView.e
  {
    List<AbsListView.e> mListeners = new ArrayList();
    
    void aWb()
    {
      this.mListeners.clear();
    }
    
    public void c(AbsListView.e parame)
    {
      if (!this.mListeners.contains(parame)) {
        this.mListeners.add(parame);
      }
    }
    
    public void d(AbsListView.e parame)
    {
      this.mListeners.remove(parame);
    }
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
      {
        AbsListView.e locale = (AbsListView.e)localIterator.next();
        try
        {
          locale.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
        }
        catch (Throwable localThrowable) {}
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyBaseListView", 2, "onScroll exp", localThrowable);
        }
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
      {
        AbsListView.e locale = (AbsListView.e)localIterator.next();
        try
        {
          locale.onScrollStateChanged(paramAbsListView, paramInt);
        }
        catch (Throwable localThrowable) {}
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseListView", 2, "onScrollStateChanged exp", localThrowable);
        }
      }
      if (paramInt == 0) {
        VideoReport.traverseExposure();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(ReadInJoyBaseListView paramReadInJoyBaseListView);
  }
  
  public static abstract interface c
  {
    public abstract void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt);
    
    public abstract void aCB();
    
    public abstract void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void aUH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView
 * JD-Core Version:    0.7.0.1
 */