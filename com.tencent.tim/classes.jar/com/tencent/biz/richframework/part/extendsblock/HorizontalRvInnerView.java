package com.tencent.biz.richframework.part.extendsblock;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.ViewGroup;
import auqt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.ArrayList;
import rxs;
import rxx;
import ryg;
import ryg.a;

public class HorizontalRvInnerView
  extends RecyclerViewCompat
{
  private a jdField_a_of_type_ComTencentBizRichframeworkPartExtendsblockHorizontalRvInnerView$a;
  private ryg jdField_a_of_type_Ryg;
  private LinearLayoutManager mLinearLayoutManager;
  
  public HorizontalRvInnerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalRvInnerView(Context paramContext, ryg paramryg)
  {
    super(paramContext);
    this.jdField_a_of_type_Ryg = paramryg;
    setDescendantFocusability(393216);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartExtendsblockHorizontalRvInnerView$a = new a();
    setAdapter(this.jdField_a_of_type_ComTencentBizRichframeworkPartExtendsblockHorizontalRvInnerView$a);
    this.mLinearLayoutManager = new rxx(getContext(), 0, false);
    setLayoutManager(this.mLinearLayoutManager);
    setOverScrollMode(2);
  }
  
  public void setData(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartExtendsblockHorizontalRvInnerView$a != null) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartExtendsblockHorizontalRvInnerView$a.setDatas(paramArrayList);
    }
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mLinearLayoutManager != null) {
      this.mLinearLayoutManager.setOrientation(paramInt);
    }
  }
  
  public class a
    extends rxs
  {
    public a() {}
    
    public ryg.a b(ViewGroup paramViewGroup, int paramInt)
    {
      if (HorizontalRvInnerView.a(HorizontalRvInnerView.this) != null) {
        return HorizontalRvInnerView.a(HorizontalRvInnerView.this).a(paramViewGroup, paramInt);
      }
      return null;
    }
    
    public int getItemCount()
    {
      if (HorizontalRvInnerView.a(HorizontalRvInnerView.this) != null) {
        return HorizontalRvInnerView.a(HorizontalRvInnerView.this).ug();
      }
      return 0;
    }
    
    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if ((!auqt.b(paramInt, this.mDataList)) && (HorizontalRvInnerView.a(HorizontalRvInnerView.this) != null)) {
        HorizontalRvInnerView.a(HorizontalRvInnerView.this).e(paramViewHolder, paramInt);
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.extendsblock.HorizontalRvInnerView
 * JD-Core Version:    0.7.0.1
 */