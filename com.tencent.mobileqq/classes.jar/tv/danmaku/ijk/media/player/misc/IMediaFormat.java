package tv.danmaku.ijk.media.player.misc;

public abstract interface IMediaFormat
{
  public static final String KEY_HEIGHT = "height";
  public static final String KEY_MIME = "mime";
  public static final String KEY_WIDTH = "width";
  
  public abstract int getInteger(String paramString);
  
  public abstract String getString(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IMediaFormat
 * JD-Core Version:    0.7.0.1
 */