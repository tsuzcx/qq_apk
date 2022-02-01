package com.tencent.mobileqq.activity.richmedia;

import aaow;
import aaox;
import aaoy;
import aaoz;
import aapa;
import aapb;
import aapc;
import aapd;
import aape;
import aapf;
import aapg;
import aaph;
import aapi;
import aapj;
import aapk;
import aapl;
import aapn;
import aaqj;
import aasa;
import aauq;
import aaus;
import aaut;
import acfp;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import aniq;
import anlc;
import anpc;
import aofw;
import aqha;
import aqhq;
import aqiw;
import aqju;
import arxa;
import ausj;
import avpq;
import avpw;
import avpw.d;
import avsu;
import avtz;
import avzf;
import awcf;
import awcr;
import awdo;
import awed;
import awig;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar.a;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.video.decode.ShortVideoSoLoad;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import wja;

public class EditLocalVideoActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, VideoFrameSelectBar.a
{
  private static final boolean Ll;
  private static final String bdu = "/tencent" + File.separator + "video_edit_music_download" + File.separator;
  private static final String bdv = "/tencent" + File.separator + "video_edit_music" + File.separator;
  public static String bdw = aasa.SDCARD_ROOT + bdu;
  private static String bdx = aasa.SDCARD_ROOT + bdv;
  private ViewStub D;
  private String JB;
  private boolean Ln = true;
  private long Mb;
  private long Mc;
  private long Md;
  private TextView Oo;
  private TextView Op;
  private TextView Oq;
  private ProgressBar U;
  private aapn jdField_a_of_type_Aapn;
  private aaqj jdField_a_of_type_Aaqj;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private a jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$a = new a(this);
  private VideoFrameSelectBar jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
  private ExtendEditText jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText;
  private ViewGroup aB;
  private Bitmap aM;
  private ausj ab;
  private aqju ac;
  private int agt;
  private int agu = 2;
  private int agv;
  private int agw;
  private String azT;
  private PressDarkImageButton jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private FixedSizeVideoView jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView;
  private String bdA;
  private String bdy;
  private String bdz;
  boolean bwB;
  private boolean bwC;
  private boolean bwD = true;
  private boolean bwE;
  private boolean bwF;
  private boolean bwG;
  private boolean bwH;
  private boolean bwI;
  private boolean bwJ;
  private boolean bwK;
  public RMVideoStateMgr c = RMVideoStateMgr.a();
  private int cic;
  private int cie;
  private int cif = -1;
  private int cig = -1;
  private int cih = -1;
  private int cii = 0;
  private ViewGroup dM;
  private RelativeLayout dw;
  public ArrayList<String> eo;
  private ImageView fU;
  private ImageView fV;
  private Button fc;
  private Button jdField_fd_of_type_AndroidWidgetButton;
  private TextView jdField_fd_of_type_AndroidWidgetTextView;
  private RelativeLayout iO;
  private RelativeLayout iP;
  private RelativeLayout iQ;
  private RelativeLayout iR;
  private boolean isTopic;
  private String localVideoPath;
  private TextView mCancelText;
  private String mContent = "";
  private int mDuration;
  private int mEndTime;
  private String mFontUrl;
  private StringBuilder mFormatBuilder = new StringBuilder();
  private Formatter mFormatter = new Formatter(this.mFormatBuilder, Locale.getDefault());
  private boolean mIsUploadOrigin;
  private boolean mNeedProcess;
  public int mPriv = 1;
  private String mRefer;
  private int mStartTime;
  private TextView mTimeText;
  private int mVideoHeight;
  private int mVideoWidth;
  public String pO;
  private QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo;
  private String topicId;
  private boolean topicSyncQzone = true;
  public String uO;
  private long uin;
  private View zI;
  private View zJ;
  private View zK;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 10) {}
    for (boolean bool = true;; bool = false)
    {
      Ll = bool;
      return;
    }
  }
  
  private void CA(boolean paramBoolean)
  {
    int k = 8;
    int j = 0;
    this.bwH = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
    int i;
    if (paramBoolean)
    {
      i = 0;
      ((VideoFrameSelectBar)localObject).setVisibility(i);
      localObject = this.iR;
      if (!paramBoolean) {
        break label174;
      }
      i = 0;
      label41:
      ((RelativeLayout)localObject).setVisibility(i);
      localObject = this.fU;
      if (!paramBoolean) {
        break label180;
      }
      i = 0;
      label59:
      ((ImageView)localObject).setVisibility(i);
      localObject = this.fV;
      if (!paramBoolean) {
        break label186;
      }
      i = 0;
      label77:
      ((ImageView)localObject).setVisibility(i);
      localObject = this.dM;
      if (!paramBoolean) {
        break label192;
      }
      i = 8;
      label96:
      ((ViewGroup)localObject).setVisibility(i);
      if (this.zK != null)
      {
        localObject = this.zK;
        if (!paramBoolean) {
          break label197;
        }
        i = k;
        label122:
        ((View)localObject).setVisibility(i);
      }
      if (this.cii != 0) {
        break label202;
      }
      CB(paramBoolean);
    }
    for (;;)
    {
      if (this.jdField_fd_of_type_AndroidWidgetTextView != null)
      {
        localObject = this.jdField_fd_of_type_AndroidWidgetTextView;
        i = j;
        if (paramBoolean) {
          i = 4;
        }
        ((TextView)localObject).setVisibility(i);
      }
      return;
      i = 8;
      break;
      label174:
      i = 8;
      break label41;
      label180:
      i = 8;
      break label59;
      label186:
      i = 8;
      break label77;
      label192:
      i = 0;
      break label96;
      label197:
      i = 0;
      break label122;
      label202:
      if (this.cii == 1) {
        CB(true);
      }
    }
  }
  
  private void CB(boolean paramBoolean)
  {
    int j = 8;
    Object localObject = this.iO;
    if (paramBoolean)
    {
      i = 8;
      ((RelativeLayout)localObject).setVisibility(i);
      localObject = this.iO;
      if (!paramBoolean) {
        break label109;
      }
      i = 0;
      label34:
      ((RelativeLayout)localObject).setBackgroundColor(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText;
      if (!paramBoolean) {
        break label123;
      }
      i = 8;
      label53:
      ((ExtendEditText)localObject).setVisibility(i);
      localObject = this.fc;
      if ((!paramBoolean) && (!this.isTopic)) {
        break label128;
      }
      i = 8;
      label79:
      ((Button)localObject).setVisibility(i);
      localObject = this.zI;
      if (!paramBoolean) {
        break label133;
      }
    }
    label128:
    label133:
    for (int i = j;; i = 0)
    {
      ((View)localObject).setVisibility(i);
      return;
      i = 0;
      break;
      label109:
      i = getResources().getColor(2131166737);
      break label34;
      label123:
      i = 0;
      break label53;
      i = 0;
      break label79;
    }
  }
  
  private void Cz(boolean paramBoolean)
  {
    int j = 0;
    Object localObject;
    if ((this.iP != null) && (this.jdField_fd_of_type_AndroidWidgetButton != null) && (this.Op != null))
    {
      localObject = this.iP;
      if (!paramBoolean) {
        break label78;
      }
      i = 0;
      ((RelativeLayout)localObject).setVisibility(i);
      localObject = this.jdField_fd_of_type_AndroidWidgetButton;
      if (!paramBoolean) {
        break label84;
      }
      i = 0;
      label53:
      ((Button)localObject).setVisibility(i);
      localObject = this.Op;
      if (!paramBoolean) {
        break label90;
      }
    }
    label78:
    label84:
    label90:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      return;
      i = 8;
      break;
      i = 8;
      break label53;
    }
  }
  
  private void Gb(int paramInt)
  {
    if (this.U != null)
    {
      this.U.setProgress(0);
      this.U.setVisibility(8);
    }
    h("608", "2", "0", true);
    this.mStartTime = 0;
    this.mEndTime = 0;
    this.agt = 0;
    if (this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.stopPlayback();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.destroy();
    }
    if ((this.aM != null) && (!this.aM.isRecycled())) {
      this.aM.recycle();
    }
    Gc(8);
    setResult(paramInt);
    finish();
  }
  
  private void Gc(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVisibility(paramInt);
    }
    if (this.iQ != null) {
      this.iQ.setVisibility(paramInt);
    }
    if (this.aB != null) {
      this.aB.setVisibility(paramInt);
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, Matrix paramMatrix, boolean paramBoolean)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, paramMatrix, true);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (paramBoolean) {
        return a(paramBitmap, paramInt1, paramInt2, paramMatrix, false);
      }
    }
    return null;
  }
  
  private static Bitmap a(BitmapFactory.Options paramOptions, String paramString)
  {
    int i = 0;
    for (;;)
    {
      if ((i > 0) && (paramOptions.inSampleSize > 7)) {
        return null;
      }
      try
      {
        Bitmap localBitmap = decodeFileWithBuffer(paramString, paramOptions);
        return localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramOptions.inSampleSize += 1;
        i += 1;
      }
    }
  }
  
  private Bitmap a(BitmapFactory.Options paramOptions, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = decodeFileWithBuffer(paramString, paramOptions);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!paramBoolean) {}
    }
    return localObject;
    return a(paramOptions, paramString, false);
  }
  
  private void aK(Message paramMessage)
  {
    if (this.fV != null) {}
    try
    {
      paramMessage = (String)paramMessage.obj;
      int i = this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getWidth();
      int j = this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "VIDEO_SHOW_COVER, filename=" + paramMessage + ", w=" + i + ", h=" + j);
      }
      this.aM = b(paramMessage, i, j, false);
      if (this.aM != null)
      {
        ViewGroup.LayoutParams localLayoutParams = this.fV.getLayoutParams();
        localLayoutParams.height = j;
        localLayoutParams.width = i;
        this.fV.setLayoutParams(localLayoutParams);
        this.fV.setImageBitmap(this.aM);
        if (this.bwH) {
          this.fV.setVisibility(0);
        }
        this.agv = i;
        this.agw = j;
        this.JB = paramMessage;
      }
      return;
    }
    catch (Throwable paramMessage)
    {
      QLog.w("EditLocalVideoActivity", 2, "VIDEO_SHOW_COVER failed", paramMessage);
    }
  }
  
  private static String ad(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return acfp.m(2131705438);
    case 1: 
      return acfp.m(2131705414);
    case 4: 
      return acfp.m(2131705431);
    case 16: 
      return acfp.m(2131705425);
    case 64: 
      return acfp.m(2131705436);
    }
    return acfp.m(2131705422);
  }
  
  private void adL()
  {
    avpw.b(this, new aaoy(this));
  }
  
  private void ahG()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.reset();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$a.removeMessages(9999);
  }
  
  private void bP(Bundle paramBundle)
  {
    Intent localIntent;
    if ((this.jdField_a_of_type_Aaqj != null) && ("ref_h5_record_video".equals(this.jdField_a_of_type_Aaqj.getRefer())))
    {
      localIntent = new Intent("com.qzone.h5.video.recordCallback");
      localIntent.putExtras(paramBundle);
      BaseApplication.getContext().sendBroadcast(localIntent);
    }
    for (;;)
    {
      if (this.cii == 0) {
        setResult(-1);
      }
      finish();
      return;
      if (this.cii == 0)
      {
        avzf.a().a("cmd.publishVideoMood", paramBundle, false);
      }
      else if (this.cii == 1)
      {
        localIntent = new Intent(getIntent());
        localIntent.putExtras(paramBundle);
        paramBundle = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
        boolean bool = localIntent.getBooleanExtra("DirectBackToQzone", false);
        if (("qzone_plugin.apk".equals(paramBundle)) && (bool))
        {
          localIntent.setFlags(603979776);
          avpw.a(this, "", localIntent, -1);
        }
      }
    }
  }
  
  private void bc(int paramInt1, int paramInt2)
  {
    QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").post(new EditLocalVideoActivity.18(this, paramInt1, paramInt2));
  }
  
  public static boolean bg(int paramInt)
  {
    return (paramInt == 16) || (paramInt == 128);
  }
  
  private void cnJ()
  {
    cvR();
    long l = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
    if (this.Mc > l)
    {
      this.bwC = false;
      if (this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.getDrawable().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
      }
      l = QzoneConfig.getInstance().getConfig("VideoEdit", "SupportMixMusicMaxSize", 524288000L);
      if (this.Mb <= 0L) {
        this.Mb = new File(this.localVideoPath).length();
      }
      if (this.Mb <= l) {
        break label190;
      }
      this.bwD = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.getDrawable().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
      }
    }
    for (;;)
    {
      if (this.cii == 0) {
        Cz(true);
      }
      if (TextUtils.isEmpty(this.localVideoPath)) {
        break label215;
      }
      cvS();
      return;
      this.bwC = true;
      if (this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton == null) {
        break;
      }
      this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.getDrawable().clearColorFilter();
      break;
      label190:
      this.bwD = true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.getDrawable().clearColorFilter();
      }
    }
    label215:
    QLog.e("EditLocalVideoActivity", 2, " localVideoPath is empty ");
  }
  
  private void cvE()
  {
    new AlertDialog.Builder(this).setMessage(acfp.m(2131705432)).setNegativeButton(2131695681, new aaow(this)).setCancelable(false).show();
  }
  
  private void cvF()
  {
    w("play_local_video", "play_local_video_success", "1", Build.MODEL);
    try
    {
      new AlertDialog.Builder(this).setMessage(acfp.m(2131705430)).setNegativeButton(2131695681, new aapf(this)).setCancelable(false).create().show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("EditLocalVideoActivity", 2, "LOAD_VIDEO_TIME_OUT showDialog error", localException);
    }
  }
  
  private void cvG()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "handleMessage, MSG_ON_CONFIRM");
    }
    CA(false);
    if (this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.isPlaying()) {
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setPlayDuration(this.mStartTime, this.mEndTime - this.mStartTime);
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
    this.bwG = true;
  }
  
  private void cvH()
  {
    Typeface localTypeface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTextEffect(this.bdz);
    String str = avtz.a(this.cif, null, null, null);
    if (TextUtils.isEmpty(str)) {
      this.cif = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setTypeface(localTypeface);
      return;
      localTypeface = Typeface.createFromFile(str);
    }
  }
  
  private void cvI()
  {
    URLImageView localURLImageView;
    if (this.qzoneVerticalVideoTopicInfo != null)
    {
      this.zK = $(2131380072);
      this.zK.setVisibility(0);
      ((TextView)$(2131380966)).setText(this.qzoneVerticalVideoTopicInfo.GU());
      localURLImageView = (URLImageView)$(2131369834);
      if (!TextUtils.isEmpty(this.qzoneVerticalVideoTopicInfo.GV())) {
        localURLImageView.setBackgroundURL(this.qzoneVerticalVideoTopicInfo.GV());
      }
    }
    else
    {
      return;
    }
    localURLImageView.setVisibility(8);
  }
  
  private void cvJ()
  {
    int i = awdo.a(this, this);
    if (i <= 0) {}
    do
    {
      return;
      localObject = findViewById(2131374883);
    } while ((localObject == null) || (!(((View)localObject).getLayoutParams() instanceof RelativeLayout.LayoutParams)));
    Object localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (i + ((RelativeLayout.LayoutParams)localObject).height);
  }
  
  private void cvK()
  {
    if (this.bwH)
    {
      this.mCancelText.performClick();
      return;
    }
    if (this.ac == null) {
      this.ac = aqha.a(this, 230, acfp.m(2131705426), null, getString(2131694366), getString(2131721058), new aapg(this), new aaph(this));
    }
    this.ac.show();
  }
  
  private void cvL()
  {
    this.jdField_a_of_type_Aapn.J(this.Mc, this.localVideoPath);
    this.jdField_a_of_type_Aapn.gr(this.mStartTime, this.mEndTime);
    this.jdField_a_of_type_Aapn.b(new aapi(this));
    this.jdField_a_of_type_Aapn.b(new aapj(this));
    this.jdField_a_of_type_Aapn.cvZ();
  }
  
  private void cvM()
  {
    if (this.jdField_a_of_type_Aapn == null)
    {
      this.jdField_a_of_type_Aapn = aapn.a(this, this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView, this.qzoneVerticalVideoTopicInfo, this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton);
      return;
    }
    QZLog.i("EditLocalVideoActivity", 2, "use old music mixer");
  }
  
  private void cvN()
  {
    if (!iR(this.localVideoPath)) {
      arxa.a().showToast("视频文件不存在");
    }
    Bundle localBundle;
    label536:
    label827:
    label834:
    label851:
    do
    {
      return;
      LpReportInfo_pf00064.allReport(664, 2);
      Object localObject;
      int i;
      if (this.mIsUploadOrigin) {
        if (this.bwG)
        {
          this.mNeedProcess = true;
          localBundle = new Bundle();
          localBundle.putString("param.content", this.mContent);
          localBundle.putInt("param.priv", this.mPriv);
          localBundle.putStringArrayList("param.privList", this.eo);
          localBundle.putInt("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", this.cii);
          localBundle.putString("file_send_path", this.bdy);
          localBundle.putString("param.videoPath", this.localVideoPath);
          localBundle.putLong("param.videoSize", this.Mb);
          localBundle.putInt("param.videoType", 1);
          localBundle.putString("param.thumbnailPath", this.JB);
          localBundle.putInt("param.thumbnailHeight", this.agw);
          localBundle.putInt("param.thumbnailWidth", this.agv);
          localBundle.putLong("param.startTime", this.mStartTime);
          localBundle.putLong("param.duration", this.mEndTime - this.mStartTime);
          localBundle.putLong("param.totalDuration", this.Mc);
          localBundle.putBoolean("param.needProcess", this.mNeedProcess);
          localBundle.putBoolean("param.isUploadOrigin", this.mIsUploadOrigin);
          localBundle.putString("param.topicId", this.topicId);
          localBundle.putBoolean("param.topicSyncQzone", this.topicSyncQzone);
          localBundle.putBoolean("param.isSyncToQQStory", this.bwK);
          localBundle.putParcelable("param.QzoneTopic", this.qzoneVerticalVideoTopicInfo);
          if (this.cif >= 0)
          {
            localBundle.putInt("extra_key_font_id", this.cif);
            localBundle.putInt("extra_key_font_format_type", this.cig);
            localBundle.putString("extra_key_font_url", this.mFontUrl);
          }
          if (this.cih >= 0)
          {
            localBundle.putInt("extra_key_super_font_id", this.cih);
            localBundle.putString("extra_key_super_font_info", this.bdz);
          }
          localObject = new Bundle();
          ((Bundle)localObject).putInt("sv_encode_max_bitrate", aniq.dFI);
          ((Bundle)localObject).putInt("sv_encode_min_bitrate", aniq.dFJ);
          ((Bundle)localObject).putInt("sv_encode_qmax", aniq.dFK);
          ((Bundle)localObject).putInt("sv_encode_qmin", aniq.dFL);
          ((Bundle)localObject).putInt("sv_encode_qmaxdiff", aniq.dFM);
          ((Bundle)localObject).putInt("sv_encode_ref_frame", aniq.dFN);
          ((Bundle)localObject).putInt("sv_encode_smooth", aniq.dFO);
          if (this.c != null)
          {
            if (this.c.a != null) {
              ((Bundle)localObject).putInt("sv_total_frame_count", this.c.a.getFrameIndex());
            }
            ((Bundle)localObject).putInt("sv_total_record_time", (int)this.c.bL);
          }
          i = 201;
          if (this.qzoneVerticalVideoTopicInfo != null)
          {
            if (!this.qzoneVerticalVideoTopicInfo.ags()) {
              break label827;
            }
            i = 213;
          }
          ((Bundle)localObject).putInt("param.uploadEntrance", i);
          localBundle.putBundle("param.extras", (Bundle)localObject);
          if ((this.cii != 1) || (this.bwG) || (this.bdy == null) || (!this.bdy.equals(this.localVideoPath))) {
            break label834;
          }
          localBundle.putBoolean("PhotoConst.EDIT_LOCAL_VIDEO_DONOTHING_RETURN", true);
        }
      }
      for (;;)
      {
        long l = QzoneConfig.getInstance().getConfig("VideoEdit", "UploadMaxSizeTipWithNoWifi", 20971520L);
        if ((aqiw.getNetworkType(BaseApplication.getContext()) == 1) || (this.Mb <= l)) {
          break label869;
        }
        if (this.ab != null) {
          break label851;
        }
        localObject = acfp.m(2131705427) + l / 1024L / 1024L + acfp.m(2131705433);
        this.ab = ausj.b(this);
        this.ab.setMainTitle((CharSequence)localObject);
        this.ab.addButton("立即上传", 0);
        this.ab.addCancelButton(2131721058);
        this.ab.a(new aapk(this, localBundle));
        this.ab.a(new aapl(this));
        this.ab.show();
        return;
        this.mNeedProcess = false;
        break;
        l = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
        if (this.bwG)
        {
          this.mNeedProcess = true;
          break;
        }
        if (this.Mc > l)
        {
          this.mNeedProcess = false;
          break;
        }
        this.mNeedProcess = true;
        break;
        i = 214;
        break label536;
        h("608", "1", "0", true);
      }
    } while (this.ab.isShowing());
    this.ab.show();
    return;
    label869:
    bP(localBundle);
  }
  
  private void cvO()
  {
    if ((this.jdField_a_of_type_Aapn != null) && (this.jdField_a_of_type_Aapn.WM()))
    {
      cvP();
      return;
    }
    cvN();
  }
  
  private void cvP()
  {
    this.jdField_a_of_type_Aapn.a(new aaox(this));
  }
  
  private void cvQ()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.hasChanged())
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.mStartTime);
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
      CA(false);
      this.bwG = false;
      return;
    }
    ausj localausj = ausj.b(this);
    localausj.setMainTitle(acfp.m(2131705419));
    localausj.addButton(2131694366, 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new aaoz(this, localausj));
    localausj.show();
  }
  
  private void cvR()
  {
    if (this.cii == 0)
    {
      this.jdField_fd_of_type_AndroidWidgetTextView.setText(2131696931);
      this.Oo.setText(2131721085);
      if ((this.jdField_a_of_type_Aapn == null) || (!this.jdField_a_of_type_Aapn.WL()))
      {
        this.iO.setVisibility(0);
        this.iO.setBackgroundColor(getResources().getColor(2131166737));
        anlc.a(this.iO, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
    }
    for (;;)
    {
      this.jdField_fd_of_type_AndroidWidgetTextView.setVisibility(0);
      this.Oo.setVisibility(0);
      anlc.a(this.Oo, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      if (this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      }
      anlc.a(this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      anlc.a(this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      Cz(false);
      anlc.a(this.iP, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      if (!this.bwI)
      {
        this.jdField_fd_of_type_AndroidWidgetButton.setBackgroundResource(2130850051);
        this.bwB = false;
      }
      return;
      if (this.cii == 1)
      {
        this.jdField_fd_of_type_AndroidWidgetTextView.setText(2131690700);
        this.Oo.setText(2131721079);
        this.iO.setVisibility(8);
        this.iO.setBackgroundColor(0);
      }
    }
  }
  
  private void cvS()
  {
    if (this.D == null)
    {
      this.D = ((ViewStub)findViewById(2131374882));
      this.D.inflate();
    }
    try
    {
      Object localObject1 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext());
      GlobalInit.loadLibraryWithFullPath((String)localObject1 + VideoEnvironment.zQ());
      if (!aauq.ai(this.uin))
      {
        QQToast.a(this, acfp.m(2131705416), 0).show();
        QLog.e("EditLocalVideoActivity", 2, "init trim failed");
        w("play_local_video", "play_local_video_success", "3", Build.MODEL);
        finish();
      }
      try
      {
        localObject1 = (ActivityManager)getSystemService("activity");
        localObject2 = new ActivityManager.MemoryInfo();
        ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
        i = QzoneConfig.getInstance().getConfig("TrimVideo", "MinAvailableRam", 209715200);
        if (((ActivityManager.MemoryInfo)localObject2).availMem < i) {
          QQToast.a(this, acfp.m(2131705441), 0).show();
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditLocalVideoActivity", 2, "availMem=" + ((ActivityManager.MemoryInfo)localObject2).availMem + ", threshold=" + ((ActivityManager.MemoryInfo)localObject2).threshold + ", lowMem=" + ((ActivityManager.MemoryInfo)localObject2).lowMemory + ", minRam=" + i);
        }
        aauq.ahH();
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject2;
          int i;
          FrameLayout.LayoutParams localLayoutParams1;
          int n;
          int m;
          QLog.w("EditLocalVideoActivity", 2, "", localThrowable2);
        }
      }
      this.iQ = ((RelativeLayout)$(2131365322));
      this.aB = ((ViewGroup)$(2131381636));
      this.fV = ((ImageView)$(2131365502));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar = ((VideoFrameSelectBar)$(2131381610));
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView = ((FixedSizeVideoView)$(2131381864));
      this.fU = ((ImageView)$(2131381932));
      this.iR = ((RelativeLayout)$(2131381611));
      this.iR.setVisibility(8);
      this.mCancelText = ((TextView)$(2131381612));
      this.mTimeText = ((TextView)$(2131381614));
      this.Oq = ((TextView)$(2131381613));
      this.mCancelText.setOnClickListener(this);
      this.Oq.setOnClickListener(this);
      if ((this.cic != 0) && (this.cie != 0))
      {
        localObject1 = (RelativeLayout.LayoutParams)$lp(this.aB);
        localObject2 = (FrameLayout.LayoutParams)$lp(this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView);
        localLayoutParams1 = (FrameLayout.LayoutParams)$lp(this.fV);
        localLayoutParams2 = (FrameLayout.LayoutParams)$lp(this.fU);
        n = this.cic;
        m = this.cie;
        j = m;
        i = n;
        if (Build.VERSION.SDK_INT >= 17)
        {
          i1 = m;
          i = n;
        }
      }
      try
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        i1 = m;
        i = n;
        localMediaMetadataRetriever.setDataSource(this.localVideoPath);
        i1 = m;
        i = n;
        String str = localMediaMetadataRetriever.extractMetadata(24);
        i1 = m;
        i = n;
        QLog.e("EditLocalVideoActivity", 2, "rotation=" + str + "  localVideoWidth=" + this.cic + " localVideoHeight=" + this.cie);
        i1 = m;
        i = n;
        int k;
        if (!TextUtils.equals(str, "90"))
        {
          j = m;
          k = n;
          i1 = m;
          i = n;
          if (!TextUtils.equals(str, "270")) {}
        }
        else
        {
          i1 = m;
          i = n;
          k = this.cie;
          i1 = m;
          i = k;
          j = this.cic;
        }
        i1 = j;
        i = k;
        localMediaMetadataRetriever.release();
        i = k;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          QLog.e("EditLocalVideoActivity", 1, "replay error", localThrowable3);
          j = i1;
          continue;
          localLayoutParams2.height = this.cie;
        }
      }
      if (i / j >= 1.0F)
      {
        localLayoutParams2.height = -1;
        this.aB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.fV.setLayoutParams(localLayoutParams1);
        this.fU.setLayoutParams(localLayoutParams2);
        kJ();
        initVideoView();
        if (!TextUtils.isEmpty(this.localVideoPath)) {
          cvT();
        }
        Gc(0);
        this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVideoPath(this.localVideoPath);
        this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.mStartTime);
        this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QLog.e("EditLocalVideoActivity", 2, "loadLibrary Exception", localThrowable1);
        w("play_local_video", "play_local_video_success", "2", Build.MODEL);
        QQToast.a(this, acfp.m(2131705435), 0).show();
        finish();
      }
    }
  }
  
  private void cvT()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$a.removeMessages(9999);
    this.fV.setImageBitmap(null);
    this.fV.setVisibility(8);
    this.azT = this.localVideoPath;
    this.Md = this.Mb;
    long l = this.Mc;
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "initData, videoPath=" + this.azT + ", videoSize=" + this.Md + ", duration:" + l);
    }
    this.agu = 2;
    if (!TextUtils.isEmpty(this.azT))
    {
      int i = aaus.bW(this.azT);
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EditLocalVideoActivity", 2, "format is not supported ret=" + i);
        }
        awed.ad(String.valueOf(this.uin), "qzone_video_trim", "10", null);
        this.azT = null;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$a.sendEmptyMessage(1101);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "setVideoPath:" + this.azT);
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVideoPath(this.azT);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$a.sendEmptyMessageDelayed(9999, 10000L);
      return;
    }
    setResult(0);
    finish();
  }
  
  private void cvU()
  {
    bdw = aasa.SDCARD_ROOT + bdu;
    bdx = aasa.SDCARD_ROOT + bdv;
    try
    {
      Object localObject = new ArrayList();
      Collections.addAll((Collection)localObject, new String[] { bdw, bdx });
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        File localFile = new File(str);
        if ((!localFile.exists()) && (localFile.mkdirs())) {
          QZLog.d("EditLocalVideoActivity", 2, new Object[] { "assertSdcardExit create directory ", str });
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("EditLocalVideoActivity", 2, "assertSdcardExit exception", localException);
      aqhq.UD(bdx + ".nomedia");
    }
  }
  
  private void cvV()
  {
    this.uin = getAppRuntime().getLongAccountUin();
  }
  
  /* Error */
  private static Bitmap decodeFileWithBuffer(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 1469	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 1470	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_1
    //   12: ifnull +47 -> 59
    //   15: aload_2
    //   16: astore_0
    //   17: aload_1
    //   18: getfield 1473	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   21: ifeq +38 -> 59
    //   24: aload_2
    //   25: astore_0
    //   26: new 1475	java/io/BufferedInputStream
    //   29: dup
    //   30: aload_2
    //   31: sipush 2048
    //   34: invokespecial 1478	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   37: aconst_null
    //   38: aload_1
    //   39: invokestatic 1484	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_0
    //   46: astore_1
    //   47: aload_2
    //   48: ifnull +9 -> 57
    //   51: aload_2
    //   52: invokevirtual 1489	java/io/InputStream:close	()V
    //   55: aload_0
    //   56: astore_1
    //   57: aload_1
    //   58: areturn
    //   59: aload_2
    //   60: astore_0
    //   61: new 1475	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_2
    //   66: sipush 8192
    //   69: invokespecial 1478	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   72: aconst_null
    //   73: aload_1
    //   74: invokestatic 1484	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: goto -35 -> 45
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: astore_0
    //   88: invokestatic 468	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +15 -> 106
    //   94: aload_2
    //   95: astore_0
    //   96: ldc_w 470
    //   99: iconst_2
    //   100: ldc 179
    //   102: aload_1
    //   103: invokestatic 784	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_3
    //   107: astore_1
    //   108: aload_2
    //   109: ifnull -52 -> 57
    //   112: aload_2
    //   113: invokevirtual 1489	java/io/InputStream:close	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: areturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: astore_0
    //   126: invokestatic 468	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +15 -> 144
    //   132: aload_2
    //   133: astore_0
    //   134: ldc_w 470
    //   137: iconst_2
    //   138: ldc 179
    //   140: aload_1
    //   141: invokestatic 784	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   144: aload_3
    //   145: astore_1
    //   146: aload_2
    //   147: ifnull -90 -> 57
    //   150: aload_2
    //   151: invokevirtual 1489	java/io/InputStream:close	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_0
    //   157: aconst_null
    //   158: areturn
    //   159: astore_1
    //   160: aconst_null
    //   161: astore_0
    //   162: aload_0
    //   163: ifnull +7 -> 170
    //   166: aload_0
    //   167: invokevirtual 1489	java/io/InputStream:close	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: aload_0
    //   174: areturn
    //   175: astore_0
    //   176: goto -6 -> 170
    //   179: astore_1
    //   180: goto -18 -> 162
    //   183: astore_1
    //   184: goto -60 -> 124
    //   187: astore_1
    //   188: goto -102 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramString	String
    //   0	191	1	paramOptions	BitmapFactory.Options
    //   10	141	2	localFileInputStream	java.io.FileInputStream
    //   1	144	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	83	java/lang/OutOfMemoryError
    //   112	116	118	java/io/IOException
    //   2	11	121	java/io/FileNotFoundException
    //   150	154	156	java/io/IOException
    //   2	11	159	finally
    //   51	55	172	java/io/IOException
    //   166	170	175	java/io/IOException
    //   17	24	179	finally
    //   26	43	179	finally
    //   61	78	179	finally
    //   88	94	179	finally
    //   96	106	179	finally
    //   126	132	179	finally
    //   134	144	179	finally
    //   17	24	183	java/io/FileNotFoundException
    //   26	43	183	java/io/FileNotFoundException
    //   61	78	183	java/io/FileNotFoundException
    //   17	24	187	java/lang/OutOfMemoryError
    //   26	43	187	java/lang/OutOfMemoryError
    //   61	78	187	java/lang/OutOfMemoryError
  }
  
  private void eb(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString1 = Class.forName(paramString1).newInstance();
          if ((paramString1 instanceof aaqj))
          {
            this.jdField_a_of_type_Aaqj = ((aaqj)paramString1);
            this.jdField_a_of_type_Aaqj.setRefer(paramString2);
            return;
          }
        }
        catch (Throwable paramString1)
        {
          this.jdField_a_of_type_Aaqj = null;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditLocalVideoActivity", 2, "initComponentParamData:exp =" + paramString1);
  }
  
  public static String fX()
  {
    File localFile1 = null;
    String str2 = null;
    Object localObject = localFile1;
    try
    {
      File localFile2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
      String str1 = str2;
      if (localFile2 != null)
      {
        str1 = str2;
        localObject = localFile1;
        if (localFile2.exists())
        {
          localObject = localFile1;
          str2 = localFile2.getAbsolutePath() + "/Camera";
          localObject = str2;
          localFile1 = new File(str2);
          str1 = str2;
          localObject = str2;
          if (!localFile1.exists())
          {
            localObject = str2;
            localFile1.mkdir();
            str1 = str2;
          }
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      QLog.w("EditLocalVideoActivity", 2, "getCameraDirectoryPath error", localException);
    }
    return localObject;
  }
  
  private void hh(String paramString) {}
  
  private boolean iR(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  private void initData()
  {
    boolean bool = false;
    cvV();
    Intent localIntent = getIntent();
    this.cii = localIntent.getIntExtra("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", 0);
    this.localVideoPath = localIntent.getStringExtra("file_send_path");
    if (!TextUtils.isEmpty(this.localVideoPath))
    {
      if (!new File(this.localVideoPath).exists())
      {
        QLog.e("EditLocalVideoActivity", 2, "localVideoPath not exists : " + this.localVideoPath);
        arxa.a().showToast(acfp.m(2131705434));
        finish();
      }
    }
    else
    {
      QLog.e("EditLocalVideoActivity", 2, "localVideoPath is null : " + this.localVideoPath);
      arxa.a().showToast(acfp.m(2131705428));
      finish();
      return;
    }
    this.bdy = this.localVideoPath;
    this.Mb = localIntent.getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
    this.Mc = localIntent.getLongExtra("file_send_duration", 0L);
    this.cic = localIntent.getIntExtra("file_width", 0);
    this.cie = localIntent.getIntExtra("file_height", 0);
    QLog.i("EditLocalVideoActivity", 2, "localVideoWidth: " + this.cic + " ,    localVideoHeight: " + this.cie);
    this.bwI = localIntent.getBooleanExtra("is_qzone_vip", false);
    this.topicId = localIntent.getStringExtra("topic_id");
    if (!TextUtils.isEmpty(this.topicId)) {
      bool = true;
    }
    this.isTopic = bool;
    this.topicSyncQzone = localIntent.getBooleanExtra("param.topicSyncQzone", this.topicSyncQzone);
    this.cif = localIntent.getIntExtra("extra_key_font_id", -1);
    this.cig = localIntent.getIntExtra("extra_key_font_format_type", -1);
    this.mFontUrl = localIntent.getStringExtra("extra_key_font_url");
    this.cih = localIntent.getIntExtra("extra_key_super_font_id", -1);
    this.bdz = localIntent.getStringExtra("extra_key_super_font_info");
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$a.sendEmptyMessage(1009);
    this.mRefer = localIntent.getStringExtra("short_video_refer");
    this.bdA = localIntent.getStringExtra("set_user_callback");
    eb(this.bdA, this.mRefer);
    this.mStartTime = ((int)localIntent.getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_START_TIME", 0L));
    this.mEndTime = ((int)localIntent.getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_END_TIME", 0L));
    this.mDuration = ((int)localIntent.getLongExtra("PhotoConst.EDIT_LOCAL_VIDEO_DURATION", 0L));
    if (this.mStartTime != 0) {
      this.agt = this.mStartTime;
    }
    this.qzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)localIntent.getParcelableExtra("key_qzone_topic"));
  }
  
  private void initVideoView()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnFixVDPlayCompelteListener(new aapb(this));
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnErrorListener(new aapc(this));
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnPreparedListener(new aapd(this));
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnTouchListener(new aape(this));
  }
  
  private void kJ()
  {
    this.fU.setOnClickListener(new aapa(this));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.setOnFramesClipChangeListener(this);
    }
  }
  
  private void onConfirm()
  {
    int j = 0;
    int k = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.aT();
    int m = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.aU();
    if (!rg())
    {
      Toast.makeText(MobileQQ.getContext(), acfp.m(2131705423), 1).show();
      return;
    }
    this.mNeedProcess = true;
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "toPublishMood, startTime=" + k + ", endTime=" + m + ", duration=" + (m - k));
    }
    Object localObject = "";
    Bitmap localBitmap;
    int i;
    if (Ll)
    {
      localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(this.azT);
      localBitmap = ((MediaMetadataRetriever)localObject).getFrameAtTime(k * 1000L);
      ((MediaMetadataRetriever)localObject).release();
      localObject = "";
      i = 0;
    }
    for (;;)
    {
      if (localBitmap != null)
      {
        localObject = aauq.JD + File.separator + System.currentTimeMillis() + ".jpg";
        if (awcr.saveBitmapToFile(localBitmap, (String)localObject, Bitmap.CompressFormat.JPEG, 90, true))
        {
          j = localBitmap.getWidth();
          i = localBitmap.getHeight();
        }
      }
      for (;;)
      {
        aauq.ahI();
        this.mStartTime = k;
        this.mEndTime = m;
        this.JB = ((String)localObject);
        this.agw = i;
        this.agv = j;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$a.sendEmptyMessage(1103);
        return;
        if (aaut.g(this.azT, this.mVideoWidth, this.mVideoHeight) == 0) {}
        for (boolean bool = TrimNative.isGetFrameReady();; bool = false)
        {
          if (!bool) {
            break label326;
          }
          localBitmap = aaut.a(k, k + 1000);
          localObject = "";
          i = 0;
          break;
        }
        label326:
        QLog.w("EditLocalVideoActivity", 2, "TrimNative.isGetFrameReady return false,thumbnail pic is null.");
        if (!re()) {
          break label442;
        }
        if (k <= 1000) {
          localObject = this.JB;
        }
        j = this.agv;
        i = this.agw;
        localBitmap = null;
        break;
        localObject = "";
        QLog.e("EditLocalVideoActivity", 2, "save jpg failed");
        awed.ad(String.valueOf(this.uin), "qzone_video_trim", "4", null);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("EditLocalVideoActivity", 2, "getFrame failed");
        }
        awed.ad(String.valueOf(this.uin), "qzone_video_trim", "5", null);
      }
      label442:
      localObject = "";
      localBitmap = null;
      i = 0;
    }
  }
  
  private boolean re()
  {
    return "cover_mall_record_video".equals(this.mRefer);
  }
  
  private boolean rg()
  {
    if (!avsu.isExternalAvailable())
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditLocalVideoActivity", 2, "isEnoughStorage() sdcard not mounted");
      }
      awed.ad(String.valueOf(this.uin), "qzone_video_trim", "6", null);
    }
    long l = awcf.getFileSize(this.azT);
    if (l <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "no file size");
      }
      awed.ad(String.valueOf(this.uin), "qzone_video_trim", "7", null);
      return false;
    }
    if (l / this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getDuration() * (this.mEndTime - this.mStartTime) > avsu.getSDCardRemain())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "there is not enough space on sdcard");
      }
      awed.ad(String.valueOf(this.uin), "qzone_video_trim", "8", null);
      return false;
    }
    return true;
  }
  
  private void w(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString2, paramString3);
    localHashMap.put("reserve", paramString4);
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(String.valueOf(this.uin), paramString1, true, 0L, 0L, localHashMap, null);
  }
  
  public void F(float paramFloat)
  {
    runOnUiThread(new EditLocalVideoActivity.22(this, paramFloat));
  }
  
  public Bitmap b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("EditLocalVideoActivity", 2, "getBitmapWithSize but fileName is empty");
      paramString = null;
      return paramString;
    }
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    decodeFileWithBuffer(paramString, localOptions);
    localOptions.inJustDecodeBounds = false;
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    j = Math.min(i / paramInt1, j / paramInt2);
    i = j;
    if (j < 1) {
      i = 1;
    }
    localOptions.inSampleSize = i;
    Bitmap localBitmap2 = a(localOptions, paramString, true);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localOptions.inSampleSize += 1;
      localBitmap1 = a(localOptions, paramString);
    }
    if (localBitmap1 == null) {
      return null;
    }
    i = localBitmap1.getWidth();
    j = localBitmap1.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    if ((f1 > 1.0F) && (f2 > 1.0F)) {
      return localBitmap1;
    }
    paramString = new Matrix();
    if (paramBoolean) {
      if (f1 > f2)
      {
        f1 = f2;
        label230:
        paramString.postScale(f1, f1);
      }
    }
    for (;;)
    {
      localBitmap2 = a(localBitmap1, i, j, paramString, true);
      paramString = localBitmap2;
      if (localBitmap2 == localBitmap1) {
        break;
      }
      localBitmap1.recycle();
      return localBitmap2;
      break label230;
      paramString.postScale(f1, f2);
    }
  }
  
  public void bd(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "onFramesClipChanged, startTime=" + paramInt1 + ", endTime=" + paramInt2);
    }
    if (this.bwH) {
      LpReportInfo_pf00064.allReport(664, 4, 4);
    }
    runOnUiThread(new EditLocalVideoActivity.19(this));
    if (this.fU.getVisibility() != 0) {
      runOnUiThread(new EditLocalVideoActivity.20(this));
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new EditLocalVideoActivity.21(this, paramInt1, paramInt2));
    if (this.mStartTime == 0) {
      this.agt = paramInt1;
    }
    if (this.jdField_a_of_type_Aapn != null) {
      this.jdField_a_of_type_Aapn.gr(paramInt1, paramInt2);
    }
  }
  
  /* Error */
  public String bj(String paramString)
  {
    // Byte code:
    //   0: invokestatic 1763	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 1831	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: aload_2
    //   8: new 125	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 1833
    //   18: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 1839	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: aconst_null
    //   32: ldc_w 1841
    //   35: iconst_1
    //   36: anewarray 456	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: aconst_null
    //   44: invokestatic 1847	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +214 -> 263
    //   52: aload_1
    //   53: invokeinterface 1852 1 0
    //   58: ifeq +205 -> 263
    //   61: aload_1
    //   62: aload_1
    //   63: ldc_w 1854
    //   66: invokeinterface 1857 2 0
    //   71: invokeinterface 1858 2 0
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 719	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne +176 -> 257
    //   84: new 456	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: invokevirtual 1862	java/lang/String:getBytes	()[B
    //   92: ldc_w 1864
    //   95: invokespecial 1867	java/lang/String:<init>	([BLjava/lang/String;)V
    //   98: invokestatic 1872	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: invokestatic 468	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +30 -> 135
    //   108: ldc_w 470
    //   111: iconst_2
    //   112: new 125	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 1874
    //   122: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 1570	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_2
    //   136: astore_3
    //   137: aload_1
    //   138: ifnull +11 -> 149
    //   141: aload_1
    //   142: invokeinterface 1875 1 0
    //   147: aload_2
    //   148: astore_3
    //   149: aload_3
    //   150: areturn
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_2
    //   154: ldc 179
    //   156: astore_1
    //   157: invokestatic 468	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +33 -> 193
    //   163: ldc_w 470
    //   166: iconst_2
    //   167: new 125	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 1877
    //   177: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_3
    //   181: invokestatic 1881	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   184: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 730	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload_1
    //   194: astore_3
    //   195: aload_2
    //   196: ifnull -47 -> 149
    //   199: aload_2
    //   200: invokeinterface 1875 1 0
    //   205: aload_1
    //   206: areturn
    //   207: astore_2
    //   208: aconst_null
    //   209: astore_1
    //   210: aload_1
    //   211: ifnull +9 -> 220
    //   214: aload_1
    //   215: invokeinterface 1875 1 0
    //   220: aload_2
    //   221: athrow
    //   222: astore_2
    //   223: goto -13 -> 210
    //   226: astore_3
    //   227: aload_2
    //   228: astore_1
    //   229: aload_3
    //   230: astore_2
    //   231: goto -21 -> 210
    //   234: astore_3
    //   235: aload_1
    //   236: astore_2
    //   237: ldc 179
    //   239: astore_1
    //   240: goto -83 -> 157
    //   243: astore 4
    //   245: aload_2
    //   246: astore_3
    //   247: aload_1
    //   248: astore_2
    //   249: aload_3
    //   250: astore_1
    //   251: aload 4
    //   253: astore_3
    //   254: goto -97 -> 157
    //   257: ldc 179
    //   259: astore_2
    //   260: goto -158 -> 102
    //   263: ldc 179
    //   265: astore_2
    //   266: goto -131 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	EditLocalVideoActivity
    //   0	269	1	paramString	String
    //   6	194	2	localObject1	Object
    //   207	14	2	localObject2	Object
    //   222	6	2	localObject3	Object
    //   230	36	2	localObject4	Object
    //   136	14	3	localObject5	Object
    //   151	30	3	localException1	Exception
    //   194	1	3	str	String
    //   226	4	3	localObject6	Object
    //   234	1	3	localException2	Exception
    //   246	8	3	localObject7	Object
    //   243	9	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   7	48	151	java/lang/Exception
    //   7	48	207	finally
    //   52	102	222	finally
    //   102	135	222	finally
    //   157	193	226	finally
    //   52	102	234	java/lang/Exception
    //   102	135	243	java/lang/Exception
  }
  
  protected void buQ()
  {
    setContentViewNoTitle(2131561413);
    this.dw = ((RelativeLayout)$(2131366243));
    this.dM = ((ViewGroup)$(2131367263));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)$(2131367252));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)$(2131367249));
    this.jdField_b_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    this.Oo = ((TextView)$(2131367318));
    this.Oo.setOnClickListener(this);
    this.jdField_fd_of_type_AndroidWidgetTextView = ((TextView)$(2131367313));
    this.jdField_fd_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.iP = ((RelativeLayout)$(2131367285));
    this.iP.setOnClickListener(this);
    this.jdField_fd_of_type_AndroidWidgetButton = ((Button)$(2131367286));
    this.jdField_fd_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.Op = ((TextView)$(2131367287));
    this.iO = ((RelativeLayout)$(2131367260));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)wja.a(2, 50, getResources()));
    this.iO.setBackgroundColor(getResources().getColor(2131166737));
    this.iO.setVisibility(0);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = wja.dp2px(55.0F, getResources());
    this.iO.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText = ((ExtendEditText)$(2131367261));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setEditableFactory(aofw.a);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.fc = ((Button)$(2131367304));
    this.fc.setOnClickListener(this);
    this.zI = $(2131367309);
    cvI();
    cvJ();
  }
  
  public void h(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.a locala = new QZoneClickReport.a();
    locala.actionType = paramString1;
    locala.cMI = paramString2;
    locala.reserves = paramString3;
    QZoneClickReport.report(String.valueOf(this.uin), locala, paramBoolean);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent.containsKey("permission_code")) {
          this.mPriv = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.eo == null) {
            this.eo = new ArrayList();
          }
          this.eo.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.eo.addAll((Collection)localObject);
          }
        }
        if (bg(this.mPriv))
        {
          this.pO = paramIntent.getString("key_setting_raw_json");
          this.uO = paramIntent.getString("key_selected_tag");
        }
        uy();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 1009) {
          break;
        }
        this.bwF = false;
        if (this.zJ != null) {
          this.zJ.setVisibility(8);
        }
      } while (paramIntent == null);
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle.containsKey("extra_key_bundle_priv_key"))
      {
        paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
        if (paramIntent != null)
        {
          this.mPriv = paramIntent.getInt("permission_code");
          if (this.eo == null) {
            this.eo = new ArrayList();
          }
          this.eo.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.eo.addAll((Collection)localObject);
          }
          if (bg(this.mPriv))
          {
            this.pO = paramIntent.getString("key_setting_raw_json");
            this.uO = paramIntent.getString("key_selected_tag");
          }
          uy();
        }
      }
      if (localBundle.containsKey("contentIntentKey"))
      {
        localObject = localBundle.getString("contentIntentKey");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = "";
        }
        this.mContent = paramIntent;
      }
      if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
      {
        paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.setText(paramIntent);
      }
      this.cif = localBundle.getInt("extra_key_font_id", -1);
      this.cig = localBundle.getInt("extra_key_font_format_type");
      this.mFontUrl = localBundle.getString("extra_key_font_url");
      this.cih = localBundle.getInt("extra_key_super_font_id", -1);
      this.bdz = localBundle.getString("extra_key_super_font_info");
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity$a.sendEmptyMessage(1009);
      return;
    } while ((paramInt1 != 1010) || (paramInt2 != -1));
    this.bwI = true;
  }
  
  public void onBackPressed()
  {
    this.bwJ = true;
    cvK();
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
      LpReportInfo_pf00064.allReport(664, 3, 1);
      if (this.bwD)
      {
        this.bwE = true;
        cvM();
        cvL();
      }
      else
      {
        Toast.makeText(getApplicationContext(), acfp.m(2131705417), 1).show();
        continue;
        LpReportInfo_pf00064.allReport(664, 4, 1);
        if (this.bwC)
        {
          QLog.e("EditLocalVideoActivity", 2, "click clip ");
          localObject1 = b(this.JB, this.agv, this.agw, false);
          if (localObject1 != null) {
            this.fV.setImageBitmap((Bitmap)localObject1);
          }
          for (;;)
          {
            this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.agt);
            this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
            this.bwH = true;
            CA(true);
            break;
            QLog.e("EditLocalVideoActivity", 2, "click clip but coverview find bitmap is null");
          }
        }
        long l = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoDurationThreshold", 90000);
        Toast.makeText(getApplicationContext(), acfp.m(2131705424) + l / 1000L + acfp.m(2131705439), 1).show();
        continue;
        LpReportInfo_pf00064.allReport(664, 1);
        this.bwJ = false;
        cvK();
        continue;
        Object localObject1 = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1").replace("{uin}", String.valueOf(this.uin)).replace("{qua}", avpq.getQUA3());
        h("608", "6", "0", true);
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("permission_code", this.mPriv);
        Iterator localIterator;
        if ((this.eo != null) && (this.eo.size() > 0))
        {
          ((Bundle)localObject2).putStringArrayList("uin_list", this.eo);
          localObject3 = new ArrayList(this.eo.size());
          localIterator = this.eo.iterator();
          while (localIterator.hasNext()) {
            ((ArrayList)localObject3).add(bj((String)localIterator.next()));
          }
          ((Bundle)localObject2).putStringArrayList("key_nicknames", (ArrayList)localObject3);
        }
        if ((bg(this.mPriv)) && (!TextUtils.isEmpty(this.pO))) {
          ((Bundle)localObject2).putString("key_setting_raw_json", this.pO);
        }
        avpw.forwardToBrowser(this, (String)localObject1, 2, (Bundle)localObject2, "");
        continue;
        cvO();
        continue;
        this.bwF = true;
        h("608", "5", "0", true);
        localObject2 = avpw.d.a();
        Object localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("permission_code", this.mPriv);
        if ((this.eo != null) && (this.eo.size() > 0))
        {
          ((Bundle)localObject3).putStringArrayList("uin_list", this.eo);
          localObject1 = new ArrayList(this.eo.size());
          localIterator = this.eo.iterator();
          while (localIterator.hasNext()) {
            ((ArrayList)localObject1).add(bj((String)localIterator.next()));
          }
          ((Bundle)localObject3).putStringArrayList("key_nicknames", (ArrayList)localObject1);
        }
        if ((bg(this.mPriv)) && (!TextUtils.isEmpty(this.pO))) {
          ((Bundle)localObject3).putString("key_setting_raw_json", this.pO);
        }
        if (this.zJ == null)
        {
          this.zJ = new View(this);
          this.zJ.setBackgroundColor(Color.argb(128, 0, 0, 0));
          this.zJ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
          this.dw.addView(this.zJ);
        }
        this.zJ.setVisibility(0);
        localObject1 = "";
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText.getText().toString();
        }
        if (this.isTopic) {}
        for (int i = 0;; i = 1)
        {
          avpw.a(this, (avpw.d)localObject2, 1009, "", (String)localObject1, "", "", 0, i, 1, 0, 0, 0, "", 10000, (Bundle)localObject3, this.isTopic, this.topicSyncQzone, this.cif, this.cih, false);
          break;
        }
        if (!this.bwI)
        {
          adL();
        }
        else if (this.bwB)
        {
          this.bwB = false;
          this.jdField_fd_of_type_AndroidWidgetButton.setBackgroundResource(2130850051);
          this.mIsUploadOrigin = false;
        }
        else
        {
          h("608", "7", "1", true);
          this.bwB = true;
          this.jdField_fd_of_type_AndroidWidgetButton.setBackgroundResource(2130850050);
          this.mIsUploadOrigin = true;
          continue;
          LpReportInfo_pf00064.allReport(664, 4, 2);
          cvQ();
          continue;
          LpReportInfo_pf00064.allReport(664, 4, 3);
          h("608", "4", "1", true);
          QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").post(new EditLocalVideoActivity.5(this));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    getWindow().addFlags(128);
    getWindow().addFlags(1024);
    cvU();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    initData();
    buQ();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    awig.a().Wp();
    if (this.jdField_a_of_type_Aapn != null) {
      this.jdField_a_of_type_Aapn.cwb();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (!TextUtils.isEmpty(this.azT))
    {
      if (this.bwH) {
        break label43;
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aapn != null) {
        this.jdField_a_of_type_Aapn.cwc();
      }
      return;
      label43:
      if (this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.isPlaying()) {
        this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.bwE)
    {
      LpReportInfo_pf00064.allReport(664, 3, 2);
      this.bwE = false;
    }
    cnJ();
    if (this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null)
    {
      if (this.bwH) {
        break label84;
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.mStartTime);
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
      this.fU.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aapn != null) {
        this.jdField_a_of_type_Aapn.cwd();
      }
      return;
      label84:
      Bitmap localBitmap = b(this.JB, this.agv, this.agw, false);
      if (localBitmap != null) {
        this.fV.setImageBitmap(localBitmap);
      }
      CA(true);
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.agt);
      this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
    }
  }
  
  public long s(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l = paramString.getAvailableBlocks();
      int i = paramString.getBlockSize();
      return i * l;
    }
    catch (Exception paramString)
    {
      QLog.w("EditLocalVideoActivity", 2, "getFreeSpace error", paramString);
    }
    return 0L;
  }
  
  public String time2str(int paramInt)
  {
    int j = paramInt / 1000;
    paramInt = j % 60;
    int i = j / 60 % 60;
    j /= 3600;
    this.mFormatBuilder.setLength(0);
    if (j > 0) {
      return this.mFormatter.format("%d:%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) }).toString();
    }
    return this.mFormatter.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) }).toString();
  }
  
  public void uy()
  {
    this.fc.setText(ad(this.mPriv));
  }
  
  public static class a
    extends Handler
  {
    private WeakReference<EditLocalVideoActivity> activity;
    
    a(EditLocalVideoActivity paramEditLocalVideoActivity)
    {
      this.activity = new WeakReference(paramEditLocalVideoActivity);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((this.activity == null) || (this.activity.get() == null)) {}
      EditLocalVideoActivity localEditLocalVideoActivity;
      do
      {
        return;
        localEditLocalVideoActivity = (EditLocalVideoActivity)this.activity.get();
        switch (paramMessage.what)
        {
        case 1000: 
        default: 
          return;
        case 1001: 
          EditLocalVideoActivity.b(localEditLocalVideoActivity);
          return;
        case 1103: 
          EditLocalVideoActivity.a(localEditLocalVideoActivity);
          return;
        case 1102: 
          EditLocalVideoActivity.a(localEditLocalVideoActivity, paramMessage);
          return;
        }
      } while (EditLocalVideoActivity.a(localEditLocalVideoActivity) == null);
      EditLocalVideoActivity.a(localEditLocalVideoActivity).requestLayout();
      return;
      EditLocalVideoActivity.c(localEditLocalVideoActivity);
      return;
      Toast.makeText(localEditLocalVideoActivity.getApplicationContext(), acfp.m(2131705429), 1).show();
      EditLocalVideoActivity.d(localEditLocalVideoActivity);
      return;
      localEditLocalVideoActivity.h("608", "3", "1", true);
      LpReportInfo_pf00064.allReport(664, 3, 4);
      paramMessage = (String)paramMessage.obj;
      return;
      localEditLocalVideoActivity.h("608", "3", "2", true);
      return;
      EditLocalVideoActivity.e(localEditLocalVideoActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity
 * JD-Core Version:    0.7.0.1
 */