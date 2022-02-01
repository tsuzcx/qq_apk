package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import arji;
import arjj;
import arjk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabBarView
  extends LinearLayout
{
  protected static int SCREEN_WIDTH;
  private static final int aXr;
  private static final int aXs;
  private static final int aXt = 16;
  private static final int eip;
  protected List<RedDotTextView> Js = new ArrayList();
  public int aXA = -1;
  protected int aXu = aXr;
  protected int aXv = aXs;
  public int aXw;
  protected int aXx;
  protected int aXy;
  public int aXz = -1;
  private boolean arh;
  public long avU;
  public a b;
  protected LinearLayout.LayoutParams c;
  protected int ccq;
  public int eiq;
  public int eir;
  protected List<LinearLayout> jO = new ArrayList();
  protected List<String> jP = new ArrayList();
  public float ki;
  private Handler mHandler = new arji(this);
  protected int mLeftPadding;
  public final Paint mPaint;
  protected int mRightPadding;
  protected int mTextSize = aXt;
  protected int mTopPadding;
  Paint paint = new Paint();
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    aXr = (int)(40.0F * localBaseApplication.getResources().getDisplayMetrics().density + 0.5F);
    aXs = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 4.0F + 0.5F);
    eip = 10;
  }
  
  public TabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aXw = paramContext.getResources().getColor(2131167312);
    this.aXx = paramContext.getResources().getColor(2131167304);
    this.mPaint = new Paint();
    this.mPaint.setColor(this.aXw);
    this.c = new LinearLayout.LayoutParams(0, -1);
    this.c.weight = 1.0F;
    this.c.gravity = 17;
    setBackgroundDrawable(getResources().getDrawable(2130851395));
    if (SCREEN_WIDTH == 0) {
      SCREEN_WIDTH = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }
  }
  
  private void aVv()
  {
    Object localObject = (AccessibilityManager)getContext().getSystemService("accessibility");
    if ((localObject != null) && (((AccessibilityManager)localObject).isEnabled()))
    {
      int j = getChildCount();
      localObject = new StringBuilder(30);
      int i = 0;
      while (i < j)
      {
        RedDotTextView localRedDotTextView = b(i);
        if (localRedDotTextView != null)
        {
          ((StringBuilder)localObject).append(localRedDotTextView.getText()).append("，").append(getContext().getString(2131692117));
          if (this.aXA == i) {
            ((StringBuilder)localObject).append("，").append("已选中");
          }
          localRedDotTextView.setContentDescription(((StringBuilder)localObject).toString());
          ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
        }
        i += 1;
      }
    }
  }
  
  private void df(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {}
    try
    {
      TextView localTextView;
      if (paramInt1 < this.Js.size())
      {
        localTextView = (TextView)this.Js.get(paramInt1);
        if (localTextView != null)
        {
          localTextView.setTextColor(this.aXx);
          if ((this.eiq != 0) && (this.eir != 0)) {
            localTextView.setBackgroundResource(this.eir);
          }
        }
      }
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
    {
      for (;;)
      {
        try
        {
          localTextView = (TextView)this.Js.get(paramInt2);
          if (localTextView != null)
          {
            localTextView.setTextColor(this.aXw);
            if (this.eiq != 0) {
              localTextView.setBackgroundResource(this.eiq);
            }
          }
          return;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TabBarView", 2, localIndexOutOfBoundsException2, new Object[0]);
        }
        localIndexOutOfBoundsException1 = localIndexOutOfBoundsException1;
        if (QLog.isColorLevel()) {
          QLog.d("TabBarView", 2, localIndexOutOfBoundsException1, new Object[0]);
        }
      }
    }
  }
  
  private void onTabSelected(int paramInt1, int paramInt2)
  {
    if (this.b != null) {
      this.b.onTabSelected(paramInt1, paramInt2);
    }
  }
  
  public View U(int paramInt)
  {
    View localView2 = getChildAt(paramInt);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = null;
    }
    return localView1;
  }
  
  public void YO(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount())) {
      throw new IllegalArgumentException("index is not legal, please check!");
    }
    this.Js.remove(paramInt);
    this.jO.remove(paramInt);
    this.jP.remove(paramInt);
    removeViewAt(paramInt);
  }
  
  public RedDotTextView a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, false, false, false);
  }
  
  public RedDotTextView a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt, paramString, paramBoolean1, paramBoolean2, false);
  }
  
  public RedDotTextView a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt < 0) || (paramInt > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    LinearLayout localLinearLayout1 = new LinearLayout(getContext());
    RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
    localRedDotTextView.setText(paramString);
    localRedDotTextView.setTextSize(2, this.mTextSize);
    localRedDotTextView.setTextColor(this.aXx);
    localRedDotTextView.setPadding(this.mLeftPadding, this.mTopPadding, this.mRightPadding, this.aXy);
    localRedDotTextView.setSingleLine();
    localRedDotTextView.setFocusable(true);
    localRedDotTextView.setContentDescription(paramString);
    localRedDotTextView.setGravity(17);
    if (!TextUtils.isEmpty(paramString)) {
      localRedDotTextView.setOnClickListener(new arjj(this, paramInt));
    }
    ViewCompat.setAccessibilityDelegate(localRedDotTextView, new arjk(this));
    this.Js.add(localRedDotTextView);
    this.jO.add(localLinearLayout1);
    this.jP.add(paramString);
    int m = this.Js.size();
    HashMap localHashMap = new HashMap();
    if (!paramBoolean3)
    {
      if (!paramBoolean1) {
        break label446;
      }
      if (m < 6) {
        break label406;
      }
      localHashMap.put("width", Integer.valueOf((int)(SCREEN_WIDTH / getResources().getDisplayMetrics().density / 6.0F + 0.5F)));
    }
    int i;
    LinearLayout localLinearLayout2;
    for (;;)
    {
      paramString = new LinearLayout.LayoutParams(0, -1);
      i = 0;
      for (;;)
      {
        if (i >= m) {
          break label912;
        }
        localLinearLayout2 = (LinearLayout)this.jO.get(i);
        if ((localHashMap == null) || (localHashMap.get("width") == null)) {
          break;
        }
        paramString.width = ((int)(Integer.parseInt(localHashMap.get("width").toString()) * getResources().getDisplayMetrics().density + 0.5F));
        label352:
        if ((!paramBoolean2) || (m != 2)) {
          break label890;
        }
        if (i != 0) {
          break label852;
        }
        paramString.gravity = 21;
        localLinearLayout2.setLayoutParams(paramString);
        localLinearLayout2.setGravity(21);
        localLinearLayout2.setPadding(0, 0, 50, 0);
        label397:
        i += 1;
      }
      label406:
      localHashMap.put("width", Integer.valueOf((int)(SCREEN_WIDTH / getResources().getDisplayMetrics().density / m + 0.5F)));
    }
    label446:
    if (m == 2) {
      localHashMap.put("width", Integer.valueOf((int)(SCREEN_WIDTH / getResources().getDisplayMetrics().density / 3.0F + 0.5F)));
    }
    int j;
    label507:
    int k;
    if (m == 6)
    {
      i = 0;
      paramString = Boolean.valueOf(true);
      j = 0;
      if (j < m)
      {
        k = ((String)this.jP.get(j)).toString().length();
        if (j == 0) {
          i = k;
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label507;
      if (i != k)
      {
        paramString = Boolean.valueOf(false);
        continue;
        if (paramString.booleanValue()) {
          localHashMap.put("width", Integer.valueOf(69));
        }
        for (;;)
        {
          if (m <= 6) {
            break label667;
          }
          localHashMap.put("paddingLeft", Integer.valueOf(8));
          localHashMap.put("paddingRight", Integer.valueOf(8));
          break;
          localHashMap.put("paddingLeft", Integer.valueOf(8));
          localHashMap.put("paddingRight", Integer.valueOf(8));
        }
        label667:
        break;
        if ((localHashMap != null) && (localHashMap.get("paddingLeft") != null) && (localHashMap.get("paddingRight") != null))
        {
          j = (int)(Integer.parseInt(localHashMap.get("paddingLeft").toString()) * getResources().getDisplayMetrics().density + 0.5F);
          k = (int)(Integer.parseInt(localHashMap.get("paddingRight").toString()) * getResources().getDisplayMetrics().density + 0.5F);
          paramString.leftMargin = j;
          paramString.rightMargin = k;
          paramString.width = -2;
          break label352;
        }
        if (paramBoolean3)
        {
          j = (int)((this.mTextSize + this.ccq * 2) * getResources().getDisplayMetrics().density + 0.5F);
          paramString.leftMargin = j;
          paramString.rightMargin = j;
          paramString.width = -2;
          break label352;
        }
        paramString.weight = 1.0F;
        break label352;
        label852:
        if (i != 1) {
          break label397;
        }
        paramString.gravity = 19;
        localLinearLayout2.setLayoutParams(paramString);
        localLinearLayout2.setGravity(19);
        localLinearLayout2.setPadding(50, 0, 0, 0);
        break label397;
        label890:
        paramString.gravity = 17;
        localLinearLayout2.setLayoutParams(paramString);
        localLinearLayout2.setGravity(17);
        break label397;
        label912:
        localRedDotTextView.setId(2131379484);
        if ((localHashMap != null) && (localHashMap.get("paddingLeft") != null))
        {
          localLinearLayout1.addView(localRedDotTextView, paramString);
          if (m != 2) {
            break label977;
          }
          setGravity(1);
        }
        for (;;)
        {
          addView(localLinearLayout1, paramInt);
          return localRedDotTextView;
          localLinearLayout1.addView(localRedDotTextView);
          break;
          label977:
          setGravity(8388627);
        }
      }
    }
  }
  
  public RedDotTextView a(String paramString)
  {
    return a(getChildCount(), paramString);
  }
  
  public RedDotTextView b(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if (localView == null) {
      return null;
    }
    localView = localView.findViewById(2131379484);
    if ((localView instanceof RedDotTextView)) {
      return (RedDotTextView)localView;
    }
    return null;
  }
  
  protected void bC(Canvas paramCanvas)
  {
    View localView1 = getChildAt(this.aXA);
    int j;
    int i;
    if (localView1 != null)
    {
      View localView2 = (View)this.Js.get(this.aXA);
      this.paint.setTextSize(this.mTextSize * getContext().getResources().getDisplayMetrics().density + 0.5F);
      float f1 = this.paint.measureText(((String)this.jP.get(this.aXA)).toString());
      j = (int)((localView1.getRight() - localView1.getLeft() - f1) / 2.0F);
      i = (int)(f1 + j);
      if (localView2 != null)
      {
        j = localView1.getLeft() + j - this.ccq;
        int k = localView1.getLeft();
        i = this.ccq + (k + i);
        if (this.ki <= 0.0F) {
          break label329;
        }
        localView1 = getChildAt(this.aXz);
        if (localView1 == null) {
          break label329;
        }
        f1 = this.paint.measureText(((String)this.jP.get(this.aXz)).toString());
        int m = (int)((localView1.getRight() - localView1.getLeft() - f1) / 2.0F);
        k = (int)(f1 + m);
        f1 = j;
        float f2 = this.ki;
        j = (int)((m + localView1.getLeft() - this.ccq - j) * f2 + f1);
        f1 = i;
        f2 = this.ki;
        i = (int)((k + localView1.getLeft() + this.ccq - i) * f2 + f1);
      }
    }
    label329:
    for (;;)
    {
      paramCanvas.drawRect(j, getHeight() - this.aXv, i, getHeight(), this.mPaint);
      return;
    }
  }
  
  public void clearSelected()
  {
    this.aXA = -1;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    bC(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  public int g(View paramView)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (getChildAt(i).equals(paramView)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.aXu, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.aXu);
  }
  
  public int qt()
  {
    return this.aXA;
  }
  
  public void setEnableRepeatedClick(boolean paramBoolean)
  {
    this.arh = paramBoolean;
  }
  
  public void setOnTabChangeListener(a parama)
  {
    this.b = parama;
  }
  
  public void setSelectBgRes(int paramInt)
  {
    this.eiq = paramInt;
  }
  
  public void setSelectColor(int paramInt)
  {
    this.aXw = paramInt;
    this.mPaint.setColor(this.aXw);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    setSelectedTab(paramInt, paramBoolean, true);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    int j = getChildCount();
    paramInt = i;
    if (i >= j) {
      paramInt = j - 1;
    }
    if (this.aXA != paramInt)
    {
      if (this.aXA == -1) {
        paramBoolean1 = false;
      }
      if (paramBoolean1)
      {
        this.ki = 0.0F;
        this.aXz = paramInt;
        this.mHandler.sendEmptyMessage(0);
      }
    }
    while ((!this.arh) || (!paramBoolean2))
    {
      return;
      if (paramBoolean2) {
        onTabSelected(this.aXA, paramInt);
      }
      this.aXz = paramInt;
      this.ki = 1.0F;
      df(this.aXA, paramInt);
      invalidate();
      this.aXA = paramInt;
      aVv();
      return;
    }
    onTabSelected(this.aXA, this.aXA);
  }
  
  public void setTabHeight(int paramInt)
  {
    this.aXu = paramInt;
  }
  
  public void setTabLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    this.c = paramLayoutParams;
  }
  
  public void setTabTextSize(int paramInt)
  {
    this.mTextSize = paramInt;
  }
  
  public void setTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLeftPadding = paramInt1;
    this.mTopPadding = paramInt2;
    this.mRightPadding = paramInt3;
    this.aXy = paramInt4;
  }
  
  public void setUnSelectBgRes(int paramInt)
  {
    this.eir = paramInt;
  }
  
  public void setUnderLineHeight(int paramInt)
  {
    this.aXv = paramInt;
  }
  
  public void setUnderLineMargin(int paramInt)
  {
    this.ccq = paramInt;
  }
  
  public void setUnselectColor(int paramInt)
  {
    this.aXx = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void onTabSelected(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView
 * JD-Core Version:    0.7.0.1
 */