import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import java.io.File;

public class trt
  implements tqg
{
  TextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
  private String jdField_a_of_type_JavaLangString = "VideoViewTextureImpl";
  tqt jdField_a_of_type_Tqt = new tqt();
  
  public trt(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView = new TextureVideoView(paramContext.getApplicationContext());
    this.jdField_a_of_type_JavaLangString += paramString;
  }
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
  }
  
  public tqt a()
  {
    return this.jdField_a_of_type_Tqt;
  }
  
  public void a()
  {
    urk.d(this.jdField_a_of_type_JavaLangString, "stopPlayback");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.a();
  }
  
  @TargetApi(14)
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVisibility(paramInt);
  }
  
  public void a(long paramLong)
  {
    urk.d(this.jdField_a_of_type_JavaLangString, "seekTo");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.seekTo((int)paramLong);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Tqt.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Tqt.jdField_a_of_type_Boolean = true;
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (shq.a(new File(paramString2))) {
        paramString1 = paramString2;
      }
    }
    urk.d(this.jdField_a_of_type_JavaLangString, "setVideoPath");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoPath(paramString1);
  }
  
  public void a(tqh paramtqh)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramtqh == null) {}
    for (paramtqh = null;; paramtqh = new tru(this, paramtqh))
    {
      localTextureVideoView.setOnCompletionListener(paramtqh);
      return;
    }
  }
  
  public void a(tqi paramtqi) {}
  
  public void a(tqj paramtqj)
  {
    Object localObject = null;
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramtqj == null) {}
    for (paramtqj = localObject;; paramtqj = new trv(this, paramtqj, null))
    {
      localTextureVideoView.setOnErrorListener(paramtqj);
      return;
    }
  }
  
  public void a(tqk paramtqk)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramtqk == null) {}
    for (paramtqk = null;; paramtqk = new trw(this, paramtqk))
    {
      localTextureVideoView.setOnInfoListener(paramtqk);
      return;
    }
  }
  
  public void a(tql paramtql)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramtql == null) {}
    for (paramtql = null;; paramtql = new trx(this, paramtql))
    {
      localTextureVideoView.setOnPreparedListener(paramtql);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.isPlaying();
  }
  
  public int b()
  {
    return 1;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getDuration();
  }
  
  public void b()
  {
    urk.d(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
  }
  
  public void c()
  {
    urk.d(this.jdField_a_of_type_JavaLangString, "pause");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
  }
  
  public void d()
  {
    urk.d(this.jdField_a_of_type_JavaLangString, "restart");
    b();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     trt
 * JD-Core Version:    0.7.0.1
 */