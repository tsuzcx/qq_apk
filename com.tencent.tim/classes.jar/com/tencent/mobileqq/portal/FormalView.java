package com.tencent.mobileqq.portal;

import acfp;
import akzo;
import akzp;
import akzq;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wja;

public class FormalView
  extends RelativeLayout
  implements Handler.Callback
{
  private static final int[] mp = new int[0];
  private ImageView Cd;
  private ImageView Ce;
  private ImageView Cf;
  private ImageView Cg;
  private ImageView Ch;
  private ImageView Ci;
  private ImageView Cj;
  private ImageView Ck;
  public List<PortalManager.LogoConfig> EJ;
  public List<PortalManager.ComboNumber> EK;
  public List<Integer> EL = new ArrayList();
  private View FF;
  private View FG;
  private View FH;
  private TextView WO;
  private TextView WP;
  public HongbaoCaidanRainView a;
  private ImageAlphaSwitchView jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView;
  private ImageShakeAnimView jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView;
  private ImageSwitchAnimView jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView;
  private PortalManager jdField_a_of_type_ComTencentMobileqqPortalPortalManager;
  private ProgressViewYellow jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow;
  private StrokeTextView jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView;
  private long afG;
  private long afH;
  public long afI;
  private StrokeTextView b;
  private String bUU = "";
  private StrokeTextView c;
  public boolean cvu;
  public boolean cvv;
  private boolean cvw;
  private StrokeTextView d;
  public int dqr;
  private int dqs = -1;
  private int dqt = -1;
  private int dqu = -1;
  ValueAnimator jdField_e_of_type_ComNineoldandroidsAnimationValueAnimator = null;
  private StrokeTextView jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView;
  private StrokeTextView f;
  private LinearLayout jP;
  private Context mContext;
  private Handler mHandler;
  private View mProgressContainer;
  public Map<Integer, PortalManager.ComboNumber> mq = new HashMap();
  private AnimationDrawable s;
  public long scrollTime;
  private AnimationSet x;
  private AnimationSet y;
  
  public FormalView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    LayoutInflater.from(paramContext).inflate(2131561372, this, true);
    paramContext = Typeface.createFromAsset(this.mContext.getAssets(), "fonts/HuNan-CC.ttf");
    this.d = ((StrokeTextView)findViewById(2131364960));
    this.d.setTypeface(paramContext);
    this.d.setInnerTextColor(-13490398);
    this.d.setStrokeColor(-1);
    this.d.setStrokeSize(wja.dp2px(4.0F, getResources()));
    this.d.setStrokeEnable(true);
    this.d.setShadow(wja.dp2px(2.0F, getResources()), 0.0F, wja.dp2px(1.0F, getResources()), 1073741824);
    this.Ce = ((ImageView)findViewById(2131363583));
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131368605));
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(paramContext);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-13490398);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(-1);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(wja.dp2px(4.0F, getResources()));
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setShadowLayer(wja.dp2px(2.0F, getResources()), 0.0F, wja.dp2px(1.0F, getResources()), 1711276032);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131368598));
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-6413557);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setShadow(wja.dp2px(4.0F, getResources()), 0.0F, 0.0F, -135991);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.f = ((StrokeTextView)findViewById(2131376818));
    this.f.setInnerTextColor(-6413557);
    this.f.setStrokeEnable(false);
    this.f.setShadow(wja.dp2px(4.0F, getResources()), 0.0F, 0.0F, -135991);
    this.f.setTypeface(Typeface.defaultFromStyle(1));
    this.f.setText(acfp.m(2131706424));
    this.b = ((StrokeTextView)findViewById(2131368603));
    this.b.setInnerTextColor(Color.parseColor("#9E230B"));
    this.b.setStrokeColor(Color.parseColor("#FBEACD"));
    this.b.setStrokeSize(wja.dp2px(2.0F, getResources()));
    this.b.setTextSize(1, 24.0F);
    this.b.setStrokeEnable(true);
    this.Cf = ((ImageView)findViewById(2131368596));
    this.c = ((StrokeTextView)findViewById(2131372349));
    this.c.setInnerTextColor(Color.parseColor("#9E230B"));
    this.c.setStrokeColor(Color.parseColor("#FBEACD"));
    this.c.setStrokeSize(wja.dp2px(2.0F, getResources()));
    this.c.setStrokeEnable(true);
    this.Cd = ((ImageView)findViewById(2131380437));
    this.jP = ((LinearLayout)findViewById(2131379682));
    this.FF = findViewById(2131376819);
    this.WP = ((TextView)findViewById(2131363734));
    this.WO = ((TextView)findViewById(2131379685));
    paramContext = Typeface.createFromAsset(this.mContext.getAssets(), "fonts/DS-DIGIB.TTF");
    this.WO.setTypeface(paramContext);
    this.WO.setGravity(17);
    this.dqt = wja.dp2px(70.0F, getResources());
    this.Cg = ((ImageView)findViewById(2131368995));
    this.Ch = ((ImageView)findViewById(2131368996));
    this.dqu = getResources().getDimensionPixelSize(2131298656);
    this.mProgressContainer = findViewById(2131373676);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow = ((ProgressViewYellow)findViewById(2131373668));
    this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView = ((ImageAlphaSwitchView)findViewById(2131373685));
    this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setGravity(17);
    this.Ci = ((ImageView)findViewById(2131373686));
    this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = ((ImageSwitchAnimView)findViewById(2131373682));
    this.FG = findViewById(2131373683);
    this.FH = findViewById(2131378509);
    this.Cj = ((ImageView)findViewById(2131378510));
    this.Ck = ((ImageView)findViewById(2131378511));
    int i = wja.dp2px(342.0F, getResources());
    wja.dp2px(164.0F, getResources());
    this.dqs = wja.dp2px(40.0F, getResources());
    paramContext = new RelativeLayout.LayoutParams(i, wja.dp2px(180.0F, getResources()));
    paramContext.addRule(14);
    paramContext.topMargin = (-this.dqs);
    addView(this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView, 0, paramContext);
    this.mHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager = ((PortalManager)((BaseActivity)this.mContext).app.getManager(79));
  }
  
  private void dEs()
  {
    if (this.s == null)
    {
      this.s = new AnimationDrawable();
      int i = 0;
      try
      {
        while (i < mp.length)
        {
          this.s.addFrame(getResources().getDrawable(mp[i]), 30);
          i += 1;
        }
        this.d.clearAnimation();
      }
      catch (Throwable localThrowable)
      {
        this.s.setOneShot(false);
        this.Ce.setBackgroundDrawable(this.s);
        this.s.start();
      }
    }
    this.d.setVisibility(8);
    this.Cf.clearAnimation();
    this.Cf.setVisibility(8);
    this.Ce.setVisibility(0);
  }
  
  public void Ny(boolean paramBoolean)
  {
    if ((paramBoolean) && (QLog.isColorLevel())) {
      QLog.d("FormalView", 2, "readyGo, show=" + paramBoolean);
    }
    View localView = findViewById(2131368605);
    if (paramBoolean)
    {
      if (this.y == null)
      {
        AnimationSet localAnimationSet = new AnimationSet(true);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.8F, 1.0F, 1.85F, 1.0F, 1, 0.5F, 1, 0.5F);
        localAnimationSet.setInterpolator(new OvershootInterpolator(1.0F));
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.setDuration(400L);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setAnimationListener(new akzo(this, localView));
        this.y = localAnimationSet;
      }
      localView.startAnimation(this.y);
    }
    do
    {
      return;
      localView.clearAnimation();
      localView.setVisibility(8);
    } while (this.f == null);
    this.f.setVisibility(8);
  }
  
  public void a(long paramLong1, long paramLong2, CharSequence paramCharSequence)
  {
    this.mProgressContainer.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.ax(paramLong1, paramLong2);
    this.FF.setVisibility(8);
    this.WP.setVisibility(8);
    this.jP.setVisibility(0);
    if (this.dqr == 1) {
      this.FH.setVisibility(0);
    }
    String str = paramCharSequence.toString();
    if (!this.bUU.equals(str))
    {
      this.WO.setText(paramCharSequence);
      this.bUU = str;
    }
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = wja.dp2px(81.0F, getResources());
    paramCharSequence = (ViewGroup.MarginLayoutParams)this.FG.getLayoutParams();
    paramCharSequence.leftMargin = ((int)((i - j) * (paramLong2 - paramLong1) / paramLong2));
    this.FG.setLayoutParams(paramCharSequence);
  }
  
  public void dEr()
  {
    Ny(false);
  }
  
  public void dEt() {}
  
  @TargetApi(11)
  public void dEu()
  {
    this.jdField_e_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
    this.jdField_e_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new akzp(this));
    this.jdField_e_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(new akzq(this));
    this.jdField_e_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
    this.jdField_e_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_e_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  public void dEv()
  {
    this.cvu = true;
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView.getLayoutParams()).topMargin = 0;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Cg.getLayoutParams();
    localLayoutParams.leftMargin = (-this.dqt);
    this.Cg.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.Ch.getLayoutParams();
    localLayoutParams.rightMargin = (-this.dqt);
    this.Ch.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.mProgressContainer.getLayoutParams();
    localLayoutParams.topMargin = 0;
    this.mProgressContainer.setLayoutParams(localLayoutParams);
  }
  
  public void dEw()
  {
    if (this.jdField_e_of_type_ComNineoldandroidsAnimationValueAnimator != null) {}
    try
    {
      if (this.jdField_e_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()) {
        this.jdField_e_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      }
      this.jdField_e_of_type_ComNineoldandroidsAnimationValueAnimator = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      localThrowable.printStackTrace();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.cvv) {
        dEs();
      }
    }
  }
  
  public void mA(boolean paramBoolean) {}
  
  public void setBackground(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 != null))
    {
      paramBitmap1 = getBackground();
      if ((paramBitmap1 == null) || (!(paramBitmap1 instanceof BitmapDrawable)) || (((BitmapDrawable)paramBitmap1).getBitmap() != paramBitmap2)) {}
    }
    else
    {
      return;
    }
    super.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap2));
  }
  
  public void setCloudBmp(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 == null))
    {
      QLog.d("PortalManager", 1, "FormalView setCloudBmp, left or right is null");
      return;
    }
    this.Cg.setImageBitmap(paramBitmap1);
    this.Ch.setImageBitmap(paramBitmap2);
  }
  
  public void setComboNumberList(List<PortalManager.ComboNumber> paramList)
  {
    this.EK = paramList;
    this.EL.clear();
    this.mq.clear();
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Collections.sort(paramList, new a(null));
    int i = 0;
    while (i < paramList.size())
    {
      PortalManager.ComboNumber localComboNumber = (PortalManager.ComboNumber)paramList.get(i);
      if (localComboNumber != null)
      {
        this.EL.add(Integer.valueOf(localComboNumber.number));
        this.mq.put(Integer.valueOf(localComboNumber.number), localComboNumber);
        if (QLog.isColorLevel()) {
          QLog.d("FormalView", 2, "setComboNumberList, index=" + i + ", p=" + localComboNumber.toString());
        }
      }
      i += 1;
    }
    ThreadManager.postImmediately(new FormalView.4(this, paramList), null, true);
  }
  
  public void setHBSpeed(int paramInt) {}
  
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
          QLog.d("FormalView", 2, "setLogoConfigList, index=" + i + ", p=" + localLogoConfig.toString());
        }
        i += 1;
      }
    }
  }
  
  public void setProgressLogo(Bitmap paramBitmap, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (QLog.isColorLevel()) {
      QLog.d("FormalView", 2, "setProgressLogo, bmp=" + paramBitmap + ", needSwitch=" + paramBoolean);
    }
    if (paramBitmap != null)
    {
      if (this.dqr == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(paramBitmap);
        return;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.aa(paramBitmap);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(paramBitmap);
      return;
    }
    if (this.dqr == 1) {
      paramBitmap = getResources().getDrawable(2130846212);
    }
    for (;;)
    {
      if ((paramBitmap instanceof SkinnableBitmapDrawable)) {
        localBitmap = ((SkinnableBitmapDrawable)paramBitmap).getBitmap();
      }
      for (;;)
      {
        if (localBitmap == null) {
          break label189;
        }
        if (this.dqr != 1) {
          break label191;
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(localBitmap);
        return;
        if ((this.dqr != 2) && (this.dqr != 3)) {
          break label213;
        }
        paramBitmap = getResources().getDrawable(2130846172);
        break;
        if ((paramBitmap instanceof BitmapDrawable)) {
          localBitmap = ((BitmapDrawable)paramBitmap).getBitmap();
        }
      }
      label189:
      break;
      label191:
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.aa(localBitmap);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(localBitmap);
      return;
      label213:
      paramBitmap = null;
    }
  }
  
  public void setProgressNameBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FormalView", 2, "setProgressNameBitmap, name=" + paramBitmap1 + ", bg=" + paramBitmap2 + ", needSwitch=" + paramBoolean);
    }
    if (paramBitmap1 == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.Z(paramBitmap1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setImage(paramBitmap1);
  }
  
  public void setSmallIcon(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FormalView", 2, "setSmallIcon, icon=" + paramBitmap1 + ", name=" + paramBitmap2 + ", mode=" + this.dqr);
    }
    this.Ck.setImageBitmap(paramBitmap2);
    this.Cj.setImageBitmap(paramBitmap1);
  }
  
  public void w(int paramInt, String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (l - this.afI <= 500L) {
      if (QLog.isColorLevel()) {
        QLog.d("FormalView", 2, "combo, no network last time = " + this.afI);
      }
    }
    do
    {
      return;
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.WP.setVisibility(8);
      this.FF.setVisibility(8);
      this.Cd.setVisibility(8);
      Ny(false);
      if (l - this.afG > 600L)
      {
        this.afG = l;
        this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView.startAnim();
      }
    } while (System.currentTimeMillis() - this.afH < 500L);
    Object localObject1;
    Object localObject2;
    if (this.x == null)
    {
      this.x = new AnimationSet(true);
      localObject1 = new AlphaAnimation(0.0F, 1.0F);
      localObject2 = new ScaleAnimation(2.4F, 1.0F, 2.4F, 1.0F, 1, 0.5F, 1, 0.5F);
      OvershootInterpolator localOvershootInterpolator = new OvershootInterpolator(1.0F);
      this.x.setInterpolator(localOvershootInterpolator);
      this.x.addAnimation((Animation)localObject1);
      this.x.addAnimation((Animation)localObject2);
      this.x.setDuration(400L);
      this.x.setFillAfter(true);
    }
    this.x.reset();
    this.Ce.setVisibility(8);
    this.cvw = false;
    if (this.EL.contains(Integer.valueOf(paramInt)))
    {
      this.cvw = true;
      this.d.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.Cf.setVisibility(0);
      localObject1 = (PortalManager.ComboNumber)this.mq.get(Integer.valueOf(paramInt));
      if (localObject1 == null)
      {
        this.cvw = false;
        QLog.d("FormalView", 1, "combo, get CN from map return null, combo=" + paramInt);
      }
    }
    else
    {
      if (this.cvw) {
        break label777;
      }
      this.cvw = false;
      this.d.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.Cf.setVisibility(8);
      if (paramInt != 1) {
        break label708;
      }
      this.d.setText(acfp.m(2131706425));
      label436:
      this.Cf.clearAnimation();
      this.d.startAnimation(this.x);
      label454:
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramString);
      }
      this.mHandler.removeMessages(1);
      paramString = this.mHandler;
      if (!this.cvw) {
        break label831;
      }
    }
    label777:
    label831:
    for (l = 2000L;; l = 800L)
    {
      paramString.sendEmptyMessageDelayed(1, l);
      this.cvv = true;
      return;
      localObject2 = PortalManager.d(((PortalManager.ComboNumber)localObject1).numberImageMD5, null);
      if (localObject2 == null)
      {
        this.cvw = false;
        QLog.d("FormalView", 1, "combo, get bmp from PM return null, combo=" + paramInt);
      }
      for (;;)
      {
        new StringBuilder().append(BaseApplicationImpl.getApplication().getFilesDir()).append(PortalManager.bUW).append(((PortalManager.ComboNumber)localObject1).flowerImageMD5).toString();
        new StringBuilder().append(BaseApplicationImpl.getApplication().getFilesDir()).append(PortalManager.bUW).append(((PortalManager.ComboNumber)localObject1).flowerImage2MD5).toString();
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.SA(3);
        }
        anot.a(((BaseActivity)this.mContext).app, "dc01440", "", "", "0X80078A9", "0X80078A9", 0, 0, ((PortalManager.ComboNumber)localObject1).number + "", "", "", "");
        break;
        this.Cf.setImageBitmap((Bitmap)localObject2);
      }
      label708:
      if (paramInt < 10)
      {
        this.d.setText(paramInt + acfp.m(2131706421));
        break label436;
      }
      this.d.setText("x" + paramInt);
      break label436;
      this.d.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.Cf.setVisibility(0);
      this.d.clearAnimation();
      this.Cf.startAnimation(this.x);
      this.afH = System.currentTimeMillis();
      break label454;
    }
  }
  
  static class a
    implements Comparator<PortalManager.ComboNumber>
  {
    public int a(PortalManager.ComboNumber paramComboNumber1, PortalManager.ComboNumber paramComboNumber2)
    {
      if (paramComboNumber1.number > paramComboNumber2.number) {
        return 1;
      }
      if (paramComboNumber1.number < paramComboNumber2.number) {
        return -1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FormalView
 * JD-Core Version:    0.7.0.1
 */