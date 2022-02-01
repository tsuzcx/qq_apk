import android.content.Context;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import common.config.service.QzoneConfig;

public class astk
  extends AbsVideoPlayer
{
  private static final String oskPlayerContentTypeList = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
  
  public int captureImageInTime(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public View createVideoView(Context paramContext)
  {
    return null;
  }
  
  public long getCurrentPostion()
  {
    return 0L;
  }
  
  public long getDuration()
  {
    return 0L;
  }
  
  public boolean getOutputMute()
  {
    return false;
  }
  
  public int getVideoHeight()
  {
    return 0;
  }
  
  public int getVideoWidth()
  {
    return 0;
  }
  
  public boolean isPlaying()
  {
    return false;
  }
  
  public void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong) {}
  
  public void pause() {}
  
  public void release() {}
  
  public void seekTo(int paramInt) {}
  
  public void setLoopback(boolean paramBoolean) {}
  
  public void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener) {}
  
  public void setOnCompletionListener(AbsVideoPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void setOnControllerClickListener(AbsVideoPlayer.OnControllerClickListener paramOnControllerClickListener) {}
  
  public void setOnErrorListener(AbsVideoPlayer.OnErrorListener paramOnErrorListener) {}
  
  public void setOnInfoListener(AbsVideoPlayer.OnInfoListener paramOnInfoListener) {}
  
  public void setOnSeekCompleteListener(AbsVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void setOnVideoPreparedListener(AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener) {}
  
  public boolean setOutputMute(boolean paramBoolean)
  {
    return false;
  }
  
  public void setXYaxis(int paramInt) {}
  
  public void start() {}
  
  public void startPlayDanmu() {}
  
  public void stop() {}
  
  public void stopPlayDanmu() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     astk
 * JD-Core Version:    0.7.0.1
 */