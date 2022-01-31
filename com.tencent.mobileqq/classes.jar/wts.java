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
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

@TargetApi(14)
public class wts
  extends wwc
  implements azhp, azhq, vss, vue, wwq
{
  protected int a;
  public ImageView a;
  protected TextView a;
  protected TrimTextureVideoView a;
  protected String a;
  protected xfe a;
  protected boolean a;
  protected wtv[] a;
  protected int b;
  protected boolean b;
  
  public wts(@NonNull wwe paramwwe)
  {
    super(paramwwe);
  }
  
  public long a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfWtv.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    wtv localwtv = this.jdField_a_of_type_ArrayOfWtv[paramInt];
    return localwtv.jdField_b_of_type_Int - localwtv.jdField_a_of_type_Int;
  }
  
  public Bitmap a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfWtv.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    wtv localwtv = this.jdField_a_of_type_ArrayOfWtv[paramInt];
    if (localwtv.c.isRecycled()) {
      wsv.e("Q.qqstory.record.EditLocalVideoPlayer", "自己的bitmap被外边recycle了!");
    }
    return localwtv.c;
  }
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return Bitmap.createBitmap(paramBitmap);
  }
  
  public List<? extends wyj> a()
  {
    wtv[] arrayOfwtv = new wtv[this.jdField_a_of_type_ArrayOfWtv.length];
    int i = 0;
    while (i < arrayOfwtv.length)
    {
      arrayOfwtv[i] = wtv.a(this.jdField_a_of_type_ArrayOfWtv[i], a(this.jdField_a_of_type_ArrayOfWtv[i].c));
      i += 1;
    }
    return Arrays.asList(arrayOfwtv);
  }
  
  public void a()
  {
    super.a();
    if ((!this.jdField_a_of_type_Wwe.a.d()) || (!this.jdField_a_of_type_Wwe.a.b())) {
      return;
    }
    Object localObject = (EditLocalVideoSource)this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    int k = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    int m = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    long l = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
    int n = this.jdField_a_of_type_Wwe.a.c();
    this.jdField_a_of_type_ArrayOfWtv = new wtv[n];
    wsv.a("Q.qqstory.record.EditLocalVideoPlayer", "onCreate EditSource fragmentCount is %d", Integer.valueOf(n));
    int i = 0;
    int j = k;
    while (i < n)
    {
      this.jdField_a_of_type_ArrayOfWtv[i] = new wtv(i, null);
      wtv localwtv = this.jdField_a_of_type_ArrayOfWtv[i];
      localwtv.jdField_a_of_type_Int = j;
      localwtv.jdField_b_of_type_Int = Math.min(j + 10000, m);
      if (i == n - 1) {
        localwtv.jdField_b_of_type_Int = m;
      }
      j += 10000;
      i += 1;
    }
    this.jdField_a_of_type_Int = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView = ((TrimTextureVideoView)a(2131366547));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364829));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131375171));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (QQStoryFlowCallback.a != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(QQStoryFlowCallback.a);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      wsv.b("Q.qqstory.record.EditLocalVideoPlayer", "onCreate mBackgroundImage.setImageBitmap()");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setOnRecyclePlayListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setOnPreparedListener(this);
    if ((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int != 12)) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a(((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setVideoPath(this.jdField_a_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_Wwe.a.a("extra_upload_temp_directory");
      this.jdField_a_of_type_Xfe = new xfe();
      this.jdField_a_of_type_Xfe.a();
      this.jdField_a_of_type_Xfe.a(this.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_b_of_type_Boolean, 480, k, 10000, n, true, new wtt(this), new wtu(this, l, m));
      wta.a("video_edit", "edit_local", 0, 0, new String[0]);
      a(wwq.class, this);
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
  
  public void a(int paramInt, @NonNull xgs paramxgs)
  {
    if ((paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      wsv.b("Q.qqstory.record.EditLocalVideoPlayer", "editVideoPrePublish(%d) -> %s", Integer.valueOf(paramInt), this.jdField_a_of_type_ArrayOfWtv[paramInt]);
      paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = this.jdField_b_of_type_Boolean;
      paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = this.jdField_a_of_type_ArrayOfWtv[paramInt].jdField_a_of_type_Int;
      paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = this.jdField_a_of_type_ArrayOfWtv[paramInt].jdField_b_of_type_Int;
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte) {}
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ArrayOfWtv[this.jdField_a_of_type_Wwe.a()].jdField_a_of_type_Boolean = paramBoolean;
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
      if ((this.jdField_a_of_type_ArrayOfWtv == null) || (i >= this.jdField_a_of_type_ArrayOfWtv.length) || (this.jdField_a_of_type_ArrayOfWtv[i].jdField_b_of_type_Boolean))
      {
        wsv.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfWtv), Integer.valueOf(i) });
        return false;
      }
      b(true);
      return true;
    }
    if (paramMessage.what == 7)
    {
      i = paramMessage.arg1;
      if ((this.jdField_a_of_type_ArrayOfWtv == null) || (i >= this.jdField_a_of_type_ArrayOfWtv.length))
      {
        wsv.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfWtv), Integer.valueOf(i) });
        return false;
      }
      this.jdField_a_of_type_ArrayOfWtv[i].jdField_b_of_type_Boolean = true;
      wsv.b("Q.qqstory.record.EditLocalVideoPlayer", "PlayerContext %d Deleted!", Integer.valueOf(i));
      return true;
    }
    return false;
  }
  
  public void a_(vtz paramvtz)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new EditLocalVideoPlayer.3(this), 300L);
    }
    wsv.a("Q.qqstory.record.EditLocalVideoPlayer", "onPrepared %s", this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    this.jdField_a_of_type_Boolean = true;
    b(true);
  }
  
  public void ad_()
  {
    super.ad_();
    b(false);
  }
  
  public void ae_() {}
  
  public void b()
  {
    wtx localwtx = (wtx)a(wtx.class);
    if (localwtx != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayRecycle()");
      }
      localwtx.b();
    }
  }
  
  public void b(int paramInt) {}
  
  protected void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    int i = this.jdField_a_of_type_Wwe.a();
    if ((this.jdField_a_of_type_ArrayOfWtv == null) || (i >= this.jdField_a_of_type_ArrayOfWtv.length) || (this.jdField_a_of_type_ArrayOfWtv[i].jdField_b_of_type_Boolean))
    {
      wsv.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! resumePlay(%b): PlayerContext is illegal %s index=%d", new Object[] { Boolean.valueOf(paramBoolean), Arrays.toString(this.jdField_a_of_type_ArrayOfWtv), Integer.valueOf(i) });
      return;
    }
    wtv localwtv = this.jdField_a_of_type_ArrayOfWtv[i];
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setPlayRange(localwtv.jdField_a_of_type_Int, localwtv.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.b(localwtv.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.b(localwtv.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a(false);
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Xfe.b();
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.c();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Wwe.a(Message.obtain(null, 8));
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.c();
  }
  
  public void k()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wts
 * JD-Core Version:    0.7.0.1
 */