import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import java.io.File;

public class xut
  implements xtg
{
  TextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
  private String jdField_a_of_type_JavaLangString = "VideoViewTextureImpl";
  xtt jdField_a_of_type_Xtt = new xtt();
  
  public xut(Context paramContext, String paramString)
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
  
  public xtt a()
  {
    return this.jdField_a_of_type_Xtt;
  }
  
  public void a()
  {
    yuk.d(this.jdField_a_of_type_JavaLangString, "stopPlayback");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.a();
  }
  
  @TargetApi(14)
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVisibility(paramInt);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Xtt.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Xtt.jdField_a_of_type_Boolean = true;
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (wkr.a(new File(paramString2))) {
        paramString1 = paramString2;
      }
    }
    yuk.d(this.jdField_a_of_type_JavaLangString, "setVideoPath");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoPath(paramString1);
  }
  
  public void a(xth paramxth)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramxth == null) {}
    for (paramxth = null;; paramxth = new xuu(this, paramxth))
    {
      localTextureVideoView.setOnCompletionListener(paramxth);
      return;
    }
  }
  
  public void a(xti paramxti) {}
  
  public void a(xtj paramxtj)
  {
    Object localObject = null;
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramxtj == null) {}
    for (paramxtj = localObject;; paramxtj = new xuv(this, paramxtj, null))
    {
      localTextureVideoView.setOnErrorListener(paramxtj);
      return;
    }
  }
  
  public void a(xtk paramxtk)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramxtk == null) {}
    for (paramxtk = null;; paramxtk = new xuw(this, paramxtk))
    {
      localTextureVideoView.setOnInfoListener(paramxtk);
      return;
    }
  }
  
  public void a(xtl paramxtl)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramxtl == null) {}
    for (paramxtl = null;; paramxtl = new xux(this, paramxtl))
    {
      localTextureVideoView.setOnPreparedListener(paramxtl);
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
    yuk.d(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
  }
  
  public void c()
  {
    yuk.d(this.jdField_a_of_type_JavaLangString, "pause");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
  }
  
  public void d()
  {
    yuk.d(this.jdField_a_of_type_JavaLangString, "restart");
    b();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xut
 * JD-Core Version:    0.7.0.1
 */