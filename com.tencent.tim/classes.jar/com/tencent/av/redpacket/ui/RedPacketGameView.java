package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.LocalEmojiInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalFrameSyncInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalHitInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import isb;
import isw;
import itb;
import itc;
import itd;
import ite;
import iwu;
import java.util.List;
import jij;
import jik;
import jlg;

public class RedPacketGameView
  extends RelativeLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, View.OnClickListener
{
  public isw a;
  public itb a;
  public itd a;
  public isb b;
  public Bitmap bi;
  public Bitmap bl;
  public Bitmap bm;
  public itc[] c = new itc[10];
  public View hL;
  public long mCurTime;
  public int mFrameNumber;
  public boolean mIsRunning = true;
  public boolean mIsSend;
  public Paint mPaint = new Paint();
  public long mStartTime;
  public int mState = 0;
  
  public RedPacketGameView(Context paramContext, AVActivity paramAVActivity)
  {
    super(paramContext);
    this.jdField_a_of_type_Isw = new isw();
    a(paramContext, paramAVActivity);
  }
  
  public RedPacketGameView(Context paramContext, AVActivity paramAVActivity, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Isw = new isw();
    a(paramContext, paramAVActivity);
  }
  
  public RedPacketGameView(Context paramContext, AVActivity paramAVActivity, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Isw = new isw();
    a(paramContext, paramAVActivity);
  }
  
  private void aqu()
  {
    if (this.hL != null)
    {
      if (this.bl != null)
      {
        localObject = (VideoView)this.hL.findViewById(2131374188);
        if (localObject != null) {
          ((VideoView)localObject).setBackgroundDrawable(new BitmapDrawable(this.bl));
        }
      }
      Object localObject = (ViewGroup)this.hL.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).post(new RedPacketGameView.4(this, (ViewGroup)localObject));
      }
    }
  }
  
  private Bitmap rotateBitmap(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject = null;
    if (paramBitmap != null)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramFloat);
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
      localObject = localBitmap;
      if (!localBitmap.equals(paramBitmap))
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
    }
    return localObject;
  }
  
  private void startGame()
  {
    aqu();
    ((AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6)).startGame();
  }
  
  public void a(Context paramContext, AVActivity paramAVActivity)
  {
    setId(2131374182);
    this.jdField_a_of_type_Itd = new itd(paramContext);
    this.b = new isb(paramContext);
    this.jdField_a_of_type_Itb = new itb(this, paramAVActivity);
  }
  
  public void a(Canvas paramCanvas, long paramLong)
  {
    if (this.mState == 1) {
      if ((this.jdField_a_of_type_Itd != null) && (this.hL == null)) {
        this.jdField_a_of_type_Itd.draw(paramCanvas, this.mPaint);
      }
    }
    while (this.mState != 2) {
      return;
    }
    this.b.draw(paramCanvas, this.mPaint);
    this.jdField_a_of_type_Isw.draw(paramCanvas, this.mPaint);
    this.jdField_a_of_type_Itb.draw(paramCanvas, this.mPaint);
  }
  
  public void apP()
  {
    this.b.apP();
  }
  
  public void apU()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    Object localObject1 = localAVActivity.getLayoutInflater();
    Object localObject2 = (ViewGroup)getParent();
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
    this.hL = ((ViewGroup)localObject2).findViewById(2131374187);
    if (this.hL == null)
    {
      ((LayoutInflater)localObject1).inflate(2131559964, (ViewGroup)localObject2);
      this.hL = ((ViewGroup)localObject2).findViewById(2131374187);
    }
    localObject1 = (VideoView)this.hL.findViewById(2131374188);
    String str = jik.getResPath() + "qav_redpacket_guide.mp4";
    ((VideoView)localObject1).setVideoPath(str);
    ((VideoView)localObject1).setOnErrorListener(this);
    ((VideoView)localObject1).setOnCompletionListener(this);
    ((VideoView)localObject1).setOnPreparedListener(this);
    ((VideoView)localObject1).setZOrderOnTop(true);
    ((VideoView)localObject1).setZOrderMediaOverlay(true);
    if (Build.VERSION.SDK_INT >= 17) {
      ((VideoView)localObject1).setOnInfoListener(this);
    }
    if (this.bl == null) {
      localObject2 = new MediaMetadataRetriever();
    }
    try
    {
      ((MediaMetadataRetriever)localObject2).setDataSource(str);
      this.bl = ((MediaMetadataRetriever)localObject2).getFrameAtTime(0L);
      ((MediaMetadataRetriever)localObject2).release();
      if (this.bl != null) {
        ((VideoView)localObject1).setBackgroundDrawable(new BitmapDrawable(this.bl));
      }
      localObject1 = this.hL.findViewById(2131374186);
      if (this.bm == null) {
        this.bm = localAVRedPacketManager.o("qav_redpacket_receive_popup.png");
      }
      if (this.bm != null) {
        ((View)localObject1).setBackgroundDrawable(new BitmapDrawable(this.bm));
      }
      localObject1 = this.hL.findViewById(2131374185);
      if (this.bi == null) {
        this.bi = localAVRedPacketManager.o("qav_redpacket_result_close.png");
      }
      if (this.bi != null) {
        ((View)localObject1).setBackgroundDrawable(jlg.a(localAVActivity.getResources(), this.bi, 2131166288));
      }
      ((View)localObject1).setOnClickListener(this);
      jij.awO();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketGameView", 2, "showReceiverUserGuide e = " + localException);
        }
      }
    }
  }
  
  public void apZ()
  {
    iR(false);
  }
  
  public void aqs()
  {
    iR(true);
  }
  
  public void aqt()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Isw.mStartTime = l;
    this.b.setStartTime(l);
    this.mState = 2;
  }
  
  public void b(AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    if ((this.mState != 2) && (paramLocalFrameSyncInfo.localEmojiInfos.size() > 0)) {
      this.mState = 2;
    }
    c(true, paramLocalFrameSyncInfo);
  }
  
  public void c(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    QLog.d("RedPacketGameView", 2, "WL_DEBUG updateState localFrameSyncInfo = " + paramLocalFrameSyncInfo.toString());
    this.jdField_a_of_type_Itb.c(paramBoolean, paramLocalFrameSyncInfo);
    this.b.c(paramBoolean, paramLocalFrameSyncInfo);
  }
  
  public void d(AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    int j = 0;
    c(false, paramLocalFrameSyncInfo);
    int i = j;
    if (paramLocalFrameSyncInfo.localHitInfo.topWordTipType != 3)
    {
      i = j;
      if (paramLocalFrameSyncInfo.localHitInfo.topWordTipType != 0) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
      if (localAVRedPacketManager.cs(this.b.ct(paramLocalFrameSyncInfo.localHitInfo.emojiId))) {
        postDelayed(new RedPacketGameView.2(this, localAVRedPacketManager), 50L);
      }
    }
  }
  
  public void d(AVRedPacketManager paramAVRedPacketManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameView", 2, "preLoadRes start,avRedPacketManager = " + paramAVRedPacketManager);
    }
    this.jdField_a_of_type_Itd.b(paramAVRedPacketManager);
    this.b.b(paramAVRedPacketManager);
    int i = 0;
    while (i < this.c.length)
    {
      this.c[i] = new itc(paramAVRedPacketManager.o("qav_redpacket_score_" + i + ".png"));
      i += 1;
    }
    this.jdField_a_of_type_Isw.b(paramAVRedPacketManager);
    this.b.a(paramAVRedPacketManager, this.c);
    this.jdField_a_of_type_Itb.c(paramAVRedPacketManager, this.c);
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameView", 2, "preLoadRes end");
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.mCurTime = NetConnInfoCenter.getServerTimeMillis();
    update(this.mCurTime);
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    a(paramCanvas, this.mCurTime);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    QLog.d("RedPacketGameView", 2, "WL_DEBUG update cost = " + (l1 - this.mCurTime) + ", doDraw cost = " + (l2 - l1));
    super.dispatchDraw(paramCanvas);
    if (this.mIsRunning) {
      invalidate();
    }
    if (this.mStartTime == 0L) {
      this.mStartTime = this.mCurTime;
    }
    this.mFrameNumber += 1;
  }
  
  public AVActivity getAVActivity()
  {
    Context localContext = getContext();
    if ((localContext instanceof AVActivity)) {
      return (AVActivity)localContext;
    }
    return null;
  }
  
  public void h(int paramInt, List<AVRedPacketManager.LocalEmojiInfo> paramList)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (this.jdField_a_of_type_Itd != null) {}
    for (l = this.jdField_a_of_type_Itd.v(l - 2333L);; l = 0L)
    {
      AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
      this.b.bB(paramList);
      this.jdField_a_of_type_Itb.lH(paramInt);
      if (l > 0L)
      {
        postDelayed(new RedPacketGameView.1(this, localAVRedPacketManager), l);
        return;
      }
      localAVRedPacketManager.C(1, false);
      return;
    }
  }
  
  public void iR(boolean paramBoolean)
  {
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
    this.mIsSend = paramBoolean;
    this.mState = 1;
    this.b.a(localAVRedPacketManager);
    this.jdField_a_of_type_Itd.a(paramBoolean, localAVRedPacketManager);
    long l = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Itd.cw(l);
    this.b.setIsSend(paramBoolean);
    this.jdField_a_of_type_Itb.a(paramBoolean, localAVRedPacketManager);
  }
  
  public void iS(boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      if (this.mIsSend)
      {
        iwu.b(localVideoAppInterface, 1045, 2131698025);
        return;
      }
      QLog.w("RedPacketGameView", 1, "showCameraOpenTip, isShow[" + paramBoolean + "], seq[" + l + "]");
      iwu.a(localVideoAppInterface, 1046, null, new ite(this, l));
      return;
    }
    iwu.a(localVideoAppInterface, 1045);
  }
  
  public void iT(boolean paramBoolean)
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      iwu.b(localVideoAppInterface, 1045, 2131698036);
      return;
    }
    iwu.a(localVideoAppInterface, 1045);
  }
  
  public void iU(boolean paramBoolean)
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      iwu.b(localVideoAppInterface, 1045, 2131698037);
      if (this.jdField_a_of_type_Itd != null) {
        this.jdField_a_of_type_Itd.v(0L);
      }
      return;
    }
    iwu.a(localVideoAppInterface, 1045);
  }
  
  public void iV(boolean paramBoolean)
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      iwu.b(localVideoAppInterface, 1045, 2131698038);
      if (this.jdField_a_of_type_Itd != null) {
        this.jdField_a_of_type_Itd.v(0L);
      }
      return;
    }
    iwu.a(localVideoAppInterface, 1045);
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
      startGame();
      jij.awP();
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    startGame();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    startGame();
    return false;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((this.hL != null) && (paramInt1 == 3))
    {
      paramMediaPlayer = (VideoView)this.hL.findViewById(2131374188);
      if (paramMediaPlayer != null) {
        paramMediaPlayer.setBackgroundDrawable(null);
      }
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.hL != null)
    {
      paramMediaPlayer = (VideoView)this.hL.findViewById(2131374188);
      if (paramMediaPlayer != null) {
        paramMediaPlayer.start();
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Itd != null) {
      this.jdField_a_of_type_Itd.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.jdField_a_of_type_Isw.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Itb.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void recycle()
  {
    this.jdField_a_of_type_Isw.recycle();
    this.jdField_a_of_type_Itb.recycle();
    this.b.recycle();
    itc[] arrayOfitc = this.c;
    int j = arrayOfitc.length;
    int i = 0;
    while (i < j)
    {
      itc localitc = arrayOfitc[i];
      if (localitc != null) {
        localitc.recycle();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Itd != null) {
      this.jdField_a_of_type_Itd.recycle();
    }
    this.jdField_a_of_type_Itd = null;
    this.jdField_a_of_type_Isw = null;
    this.jdField_a_of_type_Itb = null;
    this.b = null;
    this.c = null;
    this.mPaint = null;
    aqu();
  }
  
  public void setIsRunning(boolean paramBoolean)
  {
    this.mIsRunning = paramBoolean;
    if (!this.mIsRunning) {
      return;
    }
    invalidate();
  }
  
  public void setScoreMarginTop(int paramInt)
  {
    this.jdField_a_of_type_Itb.setMarginTop(paramInt);
  }
  
  public void update(long paramLong)
  {
    if (this.mState == 1) {
      if ((this.jdField_a_of_type_Itd != null) && (this.jdField_a_of_type_Itd.ax(paramLong)))
      {
        this.jdField_a_of_type_Itd.recycle();
        this.jdField_a_of_type_Itd = null;
        ((AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6)).aqd();
      }
    }
    while (this.mState != 2) {
      return;
    }
    this.jdField_a_of_type_Isw.update(paramLong);
    this.b.update(paramLong);
    this.jdField_a_of_type_Itb.update(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameView
 * JD-Core Version:    0.7.0.1
 */