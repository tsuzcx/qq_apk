package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import acfp;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import ayrt;
import aysi;
import aysu;
import aysv;
import aysw;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.lang.ref.WeakReference;
import wja;

public class PickerContainer
  extends RelativeLayout
  implements PickerBarLayout.a
{
  public static final String cXS = acfp.m(2131709635);
  private float GO = 200.0F;
  public float GP = 333.60001F;
  public float GQ = 333.60001F;
  private float GR = 497.0F;
  private ImageView IY;
  private PickerBarLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout;
  private Float jdField_a_of_type_JavaLangFloat = Float.valueOf(1.0F);
  private ayrt jdField_b_of_type_Ayrt;
  private aysi jdField_b_of_type_Aysi;
  private ValueAnimator d;
  private boolean dAA;
  private boolean dAD;
  private int eMK = 58;
  private View jP;
  private WeakReference<a> mListenerRef;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  Property<PickerContainer, Float> n = new aysu(this, Float.class, "containerAlpha");
  
  public PickerContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PickerContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PickerContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void V(boolean paramBoolean, long paramLong)
  {
    if (this.d != null)
    {
      this.d.cancel();
      this.d.removeAllUpdateListeners();
      this.d = null;
    }
    float f = 1.0F;
    if (!paramBoolean) {
      f = 0.0F;
    }
    this.d = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.n, new float[] { this.jdField_a_of_type_JavaLangFloat.floatValue(), f }) });
    this.d.setDuration(paramLong);
    if (this.d != null)
    {
      this.d.setRepeatMode(1);
      this.d.setRepeatCount(0);
      this.d.setStartDelay(0L);
      this.d.addUpdateListener(new aysv(this));
      this.d.addListener(new aysw(this));
      this.d.start();
    }
  }
  
  private static float b(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    return paramResources.getDisplayMetrics().density * paramFloat;
  }
  
  private Float b()
  {
    return this.jdField_a_of_type_JavaLangFloat;
  }
  
  private void b(Float paramFloat)
  {
    this.jdField_a_of_type_JavaLangFloat = paramFloat;
  }
  
  public static float c(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return paramFloat;
    }
    return b(paramFloat / 2.0F, paramContext.getResources());
  }
  
  private void eTw()
  {
    if (!this.dAA) {
      return;
    }
    if (this.d != null)
    {
      this.d.cancel();
      this.d.removeAllUpdateListeners();
      this.d = null;
    }
    this.dAA = false;
  }
  
  private void gI(Context paramContext)
  {
    this.GO = c(paramContext, this.GO);
    this.GP = c(paramContext, this.GP);
    this.GQ = c(paramContext, this.GQ);
    this.GR = c(paramContext, this.GR);
    this.eMK = wja.dp2px(this.eMK, paramContext.getResources());
  }
  
  public void U(boolean paramBoolean, long paramLong)
  {
    if (this.dAA) {
      eTw();
    }
    if (paramLong > 0L)
    {
      setVisibility(0);
      V(paramBoolean, paramLong);
      return;
    }
    setAlpha(1.0F);
    if (paramBoolean)
    {
      setVisibility(0);
      return;
    }
    setVisibility(8);
  }
  
  public boolean a(EditVideoParams paramEditVideoParams, a parama)
  {
    this.mListenerRef = new WeakReference(parama);
    gI(getContext());
    this.jP = new View(getContext());
    parama = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_Ayrt = new ayrt();
    this.jdField_b_of_type_Ayrt.init(getContext());
    this.jP.setBackground(this.jdField_b_of_type_Ayrt);
    addView(this.jP, parama);
    parama = new RelativeLayout(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.bottomMargin = this.eMK;
    addView(parama, localLayoutParams);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout = new PickerBarLayout(getContext());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.a(paramEditVideoParams, getContext(), this);
    this.GR = (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.Sh() * 60 + 80 + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.Sh() * 5 + 22 + 70);
    this.GR = c(getContext(), this.GR);
    paramEditVideoParams = new RelativeLayout.LayoutParams((int)this.GO, (int)this.GR);
    paramEditVideoParams.addRule(11);
    paramEditVideoParams.addRule(15);
    parama.addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout, paramEditVideoParams);
    this.IY = new ImageView(getContext());
    paramEditVideoParams = new RelativeLayout.LayoutParams((int)this.GP, (int)this.GQ);
    paramEditVideoParams.addRule(13);
    this.jdField_b_of_type_Aysi = new aysi();
    this.jdField_b_of_type_Aysi.a(getContext(), this.GP, this.GQ, 1.2F);
    this.IY.setBackground(this.jdField_b_of_type_Aysi);
    parama.addView(this.IY, paramEditVideoParams);
    return true;
  }
  
  public void afC(int paramInt)
  {
    if (paramInt == 1) {
      if (this.jdField_b_of_type_Ayrt != null)
      {
        this.jdField_b_of_type_Ayrt.stop();
        this.jdField_b_of_type_Ayrt.ZN(false);
        this.jdField_b_of_type_Ayrt.afv(1);
        this.jdField_b_of_type_Ayrt.start();
      }
    }
    while ((paramInt == 4) || (this.jdField_b_of_type_Ayrt == null)) {
      return;
    }
    this.jdField_b_of_type_Ayrt.stop();
    this.jdField_b_of_type_Ayrt.ZN(false);
    this.jdField_b_of_type_Ayrt.afv(2);
    this.jdField_b_of_type_Ayrt.start();
  }
  
  public void afD(int paramInt) {}
  
  public void afF(int paramInt)
  {
    if (paramInt == 4)
    {
      this.mUIHandler.removeCallbacksAndMessages(null);
      if (this.jdField_b_of_type_Aysi != null)
      {
        this.jdField_b_of_type_Aysi.stop();
        if ((this.jdField_b_of_type_Aysi.Sf() == 1) || (this.jdField_b_of_type_Aysi.Sf() == 3))
        {
          this.jdField_b_of_type_Aysi.afv(2);
          this.jdField_b_of_type_Aysi.start();
        }
      }
    }
  }
  
  public void afG(int paramInt) {}
  
  public void cE(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.cD(paramInt, paramBoolean);
    }
  }
  
  public void f(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PickerContainer", 2, "onSelected: index:" + paramInt + " text:" + paramString + " bstart:" + paramBoolean1 + " bend:" + paramBoolean2);
    }
    a locala = (a)this.mListenerRef.get();
    if (locala != null)
    {
      if (!paramBoolean1) {
        break label128;
      }
      this.dAD = true;
      locala.eL(paramInt, paramString);
    }
    for (;;)
    {
      this.mUIHandler.removeCallbacksAndMessages(null);
      this.mUIHandler.postDelayed(new PickerContainer.4(this, paramString), 300L);
      return;
      label128:
      if (paramBoolean2)
      {
        this.dAD = false;
        locala.eN(paramInt, paramString);
      }
      else
      {
        locala.eM(paramInt, paramString);
      }
    }
  }
  
  public void unInit()
  {
    this.mListenerRef = null;
    if (this.jdField_b_of_type_Aysi != null)
    {
      this.jdField_b_of_type_Aysi.unInit();
      this.jdField_b_of_type_Aysi = null;
    }
    if (this.jdField_b_of_type_Ayrt != null)
    {
      this.jdField_b_of_type_Ayrt.unInit();
      this.jdField_b_of_type_Ayrt = null;
    }
    this.jP = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.unInit();
    }
    this.IY = null;
    if (this.mUIHandler != null) {
      this.mUIHandler.removeCallbacksAndMessages(null);
    }
    if (this.d != null)
    {
      this.d.cancel();
      this.d.removeAllUpdateListeners();
      this.d = null;
    }
    this.n = null;
  }
  
  public static abstract interface a
  {
    public abstract void eL(int paramInt, String paramString);
    
    public abstract void eM(int paramInt, String paramString);
    
    public abstract void eN(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer
 * JD-Core Version:    0.7.0.1
 */