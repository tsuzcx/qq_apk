import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.2;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.3;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.4;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.5;
import dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.6;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView.a;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayis
  extends aygy
  implements Handler.Callback, ayhm, HWDecodeListener, HWVideoPlayView.a
{
  protected VideoFilterPlayView a;
  public boolean aHm;
  private Handler bq = new Handler(ThreadManager.getFileThreadLooper(), this);
  protected int bqD = -1;
  final boolean dzp = true;
  boolean dzq;
  boolean dzr;
  boolean dzs;
  boolean dzt = false;
  private AtomicBoolean eR = new AtomicBoolean(false);
  private String mAudioFilePath;
  private int mEndTime;
  public LocalMediaInfo mLocalMediaInfo;
  private int mRotation;
  private int mStartTime;
  private int mState = 0;
  private String mVideoPath;
  public List<ayis.a> oG = new CopyOnWriteArrayList();
  private Handler uiHandler;
  
  public ayis(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, ayym paramayym)
  {
    if ((paramBitmap == null) || (paramayym == null)) {
      return null;
    }
    Object localObject = rpv.a(paramBitmap.getWidth(), paramBitmap.getHeight(), ankt.SCREEN_WIDTH, ankt.cIE);
    int j = ((Integer)((Pair)localObject).first).intValue();
    int k = ((Integer)((Pair)localObject).second).intValue();
    int i = ayyh.eNn;
    if (k > i) {
      j = (int)(j * i / k);
    }
    for (;;)
    {
      j = alwy.iN(j);
      i = alwy.iN(i);
      paramayym.init(j, i);
      localObject = new GaussianBlurFilter();
      ((GaussianBlurFilter)localObject).init(paramBitmap.getWidth(), paramBitmap.getHeight());
      if (((GaussianBlurFilter)localObject).isInitSucc())
      {
        paramContext = aqhu.a(paramContext, aqhu.U(paramBitmap), 0.4F, 25.0F);
        paramayym = paramContext;
        if (paramContext != null)
        {
          localCanvas = new Canvas();
          if (!paramContext.isMutable()) {
            break label205;
          }
        }
        label205:
        for (paramayym = paramContext;; paramayym = paramContext.copy(paramContext.getConfig(), true))
        {
          localCanvas.setBitmap(paramayym);
          localCanvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
          paramayym = paramContext;
          paramContext = rop.b(rop.b(paramayym, j, i, true), paramBitmap);
          ((GaussianBlurFilter)localObject).destroy();
          return paramContext;
        }
      }
      paramContext = paramBitmap.copy(paramBitmap.getConfig(), true);
      Canvas localCanvas = new Canvas();
      if (paramContext.isMutable()) {}
      for (paramayym = paramContext;; paramayym = paramContext.copy(paramContext.getConfig(), true))
      {
        localCanvas.setBitmap(paramayym);
        localCanvas.drawColor(Color.parseColor("#CC000000"), PorterDuff.Mode.SRC_OVER);
        paramayym = paramContext;
        break;
      }
      i = k;
    }
  }
  
  private Bitmap a(@NonNull ayis.a parama, boolean paramBoolean)
  {
    long l1 = 0L;
    int i = 180;
    Object localObject2 = ayis.a.a(parama);
    long l2 = this.b.iX() / 1000000L;
    Object localObject1;
    if ((l2 != 0L) && (paramBoolean))
    {
      localObject1 = ayzc.a(this.mVideoPath, this.mLocalMediaInfo, l2);
      if (localObject1 != null) {
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if (localObject2 == null) {
        return null;
      }
      ayym localayym;
      label126:
      Object localObject3;
      if (rpv.a(this.mLocalMediaInfo))
      {
        i = 0;
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = rpq.rotateBitmap((Bitmap)localObject2, i);
        }
        localayym = new ayym();
        if (!this.dzr) {
          break label500;
        }
        localObject1 = a(getContext(), (Bitmap)localObject1, localayym);
        localObject3 = awte.a(awte.eCS);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (((QQFilterRenderManager)localObject3).getBusinessOperation().hasAvOrSpecialEffect())
          {
            if (paramBoolean) {
              l1 = this.b.iX();
            }
            localObject3 = localayym.a((Bitmap)localObject1, l1);
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
        }
        if ((!ayis.a.a(parama)) || (!ayyl.lb(ayis.a.a(parama)))) {
          break label635;
        }
        switch (ayis.a.a(parama))
        {
        default: 
          localObject1 = null;
          label251:
          if (localObject1 != null)
          {
            ((GPUBaseFilter)localObject1).init();
            localObject3 = localayym.a((Bitmap)localObject2, (GPUBaseFilter)localObject1);
            ((GPUBaseFilter)localObject1).destroy();
            ram.b("Q.qqstory.record.HWEditImportVideoPlayer", "updateFragmentThumbBitmapIfNeeded, filterThumbBitmap = %s", localObject3);
            if (localObject3 != null) {
              localObject1 = localObject3;
            }
          }
          break;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (ayis.a.b(parama))
        {
          localObject2 = localObject1;
          if (ayis.a.b(parama) != null)
          {
            ayyq localayyq = (ayyq)ayyl.a(106);
            localayyq.ae(ayis.a.b(parama));
            localayyq.init();
            localObject2 = localayym.a((Bitmap)localObject1, localayyq);
            ram.b("Q.qqstory.record.HWEditImportVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", localObject2);
            if (localObject2 != null) {
              localObject1 = localObject2;
            }
            localayyq.destroy();
            localObject2 = localObject1;
          }
        }
        if ((localObject3 != null) && (localObject3 != ayis.a.a(parama)) && (localObject3 != localObject2)) {
          ((Bitmap)localObject3).recycle();
        }
        localayym.destory();
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = rpq.rotateBitmap((Bitmap)localObject2, 360 - i);
        }
        localObject2 = localObject1;
        if (this.dzs) {
          localObject2 = rpq.rotateBitmap((Bitmap)localObject1, 90.0F);
        }
        if ((localObject2 != ayis.a.a(parama)) || (ayis.a.a(parama)) || (ayis.a.b(parama)))
        {
          return localObject2;
          if (this.mLocalMediaInfo.rotation == 180) {
            break;
          }
          i = 0;
          break;
          label500:
          if (this.b.a.getBooleanExtra("is_video_forward", false))
          {
            localObject2 = this.b.a.getStringExtra("vip_forward_name");
            localObject1 = a(localayym, (Bitmap)localObject1, getContext(), getContext().getString(2131701751, new Object[] { localObject2 }));
            break label126;
          }
          localayym.init(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
          break label126;
          localObject1 = ayyl.a(7);
          break label251;
          localObject1 = ayyl.a(4);
          break label251;
          localObject1 = ayyl.a(6);
          break label251;
          localObject1 = ayyl.a(5);
          break label251;
        }
        return parama.cE;
        localObject1 = localObject2;
        continue;
        label635:
        localObject3 = null;
        localObject1 = localObject2;
      }
    }
  }
  
  public static Bitmap a(ayym paramayym, Bitmap paramBitmap, Context paramContext, String paramString)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int j = (int)(k * 16.0F / 9.0F);
    int i = ayyh.eNn;
    if (j > i) {}
    for (j = (int)(k * i / j);; j = k)
    {
      j = alwy.iN(j);
      i = alwy.iN(i);
      paramayym.init(j, i);
      paramayym = new ayza(paramContext, paramString);
      paramayym.ac(k, m, j, i);
      paramContext = new GLImage();
      paramContext.loadTextureSync(paramBitmap);
      paramBitmap = GlUtil.captureFrame(paramayym.mh(paramContext.getTexture()), j, i);
      paramayym.onSurfaceDestroy();
      return paramBitmap;
      i = j;
    }
  }
  
  private void a(@NonNull ayis.a parama)
  {
    ram.d("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayInfo，index : %d => %d", Integer.valueOf(this.bqD), Integer.valueOf(parama.bqJ));
    if (parama.mIFrameVideoPath == null)
    {
      if (!this.a.getVideoFilePath().equalsIgnoreCase(this.mVideoPath))
      {
        this.a.stopPlay();
        this.mRotation = this.a.a(this.mLocalMediaInfo);
        this.a.setFilePath(this.mVideoPath, this.mAudioFilePath, true, this.dzq, this.dzr);
        this.a.startPlay();
        this.a.resumePlay();
        this.mState = 1;
      }
      this.a.setPlayRange((int)ayis.a.a(parama), (int)ayis.a.b(parama));
      if (this.b.b != null) {
        this.b.b.aQ(3, acfp.m(2131707328));
      }
    }
    for (;;)
    {
      this.bqD = parama.bqJ;
      return;
      if (!this.a.getVideoFilePath().equalsIgnoreCase(parama.mIFrameVideoPath))
      {
        this.a.stopPlay();
        this.mRotation = this.a.a(this.mLocalMediaInfo);
        this.a.setFilePath(parama.mIFrameVideoPath, parama.azV, true, this.dzq, this.dzr);
        this.a.dMb();
        this.a.startPlay();
        this.a.resumePlay();
        this.mState = 1;
      }
      if (this.b.b != null) {
        this.b.b.aQ(3, "");
      }
    }
  }
  
  private void eRx()
  {
    int k;
    int j;
    float f;
    if ((this.b.a.asi == 14) && (this.b.a() != null) && (!this.b.a().isLandTakePicToVideo()) && ((this.b.a.a instanceof EditLocalVideoSource)))
    {
      k = ((EditLocalVideoSource)this.b.a.a).d.rotation;
      j = this.b.a.a.getWidth();
      i = this.b.a.a.getHeight();
      if ((k == 90) || (k == 270))
      {
        j = Math.min(this.b.a.a.getWidth(), this.b.a.a.getHeight());
        i = Math.max(this.b.a.a.getWidth(), this.b.a.a.getHeight());
      }
      f = j / i;
      j = ankt.SCREEN_WIDTH;
      i = ankt.cIE;
      if (ankt.bA(getContext())) {
        break label333;
      }
    }
    label333:
    for (int i = ankt.getRealHeight(getContext());; i = ankt.cIE)
    {
      k = (int)(j / f);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = j;
        localLayoutParams.height = k;
        localLayoutParams.addRule(16);
        localLayoutParams.setMargins(0, i / 2 - (int)(j / f) / 2, 0, 0);
        this.a.setLayoutParams(localLayoutParams);
      }
      QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, "adjust view size viewWidth ane viewHeight:" + j + " " + k);
      return;
    }
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
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    int i = this.oG.size();
    Object localObject;
    if (i > 1) {
      if (paramInt < i)
      {
        localObject = (ayis.a)this.oG.get(paramInt);
        paramayqb.g.hasFragments = true;
        paramayqb.g.videoNeedRotate = false;
        paramayqb.g.videoRangeStart = ((int)ayis.a.a((ayis.a)localObject));
        paramayqb.g.videoRangeEnd = ((int)ayis.a.b((ayis.a)localObject));
        ram.d("Q.qqstory.record.HWEditImportVideoPlayer", "editVideoPrePublish : %s", localObject);
      }
    }
    for (;;)
    {
      paramayqb.g.putExtra("local_import", Boolean.valueOf(true));
      paramayqb.g.putExtra("video_rotation", Integer.valueOf(this.mRotation));
      boolean bool = rpv.a(this.mLocalMediaInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "landscape:" + bool + " w:" + this.mLocalMediaInfo.mediaWidth + " h:" + this.mLocalMediaInfo.mediaHeight + " r:" + this.mLocalMediaInfo.rotation);
      }
      paramayqb.g.putExtra("landscape_video", Boolean.valueOf(bool));
      paramayqb.g.putExtra("extra_is_need_gaussion_blur", Boolean.valueOf(this.dzr));
      if (this.b.a.getBooleanExtra("is_video_forward", false))
      {
        localObject = this.b.a.getStringExtra("vip_forward_name");
        paramayqb.g.putExtra("video_forward_watermark", getContext().getString(2131701751, new Object[] { localObject }));
        paramayqb.g.putExtra("is_video_forward", Boolean.valueOf(true));
      }
      return;
      ram.w("Q.qqstory.record.HWEditImportVideoPlayer", "editVideoPrePublish : get invalid fragment index = %d, fragment count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      continue;
      if (i == 1)
      {
        localObject = (ayis.a)this.oG.get(paramInt);
        paramayqb.g.videoNeedRotate = false;
        paramayqb.g.videoRangeStart = this.mStartTime;
        paramayqb.g.videoRangeEnd = this.mEndTime;
        paramayqb.g.hwEncodeRecordVideo = true;
      }
    }
  }
  
  public void aG(long paramLong, boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.Z((int)paramLong, paramBoolean);
    }
  }
  
  public void aH(long paramLong, boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.aH((int)paramLong, paramBoolean);
    }
  }
  
  public void b(int paramInt1, int paramInt2, float paramFloat)
  {
    float f = 1.0F - paramFloat;
    if ((f == 0.0F) || (f > 0.95F))
    {
      this.a.setColorFilterType(eh(paramInt1));
      setSpeedType(paramInt1);
      ram.a("Q.qqstory.record.HWEditImportVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
    }
    do
    {
      return;
      if ((this.b.a.a instanceof EditLocalVideoSource))
      {
        EditLocalVideoSource localEditLocalVideoSource = (EditLocalVideoSource)this.b.a.a;
        this.a.setColorFilterType(eh(paramInt1), eh(paramInt2), f, localEditLocalVideoSource.d.rotation);
        return;
      }
    } while (!(this.b.a.a instanceof EditTakeVideoSource));
    this.a.setColorFilterType(eh(paramInt1), eh(paramInt2), f, 0);
  }
  
  public void b(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramBoolean) {
      if (this.a != null)
      {
        this.a.eUw();
        this.dzt = false;
        this.a.resumePlay();
        this.mState = 1;
        localaydu = (aydu)a(aydu.class);
        if (localaydu != null) {
          localaydu.bsi();
        }
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 0L, this.mRotation);
    this.a.pausePlay();
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
    ayis.a locala;
    if (i < this.oG.size())
    {
      locala = (ayis.a)this.oG.get(i);
      ayis.a.a(locala, paramBitmap);
      if ((!ayis.a.b(locala)) && (!paramBoolean)) {
        break label73;
      }
    }
    label73:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ayis.a.a(locala, paramBoolean);
      this.a.setMosaicFilterType(paramBitmap);
      return;
    }
  }
  
  public List<? extends ayjg> ca()
  {
    return Collections.unmodifiableList(this.oG);
  }
  
  public boolean dt(long paramLong)
  {
    return false;
  }
  
  protected boolean e(Message paramMessage)
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
        } while (this.a == null);
        this.a.startPlay();
        this.mState = 1;
        return true;
      }
      this.a.stopPlay();
      this.mState = 0;
      return true;
    }
    int i;
    if (paramMessage.what == 6)
    {
      i = paramMessage.arg2;
      int j = paramMessage.arg1;
      if (i >= this.oG.size()) {
        break label180;
      }
      paramMessage = (ayis.a)this.oG.get(i);
      ram.d("Q.qqstory.record.HWEditImportVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : fragment = %s", paramMessage);
      this.a.setColorFilterType(eh(ayis.a.a(paramMessage)));
      setSpeedType(ayis.a.a(paramMessage));
      a(paramMessage);
      this.bq.removeMessages(j);
      this.bq.sendEmptyMessage(j);
    }
    for (;;)
    {
      return false;
      label180:
      ram.e("Q.qqstory.record.HWEditImportVideoPlayer", "MESSAGE_PLAYING_FRAGMENT_CHANGED : get invalid index=%d, video fragment count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.oG.size()) });
    }
  }
  
  public void eRU()
  {
    if (this.mState == 2)
    {
      this.a.pausePlay();
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
      return a((ayis.a)this.oG.get(paramInt), true);
    }
    ram.e("Q.qqstory.record.HWEditImportVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public void f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if (this.a != null) {
      this.a.g(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
  }
  
  public int getPlayMode()
  {
    int i = this.b.tj();
    if (i < this.oG.size())
    {
      ayis.a locala = (ayis.a)this.oG.get(i);
      if (locala != null) {
        return ayis.a.a(locala);
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
    if (i < this.oG.size())
    {
      paramMessage = (ayis.a)this.oG.get(i);
      Bitmap localBitmap = a(paramMessage, false);
      if ((localBitmap != null) && (localBitmap != paramMessage.cE))
      {
        paramMessage = paramMessage.a(localBitmap);
        this.oG.set(i, paramMessage);
        ram.d("Q.qqstory.record.HWEditImportVideoPlayer", "update fragment bitmap : %s", paramMessage);
        l(new HWEditImportVideoPlayer.3(this, i), 0L);
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
    int j = -90;
    super.onCreate();
    this.uiHandler = new Handler();
    Object localObject;
    boolean bool1;
    if ((this.b.a.a instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.b.a.a;
      this.mAudioFilePath = ((EditLocalVideoSource)localObject).sourcePath;
      this.mLocalMediaInfo = ((EditLocalVideoSource)localObject).d;
      this.mStartTime = ((EditLocalVideoSource)localObject).startTime;
      this.mEndTime = ((EditLocalVideoSource)localObject).endTime;
      this.mVideoPath = ((EditLocalVideoSource)localObject).sourcePath;
      if ((this.mLocalMediaInfo.mediaWidth == 0) || (this.mLocalMediaInfo.mediaHeight == 0))
      {
        localObject = new azbt.a();
        azbt.a(this.mVideoPath, (azbt.a)localObject);
        this.mLocalMediaInfo.mediaWidth = localObject.mMetaData[0];
        this.mLocalMediaInfo.mediaHeight = localObject.mMetaData[1];
        this.mLocalMediaInfo.rotation = localObject.mMetaData[2];
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "LocalMediaInfo:" + this.mLocalMediaInfo.toString());
      }
      bool1 = aygz.r(this.b.a.aCQ, 262144);
      boolean bool2 = VideoEnvironment.lw(7);
      ram.w("Q.qqstory.record.HWEditImportVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label642;
      }
      bool1 = true;
      this.aHm = bool1;
      this.a = ((VideoFilterPlayView)y(2131368687));
      this.a.setVisibility(0);
      if (this.b.a.asi == 14) {
        break label647;
      }
      this.mRotation = this.a.a(this.mLocalMediaInfo);
      label334:
      this.dzq = this.b.a.getBooleanExtra("extra_is_fit_center", false);
      this.dzr = this.b.a.getBooleanExtra("extra_is_need_gaussion_blur", false);
      if (this.dzr) {
        if (!rpv.a(this.mLocalMediaInfo)) {
          break label758;
        }
      }
    }
    label476:
    label746:
    label753:
    label758:
    for (int i = -90;; i = 0)
    {
      this.a.afQ(i);
      this.a.setMediaInfo(this.mLocalMediaInfo);
      this.a.setFilePath(this.mVideoPath, this.mAudioFilePath, true, this.dzq, this.dzr);
      if (this.b.bQ != null)
      {
        localObject = (VideoStoryDataBean)this.b.bQ.getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
        if ((localObject != null) && (((VideoStoryDataBean)localObject).isLandTakePicToVideo()))
        {
          bool1 = true;
          this.dzs = bool1;
        }
      }
      else if (this.b.a.getBooleanExtra("is_video_forward", false))
      {
        if (!rpv.a(this.mLocalMediaInfo)) {
          break label753;
        }
      }
      for (i = j;; i = 0)
      {
        localObject = this.b.a.getStringExtra("vip_forward_name");
        this.a.hm(getContext().getString(2131701751, new Object[] { localObject }), i);
        this.a.setRepeat(true);
        this.a.setSpeedType(0);
        this.a.setDecodeListener(this);
        this.a.setPlayViewListener(this);
        this.mState = 0;
        this.a.setTrackerCallback(new ayit(this));
        a(ayhm.class, this);
        this.bq.postDelayed(new HWEditImportVideoPlayer.2(this), 200L);
        return;
        throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditLocalVideoSource now");
        bool1 = false;
        break;
        if (((this.b.a() != null) && (this.b.a().isLandTakePicToVideo())) || (!rpv.a(this.mLocalMediaInfo))) {
          this.mRotation = this.a.a(this.mLocalMediaInfo);
        }
        for (;;)
        {
          if (!rpv.LR()) {
            break label746;
          }
          eRx();
          QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, "adjust view size end");
          break;
          if (this.mLocalMediaInfo.rotation == 180) {
            this.mRotation = this.a.mi(180);
          }
        }
        break label334;
        bool1 = false;
        break label476;
      }
    }
  }
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    QLog.e("Q.qqstory.record.HWEditImportVideoPlayer", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  public void onDecodeFinish() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
    throws InterruptedException
  {
    this.b.om(paramLong2);
    l(new HWEditImportVideoPlayer.5(this, paramLong2), 0L);
  }
  
  public void onDecodeRepeat()
  {
    l(new HWEditImportVideoPlayer.6(this), 0L);
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    l(new HWEditImportVideoPlayer.4(this), 200L);
  }
  
  public void onDestroy()
  {
    this.a.stopPlay();
    this.mState = 0;
    this.a.setPlayViewListener(null);
    if (this.uiHandler != null) {
      this.uiHandler.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
    if ((axvu.dwO) && (this.a.dzo > 100) && (this.a.ahT > 0L))
    {
      int i = this.b.QD();
      float f = this.a.dzo / (float)this.a.ahT * 1000.0F;
      if (rar.d((int)f, 0L, 30L)) {
        rar.a("CamEditFreq", true, 0L, new String[] { String.valueOf(this.b.a.asi), String.valueOf(f), rar.bY(i), String.valueOf(this.a.dzo), String.valueOf(this.a.ahT) });
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.a.pausePlay();
    this.a.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.onResume();
    if (this.mState != 2)
    {
      this.a.resumePlay();
      return;
    }
    this.a.pausePlay();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.dzt)
    {
      this.b.eRM();
      this.dzt = false;
    }
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void p(int paramInt, Object paramObject)
  {
    if (this.a == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      }
    } while (this.dzt);
    this.a.resumePlay();
    this.mState = 1;
    return;
    this.a.pausePlay();
    this.mState = 2;
  }
  
  public void pause()
  {
    VideoFilterPlayView localVideoFilterPlayView = this.a;
    if (this.b.bqq == 42) {}
    for (boolean bool = true;; bool = false)
    {
      localVideoFilterPlayView.dCd = bool;
      this.a.pausePlay();
      this.mState = 2;
      return;
    }
  }
  
  public void play()
  {
    this.a.resumePlay();
    this.mState = 1;
  }
  
  public void s(Bitmap paramBitmap) {}
  
  public void setPlayMode(int paramInt)
  {
    ram.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(paramInt));
    int i = this.b.tj();
    if (i < this.oG.size())
    {
      ayis.a locala = (ayis.a)this.oG.get(i);
      if (ayis.a.a(locala) != paramInt)
      {
        ayis.a.a(locala, paramInt);
        ayis.a.c(locala, true);
      }
    }
  }
  
  public void setSpeedType(int paramInt)
  {
    paramInt = eg(paramInt);
    ayis.a locala;
    if ((paramInt == 5) && (this.oG.size() > 0))
    {
      locala = (ayis.a)this.oG.get(this.bqD);
      if (locala.mIFrameVideoPath == null)
      {
        this.a.pausePlay();
        this.mState = 2;
        this.a.setSpeedType(5);
      }
    }
    for (;;)
    {
      if (this.dzt)
      {
        this.b.eRM();
        this.dzt = false;
      }
      return;
      ram.d("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode change to iframe video");
      a(locala);
      break;
      this.a.setSpeedType(paramInt);
      this.a.resumePlay();
      this.mState = 1;
    }
  }
  
  public void setTransferData(TransferData paramTransferData)
  {
    if (this.a != null) {
      this.a.setTransferData(paramTransferData);
    }
  }
  
  public void setVolume(float paramFloat)
  {
    this.a.setVolume(paramFloat);
  }
  
  public void tt(boolean paramBoolean)
  {
    int i = this.b.tj();
    if (i < this.oG.size()) {
      ayis.a.b((ayis.a)this.oG.get(i), paramBoolean);
    }
    this.a.setMuteAudio(paramBoolean);
  }
  
  public long w(int paramInt)
  {
    if (paramInt < this.oG.size())
    {
      ayis.a locala = (ayis.a)this.oG.get(paramInt);
      return ayis.a.b(locala) - ayis.a.a(locala);
    }
    ram.e("Q.qqstory.record.HWEditImportVideoPlayer", "getDurationOfFragment with invalid index = %d", new Object[] { Integer.valueOf(paramInt) });
    return 0L;
  }
  
  public static class a
    extends ayjg
  {
    private boolean aHp;
    private boolean aHq;
    private boolean aHr;
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
      return paramBitmap;
    }
    
    public String toString()
    {
      return "Mp4VideoFragmentInfo{index=" + this.bqJ + ", bitmap=" + this.cE + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayis
 * JD-Core Version:    0.7.0.1
 */