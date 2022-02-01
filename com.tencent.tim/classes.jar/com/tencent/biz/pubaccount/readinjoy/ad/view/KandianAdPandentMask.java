package com.tencent.biz.pubaccount.readinjoy.ad.view;

import ahbj;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import aqxx;
import auts;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import jzk;
import kkw;
import kma;
import knj;
import knz;
import koa;
import kob;
import koc;
import msc;
import myi;
import myj;
import ndh;
import ndi;
import ods;

public class KandianAdPandentMask
{
  @Nullable
  private KandianAdPandentView a;
  
  public void a(Activity paramActivity, ListView paramListView)
  {
    if ((knj.a().getShowStatus() == 1) && (knj.zV()))
    {
      str = knj.a().iv();
      i = knj.a().getMaskType();
      if (i != 1) {}
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      return;
      if (ahbj.isFileExists(str))
      {
        this.a = new KandianAdPandentView(paramActivity, paramListView, str);
        this.a.po(i);
        paramActivity = knj.a().a();
        if (paramActivity != null) {
          kma.b(paramActivity, true, "no error");
        }
        knj.a().b = this;
      }
      for (;;)
      {
        QLog.d("ReadInJoySuperMaskAd", 1, "preview mode value = " + knj.a().zW());
        knj.a().aEQ();
        return;
        knj.a().pl(3);
        paramActivity = knj.a().a();
        if (paramActivity != null) {
          kma.b(paramActivity, false, "apng not exit");
        }
      }
    }
    QLog.i("KandianAdPandentMask", 2, "status: " + knj.a().getShowStatus() + " Aladdin: " + knj.zV());
  }
  
  public void aES()
  {
    if (this.a != null) {
      this.a.aET();
    }
  }
  
