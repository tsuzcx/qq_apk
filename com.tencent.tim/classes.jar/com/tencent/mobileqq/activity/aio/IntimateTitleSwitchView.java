package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;

public class IntimateTitleSwitchView
  extends FrameLayout
{
  TextView Ih;
  TextView Ii;
  TextView Ij;
  a jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView$a;
  IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  QQAppInterface app;
  boolean aqw = false;
  int bPg;
  int bPj;
  TickerView c;
  ViewGroup cZ;
  Runnable ei = new IntimateTitleSwitchView.1(this);
  Context mContext;
  boolean uA = false;
  
  public IntimateTitleSwitchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateTitleSwitchView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateTitleSwitchView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2131559453, this, true);
    this.cZ = ((ViewGroup)paramContext.findViewById(2131369351));
    this.c = ((TickerView)paramContext.findViewById(2131369339));
    this.Ih = ((TextView)paramContext.findViewById(2131369338));
    this.Ii = ((TextView)paramContext.findViewById(2131369336));
    this.Ij = ((TextView)paramContext.findViewById(2131362216));
    this.c.setCharacterLists(new String[] { "9876543210" });
    this.c.setAnimationDuration(2000L);
    this.cZ.setTranslationX(0.0F);
  }
  
  private boolean Ru()
  {
    boolean bool = true;
    if (this.bPg == 4) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IntimateTitleSwitchView", 0, "canUpdateAnim res: " + bool + "  mCurrentShowType:" + this.bPg);
    }
    return bool;
  }
  
  private void bZw()
  {
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "checkAndStartUpdateAnim mIsResumed:" + this.uA + " mCurrentShowType:" + this.bPg + " mIntimateInfo:" + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
    if ((this.uA) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null))
    {
      removeCallbacks(this.ei);
      if ((Ru()) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays != this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays > 0)) {
        postDelayed(this.ei, 300L);
      }
    }
  }
  
  private void bZx()
  {
    int k = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays);
    int j = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays);
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "smoothUpdateDays fromDays:" + k + " toDays:" + j);
    }
    if (k <= 0)
    {
      int m = String.valueOf(j).length();
      localObject = "";
      i = 0;
      while ((i < m) && (i < 5))
      {
        localObject = (String)localObject + "0";
        i += 1;
      }
      this.c.setText((String)localObject, false);
    }
    Object localObject = this.c;
    if (j > k) {}
    for (int i = 1;; i = 2)
    {
      ((TickerView)localObject).setPreferredScrollingDirection(i);
      this.c.setDigitalAnimWidthSpeedIncrement(true);
      this.c.setIgnoreWidthAnim(true);
      this.c.setText(String.valueOf(j));
      this.Ih.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView$a.bZk();
      }
      return;
    }
  }
  
  public void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.bPj = paramInt;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays;
    int i = j;
    if (Ru())
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays > 0) {
        i = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterFriendDays);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IntimateTitleSwitchView", 0, "updateIntimateInfo beFriendDays: " + i);
    }
    if (i >= -1) {
      if (i == 0)
      {
        str = this.mContext.getResources().getString(2131695042);
        this.Ih.setVisibility(8);
        this.c.setText(str, false);
        if (paramInt == 3)
        {
          this.Ii.setText(2131695044);
          this.Ij.setBackgroundResource(2130841184);
          j = 2131165894;
          i = 2131165893;
          paramInt = 2130841184;
          label162:
          if (TextUtils.isEmpty(paramIntimateInfo.addFriendWording)) {
            break label418;
          }
          this.Ij.setText(paramIntimateInfo.addFriendWording);
          this.Ij.setVisibility(0);
          label191:
          this.c.setTextColor(this.mContext.getResources().getColor(j));
          this.Ih.setTextColor(this.mContext.getResources().getColor(j));
          this.Ii.setTextColor(this.mContext.getResources().getColor(j));
          this.Ij.setTextColor(this.mContext.getResources().getColor(i));
          this.Ij.setBackgroundResource(paramInt);
          label274:
          bZw();
        }
      }
      else
      {
        if (i != -1) {
          break label468;
        }
      }
    }
    label418:
    label468:
    for (String str = "999+";; str = String.valueOf(i))
    {
      this.Ih.setVisibility(0);
      break;
      if (paramInt == 2)
      {
        this.Ii.setText(2131695043);
        this.Ij.setBackgroundResource(2130841182);
        j = 2131165892;
        i = 2131165891;
        paramInt = 2130841182;
        break label162;
      }
      if (paramInt == 1)
      {
        this.Ii.setText(2131695045);
        this.Ij.setBackgroundResource(2130841186);
        j = 2131165896;
        i = 2131165895;
        paramInt = 2130841186;
        break label162;
      }
      this.Ii.setText(2131695040);
      this.Ij.setBackgroundResource(2130841180);
      j = 2131165897;
      i = 2131165898;
      paramInt = 2130841180;
      break label162;
      this.Ij.setVisibility(8);
      break label191;
      this.c.setText("");
      this.Ih.setVisibility(8);
      this.Ii.setText("");
      this.Ij.setVisibility(4);
      break label274;
    }
  }
  
  public void onDestroy()
  {
    this.uA = false;
    removeCallbacks(this.ei);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView$a = null;
  }
  
  public void onDrawerClosed()
  {
    this.uA = false;
    this.aqw = false;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onDrawerClosed mIsResumed:" + this.uA);
    }
    removeCallbacks(this.ei);
  }
  
  public void onDrawerOpened()
  {
    this.uA = true;
    this.aqw = true;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onDrawerOpened mIsResumed:" + this.uA);
    }
    bZw();
  }
  
  public void onPaused()
  {
    this.uA = false;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onPaused mIsResumed:" + this.uA);
    }
    removeCallbacks(this.ei);
  }
  
  public void onResumed()
  {
    if (this.bPg == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IntimateTitleSwitchView", 0, "onResumed mIsOpened:" + this.aqw);
      }
      if (!this.aqw) {
        return;
      }
    }
    this.uA = true;
    if (QLog.isColorLevel()) {
      QLog.i("IntimateTitleSwitchView", 0, "onResumed mIsResumed:" + this.uA);
    }
    bZw();
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public void setCallBack(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateTitleSwitchView$a = parama;
  }
  
  public void setCurrentShowType(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateTitleSwitchView", 0, "setCurrentShowType showType: " + paramInt + "  old:" + this.bPg + "  this:" + this);
    }
    this.bPg = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void bZk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView
 * JD-Core Version:    0.7.0.1
 */