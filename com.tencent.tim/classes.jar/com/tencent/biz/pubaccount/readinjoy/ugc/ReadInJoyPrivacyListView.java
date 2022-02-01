package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import auts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import mjy;
import wja;

public class ReadInJoyPrivacyListView
  extends XListView
  implements AbsListView.e
{
  private boolean AJ = true;
  private a a;
  private RelativeLayout ey;
  private boolean mIsLoading;
  private TextView nI;
  private ProgressBar z;
  
  public ReadInJoyPrivacyListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReadInJoyPrivacyListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ReadInJoyPrivacyListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void aPA()
  {
    if ((this.ey == null) || (this.z == null) || (this.nI == null)) {
      return;
    }
    this.ey.setVisibility(0);
    this.z.setVisibility(0);
    this.nI.setText(2131718460);
    this.nI.setOnClickListener(null);
    this.nI.setVisibility(0);
  }
  
  private void init()
  {
    setDivider(getResources().getDrawable(2130850276));
    setDividerHeight(wja.dp2px(0.5F, getResources()));
    setOnScrollListener(this);
    initFooterView();
  }
  
  private void initFooterView()
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
  
  private void loadMore()
  {
    this.mIsLoading = true;
    aPA();
    if ((this.AJ) && (this.a != null)) {
      this.a.loadMore();
    }
  }
  
  public void aPB()
  {
    if (this.ey != null)
    {
      this.mIsLoading = false;
      QLog.d("ReadInJoyPrivacyListView", 2, "loadMoreFail");
      this.ey.setVisibility(0);
      this.nI.setText(2131718459);
      this.nI.setVisibility(0);
      this.nI.setOnClickListener(new mjy(this));
      this.z.setVisibility(8);
    }
  }
  
  public void nR(boolean paramBoolean)
  {
    if (this.ey == null) {
      initFooterView();
    }
    this.mIsLoading = false;
    QLog.d("ReadInJoyPrivacyListView", 2, "loading complete " + paramBoolean);
    if (paramBoolean)
    {
      this.nI.setVisibility(8);
      this.z.setVisibility(8);
    }
    for (;;)
    {
      ((BaseAdapter)((auts)getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
      return;
      removeFooterView(this.ey);
      this.AJ = false;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.AJ) && (!this.mIsLoading)) {
      loadMore();
    }
  }
  
  public void setLoadMoreCallback(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void loadMore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListView
 * JD-Core Version:    0.7.0.1
 */