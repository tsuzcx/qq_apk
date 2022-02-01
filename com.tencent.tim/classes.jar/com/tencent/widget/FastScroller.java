package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import auts;
import com.tencent.util.VersionUtils;

class FastScroller
{
  private static final int[] ATTRS = { 16843609, 16843574, 16843577, 16843575, 16843576, 16843578 };
  private static int eti = 4;
  private static final int[] tu = { 16842919 };
  private static final int[] tv = new int[0];
  BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private SectionIndexer jdField_a_of_type_AndroidWidgetSectionIndexer;
  private ScrollFade jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade;
  private RectF bo;
  private String cIV;
  private int ckO;
  boolean dkj;
  private boolean dkk;
  private boolean dkl;
  private boolean dkm;
  private boolean dkn;
  private boolean dko;
  boolean dkp;
  int etj;
  int etk;
  int etl;
  private int etm;
  private int etn;
  private int eto;
  private int etp;
  AbsListView f;
  private Drawable gC;
  private Drawable gD;
  private Drawable gE;
  private final Runnable iy = new FastScroller.1(this);
  private Handler mHandler = new Handler();
  float mInitialTouchY;
  private int mItemCount = -1;
  private Paint mPaint;
  private int mPosition;
  private int mState;
  private Drawable mThumbDrawable;
  private final Rect mTmpRect = new Rect();
  private Drawable mTrackDrawable;
  private Object[] w;
  
  public FastScroller(Context paramContext, AbsListView paramAbsListView)
  {
    this.f = paramAbsListView;
    init(paramContext);
  }
  
  private void a(Context paramContext, Drawable paramDrawable)
  {
    this.mThumbDrawable = paramDrawable;
    if ((paramDrawable instanceof NinePatchDrawable)) {
      this.etk = paramContext.getResources().getDimensionPixelSize(2131297250);
    }
    for (this.etj = paramContext.getResources().getDimensionPixelSize(2131297249);; this.etj = paramDrawable.getIntrinsicHeight())
    {
      this.dkm = true;
      return;
      this.etk = paramDrawable.getIntrinsicWidth();
    }
  }
  
