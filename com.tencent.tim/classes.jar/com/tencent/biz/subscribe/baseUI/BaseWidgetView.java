package com.tencent.biz.subscribe.baseUI;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import sal;

public abstract class BaseWidgetView<T>
  extends FrameLayout
{
  private SparseArray<Long> be = new SparseArray();
  public int bvX;
  private T data;
  private WeakReference<Activity> jdField_do;
  private HashMap<Integer, b> fG = new HashMap();
  private ExtraTypeInfo mExtraTypeInfo;
  private a mInteractor;
  private int mViewType;
  
  public BaseWidgetView(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public BaseWidgetView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    I(paramContext, paramInt);
  }
  
  public BaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e(paramContext, paramAttributeSet);
    I(paramContext, getViewType());
  }
  
  private void I(Context paramContext, int paramInt)
  {
    this.mViewType = paramInt;
    S(paramContext, paramInt);
    if (getLayoutId() != 0) {
      LayoutInflater.from(paramContext).inflate(getLayoutId(), this, true);
    }
    e(paramContext, this);
    if (aB() != null) {
      aB().setOnClickListener(new sal(this));
    }
    W(paramContext, paramInt);
  }
  
  private void a(View paramView, b paramb)
  {
    if (paramView != null) {
      this.fG.put(Integer.valueOf(paramView.getId()), paramb);
    }
  }
  
  public boolean J(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    long l = System.currentTimeMillis();
    if (l - ((Long)this.be.get(paramView.getId(), Long.valueOf(-1L))).longValue() > 800L)
    {
      this.be.put(paramView.getId(), Long.valueOf(l));
      return false;
    }
    return true;
  }
  
  protected abstract void P(T paramT);
  
  protected void S(Context paramContext, int paramInt) {}
  
  protected void W(Context paramContext, int paramInt) {}
  
  public View aB()
  {
    return null;
  }
  
  public void bindData(T paramT, int paramInt) {}
  
  public void dZ(View paramView)
  {
    if ((paramView != null) && (this.fG.get(Integer.valueOf(paramView.getId())) != null)) {
      ((b)this.fG.get(Integer.valueOf(paramView.getId()))).bja();
    }
  }
  
  protected void e(Context paramContext, AttributeSet paramAttributeSet) {}
  
  protected abstract void e(Context paramContext, View paramView);
  
  public T getData()
  {
    return this.data;
  }
  
  public int getDataPosInList()
  {
    return this.bvX;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    return this.mExtraTypeInfo;
  }
  
  public Activity getHostActivity()
  {
    if (this.jdField_do != null) {
      return (Activity)this.jdField_do.get();
    }
    return null;
  }
  
  public a getInteractor()
  {
    return this.mInteractor;
  }
  
  protected abstract int getLayoutId();
  
  public int getViewType()
  {
    return this.mViewType;
  }
  
  public void release() {}
  
  public void setData(T paramT)
  {
    this.data = paramT;
    P(paramT);
  }
  
  public void setData(T paramT, int paramInt)
  {
    this.data = paramT;
    bindData(paramT, paramInt);
  }
  
  public void setDataPosInList(int paramInt)
  {
    this.bvX = paramInt;
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setHostActivity(Activity paramActivity)
  {
    this.jdField_do = new WeakReference(paramActivity);
  }
  
  public void setInteractor(a parama)
  {
    this.mInteractor = parama;
  }
  
  public void setPreClickListener(View paramView, b paramb)
  {
    a(paramView, paramb);
  }
  
  public void setPreClickListener(b paramb)
  {
    a(aB(), paramb);
  }
  
  public void setViewType(int paramInt)
  {
    this.mViewType = paramInt;
  }
  
  public View.OnClickListener v()
  {
    return null;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void bja();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.baseUI.BaseWidgetView
 * JD-Core Version:    0.7.0.1
 */