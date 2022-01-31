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

public class vhz
  extends vhn
  implements axmh, axmi, vib, vjl
{
  public float a;
  public long a;
  protected Handler a;
  protected ImageView a;
  public EditRecordVideoSource a;
  public ImageViewVideoPlayer a;
  public List<vjk> a;
  protected boolean a;
  public Handler b;
  protected boolean b;
  
  public vhz(@NonNull vhp paramvhp)
  {
    super(paramvhp);
    this.jdField_a_of_type_Float = 0.2F;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    float f = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.d * 1.0F / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_c_of_type_Int;
    veg.c("Q.qqstory.record.EditVideoPlayer", "updateVideoDrawablePlayerUI width" + paramInt1 + "heightRatio=" + f + "dst_height" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.d + "dst_width=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(paramInt1, paramInt2, f, false, axli.a(5.0F));
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 3)
    {
      veg.b("Q.qqstory.record.EditVideoPlayer", "pausePreview");
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
      vfi localvfi = (vfi)a(vfi.class);
      if (localvfi != null) {
        localvfi.Z_();
      }
      return;
    }
    veg.d("Q.qqstory.record.EditVideoPlayer", "pausePreview but the player has not started : " + this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int);
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 4))
    {
      veg.b("Q.qqstory.record.EditVideoPlayer", "restartPreview");
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
      vfi localvfi = (vfi)a(vfi.class);
      if (localvfi != null) {
        localvfi.f();
      }
      return;
    }
    veg.d("Q.qqstory.record.EditVideoPlayer", "restartPreview but the player is not stopping : " + this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int);
  }
  
  private void n()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.jdField_a_of_type_Vhp.a(Message.obtain(null, 8));
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new EditVideoPlayer.3(this));
  }
  
  public void V_()
  {
    super.V_();
    NativeVideoImage.resumeAll();
    switch (this.jdField_a_of_type_Vhp.b)
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
  
  public void W_()
  {
    veg.e("Q.qqstory.record.EditVideoPlayer", "onPlayerEnd");
  }
  
  public void X_()
  {
    super.X_();
    veg.d("Q.qqstory.record.EditVideoPlayer", "onStop stop play");
    b(false);
  }
  
  public long a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        localObject = (vjk)((List)localObject).get(paramInt);
        return ((vjk)localObject).d - ((vjk)localObject).jdField_c_of_type_Long;
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
      for (localObject = (vjk)((List)localObject).get(paramInt); localObject == null; localObject = null) {
        return null;
      }
      return a((vjk)localObject);
    }
    Object localObject = new Bitmap[1];
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.4(this, paramInt, (Bitmap[])localObject, localCountDownLatch));
    try
    {
      veg.b("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap waiting ...");
      localCountDownLatch.await();
      veg.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap done bitmap = %s", localObject[0]);
      return localObject[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        veg.c("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap error", localInterruptedException);
      }
    }
  }
  
  public Bitmap a(@NonNull vjk paramvjk)
  {
    Bitmap localBitmap = null;
    Object localObject = (vev)a(vev.class);
    int j;
    int i;
    if (localObject != null)
    {
      j = ((vev)localObject).a(paramvjk.jdField_c_of_type_Int);
      i = ((vev)localObject).a(this.jdField_a_of_type_Vhp.a());
      veg.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap for %d, playModeNeeded = %d, currentPlayMode = %d", Integer.valueOf(paramvjk.jdField_c_of_type_Int), Integer.valueOf(j), Integer.valueOf(i));
    }
    for (;;)
    {
      localObject = (veu)a(veu.class);
      int k;
      byte[] arrayOfByte;
      if (localObject != null)
      {
        k = ((veu)localObject).a();
        arrayOfByte = ((veu)localObject).a(paramvjk.jdField_c_of_type_Int);
      }
      for (localObject = ((veu)localObject).a(this.jdField_a_of_type_Vhp.a());; localObject = null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {}
        try
        {
          VideoSourceHelper.nativeSetPlayMode(j);
          VideoSourceHelper.nativeSetMosaic(k, arrayOfByte);
          veg.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap, playMode=%d, info=%s", Integer.valueOf(j), paramvjk);
          if (j == 1)
          {
            localBitmap = ((MultiBlockVideoPlayer)this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramvjk.b - 1L, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.b());
            return localBitmap;
          }
          paramvjk = ((MultiBlockVideoPlayer)this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramvjk.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.b());
          return paramvjk;
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
  
  public List<? extends vju> a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer))
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      if (localList != null)
      {
        int i = localList.size();
        if (i > 1) {}
        for (vjk localvjk = (vjk)localList.get(i - 1); (localvjk != null) && (localvjk.b - localvjk.jdField_a_of_type_Long < 11L); localvjk = null) {
          return Collections.unmodifiableList(localList.subList(0, i - 1));
        }
        return Collections.unmodifiableList(localList);
      }
    }
    return Collections.emptyList();
  }
  
  public void a()
  {
    axgg.a();
    a(0, null);
    a(false);
    b(0);
    MultiBlockVideoPlayer.a();
    boolean bool1 = vhp.a(this.jdField_a_of_type_Vhp.a.b, 32768);
    boolean bool2 = VideoEnvironment.b(7);
    veg.d("Q.qqstory.record.EditVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    Object localObject;
    label272:
    label290:
    String str2;
    String str1;
    if ((bool1) && (bool2))
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (!(this.jdField_a_of_type_Vhp.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) {
        break label459;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource = ((EditRecordVideoSource)this.jdField_a_of_type_Vhp.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)a(2131366413));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131366443));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPFrameListener(this);
      if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer))) {
        ((MultiBlockVideoPlayer)this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setVideoLoadListener(this);
      }
      a(vjr.a(a()), vjr.b(a()));
      localObject = RMVideoStateMgr.a().a.a();
      if (localObject == null) {
        break label481;
      }
      veg.c("Q.qqstory.record.EditVideoPlayer", "get player cover success.");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(8);
      if (!this.jdField_a_of_type_Vhp.a()) {
        break label492;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setNeedPlayAudio(false);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_JavaLangString)) {
        break label555;
      }
      veg.d("Q.qqstory.record.EditVideoPlayer", "onCreate init play");
      str2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_JavaLangString;
      localObject = null;
      str1 = null;
      Bundle localBundle = this.jdField_a_of_type_Vhp.a.jdField_a_of_type_AndroidOsBundle;
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
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(axik.jdField_c_of_type_Int, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Int, str2, (String)localObject, str1);
        label410:
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_b_of_type_Boolean = false;
        veg.d("Q.qqstory.record.EditVideoPlayer", "onCreate init player, securityChecked=%s, afFilePath=%s, vfFilePath=%s", new Object[] { Boolean.valueOf(bool1), localObject, str1 });
      }
      for (;;)
      {
        a(vib.class, this);
        return;
        bool1 = false;
        break;
        label459:
        veg.d("Q.qqstory.record.EditVideoPlayer", "edit source type mismatch !");
        a().a(0, null, 0, 0);
        return;
        label481:
        veg.e("Q.qqstory.record.EditVideoPlayer", "get player cover return null!");
        break label272;
        label492:
        vem.jdField_a_of_type_Long = this.jdField_a_of_type_Vja.getActivity().getIntent().getLongExtra("stop_record_time", 0L);
        vem.b = System.currentTimeMillis();
        break label290;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(axik.jdField_c_of_type_Int, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Int, str2, false);
        break label410;
        label555:
        veg.d("Q.qqstory.record.EditVideoPlayer", "onCreate init player failed !");
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
    if ((paramInt == 1) && (this.jdField_a_of_type_Long == 0L) && (!this.jdField_a_of_type_Vhp.a()))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localObject = QQStoryContext.a().a();
      vem.a(this.jdField_a_of_type_Long, (String)localObject);
      veg.b("Q.qqstory.record.EditVideoPlayer", "onCurrentFrame:" + paramInt + ", mPreivewContentTime:" + this.jdField_a_of_type_Long);
      if (0L != 0L) {
        break label229;
      }
      localObject = this.jdField_a_of_type_Vhp.a.jdField_a_of_type_AndroidOsBundle;
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
        localObject = this.jdField_a_of_type_Vja.getActivity();
        l4 = l1;
        l3 = l2;
        if (localObject != null)
        {
          l3 = ((Activity)localObject).getIntent().getLongExtra("stop_record_time", 0L);
          l4 = System.currentTimeMillis();
        }
      }
      if (l3 != 0L) {
        vel.b("video_edit", "startEditVideoTime", this.jdField_a_of_type_Vhp.b(), 0, new String[] { String.valueOf(l4 - l3) });
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
  
  public void a(int paramInt, @NonNull vsd paramvsd)
  {
    super.a(paramInt, paramvsd);
    if (!this.jdField_a_of_type_Boolean) {
      paramvsd.a.hasFragments = false;
    }
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_JavaUtilList;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0))
      {
        paramvsd.a.hasFragments = false;
        return;
      }
      paramvsd.a.hasFragments = false;
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (vjk)((Iterator)localObject2).next();
        if (localObject1 == null)
        {
          veg.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish error. RecordVideoBlockInfo is null.");
        }
        else if (((vjk)localObject1).jdField_c_of_type_Int == paramInt)
        {
          paramvsd.a.hasFragments = true;
          localObject2 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject2).put("vfFrameIndexStart", ((vjk)localObject1).jdField_a_of_type_Long);
        ((JSONObject)localObject2).put("vfFrameIndexEnd", ((vjk)localObject1).b);
        ((JSONObject)localObject2).put("afTimeStart", ((vjk)localObject1).jdField_c_of_type_Long);
        ((JSONObject)localObject2).put("afTimeEnd", ((vjk)localObject1).d);
        paramvsd.a.fragments = ((JSONObject)localObject2).toString();
        veg.b("Q.qqstory.record.EditVideoPlayer", "fragments = %s.", paramvsd.a.fragments);
        veg.b("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish : %s", paramvsd.a.fragments);
        if (paramvsd.a.hasFragments) {
          continue;
        }
        veg.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish, can not find RecordVideoBlockInfo with fragment index %d", new Object[] { Integer.valueOf(paramInt) });
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
  
  public void a(vjk paramvjk)
  {
    veg.a("Q.qqstory.record.EditVideoPlayer", "updateVideoFrameBitmap info=%s", paramvjk);
    Object localObject = a(paramvjk);
    if (localObject != null)
    {
      Bitmap localBitmap = vxy.a((Bitmap)localObject, this.jdField_a_of_type_Float, false);
      a((Bitmap)localObject);
      if (localBitmap != null)
      {
        localObject = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        vjk localvjk = (vjk)((List)localObject).get(paramvjk.jdField_c_of_type_Int);
        ((List)localObject).set(paramvjk.jdField_c_of_type_Int, localvjk.a(localBitmap));
        this.jdField_a_of_type_JavaUtilList = ((List)localObject);
        n();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    veg.a("Q.qqstory.record.EditVideoPlayer", "setPlayMute mute = %s", Boolean.valueOf(paramBoolean));
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
    veg.d("Q.qqstory.record.EditVideoPlayer", "onDestroy release play");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.e();
    axgg.b();
    MultiBlockVideoPlayer.a();
  }
  
  public void f()
  {
    vfi localvfi = (vfi)a(vfi.class);
    if (localvfi != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayerRecyle2()");
      }
      localvfi.b();
    }
  }
  
  public void g()
  {
    veg.b("Q.qqstory.record.EditVideoPlayer", "onDrawLastFrameEnd : mBlurLastFrame = " + this.jdField_b_of_type_Boolean);
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsBitmap;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
    }
    if (localBitmap1 != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
      if (this.jdField_b_of_type_Boolean) {
        Stream.of(localBitmap1).map(new ThreadOffFunction("Q.qqstory.record.EditVideoPlayer", 2)).map(new vkd(0.2F, false)).map(new vke(10)).map(new UIThreadOffFunction(this)).subscribe(new via(this));
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void h()
  {
    super.h();
    veg.d("Q.qqstory.record.EditVideoPlayer", "onPause stop play");
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
 * Qualified Name:     vhz
 * JD-Core Version:    0.7.0.1
 */