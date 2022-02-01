package com.tencent.mobileqq.utils.dialogutils;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqoa;
import aqob;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import wja;

public class QQCustomMenuImageLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static int eak = 45;
  public static int eal = 53;
  public static int eam = 90;
  public static float mDensity = 1.0F;
  public static int mPadding = 5;
  public static int screenWidth;
  private ImageView EY;
  private ImageView EZ;
  private aqoa e;
  public int eah;
  private int eai = -1;
  private int eaj;
  private View.OnClickListener gd;
  private BubblePopupWindow popup;
  
  public QQCustomMenuImageLayout(Context paramContext)
  {
    super(paramContext);
    setOrientation(0);
    this.eah = (screenWidth - (int)(10.0F * mDensity));
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomMenuImageLayout", 4, "screenWidth:" + screenWidth + " mDensity: " + mDensity + " layoutMaxWidth A:" + this.eah);
    }
    this.eaj = 12;
    if (mDensity >= 2.0F) {
      this.eaj = 20;
    }
  }
  
  private int Mi()
  {
    int m = getChildCount();
    int k = 0;
    for (int j = 0; k < m; j = i)
    {
      View localView = getChildAt(k);
      i = j;
      if (localView != null)
      {
        i = j;
        if (localView.getVisibility() != 8)
        {
          int n = (int)Layout.getDesiredWidth(((TextView)localView).getText(), ((TextView)localView).getPaint());
          j += localView.getPaddingLeft() + n + localView.getPaddingRight();
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("QQCustomMenuImageLayout", 4, "child  TextView text " + ((TextView)localView).getText() + " measureWidth = " + n + " paddingL = " + localView.getPaddingLeft() + " paddingR = " + localView.getPaddingRight());
            i = j;
          }
        }
      }
      k += 1;
    }
    int i = mPadding * 2 + j;
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomMenuImageLayout", 4, "totalWidth   " + i);
    }
    return i;
  }
  
  private TextView a(aqob paramaqob)
  {
    QQCustomMenuImageLayout.1 local1 = new QQCustomMenuImageLayout.1(this, getContext());
    local1.setText(paramaqob.getTitle());
    local1.setTextSize(10.0F);
    Resources localResources = getContext().getResources();
    local1.setMinimumWidth(90);
    local1.setMaxLines(1);
    try
    {
      Drawable localDrawable = getContext().getResources().getDrawable(paramaqob.getDrawable());
      local1.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
      local1.setCompoundDrawablePadding(0);
      int i = wja.dp2px(9.0F, localResources);
      local1.setPadding(0, i, 0, i);
      local1.setContentDescription(paramaqob.getTitle());
      local1.setId(paramaqob.getItemId());
      local1.setTextColor(-855638017);
      local1.setBackgroundDrawable(null);
      local1.setIncludeFontPadding(true);
      local1.setOnClickListener(this.gd);
      local1.setGravity(17);
      return local1;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        wja.a("QQCustomMenuImageLayout", "creatTextViewWithTopIcon ERR", localRuntimeException);
        Object localObject = null;
      }
    }
  }
  
  private TextView d(int paramInt)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText("");
    localTextView.setTextSize(1.0F);
    localTextView.setWidth(paramInt);
    localTextView.setMaxLines(1);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.setTextColor(-1);
    localTextView.setBackgroundDrawable(null);
    localTextView.setGravity(17);
    return localTextView;
  }
  
  private ImageView z()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(2130839093);
    localImageView.setContentDescription(acfp.m(2131711617));
    localImageView.setBackgroundDrawable(null);
    localImageView.setOnClickListener(this);
    localImageView.setPadding((int)(this.eaj * mDensity), (int)(mDensity * 10.0F), (int)(this.eaj * mDensity), (int)(mDensity * 10.0F));
    return localImageView;
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    addView(paramView);
  }
  
  public void eev()
  {
    removeAllViews();
    int m = this.e.size();
    int i = 0;
    Object localObject;
    int k;
    int j;
    if (i < m)
    {
      localObject = a(this.e.a(i));
      k = eam;
      if (k < eak)
      {
        j = eak;
        label50:
        if (!mA(j)) {
          break label207;
        }
        if (i != 6) {
          break label151;
        }
        removeViewAt(i - 1);
        i -= 1;
        this.EZ = z();
        localObject = new LinearLayout.LayoutParams(this.EZ.getPaddingLeft() + 22 + this.EZ.getPaddingRight(), -2);
        this.EZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
        addView(this.EZ);
      }
    }
    for (;;)
    {
      this.eai = i;
      return;
      j = k;
      if (k <= eal) {
        break label50;
      }
      j = eal;
      break label50;
      label151:
      addView((View)localObject, new LinearLayout.LayoutParams(j, -2, 0.0F));
      if (i == m - 1) {
        addView(d(mPadding), new LinearLayout.LayoutParams(mPadding, -2, 0.0F));
      }
      i += 1;
      break;
      label207:
      this.EZ = z();
      j = this.EZ.getPaddingLeft() + 22 + this.EZ.getPaddingRight();
      localObject = new LinearLayout.LayoutParams(j, -2);
      this.EZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (mA(j)) {}
      for (;;)
      {
        addView(this.EZ);
        break;
        if (i > 1)
        {
          removeViewAt(i - 1);
          i -= 1;
        }
      }
      i = -1;
    }
  }
  
  public void eew()
  {
    if (this.eai >= 0)
    {
      removeAllViews();
      this.EY = new ImageView(getContext());
      this.EY.setImageResource(2130839088);
      this.EY.setContentDescription(acfp.m(2131711610));
      this.EY.setBackgroundDrawable(null);
      this.EY.setOnClickListener(this);
      this.EY.setPadding((int)(this.eaj * mDensity), (int)(mDensity * 10.0F), (int)(this.eaj * mDensity), (int)(mDensity * 10.0F));
      int i = this.EY.getPaddingLeft() + 22 + this.EY.getPaddingRight();
      Object localObject = new LinearLayout.LayoutParams(i, -2);
      this.EY.setLayoutParams((ViewGroup.LayoutParams)localObject);
      addView(this.EY);
      int k = 0 + i;
      int j = this.eai;
      if (j < this.e.size())
      {
        localObject = a(this.e.a(j));
        int m = eam;
        if (m < eak) {
          i = eak;
        }
        for (;;)
        {
          addView((View)localObject, new LinearLayout.LayoutParams(i, -2, 0.0F));
          k += i;
          j += 1;
          break;
          i = m;
          if (m > eal) {
            i = eal;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomMenuImageLayout", 4, "secondScreenWidth: " + k);
      }
      if (k < screenWidth / 2)
      {
        i = screenWidth / 2 - k;
        localObject = d(i);
        ((TextView)localObject).setVisibility(4);
        addView((View)localObject, new LinearLayout.LayoutParams(i, -2, 0.0F));
      }
    }
  }
  
  public boolean mA(int paramInt)
  {
    return Mi() + paramInt <= this.eah;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.EY) {
      eev();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.EZ) {
        eew();
      }
    }
  }
  
  public void setMenu(aqoa paramaqoa)
  {
    this.e = paramaqoa;
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomMenuImageLayout", 4, "MENU:" + this.e.toString());
    }
  }
  
  public void setMenuIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gd = paramOnClickListener;
  }
  
  public void setPopup(BubblePopupWindow paramBubblePopupWindow)
  {
    this.popup = paramBubblePopupWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuImageLayout
 * JD-Core Version:    0.7.0.1
 */