package dov.com.qq.im.ae.camera.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import awwk;
import awzr;
import awzs;
import awzt;
import awzu;
import awzv;
import axgi;
import axov;
import axpr;
import axwc;
import ayva;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.ArrayList;
import java.util.Iterator;
import rpq;

public class AEProviderContainerView
  extends FrameLayout
{
  private ArrayList<View> FC = new ArrayList();
  private View Gp;
  private View Mm;
  private View Mn;
  private View Mo;
  private awwk jdField_a_of_type_Awwk;
  private AEFilterProviderView jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView;
  private boolean aUU;
  private AEBeautyProviderView b;
  private FrameLayout bw;
  private axgi c;
  private AECaptureMode d = AECaptureMode.NORMAL;
  private boolean dtL;
  View.OnClickListener fG = new awzr(this);
  private int mSelectedTabIndex = 0;
  public int translationY = rpq.dip2px(getContext(), 195.0F);
  
  public AEProviderContainerView(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public AEProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  public AEProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  private void eIe()
  {
    switch (this.mSelectedTabIndex)
    {
    default: 
      return;
    case 0: 
      eIf();
      return;
    }
    eIg();
  }
  
  private void eIf()
  {
    this.mSelectedTabIndex = 0;
    this.Mn.setSelected(true);
    this.Mm.setSelected(false);
    if (this.b != null)
    {
      this.b.setAlpha(1.0F);
      this.b.setVisibility(8);
      this.b = null;
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView == null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView = new AEFilterProviderView(getContext());
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setNeedTabBar(false);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.TZ(rpq.dip2px(getContext(), 162.0F));
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null) {
        this.bw.addView(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView);
      }
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null)
    {
      if (!this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.mInited) {
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.onCreate(null);
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.dKI();
    }
  }
  
  private void eIg()
  {
    this.mSelectedTabIndex = 1;
    this.Mn.setSelected(false);
    this.Mm.setSelected(true);
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.dLs();
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setVisibility(8);
    }
    if (this.b == null)
    {
      this.b = new AEBeautyProviderView(getContext());
      if (this.b != null) {
        this.bw.addView(this.b);
      }
    }
    if (this.b != null)
    {
      if (!this.b.mInited)
      {
        this.b.setController(this.jdField_a_of_type_Awwk);
        this.b.onCreate(null);
      }
      this.b.setAlpha(1.0F);
      this.b.setVisibility(0);
      this.b.dKI();
    }
  }
  
  private void eIi()
  {
    this.dtL = false;
    Object localObject = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.translationY });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new awzu(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = axwc.a(this, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new awzv(this));
    startAnimation((Animation)localObject);
  }
  
  private void initUI()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131558576, null);
    addView(localView);
    this.Mm = localView.findViewById(2131363382);
    this.Mm.setOnClickListener(this.fG);
    this.Mn = localView.findViewById(2131367097);
    this.Mn.setOnClickListener(this.fG);
    this.bw = ((FrameLayout)localView.findViewById(2131373725));
    this.Gp = localView.findViewById(2131373726);
    this.Mo = localView.findViewById(2131364384);
    this.FC.add(this.Gp);
    this.FC.add(this.Mo);
    this.FC.add(this.Mm);
    this.FC.add(this.Mn);
  }
  
  public boolean aOd()
  {
    int j = 1;
    boolean bool2 = false;
    int i;
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null) || (this.b != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView == null) {
        break label82;
      }
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.getVisibility() != 0) {
        break label72;
      }
      i = 1;
    }
    label72:
    label77:
    label82:
    for (boolean bool1 = i | 0x0;; bool1 = false)
    {
      bool2 = bool1;
      if (this.b != null) {
        if (this.b.getVisibility() != 0) {
          break label77;
        }
      }
      for (i = j;; i = 0)
      {
        bool2 = bool1 | i;
        return bool2;
        i = 0;
        break;
      }
    }
  }
  
  public boolean aOn()
  {
    return this.d == AECaptureMode.GIF;
  }
  
  public void apk()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.apk();
    }
    ayva.a().b(null, (Activity)getContext(), 0);
    ayva.a().a(null, 0);
    ((axpr)axov.a(5)).cT((Activity)getContext());
  }
  
  public void dLp()
  {
    if (this.dtL) {
      eIi();
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.dLs();
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.setVisibility(8);
    }
    if (this.b != null)
    {
      this.b.setVisibility(8);
      this.b = null;
    }
    if (this.c != null) {
      this.c.p(196613, new Object[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEProviderContainerView", 2, "panel closed");
    }
  }
  
  public void eHZ()
  {
    if (this.b != null) {
      this.b.eHZ();
    }
  }
  
  public void eId()
  {
    if (!this.aUU)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AEProviderContainerView", 2, "doOpenProviderView failed isInflated" + this.aUU);
      }
      return;
    }
    eIe();
    eIh();
  }
  
  public void eIh()
  {
    this.dtL = true;
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this, "translationY", new float[] { this.translationY, 0.0F }));
    ((AnimatorSet)localObject).addListener(new awzs(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = axwc.a(this, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new awzt(this));
    startAnimation((Animation)localObject);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.onDestroy();
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView = null;
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.onResume();
    }
    if (this.b != null) {
      this.b.onResume();
    }
  }
  
  public void onStop()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderView.onStop();
    }
  }
  
  public void setBackGroundAlpha(float paramFloat)
  {
    if (this.FC != null)
    {
      Iterator localIterator = this.FC.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if (localView != null) {
          localView.setAlpha(paramFloat);
        }
      }
    }
  }
  
  public void setCaptureMode(AECaptureMode paramAECaptureMode)
  {
    this.d = paramAECaptureMode;
  }
  
  public void setControllerAndManager(awwk paramawwk, axgi paramaxgi)
  {
    this.jdField_a_of_type_Awwk = paramawwk;
    this.c = paramaxgi;
    this.aUU = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView
 * JD-Core Version:    0.7.0.1
 */