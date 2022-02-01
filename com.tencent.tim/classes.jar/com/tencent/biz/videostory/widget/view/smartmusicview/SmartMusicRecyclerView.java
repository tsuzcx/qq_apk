package com.tencent.biz.videostory.widget.view.smartmusicview;

import NS_QQ_STORY_META.META.StMusic;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;
import srq;
import srs.a;
import ssa;
import ssa.a;
import ssd;
import wja;

public class SmartMusicRecyclerView
  extends RecyclerView
{
  private ssa a;
  private boolean aME = true;
  private boolean aMN;
  private srs.a jdField_b_of_type_Srs$a;
  private ssa.a jdField_b_of_type_Ssa$a;
  private srq c;
  private int mLastPosition;
  
  public SmartMusicRecyclerView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public SmartMusicRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmartMusicRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void bAA()
  {
    if (this.jdField_b_of_type_Ssa$a != null)
    {
      this.jdField_b_of_type_Ssa$a.vb(false);
      this.jdField_b_of_type_Ssa$a.showProgressBar(false);
      this.jdField_b_of_type_Ssa$a.bAy();
    }
  }
  
  private void c(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      if ((this.jdField_b_of_type_Ssa$a != null) && (this.aMN) && (this.aME))
      {
        this.jdField_b_of_type_Ssa$a.showCover();
        this.jdField_b_of_type_Ssa$a.bAz();
      }
      if (!this.aMN)
      {
        int i = this.c.getCurrentPosition() + 1;
        paramRecyclerView.smoothScrollToPosition(i);
        bAA();
        this.jdField_b_of_type_Ssa$a = ((ssa.a)paramRecyclerView.findViewHolderForAdapterPosition(i));
        if ((this.jdField_b_of_type_Srs$a != null) && (this.mLastPosition != i))
        {
          this.mLastPosition = i;
          this.jdField_b_of_type_Srs$a.b(i, this.jdField_b_of_type_Ssa$a);
        }
        this.aMN = true;
      }
    }
    if (((paramInt == 1) || (paramInt == 2)) && (paramInt == 1))
    {
      bAA();
      this.aMN = false;
    }
  }
  
  private void initView()
  {
    this.c = new srq(getContext(), wja.dp2px(120.0F, getContext().getResources()));
    setLayoutManager(this.c);
    this.a = new ssa();
    setAdapter(this.a);
    addOnScrollListener(new ssd(this));
  }
  
  public srq a()
  {
    return this.c;
  }
  
  public void setHasAutoSet(boolean paramBoolean)
  {
    this.aMN = paramBoolean;
  }
  
  public void setLastPosition(int paramInt)
  {
    this.mLastPosition = paramInt;
  }
  
  public void setListener(srs.a parama)
  {
    this.jdField_b_of_type_Srs$a = parama;
    if (this.a != null) {
      this.a.setListener(parama);
    }
  }
  
  public void setMusicData(List<META.StMusic> paramList)
  {
    if (paramList != null) {
      this.a.setData(paramList);
    }
  }
  
  public void setNeedScale(boolean paramBoolean)
  {
    this.aME = paramBoolean;
    a().setNeedScale(paramBoolean);
    if (this.jdField_b_of_type_Ssa$a != null) {
      if (!paramBoolean) {
        break label55;
      }
    }
    label55:
    for (float f = a().getMaxScale();; f = 1.0F)
    {
      this.jdField_b_of_type_Ssa$a.itemView.setScaleY(f);
      this.jdField_b_of_type_Ssa$a.itemView.setScaleX(f);
      return;
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (paramInt - 1 < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      smoothScrollBy(0, a().eq(paramInt));
      return;
      paramInt -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView
 * JD-Core Version:    0.7.0.1
 */