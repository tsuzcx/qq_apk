package com.tencent.qqlive.tvkplayer.vinfo;

import android.support.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.playerwrapper.player.TVKMediaSource;
import com.tencent.qqlive.tvkplayer.playerwrapper.player.TVKPlayerCommonEnum;
import java.io.ByteArrayInputStream;
import java.util.Properties;

public class TVKPlaybackInfo
{
  private int mBufferPercent;
  private String mCurAudioTrack;
  private int mDownloadSpeedKBps;
  private boolean mEnableDrm;
  private int mEnableHDREnhance;
  private boolean mIsPrePlay;
  private long mLastPosition;
  private int mLivePlayType;
  private int mMediaFormat;
  private MediaInfo mMediaInfo;
  private int mMediaPayType;
  private TVKMediaSource mMediaSource;
  private TVKNetVideoInfo mNetVideoInfo;
  private long mPlayedTime;
  private PlayerInfo mPlayerInfo;
  private RequestInfo mRequestInfo;
  private int mSeekModWhenPrepared;
  private long mSeekPosWhenPrepared;
  
  public TVKPlaybackInfo()
  {
    init();
  }
  
  private void init()
  {
    this.mMediaInfo = new MediaInfo();
    this.mPlayerInfo = new PlayerInfo();
    this.mMediaFormat = 0;
    this.mMediaSource = null;
    this.mMediaPayType = 1;
    this.mNetVideoInfo = new TVKNetVideoInfo();
    this.mRequestInfo = new RequestInfo();
    this.mPlayedTime = 0L;
    this.mCurAudioTrack = null;
    this.mSeekPosWhenPrepared = 0L;
    this.mSeekModWhenPrepared = 0;
    this.mEnableHDREnhance = 0;
    this.mIsPrePlay = false;
  }
  
  void clear()
  {
    init();
  }
  
  String currentAudioTrack()
  {
    return this.mCurAudioTrack;
  }
  
  void currentAudioTrack(String paramString)
  {
    this.mCurAudioTrack = paramString;
  }
  
  void enableDrm(boolean paramBoolean)
  {
    this.mEnableDrm = paramBoolean;
  }
  
  boolean enableDrm()
  {
    return this.mEnableDrm;
  }
  
  int enableHDREnhance()
  {
    return this.mEnableHDREnhance;
  }
  
  void enableHDREnhance(int paramInt)
  {
    this.mEnableHDREnhance = paramInt;
  }
  
  public int getBufferPercent()
  {
    return this.mBufferPercent;
  }
  
  public int getDownloadSpeedKBps()
  {
    return this.mDownloadSpeedKBps;
  }
  
  boolean isHDR10()
  {
    return (this.mNetVideoInfo != null) && (this.mNetVideoInfo.getCurDefinition() != null) && (this.mNetVideoInfo.getCurDefinition().getDefn().equals("hdr10")) && (this.mNetVideoInfo.getCurDefinition().getVideoCodec() == 3);
  }
  
  boolean isHevc()
  {
    return (this.mNetVideoInfo != null) && (this.mNetVideoInfo.isHevc());
  }
  
  boolean isPrePlay()
  {
    return this.mIsPrePlay;
  }
  
  void isPreplay(boolean paramBoolean)
  {
    this.mIsPrePlay = paramBoolean;
  }
  
  long lastPosition()
  {
    return this.mLastPosition;
  }
  
  void lastPosition(long paramLong)
  {
    this.mLastPosition = paramLong;
  }
  
  int livePlayType()
  {
    return this.mLivePlayType;
  }
  
  void livePlayType(int paramInt)
  {
    this.mLivePlayType = paramInt;
  }
  
  int mediaFormat()
  {
    return this.mMediaFormat;
  }
  
  void mediaFormat(int paramInt)
  {
    this.mMediaFormat = paramInt;
  }
  
  MediaInfo mediaInfo()
  {
    return this.mMediaInfo;
  }
  
  int mediaPayType()
  {
    return this.mMediaPayType;
  }
  
  void mediaPayType(int paramInt)
  {
    this.mMediaPayType = paramInt;
  }
  
  TVKMediaSource mediaSource()
  {
    return this.mMediaSource;
  }
  
  void mediaSource(@NonNull TVKMediaSource paramTVKMediaSource)
  {
    this.mMediaSource = paramTVKMediaSource;
  }
  
