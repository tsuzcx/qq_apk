import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Message;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.a;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoPlayer.3;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.a;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.b;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

@TargetApi(14)
public class rbh
  extends rdb
  implements TrimTextureVideoView.a, ImageViewVideoPlayer.a, ImageViewVideoPlayer.b, qmc.e, rdo
{
  protected TrimTextureVideoView a;
  protected rjm a;
  protected rbh.a[] a;
  protected boolean aGA;
  protected boolean aGB;
  public ImageView jg;
  protected int mEndTime;
  protected int mStartTime;
  protected String mVideoPath;
  protected TextView yc;
  
  public rbh(@NonNull rdc paramrdc)
  {
    super(paramrdc);
  }
  
  protected Bitmap A(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return Bitmap.createBitmap(paramBitmap);
  }
  
  public void Nn() {}
  
  public void No() {}
  
  public void Np() {}
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    if ((paramrkm.a instanceof EditLocalVideoSource))
    {
      paramrkm.g.hasFragments = true;
      ram.d("Q.qqstory.record.EditLocalVideoPlayer", "editVideoPrePublish(%d) -> %s", Integer.valueOf(paramInt), this.jdField_a_of_type_ArrayOfRbh$a[paramInt]);
      paramrkm.g.videoNeedRotate = this.aGB;
      paramrkm.g.videoRangeStart = this.jdField_a_of_type_ArrayOfRbh$a[paramInt].startTime;
      paramrkm.g.videoRangeEnd = this.jdField_a_of_type_ArrayOfRbh$a[paramInt].endTime;
    }
  }
  
  public void a(qmc paramqmc)
  {
    if (this.jg != null) {
      this.jg.postDelayed(new EditLocalVideoPlayer.3(this), 300L);
    }
    ram.b("Q.qqstory.record.EditLocalVideoPlayer", "onPrepared %s", this.b.a.a.getSourcePath());
    this.aGA = true;
    sJ(true);
  }
  
  public void b(int paramInt1, int paramInt2, float paramFloat) {}
  
  public void boS()
  {
    rbl localrbl = (rbl)a(rbl.class);
    if (localrbl != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayRecycle()");
      }
      localrbl.bsg();
    }
  }
  
  public void bsf()
  {
    this.b.a(Message.obtain(null, 8));
  }
  
  public void c(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public List<? extends rfa> ca()
  {
    rbh.a[] arrayOfa = new rbh.a[this.jdField_a_of_type_ArrayOfRbh$a.length];
    int i = 0;
    while (i < arrayOfa.length)
    {
      arrayOfa[i] = rbh.a.a(this.jdField_a_of_type_ArrayOfRbh$a[i], A(this.jdField_a_of_type_ArrayOfRbh$a[i].cE));
      i += 1;
    }
    return Arrays.asList(arrayOfa);
  }
  
  protected boolean e(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      default: 
        return true;
      case 1: 
        sJ(false);
        return true;
      case 2: 
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.pausePlay();
        return true;
      }
      sJ(true);
      return true;
    }
    int i;
    if (paramMessage.what == 6)
    {
      i = paramMessage.arg2;
      if ((this.jdField_a_of_type_ArrayOfRbh$a == null) || (i >= this.jdField_a_of_type_ArrayOfRbh$a.length) || (this.jdField_a_of_type_ArrayOfRbh$a[i].isDeleted))
      {
        ram.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfRbh$a), Integer.valueOf(i) });
        return false;
      }
      sJ(true);
      return true;
    }
    if (paramMessage.what == 7)
    {
      i = paramMessage.arg1;
      if ((this.jdField_a_of_type_ArrayOfRbh$a == null) || (i >= this.jdField_a_of_type_ArrayOfRbh$a.length))
      {
        ram.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfRbh$a), Integer.valueOf(i) });
        return false;
      }
      this.jdField_a_of_type_ArrayOfRbh$a[i].isDeleted = true;
      ram.d("Q.qqstory.record.EditLocalVideoPlayer", "PlayerContext %d Deleted!", Integer.valueOf(i));
      return true;
    }
    return false;
  }
  
  public Bitmap f(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfRbh$a.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    rbh.a locala = this.jdField_a_of_type_ArrayOfRbh$a[paramInt];
    if (locala.cE.isRecycled()) {
      ram.e("Q.qqstory.record.EditLocalVideoPlayer", "自己的bitmap被外边recycle了!");
    }
    return locala.cE;
  }
  
  public void h(int paramInt, byte[] paramArrayOfByte) {}
  
  public void onCreate()
  {
    super.onCreate();
    if ((!this.b.a.Ld()) || (!this.b.a.Lb())) {
      return;
    }
    Object localObject = (EditLocalVideoSource)this.b.a.a;
    int k = ((EditLocalVideoSource)localObject).startTime;
    int m = ((EditLocalVideoSource)localObject).endTime;
    long l = ((EditLocalVideoSource)localObject).d.mDuration;
    int n = this.b.a.ti();
    this.jdField_a_of_type_ArrayOfRbh$a = new rbh.a[n];
    ram.b("Q.qqstory.record.EditLocalVideoPlayer", "onCreate EditSource fragmentCount is %d", Integer.valueOf(n));
    int i = 0;
    int j = k;
    while (i < n)
    {
      this.jdField_a_of_type_ArrayOfRbh$a[i] = new rbh.a(i, null);
      rbh.a locala = this.jdField_a_of_type_ArrayOfRbh$a[i];
      locala.startTime = j;
      locala.endTime = Math.min(j + 10000, m);
      if (i == n - 1) {
        locala.endTime = m;
      }
      j += 10000;
      i += 1;
    }
    this.mStartTime = ((EditLocalVideoSource)localObject).startTime;
    this.mEndTime = ((EditLocalVideoSource)localObject).endTime;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView = ((TrimTextureVideoView)y(2131367295));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setVisibility(0);
    this.yc = ((TextView)y(2131365426));
    this.yc.setEnabled(false);
    this.jg = ((ImageView)y(2131376633));
    this.jg.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (QQStoryFlowCallback.ev != null)
    {
      this.jg.setImageBitmap(QQStoryFlowCallback.ev);
      this.jg.setVisibility(0);
      ram.d("Q.qqstory.record.EditLocalVideoPlayer", "onCreate mBackgroundImage.setImageBitmap()");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setOnRecyclePlayListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setOnPreparedListener(this);
    if ((this.b.a.asi != 10) && (this.b.a.asi != 12)) {
      this.aGB = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.i(((EditLocalVideoSource)localObject).d.rotation, ((EditLocalVideoSource)localObject).d.mediaWidth, ((EditLocalVideoSource)localObject).d.mediaHeight);
    }
    for (;;)
    {
      this.mVideoPath = this.b.a.a.getSourcePath();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setVideoPath(this.mVideoPath);
      localObject = this.b.a.getStringExtra("extra_upload_temp_directory");
      this.jdField_a_of_type_Rjm = new rjm();
      this.jdField_a_of_type_Rjm.init();
      this.jdField_a_of_type_Rjm.a(this.mVideoPath, (String)localObject, this.aGB, 480, k, 10000, n, true, new rbi(this), new rbj(this, l, m));
      rar.a("video_edit", "edit_local", 0, 0, new String[0]);
      a(rdo.class, this);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setCenterInside(true);
      this.jg.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Rjm.unInit();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.pausePlay();
  }
  
  public void onResume()
  {
    super.onResume();
    sJ(false);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void p(int paramInt, Object paramObject)
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
      sJ(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.pausePlay();
  }
  
  public void pause()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.pausePlay();
  }
  
  public void play()
  {
    sJ(true);
  }
  
  public void s(Bitmap paramBitmap) {}
  
  protected void sJ(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView == null) || (!this.aGA)) {
      return;
    }
    int i = this.b.tj();
    if ((this.jdField_a_of_type_ArrayOfRbh$a == null) || (i >= this.jdField_a_of_type_ArrayOfRbh$a.length) || (this.jdField_a_of_type_ArrayOfRbh$a[i].isDeleted))
    {
      ram.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! resumePlay(%b): PlayerContext is illegal %s index=%d", new Object[] { Boolean.valueOf(paramBoolean), Arrays.toString(this.jdField_a_of_type_ArrayOfRbh$a), Integer.valueOf(i) });
      return;
    }
    rbh.a locala = this.jdField_a_of_type_ArrayOfRbh$a[i];
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setPlayRange(locala.startTime, locala.endTime);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.sK(locala.isMute);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.sJ(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.sK(locala.isMute);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.sJ(false);
  }
  
  public void setPlayMode(int paramInt) {}
  
  public void tt(boolean paramBoolean)
  {
    this.jdField_a_of_type_ArrayOfRbh$a[this.b.tj()].isMute = paramBoolean;
    sJ(false);
  }
  
  public long w(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfRbh$a.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    rbh.a locala = this.jdField_a_of_type_ArrayOfRbh$a[paramInt];
    return locala.endTime - locala.startTime;
  }
  
  public void wR(int paramInt) {}
  
  public static class a
    extends rfa
  {
    String azr;
    int endTime;
    boolean isDeleted = false;
    boolean isMute = false;
    int startTime;
    
    public a(int paramInt, Bitmap paramBitmap)
    {
      super(paramBitmap);
    }
    
    public static a a(a parama, Bitmap paramBitmap)
    {
      paramBitmap = new a(parama.bqJ, paramBitmap);
      paramBitmap.startTime = parama.startTime;
      paramBitmap.endTime = parama.endTime;
      paramBitmap.azr = parama.azr;
      paramBitmap.isMute = parama.isMute;
      paramBitmap.isDeleted = parama.isDeleted;
      return paramBitmap;
    }
    
    public String toString()
    {
      return "PlayerContext{startTime=" + this.startTime + ", endTime=" + this.endTime + ", isMute=" + this.isMute + ", isDeleted=" + this.isDeleted + "} " + super.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbh
 * JD-Core Version:    0.7.0.1
 */