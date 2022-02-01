package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import aqcx;
import aqho;
import aqnm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lto;

public class ProteusRecycleView
  extends RecyclerViewWithHeaderFooter
{
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView$b;
  private SideBarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView;
  private int aPI;
  private boolean akU;
  private boolean akV;
  private boolean akW;
  private float iq;
  private List<a> ir;
  private float is;
  
  public ProteusRecycleView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  private void aNo()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView != null)
    {
      setClipToPadding(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView.a(new lto(this));
    }
  }
  
  private void aNp()
  {
    if (this.akW)
    {
      this.akW = false;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView$b != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView$b.aCI();
      }
    }
  }
  
  private void init(Context paramContext)
  {
    this.aPI = ((int)aqho.convertDpToPixel(paramContext, 28.0F));
    setOverScrollMode(2);
  }
  
  private void rt(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView.d(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView.qu());
      int i = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView.t();
      paramInt = i;
      if (i >= this.aPI)
      {
        this.akW = true;
        paramInt = this.aPI;
      }
      scrollBy(paramInt, 0);
      setPadding(0, 0, paramInt, 0);
    }
  }
  
  public SideBarView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView;
  }
  
  public void a(a parama)
  {
    if (this.ir == null) {
      this.ir = new ArrayList();
    }
    this.ir.add(parama);
  }
  
  public void b(a parama)
  {
    if (this.ir != null) {
      this.ir.remove(parama);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.ir != null)
    {
      Iterator localIterator = this.ir.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).p(paramMotionEvent);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView$b == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    if (i == 0)
    {
      this.is = f2;
      this.iq = f1;
      this.akU = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    boolean bool1;
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProteusRecycleView", 2, "dispatchTouchEvent:ACTION_MOVE. mIsPress=" + this.akU);
      }
      if (this.akV) {
        break label478;
      }
      if (!canScrollHorizontally(1)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      f2 -= this.is;
      f1 -= this.iq;
      if ((this.akU) && (Math.abs(f1) * 5.0F > Math.abs(f2) * 4.0F) && (Math.abs(f1) > aqcx.dip2px(getContext(), 3.0F)))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        bool1 = bool2;
        label234:
        if (QLog.isColorLevel()) {
          QLog.d("ProteusRecycleView", 2, "dispatchTouchEvent:bottom" + bool1 + " isCurShowSideBarView " + this.akV + " dY:" + f1 + " dX:" + f2);
        }
        if ((bool1) || (this.akV))
        {
          getParent().requestDisallowInterceptTouchEvent(true);
          this.akV = true;
          rt((int)-f2);
        }
      }
      for (;;)
      {
        return super.dispatchTouchEvent(paramMotionEvent);
        bool1 = false;
        break;
        getParent().requestDisallowInterceptTouchEvent(true);
        break label234;
        if ((i == 3) || (i == 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProteusRecycleView", 2, "dispatchTouchEvent:ACTION_CANCEL or UP. action=" + i + " mIsPress=" + this.akU + " isCurShowSideBarView:" + this.akV);
          }
          getParent().requestDisallowInterceptTouchEvent(false);
          this.akU = false;
          if (this.akV) {
            aNo();
          }
          this.akV = false;
          if (f2 - this.is < -aqnm.dpToPx(15.0F)) {
            aNp();
          }
        }
      }
      label478:
      bool1 = false;
    }
  }
  
  public void setOnStateChangeListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView$b = paramb;
  }
  
  public void setSideBarView(SideBarView paramSideBarView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericSideBarView = paramSideBarView;
  }
  
  public static abstract interface a
  {
    public abstract void p(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface b
  {
    public abstract void aCI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView
 * JD-Core Version:    0.7.0.1
 */