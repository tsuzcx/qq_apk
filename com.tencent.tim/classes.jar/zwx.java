import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.photo.album.preview.PreviewBean;
import com.tencent.mobileqq.activity.photo.album.preview.VideoPreviewPresent;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class zwx
  extends VideoPreviewPresent
{
  public zwx(PreviewBean paramPreviewBean)
  {
    super(paramPreviewBean);
  }
  
  public BaseVideoView generateVideoView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    paramVideoPlayParam.mSceneId = 105;
    paramVideoPlayParam.mSceneName = allh.eO(105);
    return (BaseVideoView)allg.createBaseVideoView(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zwx
 * JD-Core Version:    0.7.0.1
 */