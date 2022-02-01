import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Message;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoPlayer.3;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPFrameListener;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

@TargetApi(14)
public class yll
  extends ynu
  implements ImageViewVideoPlayer.IMPFrameListener, ImageViewVideoPlayer.IMPlayerEndListener, xkn, xlz, yoi
{
  protected int a;
  public ImageView a;
  protected TextView a;
  protected TrimTextureVideoView a;
  protected String a;
  protected ywm a;
  protected boolean a;
  protected ylo[] a;
  protected int b;
  protected boolean b;
  
  public yll(@NonNull ynw paramynw)
  {
    super(paramynw);
  }
  
  public void S_()
  {
    super.S_();
    b(false);
  }
  
  public long a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfYlo.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    ylo localylo = this.jdField_a_of_type_ArrayOfYlo[paramInt];
    return localylo.jdField_b_of_type_Int - localylo.jdField_a_of_type_Int;
  }
  
  public Bitmap a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfYlo.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    ylo localylo = this.jdField_a_of_type_ArrayOfYlo[paramInt];
    if (localylo.c.isRecycled()) {
      ykq.e("Q.qqstory.record.EditLocalVideoPlayer", "自己的bitmap被外边recycle了!");
    }
    return localylo.c;
  }
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return Bitmap.createBitmap(paramBitmap);
  }
  
  public List<? extends yqa> a()
  {
    ylo[] arrayOfylo = new ylo[this.jdField_a_of_type_ArrayOfYlo.length];
    int i = 0;
    while (i < arrayOfylo.length)
    {
      arrayOfylo[i] = ylo.a(this.jdField_a_of_type_ArrayOfYlo[i], a(this.jdField_a_of_type_ArrayOfYlo[i].c));
      i += 1;
    }
    return Arrays.asList(arrayOfylo);
  }
  
  public void a()
  {
    super.a();
    if ((!this.jdField_a_of_type_Ynw.a.isEditLocal()) || (!this.jdField_a_of_type_Ynw.a.isEditVideo())) {
      return;
    }
    Object localObject = (EditLocalVideoSource)this.jdField_a_of_type_Ynw.a.mEditSource;
    int k = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    int m = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    long l = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
    int n = this.jdField_a_of_type_Ynw.a.getExpectFragmentCount();
    this.jdField_a_of_type_ArrayOfYlo = new ylo[n];
    ykq.a("Q.qqstory.record.EditLocalVideoPlayer", "onCreate EditSource fragmentCount is %d", Integer.valueOf(n));
    int i = 0;
    int j = k;
    while (i < n)
    {
      this.jdField_a_of_type_ArrayOfYlo[i] = new ylo(i, null);
      ylo localylo = this.jdField_a_of_type_ArrayOfYlo[i];
      localylo.jdField_a_of_type_Int = j;
      localylo.jdField_b_of_type_Int = Math.min(j + 10000, m);
      if (i == n - 1) {
        localylo.jdField_b_of_type_Int = m;
      }
      j += 10000;
      i += 1;
    }
    this.jdField_a_of_type_Int = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView = ((TrimTextureVideoView)a(2131367011));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365221));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131376102));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (QQStoryFlowCallback.a != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(QQStoryFlowCallback.a);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      ykq.b("Q.qqstory.record.EditLocalVideoPlayer", "onCreate mBackgroundImage.setImageBitmap()");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setOnRecyclePlayListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setOnPreparedListener(this);
    if ((this.jdField_a_of_type_Ynw.a.mBusinessId != 10) && (this.jdField_a_of_type_Ynw.a.mBusinessId != 12)) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a(((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Ynw.a.mEditSource.getSourcePath();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setVideoPath(this.jdField_a_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_Ynw.a.getStringExtra("extra_upload_temp_directory");
      this.jdField_a_of_type_Ywm = new ywm();
      this.jdField_a_of_type_Ywm.a();
      this.jdField_a_of_type_Ywm.a(this.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_b_of_type_Boolean, 480, k, 10000, n, true, new ylm(this), new yln(this, l, m));
      ykv.a("video_edit", "edit_local", 0, 0, new String[0]);
      a(yoi.class, this);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setCenterInside(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, float paramFloat) {}
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) {
      return;
    }
    switch (paramInt)
    {
    case 10: 
    case 2: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      b(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.c();
  }
  
  public void a(int paramInt, @NonNull yya paramyya)
  {
    if ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      ykq.b("Q.qqstory.record.EditLocalVideoPlayer", "editVideoPrePublish(%d) -> %s", Integer.valueOf(paramInt), this.jdField_a_of_type_ArrayOfYlo[paramInt]);
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = this.jdField_b_of_type_Boolean;
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = this.jdField_a_of_type_ArrayOfYlo[paramInt].jdField_a_of_type_Int;
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = this.jdField_a_of_type_ArrayOfYlo[paramInt].jdField_b_of_type_Int;
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte) {}
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ArrayOfYlo[this.jdField_a_of_type_Ynw.a()].jdField_a_of_type_Boolean = paramBoolean;
    b(false);
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      default: 
        return true;
      case 1: 
        b(false);
        return true;
      case 2: 
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.c();
        return true;
      }
      b(true);
      return true;
    }
    int i;
    if (paramMessage.what == 6)
    {
      i = paramMessage.arg2;
      if ((this.jdField_a_of_type_ArrayOfYlo == null) || (i >= this.jdField_a_of_type_ArrayOfYlo.length) || (this.jdField_a_of_type_ArrayOfYlo[i].jdField_b_of_type_Boolean))
      {
        ykq.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfYlo), Integer.valueOf(i) });
        return false;
      }
      b(true);
      return true;
    }
    if (paramMessage.what == 7)
    {
      i = paramMessage.arg1;
      if ((this.jdField_a_of_type_ArrayOfYlo == null) || (i >= this.jdField_a_of_type_ArrayOfYlo.length))
      {
        ykq.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfYlo), Integer.valueOf(i) });
        return false;
      }
      this.jdField_a_of_type_ArrayOfYlo[i].jdField_b_of_type_Boolean = true;
      ykq.b("Q.qqstory.record.EditLocalVideoPlayer", "PlayerContext %d Deleted!", Integer.valueOf(i));
      return true;
    }
    return false;
  }
  
  public void a_(xlu paramxlu)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new EditLocalVideoPlayer.3(this), 300L);
    }
    ykq.a("Q.qqstory.record.EditLocalVideoPlayer", "onPrepared %s", this.jdField_a_of_type_Ynw.a.mEditSource.getSourcePath());
    this.jdField_a_of_type_Boolean = true;
    b(true);
  }
  
  public void b()
  {
    ylq localylq = (ylq)a(ylq.class);
    if (localylq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayRecycle()");
      }
      localylq.b();
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    int i = this.jdField_a_of_type_Ynw.a();
    if ((this.jdField_a_of_type_ArrayOfYlo == null) || (i >= this.jdField_a_of_type_ArrayOfYlo.length) || (this.jdField_a_of_type_ArrayOfYlo[i].jdField_b_of_type_Boolean))
    {
      ykq.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! resumePlay(%b): PlayerContext is illegal %s index=%d", new Object[] { Boolean.valueOf(paramBoolean), Arrays.toString(this.jdField_a_of_type_ArrayOfYlo), Integer.valueOf(i) });
      return;
    }
    ylo localylo = this.jdField_a_of_type_ArrayOfYlo[i];
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setPlayRange(localylo.jdField_a_of_type_Int, localylo.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.b(localylo.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.b(localylo.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a(false);
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Ywm.b();
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.c();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Ynw.a(Message.obtain(null, 8));
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.c();
  }
  
  public void i()
  {
    b(true);
  }
  
  public void onCurrentFrame(int paramInt) {}
  
  public void onDrawLastFrameEnd() {}
  
  public void onPlayerEnd() {}
  
  public void onPlayerRecyle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yll
 * JD-Core Version:    0.7.0.1
 */