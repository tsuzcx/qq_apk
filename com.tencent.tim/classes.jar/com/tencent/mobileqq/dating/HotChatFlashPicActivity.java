package com.tencent.mobileqq.dating;

import afcm;
import afcn;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqbn;
import aqgw;
import ayxa;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.CountDownProgressBar;
import com.tencent.widget.CountDownProgressBar.a;
import java.io.File;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import sxv;
import sxx;
import sxy;
import syd;
import xuh;
import xuh.a;
import xui;

public class HotChatFlashPicActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnTouchListener, CountDownProgressBar.a, sxv
{
  private TextView Rs;
  private long Xi;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new afcn(this);
  private AnimationView jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView;
  private CountDownProgressBar jdField_a_of_type_ComTencentWidgetCountDownProgressBar;
  private URLImageView aY;
  private AIOImageData jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
  private syd jdField_b_of_type_Syd;
  private xuh jdField_b_of_type_Xuh;
  private boolean bXh;
  private boolean bXi;
  private boolean bXj;
  private boolean bXk;
  private boolean bXl;
  private boolean bXm;
  private boolean bXn;
  private boolean bXo;
  private boolean biP = true;
  private xui c = new afcm(this);
  private AtomicBoolean cP = new AtomicBoolean(true);
  private int cQi;
  private int cQj;
  private aqgw d;
  private String fT;
  private View fc;
  private BitmapDrawable g;
  private Dialog mDialog;
  private String mFilePath;
  private boolean mIsLoading;
  private boolean mIsSend;
  private int mProgress;
  private RelativeLayout mRoot;
  private String mSelfUin = "";
  private long mUniseq;
  private String mosaicPath;
  private View xJ;
  private ImageView yz;
  
  private void HG(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = paramString;
    this.d.sendMessageDelayed(localMessage, 200L);
  }
  
  private void HH(String paramString)
  {
    this.d.sendEmptyMessage(7);
    paramString = y(paramString);
    if (paramString != null)
    {
      Message localMessage = new Message();
      localMessage.what = 5;
      localMessage.obj = paramString;
      this.d.sendMessage(localMessage);
    }
  }
  
  private void HI(String paramString)
  {
    this.d.sendEmptyMessage(7);
    M(y(paramString));
  }
  
  private void HJ(String paramString)
  {
    this.g = new BitmapDrawable(y(paramString));
    R(this.g);
  }
  
