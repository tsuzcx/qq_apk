package tv.danmaku.ijk.media.player.misc;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.TrackInfo;
import android.os.Build.VERSION;

public class AndroidTrackInfo
  implements ITrackInfo
{
  private final MediaPlayer.TrackInfo mTrackInfo;
  
  private AndroidTrackInfo(MediaPlayer.TrackInfo paramTrackInfo)
  {
    this.mTrackInfo = paramTrackInfo;
  }
  
  public static AndroidTrackInfo[] fromMediaPlayer(MediaPlayer paramMediaPlayer)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return fromTrackInfo(paramMediaPlayer.getTrackInfo());
    }
    return null;
  }
  
  private static AndroidTrackInfo[] fromTrackInfo(MediaPlayer.TrackInfo[] paramArrayOfTrackInfo)
  {
    if (paramArrayOfTrackInfo == null) {
      return null;
    }
    AndroidTrackInfo[] arrayOfAndroidTrackInfo = new AndroidTrackInfo[paramArrayOfTrackInfo.length];
    int i = 0;
    while (i < paramArrayOfTrackInfo.length)
    {
      arrayOfAndroidTrackInfo[i] = new AndroidTrackInfo(paramArrayOfTrackInfo[i]);
      i += 1;
    }
    return arrayOfAndroidTrackInfo;
  }
  
  @TargetApi(19)
  public IMediaFormat getFormat()
  {
    if (this.mTrackInfo == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 19) {
      return null;
    }
    MediaFormat localMediaFormat = this.mTrackInfo.getFormat();
    if (localMediaFormat == null) {
      return null;
    }
    return new AndroidMediaFormat(localMediaFormat);
  }
  
  @TargetApi(16)
  public String getInfoInline()
  {
    MediaPlayer.TrackInfo localTrackInfo = this.mTrackInfo;
    if (localTrackInfo != null) {
      return localTrackInfo.toString();
    }
    return "null";
  }
  
  @TargetApi(16)
  public String getLanguage()
  {
    MediaPlayer.TrackInfo localTrackInfo = this.mTrackInfo;
    if (localTrackInfo == null) {
      return "und";
    }
    return localTrackInfo.getLanguage();
  }
  
  @TargetApi(16)
  public int getTrackType()
  {
    MediaPlayer.TrackInfo localTrackInfo = this.mTrackInfo;
    if (localTrackInfo == null) {
      return 0;
    }
    return localTrackInfo.getTrackType();
  }
  
  @TargetApi(16)
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append('{');
    MediaPlayer.TrackInfo localTrackInfo = this.mTrackInfo;
    if (localTrackInfo != null) {
      localStringBuilder.append(localTrackInfo.toString());
    } else {
      localStringBuilder.append("null");
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.AndroidTrackInfo
 * JD-Core Version:    0.7.0.1
 */