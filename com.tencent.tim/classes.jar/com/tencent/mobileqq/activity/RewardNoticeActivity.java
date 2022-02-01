package com.tencent.mobileqq.activity;

import acbs;
import acbw;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqcx;
import aqft;
import aqgw;
import aqiw;
import aqpi;
import aqpi.a;
import aqrb;
import aqrd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import vsh;
import vsj;
import vsk;

public class RewardNoticeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  TextView AQ;
  TextView FA;
  protected long GP;
  acbw a = new vsj(this);
  protected String aPC;
  protected String aPD;
  protected String aPE;
  public String aPF;
  private aqgw b;
  protected int bvC;
  protected byte[] cj;
  aqrd d = new vsk(this);
  public RelativeLayout he;
  public RelativeLayout hf;
  Handler.Callback mCallback = new vsh(this);
  ImageView mCloseButton;
  protected String mName;
  protected String mPicUrl;
  public int mType;
  protected String mUrl;
  public ImageView ra;
  ImageView rb;
  ImageView rc;
  View uH;
  
  private void initData()
  {
    Object localObject = super.getIntent();
    this.mType = ((Intent)localObject).getIntExtra("rewardType", 1);
    byte[] arrayOfByte1 = ((Intent)localObject).getByteArrayExtra("rewardName");
    byte[] arrayOfByte2 = ((Intent)localObject).getByteArrayExtra("rewardUrl");
    byte[] arrayOfByte3 = ((Intent)localObject).getByteArrayExtra("rewardJupWording");
    byte[] arrayOfByte4 = ((Intent)localObject).getByteArrayExtra("rewardOptWording");
    byte[] arrayOfByte5 = ((Intent)localObject).getByteArrayExtra("rewardOptUrl");
    byte[] arrayOfByte6 = ((Intent)localObject).getByteArrayExtra("rewardToastWording");
    byte[] arrayOfByte7 = ((Intent)localObject).getByteArrayExtra("rewardIconUrl");
    if (arrayOfByte1 != null) {}
    try
    {
      this.mName = new String(arrayOfByte1, "UTF-8");
      if (arrayOfByte2 != null) {
        this.mUrl = new String(arrayOfByte2, "UTF-8");
      }
      if (arrayOfByte3 != null) {
        this.aPC = new String(arrayOfByte3, "UTF-8");
      }
      if (arrayOfByte4 != null) {
        this.aPD = new String(arrayOfByte4, "UTF-8");
      }
      if (arrayOfByte5 != null) {
        this.aPE = new String(arrayOfByte5, "UTF-8");
      }
      if (arrayOfByte6 != null) {
        this.aPF = new String(arrayOfByte6, "UTF-8");
      }
      if (arrayOfByte7 != null) {
        this.mPicUrl = new String(arrayOfByte7, "UTF-8");
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.BabyQ", 2, "UnsupportedEncodingException" + localUnsupportedEncodingException.toString());
          continue;
          i = 0;
        }
      }
    }
    this.cj = ((Intent)localObject).getByteArrayExtra("rewardCookie");
    if (this.mType == 1) {
      this.GP = ((Intent)localObject).getLongExtra("rewardFaceId", -1L);
    }
    this.bvC = ((Intent)localObject).getIntExtra("rewardReportType", -1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("initData type:").append(this.mType).append(" name:").append(this.mName).append(" url:").append(aqft.pk(this.mUrl)).append(" cookie:");
      if (this.cj != null)
      {
        i = this.cj.length;
        QLog.d("Q.BabyQ", 2, i + " jump:" + aqft.pk(this.aPC) + " optWord:" + this.aPD + " optUrl:" + aqft.pk(this.aPE) + " toast:" + this.aPF + " picUrl:" + aqft.pk(this.mPicUrl) + " faceId:" + this.GP);
      }
    }
    else
    {
      return;
    }
  }
  
  public void a(View paramView, Animation.AnimationListener paramAnimationListener, float paramFloat, long paramLong, int paramInt)
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(-paramFloat, paramFloat, 1, 0.5F, 1, 0.7F);
    localRotateAnimation.setDuration(paramLong / (paramInt + 1));
    localRotateAnimation.setRepeatMode(2);
    localRotateAnimation.setRepeatCount(paramInt);
    paramView.clearAnimation();
    paramView.startAnimation(localRotateAnimation);
    if (paramAnimationListener != null) {
      localRotateAnimation.setAnimationListener(paramAnimationListener);
    }
  }
  
  void bVf()
  {
    int i = 0;
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext())) {
      QQToast.a(this, 1, 2131696270, 0).show(getTitleBarHeight());
    }
    for (;;)
    {
      return;
      if (this.mType == 1) {
        if (this.GP == -1L)
        {
          QLog.e("Q.BabyQ", 2, "receive error face id");
          i = 1;
        }
      }
      while (i != 0)
      {
        finish();
        return;
        ((aqrb)this.app.getBusinessHandler(71)).R(this.GP, -1, 1);
        anot.a(this.app, "dc00898", "", "", "0X800723D", "0X800723D", 0, 0, "", "", "", "");
        continue;
        if (this.mType == 11)
        {
          bVg();
          acbs.d(this.app, this.bvC, 2);
          i = 1;
        }
        else if ((this.mType == 12) || (this.mType == 13))
        {
          ((acbs)this.app.getBusinessHandler(53)).av(this.cj);
          acbs.d(this.app, this.bvC, 2);
        }
        else if (this.mType == 2)
        {
          bVi();
          anot.a(this.app, "dc00898", "", "", "0X800724B", "0X800724B", 0, 0, "", "", "", "");
          i = 1;
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.BabyQ", 2, "pickReward error type:" + this.mType);
          }
          i = 1;
        }
      }
    }
  }
  
  public void bVg()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", this.mUrl);
    localIntent.putExtra("leftViewText", super.getString(2131690700));
    super.startActivity(localIntent);
  }
  
  public void bVh()
  {
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(0.3F, 1.06F, 0.3F, 1.06F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation1.setStartOffset(0L);
    localScaleAnimation1.setDuration(300L);
    localScaleAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(1.06F, 1.0F, 1.06F, 1.0F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation2.setStartOffset(300L);
    localScaleAnimation2.setDuration(100L);
    localScaleAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localScaleAnimation1);
    localAnimationSet.addAnimation(localScaleAnimation2);
    this.uH.startAnimation(localAnimationSet);
  }
  
  void bVi()
  {
    String str = "";
    if (aqpi.a != null) {
      str = aqpi.a.cuI;
    }
    if (TextUtils.isEmpty(str))
    {
      str = String.format("https://m.vip.qq.com/redirect/index.php?go=androidzhanghao&qq=%s&aid=%s&_wv=5123", new Object[] { "0", "mvip.pingtai.mobileqq.androidziliaoka.fromqita" }) + "&adtag=" + "qita";
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "gotoQQVipWeb() url = " + str);
      }
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject).putExtra("url", str);
      ((Intent)localObject).putExtra("hide_more_button", true);
      super.startActivity((Intent)localObject);
      return;
    }
    Object localObject = new StringBuilder(str);
    if (str.contains("?")) {
      ((StringBuilder)localObject).append("&platform=1");
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("&qq=" + "0");
      ((StringBuilder)localObject).append("&adtag=" + "qita");
      ((StringBuilder)localObject).append("&aid=" + "mvip.pingtai.mobileqq.androidziliaoka.fromqita");
      str = ((StringBuilder)localObject).toString();
      break;
      ((StringBuilder)localObject).append("?platform=1");
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561641);
    initData();
    this.hf = ((RelativeLayout)super.findViewById(2131377245));
    this.he = ((RelativeLayout)super.findViewById(2131377246));
    this.ra = ((ImageView)super.findViewById(2131379246));
    this.rb = ((ImageView)super.findViewById(2131377240));
    this.AQ = ((TextView)super.findViewById(2131377242));
    this.FA = ((TextView)super.findViewById(2131377244));
    this.mCloseButton = ((ImageView)super.findViewById(2131364687));
    this.rc = ((ImageView)super.findViewById(2131377241));
    this.uH = super.findViewById(2131376635);
    this.AQ.setOnClickListener(this);
    this.mCloseButton.setOnClickListener(this);
    this.FA.setText(this.mName);
    if (!TextUtils.isEmpty(this.aPC)) {
      this.AQ.setText(this.aPC);
    }
    if (!TextUtils.isEmpty(this.mPicUrl)) {}
    try
    {
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestWidth = aqcx.dip2px(this, 75.0F);
      paramBundle.mRequestHeight = aqcx.dip2px(this, 65.0F);
      paramBundle = URLDrawable.getDrawable(this.mPicUrl, paramBundle);
      this.rc.setImageDrawable(paramBundle);
      this.b = new aqgw(Looper.getMainLooper(), this.mCallback);
      this.b.sendEmptyMessageDelayed(1, 200L);
      super.addObserver(this.a);
      super.addObserver(this.d);
      if (this.mType == 2)
      {
        anot.a(this.app, "dc00898", "", "", "0X800724A", "0X800724A", 0, 0, "", "", "", "");
        return true;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.BabyQ", 2, "load pic error" + paramBundle.toString());
        }
      }
      acbs.d(this.app, this.bvC, 1);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.a);
    super.removeObserver(this.d);
    this.b.removeCallbacksAndMessages(null);
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
      bVf();
      continue;
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RewardNoticeActivity
 * JD-Core Version:    0.7.0.1
 */