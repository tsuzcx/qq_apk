package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import anxu;
import anxw;
import anxx;
import anyk;
import aqmj;
import awit;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kbp;
import kxm.b;
import mfo;
import nhf;
import nhg;
import nhh;
import org.json.JSONException;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tlb;

public class ReadInJoySkinSlideDownView
  extends RelativeLayout
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  protected boolean Yp;
  private int aYF;
  private String afn;
  private String alm;
  private boolean asb;
  private anxx b;
  public SpriteNativeView b;
  private View.OnClickListener cv;
  private View.OnClickListener cw;
  private int mChannelId;
  private Context mContext;
  public MediaPlayer mMediaPlayer;
  ViewTreeObserver mViewTreeObserver;
  
  public ReadInJoySkinSlideDownView(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mChannelId = paramInt1;
    this.afn = paramString1;
    this.alm = paramString2;
    this.aYF = paramInt2;
    this.cv = paramOnClickListener1;
    this.cw = paramOnClickListener3;
    LayoutInflater.from(getContext()).inflate(2131562928, this);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView = ((SpriteNativeView)findViewById(2131378464));
    setClickable(true);
    this.mViewTreeObserver = getViewTreeObserver();
    this.mViewTreeObserver.addOnGlobalLayoutListener(this);
  }
  
  private void a(int paramInt, Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    new anyk().a(paramString2).a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.getWidth()).a(new nhh(this, paramOnClickListener1, paramString1, paramInt, paramString2, paramContext, paramOnClickListener2)).a(new nhg(this)).a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView, new nhf(this));
  }
  
  private void i(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject1 = this.mContext;
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof BaseActivity))
    {
      aqmj.aJ((Context)localObject1, ((BaseActivity)localObject1).getCurrentAccountUin());
      localObject2 = (BaseActivity)localObject1;
      localObject3 = (mfo)((BaseActivity)localObject2).app.getManager(270);
      localObject1 = ((mfo)localObject3).jL();
      localObject2 = ((mfo)localObject3).a((Context)localObject2, 0);
      localObject3 = new kxm.b();
    }
    for (;;)
    {
      try
      {
        ((kxm.b)localObject3).c().d().a(paramInt1).f().g().h().i().d(0).e(2).b();
        if (TextUtils.isEmpty(paramString)) {}
        ((kxm.b)localObject3).a("jump_url", paramString);
        ((kxm.b)localObject3).a("guide_id", (String)localObject1);
        ((kxm.b)localObject3).a("jump_url_type", paramInt2);
        if ((localObject2 == null) || (!((RefreshData)localObject2).isAD)) {
          continue;
        }
        paramInt1 = 1;
        ((kxm.b)localObject3).a("ad_page", paramInt1);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      kbp.a(null, "CliOper", "", "", "0X800969C", "0X800969C", 0, 0, awit.sn("default_feeds_proteus_offline_bid"), "", "", ((kxm.b)localObject3).build(), false);
      if ((localObject2 != null) && (((RefreshData)localObject2).isAD) && (((RefreshData)localObject2).adClickReports != null) && (((RefreshData)localObject2).adClickReports.size() > 0)) {}
      try
      {
        paramString = new qq_ad_get.QQAdGetRsp.AdInfo();
        long l = ((RefreshData)localObject2).adId.longValue();
        paramString.report_info.trace_info.aid.set(l);
        paramString.report_info.thirdparty_monitor_urls.api_click_monitor_url.set(((RefreshData)localObject2).getUrls(((RefreshData)localObject2).adClickReports));
        tlb.a(1, 1, paramString);
        return;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
      }
      paramInt1 = 0;
    }
  }
  
  public String getJumpUrl()
  {
    Iterator localIterator = this.jdField_b_of_type_Anxx.getChildren().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (anxu)localIterator.next();
      if ((localObject instanceof anxw))
      {
        localObject = ((anxw)localObject).on();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("close")) && (!((String)localObject).equals("open_sound")) && (!((String)localObject).equals("use_skin"))) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void onDestroy()
  {
    if (!this.Yp)
    {
      this.Yp = true;
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.onDestroy();
    }
    if (this.mMediaPlayer != null) {}
    try
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      if (this.mViewTreeObserver != null)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          if (this.mViewTreeObserver.isAlive()) {
            this.mViewTreeObserver.removeOnGlobalLayoutListener(this);
          }
          this.mViewTreeObserver = null;
        }
      }
      else {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(localException));
          continue;
          if (this.mViewTreeObserver.isAlive()) {
            this.mViewTreeObserver.removeGlobalOnLayoutListener(this);
          }
        }
      }
    }
  }
  
  public void onGlobalLayout()
  {
    if ((this.asb) || (getWidth() <= 0) || (getHeight() <= 0)) {
      return;
    }
    this.asb = true;
    if (Build.VERSION.SDK_INT >= 16) {
      if (this.mViewTreeObserver.isAlive()) {
        this.mViewTreeObserver.removeOnGlobalLayoutListener(this);
      }
    }
    for (;;)
    {
      this.mViewTreeObserver = null;
      a(this.mChannelId, this.mContext, this.afn, this.alm, this.cv, this.cw);
      return;
      if (this.mViewTreeObserver.isAlive()) {
        this.mViewTreeObserver.removeGlobalOnLayoutListener(this);
      }
    }
  }
  
  public void onPause()
  {
    if (this.mMediaPlayer != null) {}
    try
    {
      this.mMediaPlayer.pause();
      this.mMediaPlayer.seekTo(0);
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.onPause();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(localException));
        }
      }
    }
  }
  
  public void onResume()
  {
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinSlideDownView
 * JD-Core Version:    0.7.0.1
 */