  public void mr(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.mw(paramBoolean);
    }
  }
  
  public boolean zY()
  {
    return (this.a != null) && (KandianAdPandentView.a(this.a));
  }
  
  @SuppressLint({"ViewConstructor"})
  public static class KandianAdPandentView
    extends RelativeLayout
    implements View.OnClickListener
  {
    private ApngDrawable.OnPlayRepeatListener jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener;
    private VPNGImageView jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
    private msc jdField_a_of_type_Msc = new knz(this);
    private myi jdField_a_of_type_Myi;
    private int aKm;
    private ViewGroup aR;
    private ViewGroup aS;
    private boolean agG;
    private boolean agH = true;
    private boolean agI = true;
    @Nullable
    private AudioManager audioManager;
    @Nullable
    private Bitmap bU;
    private Bitmap bV;
    private Bitmap bW;
    @Nullable
    private URLDrawable jdField_e_of_type_ComTencentImageURLDrawable;
    @Nullable
    private ListView jdField_e_of_type_ComTencentWidgetListView;
    private float iN = 0.0F;
    private ImageView il;
    private ImageView im;
    private ImageView in;
    private ImageView io;
    private boolean isShowing;
    private View jM;
    private View jN;
    private Activity mActivity;
    private Handler mHandler = new Handler(new koa(this));
    private TextView or;
    private String resPath;
    private long sA;
    private View videoView;
    
    public KandianAdPandentView(Activity paramActivity, @Nullable ListView paramListView, String paramString)
    {
      super();
      this.mActivity = paramActivity;
      this.jdField_e_of_type_ComTencentWidgetListView = paramListView;
      this.aS = ((ViewGroup)paramActivity.getWindow().getDecorView());
      this.resPath = paramString;
      initView();
    }
    
    @Nullable
    private Bitmap a(@Nullable View paramView, boolean paramBoolean)
    {
      Canvas localCanvas = null;
      Object localObject4 = null;
      Bitmap localBitmap1 = null;
      Object localObject2;
      Object localObject3;
      if (paramView != null)
      {
        paramView.setDrawingCacheEnabled(true);
        paramView.buildDrawingCache();
        localObject2 = localCanvas;
        localObject3 = localObject4;
      }
      try
      {
        Bitmap localBitmap2 = paramView.getDrawingCache();
        localObject2 = localCanvas;
        localObject3 = localObject4;
        localBitmap1 = Bitmap.createBitmap(localBitmap2.getWidth(), localBitmap2.getHeight(), localBitmap2.getConfig());
        localObject2 = localBitmap1;
        localObject3 = localBitmap1;
        localCanvas = new Canvas(localBitmap1);
        if (!paramBoolean)
        {
          localObject2 = localBitmap1;
          localObject3 = localBitmap1;
          localCanvas.drawColor(Color.parseColor("#f8f8f8"));
        }
        localObject2 = localBitmap1;
        localObject3 = localBitmap1;
        localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, null);
        return localBitmap1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("KandianAdPandent", 2, "buildBitmapFromView, error" + localException.getMessage());
          localException.printStackTrace();
        }
        return localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("KandianAdPandent", 2, "buildBitmapFromView, error" + localOutOfMemoryError.getMessage());
          localOutOfMemoryError.printStackTrace();
        }
        return localObject3;
      }
      finally
      {
        paramView.setDrawingCacheEnabled(false);
        paramView.destroyDrawingCache();
      }
    }
    
    private void aEW()
    {
      boolean bool2 = true;
      label42:
      label103:
      myi localmyi;
      if (!this.agH)
      {
        bool1 = true;
        this.agH = bool1;
        if (!this.agH) {
          break label135;
        }
        this.io.setImageDrawable(this.mActivity.getResources().getDrawable(2130850356));
        if ((this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer() != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().mMediaPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().mMediaPlayer.isPlaying()))
        {
          if (!this.agH) {
            break label158;
          }
          this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().mMediaPlayer.setVolume(1.0F, 1.0F);
        }
        if (this.jdField_a_of_type_Myi != null)
        {
          localmyi = this.jdField_a_of_type_Myi;
          if (this.agH) {
            break label176;
          }
        }
      }
      label135:
      label158:
      label176:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localmyi.setMute(bool1);
        return;
        bool1 = false;
        break;
        this.io.setImageDrawable(this.mActivity.getResources().getDrawable(2130850355));
        break label42;
        this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().mMediaPlayer.setVolume(0.0F, 0.0F);
        break label103;
      }
    }
    
    private void aEX()
    {
      if (this.audioManager != null) {
        this.aKm = this.audioManager.getStreamVolume(3);
      }
      QLog.d("KandianAdPandent", 2, "current volume =  " + this.aKm);
      this.iN = (this.aKm / 5.0F);
      QLog.d("KandianAdPandent", 2, "current volume =  " + this.aKm + "intervalVolume = " + this.iN);
    }
    
    private void aEY()
    {
      if (this.agG) {
        return;
      }
      Object localObject3 = ai();
      Object localObject1 = this.mActivity.findViewById(16908307);
      Object localObject2 = this.mActivity.findViewById(2131381456);
      int i;
      int j;
      if (localObject3 != null)
      {
        i = ((View)localObject3).getHeight();
        j = a((View)localObject3, this.aS);
      }
      for (;;)
      {
        QLog.d("KandianAdPandent", 2, "hideAdsWithAnim, targetFeedsItemTop=" + j + ", targetFeedsItemHeight=" + i);
        if ((j >= 0) && (i > 0)) {}
        for (int k = 1; k != 0; k = 0)
        {
          this.bU = a((View)localObject3, false);
          if (this.bU != null)
          {
            this.il.setImageBitmap(this.bU);
            localObject3 = this.il.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject3).width = this.bU.getWidth();
            ((ViewGroup.LayoutParams)localObject3).height = this.bU.getHeight();
            this.il.requestLayout();
          }
          this.bW = a((View)localObject2, true);
          if (this.bW != null)
          {
            this.in.setImageBitmap(this.bW);
            localObject3 = this.in.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject3).height = this.bW.getHeight();
            ((ViewGroup.LayoutParams)localObject3).width = this.bW.getWidth();
            this.in.setY(((View)localObject2).getY());
            this.in.requestLayout();
          }
          this.bV = a((View)localObject1, true);
          if (this.bV != null)
          {
            this.im.setImageBitmap(this.bV);
            localObject2 = this.im.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject2).height = this.bV.getHeight();
            ((ViewGroup.LayoutParams)localObject2).width = this.bV.getWidth();
            this.im.setY(((View)localObject1).getY());
            this.im.requestLayout();
          }
          i = i / 2 + j - getHeight() / 2;
          QLog.d("KandianAdPandent", 2, "hideAdsWithAnim, centerDiff=" + i);
          localObject2 = ObjectAnimator.ofFloat(this.il, "scaleX", new float[] { 1.2F, 1.0F });
          localObject3 = ObjectAnimator.ofFloat(this.il, "scaleY", new float[] { 1.2F, 1.0F });
          Object localObject4 = ObjectAnimator.ofFloat(this.il, "alpha", new float[] { 0.0F, 1.0F });
          Object localObject5 = ObjectAnimator.ofFloat(this.il, "translationY", new float[] { 0.0F, i });
          localObject1 = new AnimatorSet();
          ((AnimatorSet)localObject1).play((Animator)localObject2).with((Animator)localObject3).with((Animator)localObject4).with((Animator)localObject5);
          ((AnimatorSet)localObject1).setDuration(600L);
          localObject3 = ObjectAnimator.ofFloat(this.aR, "alpha", new float[] { 1.0F, 0.0F });
          localObject4 = ObjectAnimator.ofFloat(this.aR, "scaleY", new float[] { 1.0F, 0.8F });
          localObject5 = ObjectAnimator.ofFloat(this.aR, "scaleY", new float[] { 1.0F, 0.8F });
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.aR, "translationY", new float[] { 0.0F, i });
          localObject2 = new AnimatorSet();
          ((AnimatorSet)localObject2).play((Animator)localObject3).with(localObjectAnimator).with((Animator)localObject4).with((Animator)localObject5);
          ((AnimatorSet)localObject2).setDuration(600L);
          localObject3 = ObjectAnimator.ofFloat(this.jN, "alpha", new float[] { 0.5F, 0.0F });
          ((ObjectAnimator)localObject3).setDuration(600L);
          localObject5 = ObjectAnimator.ofFloat(this.jM, "alpha", new float[] { 1.0F, 0.0F });
          localObject4 = new AnimatorSet();
          ((AnimatorSet)localObject4).play((Animator)localObject5).after(150L);
          ((AnimatorSet)localObject4).setDuration(150L);
          localObject5 = new AnimatorSet();
          ((AnimatorSet)localObject5).setInterpolator(new AccelerateDecelerateInterpolator());
          ((AnimatorSet)localObject5).playTogether(new Animator[] { localObject1, localObject2, localObject3, localObject4 });
          ((AnimatorSet)localObject5).start();
          this.agG = true;
          ((AnimatorSet)localObject5).addListener(new koc(this));
          return;
        }
        aEZ();
        return;
        j = -1;
        i = 0;
      }
    }
    
    private void aEZ()
    {
      aET();
    }
    
    @Nullable
    private View ai()
    {
      localObject2 = null;
      View localView = null;
      int j;
      int k;
      int i;
      if (this.jdField_e_of_type_ComTencentWidgetListView != null)
      {
        j = this.jdField_e_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
        k = this.jdField_e_of_type_ComTencentWidgetListView.getLastVisiblePosition();
        i = j;
      }
      for (;;)
      {
        localObject2 = localView;
        if (i <= k) {
          localObject2 = localView;
        }
        try
        {
          Object localObject3 = this.jdField_e_of_type_ComTencentWidgetListView.getAdapter().getItem(i);
          localObject2 = localView;
          if ((localObject3 instanceof AdvertisementInfo))
          {
            localObject2 = localView;
            localObject3 = (AdvertisementInfo)localObject3;
            localObject2 = localView;
            if (knj.a().d != null)
            {
              localObject2 = localView;
              if (((AdvertisementInfo)localObject3).mAdAid == knj.a().d.mAdAid)
              {
                localObject2 = localView;
                localView = this.jdField_e_of_type_ComTencentWidgetListView.getChildAt(i - j);
                localObject2 = localView;
                QLog.d("KandianAdPandent", 2, "hideAdsWithAnim, find AdvertisementInfo, targetPos=" + i + ", targetItemView=" + localView);
                localObject2 = localView;
                return localObject2;
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject1 = localObject2;
          }
        }
        i += 1;
      }
    }
    
    private void initView()
    {
      LayoutInflater.from(getContext()).inflate(2131560404, this, true);
      setId(2131370007);
      this.aR = ((ViewGroup)findViewById(2131372964));
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView = ((VPNGImageView)findViewById(2131369955));
      this.io = ((ImageView)findViewById(2131372959));
      this.il = ((ImageView)findViewById(2131369789));
      this.in = ((ImageView)findViewById(2131369786));
      this.im = ((ImageView)findViewById(2131369787));
      this.jM = findViewById(2131372965);
      this.jN = findViewById(2131372972);
      this.or = ((TextView)findViewById(2131369992));
      ((ImmersiveTitleBar2)findViewById(2131380034)).abu(0);
      setOnClickListener(this);
      this.or.setOnClickListener(this);
      this.io.setOnClickListener(this);
    }
    
    private void mk(String paramString)
    {
      if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView == null) || (this.aS == null)) {
        return;
      }
      mv(false);
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setVisibility(0);
      aEX();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.aS.getWidth() * 1.778F));
      localLayoutParams.addRule(13, -1);
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setVideo(paramString, false, 1, new kob(this));
      startTimer();
    }
    
    private void ml(String paramString)
    {
      mv(false);
      aEX();
      if (QLog.isColorLevel()) {
        QLog.d("KandianAdPandent", 2, new Object[] { "initTVKVideoController with path:", paramString });
      }
      if (!new myj().EU()) {
        QLog.e("KandianAdPandent", 2, "sdk NOT installed");
      }
      this.jdField_a_of_type_Myi = new myi(this.mActivity);
      this.videoView = this.jdField_a_of_type_Myi.al();
      this.videoView.setId(2131369958);
      if (this.videoView != null) {
        n(this.aR);
      }
      this.jdField_a_of_type_Myi.setXYaxis(2);
      this.jdField_a_of_type_Myi.a(this.jdField_a_of_type_Myi.b());
      this.jdField_a_of_type_Myi.a(this.jdField_a_of_type_Msc);
      this.videoView.setVisibility(0);
      this.jdField_a_of_type_Myi.a(null, paramString, 3, 1L, 0L, 0);
      this.jdField_a_of_type_Myi.setMute(false);
      startTimer();
    }
    
    private void pp(int paramInt)
    {
      this.audioManager = ((AudioManager)this.mActivity.getSystemService("audio"));
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        aEU();
        return;
      case 3: 
        mk(this.resPath);
        return;
      }
      ml(this.resPath);
    }
    
    public int a(View paramView1, View paramView2)
    {
      int j = 0;
      int i = 0;
      for (;;)
      {
        if (i > 30) {
          return j;
        }
        j = paramView1.getTop() + j;
        paramView1 = (View)paramView1.getParent();
        if ((paramView1 == null) || (paramView1 == paramView2)) {
          return j;
        }
        i += 1;
      }
    }
    
    public void aET()
    {
      if (getParent() != null)
      {
        ((ViewGroup)getParent()).removeView(this);
        this.isShowing = false;
      }
      if ((this.bU != null) && (!this.bU.isRecycled())) {
        this.bU.recycle();
      }
      Object localObject;
      if (this.jdField_e_of_type_ComTencentImageURLDrawable != null)
      {
        localObject = this.jdField_e_of_type_ComTencentImageURLDrawable.getCurrDrawable();
        if ((localObject instanceof ApngDrawable))
        {
          localObject = (ApngDrawable)localObject;
          ((ApngDrawable)localObject).removeOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener);
          ((ApngDrawable)localObject).setOnPlayRepeatListener(null);
        }
      }
      if (NetConnInfoCenter.getServerTimeMillis() - knj.a().cg() >= 1000L) {
        knj.a().aCG();
      }
      knj.a().pl(2);
      if (this.jdField_e_of_type_ComTencentWidgetListView != null)
      {
        localObject = this.jdField_e_of_type_ComTencentWidgetListView.getAdapter();
        if ((localObject instanceof auts))
        {
          localObject = ((auts)localObject).getWrappedAdapter();
          if ((localObject instanceof ndi)) {
            ((ndi)localObject).j(this.jdField_e_of_type_ComTencentWidgetListView, 0);
          }
        }
      }
      if (this.mHandler != null)
      {
        this.mHandler.removeMessages(1);
        this.mHandler = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView != null) {
        this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onRelease();
      }
      if (this.jdField_a_of_type_Myi != null)
      {
        this.jdField_a_of_type_Myi.stop();
        this.jdField_a_of_type_Myi.release();
      }
      if (this.audioManager != null) {}
      try
      {
        this.audioManager.setStreamVolume(3, this.aKm, 4);
        knj.a().clean();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("KandianAdPandentMask", 2, "audioManager setStreamVolume error :" + localException.toString());
          }
        }
      }
    }
    
    void aEU() {}
    
    public void aEV()
    {
      if (this.audioManager != null)
      {
        int i = this.audioManager.getStreamVolume(3);
        if (i >= this.aKm) {
          this.agI = false;
        }
        i = (int)Math.ceil(i + this.iN);
        QLog.d("KandianAdPandent", 2, "updateVolume setVolume =  " + i);
        this.audioManager.setStreamVolume(3, i, 4);
      }
    }
    
    public void cc(View paramView)
    {
      if ((paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup))) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
    }
    
    public void mv(boolean paramBoolean)
    {
      if (paramBoolean) {
        return;
      }
      this.io.setVisibility(0);
      this.or.setVisibility(0);
    }
    
    public void mw(boolean paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer() != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().mMediaPlayer != null))
      {
        if (!paramBoolean) {
          break label70;
        }
        this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onResume();
      }
      label70:
      do
      {
        for (;;)
        {
          if (this.jdField_a_of_type_Myi != null)
          {
            if (!paramBoolean) {
              break;
            }
            if (this.jdField_a_of_type_Myi.isPause()) {
              this.jdField_a_of_type_Myi.start();
            }
          }
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().mMediaPlayer.isPlaying()) {
            this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onPause();
          }
        }
      } while (!this.jdField_a_of_type_Myi.isPlaying());
      this.jdField_a_of_type_Myi.pause();
    }
    
    public void n(ViewGroup paramViewGroup)
    {
      cc(this.videoView);
      cc(this.io);
      cc(this.or);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
      localLayoutParams.addRule(13, -1);
      paramViewGroup.addView(this.videoView, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
      localLayoutParams.height = aqcx.dip2px(this.mActivity, 27.0F);
      localLayoutParams.width = aqcx.dip2px(this.mActivity, 72.0F);
      localLayoutParams.rightMargin = aqcx.dip2px(this.mActivity, 20.0F);
      localLayoutParams.topMargin = aqcx.dip2px(this.mActivity, 60.0F);
      localLayoutParams.addRule(11, -1);
      paramViewGroup.addView(this.or, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
      localLayoutParams.height = aqcx.dip2px(this.mActivity, 26.0F);
      localLayoutParams.width = aqcx.dip2px(this.mActivity, 26.0F);
      localLayoutParams.rightMargin = aqcx.dip2px(this.mActivity, 2.0F);
      localLayoutParams.addRule(6, 2131369992);
      localLayoutParams.addRule(8, 2131369992);
      localLayoutParams.addRule(0, 2131369992);
      paramViewGroup.addView(this.io, localLayoutParams);
    }
    
    public void onClick(View paramView)
    {
      Object localObject;
      label78:
      long l;
      switch (paramView.getId())
      {
      default: 
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      case 2131370007: 
        knj.a().pm(1);
        kkw localkkw = knj.a().d.mAdvertisementExtInfo;
        if (this.agH)
        {
          localObject = "1";
          localkkw.aas = ((String)localObject);
          if ((this.jdField_e_of_type_ComTencentWidgetListView == null) || (this.jdField_e_of_type_ComTencentWidgetListView.getAdapter() == null) || (!(this.jdField_e_of_type_ComTencentWidgetListView.getAdapter() instanceof auts))) {
            break label348;
          }
          localObject = (auts)this.jdField_e_of_type_ComTencentWidgetListView.getAdapter();
          if ((((auts)localObject).getWrappedAdapter() == null) || (!(((auts)localObject).getWrappedAdapter() instanceof ndh))) {
            break label348;
          }
          localObject = (ndh)((auts)localObject).getWrappedAdapter();
          if (localObject != null)
          {
            ((ndh)localObject).a = ods.a(getContext(), knj.a().d, (ndi)localObject, 0, false, null);
            if (((ndh)localObject).a == null) {
              break label251;
            }
            l = SystemClock.elapsedRealtime();
            label196:
            ((ndh)localObject).sr = l;
          }
        }
        break;
      }
      for (;;)
      {
        knj.a().d.clickPos = 11;
        ods.a(this.mActivity, knj.a().d, (ndi)localObject, 0, false, false, null);
        knj.agB = false;
        aEZ();
        break;
        localObject = "0";
        break label78;
        label251:
        l = -2147483648L;
        break label196;
        knj.a().pm(jzk.aFl);
        this.agH = false;
        aEW();
        aEY();
        break;
        if (this.agH)
        {
          knj.a().d.mAdvertisementExtInfo.aas = "0";
          knj.a().pm(jzk.aFm);
        }
        for (;;)
        {
          aEW();
          break;
          knj.a().d.mAdvertisementExtInfo.aas = "1";
          knj.a().pm(jzk.aFn);
        }
        label348:
        localObject = null;
      }
    }
    
    public void po(int paramInt)
    {
      if (this.aS.findViewById(2131370007) == null)
      {
        pp(paramInt);
        this.aS.addView(this);
        this.isShowing = true;
      }
    }
    
    public void startTimer()
    {
      if ((this.aKm == 0) || (this.audioManager == null)) {
        return;
      }
      this.mHandler.removeMessages(1);
      this.audioManager.setStreamVolume(3, 0, 4);
      this.sA = System.currentTimeMillis();
      this.mHandler.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.KandianAdPandentMask
 * JD-Core Version:    0.7.0.1
 */