package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Canvas;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mtg.b;
import mtg.e;
import mtg.g;
import muj;
import mvo;
import mvp;
import txn;
import wja;

public class VideoFeedsListView
  extends ListView
  implements AbsListView.e
{
  private OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView$b;
  private int aUX = 0;
  private int aUY = 0;
  private int aUZ = -1;
  private int aVa;
  private int aVb;
  private int aVc;
  private int aVd;
  private int aVe = -1;
  private int aVf = -1;
  private int aVg;
  private boolean aoJ;
  private boolean aoK = true;
  private boolean aoL;
  private boolean aoM;
  private boolean aoN;
  private boolean aoO;
  private boolean aoP;
  private boolean aoQ;
  private boolean aoR;
  private boolean aoS;
  protected boolean aoT;
  private boolean aoU = true;
  private boolean aoV;
  private boolean aoW;
  private boolean aoX;
  private boolean aoY;
  private boolean aoZ;
  private boolean aov;
  private boolean apa = true;
  private boolean apb = true;
  private boolean apc = true;
  private ViewGroup bH;
  private ViewGroup bI;
  private ViewGroup bJ;
  private AbsListView.e c;
  private float jM;
  private float jZ;
  private Context mContext;
  private View mHeaderView;
  private boolean mIsScrollable = true;
  private boolean mIsScrolling;
  private ArrayList<a> mListeners = new ArrayList();
  private HashMap<Integer, Long> mOrientationEventMap;
  private int mScreenHeight;
  private int mScreenWidth;
  private VelocityTracker mVelocityTracker;
  private long wT;
  
  public VideoFeedsListView(Context paramContext, Activity paramActivity)
  {
    this(paramContext, (AttributeSet)null);
  }
  
  public VideoFeedsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    paramContext = muj.c((Activity)this.mContext);
    this.mScreenWidth = paramContext[0];
    this.mScreenHeight = paramContext[1];
    setOverScrollMode(2);
    aSE();
    this.mVelocityTracker = VelocityTracker.obtain();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView$b = new b(new Handler());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView$b.registerObserver();
    this.apc = muj.isSystemAutoRotateOpen(this.mContext);
    super.setOnScrollListener(this);
  }
  
  private boolean ED()
  {
    return (this.bJ != null) && ((this.bJ.getTag() instanceof mtg.b));
  }
  
  private void J(View paramView, int paramInt)
  {
    int i = 400;
    if (paramView == null) {
      return;
    }
    Object localObject;
    if (paramView != this.bH)
    {
      localObject = paramView;
      if (paramView != this.bI) {}
    }
    else
    {
      this.aoR = true;
      localObject = paramView;
      if (this.aoX)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "smoothScrollItemToCenter: 极端情况，滚动时数据发生变化，不触发滚动");
        }
        this.aoX = false;
        localObject = this.bJ;
        this.aoR = false;
      }
    }
    if (localObject == this.bI) {
      this.aoV = false;
    }
    int j = (((View)localObject).getTop() + ((View)localObject).getBottom()) / 2 - this.mScreenHeight / 2;
    int m = Math.abs(j);
    int k = Math.abs(paramInt);
    if (k == 0)
    {
      paramInt = 400;
      label131:
      if (m <= 1) {
        break label183;
      }
      if (paramInt <= 400) {
        break label185;
      }
      paramInt = i;
    }
    for (;;)
    {
      if (ad(j, paramInt)) {
        break label202;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "smoothScrollItemToCenter: dont need scroll just return");
      }
      this.aoR = false;
      return;
      paramInt = m / k;
      break label131;
      label183:
      break;
      label185:
      if (paramInt < 150) {
        paramInt = 150;
      }
    }
    label202:
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "scroll distance = " + j + "speed = " + k + "duration = " + paramInt);
    }
    this.aoW = true;
    this.mIsScrolling = true;
    post(new VideoFeedsListView.3(this, j, paramInt));
  }
  
  private void T(float paramFloat)
  {
    if (this.aoZ) {}
    label7:
    VideoFeedsAlphaMaskView localVideoFeedsAlphaMaskView;
    do
    {
      do
      {
        do
        {
          do
          {
            break label7;
            break label7;
            do
            {
              return;
            } while (this.bJ == null);
            if (((this.bJ.getTag() instanceof mtg.e)) && (((mtg.e)this.bJ.getTag()).position == this.aVe))
            {
              localVideoFeedsAlphaMaskView = ((mtg.e)this.bJ.getTag()).a;
              if (localVideoFeedsAlphaMaskView != null) {
                localVideoFeedsAlphaMaskView.setAlpha(paramFloat);
              }
            }
            if ((this.bH == null) || (!(this.bH.getTag() instanceof mtg.e)) || (this.bJ.getTop() <= this.aVb)) {
              break;
            }
          } while (((mtg.e)this.bH.getTag()).position != this.aVe - 1);
          localVideoFeedsAlphaMaskView = ((mtg.e)this.bH.getTag()).a;
        } while (localVideoFeedsAlphaMaskView == null);
        localVideoFeedsAlphaMaskView.setAlpha(1.0F - paramFloat);
        return;
      } while ((this.bI == null) || (!(this.bI.getTag() instanceof mtg.e)) || (((mtg.e)this.bI.getTag()).position != this.aVe + 1));
      localVideoFeedsAlphaMaskView = ((mtg.e)this.bI.getTag()).a;
    } while (localVideoFeedsAlphaMaskView == null);
    localVideoFeedsAlphaMaskView.setAlpha(1.0F - paramFloat);
  }
  
  private void Y(int paramInt, boolean paramBoolean)
  {
    aSG();
    Object localObject1 = this.bJ.findViewById(2131368467);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    localObject1 = this.bJ.findViewById(2131367481);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    this.aoL = true;
    this.aoR = false;
    if (this.mListeners != null)
    {
      localObject1 = this.mListeners.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((a)((Iterator)localObject1).next()).b(this.bJ.getTag(), true);
      }
    }
    localObject1 = (ViewGroup)this.bJ.findViewById(2131365065);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "innerEnterFullScreen() ERROR root == null");
      }
      return;
    }
    Object localObject2 = ((ViewGroup)localObject1).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).height = this.mScreenHeight;
    ((ViewGroup.LayoutParams)localObject2).width = this.mScreenHeight;
    ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    int i = 0;
    while (i < ((ViewGroup)localObject1).getChildCount())
    {
      localObject2 = ((ViewGroup)localObject1).getChildAt(i);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
      if ((localLayoutParams.height != -1) || (localLayoutParams.width != -1))
      {
        i += 1;
      }
      else
      {
        if (paramInt == 1) {
          ((View)localObject2).setRotation(90.0F);
        }
        for (;;)
        {
          ((View)localObject2).setTranslationX(-(this.mScreenHeight - this.mScreenWidth) / 2);
          localLayoutParams.height = this.mScreenWidth;
          localLayoutParams.width = this.mScreenHeight;
          ((View)localObject2).setLayoutParams(localLayoutParams);
          ((View)localObject2).setTranslationY((this.mScreenHeight - this.mScreenWidth) / 2);
          break;
          ((View)localObject2).setRotation(-90.0F);
        }
      }
    }
    localObject2 = this.bJ.findViewById(2131365079);
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(8);
    }
    if (this.aUY == 0)
    {
      if (this.aVe != 0) {
        this.mIsScrolling = true;
      }
      smoothScrollBy(this.aVb, 0);
    }
    if (paramBoolean)
    {
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject2).setDuration(500L);
      ((AlphaAnimation)localObject2).setFillAfter(true);
      ((ViewGroup)localObject1).startAnimation((Animation)localObject2);
    }
    this.aUY = paramInt;
  }
  
  private void aSE()
  {
    this.mOrientationEventMap = new HashMap();
    try
    {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new mvp(this, this.mContext, 3);
      if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "initOrientationEventListener() Exception error=" + localException.getMessage());
    }
  }
  
  private boolean ad(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    paramInt2 = this.mFirstPosition;
    int i = getChildCount();
    int j = getPaddingTop();
    int k = getHeight();
    int m = getPaddingBottom();
    boolean bool1 = bool2;
    if (paramInt1 != 0)
    {
      bool1 = bool2;
      if (this.mItemCount != 0)
      {
        bool1 = bool2;
        if (getChildCount() != 0) {
          if ((paramInt2 == 0) && (getChildAt(0).getTop() == j))
          {
            bool1 = bool2;
            if (paramInt1 < 0) {}
          }
          else if ((paramInt2 + i - 1 == this.mItemCount - 1) && (getChildAt(i - 1).getBottom() == k - m))
          {
            bool1 = bool2;
            if (paramInt1 > 0) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void cU(View paramView)
  {
    J(paramView, 0);
  }
  
  private int dw(int paramInt)
  {
    return (int)(this.mScreenHeight / 2.0F - paramInt / 2.0F - wja.dp2px(2.0F, this.mContext.getResources()));
  }
  
  private boolean innerCheckCanDetectOrientation(int paramInt)
  {
    if ((paramInt >= 70) && (paramInt <= 110)) {
      paramInt = 1;
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      this.mOrientationEventMap.put(Integer.valueOf(paramInt), Long.valueOf(l));
      Iterator localIterator = this.mOrientationEventMap.entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator.next();
      } while ((((Integer)localEntry.getKey()).intValue() == paramInt) || (l - ((Long)localEntry.getValue()).longValue() >= 100L));
      return false;
      if ((paramInt >= 250) && (paramInt <= 290)) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
    return true;
  }
  
  private void o(View paramView, boolean paramBoolean)
  {
    paramView = paramView.findViewById(2131365065);
    if (paramBoolean)
    {
      localLayoutParams = paramView.getLayoutParams();
      this.aVg = localLayoutParams.height;
      localLayoutParams.height = muj.l((Activity)this.mContext);
      paramView.setLayoutParams(localLayoutParams);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = this.aVg;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private int pW()
  {
    int j = getLastVisiblePosition();
    int k = getFirstVisiblePosition();
    int i = 0;
    while (i <= j - k)
    {
      int m = getChildAt(i).getTop();
      int n = getChildAt(i).getBottom();
      if ((m < this.mScreenHeight / 2) && (n > this.mScreenHeight / 2)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void sE(int paramInt)
  {
    paramInt = dw(paramInt);
    if (this.mHeaderView != null)
    {
      View localView = this.mHeaderView.findViewById(2131363565);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void sF(int paramInt)
  {
    if (this.mHeaderView != null)
    {
      View localView = this.mHeaderView.findViewById(2131363565);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void aSF()
  {
    if (this.aoW) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "smoothScrollToNextItem: scrolling item to center ,just return");
      }
    }
    do
    {
      return;
      if (this.mIsScrolling)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "smoothScrollToNextItem: scrolling ,do scroll when idle");
        }
        this.aoV = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "smoothScrollToNextItem: ");
      }
    } while (this.bI == null);
    cU(this.bI);
  }
  
  public void aSG()
  {
    if (this.aUY != 0) {
      break label7;
    }
    label7:
    while (((this.aoL) && (!this.aoJ)) || (this.aoZ) || (this.aoY)) {
      return;
    }
    int i = pW();
    this.bJ = ((ViewGroup)getChildAt(i));
    this.bI = ((ViewGroup)getChildAt(i + 1));
    this.bH = ((ViewGroup)getChildAt(i - 1));
    boolean bool;
    if ((this.bJ != null) && (this.bJ.getTag() != null))
    {
      this.aVe = ((mtg.e)this.bJ.getTag()).position;
      localObject = this.bJ.findViewById(2131365065);
      if (localObject == null)
      {
        QLog.e("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "resetVideoInstance: contentView null ！，itemType=" + ((mtg.e)this.bJ.getTag()).itemType);
        return;
      }
      i = Math.abs(((View)localObject).getRight() - ((View)localObject).getLeft());
      int j = Math.abs(((View)localObject).getBottom() - ((View)localObject).getTop());
      if (i > j)
      {
        bool = true;
        label208:
        this.aoJ = bool;
        this.aVa = j;
        this.aVb = this.bJ.getTop();
      }
    }
    else
    {
      this.aoP = false;
      this.aoO = false;
      if (!this.aoU) {
        break label336;
      }
    }
    label336:
    for (Object localObject = this.bI;; localObject = this.bJ)
    {
      if ((localObject != null) && (((View)localObject).getTag() != null) && (((mtg.e)((View)localObject).getTag()).position == getAdapter().getCount() - 1 - getHeaderViewsCount() - getFooterViewsCount())) {
        this.aoP = true;
      }
      if ((this.bH == null) || (this.bH.getId() != 2131376714)) {
        break;
      }
      this.aoO = true;
      return;
      bool = false;
      break label208;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (!this.aoS)
    {
      this.bJ = ((ViewGroup)getChildAt(1));
      if (this.bJ != null) {}
    }
    do
    {
      do
      {
        return;
        this.aVc = (this.bJ.getBottom() - this.bJ.getTop());
        boolean bool;
        if (this.aoZ)
        {
          paramCanvas = this.bJ.findViewById(2131365065);
          int i = Math.abs(paramCanvas.getRight() - paramCanvas.getLeft());
          int j = Math.abs(paramCanvas.getBottom() - paramCanvas.getTop());
          if (i > j)
          {
            bool = true;
            this.aoJ = bool;
            this.aVa = j;
            this.aVb = dw(this.aVc);
            this.bJ.findViewById(2131368467).setVisibility(8);
            sF(0);
            o(this.bJ, true);
            this.apa = false;
          }
        }
        for (;;)
        {
          this.aoS = true;
          return;
          bool = false;
          break;
          sE(this.bJ.getHeight());
        }
        if ((!this.aoU) && (this.aoP))
        {
          aSG();
          if ((!this.aoP) && (!this.mIsScrolling) && (this.bJ != null) && ((this.bJ.getTag() instanceof mtg.g)) && (this.mListeners != null))
          {
            paramCanvas = this.mListeners.iterator();
            while (paramCanvas.hasNext()) {
              ((a)paramCanvas.next()).Y(this.bJ.getTag());
            }
          }
        }
      } while (this.aoQ);
      if (!this.aoZ)
      {
        aSG();
        this.aVb = dw(this.aVc);
      }
    } while ((this.bJ == null) || (!(this.bJ.getTag() instanceof mtg.g)));
    this.bJ.findViewById(2131365079).setAlpha(0.0F);
    if (this.mListeners != null)
    {
      paramCanvas = this.mListeners.iterator();
      while (paramCanvas.hasNext()) {
        ((a)paramCanvas.next()).Y(this.bJ.getTag());
      }
    }
    this.aoQ = true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.wT = System.currentTimeMillis();
    if (this.mIsScrolling) {
      return true;
    }
    if (this.aoL) {
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.aoR = false;
      this.aoN = false;
      this.jM = paramMotionEvent.getY();
      this.aoM = false;
      aSG();
    }
    if ((paramMotionEvent.getAction() == 2) && (!this.aoM) && (this.bJ != null))
    {
      int i = wja.dp2px(25.0F, this.mContext.getResources());
      int j = ViewConfiguration.getTouchSlop();
      if ((Math.abs(this.jM - paramMotionEvent.getY()) > j) && ((this.jM < i) || (Math.abs(this.mScreenHeight - this.jM) < i)))
      {
        this.aoM = true;
        return true;
      }
    }
    if ((!this.mIsScrollable) || (this.aoZ)) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = 1.0F;
    float f2;
    if (this.bJ != null)
    {
      f2 = Math.round(Math.abs(this.bJ.getTop() - this.aVb) / this.aVa * 100.0F) / 100.0F;
      if (f2 <= 1.0F) {
        break label81;
      }
    }
    for (;;)
    {
      T(f1);
      if (this.c != null) {
        this.c.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      return;
      label81:
      f1 = f2;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      txn.a().stopMonitorScene("list_video_feeds", false);
      switch (paramInt)
      {
      default: 
        label40:
        if (this.c != null) {
          this.c.onScrollStateChanged(paramAbsListView, paramInt);
        }
        break;
      }
    }
    do
    {
      return;
      txn.a().startMonitorScene("list_video_feeds");
      break;
      if ((this.aUX == 1) && (!this.mIsScrolling)) {
        J(this.bJ, this.aVd);
      }
      for (;;)
      {
        this.aoX = false;
        this.aUX = 0;
        break;
        this.mIsScrolling = false;
        this.aoW = false;
        if (this.aoR) {
          T(1.0F);
        }
        aSG();
        if (this.aoR) {
          T(0.0F);
        }
        if ((this.aoR) && (this.mListeners != null) && (!this.aoL) && (this.bJ != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsPlayManager.preplay", 2, "onScrollStateChanged: onCenterViewChanged ");
          }
          Iterator localIterator = this.mListeners.iterator();
          while (localIterator.hasNext()) {
            ((a)localIterator.next()).Y(this.bJ.getTag());
          }
        }
        if (this.aoV) {
          aSF();
        }
      }
      this.aUX = 1;
      break label40;
    } while (this.mIsScrolling);
    if (this.jZ > this.jM) {
      if (!this.aoO) {
        J(this.bH, this.aVd);
      }
    }
    for (;;)
    {
      this.aUX = 2;
      break;
      J(this.bJ, this.aVd);
      continue;
      if (this.jZ < this.jM) {
        if (!this.aoP) {
          J(this.bI, this.aVd);
        } else {
          J(this.bJ, this.aVd);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.mIsScrolling) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.aoL);
      bool1 = bool2;
    } while (this.aoM);
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    if (this.aVf == 6)
    {
      this.jM = paramMotionEvent.getY();
      this.aVf = paramMotionEvent.getActionMasked();
      return super.onTouchEvent(paramMotionEvent);
    }
    this.aVf = paramMotionEvent.getActionMasked();
    if (paramMotionEvent.getAction() == 1)
    {
      this.jZ = paramMotionEvent.getY();
      if (((this.aoT) && (this.aoP)) || ((this.aoP) && (paramMotionEvent.getY() + 300.0F < this.jM)))
      {
        if (this.mListeners != null)
        {
          paramMotionEvent = this.mListeners.iterator();
          while (paramMotionEvent.hasNext()) {
            ((a)paramMotionEvent.next()).aSa();
          }
        }
        J(this.bJ, this.aVd);
        return true;
      }
      this.mVelocityTracker.clear();
    }
    int i;
    float f;
    do
    {
      do
      {
        return super.onTouchEvent(paramMotionEvent);
      } while (paramMotionEvent.getAction() != 2);
      this.mVelocityTracker.computeCurrentVelocity(1);
      this.aVd = ((int)this.mVelocityTracker.getYVelocity());
      if ((this.aoO) && (paramMotionEvent.getY() > this.jM))
      {
        if ((paramMotionEvent.getY() - this.jM > 300.0F) && (!this.aov))
        {
          this.aov = true;
          if (this.mListeners != null)
          {
            paramMotionEvent = this.mListeners.iterator();
            while (paramMotionEvent.hasNext()) {
              ((a)paramMotionEvent.next()).aSH();
            }
          }
        }
        return true;
      }
      i = (int)(this.aVa * 0.3D);
      f = paramMotionEvent.getY() - this.jM;
      if ((!this.aoT) && (this.aoP) && (f < 0.0F) && (Math.abs(f) >= i)) {
        return true;
      }
      if (this.aoN) {
        return true;
      }
      if ((f > 0.0F) && (i <= f))
      {
        this.aoN = true;
        J(this.bH, this.aVd);
        return true;
      }
    } while ((f >= 0.0F) || (Math.abs(f) < i));
    this.aoN = true;
    J(this.bI, this.aVd);
    return true;
  }
  
  public void ou(boolean paramBoolean)
  {
    this.aoL = false;
    this.aUY = 0;
    if (this.mListeners != null)
    {
      localObject1 = this.mListeners.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((a)((Iterator)localObject1).next()).b(this.bJ.getTag(), false);
      }
    }
    Object localObject1 = this.bJ.findViewById(2131368467);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.bJ.findViewById(2131367481);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = (ViewGroup)this.bJ.findViewById(2131365065);
    if (localObject1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "innerExitFullScreen() ERROR root == null");
      }
    }
    do
    {
      return;
      Object localObject2 = ((ViewGroup)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = this.aVa;
      ((ViewGroup.LayoutParams)localObject2).width = this.mScreenWidth;
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      int i = 0;
      if (i < ((ViewGroup)localObject1).getChildCount())
      {
        localObject2 = ((ViewGroup)localObject1).getChildAt(i);
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
        if ((localLayoutParams.height != this.mScreenWidth) || (localLayoutParams.width != this.mScreenHeight)) {}
        for (;;)
        {
          i += 1;
          break;
          ((View)localObject2).setRotation(0.0F);
          ((View)localObject2).setTranslationX(0.0F);
          localLayoutParams.height = -1;
          localLayoutParams.width = -1;
          ((View)localObject2).setLayoutParams(localLayoutParams);
          ((View)localObject2).setTranslationY(0.0F);
        }
      }
      if (this.aVe != 0) {
        this.mIsScrolling = true;
      }
      smoothScrollBy(-this.aVb, 0);
      localObject1 = this.bJ.findViewById(2131365079);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    } while (!paramBoolean);
    localObject1 = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject1).setDuration(500L);
    ((AlphaAnimation)localObject1).setFillAfter(true);
    startAnimation((Animation)localObject1);
  }
  
  public void ov(boolean paramBoolean)
  {
    if (this.aoL) {}
    while (this.aUX == 1) {
      return;
    }
    this.aUZ = 1;
    Y(1, paramBoolean);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    getAdapter().registerDataSetObserver(new mvo(this));
  }
  
  public void setIsLastItemAsFooter(boolean paramBoolean)
  {
    this.aoU = paramBoolean;
  }
  
  public void setIsOrignalVideoFullScreen(boolean paramBoolean)
  {
    this.apb = paramBoolean;
  }
  
  public void setIsScrollItemToTop(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.aoQ) {
      if (!paramBoolean1)
      {
        this.bJ.findViewById(2131368467).setVisibility(0);
        if (!this.apa)
        {
          this.apa = true;
          sE(this.aVc);
          o(this.bJ, false);
          this.aoZ = false;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "setIsScrollItemToTop isScrollItemToTop=" + paramBoolean1 + ", needDurationWhenScrollToTop=" + paramBoolean2 + ", mFirstDrawCompleted=" + this.aoQ + ", mIsHeaderHeightSetted=" + this.apa + ", mIsNeedRecoveryScrollItemToTop=" + this.aoY + ", mCenterViewHeight=" + this.aVc + ", mContentViewHeightBefore=" + this.aVg);
      }
      if (this.mListeners == null) {
        return;
      }
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).ow(paramBoolean1);
      }
      this.bH = null;
      this.bI = null;
      this.mIsScrolling = true;
      if (this.aoY)
      {
        smoothScrollBy(-this.aVb, 0);
        break;
      }
      smoothScrollBy(-this.aVb, 500);
      break;
      this.aoZ = true;
      this.aVc = (this.bJ.getBottom() - this.bJ.getTop());
      this.bJ.findViewById(2131368467).setVisibility(8);
      this.mIsScrolling = true;
      if (paramBoolean2) {
        smoothScrollBy(this.aVb, 500);
      }
      for (;;)
      {
        o(this.bJ, true);
        break;
        smoothScrollBy(this.aVb, 0);
      }
      this.aoZ = paramBoolean1;
    }
  }
  
  public void setNeedDetectScreenOrientation(boolean paramBoolean)
  {
    this.aoK = paramBoolean;
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.c = parame;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.mIsScrollable = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void Y(Object paramObject);
    
    public abstract void aSH();
    
    public abstract void aSa();
    
    public abstract void b(Object paramObject, boolean paramBoolean);
    
    public abstract void ow(boolean paramBoolean);
  }
  
  class b
    extends ContentObserver
  {
    private ContentResolver mResolver = VideoFeedsListView.a(VideoFeedsListView.this).getContentResolver();
    
    public b(Handler paramHandler)
    {
      super();
    }
    
    public void onChange(boolean paramBoolean)
    {
      boolean bool = true;
      super.onChange(paramBoolean);
      int i = Settings.System.getInt(VideoFeedsListView.a(VideoFeedsListView.this).getContentResolver(), "accelerometer_rotation", -1);
      VideoFeedsListView localVideoFeedsListView = VideoFeedsListView.this;
      if (i == 1) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        VideoFeedsListView.b(localVideoFeedsListView, paramBoolean);
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "RotationObserver.onChange() : rotateState=" + i);
        }
        return;
      }
    }
    
    public void registerObserver()
    {
      this.mResolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView
 * JD-Core Version:    0.7.0.1
 */