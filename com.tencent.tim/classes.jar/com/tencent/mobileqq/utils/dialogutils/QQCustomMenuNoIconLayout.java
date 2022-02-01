package com.tencent.mobileqq.utils.dialogutils;

import acej;
import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqoa;
import aqob;
import aqoc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.d;
import java.util.Iterator;
import java.util.List;
import wja;

public class QQCustomMenuNoIconLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static int ean;
  public static float mDensity = 1.0F;
  public static int mItemPadding = 14;
  public static int mPadding = 5;
  public static int screenWidth;
  protected ImageView Fc;
  protected ImageView Fd;
  protected ImageView Fe;
  protected ImageView Ff;
  private aqob jdField_a_of_type_Aqob;
  private BubblePopupWindow.d jdField_a_of_type_ComTencentWidgetBubblePopupWindow$d = new aqoc(this);
  private TextView abB;
  private boolean cUN;
  private boolean cUO;
  private boolean cUP;
  protected aqoa e;
  public int eah;
  protected int eai = -1;
  protected int eaj;
  private int eao;
  private int eap = 8;
  private int eaq;
  private int ear = -1;
  protected View.OnClickListener gd;
  private Context mContext;
  protected BubblePopupWindow popup;
  
  public QQCustomMenuNoIconLayout(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    setOrientation(0);
    ean = (int)(10.0F * mDensity + 0.5D);
    this.eaj = 8;
    if (mDensity >= 2.0F) {
      this.eaj = 10;
    }
    if (mDensity < acej.k.density) {}
    for (this.eah = ((int)((screenWidth - ean) * (mDensity / acej.k.density)));; this.eah = (screenWidth - ean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomMenuNoIconLayout", 4, "screenWidth:" + screenWidth + " mDensity: " + mDensity + " layoutMaxWidth A:" + this.eah);
      }
      return;
    }
  }
  
  private int Mi()
  {
    int m = getChildCount();
    int k = 0;
    int i = 0;
    View localView;
    int j;
    if (k < m)
    {
      localView = getChildAt(k);
      if ((localView == null) || (localView.getVisibility() == 8)) {
        break label149;
      }
      if ((localView instanceof TextView))
      {
        j = (int)Layout.getDesiredWidth(((TextView)localView).getText(), ((TextView)localView).getPaint()) + localView.getPaddingLeft() + localView.getPaddingRight();
        label79:
        i = j + i;
      }
    }
    label149:
    for (;;)
    {
      k += 1;
      break;
      if ((localView instanceof ImageView))
      {
        j = 1;
        break label79;
        i = mPadding * 2 + i;
        if (QLog.isColorLevel()) {
          QLog.d("QQCustomMenuNoIconLayout", 4, "totalWidth   " + i);
        }
        return i;
      }
      j = 0;
      break label79;
    }
  }
  
  private TextView b(aqob paramaqob)
  {
    QQCustomMenuNoIconLayout.2 local2 = new QQCustomMenuNoIconLayout.2(this, getContext());
    local2.setText(paramaqob.getTitle());
    local2.setTextSize(13.0F);
    local2.setMinimumWidth(90);
    Resources localResources = getContext().getResources();
    local2.setMaxLines(1);
    int i = wja.dp2px(9.0F, localResources);
    local2.setPadding(mItemPadding, i, mItemPadding, i);
    local2.setContentDescription(paramaqob.getTitle());
    local2.setId(paramaqob.getItemId());
    local2.setTextColor(-855638017);
    local2.setBackgroundDrawable(null);
    local2.setIncludeFontPadding(true);
    local2.setOnClickListener(this.gd);
    local2.setGravity(17);
    return local2;
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
  
  private void eeB()
  {
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setBackgroundResource(2130839072);
    addView(localImageView, new LinearLayout.LayoutParams(-2, -2));
  }
  
  private void eez()
  {
    this.abB = b(this.jdField_a_of_type_Aqob);
    this.eaq = ((int)Layout.getDesiredWidth(this.abB.getText(), this.abB.getPaint()));
    this.eaq = (this.eaq + this.abB.getPaddingLeft() + this.abB.getPaddingRight());
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    addView(paramView);
  }
  
  public void eeA()
  {
    if (this.eao >= 0)
    {
      removeAllViews();
      this.Ff = new ImageView(getContext());
      this.Ff.setImageResource(2130839088);
      this.Ff.setContentDescription(acfp.m(2131711606));
      this.Ff.setBackgroundDrawable(null);
      this.Ff.setOnClickListener(this);
      this.Ff.setPadding((int)(this.eaj * mDensity), (int)(mDensity * 10.0F), (int)(this.eaj * mDensity), (int)(mDensity * 10.0F));
      int i = this.Ff.getPaddingLeft() + 22 + this.Ff.getPaddingRight();
      Object localObject = new LinearLayout.LayoutParams(i, -2);
      this.Ff.setLayoutParams((ViewGroup.LayoutParams)localObject);
      addView(this.Ff);
      eeB();
      int m = this.e.size();
      int j = this.eao;
      int k;
      int n;
      int i1;
      for (i = 0 + (i + 1); j < m; i = i1 + (i + n) + k)
      {
        localObject = b(this.e.a(j));
        addView((View)localObject, new LinearLayout.LayoutParams(-2, -2, 0.0F));
        k = i;
        if (j != m - 1)
        {
          eeB();
          k = i + 1;
        }
        i = (int)Layout.getDesiredWidth(((TextView)localObject).getText(), ((TextView)localObject).getPaint());
        n = ((TextView)localObject).getPaddingLeft();
        i1 = ((TextView)localObject).getPaddingRight();
        j += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomMenuNoIconLayout", 4, "secondScreenWidth: " + i);
      }
      if (!this.cUO)
      {
        this.popup.abd(i);
        this.cUO = true;
      }
      addView(d(mPadding), new LinearLayout.LayoutParams(mPadding, -2, 0.0F));
    }
  }
  
  public void eev()
  {
    removeAllViews();
    if (this.cUN)
    {
      this.popup.ewH();
      this.cUN = false;
    }
    int m = this.e.size();
    int i = 0;
    Object localObject;
    int j;
    int n;
    if (i < m)
    {
      localObject = b(this.e.a(i));
      j = (int)Layout.getDesiredWidth(((TextView)localObject).getText(), ((TextView)localObject).getPaint());
      int k = ((TextView)localObject).getPaddingLeft();
      n = ((TextView)localObject).getPaddingRight() + (j + k);
      if (mA(n))
      {
        k = this.eap;
        j = k;
        if (this.jdField_a_of_type_Aqob != null) {
          j = k - 1;
        }
        if (i == j)
        {
          j = getChildCount();
          removeViewAt(j - 1);
          removeViewAt(j - 2);
          i -= 1;
          if (this.jdField_a_of_type_Aqob != null) {
            addView(b(this.jdField_a_of_type_Aqob), new LinearLayout.LayoutParams(this.eaq, -2, 0.0F));
          }
          eeB();
          this.Fc = z();
          localObject = new LinearLayout.LayoutParams(this.Fc.getPaddingLeft() + 22 + this.Fc.getPaddingRight(), -2);
          this.Fc.setLayoutParams((ViewGroup.LayoutParams)localObject);
          addView(this.Fc);
        }
      }
    }
    for (;;)
    {
      ImageView localImageView;
      LinearLayout.LayoutParams localLayoutParams;
      if (this.jdField_a_of_type_Aqob != null)
      {
        localObject = b(this.jdField_a_of_type_Aqob);
        localImageView = new ImageView(this.mContext);
        localImageView.setBackgroundResource(2130839072);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (m == 0) {
          addView((View)localObject, this.ear * 2, new LinearLayout.LayoutParams(this.eaq, -2, 0.0F));
        }
        if (this.cUP)
        {
          if (m != 1) {
            break label757;
          }
          if (this.ear != 0) {
            break label712;
          }
          addView((View)localObject, this.ear * 2, new LinearLayout.LayoutParams(this.eaq, -2, 0.0F));
          addView(localImageView, this.ear * 2 + 1, localLayoutParams);
        }
      }
      for (;;)
      {
        this.cUP = false;
        this.eai = i;
        return;
        addView((View)localObject, new LinearLayout.LayoutParams(n, -2, 0.0F));
        if (i != m - 1) {
          eeB();
        }
        for (;;)
        {
          i += 1;
          break;
          this.cUP = true;
        }
        this.Fc = z();
        j = this.Fc.getPaddingLeft() + 22 + this.Fc.getPaddingRight();
        localObject = new LinearLayout.LayoutParams(j, -2);
        this.Fc.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (mA(j))
        {
          if (this.jdField_a_of_type_Aqob != null) {
            addView(b(this.jdField_a_of_type_Aqob), new LinearLayout.LayoutParams(this.eaq, -2, 0.0F));
          }
          eeB();
        }
        for (;;)
        {
          addView(this.Fc);
          break;
          if (i > 1)
          {
            j = getChildCount();
            if ((getChildAt(j - 1) instanceof ImageView)) {
              removeViewAt(j - 1);
            }
            removeViewAt(j - 2);
            i -= 1;
            if (this.jdField_a_of_type_Aqob != null) {
              addView(b(this.jdField_a_of_type_Aqob), new LinearLayout.LayoutParams(this.eaq, -2, 0.0F));
            }
            eeB();
          }
          else
          {
            if (i > 0)
            {
              j = getChildCount();
              if ((getChildAt(j - 1) instanceof ImageView)) {
                removeViewAt(j - 1);
              }
              removeViewAt(j - 2);
            }
            j = i - 1;
            if (this.jdField_a_of_type_Aqob != null) {
              addView(b(this.jdField_a_of_type_Aqob), new LinearLayout.LayoutParams(this.eaq, -2, 0.0F));
            }
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("QQCustomMenuNoIconLayout", 4, "showFirstScreenMenu: only arrow menu is wrong!");
              i = j;
            }
          }
        }
        label712:
        addView(localImageView, this.ear * 2 - 1, localLayoutParams);
        addView((View)localObject, this.ear * 2, new LinearLayout.LayoutParams(this.eaq, -2, 0.0F));
        continue;
        label757:
        if (this.ear < m)
        {
          addView((View)localObject, this.ear * 2, new LinearLayout.LayoutParams(this.eaq, -2, 0.0F));
          addView(localImageView, this.ear * 2 + 1, localLayoutParams);
        }
        else
        {
          addView(localImageView, this.ear * 2 - 1, localLayoutParams);
          addView((View)localObject, this.ear * 2, new LinearLayout.LayoutParams(this.eaq, -2, 0.0F));
        }
      }
      i = -1;
    }
  }
  
  public void eew()
  {
    int k = 0;
    if (this.cUO)
    {
      this.popup.ewH();
      this.cUO = false;
    }
    int i;
    Object localObject1;
    int m;
    int j;
    if (this.eai >= 0)
    {
      removeAllViews();
      this.Fe = new ImageView(getContext());
      this.Fe.setImageResource(2130839088);
      this.Fe.setContentDescription(acfp.m(2131711614));
      this.Fe.setBackgroundDrawable(null);
      this.Fe.setOnClickListener(this);
      this.Fe.setPadding((int)(this.eaj * mDensity), (int)(mDensity * 10.0F), (int)(this.eaj * mDensity), (int)(mDensity * 10.0F));
      i = this.Fe.getPaddingLeft() + 22 + this.Fe.getPaddingRight();
      localObject1 = new LinearLayout.LayoutParams(i, -2);
      this.Fe.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      addView(this.Fe);
      eeB();
      i = 0 + (i + 1);
      m = this.e.size();
      j = this.eai;
      k = i;
      if (j < m)
      {
        localObject1 = b(this.e.a(j));
        k = (int)Layout.getDesiredWidth(((TextView)localObject1).getText(), ((TextView)localObject1).getPaint()) + ((TextView)localObject1).getPaddingLeft() + ((TextView)localObject1).getPaddingRight();
        if (mB(k)) {
          if (j - this.eai == this.eap)
          {
            k = getChildCount();
            removeViewAt(k - 1);
            removeViewAt(k - 2);
            this.Fd = z();
            localObject1 = new LinearLayout.LayoutParams(this.Fd.getPaddingLeft() + 22 + this.Fd.getPaddingRight(), -2);
            this.Fd.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            addView(this.Fd);
            k = j - 1;
            j = i;
            i = k;
          }
        }
      }
    }
    for (;;)
    {
      this.eao = i;
      if ((i == -1) && (!this.cUN))
      {
        this.popup.abd(j);
        this.cUN = true;
      }
      return;
      addView((View)localObject1, new LinearLayout.LayoutParams(k, -2, 0.0F));
      k = i + k;
      i = k;
      if (j != m - 1)
      {
        eeB();
        i = k + 1;
      }
      j += 1;
      break;
      this.Fd = z();
      k = this.Fd.getPaddingLeft();
      m = this.Fd.getPaddingRight() + (k + 22);
      Object localObject2 = new LinearLayout.LayoutParams(m, -2);
      this.Fd.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (mB(m))
      {
        k = i + m;
        i = j;
        addView(this.Fd);
        j = k + m;
      }
      else
      {
        int n;
        if (j > 1)
        {
          n = getChildCount();
          if (!(getChildAt(n - 1) instanceof ImageView)) {
            break label741;
          }
          removeViewAt(n - 1);
          i -= 1;
        }
        label738:
        label741:
        for (;;)
        {
          localObject2 = getChildAt(n - 2);
          k = i;
          if ((localObject2 instanceof TextView))
          {
            localObject2 = (TextView)localObject2;
            k = i - ((int)Layout.getDesiredWidth(((TextView)localObject2).getText(), ((TextView)localObject2).getPaint()) + ((TextView)localObject1).getPaddingLeft() + ((TextView)localObject1).getPaddingRight());
          }
          removeViewAt(n - 2);
          i = j - 1;
          break;
          k = i;
          if (j > 0)
          {
            k = getChildCount();
            if ((getChildAt(k - 1) instanceof ImageView)) {
              removeViewAt(k - 1);
            }
            i -= 1;
            localObject2 = getChildAt(k - 2);
            if (!(localObject2 instanceof TextView)) {
              break label738;
            }
            localObject2 = (TextView)localObject2;
            i -= (int)Layout.getDesiredWidth(((TextView)localObject2).getText(), ((TextView)localObject2).getPaint()) + ((TextView)localObject1).getPaddingLeft() + ((TextView)localObject1).getPaddingRight();
          }
          for (;;)
          {
            removeViewAt(k - 2);
            k = i;
            if (QLog.isColorLevel()) {
              QLog.d("QQCustomMenuNoIconLayout", 4, "showSecondScreenMenu: only arrow menu is wrong!");
            }
            i = j - 1;
            break;
          }
        }
        j = k;
        i = -1;
      }
    }
  }
  
  public boolean mA(int paramInt)
  {
    if (this.jdField_a_of_type_Aqob != null) {
      if (Mi() + paramInt > this.eah - this.eaq) {}
    }
    while (Mi() + paramInt <= this.eah)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean mB(int paramInt)
  {
    return Mi() + paramInt <= this.eah;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.Fe) {
      eev();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.Fc) {
        eew();
      } else if (paramView == this.Fd) {
        eeA();
      } else if (paramView == this.Ff) {
        eew();
      }
    }
  }
  
  public void setMenu(aqoa paramaqoa)
  {
    this.e = paramaqoa.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomMenuNoIconLayout", 4, "MENU:" + this.e.toString());
    }
    paramaqoa = this.e.vq.iterator();
    int i = 0;
    for (;;)
    {
      if (paramaqoa.hasNext())
      {
        aqob localaqob = (aqob)paramaqoa.next();
        if (TextUtils.equals(localaqob.title, this.mContext.getString(2131696127)))
        {
          this.jdField_a_of_type_Aqob = localaqob;
          this.ear = i;
          eez();
          paramaqoa.remove();
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void setMenuIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gd = paramOnClickListener;
  }
  
  public void setPopup(BubblePopupWindow paramBubblePopupWindow)
  {
    this.popup = paramBubblePopupWindow;
    this.popup.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$d);
  }
  
  protected ImageView z()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(2130839093);
    localImageView.setContentDescription(acfp.m(2131711605));
    localImageView.setBackgroundDrawable(null);
    localImageView.setOnClickListener(this);
    localImageView.setPadding((int)(this.eaj * mDensity), (int)(mDensity * 10.0F), (int)(this.eaj * mDensity), (int)(mDensity * 10.0F));
    return localImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout
 * JD-Core Version:    0.7.0.1
 */