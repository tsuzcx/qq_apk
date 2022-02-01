package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import acfp;
import alkw;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import annt;
import aurr;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.os.MqqHandler;
import pmi;
import pmm;
import pmq;
import pnh;
import pno;
import pno.a;
import psr;
import psu;
import psx;
import ptk;
import pty;
import pty.a;
import puh;
import pyg;
import qee;
import qef;
import qef.a;
import qem;
import qem.d;
import qgk;
import qgy.f;
import qjq;
import qjv;
import qjw;
import qjy;
import qjz;
import qka;
import qkb;
import qkc;
import qkd;
import qke;
import qkf;
import qkg;
import qkh;
import qki;
import qkj;
import qkk;
import qkl;
import qkm;
import qkn;
import qko;
import qkp;
import qkq;
import qkr;
import qks;
import qkt;
import qlb;
import qlc;
import qle.a;
import qlo;
import ram;
import rar;
import rom;
import rpq;
import rrq;

public class VideoViewVideoHolder
  extends qjw
  implements View.OnClickListener
{
  public static final SparseArray<int[]> aN = new qjz();
  public static final String[] bU = { "s_Idle", "s_VideoInfo", "s_VideoInfo_OK", "s_DoodleDown", "s_DoodleDown_OK", "s_VideoFile", "s_VideoFile_OK", "s_Prepare", "s_Prepare_OK", "s_Starting", "s_Playing_OK", "s_Pause", "s_Complete_OK" };
  private static final String[] bV = { "SE", "VI", "DD", "SV", "VD", "SP", "VP", "HC" };
  private long AP;
  private long AQ;
  private long AR;
  private long AS;
  public QQStoryVideoPlayerErrorView a;
  public e a;
  public QQStoryLoadingView a;
  private pyg jdField_a_of_type_Pyg = new pyg();
  public qlb a;
  private qle.a jdField_a_of_type_Qle$a = new qle.a();
  public rrq a;
  private boolean aDL;
  private boolean aDM;
  private boolean aDN;
  private boolean aDO;
  String axA = null;
  private String axB;
  private String axC;
  private String axD;
  Stream jdField_b_of_type_ComTribeAsyncReactiveStream = null;
  private qef jdField_b_of_type_Qef;
  qem.d jdField_b_of_type_Qem$d = new qkc(this);
  private Handler bi = new Handler(Looper.getMainLooper());
  private int bmC = 0;
  public int bmD;
  private int bmE;
  private int bmF;
  private int bmG;
  public int bmH = 3;
  private int bmI;
  private int bmJ;
  private int bmK;
  private int bufferingCount;
  private Button cf;
  private Button ci;
  private Button ck;
  private Bitmap cr;
  private j d;
  private int[] dM = new int[6];
  private int decodeType;
  private int errorCode;
  public ImageView fV = (ImageView)this.mItemView.findViewById(2131365490);
  private Map<String, Long> fW = new VideoViewVideoHolder.12(this);
  public ImageView mMaskView = (ImageView)this.mItemView.findViewById(2131371168);
  private View oi;
  public String videoUrl;
  private TextView xi;
  
  public VideoViewVideoHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$e = new e(null);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramViewGroup.findViewById(2131370787));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramViewGroup.findViewById(2131381769));
    this.oi = this.mItemView.findViewById(2131379390);
    this.xi = ((TextView)this.mItemView.findViewById(2131379389));
    this.cf = ((Button)this.mItemView.findViewById(2131379387));
    this.cf.setOnClickListener(this);
    this.ci = ((Button)this.mItemView.findViewById(2131379391));
    this.ci.setOnClickListener(this);
    this.ck = ((Button)this.mItemView.findViewById(2131379388));
    this.ck.setOnClickListener(this);
  }
  
  private void D(long paramLong, String paramString)
  {
    L("HC", SystemClock.uptimeMillis());
    this.aDN = true;
    ram.d(this.TAG, "hideCover, hide loading view");
    this.fV.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    boI();
    this.axD = this.jdField_a_of_type_Qjq.vid;
    boM();
    this.bi.postDelayed(new VideoViewVideoHolder.11(this), 600L);
    this.d.c(this, this.jdField_a_of_type_Qlb);
  }
  
  private void L(String paramString, long paramLong)
  {
    if (this.aDO)
    {
      this.fW.put(paramString, Long.valueOf(paramLong));
      boJ();
    }
  }
  
  private void a(qjq paramqjq, qlb paramqlb, int paramInt)
  {
    if (!TextUtils.equals(this.axD, this.jdField_a_of_type_Qjq.vid)) {
      return;
    }
    String str = rar.getNetworkType(n());
    qle.a locala = paramqlb.a();
    long l1;
    long l2;
    if (locala.duration == 0L)
    {
      l1 = paramqlb.getDuration();
      if (paramInt != 1) {
        break label102;
      }
      l2 = l1;
    }
    for (;;)
    {
      Bosses.get().postJob(new qke(this, this.TAG, paramqjq, l1, l2, paramInt, str));
      return;
      l1 = locala.duration;
      break;
      label102:
      if (locala.duration == 0L) {
        l2 = paramqlb.getCurrentPosition();
      } else {
        l2 = locala.AW;
      }
    }
  }
  
  public static boolean a(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void b(qjq paramqjq, qlb paramqlb, int paramInt)
  {
    StoryVideoItem localStoryVideoItem = paramqjq.b();
    if (localStoryVideoItem == null) {
      ram.e(this.TAG, "video info empty , report error! vid :%s", new Object[] { paramqjq.vid });
    }
    while (!TextUtils.equals(this.axD, this.jdField_a_of_type_Qjq.vid)) {
      return;
    }
    paramqjq = rar.getNetworkType(n());
    qle.a locala = paramqlb.a();
    long l1;
    long l2;
    if (locala.duration == 0L)
    {
      l1 = paramqlb.getDuration();
      if (paramInt != 1) {
        break label133;
      }
      l2 = l1;
    }
    for (;;)
    {
      Bosses.get().postJob(new qkf(this, this.TAG, localStoryVideoItem, l1, l2, paramInt, paramqjq));
      return;
      l1 = locala.duration;
      break;
      label133:
      if (locala.duration == 0L) {
        l2 = paramqlb.getCurrentPosition();
      } else {
        l2 = locala.AW;
      }
    }
  }
  
  private void boF()
  {
    sG(false);
  }
  
  private void boI()
  {
    Object localObject;
    long l;
    int i;
    String str;
    if (this.fW.containsKey("SE"))
    {
      localObject = "SE";
      l = ((Long)this.fW.get("SE")).longValue();
      String[] arrayOfString = bV;
      int j = arrayOfString.length;
      i = 0;
      if (i < j)
      {
        str = arrayOfString[i];
        if (!str.equals("SE")) {}
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (this.fW.containsKey(str))
      {
        logEvent(String.format((Locale)null, acfp.m(2131716492), new Object[] { localObject, str, Long.valueOf(((Long)this.fW.get(str)).longValue() - l) }));
        l = ((Long)this.fW.get(str)).longValue();
        localObject = str;
        continue;
        if (this.aDO) {
          logEvent(String.format((Locale)null, acfp.m(2131716473), new Object[] { Long.valueOf(((Long)this.fW.get("HC")).longValue() - ((Long)this.fW.get("SE")).longValue()) }));
        }
        return;
      }
    }
  }
  
  private void boJ()
  {
    this.oi.setVisibility(8);
    this.xi.setVisibility(8);
    this.cf.setVisibility(8);
    this.ci.setVisibility(8);
    this.ck.setVisibility(8);
  }
  
  private void boK()
  {
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.tW() == 0)))
    {
      bool1 = true;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView == null) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.getVisibility() != 0)) {
        break label224;
      }
    }
    label224:
    for (boolean bool2 = true;; bool2 = false)
    {
      int i = this.bmK;
      int j = this.errorCode;
      int k = this.bmI;
      int m = this.jdField_a_of_type_Qlb.getPlayType();
      String str1 = this.axD;
      String str2 = this.jdField_a_of_type_Qjq.vid;
      String str3 = this.axC;
      String str4 = this.videoUrl;
      long l = this.AS;
      int n = this.bufferingCount;
      int i1 = this.bmJ;
      int i2 = a().mReportData.from;
      Long localLong = (Long)this.fW.get("SE");
      qle.a locala = new qle.a(this.jdField_a_of_type_Qlb.a());
      Bosses.get().postJob(new qkd(this, this.TAG, bool1, i, localLong, bool2, j, k, m, str1, str2, i2, n, i1, locala, l, str3, str4));
      return;
      bool1 = false;
      break;
    }
  }
  
  private void boM()
  {
    if (!this.aDO) {
      return;
    }
    this.aDO = false;
    int i;
    StringBuilder localStringBuilder;
    long l2;
    long l1;
    int j;
    label265:
    Object localObject2;
    if ((!a().mReportData.hasReportFirstVideoTime) && ((TextUtils.equals(this.jdField_a_of_type_Qjq.vid, a().vid)) || (TextUtils.isEmpty(a().vid))))
    {
      i = 1;
      if (!a().mReportData.hasReportFirstVideoTime) {
        a().mReportData.hasReportFirstVideoTime = true;
      }
      localStringBuilder = new StringBuilder();
      l2 = a().mReportData.startActivityTimeStamp;
      long l3 = a().mReportData.activityOnCreateTimeStamp;
      long l4 = a().mReportData.initViewPagerUiTimeStamp;
      l1 = a().mReportData.initViewPagerDataTimeStamp;
      localStringBuilder.append("staAct").append(" ").append(0).append(" ");
      localStringBuilder.append("onCre").append(" ").append(l3 - l2).append(" ");
      localStringBuilder.append("initUi").append(" ").append(l4 - l2).append(" ");
      localStringBuilder.append("initData").append(" ").append(l1 - l2).append(" ");
      localObject1 = bV;
      int k = localObject1.length;
      j = 0;
      if (j >= k) {
        break label380;
      }
      localObject2 = localObject1[j];
      if (!this.fW.containsKey(localObject2)) {
        break label349;
      }
      l1 = ((Long)this.fW.get(localObject2)).longValue();
      localStringBuilder.append(localObject2).append(" ").append(l1 - l2).append(" ");
    }
    for (;;)
    {
      j += 1;
      break label265;
      i = 0;
      break;
      label349:
      localStringBuilder.append(localObject2).append(" ").append(l1 - l2).append(" ");
    }
    label380:
    if (i != 0)
    {
      l1 = ((Long)this.fW.get("HC")).longValue() - l2;
      logEvent(acfp.m(2131716478) + l1);
      if (i == 0) {
        break label666;
      }
      localObject1 = "CL ";
      if (this.jdField_a_of_type_Qlb.getPlayType() != 0) {
        break label674;
      }
      localObject1 = (String)localObject1 + "LO ";
      localObject1 = (String)localObject1 + this.jdField_a_of_type_Qlb.sI();
      localObject1 = (String)localObject1 + " ";
      if (!Jv()) {
        break label739;
      }
    }
    label443:
    label478:
    label739:
    for (Object localObject1 = (String)localObject1 + "TVK";; localObject1 = (String)localObject1 + "TEX")
    {
      this.AQ = l1;
      rar.b("play_video", "start_wait_time", a().mReportData.from, (int)l1, new String[] { localObject1, localStringBuilder.toString(), rar.getNetworkType(n()), this.jdField_a_of_type_Qjq.vid });
      return;
      l1 = ((Long)this.fW.get("HC")).longValue() - ((Long)this.fW.get("SE")).longValue();
      break;
      localObject1 = "SL ";
      break label443;
      if (this.jdField_a_of_type_Qlb.getPlayType() == 1)
      {
        localObject1 = (String)localObject1 + "ST ";
        break label478;
      }
      localObject1 = (String)localObject1 + "3 ";
      break label478;
    }
  }
  
  private void d(ErrorMessage paramErrorMessage)
  {
    ram.w(this.TAG, "onError. %d : %s", new Object[] { Integer.valueOf(paramErrorMessage.errorCode), paramErrorMessage.errorMsg });
    if (paramErrorMessage.errorCode == 0) {
      return;
    }
    switch (paramErrorMessage.errorCode)
    {
    default: 
      return;
    case 2: 
    case 3: 
    case 6: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.wh(1);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Qlb.setVisibility(8);
      this.mMaskView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new qkm(this, paramErrorMessage));
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setTipsText(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.getResources().getString(2131701939));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Qlb.setVisibility(8);
      this.mMaskView.setVisibility(8);
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Qlb.setVisibility(8);
      this.mMaskView.setVisibility(8);
      return;
    case 7: 
    case 14: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.wh(1);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Qlb.setVisibility(8);
      this.mMaskView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new qkn(this));
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.wh(1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_Qlb.setVisibility(8);
    this.mMaskView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new qka(this));
  }
  
  private void d(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    int i = paramStoryVideoItem.mVideoWidth;
    int j = paramStoryVideoItem.mVideoHeight;
    if ((TextUtils.equals(this.axB, paramStoryVideoItem.mVid)) || ((this.bmE == i) && (this.bmF == j) && (this.bmE > 0) && (this.bmF > 0) && (this.bmG == paramStoryVideoItem.playerScaleType)))
    {
      this.axB = paramStoryVideoItem.mVid;
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Qlb.getView();
    boolean bool = localObject1 instanceof TextureVideoView;
    int k = 0;
    int i2 = rpq.getScreenWidth(this.mItemView.getContext());
    int n = rpq.getScreenHeight(this.mItemView.getContext());
    double d1 = i / j;
    double d2 = i2 / n;
    int m;
    label174:
    label184:
    label205:
    float f2;
    label269:
    int i1;
    label277:
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    Object localObject2;
    if ((bool) && (i > 0) && (j > 0)) {
      if (d1 < 1.0D)
      {
        k = 1;
        if (d2 >= 1.0D) {
          break label763;
        }
        m = 1;
        if (k == m) {
          break label769;
        }
        bool = true;
        this.aDL = bool;
        if (!this.aDL) {
          break label921;
        }
        d1 = j / i;
        if (paramStoryVideoItem.playerScaleType != 1) {
          break label808;
        }
        float f1 = i2 / j;
        f2 = n / i;
        if (f1 >= f2) {
          break label775;
        }
        m = (int)(j * f1);
        k = (int)(i * f1);
        i = (n - k) / 2;
        j = 0;
        n = k;
        i1 = m;
        i2 = i;
        i3 = j;
        i4 = k;
        i5 = m;
        i6 = n;
        i7 = i1;
        if (this.aDL)
        {
          localObject2 = new Matrix();
          ((Matrix)localObject2).setScale(k / m, m / k, m / 2.0F, k / 2.0F);
          ((Matrix)localObject2).postRotate(90.0F, m / 2.0F, k / 2.0F);
          ((TextureVideoView)localObject1).setTransform((Matrix)localObject2);
          i7 = i1;
          i6 = n;
          i5 = m;
          i4 = k;
          i3 = j;
          i2 = i;
        }
      }
    }
    for (;;)
    {
      this.axB = paramStoryVideoItem.mVid;
      this.bmG = paramStoryVideoItem.playerScaleType;
      this.bmF = paramStoryVideoItem.mVideoHeight;
      this.bmE = paramStoryVideoItem.mVideoWidth;
      logEvent(acfp.m(2131716477) + i7 + acfp.m(2131716472) + i6 + acfp.m(2131716474) + String.valueOf(this.aDL));
      localObject2 = new StringBuilder().append(acfp.m(2131716471)).append(paramStoryVideoItem.mVideoDuration).append(acfp.m(2131716491)).append(paramStoryVideoItem.mVideoBytes);
      if (paramStoryVideoItem.mIsPicture == 1) {}
      for (localObject1 = acfp.m(2131716485);; localObject1 = "")
      {
        logEvent((String)localObject1);
        this.dM[0] = i7;
        this.dM[1] = i6;
        this.dM[2] = i5;
        this.dM[3] = i4;
        this.dM[4] = i3;
        this.dM[5] = i2;
        ram.d(this.TAG, "updateViewParam, videoWidth/videoHeight=%d/%d, layoutWidth/layoutHeight=%d/%d, leftMargin=%d, topMargin=%d, vid=%s", new Object[] { Integer.valueOf(this.dM[0]), Integer.valueOf(this.dM[1]), Integer.valueOf(this.dM[2]), Integer.valueOf(this.dM[3]), Integer.valueOf(this.dM[4]), Integer.valueOf(this.dM[5]), paramStoryVideoItem.mVid });
        f(this.jdField_a_of_type_Qlb.getView(), i5, i4, i3, i2);
        f(this.fV, i5, i4, i3, i2);
        f(this.mMaskView, i5, i4, i3, i2);
        return;
        k = 0;
        break;
        label763:
        m = 0;
        break label174;
        label769:
        bool = false;
        break label184;
        label775:
        m = (int)(j * f2);
        k = (int)(i * f2);
        i = 0;
        j = (i2 - m) / 2;
        break label269;
        label808:
        if (d2 >= d1)
        {
          k = (int)(i2 / d1);
          m = (int)(1.0D * (n - k) / 2.0D + 0.5D);
          i1 = j;
          n = i;
          i = m;
          j = 0;
          m = i2;
          break label277;
        }
        m = (int)(d1 * n);
        i2 = (int)(1.0D * (i2 - m) / 2.0D + 0.5D);
        k = n;
        i1 = j;
        n = i;
        i = 0;
        j = i2;
        break label277;
      }
      label921:
      k = i;
      i = j;
      j = k;
      break label205;
      i3 = 0;
      i4 = -1;
      i5 = -1;
      i2 = k;
      i6 = j;
      i7 = i;
    }
  }
  
  private void e(StoryVideoItem paramStoryVideoItem)
  {
    if ((!TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid)) && (!StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))) {
      this.jdField_a_of_type_Pyg.a(paramStoryVideoItem.mVid, paramStoryVideoItem.mOwnerUid, a().mReportData.from, false, paramStoryVideoItem.mCreateTime);
    }
    for (;;)
    {
      String str = paramStoryVideoItem.mOwnerUid;
      Object localObject = str;
      if (this.jdField_a_of_type_Qjq.h != null)
      {
        localObject = str;
        if (this.jdField_a_of_type_Qjq.h.nodeType == 13) {
          localObject = this.jdField_a_of_type_Qjq.h.unionId;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new ptk((String)localObject, paramStoryVideoItem);
        pmi.a().dispatch((Dispatcher.Dispatchable)localObject);
      }
      ((psu)psx.a(5)).rn(paramStoryVideoItem.mVid);
      ram.d(this.TAG, "Do play video. vid = %s", paramStoryVideoItem.mVid);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "not report play, vid = " + paramStoryVideoItem.mVid + " mOwnerUid:" + paramStoryVideoItem.mOwnerUid + ", myUin:" + QQStoryContext.a().getCurrentUid());
      }
    }
  }
  
  private boolean eE(int paramInt)
  {
    return a(paramInt, (int[])aN.get(this.bmC));
  }
  
  private boolean eF(int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool, "not - main - thread");
      if (!a(paramInt, (int[])aN.get(this.bmC))) {
        break;
      }
      ram.w(this.TAG, "changeState : %s => %s", new Object[] { bU[this.bmC], bU[paramInt] });
      this.bmC = paramInt;
      return true;
    }
    ram.d(this.TAG, new Throwable(), "changeState not allow ! current = %s, new = %s", new Object[] { bU[this.bmC], bU[paramInt] });
    annt.e(new IllegalStateException("changeState ! " + bU[this.bmC] + " -- " + bU[paramInt]));
    rom.assertTrue(false, "changeState not allow. current=" + bU[this.bmC] + ", new=" + bU[paramInt]);
    return false;
  }
  
  private static void f(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).width = paramInt1;
      ((ViewGroup.MarginLayoutParams)localObject).height = paramInt2;
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = paramInt3;
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = paramInt3;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramInt4;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt4;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void logEvent(@NonNull String paramString)
  {
    ram.d(this.TAG, paramString);
  }
  
  private void sG(boolean paramBoolean)
  {
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      bool = true;
      rom.assertTrue(bool, "not - main - thread");
      ram.a(this.TAG, "checkStateAndGoAhead. %s => %s. reset=%s", bU[this.bmC], bU[this.bmD], Boolean.valueOf(paramBoolean));
      if (!paramBoolean) {
        break label134;
      }
      this.axA = (bU[this.bmC] + " - " + bU[0]);
      this.jdField_b_of_type_ComTribeAsyncReactiveStream = Stream.of("");
      this.jdField_b_of_type_ComTribeAsyncReactiveStream.map(new g(null)).subscribe(new qkg(this));
    }
    label134:
    do
    {
      return;
      bool = false;
      break;
      if (this.bmC == this.bmD)
      {
        ram.b(this.TAG, "checkStateAndGoAhead. DONE => %s", bU[this.bmD]);
        return;
      }
      if (this.jdField_b_of_type_ComTribeAsyncReactiveStream != null)
      {
        ram.w(this.TAG, "checkStateAndGoAhead. do nothing. waiting ...");
        return;
      }
      if (this.bmD == 0)
      {
        sG(true);
        return;
      }
      if (this.bmD == 2)
      {
        if (this.bmC == 0)
        {
          this.axA = (bU[0] + " - " + bU[2]);
          this.jdField_b_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_Qjq);
          this.jdField_b_of_type_ComTribeAsyncReactiveStream.map(new a(null)).map(new h(null)).subscribe(new qkh(this));
          return;
        }
        sG(true);
        return;
      }
      if ((this.bmD == 8) || (this.bmD == 10))
      {
        if (this.bmC == 0)
        {
          if (this.jdField_a_of_type_Qjq != null)
          {
            this.axA = (bU[0] + " - " + bU[6]);
            this.jdField_b_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_Qjq);
            this.jdField_b_of_type_ComTribeAsyncReactiveStream.map(new a(null)).map(new h(null)).map(new c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$e)).map(new f(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$e, Jv())).subscribe(new qki(this));
            return;
          }
          ram.e(this.TAG, "mData is null");
          d(new ErrorMessage(0, "mData is null. un bind !"));
          return;
        }
        StoryVideoItem localStoryVideoItem;
        if (this.bmC == 2)
        {
          if (this.jdField_a_of_type_Qjq != null)
          {
            localStoryVideoItem = ((psu)psx.a(5)).b(this.jdField_a_of_type_Qjq.vid);
            if (localStoryVideoItem != null)
            {
              this.axA = (bU[2] + " - " + bU[6]);
              this.jdField_b_of_type_ComTribeAsyncReactiveStream = Stream.of(localStoryVideoItem);
              this.jdField_b_of_type_ComTribeAsyncReactiveStream.map(new c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$e)).map(new f(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$e, Jv())).subscribe(new qkj(this));
              return;
            }
            ram.e(this.TAG, "mData is null");
            d(new ErrorMessage(0, "Go To VideoFile. storyVideoItem is null. un bind !"));
            return;
          }
          ram.e(this.TAG, "mData is null");
          d(new ErrorMessage(0, "Go To VideoFile. mData is null. un bind !"));
          return;
        }
        if (this.bmC < 6)
        {
          sG(true);
          return;
        }
        if (this.bmC == 6)
        {
          localStoryVideoItem = ((psu)psx.a(5)).b(this.jdField_a_of_type_Qjq.vid);
          if (localStoryVideoItem != null)
          {
            this.axA = (bU[6] + " - " + bU[8]);
            this.jdField_b_of_type_ComTribeAsyncReactiveStream = Stream.of(localStoryVideoItem);
            this.jdField_b_of_type_ComTribeAsyncReactiveStream.map(new i(null)).subscribe(new qkk(this));
            return;
          }
          d(new ErrorMessage(12, "no videoInfo " + this.jdField_a_of_type_Qjq.vid));
          return;
        }
        if ((this.bmC == 7) || (this.bmC == 9) || (this.bmC == 12))
        {
          sG(true);
          return;
        }
        if ((this.bmD == 8) && ((this.bmC == 11) || (this.bmC == 10)))
        {
          sG(true);
          return;
        }
        if ((this.bmD == 10) && ((this.bmC == 11) || (this.bmC == 8)))
        {
          ram.b(this.TAG, "requestChangeState. current=%s, target=%s, start play", bU[this.bmC], bU[this.bmD]);
          localStoryVideoItem = ((psu)psx.a(5)).b(this.jdField_a_of_type_Qjq.vid);
          if (localStoryVideoItem != null)
          {
            this.axA = (bU[this.bmC] + " - " + bU[10]);
            this.jdField_b_of_type_ComTribeAsyncReactiveStream = Stream.of(localStoryVideoItem);
            this.jdField_b_of_type_ComTribeAsyncReactiveStream.map(new VideoStartSegment(null)).subscribe(new qkl(this));
            return;
          }
          d(new ErrorMessage(12, "no videoInfo " + this.jdField_a_of_type_Qjq.vid));
          return;
        }
        ram.e(this.TAG, "state error. currentTargetState = %s, currentState = %s", new Object[] { bU[this.bmD], bU[this.bmC] });
        return;
      }
    } while (this.bmD != 11);
    if (this.bmC == 10)
    {
      ram.b(this.TAG, "requestChangeState. current=%s, target=%s, pause video", bU[this.bmC], bU[this.bmD]);
      eF(11);
      this.jdField_a_of_type_Qlb.pause();
      return;
    }
    ram.w(this.TAG, "requestChangeState. current=%s, target=%s, ERROR !", new Object[] { bU[this.bmC], bU[this.bmD] });
  }
  
  private void wo(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Qjq.b();
    if (localObject == null)
    {
      av().setVisibility(8);
      return;
    }
    localObject = ((StoryVideoItem)localObject).getVideoLinkInfo();
    if ((localObject != null) && (((pty)localObject).IX()) && (((pty)localObject).a.IY()) && (a().mReportData.from != 86))
    {
      av().setVisibility(paramInt);
      return;
    }
    av().setVisibility(8);
  }
  
  public boolean JO()
  {
    if ((!JN()) || (!isSelected()) || (this.c == null)) {
      return false;
    }
    psr localpsr = (psr)psx.a(10);
    if ((this.c.nR.size() > 1) && (!localpsr.II()))
    {
      boH();
      if (this.jdField_a_of_type_Rrq != null) {
        this.jdField_a_of_type_Rrq.dismiss();
      }
      this.jdField_a_of_type_Rrq = new rrq(n());
      this.jdField_a_of_type_Rrq.setIsVertical(true);
      this.jdField_a_of_type_Rrq.sI(acfp.m(2131716479));
      this.jdField_a_of_type_Rrq.setOnDismissListener(new d(this, this.aDM));
      this.jdField_a_of_type_Rrq.show();
      localpsr.sd(true);
      return true;
    }
    if ((a().getAdapter().getCount() > 1) && (!localpsr.IJ()))
    {
      boH();
      if (this.jdField_a_of_type_Rrq != null) {
        this.jdField_a_of_type_Rrq.dismiss();
      }
      this.jdField_a_of_type_Rrq = new rrq(n());
      this.jdField_a_of_type_Rrq.sI(acfp.m(2131716481));
      this.jdField_a_of_type_Rrq.setOnDismissListener(new d(this, this.aDM));
      this.jdField_a_of_type_Rrq.show();
      localpsr.se(true);
      return true;
    }
    return false;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull qjq paramqjq, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    String str;
    if (this.jdField_a_of_type_Qjq != null)
    {
      str = this.jdField_a_of_type_Qjq.vid;
      super.a(paramInt1, paramInt2, paramqjq, paramStoryPlayerGroupHolder);
      ram.a(this.TAG, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.bmn), Integer.valueOf(this.bmB), paramqjq);
      boJ();
      this.fW.clear();
      if (paramqjq.vid.equals(str)) {
        break label95;
      }
    }
    label95:
    for (boolean bool = true;; bool = false)
    {
      c(2, bool, "onBind");
      return;
      str = null;
      break;
    }
  }
  
  public void a(j paramj)
  {
    this.d = paramj;
  }
  
  public void aK(int paramInt, String paramString)
  {
    c(paramInt, false, paramString);
  }
  
  public View au()
  {
    qjy localqjy = (qjy)a(qjy.class);
    if (localqjy != null) {
      return localqjy.oh;
    }
    return new View(n());
  }
  
  protected View av()
  {
    qjv localqjv = (qjv)a(qjv.class);
    if (localqjv != null) {
      return localqjv.mItemView;
    }
    return new View(n());
  }
  
  public void boG()
  {
    if ((this.bmC == 11) && (au().getVisibility() != 0)) {
      aK(10, "call resume");
    }
  }
  
  public void boH()
  {
    if ((this.bmC == 10) && (au().getVisibility() != 0)) {
      aK(11, "call Pause");
    }
  }
  
  public void boL()
  {
    if (!this.jdField_a_of_type_Qjq.JM()) {
      return;
    }
    int i = a().mReportData.from;
    if (qee.eD(i)) {
      b(this.jdField_a_of_type_Qjq, this.jdField_a_of_type_Qlb, this.bmH);
    }
    for (;;)
    {
      ram.a(this.TAG, "report video player done! vid :%s , from :%d , op_result: %d", this.jdField_a_of_type_Qjq.vid, Integer.valueOf(i), Integer.valueOf(this.bmH));
      return;
      a(this.jdField_a_of_type_Qjq, this.jdField_a_of_type_Qlb, this.bmH);
    }
  }
  
  public void boy()
  {
    super.boy();
    c(0, true, "unBind");
    if (this.jdField_a_of_type_Rrq != null) {
      this.jdField_a_of_type_Rrq.dismiss();
    }
  }
  
  public void c(int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool;
    if ((paramInt == 2) || (paramInt == 8) || (paramInt == 10) || (paramInt == 11) || (paramInt == 0))
    {
      bool = true;
      rom.assertTrue(bool);
      ram.a(this.TAG, "requestChangeState. START. current=%s, newTarget=%s. reset=%s, reason=%s", bU[this.bmC], bU[paramInt], Boolean.valueOf(paramBoolean), paramString);
      if ((this.bmD != paramInt) || (paramBoolean))
      {
        this.bmD = paramInt;
        if (!paramBoolean) {
          break label177;
        }
        if (this.jdField_b_of_type_ComTribeAsyncReactiveStream == null) {
          break label169;
        }
        ram.b(this.TAG, "cancel current stream : %s. current state = %s", this.axA, bU[this.bmC]);
        this.jdField_b_of_type_ComTribeAsyncReactiveStream.cancel();
        this.axA = null;
        this.jdField_b_of_type_ComTribeAsyncReactiveStream = null;
        boF();
      }
    }
    for (;;)
    {
      ram.a(this.TAG, "requestChangeState. DONE. current=%s, newTarget=%s. reset=%s, reason=%s", bU[this.bmC], bU[paramInt], Boolean.valueOf(paramBoolean), paramString);
      return;
      bool = false;
      break;
      label169:
      sG(true);
      continue;
      label177:
      if (this.jdField_b_of_type_ComTribeAsyncReactiveStream != null) {
        ram.d(this.TAG, "just waiting");
      } else {
        boF();
      }
    }
  }
  
  public void dU(int paramInt1, int paramInt2)
  {
    super.dU(paramInt1, paramInt2);
    logEvent(acfp.m(2131716486) + this.bmn + "-" + this.bmB);
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
      Object localObject1 = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
      Object localObject2 = ClipData.newPlainText("VideoInfo(" + this.jdField_a_of_type_Qjq.vid + ")", this.jdField_a_of_type_Qjq.vid);
      alkw.a((ClipboardManager)localObject1, (ClipData)localObject2);
      ((ClipboardManager)localObject1).setPrimaryClip((ClipData)localObject2);
      QQToast.a(paramView.getContext(), 2131696125, 0).show();
      continue;
      localObject1 = ((pmm)psx.a(4)).ml();
      if ((localObject1 != null) && (this.videoUrl != null))
      {
        localObject2 = ((pmq)psx.a(28)).e(aurr.addParameter(this.videoUrl, "authkey", (String)localObject1).replace("https://", "http://"));
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          localObject1 = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
          localObject2 = ClipData.newPlainText("VideoUrl(" + this.jdField_a_of_type_Qjq.vid + ")", localObject2[0]);
          alkw.a((ClipboardManager)localObject1, (ClipData)localObject2);
          ((ClipboardManager)localObject1).setPrimaryClip((ClipData)localObject2);
          QQToast.a(paramView.getContext(), 2131696125, 0).show();
          continue;
          localObject1 = pnh.a(this.jdField_a_of_type_Qjq.vid, 0, false, false);
          if ((localObject1 != null) && (((File)localObject1).exists()))
          {
            localObject2 = new Intent("android.intent.action.VIEW");
            ((Intent)localObject2).addFlags(268435456);
            ((Intent)localObject2).setDataAndType(Uri.parse(((File)localObject1).getParent()), "resource/folder");
            try
            {
              if (((Intent)localObject2).resolveActivityInfo(n().getPackageManager(), 0) == null) {
                break label367;
              }
              startActivity((Intent)localObject2);
            }
            catch (ActivityNotFoundException localActivityNotFoundException)
            {
              localActivityNotFoundException.printStackTrace();
            }
            continue;
            label367:
            QQToast.a(paramView.getContext(), acfp.m(2131716489), 0).show();
          }
        }
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Qlb = new qlc(new qlo(n(), String.valueOf(System.identityHashCode(this))));
    ram.b(this.TAG, "create video view, use-TVK=%s videoView=%s", Boolean.valueOf(Jv()), this.jdField_a_of_type_Qlb);
    ((ViewGroup)this.mItemView).addView(this.jdField_a_of_type_Qlb.getView(), 0, new RelativeLayout.LayoutParams(-1, -1));
    a(new qkb(this));
  }
  
  public View onCreateView(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public int sF()
  {
    if (this.jdField_a_of_type_Qjq.JM())
    {
      if (this.bmC != 10) {
        break label127;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0) {
        ram.w(this.TAG, "toggle video, PLAYING = > PAUSE. ignore because loading while playing");
      }
    }
    else
    {
      return 0;
    }
    ram.w(this.TAG, "toggle video, PLAYING = > PAUSE");
    au().setVisibility(0);
    aK(11, "toggle pause");
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    wo(0);
    rar.a("play_video", "exp_tips", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Qjq.vid });
    return 2;
    label127:
    if ((this.bmC == 11) && (au().getVisibility() == 0))
    {
      ram.w(this.TAG, "toggle video, PAUSE = > PLAYING");
      au().setVisibility(8);
      aK(10, "toggle start");
      wo(8);
      return 1;
    }
    ram.w(this.TAG, "toggle video, ignore. isPlaying=%s, hideCover=%s, visibility=%d", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Qlb.isPlaying()), Boolean.valueOf(this.aDN), Integer.valueOf(au().getVisibility()) });
    wo(8);
    return 0;
  }
  
  public void sF(boolean paramBoolean)
  {
    super.sF(paramBoolean);
    if (paramBoolean)
    {
      this.aDO = true;
      this.fW.clear();
      L("SE", SystemClock.uptimeMillis());
      this.AQ = 0L;
      this.AP = 0L;
      this.bmH = 3;
      this.bmK = 1;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "onSelectedChanged true");
      rar.b("play_video", "onSelectedState", 0, 0, new String[] { bU[this.bmC] });
      aK(10, "selected");
      rar.a("play_video", "exp", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_Qjq.vid });
    }
    for (;;)
    {
      this.bufferingCount = 0;
      this.AR = 0L;
      this.bmJ = 0;
      return;
      this.aDN = false;
      boL();
      boK();
      this.axD = null;
      this.fW.clear();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      au().setVisibility(8);
      av().setVisibility(8);
      c(0, true, "unSelected");
    }
  }
  
  public void sH(boolean paramBoolean)
  {
    ram.w(this.TAG, "setRepeatWhilePlayDone = %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.aDM = paramBoolean;
  }
  
  public void wp(int paramInt)
  {
    boJ();
  }
  
  class VideoStartSegment
    extends JobSegment<StoryVideoItem, StoryVideoItem>
    implements Runnable
  {
    long AV = 0L;
    StoryVideoItem g;
    
    private VideoStartSegment() {}
    
    private boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, TextureView paramTextureView, long paramLong)
    {
      if (paramTextureView.isAvailable())
      {
        if ((VideoViewVideoHolder.a(paramVideoViewVideoHolder) != null) && (VideoViewVideoHolder.a(paramVideoViewVideoHolder).getWidth() == paramTextureView.getWidth() / 16) && (VideoViewVideoHolder.a(paramVideoViewVideoHolder).getHeight() == paramTextureView.getHeight() / 16))
        {
          paramTextureView = paramTextureView.getBitmap(VideoViewVideoHolder.a(paramVideoViewVideoHolder));
          if (qgk.a(paramTextureView, 4, 16))
          {
            ram.b(paramVideoViewVideoHolder.TAG, "isCurrentFrameBlack CheckVideoViewRealStartRunnable find dark bitmap ! current = %d", Long.valueOf(paramLong));
            return true;
          }
        }
        else
        {
          if (VideoViewVideoHolder.a(paramVideoViewVideoHolder) != null) {
            VideoViewVideoHolder.a(paramVideoViewVideoHolder).recycle();
          }
          int i = paramTextureView.getWidth() / 16;
          int j = paramTextureView.getHeight() / 16;
          if ((i > 0) && (j > 0))
          {
            if (Build.VERSION.SDK_INT >= 17) {
              VideoViewVideoHolder.a(paramVideoViewVideoHolder, Bitmap.createBitmap(paramTextureView.getResources().getDisplayMetrics(), i, j, Bitmap.Config.ARGB_8888));
            }
            for (;;)
            {
              paramTextureView = paramTextureView.getBitmap(VideoViewVideoHolder.a(paramVideoViewVideoHolder));
              break;
              VideoViewVideoHolder.a(paramVideoViewVideoHolder, Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
            }
          }
          return false;
        }
        ram.w(VideoViewVideoHolder.this.TAG, "isCurrentFrameBlack StoryPlayerTest.isBlack false. treat as not-black frame");
      }
      for (;;)
      {
        return false;
        ram.w(VideoViewVideoHolder.this.TAG, "isCurrentFrameBlack targetView.isAvailable() false. treat as not-black frame");
      }
    }
    
    private void b(VideoViewVideoHolder paramVideoViewVideoHolder, long paramLong, String paramString)
    {
      VideoViewVideoHolder.a(paramVideoViewVideoHolder, paramLong, paramString);
      g(this.g);
    }
    
    protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
    {
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, 9);
      this.g = paramStoryVideoItem;
      if (VideoViewVideoHolder.this.c != null)
      {
        ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoStartSegment.1(this));
        if (!VideoViewVideoHolder.this.a().mUIStyle.mForDebug) {
          VideoViewVideoHolder.b(VideoViewVideoHolder.this, paramStoryVideoItem);
        }
        return;
      }
      ram.e(VideoViewVideoHolder.this.TAG, "onPrepared, is not on foreground, do not start video view !!");
      notifyError(new ErrorMessage(0, "onPrepared, is not on foreground"));
    }
    
    protected void g(StoryVideoItem paramStoryVideoItem)
    {
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, 10);
      super.notifyResult(paramStoryVideoItem);
    }
    
    public void onCancel()
    {
      super.onCancel();
      ram.d(VideoViewVideoHolder.this.TAG, "VideoStartSegment onCancel");
      VideoViewVideoHolder.this.a.stopPlayback();
    }
    
    public void run()
    {
      VideoViewVideoHolder localVideoViewVideoHolder = VideoViewVideoHolder.this;
      if (!localVideoViewVideoHolder.isSelected())
      {
        ram.w(localVideoViewVideoHolder.TAG, "!holder.isSelected() holder = %s", new Object[] { localVideoViewVideoHolder });
        notifyError(new ErrorMessage(0, "!holder.isSelected"));
        return;
      }
      if (VideoViewVideoHolder.e(VideoViewVideoHolder.this) == 1)
      {
        ram.w(VideoViewVideoHolder.this.TAG, "SOFT DECODE, waiting PLAYER_INFO_START_RENDERING");
        g(this.g);
        return;
      }
      long l1 = localVideoViewVideoHolder.a.getCurrentPosition();
      if (l1 > 0L)
      {
        TextureView localTextureView = qgk.a(localVideoViewVideoHolder.a.getView());
        if (localTextureView != null)
        {
          long l2 = SystemClock.uptimeMillis();
          boolean bool = a(localVideoViewVideoHolder, localTextureView, l1);
          ram.b(VideoViewVideoHolder.this.TAG, "check black cost %d ms", Long.valueOf(SystemClock.uptimeMillis() - l2));
          if (!bool)
          {
            b(localVideoViewVideoHolder, l1, "NotBlackFrame");
            return;
          }
          if (l1 > 500L)
          {
            b(localVideoViewVideoHolder, l1, "BlackFrame-TimeOut");
            return;
          }
          VideoViewVideoHolder.a(localVideoViewVideoHolder).postDelayed(this, 20L);
          return;
        }
        if (l1 > 100L)
        {
          b(localVideoViewVideoHolder, l1, "NoTextureView-TimeOut");
          return;
        }
        VideoViewVideoHolder.a(localVideoViewVideoHolder).postDelayed(this, 20L);
        return;
      }
      if (SystemClock.uptimeMillis() - this.AV > 4000L)
      {
        ram.w(VideoViewVideoHolder.this.TAG, "check black frame time out. holder = %s", new Object[] { localVideoViewVideoHolder });
        localVideoViewVideoHolder.a.stopPlayback();
        VideoViewVideoHolder.c(VideoViewVideoHolder.this, 14);
        notifyError(new ErrorMessage(VideoViewVideoHolder.b(VideoViewVideoHolder.this), "check black frame time out"));
        return;
      }
      VideoViewVideoHolder.a(localVideoViewVideoHolder).postDelayed(this, 20L);
    }
  }
  
  class a
    extends JobSegment<qjq, String>
  {
    private a() {}
    
    protected void a(JobContext paramJobContext, qjq paramqjq)
    {
      ram.d(VideoViewVideoHolder.this.TAG, "CheckDataSegment runSegment");
      if (VideoViewVideoHolder.this.jdField_a_of_type_Qjq.JK())
      {
        ram.d(VideoViewVideoHolder.this.TAG, "isLoadingData, show loading view");
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, 2);
        VideoViewVideoHolder.this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
        VideoViewVideoHolder.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
        VideoViewVideoHolder.this.jdField_a_of_type_Qlb.setVisibility(8);
        VideoViewVideoHolder.this.fV.setVisibility(8);
        VideoViewVideoHolder.this.mMaskView.setVisibility(8);
        notifyError(new ErrorMessage(0, "isLoadingData"));
        return;
      }
      if (VideoViewVideoHolder.this.jdField_a_of_type_Qjq.JL())
      {
        ram.w(VideoViewVideoHolder.this.TAG, "showPage, show error view, because this is a error data = %s", VideoViewVideoHolder.this.jdField_a_of_type_Qjq.c());
        VideoViewVideoHolder.b(VideoViewVideoHolder.this, VideoViewVideoHolder.this.jdField_a_of_type_Qjq.c().errorCode);
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, false);
        ram.w(VideoViewVideoHolder.this.TAG, "isErrorData, hide loading view. subErrorCode=%d", new Object[] { Integer.valueOf(VideoViewVideoHolder.a(VideoViewVideoHolder.this)) });
        if (VideoViewVideoHolder.a(VideoViewVideoHolder.this) == 97000000)
        {
          VideoViewVideoHolder.c(VideoViewVideoHolder.this, 4);
          notifyError(new ErrorMessage(VideoViewVideoHolder.b(VideoViewVideoHolder.this), "PLAY_DATA_NO_VID"));
          return;
        }
        VideoViewVideoHolder.c(VideoViewVideoHolder.this, 9);
        notifyError(new ErrorMessage(VideoViewVideoHolder.b(VideoViewVideoHolder.this), "isErrorData"));
        return;
      }
      if (StoryVideoItem.isFakeVid(VideoViewVideoHolder.this.jdField_a_of_type_Qjq.vid))
      {
        paramJobContext = ((psu)psx.a(5)).b(VideoViewVideoHolder.this.jdField_a_of_type_Qjq.vid);
        if (paramJobContext != null)
        {
          VideoViewVideoHolder.a(VideoViewVideoHolder.this, paramJobContext);
          VideoViewVideoHolder.this.fV.setVisibility(0);
          paramqjq = (String)VideoViewVideoHolder.this.fV.getTag();
          if (!TextUtils.equals(VideoViewVideoHolder.this.jdField_a_of_type_Qjq.vid, paramqjq))
          {
            VideoViewVideoHolder.this.fV.setTag(VideoViewVideoHolder.this.jdField_a_of_type_Qjq.vid);
            qem.a(VideoViewVideoHolder.this.fV, paramJobContext.mVideoLocalThumbnailPath, paramJobContext.getThumbUrl(), VideoViewVideoHolder.a(VideoViewVideoHolder.this), VideoViewVideoHolder.this.b);
          }
          ram.w(VideoViewVideoHolder.this.TAG, "showPage, show error view, because this is fake vid = %s", new Object[] { VideoViewVideoHolder.this.jdField_a_of_type_Qjq.vid });
          VideoViewVideoHolder.c(VideoViewVideoHolder.this, 5);
          VideoViewVideoHolder.a(VideoViewVideoHolder.this, false);
          notifyError(new ErrorMessage(VideoViewVideoHolder.b(VideoViewVideoHolder.this), "isFakeData"));
          return;
        }
        VideoViewVideoHolder.c(VideoViewVideoHolder.this, 11);
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, false);
        notifyError(new ErrorMessage(VideoViewVideoHolder.b(VideoViewVideoHolder.this), "Fake Vid No Data"));
        return;
      }
      notifyResult(VideoViewVideoHolder.this.jdField_a_of_type_Qjq.vid);
    }
    
    public void onCancel()
    {
      super.onCancel();
      ram.d(VideoViewVideoHolder.this.TAG, "CheckDataSegment onCancel");
    }
  }
  
  public class b<T>
    extends SimpleObserver<T>
  {
    private b() {}
    
    public void onCancel()
    {
      super.onCancel();
      ram.w(VideoViewVideoHolder.this.TAG, "stream : [%s]  CANCEL", new Object[] { VideoViewVideoHolder.this.axA });
      VideoViewVideoHolder.this.b = null;
      VideoViewVideoHolder.this.axA = null;
    }
    
    public void onError(@NonNull Error paramError)
    {
      super.onError(paramError);
      ram.w(VideoViewVideoHolder.this.TAG, "stream : [%s]  ERROR", new Object[] { VideoViewVideoHolder.this.axA });
      VideoViewVideoHolder.this.b = null;
      VideoViewVideoHolder.this.axA = null;
    }
    
    public void onNext(T paramT)
    {
      super.onNext(paramT);
      ram.w(VideoViewVideoHolder.this.TAG, "stream : [%s] DONE", new Object[] { VideoViewVideoHolder.this.axA });
      VideoViewVideoHolder.this.b = null;
      VideoViewVideoHolder.this.axA = null;
    }
  }
  
  class c
    extends JobSegment<StoryVideoItem, StoryVideoItem>
    implements pno.a
  {
    private VideoViewVideoHolder.e a;
    private StoryVideoItem g;
    
    public c(VideoViewVideoHolder.e parame)
    {
      this.a = parame;
    }
    
    protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
    {
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, 3);
      this.g = paramStoryVideoItem;
      int i = paramStoryVideoItem.isMaskDownloaded();
      if (i == 0)
      {
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, 4);
        VideoViewVideoHolder.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
        VideoViewVideoHolder.this.jdField_a_of_type_Qlb.setVisibility(8);
        ram.b(VideoViewVideoHolder.this.TAG, "wait doodle download and display ... %s", paramStoryVideoItem.getDownloadMaskUrl());
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, acfp.m(2131716480));
        this.a.a().a(paramStoryVideoItem.mVid, 1, true, this);
        return;
      }
      if (i == 1)
      {
        VideoViewVideoHolder.this.mMaskView.setVisibility(0);
        qem.a(VideoViewVideoHolder.this.mMaskView, paramStoryVideoItem.mLocalMaskPath, paramStoryVideoItem.getDownloadMaskUrl(), VideoViewVideoHolder.a(VideoViewVideoHolder.this));
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, acfp.m(2131716475));
      }
      for (;;)
      {
        g(paramStoryVideoItem);
        return;
        VideoViewVideoHolder.this.mMaskView.setVisibility(8);
      }
    }
    
    public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
    {
      if (!isCanceled())
      {
        ram.w(VideoViewVideoHolder.this.TAG, "wait doodle download and display error. vid :%s, error=%s", new Object[] { this.g.mVid, paramErrorMessage });
        VideoViewVideoHolder.c(VideoViewVideoHolder.this, 2);
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, false);
        VideoViewVideoHolder.b(VideoViewVideoHolder.this, paramErrorMessage.errorCode);
        notifyError(new ErrorMessage(VideoViewVideoHolder.b(VideoViewVideoHolder.this), "doodle download failed"));
        return;
      }
      ram.w(VideoViewVideoHolder.this.TAG, "wait doodle download and display error. stream canceled.");
    }
    
    public void bj(String paramString, int paramInt)
    {
      if (!isCanceled())
      {
        ram.w(VideoViewVideoHolder.this.TAG, "wait doodle download and display cancel. vid :%s", new Object[] { this.g.mVid });
        VideoViewVideoHolder.c(VideoViewVideoHolder.this, 2);
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, false);
        VideoViewVideoHolder.b(VideoViewVideoHolder.this, 1234);
        notifyError(new ErrorMessage(VideoViewVideoHolder.b(VideoViewVideoHolder.this), "doodle download cancel"));
        return;
      }
      ram.w(VideoViewVideoHolder.this.TAG, "wait doodle download and display cancel. stream canceled.");
    }
    
    protected void g(StoryVideoItem paramStoryVideoItem)
    {
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, 4);
      super.notifyResult(paramStoryVideoItem);
    }
    
    public void onCancel()
    {
      super.onCancel();
      ram.d(VideoViewVideoHolder.this.TAG, "DoodleSegment onCancel");
      if (this.g != null) {
        this.a.a().bi(this.g.mVid, 1);
      }
    }
    
    public void onSuccess(String paramString, int paramInt)
    {
      if (!isCanceled())
      {
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, "DD", SystemClock.uptimeMillis());
        VideoViewVideoHolder.this.mMaskView.setVisibility(0);
        qem.a(VideoViewVideoHolder.this.mMaskView, this.g.mLocalMaskPath, this.g.getDownloadMaskUrl(), VideoViewVideoHolder.a(VideoViewVideoHolder.this));
        g(this.g);
        return;
      }
      ram.w(VideoViewVideoHolder.this.TAG, "wait doodle download and display onSuccess. stream canceled.");
    }
  }
  
  static class d
    implements DialogInterface.OnDismissListener
  {
    private final boolean aDP;
    private final WeakReference<VideoViewVideoHolder> cW;
    
    public d(VideoViewVideoHolder paramVideoViewVideoHolder, boolean paramBoolean)
    {
      this.cW = new WeakReference(paramVideoViewVideoHolder);
      this.aDP = paramBoolean;
    }
    
    public void onDismiss(DialogInterface paramDialogInterface)
    {
      paramDialogInterface = (VideoViewVideoHolder)this.cW.get();
      if (paramDialogInterface != null)
      {
        if ((paramDialogInterface.Ju()) && (!paramDialogInterface.n().isFinishing())) {
          break label40;
        }
        ram.d("OnNewGuideDialogDismissListener", "activity token invalid, preventing from showing dialog");
      }
      label40:
      while (paramDialogInterface.JO()) {
        return;
      }
      paramDialogInterface.sH(this.aDP);
      paramDialogInterface.boG();
      paramDialogInterface.a = null;
    }
  }
  
  public class e
  {
    pno b;
    
    private e() {}
    
    public pno a()
    {
      if (this.b == null) {
        this.b = new pno();
      }
      return this.b;
    }
    
    public void destroy()
    {
      if (this.b != null) {
        this.b.stop();
      }
    }
  }
  
  class f
    extends JobSegment<StoryVideoItem, StoryVideoItem>
    implements pno.a
  {
    private VideoViewVideoHolder.e a;
    private boolean aDm;
    private StoryVideoItem g;
    
    public f(VideoViewVideoHolder.e parame, boolean paramBoolean)
    {
      this.a = parame;
      this.aDm = paramBoolean;
    }
    
    protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
    {
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, 5);
      this.g = paramStoryVideoItem;
      if (this.aDm)
      {
        g(paramStoryVideoItem);
        return;
      }
      ram.w(VideoViewVideoHolder.this.TAG, "showVideo, start download video fully");
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, 5);
      this.a.a().a(paramStoryVideoItem.mVid, 0, true, this);
    }
    
    public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
    {
      if (!isCanceled())
      {
        ram.c(VideoViewVideoHolder.this.TAG, paramErrorMessage, "showVideo, start download video fully, onError", new Object[0]);
        VideoViewVideoHolder.c(VideoViewVideoHolder.this, 3);
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, false);
        VideoViewVideoHolder.b(VideoViewVideoHolder.this, paramErrorMessage.errorCode);
        notifyError(new ErrorMessage(VideoViewVideoHolder.b(VideoViewVideoHolder.this), paramErrorMessage.getErrorMessage()));
        return;
      }
      ram.c(VideoViewVideoHolder.this.TAG, paramErrorMessage, "showVideo, start download video fully, onError. stream canceled", new Object[0]);
    }
    
    public void bj(String paramString, int paramInt)
    {
      if (!isCanceled())
      {
        ram.w(VideoViewVideoHolder.this.TAG, "showVideo, start download video fully, onCancel");
        VideoViewVideoHolder.c(VideoViewVideoHolder.this, 3);
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, false);
        VideoViewVideoHolder.b(VideoViewVideoHolder.this, 1234);
        notifyError(new ErrorMessage(VideoViewVideoHolder.b(VideoViewVideoHolder.this), "Download video cancel"));
        return;
      }
      ram.w(VideoViewVideoHolder.this.TAG, "showVideo, start download video fully, onCancel. stream canceled");
    }
    
    protected void g(StoryVideoItem paramStoryVideoItem)
    {
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, 6);
      super.notifyResult(paramStoryVideoItem);
    }
    
    public void onCancel()
    {
      super.onCancel();
      ram.d(VideoViewVideoHolder.this.TAG, "VideoFileSegment onCancel");
      if (this.g != null) {
        this.a.a().bi(this.g.mVid, 0);
      }
    }
    
    public void onSuccess(String paramString, int paramInt)
    {
      if (!isCanceled())
      {
        ram.w(VideoViewVideoHolder.this.TAG, "showVideo, start download video fully, onSuccess");
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, "VD", SystemClock.uptimeMillis());
        g(this.g);
        return;
      }
      ram.w(VideoViewVideoHolder.this.TAG, "showVideo, start download video fully, onSuccess. stream canceled");
    }
  }
  
  class g
    extends JobSegment<String, String>
  {
    private g() {}
    
    protected void a(JobContext paramJobContext, String paramString)
    {
      VideoViewVideoHolder.this.a.a(null);
      VideoViewVideoHolder.this.a.a(null);
      VideoViewVideoHolder.this.a.a(null);
      VideoViewVideoHolder.this.a.a(null);
      VideoViewVideoHolder.this.a.a(null);
      if (VideoViewVideoHolder.f(VideoViewVideoHolder.this) == 0)
      {
        ram.w(VideoViewVideoHolder.this.TAG, "VideoIdleSegment. already idle state");
        notifyResult(paramString);
        return;
      }
      if (VideoViewVideoHolder.f(VideoViewVideoHolder.this) < 7)
      {
        ram.w(VideoViewVideoHolder.this.TAG, "VideoIdleSegment. change to idle directly");
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, 0);
        notifyResult(paramString);
        return;
      }
      ram.d(VideoViewVideoHolder.this.TAG, "VideoIdleSegment. stop video view");
      VideoViewVideoHolder.this.a.stopPlayback();
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, 0);
      notifyResult(paramString);
    }
  }
  
  class h
    extends JobSegment<String, StoryVideoItem>
    implements qef.a
  {
    String vid;
    
    private h() {}
    
    private void a(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
    {
      if ((paramStoryVideoItem != null) && (paramStoryVideoItem.mErrorCode != 0))
      {
        ram.w(VideoViewVideoHolder.this.TAG, "showPage, show error view, because video item error code = %d", new Object[] { Integer.valueOf(paramStoryVideoItem.mErrorCode) });
        VideoViewVideoHolder.c(VideoViewVideoHolder.this, 4);
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, false);
        VideoViewVideoHolder.b(VideoViewVideoHolder.this, paramStoryVideoItem.mErrorCode);
        notifyError(new ErrorMessage(VideoViewVideoHolder.b(VideoViewVideoHolder.this), "videoDeleted"));
        return;
      }
      if ((paramStoryVideoItem == null) || (!paramStoryVideoItem.isBasicInfoOK()))
      {
        if (paramBoolean)
        {
          VideoViewVideoHolder.a(VideoViewVideoHolder.this, 3);
          VideoViewVideoHolder.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
          VideoViewVideoHolder.this.jdField_a_of_type_Qlb.setVisibility(8);
          VideoViewVideoHolder.this.fV.setVisibility(8);
          VideoViewVideoHolder.this.mMaskView.setVisibility(8);
          VideoViewVideoHolder.a(VideoViewVideoHolder.this, acfp.m(2131716487));
          paramStoryVideoItem = new ArrayList();
          paramStoryVideoItem.add(VideoViewVideoHolder.this.jdField_a_of_type_Qjq.vid);
          localObject = VideoViewVideoHolder.a(VideoViewVideoHolder.this);
          if (localObject != null) {
            ((qef)localObject).destroy();
          }
          VideoViewVideoHolder.a(VideoViewVideoHolder.this, new qef(paramStoryVideoItem));
          VideoViewVideoHolder.a(VideoViewVideoHolder.this).a(this);
          VideoViewVideoHolder.a(VideoViewVideoHolder.this).bnJ();
          return;
        }
        onFailed();
        return;
      }
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, paramStoryVideoItem);
      VideoViewVideoHolder.this.fV.setVisibility(0);
      Object localObject = (String)VideoViewVideoHolder.this.fV.getTag();
      if (!TextUtils.equals(VideoViewVideoHolder.this.jdField_a_of_type_Qjq.vid, (CharSequence)localObject))
      {
        VideoViewVideoHolder.this.fV.setTag(VideoViewVideoHolder.this.jdField_a_of_type_Qjq.vid);
        qem.a(VideoViewVideoHolder.this.fV, paramStoryVideoItem.mVideoLocalThumbnailPath, paramStoryVideoItem.getThumbUrl(), VideoViewVideoHolder.a(VideoViewVideoHolder.this), VideoViewVideoHolder.this.b);
      }
      g(paramStoryVideoItem);
    }
    
    protected void a(JobContext paramJobContext, String paramString)
    {
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, 1);
      this.vid = paramString;
      a(((psu)psx.a(5)).b(VideoViewVideoHolder.this.jdField_a_of_type_Qjq.vid), true);
    }
    
    public void cj(ArrayList<StoryVideoItem> paramArrayList)
    {
      if (isCanceled()) {
        return;
      }
      paramArrayList = VideoViewVideoHolder.a(VideoViewVideoHolder.this);
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, null);
      if (paramArrayList != null) {
        paramArrayList.destroy();
      }
      ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoInfoSegment.1(this));
    }
    
    protected void g(StoryVideoItem paramStoryVideoItem)
    {
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, 2);
      super.notifyResult(paramStoryVideoItem);
    }
    
    public void onCancel()
    {
      super.onCancel();
      ram.d(VideoViewVideoHolder.this.TAG, "VideoInfoSegment onCancel");
      qef localqef = VideoViewVideoHolder.a(VideoViewVideoHolder.this);
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, null);
      if (localqef != null) {
        localqef.destroy();
      }
    }
    
    public void onFailed()
    {
      if (isCanceled()) {
        return;
      }
      qef localqef = VideoViewVideoHolder.a(VideoViewVideoHolder.this);
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, null);
      if (localqef != null) {
        localqef.destroy();
      }
      ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoInfoSegment.2(this));
    }
  }
  
  public class i
    extends JobSegment<StoryVideoItem, StoryVideoItem>
  {
    StoryVideoItem g;
    
    private i() {}
    
    protected void a(JobContext paramJobContext, StoryVideoItem paramStoryVideoItem)
    {
      VideoViewVideoHolder.a(VideoViewVideoHolder.this, 7);
      this.g = paramStoryVideoItem;
      paramJobContext = null;
      File localFile = pnh.a(paramStoryVideoItem.mVid, 0, false, false);
      if ((localFile != null) && (pnh.s(localFile))) {
        paramJobContext = localFile.getAbsolutePath();
      }
      for (;;)
      {
        if (paramJobContext == null)
        {
          ram.w(VideoViewVideoHolder.this.TAG, "finalFileName null, hide loading view");
          VideoViewVideoHolder.c(VideoViewVideoHolder.this, 8);
          VideoViewVideoHolder.a(VideoViewVideoHolder.this, false);
          ram.e(VideoViewVideoHolder.this.TAG, "setVideoPath, fileName is empty !!");
          VideoViewVideoHolder.a(VideoViewVideoHolder.this, acfp.m(2131716476));
          notifyError(new ErrorMessage(VideoViewVideoHolder.b(VideoViewVideoHolder.this), "fileName null"));
          return;
          if (VideoViewVideoHolder.this.Jv())
          {
            if ((!TextUtils.isEmpty(paramStoryVideoItem.mVideoUrl)) || (!TextUtils.isEmpty(paramStoryVideoItem.mTempVideoUrl)))
            {
              localFile = pnh.a(paramStoryVideoItem.mVid, 0, true, true);
              if (localFile != null) {
                paramJobContext = localFile.getAbsolutePath();
              }
              for (;;)
              {
                break;
                ram.e(VideoViewVideoHolder.this.TAG, "showVideo, vid=%s, support stream, getLocalFile return null", new Object[] { paramStoryVideoItem.mVid });
              }
            }
          }
          else {
            notifyError(new ErrorMessage(-1, "not tvk videoView, and videoFile has not downloaded."));
          }
        }
        else
        {
          VideoViewVideoHolder.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
          VideoViewVideoHolder.this.jdField_a_of_type_Qlb.setVisibility(0);
          ram.d(VideoViewVideoHolder.this.TAG, "set video view listeners ... and then setVideoPath");
          VideoViewVideoHolder.d(VideoViewVideoHolder.this, 0);
          VideoViewVideoHolder.this.jdField_a_of_type_Qlb.a(new qko(this));
          VideoViewVideoHolder.this.jdField_a_of_type_Qlb.a(new qkp(this, paramJobContext, paramStoryVideoItem));
          VideoViewVideoHolder.this.jdField_a_of_type_Qlb.a(new qkq(this, paramStoryVideoItem));
          VideoViewVideoHolder.this.jdField_a_of_type_Qlb.a(new qkr(this, paramStoryVideoItem));
          VideoViewVideoHolder.this.jdField_a_of_type_Qlb.a(new qks(this, paramStoryVideoItem));
          ((pmq)psx.a(28)).a(paramStoryVideoItem.mVid, 0, new qkt(this, paramStoryVideoItem, paramJobContext));
          return;
        }
        paramJobContext = null;
      }
    }
    
    public void g(StoryVideoItem paramStoryVideoItem)
    {
      if (VideoViewVideoHolder.b(VideoViewVideoHolder.this, 8))
      {
        VideoViewVideoHolder.a(VideoViewVideoHolder.this, 8);
        VideoViewVideoHolder.a(VideoViewVideoHolder.this).a(VideoViewVideoHolder.this, VideoViewVideoHolder.this.jdField_a_of_type_Qlb);
        super.notifyResult(paramStoryVideoItem);
        return;
      }
      ram.e(VideoViewVideoHolder.this.TAG, "STATE_PREPARE_ED ignore");
    }
    
    public void onCancel()
    {
      super.onCancel();
      ram.d(VideoViewVideoHolder.this.TAG, "VideoPrepareSegment onCancel");
      VideoViewVideoHolder.this.jdField_a_of_type_Qlb.stopPlayback();
    }
  }
  
  public static abstract interface j
  {
    public abstract void a(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, String paramString2, File paramFile, boolean paramBoolean);
    
    public abstract void a(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb);
    
    public abstract boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb, int paramInt, Object paramObject);
    
    public abstract void b(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb);
    
    public abstract boolean b(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb, boolean paramBoolean);
    
    public abstract void c(VideoViewVideoHolder paramVideoViewVideoHolder, qlb paramqlb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder
 * JD-Core Version:    0.7.0.1
 */