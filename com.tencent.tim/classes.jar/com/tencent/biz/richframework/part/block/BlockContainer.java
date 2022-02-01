package com.tencent.biz.richframework.part.block;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import rxj;
import rxn;
import rxn.b;
import rxn.c;
import rxq;
import rxx;
import rxy;

public class BlockContainer
  extends FrameLayout
{
  private static final String TAG = BlockContainer.class.getSimpleName();
  protected NestScrollRecyclerView a;
  private StatusView b;
  protected rxn mBlockMerger;
  private ExtraTypeInfo mExtraTypeInfo;
  private RecyclerView.LayoutManager mLayoutManager;
  private Fragment mParentFragment;
  
  public BlockContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BlockContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BlockContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  @NotNull
  private rxn a()
  {
    return new rxn(this);
  }
  
  public boolean Me()
  {
    if (this.mBlockMerger != null) {
      return this.mBlockMerger.Me();
    }
    return false;
  }
  
  public NestScrollRecyclerView a()
  {
    return this.a;
  }
  
  public StatusView a()
  {
    return this.b;
  }
  
  protected StatusView a(View paramView)
  {
    paramView = new StatusView(getContext());
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    paramView.setVisibility(8);
    return paramView;
  }
  
  public void a(rxn.c paramc)
  {
    if (this.mBlockMerger != null) {
      this.mBlockMerger.b(paramc);
    }
  }
  
  public void a(rxq paramrxq)
  {
    if (this.mBlockMerger != null) {
      this.mBlockMerger.a(paramrxq);
    }
  }
  
  public void b(rxq paramrxq)
  {
    if (this.mBlockMerger != null) {
      this.mBlockMerger.b(paramrxq);
    }
  }
  
  protected void c(FrameLayout paramFrameLayout)
  {
    this.a = ((NestScrollRecyclerView)paramFrameLayout.findViewById(2131364399));
    this.a.setHasFixedSize(true);
    this.a.setNestedScrollingEnabled(false);
    this.mBlockMerger = a();
    this.a.setAdapter(this.mBlockMerger);
    this.a.addItemDecoration(new a(this.mBlockMerger));
    setLayoutManagerType(1, 1);
    this.a.setItemAnimator(null);
    this.a.setOverScrollMode(2);
    this.b = a(paramFrameLayout);
    this.b.setVisibility(8);
    addView(this.b, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void cx(ArrayList<rxq> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((rxq)paramArrayList.next());
    }
  }
  
  public rxn getBlockMerger()
  {
    return this.mBlockMerger;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    if (this.mExtraTypeInfo == null) {
      this.mExtraTypeInfo = new ExtraTypeInfo();
    }
    return this.mExtraTypeInfo;
  }
  
  public Fragment getFragment()
  {
    if (this.mParentFragment == null) {}
    return this.mParentFragment;
  }
  
  protected int getLayoutId()
  {
    return 2131558837;
  }
  
  protected void initView()
  {
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    c(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public boolean onBackEvent()
  {
    if (this.mBlockMerger != null) {
      return this.mBlockMerger.onBackEvent();
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      if ((this.a.getLayoutManager() instanceof LinearLayoutManager)) {
        ((LinearLayoutManager)this.a.getLayoutManager()).setRecycleChildrenOnDetach(true);
      }
      this.a.setAdapter(null);
    }
    if (this.mBlockMerger != null) {
      this.mBlockMerger.destroy();
    }
    if ((a() != null) && (a().n() != null)) {
      a().n().setImageDrawable(null);
    }
    this.mParentFragment = null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void setBlockWrapper(rxj paramrxj)
  {
    if (this.mBlockMerger != null) {
      this.mBlockMerger.setBlockWrapper(paramrxj);
    }
  }
  
  public void setEnableLoadMore(boolean paramBoolean)
  {
    if (this.mBlockMerger != null) {
      this.mBlockMerger.setEnableLoadMore(paramBoolean);
    }
  }
  
  public void setEnableRefresh(boolean paramBoolean)
  {
    if (this.mBlockMerger != null) {
      this.mBlockMerger.setEnableRefresh(paramBoolean);
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setLayoutManagerType(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.a.setLayoutManager(this.mLayoutManager);
      this.mBlockMerger.b(this.mLayoutManager);
      return;
      this.mLayoutManager = new rxx(getContext(), 1, false);
      continue;
      this.mLayoutManager = new GridLayoutManager(getContext(), paramInt2);
      ((GridLayoutManager)this.mLayoutManager).setSpanSizeLookup(this.mBlockMerger.a());
      continue;
      this.a.setHasFixedSize(false);
      this.mLayoutManager = new rxy(paramInt2, 1);
      ((rxy)this.mLayoutManager).setGapStrategy(0);
    }
  }
  
  public void setParentFragment(Fragment paramFragment)
  {
    this.mParentFragment = paramFragment;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (this.mBlockMerger != null)
    {
      if ((paramBoolean) && (!this.mBlockMerger.isRefreshing())) {
        this.mBlockMerger.setRefreshing(true);
      }
      if ((!paramBoolean) && (this.mBlockMerger.isRefreshing())) {
        this.mBlockMerger.setRefreshing(false);
      }
    }
  }
  
  public void setShareData(String paramString, rxn.b paramb)
  {
    if (this.mBlockMerger != null) {
      this.mBlockMerger.setShareData(paramString, paramb);
    }
  }
  
  public void start()
  {
    if (this.mBlockMerger != null) {
      this.mBlockMerger.bxm();
    }
  }
  
  public class a
    extends RecyclerView.ItemDecoration
  {
    public a(rxn paramrxn) {}
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
      int i = paramRecyclerView.getChildLayoutPosition(paramView);
      if ((BlockContainer.this.mBlockMerger != null) && (BlockContainer.this.mBlockMerger.a(i) != null)) {
        BlockContainer.this.mBlockMerger.a(i).getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
      }
    }
    
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      super.onDraw(paramCanvas, paramRecyclerView, paramState);
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        if ((BlockContainer.this.mBlockMerger != null) && (BlockContainer.this.mBlockMerger.a(i) != null))
        {
          View localView = paramRecyclerView.getChildAt(i);
          BlockContainer.this.mBlockMerger.a(i).onDrawItemDecoration(paramCanvas, paramRecyclerView, localView, paramState);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.BlockContainer
 * JD-Core Version:    0.7.0.1
 */