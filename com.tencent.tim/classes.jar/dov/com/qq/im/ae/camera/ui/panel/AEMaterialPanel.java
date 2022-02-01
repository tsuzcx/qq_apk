package dov.com.qq.im.ae.camera.ui.panel;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import awwk;
import awzm;
import awzn;
import awzo;
import awzp;
import axbu;
import axcg;
import axgi;
import axiy;
import axwc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import rpq;

public class AEMaterialPanel
  extends FrameLayout
{
  private awwk jdField_a_of_type_Awwk;
  private AEMaterialProviderView jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView;
  private axgi jdField_b_of_type_Axgi;
  private a jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$a;
  private boolean dtH;
  private boolean dtI;
  private Runnable iM;
  public int translationY = QX();
  
  public AEMaterialPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEMaterialPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEMaterialPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int QX()
  {
    return rpq.dip2px(getContext(), 242.0F);
  }
  
  private void aB(Runnable paramRunnable)
  {
    hidePanel();
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.setVisibility(8);
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  @TargetApi(12)
  private void aC(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView == null) {
      ces();
    }
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this, "translationY", new float[] { this.translationY, 0.0F }));
    ((AnimatorSet)localObject).addListener(new awzm(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = axwc.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new awzn(this, paramRunnable));
    startAnimation((Animation)localObject);
  }
  
  private void aD(Runnable paramRunnable)
  {
    axiy.d("AEMaterialPanel", "in close panel animation.");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.translationY });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new awzo(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = axwc.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView, 1.0F, 0.0F);
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener(new awzp(this));
    startAnimation(paramRunnable);
  }
  
  private void eIa()
  {
    if (this.jdField_a_of_type_Awwk != null) {
      this.jdField_a_of_type_Awwk.by(false, 150);
    }
  }
  
  private void eIb()
  {
    if (this.jdField_b_of_type_Axgi != null) {
      this.jdField_b_of_type_Axgi.p(131075, new Object[0]);
    }
  }
  
  private void hidePanel()
  {
    setTranslationY(QX());
    setVisibility(8);
  }
  
  public void XW(boolean paramBoolean)
  {
    if ((getContext() instanceof Activity))
    {
      Object localObject = (Activity)getContext();
      if (axcg.ay(((Activity)localObject).getIntent()))
      {
        MqqHandler localMqqHandler = ThreadManager.getUIHandler();
        localObject = new AEMaterialPanel.1(this, (Activity)localObject);
        this.iM = ((Runnable)localObject);
        localMqqHandler.postDelayed((Runnable)localObject, 300L);
      }
    }
    a(paramBoolean, new AEMaterialPanel.2(this));
  }
  
  public void a(boolean paramBoolean, Runnable paramRunnable)
  {
    if (!aOd()) {
      return;
    }
    if (paramBoolean) {
      aD(paramRunnable);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Axgi != null) {
        this.jdField_b_of_type_Axgi.p(196613, new Object[0]);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AEMaterialPanel", 2, "panel closed");
      return;
      aB(paramRunnable);
    }
  }
  
  public boolean aOd()
  {
    if (getVisibility() == 8) {}
    while ((this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView == null) || (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.getVisibility() != 0)) {
      return false;
    }
    return true;
  }
  
  public void ad(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView == null) {
      bool = true;
    }
    aC(null);
    if ((paramBoolean) && (paramString1 != null) && (paramString2 != null) && (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null)) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.ae(paramString1, paramString2, bool);
    }
  }
  
  @TargetApi(11)
  public void ces()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.height = QX();
    setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView = new AEMaterialProviderView(getContext(), this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$a);
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null) {
      addView(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEMaterialPanel", 2, "onDestroy()");
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.onDestroy();
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView = null;
    }
    if (this.iM != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.iM);
    }
  }
  
  public void onStop()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.onStop();
    }
  }
  
  public void setAECaptureController(awwk paramawwk)
  {
    this.jdField_a_of_type_Awwk = paramawwk;
  }
  
  public void setMaterialPanelListener(a parama)
  {
    this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$a = parama;
  }
  
  public void setPartManager(axgi paramaxgi)
  {
    this.jdField_b_of_type_Axgi = paramaxgi;
  }
  
  public static abstract interface a
  {
    public abstract void a(axbu paramaxbu);
    
    public abstract void eGk();
    
    public abstract void eGl();
    
    public abstract void eGm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel
 * JD-Core Version:    0.7.0.1
 */