package tv.danmaku.ijk.media.player.misc;

import android.text.TextUtils;
import tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta;

public class IjkTrackInfo
  implements ITrackInfo
{
  private IjkMediaMeta.IjkStreamMeta mStreamMeta;
  private int mTrackType = 0;
  
  public IjkTrackInfo(IjkMediaMeta.IjkStreamMeta paramIjkStreamMeta)
  {
    this.mStreamMeta = paramIjkStreamMeta;
  }
  
  public IMediaFormat getFormat()
  {
    return new IjkMediaFormat(this.mStreamMeta);
  }
  
  public String getInfoInline()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    int i = this.mTrackType;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            localStringBuilder.append("UNKNOWN");
          } else {
            localStringBuilder.append("SUBTITLE");
          }
        }
        else
        {
          localStringBuilder.append("TIMEDTEXT");
          localStringBuilder.append(", ");
          localStringBuilder.append(this.mStreamMeta.mLanguage);
        }
      }
      else
      {
        localStringBuilder.append("AUDIO");
        localStringBuilder.append(", ");
        localStringBuilder.append(this.mStreamMeta.getCodecShortNameInline());
        localStringBuilder.append(", ");
        localStringBuilder.append(this.mStreamMeta.getBitrateInline());
        localStringBuilder.append(", ");
        localStringBuilder.append(this.mStreamMeta.getSampleRateInline());
      }
    }
    else
    {
      localStringBuilder.append("VIDEO");
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mStreamMeta.getCodecShortNameInline());
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mStreamMeta.getBitrateInline());
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mStreamMeta.getResolutionInline());
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mStreamMeta.getFpsInline());
    }
    return localStringBuilder.toString();
  }
  
  public String getLanguage()
  {
    IjkMediaMeta.IjkStreamMeta localIjkStreamMeta = this.mStreamMeta;
    if ((localIjkStreamMeta != null) && (!TextUtils.isEmpty(localIjkStreamMeta.mLanguage))) {
      return this.mStreamMeta.mLanguage;
    }
    return "und";
  }
  
  public int getTrackType()
  {
    return this.mTrackType;
  }
  
  public void setMediaMeta(IjkMediaMeta.IjkStreamMeta paramIjkStreamMeta)
  {
    this.mStreamMeta = paramIjkStreamMeta;
  }
  
  public void setTrackType(int paramInt)
  {
    this.mTrackType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append('{');
    localStringBuilder.append(getInfoInline());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IjkTrackInfo
 * JD-Core Version:    0.7.0.1
 */