package com.tencent.mobileqq.onlinestatus;

import aeif;
import aelg;
import akti;
import akto;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqnm;
import auun;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class OnlineStatusView
  extends LinearLayout
{
  TextView WK;
  TextView WL;
  aelg a;
  long ael;
  auun b;
  URLImageView bn;
  int dpf;
  int dpg = 1;
  
  public OnlineStatusView(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public OnlineStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  public OnlineStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  public int He()
  {
    CharSequence localCharSequence1 = this.WK.getText();
    CharSequence localCharSequence2 = this.WL.getText();
    int i = (int)this.WK.getPaint().measureText(localCharSequence1, 0, localCharSequence1.length());
    int j = (int)this.WL.getPaint().measureText(localCharSequence2, 0, localCharSequence2.length());
    int k = aqnm.dip2px(2.0F);
    int m = aqnm.dip2px(12.0F);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusView", 2, new Object[] { "prefixLen:", Integer.valueOf(i), " suffixLen:", Integer.valueOf(j), " iconLen:", Integer.valueOf(m) });
    }
    return i + m + j + k;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Friends paramFriends)
  {
    this.ael = paramFriends.uExtOnlineStatus;
    this.dpf = paramFriends.getBatteryCapacity();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusView", 2, new Object[] { "setOnlineStatus extStatus:", Long.valueOf(this.ael), " battery:", Integer.valueOf(this.dpf) });
    }
    akto localakto = this.a.a(AppRuntime.Status.online, this.ael);
    if ((localakto.itemType == 2) || ((this.ael == 1000L) && (this.dpf <= 0)))
    {
      QLog.d("OnlineStatusView", 2, "setOnlineStatus item is null");
      return false;
    }
    paramQQAppInterface = akti.a().a(paramQQAppInterface, localakto, localakto.f, paramFriends, this.WL, 2);
    if ((localakto.id == -1L) && (TextUtils.isEmpty(paramQQAppInterface))) {
      return false;
    }
    if (akto.cw(this.ael))
    {
      paramFriends = this.b.i(this.dpf, 1);
      this.bn.setImageDrawable(paramFriends);
      if (this.dpg != 2) {
        break label269;
      }
      this.WK.setVisibility(0);
      this.WL.setText(paramQQAppInterface + "]");
    }
    for (;;)
    {
      return true;
      paramFriends = URLDrawable.URLDrawableOptions.obtain();
      paramFriends.mRequestWidth = aqnm.dip2px(12.0F);
      paramFriends.mRequestHeight = aqnm.dip2px(12.0F);
      paramFriends = URLDrawable.getDrawable(localakto.iconUrl, paramFriends);
      this.bn.setImageDrawable(paramFriends);
      break;
      label269:
      this.WK.setVisibility(8);
      this.WL.setText(paramQQAppInterface);
    }
  }
  
  void initUI()
  {
    setOrientation(0);
    setGravity(16);
    float f = getResources().getDimensionPixelSize(2131296935);
    this.WK = new TextView(getContext());
    this.WK.setDuplicateParentStateEnabled(false);
    this.WK.setIncludeFontPadding(false);
    this.WK.setSingleLine(true);
    this.WK.setTextColor(getResources().getColor(2131167383));
    this.WK.setTextSize(0, f);
    this.WK.setText("[");
    this.WK.setGravity(16);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, aqnm.dip2px(19.0F));
    localLayoutParams.gravity = 16;
    addView(this.WK, localLayoutParams);
    this.bn = new URLImageView(getContext());
    this.bn.setDuplicateParentStateEnabled(false);
    this.bn.setScaleType(ImageView.ScaleType.FIT_XY);
    localLayoutParams = new LinearLayout.LayoutParams(aqnm.dip2px(12.0F), aqnm.dip2px(12.0F));
    localLayoutParams.gravity = 16;
    localLayoutParams.leftMargin = aqnm.dip2px(2.0F);
    localLayoutParams.rightMargin = aqnm.dip2px(2.0F);
    addView(this.bn, localLayoutParams);
    this.WL = new TextView(getContext());
    this.WL.setDuplicateParentStateEnabled(false);
    this.WL.setIncludeFontPadding(false);
    this.WL.setSingleLine(true);
    this.WL.setTextColor(getResources().getColor(2131167383));
    this.WL.setTextSize(0, f);
    this.WL.setGravity(16);
    localLayoutParams = new LinearLayout.LayoutParams(-2, aqnm.dip2px(19.0F));
    localLayoutParams.gravity = 16;
    addView(this.WL, localLayoutParams);
    this.a = ((aelg)aeif.a().o(578));
    this.b = new auun();
  }
  
  public void setTextSize(int paramInt)
  {
    this.WK.setTextSize(0, paramInt);
    this.WL.setTextSize(0, paramInt);
  }
  
  public void setViewStyle(int paramInt)
  {
    this.dpg = paramInt;
  }
  
  public CharSequence t()
  {
    CharSequence localCharSequence1 = this.WK.getText();
    CharSequence localCharSequence2 = this.WL.getText();
    StringBuilder localStringBuilder = new StringBuilder(10);
    localStringBuilder.append(localCharSequence1).append(localCharSequence2);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusView
 * JD-Core Version:    0.7.0.1
 */