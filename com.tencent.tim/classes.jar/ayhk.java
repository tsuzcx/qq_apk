import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.3;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.4;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.5;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.6;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.7;
import dov.com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer.a;
import dov.com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer.b;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.a;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class ayhk
  extends aygy
  implements ayhm, MultiBlockVideoPlayer.b, ImageViewVideoPlayer.a, ImageViewVideoPlayer.b
{
  public long BM;
  public EditRecordVideoSource a;
  public ImageViewVideoPlayer a;
  protected boolean aHh;
  protected boolean aHi;
  protected Handler bp = new Handler(ThreadManager.getFileThreadLooper());
  public float mI = 0.2F;
  public Handler mMainHandler = new Handler(Looper.getMainLooper());
  protected ImageView nj;
  public List<MultiBlockVideoPlayer.a> oD;
  
  public ayhk(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private void bti()
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.dJr == 2) || (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.dJr == 4))
    {
      ram.d("Q.qqstory.record.EditVideoPlayer", "restartPreview");
      this.aHi = false;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
      aydu localaydu = (aydu)a(aydu.class);
      if (localaydu != null) {
        localaydu.bsi();
      }
      return;
    }
    ram.w("Q.qqstory.record.EditVideoPlayer", "restartPreview but the player is not stopping : " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.dJr);
  }
  
  private void btj()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.b.a(Message.obtain(null, 8));
      return;
    }
    this.mMainHandler.post(new EditVideoPlayer.3(this));
  }
  
  private void ec(int paramInt1, int paramInt2)
  {
    float f = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.bpI * 1.0F / this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.bpH;
    ram.i("Q.qqstory.record.EditVideoPlayer", "updateVideoDrawablePlayerUI width" + paramInt1 + "heightRatio=" + f + "dst_height" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.bpI + "dst_width=" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.bpH);
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(paramInt1, paramInt2, f, false, azbx.dip2px(5.0F));
  }
  
  private void tE(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.dJr == 3)
    {
      ram.d("Q.qqstory.record.EditVideoPlayer", "pausePreview");
      this.aHi = paramBoolean;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.bsT();
      aydu localaydu = (aydu)a(aydu.class);
      if (localaydu != null) {
        localaydu.bsh();
      }
      return;
    }
    ram.w("Q.qqstory.record.EditVideoPlayer", "pausePreview but the player has not started : " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.dJr);
  }
  
  public void Nn()
  {
    ram.e("Q.qqstory.record.EditVideoPlayer", "onPlayerEnd");
  }
  
  public void No()
  {
    aydu localaydu = (aydu)a(aydu.class);
    if (localaydu != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayerRecyle2()");
      }
      localaydu.bsg();
    }
  }
  
  public void Np()
  {
    ram.d("Q.qqstory.record.EditVideoPlayer", "onDrawLastFrameEnd : mBlurLastFrame = " + this.aHi);
    Bitmap localBitmap2 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.gl;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.getCurrentBitmap();
    }
    if (localBitmap1 != null)
    {
      this.nj.setImageBitmap(localBitmap1);
      if (this.aHi) {
        Stream.of(localBitmap1).map(new ThreadOffFunction("Q.qqstory.record.EditVideoPlayer", 2)).map(new ayji(0.2F, false)).map(new ayjj(10)).map(new UIThreadOffFunction(this)).subscribe(new ayhl(this));
      }
    }
    this.nj.setVisibility(0);
  }
  
  public Bitmap a(@NonNull MultiBlockVideoPlayer.a parama)
  {
    Bitmap localBitmap = null;
    Object localObject = (aydh)a(aydh.class);
    int j;
    int i;
    if (localObject != null)
    {
      j = ((aydh)localObject).ec(parama.bqJ);
      i = ((aydh)localObject).ec(this.b.tj());
      ram.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap for %d, playModeNeeded = %d, currentPlayMode = %d", Integer.valueOf(parama.bqJ), Integer.valueOf(j), Integer.valueOf(i));
    }
    for (;;)
    {
      localObject = (aydg)a(aydg.class);
      int k;
      byte[] arrayOfByte;
      if (localObject != null)
      {
        k = ((aydg)localObject).ta();
        arrayOfByte = ((aydg)localObject).f(parama.bqJ);
      }
      for (localObject = ((aydg)localObject).f(this.b.tj());; localObject = null)
      {
        if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {}
        try
        {
          VideoSourceHelper.nativeSetPlayMode(j);
          VideoSourceHelper.nativeSetMosaic(k, arrayOfByte);
          ram.b("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap, playMode=%d, info=%s", Integer.valueOf(j), parama);
          if (j == 1)
          {
            localBitmap = ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(parama.BS - 1L, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.getWidth(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.getHeight());
            return localBitmap;
          }
          parama = ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(parama.BR, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.getWidth(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.getHeight());
          return parama;
        }
        finally
        {
          VideoSourceHelper.nativeSetPlayMode(i);
          VideoSourceHelper.nativeSetMosaic(k, (byte[])localObject);
        }
        arrayOfByte = null;
        k = 0;
      }
      i = 0;
      j = 0;
    }
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    if (!this.aHh) {
      paramayqb.g.hasFragments = false;
    }
    for (;;)
    {
      return;
      Object localObject1 = this.oD;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0))
      {
        paramayqb.g.hasFragments = false;
        return;
      }
      paramayqb.g.hasFragments = false;
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (MultiBlockVideoPlayer.a)((Iterator)localObject2).next();
        if (localObject1 == null)
        {
          ram.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish error. RecordVideoBlockInfo is null.");
        }
        else if (((MultiBlockVideoPlayer.a)localObject1).bqJ == paramInt)
        {
          paramayqb.g.hasFragments = true;
          localObject2 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject2).put("vfFrameIndexStart", ((MultiBlockVideoPlayer.a)localObject1).BR);
        ((JSONObject)localObject2).put("vfFrameIndexEnd", ((MultiBlockVideoPlayer.a)localObject1).BS);
        ((JSONObject)localObject2).put("afTimeStart", ((MultiBlockVideoPlayer.a)localObject1).BT);
        ((JSONObject)localObject2).put("afTimeEnd", ((MultiBlockVideoPlayer.a)localObject1).BU);
        paramayqb.g.fragments = ((JSONObject)localObject2).toString();
        ram.d("Q.qqstory.record.EditVideoPlayer", "fragments = %s.", paramayqb.g.fragments);
        ram.d("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish : %s", paramayqb.g.fragments);
        if (paramayqb.g.hasFragments) {
          continue;
        }
        ram.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish, can not find RecordVideoBlockInfo with fragment index %d", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void a(MultiBlockVideoPlayer.a parama)
  {
    ram.b("Q.qqstory.record.EditVideoPlayer", "updateVideoFrameBitmap info=%s", parama);
    Object localObject = a(parama);
    if (localObject != null)
    {
      Bitmap localBitmap = rop.b((Bitmap)localObject, this.mI, false);
      s((Bitmap)localObject);
      if (localBitmap != null)
      {
        localObject = new ArrayList(this.oD);
        MultiBlockVideoPlayer.a locala = (MultiBlockVideoPlayer.a)((List)localObject).get(parama.bqJ);
        ((List)localObject).set(parama.bqJ, locala.a(localBitmap));
        this.oD = ((List)localObject);
        btj();
      }
    }
  }
  
  public void aG(long paramLong, boolean paramBoolean) {}
  
  public void aH(long paramLong, boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2, float paramFloat)
  {
    VideoSourceHelper.nativeSetSlideMode(paramInt2, paramFloat);
  }
  
  public void brU() {}
  
  public void c(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public List<? extends ayjg> ca()
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer))
    {
      List localList = this.oD;
      if (localList != null)
      {
        int i = localList.size();
        if (i > 1) {}
        for (MultiBlockVideoPlayer.a locala = (MultiBlockVideoPlayer.a)localList.get(i - 1); (locala != null) && (locala.BS - locala.BR < 3L); locala = null) {
          return Collections.unmodifiableList(localList.subList(0, i - 1));
        }
        return Collections.unmodifiableList(localList);
      }
    }
    return Collections.emptyList();
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
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
        continue;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.bsT();
        continue;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.resetPlay();
      }
    }
    if ((paramMessage.what == 6) && (this.aHh))
    {
      int i = paramMessage.arg2;
      int j = paramMessage.arg1;
      if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {
        this.bp.post(new EditVideoPlayer.1(this, i, j));
      }
    }
    return false;
  }
  
  public Bitmap f(int paramInt)
  {
    if ((!this.aHh) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.record.EditVideoPlayer", 2, "generateVideoFrameBitmap enableMultiVideoFragment:" + this.aHh);
    }
    if (Looper.myLooper() == this.bp.getLooper())
    {
      localObject = this.oD;
      if ((localObject != null) && (paramInt < ((List)localObject).size())) {}
      for (localObject = (MultiBlockVideoPlayer.a)((List)localObject).get(paramInt); localObject == null; localObject = null) {
        return null;
      }
      return a((MultiBlockVideoPlayer.a)localObject);
    }
    Object localObject = new Bitmap[1];
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.bp.post(new EditVideoPlayer.4(this, paramInt, (Bitmap[])localObject, localCountDownLatch));
    try
    {
      ram.d("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap waiting ...");
      localCountDownLatch.await();
      ram.b("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap done bitmap = %s", localObject[0]);
      return localObject[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ram.e("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap error", localInterruptedException);
      }
    }
  }
  
  public int getPlayMode()
  {
    return 0;
  }
  
  public void h(int paramInt, byte[] paramArrayOfByte)
  {
    this.bp.post(new EditVideoPlayer.5(this, paramInt, paramArrayOfByte));
  }
  
  public void onCreate()
  {
    azam.ahH();
    h(0, null);
    tt(false);
    setPlayMode(0);
    MultiBlockVideoPlayer.btF();
    boolean bool1 = aygz.r(this.b.a.aCQ, 262144);
    boolean bool2 = VideoEnvironment.lw(7);
    ram.w("Q.qqstory.record.EditVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    Object localObject;
    label272:
    label290:
    String str2;
    String str1;
    if ((bool1) && (bool2))
    {
      bool1 = true;
      this.aHh = bool1;
      if (!(this.b.a.a instanceof EditRecordVideoSource)) {
        break label459;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource = ((EditRecordVideoSource)this.b.a.a);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)y(2131367267));
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(0);
      this.nj = ((ImageView)y(2131367297));
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPFrameListener(this);
      if ((this.aHh) && ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer))) {
        ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setVideoLoadListener(this);
      }
      ec(ayjd.b(getResources()), ayjd.c(getResources()));
      localObject = RMVideoStateMgr.a().a.ar();
      if (localObject == null) {
        break label481;
      }
      ram.i("Q.qqstory.record.EditVideoPlayer", "get player cover success.");
      this.nj.setImageBitmap((Bitmap)localObject);
      this.nj.setVisibility(0);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(8);
      if (!this.b.La()) {
        break label492;
      }
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setNeedPlayAudio(false);
      if (TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.sourcePath)) {
        break label555;
      }
      ram.w("Q.qqstory.record.EditVideoPlayer", "onCreate init play");
      str2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.sourcePath;
      localObject = null;
      str1 = null;
      Bundle localBundle = this.b.a.mExtra;
      if (localBundle == null) {
        break label569;
      }
      bool1 = localBundle.getBoolean("SecurityChecked", false);
      if (!bool1) {
        break label566;
      }
      localObject = localBundle.getString("AFPath");
      str1 = localBundle.getString("VFPath");
    }
    for (;;)
    {
      if (bool1)
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(aniq.dGY, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.recordTime, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.bpF, str2, (String)localObject, str1);
        label410:
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mRequireAudioFocus = false;
        ram.w("Q.qqstory.record.EditVideoPlayer", "onCreate init player, securityChecked=%s, afFilePath=%s, vfFilePath=%s", new Object[] { Boolean.valueOf(bool1), localObject, str1 });
      }
      for (;;)
      {
        a(ayhm.class, this);
        return;
        bool1 = false;
        break;
        label459:
        ram.w("Q.qqstory.record.EditVideoPlayer", "edit source type mismatch !");
        a().a(0, null, 0, 0);
        return;
        label481:
        ram.e("Q.qqstory.record.EditVideoPlayer", "get player cover return null!");
        break label272;
        label492:
        ras.BB = this.jdField_a_of_type_Ayii.getActivity().getIntent().getLongExtra("stop_record_time", 0L);
        ras.BC = System.currentTimeMillis();
        break label290;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(aniq.dGY, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.recordTime, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.bpF, str2, false);
        break label410;
        label555:
        ram.w("Q.qqstory.record.EditVideoPlayer", "onCreate init player failed !");
      }
      label566:
      continue;
      label569:
      bool1 = false;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ram.w("Q.qqstory.record.EditVideoPlayer", "onDestroy release play");
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.bsT();
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.releasePlayer();
    azam.ahI();
    MultiBlockVideoPlayer.btF();
  }
  
  public void onLoadSuccess()
  {
    if ((this.aHh) && (MultiBlockVideoPlayer.class.isInstance(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer))) {
      this.bp.post(new EditVideoPlayer.7(this));
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ram.w("Q.qqstory.record.EditVideoPlayer", "onPause stop play");
    tE(false);
    NativeVideoImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    NativeVideoImage.resumeAll();
    switch (this.b.bqq)
    {
    case 0: 
    case 2: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      bti();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    ram.w("Q.qqstory.record.EditVideoPlayer", "onStop stop play");
    tE(false);
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      bti();
    case 10: 
      return;
    }
    tE(true);
  }
  
  public void pause()
  {
    tE(false);
  }
  
  public void play()
  {
    bti();
  }
  
  public void s(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {
      ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).s(paramBitmap);
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    this.bp.post(new EditVideoPlayer.6(this, paramInt));
  }
  
  public void setTransferData(TransferData paramTransferData) {}
  
  public void setVolume(float paramFloat) {}
  
  public void tt(boolean paramBoolean)
  {
    ram.b("Q.qqstory.record.EditVideoPlayer", "setPlayMute mute = %s", Boolean.valueOf(paramBoolean));
    VideoSourceHelper.nativeSetPlayAFMute(paramBoolean);
  }
  
  public long w(int paramInt)
  {
    if (this.aHh)
    {
      Object localObject = this.oD;
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        localObject = (MultiBlockVideoPlayer.a)((List)localObject).get(paramInt);
        return ((MultiBlockVideoPlayer.a)localObject).BU - ((MultiBlockVideoPlayer.a)localObject).BT;
      }
    }
    return -1L;
  }
  
  public void wR(int paramInt)
  {
    this.nj.setVisibility(8);
    Object localObject;
    long l2;
    long l1;
    if ((paramInt == 1) && (this.BM == 0L) && (!this.b.La()))
    {
      this.BM = System.currentTimeMillis();
      localObject = QQStoryContext.a().mi();
      ras.F(this.BM, (String)localObject);
      ram.d("Q.qqstory.record.EditVideoPlayer", "onCurrentFrame:" + paramInt + ", mPreivewContentTime:" + this.BM);
      if (0L != 0L) {
        break label229;
      }
      localObject = this.b.a.mExtra;
      if (localObject == null) {
        break label229;
      }
      l2 = ((Bundle)localObject).getLong("startEditVideoTime", 0L);
      l1 = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      long l4 = l1;
      long l3 = l2;
      if (l2 == 0L)
      {
        localObject = this.jdField_a_of_type_Ayii.getActivity();
        l4 = l1;
        l3 = l2;
        if (localObject != null)
        {
          l3 = ((Activity)localObject).getIntent().getLongExtra("stop_record_time", 0L);
          l4 = System.currentTimeMillis();
        }
      }
      if (l3 != 0L) {
        rar.b("video_edit", "startEditVideoTime", this.b.tk(), 0, new String[] { String.valueOf(l4 - l3) });
      }
      return;
      label229:
      l1 = 0L;
      l2 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhk
 * JD-Core Version:    0.7.0.1
 */