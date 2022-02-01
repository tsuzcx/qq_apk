package tv.danmaku.ijk.media.player.misc;

import android.annotation.TargetApi;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta;

public class IjkMediaFormat
  implements IMediaFormat
{
  public static final String CODEC_NAME_H264 = "h264";
  public static final String KEY_IJK_BIT_RATE_UI = "ijk-bit-rate-ui";
  public static final String KEY_IJK_CHANNEL_UI = "ijk-channel-ui";
  public static final String KEY_IJK_CODEC_LONG_NAME_UI = "ijk-codec-long-name-ui";
  public static final String KEY_IJK_CODEC_NAME_UI = "ijk-codec-name-ui";
  public static final String KEY_IJK_CODEC_PIXEL_FORMAT_UI = "ijk-pixel-format-ui";
  public static final String KEY_IJK_CODEC_PROFILE_LEVEL_UI = "ijk-profile-level-ui";
  public static final String KEY_IJK_FRAME_RATE_UI = "ijk-frame-rate-ui";
  public static final String KEY_IJK_RESOLUTION_UI = "ijk-resolution-ui";
  public static final String KEY_IJK_SAMPLE_RATE_UI = "ijk-sample-rate-ui";
  private static final Map<String, IjkMediaFormat.Formatter> sFormatterMap = new HashMap();
  public final IjkMediaMeta.IjkStreamMeta mMediaFormat;
  
  public IjkMediaFormat(IjkMediaMeta.IjkStreamMeta paramIjkStreamMeta)
  {
    sFormatterMap.put("ijk-codec-long-name-ui", new IjkMediaFormat.1(this));
    sFormatterMap.put("ijk-codec-name-ui", new IjkMediaFormat.2(this));
    sFormatterMap.put("ijk-bit-rate-ui", new IjkMediaFormat.3(this));
    sFormatterMap.put("ijk-profile-level-ui", new IjkMediaFormat.4(this));
    sFormatterMap.put("ijk-pixel-format-ui", new IjkMediaFormat.5(this));
    sFormatterMap.put("ijk-resolution-ui", new IjkMediaFormat.6(this));
    sFormatterMap.put("ijk-frame-rate-ui", new IjkMediaFormat.7(this));
    sFormatterMap.put("ijk-sample-rate-ui", new IjkMediaFormat.8(this));
    sFormatterMap.put("ijk-channel-ui", new IjkMediaFormat.9(this));
    this.mMediaFormat = paramIjkStreamMeta;
  }
  
  @TargetApi(16)
  public int getInteger(String paramString)
  {
    IjkMediaMeta.IjkStreamMeta localIjkStreamMeta = this.mMediaFormat;
    if (localIjkStreamMeta == null) {
      return 0;
    }
    return localIjkStreamMeta.getInt(paramString);
  }
  
  public String getString(String paramString)
  {
    if (this.mMediaFormat == null) {
      return null;
    }
    if (sFormatterMap.containsKey(paramString)) {
      return ((IjkMediaFormat.Formatter)sFormatterMap.get(paramString)).format(this);
    }
    return this.mMediaFormat.getString(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.misc.IjkMediaFormat
 * JD-Core Version:    0.7.0.1
 */