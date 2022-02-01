package com.tencent.mobileqq.relationx.icebreaking;

import abrb;
import alum;
import alun;
import alur;
import aluu;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import anot;
import aurf;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;
import wja;
import wnc;
import ybb;
import ygl;

public class AIOIceBreakShow
  implements Handler.Callback, AIOIceBreakView.a
{
  private static int dxZ;
  private List<ygl> Fs;
  private alur jdField_a_of_type_Alur;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Animator.AnimatorListener animatorListener = new alun(this);
  private boolean bQY;
  private BaseChatPie jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie;
  private wnc jdField_c_of_type_Wnc;
  private boolean czw;
  private aurf d;
  private int dya = -1;
  private ValueAnimator.AnimatorUpdateListener g = new alum(this);
  private aurf j;
  private LinearLayout kd;
  private Context mContext;
  private String mFriendUin;
  private int mState = -1;
  
  public AIOIceBreakShow(BaseChatPie paramBaseChatPie, Context paramContext, String paramString)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.mContext = paramContext;
    this.mFriendUin = paramString;
    this.jdField_a_of_type_Alur = ((alur)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getManager(285));
    this.d = new aurf(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.getUIHandler().getLooper(), this);
    this.j = new aurf(ThreadManager.getSubThreadLooper(), this);
    dxZ = wja.dp2px(150.0F, this.mContext.getResources());
    this.jdField_c_of_type_Wnc = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a;
  }
  
  private void Kk(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("hide needAnim: %s, mState: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.mState) }));
    }
    if (this.mState != 0) {
      return;
    }
    if ((this.bQY) && (this.jdField_a_of_type_AndroidAnimationValueAnimator != null))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      restore();
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.g);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.animatorListener);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      }
      PropertyValuesHolder localPropertyValuesHolder1 = PropertyValuesHolder.ofInt("height", new int[] { dxZ, 0 });
      PropertyValuesHolder localPropertyValuesHolder2 = PropertyValuesHolder.ofInt("alpha", new int[] { 100, 0 });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setValues(new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2 });
      this.mState = 1;
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
    if ((this.kd != null) && (this.kd.getParent() != null))
    {
      this.kd.setVisibility(8);
      this.jdField_c_of_type_Wnc.a(3, 0);
      this.jdField_c_of_type_Wnc.c(0, false, "icebreak_showFooter", 0);
      if (auA()) {
        this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.refresh(196608);
      }
      this.kd = null;
    }
    this.mState = 1;
  }
  
  private void Vg()
  {
    Object localObject1 = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.b;
    if ((localObject1 == null) || (this.kd == null)) {
      return;
    }
    localObject1 = ((ListView)localObject1).getChildAt(((ListView)localObject1).getLastVisiblePosition() - ((ListView)localObject1).getFirstVisiblePosition());
    int k = 0;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = new Rect();
      ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
      i = ((Rect)localObject2).bottom;
      if (((View)localObject1).getId() == 2131362462) {
        i = ((Rect)localObject2).top;
      }
      localObject1 = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.i().findViewById(2131369277);
      localObject2 = new Rect();
      ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
      if (((Rect)localObject2).top - i > dxZ) {
        break label305;
      }
      i = 1;
    }
    for (;;)
    {
      localObject1 = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a;
      if (this.kd.getParent() != null)
      {
        if (!(auA() ^ i))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AIOIceBreakShow", 2, "don't need to relocate");
          return;
          i = k;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AIOIceBreakShow", 2, "locate itemView == null");
          i = k;
          continue;
        }
        ((ViewGroup)this.kd.getParent()).removeView(this.kd);
      }
      localObject2 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject2).gravity = 81;
      if (i != 0)
      {
        ((wnc)localObject1).a(this.kd, (FrameLayout.LayoutParams)localObject2);
        this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.refresh(196608);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AIOIceBreakShow", 2, "locate to ListView");
        return;
      }
      ((FrameLayout)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.i().findViewById(2131373566)).addView(this.kd, (ViewGroup.LayoutParams)localObject2);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOIceBreakShow", 2, "locate to ContentView");
      return;
      label305:
      i = 0;
    }
  }
  
  private boolean auA()
  {
    if (this.kd.getParent() != null)
    {
      localObject = this.kd.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label44;
      }
    }
    label44:
    for (Object localObject = (ViewGroup)localObject;; localObject = null) {
      return ((ViewGroup)localObject).getId() == 2131362462;
    }
  }
  
  private void dy(int paramInt, String paramString)
  {
    this.j.removeCallbacksAndMessages(null);
    this.j.postDelayed(new RemoveRunnable(paramInt, paramString), this.jdField_a_of_type_Alur.showDuration * 1000L);
  }
  
  private void dz(int paramInt, String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new AIOIceBreakShow.1(this, paramInt, paramString));
  }
  
  private void remove()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("remove mState: %s", new Object[] { Integer.valueOf(this.mState) }));
    }
    if ((this.mState != 0) && (this.mState != 1)) {
      return;
    }
    if ((this.kd != null) && (this.kd.getParent() != null))
    {
      ((ViewGroup)this.kd.getParent()).removeView(this.kd);
      this.jdField_c_of_type_Wnc.a(3, 0);
      this.jdField_c_of_type_Wnc.bZM();
      this.kd = null;
    }
    this.mState = 2;
    abrb.b(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, "ice_break", false);
  }
  
  private void restore()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, "restore");
    }
    if (this.kd != null)
    {
      this.kd.setAlpha(1.0F);
      this.kd.scrollTo(0, 0);
      if (this.mState == 0) {
        this.kd.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.kd.setVisibility(8);
  }
  
  private void show(boolean paramBoolean)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("show needAnim: %s, mState: %s, mIceBreakType: %s, mIsAIOPanelOpen: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.mState), Integer.valueOf(this.dya), Boolean.valueOf(this.czw) }));
    }
    if ((this.mState != 1) && (this.mState != -1)) {}
    while (this.dya == -1) {
      return;
    }
    if (this.kd == null)
    {
      if ((this.Fs == null) || (this.Fs.size() == 0))
      {
        QLog.d("AIOIceBreakShow", 1, "rec mRecEmotionList is empty!");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOIceBreakShow", 2, "bind data pic urls: " + this.Fs);
      }
      this.kd = new AIOIceBreakView(this.mContext);
      ((AIOIceBreakView)this.kd).c(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie, this.Fs);
      this.kd.setTag(2131362409, Integer.valueOf(this.dya));
      ((AIOIceBreakView)this.kd).setOnIceImageClickListener(this);
    }
    if (this.czw)
    {
      this.mState = 1;
      return;
    }
    if ((this.bQY) && (this.jdField_a_of_type_AndroidAnimationValueAnimator != null))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      restore();
    }
    abrb.b(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, "ice_break", true);
    Vg();
    this.mState = 0;
    Object localObject;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.g);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.animatorListener);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      }
      localObject = PropertyValuesHolder.ofInt("height", new int[] { 0, dxZ });
      PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofInt("alpha", new int[] { 0, 100 });
      this.jdField_c_of_type_Wnc.a(3, 0);
      this.jdField_c_of_type_Wnc.c(0, false, "icebreak_showFooter", 0);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setValues(new PropertyValuesHolder[] { localObject, localPropertyValuesHolder });
      this.kd.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      if (QLog.isColorLevel()) {
        QLog.d("AIOIceBreakShow", 2, "real show duration = " + this.jdField_a_of_type_Alur.showDuration);
      }
      dy(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl);
      dz(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl);
      localObject = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app;
      if (this.dya != 0) {
        break label607;
      }
    }
    for (;;)
    {
      anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X8009B95", "0X8009B95", i, 0, "", "", "", "");
      return;
      this.jdField_c_of_type_Wnc.a(3, dxZ);
      this.jdField_c_of_type_Wnc.c(dxZ, false, "icebreak_showFooter", 0);
      break;
      label607:
      i = 2;
    }
  }
  
  public void Og(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOIceBreakShow", 2, String.format("onAIOPanelChanged isShow = %s, mIsAIOPanelOpen = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.czw) }));
    }
    if ((this.czw ^ paramBoolean))
    {
      this.czw = paramBoolean;
      if (!this.czw) {
        break label111;
      }
      if ((this.mState == 0) && (!this.bQY))
      {
        this.d.removeMessages(0);
        this.d.removeMessages(1);
        localMessage = this.d.obtainMessage(1, 0, 0);
        this.d.sendMessage(localMessage);
      }
    }
    label111:
    while ((this.mState != 1) || (this.bQY)) {
      return;
    }
    this.d.removeMessages(0);
    this.d.removeMessages(1);
    Message localMessage = this.d.obtainMessage(0, 0, 0);
    this.d.sendMessage(localMessage);
  }
  
  public void ae(View paramView)
  {
    if (aluu.kX(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onImageClick remove matchChat Ice show");
      }
      if ((this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ybb)) {
        ((ybb)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie).cgz();
      }
      ThreadManager.getSubThreadHandler().post(new AIOIceBreakShow.4(this));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      if (paramMessage.arg1 == 1)
      {
        show(true);
        return false;
      }
      show(false);
      return false;
    case 1: 
      if (paramMessage.arg1 == 1)
      {
        Kk(true);
        return false;
      }
      Kk(false);
      return false;
    }
    remove();
    return false;
  }
  
  public void lU(List<ygl> paramList)
  {
    int i = this.jdField_a_of_type_Alur.ai(this.mFriendUin, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ);
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("updateShow, newType = %s, oldType = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.dya) }));
    }
    if (i == this.dya) {
      return;
    }
    if (i != -1)
    {
      if ((paramList == null) || (paramList.isEmpty()))
      {
        QLog.d("AIOIceBreakShow", 1, "update show but hotPicList is empty!");
        return;
      }
      this.dya = i;
      this.Fs = paramList;
      paramList = this.d.obtainMessage(0, 1, 0);
      this.d.sendMessage(paramList);
      return;
    }
    this.dya = i;
    this.Fs = paramList;
    this.d.sendEmptyMessage(2);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    remove();
    this.d.removeCallbacksAndMessages(null);
    this.j.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, "show sprite (normal) onDestroy.");
    }
  }
  
  class RemoveRunnable
    implements Runnable
  {
    private final int type;
    private final String uin;
    
    public RemoveRunnable(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.uin = paramString;
    }
    
    public void run()
    {
      alur localalur = (alur)AIOIceBreakShow.a(AIOIceBreakShow.this).app.getManager(285);
      if (QLog.isColorLevel())
      {
        if (this.type != 1) {
          break label75;
        }
        localalur.Pe(this.uin);
      }
      for (;;)
      {
        QLog.d("AIOIceBreakShow", 1, String.format("removeDelay, type = %s, uin = %s", new Object[] { Integer.valueOf(this.type), this.uin }));
        return;
        label75:
        if (aluu.kX(this.type)) {
          localalur.Pf(this.uin);
        } else {
          localalur.ov(this.uin);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow
 * JD-Core Version:    0.7.0.1
 */