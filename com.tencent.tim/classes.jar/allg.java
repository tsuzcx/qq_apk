import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoViewFactory;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;

public class allg
{
  static {}
  
  public static IBaseVideoView createBaseVideoView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    return VideoViewFactory.createBaseVideoView(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
  
  public static IBaseVideoView createBaseVideoViewFS(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    return VideoViewFactory.createBaseVideoViewFS(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
  
  public static IBaseVideoView createCropBubbleView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    paramContext = (CropBubbleVideoView)VideoViewFactory.createCropBubbleView(paramContext, paramLong, paramVideoPlayParam, paramBoolean);
    paramContext.setRadius(6.0F);
    paramContext.setDrawTri(false);
    return paramContext;
  }
  
  public static IBaseVideoView createQQVideoPlayView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    return VideoViewFactory.createQQVideoPlayView(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     allg
 * JD-Core Version:    0.7.0.1
 */