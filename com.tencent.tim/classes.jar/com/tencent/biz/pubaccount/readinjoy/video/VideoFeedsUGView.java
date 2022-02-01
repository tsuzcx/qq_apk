package com.tencent.biz.pubaccount.readinjoy.video;

import alkw;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqiz;
import aqmj;
import arvv;
import aryx;
import com.tencent.biz.pubaccount.VideoInfo.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import javax.annotation.Nullable;
import kfq;
import mqq.os.MqqHandler;
import muj;
import mxw;
import mxw.a;
import mxx;
import wja;

public class VideoFeedsUGView
  extends RelativeLayout
  implements View.OnClickListener, aryx
{
  public static mxw a = new mxw();
  RectF E = new RectF();
  Paint aB = new Paint();
  private String akG = "";
  public String akH;
  public VideoInfo.a c;
  ImageView ke;
  ImageView kf;
  ImageView mCloseView;
  Path mPath;
  int mProgress = 0;
  TextView sn;
  
  public VideoFeedsUGView(@NonNull Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
    setOnClickListener(this);
  }
  
  public VideoFeedsUGView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
    setOnClickListener(this);
  }
  
  private void aTB()
  {
    if (this.c == null) {
      return;
    }
    try
    {
      this.sn.setTextColor(Color.parseColor(this.c.XD));
      label25:
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = wja.dp2px(153.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = wja.dp2px(28.0F, getResources());
      setBackgroundDrawable(URLDrawable.getDrawable(this.c.Xz, (URLDrawable.URLDrawableOptions)localObject));
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = wja.dp2px(24.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = wja.dp2px(24.0F, getResources());
      localObject = URLDrawable.getDrawable(this.c.XA, (URLDrawable.URLDrawableOptions)localObject);
      this.ke.setImageDrawable((Drawable)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = wja.dp2px(95.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = wja.dp2px(14.0F, getResources());
      localObject = URLDrawable.getDrawable(this.c.XB, (URLDrawable.URLDrawableOptions)localObject);
      this.kf.setImageDrawable((Drawable)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = wja.dp2px(8.0F, getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = wja.dp2px(8.0F, getResources());
      localObject = URLDrawable.getDrawable(this.c.XC, (URLDrawable.URLDrawableOptions)localObject);
      this.mCloseView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  private void initView(Context paramContext)
  {
    this.ke = new ImageView(paramContext);
    this.ke.setId(1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(24.0F, getResources()), wja.dp2px(24.0F, getResources()));
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(9);
    localLayoutParams.leftMargin = wja.dp2px(8.0F, getResources());
    this.ke.setLayoutParams(localLayoutParams);
    addView(this.ke, localLayoutParams);
    this.kf = new ImageView(paramContext);
    this.kf.setId(2);
    localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(95.0F, getResources()), wja.dp2px(14.0F, getResources()));
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = wja.dp2px(4.0F, getResources());
    this.kf.setLayoutParams(localLayoutParams);
    addView(this.kf, localLayoutParams);
    this.sn = new TextView(paramContext);
    this.sn.setId(3);
    this.sn.setTextSize(11.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 1);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = wja.dp2px(6.0F, getResources());
    localLayoutParams.leftMargin = wja.dp2px(4.0F, getResources());
    localLayoutParams.bottomMargin = 1;
    this.sn.setLayoutParams(localLayoutParams);
    addView(this.sn, localLayoutParams);
    this.mCloseView = new ImageView(paramContext);
    this.mCloseView.setPadding(wja.dp2px(4.0F, getResources()), wja.dp2px(4.0F, getResources()), wja.dp2px(4.0F, getResources()), wja.dp2px(4.0F, getResources()));
    this.mCloseView.setOnClickListener(new mxx(this));
    paramContext = new RelativeLayout.LayoutParams(wja.dp2px(16.0F, getResources()), wja.dp2px(16.0F, getResources()));
    paramContext.addRule(11);
    paramContext.addRule(15);
    paramContext.rightMargin = wja.dp2px(4.0F, getResources());
    this.mCloseView.setLayoutParams(paramContext);
    addView(this.mCloseView, paramContext);
  }
  
  private void oI(boolean paramBoolean)
  {
    if (this.c == null)
    {
      setVisibility(8);
      return;
    }
    if (!DateUtils.isToday(aqmj.bd("ug_prefix_ug_1get3_ug_show_time")))
    {
      aqmj.bn("ug_prefix_ug_1get3_ug_show_time", System.currentTimeMillis());
      aqmj.go("ug_prefix_ug_1get3_ug_click_count" + this.c.XM, 0);
      aqmj.go("ug_prefix_ug_1get3_ug_exp_count" + this.c.XM, 0);
    }
    if (DateUtils.isToday(aqmj.bd("ug_prefix_ug_1get3_ug_close_time")))
    {
      setVisibility(8);
      return;
    }
    if (aqmj.fl("ug_prefix_ug_1get3_ug_click_count" + this.c.XM) >= this.c.aHu)
    {
      setVisibility(8);
      return;
    }
    if (aqmj.fl("ug_prefix_ug_1get3_ug_exp_count" + this.c.XM) >= this.c.aHv)
    {
      setVisibility(8);
      return;
    }
    if ((this.c.aHw == 1) && (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), this.c.XI)))
    {
      setVisibility(8);
      return;
    }
    if ((this.c.aHw == 2) && (!aqiz.isAppInstalled(BaseApplicationImpl.getContext(), this.c.XI)))
    {
      setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      aqmj.go("ug_prefix_ug_1get3_ug_exp_count" + this.c.XM, aqmj.fl("ug_prefix_ug_1get3_ug_exp_count" + this.c.XM) + 1);
      kfq.ma(kfq.p(this.c.XH, "2", this.akH));
    }
    setVisibility(0);
    if (this.c.aHw == 2)
    {
      this.mProgress = 0;
      this.kf.setVisibility(0);
      this.sn.setVisibility(8);
    }
    DownloadInfo localDownloadInfo;
    for (;;)
    {
      aTB();
      invalidate();
      return;
      localDownloadInfo = arvv.a().e(this.c.XE);
      if (localDownloadInfo != null) {
        break;
      }
      this.mProgress = 0;
      this.kf.setVisibility(0);
      this.sn.setVisibility(8);
    }
    this.kf.setVisibility(8);
    this.sn.setVisibility(0);
    if (localDownloadInfo.getState() == 4) {
      this.sn.setText(this.c.XL);
    }
    for (;;)
    {
      this.mProgress = localDownloadInfo.progress;
      break;
      if ((localDownloadInfo.getState() == 20) || (localDownloadInfo.getState() == 1) || (localDownloadInfo.getState() == 2)) {
        this.sn.setText(this.c.XJ + localDownloadInfo.progress + "%");
      } else {
        this.sn.setText(this.c.XK);
      }
    }
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.8(this, paramString2));
  }
  
  public void onClick(View paramView)
  {
    if (this.c == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.c.aHw == 2)
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_kandian_videos");
        ((Intent)localObject).setData(Uri.parse(this.c.XF));
        if (muj.isIntentAvailable(getContext(), (Intent)localObject)) {
          getContext().startActivity((Intent)localObject);
        }
        kfq.ma(kfq.p(this.c.XH, "7", this.akH));
        aqmj.go("ug_prefix_ug_1get3_ug_click_count" + this.c.XM, aqmj.fl("ug_prefix_ug_1get3_ug_click_count" + this.c.XM) + 1);
        continue;
      }
      Object localObject = new mxw.a();
      ((mxw.a)localObject).akF = this.c.XE;
      ((mxw.a)localObject).akD = this.c.XH;
      ((mxw.a)localObject).akE = this.akH;
      a.a(this.c.XI, (mxw.a)localObject);
      arvv.a().a(a);
      localObject = this.c.XG;
      try
      {
        ClipboardManager localClipboardManager = (ClipboardManager)getContext().getSystemService("clipboard");
        alkw.a(localClipboardManager, (CharSequence)localObject);
        localClipboardManager.setText((CharSequence)localObject);
        label263:
        kfq.ma(kfq.p(this.c.XH, "3", this.akH));
        this.sn.setVisibility(0);
        this.kf.setVisibility(8);
        localObject = arvv.a().e(this.c.XE);
        if (localObject == null)
        {
          localObject = new DownloadInfo();
          ((DownloadInfo)localObject).urlStr = this.c.XE;
          ((DownloadInfo)localObject).source = "biz_src_kandian_videos";
          ((DownloadInfo)localObject).packageName = this.c.XI;
          arvv.a().b((DownloadInfo)localObject);
          aqmj.go("ug_prefix_ug_1get3_ug_click_count" + this.c.XM, aqmj.fl("ug_prefix_ug_1get3_ug_click_count" + this.c.XM) + 1);
          kfq.ma(kfq.p(this.c.XH, "9", this.akH));
          kfq.ma(kfq.p(this.c.XH, "10", this.akH));
          this.sn.setText(this.c.XJ + "0%");
          this.mProgress = 0;
          continue;
        }
        if (((DownloadInfo)localObject).getState() == 4)
        {
          kfq.ma(kfq.p(this.c.XH, "102", this.akH));
          kfq.ma(kfq.p(this.c.XH, "20", this.akH));
          if (!arvv.a().d((DownloadInfo)localObject)) {
            arvv.a().b((DownloadInfo)localObject);
          }
          aqmj.go("ug_prefix_ug_1get3_ug_click_count" + this.c.XM, aqmj.fl("ug_prefix_ug_1get3_ug_click_count" + this.c.XM) + 1);
          this.sn.setText(this.c.XL);
          continue;
        }
        if ((((DownloadInfo)localObject).getState() == 30) || (((DownloadInfo)localObject).getState() == 10) || (((DownloadInfo)localObject).getState() == 20) || (((DownloadInfo)localObject).getState() == 1) || (((DownloadInfo)localObject).getState() == 2))
        {
          kfq.ma(kfq.p(this.c.XH, "22", this.akH));
          arvv.a().fx(this.c.XE);
          this.sn.setText(this.c.XK);
          continue;
        }
        arvv.a().b((DownloadInfo)localObject);
        aqmj.go("ug_prefix_ug_1get3_ug_click_count" + this.c.XM, aqmj.fl("ug_prefix_ug_1get3_ug_click_count" + this.c.XM) + 1);
        kfq.ma(kfq.p(this.c.XH, "10", this.akH));
        this.sn.setText(this.c.XJ + ((DownloadInfo)localObject).progress + "%");
        this.mProgress = ((DownloadInfo)localObject).progress;
      }
      catch (Throwable localThrowable)
      {
        break label263;
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.5(this, paramDownloadInfo));
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.7(this, paramDownloadInfo));
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.4(this, paramDownloadInfo));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.2(this, paramDownloadInfo));
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.6(this, paramList));
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.3(this, paramDownloadInfo));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.c != null) && (this.mProgress != 0))
    {
      paramCanvas.save();
      if (this.mPath == null)
      {
        this.mPath = new Path();
        this.mPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), wja.dp2px(14.0F, getResources()), wja.dp2px(14.0F, getResources()), Path.Direction.CW);
      }
      paramCanvas.clipPath(this.mPath, Region.Op.INTERSECT);
      this.E.set(0.0F, 0.0F, getWidth() * this.mProgress / 100.0F, getHeight());
      this.aB.setColor(1291845631);
      paramCanvas.drawRect(this.E, this.aB);
      paramCanvas.restore();
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void reset()
  {
    this.c = null;
  }
  
  public void setActive(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      arvv.a().a(this);
      oI(true);
      return;
    }
    arvv.a().b(this);
  }
  
  public void setInfo(VideoInfo.a parama, String paramString1, String paramString2)
  {
    this.akG = paramString1;
    this.akH = paramString2;
    this.c = parama;
    oI(false);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGView.9(this, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView
 * JD-Core Version:    0.7.0.1
 */