package com.tencent.biz.qqstory.takevideo;

import acfp;
import alza;
import alzd;
import alzf;
import amae;
import amah;
import amas;
import amat;
import amax;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anhq;
import aniq;
import anki;
import aqgz;
import aqiw;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import ram;
import rbw;
import rcb;
import rdb;
import rdc;
import rdo;
import rel;
import rep;
import req;
import rer;
import rfa;
import rkm;
import rpq;
import rpv;

public class HWEditLocalVideoPlayer
  extends rdb
  implements alzd, Handler.Callback, rdo
{
  private amah jdField_a_of_type_Amah;
  private ConvertIFramesRunnable jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
  public NeoVideoFilterPlayView a;
  private boolean aHl = true;
  protected boolean aHm;
  public final boolean aHn = alzf.aHn;
  private boolean aHo;
  private Handler bq = new Handler(ThreadManager.getFileThreadLooper(), this);
  protected int bqD = -1;
  private ProgressDialog e;
  private String mAudioFilePath;
  protected LocalMediaInfo mLocalMediaInfo;
  private String mVideoPath;
  protected List<a> oG = new CopyOnWriteArrayList();
  private Handler uiHandler;
  private TextView yw;
  
  public HWEditLocalVideoPlayer(@NonNull rdc paramrdc)
  {
    super(paramrdc);
    QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "HWEditLocalVideoPlayer. ENABLE_FLOW = " + this.aHn);
  }
  
  private Bitmap a(@NonNull a parama)
  {
    Object localObject3 = null;
    Object localObject1 = a.b(parama);
    if (localObject1 == null) {
      return null;
    }
    int i = this.mLocalMediaInfo.rotation;
    Object localObject2 = localObject1;
    if (i != 0) {
      localObject2 = rpq.rotateBitmap((Bitmap)localObject1, 360 - i);
    }
    amat localamat = new amat();
    localamat.init(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
    Object localObject4 = localObject3;
    if (a.a(parama))
    {
      localObject4 = localObject3;
      if (amas.lb(a.a(parama))) {
        switch (a.a(parama))
        {
        default: 
          localObject1 = null;
          localObject4 = localObject3;
          if (localObject1 != null)
          {
            ((GPUBaseFilter)localObject1).init();
            localObject3 = localamat.a((Bitmap)localObject2, (GPUBaseFilter)localObject1);
            ((GPUBaseFilter)localObject1).destroy();
            ram.b("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, filterThumbBitmap = %s", localObject3);
            localObject4 = localObject3;
            if (localObject3 != null) {
              localObject1 = localObject3;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (a.b(parama))
      {
        localObject2 = localObject1;
        if (a.c(parama) != null)
        {
          localObject4 = (amax)amas.a(106);
          if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi != 10) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi != 12)) {
            break label387;
          }
          ((amax)localObject4).i(a.c(parama), i);
        }
      }
      for (;;)
      {
        ((amax)localObject4).init();
        localObject2 = localamat.a((Bitmap)localObject1, (GPUBaseFilter)localObject4);
        ram.b("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        ((amax)localObject4).destroy();
        localObject2 = localObject1;
        if ((localObject3 != null) && (localObject3 != a.b(parama)) && (localObject3 != localObject2)) {
          ((Bitmap)localObject3).recycle();
        }
        localamat.destory();
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = rpq.rotateBitmap((Bitmap)localObject2, i);
        }
        if ((localObject1 == a.b(parama)) && (!a.a(parama)) && (!a.b(parama))) {
          break label399;
        }
        return localObject1;
        localObject1 = amas.a(7);
        break;
        localObject1 = amas.a(4);
        break;
        localObject1 = amas.a(6);
        break;
        localObject1 = amas.a(5);
        break;
        label387:
        ((amax)localObject4).ae(a.c(parama));
      }
      label399:
      return parama.cE;
      localObject1 = localObject2;
      localObject3 = localObject4;
    }
  }
  
  private ConvertIFramesRunnable a(int paramInt)
  {
    if ((Build.MODEL.equalsIgnoreCase("MX5")) || (Build.MODEL.contains("vivo X5")) || (Build.MODEL.equalsIgnoreCase("M2 Note")) || (Build.MODEL.equalsIgnoreCase("m1 metal")) || (Build.MODEL.equalsIgnoreCase("HLA Note3")) || (Build.MODEL.equalsIgnoreCase("OPPO R7")) || (Build.MODEL.equalsIgnoreCase("LON-AL00"))) {
      return new ConvertIFramesRunnable(3, 1, paramInt);
    }
    return new ConvertIFramesRunnable(30, 0, paramInt);
  }
  
  private void a(@NonNull a parama)
  {
    ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.bqD), Integer.valueOf(parama.bqJ));
    if (this.aHn)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayRange((int)a.a(parama), (int)a.b(parama));
      if (this.b.b != null) {
        this.b.b.aQ(3, "");
      }
    }
    for (;;)
    {
      this.bqD = parama.bqJ;
      return;
      if (parama.mIFrameVideoPath == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.getVideoFilePath().equalsIgnoreCase(this.mVideoPath))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.stopPlay();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(this.mVideoPath, this.mAudioFilePath);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.startPlay();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.resumePlay();
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayRange((int)a.a(parama), (int)a.b(parama));
        if (this.b.b != null) {
          this.b.b.aQ(3, acfp.m(2131707332));
        }
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.getVideoFilePath().equalsIgnoreCase(parama.mIFrameVideoPath))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.stopPlay();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(parama.mIFrameVideoPath, parama.azV);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.dMb();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.startPlay();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.resumePlay();
        }
        if (this.b.b != null) {
          this.b.b.aQ(3, "");
        }
      }
    }
  }
  
  private void bc(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.e != null) {
        btB();
      }
      for (;;)
      {
        this.yw.setText(paramString);
        if (this.e.isShowing()) {
          break;
        }
        this.e.show();
        return;
        this.e = new ReportProgressDialog(paramContext, 2131756467);
        this.e.setCancelable(false);
        this.e.getWindow().setDimAmount(0.0F);
        this.e.show();
        this.e.setContentView(2131559761);
        this.yw = ((TextView)this.e.findViewById(2131373180));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachineQQBrowserActivity", 2, "showProgressDialog error " + paramContext.getMessage());
      }
    }
  }
  
  private void btA()
  {
    if (this.aHn)
    {
      this.b.jdField_a_of_type_Rcb.tz(true);
      return;
    }
    int i = 0;
    while (i < this.oG.size())
    {
      if ((a.a((a)this.oG.get(i)) == 1) && (TextUtils.isEmpty(((a)this.oG.get(i)).mIFrameVideoPath)))
      {
        this.b.jdField_a_of_type_Rcb.tz(false);
        return;
      }
      i += 1;
    }
    this.b.jdField_a_of_type_Rcb.tz(true);
  }
  
  private void btB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "cancleProgressDailog");
    }
    try
    {
      if (this.e != null)
      {
        this.e.cancel();
        this.e = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private int eg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 3;
    case 2: 
      return 1;
    }
    return 2;
  }
  
  private int eh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 7: 
      return 7;
    case 6: 
      return 6;
    case 5: 
      return 5;
    }
    return 4;
  }
  
  private void setSpeedType(int paramInt)
  {
    paramInt = eg(paramInt);
    if (this.aHn)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.resumePlay();
    }
    for (;;)
    {
      btA();
      return;
      if ((paramInt == 3) && (this.oG.size() > 0))
      {
        a locala = (a)this.oG.get(this.bqD);
        if (locala.mIFrameVideoPath == null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.pausePlay();
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(3);
          break;
          ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
          a(locala);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.resumePlay();
    }
  }
  
  private void xg(int paramInt)
  {
    if (this.aHn)
    {
      ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable skip");
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
    {
      Object localObject;
      if (paramInt < this.oG.size())
      {
        localObject = (a)this.oG.get(paramInt);
        if ((!((a)localObject).aHs) && (TextUtils.isEmpty(((a)localObject).mIFrameVideoPath)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(((a)localObject).bqJ);
          this.uiHandler.postDelayed(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        localObject = this.oG.iterator();
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          if ((!locala.aHs) && (TextUtils.isEmpty(locala.mIFrameVideoPath)))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(locala.bqJ);
            this.uiHandler.postDelayed(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        ram.i("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
        return;
      }
      ram.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.mFrameRate), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.bqE), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.bqF));
      return;
    }
    ram.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.mFrameRate), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.bqE), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.bqF));
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    int i;
    a locala;
    if ((paramrkm.a instanceof EditTakeVideoSource))
    {
      if (this.jdField_a_of_type_Amah != null)
      {
        this.jdField_a_of_type_Amah.dJU();
        this.jdField_a_of_type_Amah = null;
      }
      i = this.oG.size();
      if (i <= 1) {
        break label264;
      }
      if (paramInt >= i) {
        break label235;
      }
      locala = (a)this.oG.get(paramInt);
      paramrkm.g.hasFragments = true;
      paramrkm.g.videoNeedRotate = false;
      paramrkm.g.videoRangeStart = ((int)a.a(locala));
      paramrkm.g.videoRangeEnd = ((int)a.b(locala));
      paramrkm.g.mIFrameVideoPath = locala.mIFrameVideoPath;
      ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : %s", locala);
    }
    for (;;)
    {
      boolean bool = rpv.a(this.mLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "landscape:" + bool + " w:" + this.mLocalMediaInfo.mediaWidth + " h:" + this.mLocalMediaInfo.mediaHeight + " r:" + this.mLocalMediaInfo.rotation);
      }
      paramrkm.g.putExtra("landscape_video", Boolean.valueOf(bool));
      return;
      label235:
      ram.w("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      label264:
      if (paramInt < i)
      {
        locala = (a)this.oG.get(paramInt);
        paramrkm.g.videoNeedRotate = false;
        paramrkm.g.mIFrameVideoPath = locala.mIFrameVideoPath;
      }
      else
      {
        ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", new Throwable(), "fragment index %d invalid, fragment count %d, again count %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.oG.size()) });
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2, float paramFloat)
  {
    float f = 1.0F - paramFloat;
    if ((f == 0.0F) || (f > 0.95F))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(eh(paramInt1));
      setSpeedType(paramInt1);
      ram.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(eh(paramInt1), eh(paramInt2), f, localEditLocalVideoSource.d.rotation);
        return;
      }
    } while (!(this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(eh(paramInt1), eh(paramInt2), f, 0);
  }
  
  public void c(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = this.b.tj();
    a locala;
    if (i < this.oG.size())
    {
      locala = (a)this.oG.get(i);
      a.a(locala, paramBitmap);
      if ((!a.b(locala)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a.a(locala, paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setMosaicFilterType(paramBitmap);
      return;
    }
  }
  
  public List<? extends rfa> ca()
  {
    return Collections.unmodifiableList(this.oG);
  }
  
  public boolean e(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      case 3: 
      default: 
        return true;
      case 1: 
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.startPlay();
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.stopPlay();
      return true;
    }
    int i;
    if (paramMessage.what == 6)
    {
      i = paramMessage.arg2;
      int j = paramMessage.arg1;
      if (i >= this.oG.size()) {
        break label167;
      }
      paramMessage = (a)this.oG.get(i);
      ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : fragment = %s", paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setColorFilterType(eh(a.a(paramMessage)));
      setSpeedType(a.a(paramMessage));
      a(paramMessage);
      xg(i);
      this.bq.removeMessages(j);
      this.bq.sendEmptyMessage(j);
    }
    for (;;)
    {
      return false;
      label167:
      ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : get invalid index=%d, video fragment count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.oG.size()) });
    }
  }
  
  public Bitmap f(int paramInt)
  {
    if (paramInt < this.oG.size()) {
      return a((a)this.oG.get(paramInt));
    }
    ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void fp(long paramLong)
    throws InterruptedException
  {
    int i = 1;
    EditVideoParams localEditVideoParams;
    Object localObject;
    int j;
    String str;
    int k;
    Intent localIntent;
    if (!this.aHo)
    {
      this.aHo = true;
      if (!anki.axK()) {
        return;
      }
      localEditVideoParams = (EditVideoParams)this.jdField_a_of_type_Rel.getActivity().getIntent().getParcelableExtra(EditVideoParams.class.getName());
      if ((localEditVideoParams != null) && (aqiw.isNetSupport(this.jdField_a_of_type_Rel.getActivity())))
      {
        localObject = localEditVideoParams.mExtra;
        int m = ((Bundle)localObject).getInt("ptv_template_kind", -999);
        j = ((Bundle)localObject).getInt("dance_machine_session_type", -999);
        str = ((Bundle)localObject).getString("dance_machine_session_uin", "");
        k = ((Bundle)localObject).getInt("dance_machine_score", 0);
        if (m == 3)
        {
          boolean bool = anhq.a().axa();
          this.jdField_a_of_type_Rel.getActivity().runOnUiThread(new HWEditLocalVideoPlayer.5(this));
          localObject = "";
          if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource)) {
            localObject = ((EditTakeVideoSource)this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).azv;
          }
          localIntent = new Intent();
          localIntent.putExtra("KEY_AUDIO_FILE_PATH", (String)localObject);
          localIntent.putExtra("KEY_VIDEO_FILE_PATH", this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath());
          localIntent.putExtra(EditVideoParams.class.getName(), localEditVideoParams);
          localIntent.putExtra("KEY_AUDIO_CHANNEL", aniq.ckG);
          localIntent.putExtra("KEY_BITRATE", aniq.dHj);
          localIntent.putExtra("KEY_AUDIO_FORMAT", aniq.mAudioFormat);
          localIntent.putExtra("KEY_SAMPLE_RATE", aniq.bth);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.cBS = true;
          if (QLog.isColorLevel()) {
            QLog.d("DIDI", 1, "enter Rank mHaveDanceRankShowed=true");
          }
          localObject = this.jdField_a_of_type_Rel.getActivity();
          if (!bool) {
            break label391;
          }
        }
      }
    }
    for (;;)
    {
      DanceMachineQQBrowserActivity.a((Activity)localObject, j, str, i, localEditVideoParams.asi, 0, k, localIntent);
      localObject = (rbw)a(rbw.class);
      if (localObject == null) {
        break;
      }
      ((rbw)localObject).setTimeStamp(paramLong / 1000000L);
      return;
      label391:
      i = 0;
    }
  }
  
  public void h(int paramInt, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i < this.oG.size())
    {
      paramMessage = (a)this.oG.get(i);
      Bitmap localBitmap = a(paramMessage);
      if ((localBitmap != null) && (localBitmap != paramMessage.cE))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.oG.set(i, paramMessage);
        ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", paramMessage);
        this.uiHandler.post(new HWEditLocalVideoPlayer.3(this, i));
      }
    }
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.cBS = false;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.dMc();
    if (QLog.isColorLevel()) {
      QLog.d("DIDI", 1, "onActivityResult mHaveDanceRankShowed=false");
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.uiHandler = new Handler();
    Object localObject;
    if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource))
    {
      localObject = (EditTakeVideoSource)this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      this.mAudioFilePath = ((EditTakeVideoSource)localObject).azv;
      this.mLocalMediaInfo = ((EditTakeVideoSource)localObject).d;
      this.mVideoPath = ((EditTakeVideoSource)localObject).sourcePath;
      bool1 = rdc.al(this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.bqp, 32768);
      boolean bool2 = VideoEnvironment.lw(7);
      ram.w("Q.qqstory.record.HWEditLocalVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label394;
      }
    }
    label394:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.aHm = bool1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView = ((NeoVideoFilterPlayView)y(2131368687));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setFilePath(this.mVideoPath, this.mAudioFilePath);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setRepeat(true);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setSpeedType(0);
      if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 10) || (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 12))
      {
        int i = rpv.getRotation(this.mVideoPath);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setRotate(i);
        if ((i == 90) || (i == 270))
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.getLayoutParams();
          EditTakeVideoSource localEditTakeVideoSource = (EditTakeVideoSource)this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
          ((RelativeLayout.LayoutParams)localObject).height = ((int)(aqgz.getWidth() * localEditTakeVideoSource.getWidth() / localEditTakeVideoSource.getHeight()));
          ((RelativeLayout.LayoutParams)localObject).addRule(13);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setDecodeListener(this);
      if (this.aHn) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setPlayListener(new rep(this));
      }
      a(rdo.class, this);
      this.b.jdField_a_of_type_Rcb.tz(false);
      this.bq.postDelayed(new HWEditLocalVideoPlayer.2(this), 200L);
      return;
      throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditTakeVideoSource now");
    }
  }
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    QLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  public void onDecodeFinish() {}
  
  public void onDecodeRepeat()
  {
    this.uiHandler.post(new HWEditLocalVideoPlayer.6(this));
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    this.uiHandler.postDelayed(new HWEditLocalVideoPlayer.4(this), 200L);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.stopPlay();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.onPause();
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.aHo = paramBundle.getBoolean("IS_FIRST_FRAME_DECODED", false);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.onResume();
    btB();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("IS_FIRST_FRAME_DECODED", this.aHo);
  }
  
  public void onStart()
  {
    super.onStart();
    this.aHl = true;
    xg(0);
  }
  
  public void onStop()
  {
    super.onStop();
    this.aHl = false;
    if (this.jdField_a_of_type_Amah != null)
    {
      this.jdField_a_of_type_Amah.dJU();
      this.jdField_a_of_type_Amah = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable != null)
    {
      this.uiHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = null;
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView == null) {
      return;
    }
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 2: 
    case 5: 
    case 9: 
    default: 
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.resumePlay();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.pausePlay();
  }
  
  public void pause()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.pausePlay();
  }
  
  public void play()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.resumePlay();
  }
  
  public void s(Bitmap paramBitmap) {}
  
  public void setPlayMode(int paramInt)
  {
    ram.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.b.tj();
    if (i < this.oG.size())
    {
      a locala = (a)this.oG.get(i);
      if (a.a(locala) != paramInt)
      {
        a.a(locala, paramInt);
        a.c(locala, true);
      }
    }
  }
  
  public void tt(boolean paramBoolean)
  {
    int i = this.b.tj();
    if (i < this.oG.size()) {
      a.b((a)this.oG.get(i), paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowNeoVideoFilterPlayView.setMuteAudio(paramBoolean);
  }
  
  public long w(int paramInt)
  {
    if (paramInt < this.oG.size())
    {
      a locala = (a)this.oG.get(paramInt);
      return a.b(locala) - a.a(locala);
    }
    ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return 0L;
  }
  
  public class ConvertIFramesRunnable
    implements Runnable
  {
    public int bqE = 1;
    public int bqF;
    public int mFrameRate = 30;
    
    ConvertIFramesRunnable(int paramInt1, int paramInt2, int paramInt3)
    {
      this.bqE = paramInt2;
      this.mFrameRate = paramInt1;
      this.bqF = paramInt3;
    }
    
    @TargetApi(17)
    public void run()
    {
      ram.w("Q.qqstory.record.HWEditLocalVideoPlayer", "start convert i frame video. mVideoPath = " + HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this));
      Object localObject1 = new MediaMetadataRetriever();
      try
      {
        ((MediaMetadataRetriever)localObject1).setDataSource(HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this));
        Object localObject2 = ((MediaMetadataRetriever)localObject1).extractMetadata(18);
        String str1 = ((MediaMetadataRetriever)localObject1).extractMetadata(19);
        String str2 = ((MediaMetadataRetriever)localObject1).extractMetadata(24);
        ((MediaMetadataRetriever)localObject1).release();
        int i;
        int j;
        int k;
        long l1;
        long l2;
        return;
      }
      catch (Exception localException)
      {
        try
        {
          i = Integer.valueOf(str2).intValue();
          j = Integer.valueOf((String)localObject2).intValue();
          k = Integer.valueOf(str1).intValue();
          HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this, new amah());
          localObject1 = HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this) + "_" + this.bqF + ".IFrames.mp4";
          if (this.bqE != 0) {
            HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this).dBg = (this.bqE * this.mFrameRate);
          }
          localObject2 = (HWEditLocalVideoPlayer.a)HWEditLocalVideoPlayer.this.oG.get(this.bqF);
          l1 = HWEditLocalVideoPlayer.a.a((HWEditLocalVideoPlayer.a)localObject2);
          l2 = HWEditLocalVideoPlayer.a.b((HWEditLocalVideoPlayer.a)localObject2);
          HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this).a(new alza(HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this), 0, false, true, l1, l2), new amae((String)localObject1, j, k, 12582912, this.bqE, this.mFrameRate, 0, false, i, null, null, null, false), new req(this, (HWEditLocalVideoPlayer.a)localObject2), new rer(this));
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "video info error, videoFilePath=" + HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this));
        }
        localException = localException;
        ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "setDataSource failed when convert i frame", localException);
        return;
      }
    }
  }
  
  public static class a
    extends rfa
  {
    private boolean aHp;
    private boolean aHq;
    private boolean aHr;
    public boolean aHs;
    public String azV;
    private Bitmap cC;
    private Bitmap cD;
    private long endTime;
    public String mIFrameVideoPath;
    private int playMode = 0;
    private long startTime;
    
    public a(int paramInt, Bitmap paramBitmap)
    {
      super(paramBitmap);
      this.cD = paramBitmap;
    }
    
    public a a(Bitmap paramBitmap)
    {
      paramBitmap = new a(this.bqJ, paramBitmap);
      paramBitmap.cD = this.cD;
      paramBitmap.startTime = this.startTime;
      paramBitmap.endTime = this.endTime;
      paramBitmap.playMode = this.playMode;
      paramBitmap.aHp = this.aHp;
      paramBitmap.cC = this.cC;
      paramBitmap.mIFrameVideoPath = this.mIFrameVideoPath;
      paramBitmap.azV = this.azV;
      this.aHq = false;
      this.aHr = false;
      this.aHs = false;
      return paramBitmap;
    }
    
    public String toString()
    {
      return "Mp4VideoFragmentInfo{index=" + this.bqJ + ", bitmap=" + this.cE + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", mRevertFailed=" + this.aHs + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */