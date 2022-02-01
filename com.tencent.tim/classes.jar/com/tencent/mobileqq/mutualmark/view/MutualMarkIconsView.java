package com.tencent.mobileqq.mutualmark.view;

import acff;
import acfp;
import ajnn;
import ajoh;
import ajol;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BaselineTextView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import wja;
import zap.a;

public class MutualMarkIconsView
  extends LinearLayout
{
  public StringBuilder Q;
  TextView UV;
  int djZ = 0;
  int dka = 42;
  int dkb = 294;
  int dkc = 294;
  int dkd = 0;
  private TextPaint mTextPaint = new TextPaint();
  ArrayList<MutualMarkIconItemView> xV;
  
  public MutualMarkIconsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MutualMarkIconsView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MutualMarkIconsView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(CharSequence paramCharSequence, float paramFloat)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return 0;
    }
    this.mTextPaint.setTextSize(paramFloat);
    return (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.mTextPaint));
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, ajoh paramajoh, ExtensionInfo paramExtensionInfo, MutualMarkIconItemView paramMutualMarkIconItemView)
  {
    int i;
    if (paramajoh.ark())
    {
      paramMutualMarkIconItemView.setIconResource(paramajoh);
      paramMutualMarkIconItemView.setVisibility(0);
      if (AppSetting.enableTalkBack)
      {
        paramQQAppInterface = paramajoh.name;
        if (!TextUtils.isEmpty(paramajoh.aSQ)) {
          paramQQAppInterface = paramajoh.aSQ;
        }
        paramMutualMarkIconItemView.setContentDescription(paramQQAppInterface);
        if (this.Q != null) {
          this.Q.append(paramQQAppInterface);
        }
      }
      if ((!paramajoh.arh()) || (this.djZ != 3) || (!paramajoh.ari()) || (paramajoh.cpw)) {
        break label206;
      }
      if ((paramajoh.adc != 0L) && (System.currentTimeMillis() - paramajoh.adc > 3500L))
      {
        paramajoh.cpw = true;
        ajnn.a(paramajoh, paramExtensionInfo);
        if (paramExtensionInfo == null) {
          break label206;
        }
        ajol.b(paramExtensionInfo);
        i = 0;
      }
    }
    for (;;)
    {
      if (i == 0) {
        paramMutualMarkIconItemView.setIconAlpha(paramajoh.bg());
      }
      this.dkd += paramMutualMarkIconItemView.Gy();
      return;
      paramajoh.adc = System.currentTimeMillis();
      ajnn.a(paramajoh, paramExtensionInfo);
      paramMutualMarkIconItemView.ME(paramString);
      i = 1;
      continue;
      paramMutualMarkIconItemView.setVisibility(8);
      return;
      label206:
      i = 0;
    }
  }
  
  private void dyB()
  {
    removeAllViews();
    setVisibility(8);
    this.dkd = 0;
    this.UV = null;
    if (this.xV != null)
    {
      Iterator localIterator = this.xV.iterator();
      while (localIterator.hasNext())
      {
        MutualMarkIconItemView localMutualMarkIconItemView = (MutualMarkIconItemView)localIterator.next();
        if (localMutualMarkIconItemView != null) {
          localMutualMarkIconItemView.dyz();
        }
      }
    }
    this.xV = null;
  }
  
  private void dyC()
  {
    int j;
    if (this.xV != null)
    {
      Iterator localIterator = this.xV.iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label65;
      }
      MutualMarkIconItemView localMutualMarkIconItemView = (MutualMarkIconItemView)localIterator.next();
      if ((localMutualMarkIconItemView == null) || (localMutualMarkIconItemView.getVisibility() != 0)) {
        break label71;
      }
      i += localMutualMarkIconItemView.Gy();
    }
    label65:
    label71:
    for (;;)
    {
      break;
      j = 0;
      this.dkd = j;
      return;
    }
  }
  
  private void i(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    int k = 0;
    int j = k;
    if (paramLong > 0L) {
      if ((this.djZ != 3) && (this.djZ != 4))
      {
        j = k;
        if (this.djZ != 2) {}
      }
      else
      {
        if ((this.djZ != 3) && (this.djZ != 4)) {
          break label492;
        }
      }
    }
    label394:
    label492:
    for (int i = 0;; i = 1)
    {
      paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
      j = k;
      if (paramQQAppInterface != null)
      {
        j = k;
        if (paramQQAppInterface.it(i)) {
          if (this.UV == null)
          {
            if ((this.djZ != 3) && (this.djZ != 4)) {
              break label394;
            }
            this.UV = new TextView(getContext());
            this.UV.setTextSize(1, 12.0F);
            if (this.djZ != 4) {
              break label374;
            }
            this.UV.setTextColor(getResources().getColorStateList(2131167304));
            this.UV.setSingleLine();
            this.UV.setGravity(16);
            paramQQAppInterface = new LinearLayout.LayoutParams(-2, this.dka);
            addView(this.UV, paramQQAppInterface);
          }
        }
      }
      for (;;)
      {
        long l = paramLong;
        if (paramLong > 9999L) {
          l = 9999L;
        }
        this.UV.setText(l + acfp.m(2131708615));
        if (AppSetting.enableTalkBack)
        {
          paramQQAppInterface = String.format(ajol.f(getContext(), 19), new Object[] { Long.valueOf(l) });
          this.UV.setContentDescription(paramQQAppInterface);
          if (this.Q != null) {
            this.Q.append(paramQQAppInterface);
          }
        }
        j = this.UV.getMeasuredWidth();
        i = j;
        if (j <= 0) {
          i = wja.dp2px(32.0F, getResources());
        }
        this.dkd = (i + this.dkd);
        j = 1;
        if ((j == 0) && (this.UV != null))
        {
          removeView(this.UV);
          this.UV = null;
        }
        return;
        label374:
        this.UV.setTextColor(getResources().getColorStateList(2131167383));
        break;
        this.UV = new BaselineTextView(getContext(), null);
        this.UV.setTextColor(getResources().getColorStateList(2131167304));
        this.UV.setSingleLine();
        this.UV.setTextSize(1, 14.0F);
        this.UV.setPadding(0, 0, 0, wja.dp2px(2.0F, getResources()));
        paramQQAppInterface = new LinearLayout.LayoutParams(-2, -2);
        paramQQAppInterface.gravity = 80;
        addView(this.UV, paramQQAppInterface);
      }
    }
  }
  
  public int a(View paramView, SpecailCareListActivity.d paramd, int paramInt1, int paramInt2)
  {
    int j = 0;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramd.b.getLayoutParams();
    if (localLayoutParams != null) {}
    for (int i = localLayoutParams.rightMargin;; i = 0)
    {
      dyC();
      if (this.dkd <= this.dkc) {
        return this.dkd + paramInt1 + i;
      }
      int k = paramView.getMeasuredWidth();
      if (k <= 0) {}
      for (;;)
      {
        if (paramInt2 <= this.dkc) {
          return this.dkd + paramInt1 + i;
        }
        paramInt1 = paramView.getPaddingLeft();
        k = paramView.getPaddingRight();
        int m = a(paramd.ib.getText(), paramd.ib.getTextSize());
        m = Math.min(getResources().getDimensionPixelSize(2131296994), m);
        int i1 = paramd.ib.getCompoundPaddingLeft();
        int i2 = paramd.ib.getCompoundPaddingRight();
        int i3 = paramd.ib.getPaddingRight();
        int i4 = paramd.ib.getPaddingLeft();
        int n = wja.dp2px(72.0F, getResources());
        paramInt2 = paramInt2 - (paramInt1 + k) - n - i - m - (i1 + i2 + i3 + i4);
        if (QLog.isColorLevel()) {
          QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInSpecialCareList maxMutualMarkWidth:" + paramInt2 + " maybeWidth:" + this.dkd + " nickMinWidth:" + m + " nickRootLeft:" + n + " mutualMarkMarginRight:" + i);
        }
        if (this.dkd > paramInt2) {
          if (this.xV != null) {
            paramInt1 = j;
          }
        }
        for (;;)
        {
          if (paramInt1 < this.xV.size())
          {
            paramView = (MutualMarkIconItemView)this.xV.get(paramInt1);
            if ((paramView != null) && (paramView.getVisibility() == 0))
            {
              this.dkd -= paramView.Gy();
              paramView.setVisibility(8);
              if (QLog.isColorLevel()) {
                QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInSpecialCareList hide Type:" + paramView.gr() + " width:" + paramView.Gy());
              }
              if (this.dkd > paramInt2) {}
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInSpecialCareList after maybeWidth:" + this.dkd);
            }
            if (QLog.isColorLevel()) {
              QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInSpecialCareList return:" + this.dkd);
            }
            return this.dkd + i;
          }
          paramInt1 += 1;
        }
        paramInt2 = k;
      }
    }
  }
  
  public int a(FriendItemLayout paramFriendItemLayout, zap.a parama, int paramInt)
  {
    int j = 0;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)parama.b.getLayoutParams();
    if (localLayoutParams != null) {}
    for (int i = localLayoutParams.rightMargin;; i = 0)
    {
      dyC();
      if (this.dkd <= this.dkb) {
        return this.dkd + paramInt + i;
      }
      int k = paramFriendItemLayout.getMeasuredWidth();
      if (k <= this.dkb) {
        return this.dkd + paramInt + i;
      }
      int m = paramFriendItemLayout.getPaddingLeft();
      int n = paramFriendItemLayout.getPaddingRight();
      paramInt = a(parama.l.getText(), parama.l.getTextSize());
      int i1 = Math.min(getResources().getDimensionPixelSize(2131296994), paramInt);
      int i2 = parama.l.getCompoundPaddingLeft();
      int i3 = parama.l.getCompoundPaddingRight();
      int i4 = parama.l.getPaddingRight();
      int i5 = parama.l.getPaddingLeft();
      paramFriendItemLayout = (FrameLayout.LayoutParams)parama.hE.getLayoutParams();
      if (paramFriendItemLayout != null) {}
      for (paramInt = paramFriendItemLayout.leftMargin;; paramInt = 0)
      {
        k = k - (m + n) - paramInt - i1 - (i5 + (i2 + i3 + i4)) - parama.az.getMeasuredWidth() - i;
        if (QLog.isColorLevel()) {
          QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInFriendItemLayout maxMutualMarkWidth:" + k + " maybeWidth:" + this.dkd + " nickMinWidth:" + i1 + " mutualMarkMarginRight:" + i);
        }
        if (this.dkd > k) {
          if (this.xV != null) {
            paramInt = j;
          }
        }
        for (;;)
        {
          if (paramInt < this.xV.size())
          {
            paramFriendItemLayout = (MutualMarkIconItemView)this.xV.get(paramInt);
            if ((paramFriendItemLayout != null) && (paramFriendItemLayout.getVisibility() == 0))
            {
              this.dkd -= paramFriendItemLayout.Gy();
              paramFriendItemLayout.setVisibility(8);
              if (QLog.isColorLevel()) {
                QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInFriendItemLayout hide Type:" + paramFriendItemLayout.gr() + " width:" + paramFriendItemLayout.Gy());
              }
              if (this.dkd > k) {}
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInFriendItemLayout after maybeWidth:" + this.dkd);
            }
            if (QLog.isColorLevel()) {
              QLog.i("MutualMarkIconsView", 2, "getMaybeWidthInFriendItemLayout return:" + this.dkd);
            }
            return this.dkd + i;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void z(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (AppSetting.enableTalkBack) {
      this.Q = new StringBuilder();
    }
    this.djZ = paramInt;
    ArrayList localArrayList = ajnn.a(paramQQAppInterface, paramString, false, paramInt);
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      dyB();
      return;
    }
    if (this.xV == null) {
      this.xV = new ArrayList();
    }
    paramInt = this.xV.size();
    int i = localArrayList.size();
    if (paramInt < i) {
      while (paramInt < i)
      {
        localObject1 = new MutualMarkIconItemView(getContext());
        addView((View)localObject1, paramInt, new LinearLayout.LayoutParams(-2, this.dka));
        this.xV.add(localObject1);
        paramInt += 1;
      }
    }
    if (paramInt > i)
    {
      paramInt -= 1;
      while (paramInt >= i)
      {
        removeView((MutualMarkIconItemView)this.xV.remove(paramInt));
        paramInt -= 1;
      }
    }
    setVisibility(0);
    this.dkd = 0;
    Object localObject2 = (acff)paramQQAppInterface.getManager(51);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((acff)localObject2).a(paramString, false);
    }
    paramInt = 0;
    long l = 0L;
    if (paramInt < localArrayList.size())
    {
      localObject2 = (ajoh)localArrayList.get(paramInt);
      a(paramQQAppInterface, paramString, (ajoh)localObject2, (ExtensionInfo)localObject1, (MutualMarkIconItemView)this.xV.get(paramInt));
      if (((ajoh)localObject2).type != 5L) {
        break label301;
      }
      l = ((ajoh)localObject2).adb;
    }
    label301:
    for (;;)
    {
      paramInt += 1;
      break;
      i(paramQQAppInterface, paramString, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView
 * JD-Core Version:    0.7.0.1
 */