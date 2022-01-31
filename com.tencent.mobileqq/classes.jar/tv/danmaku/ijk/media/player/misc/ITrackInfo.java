package tv.danmaku.ijk.media.player.misc;

public abstract interface ITrackInfo
{
  public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
  public static final int MEDIA_TRACK_TYPE_METADATA = 5;
  public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4;
  public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3;
  public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
  public static final int MEDIA_TRACK_TYPE_VIDEO = 1;
  
  public abstract IMediaFormat getFormat();
  
  public abstract String getInfoInline();
  
  public abstract String getLanguage();
  
  public abstract int getTrackType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.ITrackInfo
 * JD-Core Version:    0.7.0.1
 */