package tv.danmaku.ijk.media.player.misc;

import android.annotation.TargetApi;
import android.media.MediaFormat;

public class AndroidMediaFormat
  implements IMediaFormat
{
  private final MediaFormat mMediaFormat;
  
  public AndroidMediaFormat(MediaFormat paramMediaFormat)
  {
    this.mMediaFormat = paramMediaFormat;
  }
  
  @TargetApi(16)
  public int getInteger(String paramString)
  {
    if (this.mMediaFormat == null) {
      return 0;
    }
    return this.mMediaFormat.getInteger(paramString);
  }
  
  @TargetApi(16)
  public String getString(String paramString)
  {
    if (this.mMediaFormat == null) {
      return null;
    }
    return this.mMediaFormat.getString(paramString);
  }
  
  @TargetApi(16)
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    if (this.mMediaFormat != null) {
      localStringBuilder.append(this.mMediaFormat.toString());
    }
    for (;;)
    {
      localStringBuilder.append('}');
      return localStringBuilder.toString();
      localStringBuilder.append("null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.AndroidMediaFormat
 * JD-Core Version:    0.7.0.1
 */