  private void M(Bitmap paramBitmap)
  {
    this.mRoot.setBackgroundResource(2131166645);
    if (this.bXm) {
      this.xJ.setVisibility(0);
    }
    this.bXm = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "update mosaic");
    }
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(8);
    if (paramBitmap != null)
    {
      this.aY.setImageBitmap(paramBitmap);
      this.d.sendEmptyMessage(8);
      this.aY.setVisibility(0);
    }
  }
  
  private void R(Drawable paramDrawable)
  {
    Rect localRect = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    Object localObject = getResources().getDisplayMetrics();
    int k = ((DisplayMetrics)localObject).widthPixels;
    int m = ((DisplayMetrics)localObject).heightPixels;
    float f = Math.min(k / i, m / j);
    localObject = sxx.getAnimationEndDstRect((int)(i * f), (int)(j * f), k, m, false, null);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.startEnterAnimation(paramDrawable, localRect, (Rect)localObject, sxy.getCutValue(localRect, paramDrawable), 350L);
    paramDrawable = new AlphaAnimation(0.0F, 1.0F);
    paramDrawable.setInterpolator(new AccelerateInterpolator());
    paramDrawable.setDuration(350L);
    paramDrawable.setFillAfter(true);
    this.mRoot.setBackgroundResource(2131166645);
    this.mRoot.startAnimation(paramDrawable);
  }
  
  private void S(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      finish();
    }
    while (this.bXn) {
      return;
    }
    Rect localRect = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    Object localObject = getResources().getDisplayMetrics();
    int k = ((DisplayMetrics)localObject).widthPixels;
    int m = ((DisplayMetrics)localObject).heightPixels;
    float f = Math.min(k / i, m / j);
    localObject = sxx.getAnimationEndDstRect((int)(i * f), (int)(j * f), k, m, false, null);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
    this.aY.setVisibility(8);
    this.xJ.setVisibility(8);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.startBackAnimation(paramDrawable, localRect, (Rect)localObject, sxy.getCutValue(localRect, paramDrawable), 0, 0, 350L);
    paramDrawable = new AlphaAnimation(1.0F, 0.0F);
    paramDrawable.setDuration(350L);
    paramDrawable.setFillAfter(true);
    this.mRoot.startAnimation(paramDrawable);
  }
  
  private int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          m = j;
        }
      }
    }
    label43:
    int k;
    label55:
    do
    {
      do
      {
        return m;
        j = paramOptions.outHeight;
        k = paramOptions.outWidth;
        m = i;
      } while (j <= paramInt2);
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      i <<= 1;
      k >>= 1;
      j >>= 1;
      break label55;
      n = m;
    }
  }
  
  private long fB()
  {
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    int k = localCalendar.get(13);
    return l + (86399000L - i * 3600 * 1000 - j * 60 * 1000 - k * 1000);
  }
  
  private String kt(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("I:N"))) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString + "_fp";
      if (!new File(str).exists()) {
        break;
      }
      paramString = str;
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.hotchat", 4, "flash pic cache file exist");
    return str;
    return null;
  }
  
  private String ul()
  {
    Object localObject;
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.c(4) != null) || (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.c(2) != null))
    {
      this.bXk = true;
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.c(4) != null) {
        localObject = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.aVY;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "checkLocalFileExist,filePath:" + (String)localObject + ",isOrigin:" + false + ",isSendFromLocal:" + this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.bjd);
      }
      return localObject;
      localObject = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.aVX;
      continue;
      String str = kt(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.aVY);
      localObject = str;
      if (str == null)
      {
        str = kt(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.aVX);
        localObject = str;
        if (str == null)
        {
          localObject = str;
          if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.bim)
          {
            localObject = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
            localObject = "I:E";
          }
        }
      }
    }
  }
  
  private String um()
  {
    int i = 7;
    if ((this.biP) || (this.cQi < 2)) {
      return "error happen";
    }
    this.Xi = getSharedPreferences(this.mSelfUin, 4).getLong("commen_flashpic_shot_deadlineday", 0L);
    double d1 = this.Xi - System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    if ((d1 < 0.0D) || (d1 >= 86400000.0D)) {
      if (d1 < 0.0D)
      {
        localStringBuilder.append(i);
        localStringBuilder.append(getString(2131691849));
      }
    }
    for (;;)
    {
      return String.format(getString(2131691848), new Object[] { localStringBuilder });
      i = Math.min((int)(d1 / 86400000.0D), 7);
      break;
      i = (int)(d1 / 3600000.0D);
      if (i != 0)
      {
        localStringBuilder.append(i);
        localStringBuilder.append(getString(2131691851));
      }
      int j = (int)((d1 - i * 3600000.0D) / 60000.0D);
      if ((i == 0) && (j == 0))
      {
        localStringBuilder.append(1);
        localStringBuilder.append(getString(2131691852));
      }
      else if (j != 0)
      {
        localStringBuilder.append(j);
        localStringBuilder.append(getString(2131691852));
      }
    }
  }
  
  private void updateProgress(int paramInt)
  {
    this.mProgress = paramInt;
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    this.d.sendMessage(localMessage);
  }
  
  private Bitmap y(String paramString)
  {
    int i = 320;
    int k = 1;
    Object localObject = getResources().getDisplayMetrics();
    int j = ((DisplayMetrics)localObject).widthPixels;
    int m = ((DisplayMetrics)localObject).heightPixels;
    if ((j == 0) || (m == 0)) {
      j = 320;
    }
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(paramString, localOptions);
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = calculateInSampleSize(localOptions, j, i);
        localObject = SafeBitmapFactory.decodeFile(paramString, localOptions);
        m = ((Bitmap)localObject).getWidth() / 16;
        if (m == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.hotchat", 2, "reqWidth:" + j + ",reqHeight:" + i + ",inSampleSize:" + localOptions.inSampleSize + ",block:" + k);
          }
          paramString = aqbn.f((Bitmap)localObject, k);
        }
        k = m;
      }
      catch (Exception localException1)
      {
        try
        {
          ((Bitmap)localObject).recycle();
          return paramString;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          localObject = paramString;
          continue;
        }
        catch (Exception localException2)
        {
          localObject = paramString;
          continue;
        }
        localException1 = localException1;
        localObject = null;
        paramString = (String)localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.hotchat", 2, "FlashPicActivity getMosaicBitmap Exception：" + localException1.toString());
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localObject = null;
        localOutOfMemoryError1.printStackTrace();
        paramString = (String)localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.hotchat", 2, "FlashPicActivity getMosaicBitmap oom：" + localOutOfMemoryError1.toString());
        return localObject;
      }
      continue;
      i = m;
    }
  }
  
  public void cYs()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "count down stop");
    }
    if (this.bXi) {
      S(this.aY.getDrawable());
    }
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "on back pressed");
    }
    S(this.aY.getDrawable());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.bXo = true;
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    if (ayxa.enableNotch(this))
    {
      this.mNeedStatusTrans = true;
      this.mActNeedImmersive = false;
      super.doOnCreate(paramBundle);
      if (Build.VERSION.SDK_INT > 13) {
        getWindow().addFlags(8192);
      }
      setContentView(2131561440);
      this.mRoot = ((RelativeLayout)findViewById(2131377546));
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView = ((AnimationView)findViewById(2131362725));
      this.aY = ((URLImageView)findViewById(2131367221));
      this.xJ = findViewById(2131367225);
      this.yz = ((ImageView)this.xJ.findViewById(2131367223));
      this.Rs = ((TextView)this.xJ.findViewById(2131367224));
      this.fc = findViewById(2131367220);
      this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar = ((CountDownProgressBar)findViewById(2131367219));
      this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setTotalMills(2500L, 3);
      this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setOnCountDownLinstener(this);
      this.jdField_b_of_type_Syd = new syd();
      this.jdField_b_of_type_Syd.init(this, (ImageView)findViewById(2131367222));
      paramBundle = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (paramBundle != null)
      {
        this.jdField_b_of_type_Xuh = xuh.a.a(paramBundle.binder);
        this.jdField_b_of_type_Xuh.a(this.c);
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData = ((AIOImageData)getIntent().getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"));
      this.bXh = getIntent().getBooleanExtra("isreaded", false);
      this.mUniseq = getIntent().getLongExtra("uniseq", 0L);
      this.fT = getIntent().getStringExtra("md5");
      this.mIsSend = getIntent().getBooleanExtra("is_send", false);
      this.mSelfUin = getIntent().getStringExtra("self_uin");
      this.biP = getIntent().getBooleanExtra("self_identify", true);
      this.cQj = getIntent().getIntExtra("curtype", 0);
      this.d = new aqgw(this.jdField_a_of_type_AndroidOsHandler$Callback);
      paramBundle = getSharedPreferences(this.mSelfUin, 4);
      if (!this.biP) {
        break label656;
      }
      this.cQi = paramBundle.getInt("HOTCHAT_FLASHPIC_SHOT", 0);
      label440:
      if (!this.biP)
      {
        this.Xi = paramBundle.getLong("commen_flashpic_shot_deadlineday", 0L);
        if ((this.Xi != 0L) && (this.Xi <= System.currentTimeMillis()))
        {
          this.cQi = 0;
          paramBundle = paramBundle.edit();
          paramBundle.putInt("commen_flashpic_shot", this.cQi);
          paramBundle.putLong("commen_flashpic_shot_deadlineday", 0L);
          paramBundle.commit();
        }
        this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setTotalMills(4500L, 5);
      }
      if ((!this.bXh) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData != null)) {
        break label686;
      }
      this.yz.setImageResource(2130843395);
      if (!this.biP) {
        break label673;
      }
      this.Rs.setText(2131694703);
      label577:
      this.xJ.setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "mIsReaded:" + this.bXh + ",mScreenShotCount:" + this.cQi + ",mIsSend:" + this.mIsSend);
      }
      return true;
      this.mNeedStatusTrans = false;
      break;
      label656:
      this.cQi = paramBundle.getInt("commen_flashpic_shot", 0);
      break label440;
      label673:
      this.Rs.setText(2131691846);
      break label577;
      label686:
      if ((this.cQi >= 2) && (!this.mIsSend))
      {
        this.yz.setImageResource(2130843395);
        if (this.biP) {
          this.Rs.setText(2131694705);
        }
        for (;;)
        {
          this.xJ.setVisibility(0);
          break;
          this.Rs.setText(um());
        }
      }
      this.mFilePath = ul();
      if ((this.mFilePath != null) && (this.mFilePath.equals("I:E")))
      {
        this.d.sendEmptyMessage(1);
      }
      else if (this.mFilePath != null)
      {
        paramBundle = this.mFilePath;
        this.mosaicPath = this.mFilePath;
        updateProgress(0);
        ThreadManager.getFileThreadHandler().post(new HotChatFlashPicActivity.2(this, paramBundle));
      }
      else
      {
        this.mIsLoading = true;
        updateProgress(0);
        if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.c(1) != null)
        {
          this.bXl = true;
          this.mosaicPath = this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.aVW;
          if (QLog.isColorLevel()) {
            QLog.d("Q.hotchat", 2, "flashpic thumbImageFile exists");
          }
        }
        this.jdField_b_of_type_Xuh.downloadMedia(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.id, this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.subId, 2);
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.g != null) && (this.g.getBitmap() != null)) {}
    try
    {
      this.g.getBitmap().recycle();
      if ((this.jdField_b_of_type_Xuh == null) || (getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {}
    }
    catch (Exception localException1)
    {
      try
      {
        do
        {
          this.jdField_b_of_type_Xuh.destory();
          System.gc();
          return;
          localException1 = localException1;
        } while (!QLog.isColorLevel());
        QLog.w("Q.hotchat", 2, "", localException1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public void doOnPause()
  {
    if ((isFinishing()) && (!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.bjd) && (!this.bXk) && (this.mFilePath != null) && (!this.mFilePath.equals("I:E")) && (!this.bXi))
    {
      String str = this.mFilePath;
      ThreadManager.getFileThreadHandler().post(new HotChatFlashPicActivity.5(this, str));
    }
    super.doOnPause();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if ((this.mosaicPath != null) && (this.bXo))
    {
      if (!this.bXl) {
        break label39;
      }
      HJ(this.mosaicPath);
    }
    for (;;)
    {
      this.bXo = false;
      return;
      label39:
      this.d.postDelayed(new HotChatFlashPicActivity.3(this), 350L);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.bXi) {
      ThreadManagerV2.executeOnFileThread(new HotChatFlashPicActivity.7(this));
    }
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public boolean isSupportScreenShot()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "isSupportScreenShot,mIsPicShow:" + this.bXi + ",mScreenShotCount:" + this.cQi + ",mHadShot:" + this.bXj);
    }
    if (this.bXi)
    {
      if (!this.bXj)
      {
        this.cQi += 1;
        this.bXj = true;
        ThreadManager.getFileThreadHandler().post(new HotChatFlashPicActivity.6(this));
        this.d.sendEmptyMessage(4);
      }
      return false;
    }
    return super.isSupportScreenShot();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369579) {
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onEnterAnimationEnd()
  {
    this.aY.setVisibility(0);
    this.aY.setImageDrawable(this.g);
    HI(this.mosaicPath);
  }
  
  public void onEnterAnimationStart() {}
  
  public void onExitAnimationEnd()
  {
    finish();
    this.bXn = false;
  }
  
  public void onExitAnimationStart()
  {
    this.bXn = true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.hotchat", 2, "action down,mLargeError:" + this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.bim + ",mIsLoading:" + this.mIsLoading);
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.bim) && (!this.mIsLoading))
        {
          this.mIsLoading = true;
          this.xJ.setVisibility(8);
          this.jdField_b_of_type_Syd.setProgress(0);
          this.jdField_b_of_type_Syd.show();
          updateProgress(0);
          this.jdField_b_of_type_Xuh.downloadMedia(this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.id, this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.subId, 2);
          return true;
        }
      } while ((this.bXi) || (this.bXj) || (this.mIsLoading) || (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.bim));
      this.d.sendEmptyMessageDelayed(3, 500L);
      return true;
      this.d.removeMessages(3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "on touch: " + paramMotionEvent.getAction());
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.bim);
    S(this.aY.getDrawable());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity
 * JD-Core Version:    0.7.0.1
 */