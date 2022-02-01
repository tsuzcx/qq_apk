package com.tencent.biz.qqstory.view.segment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.biz.qqstory.base.QQStoryIllegalException;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView.a;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AbsListView.g;
import com.tencent.widget.ListView;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import jqi;
import ppe;
import qwp;
import ram;
import rom;
import rrw;
import rrx;
import rry;
import rrz;
import rsa;
import rsb;
import rsb.a;
import rsd;
import rsn;
import rsn.a;

public abstract class SegmentList
  extends QQStoryPullToRefreshListView
  implements AbsListView.g, rsb.a
{
  public static int ERROR_CODE_SUCCESS;
  public static int buJ = 1;
  public static int buK = 2;
  private AbsListView.g jdField_a_of_type_ComTencentWidgetAbsListView$g;
  public rsb a;
  private rsn jdField_a_of_type_Rsn;
  private String aBP;
  private String aBQ = "default";
  private boolean aJx;
  protected boolean aJy;
  private int buL = -1;
  private boolean isDestroy;
  private Handler mHandler;
  private AbsListView.e mOnScrollListener;
  
  public SegmentList(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SegmentList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SegmentList(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean g(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.isDestroy) {
        return false;
      }
      setAdapter(this.jdField_a_of_type_Rsb);
      brz();
    }
  }
  
  private void init()
  {
    this.jdField_a_of_type_Rsb = new rsb(this, this);
    this.mHandler = new Handler(Looper.getMainLooper(), new rrw(this));
    super.setRecyclerListener(this);
    super.setDragEnable(true);
    super.setSwipListListener(new rrx(this));
    super.setRightIconMenuListener(new rry(this));
  }
  
  public boolean LZ()
  {
    return this.aJx;
  }
  
  public <T extends rsd> T a(String paramString)
  {
    return this.jdField_a_of_type_Rsb.a(paramString);
  }
  
  public rsn a(@NonNull String paramString)
  {
    rom.sF(paramString);
    if (paramString.equals(this.aBP)) {
      return this.jdField_a_of_type_Rsn;
    }
    return null;
  }
  
  public void a(@NonNull rsd paramrsd)
  {
    this.jdField_a_of_type_Rsb.a(paramrsd);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.e.S(0L);
    if (!jqi.isNetworkAvailable(getContext().getApplicationContext()))
    {
      eu(1, buJ);
      return true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView$a.pullToRefresh();
    return true;
  }
  
  protected void ae(boolean paramBoolean, int paramInt) {}
  
  protected void af(boolean paramBoolean, int paramInt) {}
  
  public void azy()
  {
    this.jdField_a_of_type_Rsb.notifyDataSetChanged();
  }
  
  protected abstract void box();
  
  public void bqW()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.jdField_a_of_type_Rsn = new rsn(localLoadMoreLayout, getContext().getApplicationContext());
    this.jdField_a_of_type_Rsn.ax(true, false);
    super.addFooterView(localLoadMoreLayout);
    super.setOnScrollListener(this);
  }
  
  public void brA() {}
  
  public void brD()
  {
    this.jdField_a_of_type_Rsb.tO(true);
  }
  
  public void brz()
  {
    brD();
  }
  
  public void eu(int paramInt1, int paramInt2)
  {
    qwp.w("SwipListView", new Object[] { "allRequestCompletedButOccurError ", Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    case 2: 
    default: 
      return;
    case 1: 
      if (this.e != null)
      {
        this.e.tT(1);
        super.postDelayed(new SegmentList.7(this), 800L);
      }
      af(false, paramInt2);
      return;
    }
    if (!this.aJy)
    {
      brA();
      this.aJy = true;
    }
    ae(false, paramInt2);
  }
  
  public void layoutChildren()
  {
    try
    {
      super.layoutChildren();
      this.jdField_a_of_type_Rsb.bwb();
      if (this.aJx) {
        this.aBQ = this.jdField_a_of_type_Rsb.nd();
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ram.e("SwipListView", localIllegalStateException.toString() + " ##info: mItemCount=" + this.mItemCount + "mAdapter.getCount()=" + this.jdField_a_of_type_Rsb.getCount() + " .last segmentSimpleInfo=" + this.aBQ + " ,and current segmentSimpleInfo=" + this.jdField_a_of_type_Rsb.nd());
      if (!this.aJx) {
        throw localIllegalStateException;
      }
      if (this.mItemCount == this.jdField_a_of_type_Rsb.getCount()) {
        throw localIllegalStateException;
      }
      throw new QQStoryIllegalException(localIllegalStateException.toString() + " ##info: mItemCount=" + this.mItemCount + "mAdapter.getCount()=" + this.jdField_a_of_type_Rsb.getCount() + " .last segmentSimpleInfo=" + this.aBQ + " ,and current segmentSimpleInfo=" + this.jdField_a_of_type_Rsb.nd());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Rsb.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate()
  {
    setPullToRefreshListener(new rrz(this));
    box();
    this.jdField_a_of_type_Rsb.onCreate();
    Bosses.get().postJob(new rsa(this, "SwipListView"));
  }
  
  public void onDestroy()
  {
    this.isDestroy = true;
    this.mHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Rsb.onDestroy();
  }
  
  public void onMovedToScrapHeap(View paramView)
  {
    this.jdField_a_of_type_Rsb.onMovedToScrapHeap(paramView);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$g != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$g.onMovedToScrapHeap(paramView);
    }
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_Rsb.onPause();
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_Rsb.onResume();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.buL) {}
    do
    {
      return;
      this.buL = paramInt1;
    } while (paramInt3 - (paramInt1 + paramInt2) > this.jdField_a_of_type_Rsn.tV());
    this.jdField_a_of_type_Rsn.ui(true);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void pn(boolean paramBoolean)
  {
    super.pn(paramBoolean);
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    this.jdField_a_of_type_Rsb.wG(paramInt);
  }
  
  public void resetAdapter()
  {
    if (this.aJx) {
      super.setAdapter(this.jdField_a_of_type_Rsb);
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof rsb))
    {
      super.setAdapter(paramListAdapter);
      this.aJx = true;
      return;
    }
    throw new QQStoryIllegalException("SegmentList do not necessary call setAdapter()");
  }
  
  public void setLoadMoreComplete(@NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    rom.sF(paramString);
    if (paramString.equals(this.aBP)) {
      this.jdField_a_of_type_Rsn.ax(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setOnLoadMoreListener(@NonNull String paramString, rsn.a parama)
  {
    this.jdField_a_of_type_Rsn.setOnLoadMoreListener(parama);
    this.aBP = paramString;
    rom.sF(paramString);
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.mOnScrollListener = parame;
  }
  
  public void setRecyclerListener(AbsListView.g paramg)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$g = paramg;
  }
  
  public void sk(@NonNull String paramString)
  {
    this.jdField_a_of_type_Rsb.sk(paramString);
  }
  
  public void xT(int paramInt)
  {
    qwp.w("SwipListView", new Object[] { "allRequestCompletedAndSuccess ", Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 1: 
      if (this.e != null)
      {
        this.e.tT(0);
        super.postDelayed(new SegmentList.6(this), 800L);
      }
      af(true, ERROR_CODE_SUCCESS);
      return;
    }
    if (!this.aJy)
    {
      brA();
      this.aJy = true;
    }
    ae(true, ERROR_CODE_SUCCESS);
  }
  
  public static abstract interface a
    extends ppe
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentList
 * JD-Core Version:    0.7.0.1
 */