  TVKNetVideoInfo netVideoInfo()
  {
    return this.mNetVideoInfo;
  }
  
  void netVideoInfo(TVKNetVideoInfo paramTVKNetVideoInfo)
  {
    this.mNetVideoInfo = paramTVKNetVideoInfo;
  }
  
  long playedTime()
  {
    return this.mPlayedTime;
  }
  
  void playedTime(long paramLong)
  {
    this.mPlayedTime = paramLong;
  }
  
  PlayerInfo playerInfo()
  {
    return this.mPlayerInfo;
  }
  
  public RequestInfo requestInfo()
  {
    return this.mRequestInfo;
  }
  
  int seekModWhenPrepared()
  {
    return this.mSeekModWhenPrepared;
  }
  
  void seekModWhenPrepared(int paramInt)
  {
    this.mSeekModWhenPrepared = paramInt;
  }
  
  long seekPosWhenPrepared()
  {
    return this.mSeekPosWhenPrepared;
  }
  
  void seekPosWhenPrepared(long paramLong)
  {
    this.mSeekPosWhenPrepared = paramLong;
  }
  
  public void setBufferPercent(int paramInt)
  {
    this.mBufferPercent = paramInt;
  }
  
  public void setDownloadSpeedKBps(int paramInt)
  {
    this.mDownloadSpeedKBps = paramInt;
  }
  
  static class MediaInfo
  {
    private long audioBitRate;
    private String audioCodec;
    private String audioProfile;
    private int channels;
    private String codecMimeType;
    private String containerFormat;
    private long durationMs;
    private int height;
    private String mediaInfoStr;
    private long sampleRate;
    private long videoBitRate;
    private String videoCodec;
    private String videoProfile;
    private int videoRotation;
    private int width;
    
    long audioBitRate()
    {
      return this.audioBitRate;
    }
    
    String audioCodec()
    {
      return this.audioCodec;
    }
    
    String audioProfile()
    {
      return this.audioProfile;
    }
    
    int channels()
    {
      return this.channels;
    }
    
    String codecMimeType()
    {
      return this.codecMimeType;
    }
    
    String containerFormat()
    {
      return this.containerFormat;
    }
    
    long duration()
    {
      return this.durationMs;
    }
    
    void duration(long paramLong)
    {
      this.durationMs = paramLong;
    }
    
    String mediaInfoStr()
    {
      return this.mediaInfoStr;
    }
    
    void mediaInfoStr(String paramString)
    {
      try
      {
        this.mediaInfoStr = paramString;
        Properties localProperties = new Properties();
        localProperties.load(new ByteArrayInputStream(paramString.getBytes()));
        this.containerFormat = localProperties.getProperty("ContainerFormat", "");
        this.videoCodec = localProperties.getProperty("VideoCodec", "");
        this.videoProfile = localProperties.getProperty("VideoProfile", "");
        this.width = Integer.valueOf(localProperties.getProperty("Width")).intValue();
        this.height = Integer.valueOf(localProperties.getProperty("Height")).intValue();
        this.videoBitRate = Long.valueOf(localProperties.getProperty("VideoBitRate")).longValue();
        this.audioCodec = localProperties.getProperty("AudioCodec");
        this.audioProfile = localProperties.getProperty("AudioProfile", "");
        this.audioBitRate = Long.valueOf(localProperties.getProperty("AudioBitRate")).longValue();
        this.channels = Integer.valueOf(localProperties.getProperty("Channels")).intValue();
        this.sampleRate = Long.valueOf(localProperties.getProperty("SampleRate")).longValue();
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.mediaInfoStr = "";
      }
    }
    
    long sampleRate()
    {
      return this.sampleRate;
    }
    
    long videoBitRate()
    {
      return this.videoBitRate;
    }
    
    String videoCodec()
    {
      return this.videoCodec;
    }
    
    int videoHeight()
    {
      return this.height;
    }
    
    void videoHeight(int paramInt)
    {
      this.height = paramInt;
    }
    
    String videoProfile()
    {
      return this.videoProfile;
    }
    
    int videoRotation()
    {
      return this.videoRotation;
    }
    
    void videoRotation(int paramInt)
    {
      this.videoRotation = paramInt;
    }
    
    int videoWidth()
    {
      return this.width;
    }
    
