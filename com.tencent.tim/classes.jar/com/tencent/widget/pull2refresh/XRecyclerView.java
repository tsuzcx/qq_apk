package com.tencent.widget.pull2refresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import auwt;
import auwt.a;
import auwy;
import auxe;
import auxf;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;
import npy;

public class XRecyclerView
  extends AbsPullToRefreshView2
  implements auwt.a, auwy
{
  private auwt jdField_a_of_type_Auwt;
  protected RecyclerViewWithHeaderFooter a;
  private XLoadMoreLayout jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout;
  private a jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$a;
  private ThreadLocal<Boolean> m = new auxe(this);
  private int mLastScrollState = 0;
  private int mScrollX;
  private int mScrollY;
  
  public XRecyclerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    a(this);
    LayoutInflater.from(getContext()).inflate(2131563397, this, true);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout = new XLoadMoreLayout(getContext());
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = ((RecyclerViewWithHeaderFooter)findViewById(2131374958));
    this.jdField_a_of_type_Auwt = new auwt(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout, getContext());
    this.jdField_a_of_type_Auwt.uh(true);
    this.jdField_a_of_type_Auwt.a(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.addFooterView(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.addOnScrollListener(new auxf(this));
  }
  
  public boolean B(View paramView)
  {
    boolean bool = ((Boolean)this.m.get()).booleanValue();
    this.m.set(Boolean.valueOf(false));
    if ((this.jdField_a_of_type_Npy != null) && (paramView == this.jdField_a_of_type_Npy.d(this)))
    {
      this.jdField_a_of_type_Npy.pY(bool);
      if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$a != null) {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$a.a(this, bool);
      }
    }
    return true;
  }
  
  @TargetApi(14)
  protected boolean Fi()
  {
    return !this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.canScrollVertically(-1);
  }
  
  @TargetApi(14)
  protected boolean Fj()
  {
    return !this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.canScrollVertically(1);
  }
  
  public void M(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Npy != null) && (paramView == this.jdField_a_of_type_Npy.d(this))) {
      this.jdField_a_of_type_Npy.ag(paramInt, this.ob);
    }
  }
  
  public boolean R(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$a != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$a.a(this, 0);
    }
    return true;
  }
  
  public auwt a()
  {
    return this.jdField_a_of_type_Auwt;
  }
  
  public RecyclerViewWithHeaderFooter a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter;
  }
  
  public void aXi() {}
  
  public void aXj()
  {
    this.m.set(Boolean.valueOf(true));
    tl(1);
  }
  
  public void ad(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XRecyclerView", 2, "loadMoreComplete(): hasMoreData=" + paramBoolean2);
    }
    this.jdField_a_of_type_Auwt.ax(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_Auwt.uh(paramBoolean2);
  }
  
  protected View an()
  {
    View localView = this.jdField_a_of_type_Npy.d(this);
    if ((this.jdField_a_of_type_Npy instanceof ReadInJoySkinAnimManager))
    {
      setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
      return localView;
    }
    setPullHeaderBgDrawable(getResources().getDrawable(2130839645));
    return localView;
  }
  
  protected View ao()
  {
    return null;
  }
  
  public void dd(View paramView)
  {
    if ((this.jdField_a_of_type_Npy != null) && (paramView == this.jdField_a_of_type_Npy.d(this))) {
      this.jdField_a_of_type_Npy.ag(100, this.ob);
    }
  }
  
  public void exW()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.stopScroll();
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.scrollToPosition(0);
  }
  
  public void pn(boolean paramBoolean)
  {
    super.pn(paramBoolean);
    if (this.jdField_a_of_type_Npy != null) {
      this.jdField_a_of_type_Npy.t(paramBoolean, "");
    }
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$a != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$a.aCB();
    }
  }
  
  protected void pp(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.mInterceptTouchEvent = paramBoolean;
  }
  
  public void q(View paramView, boolean paramBoolean) {}
  
  protected int qr()
  {
    return this.jdField_a_of_type_Npy.qC();
  }
  
  public void setRefreshCallback(a parama)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(XRecyclerView paramXRecyclerView, int paramInt);
    
    public abstract void a(XRecyclerView paramXRecyclerView, boolean paramBoolean);
    
    public abstract void aCB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.XRecyclerView
 * JD-Core Version:    0.7.0.1
 */