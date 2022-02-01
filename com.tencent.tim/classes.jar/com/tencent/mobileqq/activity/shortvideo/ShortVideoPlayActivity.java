package com.tencent.mobileqq.activity.shortvideo;

import aazh;
import aazi;
import aazk;
import aazl;
import aazm;
import aazn;
import aazo;
import aazp;
import aazs;
import aazt;
import aazu;
import aazv;
import aazw;
import aazx;
import aazy;
import acbn;
import acfp;
import ahgq;
import aiyw;
import ajlg;
import alar;
import allf;
import alyr;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import anfr;
import anfu;
import angi;
import anot;
import anpc;
import aoko;
import aonu;
import aooi;
import aopd;
import aqgz;
import aqha;
import aqhq;
import aqiw;
import aqju;
import aqmj;
import aqmr;
import ausj;
import avja;
import avkd;
import avpw;
import avpw.d;
import ayxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;
import com.tencent.util.VersionUtils;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.b;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import wla;
import wla.a;

@TargetApi(11)
public class ShortVideoPlayActivity
  extends BaseActivity
  implements View.OnClickListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnVideoPreparedListener, ISPlayerVideoView.IVideoViewCallBack, DragView.b, wla.a
{
  static String baK = aqmj.bo(BaseApplication.getContext());
  static String[] cX;
  public View Ao;
  long Ju = -1L;
  boolean LD = false;
  long MT;
  private long MU;
  private long MV;
  private long MW;
  private long MX;
  private long MY;
  private long MZ;
  private long Na;
  private long Nb;
  private long Nc;
  private long Nd;
  private long Ne;
  private long Nf;
  private long Ng;
  private long Nh;
  TextView OR;
  TextView OS;
  TextView OT;
  DragView a;
  URLImageView aE;
  public String aIf;
  private boolean aPx;
  boolean acN = false;
  long ap;
  private boolean bBA;
  public boolean bBB = false;
  boolean bBp;
  public boolean bBq = false;
  boolean bBr = false;
  boolean bBs = false;
  boolean bBt;
  public boolean bBu = false;
  private boolean bBv;
  private boolean bBw;
  private boolean bBx;
  private boolean bBy;
  private boolean bBz;
  long bS;
  int bWR = -1;
  String beL = "";
  String beM;
  String beN;
  public String beO = "0";
  String beP;
  private String beQ;
  private String beR;
  private String beS;
  private String beT;
  private String beU;
  private String beV;
  private String beW;
  public boolean biF;
  private boolean bsQ = true;
  private boolean bsR = true;
  private boolean bsS = true;
  public boolean bsT;
  public avkd c;
  String[] cJ;
  Bitmap cL;
  private int ceI;
  public int ceJ;
  int ceK = 1;
  public int cmQ = 0;
  public int cmR = -1;
  private int cmS;
  private int cmT;
  int cmU;
  public int cmV;
  private int cmW;
  private int cmX;
  private int cmY;
  private int cmZ;
  private int cna;
  private int cnb;
  private int cnc;
  private int cnd;
  private int cne;
  private int cnf;
  private int cng;
  private int cnh;
  private int cni;
  private int cnj;
  private int cnk;
  private int cnl;
  private int cnm;
  ValueAnimator d = null;
  public RelativeLayout dR;
  final Runnable eu;
  public long fB;
  public WeakReference<ISuperPlayer> fa;
  final Runnable fn;
  RelativeLayout iW;
  RelativeLayout iX;
  RelativeLayout iY;
  private RelativeLayout iZ;
  LinearLayout ic;
  MessageForShortVideo l;
  Bundle mBundle;
  ImageView mCloseBtn;
  private boolean mCompleted;
  public Context mContext;
  String mCurrentUin;
  String mDomain;
  public long mDuration = -1L;
  private int mErrCode;
  long mFileSize;
  int mFileType;
  public final WeakReference<MqqHandler> mHandler;
  boolean mHidden;
  boolean mInterrupted = false;
  boolean mIsUploading = false;
  public String mMd5;
  SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener;
  public int mPlayState = 0;
  TextView mProgressTime;
  private TextView mRateText;
  BroadcastReceiver mReceiver;
  RelativeLayout mRoot;
  public SeekBar mSeekBar;
  long mStartPlayTime = -1L;
  private int mStatus = -1;
  TextView mTotalTime;
  public int mUinType;
  private String mUuid;
  public String mVideoPath;
  ISPlayerVideoView mVideoView;
  String msg_id = "";
  SeekBar o;
  Rect originRect;
  protected ImageView sf;
  LinearLayout top_blackLH;
  ImageView wP;
  long yF;
  
  static
  {
    if ((baK != null) && (baK.length() > 0)) {
      cX = baK.split("\\|");
    }
  }
  
  public ShortVideoPlayActivity()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.d = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
      this.d.setDuration(2500L);
      this.d.addUpdateListener(new aazh(this));
    }
    this.mHandler = new WeakReference(new aazp(this));
    this.eu = new ShortVideoPlayActivity.5(this);
    this.fn = new ShortVideoPlayActivity.6(this);
    this.mHidden = true;
    this.mReceiver = new aazy(this);
    this.mOnSeekBarChangeListener = new aazn(this);
  }
  
  private void Do(boolean paramBoolean)
  {
    if (!this.bsR) {}
    do
    {
      do
      {
        return;
      } while (!this.bBv);
      if (this.mErrCode == 0) {
        paramBoolean = true;
      }
    } while (this.l == null);
    this.bsR = false;
    HashMap localHashMap = new HashMap();
    String str = "actShortVideoDownloadVideo";
    if (this.mFileType == 6) {
      str = "actShortVideoDownloadVideo";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "reportTag = " + str);
      }
      localHashMap.put("param_uuid", this.mUuid);
      localHashMap.put("param_picSize", String.valueOf(this.mFileSize));
      localHashMap.put("param_fileMd5", this.mMd5);
      localHashMap.put("param_busiType", this.cmQ + "");
      localHashMap.put("param_videoDuration", String.valueOf(this.l.videoFileTime));
      if (!paramBoolean) {
        break;
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, str, true, this.Nd, this.mFileSize, localHashMap, "");
      return;
      if ((this.mFileType == 9) || (this.mFileType == 17))
      {
        str = "actShortVideoDiscussgroupDownloadVideo";
        localHashMap.put("param_grpUin", this.beO);
      }
    }
    if (this.mErrCode != -9527) {
      localHashMap.remove("param_rspHeader");
    }
    localHashMap.put("param_FailCode", String.valueOf(this.mErrCode));
    anpc.a(BaseApplication.getContext()).collectPerformance(null, str, false, this.Nd, 0L, localHashMap, "");
  }
  
  private void X(long paramLong1, long paramLong2)
  {
    int i = 0;
    if (paramLong2 != 0L) {
      i = (int)(100L * paramLong1 / paramLong2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "updateUploadInfo " + i + " " + paramLong1 + " " + paramLong2);
    }
    if (this.OR != null) {
      this.OR.setText(bg(paramLong1) + "/" + bg(paramLong2));
    }
    if (this.o != null) {
      this.o.setProgress(i);
    }
  }
  
  private anfu a()
  {
    anfu localanfu = new anfu();
    try
    {
      JSONObject localJSONObject = new JSONObject(this.beM);
      if (localJSONObject != null)
      {
        localanfu.dFl = localJSONObject.getInt("busi_type");
        localanfu.uuid = localJSONObject.getString("file_uuid");
        String str = localJSONObject.getString("file_md5");
        localanfu.md5 = str;
        this.mMd5 = str;
        localanfu.size = localJSONObject.getInt("file_size");
        localanfu.uinType = this.cmR;
        localanfu.selfUin = this.mCurrentUin;
        localanfu.peerUin = this.beO;
        localanfu.bUG = this.beO;
        localanfu.fileType = 1001;
        this.mFileType = 1001;
        localanfu.localPath = ip(localanfu.md5);
        return localanfu;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private boolean aU(Context paramContext)
  {
    File localFile = Environment.getExternalStorageDirectory();
    if ((localFile.exists()) && (localFile.canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label72;
      }
    }
    label72:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label77;
      }
      QQToast.a(paramContext, 1, 2131719242, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
      return false;
      i = 0;
      break;
    }
    label77:
    return true;
  }
  
  private String bg(long paramLong)
  {
    if (paramLong < 1024L) {
      return paramLong + "B";
    }
    if (paramLong < 1048576L)
    {
      f = (float)paramLong / 1024.0F;
      return String.format("%.2f", new Object[] { Float.valueOf(f) }) + "K";
    }
    float f = (float)paramLong / 1048576.0F;
    return String.format("%.2f", new Object[] { Float.valueOf(f) }) + "M";
  }
  
  private int bp()
  {
    int i = 16392;
    if (this.bS != -1L) {
      i = 16456;
    }
    return i | 0x200;
  }
  
  private void cAF()
  {
    if ((this.l == null) || (this.mStatus == -1) || (this.l.videoFileStatus == 2003)) {
      break label28;
    }
    label28:
    while (!this.bsS) {
      return;
    }
    this.bsS = false;
    if (this.mFileSize == 0L) {}
    for (int i = 0;; i = (int)(100L * this.ap / this.mFileSize))
    {
      if (this.l.videoFileProgress < 0) {
        this.l.videoFileProgress = 0;
      }
      int j = this.l.videoFileProgress;
      if (((this.l.videoFileStatus == 1002) || (this.l.videoFileStatus == 2002)) && (this.l.videoFileStatus == this.mStatus) && (i - j < 10)) {
        break;
      }
      if ((this.mFileType != 6) && (this.mFileType != 17) && (this.mFileType != 9))
      {
        j = i;
        if (this.mFileType != 20) {}
      }
      else
      {
        if (this.mStatus == 2002) {
          this.l.transferedSize = ((int)this.ap);
        }
        j = i;
        if (this.mStatus == 2003)
        {
          this.l.transferedSize = 0;
          j = 100;
        }
      }
      if (((this.l.videoFileStatus == 2004) || (this.l.videoFileStatus == 1004)) && ((this.mStatus == 1002) || (this.mStatus == 2002))) {
        break;
      }
      this.l.videoFileStatus = this.mStatus;
      this.l.fileType = this.mFileType;
      this.l.videoFileProgress = j;
      if ((this.l.mPreUpload) && (this.mStatus == 1003) && (this.mMd5 != null)) {
        this.l.md5 = this.mMd5;
      }
      if ((this.mStatus == 2003) && (!aqmr.isEmpty(this.mVideoPath)))
      {
        File localFile = new File(this.mVideoPath);
        this.l.lastModified = localFile.lastModified();
      }
      this.l.serial();
      this.app.b().c(this.l.frienduin, this.mUinType, this.l.uniseq, this.l.msgData);
      return;
    }
  }
  
  private void cAs()
  {
    if (this.LD) {}
    for (int i = 1;; i = 0)
    {
      if ((anfr.cFn) || (System.currentTimeMillis() - anfr.akU < 300000L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "needRemind=false");
        }
        i = 0;
      }
      if (i != 0)
      {
        Object localObject = this.mContext.getString(2131720253);
        aqju localaqju = aqha.a(this.mContext, 230, null, (String)localObject, 2131696322, 2131721952, new aazw(this), new aazx(this));
        localObject = aiyw.a(this.mContext, this.app, 1, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          localaqju.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        pause();
        this.bBu = false;
        d(localaqju);
      }
      return;
    }
  }
  
  private void cAv()
  {
    Object localObject;
    if (this.mIsUploading)
    {
      localObject = this.app.a().a(this.l.frienduin, this.l.uniseq);
      if ((localObject instanceof aonu))
      {
        localObject = (aonu)localObject;
        X(((aonu)localObject).fF(), ((aonu)localObject).getFileSize());
      }
      localObject = wla.a(this.app);
      if (localObject != null) {
        ((wla)localObject).a(this.mRoot, this);
      }
      this.mVideoPath = ShortVideoUtils.a(this.l, "mp4");
      if (new File(this.mVideoPath).exists())
      {
        long l1 = this.l.videoFileSize;
        this.mFileSize = l1;
        this.ap = l1;
        this.cmT = 10000;
      }
      for (;;)
      {
        play(this.fB);
        return;
        Bi(acfp.m(2131714514));
      }
    }
    showAnimation();
    if ((this.cmQ == 1) || (this.cmQ == 2) || (this.cmQ == 4) || (this.mUinType == 9501) || (this.cmQ == 6))
    {
      this.sf.setVisibility(8);
      if ((this.cmQ != 2) || (this.beM == null)) {}
    }
    try
    {
      localObject = new JSONObject(this.beM);
      this.mFileType = 1001;
      this.mVideoPath = ip(((JSONObject)localObject).getString("file_md5"));
      this.mFileSize = ((JSONObject)localObject).getInt("file_size");
      this.mUuid = ((JSONObject)localObject).getString("file_uuid");
      label297:
      localObject = new File(this.mVideoPath);
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        this.ap = ((File)localObject).length();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView(), #PLAY_CALLER_STRUCT_MSG#, have video size=" + this.ap + " msg.size=" + this.mFileSize);
        }
        if (this.ap < this.mFileSize) {
          this.LD = true;
        }
        if (this.LD)
        {
          cAx();
          localObject = wla.a(this.app);
          if (localObject != null) {
            ((wla)localObject).a(this.mRoot, this);
          }
          this.mSeekBar.setSecondaryProgress(this.cmT);
        }
      }
      do
      {
        this.bBv = this.LD;
        if (this.LD) {
          break label975;
        }
        play(this.fB);
        return;
        this.LD = true;
        break;
      } while ((this.cmQ != 0) && (this.cmQ != 5));
      int i;
      if (this.l.getBitValue(1) == 0)
      {
        if (this.l.getBitValue(0) == 1)
        {
          i = 101;
          label520:
          alar.jf(1000, i);
          this.l.setBitValue(1, (byte)1);
          ThreadManager.getFileThreadHandler().post(new ShortVideoPlayActivity.12(this));
        }
      }
      else
      {
        this.mVideoPath = ShortVideoUtils.a(this.l, "mp4");
        localObject = new File(this.mVideoPath);
        if (!((File)localObject).exists()) {
          break label951;
        }
        this.ap = ((File)localObject).length();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView(), #PLAY_CALLER_SHORT_VIDEO#, have video size=" + this.ap + " msg.size=" + this.l.videoFileSize + " status=" + this.l.videoFileStatus);
        }
        this.mFileSize = this.l.videoFileSize;
        this.cmT = 10000;
        this.mSeekBar.setSecondaryProgress(10000);
        this.bBt = false;
        if (this.ap >= this.mFileSize) {}
      }
      for (this.LD = true;; this.LD = true)
      {
        if (this.LD)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, need download, startDownload...");
          }
          if (aU(this.mContext))
          {
            localObject = anfr.a(this.app, this.l, 1);
            if (localObject != null)
            {
              anfr.a((angi)localObject, this.app);
              this.mFileType = ((angi)localObject).b.fileType;
              k(this.l);
            }
          }
          localObject = wla.a(this.app);
          if (localObject != null) {
            ((wla)localObject).a(this.mRoot, this);
          }
          this.mFileSize = this.l.videoFileSize;
          this.cmT = ((int)(10000L * this.ap / this.mFileSize));
          this.cmS = 0;
          this.MU = 0L;
          this.bBt = true;
          this.mSeekBar.setSecondaryProgress(this.cmT);
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView() mCacheProgress=" + this.cmT + ",mTransferredSize=" + this.ap);
          }
        }
        if (this.cmQ != 5) {
          break;
        }
        this.sf.setVisibility(8);
        break;
        i = 102;
        break label520;
        label951:
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
        }
      }
      label975:
      bSZ();
      GR(4);
      return;
    }
    catch (Exception localException)
    {
      break label297;
    }
  }
  
  private void cAw()
  {
    if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.awK()) && (this.mRoot != null)) {
      this.mRoot.setSystemUiVisibility(1284);
    }
  }
  
  private void cAx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startDownLoadVideoForPubAccount: " + this.beM);
    }
    Object localObject = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label113;
      }
      i = 1;
      label74:
      if (i != 0) {
        break label118;
      }
      QQToast.a(this.mContext, 1, 2131719242, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
    }
    label113:
    label118:
    anfu localanfu;
    do
    {
      return;
      i = 0;
      break;
      i = 0;
      break label74;
      localObject = anfr.a(2, 0);
      localanfu = a();
      if ((!AppNetConnInfo.isWifiConn()) && (localanfu != null) && (localanfu.size > 204800L)) {
        d(aqha.a(this, 230, getString(2131720254), getString(2131720255), new aazk(this), new aazl(this)));
      }
    } while (localanfu == null);
    localanfu.cFo = true;
    ((angi)localObject).b = localanfu;
    anfr.a((angi)localObject, this.app);
    this.beP = localanfu.localPath;
  }
  
  private void cAy()
  {
    if (this.iW != null) {
      this.iW.setVisibility(8);
    }
    this.ic.setVisibility(0);
  }
  
  private void d(Dialog paramDialog)
  {
    if ((BaseActivity.mAppForground) && (!isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog) {}
  }
  
  private void gr()
  {
    if (this.cmQ != 3) {
      return;
    }
    this.c = new aazv(this, this, new aazu(this), bp(), 5, this.app);
  }
  
  private void gv()
  {
    avja.a(this.mContext, this.app.getCurrentUin(), this.bS, this.yF);
  }
  
  private void hK()
  {
    String str = getVideoPath();
    if (!ja(str))
    {
      QQToast.a(this.mContext, 0, 2131720229, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if (this.mHandler.get() != null) {
      ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(str, (MqqHandler)this.mHandler.get(), this.mMd5 + ".mp4", false));
    }
    if (this.mUinType == 0)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "1", "", "");
      this.bBq = true;
    }
    for (;;)
    {
      new alyr(BaseApplication.getContext()).a(this.app, 2002, this.cmR, this.beO);
      if (!this.biF) {
        break;
      }
      ajlg.report("0X8009ABD");
      return;
      if (this.mUinType == 3000)
      {
        anot.a(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "2", "", "");
        this.bBq = true;
      }
      else if (this.mUinType == 1)
      {
        anot.a(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "3", "", "");
        this.bBq = true;
      }
      else
      {
        anot.a(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "4", "", "");
        this.bBq = true;
      }
    }
  }
  
  private void iB()
  {
    String str = getVideoPath();
    if (!ja(str))
    {
      QQToast.a(this.mContext, 0, 2131720229, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse("file://" + str), "video/*");
    startActivity(localIntent);
    if (this.mUinType == 0)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      this.bBq = true;
      return;
    }
    if (this.mUinType == 3000)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      this.bBq = true;
      return;
    }
    if (this.mUinType == 1)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      this.bBq = true;
      return;
    }
    anot.a(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
    this.bBq = true;
  }
  
  private String ip(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(acbn.SDCARD_PATH);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("publicaccount");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.mCurrentUin);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".");
    localStringBuilder.append("mp4");
    return localStringBuilder.toString();
  }
  
  private void removeAllListener()
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.fa.get();
    if (localISuperPlayer != null)
    {
      localISuperPlayer.setOnCompletionListener(this);
      localISuperPlayer.setOnErrorListener(this);
      localISuperPlayer.setOnVideoPreparedListener(this);
      localISuperPlayer.setOnSeekCompleteListener(this);
      localISuperPlayer.setOnInfoListener(this);
    }
  }
  
  private void yZ()
  {
    avpw.d locald = avpw.d.a();
    avpw.c(getActivity(), locald, this.mVideoPath, 10001);
    anot.a(this.app, "dc00898", "", "", "0X800753A", "0X800753A", 0, 0, "", "", "", "");
  }
  
  public void Bi(String paramString)
  {
    if (this.mHandler.get() != null) {
      ((MqqHandler)this.mHandler.get()).post(new ShortVideoPlayActivity.11(this, paramString));
    }
  }
  
  void GR(int paramInt)
  {
    runOnUiThread(new ShortVideoPlayActivity.16(this, paramInt));
  }
  
  void GS(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (paramInt == this.mPlayState);
          if (isFinishing())
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ShortVideoPlayActivity", 2, "changePlayState, while finishing");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "changePlayState, " + bA(this.mPlayState) + " ==> " + bA(paramInt));
          }
          if ((this.mPlayState == 1) && (paramInt != 1)) {
            if (this.MW != 0L) {
              this.MV += System.currentTimeMillis() - this.MW;
            }
          }
          for (;;)
          {
            this.mPlayState = paramInt;
            switch (paramInt)
            {
            default: 
              return;
            case 0: 
              if (this.mHandler.get() != null) {
                ((MqqHandler)this.mHandler.get()).removeCallbacks(this.eu);
              }
              this.wP.setImageResource(2130846636);
              this.wP.setContentDescription(acfp.m(2131714515));
              return;
              if ((this.mPlayState == 4) && (paramInt != 4) && (this.Nc != 0L)) {
                this.Nb += System.currentTimeMillis() - this.Nc;
              }
              break;
            }
          }
          this.MW = System.currentTimeMillis();
          this.cmZ += 1;
          this.wP.setImageResource(2130846638);
          this.wP.setContentDescription(acfp.m(2131714495));
          this.aE.setVisibility(8);
          if (this.mHandler.get() != null)
          {
            ((MqqHandler)this.mHandler.get()).removeCallbacks(this.eu);
            ((MqqHandler)this.mHandler.get()).postDelayed(this.eu, 50L);
          }
          cAA();
          bSZ();
          cAD();
        } while (this.iZ == null);
        this.iZ.setVisibility(8);
        return;
        this.cna += 1;
        this.wP.setImageResource(2130846636);
        this.wP.setContentDescription(acfp.m(2131714497));
        return;
        this.Nc = System.currentTimeMillis();
        this.cnc += 1;
        if (this.LD) {
          this.iZ.setVisibility(0);
        }
      } while (this.mHandler.get() == null);
      ((MqqHandler)this.mHandler.get()).removeCallbacks(this.eu);
      ((MqqHandler)this.mHandler.get()).postDelayed(this.eu, 50L);
      return;
      this.wP.setImageResource(2130846636);
      this.wP.setContentDescription(acfp.m(2131714488));
    } while (this.mHandler.get() == null);
    ((MqqHandler)this.mHandler.get()).removeCallbacks(this.eu);
  }
  
  protected void Qq()
  {
    int i = 0;
    String str2 = getResources().getString(2131720281);
    String str3 = getResources().getString(2131720282);
    String str4 = getResources().getString(2131720239);
    String str5 = getResources().getString(2131720259);
    String str6 = getResources().getString(2131721058);
    String str1;
    boolean bool1;
    ausj localausj;
    if (this.cmQ == 0)
    {
      str1 = ShortVideoUtils.a(this.l, "mp4");
      bool1 = aqhq.fileExists(str1);
      if (this.LD) {
        bool1 = false;
      }
      boolean bool2 = "1".equals(DeviceProfileManager.a().aJ(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"));
      if (getIntent().getIntExtra("from_busi_type", 0) == 2) {
        i = 1;
      }
      localausj = ausj.b(this);
      if ((bool2) && (this.mUinType != 9501) && (i == 0)) {
        localausj.addButton(str2);
      }
      if (((this.l == null) || (this.l.videoFileStatus == 5001)) || (this.cmQ != 3))
      {
        if (!bool1) {
          break label262;
        }
        localausj.addButton(str4);
        localausj.addButton(str5);
      }
    }
    for (;;)
    {
      localausj.addCancelButton(str6);
      localausj.show();
      localausj.a(new aazo(this, localausj, str2, str1, str3, bool1, str4, str1, str5));
      return;
      str1 = this.mVideoPath;
      break;
      label262:
      localausj.addButton(str4, 7);
      localausj.addButton(str5, 7);
    }
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (((this.l == null) || (this.l.uniseq != paramaoko.uniseq)) && (this.cmQ != 2)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2);
        }
        if ((QLog.isColorLevel()) && (this.l != null)) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage msg.uniseq:" + this.l.uniseq + ",fileType:" + ShortVideoUtils.fe(paramaoko.fileType) + " ===> fileStatus:" + ShortVideoUtils.ff(paramaoko.status));
        }
      } while ((paramaoko.fileType != 6) && (paramaoko.fileType != 17) && (paramaoko.fileType != 9) && (paramaoko.fileType != 20));
      switch (paramaoko.status)
      {
      case 2004: 
      default: 
        return;
      case 1002: 
        X(paramaoko.transferedSize, paramaoko.fileSize);
        return;
      case 2003: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage STATUS_RECV_FINISHED");
        }
        this.cmT = 10000;
        return;
      case 2005: 
        QQToast.a(this.mContext, 2131720272, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        this.mErrCode = paramaoko.errorCode;
        return;
      case 5001: 
        QQToast.a(this.mContext, 2131720270, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        this.mErrCode = paramaoko.errorCode;
        return;
      case 5002: 
        QQToast.a(this.mContext, 2131720271, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
        this.mErrCode = paramaoko.errorCode;
        return;
      case 2002: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "STATUS_RECV_PROCESS: get url finished");
        }
        this.cmU = ((int)(System.currentTimeMillis() - this.mStartPlayTime));
      }
    } while (paramaoko.urls == null);
    this.cJ = paramaoko.urls;
    this.mDomain = paramaoko.domain;
    this.Ng = paramaoko.apK;
    paramInt1 = i;
    while (paramInt1 < 1)
    {
      if (!aqmr.isEmpty(this.mDomain))
      {
        paramView = new StringBuilder();
        paramaoko = this.cJ;
        paramaoko[paramInt1] = (paramaoko[paramInt1] + "&txhost=" + this.mDomain);
      }
      paramInt1 += 1;
    }
    play(0L);
    return;
    cAy();
  }
  
  void a(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onCompletion(), mPlayProgress=" + this.cmS + ", mCacheProgress=" + this.cmT + ", mCurPlayPosition" + this.MU + ", mDuration=" + this.mDuration);
    }
    this.cmS = 10000;
    if (!this.bBA) {
      this.Nh = this.mDuration;
    }
    this.mSeekBar.setProgress(10000);
    if ((this.cmQ == 2) && (this.mPlayState == 1)) {
      i(this.beL, 2, 1002, this.msg_id);
    }
    GR(0);
    this.mProgressTime.setText(this.mTotalTime.getText());
    cAz();
    this.fB = 0L;
    this.mCompleted = true;
    if (this.mStartPlayTime >= 0L)
    {
      this.Ju += System.currentTimeMillis() - this.mStartPlayTime;
      if (!this.bBs)
      {
        new alyr(BaseApplication.getContext()).a(this.app, 2002, (int)(this.mDuration / 1000L), this.cmR, this.beO, this.Ju / 1000L);
        this.bBs = true;
      }
    }
    crw();
  }
  
  public void a(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.cne = paramInt1;
    this.cnf = paramInt2;
    crw();
    Do(false);
    this.mStatus = 2005;
    GR(3);
    reset();
    gj(paramInt1, paramInt2);
  }
  
  void azR()
  {
    if ((this.fa != null) && (this.fa.get() != null))
    {
      ((ISuperPlayer)this.fa.get()).stop();
      ((ISuperPlayer)this.fa.get()).release();
      removeAllListener();
      this.fa = null;
    }
    GR(0);
  }
  
  public Intent b()
  {
    Object localObject = getVideoPath();
    Bundle localBundle = c(this).getExtras();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_need_sendmsg", true);
    localBundle.putString("forward_thumb", ShortVideoUtils.bw(this.aIf, "jpg"));
    localBundle.putString("file_send_path", (String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtras(localBundle);
    return localObject;
  }
  
  String bA(int paramInt)
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
    case 3: 
      return " error ";
    }
    return " buffering ";
  }
  
  void bSZ()
  {
    if ((this.OT != null) && (this.OT.getVisibility() == 0)) {
      this.OT.setVisibility(8);
    }
  }
  
  void cAA()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "delayStartHiding");
    }
    if (this.mHandler.get() != null)
    {
      ((MqqHandler)this.mHandler.get()).removeCallbacks(this.fn);
      if ((this.mPlayState == 1) && (this.fa != null) && (this.fa.get() != null) && (((ISuperPlayer)this.fa.get()).isPlaying())) {
        ((MqqHandler)this.mHandler.get()).postDelayed(this.fn, 2500L);
      }
    }
  }
  
  void cAB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startHiding : mHidden = " + this.mHidden + ",playState:" + bA(this.mPlayState));
    }
    if (this.mHidden) {}
    do
    {
      do
      {
        return;
      } while (this.mPlayState != 1);
      this.mHidden = true;
    } while (((this.Ao.getVisibility() != 0) && (this.dR.getVisibility() != 0)) || (Build.VERSION.SDK_INT < 11));
    this.d.cancel();
    this.d.start();
  }
  
  void cAC()
  {
    if ((this.fa == null) || (this.fa.get() == null)) {}
    do
    {
      long l1;
      do
      {
        return;
        l1 = ((ISuperPlayer)this.fa.get()).getDurationMs();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "initDuration: duration=" + l1);
        }
      } while (l1 == 0L);
      this.mDuration = ((int)l1);
      this.beN = ShortVideoUtils.stringForTime(this.mDuration);
    } while ((this.mTotalTime == null) || (this.mTotalTime.getText().equals(this.beN)));
    runOnUiThread(new ShortVideoPlayActivity.15(this));
  }
  
  void cAD()
  {
    if ((this.aE != null) && (this.aE.getVisibility() == 0)) {
      this.aE.setVisibility(8);
    }
  }
  
  public void cAE()
  {
    d(aqha.a(this, 232, null, getString(2131720262), new aazs(this), new aazt(this)));
  }
  
  void cAt()
  {
    try
    {
      this.mVideoView = SuperPlayerFactory.createPlayerVideoView(getApplicationContext());
      ((View)this.mVideoView).setBackgroundColor(-16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      ((View)this.mVideoView).setLayoutParams(localLayoutParams);
      ((View)this.mVideoView).setVisibility(0);
      this.mVideoView.addViewCallBack(this);
      if (this.originRect != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(13);
        ((View)this.mVideoView).setLayoutParams(localLayoutParams);
        this.a.addView((View)this.mVideoView);
        this.iX.addView(this.a, 0);
      }
      for (;;)
      {
        cAv();
        return;
        this.iX.addView((View)this.mVideoView, 0);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void cAu()
  {
    this.iY = ((RelativeLayout)getLayoutInflater().inflate(2131561699, null, false));
    this.mRoot = ((RelativeLayout)this.iY.findViewById(2131377546));
    this.ic = ((LinearLayout)this.iY.findViewById(2131372454));
    cAw();
    this.Ao = this.iY.findViewById(2131372727);
    this.Ao.setOnClickListener(this);
    this.aE = ((URLImageView)this.iY.findViewById(2131365478));
    this.OT = ((TextView)this.iY.findViewById(2131370790));
    this.sf = ((ImageView)this.iY.findViewById(2131371273));
    this.sf.setOnClickListener(this);
    this.mProgressTime = ((TextView)this.iY.findViewById(2131373666));
    this.mTotalTime = ((TextView)this.iY.findViewById(2131380108));
    this.mSeekBar = ((SeekBar)this.iY.findViewById(2131377914));
    this.mSeekBar.setMax(10000);
    this.wP = ((ImageView)this.iY.findViewById(2131372728));
    this.wP.setOnClickListener(this);
    this.mSeekBar.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
    this.iZ = ((RelativeLayout)this.iY.findViewById(2131364065));
    this.mRateText = ((TextView)this.iY.findViewById(2131376618));
    if (((this.cmQ == 0) || (this.cmQ == 5)) && (this.l != null) && ((this.l.videoFileStatus == 1001) || (this.l.videoFileStatus == 1002)) && (this.app.a().a(this.l.frienduin, this.l.uniseq) != null))
    {
      this.mIsUploading = true;
      this.iW = ((RelativeLayout)this.iY.findViewById(2131381314));
      this.iW.setVisibility(0);
      this.ic.setVisibility(4);
      this.o = ((SeekBar)this.iY.findViewById(2131381316));
      this.o.setMax(100);
      this.mCloseBtn = ((ImageView)this.iY.findViewById(2131364678));
      this.mCloseBtn.setOnClickListener(this);
      this.OR = ((TextView)this.iY.findViewById(2131381315));
    }
    this.a = new DragView(this);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a.setGestureChangeListener(this);
    if (ayxa.isLiuHaiUseValid()) {}
    for (int i = ayxa.sNotchHeight;; i = 0)
    {
      if (this.originRect != null)
      {
        localObject = this.originRect;
        ((Rect)localObject).top -= i;
        localObject = this.originRect;
        ((Rect)localObject).bottom -= i;
      }
      this.a.setOriginRect(this.originRect);
      this.iX = ((RelativeLayout)findViewById(2131374975));
      this.iX.setOnClickListener(this);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.iY.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.iX.addView(this.iY);
      this.dR = ((RelativeLayout)this.iX.findViewById(2131370294));
      this.dR.setVisibility(0);
      this.dR.bringToFront();
      localObject = (RelativeLayout)this.iX.findViewById(2131370293);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getApplicationContext());
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      this.OS = ((TextView)this.iX.findViewById(2131363226));
      this.OS.setOnClickListener(this);
      gJ(0L);
      this.mTotalTime.setText(ShortVideoUtils.stringForTime(0L));
      showLoadingView();
      pQ();
      gr();
      return;
    }
  }
  
  void cAz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startShowing : mHidden = " + this.mHidden);
    }
    if (!this.mHidden) {
      return;
    }
    if (this.mHandler.get() != null) {
      ((MqqHandler)this.mHandler.get()).removeCallbacks(this.fn);
    }
    this.Ao.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.Ao.setAlpha(1.0F);
    }
    this.dR.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.dR.setAlpha(1.0F);
    }
    this.mHidden = false;
  }
  
  public void crw()
  {
    if (!this.bsQ) {}
    while (this.l == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    StringBuffer localStringBuffer = new StringBuffer();
    if (!this.LD)
    {
      i = 1;
      if (this.ceK == 0) {
        i = 3;
      }
      localHashMap.put("player_state", String.valueOf(i));
      localStringBuffer.append(" player_state " + i);
      localHashMap.put("Download", String.valueOf(this.bBv));
      localStringBuffer.append(" Download" + this.bBv);
      localHashMap.put("FileSize", String.valueOf(this.mFileSize));
      localStringBuffer.append(" FileSize" + this.mFileSize);
      localHashMap.put("HttpDownloadSum", String.valueOf(this.cmW));
      localStringBuffer.append(" HttpDownloadSum" + this.cmW);
      if (this.bBv) {
        break label1216;
      }
      localHashMap.put("DataFromCacheSize", String.valueOf(this.mFileSize));
      localStringBuffer.append(" DataFromCacheSize" + this.mFileSize);
      label277:
      localHashMap.put("FileDuration", String.valueOf(this.mDuration));
      localStringBuffer.append(" FileDuration" + this.mDuration);
      localHashMap.put("PlayTime", String.valueOf(this.MV));
      localStringBuffer.append(" PlayTime" + this.MV);
      localHashMap.put("PlayStateCount", String.valueOf(this.cmZ));
      localStringBuffer.append(" PlayStateCount" + this.cmZ);
      localHashMap.put("PlayProgress", String.valueOf(this.cmS / 100));
      localStringBuffer.append(" PlayProgress" + this.cmS / 100);
      localHashMap.put("FirstPlayTime", String.valueOf(this.MY));
      localStringBuffer.append(" FirstPlayTime" + this.MY);
      localHashMap.put("FirstBufferTime", String.valueOf(this.Na));
      localStringBuffer.append(" FirstBufferTime" + this.Na);
      localHashMap.put("SeekTimes", String.valueOf(this.ceJ));
      localStringBuffer.append(" SeekTimes" + this.ceJ);
      if (this.cnc != 0) {
        break label1264;
      }
      i = this.cnc;
      label610:
      localHashMap.put("BufferTimes", String.valueOf(i));
      localStringBuffer.append(" BufferTimes" + i);
      localHashMap.put("BufferCostTime", String.valueOf(this.Nb));
      localStringBuffer.append(" BufferCostTime" + this.Nb);
      if (this.Ne != 0L)
      {
        this.Nd = (System.currentTimeMillis() - this.Ne);
        this.Ne = 0L;
      }
      i = 0;
      if (this.cmX != 0) {
        i = this.cmW / (this.cmX * 1000);
      }
      localHashMap.put("SpeedKBS", String.valueOf(i));
      localStringBuffer.append(" SpeedKBS" + i);
      if (this.cnb <= 0) {
        break label1274;
      }
      str1 = "1";
      label794:
      localHashMap.put("IsRePlay", str1);
      localStringBuffer.append(" IsRePlay" + this.cnb);
      localHashMap.put("SuspendTimes", String.valueOf(this.cna));
      localStringBuffer.append(" SuspendTimes" + this.cna);
      if (this.mErrCode == 0) {
        break label1282;
      }
      localHashMap.put("param_FailCode", String.valueOf(this.mErrCode));
    }
    Object localObject;
    int k;
    label1282:
    for (boolean bool = false;; bool = true)
    {
      localHashMap.put("ErrorCode", String.valueOf(this.cne));
      localHashMap.put("ErrorDetailCode", String.valueOf(this.cnf));
      localHashMap.put("HttpStatus", String.valueOf(this.cnd));
      localStringBuffer.append(" HttpStatus" + this.cnd);
      localHashMap.put("User-ReturnCode", this.beQ);
      localStringBuffer.append(" User-ReturnCode" + this.beQ);
      localHashMap.put("X-RtFlag", this.beR);
      localStringBuffer.append(" X-RtFlag" + this.beR);
      int j = -1;
      localObject = new StringBuffer("");
      str1 = null;
      if (!aqmr.isEmpty(this.beS)) {
        str1 = aopd.getHostFromUrl(this.beS);
      }
      k = j;
      if (this.cJ == null) {
        break label1288;
      }
      k = j;
      if (this.cJ.length <= 0) {
        break label1288;
      }
      i = 0;
      for (;;)
      {
        k = j;
        if (i >= this.cJ.length) {
          break;
        }
        String str2 = aopd.getHostFromUrl(this.cJ[i]);
        ((StringBuffer)localObject).append(str2 + ",");
        k = j;
        if (j == -1)
        {
          k = j;
          if (!aqmr.isEmpty(str1))
          {
            k = j;
            if (str1.equals(str2)) {
              k = i;
            }
          }
        }
        i += 1;
        j = k;
      }
      i = 2;
      break;
      label1216:
      localHashMap.put("DataFromCacheSize", String.valueOf(this.cmY));
      localStringBuffer.append(" DataFromCacheSize" + this.cmY);
      break label277;
      label1264:
      i = this.cnc - 1;
      break label610;
      label1274:
      str1 = "0";
      break label794;
    }
    label1288:
    localHashMap.put("IpList", ((StringBuffer)localObject).toString());
    int i = k + 1;
    localHashMap.put("SuccIpIndex", String.valueOf(i));
    localStringBuffer.append(" SuccIpIndex" + i);
    localHashMap.put("HttpDomain", this.mDomain);
    localStringBuffer.append(" HttpDomain" + this.mDomain);
    localHashMap.put("HttpRedirectNum", String.valueOf(this.cng));
    localStringBuffer.append(" HttpRedirectNum" + this.cng);
    localHashMap.put("HttpRedirectCostMs", String.valueOf(this.cnh));
    localStringBuffer.append(" HttpRedirectCostMs" + this.cnh);
    localHashMap.put("HttpDnsCostMs", String.valueOf(this.cni));
    localStringBuffer.append(" HttpDnsCostMs" + this.cni);
    localHashMap.put("HttpConnectCostMs", String.valueOf(this.cnj));
    localStringBuffer.append(" HttpConnectCostMs" + this.cnj);
    localHashMap.put("HttpFirstRecvCostMs", String.valueOf(this.cnk));
    localStringBuffer.append(" HttpFirstRecvCostMs" + this.cnk);
    localHashMap.put("RetrySuccessTimes", "0");
    localHashMap.put("RetryFailedTimes", "0");
    localHashMap.put("ApplyCostTime", String.valueOf(this.Ng));
    localStringBuffer.append(" ApplyCostTime" + this.Ng);
    localHashMap.put("HttpCostTime", String.valueOf(this.Nd));
    localStringBuffer.append(" HttpCostTime" + this.Nd);
    localHashMap.put("DownType", "1");
    localHashMap.put("SceneType", "2");
    localHashMap.put("BusiType", String.valueOf(this.cmQ));
    localHashMap.put("SubBusiType", String.valueOf(this.l.subBusiType));
    localHashMap.put("FromUin", String.valueOf(this.mCurrentUin));
    localHashMap.put("GrpUin", String.valueOf(this.beO));
    localHashMap.put("Uuid", String.valueOf(this.mUuid));
    localHashMap.put("MsgFileMd5", String.valueOf(this.mMd5));
    localHashMap.put("DownFileMd5", String.valueOf(this.mMd5));
    String str1 = String.valueOf(aqiw.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext()));
    localHashMap.put("NetworkInfo", str1);
    localStringBuffer.append(" NetworkInfo" + str1);
    localHashMap.put("ProductVersion", String.valueOf(this.app.getAppid()));
    localHashMap.put("EncryptKey", "0");
    if (this.bBw)
    {
      str1 = "1";
      localHashMap.put("IsUpdateSuit", str1);
      localObject = new StringBuilder().append(" IsUpdateSuit");
      if (!this.bBw) {
        break label2269;
      }
      str1 = "1";
      label1998:
      localStringBuffer.append(str1);
      localHashMap.put("UpdateSuitCostTime", String.valueOf(this.Nf));
      localStringBuffer.append(" UpdateSuitCostTime" + this.Nf);
      if (!this.bBx) {
        break label2277;
      }
      str1 = "1";
      label2071:
      localHashMap.put("UpdateSuitResult", str1);
      localObject = new StringBuilder().append(" UpdateSuitResult");
      if (!this.bBx) {
        break label2285;
      }
    }
    label2269:
    label2277:
    label2285:
    for (str1 = "1";; str1 = "0")
    {
      localStringBuffer.append(str1);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoPlayActivity", 2, localStringBuffer.toString());
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actStreamingVideoPlay", bool, this.Nd, this.mFileSize, localHashMap, "");
      this.bsQ = false;
      this.cmZ = 0;
      this.ceJ = 0;
      this.cnc = 0;
      this.cna = 0;
      this.Nb = 0L;
      this.Nd = 0L;
      this.MV = 0L;
      this.cnj = 0;
      this.cni = 0;
      this.MY = 0L;
      this.Na = 0L;
      this.Ng = 0L;
      this.cnk = 0;
      this.cnh = 0;
      this.Nf = 0L;
      this.cne = 0;
      this.cnf = 0;
      return;
      str1 = "0";
      break;
      str1 = "0";
      break label1998;
      str1 = "0";
      break label2071;
    }
  }
  
  public void cwl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "userBackPressed");
    }
    azR();
    setResult(-1, getIntent());
    finish();
    try
    {
      overridePendingTransition(2130772077, 2130772079);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] overridePendingTransition=" + localException);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10001) {
      switch (paramInt2)
      {
      }
    }
    while (paramInt1 != 21)
    {
      return;
      QQToast.a(this, 2131720247, 0).show();
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    }
    ForwardUtils.a((QQAppInterface)getAppRuntime(), this, getApplicationContext(), paramIntent, null);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    azR();
    overridePendingTransition(0, 2130772440);
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 1990	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:mActNeedImmersive	Z
    //   5: aload_0
    //   6: invokestatic 1994	ayxa:initLiuHaiProperty	(Landroid/app/Activity;)V
    //   9: invokestatic 1633	ayxa:isLiuHaiUseValid	()Z
    //   12: ifeq +8 -> 20
    //   15: aload_0
    //   16: invokestatic 1998	ayxa:enableNotch	(Landroid/app/Activity;)Z
    //   19: pop
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 2000	com/tencent/mobileqq/app/BaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   25: pop
    //   26: aload_0
    //   27: ldc_w 2001
    //   30: invokespecial 2004	com/tencent/mobileqq/app/BaseActivity:setContentView	(I)V
    //   33: aload_0
    //   34: invokevirtual 2008	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:getWindow	()Landroid/view/Window;
    //   37: sipush 128
    //   40: invokevirtual 2013	android/view/Window:addFlags	(I)V
    //   43: aload_0
    //   44: aload_0
    //   45: invokevirtual 1228	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:getResources	()Landroid/content/res/Resources;
    //   48: invokevirtual 2017	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   51: getfield 2022	android/util/DisplayMetrics:widthPixels	I
    //   54: putfield 2024	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:cnl	I
    //   57: aload_0
    //   58: aload_0
    //   59: invokevirtual 1228	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:getResources	()Landroid/content/res/Resources;
    //   62: invokevirtual 2017	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   65: getfield 2027	android/util/DisplayMetrics:heightPixels	I
    //   68: putfield 2029	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:cnm	I
    //   71: aload_0
    //   72: aload_0
    //   73: ldc_w 2030
    //   76: invokevirtual 1650	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   79: checkcast 969	android/widget/LinearLayout
    //   82: putfield 2032	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:top_blackLH	Landroid/widget/LinearLayout;
    //   85: aload_0
    //   86: getfield 2032	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:top_blackLH	Landroid/widget/LinearLayout;
    //   89: ifnull +34 -> 123
    //   92: aload_0
    //   93: getfield 2032	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:top_blackLH	Landroid/widget/LinearLayout;
    //   96: invokevirtual 2033	android/widget/LinearLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   99: astore_2
    //   100: aload_2
    //   101: getstatic 1636	ayxa:sNotchHeight	I
    //   104: putfield 2038	android/view/ViewGroup$LayoutParams:height	I
    //   107: aload_0
    //   108: getfield 2032	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:top_blackLH	Landroid/widget/LinearLayout;
    //   111: aload_2
    //   112: invokevirtual 2039	android/widget/LinearLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   115: aload_0
    //   116: getfield 2032	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:top_blackLH	Landroid/widget/LinearLayout;
    //   119: iconst_0
    //   120: invokevirtual 970	android/widget/LinearLayout:setVisibility	(I)V
    //   123: invokestatic 362	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +285 -> 411
    //   129: new 366	java/lang/StringBuilder
    //   132: dup
    //   133: ldc_w 2041
    //   136: invokespecial 1100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: astore_2
    //   140: aload_2
    //   141: ldc_w 2043
    //   144: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: getstatic 2048	android/os/Build:PRODUCT	Ljava/lang/String;
    //   150: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 2050
    //   156: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_2
    //   161: ldc_w 2052
    //   164: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: getstatic 2055	android/os/Build:MODEL	Ljava/lang/String;
    //   170: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 2050
    //   176: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_2
    //   181: ldc_w 2057
    //   184: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: getstatic 2060	android/os/Build:BOARD	Ljava/lang/String;
    //   190: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 2050
    //   196: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_2
    //   201: ldc_w 2062
    //   204: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: getstatic 2065	android/os/Build:BOOTLOADER	Ljava/lang/String;
    //   210: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 2050
    //   216: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_2
    //   221: ldc_w 2067
    //   224: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: getstatic 2070	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   230: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 2050
    //   236: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_2
    //   241: ldc_w 2072
    //   244: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: getstatic 2075	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   250: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc_w 2050
    //   256: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_2
    //   261: ldc_w 2077
    //   264: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: getstatic 2080	android/os/Build:DEVICE	Ljava/lang/String;
    //   270: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 2050
    //   276: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_2
    //   281: ldc_w 2082
    //   284: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 2085	android/os/Build:DISPLAY	Ljava/lang/String;
    //   290: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 2050
    //   296: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_2
    //   301: ldc_w 2087
    //   304: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: getstatic 2090	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   310: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc_w 2050
    //   316: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_2
    //   321: ldc_w 2092
    //   324: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: getstatic 2095	android/os/Build:HARDWARE	Ljava/lang/String;
    //   330: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc_w 2050
    //   336: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_2
    //   341: ldc_w 2097
    //   344: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: getstatic 2100	android/os/Build:ID	Ljava/lang/String;
    //   350: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc_w 2050
    //   356: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload_2
    //   361: ldc_w 2102
    //   364: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: getstatic 2105	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   370: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc_w 2050
    //   376: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_2
    //   381: ldc_w 2107
    //   384: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: getstatic 287	android/os/Build$VERSION:SDK_INT	I
    //   390: invokevirtual 405	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: ldc_w 2050
    //   396: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: ldc_w 364
    //   403: iconst_2
    //   404: aload_2
    //   405: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 2109	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload_1
    //   412: ifnull +51 -> 463
    //   415: aload_0
    //   416: aload_1
    //   417: ldc_w 2111
    //   420: invokevirtual 2112	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   423: i2l
    //   424: putfield 808	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:fB	J
    //   427: invokestatic 362	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq +33 -> 463
    //   433: ldc_w 364
    //   436: iconst_2
    //   437: new 366	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 2114
    //   447: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_0
    //   451: getfield 808	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:fB	J
    //   454: invokevirtual 449	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   457: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 380	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: aload_0
    //   464: aload_0
    //   465: putfield 735	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:mContext	Landroid/content/Context;
    //   468: aload_0
    //   469: aload_0
    //   470: invokespecial 483	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   473: invokevirtual 1414	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   476: putfield 2116	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:mBundle	Landroid/os/Bundle;
    //   479: aload_0
    //   480: aload_0
    //   481: invokespecial 483	com/tencent/mobileqq/app/BaseActivity:getIntent	()Landroid/content/Intent;
    //   484: invokevirtual 2119	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:initData	(Landroid/content/Intent;)V
    //   487: aload_0
    //   488: getfield 2121	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:bBz	Z
    //   491: ifeq +200 -> 691
    //   494: aload_0
    //   495: ldc_w 2122
    //   498: invokevirtual 1650	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   501: checkcast 1205	com/tencent/image/URLImageView
    //   504: astore_1
    //   505: aload_0
    //   506: getfield 2124	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beT	Ljava/lang/String;
    //   509: ifnull +360 -> 869
    //   512: aload_0
    //   513: getfield 2124	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beT	Ljava/lang/String;
    //   516: invokevirtual 2126	java/lang/String:isEmpty	()Z
    //   519: ifne +350 -> 869
    //   522: aload_1
    //   523: iconst_0
    //   524: invokevirtual 1206	com/tencent/image/URLImageView:setVisibility	(I)V
    //   527: aload_1
    //   528: aload_0
    //   529: getfield 2124	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beT	Ljava/lang/String;
    //   532: invokestatic 2132	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   535: invokevirtual 2136	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   538: aload_0
    //   539: getfield 553	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beU	Ljava/lang/String;
    //   542: ifnull +30 -> 572
    //   545: aload_0
    //   546: getfield 553	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beU	Ljava/lang/String;
    //   549: invokevirtual 2126	java/lang/String:isEmpty	()Z
    //   552: ifne +20 -> 572
    //   555: aload_1
    //   556: iconst_1
    //   557: invokevirtual 2139	com/tencent/image/URLImageView:setClickable	(Z)V
    //   560: aload_1
    //   561: new 2141	aazz
    //   564: dup
    //   565: aload_0
    //   566: invokespecial 2142	aazz:<init>	(Lcom/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity;)V
    //   569: invokevirtual 2143	com/tencent/image/URLImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   572: aload_0
    //   573: ldc_w 2144
    //   576: invokevirtual 1650	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   579: checkcast 1205	com/tencent/image/URLImageView
    //   582: astore_1
    //   583: aload_0
    //   584: getfield 2146	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beV	Ljava/lang/String;
    //   587: ifnull +334 -> 921
    //   590: aload_0
    //   591: getfield 2146	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beV	Ljava/lang/String;
    //   594: invokevirtual 2126	java/lang/String:isEmpty	()Z
    //   597: ifne +324 -> 921
    //   600: aload_1
    //   601: iconst_0
    //   602: invokevirtual 1206	com/tencent/image/URLImageView:setVisibility	(I)V
    //   605: aload_1
    //   606: aload_0
    //   607: getfield 2146	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beV	Ljava/lang/String;
    //   610: invokestatic 2132	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   613: invokevirtual 2136	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   616: aload_0
    //   617: getfield 2148	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beW	Ljava/lang/String;
    //   620: ifnull +326 -> 946
    //   623: aload_0
    //   624: getfield 2148	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beW	Ljava/lang/String;
    //   627: invokevirtual 2126	java/lang/String:isEmpty	()Z
    //   630: ifne +316 -> 946
    //   633: aload_0
    //   634: ldc_w 2149
    //   637: invokevirtual 1650	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:findViewById	(I)Landroid/view/View;
    //   640: checkcast 458	android/widget/TextView
    //   643: astore_1
    //   644: aload_1
    //   645: iconst_0
    //   646: invokevirtual 1466	android/widget/TextView:setVisibility	(I)V
    //   649: aload_1
    //   650: aload_0
    //   651: getfield 2148	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beW	Ljava/lang/String;
    //   654: invokevirtual 462	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   657: aload_0
    //   658: getfield 553	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beU	Ljava/lang/String;
    //   661: ifnull +30 -> 691
    //   664: aload_0
    //   665: getfield 553	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:beU	Ljava/lang/String;
    //   668: invokevirtual 2126	java/lang/String:isEmpty	()Z
    //   671: ifne +20 -> 691
    //   674: aload_1
    //   675: iconst_1
    //   676: invokevirtual 2150	android/widget/TextView:setClickable	(Z)V
    //   679: aload_1
    //   680: new 2152	abaa
    //   683: dup
    //   684: aload_0
    //   685: invokespecial 2153	abaa:<init>	(Lcom/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity;)V
    //   688: invokevirtual 1675	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   691: aload_0
    //   692: invokevirtual 2155	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:cAu	()V
    //   695: aload_0
    //   696: invokevirtual 2158	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:initSDK	()V
    //   699: new 2160	android/content/IntentFilter
    //   702: dup
    //   703: invokespecial 2161	android/content/IntentFilter:<init>	()V
    //   706: astore_1
    //   707: aload_1
    //   708: ldc_w 2163
    //   711: invokevirtual 2166	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   714: aload_1
    //   715: ldc_w 2168
    //   718: invokevirtual 2166	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   721: aload_0
    //   722: aload_0
    //   723: getfield 336	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:mReceiver	Landroid/content/BroadcastReceiver;
    //   726: aload_1
    //   727: invokevirtual 2172	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   730: pop
    //   731: aload_0
    //   732: getfield 694	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   735: ldc 2
    //   737: aload_0
    //   738: getfield 319	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:mHandler	Ljava/lang/ref/WeakReference;
    //   741: invokevirtual 1028	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   744: checkcast 873	mqq/os/MqqHandler
    //   747: invokevirtual 2176	com/tencent/mobileqq/app/QQAppInterface:setHandler	(Ljava/lang/Class;Lmqq/os/MqqHandler;)V
    //   750: aload_0
    //   751: invokestatic 726	java/lang/System:currentTimeMillis	()J
    //   754: putfield 252	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:mStartPlayTime	J
    //   757: aload_0
    //   758: getfield 694	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   761: ldc_w 1150
    //   764: ldc 234
    //   766: ldc 234
    //   768: ldc_w 2178
    //   771: ldc_w 2178
    //   774: iconst_0
    //   775: iconst_0
    //   776: ldc 234
    //   778: ldc 234
    //   780: ldc 234
    //   782: ldc 234
    //   784: invokestatic 1046	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   787: aload_0
    //   788: getfield 694	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   791: ldc_w 1150
    //   794: ldc 234
    //   796: ldc 234
    //   798: ldc_w 2180
    //   801: ldc_w 2180
    //   804: iconst_0
    //   805: iconst_0
    //   806: ldc 234
    //   808: ldc 234
    //   810: ldc 234
    //   812: ldc 234
    //   814: invokestatic 1046	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   817: aload_0
    //   818: getfield 1486	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:dR	Landroid/widget/RelativeLayout;
    //   821: ifnull +19 -> 840
    //   824: aload_0
    //   825: getfield 2182	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:bBp	Z
    //   828: ifeq +12 -> 840
    //   831: aload_0
    //   832: getfield 1486	com/tencent/mobileqq/activity/shortvideo/ShortVideoPlayActivity:dR	Landroid/widget/RelativeLayout;
    //   835: bipush 8
    //   837: invokevirtual 965	android/widget/RelativeLayout:setVisibility	(I)V
    //   840: iconst_1
    //   841: ireturn
    //   842: astore_2
    //   843: invokestatic 362	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   846: ifeq +14 -> 860
    //   849: ldc_w 364
    //   852: iconst_2
    //   853: ldc_w 2184
    //   856: aload_2
    //   857: invokestatic 2187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   860: aload_1
    //   861: bipush 8
    //   863: invokevirtual 1206	com/tencent/image/URLImageView:setVisibility	(I)V
    //   866: goto -328 -> 538
    //   869: aload_1
    //   870: bipush 8
    //   872: invokevirtual 1206	com/tencent/image/URLImageView:setVisibility	(I)V
    //   875: invokestatic 362	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   878: ifeq -306 -> 572
    //   881: ldc_w 364
    //   884: iconst_2
    //   885: ldc_w 2189
    //   888: invokestatic 380	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: goto -319 -> 572
    //   894: astore_2
    //   895: aload_1
    //   896: bipush 8
    //   898: invokevirtual 1206	com/tencent/image/URLImageView:setVisibility	(I)V
    //   901: invokestatic 362	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   904: ifeq -288 -> 616
    //   907: ldc_w 364
    //   910: iconst_2
    //   911: ldc_w 2191
    //   914: aload_2
    //   915: invokestatic 2187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   918: goto -302 -> 616
    //   921: aload_1
    //   922: bipush 8
    //   924: invokevirtual 1206	com/tencent/image/URLImageView:setVisibility	(I)V
    //   927: invokestatic 362	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq -314 -> 616
    //   933: ldc_w 364
    //   936: iconst_2
    //   937: ldc_w 2193
    //   940: invokestatic 380	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   943: goto -327 -> 616
    //   946: invokestatic 362	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   949: ifeq -258 -> 691
    //   952: ldc_w 364
    //   955: iconst_2
    //   956: ldc_w 2195
    //   959: invokestatic 380	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   962: goto -271 -> 691
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	965	0	this	ShortVideoPlayActivity
    //   0	965	1	paramBundle	Bundle
    //   99	306	2	localObject	Object
    //   842	15	2	localException1	Exception
    //   894	21	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   522	538	842	java/lang/Exception
    //   600	616	894	java/lang/Exception
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnDestroy");
    }
    if ((this.fa != null) && (this.fa.get() != null) && (((ISuperPlayer)this.fa.get()).isPlaying())) {
      this.fB = ((ISuperPlayer)this.fa.get()).getCurrentPositionMs();
    }
    azR();
    if (this.iX != null) {
      this.iX.removeView((View)this.mVideoView);
    }
    if (this.mVideoView != null)
    {
      this.mVideoView.removeViewCallBack(this);
      this.mVideoView = null;
    }
    try
    {
      unregisterReceiver(this.mReceiver);
      label129:
      this.app.removeHandler(ShortVideoPlayActivity.class);
      if (this.mStartPlayTime >= 0L)
      {
        this.Ju += System.currentTimeMillis() - this.mStartPlayTime;
        if (!this.bBs)
        {
          new alyr(BaseApplication.getContext()).a(this.app, 2002, (int)(this.mDuration / 1000L), this.cmR, this.beO, this.Ju / 1000L);
          this.bBs = true;
        }
      }
      if (this.bBt) {
        new alyr(BaseApplication.getContext()).a(true, this.cmU, this.cmS / 100, this.cmT / 100, (int)this.mDuration, (int)this.mFileSize, 0, this.cmV, this.ceK, this.Ju);
      }
      if (!this.mIsUploading)
      {
        crw();
        Do(true);
        cAF();
      }
      if ((this.l != null) && (this.l.uiOperatorFlag == 2) && (this.l.videoFileProgress != 100))
      {
        this.l.videoFileStatus = 2009;
        this.l.serial();
        this.app.b().c(this.l.frienduin, this.mUinType, this.l.uniseq, this.l.msgData);
      }
      if (this.mHandler.get() != null) {
        ((MqqHandler)this.mHandler.get()).removeCallbacksAndMessages(null);
      }
      if (this.a != null)
      {
        this.a.removeAllViews();
        this.a = null;
      }
      QQAppInterface localQQAppInterface = this.app;
      int i = this.cmR;
      if (this.l != null) {}
      for (String str = this.l.frienduin;; str = "")
      {
        ShortVideoUtils.a(localQQAppInterface, i, str, 2, 1, this.mDuration, this.Nh);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label129;
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    } while (this.Ao.getVisibility() != 0);
    if ((this.mUinType != 9501) || (this.cmQ == 5)) {
      Qq();
    }
    return true;
  }
  
  public void doOnPause()
  {
    if (!this.mCompleted) {
      this.mInterrupted = true;
    }
    if ((this.fa != null) && (this.fa.get() != null) && (((ISuperPlayer)this.fa.get()).isPlaying()))
    {
      this.fB = ((ISuperPlayer)this.fa.get()).getCurrentPositionMs();
      this.bBu = true;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "pause mCurrentPosition:" + this.fB);
      }
    }
    for (;;)
    {
      pause();
      super.doOnPause();
      return;
      if (isBuffering()) {
        this.bBu = true;
      }
    }
  }
  
  @TargetApi(10)
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnResume: mInterrupted = " + this.mInterrupted + ", mNeedPlay = " + this.bBu + " mSurfaceViewDestroyed=" + this.bBy);
    }
    cAw();
    if ((this.mInterrupted) || (this.mCompleted))
    {
      if (!this.bBu) {
        break label142;
      }
      if ((this.fa != null) && (this.fa.get() != null) && (!((ISuperPlayer)this.fa.get()).isPlaying()) && (!resume())) {
        play(this.fB);
      }
    }
    label142:
    do
    {
      do
      {
        return;
      } while (Build.VERSION.SDK_INT < 10);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause, mCurrentPosition=" + this.fB);
      }
      if (this.bBy) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause mSurfaceViewDestroyed=" + this.bBy);
    return;
    if ((this.cmQ == 0) || (this.cmQ == 5)) {
      if ((TextUtils.isEmpty(this.mVideoPath)) || (!aqhq.fileExistsAndNotEmpty(this.mVideoPath))) {}
    }
    for (;;)
    {
      try
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(this.mVideoPath);
        this.cL = localMediaMetadataRetriever.getFrameAtTime(this.fB * 1000L);
        this.aE.setImageBitmap(this.cL);
        localMediaMetadataRetriever.release();
        this.aE.setVisibility(0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.aE.setImageDrawable(new ColorDrawable(0));
        continue;
      }
      if (this.cmQ == 1) {
        this.aE.setImageDrawable(new ColorDrawable(0));
      }
    }
  }
  
  public void doOnStart()
  {
    MediaPlayerManager.a(this.app).stop(true);
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    if (!this.mCompleted) {
      this.mInterrupted = true;
    }
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.doOnStop();
  }
  
  public void gJ(long paramLong)
  {
    if (this.mProgressTime != null)
    {
      long l1 = paramLong;
      if (paramLong < 0L) {
        l1 = 0L;
      }
      this.mProgressTime.setText(ShortVideoUtils.stringForTime(l1));
    }
  }
  
  String getVideoPath()
  {
    if (this.cmQ == 0) {
      return ShortVideoUtils.a(this.l, "mp4");
    }
    return this.mVideoPath;
  }
  
  void gj(int paramInt1, int paramInt2)
  {
    this.ceK = 0;
    this.mErrCode = 9001;
    String str1 = getString(2131720261);
    if (this.cmQ == 1)
    {
      bSZ();
      cAD();
      str1 = getString(2131720258);
      d(aqha.a(this, 232, null, str1, new aazm(this), null));
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "handleError，mPlayCallerType = " + this.cmQ);
      }
      this.Ju = -1L;
      this.mStartPlayTime = -1L;
      return;
    }
    if (this.cmQ == 0)
    {
      if (this.bBr) {
        break label284;
      }
      paramInt2 = (int)(aqgz.getSystemAvaialbeMemory() / 1024L);
      if (aqmr.isEmpty(this.mVideoPath)) {
        break label287;
      }
    }
    label284:
    label287:
    for (paramInt1 = (int)(new File(this.mVideoPath).length() / 1024L);; paramInt1 = 0)
    {
      String str2 = aqgz.getDeviceModel();
      anot.a(this.app, "CliOper", "", "", "0X8004674", "0X8004674", 0, 0, "" + paramInt2, "" + paramInt1, str2, this.mMd5);
      this.bBr = true;
      break;
      if (this.cmQ == 2)
      {
        i(this.beL, 0, 1002, this.msg_id);
        str1 = getString(2131720258);
        break;
      }
      break;
    }
  }
  
  public void hG()
  {
    String str = acbn.bkw;
    Intent localIntent = b();
    localIntent.putExtra("toUin", str);
    localIntent.putExtra("uinType", 6000);
    localIntent.setClass(this.mContext, DirectForwardActivity.class);
    localIntent.putExtra("forward_filepath", getVideoPath());
    localIntent.putExtra("forward_extra", getVideoPath());
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    this.mContext.startActivity(localIntent);
  }
  
  public void hJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "click menu to forward shortVideo......");
    }
    Bundle localBundle = b(this).getExtras();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_need_sendmsg", true);
    localBundle.putString("forward_thumb", ShortVideoUtils.bw(this.aIf, "jpg"));
    localBundle.putString("file_send_path", getVideoPath());
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    ahgq.P(this, localIntent);
    g(this);
    if (this.biF) {
      ajlg.report("0X8009ABC");
    }
    anot.a(this.app, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "2", "", "");
  }
  
  void handleClick()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "handleClick: mPlayState = " + bA(this.mPlayState) + ", mCurrentPosition = " + this.fB);
    }
    switch (this.mPlayState)
    {
    case 4: 
    default: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        return;
        play(this.fB);
        return;
        pause();
        return;
        resume();
      } while ((this.fB == 0L) || (!this.bBy));
      play(this.fB);
      return;
    }
    play(0L);
  }
  
  public void i(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    String str;
    if (!TextUtils.isEmpty(paramString1)) {
      str = "0";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      paramString1 = str;
      if (localJSONObject.has("ad_id")) {
        paramString1 = localJSONObject.getString("ad_id");
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "parse ad_id error");
        }
        paramString1 = "0";
      }
    }
    anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, paramString1, paramString2, "", "");
  }
  
  void initData(Intent paramIntent)
  {
    if (paramIntent.getExtras() == null) {}
    do
    {
      return;
      this.mVideoPath = paramIntent.getExtras().getString("file_send_path");
      this.cmQ = paramIntent.getExtras().getInt("video_play_caller", 0);
      this.bS = paramIntent.getExtras().getLong("fav_id", 0L);
      this.yF = paramIntent.getExtras().getInt("fav_group_id", 0);
      this.bBp = paramIntent.getExtras().getBoolean("video_title_bar_hide", false);
      this.beL = paramIntent.getExtras().getString("ad_gdt");
      this.msg_id = paramIntent.getExtras().getString("msg_id");
      this.cmR = paramIntent.getExtras().getInt("from_uin_type");
      this.beO = paramIntent.getExtras().getString("from_session_uin");
      this.mUinType = paramIntent.getExtras().getInt("uintype");
      this.beM = paramIntent.getExtras().getString("struct_msg_video_info");
      this.mCurrentUin = paramIntent.getExtras().getString("from_uin");
      this.MX = paramIntent.getExtras().getLong("message_click_start");
      this.mUuid = paramIntent.getExtras().getString("file_uuid");
      this.mMd5 = paramIntent.getExtras().getString("file_shortvideo_md5");
      this.aIf = paramIntent.getExtras().getString("thumbfile_md5");
      this.originRect = ((Rect)paramIntent.getExtras().getParcelable("KEY_THUMBNAL_BOUND"));
      this.bWR = paramIntent.getExtras().getInt("extra.EXTRA_ENTRANCE");
      this.biF = paramIntent.getExtras().getBoolean("extra.IS_FROM_MULTI_MSG");
      this.bBz = paramIntent.getExtras().getBoolean("is_hotVideo");
      this.beT = paramIntent.getExtras().getString("hot_video_icon");
      this.beV = paramIntent.getExtras().getString("hot_video_icon_sub");
      this.beU = paramIntent.getExtras().getString("hot_video_url");
      this.beW = paramIntent.getExtras().getString("hot_video_title");
      if (this.bS != -1L) {
        paramIntent.putExtra("big_brother_source_key", "biz_src_jc_shoucang");
      }
      if ((this.cmQ == 0) || (this.cmQ == 5))
      {
        this.l = ((MessageForShortVideo)paramIntent.getExtras().getParcelable("key_message_for_shortvideo"));
        if (this.l == null)
        {
          QQToast.a(this, 1, acfp.m(2131714470), 0).show(getTitleBarHeight());
          finish();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "initData(), PLAY_CALLER_SHORT_VIDEO, msg = " + this.l.toLogString() + ", mUinType = " + this.mUinType);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoPlayActivity", 2, "initData(): mVideoPath=" + this.mVideoPath + ", mPlayCallerType=" + this.cmQ + ", mCursessionType = " + this.cmR + ", mCurSessionUin = " + this.beO + ", mUinType = " + this.mUinType);
  }
  
  public void initSDK()
  {
    if (!allf.isSDKReady())
    {
      allf.a(BaseApplicationImpl.getApplication(), new aazi(this));
      QLog.d("ShortVideoPlayActivity", 1, "superplayer not ready !");
      return;
    }
    cAt();
  }
  
  boolean isBuffering()
  {
    return this.mPlayState == 4;
  }
  
  public boolean isPlaying()
  {
    return (this.mPlayState == 1) && (this.fa != null) && (this.fa.get() != null) && (((ISuperPlayer)this.fa.get()).isPlaying());
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  boolean ja(String paramString)
  {
    boolean bool = aqhq.fileExists(paramString);
    if (this.LD) {
      bool = false;
    }
    return bool;
  }
  
  protected void k(MessageForShortVideo paramMessageForShortVideo)
  {
    String str = ShortVideoUtils.fh(aqiw.getSystemNetwork(this.mContext));
    if ((paramMessageForShortVideo.istroop == 0) || (paramMessageForShortVideo.istroop == 1008))
    {
      anot.a(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "1", str, "");
      return;
    }
    if (paramMessageForShortVideo.istroop == 3000)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "2", str, "");
      return;
    }
    if (paramMessageForShortVideo.istroop == 1)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "3", str, "");
      return;
    }
    anot.a(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "4", str, "");
  }
  
  public void onBackPressed()
  {
    cwl();
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
      cwl();
      continue;
      this.app.a().z(this.l.frienduin, this.l.uniseq);
      cwl();
      continue;
      showAnimation();
      handleClick();
      continue;
      showAnimation();
      if (this.mPlayState == 1) {
        pause();
      }
      this.c.onClick(paramView);
      continue;
      cwl();
    }
  }
  
  public void onClickDragView()
  {
    cwl();
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    runOnUiThread(new ShortVideoPlayActivity.22(this, paramISuperPlayer));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!this.bBz) {
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ((RelativeLayout)findViewById(2131368667)).setVisibility(8);
      return;
    }
    ((RelativeLayout)findViewById(2131368667)).setVisibility(0);
  }
  
  public void onContentMove(float paramFloat)
  {
    if (this.iX != null)
    {
      Drawable localDrawable = this.iX.getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
      if (paramFloat < 0.8F)
      {
        this.iY.setVisibility(4);
        this.dR.setVisibility(4);
      }
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onError what=" + paramInt1 + ",extra=" + paramInt2 + ",mCacheProgress=" + this.cmT + ", mPlayProgress=" + this.cmS + ", mCurPlayPosition=" + this.MU);
    }
    runOnUiThread(new ShortVideoPlayActivity.23(this, paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramString));
    return false;
  }
  
  public void onGestureFinish()
  {
    anot.a(null, "dc00898", "", "", "0X8009AB3", "0X8009AB3", this.bWR, 0, "", "", "", "");
    azR();
    finish();
    try
    {
      overridePendingTransition(2130772077, 2130772079);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] overridePendingTransition=" + localException);
    }
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onInfo what=" + paramInt + ",extra=" + paramObject + ",mCacheProgress=" + this.cmT + ", mPlayProgress=" + this.cmS + ", mCurPlayPosition=" + this.MU);
    }
    return false;
  }
  
  public void onResetPosition()
  {
    this.iY.setVisibility(0);
    this.dR.setVisibility(0);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.mCompleted) {
      this.mInterrupted = true;
    }
    if ((this.fa != null) && (this.fa.get() != null) && (((ISuperPlayer)this.fa.get()).isPlaying()))
    {
      this.fB = ((ISuperPlayer)this.fa.get()).getCurrentPositionMs();
      this.bBu = true;
    }
    paramBundle.putLong("state_play_position", this.fB);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onSaveInstanceState: mCurrentPosition: " + this.fB);
    }
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onSeekComplete mCacheProgress=" + this.cmT + ", mPlayProgress=" + this.cmS + ", mCurPlayPosition=" + this.MU);
    }
    if ((this.fa != null) && (this.fa.get() != null)) {
      ((ISuperPlayer)this.fa.get()).start();
    }
  }
  
  public void onSurfaceChanged(Object paramObject) {}
  
  public void onSurfaceCreated(Object paramObject) {}
  
  public void onSurfaceDestroy(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onSurfaceDestory");
    }
    this.bBy = true;
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onTVideoNetInfoUpdate ,mCacheProgress=" + this.cmT + ", mPlayProgress=" + this.cmS + ", mCurPlayPosition=" + this.MU);
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onVideoPrepared: mDuration=" + this.mDuration + " mInterrupted" + this.mInterrupted + " mNeedPlay" + this.bBu);
    }
    this.bBy = false;
    runOnUiThread(new ShortVideoPlayActivity.24(this));
    if (this.cmQ == 2) {
      i(this.beL, 1, 1002, this.msg_id);
    }
    if (this.MX != 0L)
    {
      this.MY = (System.currentTimeMillis() - this.MX);
      this.MX = 0L;
    }
    if (this.MZ != 0L)
    {
      this.Na = (System.currentTimeMillis() - this.MZ);
      this.MZ = 0L;
    }
    if (this.mInterrupted)
    {
      this.mInterrupted = false;
      if (this.bBu) {}
    }
    do
    {
      return;
      this.bBu = false;
      if (this.mDuration <= 0L) {
        cAC();
      }
    } while ((this.fa == null) || (this.fa.get() == null));
    ((ISuperPlayer)this.fa.get()).start();
    if (this.MT > 0L) {
      ((ISuperPlayer)this.fa.get()).seekTo((int)this.MT);
    }
    GR(1);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      cAw();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onWindowFocusChanged: hasFocus: " + paramBoolean);
    }
  }
  
  void pQ()
  {
    Object localObject;
    if (this.l != null)
    {
      localObject = ShortVideoUtils.bw(this.l.thumbMD5, "jpg");
      if (!aqhq.fileExistsAndNotEmpty((String)localObject)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(-16777216);
      localObject = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
      this.aE.setImageDrawable((Drawable)localObject);
      this.aE.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "showLoadingImage crashed =" + localException.toString());
        }
      }
    }
  }
  
  public void pause()
  {
    if ((isPlaying()) && (this.fa != null) && (this.fa.get() != null))
    {
      this.fB = ((ISuperPlayer)this.fa.get()).getCurrentPositionMs();
      ((ISuperPlayer)this.fa.get()).pause();
    }
    GR(2);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#pause# , mCurrentPosition = " + this.fB);
    }
    if (this.mStartPlayTime >= 0L) {
      this.Ju += System.currentTimeMillis() - this.mStartPlayTime;
    }
  }
  
  public void play(long paramLong)
  {
    long l2 = paramLong;
    for (;;)
    {
      long l1;
      try
      {
        if (QLog.isColorLevel())
        {
          l2 = paramLong;
          QLog.d("ShortVideoPlayActivity", 2, "#play#, msec=" + paramLong);
        }
        l2 = paramLong;
        this.MT = paramLong;
        l2 = paramLong;
        this.bsQ = true;
        int i = 0;
        l2 = paramLong;
        if (this.fa != null)
        {
          l2 = paramLong;
          if (this.fa.get() != null) {}
        }
        else
        {
          l2 = paramLong;
          this.fa = new WeakReference(SuperPlayerFactory.createMediaPlayer(getApplicationContext(), 101, this.mVideoView));
          l2 = paramLong;
          ((ISuperPlayer)this.fa.get()).setOnCompletionListener(this);
          l2 = paramLong;
          ((ISuperPlayer)this.fa.get()).setOnErrorListener(this);
          l2 = paramLong;
          ((ISuperPlayer)this.fa.get()).setOnVideoPreparedListener(this);
          l2 = paramLong;
          ((ISuperPlayer)this.fa.get()).setOnSeekCompleteListener(this);
          l2 = paramLong;
          ((ISuperPlayer)this.fa.get()).setOnInfoListener(this);
          l2 = paramLong;
          this.MZ = System.currentTimeMillis();
          i = 1;
        }
        l2 = paramLong;
        if (this.mCompleted)
        {
          i = 1;
          l2 = paramLong;
          this.cnb += 1;
        }
        if (i == 0) {
          break label931;
        }
        l1 = paramLong;
        if (paramLong == 0L)
        {
          l1 = paramLong;
          l2 = paramLong;
          if (this.mSeekBar.getProgress() > 0)
          {
            l1 = paramLong;
            l2 = paramLong;
            if (this.mSeekBar.getProgress() < 10000)
            {
              l1 = paramLong;
              l2 = paramLong;
              if (this.l != null)
              {
                l2 = paramLong;
                l1 = this.l.videoFileTime * 1000 * this.mSeekBar.getProgress() / 100;
              }
            }
          }
        }
        l2 = l1;
        if (this.cJ != null)
        {
          l2 = l1;
          if (this.LD)
          {
            l2 = l1;
            Object localObject;
            if (this.cmQ != 0)
            {
              l2 = l1;
              if (this.cmQ != 5) {}
            }
            else
            {
              l2 = l1;
              if (this.l != null)
              {
                l2 = l1;
                localObject = ShortVideoUtils.a(this.l, "mp4");
                l2 = l1;
                if (QLog.isColorLevel())
                {
                  l2 = l1;
                  QLog.d("ShortVideoPlayActivity", 2, "#play#, setVid =" + this.mMd5 + " videoPath=" + (String)localObject);
                  l2 = l1;
                  QLog.d("ShortVideoPlayActivity", 2, "#play#, url0 =" + this.cJ[0]);
                }
                l2 = l1;
                this.Ne = System.currentTimeMillis();
                l2 = l1;
                localObject = SuperPlayerFactory.createVideoInfoForUrl(this.cJ, 100, null);
                l2 = l1;
                ((ISuperPlayer)this.fa.get()).openMediaPlayer(this.mContext.getApplicationContext(), (SuperPlayerVideoInfo)localObject, 0L);
                paramLong = l1;
                l2 = paramLong;
                this.mCompleted = false;
                l2 = paramLong;
                if (this.cmQ == 0)
                {
                  l2 = paramLong;
                  if (!this.bBq)
                  {
                    l2 = paramLong;
                    if (this.mUinType != 0) {
                      break label954;
                    }
                    l2 = paramLong;
                    anot.a(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "1", "", "");
                    l2 = paramLong;
                    this.bBq = true;
                  }
                }
                l2 = paramLong;
                if (this.mStartPlayTime >= 0L)
                {
                  l2 = paramLong;
                  this.Ju += System.currentTimeMillis() - this.mStartPlayTime;
                }
                l2 = paramLong;
                this.mStartPlayTime = System.currentTimeMillis();
                return;
              }
            }
            l2 = l1;
            if (this.cmQ == 2)
            {
              l2 = l1;
              if (this.beM != null)
              {
                l2 = l1;
                localObject = this.beP;
                continue;
              }
            }
            l2 = l1;
            if (!QLog.isColorLevel()) {
              break;
            }
            l2 = l1;
            QLog.d("ShortVideoPlayActivity", 2, "#play#, mVideo caller type not right:" + this.cmQ);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d("ShortVideoPlayActivity", 1, "#play#, msec=" + l2, localException);
        reset();
        gj(0, 0);
        return;
      }
      l2 = l1;
      if (!TextUtils.isEmpty(this.mVideoPath))
      {
        l2 = l1;
        if (QLog.isColorLevel())
        {
          l2 = l1;
          QLog.d("ShortVideoPlayActivity", 2, "#play#, videoPath=" + this.mVideoPath);
        }
        l2 = l1;
        SuperPlayerVideoInfo localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(this.mVideoPath, 100, null);
        l2 = l1;
        ((ISuperPlayer)this.fa.get()).openMediaPlayer(this.mContext.getApplicationContext(), localSuperPlayerVideoInfo, 0L);
        paramLong = l1;
      }
      else
      {
        l2 = l1;
        if (!QLog.isColorLevel()) {
          break;
        }
        l2 = l1;
        QLog.d("ShortVideoPlayActivity", 2, "#play#, mVideoPath should not be null!");
        return;
        label931:
        l2 = paramLong;
        ((ISuperPlayer)this.fa.get()).seekTo((int)paramLong);
        continue;
        label954:
        l2 = paramLong;
        if (this.mUinType == 3000)
        {
          l2 = paramLong;
          anot.a(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "2", "", "");
          l2 = paramLong;
          this.bBq = true;
        }
        else
        {
          l2 = paramLong;
          if (this.mUinType == 1)
          {
            l2 = paramLong;
            anot.a(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "3", "", "");
            l2 = paramLong;
            this.bBq = true;
          }
          else
          {
            l2 = paramLong;
            anot.a(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "4", "", "");
            l2 = paramLong;
            this.bBq = true;
          }
        }
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  void reset()
  {
    GR(0);
  }
  
  public boolean resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#resume#");
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.fa != null)
    {
      bool1 = bool2;
      if (this.fa.get() != null)
      {
        bool1 = bool2;
        if (this.mPlayState == 2)
        {
          ((ISuperPlayer)this.fa.get()).start();
          GR(1);
          bool1 = true;
        }
      }
    }
    if (this.mStartPlayTime >= 0L) {
      this.Ju += System.currentTimeMillis() - this.mStartPlayTime;
    }
    this.mStartPlayTime = System.currentTimeMillis();
    return bool1;
  }
  
  public void showAnimation()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onClick surfaceView, mHidden=" + this.mHidden);
    }
    if (this.mHidden)
    {
      cAz();
      cAA();
    }
  }
  
  void showLoadingView()
  {
    if (this.OT.getVisibility() != 0) {
      this.OT.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity
 * JD-Core Version:    0.7.0.1
 */