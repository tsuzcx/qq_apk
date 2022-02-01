import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView.a;
import java.util.Locale;

public class awyh
  extends RecyclerView.LayoutManager
{
  protected Point N;
  protected Point O;
  protected Point P;
  @NonNull
  private final awyh.c jdField_a_of_type_Awyh$c;
  private awyj.a jdField_a_of_type_Awyj$a;
  private AEBottomListScrollView.a jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$a;
  private spl jdField_a_of_type_Spl;
  private spo jdField_a_of_type_Spo;
  private Context context;
  protected int currentPosition;
  protected int currentScrollState;
  private boolean dtA;
  protected boolean dty;
  private boolean dtz;
  protected int eDO;
  protected int eDP;
  protected int eDQ;
  protected int eDR;
  protected int eDS;
  protected int eDT;
  protected int eDU;
  private int eDV;
  private int eDW;
  private int eDX;
  private int eDY;
  protected SparseArray<View> ee;
  private int viewHeight;
  private int viewWidth;
  
  public awyh(@NonNull Context paramContext, @NonNull awyh.c paramc, @NonNull awyj paramawyj)
  {
    this.context = paramContext;
    this.eDV = 100;
    this.eDU = -1;
    this.currentPosition = -1;
    this.eDY = 2100;
    this.dtA = false;
    this.O = new Point();
    this.P = new Point();
    this.N = new Point();
    this.ee = new SparseArray();
    this.jdField_a_of_type_Awyh$c = paramc;
    this.jdField_a_of_type_Awyj$a = paramawyj.a();
    this.jdField_a_of_type_Spl = new spl(this);
    this.eDX = 1;
  }
  
  private float a(View paramView, int paramInt)
  {
    return Math.min(Math.max(-1.0F, this.jdField_a_of_type_Awyj$a.a(this.O, getDecoratedLeft(paramView) + this.eDO, getDecoratedTop(paramView) + this.eDP) / paramInt), 1.0F);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, awwo paramawwo, int paramInt)
  {
    int m = paramawwo.lA(1);
    int i;
    int j;
    if ((this.eDU == -1) || (!paramawwo.nZ(this.eDU - this.currentPosition)))
    {
      i = 1;
      this.N.set(this.P.x, this.P.y);
      j = this.currentPosition;
      int k = j + m;
      j = i;
      i = k;
      label76:
      if (!oa(i)) {
        return;
      }
      if (i == this.eDU) {
        j = 1;
      }
      this.jdField_a_of_type_Awyj$a.a(paramawwo, this.eDR, this.N);
      if (!a(this.N, paramInt)) {
        break label154;
      }
      a(paramRecycler, i, this.N);
    }
    label154:
    while (j == 0)
    {
      i += m;
      break label76;
      i = 0;
      break;
    }
  }
  
  private void a(RecyclerView.State paramState)
  {
    if ((this.currentPosition == -1) || (this.currentPosition >= paramState.getItemCount())) {
      this.currentPosition = 0;
    }
  }
  
  private void a(RecyclerView.State paramState, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= paramState.getItemCount())) {
      throw new IllegalArgumentException(String.format(Locale.US, "target position out of bounds: position=%d, itemCount=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramState.getItemCount()) }));
    }
  }
  
  private boolean a(Point paramPoint, int paramInt)
  {
    return this.jdField_a_of_type_Awyj$a.a(paramPoint, this.eDO, this.eDP, paramInt, this.eDQ);
  }
  
  private boolean aOj()
  {
    if (this.eDU != -1)
    {
      this.currentPosition = this.eDU;
      this.eDU = -1;
      this.eDT = 0;
      this.eDS = 0;
      return true;
    }
    awwo localawwo = awwo.a(this.eDS);
    if (aOk())
    {
      int i = Math.abs(this.eDS);
      int j = this.eDR;
      int k = Math.abs(this.eDS) / this.eDR;
      if (i % j < this.eDR * 0.4F)
      {
        i = this.currentPosition + localawwo.lA(k);
        if (i >= 0) {
          break label133;
        }
        j = 0;
      }
      for (;;)
      {
        adA(j);
        return false;
        i = this.currentPosition + localawwo.lA(k + 1);
        break;
        label133:
        j = i;
        if (i > getItemCount() - 1) {
          j = getItemCount() - 1;
        }
      }
    }
    this.eDT = (-this.eDS);
    if (this.eDT != 0)
    {
      eHK();
      return false;
    }
    return true;
  }
  
  private boolean aOk()
  {
    return Math.abs(this.eDS) >= this.eDR * 0.4F;
  }
  
  private void adA(int paramInt)
  {
    this.eDT = (-this.eDS);
    awwo localawwo = awwo.a(paramInt - this.currentPosition);
    int i = Math.abs(paramInt - this.currentPosition);
    int j = this.eDR;
    int k = this.eDT;
    this.eDT = (localawwo.lA(i * j) + k);
    this.eDU = paramInt;
    eHK();
  }
  
  private void adz(int paramInt)
  {
    if (this.currentPosition != paramInt)
    {
      this.currentPosition = paramInt;
      this.dtz = true;
    }
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    if (getItemCount() == 0) {
      return 0;
    }
    return (int)(computeScrollRange(paramState) / getItemCount());
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    int i = computeScrollExtent(paramState);
    int j = (int)(this.eDS / this.eDR * i);
    return i * this.currentPosition + j;
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    if (getItemCount() == 0) {
      return 0;
    }
    return this.eDR * (getItemCount() - 1);
  }
  
  private void eHI()
  {
    this.eDU = -1;
    this.eDT = 0;
  }
  
  private void eHK()
  {
    if (this.currentPosition == -1) {
      return;
    }
    awyh.a locala = new awyh.a(this.context);
    locala.setTargetPosition(this.currentPosition);
    this.jdField_a_of_type_Spl.startSmoothScroll(locala);
  }
  
  private void eHL()
  {
    if (this.eDU != -1) {}
    for (float f = Math.abs(this.eDS + this.eDT);; f = this.eDR)
    {
      f = -Math.min(Math.max(-1.0F, this.eDS / f), 1.0F);
      this.jdField_a_of_type_Awyh$c.bs(f);
      return;
    }
  }
  
  private int lB(int paramInt)
  {
    int j = this.jdField_a_of_type_Spl.getItemCount();
    int i;
    if ((this.currentPosition != 0) && (paramInt < 0)) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        i = paramInt;
      } while (this.currentPosition == j - 1);
      i = paramInt;
    } while (paramInt < j);
    return j - 1;
  }
  
  private boolean oa(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.jdField_a_of_type_Spl.getItemCount());
  }
  
  public int QP()
  {
    if (this.eDS == 0) {
      return this.currentPosition;
    }
    if (this.eDU != -1) {
      return this.eDU;
    }
    return this.currentPosition + awwo.a(this.eDS).lA(1);
  }
  
  public int QQ()
  {
    return this.eDQ;
  }
  
  public void XV(boolean paramBoolean)
  {
    this.dtA = paramBoolean;
  }
  
  protected int a(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    if (this.jdField_a_of_type_Spl.getChildCount() == 0) {
      return 0;
    }
    this.eDS += paramInt;
    if (this.eDT != 0) {
      this.eDT -= paramInt;
    }
    this.jdField_a_of_type_Awyj$a.a(-paramInt, this.jdField_a_of_type_Spl);
    if (this.jdField_a_of_type_Awyj$a.a(this)) {
      b(paramRecycler);
    }
    eHL();
    eHH();
    return paramInt;
  }
  
  protected void a(RecyclerView.Recycler paramRecycler)
  {
    View localView = this.jdField_a_of_type_Spl.a(0, paramRecycler);
    int i = this.jdField_a_of_type_Spl.m(localView);
    int j = this.jdField_a_of_type_Spl.n(localView);
    this.eDO = (i / 2);
    this.eDP = (j / 2);
    this.eDR = this.jdField_a_of_type_Awyj$a.bg(i, j);
    this.eDQ = (this.eDR * this.eDW);
    this.jdField_a_of_type_Spl.detachAndScrapView(localView, paramRecycler);
  }
  
  protected void a(RecyclerView.Recycler paramRecycler, int paramInt, Point paramPoint)
  {
    if ((paramInt < 0) || (paramInt >= getItemCount())) {
      return;
    }
    View localView = (View)this.ee.get(paramInt);
    if (localView == null)
    {
      paramRecycler = this.jdField_a_of_type_Spl.a(paramInt, paramRecycler);
      this.jdField_a_of_type_Spl.layoutDecoratedWithMargins(paramRecycler, paramPoint.x - this.eDO, paramPoint.y - this.eDP, paramPoint.x + this.eDO, paramPoint.y + this.eDP);
      return;
    }
    this.jdField_a_of_type_Spl.attachView(localView);
    this.ee.remove(paramInt);
  }
  
  public void adB(int paramInt)
  {
    this.eDV = paramInt;
  }
  
  public void adC(int paramInt)
  {
    this.eDX = paramInt;
    eHH();
  }
  
  protected void b(RecyclerView.Recycler paramRecycler)
  {
    eHG();
    this.jdField_a_of_type_Awyj$a.a(this.O, this.eDS, this.P);
    int i = this.jdField_a_of_type_Awyj$a.bf(this.jdField_a_of_type_Spl.getWidth(), this.jdField_a_of_type_Spl.getHeight());
    if (a(this.P, i)) {
      a(paramRecycler, this.currentPosition, this.P);
    }
    a(paramRecycler, new awwo.b(), i);
    a(paramRecycler, new awwo.a(), i);
    c(paramRecycler);
  }
  
  public void b(RecyclerView.State paramState)
  {
    if (this.dty)
    {
      this.jdField_a_of_type_Awyh$c.eHM();
      this.dty = false;
    }
    do
    {
      do
      {
        return;
      } while (!this.dtz);
      this.jdField_a_of_type_Awyh$c.eHN();
      this.dtz = false;
    } while (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$a == null);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$a.eHF();
  }
  
  protected void c(RecyclerView.Recycler paramRecycler)
  {
    int i = 0;
    while (i < this.ee.size())
    {
      View localView = (View)this.ee.valueAt(i);
      this.jdField_a_of_type_Spl.a(localView, paramRecycler);
      i += 1;
    }
    this.ee.clear();
  }
  
  protected void c(RecyclerView.State paramState)
  {
    if ((!paramState.isMeasuring()) && ((this.jdField_a_of_type_Spl.getWidth() != this.viewWidth) || (this.jdField_a_of_type_Spl.getHeight() != this.viewHeight))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.viewWidth = this.jdField_a_of_type_Spl.getWidth();
        this.viewHeight = this.jdField_a_of_type_Spl.getHeight();
        this.jdField_a_of_type_Spl.removeAllViews();
      }
      this.O.set(this.jdField_a_of_type_Spl.getWidth() / 2, this.jdField_a_of_type_Spl.getHeight() / 2);
      return;
    }
  }
  
  public View cJ()
  {
    return this.jdField_a_of_type_Spl.getChildAt(0);
  }
  
  public View cK()
  {
    return this.jdField_a_of_type_Spl.getChildAt(this.jdField_a_of_type_Spl.getChildCount() - 1);
  }
  
  public boolean canScrollHorizontally()
  {
    return this.jdField_a_of_type_Awyj$a.canScrollHorizontally();
  }
  
  public boolean canScrollVertically()
  {
    return this.jdField_a_of_type_Awyj$a.canScrollVertically();
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  protected void eHG()
  {
    int k = 0;
    this.ee.clear();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_Spl.getChildCount()) {
        break;
      }
      View localView = this.jdField_a_of_type_Spl.getChildAt(i);
      this.ee.put(this.jdField_a_of_type_Spl.getPosition(localView), localView);
      i += 1;
    }
    while (j < this.ee.size())
    {
      this.jdField_a_of_type_Spl.detachView((View)this.ee.valueAt(j));
      j += 1;
    }
  }
  
  protected void eHH()
  {
    if (this.jdField_a_of_type_Spo != null)
    {
      int j = this.eDR;
      int k = this.eDX;
      int i = 0;
      while (i < this.jdField_a_of_type_Spl.getChildCount())
      {
        View localView = this.jdField_a_of_type_Spl.getChildAt(i);
        float f = a(localView, k * j);
        this.jdField_a_of_type_Spo.h(localView, f);
        i += 1;
      }
    }
  }
  
  public void eHJ()
  {
    this.eDT = (-this.eDS);
    if (this.eDT != 0) {
      eHK();
    }
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public int getCurrentPosition()
  {
    return this.currentPosition;
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return true;
  }
  
  public void lt(int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = this.jdField_a_of_type_Awyj$a.bh(paramInt1, paramInt2);
    if (this.eDS * j >= 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      eHJ();
      return;
    }
    paramInt2 = i;
    if (this.dtA) {
      paramInt2 = Math.abs(j / this.eDY);
    }
    awwo localawwo = awwo.a(this.eDS);
    i = this.currentPosition;
    paramInt1 = i;
    int m;
    if (aOk())
    {
      paramInt1 = i;
      if (this.eDR != 0)
      {
        paramInt1 = Math.abs(this.eDS);
        int k = this.eDR;
        m = Math.abs(this.eDS) / this.eDR;
        if (paramInt1 % k >= this.eDR * 0.4F) {
          break label178;
        }
      }
    }
    label178:
    for (paramInt1 = i + localawwo.lA(m);; paramInt1 = i + localawwo.lA(m + 1))
    {
      paramInt1 = lB(awwo.a(j).lA(paramInt2) + paramInt1);
      if (!oa(paramInt1)) {
        break;
      }
      adA(paramInt1);
      return;
    }
    eHJ();
  }
  
  public void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2)
  {
    this.eDU = -1;
    this.eDT = 0;
    this.eDS = 0;
    if ((paramAdapter2 instanceof awyh.b)) {}
    for (this.currentPosition = ((awyh.b)paramAdapter2).QR();; this.currentPosition = 0)
    {
      this.jdField_a_of_type_Spl.removeAllViews();
      return;
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (this.jdField_a_of_type_Spl.getChildCount() > 0)
    {
      paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      paramAccessibilityEvent.setFromIndex(getPosition(cJ()));
      paramAccessibilityEvent.setToIndex(getPosition(cK()));
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    int i = this.currentPosition;
    if (this.currentPosition == -1) {
      i = 0;
    }
    for (;;)
    {
      adz(i);
      return;
      if (this.currentPosition >= paramInt1) {
        i = Math.min(this.currentPosition + paramInt2, this.jdField_a_of_type_Spl.getItemCount() - 1);
      }
    }
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.currentPosition = Math.min(Math.max(0, this.currentPosition), this.jdField_a_of_type_Spl.getItemCount() - 1);
    this.dtz = true;
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    int i = -1;
    int j = this.currentPosition;
    if (this.jdField_a_of_type_Spl.getItemCount() == 0) {
      paramInt1 = i;
    }
    for (;;)
    {
      adz(paramInt1);
      return;
      if (this.currentPosition >= paramInt1)
      {
        if (this.currentPosition < paramInt1 + paramInt2) {
          this.currentPosition = -1;
        }
        paramInt1 = Math.max(0, this.currentPosition - paramInt2);
      }
      else
      {
        paramInt1 = j;
      }
    }
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    boolean bool = false;
    if (paramState.getItemCount() == 0)
    {
      this.jdField_a_of_type_Spl.removeAndRecycleAllViews(paramRecycler);
      this.eDU = -1;
      this.currentPosition = -1;
      this.eDT = 0;
      this.eDS = 0;
      return;
    }
    a(paramState);
    c(paramState);
    if (!this.dty)
    {
      if (this.jdField_a_of_type_Spl.getChildCount() == 0) {
        bool = true;
      }
      this.dty = bool;
      if (this.dty) {
        a(paramRecycler);
      }
    }
    this.jdField_a_of_type_Spl.detachAndScrapAttachedViews(paramRecycler);
    b(paramRecycler);
    eHH();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.currentPosition = ((Bundle)paramParcelable).getInt("extra_position");
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    if (this.eDU != -1) {
      this.currentPosition = this.eDU;
    }
    localBundle.putInt("extra_position", this.currentPosition);
    return localBundle;
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((this.currentScrollState == 0) && (this.currentScrollState != paramInt)) {
      this.jdField_a_of_type_Awyh$c.onScrollStart();
    }
    if (paramInt == 0) {
      if (aOj()) {
        this.jdField_a_of_type_Awyh$c.onScrollEnd();
      }
    }
    for (;;)
    {
      this.currentScrollState = paramInt;
      return;
      if (paramInt == 1) {
        eHI();
      }
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return a(paramInt, paramRecycler);
  }
  
  public void scrollToPosition(int paramInt)
  {
    if (this.currentPosition == paramInt) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerViewScrollToPosition(this);
      return;
      this.currentPosition = paramInt;
      this.jdField_a_of_type_Spl.requestLayout();
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return a(paramInt, paramRecycler);
  }
  
  public void setItemTransformer(spo paramspo)
  {
    this.jdField_a_of_type_Spo = paramspo;
  }
  
  public void setLayoutCallback(AEBottomListScrollView.a parama)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView$a = parama;
  }
  
  public void setOffscreenItems(int paramInt)
  {
    this.eDW = paramInt;
    this.eDQ = (this.eDR * paramInt);
    this.jdField_a_of_type_Spl.requestLayout();
  }
  
  public void setOrientation(awyj paramawyj)
  {
    this.jdField_a_of_type_Awyj$a = paramawyj.a();
    this.jdField_a_of_type_Spl.removeAllViews();
    this.jdField_a_of_type_Spl.requestLayout();
  }
  
  public void setSlideOnFlingThreshold(int paramInt)
  {
    this.eDY = paramInt;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    if (this.eDU != -1) {
      return;
    }
    a(paramState, paramInt);
    if (this.currentPosition == -1)
    {
      this.currentPosition = paramInt;
      return;
    }
    adA(paramInt);
  }
  
  class a
    extends LinearSmoothScroller
  {
    public a(Context paramContext)
    {
      super();
    }
    
    public int calculateDxToMakeVisible(View paramView, int paramInt)
    {
      return awyh.a(awyh.this).lC(-awyh.this.eDT);
    }
    
    public int calculateDyToMakeVisible(View paramView, int paramInt)
    {
      return awyh.a(awyh.this).lD(-awyh.this.eDT);
    }
    
    public int calculateTimeForScrolling(int paramInt)
    {
      return (int)(Math.max(0.01F, Math.min(Math.abs(paramInt), awyh.this.eDR) / awyh.this.eDR) * awyh.a(awyh.this));
    }
    
    @Nullable
    public PointF computeScrollVectorForPosition(int paramInt)
    {
      return new PointF(awyh.a(awyh.this).lC(awyh.this.eDT), awyh.a(awyh.this).lD(awyh.this.eDT));
    }
  }
  
  public static abstract interface b
  {
    public abstract int QR();
  }
  
  public static abstract interface c
  {
    public abstract void bs(float paramFloat);
    
    public abstract void eHM();
    
    public abstract void eHN();
    
    public abstract void onScrollEnd();
    
    public abstract void onScrollStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awyh
 * JD-Core Version:    0.7.0.1
 */