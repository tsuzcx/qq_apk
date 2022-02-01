package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.a;
import ram;
import rsk;
import rsr;

public class InteractContainerLayout
  extends FrameLayout
{
  public StoryVideoItem.a c;
  private final rsk c;
  
  public InteractContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InteractContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Rsk = new rsr(getContext());
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_c_of_type_Rsk.az(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void ex(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$a == null) {
      return;
    }
    this.jdField_c_of_type_Rsk.a(this.jdField_c_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$a.screenWidth, this.jdField_c_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$a.screenHeight, paramInt1, paramInt2, this.jdField_c_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$a.bkn, this.jdField_c_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$a.layoutHeight, this.jdField_c_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$a.bko, this.jdField_c_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$a.bkp, this.jdField_c_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$a.rotation);
    this.jdField_c_of_type_Rsk.acf();
  }
  
  public void a(StoryVideoItem.a parama, int paramInt)
  {
    ram.b("InteractContainerLayout", "bindRateView, layout=%s, rateResult=%s.", parama, Integer.valueOf(paramInt));
    this.jdField_c_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$a = parama;
    if ((parama == null) || (parama.bR.length < 1))
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    rsr localrsr = (rsr)this.jdField_c_of_type_Rsk;
    localrsr.t(parama.bR);
    localrsr.setRatable(false);
    if (paramInt != -2147483648) {}
    for (float f = paramInt;; f = 0.0F)
    {
      localrsr.setRate(f);
      ex(getWidth(), getHeight());
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ex(paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  public void t(StoryVideoItem paramStoryVideoItem)
  {
    ram.b("InteractContainerLayout", "bindRateView, vid=%s", paramStoryVideoItem.mVid);
    a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mRateResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.InteractContainerLayout
 * JD-Core Version:    0.7.0.1
 */