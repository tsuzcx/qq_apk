package com.tencent.mobileqq.activity.shortvideo;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import cnm;
import cnn;
import cno;
import cnp;
import cnq;
import cnr;
import cns;
import cnt;
import cnu;
import cnv;
import cnw;
import cnx;
import cny;
import cnz;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import java.io.File;

public class ShortVideoPlayActivity
  extends BaseActivity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, SurfaceHolder.Callback, View.OnClickListener
{
  public static final int a = 0;
  public static final long a = 350L;
  private static final String jdField_a_of_type_JavaLangString = "ShortVideoPlayActivity";
  public static final int b = 1;
  private static final long jdField_b_of_type_Long = 100L;
  public static final int c = 2;
  public static final int d = 3;
  private static final String jdField_d_of_type_JavaLangString = "state_play_position";
  private static final int h = 3000;
  private static final int i = 500;
  private static final int j = 1;
  private static final int k = 2;
  private static final int l = 3;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new cnw(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private final Handler jdField_a_of_type_AndroidOsHandler = new cnm(this);
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private View jdField_a_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new cnu(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new cnp(this);
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AnimationView jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new cns(this);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new cnv(this);
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private final Runnable jdField_b_of_type_JavaLangRunnable = new cnt(this);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private View jdField_c_of_type_AndroidViewView;
  private Animation jdField_c_of_type_AndroidViewAnimationAnimation;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Runnable jdField_c_of_type_JavaLangRunnable = new cnr(this);
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private Animation jdField_d_of_type_AndroidViewAnimationAnimation;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = true;
  private int f = -1;
  private int g;
  private int m;
  private int n;
  private int o;
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "null";
    case 0: 
      return " idle ";
    case 1: 
      return " playing ";
    case 2: 
      return " pause ";
    }
    return " error ";
  }
  
  private void a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {}
    for (;;)
    {
      return;
      this.jdField_e_of_type_Int = paramInt;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838773);
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ShortVideoPlayActivity", 2, "changePlayState, playState=" + a(paramInt) + ", mIsPlaying=" + this.jdField_a_of_type_Boolean);
        return;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838772);
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    this.jdField_b_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
    this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("file_shortvideo_md5");
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)paramIntent.getExtras().getParcelable("KEY_THUMBNAL_BOUND"));
    this.g = paramIntent.getExtras().getInt("uintype");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "initData(), intent extras =>mVideoPath: " + this.jdField_b_of_type_JavaLangString + ", thumbRect:" + this.jdField_a_of_type_AndroidGraphicsRect.toShortString() + ", istoop:" + this.g);
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPlayActivity", 2, "initData(), mVideoPath or mMD5 is empty, finish");
      }
      finish();
    }
    if (!FileUtils.b(this.jdField_b_of_type_JavaLangString))
    {
      QQToast.a(this, 1, 2131364425, 0).b(getTitleBarHeight());
      finish();
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsRect != null)) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ShortVideoUtils.a(this, this.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void b(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "#play#, msec=" + paramInt);
      }
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      if ((this.jdField_a_of_type_AndroidViewSurfaceView != null) && (this.jdField_a_of_type_AndroidViewSurfaceView.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(this.jdField_a_of_type_AndroidViewSurfaceView.getHolder());
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new cnn(this, paramInt));
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      if (this.g == 0)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "1", "", "");
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      if (this.g == 3000)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "2", "", "");
        this.jdField_b_of_type_Boolean = true;
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPlayActivity", 2, "#play#, msec=" + paramInt, localException);
      }
      l();
      m();
      return;
    }
    if (this.g == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "3", "", "");
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "4", "", "");
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramInt));
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewSurfaceView.setVisibility(0);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    a(1);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startShowing : mHidden = " + this.jdField_e_of_type_Boolean);
    }
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    h();
    this.jdField_b_of_type_AndroidViewView.clearAnimation();
    this.jdField_c_of_type_AndroidViewView.clearAnimation();
    if (!VersionUtils.d())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "delayStartHiding");
    }
    h();
    if ((this.jdField_e_of_type_Int == 1) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startHiding : mHidden = " + this.jdField_e_of_type_Boolean + ",playState:" + a(this.jdField_e_of_type_Int));
    }
    if (this.jdField_e_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_e_of_type_Int != 1);
      if (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.jdField_c_of_type_AndroidViewView.clearAnimation();
        this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
      }
    } while (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0);
    this.jdField_b_of_type_AndroidViewView.clearAnimation();
    this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    a(0);
  }
  
  private void j()
  {
    int i1 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "initDuration: duration=" + i1);
    }
    if (i1 != 0)
    {
      this.f = i1;
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.f);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.f));
    }
  }
  
  private void k()
  {
    int i1 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
    int i2 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "adjustVideoRatio, videoWith:" + i1 + ",videoHeight:" + i2);
    }
    if ((this.n == 0) || (this.m == 0) || (i1 == 0) || (i2 == 0)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (this.n / this.m > i2 / i1)
    {
      f1 = this.m;
      i1 = (int)(i2 * f1 / i1);
      i1 = (int)((this.n - i1) / 2.0F);
      localLayoutParams.setMargins(0, i1, 0, i1);
      this.jdField_a_of_type_AndroidViewSurfaceView.setLayoutParams(localLayoutParams);
      return;
    }
    float f1 = this.n;
    i1 = (int)(i1 * f1 / i2);
    i1 = (int)((this.m - i1) / 2.0F);
    localLayoutParams.setMargins(i1, 0, i1, 0);
    this.jdField_a_of_type_AndroidViewSurfaceView.setLayoutParams(localLayoutParams);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
    a(0);
  }
  
  private void m()
  {
    DialogUtil.a(this, 232, null, getString(2131364431), new cno(this), null).show();
    if (!this.jdField_c_of_type_Boolean)
    {
      int i1 = (int)(DeviceInfoUtil.d() / 1024L);
      int i2 = (int)(new File(this.jdField_b_of_type_JavaLangString).length() / 1024L);
      String str = DeviceInfoUtil.d();
      ReportController.b(this.app, "CliOper", "", "", "0X8004674", "0X8004674", 0, 0, "" + i1, "" + i2, str, this.jdField_c_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#stop#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((this.jdField_e_of_type_Int == 1) || (this.jdField_e_of_type_Int == 2))) {
      i();
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#pause#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) && (this.jdField_e_of_type_Int == 1))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      a(2);
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#resume#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_e_of_type_Int == 2))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      a(1);
    }
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "handleClick: mPlayState = " + a(this.jdField_e_of_type_Int));
    }
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      return;
    case 0: 
      b(0);
      return;
    case 1: 
      o();
      return;
    case 2: 
      p();
      return;
    }
    b(0);
  }
  
  private void r()
  {
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.c(2131364426);
    localActionSheet.c(2131364430);
    localActionSheet.d(2131362790);
    localActionSheet.show();
    localActionSheet.a(new cnq(this, localActionSheet));
  }
  
  public void c()
  {
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setInterpolator(new AccelerateInterpolator());
    ((AlphaAnimation)localObject).setDuration(350L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
    localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap);
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    localRect1.set(this.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewSurfaceView.getLayoutParams());
    localRect2.set(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin, this.m - this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.rightMargin, this.n - this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(new cny(this));
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a((Drawable)localObject, localRect1, localRect2, 0, 350L);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "canRectAnimation : mThumbRect == null ");
      }
    }
    do
    {
      return false;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoPlayActivity", 2, "canRectAnimation : mThumbBitmap == null ");
    return false;
    return true;
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    overridePendingTransition(0, 2130968654);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903554);
    if (paramBundle != null)
    {
      this.o = paramBundle.getInt("state_play_position");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onCreate(), mCurrentPosition : " + this.o);
      }
      this.jdField_d_of_type_Boolean = false;
    }
    a(getIntent());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296564));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296445);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new cnx(this));
    this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)findViewById(2131298497));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131298498);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131298500);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296901));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298499));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298502));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298504));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131298503));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298501));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewSurfaceView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setType(3);
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setFormat(-3);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView = ((AnimationView)findViewById(2131298505));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968648);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968647);
    this.jdField_d_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968646);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968645);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (this.jdField_d_of_type_Boolean) {
      b(0);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidViewSurfaceView.setVisibility(0);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnDestroy");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    i();
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void doOnPause()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
    {
      this.o = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "pause mCurrentPosition:" + this.o);
      }
    }
    super.doOnPause();
  }
  
  protected void doOnStart()
  {
    MediaPlayerManager.a(this.app).a(true);
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.doOnStop();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298497: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onClick surfaceView, mHidden=" + this.jdField_e_of_type_Boolean);
      }
      if (this.jdField_e_of_type_Boolean)
      {
        if (this.jdField_e_of_type_Int == 1) {
          o();
        }
        e();
        f();
        return;
      }
      g();
      return;
    case 2131298501: 
      q();
      return;
    case 2131296901: 
      finish();
      overridePendingTransition(0, 2130968654);
      return;
    }
    if (this.jdField_e_of_type_Int == 1) {
      o();
    }
    r();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "mMediaPlayer onCompletion");
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.f);
    a(0);
    e();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPlayActivity", 2, "mMediaPlayer onError what=" + paramInt1 + ",extra=" + paramInt2);
    }
    a(3);
    l();
    m();
    return false;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.o = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    paramBundle.putInt("state_play_position", this.o);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onSaveInstanceState: mCurrentPosition: " + this.o);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "surfaceCreated: mCurrentPosition:" + this.o);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(this.jdField_a_of_type_AndroidViewSurfaceView.getHolder());
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new cnz(this), 100L);
      return;
    }
    if (this.o > 0)
    {
      b(this.o);
      this.o = 0;
      return;
    }
    b(0);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.o = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "surfaceDestroyed mCurrentPosition:" + this.o);
    }
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity
 * JD-Core Version:    0.7.0.1
 */