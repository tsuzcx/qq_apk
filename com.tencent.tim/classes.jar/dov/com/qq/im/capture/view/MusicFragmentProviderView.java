package dov.com.qq.im.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import aniq;
import aqiw;
import aqnm;
import auru;
import axov;
import axrh;
import axrk;
import axro;
import axwr;
import axws;
import axwt;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import rkb;
import rox;

public class MusicFragmentProviderView
  extends ProviderView
  implements Handler.Callback, View.OnClickListener, QimMusicSeekView.a
{
  private long Cg = 400L;
  private ImageView IH;
  private View MT;
  private axrk jdField_a_of_type_Axrk = new axws(this);
  private axro jdField_a_of_type_Axro;
  private MusicPlayTask jdField_a_of_type_DovComQqImCaptureViewMusicFragmentProviderView$MusicPlayTask;
  private QimMusicSeekView jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView;
  private TextView ahF;
  private TextView ahG;
  private TextView ahH;
  private TextView ahI;
  private TextView ahJ;
  private TextView ahK;
  private TextView ahL;
  public auru b;
  private int bsu = 10000;
  private axrh c;
  private AtomicInteger cx = new AtomicInteger(-1);
  private boolean dwR;
  private TextView dx;
  private int eIs;
  private int eIt;
  private AtomicBoolean eP = new AtomicBoolean(false);
  private MusicItemInfo h;
  private ProgressBar mProgressBar;
  private Timer mTimer;
  private View oW;
  
  public MusicFragmentProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Axrh = new axwr(this);
  }
  
  private void Za(boolean paramBoolean)
  {
    boolean bool = true;
    this.eIs = this.h.musicStart;
    this.eIt = this.h.musicEnd;
    this.MT.setVisibility(8);
    this.h.musicStart = 0;
    this.h.musicEnd = this.bsu;
    this.h.musicDuration = ((int)ShortVideoUtils.getDuration(this.h.getLocalPath()));
    if (this.h.musicDuration < this.h.musicEnd) {
      this.h.musicEnd = this.h.musicDuration;
    }
    this.dwR = true;
    this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView.setDurations((tx() + 500) / 1000, (Math.max(this.h.musicDuration, this.bsu) + 500) / 1000);
    this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView.xF(0);
    lw(this.h.musicStart, this.h.musicEnd);
    this.oW.setVisibility(0);
    this.ahI.setEnabled(true);
    ProviderView.a locala;
    if ((this.eCJ == 0) && (!paramBoolean))
    {
      this.jdField_a_of_type_Axro.a(this.h, this.eCJ);
      if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null)
      {
        locala = this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a;
        if (paramBoolean) {
          break label294;
        }
      }
    }
    label294:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.uZ(paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "prepareStartMusic musicName" + this.h.mMusicName);
      }
      return;
      this.jdField_a_of_type_Axro.a(this.h);
      break;
    }
  }
  
  private void lw(int paramInt1, int paramInt2)
  {
    int j = (paramInt2 - paramInt1) / 1000;
    int i;
    if (j < 0) {
      i = 1;
    }
    for (;;)
    {
      String str1 = rkb.i(paramInt1, false);
      String str2 = rkb.i(i * 1000 + paramInt1, false);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("start = ").append(paramInt1);
        localStringBuilder.append(", end = ").append(paramInt2);
        localStringBuilder.append(", displayStart = ").append(str1);
        localStringBuilder.append(", displayEnd = ").append(str2);
        QLog.d("MusicFragmentProviderView", 2, localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder(str1);
      localStringBuilder.append("-").append(str2);
      this.ahF.setText(localStringBuilder.toString());
      this.ahJ.setText(str1);
      this.ahK.setText(str2);
      return;
      i = j;
      if ((paramInt2 - paramInt1) % 1000 > 500) {
        i = j + 1;
      }
    }
  }
  
  private void startDownload()
  {
    if (this.h == null)
    {
      QLog.i("MusicFragmentProviderView", 1, "startDownload mCurMusicItemInfo is null");
      return;
    }
    String str = this.h.mSongMid;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "songMid not exist");
      }
      aeO(-115);
      return;
    }
    if (!aqiw.isNetSupport(this.mContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "Net not Support");
      }
      aeO(-104);
      return;
    }
    if (aqiw.isMobileNetWork(this.mContext)) {
      aeP(1);
    }
    ((QIMMusicConfigManager)axov.a(2)).a(str, this.h instanceof VsMusicItemInfo, new axwt(this));
  }
  
  private int tx()
  {
    if (this.bsu < 5000) {
      return 5000;
    }
    if (this.bsu > aniq.dGY) {
      return aniq.dGY;
    }
    return this.bsu;
  }
  
  protected int QW()
  {
    return 2131561122;
  }
  
  public boolean aOc()
  {
    cancel();
    return true;
  }
  
  public void ae(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Axro != null) {
      this.jdField_a_of_type_Axro.Zx();
    }
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.uZ(false);
    }
    af(paramInt1, paramInt2, paramInt3);
  }
  
  public void aeN(int paramInt)
  {
    if (this.b != null)
    {
      Message localMessage = this.b.obtainMessage();
      localMessage.what = 5;
      localMessage.arg1 = paramInt;
      this.b.sendMessage(localMessage);
    }
  }
  
  public void aeO(int paramInt)
  {
    if (this.b != null)
    {
      Message localMessage = this.b.obtainMessage();
      localMessage.what = 8;
      localMessage.arg1 = paramInt;
      this.b.sendMessage(localMessage);
    }
  }
  
  public void aeP(int paramInt)
  {
    if (this.b != null)
    {
      Message localMessage = this.b.obtainMessage();
      localMessage.what = 4;
      localMessage.arg1 = paramInt;
      this.b.sendMessage(localMessage);
    }
  }
  
  public void af(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.h != null)
    {
      paramInt2 = this.h.musicDuration;
      paramInt1 = (int)(paramInt2 * (paramInt3 / paramInt1));
      paramInt3 = this.bsu;
      if ((paramInt1 >= paramInt2) || (paramInt3 + paramInt1 <= paramInt2)) {
        break label82;
      }
      this.h.musicStart = (paramInt2 - this.bsu);
    }
    for (this.h.musicEnd = paramInt2;; this.h.musicEnd = (paramInt1 + this.bsu))
    {
      lw(this.h.musicStart, this.h.musicEnd);
      return;
      label82:
      this.h.musicStart = paramInt1;
    }
  }
  
  public void ag(int paramInt1, int paramInt2, int paramInt3)
  {
    af(paramInt1, paramInt2, paramInt3);
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.uZ(true);
    }
    if (this.jdField_a_of_type_Axro != null)
    {
      if (this.eCJ == 0) {
        this.jdField_a_of_type_Axro.a(this.h, true, this.eCJ);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Axro.a(this.h);
  }
  
  public boolean au(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getY();
    float f2 = aqnm.getScreenHeight() - this.mContentHeight;
    if (QLog.isColorLevel()) {
      QLog.d("MusicFragmentProviderView", 2, "checkToInterceptTouchArea, touchY=" + f1 + ", minTouchingY=" + f2);
    }
    return f1 < f2;
  }
  
  public void bve()
  {
    bvf();
    this.mTimer = new Timer();
    this.jdField_a_of_type_DovComQqImCaptureViewMusicFragmentProviderView$MusicPlayTask = new MusicPlayTask();
    this.Cg = 400L;
    if (this.bsu > aniq.dGY) {
      this.Cg = ((this.bsu * 400.0F / aniq.dGY));
    }
    for (;;)
    {
      this.mTimer.schedule(this.jdField_a_of_type_DovComQqImCaptureViewMusicFragmentProviderView$MusicPlayTask, 0L, this.Cg);
      return;
      if (this.bsu < 5000) {
        this.Cg = ((this.bsu * 400.0F / 5000));
      }
    }
  }
  
  public void bvf()
  {
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewMusicFragmentProviderView$MusicPlayTask != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewMusicFragmentProviderView$MusicPlayTask.cancel();
      this.jdField_a_of_type_DovComQqImCaptureViewMusicFragmentProviderView$MusicPlayTask = null;
    }
  }
  
  public void cancel()
  {
    if (this.eP.compareAndSet(true, false))
    {
      this.jdField_a_of_type_Axro.h(this.h);
      this.h.mProgress = -1;
    }
    if ((this.h != null) && (this.dwR))
    {
      this.h.musicStart = this.eIs;
      this.h.musicEnd = this.eIt;
      this.jdField_a_of_type_Axro.eOq();
      this.jdField_a_of_type_Axro.aeH(this.eCJ);
      if (((QIMMusicConfigManager)axov.a(2)).b(this.h.mItemId) == null)
      {
        rox.delete(new File(this.h.getLocalPath()));
        if (QLog.isColorLevel()) {
          QLog.d("MusicFragmentProviderView", 2, "delete file=" + this.h.mMusicName);
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("cancel musicStart=").append(this.h.musicStart);
        localStringBuilder.append(" musicEnd=").append(this.h.musicEnd);
        localStringBuilder.append(" musicDuration").append(this.h.musicDuration);
        localStringBuilder.append(" premusicStart").append(this.eIs);
        localStringBuilder.append(" premusicEnd").append(this.eIt);
        localStringBuilder.append(" musicName").append(this.h.mMusicName);
        QLog.d("MusicFragmentProviderView", 2, localStringBuilder.toString());
      }
      this.h = null;
      bvf();
    }
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.aex(2);
    }
    if (this.b != null)
    {
      this.b.removeCallbacksAndMessages(null);
      this.b = null;
    }
    this.jdField_a_of_type_Axro.b(this.jdField_a_of_type_Axrk);
    this.jdField_a_of_type_Axro = null;
  }
  
  public void complete()
  {
    if ((this.h != null) && (this.dwR))
    {
      if (this.eCJ != 0) {
        break label261;
      }
      this.jdField_a_of_type_Axro.a(this.h, true, this.eCJ);
    }
    for (;;)
    {
      if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
        this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.uZ(true);
      }
      ((QIMMusicConfigManager)axov.a(2)).a(this.h, true);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("complete musicStart=").append(this.h.musicStart);
        localStringBuilder.append(" musicEnd=").append(this.h.musicEnd);
        localStringBuilder.append(" musicDuration").append(this.h.musicDuration);
        localStringBuilder.append(" premusicStart").append(this.eIs);
        localStringBuilder.append(" premusicEnd").append(this.eIt);
        localStringBuilder.append(" musicName").append(this.h.mMusicName);
        QLog.d("MusicFragmentProviderView", 2, localStringBuilder.toString());
      }
      this.h = null;
      bvf();
      if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
        this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.aex(2);
      }
      if (this.b != null)
      {
        this.b.removeCallbacksAndMessages(null);
        this.b = null;
      }
      if (this.jdField_a_of_type_Axro != null)
      {
        this.jdField_a_of_type_Axro.b(this.jdField_a_of_type_Axrk);
        this.jdField_a_of_type_Axro = null;
      }
      return;
      label261:
      this.jdField_a_of_type_Axro.a(this.h);
    }
  }
  
  public void en(int paramInt1, int paramInt2)
  {
    int i = (int)(this.ahJ.getPaint().measureText("00:00") / 2.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.ahJ.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt1 - i);
    this.ahJ.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.ahK.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt2 - i * 2);
    this.ahK.setLayoutParams(localLayoutParams);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i;
    boolean bool;
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 4: 
      do
      {
        do
        {
          return false;
          this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView.setPlayedPosition(this.cx.get());
          return false;
          i = paramMessage.arg1;
          this.MT.setVisibility(0);
          this.oW.setVisibility(8);
          if (i >= 100)
          {
            this.MT.setVisibility(8);
            return false;
          }
          this.IH.setVisibility(8);
          this.mProgressBar.setProgress(i);
          this.ahH.setVisibility(8);
        } while (!QLog.isColorLevel());
        QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_PROGRESS percent=" + i);
        return false;
        i = paramMessage.arg1;
        if (i == 1) {
          this.ahG.setText(this.mContext.getResources().getString(2131700438));
        }
        this.IH.setVisibility(8);
        this.ahH.setVisibility(8);
      } while (!QLog.isColorLevel());
      QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_NET_CHANGE state=" + i);
      return false;
    case 8: 
      i = paramMessage.arg1;
      if (i == 0) {
        this.MT.setVisibility(8);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_DOWNLOAD_FINISH_STATE finishState=" + i);
        return false;
        if (i == -104)
        {
          this.IH.setVisibility(0);
          this.ahH.setVisibility(8);
          this.ahG.setText(this.mContext.getResources().getString(2131700439));
        }
        else
        {
          this.IH.setVisibility(0);
          this.ahH.setVisibility(8);
          this.ahG.setText(this.mContext.getResources().getString(2131700434));
        }
      }
    case 2: 
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_REPLAY ");
      }
      if ((getContext() instanceof AppActivity))
      {
        paramMessage = (AppActivity)getContext();
        if (QLog.isColorLevel()) {
          QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_REPLAY isResume" + paramMessage.isResume());
        }
        if (paramMessage.isResume()) {
          break label879;
        }
        bool = true;
      }
      break;
    }
    for (;;)
    {
      if ((this.h == null) || (TextUtils.isEmpty(this.h.getLocalPath())))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MusicFragmentProviderView", 2, "curretInfo ==null or path not exsist");
        return false;
        if (!(getContext() instanceof BaseActivity)) {
          break label879;
        }
        paramMessage = (BaseActivity)getContext();
        if (QLog.isColorLevel()) {
          QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_REPLAY isResume" + paramMessage.isResume());
        }
        if (paramMessage.isResume()) {
          break label879;
        }
        bool = true;
        continue;
      }
      Za(bool);
      return false;
      this.ahG.setText(this.mContext.getResources().getString(2131700440));
      return false;
      if (this.h == null) {
        break;
      }
      i = paramMessage.arg1;
      this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView.xF(i);
      lw(this.h.musicStart, this.h.musicEnd);
      return false;
      if (paramMessage.obj == null) {
        break;
      }
      paramMessage = (String)paramMessage.obj;
      this.ahL.setText(paramMessage);
      this.ahL.setVisibility(0);
      return false;
      String str = this.mContext.getResources().getString(2131700434);
      if (paramMessage.arg1 == 1)
      {
        paramMessage = (FlowMusic)paramMessage.obj;
        if (QLog.isColorLevel()) {
          QLog.d("MusicFragmentProviderView", 2, "onGetSingleMusicInfo flowMusic:" + paramMessage.toString());
        }
        this.h.mUrl = paramMessage.url;
        this.h.fileSize = paramMessage.size;
        this.h.mAlbumUrl = paramMessage.albumUrl;
        if ((paramMessage.playable == 1) && (!TextUtils.isEmpty(paramMessage.url)))
        {
          this.jdField_a_of_type_Axro.a(this.h, this.jdField_c_of_type_Axrh);
          return false;
        }
        if (paramMessage.playable == 1) {}
      }
      for (paramMessage = this.mContext.getResources().getString(2131700435);; paramMessage = str)
      {
        this.IH.setVisibility(0);
        this.ahG.setText(paramMessage);
        this.ahH.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MusicFragmentProviderView", 2, "MSG_GET_SINGLE_MUSIC failed");
        return false;
      }
      label879:
      bool = false;
    }
  }
  
  public void hl(String paramString, int paramInt)
  {
    if ((this.h != null) && (this.h.getLocalPath().equals(paramString)) && (this.b != null))
    {
      paramString = this.b.obtainMessage();
      paramString.what = 1;
      paramString.arg1 = paramInt;
      this.b.sendMessage(paramString);
    }
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
      cancel();
      continue;
      complete();
      continue;
      if (!this.jdField_a_of_type_Axro.b(this.h)) {
        startDownload();
      }
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "download_try_again");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mContentView == null) {
      this.mContentView = LayoutInflater.from(getContext()).inflate(2131561122, this, false);
    }
    addContentView(this.mContentView);
    this.mContentView.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView = ((QimMusicSeekView)this.mContentView.findViewById(2131372085));
    this.jdField_a_of_type_DovComQqImCaptureViewQimMusicSeekView.setOnSeekListener(this);
    this.MT = this.mContentView.findViewById(2131370801);
    this.IH = ((ImageView)this.mContentView.findViewById(2131366062));
    this.ahH = ((TextView)this.mContentView.findViewById(2131366096));
    this.ahH.setOnClickListener(this);
    this.mProgressBar = ((ProgressBar)this.mContentView.findViewById(2131372094));
    this.ahG = ((TextView)this.mContentView.findViewById(2131366082));
    this.oW = this.mContentView.findViewById(2131377959);
    this.ahL = ((TextView)this.mContentView.findViewById(2131378566));
    this.ahJ = ((TextView)this.mContentView.findViewById(2131377918));
    this.ahK = ((TextView)this.mContentView.findViewById(2131377917));
    this.ahF = ((TextView)this.mContentView.findViewById(2131372121));
    this.dx = ((TextView)this.mContentView.findViewById(2131364098));
    this.ahI = ((TextView)this.mContentView.findViewById(2131364108));
    this.dx.setOnClickListener(this);
    this.ahI.setOnClickListener(this);
  }
  
  public void setMusicProviderView(MusicItemInfo paramMusicItemInfo)
  {
    QIMMusicConfigManager localQIMMusicConfigManager = (QIMMusicConfigManager)axov.a(2);
    this.b = new auru(Looper.getMainLooper(), this);
    this.h = paramMusicItemInfo;
    localQIMMusicConfigManager.c = paramMusicItemInfo;
    this.cx.set(-1);
    this.dwR = false;
    this.eP.set(false);
    this.jdField_a_of_type_Axro = ((axro)axov.a().c(8));
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null)
    {
      this.bsu = this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.getVideoDuration();
      if (this.bsu < 1000) {
        this.bsu = 1000;
      }
      if (this.bsu != aniq.dHa) {
        break label249;
      }
      this.Cg = ((int)(1.0F * this.bsu / (tx() + 1) * 400.0F));
      this.jdField_a_of_type_Axro.eOq();
      if (!this.jdField_a_of_type_Axro.b(paramMusicItemInfo)) {
        break label291;
      }
      this.MT.setVisibility(8);
      this.b.sendEmptyMessage(2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "setMusicProviderView file not exist fileName=" + paramMusicItemInfo.mMusicName + " mid=" + paramMusicItemInfo.mSongMid);
      }
      this.jdField_a_of_type_Axro.a(this.jdField_a_of_type_Axrk);
      return;
      this.bsu = 10000;
      break;
      label249:
      int i = (int)(this.bsu / 6 * 0.4D);
      if (this.bsu < 5000) {}
      for (long l = i;; l = 400L)
      {
        this.Cg = l;
        break;
      }
      label291:
      this.mProgressBar.setProgress(1);
      this.ahG.setText(this.mContext.getResources().getString(2131697022));
      this.IH.setVisibility(8);
      this.ahH.setVisibility(8);
      this.ahG.setVisibility(0);
      this.MT.setVisibility(0);
      this.oW.setVisibility(8);
      this.ahI.setEnabled(false);
      startDownload();
    }
  }
  
  public class MusicPlayTask
    extends TimerTask
  {
    protected MusicPlayTask() {}
    
    public void run()
    {
      if (MusicFragmentProviderView.a(MusicFragmentProviderView.this) != null)
      {
        MusicFragmentProviderView.a(MusicFragmentProviderView.this).incrementAndGet();
        if (MusicFragmentProviderView.this.b != null) {
          MusicFragmentProviderView.this.b.sendEmptyMessage(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.MusicFragmentProviderView
 * JD-Core Version:    0.7.0.1
 */