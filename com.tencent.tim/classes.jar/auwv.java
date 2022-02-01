import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import com.tencent.widget.pull2refresh.RecyclerViewCompat.a;

@SuppressLint({"ClickableViewAccessibility"})
public class auwv
{
  private auwv.a jdField_a_of_type_Auwv$a;
  private auwv.b jdField_a_of_type_Auwv$b;
  private auwv.d jdField_a_of_type_Auwv$d;
  private auwv.c b;
  private int centerPosition;
  private RecyclerViewCompat e;
  private int gravity;
  private OrientationHelper horizontalHelper;
  private boolean isQuickPageChanged;
  private boolean isSnapping;
  private LinearLayoutManager layoutManager;
  private int placeHeaderCount;
  private int reboundFooterCount;
  private int snapOffset;
  private boolean snapOnFling;
  private boolean snapOnIdle;
  private float snapSpeedFactor;
  private OrientationHelper verticalHelper;
  
  public auwv()
  {
    this(0, 25.0F);
  }
  
  public auwv(int paramInt, float paramFloat)
  {
    init();
    this.gravity = paramInt;
    this.snapSpeedFactor = paramFloat;
  }
  
  private int adjustPosition(int paramInt)
  {
    int i = getStartPosition();
    int j = getEndPosition(this.layoutManager);
    if (paramInt < i) {}
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= j);
    return j;
  }
  
  @NonNull
  private int[] calculateDistanceToFinalSnap(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLinearLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = distanceToBaseLine(paramLinearLayoutManager, paramView, getOrientationHelper(paramLinearLayoutManager));
    }
    while (paramLinearLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = distanceToBaseLine(paramLinearLayoutManager, paramView, getOrientationHelper(paramLinearLayoutManager));
      return arrayOfInt;
      arrayOfInt[0] = 0;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  private boolean checkIsPositionOutOfBound(int paramInt, RecyclerView.LayoutManager paramLayoutManager)
  {
    int i = getEndPosition(paramLayoutManager);
    return (paramInt < getStartPosition()) || (paramInt > i);
  }
  
  private void checkRecyclerViewState(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView == null) || (paramRecyclerView.getAdapter() == null) || (paramRecyclerView.getLayoutManager() == null)) {
      throw new IllegalStateException("PagerSnapHelper can't attach to the RecyclerView before setup Adapter or LayoutManager");
    }
    if (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
      throw new IllegalStateException("PagerSnapHelper can only attach to the RecyclerView with LinearLayoutManager");
    }
  }
  
  private int computeMinScollDistance()
  {
    return ViewConfiguration.get(this.e.getContext()).getScaledTouchSlop();
  }
  
  private void destroyCallbacks()
  {
    this.e.removeOnScrollListener(this.jdField_a_of_type_Auwv$d);
    this.e.setOnFlingListener(null);
  }
  
  private void dispatchFooterRebound()
  {
    if (this.b != null)
    {
      this.b.onFooterRebound();
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: onFooterRebound");
      }
    }
  }
  
  private void dispatchPagerChanged(View paramView, boolean paramBoolean)
  {
    RecyclerView.ViewHolder localViewHolder;
    int i;
    if ((paramView != null) && (this.e != null) && (this.layoutManager != null))
    {
      localViewHolder = this.e.getChildViewHolder(paramView);
      i = this.layoutManager.getPosition(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "dispatchPagerChanged: position=" + i + ", centerPosition=" + this.centerPosition + ", reset=" + paramBoolean);
      }
      if ((localViewHolder != null) && (i != -1) && ((i != this.centerPosition) || (paramBoolean)) && (!checkIsPositionOutOfBound(i, this.layoutManager))) {
        break label124;
      }
    }
    label124:
    do
    {
      return;
      this.centerPosition = i;
    } while (this.b == null);
    TraceCompat.beginSection("onPagerChanged");
    this.b.onPagerChanged(localViewHolder);
    TraceCompat.endSection();
  }
  
  private int distanceToBaseLine(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    switch (this.gravity)
    {
    default: 
      return distanceToCenter(paramLinearLayoutManager, paramView, paramOrientationHelper);
    }
    return distanceToTop(paramLinearLayoutManager, paramView, paramOrientationHelper);
  }
  
  private int distanceToCenter(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2 - getCenterLine(paramLinearLayoutManager, paramOrientationHelper);
  }
  
  private int distanceToTop(@NonNull LinearLayoutManager paramLinearLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) - getTopLine(paramOrientationHelper);
  }
  
  private void exV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: onHeaderRebound");
    }
  }
  
  private int getCenterLine(LinearLayoutManager paramLinearLayoutManager, OrientationHelper paramOrientationHelper)
  {
    if (paramLinearLayoutManager.getClipToPadding()) {}
    for (int i = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;; i = paramOrientationHelper.getEnd() / 2) {
      return i + this.snapOffset;
    }
  }
  
  private int getEndPosition(RecyclerView.LayoutManager paramLayoutManager)
  {
    return paramLayoutManager.getItemCount() - this.reboundFooterCount - 1;
  }
  
  private int getStartPosition()
  {
    return this.placeHeaderCount;
  }
  
  private int getTopLine(OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getStartAfterPadding() + this.snapOffset;
  }
  
  private void init()
  {
    this.reboundFooterCount = 0;
    this.placeHeaderCount = 0;
    this.centerPosition = -1;
    this.isSnapping = false;
    this.isQuickPageChanged = false;
    this.snapOnIdle = true;
    this.snapOnFling = true;
  }
  
  private void setupCallbacks()
    throws IllegalStateException
  {
    if (this.e.a() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.jdField_a_of_type_Auwv$d = new auwv.d(null);
    this.jdField_a_of_type_Auwv$a = new auwv.a(null);
    this.jdField_a_of_type_Auwv$b = new auwv.b(null);
    this.e.setOnTouchListener(this.jdField_a_of_type_Auwv$d);
    this.e.addOnScrollListener(this.jdField_a_of_type_Auwv$d);
    this.e.setOnFlingListener(this.jdField_a_of_type_Auwv$d);
    this.e.addOnLayoutChangeListener(this.jdField_a_of_type_Auwv$a);
    this.e.addOnLayoutChangeListener(this.jdField_a_of_type_Auwv$b);
    this.e.getAdapter().registerAdapterDataObserver(new auww(this));
  }
  
  private boolean snapFromFling(@NonNull LinearLayoutManager paramLinearLayoutManager, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    int i = 1;
    if (paramLinearLayoutManager.getItemCount() == 0) {}
    label202:
    label223:
    for (;;)
    {
      return false;
      View localView = findCenterView(paramLinearLayoutManager);
      if (localView != null)
      {
        int j = paramLinearLayoutManager.getPosition(localView);
        if (j != -1)
        {
          j = adjustPosition(j);
          int k = computeMinScollDistance();
          if (paramLinearLayoutManager.canScrollHorizontally()) {
            if (Math.abs(paramFloat1) > k) {
              if (paramFloat1 > 0.0F)
              {
                if ((paramInt == -1) || (j == paramInt)) {
                  break label202;
                }
                paramInt = j;
              }
            }
          }
          for (;;)
          {
            if (paramInt == -1) {
              break label223;
            }
            paramInt = adjustPosition(paramInt);
            if (QLog.isColorLevel()) {
              QLog.d("PagerSnapHelper", 2, "snapFromFling: position=" + paramInt);
            }
            return snapToTargetPosition(paramInt);
            i = 0;
            break;
            if (paramFloat3 > 0.0F) {
              break;
            }
            i = 0;
            break;
            if (Math.abs(paramFloat2) > k)
            {
              if (paramFloat2 > 0.0F) {
                break;
              }
              i = 0;
              break;
            }
            if (paramFloat4 > 0.0F) {
              break;
            }
            i = 0;
            break;
            if (i != 0) {
              paramInt = j + 1;
            } else {
              paramInt = j - 1;
            }
          }
        }
      }
    }
  }
  
  public void a(@Nullable RecyclerViewCompat paramRecyclerViewCompat)
    throws IllegalStateException
  {
    if (this.e == paramRecyclerViewCompat) {}
    do
    {
      return;
      if (this.e != null) {
        destroyCallbacks();
      }
      this.e = paramRecyclerViewCompat;
    } while (this.e == null);
    checkRecyclerViewState(this.e);
    this.layoutManager = ((LinearLayoutManager)this.e.getLayoutManager());
    setupCallbacks();
    snapToCenterPosition();
  }
  
  public void b(auwv.c paramc)
  {
    this.b = paramc;
  }
  
  protected LinearSmoothScroller createSnapScroller(LinearLayoutManager paramLinearLayoutManager)
  {
    return new auwx(this, this.e.getContext(), paramLinearLayoutManager);
  }
  
  @Nullable
  public View findCenterView(LinearLayoutManager paramLinearLayoutManager)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int m = paramLinearLayoutManager.getChildCount();
    if (m == 0) {}
    OrientationHelper localOrientationHelper;
    int i;
    int j;
    do
    {
      return localObject2;
      localOrientationHelper = getOrientationHelper(paramLinearLayoutManager);
      i = 2147483647;
      j = 0;
      localObject2 = localObject1;
    } while (j >= m);
    localObject2 = paramLinearLayoutManager.getChildAt(j);
    int k = Math.abs(distanceToBaseLine(paramLinearLayoutManager, (View)localObject2, localOrientationHelper));
    if (k < i)
    {
      localObject1 = localObject2;
      i = k;
    }
    for (;;)
    {
      j += 1;
      break;
    }
  }
  
  public int getCurrentPosition()
  {
    return this.centerPosition;
  }
  
  @NonNull
  protected OrientationHelper getOrientationHelper(LinearLayoutManager paramLinearLayoutManager)
  {
    if (paramLinearLayoutManager.canScrollVertically())
    {
      if (this.verticalHelper == null) {
        this.verticalHelper = OrientationHelper.createOrientationHelper(paramLinearLayoutManager, 1);
      }
      return this.verticalHelper;
    }
    if (this.horizontalHelper == null) {
      this.horizontalHelper = OrientationHelper.createOrientationHelper(paramLinearLayoutManager, 0);
    }
    return this.horizontalHelper;
  }
  
  public boolean isSnapping()
  {
    return this.isSnapping;
  }
  
  public void offsetToTargetPosition(int paramInt)
  {
    if ((this.e == null) || (this.layoutManager == null)) {
      return;
    }
    offsetToTargetPosition(this.layoutManager.findViewByPosition(paramInt));
  }
  
  public void offsetToTargetPosition(View paramView)
  {
    if ((this.e == null) || (this.layoutManager == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramView == null) || (checkIsPositionOutOfBound(this.layoutManager.getPosition(paramView), this.layoutManager)) || (paramView == null));
      paramView = calculateDistanceToFinalSnap(this.layoutManager, paramView);
    } while ((paramView[0] == 0) && (paramView[1] == 0));
    this.e.scrollBy(paramView[0], paramView[1]);
  }
  
  public void requestLayoutChanged()
  {
    this.e.addOnLayoutChangeListener(this.jdField_a_of_type_Auwv$a);
  }
  
  public void setPlaceHeaderCount(int paramInt)
  {
    this.placeHeaderCount = paramInt;
  }
  
  public void setQuickPageChanged(boolean paramBoolean)
  {
    this.isQuickPageChanged = paramBoolean;
  }
  
  public void setReboundFooterCount(int paramInt)
  {
    this.reboundFooterCount = paramInt;
  }
  
  public void setSnapOffset(int paramInt)
  {
    this.snapOffset = paramInt;
  }
  
  public void setSnapOnFling(boolean paramBoolean)
  {
    this.snapOnFling = paramBoolean;
  }
  
  public void setSnapOnIdle(boolean paramBoolean)
  {
    this.snapOnIdle = paramBoolean;
  }
  
  public boolean snapToCenterPosition()
  {
    if ((this.e == null) || (this.layoutManager == null)) {}
    View localView;
    do
    {
      return false;
      localView = findCenterView(this.layoutManager);
    } while (localView == null);
    if (QLog.isColorLevel()) {
      QLog.d("PagerSnapHelper", 2, "snapToCenterPosition: findCenterView=" + this.layoutManager.getPosition(localView));
    }
    return snapToTargetView(localView);
  }
  
  public boolean snapToNextPosition()
  {
    if ((this.e == null) || (this.layoutManager == null)) {}
    int i;
    do
    {
      return false;
      i = this.centerPosition + 1;
    } while (checkIsPositionOutOfBound(i, this.layoutManager));
    snapToTargetPosition(i);
    return true;
  }
  
  public boolean snapToPreviousPosition()
  {
    if ((this.e == null) || (this.layoutManager == null)) {}
    int i;
    do
    {
      return false;
      i = this.centerPosition - 1;
    } while (checkIsPositionOutOfBound(i, this.layoutManager));
    snapToTargetPosition(i);
    return true;
  }
  
  public boolean snapToTargetPosition(int paramInt)
  {
    if (checkIsPositionOutOfBound(paramInt, this.layoutManager)) {}
    View localView;
    int i;
    int j;
    do
    {
      return false;
      localView = this.layoutManager.findViewByPosition(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "snapToTargetPosition: position=" + paramInt + ", view=" + localView);
      }
      if (localView == null)
      {
        this.e.smoothScrollToPosition(paramInt);
        this.isSnapping = true;
        return true;
      }
      localObject = calculateDistanceToFinalSnap(this.layoutManager, localView);
      i = localObject[0];
      j = localObject[1];
    } while ((i == 0) && (j == 0));
    Object localObject = createSnapScroller(this.layoutManager);
    ((RecyclerView.SmoothScroller)localObject).setTargetPosition(paramInt);
    this.layoutManager.startSmoothScroll((RecyclerView.SmoothScroller)localObject);
    this.isSnapping = true;
    if (this.isQuickPageChanged) {
      dispatchPagerChanged(localView, false);
    }
    if ((paramInt == getEndPosition(this.layoutManager)) && ((i < 0) || (j < 0))) {
      dispatchFooterRebound();
    }
    for (;;)
    {
      return true;
      if ((paramInt == getStartPosition()) && ((i > 0) || (j > 0))) {
        exV();
      }
    }
  }
  
  public boolean snapToTargetView(View paramView)
  {
    if (paramView == null) {}
    int i;
    do
    {
      return false;
      i = this.layoutManager.getPosition(paramView);
    } while (i == -1);
    return snapToTargetPosition(adjustPosition(i));
  }
  
  class a
    implements View.OnLayoutChangeListener
  {
    private boolean reset;
    
    private a() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      auwv.a(auwv.this).removeOnLayoutChangeListener(this);
      if (auwv.a(auwv.this).getItemCount() > auwv.c(auwv.this) + auwv.d(auwv.this))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
        }
        paramView = auwv.this.findCenterView(auwv.a(auwv.this));
        if ((!auwv.this.snapToTargetView(paramView)) || (this.reset)) {
          auwv.a(auwv.this, paramView, this.reset);
        }
        this.reset = false;
      }
    }
  }
  
  class b
    implements View.OnLayoutChangeListener
  {
    private int lastHeight;
    private int lastWidth;
    
    private b() {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if ((this.lastHeight > 0) && (this.lastWidth > 0)) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((paramInt1 != 0) && (!auwv.c(auwv.this)) && ((this.lastHeight != paramView.getHeight()) || (this.lastWidth != paramView.getWidth()))) {
          auwv.this.offsetToTargetPosition(auwv.b(auwv.this));
        }
        this.lastHeight = paramView.getHeight();
        this.lastWidth = paramView.getWidth();
        return;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void onFooterRebound();
    
    public abstract void onPagerChanged(RecyclerView.ViewHolder paramViewHolder);
  }
  
  class d
    extends RecyclerView.OnScrollListener
    implements View.OnTouchListener, RecyclerViewCompat.a
  {
    private int currentScrollState = 0;
    private float firstMoveX;
    private float firstMoveY;
    private boolean hadMoveEvent;
    private int lastCenterPosition = -1;
    private float moveXDistance;
    private float moveYDistance;
    private boolean reset;
    private boolean scrolled;
    
    private d() {}
    
    private void onDragging(int paramInt)
    {
      int i = -1;
      View localView;
      if ((paramInt == 0) || (paramInt == 2))
      {
        localView = auwv.this.findCenterView(auwv.a(auwv.this));
        if (localView == null) {
          break label164;
        }
        this.lastCenterPosition = auwv.a(auwv.this).getPosition(localView);
      }
      label164:
      for (this.lastCenterPosition = auwv.a(auwv.this, this.lastCenterPosition);; this.lastCenterPosition = -1)
      {
        if ((auwv.b(auwv.this) != -1) && (auwv.a(auwv.this).findViewByPosition(auwv.b(auwv.this)) == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: centerPosition has been recycler");
          }
          this.reset = true;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("onScrollStateChanged: lastCenterView=");
          paramInt = i;
          if (localView != null) {
            paramInt = auwv.a(auwv.this).getPosition(localView);
          }
          QLog.d("PagerSnapHelper", 2, paramInt);
        }
        return;
      }
    }
    
    private void onIdle()
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      int i;
      if (auwv.b(auwv.this))
      {
        if (!auwv.this.snapToCenterPosition()) {
          bool1 = bool2;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: isRealIdle=" + bool1);
        }
        if (bool1) {
          auwv.a(auwv.this, false);
        }
        View localView = auwv.this.findCenterView(auwv.a(auwv.this));
        if (localView == null) {
          break label146;
        }
        i = auwv.a(auwv.this).getPosition(localView);
        label104:
        if (auwv.a(auwv.this, i, auwv.a(auwv.this))) {
          break label151;
        }
        auwv.a(auwv.this, localView, this.reset);
      }
      for (;;)
      {
        this.reset = false;
        return;
        bool1 = false;
        break;
        label146:
        i = -1;
        break label104;
        label151:
        if ((!auwv.a(auwv.this)) && (!auwv.b(auwv.this))) {
          if (i > auwv.a(auwv.this, auwv.a(auwv.this))) {
            auwv.a(auwv.this);
          } else if (i < auwv.a(auwv.this)) {
            auwv.b(auwv.this);
          }
        }
      }
    }
    
    public boolean onFling(float paramFloat1, float paramFloat2)
    {
      if (auwv.a(auwv.this) == null) {}
      int i;
      int j;
      do
      {
        do
        {
          return false;
        } while ((auwv.a(auwv.this).getAdapter() == null) || (!auwv.a(auwv.this)));
        i = auwv.a(auwv.this).getMinFlingVelocity();
        j = this.lastCenterPosition;
      } while ((Math.abs(paramFloat2) <= i) && (Math.abs(paramFloat1) <= i));
      try
      {
        TraceCompat.beginSection("snapFromFling");
        boolean bool = auwv.a(auwv.this, auwv.a(auwv.this), this.moveXDistance, this.moveYDistance, paramFloat1, paramFloat2, j);
        return bool;
      }
      finally
      {
        TraceCompat.endSection();
      }
    }
    
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: state=" + paramInt);
      }
      int i = this.currentScrollState;
      this.currentScrollState = paramInt;
      if (paramInt == 0)
      {
        TraceCompat.beginSection("snap onIdle");
        onIdle();
        TraceCompat.endSection();
      }
      while (paramInt != 1) {
        return;
      }
      TraceCompat.beginSection("snap onDragging");
      onDragging(i);
      TraceCompat.endSection();
    }
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        this.scrolled = true;
      }
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 2: 
        do
        {
          return false;
          this.hadMoveEvent = true;
          if (this.firstMoveX <= 0.0F) {
            this.firstMoveX = paramMotionEvent.getX();
          }
        } while (this.firstMoveY > 0.0F);
        this.firstMoveY = paramMotionEvent.getY();
        return false;
      }
      if (this.hadMoveEvent) {
        this.moveXDistance = (this.firstMoveX - paramMotionEvent.getX());
      }
      for (this.moveYDistance = (this.firstMoveY - paramMotionEvent.getY());; this.moveYDistance = 0.0F)
      {
        this.firstMoveX = 0.0F;
        this.firstMoveY = 0.0F;
        this.hadMoveEvent = false;
        return false;
        this.moveXDistance = 0.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auwv
 * JD-Core Version:    0.7.0.1
 */