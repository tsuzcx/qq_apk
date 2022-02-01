package com.tencent.mobileqq.extendfriend.wiget;

import afsi;
import afsi.a;
import afxw;
import afyg;
import afyg.a;
import afyi;
import afyk;
import afyu;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqnm;
import arwv;
import atau.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import wja;

public class ExtendFriendVoiceView
  extends FrameLayout
  implements afyg.a, View.OnClickListener
{
  private static Map<String, WeakReference<Bitmap>> kt = new HashMap();
  private static final int[] lj = { -13900833, -37464, -12331403, -5544982 };
  private static final int[] lk = { -14167603, -1350502, -12728981, -6464553 };
  private View Cs;
  private View Ct;
  private View Cu;
  private View Cv;
  private TextView RT;
  private boolean SD;
  private long XU;
  private long XV;
  private afyg jdField_a_of_type_Afyg;
  private afyu jdField_a_of_type_Afyu;
  private a jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView$a;
  private int cVs;
  private final int cVt;
  public boolean cbQ;
  private boolean cbR;
  private LottieDrawable i;
  private BaseActivity mActivity;
  private boolean mAnimating;
  private String mMD5;
  Paint mMaskPaint;
  private int mMode = 1;
  private String mVoiceUrl;
  
  public ExtendFriendVoiceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendVoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.cVt = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qq).getInteger(0, 0);
    LayoutInflater.from(paramContext).inflate(2131561350, this, true);
    this.Cs = findViewById(2131382068);
    this.Ct = findViewById(2131369083);
    this.RT = ((TextView)findViewById(2131381128));
    this.Cu = findViewById(2131369032);
    this.Cv = findViewById(2131369033);
    this.Cv.setOnClickListener(this);
    this.Cv.setOnTouchListener(afyk.A);
    ddW();
    this.jdField_a_of_type_Afyu = new afyu();
    this.jdField_a_of_type_Afyu.setDuration(3000L);
    this.jdField_a_of_type_Afyu.setRepeat(true);
    this.mMaskPaint = new Paint();
    this.mMaskPaint.setAntiAlias(true);
    this.mMaskPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
  }
  
  private Bitmap A(String paramString)
  {
    Object localObject = afxw.fe;
    if ((!TextUtils.isEmpty(paramString)) && (localObject != null) && (localObject.length > 0))
    {
      this.cVs = (paramString.toUpperCase().charAt(0) % localObject.length);
      String str = afxw.kL(localObject[this.cVs]);
      paramString = (WeakReference)kt.get(str);
      if (paramString != null) {}
      for (paramString = (Bitmap)paramString.get();; paramString = null)
      {
        if (paramString != null)
        {
          localObject = paramString;
          if (!paramString.isRecycled()) {}
        }
        else
        {
          paramString = new BitmapFactory.Options();
          paramString.inPreferredConfig = Bitmap.Config.RGB_565;
          localObject = afxw.decodeFile(str, paramString);
          kt.put(str, new WeakReference(localObject));
        }
        return localObject;
      }
    }
    return null;
  }
  
  private void ddW()
  {
    ThreadManager.post(new ExtendFriendVoiceView.1(this), 5, null, true);
  }
  
  private void ddX()
  {
    int m;
    int k;
    if ((getVisibility() == 0) && ((this.mMode == 1) || (this.mMode == 3)))
    {
      m = getWidth() - wja.dp2px(22.0F, getResources());
      if (m > 0)
      {
        k = wja.dp2px(110.0F, getResources());
        if ((this.Cv == null) || (this.Cv.getVisibility() != 0)) {
          break label235;
        }
      }
    }
    label235:
    for (int j = wja.dp2px(33.0F, getResources());; j = 0)
    {
      m = m - k - j;
      int n = (int)(m * Math.min((float)this.XU / (float)this.XV, 1.0F));
      if ((n >= 0) && (this.Cs != null))
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.Cs.getLayoutParams();
        localLayoutParams.width = (j + k + n);
        this.Cs.setLayoutParams(localLayoutParams);
        post(new ExtendFriendVoiceView.2(this));
        QLog.d("ExtendFriendVoiceView", 2, String.format("updateBubbleSize mVoiceDuration=%s mMaxVoiceDuration=%s maxWidth=%s increaseWidth=%s layoutParams.width=%s this=%s", new Object[] { Long.valueOf(this.XU), Long.valueOf(this.XV), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(localLayoutParams.width), this }));
      }
      return;
    }
  }
  
  private void hZ(int paramInt1, int paramInt2)
  {
    if (this.Cs != null)
    {
      int j = wja.dp2px(50.0F, getResources());
      GradientDrawable localGradientDrawable1 = afyi.a(paramInt1, j, j, j, j);
      GradientDrawable localGradientDrawable2 = afyi.a(paramInt2, j, j, j, j);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
      localStateListDrawable.addState(new int[0], localGradientDrawable1);
      this.Cs.setBackgroundDrawable(localStateListDrawable);
    }
  }
  
  public void IK(boolean paramBoolean)
  {
    this.cbR = paramBoolean;
    if ((paramBoolean) && (this.Cs != null))
    {
      int j = (int)(getContext().getResources().getDisplayMetrics().density * 20.0F);
      wja.i(this.Cs, j, j, j, j);
    }
  }
  
  public void Iw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("onFocusChanged focused=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (!paramBoolean) {
      aRx();
    }
  }
  
  public void Nm(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("onDownloadFailed errCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    aRx();
  }
  
  public void aRx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("stopVoice mVoiceUrl=%s", new Object[] { this.mVoiceUrl }));
    }
    if (this.jdField_a_of_type_Afyg != null) {}
    try
    {
      this.jdField_a_of_type_Afyg.stop();
      this.SD = false;
      stopAnimation();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendVoiceView", 1, "stopVoice fail.");
    }
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("playerCompletion mVoiceUrl=%s", new Object[] { this.mVoiceUrl }));
    }
    ThreadManager.getUIHandler().post(new ExtendFriendVoiceView.3(this));
    if (this.jdField_a_of_type_Afyg != null) {
      this.jdField_a_of_type_Afyg.abandonAudioFocus();
    }
  }
  
  public void c(String paramString, int paramInt1, int paramInt2) {}
  
  public void d(String paramString, int paramInt1, int paramInt2) {}
  
  public void ddV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("playVoice mVoiceUrl=%s", new Object[] { this.mVoiceUrl }));
    }
    if (this.jdField_a_of_type_Afyg == null) {
      this.jdField_a_of_type_Afyg = new afyg(this, this.mActivity);
    }
    if (!TextUtils.isEmpty(this.mVoiceUrl)) {}
    try
    {
      this.jdField_a_of_type_Afyg.play(this.mVoiceUrl);
      this.SD = true;
      startAnimation();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendVoiceView", 1, "playVoice fail.");
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.cbQ) && ("1103".equals(ThemeUtil.curThemeId)))
    {
      if (this.mMaskPaint.getColorFilter() == null) {
        this.mMaskPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
      }
      paramCanvas.saveLayer(null, this.mMaskPaint, 31);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean isAnimating()
  {
    return this.mAnimating;
  }
  
  public boolean isPlaying()
  {
    return this.SD;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView$a != null) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView$a.dcW();
        }
        catch (Exception localException) {}
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ddX();
  }
  
  public void setActivity(BaseActivity paramBaseActivity)
  {
    this.mActivity = paramBaseActivity;
    paramBaseActivity = (afsi)this.mActivity.app.getManager(264);
    if (paramBaseActivity != null)
    {
      paramBaseActivity = paramBaseActivity.a();
      if (paramBaseActivity != null) {
        this.XV = paramBaseActivity.cTT;
      }
    }
  }
  
  public void setDeleteIconEnable(boolean paramBoolean, a parama)
  {
    View localView;
    if (this.Cv != null)
    {
      localView = this.Cv;
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView$a = parama;
      return;
    }
  }
  
  public void setMode(int paramInt)
  {
    int i5 = wja.dp2px(35.0F, getResources());
    int i4 = wja.dp2px(22.0F, getResources());
    int i3 = wja.dp2px(19.0F, getResources());
    int i2 = wja.dp2px(19.0F, getResources());
    int i1 = wja.dp2px(40.0F, getResources());
    int n = wja.dp2px(30.0F, getResources());
    int m = wja.dp2px(70.0F, getResources());
    int i6 = wja.dp2px(10.0F, getResources());
    int k = wja.dp2px(60.0F, getResources());
    int j = wja.dp2px(49.0F, getResources());
    this.mMode = paramInt;
    int i7;
    float f;
    if (this.mMode == 2)
    {
      i5 = (int)(i5 * 0.8F);
      i4 = (int)(i4 * 0.8F);
      i3 = (int)(i3 * 0.8F);
      i2 = (int)(i2 * 0.8F);
      i1 = (int)(i1 * 0.8F);
      n = (int)(n * 0.8F);
      m = (int)(m * 0.8F);
      paramInt = (int)(i6 * 0.8F);
      i7 = (int)(k * 0.8F);
      int i8 = (int)(j * 0.8F);
      i6 = -1;
      k = paramInt;
      f = 14.0F * 0.8F;
      j = i7;
      paramInt = i8;
    }
    for (;;)
    {
      if (this.Cs != null)
      {
        localObject = (FrameLayout.LayoutParams)this.Cs.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = i6;
        ((FrameLayout.LayoutParams)localObject).height = i5;
        ((FrameLayout.LayoutParams)localObject).leftMargin = i4;
      }
      if (this.Ct != null)
      {
        localObject = (FrameLayout.LayoutParams)this.Ct.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = i3;
        ((FrameLayout.LayoutParams)localObject).height = i2;
        ((FrameLayout.LayoutParams)localObject).leftMargin = i1;
      }
      if (this.RT != null)
      {
        localObject = (LinearLayout.LayoutParams)this.RT.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).width = n;
        ((LinearLayout.LayoutParams)localObject).leftMargin = m;
        ((LinearLayout.LayoutParams)localObject).rightMargin = k;
        this.RT.setTextSize(1, f);
      }
      if (this.Cu != null)
      {
        if (this.mMode == 3) {
          this.Cu.setVisibility(8);
        }
      }
      else
      {
        return;
        if (this.mMode != 3) {
          break label496;
        }
        i1 = aqnm.dip2px(20.0F);
        i4 = aqnm.dip2px(16.0F);
        i3 = aqnm.dip2px(16.0F);
        i2 = aqnm.dip2px(17.0F);
        i6 = -2;
        i7 = 0;
        f = 14.0F;
        paramInt = j;
        j = k;
        k = i4;
        i4 = i7;
        continue;
      }
      Object localObject = (FrameLayout.LayoutParams)this.Cu.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = j;
      ((FrameLayout.LayoutParams)localObject).height = paramInt;
      return;
      label496:
      i7 = -2;
      f = 14.0F;
      paramInt = j;
      j = k;
      k = i6;
      i6 = i7;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.mMode == 1) && (this.Cs != null))
    {
      this.Cs.setOnClickListener(paramOnClickListener);
      return;
    }
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setVoiceDuration(long paramLong)
  {
    if (this.RT != null)
    {
      String str = String.format("%s″", new Object[] { Long.valueOf(paramLong) });
      this.RT.setText(str);
      this.XU = paramLong;
      ddX();
    }
  }
  
  public void setVoiceFileMD5(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("setVoiceFileMD5 md5=%s", new Object[] { paramString }));
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.mMD5 = paramString.toUpperCase();
      paramString = A(this.mMD5);
      if ((this.Cu != null) && (paramString != null)) {
        this.Cu.setBackgroundDrawable(new BitmapDrawable(paramString));
      }
      int j = arwv.toMD5(this.mMD5).toUpperCase().charAt(0) % lj.length;
      hZ(lj[j], lk[j]);
    }
  }
  
  public void setVoiceUrl(String paramString)
  {
    this.mVoiceUrl = paramString;
    if (!TextUtils.isEmpty(this.mVoiceUrl))
    {
      int j = this.mVoiceUrl.lastIndexOf('=');
      if (j >= 0) {
        setVoiceFileMD5(this.mVoiceUrl.substring(j + 1));
      }
    }
  }
  
  public void startAnimation()
  {
    Object localObject3 = null;
    if (this.mMode != 3)
    {
      Object localObject1;
      switch (this.cVs)
      {
      default: 
        localObject1 = null;
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject1 = new File(afxw.kL((String)localObject1));
        localObject2 = localObject3;
        if (!((File)localObject1).exists()) {
          break;
        }
        File[] arrayOfFile = ((File)localObject1).listFiles();
        localObject2 = localObject3;
        if (arrayOfFile == null) {
          break;
        }
        localObject2 = localObject3;
        if (arrayOfFile.length <= 0) {
          break;
        }
        localObject1 = new String[arrayOfFile.length];
        int j = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (j >= arrayOfFile.length) {
            break;
          }
          localObject1[j] = arrayOfFile[j].getAbsolutePath();
          j += 1;
        }
        localObject1 = "expand_animate_logo1";
        continue;
        localObject1 = "expand_animate_logo2";
        continue;
        localObject1 = "expand_animate_logo3";
        continue;
        localObject1 = "expand_animate_logo4";
      }
      if ((localObject2 != null) && (localObject2.length > 0) && (this.jdField_a_of_type_Afyu != null))
      {
        if (this.Cu != null) {
          this.Cu.setBackgroundDrawable(this.jdField_a_of_type_Afyu);
        }
        this.jdField_a_of_type_Afyu.T(localObject2);
        this.jdField_a_of_type_Afyu.startAnimation();
      }
    }
    if (this.i != null) {
      this.i.playAnimation();
    }
    this.mAnimating = true;
  }
  
  public void stopAnimation()
  {
    if (this.jdField_a_of_type_Afyu != null) {
      this.jdField_a_of_type_Afyu.stopAnimation();
    }
    if (this.i != null) {
      this.i.endAnimation();
    }
    if (this.Cu != null)
    {
      Bitmap localBitmap = A(this.mMD5);
      if (localBitmap != null) {
        this.Cu.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      }
    }
    this.mAnimating = false;
  }
  
  public void u(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("onDownloadFinish path=%s", new Object[] { paramFile.getAbsoluteFile() }));
    }
  }
  
  public static abstract interface a
  {
    public abstract void dcW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView
 * JD-Core Version:    0.7.0.1
 */