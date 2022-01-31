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
    switch (this.mTrackType)
    {
    default: 
      localStringBuilder.append("UNKNOWN");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("VIDEO");
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mStreamMeta.getCodecShortNameInline());
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mStreamMeta.getBitrateInline());
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mStreamMeta.getResolutionInline());
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mStreamMeta.getFpsInline());
      continue;
      localStringBuilder.append("AUDIO");
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mStreamMeta.getCodecShortNameInline());
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mStreamMeta.getBitrateInline());
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mStreamMeta.getSampleRateInline());
      continue;
      localStringBuilder.append("TIMEDTEXT");
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mStreamMeta.mLanguage);
      continue;
      localStringBuilder.append("SUBTITLE");
    }
  }
  
  public String getLanguage()
  {
    if ((this.mStreamMeta == null) || (TextUtils.isEmpty(this.mStreamMeta.mLanguage))) {
      return "und";
    }
    return this.mStreamMeta.mLanguage;
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
    return getClass().getSimpleName() + '{' + getInfoInline() + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IjkTrackInfo
 * JD-Core Version:    0.7.0.1
 */