package dov.com.tencent.biz.qqstory.takevideo;

import acfp;
import amae;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import ankt;
import aqhq;
import awte;
import axov;
import axro;
import axvu;
import aydu;
import ayfr;
import aygy;
import aygz;
import ayhm;
import ayiu;
import ayiv;
import ayjg;
import ayqb;
import ayyj;
import ayyl;
import ayym;
import ayyq;
import ayyt;
import ayyy;
import ayzc;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView.a;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import ram;
import rar;
import rpq;
import rpv;

public class HWEditLocalVideoPlayer
  extends aygy
  implements Handler.Callback, ayhm, HWDecodeListener, HWVideoPlayView.a
{
  private FollowCaptureParam jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam;
  private ConvertIFramesRunnable jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable;
  protected VideoFilterPlayView a;
  private long aCS;
  private boolean aHl = true;
  protected boolean aHm;
  private Handler bq = new Handler(ThreadManager.getFileThreadLooper(), this);
  protected int bqD;
  private ayyj c;
  private String cXc;
  private String cXd;
  boolean dzt = false;
  private boolean dzu;
  boolean dzv = false;
  private AtomicBoolean eR = new AtomicBoolean(false);
  private String mAudioFilePath;
  protected LocalMediaInfo mLocalMediaInfo;
  private int mState = 0;
  private String mVideoPath;
  protected List<a> oG = new CopyOnWriteArrayList();
  private Runnable runnable = new HWEditLocalVideoPlayer.4(this);
  private Handler uiHandler;
  
  public HWEditLocalVideoPlayer(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private Bitmap a(@NonNull a parama, boolean paramBoolean)
  {
    Object localObject1 = a.a(parama);
    long l = this.b.iX() / 1000000L;
    Object localObject2;
    if ((l != 0L) && (paramBoolean))
    {
      localObject2 = ayzc.a(this.mVideoPath, this.mLocalMediaInfo, l);
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        return null;
      }
      int k = this.mLocalMediaInfo.rotation;
      if (k != 0) {}
      for (localObject2 = rpq.rotateBitmap((Bitmap)localObject1, 360 - k);; localObject2 = localObject1)
      {
        ayym localayym = new ayym();
        int j = ((Bitmap)localObject2).getWidth();
        int i = ((Bitmap)localObject2).getHeight();
        if (this.dzu)
        {
          localObject1 = rpv.a(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), ankt.SCREEN_WIDTH, ankt.cIE);
          j = ((Integer)((Pair)localObject1).first).intValue();
          i = ((Integer)((Pair)localObject1).second).intValue();
        }
        localayym.init(j, i);
        localObject1 = localObject2;
        if (this.dzu) {
          localObject1 = ac((Bitmap)localObject2);
        }
        QQFilterRenderManager localQQFilterRenderManager = awte.a(awte.eCS);
        localObject2 = localObject1;
        Object localObject3;
        if (localQQFilterRenderManager != null)
        {
          localObject2 = localObject1;
          if (localQQFilterRenderManager.getBusinessOperation().hasAvOrSpecialEffect())
          {
            if (!paramBoolean) {
              break label626;
            }
            l = this.b.iX();
            localObject3 = localayym.a((Bitmap)localObject1, l);
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
        }
        if ((a.a(parama)) && (ayyl.lb(a.a(parama)))) {
          switch (a.a(parama))
          {
          default: 
            localObject1 = null;
            label315:
            if (localObject1 != null)
            {
              ((GPUBaseFilter)localObject1).init();
              localObject3 = localayym.a((Bitmap)localObject2, (GPUBaseFilter)localObject1);
              ((GPUBaseFilter)localObject1).destroy();
              ram.b("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, filterThumbBitmap = %s", localObject3);
              if (localObject3 != null)
              {
                localObject2 = localObject3;
                localObject1 = localObject3;
              }
            }
            break;
          }
        }
        for (;;)
        {
          localObject3 = localObject1;
          if (a.b(parama))
          {
            localObject3 = localObject1;
            if (a.b(parama) != null)
            {
              ayyq localayyq = (ayyq)ayyl.a(106);
              localayyq.ae(a.b(parama));
              localayyq.init();
              localObject3 = localayym.a((Bitmap)localObject1, localayyq);
              ram.b("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject3);
              if (localObject3 != null) {
                localObject1 = localObject3;
              }
              localayyq.destroy();
              localObject3 = localObject1;
            }
          }
          if ((localObject2 != null) && (localObject2 != a.a(parama)) && (localObject2 != localObject3)) {
            ((Bitmap)localObject2).recycle();
          }
          if ((localQQFilterRenderManager != null) && (localQQFilterRenderManager.hasQQFilter(183)))
          {
            localObject1 = (PKFilter)localQQFilterRenderManager.getQQFilters(183).get(0);
            localObject2 = new ayyt(((PKFilter)localObject1).getPKCoverPath(), ((PKFilter)localObject1).getPKTitleBmgPath());
            ((ayyt)localObject2).onOutputSizeChanged(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
            ((ayyt)localObject2).init();
            localObject1 = localayym.a((Bitmap)localObject3, (GPUBaseFilter)localObject2);
            ((ayyt)localObject2).destroy();
            ram.w("Q.qqstory.record.HWEditLocalVideoPlayer", "handle pk video video cover.");
            if (localObject1 == null) {}
          }
          for (;;)
          {
            localayym.destory();
            localObject2 = localObject1;
            if (k != 0) {
              localObject2 = rpq.rotateBitmap((Bitmap)localObject1, k);
            }
            if ((localObject2 != a.a(parama)) || (a.a(parama)) || (a.b(parama)))
            {
              return localObject2;
              label626:
              l = 0L;
              break;
              localObject1 = ayyl.a(7);
              break label315;
              localObject1 = ayyl.a(4);
              break label315;
              localObject1 = ayyl.a(6);
              break label315;
              localObject1 = ayyl.a(5);
              break label315;
            }
            return parama.cE;
            localObject1 = localObject3;
          }
          localObject1 = localObject2;
          localObject2 = localObject3;
          continue;
          localObject1 = localObject2;
          localObject2 = null;
        }
      }
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
    if (parama.mIFrameVideoPath == null)
    {
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.getVideoFilePath().equalsIgnoreCase(this.mVideoPath))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.stopPlay();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.mVideoPath, this.mAudioFilePath);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.startPlay();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.resumePlay();
        this.mState = 1;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayRange((int)a.a(parama), (int)a.b(parama));
      if (this.b.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.b.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.aQ(3, acfp.m(2131707333));
      }
    }
    for (;;)
    {
      this.bqD = parama.bqJ;
      return;
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.getVideoFilePath().equalsIgnoreCase(parama.mIFrameVideoPath))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.stopPlay();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(parama.mIFrameVideoPath, parama.azV);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.dMb();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.startPlay();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.resumePlay();
        this.mState = 1;
      }
      if (this.b.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        this.b.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.aQ(3, "");
      }
    }
  }
  
  private Bitmap ac(Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null)
    {
      localObject = rpv.a(paramBitmap.getWidth(), paramBitmap.getHeight(), ankt.SCREEN_WIDTH, ankt.cIE);
      ayyy localayyy = new ayyy();
      localayyy.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam);
      localayyy.setVideoSize(paramBitmap.getWidth(), paramBitmap.getHeight());
      localayyy.onSurfaceCreate();
      localayyy.onSurfaceChange(((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      GLImage localGLImage = new GLImage();
      localGLImage.loadTextureSync(paramBitmap);
      localayyy.setInputTextureID(localGLImage.getTexture());
      localayyy.onDrawFrame();
      localObject = GlUtil.captureFrame(localayyy.getOutputTextureID(), ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
      localayyy.onSurfaceDestroy();
    }
    return localObject;
  }
  
  private void btA()
  {
    int i = 0;
    if (i < this.oG.size()) {
      if ((a.a((a)this.oG.get(i)) == 1) && (TextUtils.isEmpty(((a)this.oG.get(i)).mIFrameVideoPath)))
      {
        this.b.Zo(false);
        if (this.b.jdField_b_of_type_Ayfr != null) {
          this.b.jdField_b_of_type_Ayfr.setEnable(false);
        }
      }
    }
    do
    {
      do
      {
        return;
        i += 1;
        break;
      } while (!this.eR.compareAndSet(true, true));
      this.b.Zo(true);
    } while (this.b.jdField_b_of_type_Ayfr == null);
    this.b.jdField_b_of_type_Ayfr.setEnable(true);
  }
  
  private int eg(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0;
    case 1: 
      return 5;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 8: 
      return 3;
    }
    return 4;
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
  
  private void xg(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
    {
      Object localObject;
      if (paramInt < this.oG.size())
      {
        localObject = (a)this.oG.get(paramInt);
        if ((!((a)localObject).aHs) && (TextUtils.isEmpty(((a)localObject).mIFrameVideoPath)))
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(((a)localObject).bqJ);
          this.bq.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
        }
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        localObject = this.oG.iterator();
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          if ((!locala.aHs) && (TextUtils.isEmpty(locala.mIFrameVideoPath)))
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = a(locala.bqJ);
            this.bq.postDelayed(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable, 300L);
          }
        }
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable == null)
      {
        ram.i("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
        return;
      }
      ram.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.mFrameRate), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.bqE), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.bqF));
      return;
    }
    ram.b("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.mFrameRate), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.bqE), Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable.bqF));
  }
  
  public String Iq()
  {
    return this.cXd;
  }
  
  public int RU()
  {
    return this.mState;
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    int i;
    a locala;
    if ((paramayqb.a instanceof EditTakeVideoSource))
    {
      if (this.c != null)
      {
        this.c.dJU();
        this.c = null;
      }
      i = this.oG.size();
      if (i <= 1) {
        break label380;
      }
      if (paramInt >= i) {
        break label351;
      }
      locala = (a)this.oG.get(paramInt);
      paramayqb.g.hasFragments = true;
      paramayqb.g.videoNeedRotate = false;
      paramayqb.g.videoRangeStart = ((int)a.a(locala));
      paramayqb.g.videoRangeEnd = ((int)a.b(locala));
      paramayqb.g.mIFrameVideoPath = locala.mIFrameVideoPath;
      ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : %s", locala);
    }
    for (;;)
    {
      boolean bool = rpv.a(this.mLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "landscape:" + bool + " w:" + this.mLocalMediaInfo.mediaWidth + " h:" + this.mLocalMediaInfo.mediaHeight + " r:" + this.mLocalMediaInfo.rotation);
      }
      paramayqb.g.putExtra("landscape_video", Boolean.valueOf(bool));
      paramayqb.g.putExtra("is_follow_capture_video", Boolean.valueOf(this.dzu));
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null)
      {
        paramayqb.g.putExtra("follow_capture_param", FollowCaptureParam.parseToJson(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam));
        paramayqb.g.putExtra("video_type", Integer.valueOf(5));
        paramayqb = rpv.a(this.mLocalMediaInfo.mediaWidth, this.mLocalMediaInfo.mediaHeight, ankt.SCREEN_WIDTH, ankt.cIE);
        this.mLocalMediaInfo.mediaWidth = ((Integer)paramayqb.first).intValue();
        this.mLocalMediaInfo.mediaHeight = ((Integer)paramayqb.second).intValue();
      }
      return;
      label351:
      ram.w("Q.qqstory.record.HWEditLocalVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      label380:
      if (i == 1)
      {
        locala = (a)this.oG.get(paramInt);
        paramayqb.g.videoNeedRotate = false;
        paramayqb.g.mIFrameVideoPath = locala.mIFrameVideoPath;
      }
    }
  }
  
  public void aG(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.Z((int)paramLong, paramBoolean);
    }
  }
  
  public void aH(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.aH((int)paramLong, paramBoolean);
    }
  }
  
  public LocalMediaInfo b()
  {
    return this.mLocalMediaInfo;
  }
  
  public void b(int paramInt1, int paramInt2, float paramFloat)
  {
    float f = 1.0F - paramFloat;
    if ((f == 0.0F) || (f > 0.95F))
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(eh(paramInt1));
      setSpeedType(paramInt1);
      ram.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.b.a.a instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.b.a.a;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(eh(paramInt1), eh(paramInt2), f, localEditLocalVideoSource.d.rotation);
        return;
      }
    } while (!(this.b.a.a instanceof EditTakeVideoSource));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(eh(paramInt1), eh(paramInt2), f, 0);
  }
  
  public void b(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      this.dzv = bool;
      if (!paramBoolean) {
        break label84;
      }
      this.aCS = 0L;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.eUw();
        this.dzt = false;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.resumePlay();
        this.mState = 1;
        localaydu = (aydu)a(aydu.class);
        if (localaydu != null) {
          localaydu.bsi();
        }
      }
    }
    label84:
    while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null)
    {
      return;
      bool = false;
      break;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 0L, 0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.pausePlay();
    this.mState = 2;
    aydu localaydu = (aydu)a(aydu.class);
    if (localaydu != null) {
      localaydu.bsh();
    }
    this.dzt = true;
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
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMosaicFilterType(paramBitmap);
      return;
    }
  }
  
  public List<? extends ayjg> ca()
  {
    return Collections.unmodifiableList(this.oG);
  }
  
  public boolean dt(long paramLong)
  {
    if ((this.oG != null) && (this.oG.size() > 0))
    {
      a locala = (a)this.oG.get(this.bqD);
      if ((locala != null) && (locala.mIFrameVideoPath != null))
      {
        if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) && (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.getVideoFilePath().equalsIgnoreCase(locala.mIFrameVideoPath)))
        {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.stopPlay();
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(locala.mIFrameVideoPath, locala.azV);
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.dMb();
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.startPlay();
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.pausePlay();
          if (paramLong >= 0L) {
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.Z((int)paramLong, true);
          }
          if (this.mState != 2) {
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.resumePlay();
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean e(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      case 3: 
      default: 
      case 1: 
        do
        {
          return true;
        } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.startPlay();
        this.mState = 1;
        return true;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.stopPlay();
      this.mState = 0;
      return true;
    }
    int i;
    if (paramMessage.what == 6)
    {
      i = paramMessage.arg2;
      int j = paramMessage.arg1;
      if (i >= this.oG.size()) {
        break label184;
      }
      paramMessage = (a)this.oG.get(i);
      ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : fragment = %s", paramMessage);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setColorFilterType(eh(a.a(paramMessage)));
      setSpeedType(a.a(paramMessage));
      a(paramMessage);
      xg(i);
      this.bq.removeMessages(j);
      this.bq.sendEmptyMessage(j);
    }
    for (;;)
    {
      return false;
      label184:
      ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : get invalid index=%d, video fragment count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.oG.size()) });
    }
  }
  
  public void eRU()
  {
    if (this.mState == 2)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.pausePlay();
      return;
    }
    this.mState = 1;
  }
  
  public void eRV()
  {
    this.mState = 0;
  }
  
  public Bitmap f(int paramInt)
  {
    if (paramInt < this.oG.size()) {
      return a((a)this.oG.get(paramInt), true);
    }
    ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.g(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
  }
  
  public int getPlayMode()
  {
    int i = this.b.tj();
    if (i < this.oG.size())
    {
      a locala = (a)this.oG.get(i);
      if (locala != null) {
        return a.a(locala);
      }
    }
    return 0;
  }
  
  public void h(int paramInt, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i >= 0) && (i < this.oG.size()))
    {
      paramMessage = (a)this.oG.get(i);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.cE))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.oG.set(i, paramMessage);
        ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", paramMessage);
        l(new HWEditLocalVideoPlayer.3(this, i), 0L);
      }
    }
    return true;
  }
  
  public void l(Runnable paramRunnable, long paramLong)
  {
    if (this.uiHandler != null)
    {
      if (paramLong != 0L) {
        this.uiHandler.postDelayed(paramRunnable, paramLong);
      }
    }
    else {
      return;
    }
    this.uiHandler.post(paramRunnable);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.uiHandler = new Handler();
    if ((this.b.a.a instanceof EditTakeVideoSource))
    {
      Object localObject = (EditTakeVideoSource)this.b.a.a;
      this.mAudioFilePath = ((EditTakeVideoSource)localObject).azv;
      this.mLocalMediaInfo = ((EditTakeVideoSource)localObject).d;
      this.mVideoPath = ((EditTakeVideoSource)localObject).sourcePath;
      this.cXc = ((EditTakeVideoSource)localObject).cWQ;
      if ((!TextUtils.isEmpty(this.mAudioFilePath)) && (this.mAudioFilePath.endsWith(".mp3")))
      {
        localObject = (axro)axov.a().c(8);
        MusicItemInfo localMusicItemInfo = MusicProviderView.a(this.mAudioFilePath);
        if (localMusicItemInfo != null)
        {
          ((axro)localObject).a(localMusicItemInfo);
          localObject = Image2Video.ROOT_PATH + "/noaudio";
          aqhq.UD((String)localObject);
          this.mAudioFilePath = ((String)localObject);
        }
      }
      bool1 = aygz.r(this.b.a.aCQ, 262144);
      boolean bool2 = VideoEnvironment.lw(7);
      ram.w("Q.qqstory.record.HWEditLocalVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label511;
      }
      bool1 = true;
      this.aHm = bool1;
      if (this.b.a.mExtra != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam = ((FollowCaptureParam)this.b.a.mExtra.getSerializable("extra_follow_capture_param"));
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam == null) {
          break label516;
        }
      }
    }
    label516:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.dzu = bool1;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView = ((VideoFilterPlayView)y(2131368687));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFollowCaptureVideo(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setVisibility(0);
      if (this.b.a.getIntExtra("story_game_capture_type", 1) == 2) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setStoryGamePaths(this.b.a.getStringExtra("game_pk_video_path"), this.b.a.getStringExtra("game_pk_cover_path"), this.b.a.getStringExtra("game_pk_result_path"));
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setBgmFilePath(this.cXc);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMediaInfo(this.mLocalMediaInfo);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setFilePath(this.mVideoPath, this.mAudioFilePath);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setRepeat(true);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setDecodeListener(this);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(this);
      this.mState = 0;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setTrackerCallback(new ayiu(this));
      a(ayhm.class, this);
      this.b.Zo(false);
      this.bq.postDelayed(new HWEditLocalVideoPlayer.2(this), 200L);
      return;
      throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditTakeVideoSource now");
      label511:
      bool1 = false;
      break;
    }
  }
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    QLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  public void onDecodeFinish() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
    throws InterruptedException
  {
    if (this.dzv) {
      this.aCS = paramLong1;
    }
    this.b.om(paramLong2);
    l(new HWEditLocalVideoPlayer.5(this, paramLong2), 0L);
  }
  
  public void onDecodeRepeat()
  {
    if (this.mState != 2) {
      l(new HWEditLocalVideoPlayer.6(this), 0L);
    }
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    if ((this.mState != 2) && (this.uiHandler != null))
    {
      this.uiHandler.removeCallbacks(this.runnable);
      l(this.runnable, 200L);
    }
  }
  
  public void onDestroy()
  {
    if (this.uiHandler != null)
    {
      this.uiHandler.removeCallbacksAndMessages(null);
      this.uiHandler = null;
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.stopPlay();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onDestroy();
      this.mState = 0;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setPlayViewListener(null);
    }
    super.onDestroy();
    if ((axvu.dwO) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.dzo > 100) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.ahT > 0L))
    {
      int i = this.b.QD();
      float f = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.dzo / (float)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.ahT * 1000.0F;
      if (rar.d((int)f, 0L, 30L)) {
        rar.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.b.a.asi), String.valueOf(f), rar.bY(i), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.dzo), String.valueOf(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.ahT) });
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.pausePlay();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.onResume();
    if (this.mState != 2) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.resumePlay();
    }
    for (;;)
    {
      this.dzv = false;
      return;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.pausePlay();
    }
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
    if (this.c != null)
    {
      this.c.dJU();
      this.c = null;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable != null)
    {
      this.uiHandler.removeCallbacks(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$ConvertIFramesRunnable = null;
    }
    if (this.dzt)
    {
      this.b.eRM();
      this.dzt = false;
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      }
    } while (this.dzt);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.resumePlay();
    this.mState = 1;
    return;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.pausePlay();
    this.mState = 2;
  }
  
  public void pause()
  {
    VideoFilterPlayView localVideoFilterPlayView = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView;
    if (this.b.bqq == 42) {}
    for (boolean bool = true;; bool = false)
    {
      localVideoFilterPlayView.dCd = bool;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.pausePlay();
      this.mState = 2;
      return;
    }
  }
  
  public void play()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.resumePlay();
    this.mState = 1;
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
  
  public void setSpeedType(int paramInt)
  {
    paramInt = eg(paramInt);
    a locala;
    if ((paramInt == 5) && (this.oG.size() > 0))
    {
      locala = (a)this.oG.get(this.bqD);
      if (locala.mIFrameVideoPath == null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.pausePlay();
        this.mState = 2;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(5);
      }
    }
    for (;;)
    {
      if (this.dzt)
      {
        this.b.eRM();
        this.dzt = false;
      }
      btA();
      return;
      ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
      a(locala);
      break;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setSpeedType(paramInt);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.resumePlay();
      this.mState = 1;
    }
  }
  
  public void setTransferData(TransferData paramTransferData)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setTransferData(paramTransferData);
    }
  }
  
  public void setVolume(float paramFloat)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setVolume(paramFloat);
  }
  
  public void tt(boolean paramBoolean)
  {
    int i = this.b.tj();
    if (i < this.oG.size()) {
      a.b((a)this.oG.get(i), paramBoolean);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView.setMuteAudio(paramBoolean);
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
      String str2;
      try
      {
        ((MediaMetadataRetriever)localObject1).setDataSource(HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this));
        String str1 = ((MediaMetadataRetriever)localObject1).extractMetadata(18);
        str2 = ((MediaMetadataRetriever)localObject1).extractMetadata(19);
        localObject2 = ((MediaMetadataRetriever)localObject1).extractMetadata(24);
        ((MediaMetadataRetriever)localObject1).release();
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
          return;
        }
      }
      catch (Exception localException)
      {
        ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "setDataSource failed when convert i frame", localException);
        ((MediaMetadataRetriever)localObject1).release();
        return;
      }
      int i = 0;
      try
      {
        int j = Integer.valueOf((String)localObject2).intValue();
        i = j;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          long l1;
          long l2;
          localThrowable.printStackTrace();
        }
      }
      HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this, new ayyj());
      localObject1 = HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this) + "_" + this.bqF + ".IFrames.mp4";
      if (this.bqE != 0) {
        HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this).dBg = (this.bqE * this.mFrameRate);
      }
      Object localObject2 = (HWEditLocalVideoPlayer.a)HWEditLocalVideoPlayer.this.oG.get(this.bqF);
      l1 = HWEditLocalVideoPlayer.a.a((HWEditLocalVideoPlayer.a)localObject2);
      l2 = HWEditLocalVideoPlayer.a.b((HWEditLocalVideoPlayer.a)localObject2);
      HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this).a(new DecodeConfig(HWEditLocalVideoPlayer.a(HWEditLocalVideoPlayer.this), 0, false, true, l1, l2), new amae((String)localObject1, Integer.valueOf(localException).intValue(), Integer.valueOf(str2).intValue(), 12582912, this.bqE, this.mFrameRate, 0, false, i, null, null, null, false), new ayiv(this, (HWEditLocalVideoPlayer.a)localObject2), null);
    }
  }
  
  public static class a
    extends ayjg
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */