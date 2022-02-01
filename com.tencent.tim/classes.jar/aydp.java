import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Message;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.a;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoPlayer.3;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.a;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.b;
import java.util.Arrays;
import java.util.List;

@TargetApi(14)
public class aydp
  extends aygy
  implements ayhm, TrimTextureVideoView.a, ImageViewVideoPlayer.a, ImageViewVideoPlayer.b, qmc.e
{
  protected aypl a;
  protected aydp.a[] a;
  protected boolean aGA;
  protected boolean aGB;
  protected TrimTextureVideoView b;
  public ImageView jg;
  protected int mEndTime;
  protected int mStartTime;
  protected String mVideoPath;
  protected TextView yc;
  
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
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    if ((paramayqb.a instanceof EditLocalVideoSource))
    {
      paramayqb.g.hasFragments = true;
      ram.d("Q.qqstory.record.EditLocalVideoPlayer", "editVideoPrePublish(%d) -> %s", Integer.valueOf(paramInt), this.jdField_a_of_type_ArrayOfAydp$a[paramInt] + ",mNeedRotate=" + this.aGB);
      paramayqb.g.videoNeedRotate = this.aGB;
      paramayqb.g.videoRangeStart = this.jdField_a_of_type_ArrayOfAydp$a[paramInt].startTime;
      paramayqb.g.videoRangeEnd = this.jdField_a_of_type_ArrayOfAydp$a[paramInt].endTime;
    }
  }
  
  public void a(qmc paramqmc)
  {
    if (this.jg != null) {
      this.jg.postDelayed(new EditLocalVideoPlayer.3(this), 300L);
    }
    ram.b("Q.qqstory.record.EditLocalVideoPlayer", "onPrepared %s", this.jdField_b_of_type_Aygz.a.a.getSourcePath());
    this.aGA = true;
    sJ(true);
  }
  
  public void aG(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.seekTo((int)paramLong);
    }
  }
  
  public void aH(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.seekTo((int)paramLong);
    }
  }
  
  public void b(int paramInt1, int paramInt2, float paramFloat) {}
  
  public void boS()
  {
    aydu localaydu = (aydu)a(aydu.class);
    if (localaydu != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayRecycle()");
      }
      localaydu.bsg();
    }
  }
  
  public void bsf()
  {
    this.jdField_b_of_type_Aygz.a(Message.obtain(null, 8));
  }
  
  public void c(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public List<? extends ayjg> ca()
  {
    aydp.a[] arrayOfa = new aydp.a[this.jdField_a_of_type_ArrayOfAydp$a.length];
    int i = 0;
    while (i < arrayOfa.length)
    {
      arrayOfa[i] = aydp.a.a(this.jdField_a_of_type_ArrayOfAydp$a[i], A(this.jdField_a_of_type_ArrayOfAydp$a[i].cE));
      i += 1;
    }
    return Arrays.asList(arrayOfa);
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
      default: 
        return true;
      case 1: 
        sJ(false);
        return true;
      case 2: 
        this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.pausePlay();
        return true;
      }
      sJ(true);
      return true;
    }
    int i;
    if (paramMessage.what == 6)
    {
      i = paramMessage.arg2;
      if ((this.jdField_a_of_type_ArrayOfAydp$a == null) || (i >= this.jdField_a_of_type_ArrayOfAydp$a.length) || (this.jdField_a_of_type_ArrayOfAydp$a[i].isDeleted))
      {
        ram.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfAydp$a), Integer.valueOf(i) });
        return false;
      }
      sJ(true);
      return true;
    }
    if (paramMessage.what == 7)
    {
      i = paramMessage.arg1;
      if ((this.jdField_a_of_type_ArrayOfAydp$a == null) || (i >= this.jdField_a_of_type_ArrayOfAydp$a.length))
      {
        ram.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfAydp$a), Integer.valueOf(i) });
        return false;
      }
      this.jdField_a_of_type_ArrayOfAydp$a[i].isDeleted = true;
      ram.d("Q.qqstory.record.EditLocalVideoPlayer", "PlayerContext %d Deleted!", Integer.valueOf(i));
      return true;
    }
    return false;
  }
  
  public Bitmap f(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAydp$a.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    aydp.a locala = this.jdField_a_of_type_ArrayOfAydp$a[paramInt];
    if (locala.cE.isRecycled()) {
      ram.e("Q.qqstory.record.EditLocalVideoPlayer", "自己的bitmap被外边recycle了!");
    }
    return locala.cE;
  }
  
  public int getPlayMode()
  {
    return 0;
  }
  
  public void h(int paramInt, byte[] paramArrayOfByte) {}
  
  public void onCreate()
  {
    super.onCreate();
    if ((!this.jdField_b_of_type_Aygz.a.Ld()) || (!this.jdField_b_of_type_Aygz.a.Lb())) {
      return;
    }
    Object localObject = (EditLocalVideoSource)this.jdField_b_of_type_Aygz.a.a;
    int k = ((EditLocalVideoSource)localObject).startTime;
    int m = ((EditLocalVideoSource)localObject).endTime;
    int n = this.jdField_b_of_type_Aygz.a.ti();
    this.jdField_a_of_type_ArrayOfAydp$a = new aydp.a[n];
    ram.b("Q.qqstory.record.EditLocalVideoPlayer", "onCreate EditSource fragmentCount is %d", Integer.valueOf(n));
    int j = k;
    int i = 0;
    while (i < n)
    {
      this.jdField_a_of_type_ArrayOfAydp$a[i] = new aydp.a(i, null);
      aydp.a locala = this.jdField_a_of_type_ArrayOfAydp$a[i];
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
    this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView = ((TrimTextureVideoView)y(2131367295));
    this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVisibility(0);
    this.yc = ((TextView)y(2131365426));
    this.yc.setEnabled(false);
    this.aGB = this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.i(((EditLocalVideoSource)localObject).d.rotation, ((EditLocalVideoSource)localObject).d.mediaWidth, ((EditLocalVideoSource)localObject).d.mediaHeight);
    this.jg = ((ImageView)y(2131376633));
    this.jg.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (aytv.ev != null)
    {
      boolean bool = this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.IF();
      localObject = aytv.ev;
      if (!bool) {
        this.jg.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      this.jg.setImageBitmap((Bitmap)localObject);
      this.jg.setVisibility(0);
      ram.d("Q.qqstory.record.EditLocalVideoPlayer", "onCreate mBackgroundImage.setImageBitmap()");
    }
    this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnRecyclePlayListener(this);
    this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnPreparedListener(this);
    this.mVideoPath = this.jdField_b_of_type_Aygz.a.a.getSourcePath();
    this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.mVideoPath);
    localObject = this.jdField_b_of_type_Aygz.a.getStringExtra("extra_upload_temp_directory");
    this.jdField_a_of_type_Aypl = new aypl();
    this.jdField_a_of_type_Aypl.b(null);
    this.jdField_a_of_type_Aypl.a(this.mVideoPath, (String)localObject, this.aGB, 480, k, 10000, n, false, new aydq(this), new aydr(this));
    a(ayhm.class, this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Aypl.unInit();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.pausePlay();
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
    if (this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    switch (paramInt)
    {
    case 6: 
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
    this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.pausePlay();
  }
  
  public void pause()
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.pausePlay();
  }
  
  public void play()
  {
    sJ(true);
  }
  
  public void s(Bitmap paramBitmap) {}
  
  protected void sJ(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) || (!this.aGA)) {
      return;
    }
    int i = this.jdField_b_of_type_Aygz.tj();
    if ((this.jdField_a_of_type_ArrayOfAydp$a == null) || (i >= this.jdField_a_of_type_ArrayOfAydp$a.length) || (this.jdField_a_of_type_ArrayOfAydp$a[i].isDeleted))
    {
      ram.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! resumePlay(%b): PlayerContext is illegal %s index=%d", new Object[] { Boolean.valueOf(paramBoolean), Arrays.toString(this.jdField_a_of_type_ArrayOfAydp$a), Integer.valueOf(i) });
      return;
    }
    aydp.a locala = this.jdField_a_of_type_ArrayOfAydp$a[i];
    if (paramBoolean)
    {
      this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setPlayRange(locala.startTime, locala.endTime);
      this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.sK(locala.isMute);
      this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.sJ(true);
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.sK(locala.isMute);
    this.jdField_b_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.sJ(false);
  }
  
  public void setPlayMode(int paramInt) {}
  
  public void setTransferData(TransferData paramTransferData) {}
  
  public void setVolume(float paramFloat) {}
  
  public void tt(boolean paramBoolean)
  {
    this.jdField_a_of_type_ArrayOfAydp$a[this.jdField_b_of_type_Aygz.tj()].isMute = paramBoolean;
    sJ(false);
  }
  
  public long w(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAydp$a.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    aydp.a locala = this.jdField_a_of_type_ArrayOfAydp$a[paramInt];
    return locala.endTime - locala.startTime;
  }
  
  public void wR(int paramInt) {}
  
  public static class a
    extends ayjg
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aydp
 * JD-Core Version:    0.7.0.1
 */