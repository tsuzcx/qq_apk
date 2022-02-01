package com.tencent.mobileqq.hotpic;

import ahzn;
import ahzo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import auup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HotPicTab
  extends HorizontalListView
{
  private static final float DENSITY;
  private static int SCREEN_WIDTH;
  private static final int SELECTED_COLOR;
  private static final int aXr;
  private static final int aXs;
  private static final int aXt;
  private static final int dcI;
  a a;
  private int aXz = -1;
  private Set<Integer> cC = new HashSet();
  private int dcH = -1;
  int dcJ = -1;
  private float ki;
  private Context mContext;
  private Handler mHandler = new ahzn(this);
  public final Paint mPaint;
  Paint paint = new Paint();
  private ArrayList<Integer> xm = new ArrayList();
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    SCREEN_WIDTH = localResources.getDisplayMetrics().widthPixels;
    aXr = (int)(40.0F * localResources.getDisplayMetrics().density + 0.5F);
    aXs = (int)(4.0F * localResources.getDisplayMetrics().density + 0.5F);
    aXt = 14;
    DENSITY = localResources.getDisplayMetrics().density;
    SELECTED_COLOR = localResources.getColor(2131167312);
    dcI = localResources.getColor(2131167304);
  }
  
  public HotPicTab(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setColor(SELECTED_COLOR);
  }
  
  public int Fv()
  {
    return this.mCurrentlySelectedAdapterIndex;
  }
  
  public void X(List<HotPicTagInfo> paramList, int paramInt)
  {
    boolean bool1 = false;
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {}
    Iterator localIterator;
    HotPicTagInfo localHotPicTagInfo;
    for (int i = 2131165400;; i = 2131167673)
    {
      setBackgroundResource(i);
      paramList = new ArrayList(paramList);
      this.paint.setTextSize(aXt * DENSITY + 0.5F);
      localIterator = paramList.iterator();
      int j;
      for (i = 0; localIterator.hasNext(); i = j + i)
      {
        localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
        j = (int)((int)(this.paint.measureText(localHotPicTagInfo.tagName) + 0.5F) + DENSITY * 26.0F);
        this.xm.add(Integer.valueOf(j));
      }
    }
    if (i < SCREEN_WIDTH)
    {
      boolean bool2 = true;
      this.xm.clear();
      float f = SCREEN_WIDTH / i;
      localIterator = paramList.iterator();
      for (;;)
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
        localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
        i = (int)((int)((int)(this.paint.measureText(localHotPicTagInfo.tagName) + 0.5F) + DENSITY * 26.0F) * f);
        this.xm.add(Integer.valueOf(i));
      }
    }
    this.a = new a(paramList, this.xm, bool1);
    this.dcJ = paramInt;
    setAdapter(this.a);
  }
  
  public HotPicTagInfo a()
  {
    if (this.a != null)
    {
      Object localObject = this.a.Ay;
      if (((List)localObject).size() > this.mCurrentlySelectedAdapterIndex)
      {
        localObject = (HotPicTagInfo)((List)localObject).get(this.mCurrentlySelectedAdapterIndex);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void clear()
  {
    setAdapter(null);
    this.xm.clear();
    setOnItemClickListener(null);
    this.a = null;
    this.cC.clear();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    int k = 0;
    super.dispatchDraw(paramCanvas);
    int i = SCREEN_WIDTH;
    int j;
    if (this.dcH < this.mLeftViewAdapterIndex)
    {
      i = 0;
      j = 0;
    }
    for (;;)
    {
      View localView;
      Object localObject;
      int m;
      if (this.ki > 0.0F)
      {
        localView = getSelectedView();
        if ((localView != null) && (localView.getTag() != null))
        {
          localObject = ((b)localView.getTag()).sZ;
          m = (int)(localView.getLeft() + ((TextView)localObject).getLeft() - DENSITY * 5.0F);
          k = localView.getLeft();
          k = (int)(((TextView)localObject).getRight() + k + DENSITY * 5.0F);
          label121:
          float f1 = j;
          float f2 = this.ki;
          j = (int)((m - j) * f2 + f1);
          f1 = i;
          f2 = this.ki;
          i = (int)(f1 + (k - i) * f2);
        }
      }
      for (;;)
      {
        paramCanvas.drawRect(j, getHeight() - aXs, i, getHeight(), this.mPaint);
        return;
        if (this.dcH > this.mRightViewAdapterIndex)
        {
          j = SCREEN_WIDTH;
          break;
        }
        localView = getChild(this.dcH);
        if ((localView == null) || (localView.getTag() == null)) {
          break label314;
        }
        localObject = (b)localView.getTag();
        j = (int)(localView.getLeft() + ((b)localObject).sZ.getLeft() - DENSITY * 5.0F);
        i = localView.getLeft();
        i = (int)(((b)localObject).sZ.getRight() + i + DENSITY * 5.0F);
        break;
        m = 0;
        break label121;
      }
      label314:
      j = 0;
    }
  }
  
  public int hr(int paramInt)
  {
    int i = this.mNextX + paramInt;
    if (i < 0) {
      return -1;
    }
    if (i > this.mMaxX) {
      return 1;
    }
    this.mScroller.startScroll(this.mNextX, 0, paramInt, 0, 20);
    setCurrentScrollState(4098);
    requestLayout();
    return 0;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (AppSetting.enableTalkBack) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 50, paramInt8, paramBoolean);
  }
  
  public void reset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.reset(paramBoolean);
      return;
    }
    initView(this.isFromRightToLeft);
    removeAllViewsInLayout();
    if (this.dcJ != -1)
    {
      int i = 0;
      int j = 0;
      while ((i < this.dcJ) && (i < this.xm.size()))
      {
        j += ((Integer)this.xm.get(i)).intValue();
        i += 1;
      }
      i = ((Integer)this.xm.get(this.dcJ)).intValue() * 1 / 2 + j;
      j = SCREEN_WIDTH * 1 / 2;
      if (i > j)
      {
        this.mCurrentX = (i - j);
        this.mCurrentlySelectedAdapterIndex = this.dcJ;
        this.dcH = this.dcJ;
        this.ki = 1.0F;
        this.mDataChanged = true;
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      this.mCurrentX = 0;
      break;
      this.mCurrentlySelectedAdapterIndex = 0;
      this.dcH = 0;
    }
  }
  
  public void setSelection(int paramInt)
  {
    if (this.mCurrentlySelectedAdapterIndex == paramInt) {}
    int n;
    do
    {
      return;
      super.setSelection(paramInt);
      n = SCREEN_WIDTH;
    } while ((this.mAdapter == null) || (paramInt >= this.mAdapter.getCount()) || (paramInt < 0));
    int k = getFirstVisiblePosition();
    int m = getLastVisiblePosition();
    int i;
    int j;
    if ((paramInt > m) && (m != -1))
    {
      i = 0;
      j = 0;
      while (i <= paramInt)
      {
        j += ((Integer)this.xm.get(i)).intValue();
        i += 1;
      }
      paramInt = j - this.mNextX - n;
      if (paramInt == 0) {
        break label324;
      }
      hr(paramInt);
    }
    for (;;)
    {
      this.ki = 0.0F;
      this.mHandler.removeCallbacksAndMessages(null);
      if (!Build.MODEL.equalsIgnoreCase("OPPO R7")) {
        break label358;
      }
      this.mHandler.sendEmptyMessage(2);
      return;
      if ((paramInt < k) && (k != -1))
      {
        i = 0;
        j = 0;
        while (i < paramInt)
        {
          j += ((Integer)this.xm.get(i)).intValue();
          i += 1;
        }
        paramInt = j - this.mNextX;
        break;
      }
      View localView;
      int[] arrayOfInt;
      if (paramInt == k)
      {
        localView = getChildAt(0);
        arrayOfInt = new int[2];
        localView.getLocationOnScreen(arrayOfInt);
        paramInt = arrayOfInt[0];
        break;
      }
      if (paramInt == m)
      {
        localView = getChildAt(getChildCount() - 1);
        arrayOfInt = new int[2];
        localView.getLocationOnScreen(arrayOfInt);
        i = ((Integer)this.xm.get(paramInt)).intValue() - (n - arrayOfInt[0]);
        paramInt = i;
        if (i >= 0) {
          break;
        }
        paramInt = 0;
        break;
      }
      if ((DEBUG) && (QLog.isDevelopLevel())) {}
      paramInt = 0;
      break;
      label324:
      if ((k == -1) && (m == -1)) {
        ViewCompat.postOnAnimation(this, new HotPicTab.2(this));
      } else {
        requestLayout();
      }
    }
    label358:
    this.mHandler.sendEmptyMessage(0);
  }
  
  public class a
    extends BaseAdapter
  {
    List<HotPicTagInfo> Ay;
    boolean aME;
    ArrayList<Integer> xn;
    
    public a(ArrayList<Integer> paramArrayList, boolean paramBoolean)
    {
      this.Ay = paramArrayList;
      this.xn = ((ArrayList)paramBoolean.clone());
      boolean bool;
      this.aME = bool;
    }
    
    public int getCount()
    {
      return this.Ay.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.Ay.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      if (paramView == null)
      {
        localObject = new HotPicTab.b(HotPicTab.this);
        paramView = LayoutInflater.from(HotPicTab.a(HotPicTab.this)).inflate(2131558667, null);
        ((HotPicTab.b)localObject).sZ = ((TextView)paramView.findViewById(2131368643));
        paramView.setTag(localObject);
      }
      for (;;)
      {
        String str = ((HotPicTagInfo)getItem(paramInt)).tagName;
        localObject = ((HotPicTab.b)localObject).sZ;
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setTextSize(2, HotPicTab.aXt);
        ((TextView)localObject).setTextColor(HotPicTab.dcI);
        ((TextView)localObject).setPadding(0, 0, 0, 0);
        ((TextView)localObject).setFocusable(true);
        ((TextView)localObject).setGravity(17);
        paramView.setLayoutParams(new RelativeLayout.LayoutParams(((Integer)this.xn.get(paramInt)).intValue(), -1));
        paramView.setContentDescription(str);
        paramView.setFocusable(true);
        paramView.setOnHoverListener(new ahzo(this));
        if (!HotPicTab.a(HotPicTab.this).contains(Integer.valueOf(paramInt)))
        {
          anot.a(null, "dc00898", "", "", "0X8008077", "0X8008077", 0, 0, paramInt + "", "", str, "");
          HotPicTab.a(HotPicTab.this).add(Integer.valueOf(paramInt));
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject = (HotPicTab.b)paramView.getTag();
      }
    }
  }
  
  class b
  {
    TextView sZ;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicTab
 * JD-Core Version:    0.7.0.1
 */