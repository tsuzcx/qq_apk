import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import java.io.File;

public class vte
  implements vrr
{
  TextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
  private String jdField_a_of_type_JavaLangString = "VideoViewTextureImpl";
  vse jdField_a_of_type_Vse = new vse();
  
  public vte(Context paramContext, String paramString)
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
  
  public vse a()
  {
    return this.jdField_a_of_type_Vse;
  }
  
  public void a()
  {
    wsv.d(this.jdField_a_of_type_JavaLangString, "stopPlayback");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.a();
  }
  
  @TargetApi(14)
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVisibility(paramInt);
  }
  
  public void a(long paramLong)
  {
    wsv.d(this.jdField_a_of_type_JavaLangString, "seekTo");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.seekTo((int)paramLong);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Vse.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Vse.jdField_a_of_type_Boolean = true;
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (ujb.a(new File(paramString2))) {
        paramString1 = paramString2;
      }
    }
    wsv.d(this.jdField_a_of_type_JavaLangString, "setVideoPath");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoPath(paramString1);
  }
  
  public void a(vrs paramvrs)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramvrs == null) {}
    for (paramvrs = null;; paramvrs = new vtf(this, paramvrs))
    {
      localTextureVideoView.setOnCompletionListener(paramvrs);
      return;
    }
  }
  
  public void a(vrt paramvrt) {}
  
  public void a(vru paramvru)
  {
    Object localObject = null;
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramvru == null) {}
    for (paramvru = localObject;; paramvru = new vtg(this, paramvru, null))
    {
      localTextureVideoView.setOnErrorListener(paramvru);
      return;
    }
  }
  
  public void a(vrv paramvrv)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramvrv == null) {}
    for (paramvrv = null;; paramvrv = new vth(this, paramvrv))
    {
      localTextureVideoView.setOnInfoListener(paramvrv);
      return;
    }
  }
  
  public void a(vrw paramvrw)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramvrw == null) {}
    for (paramvrw = null;; paramvrw = new vti(this, paramvrw))
    {
      localTextureVideoView.setOnPreparedListener(paramvrw);
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
    wsv.d(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
  }
  
  public void c()
  {
    wsv.d(this.jdField_a_of_type_JavaLangString, "pause");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
  }
  
  public void d()
  {
    wsv.d(this.jdField_a_of_type_JavaLangString, "restart");
    b();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vte
 * JD-Core Version:    0.7.0.1
 */