  private void cancelFling()
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0);
    this.f.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  private void ewK()
  {
    int i = this.f.getWidth();
    switch (this.mPosition)
    {
    }
    for (;;)
    {
      this.mThumbDrawable.setAlpha(208);
      return;
      this.mThumbDrawable.setBounds(i - this.etk, 0, i, this.etj);
      continue;
      this.mThumbDrawable.setBounds(0, 0, this.etk, this.etj);
    }
  }
  
  @TargetApi(11)
  private void init(Context paramContext)
  {
    boolean bool = true;
    int i = 0;
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(ATTRS);
    for (;;)
    {
      try
      {
        a(paramContext, localTypedArray.getDrawable(1));
        this.mTrackDrawable = localTypedArray.getDrawable(2);
        this.gD = localTypedArray.getDrawable(3);
        this.gE = localTypedArray.getDrawable(4);
        this.etp = localTypedArray.getInt(5, 0);
        this.dkj = true;
        ewL();
        this.etm = paramContext.getResources().getDimensionPixelSize(2131297248);
        this.bo = new RectF();
        this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade = new ScrollFade();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(this.etm / 2);
        int j = localTypedArray.getColorStateList(0).getDefaultColor();
        this.mPaint.setColor(j);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        if ((this.f.getWidth() > 0) && (this.f.getHeight() > 0)) {
          onSizeChanged(this.f.getWidth(), this.f.getHeight(), 0, 0);
        }
        this.mState = 0;
        refreshDrawableState();
        localTypedArray.recycle();
        this.ckO = ViewConfiguration.get(paramContext).getScaledTouchSlop();
        if (paramContext.getApplicationInfo().targetSdkVersion >= 11)
        {
          this.dko = bool;
          if (VersionUtils.isHoneycomb()) {
            i = this.f.getVerticalScrollbarPosition();
          }
          abf(i);
          return;
        }
      }
      finally
      {
        localTypedArray.recycle();
      }
      bool = false;
    }
  }
  
  private void refreshDrawableState()
  {
    if (this.mState == 3) {}
    for (int[] arrayOfInt = tu;; arrayOfInt = tv)
    {
      if ((this.mThumbDrawable != null) && (this.mThumbDrawable.isStateful())) {
        this.mThumbDrawable.setState(arrayOfInt);
      }
      if ((this.mTrackDrawable != null) && (this.mTrackDrawable.isStateful())) {
        this.mTrackDrawable.setState(arrayOfInt);
      }
      return;
    }
  }
  
  private int v(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    if ((this.jdField_a_of_type_AndroidWidgetSectionIndexer == null) || (this.jdField_a_of_type_AndroidWidgetBaseAdapter == null)) {
      ewL();
    }
    if ((this.jdField_a_of_type_AndroidWidgetSectionIndexer == null) || (!this.dko)) {
      paramInt1 = (this.f.getHeight() - this.etj) * paramInt1 / (paramInt3 - paramInt2);
    }
    int j;
    do
    {
      return paramInt1;
      j = paramInt1 - this.eto;
      paramInt1 = i;
    } while (j < 0);
    int k = this.eto;
    int m = this.f.getHeight() - this.etj;
    paramInt1 = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getSectionForPosition(j);
    i = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(paramInt1);
    int n = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(paramInt1 + 1);
    int i1 = this.w.length;
    View localView = this.f.getChildAt(0);
    if (localView == null) {}
    for (float f1 = 0.0F;; f1 = (this.f.getPaddingTop() - localView.getTop()) / localView.getHeight() + f1)
    {
      i = (int)(((f1 - i) / (n - i) + paramInt1) / i1 * m);
      paramInt1 = i;
      if (j <= 0) {
        break;
      }
      paramInt1 = i;
      if (j + paramInt2 != paramInt3 - k) {
        break;
      }
      localView = this.f.getChildAt(paramInt2 - 1);
      f1 = (this.f.getHeight() - this.f.getPaddingBottom() - localView.getTop()) / localView.getHeight();
      float f2 = i;
      return (int)((m - i) * f1 + f2);
      f1 = j;
    }
  }
  
  boolean Q(float paramFloat1, float paramFloat2)
  {
    int i;
    switch (this.mPosition)
    {
    default: 
      if (paramFloat1 > this.f.getWidth() - this.etk) {
        i = 1;
      }
      break;
    }
    while ((i != 0) && ((this.mTrackDrawable != null) || ((paramFloat2 >= this.etl) && (paramFloat2 <= this.etl + this.etj))))
    {
      return true;
      i = 0;
      continue;
      if (paramFloat1 < this.etk) {
        i = 1;
      } else {
        i = 0;
      }
    }
    return false;
  }
  
  public void Wf(boolean paramBoolean)
  {
    this.dkn = paramBoolean;
    if (paramBoolean)
    {
      this.mHandler.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade);
      setState(2);
    }
    while (this.mState != 2) {
      return;
    }
    this.mHandler.postDelayed(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade, 1500L);
  }
  
  public boolean aJM()
  {
    return this.dkn;
  }
  
  public void abf(int paramInt)
  {
    this.mPosition = paramInt;
    switch (paramInt)
    {
    default: 
      this.gC = this.gE;
      return;
    }
    this.gC = this.gD;
  }
  
  void bk(float paramFloat)
  {
    int i3 = this.f.getCount();
    this.dkj = false;
    float f1 = 1.0F / i3 / 8.0F;
    Object[] arrayOfObject = this.w;
    int i4;
    int j;
    int i;
    int k;
    int i1;
    if ((arrayOfObject != null) && (arrayOfObject.length > 1))
    {
      i4 = arrayOfObject.length;
      j = (int)(i4 * paramFloat);
      i = j;
      if (j >= i4) {
        i = i4 - 1;
      }
      k = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(i);
      i1 = i + 1;
      if (i >= i4 - 1) {
        break label622;
      }
    }
    label587:
    label590:
    label593:
    label622:
    for (int n = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(i + 1);; n = i3)
    {
      int m;
      if (n == k)
      {
        j = k;
        m = i;
        if (m > 0)
        {
          m -= 1;
          j = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(m);
          if (j != k)
          {
            k = j;
            j = m;
          }
        }
      }
      for (;;)
      {
        int i2 = i1 + 1;
        for (;;)
        {
          if ((i2 < i4) && (this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(i2) == n))
          {
            i2 += 1;
            i1 += 1;
            continue;
            if (m != 0) {
              break label593;
            }
            i2 = 0;
            m = i;
            k = j;
            j = i2;
            break;
          }
        }
        float f2 = m / i4;
        float f3 = i1 / i4;
        if ((m == i) && (paramFloat - f2 < f1))
        {
          i = k;
          if (i <= i3 - 1) {
            break label590;
          }
          i = i3 - 1;
        }
        for (;;)
        {
          Object localObject;
          if ((this.f instanceof ExpandableListView))
          {
            localObject = (ExpandableListView)this.f;
            ((ExpandableListView)localObject).setSelectionFromTop(((ExpandableListView)localObject).getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i + this.eto)), 0);
          }
          boolean bool;
          for (;;)
          {
            if (j >= 0)
            {
              localObject = arrayOfObject[j].toString();
              this.cIV = ((String)localObject);
              if (((((String)localObject).length() != 1) || (((String)localObject).charAt(0) != ' ')) && (j < arrayOfObject.length))
              {
                bool = true;
                label379:
                this.dkl = bool;
                return;
                i = (int)((n - k) * (paramFloat - f2) / (f3 - f2)) + k;
                break;
                if ((this.f instanceof ListView))
                {
                  ((ListView)this.f).setSelectionFromTop(i + this.eto, 0);
                  continue;
                }
                this.f.setSelection(i + this.eto);
                continue;
                i = (int)(i3 * paramFloat);
                if (i <= i3 - 1) {
                  break label587;
                }
                i = i3 - 1;
              }
            }
          }
          for (;;)
          {
            if ((this.f instanceof ExpandableListView))
            {
              localObject = (ExpandableListView)this.f;
              ((ExpandableListView)localObject).setSelectionFromTop(((ExpandableListView)localObject).getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i + this.eto)), 0);
            }
            for (;;)
            {
              j = -1;
              break;
              if ((this.f instanceof ListView)) {
                ((ListView)this.f).setSelectionFromTop(i + this.eto, 0);
              } else {
                this.f.setSelection(i + this.eto);
              }
            }
            bool = false;
            break label379;
            this.dkl = false;
            return;
          }
        }
        break;
        k = j;
        j = i;
        m = i;
        continue;
        m = i;
        j = i;
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mState == 0) {}
    int k;
    int m;
    int i;
    do
    {
      return;
      k = this.etl;
      m = this.f.getWidth();
      Object localObject1 = this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade;
      i = -1;
      int j;
      if (this.mState == 4)
      {
        j = ((ScrollFade)localObject1).getAlpha();
        if (j < 104) {
          this.mThumbDrawable.setAlpha(j * 2);
        }
      }
      switch (this.mPosition)
      {
      default: 
        i = 0;
        this.mThumbDrawable.setBounds(i, 0, this.etk + i, this.etj);
        this.dkm = true;
        i = j;
        if (this.mTrackDrawable != null)
        {
          localObject1 = this.mThumbDrawable.getBounds();
          int i1 = ((Rect)localObject1).left;
          j = (((Rect)localObject1).bottom - ((Rect)localObject1).top) / 2;
          int n = this.mTrackDrawable.getIntrinsicWidth();
          i1 = i1 + this.etk / 2 - n / 2;
          this.mTrackDrawable.setBounds(i1, j, n + i1, this.f.getHeight() - j);
          this.mTrackDrawable.draw(paramCanvas);
        }
        paramCanvas.translate(0.0F, k);
        this.mThumbDrawable.draw(paramCanvas);
        paramCanvas.translate(0.0F, -k);
        if ((this.mState != 3) || (!this.dkl)) {
          continue;
        }
        if (this.etp == 1) {
          switch (this.mPosition)
          {
          }
        }
        break;
      }
      for (i = Math.max(0, this.mThumbDrawable.getBounds().left - this.etk - this.etm);; i = Math.min(this.mThumbDrawable.getBounds().right + this.etk, this.f.getWidth() - this.etm))
      {
        j = Math.max(0, Math.min((this.etj - this.etm) / 2 + k, this.f.getHeight() - this.etm));
        localObject1 = this.bo;
        ((RectF)localObject1).left = i;
        ((RectF)localObject1).right = (((RectF)localObject1).left + this.etm);
        ((RectF)localObject1).top = j;
        ((RectF)localObject1).bottom = (((RectF)localObject1).top + this.etm);
        if (this.gC != null) {
          this.gC.setBounds((int)((RectF)localObject1).left, (int)((RectF)localObject1).top, (int)((RectF)localObject1).right, (int)((RectF)localObject1).bottom);
        }
        if (this.gC != null) {
          this.gC.draw(paramCanvas);
        }
        localObject1 = this.mPaint;
        float f1 = ((Paint)localObject1).descent();
        RectF localRectF = this.bo;
        Object localObject2 = this.mTmpRect;
        if (this.gC != null) {
          this.gC.getPadding((Rect)localObject2);
        }
        i = (((Rect)localObject2).right - ((Rect)localObject2).left) / 2;
        j = (((Rect)localObject2).bottom - ((Rect)localObject2).top) / 2;
        localObject2 = this.cIV;
        float f2 = (int)(localRectF.left + localRectF.right) / 2 - i;
        float f3 = localRectF.bottom;
        paramCanvas.drawText((String)localObject2, f2, (int)(localRectF.top + f3) / 2 + this.etm / 4 - f1 - j, (Paint)localObject1);
        return;
        i = m - this.etk * j / 208;
        break;
        i = -this.etk + this.etk * j / 208;
        break;
      }
    } while (this.mState != 4);
    if (i == 0)
    {
      setState(0);
      return;
    }
    if (this.mTrackDrawable != null)
    {
      this.f.invalidate(m - this.etk, 0, m, this.f.getHeight());
      return;
    }
    this.f.invalidate(m - this.etk, k, m, this.etj + k);
  }
  
  void ewL()
  {
    Object localObject2 = this.f.getAdapter();
    this.jdField_a_of_type_AndroidWidgetSectionIndexer = null;
    Object localObject1 = localObject2;
    if ((localObject2 instanceof auts))
    {
      this.eto = ((auts)localObject2).getHeadersCount();
      localObject1 = ((auts)localObject2).getWrappedAdapter();
    }
    if ((localObject1 instanceof ExpandableListConnector))
    {
      localObject2 = ((ExpandableListConnector)localObject1).a();
      if ((localObject2 instanceof SectionIndexer))
      {
        this.jdField_a_of_type_AndroidWidgetSectionIndexer = ((SectionIndexer)localObject2);
        this.jdField_a_of_type_AndroidWidgetBaseAdapter = ((BaseAdapter)localObject1);
        this.w = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getSections();
      }
    }
    do
    {
      return;
      if (!(localObject1 instanceof SectionIndexer)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetBaseAdapter = ((BaseAdapter)localObject1);
      this.jdField_a_of_type_AndroidWidgetSectionIndexer = ((SectionIndexer)localObject1);
      this.w = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getSections();
    } while (this.w != null);
    this.w = new String[] { " " };
    return;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = ((BaseAdapter)localObject1);
    this.w = new String[] { " " };
  }
  
  public void ewM()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = null;
  }
  
  void ewN()
  {
    this.f.removeCallbacks(this.iy);
    this.dkp = false;
  }
  
  void ewO()
  {
    this.dkp = true;
    this.f.postDelayed(this.iy, 180L);
  }
  
  void ewP()
  {
    setState(3);
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter == null) && (this.f != null)) {
      ewL();
    }
    if (this.f != null)
    {
      this.f.requestDisallowInterceptTouchEvent(true);
      this.f.reportScrollStateChange(1);
      cancelFling();
    }
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public int getWidth()
  {
    return this.etk;
  }
  
  boolean isVisible()
  {
    return this.mState != 0;
  }
  
  void kY(int paramInt1, int paramInt2)
  {
    if (this.dkn) {
      this.dkk = true;
    }
  }
  
  boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return false;
      if ((this.mState > 0) && (Q(paramMotionEvent.getX(), paramMotionEvent.getY())))
      {
        if (!this.f.isInScrollingContainer())
        {
          ewP();
          return true;
        }
        this.mInitialTouchY = paramMotionEvent.getY();
        ewO();
        continue;
        ewN();
      }
    }
  }
  
  void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if ((this.mItemCount != paramInt3) && (paramInt2 > 0))
    {
      this.mItemCount = paramInt3;
      if (this.mItemCount / paramInt2 >= eti)
      {
        bool = true;
        this.dkk = bool;
      }
    }
    else
    {
      if (this.dkn) {
        this.dkk = true;
      }
      if (this.dkk) {
        break label78;
      }
      if (this.mState != 0) {
        setState(0);
      }
    }
    label78:
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
          if ((paramInt3 - paramInt2 > 0) && (this.mState != 3))
          {
            this.etl = v(paramInt1, paramInt2, paramInt3);
            if (this.dkm)
            {
              ewK();
              this.dkm = false;
            }
          }
          this.dkj = true;
        } while (paramInt1 == this.etn);
        this.etn = paramInt1;
      } while (this.mState == 3);
      setState(2);
    } while (this.dkn);
    this.mHandler.postDelayed(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade, 1500L);
  }
  
  void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mThumbDrawable != null) {
      switch (this.mPosition)
      {
      default: 
        this.mThumbDrawable.setBounds(paramInt1 - this.etk, 0, paramInt1, this.etj);
      }
    }
    for (;;)
    {
      if (this.etp == 0)
      {
        RectF localRectF = this.bo;
        localRectF.left = ((paramInt1 - this.etm) / 2);
        localRectF.right = (localRectF.left + this.etm);
        localRectF.top = (paramInt2 / 10);
        localRectF.bottom = (localRectF.top + this.etm);
        if (this.gC != null) {
          this.gC.setBounds((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
        }
      }
      return;
      this.mThumbDrawable.setBounds(0, 0, this.etk, this.etj);
    }
  }
  
  boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (this.mState == 0) {}
    int j;
    int k;
    label221:
    do
    {
      do
      {
        return false;
        j = paramMotionEvent.getAction();
        if (j != 0) {
          break;
        }
      } while (!Q(paramMotionEvent.getX(), paramMotionEvent.getY()));
      if (!this.f.isInScrollingContainer())
      {
        ewP();
        return true;
      }
      this.mInitialTouchY = paramMotionEvent.getY();
      ewO();
      return false;
      if (j == 1)
      {
        if (this.dkp)
        {
          ewP();
          k = this.f.getHeight();
          j = (int)paramMotionEvent.getY() - this.etj + 10;
          if (j >= 0) {
            break label221;
          }
          i = 0;
        }
        for (;;)
        {
          this.etl = i;
          bk(this.etl / (k - this.etj));
          ewN();
          if (this.mState != 3) {
            break;
          }
          if (this.f != null)
          {
            this.f.requestDisallowInterceptTouchEvent(false);
            this.f.reportScrollStateChange(0);
            setState(2);
          }
          paramMotionEvent = this.mHandler;
          paramMotionEvent.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade);
          if (!this.dkn) {
            paramMotionEvent.postDelayed(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade, 1000L);
          }
          if (this.f != null) {
            this.f.invalidate();
          }
          return true;
          i = j;
          if (this.etj + j > k) {
            i = k - this.etj;
          }
        }
      }
      if (j != 2) {
        break;
      }
      if ((this.dkp) && (Math.abs(paramMotionEvent.getY() - this.mInitialTouchY) > this.ckO))
      {
        setState(3);
        if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter == null) && (this.f != null)) {
          ewL();
        }
        if (this.f != null)
        {
          this.f.requestDisallowInterceptTouchEvent(true);
          this.f.reportScrollStateChange(1);
          cancelFling();
          ewN();
        }
      }
    } while (this.mState != 3);
    if (this.f != null)
    {
      j = this.f.getHeight();
      label355:
      k = (int)paramMotionEvent.getY() - this.etj + 10;
      if (k >= 0) {
        break label395;
      }
    }
    for (;;)
    {
      if (Math.abs(this.etl - i) < 2)
      {
        return true;
        j = 0;
        break label355;
        label395:
        if (this.etj + k <= j) {
          break label458;
        }
        i = j - this.etj;
        continue;
      }
      this.etl = i;
      if (this.dkj) {
        bk(this.etl / (j - this.etj));
      }
      return true;
      if (j != 3) {
        break;
      }
      ewN();
      return false;
      label458:
      i = k;
    }
  }
  
  public void setState(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.mState = paramInt;
      refreshDrawableState();
      return;
      this.mHandler.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade);
      this.f.invalidate();
      continue;
      if (this.mState != 2) {
        ewK();
      }
      this.mHandler.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade);
      continue;
      int i = this.f.getWidth();
      this.f.invalidate(i - this.etk, this.etl, i, this.etl + this.etj);
    }
  }
  
  void stop()
  {
    setState(0);
  }
  
  public class ScrollFade
    implements Runnable
  {
    long azb;
    long mStartTime;
    
    public ScrollFade() {}
    
    void ewQ()
    {
      this.azb = 200L;
      this.mStartTime = SystemClock.uptimeMillis();
      FastScroller.this.setState(4);
    }
    
    int getAlpha()
    {
      if (FastScroller.this.getState() != 4) {
        return 208;
      }
      long l = SystemClock.uptimeMillis();
      if (l > this.mStartTime + this.azb) {
        return 0;
      }
      return (int)(208L - (l - this.mStartTime) * 208L / this.azb);
    }
    
    public void run()
    {
      if (FastScroller.this.getState() != 4)
      {
        ewQ();
        return;
      }
      if (getAlpha() > 0)
      {
        FastScroller.this.f.invalidate();
        return;
      }
      FastScroller.this.setState(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.widget.FastScroller
 * JD-Core Version:    0.7.0.1
 */