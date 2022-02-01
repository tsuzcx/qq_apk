package dov.com.qq.im.ae.camera.ui.bottom;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.View;
import awxq.b;
import awyh;
import awyh.c;
import awyj;
import awyj.b;
import axbu;
import spo;

public class AEBottomListScrollView
  extends RecyclerView
{
  private static final String TAG = AEBottomListScrollView.class.getSimpleName();
  private b jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$b;
  private c jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$c;
  private awyh b;
  private boolean dtB;
  
  public AEBottomListScrollView(Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public AEBottomListScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public AEBottomListScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private void b(float paramFloat, int paramInt1, int paramInt2, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$c != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$c.a(paramFloat, paramInt1, paramInt2, paramViewHolder1, paramViewHolder2);
    }
  }
  
  private void eHO()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$b == null) {
      return;
    }
    int i = this.b.getCurrentPosition();
    k(a(i), i);
  }
  
  private void i(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$c != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$c.h(paramViewHolder, paramInt);
    }
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    if (getOverScrollMode() != 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.dtB = bool;
      this.b = new awyh(getContext(), new d(null), new awyj.b());
      setLayoutManager(this.b);
      return;
    }
  }
  
  private void j(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$b != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$b.d(paramViewHolder, true);
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$c != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$c.g(paramViewHolder, paramInt);
    }
  }
  
  private void k(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$b != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$b.f(paramViewHolder, paramInt);
    }
  }
  
  @Nullable
  public RecyclerView.ViewHolder a(int paramInt)
  {
    View localView = this.b.findViewByPosition(paramInt);
    if (localView != null) {
      return getChildViewHolder(localView);
    }
    return null;
  }
  
  public void a(int paramInt, axbu paramaxbu)
  {
    awxq.b localb = (awxq.b)a(this.b.getCurrentPosition());
    if (localb != null) {
      localb.adx(4);
    }
    localb = (awxq.b)a(paramInt);
    if (localb != null)
    {
      localb.g(paramaxbu);
      localb.adx(3);
      if ((paramaxbu != null) && (paramaxbu.usable)) {
        localb.adx(2);
      }
      scrollToPosition(paramInt);
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = super.fling(paramInt1, paramInt2);
    if (bool)
    {
      this.b.lt(paramInt1, paramInt2);
      return bool;
    }
    this.b.eHJ();
    return bool;
  }
  
  public int getCurrentItem()
  {
    return this.b.getCurrentPosition();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.b.b(null);
  }
  
  public void setClampTransformProgressAfter(@IntRange(from=1L) int paramInt)
  {
    if (paramInt <= 1) {
      throw new IllegalArgumentException("must be >= 1");
    }
    this.b.adC(paramInt);
  }
  
  public void setItemTransformer(spo paramspo)
  {
    this.b.setItemTransformer(paramspo);
  }
  
  public void setItemTransitionTimeMillis(@IntRange(from=10L) int paramInt)
  {
    this.b.adB(paramInt);
  }
  
  public void setLayoutCallback(a parama)
  {
    if (this.b != null) {
      this.b.setLayoutCallback(parama);
    }
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof awyh))
    {
      super.setLayoutManager(paramLayoutManager);
      return;
    }
    throw new IllegalArgumentException("please use special on ");
  }
  
  public void setOffscreenItems(int paramInt)
  {
    this.b.setOffscreenItems(paramInt);
  }
  
  public void setOnItemChangedListener(@NonNull b<?> paramb)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$b = paramb;
  }
  
  public void setOrientation(awyj paramawyj)
  {
    this.b.setOrientation(paramawyj);
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.dtB = paramBoolean;
    setOverScrollMode(2);
  }
  
  public void setScrollStateChangeListener(@NonNull c<?> paramc)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$c = paramc;
  }
  
  public void setSlideOnFling(boolean paramBoolean)
  {
    this.b.XV(paramBoolean);
  }
  
  public void setSlideOnFlingThreshold(int paramInt)
  {
    this.b.setSlideOnFlingThreshold(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void eHF();
  }
  
  public static abstract interface b<T extends RecyclerView.ViewHolder>
  {
    public abstract void d(@Nullable T paramT, boolean paramBoolean);
    
    public abstract void f(@Nullable T paramT, int paramInt);
  }
  
  public static abstract interface c<T extends RecyclerView.ViewHolder>
  {
    public abstract void a(float paramFloat, int paramInt1, int paramInt2, @Nullable T paramT1, @Nullable T paramT2);
    
    public abstract void g(@NonNull T paramT, int paramInt);
    
    public abstract void h(@NonNull T paramT, int paramInt);
  }
  
  class d
    implements awyh.c
  {
    private d() {}
    
    public void bs(float paramFloat)
    {
      if (AEBottomListScrollView.a(AEBottomListScrollView.this) == null) {}
      int i;
      int j;
      do
      {
        return;
        i = AEBottomListScrollView.this.getCurrentItem();
        j = AEBottomListScrollView.a(AEBottomListScrollView.this).QP();
      } while (i == j);
      AEBottomListScrollView.a(AEBottomListScrollView.this, paramFloat, i, j, AEBottomListScrollView.this.a(i), AEBottomListScrollView.this.a(j));
    }
    
    public void eHM()
    {
      AEBottomListScrollView.this.post(new AEBottomListScrollView.ScrollStateListener.1(this));
    }
    
    public void eHN()
    {
      AEBottomListScrollView.a(AEBottomListScrollView.this);
    }
    
    public void onScrollEnd()
    {
      if ((AEBottomListScrollView.a(AEBottomListScrollView.this) == null) && (AEBottomListScrollView.a(AEBottomListScrollView.this) == null)) {}
      int i;
      RecyclerView.ViewHolder localViewHolder;
      do
      {
        return;
        i = AEBottomListScrollView.a(AEBottomListScrollView.this).getCurrentPosition();
        localViewHolder = AEBottomListScrollView.this.a(i);
      } while (localViewHolder == null);
      AEBottomListScrollView.b(AEBottomListScrollView.this, localViewHolder, i);
      AEBottomListScrollView.c(AEBottomListScrollView.this, localViewHolder, i);
    }
    
    public void onScrollStart()
    {
      if (AEBottomListScrollView.a(AEBottomListScrollView.this) == null) {}
      int i;
      RecyclerView.ViewHolder localViewHolder;
      do
      {
        return;
        i = AEBottomListScrollView.a(AEBottomListScrollView.this).getCurrentPosition();
        localViewHolder = AEBottomListScrollView.this.a(i);
      } while (localViewHolder == null);
      AEBottomListScrollView.a(AEBottomListScrollView.this, localViewHolder, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView
 * JD-Core Version:    0.7.0.1
 */