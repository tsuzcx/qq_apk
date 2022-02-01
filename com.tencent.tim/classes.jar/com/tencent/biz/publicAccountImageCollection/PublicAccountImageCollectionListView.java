package com.tencent.biz.publicAccountImageCollection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import aqiw;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import noy;
import otd.a;
import otd.b;
import otz.b;
import oub.c;
import oub.d;

public class PublicAccountImageCollectionListView
  extends ListView
  implements AbsListView.e
{
  private int aVd;
  private boolean aoN;
  private boolean aoR;
  boolean ayp = false;
  int bfT;
  private AbsListView.e c;
  private float jM;
  private float jZ;
  private Context mContext;
  private boolean mIsScrolling;
  private ArrayList<a> mListeners = new ArrayList();
  private int mScreenHeight;
  private VelocityTracker mVelocityTracker;
  private ArrayList<oub.d> mi;
  private ArrayList<oub.c> mj;
  private long qC;
  
  public PublicAccountImageCollectionListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PublicAccountImageCollectionListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PublicAccountImageCollectionListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void bhg()
  {
    if (this.ayp) {}
    while (!PublicAccountImageCollectionPreloadManager.a().Hp()) {
      return;
    }
    PublicAccountImageCollectionPreloadManager.a().bdm();
    if (this.mi != null)
    {
      int j = this.mi.size();
      int i = 0;
      while (i < j)
      {
        PublicAccountImageCollectionPreloadManager.a().oZ(((oub.d)this.mi.get(i)).arn);
        i += 1;
      }
    }
    this.ayp = true;
  }
  
  private void cj(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionListView", 2, "preloadImg start:" + paramInt1 + " count:" + paramInt2);
    }
    if (this.mj == null) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while (!aqiw.isWifiConnected(this.mContext));
    ArrayList localArrayList = new ArrayList(this.mj);
    ThreadManager.post(new PublicAccountImageCollectionListView.2(this, this.qC, localArrayList, paramInt1, paramInt2, l), 5, null, true);
  }
  
  private void jX(int paramInt)
  {
    Object localObject = getChildAt(paramInt - getFirstVisiblePosition());
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionListView", 2, "smoothScrollTo targetView is null");
      }
      return;
    }
    if (paramInt != pW()) {
      this.aoR = true;
    }
    int i = ((View)localObject).getTop();
    paramInt = ((View)localObject).getBottom();
    if ((((View)localObject).getTag() instanceof otd.b))
    {
      localObject = (otd.b)((View)localObject).getTag();
      if (((otd.b)localObject).textView.getBottom() != ((otd.b)localObject).e.getBottom()) {
        paramInt = ((otd.b)localObject).e.getBottom() + i;
      }
    }
    for (;;)
    {
      i = (paramInt + i) / 2 - this.mScreenHeight / 2;
      if (i == 0) {
        break;
      }
      paramInt = Math.abs(i);
      int j = Math.abs(this.aVd);
      if (j == 0) {
        paramInt = 400;
      }
      for (;;)
      {
        this.mIsScrolling = true;
        noy.a().pauseDownload();
        post(new PublicAccountImageCollectionListView.1(this, i, paramInt));
        return;
        paramInt /= j;
      }
    }
  }
  
  private int pW()
  {
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      int j = getChildAt(i - getFirstVisiblePosition()).getTop();
      int k = getChildAt(i - getFirstVisiblePosition()).getBottom();
      if ((j < this.mScreenHeight / 2) && (k > this.mScreenHeight / 2)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public Boolean a(View paramView)
  {
    boolean bool = false;
    if (q().equals(paramView)) {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  public void a(a parama)
  {
    this.mListeners.add(parama);
  }
  
  public void bhe()
  {
    jX(this.bfT);
  }
  
  void bhf()
  {
    int i = getFirstVisiblePosition();
    if (i <= getLastVisiblePosition())
    {
      ViewGroup localViewGroup = (ViewGroup)getChildAt(i - getFirstVisiblePosition());
      if ((localViewGroup.getTop() < this.mScreenHeight / 2) && (localViewGroup.getBottom() > this.mScreenHeight / 2))
      {
        if ((localViewGroup.getTag() instanceof otz.b))
        {
          localViewGroup.setClickable(false);
          localViewGroup.getChildAt(0).setClickable(true);
          localViewGroup.getChildAt(0).setFocusable(true);
          localViewGroup.getChildAt(0).setEnabled(true);
        }
        if ((localViewGroup.getTag() instanceof otd.b))
        {
          localViewGroup.setClickable(false);
          localViewGroup.getChildAt(1).setClickable(true);
          localViewGroup.getChildAt(1).setFocusable(true);
          localViewGroup.getChildAt(1).setEnabled(true);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localViewGroup.getTag() instanceof otz.b))
        {
          localViewGroup.setClickable(true);
          localViewGroup.getChildAt(0).setClickable(false);
          localViewGroup.getChildAt(0).setFocusable(false);
          localViewGroup.getChildAt(0).setEnabled(false);
        }
        if ((localViewGroup.getTag() instanceof otd.b))
        {
          localViewGroup.setClickable(true);
          localViewGroup.getChildAt(1).setClickable(false);
          localViewGroup.getChildAt(1).setFocusable(false);
          localViewGroup.getChildAt(1).setEnabled(false);
        }
      }
    }
  }
  
  void dB(View paramView)
  {
    float f1 = 1.0F;
    VideoFeedsAlphaMaskView localVideoFeedsAlphaMaskView = null;
    float f2;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      if (!(paramView.getTag() instanceof otd.b)) {
        break label112;
      }
      localVideoFeedsAlphaMaskView = ((otd.b)paramView.getTag()).b;
      int i = Math.abs((paramView.getBottom() + paramView.getTop()) / 2 - this.mScreenHeight / 2);
      int j = (paramView.getBottom() - paramView.getTop()) / 2;
      f2 = Math.round(i / j * 100.0F) / 100.0F;
      if (f2 <= 1.0F) {
        break label162;
      }
    }
    for (;;)
    {
      if (localVideoFeedsAlphaMaskView != null) {
        localVideoFeedsAlphaMaskView.setAlpha(f1);
      }
      return;
      label112:
      if ((paramView.getTag() instanceof otd.a))
      {
        localVideoFeedsAlphaMaskView = ((otd.a)paramView.getTag()).b;
        break;
      }
      if (!(paramView.getTag() instanceof otz.b)) {
        break;
      }
      localVideoFeedsAlphaMaskView = ((otz.b)paramView.getTag()).b;
      break;
      label162:
      f1 = f2;
    }
  }
  
  public void doOnDestory()
  {
    if (this.mListeners != null)
    {
      this.mListeners.clear();
      this.mListeners = null;
    }
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    this.mContext = null;
    noy.a().clean();
  }
  
  void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mVelocityTracker = VelocityTracker.obtain();
    super.setOnScrollListener(this);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mIsScrolling) {
      return true;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.aoR = false;
      this.aoN = false;
      this.jM = paramMotionEvent.getY();
      this.bfT = pW();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      dB(paramAbsListView.getChildAt(paramInt1));
      paramInt1 += 1;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.c != null) {
        this.c.onScrollStateChanged(paramAbsListView, paramInt);
      }
      do
      {
        return;
        if (!this.mIsScrolling) {
          jX(this.bfT);
        }
        this.mIsScrolling = false;
        ViewGroup localViewGroup = q();
        if ((this.aoR) && (this.mListeners != null) && (localViewGroup != null))
        {
          Iterator localIterator = this.mListeners.iterator();
          while (localIterator.hasNext()) {
            ((a)localIterator.next()).Y(localViewGroup.getTag());
          }
        }
        noy.a().resume();
        int i = getLastVisiblePosition();
        int j = getFirstVisiblePosition();
        int k = PublicAccountImageCollectionPreloadManager.a().rT();
        cj(getFirstVisiblePosition(), i - j + 1 + k);
        if ((getChildAt(paramAbsListView.getLastVisiblePosition() - getFirstVisiblePosition()).getTag() instanceof otz.b)) {
          bhg();
        }
        bhf();
        break;
      } while (this.mIsScrolling);
      if (this.jZ - this.jM > 0.0F) {
        jX(this.bfT - 1);
      } else {
        jX(this.bfT + 1);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mIsScrolling) {
      return true;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    if (paramMotionEvent.getAction() == 1)
    {
      this.jZ = paramMotionEvent.getY();
      this.mVelocityTracker.clear();
    }
    do
    {
      int i;
      do
      {
        View localView;
        do
        {
          do
          {
            return super.onTouchEvent(paramMotionEvent);
          } while (paramMotionEvent.getAction() != 2);
          this.mVelocityTracker.computeCurrentVelocity(1);
          this.aVd = ((int)this.mVelocityTracker.getYVelocity());
          if (this.aoN) {
            break;
          }
          localView = getChildAt(this.bfT - getFirstVisiblePosition());
        } while (localView == null);
        i = (int)(localView.getHeight() * 0.8D);
      } while (Math.abs(paramMotionEvent.getY() - this.jM) < i);
      if (paramMotionEvent.getY() - this.jM > 0.0F)
      {
        this.aoN = true;
        jX(this.bfT - 1);
        return true;
      }
    } while (paramMotionEvent.getY() - this.jM >= 0.0F);
    this.aoN = true;
    jX(this.bfT + 1);
    return true;
  }
  
  public ViewGroup q()
  {
    return (ViewGroup)getChildAt(pW() - getFirstVisiblePosition());
  }
  
  public void setPhotoCollectionInfo(ArrayList<oub.c> paramArrayList)
  {
    this.mj = paramArrayList;
    cj(1, 1);
  }
  
  public void setRecommendInfo(ArrayList<oub.d> paramArrayList)
  {
    this.mi = paramArrayList;
  }
  
  public void setScreenHeight(int paramInt)
  {
    this.mScreenHeight = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void Y(Object paramObject);
  }
  
  static class b
  {
    public int reqHeight;
    public int reqWidth;
    public URL url;
    
    public static b a(URL paramURL, int paramInt1, int paramInt2)
    {
      b localb = new b();
      localb.url = paramURL;
      localb.reqWidth = paramInt1;
      localb.reqHeight = paramInt2;
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView
 * JD-Core Version:    0.7.0.1
 */