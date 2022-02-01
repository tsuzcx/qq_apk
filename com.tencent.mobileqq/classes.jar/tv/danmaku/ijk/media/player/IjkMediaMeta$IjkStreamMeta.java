package tv.danmaku.ijk.media.player;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Locale;

public class IjkMediaMeta$IjkStreamMeta
{
  public long mBitrate;
  public long mChannelLayout;
  public String mCodecLongName;
  public String mCodecName;
  public String mCodecProfile;
  public int mFpsDen;
  public int mFpsNum;
  public int mHeight;
  public final int mIndex;
  public String mLanguage;
  public Bundle mMeta;
  public int mSampleRate;
  public int mSarDen;
  public int mSarNum;
  public int mTbrDen;
  public int mTbrNum;
  public String mType;
  public int mWidth;
  
  public IjkMediaMeta$IjkStreamMeta(int paramInt)
  {
    this.mIndex = paramInt;
  }
  
  public String getBitrateInline()
  {
    long l = this.mBitrate;
    if (l <= 0L) {
      return "N/A";
    }
    if (l < 1000L) {
      return String.format(Locale.US, "%d bit/s", new Object[] { Long.valueOf(this.mBitrate) });
    }
    return String.format(Locale.US, "%d kb/s", new Object[] { Long.valueOf(this.mBitrate / 1000L) });
  }
  
  public String getChannelLayoutInline()
  {
    long l = this.mChannelLayout;
    if (l <= 0L) {
      return "N/A";
    }
    if (l == 4L) {
      return "mono";
    }
    if (l == 3L) {
      return "stereo";
    }
    return String.format(Locale.US, "%x", new Object[] { Long.valueOf(this.mChannelLayout) });
  }
  
  public String getCodecLongNameInline()
  {
    if (!TextUtils.isEmpty(this.mCodecLongName)) {
      return this.mCodecLongName;
    }
    if (!TextUtils.isEmpty(this.mCodecName)) {
      return this.mCodecName;
    }
    return "N/A";
  }
  
  public String getCodecShortNameInline()
  {
    if (!TextUtils.isEmpty(this.mCodecName)) {
      return this.mCodecName;
    }
    return "N/A";
  }
  
  public String getFpsInline()
  {
    int i = this.mFpsNum;
    if (i > 0)
    {
      int j = this.mFpsDen;
      if (j > 0) {
        return String.valueOf(i / j);
      }
    }
    return "N/A";
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
  
  public String getResolutionInline()
  {
    if ((this.mWidth > 0) && (this.mHeight > 0))
    {
      if ((this.mSarNum > 0) && (this.mSarDen > 0)) {
        return String.format(Locale.US, "%d x %d [SAR %d:%d]", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mSarNum), Integer.valueOf(this.mSarDen) });
      }
      return String.format(Locale.US, "%d x %d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
    }
    return "N/A";
  }
  
  public String getSampleRateInline()
  {
    if (this.mSampleRate <= 0) {
      return "N/A";
    }
    return String.format(Locale.US, "%d Hz", new Object[] { Integer.valueOf(this.mSampleRate) });
  }
  
  public String getString(String paramString)
  {
    return this.mMeta.getString(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta
 * JD-Core Version:    0.7.0.1
 */