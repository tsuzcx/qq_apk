package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.HashSet;
import java.util.Set;
import pwj;
import pwk;
import ram;
import wja;

public class MsgTabStoryNodeView
  extends FrameLayout
{
  Runnable dq = new MsgTabStoryNodeView.1(this);
  public boolean mDetached = true;
  Handler mHandler = new Handler();
  LinearLayoutManager mLinearLayoutManager;
  private int[] mParentLocation = new int[2];
  private float mPressX;
  private float mPressY;
  public RecyclerView mRecyclerView;
  private int mScrollMode;
  boolean mScrolling = false;
  private int[] mStoryBarLocation = new int[2];
  int mTouchSlop;
  Rect mVisibleRect = new Rect();
  public View oe;
  private boolean result;
  public final TextView xc;
  
  public MsgTabStoryNodeView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    inflate(paramContext, 2131561901, this);
    this.mRecyclerView = ((RecyclerView)findViewById(2131376993));
    this.mRecyclerView.addItemDecoration(new a(paramContext));
    this.mRecyclerView.setItemAnimator(null);
    this.xc = ((TextView)findViewById(2131379531));
    this.oe = findViewById(2131370284);
    findViewById(2131379528).setOnClickListener(new pwj(this));
    int i = paramContext.getResources().getColor(2131167311);
    ((ImageView)findViewById(2131368865)).getDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    this.oe.setOnClickListener(new pwk(this, paramContext));
    this.mLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.mLinearLayoutManager.setAutoMeasureEnabled(true);
    this.mRecyclerView.setLayoutManager(this.mLinearLayoutManager);
  }
  
  public void bnv()
  {
    Drawable localDrawable = getContext().getResources().getDrawable(2130846953);
    ram.d("Q.qqstory.msgTab.MsgTabStoryNodeView", "newDrawable %s", String.valueOf(localDrawable));
    if ((localDrawable instanceof SkinnableBitmapDrawable))
    {
      ImageView localImageView = (ImageView)findViewById(2131368931);
      Matrix localMatrix = localImageView.getImageMatrix();
      float f = localImageView.getWidth() * 1.0F / localDrawable.getIntrinsicWidth();
      localMatrix.setScale(f, f, 0.0F, 0.0F);
      localImageView.setImageMatrix(localMatrix);
      localImageView.setImageDrawable(localDrawable);
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      setBackgroundDrawable(getResources().getDrawable(2130839642));
      return;
      ((ImageView)findViewById(2131368931)).setVisibility(8);
    }
  }
  
  public boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      if (this.result)
      {
        paramMotionEvent.offsetLocation(0.0F, this.mParentLocation[1] - this.mStoryBarLocation[1]);
        dispatchTouchEvent(paramMotionEvent);
      }
      return this.result;
      getLocationInWindow(this.mStoryBarLocation);
      paramView.getLocationInWindow(this.mParentLocation);
      if ((f1 >= this.mStoryBarLocation[1]) && (f1 < this.mStoryBarLocation[1] + getHeight())) {}
      for (boolean bool = true;; bool = false)
      {
        this.result = bool;
        this.mPressX = f2;
        this.mPressY = f1;
        this.mScrollMode = 0;
        break;
      }
      f2 = Math.abs(this.mPressX - f2);
      f1 = Math.abs(this.mPressY - f1);
      if ((this.mScrollMode == 0) && (f2 > this.mTouchSlop)) {
        this.mScrollMode = 1;
      }
      if ((this.mScrollMode == 0) && (f1 > this.mTouchSlop)) {
        this.mScrollMode = 2;
      }
      if ((this.mScrollMode == 2) && (this.result))
      {
        this.result = false;
        paramMotionEvent.setAction(3);
        dispatchTouchEvent(paramMotionEvent);
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mDetached = false;
    ram.d("Q.qqstory.msgTab.MsgTabStoryNodeView", "onAttachedToWindow");
    bnv();
    if (this.mRecyclerView.getLayoutManager().getChildCount() != this.mRecyclerView.getChildCount())
    {
      ram.e("Q.qqstory.msgTab.MsgTabStoryNodeView", "onAttachedToWindow recyclerView count not match! reset!");
      this.mLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
      this.mLinearLayoutManager.setAutoMeasureEnabled(true);
      this.mRecyclerView.setLayoutManager(this.mLinearLayoutManager);
      this.mRecyclerView.getAdapter().notifyDataSetChanged();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mDetached = true;
    ram.d("Q.qqstory.msgTab.MsgTabStoryNodeView", "onDetachedFromWindow");
  }
  
  public void onPostThemeChanged()
  {
    int i = getContext().getResources().getColor(2131167311);
    Object localObject = (ImageView)findViewById(2131368865);
    if (localObject != null)
    {
      ((ImageView)localObject).getDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      ((ImageView)localObject).invalidate();
    }
    ((TextView)findViewById(2131379528)).setTextColor(i);
    ((TextView)findViewById(2131379527)).setTextColor(i);
    getContext().getResources().getColor(2131167363);
    getContext().getResources().getDrawable(2130851025);
    this.mRecyclerView.setBackgroundDrawable(null);
    for (localObject = this;; localObject = (View)localObject)
    {
      ram.d("Q.qqstory.msgTab.MsgTabStoryNodeViewVASH", "Debug %s -> back: %s", String.valueOf(localObject), String.valueOf(((View)localObject).getBackground()));
      localObject = ((View)localObject).getParent();
      if ((localObject == null) || (!(localObject instanceof View)))
      {
        bnv();
        return;
      }
    }
  }
  
  public void wd(int paramInt)
  {
    ram.d("Q.qqstory.msgTab.MsgTabStoryNodeView", "updateRedPoint " + paramInt);
    if (paramInt > 99) {
      this.xc.setText("99+");
    }
    while (paramInt <= 0)
    {
      this.xc.setVisibility(8);
      return;
      this.xc.setText(String.valueOf(paramInt));
    }
    this.xc.setVisibility(0);
  }
  
  public static class a
    extends RecyclerView.ItemDecoration
  {
    static final Set<Integer> aH = new HashSet();
    protected int blb;
    protected int blc;
    protected int bld;
    protected int ble;
    protected int blf;
    
    static
    {
      aH.add(Integer.valueOf(1024));
      aH.add(Integer.valueOf(12));
      aH.add(Integer.valueOf(3));
    }
    
    public a(Context paramContext)
    {
      this.blb = wja.dp2px(5.0F, paramContext.getResources());
      this.blc = wja.dp2px(16.0F, paramContext.getResources());
      this.bld = wja.dp2px(8.5F, paramContext.getResources());
      this.ble = wja.dp2px(3.0F, paramContext.getResources());
      this.blf = wja.dp2px(3.0F, paramContext.getResources());
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      int k = paramRecyclerView.getChildViewHolder(paramView).getAdapterPosition();
      paramView = paramRecyclerView.getAdapter();
      if ((k < 0) || (k >= paramView.getItemCount())) {
        return;
      }
      int m = paramView.getItemViewType(k);
      if (paramView.getItemCount() > k + 1)
      {
        int n = paramView.getItemViewType(k + 1);
        int i = 0;
        if (aH.contains(Integer.valueOf(m))) {
          i = 1;
        }
        int j = i;
        if (aH.contains(Integer.valueOf(n))) {
          j = i + 1;
        }
        if (j == 1)
        {
          paramRect.right = this.ble;
          return;
        }
        if (j == 2)
        {
          paramRect.right = this.blf;
          return;
        }
      }
      if (m == 2)
      {
        paramRect.right = this.blc;
        return;
      }
      if (k == paramState.getItemCount() - 1)
      {
        paramRect.right = this.bld;
        return;
      }
      paramRect.right = this.blb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView
 * JD-Core Version:    0.7.0.1
 */