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
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayer.1;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayer.3;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayer.4;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayer.5;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayer.6;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayer.7;
import com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class uvd
  extends uur
  implements awni, awnj, uvf, uwp
{
  public float a;
  public long a;
  protected Handler a;
  protected ImageView a;
  public EditRecordVideoSource a;
  public ImageViewVideoPlayer a;
  public List<uwo> a;
  protected boolean a;
  public Handler b;
  protected boolean b;
  
  public uvd(@NonNull uut paramuut)
  {
    super(paramuut);
    this.jdField_a_of_type_Float = 0.2F;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    float f = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.d * 1.0F / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_c_of_type_Int;
    urk.c("Q.qqstory.record.EditVideoPlayer", "updateVideoDrawablePlayerUI width" + paramInt1 + "heightRatio=" + f + "dst_height" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.d + "dst_width=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(paramInt1, paramInt2, f, false, awmc.a(5.0F));
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 3)
    {
      urk.b("Q.qqstory.record.EditVideoPlayer", "pausePreview");
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
      usm localusm = (usm)a(usm.class);
      if (localusm != null) {
        localusm.ab_();
      }
      return;
    }
    urk.d("Q.qqstory.record.EditVideoPlayer", "pausePreview but the player has not started : " + this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int);
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 4))
    {
      urk.b("Q.qqstory.record.EditVideoPlayer", "restartPreview");
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
      usm localusm = (usm)a(usm.class);
      if (localusm != null) {
        localusm.f();
      }
      return;
    }
    urk.d("Q.qqstory.record.EditVideoPlayer", "restartPreview but the player is not stopping : " + this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int);
  }
  
  private void n()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.jdField_a_of_type_Uut.a(Message.obtain(null, 8));
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new EditVideoPlayer.3(this));
  }
  
  public void X_()
  {
    super.X_();
    NativeVideoImage.resumeAll();
    switch (this.jdField_a_of_type_Uut.b)
    {
    case 0: 
    case 2: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      m();
    }
  }
  
  public void Y_()
  {
    urk.e("Q.qqstory.record.EditVideoPlayer", "onPlayerEnd");
  }
  
  public void Z_()
  {
    super.Z_();
    urk.d("Q.qqstory.record.EditVideoPlayer", "onStop stop play");
    b(false);
  }
  
  public long a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        localObject = (uwo)((List)localObject).get(paramInt);
        return ((uwo)localObject).d - ((uwo)localObject).jdField_c_of_type_Long;
      }
    }
    return -1L;
  }
  
  public Bitmap a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("not supported while EditVideoParams.ENABLE_MULTI_VIDEO_FRAGMENT is off");
    }
    if (Looper.myLooper() == this.jdField_a_of_type_AndroidOsHandler.getLooper())
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (paramInt < ((List)localObject).size())) {}
      for (localObject = (uwo)((List)localObject).get(paramInt); localObject == null; localObject = null) {
        return null;
      }
      return a((uwo)localObject);
    }
    Object localObject = new Bitmap[1];
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.4(this, paramInt, (Bitmap[])localObject, localCountDownLatch));
    try
    {
      urk.b("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap waiting ...");
      localCountDownLatch.await();
      urk.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap done bitmap = %s", localObject[0]);
      return localObject[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        urk.c("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap error", localInterruptedException);
      }
    }
  }
  
  public Bitmap a(@NonNull uwo paramuwo)
  {
    Bitmap localBitmap = null;
    Object localObject = (urz)a(urz.class);
    int j;
    int i;
    if (localObject != null)
    {
      j = ((urz)localObject).a(paramuwo.jdField_c_of_type_Int);
      i = ((urz)localObject).a(this.jdField_a_of_type_Uut.a());
      urk.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap for %d, playModeNeeded = %d, currentPlayMode = %d", Integer.valueOf(paramuwo.jdField_c_of_type_Int), Integer.valueOf(j), Integer.valueOf(i));
    }
    for (;;)
    {
      localObject = (ury)a(ury.class);
      int k;
      byte[] arrayOfByte;
      if (localObject != null)
      {
        k = ((ury)localObject).a();
        arrayOfByte = ((ury)localObject).a(paramuwo.jdField_c_of_type_Int);
      }
      for (localObject = ((ury)localObject).a(this.jdField_a_of_type_Uut.a());; localObject = null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {}
        try
        {
          VideoSourceHelper.nativeSetPlayMode(j);
          VideoSourceHelper.nativeSetMosaic(k, arrayOfByte);
          urk.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap, playMode=%d, info=%s", Integer.valueOf(j), paramuwo);
          if (j == 1)
          {
            localBitmap = ((MultiBlockVideoPlayer)this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramuwo.b - 1L, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.b());
            return localBitmap;
          }
          paramuwo = ((MultiBlockVideoPlayer)this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramuwo.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.b());
          return paramuwo;
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
  
  public List<? extends uwy> a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer))
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      if (localList != null)
      {
        int i = localList.size();
        if (i > 1) {}
        for (uwo localuwo = (uwo)localList.get(i - 1); (localuwo != null) && (localuwo.b - localuwo.jdField_a_of_type_Long < 11L); localuwo = null) {
          return Collections.unmodifiableList(localList.subList(0, i - 1));
        }
        return Collections.unmodifiableList(localList);
      }
    }
    return Collections.emptyList();
  }
  
  public void a()
  {
    awha.a();
    a(0, null);
    a(false);
    b(0);
    MultiBlockVideoPlayer.a();
    boolean bool1 = uut.a(this.jdField_a_of_type_Uut.a.b, 32768);
    boolean bool2 = VideoEnvironment.b(7);
    urk.d("Q.qqstory.record.EditVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    Object localObject;
    label272:
    label290:
    String str2;
    String str1;
    if ((bool1) && (bool2))
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (!(this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) {
        break label459;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource = ((EditRecordVideoSource)this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)a(2131300803));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131300833));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPFrameListener(this);
      if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer))) {
        ((MultiBlockVideoPlayer)this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setVideoLoadListener(this);
      }
      a(uwv.a(a()), uwv.b(a()));
      localObject = RMVideoStateMgr.a().a.a();
      if (localObject == null) {
        break label481;
      }
      urk.c("Q.qqstory.record.EditVideoPlayer", "get player cover success.");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(8);
      if (!this.jdField_a_of_type_Uut.a()) {
        break label492;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setNeedPlayAudio(false);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_JavaLangString)) {
        break label555;
      }
      urk.d("Q.qqstory.record.EditVideoPlayer", "onCreate init play");
      str2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_JavaLangString;
      localObject = null;
      str1 = null;
      Bundle localBundle = this.jdField_a_of_type_Uut.a.jdField_a_of_type_AndroidOsBundle;
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
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(awje.jdField_c_of_type_Int, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Int, str2, (String)localObject, str1);
        label410:
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_b_of_type_Boolean = false;
        urk.d("Q.qqstory.record.EditVideoPlayer", "onCreate init player, securityChecked=%s, afFilePath=%s, vfFilePath=%s", new Object[] { Boolean.valueOf(bool1), localObject, str1 });
      }
      for (;;)
      {
        a(uvf.class, this);
        return;
        bool1 = false;
        break;
        label459:
        urk.d("Q.qqstory.record.EditVideoPlayer", "edit source type mismatch !");
        a().a(0, null, 0, 0);
        return;
        label481:
        urk.e("Q.qqstory.record.EditVideoPlayer", "get player cover return null!");
        break label272;
        label492:
        urq.jdField_a_of_type_Long = this.jdField_a_of_type_Uwe.getActivity().getIntent().getLongExtra("stop_record_time", 0L);
        urq.b = System.currentTimeMillis();
        break label290;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(awje.jdField_c_of_type_Int, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Int, str2, false);
        break label410;
        label555:
        urk.d("Q.qqstory.record.EditVideoPlayer", "onCreate init player failed !");
      }
      label566:
      continue;
      label569:
      bool1 = false;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject;
    long l2;
    long l1;
    if ((paramInt == 1) && (this.jdField_a_of_type_Long == 0L) && (!this.jdField_a_of_type_Uut.a()))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localObject = QQStoryContext.a().a();
      urq.a(this.jdField_a_of_type_Long, (String)localObject);
      urk.b("Q.qqstory.record.EditVideoPlayer", "onCurrentFrame:" + paramInt + ", mPreivewContentTime:" + this.jdField_a_of_type_Long);
      if (0L != 0L) {
        break label229;
      }
      localObject = this.jdField_a_of_type_Uut.a.jdField_a_of_type_AndroidOsBundle;
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
        localObject = this.jdField_a_of_type_Uwe.getActivity();
        l4 = l1;
        l3 = l2;
        if (localObject != null)
        {
          l3 = ((Activity)localObject).getIntent().getLongExtra("stop_record_time", 0L);
          l4 = System.currentTimeMillis();
        }
      }
      if (l3 != 0L) {
        urp.b("video_edit", "startEditVideoTime", this.jdField_a_of_type_Uut.b(), 0, new String[] { String.valueOf(l4 - l3) });
      }
      return;
      label229:
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    VideoSourceHelper.nativeSetSlideMode(paramInt2, paramFloat);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    case 2: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      m();
    case 10: 
      return;
    }
    b(true);
  }
  
  public void a(int paramInt, @NonNull vfh paramvfh)
  {
    super.a(paramInt, paramvfh);
    if (!this.jdField_a_of_type_Boolean) {
      paramvfh.a.hasFragments = false;
    }
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_JavaUtilList;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0))
      {
        paramvfh.a.hasFragments = false;
        return;
      }
      paramvfh.a.hasFragments = false;
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (uwo)((Iterator)localObject2).next();
        if (localObject1 == null)
        {
          urk.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish error. RecordVideoBlockInfo is null.");
        }
        else if (((uwo)localObject1).jdField_c_of_type_Int == paramInt)
        {
          paramvfh.a.hasFragments = true;
          localObject2 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject2).put("vfFrameIndexStart", ((uwo)localObject1).jdField_a_of_type_Long);
        ((JSONObject)localObject2).put("vfFrameIndexEnd", ((uwo)localObject1).b);
        ((JSONObject)localObject2).put("afTimeStart", ((uwo)localObject1).jdField_c_of_type_Long);
        ((JSONObject)localObject2).put("afTimeEnd", ((uwo)localObject1).d);
        paramvfh.a.fragments = ((JSONObject)localObject2).toString();
        urk.b("Q.qqstory.record.EditVideoPlayer", "fragments = %s.", paramvfh.a.fragments);
        urk.b("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish : %s", paramvfh.a.fragments);
        if (paramvfh.a.hasFragments) {
          continue;
        }
        urk.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish, can not find RecordVideoBlockInfo with fragment index %d", new Object[] { Integer.valueOf(paramInt) });
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
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.5(this, paramInt, paramArrayOfByte));
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {
      ((MultiBlockVideoPlayer)this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(uwo paramuwo)
  {
    urk.a("Q.qqstory.record.EditVideoPlayer", "updateVideoFrameBitmap info=%s", paramuwo);
    Object localObject = a(paramuwo);
    if (localObject != null)
    {
      Bitmap localBitmap = vlc.a((Bitmap)localObject, this.jdField_a_of_type_Float, false);
      a((Bitmap)localObject);
      if (localBitmap != null)
      {
        localObject = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        uwo localuwo = (uwo)((List)localObject).get(paramuwo.jdField_c_of_type_Int);
        ((List)localObject).set(paramuwo.jdField_c_of_type_Int, localuwo.a(localBitmap));
        this.jdField_a_of_type_JavaUtilList = ((List)localObject);
        n();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    urk.a("Q.qqstory.record.EditVideoPlayer", "setPlayMute mute = %s", Boolean.valueOf(paramBoolean));
    VideoSourceHelper.nativeSetPlayAFMute(paramBoolean);
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.d();
      }
    }
    if ((paramMessage.what == 6) && (this.jdField_a_of_type_Boolean))
    {
      int i = paramMessage.arg2;
      int j = paramMessage.arg1;
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {
        this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.1(this, i, j));
      }
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.6(this, paramInt));
  }
  
  public void d()
  {
    super.d();
    urk.d("Q.qqstory.record.EditVideoPlayer", "onDestroy release play");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.e();
    awha.b();
    MultiBlockVideoPlayer.a();
  }
  
  public void f()
  {
    usm localusm = (usm)a(usm.class);
    if (localusm != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayerRecyle2()");
      }
      localusm.b();
    }
  }
  
  public void g()
  {
    urk.b("Q.qqstory.record.EditVideoPlayer", "onDrawLastFrameEnd : mBlurLastFrame = " + this.jdField_b_of_type_Boolean);
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsBitmap;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
    }
    if (localBitmap1 != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
      if (this.jdField_b_of_type_Boolean) {
        Stream.of(localBitmap1).map(new ThreadOffFunction("Q.qqstory.record.EditVideoPlayer", 2)).map(new uxh(0.2F, false)).map(new uxi(10)).map(new UIThreadOffFunction(this)).subscribe(new uve(this));
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void h()
  {
    super.h();
    urk.d("Q.qqstory.record.EditVideoPlayer", "onPause stop play");
    b(false);
    NativeVideoImage.pauseAll();
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_Boolean) && (MultiBlockVideoPlayer.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer))) {
      this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.7(this));
    }
  }
  
  public void j()
  {
    b(false);
  }
  
  public void k()
  {
    m();
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvd
 * JD-Core Version:    0.7.0.1
 */