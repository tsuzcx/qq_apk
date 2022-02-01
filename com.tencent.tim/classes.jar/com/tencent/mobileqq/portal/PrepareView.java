package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.AnimatorSet.Builder;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import wja;

public class PrepareView
  extends RelativeLayout
{
  private ImageView Cl;
  private ImageView Cm;
  private ImageView Cn;
  private ImageView Co;
  private ImageView Cp;
  private ImageView Cq;
  private ImageView Cr;
  private ImageView Cs;
  private ImageView Ct;
  public List<PortalManager.LogoConfig> EJ;
  private TextView WQ;
  private TextView WR;
  private TextView WS;
  private TextView WT;
  private TextView WU;
  private TextView WV;
  private TextView WW;
  private TextView WX;
  private TextView WY;
  private TextView WZ;
  Animator a;
  AnimatorSet jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet;
  private ImageSwitchAnimView jdField_b_of_type_ComTencentMobileqqPortalImageSwitchAnimView;
  AnimatorSet jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet;
  private ImageAlphaSwitchView jdField_c_of_type_ComTencentMobileqqPortalImageAlphaSwitchView;
  private ImageShakeAnimView jdField_c_of_type_ComTencentMobileqqPortalImageShakeAnimView;
  AnimatorSet d;
  private CountDownTimer f;
  private RelativeLayout lu;
  private RelativeLayout lv;
  private Context mContext;
  public int mMode = -1;
  public long scrollTime;
  
  public PrepareView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  private void axz()
  {
    if ((this.Cq == null) || (this.Cs == null) || (this.Cr == null)) {}
    do
    {
      return;
      ObjectAnimator localObjectAnimator1;
      ObjectAnimator localObjectAnimator2;
      if (this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet == null)
      {
        ViewHelper.setPivotX(this.Cq, 0.5F);
        ViewHelper.setPivotY(this.Cq, 0.2F);
        localObjectAnimator1 = ObjectAnimator.ofFloat(this.Cq, "rotation", new float[] { 0.0F, -10.0F, 10.0F, -6.0F, 0.0F });
        localObjectAnimator1.setDuration(720L);
        localObjectAnimator2 = ObjectAnimator.ofFloat(this.Cq, "translationY", new float[] { 0.0F, 8.0F, -8.0F, 4.0F, 0.0F });
        localObjectAnimator2.setDuration(720L);
        this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet = new AnimatorSet();
        this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
      }
      if (this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet == null)
      {
        ViewHelper.setPivotX(this.Cs, 0.5F);
        ViewHelper.setPivotY(this.Cs, 0.2F);
        localObjectAnimator1 = ObjectAnimator.ofFloat(this.Cs, "rotation", new float[] { 0.0F, 3.0F, -3.0F, 2.0F, 0.0F });
        localObjectAnimator1.setDuration(720L);
        localObjectAnimator2 = ObjectAnimator.ofFloat(this.Cs, "translationY", new float[] { 0.0F, 8.0F, -8.0F, 4.0F, 0.0F });
        localObjectAnimator2.setDuration(720L);
        this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet = new AnimatorSet();
        this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
      }
      if (this.a == null)
      {
        localObjectAnimator1 = ObjectAnimator.ofFloat(this.Cr, "translationY", new float[] { 0.0F, 8.0F, -8.0F, 4.0F, 0.0F });
        localObjectAnimator1.setDuration(720L);
        this.a = localObjectAnimator1;
      }
      if ((this.Cl != null) && (this.d == null) && (this.mMode == 1))
      {
        localObjectAnimator1 = ObjectAnimator.ofFloat(this.Cl, "translationY", new float[] { 0.0F, 8.0F, -8.0F, 4.0F, 0.0F });
        localObjectAnimator1.setDuration(720L);
        localObjectAnimator2 = ObjectAnimator.ofFloat(this.Cl, "scaleX", new float[] { 1.0F, 0.99F, 1.02F, 0.99F, 1.0F });
        localObjectAnimator2.setDuration(720L);
        this.d = new AnimatorSet();
        this.d.play(localObjectAnimator1).with(localObjectAnimator2);
      }
    } while ((this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet == null) || (this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet == null));
    this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet.cancel();
    this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet.start();
    this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet.cancel();
    this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet.start();
    this.a.cancel();
    this.a.start();
    if ((this.mMode == 1) && (this.d != null) && (this.Cl != null))
    {
      this.d.cancel();
      this.d.start();
    }
    this.jdField_c_of_type_ComTencentMobileqqPortalImageShakeAnimView.startAnim();
  }
  
  private Bitmap n(int paramInt)
  {
    int j = 0;
    int i;
    if (this.mMode == 1) {
      if (paramInt == 0) {
        i = 2130846212;
      }
    }
    while (i != 0)
    {
      Drawable localDrawable = getResources().getDrawable(i);
      if ((localDrawable instanceof SkinnableBitmapDrawable))
      {
        return ((SkinnableBitmapDrawable)localDrawable).getBitmap();
        i = j;
        if (paramInt == 1)
        {
          i = 2130846213;
          continue;
          if (this.mMode != 2)
          {
            i = j;
            if (this.mMode != 3) {
              break;
            }
          }
          else if (paramInt == 0)
          {
            i = 2130846172;
          }
          else
          {
            i = j;
            if (paramInt == 1) {
              i = 2130846173;
            }
          }
        }
      }
      else if ((localDrawable instanceof BitmapDrawable))
      {
        return ((BitmapDrawable)localDrawable).getBitmap();
      }
    }
    return null;
  }
  
  public void dEF()
  {
    if (this.mMode < 0) {}
    while (this.f == null) {
      return;
    }
    this.f.cancel();
    this.f = null;
  }
  
  public void dEG()
  {
    axz();
  }
  
  public void dEw()
  {
    try
    {
      if (this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet != null)
      {
        if (this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet.isRunning()) {
          this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet.cancel();
        }
        this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet = null;
      }
      if (this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet != null)
      {
        if (this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet.isRunning()) {
          this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet.cancel();
        }
        this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet = null;
      }
      if (this.a != null)
      {
        if (this.a.isRunning()) {
          this.a.cancel();
        }
        this.a = null;
      }
      if (this.d != null)
      {
        if (this.d.isRunning()) {
          this.d.cancel();
        }
        this.d = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      localThrowable.printStackTrace();
    }
  }
  
  public boolean kP(int paramInt)
  {
    dEF();
    removeAllViews();
    if (paramInt == 1)
    {
      LayoutInflater.from(this.mContext).inflate(2131561374, this, true);
      this.Cl = ((ImageView)findViewById(2131370900));
      this.Cm = ((ImageView)findViewById(2131372192));
    }
    for (;;)
    {
      this.lu = ((RelativeLayout)findViewById(2131379684));
      this.WQ = ((TextView)findViewById(2131379680));
      this.WR = ((TextView)findViewById(2131379681));
      this.WS = ((TextView)findViewById(2131379683));
      this.lv = ((RelativeLayout)findViewById(2131366157));
      this.WT = ((TextView)findViewById(2131379662));
      this.WU = ((TextView)findViewById(2131379663));
      this.WV = ((TextView)findViewById(2131379664));
      this.WW = ((TextView)findViewById(2131379665));
      this.WX = ((TextView)findViewById(2131369329));
      this.WY = ((TextView)findViewById(2131369330));
      this.WZ = ((TextView)findViewById(2131370490));
      Object localObject = Typeface.createFromAsset(this.mContext.getAssets(), "fonts/DS-DIGIB.TTF");
      this.WQ.setTypeface((Typeface)localObject);
      this.WR.setTypeface((Typeface)localObject);
      this.WS.setTypeface((Typeface)localObject);
      this.WT.setTypeface((Typeface)localObject);
      this.WU.setTypeface((Typeface)localObject);
      this.WV.setTypeface((Typeface)localObject);
      this.WW.setTypeface((Typeface)localObject);
      this.WX.setTypeface((Typeface)localObject);
      this.WY.setTypeface((Typeface)localObject);
      this.WZ.setTypeface((Typeface)localObject);
      this.Cn = ((ImageView)findViewById(2131370346));
      this.Co = ((ImageView)findViewById(2131377274));
      this.Cp = ((ImageView)findViewById(2131382307));
      this.Cq = ((ImageView)findViewById(2131363391));
      this.Cs = ((ImageView)findViewById(2131377570));
      this.Cr = ((ImageView)findViewById(2131377569));
      this.Ct = ((ImageView)findViewById(2131365469));
      localObject = (RelativeLayout.LayoutParams)this.Ct.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).topMargin = ImmersiveUtils.getStatusBarHeight(this.mContext);
        this.Ct.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = new RelativeLayout.LayoutParams(wja.dp2px(475.0F, getResources()), wja.dp2px(300.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      addView(this.jdField_c_of_type_ComTencentMobileqqPortalImageShakeAnimView, 0, (ViewGroup.LayoutParams)localObject);
      return true;
      if ((paramInt != 2) && (paramInt != 3)) {
        break;
      }
      LayoutInflater.from(this.mContext).inflate(2131561373, this, true);
      this.jdField_b_of_type_ComTencentMobileqqPortalImageSwitchAnimView = ((ImageSwitchAnimView)findViewById(2131370900));
      this.jdField_c_of_type_ComTencentMobileqqPortalImageAlphaSwitchView = ((ImageAlphaSwitchView)findViewById(2131372192));
    }
    return false;
  }
  
  public void setBackground(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6)
  {
    if (this.mMode < 0) {
      return;
    }
    if (paramBitmap1 != null) {}
    for (;;)
    {
      try
      {
        paramBitmap2 = getBackground();
        if ((paramBitmap2 == null) || (!(paramBitmap2 instanceof BitmapDrawable))) {
          continue;
        }
        paramBitmap2 = ((BitmapDrawable)paramBitmap2).getBitmap();
        if (paramBitmap2 != paramBitmap1) {
          continue;
        }
      }
      catch (Throwable paramBitmap1)
      {
        continue;
        this.Cn.setImageBitmap(paramBitmap3);
        continue;
      }
      if (paramBitmap3 != null) {}
      try
      {
        paramBitmap1 = this.Cn.getDrawable();
        if ((paramBitmap1 == null) || (!(paramBitmap1 instanceof BitmapDrawable))) {
          continue;
        }
        paramBitmap1 = ((BitmapDrawable)paramBitmap1).getBitmap();
        if (paramBitmap1 != paramBitmap3) {
          continue;
        }
      }
      catch (Throwable paramBitmap1)
      {
        continue;
        this.Co.setImageBitmap(paramBitmap4);
        continue;
      }
      if (paramBitmap4 != null) {}
      try
      {
        paramBitmap1 = this.Co.getDrawable();
        if ((paramBitmap1 == null) || (!(paramBitmap1 instanceof BitmapDrawable))) {
          break label199;
        }
        paramBitmap1 = ((BitmapDrawable)paramBitmap1).getBitmap();
        if (paramBitmap1 != paramBitmap4) {
          break label199;
        }
      }
      catch (Throwable paramBitmap1)
      {
        continue;
        this.Cp.setImageResource(2130846191);
      }
      if (paramBitmap5 == null) {
        break label215;
      }
      paramBitmap1 = this.Cp.getDrawable();
      if ((paramBitmap1 != null) && ((paramBitmap1 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap1).getBitmap() == paramBitmap5)) {
        break;
      }
      this.Cp.setImageBitmap(paramBitmap5);
      return;
      super.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap1));
    }
    label199:
    label215:
    return;
  }
  
  public void setLogo(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (this.mMode == 1) {
      if ((this.Cl != null) && (this.Cm != null)) {
        break label53;
      }
    }
    label53:
    label186:
    label205:
    label230:
    for (;;)
    {
      return;
      if (((this.mMode != 2) && (this.mMode != 3)) || ((this.jdField_b_of_type_ComTencentMobileqqPortalImageSwitchAnimView != null) && (this.jdField_c_of_type_ComTencentMobileqqPortalImageAlphaSwitchView != null)))
      {
        Bitmap localBitmap = paramBitmap1;
        if (paramBitmap1 == null) {
          localBitmap = n(0);
        }
        if (localBitmap != null)
        {
          if (this.jdField_b_of_type_ComTencentMobileqqPortalImageSwitchAnimView != null)
          {
            if (this.mMode != 3) {
              break label186;
            }
            this.jdField_b_of_type_ComTencentMobileqqPortalImageSwitchAnimView.aa(localBitmap);
          }
          if ((this.Cl != null) && (this.mMode == 1)) {
            this.Cl.setImageBitmap(localBitmap);
          }
        }
        paramBitmap1 = paramBitmap2;
        if (paramBitmap2 == null) {
          paramBitmap1 = n(1);
        }
        if (paramBitmap1 == null) {
          break;
        }
        if (this.jdField_c_of_type_ComTencentMobileqqPortalImageAlphaSwitchView != null)
        {
          if (this.mMode != 3) {
            break label205;
          }
          this.jdField_c_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setGravity(3);
          this.jdField_c_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.Z(paramBitmap1);
        }
        for (;;)
        {
          if ((this.Cm == null) || (this.mMode != 1)) {
            break label230;
          }
          this.Cm.setImageBitmap(paramBitmap1);
          return;
          if (this.mMode != 2) {
            break;
          }
          this.jdField_b_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(localBitmap);
          break;
          if (this.mMode == 2)
          {
            this.jdField_c_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setGravity(3);
            this.jdField_c_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setImage(paramBitmap1);
          }
        }
      }
    }
  }
  
  public void setLogoConfigList(List<PortalManager.LogoConfig> paramList)
  {
    this.EJ = paramList;
    if ((paramList != null) && (QLog.isColorLevel()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        PortalManager.LogoConfig localLogoConfig = (PortalManager.LogoConfig)paramList.get(i);
        if (localLogoConfig != null) {
          QLog.d("PortalManager", 2, "prepareview, setLogoConfigList, index=" + i + ", p=" + localLogoConfig.toString());
        }
        i += 1;
      }
    }
  }
  
  public void setMode(int paramInt)
  {
    if (((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) || (this.mMode == paramInt)) {}
    while (!kP(paramInt)) {
      return;
    }
    this.mMode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PrepareView
 * JD-Core Version:    0.7.0.1
 */