package tv.danmaku.ijk.media.player;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class IjkMediaMeta
{
  public static final long AV_CH_BACK_CENTER = 256L;
  public static final long AV_CH_BACK_LEFT = 16L;
  public static final long AV_CH_BACK_RIGHT = 32L;
  public static final long AV_CH_FRONT_CENTER = 4L;
  public static final long AV_CH_FRONT_LEFT = 1L;
  public static final long AV_CH_FRONT_LEFT_OF_CENTER = 64L;
  public static final long AV_CH_FRONT_RIGHT = 2L;
  public static final long AV_CH_FRONT_RIGHT_OF_CENTER = 128L;
  public static final long AV_CH_LAYOUT_2POINT1 = 11L;
  public static final long AV_CH_LAYOUT_2_1 = 259L;
  public static final long AV_CH_LAYOUT_2_2 = 1539L;
  public static final long AV_CH_LAYOUT_3POINT1 = 15L;
  public static final long AV_CH_LAYOUT_4POINT0 = 263L;
  public static final long AV_CH_LAYOUT_4POINT1 = 271L;
  public static final long AV_CH_LAYOUT_5POINT0 = 1543L;
  public static final long AV_CH_LAYOUT_5POINT0_BACK = 55L;
  public static final long AV_CH_LAYOUT_5POINT1 = 1551L;
  public static final long AV_CH_LAYOUT_5POINT1_BACK = 63L;
  public static final long AV_CH_LAYOUT_6POINT0 = 1799L;
  public static final long AV_CH_LAYOUT_6POINT0_FRONT = 1731L;
  public static final long AV_CH_LAYOUT_6POINT1 = 1807L;
  public static final long AV_CH_LAYOUT_6POINT1_BACK = 319L;
  public static final long AV_CH_LAYOUT_6POINT1_FRONT = 1739L;
  public static final long AV_CH_LAYOUT_7POINT0 = 1591L;
  public static final long AV_CH_LAYOUT_7POINT0_FRONT = 1735L;
  public static final long AV_CH_LAYOUT_7POINT1 = 1599L;
  public static final long AV_CH_LAYOUT_7POINT1_WIDE = 1743L;
  public static final long AV_CH_LAYOUT_7POINT1_WIDE_BACK = 255L;
  public static final long AV_CH_LAYOUT_HEXAGONAL = 311L;
  public static final long AV_CH_LAYOUT_MONO = 4L;
  public static final long AV_CH_LAYOUT_OCTAGONAL = 1847L;
  public static final long AV_CH_LAYOUT_QUAD = 51L;
  public static final long AV_CH_LAYOUT_STEREO = 3L;
  public static final long AV_CH_LAYOUT_STEREO_DOWNMIX = 1610612736L;
  public static final long AV_CH_LAYOUT_SURROUND = 7L;
  public static final long AV_CH_LOW_FREQUENCY = 8L;
  public static final long AV_CH_LOW_FREQUENCY_2 = 34359738368L;
  public static final long AV_CH_SIDE_LEFT = 512L;
  public static final long AV_CH_SIDE_RIGHT = 1024L;
  public static final long AV_CH_STEREO_LEFT = 536870912L;
  public static final long AV_CH_STEREO_RIGHT = 1073741824L;
  public static final long AV_CH_SURROUND_DIRECT_LEFT = 8589934592L;
  public static final long AV_CH_SURROUND_DIRECT_RIGHT = 17179869184L;
  public static final long AV_CH_TOP_BACK_CENTER = 65536L;
  public static final long AV_CH_TOP_BACK_LEFT = 32768L;
  public static final long AV_CH_TOP_BACK_RIGHT = 131072L;
  public static final long AV_CH_TOP_CENTER = 2048L;
  public static final long AV_CH_TOP_FRONT_CENTER = 8192L;
  public static final long AV_CH_TOP_FRONT_LEFT = 4096L;
  public static final long AV_CH_TOP_FRONT_RIGHT = 16384L;
  public static final long AV_CH_WIDE_LEFT = 2147483648L;
  public static final long AV_CH_WIDE_RIGHT = 4294967296L;
  public static final int FF_PROFILE_H264_BASELINE = 66;
  public static final int FF_PROFILE_H264_CAVLC_444 = 44;
  public static final int FF_PROFILE_H264_CONSTRAINED = 512;
  public static final int FF_PROFILE_H264_CONSTRAINED_BASELINE = 578;
  public static final int FF_PROFILE_H264_EXTENDED = 88;
  public static final int FF_PROFILE_H264_HIGH = 100;
  public static final int FF_PROFILE_H264_HIGH_10 = 110;
  public static final int FF_PROFILE_H264_HIGH_10_INTRA = 2158;
  public static final int FF_PROFILE_H264_HIGH_422 = 122;
  public static final int FF_PROFILE_H264_HIGH_422_INTRA = 2170;
  public static final int FF_PROFILE_H264_HIGH_444 = 144;
  public static final int FF_PROFILE_H264_HIGH_444_INTRA = 2292;
  public static final int FF_PROFILE_H264_HIGH_444_PREDICTIVE = 244;
  public static final int FF_PROFILE_H264_INTRA = 2048;
  public static final int FF_PROFILE_H264_MAIN = 77;
  public static final String IJKM_KEY_AUDIO_STREAM = "audio";
  public static final String IJKM_KEY_BITRATE = "bitrate";
  public static final String IJKM_KEY_CHANNEL_LAYOUT = "channel_layout";
  public static final String IJKM_KEY_CODEC_LEVEL = "codec_level";
  public static final String IJKM_KEY_CODEC_LONG_NAME = "codec_long_name";
  public static final String IJKM_KEY_CODEC_NAME = "codec_name";
  public static final String IJKM_KEY_CODEC_PIXEL_FORMAT = "codec_pixel_format";
  public static final String IJKM_KEY_CODEC_PROFILE = "codec_profile";
  public static final String IJKM_KEY_CODEC_PROFILE_ID = "codec_profile_id";
  public static final String IJKM_KEY_DURATION_US = "duration_us";
  public static final String IJKM_KEY_FORMAT = "format";
  public static final String IJKM_KEY_FPS_DEN = "fps_den";
  public static final String IJKM_KEY_FPS_NUM = "fps_num";
  public static final String IJKM_KEY_HEIGHT = "height";
  public static final String IJKM_KEY_LANGUAGE = "language";
  public static final String IJKM_KEY_SAMPLE_RATE = "sample_rate";
  public static final String IJKM_KEY_SAR_DEN = "sar_den";
  public static final String IJKM_KEY_SAR_NUM = "sar_num";
  public static final String IJKM_KEY_START_US = "start_us";
  public static final String IJKM_KEY_STREAMS = "streams";
  public static final String IJKM_KEY_TBR_DEN = "tbr_den";
  public static final String IJKM_KEY_TBR_NUM = "tbr_num";
  public static final String IJKM_KEY_TIMEDTEXT_STREAM = "timedtext";
  public static final String IJKM_KEY_TYPE = "type";
  public static final String IJKM_KEY_VIDEO_STREAM = "video";
  public static final String IJKM_KEY_WIDTH = "width";
  public static final String IJKM_VAL_TYPE__AUDIO = "audio";
  public static final String IJKM_VAL_TYPE__TIMEDTEXT = "timedtext";
  public static final String IJKM_VAL_TYPE__UNKNOWN = "unknown";
  public static final String IJKM_VAL_TYPE__VIDEO = "video";
  public IjkMediaMeta.IjkStreamMeta mAudioStream;
  public long mBitrate;
  public long mDurationUS;
  public String mFormat;
  public Bundle mMediaMeta;
  public long mStartUS;
  public final ArrayList<IjkMediaMeta.IjkStreamMeta> mStreams = new ArrayList();
  public IjkMediaMeta.IjkStreamMeta mVideoStream;
  
  public static IjkMediaMeta parse(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    IjkMediaMeta localIjkMediaMeta = new IjkMediaMeta();
    localIjkMediaMeta.mMediaMeta = paramBundle;
    localIjkMediaMeta.mFormat = localIjkMediaMeta.getString("format");
    localIjkMediaMeta.mDurationUS = localIjkMediaMeta.getLong("duration_us");
    localIjkMediaMeta.mStartUS = localIjkMediaMeta.getLong("start_us");
    localIjkMediaMeta.mBitrate = localIjkMediaMeta.getLong("bitrate");
    int k = localIjkMediaMeta.getInt("video", -1);
    int m = localIjkMediaMeta.getInt("audio", -1);
    localIjkMediaMeta.getInt("timedtext", -1);
    paramBundle = localIjkMediaMeta.getParcelableArrayList("streams");
    if (paramBundle == null) {
      return localIjkMediaMeta;
    }
    paramBundle = paramBundle.iterator();
    int i = -1;
    while (paramBundle.hasNext())
    {
      Bundle localBundle = (Bundle)paramBundle.next();
      int j = i + 1;
      i = j;
      if (localBundle != null)
      {
        IjkMediaMeta.IjkStreamMeta localIjkStreamMeta = new IjkMediaMeta.IjkStreamMeta(j);
        localIjkStreamMeta.mMeta = localBundle;
        localIjkStreamMeta.mType = localIjkStreamMeta.getString("type");
        localIjkStreamMeta.mLanguage = localIjkStreamMeta.getString("language");
        i = j;
        if (!TextUtils.isEmpty(localIjkStreamMeta.mType))
        {
          localIjkStreamMeta.mCodecName = localIjkStreamMeta.getString("codec_name");
          localIjkStreamMeta.mCodecProfile = localIjkStreamMeta.getString("codec_profile");
          localIjkStreamMeta.mCodecLongName = localIjkStreamMeta.getString("codec_long_name");
          localIjkStreamMeta.mBitrate = localIjkStreamMeta.getInt("bitrate");
          if (localIjkStreamMeta.mType.equalsIgnoreCase("video"))
          {
            localIjkStreamMeta.mWidth = localIjkStreamMeta.getInt("width");
            localIjkStreamMeta.mHeight = localIjkStreamMeta.getInt("height");
            localIjkStreamMeta.mFpsNum = localIjkStreamMeta.getInt("fps_num");
            localIjkStreamMeta.mFpsDen = localIjkStreamMeta.getInt("fps_den");
            localIjkStreamMeta.mTbrNum = localIjkStreamMeta.getInt("tbr_num");
            localIjkStreamMeta.mTbrDen = localIjkStreamMeta.getInt("tbr_den");
            localIjkStreamMeta.mSarNum = localIjkStreamMeta.getInt("sar_num");
            localIjkStreamMeta.mSarDen = localIjkStreamMeta.getInt("sar_den");
            if (k == j) {
              localIjkMediaMeta.mVideoStream = localIjkStreamMeta;
            }
          }
          for (;;)
          {
            localIjkMediaMeta.mStreams.add(localIjkStreamMeta);
            i = j;
            break;
            if (localIjkStreamMeta.mType.equalsIgnoreCase("audio"))
            {
              localIjkStreamMeta.mSampleRate = localIjkStreamMeta.getInt("sample_rate");
              localIjkStreamMeta.mChannelLayout = localIjkStreamMeta.getLong("channel_layout");
              if (m == j) {
                localIjkMediaMeta.mAudioStream = localIjkStreamMeta;
              }
            }
          }
        }
      }
    }
    return localIjkMediaMeta;
  }
  
  public String getDurationInline()
  {
    long l1 = (this.mDurationUS + 5000L) / 1000000L;
    long l2 = l1 / 60L;
    long l3 = l2 / 60L;
    return String.format(Locale.US, "%02d:%02d:%02d", new Object[] { Long.valueOf(l3), Long.valueOf(l2 % 60L), Long.valueOf(l1 % 60L) });
  }
  
  public int getInt(String paramString)
  {
    return getInt(paramString, 0);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    paramString = getString(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public long getLong(String paramString)
  {
    return getLong(paramString, 0L);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    paramString = getString(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return paramLong;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return paramLong;
  }
  
  public ArrayList<Bundle> getParcelableArrayList(String paramString)
  {
    return this.mMediaMeta.getParcelableArrayList(paramString);
  }
  
  public String getString(String paramString)
  {
    return this.mMediaMeta.getString(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.IjkMediaMeta
 * JD-Core Version:    0.7.0.1
 */