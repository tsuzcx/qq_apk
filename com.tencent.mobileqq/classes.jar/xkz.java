import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import java.io.File;

public class xkz
  implements xjm
{
  TextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
  private String jdField_a_of_type_JavaLangString = "VideoViewTextureImpl";
  xjz jdField_a_of_type_Xjz = new xjz();
  
  public xkz(Context paramContext, String paramString)
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
  
  public xjz a()
  {
    return this.jdField_a_of_type_Xjz;
  }
  
  public void a()
  {
    ykq.d(this.jdField_a_of_type_JavaLangString, "stopPlayback");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.a();
  }
  
  @TargetApi(14)
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVisibility(paramInt);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Xjz.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Xjz.jdField_a_of_type_Boolean = true;
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (wbl.a(new File(paramString2))) {
        paramString1 = paramString2;
      }
    }
    ykq.d(this.jdField_a_of_type_JavaLangString, "setVideoPath");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoPath(paramString1);
  }
  
  public void a(xjn paramxjn)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramxjn == null) {}
    for (paramxjn = null;; paramxjn = new xla(this, paramxjn))
    {
      localTextureVideoView.setOnCompletionListener(paramxjn);
      return;
    }
  }
  
  public void a(xjo paramxjo) {}
  
  public void a(xjp paramxjp)
  {
    Object localObject = null;
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramxjp == null) {}
    for (paramxjp = localObject;; paramxjp = new xlb(this, paramxjp, null))
    {
      localTextureVideoView.setOnErrorListener(paramxjp);
      return;
    }
  }
  
  public void a(xjq paramxjq)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramxjq == null) {}
    for (paramxjq = null;; paramxjq = new xlc(this, paramxjq))
    {
      localTextureVideoView.setOnInfoListener(paramxjq);
      return;
    }
  }
  
  public void a(xjr paramxjr)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramxjr == null) {}
    for (paramxjr = null;; paramxjr = new xld(this, paramxjr))
    {
      localTextureVideoView.setOnPreparedListener(paramxjr);
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
    ykq.d(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
  }
  
  public void c()
  {
    ykq.d(this.jdField_a_of_type_JavaLangString, "pause");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
  }
  
  public void d()
  {
    ykq.d(this.jdField_a_of_type_JavaLangString, "restart");
    b();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkz
 * JD-Core Version:    0.7.0.1
 */