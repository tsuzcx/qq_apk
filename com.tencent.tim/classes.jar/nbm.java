import android.content.Context;
import com.tencent.superplayer.api.SuperPlayerOption;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "", "currentPositionMs", "", "getCurrentPositionMs", "()J", "durationMs", "getDurationMs", "isLoopBack", "", "()Z", "setLoopBack", "(Z)V", "isPauseing", "isPlaying", "outputMute", "getOutputMute", "setOutputMute", "speedRatio", "", "getSpeedRatio", "()F", "setSpeedRatio", "(F)V", "videoHeight", "", "getVideoHeight", "()I", "videoWidth", "getVideoWidth", "getStreamDumpInfo", "", "openMediaPlayer", "", "context", "Landroid/content/Context;", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "startPositionMilsec", "playerOption", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "pause", "pauseDownload", "prePlayViewShow", "release", "resumeDownload", "seekTo", "positionMilsec", "mode", "setEventListener", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IEventListener;", "setHttpBufferRange", "emergencyTime", "safePlayTime", "preloadDuration", "setLoopback", "isLoopback", "setXYaxis", "type", "start", "stop", "updatePlayerVideoView", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface nbm
{
  public static final nbm.a a = nbm.a.b;
  
  public abstract void S(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(@NotNull Context paramContext, @NotNull nbt paramnbt, long paramLong, @NotNull SuperPlayerOption paramSuperPlayerOption);
  
  public abstract void a(@Nullable nbl paramnbl);
  
  public abstract void aTR();
  
  public abstract void b(@Nullable nbr paramnbr);
  
  public abstract long getCurrentPositionMs();
  
  public abstract long getDurationMs();
  
  public abstract boolean getOutputMute();
  
  @Nullable
  public abstract String getStreamDumpInfo();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void pause();
  
  public abstract void pauseDownload();
  
  public abstract void release();
  
  public abstract void resumeDownload();
  
  public abstract void seekTo(int paramInt1, int paramInt2);
  
  public abstract void setLoopback(boolean paramBoolean);
  
  public abstract void setOutputMute(boolean paramBoolean);
  
  public abstract void setSpeedRatio(float paramFloat);
  
  public abstract void setXYaxis(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer$Companion;", "", "()V", "PLAYER_INFO_BUFFERING_END", "", "PLAYER_INFO_BUFFERING_START", "PLAYER_INFO_CURRENT_LOOP_END", "PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED", "PLAYER_SCALE_BOTH_FULLSCREEN", "PLAYER_SCALE_ORIGINAL_FULLSCREEN", "PLAYER_SCALE_ORIGINAL_RATIO", "PLAYER_SCALE_ORIGINAL_RATIO_SQUARE", "SEEK_MODE_ACCURATE_POSITION", "SEEK_MODE_DEFAULT", "SEEK_MODE_FREVIOUS_KFRAME", "SEEK_MODE_NEXT_KFRAME", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbm
 * JD-Core Version:    0.7.0.1
 */