    void videoWidth(int paramInt)
    {
      this.width = paramInt;
    }
  }
  
  static class PlayerInfo
  {
    private int audioDecoderType = TVKPlayerCommonEnum.PLAYER_DECODER_UNKNOWN;
    private boolean dumped;
    private int playerType = 0;
    private int videoDecoderType = TVKPlayerCommonEnum.PLAYER_DECODER_UNKNOWN;
    
    int audioDecoderType()
    {
      return this.audioDecoderType;
    }
    
    void audioDecoderType(int paramInt)
    {
      this.audioDecoderType = paramInt;
    }
    
    void dumped(boolean paramBoolean)
    {
      this.dumped = paramBoolean;
    }
    
    boolean dumped()
    {
      return this.dumped;
    }
    
    int playerType()
    {
      return this.playerType;
    }
    
    void playerType(int paramInt)
    {
      this.playerType = paramInt;
    }
    
    int videoDecoderType()
    {
      return this.videoDecoderType;
    }
    
    void videoDecoderType(int paramInt)
    {
      this.videoDecoderType = paramInt;
    }
  }
  
  public static class RequestInfo
  {
    private String audioTrack;
    private String definition;
    private boolean dolbyEnable;
    private boolean drmEnable;
    private String flowId;
    private int formatId;
    private boolean h265Enable;
    private boolean hdr10Enable;
    private Object tag;
    
    RequestInfo()
    {
      flowId("");
      formatId(0);
      definition("");
      h265Enable(true);
      dolbyEnable(true);
      audioTrack("");
      drmEnable(true);
      hdr10Enable(true);
    }
    
    String audioTrack()
    {
      return this.audioTrack;
    }
    
    void audioTrack(String paramString)
    {
      this.audioTrack = paramString;
    }
    
    RequestInfo copy()
    {
      RequestInfo localRequestInfo = new RequestInfo();
      localRequestInfo.flowId = this.flowId;
      localRequestInfo.formatId = this.formatId;
      localRequestInfo.definition = this.definition;
      localRequestInfo.h265Enable = this.h265Enable;
      localRequestInfo.dolbyEnable = this.dolbyEnable;
      localRequestInfo.audioTrack = this.audioTrack;
      localRequestInfo.drmEnable = this.drmEnable;
      localRequestInfo.hdr10Enable = this.hdr10Enable;
      localRequestInfo.tag = this.tag;
      return localRequestInfo;
    }
    
    void copyFrom(RequestInfo paramRequestInfo)
    {
      flowId(paramRequestInfo.flowId);
      formatId(paramRequestInfo.formatId);
      definition(paramRequestInfo.definition);
      h265Enable(paramRequestInfo.h265Enable);
      dolbyEnable(paramRequestInfo.dolbyEnable);
      audioTrack(paramRequestInfo.audioTrack);
      drmEnable(paramRequestInfo.drmEnable);
      hdr10Enable(paramRequestInfo.hdr10Enable);
    }
    
    String definition()
    {
      return this.definition;
    }
    
    public void definition(String paramString)
    {
      this.definition = paramString;
    }
    
    void dolbyEnable(boolean paramBoolean)
    {
      this.dolbyEnable = paramBoolean;
    }
    
    boolean dolbyEnable()
    {
      return this.dolbyEnable;
    }
    
    void drmEnable(boolean paramBoolean)
    {
      this.drmEnable = paramBoolean;
    }
    
    boolean drmEnable()
    {
      return this.drmEnable;
    }
    
    String flowId()
    {
      return this.flowId;
    }
    
    public void flowId(String paramString)
    {
      this.flowId = paramString;
    }
    
    int formatId()
    {
      return this.formatId;
    }
    
    public void formatId(int paramInt)
    {
      this.formatId = paramInt;
    }
    
    void h265Enable(boolean paramBoolean)
    {
      this.h265Enable = paramBoolean;
    }
    
    boolean h265Enable()
    {
      return this.h265Enable;
    }
    
    void hdr10Enable(boolean paramBoolean)
    {
      this.hdr10Enable = paramBoolean;
    }
    
    boolean hdr10Enable()
    {
      return this.hdr10Enable;
    }
    
    public Object tag()
    {
      return this.tag;
    }
    
    public void tag(Object paramObject)
    {
      this.tag = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo
 * JD-Core Version:    0.7.0.1
 */