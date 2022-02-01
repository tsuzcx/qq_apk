package com.tencent.mobileqq.olympic.activity;

import adbx;
import adca;
import akqq;
import akqr;
import akqs;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.a;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import jik;
import mqq.os.MqqHandler;
import wja;

public class PromotionEntry
{
  public static final String TAG = adca.TAG;
  private UpdateOperateBtnStatusRunnable jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable;
  private a jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$a;
  private boolean bLe = true;
  public boolean cui;
  private ImageView kg;
  
  public PromotionEntry(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$a = parama;
  }
  
  private void c(String paramString, PromotionConfigInfo.a parama, boolean paramBoolean)
  {
    String str = TAG;
    paramString = new StringBuilder().append("updateOperateBtnStatus[").append(paramString).append("], visible[").append(paramBoolean).append("], mIsWorldCupMode[").append(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$a.afk()).append("], mEnterTransferDoorModeByClickEntry[").append(this.cui).append("], operateBtn[");
    if (this.kg != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.kg != null) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable == null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable = new UpdateOperateBtnStatusRunnable(null);
    }
    if (parama != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.c = parama;
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.mShow = paramBoolean;
    UpdateOperateBtnStatusRunnable.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable, new WeakReference(this.kg));
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable);
    if (paramBoolean)
    {
      if (this.bLe)
      {
        anot.a(null, "CliOper", "", "", "0X8009C6A", "0X8009C6A", 0, 0, parama.id, "0", "0", "");
        this.bLe = false;
      }
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable, 500L);
      return;
    }
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable);
  }
  
  public void a(AppInterface paramAppInterface, PromotionConfigInfo.a parama)
  {
    if (this.kg != null) {
      return;
    }
    paramAppInterface = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$a.l();
    ImageView localImageView = new ImageView(paramAppInterface.getContext());
    Object localObject = adbx.a(parama) + "entry.png";
    localObject = jik.a(localImageView.getResources(), (String)localObject);
    if (localObject != null) {
      localImageView.setImageBitmap((Bitmap)localObject);
    }
    localObject = new RelativeLayout.LayoutParams(wja.dp2px(217.0F, localImageView.getResources()), wja.dp2px(47.0F, localImageView.getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    int j = ImmersiveUtils.getScreenHeight();
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i = j - ImmersiveUtils.getStatusBarHeight(paramAppInterface.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * 23 / 200.0F));
    localImageView.setClickable(true);
    localImageView.setOnTouchListener(new akqq(this));
    localImageView.setOnClickListener(new akqr(this, parama));
    localImageView.setVisibility(8);
    paramAppInterface.addView(localImageView, (ViewGroup.LayoutParams)localObject);
    this.kg = localImageView;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$a.afk())
    {
      QLog.w(TAG, 1, "reallyCreateOperateEntry, 已经在穿越门模式了");
      return;
    }
    c("reallyCreateOperateEntry", parama, true);
  }
  
  public void a(boolean paramBoolean, PromotionConfigInfo.a parama)
  {
    c("operateBtnOnClick", parama, paramBoolean);
    this.cui = true;
  }
  
  public void showEntry(boolean paramBoolean)
  {
    c("showEntry", null, paramBoolean);
  }
  
  public void t(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$a = null;
    this.bLe = true;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.destory();
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable = null;
    }
    if (this.kg != null)
    {
      this.kg.setOnClickListener(null);
      this.kg = null;
    }
  }
  
  public static class UpdateOperateBtnStatusRunnable
    implements Runnable
  {
    OnCompositionLoadedListener a = null;
    public ObjectAnimator bL = null;
    PromotionConfigInfo.a c = null;
    private WeakReference<ImageView> hw = new WeakReference(null);
    public LottieDrawable lottieDrawable = null;
    public boolean mShow;
    
    public void NJ(String paramString)
    {
      this.a = new akqs(this, paramString);
    }
    
    public void destory()
    {
      ImageView localImageView = (ImageView)this.hw.get();
      if (localImageView != null) {
        localImageView.setImageDrawable(null);
      }
      if (this.lottieDrawable != null)
      {
        this.lottieDrawable.cancelAnimation();
        this.lottieDrawable = null;
      }
    }
    
    public void e(ImageView paramImageView, int paramInt)
    {
      if (this.bL != null) {}
      do
      {
        return;
        if (this.c == null)
        {
          QLog.w(PromotionEntry.TAG, 1, "createShowOperateBtnAnim, promotionItem为空");
          return;
        }
      } while (this.lottieDrawable != null);
      Object localObject = adbx.a(this.c);
      NJ((String)localObject);
      try
      {
        localObject = new FileInputStream((String)localObject + "entry.json");
        LottieComposition.Factory.fromInputStream(paramImageView.getContext(), (InputStream)localObject, this.a);
        return;
      }
      catch (Exception paramImageView)
      {
        QLog.i(PromotionEntry.TAG, 1, "createShowOperateBtnAnim, 读取json失败", paramImageView);
      }
    }
    
    public void run()
    {
      ImageView localImageView = (ImageView)this.hw.get();
      if (localImageView == null) {}
      do
      {
        do
        {
          do
          {
            return;
            if (!this.mShow) {
              break;
            }
          } while (localImageView.getVisibility() == 0);
          localImageView.setVisibility(0);
          e(localImageView, 0);
          if (this.bL != null) {
            this.bL.start();
          }
        } while (this.lottieDrawable == null);
        localImageView.setImageDrawable(this.lottieDrawable);
        this.lottieDrawable.setRepeatCount(5);
        this.lottieDrawable.playAnimation();
        return;
        localImageView.setVisibility(8);
        if (this.bL != null) {
          this.bL.end();
        }
      } while (this.lottieDrawable == null);
      localImageView.setImageDrawable(this.lottieDrawable);
      this.lottieDrawable.endAnimation();
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean afk();
    
    public abstract void c(PromotionConfigInfo.a parama);
    
    public abstract RelativeLayout l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry
 * JD-Core Version:    0.7.0.1
 */