package com.tencent.mobileqq.richmedia.capture.view;

import alwu;
import alxb;
import alxe;
import alxy;
import alxz;
import alya;
import alyb;
import alyc;
import alyd;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import anjo;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import rpq;

@TargetApi(11)
public class ProviderContainerView
  extends FrameLayout
  implements alxy
{
  View Gp;
  View Gq;
  private View Gr;
  private alxe jdField_a_of_type_Alxe;
  private a jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$a;
  private b jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$b;
  private ProviderView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView;
  private alxb jdField_b_of_type_Alxb;
  private CameraCaptureButtonLayout jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout;
  private EffectsCameraCaptureView jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
  FrameLayout bw;
  public boolean cAi = true;
  public boolean cAj = true;
  public boolean cAk = true;
  public boolean cAl = true;
  private boolean cBi;
  private int cIM = -1;
  boolean czH = true;
  View.OnClickListener fG = new alxz(this);
  private HashMap<Integer, ProviderView> jx = new HashMap();
  LinearLayout kg;
  public View mDivider;
  private HashMap<Integer, RedDotImageView> mH = new HashMap();
  private List<a> mListeners;
  private View mRootView;
  
  public ProviderContainerView(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public ProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  public ProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  private void OG(boolean paramBoolean)
  {
    Object localObject = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, rpq.dip2px(getContext(), 80.0F) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject, alwu.a(this.kg, getResources().getColor(2131165625), 153, 0), alwu.a(this.Gp, getResources().getColor(2131165625), 153, 0), alwu.a(this.Gq, getResources().getColor(2131165625), 153, 0) });
    localAnimatorSet.addListener(new alyc(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = alwu.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new alyd(this, paramBoolean));
    startAnimation((Animation)localObject);
  }
  
  @TargetApi(12)
  private void TY(int paramInt)
  {
    bN(paramInt, true);
    paramInt = rpq.dip2px(getContext(), 80.0F);
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(new Animator[] { ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt, 0.0F }), alwu.a(this.kg, getResources().getColor(2131165625), 0, 153), alwu.a(this.Gp, getResources().getColor(2131165625), 0, 153), alwu.a(this.Gq, getResources().getColor(2131165625), 0, 153) });
    ((AnimatorSet)localObject).addListener(new alya(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = alwu.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new alyb(this));
    startAnimation((Animation)localObject);
  }
  
  private void aq(View paramView, int paramInt)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int i = iR(paramInt);
      if (i != -1)
      {
        if (this.Gr != null)
        {
          this.Gr.setSelected(false);
          this.cBi = true;
        }
        this.Gr = paramView;
        this.Gr.setSelected(true);
        if ((paramView instanceof RedDotImageView))
        {
          ((RedDotImageView)paramView).showRedDot(false);
          if ((paramInt == 102) && (!anjo.pl(anjo.ceu))) {
            anjo.QD(anjo.ceu);
          }
        }
        else
        {
          if (this.cBi) {
            break label146;
          }
          TY(i);
        }
        Object localObject;
        for (;;)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$a;
          if (localObject != null) {
            ((a)localObject).ar(paramView, paramInt);
          }
          if (i != this.cIM) {
            break label155;
          }
          dLp();
          this.cIM = -1;
          return;
          this.jdField_a_of_type_Alxe.TK(i);
          break;
          label146:
          bN(i, false);
        }
        label155:
        if ((this.cIM == -1) && (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout != null)) {
          this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.by(true, 150);
        }
        this.cIM = i;
        if (this.mListeners != null)
        {
          localObject = this.mListeners.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((a)((Iterator)localObject).next()).ar(paramView, paramInt);
          }
        }
      }
    }
  }
  
  private void bN(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.dLs();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setVisibility(8);
    }
    ProviderView localProviderView;
    if (this.jx.containsKey(Integer.valueOf(this.jdField_a_of_type_Alxe.iQ(paramInt))))
    {
      localProviderView = (ProviderView)this.jx.get(Integer.valueOf(this.jdField_a_of_type_Alxe.iQ(paramInt)));
      if ((localProviderView != null) && (!localProviderView.mInited))
      {
        localProviderView.setProviderViewListener(this.jdField_b_of_type_Alxb);
        localProviderView.setAppInterface(this.jdField_b_of_type_Alxb.mApp);
        localProviderView.onCreate(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView = localProviderView;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView != null)
      {
        if (paramBoolean) {
          break label273;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setAlpha(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.dKI();
      return;
      int i = this.jdField_a_of_type_Alxe.iQ(paramInt);
      localProviderView = this.jdField_a_of_type_Alxe.a(getContext(), i);
      if (localProviderView != null)
      {
        if ((localProviderView instanceof alxy)) {
          ((alxy)localProviderView).setNeedAdvertisement(this.czH);
        }
        this.jx.put(Integer.valueOf(this.jdField_a_of_type_Alxe.iQ(paramInt)), localProviderView);
        this.bw.addView(localProviderView);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ProviderContainerView", 2, "build provider view failed " + paramInt);
      return;
      label273:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.setVisibility(8);
    }
  }
  
  private void initUI()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131561633, null);
    addView(localView);
    this.kg = ((LinearLayout)localView.findViewById(2131368712));
    this.bw = ((FrameLayout)localView.findViewById(2131373724));
    this.Gp = localView.findViewById(2131366700);
    this.Gq = localView.findViewById(2131366699);
    this.mDivider = localView.findViewById(2131373714);
    this.jdField_a_of_type_Alxe = new alxe(0);
  }
  
  public void OF(boolean paramBoolean)
  {
    if (this.Gr != null)
    {
      this.Gr.setSelected(false);
      this.Gr = null;
      this.cBi = false;
      OG(paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView.dLs();
    }
    this.cIM = -1;
  }
  
  public void dLp()
  {
    OF(false);
  }
  
  public int iR(int paramInt)
  {
    return this.jdField_a_of_type_Alxe.iR(paramInt);
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.cAi = paramBoolean;
    if (this.jdField_a_of_type_Alxe != null) {
      this.jdField_a_of_type_Alxe.setBeautyEnable(paramBoolean);
    }
  }
  
  public void setContainerViewListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$a = parama;
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.cAk = paramBoolean;
    if (this.jdField_a_of_type_Alxe != null) {
      this.jdField_a_of_type_Alxe.setFaceEffectEnable(paramBoolean);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.cAj = paramBoolean;
    if (this.jdField_a_of_type_Alxe != null) {
      this.jdField_a_of_type_Alxe.setFilterEnable(paramBoolean);
    }
  }
  
  public void setListenerController(alxb paramalxb)
  {
    this.jdField_b_of_type_Alxb = paramalxb;
    this.mRootView = paramalxb.mRootView;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout = ((CameraCaptureButtonLayout)this.mRootView.findViewById(2131364256));
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.mRootView.findViewById(2131364201));
  }
  
  public void setNeedAdvertisement(boolean paramBoolean)
  {
    this.czH = paramBoolean;
  }
  
  public void setSubtitleEnable(boolean paramBoolean)
  {
    this.cAl = paramBoolean;
    if (this.jdField_a_of_type_Alxe != null) {
      this.jdField_a_of_type_Alxe.setSubtitleEnable(paramBoolean);
    }
  }
  
  public void setTriggerLisener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$b = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void ar(View paramView, int paramInt);
    
    public abstract void dKp();
  }
  
  public static abstract interface b
  {
    public abstract void dLq();
    
    public abstract void dLr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView
 * JD-Core Version:    0.7.0.1
 */