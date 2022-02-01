package com.tencent.qqlive.tvkplayer.vinfo;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TVKNetVideoInfo
  implements Serializable
{
  public static final int AUDIO_CODEC_FORMAT_AAC = 1;
  public static final int AUDIO_CODEC_FORMAT_DOLBY_ATMOS = 3;
  public static final int AUDIO_CODEC_FORMAT_DOLBY_SURROUND = 2;
  public static final String FORMAT_AUDIO = "audio";
  public static final String FORMAT_FHD = "fhd";
  public static final String FORMAT_HD = "hd";
  public static final String FORMAT_HDR10 = "hdr10";
  public static final String FORMAT_MP4 = "mp4";
  public static final String FORMAT_MSD = "msd";
  public static final String FORMAT_SD = "sd";
  public static final String FORMAT_SHD = "shd";
  public static final int TYPE_JSON = 1;
  public static final int TYPE_PICTURE_NODE = 3;
  public static final int TYPE_XML = 2;
  public static final int VIDEO_CODEC_FORMAT_AUDIO = 5;
  public static final int VIDEO_CODEC_FORMAT_DOLLBYVISION = 4;
  public static final int VIDEO_CODEC_FORMAT_H264 = 1;
  public static final int VIDEO_CODEC_FORMAT_H265 = 2;
  public static final int VIDEO_CODEC_FORMAT_HDR10 = 3;
  public static final int VIDEO_CODEC_FORMAT_SDR = 7;
  public static final int VIDEO_CODEC_FORMAT_SDRPLUS = 6;
  public static final int VIDEO_HDR_TONEMAPPING_SUPPORT = 1;
  private static final long serialVersionUID = -1L;
  private ArrayList<AudioTrackInfo> mAudioTrackList;
  private TVKCGIVideoInfo mCGIVideoInfo;
  private int mChargeState = 0;
  private AudioTrackInfo mCurAudioTrack;
  private DefnInfo mCurDefinition;
  private SubTitle mCurSubtitle = null;
  private int mDanmuState = 0;
  private ArrayList<DefnInfo> mDefinitionList;
  private int mDuration = 0;
  private int mEndPos;
  private String mErrInfo;
  private String mErrTitle;
  private int mExem;
  private long mFileSize = 0L;
  private int mHlsP2p;
  private int mIRetDetailCode = 0;
  private boolean mIsHevc;
  private boolean mIsLocalVideo = false;
  private int mIsPay = 0;
  private int mLimit = 0;
  private String mLnk;
  private int mMediaVideoState;
  private int mNeedPay = 0;
  private String mPLString;
  private int mPLType = 0;
  private Object mPicList;
  private long mPlayBackStart;
  private long mPlayBackTime;
  private long mPlayTime;
  private int mPrePlayCountPerDay = 0;
  private long mPrePlayEndPos;
  private long mPrePlayStartPos;
  private long mPrePlayTime = 0L;
  private int mQueueRank;
  private String mQueueSessionKey;
  private int mQueueStatus;
  private int mQueueVipJump;
  private int mRestPrePlayCount = 0;
  private int mRetCode;
  private int mStartPos;
  private int mState = 2;
  private int mStatus;
  private int mSubErrType;
  private ArrayList<SubTitle> mSubTitleList = new ArrayList();
  private long mSvrTick;
  private int mTestId;
  private int mTie;
  private String mTitle;
  private String mVid;
  private HashMap<Integer, String> mVideoDownloadHostMap = new HashMap();
  private int mVideoType;
  private int mVst = 0;
  private float mWHRadio;
  private String mWanIP;
  private ArrayList<TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo> mWatermarkInfos;
  
  public void addAudioTrack(AudioTrackInfo paramAudioTrackInfo)
  {
    if (this.mAudioTrackList == null) {
      this.mAudioTrackList = new ArrayList();
    }
    this.mAudioTrackList.add(paramAudioTrackInfo);
  }
  
  public void addDefinition(DefnInfo paramDefnInfo)
  {
    if (this.mDefinitionList == null) {
      this.mDefinitionList = new ArrayList();
    }
    this.mDefinitionList.add(paramDefnInfo);
  }
  
  public void addSubTitle(SubTitle paramSubTitle)
  {
    this.mSubTitleList.add(paramSubTitle);
  }
  
  public void addVideoDownloadHostItem(Integer paramInteger, String paramString)
  {
    this.mVideoDownloadHostMap.put(paramInteger, paramString);
  }
  
  public AudioTrackInfo getAudioTrackByTrackName(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.mAudioTrackList == null) || (this.mAudioTrackList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.mAudioTrackList.iterator();
    while (localIterator.hasNext())
    {
      AudioTrackInfo localAudioTrackInfo = (AudioTrackInfo)localIterator.next();
      if (localAudioTrackInfo.mAudioTrack.equals(paramString)) {
        return localAudioTrackInfo;
      }
    }
    return null;
  }
  
  public List<AudioTrackInfo> getAudioTrackList()
  {
    return this.mAudioTrackList;
  }
  
  public TVKCGIVideoInfo getCGIVideoInfo()
  {
    return this.mCGIVideoInfo;
  }
  
  public AudioTrackInfo getCurAudioTrack()
  {
    return this.mCurAudioTrack;
  }
  
  public DefnInfo getCurDefinition()
  {
    return this.mCurDefinition;
  }
  
  public SubTitle getCurSubtitle()
  {
    return this.mCurSubtitle;
  }
  
  public int getDanmuState()
  {
    return this.mDanmuState;
  }
  
  public ArrayList<DefnInfo> getDefinitionList()
  {
    return this.mDefinitionList;
  }
  
  public int getDuration()
  {
    return this.mDuration;
  }
  
  public int getEndPos()
  {
    return this.mEndPos;
  }
  
  public String getErrInfo()
  {
    return this.mErrInfo;
  }
  
  public String getErrtitle()
  {
    return this.mErrTitle;
  }
  
  public int getExem()
  {
    return this.mExem;
  }
  
  public long getFileSize()
  {
    return this.mFileSize;
  }
  
  public int getHlsp2p()
  {
    return this.mHlsP2p;
  }
  
  public int getIretDetailCode()
  {
    return this.mIRetDetailCode;
  }
  
  public int getIsPay()
  {
    return this.mIsPay;
  }
  
  public int getLimit()
  {
    return this.mLimit;
  }
  
  public String getLnk()
  {
    return this.mLnk;
  }
  
  public int getMediaVideoState()
  {
    return this.mMediaVideoState;
  }
  
  public int getMediaVideoType()
  {
    return this.mVideoType;
  }
  
  public int getNeedPay()
  {
    return this.mNeedPay;
  }
  
  public String getPLString()
  {
    return this.mPLString;
  }
  
  public int getPLType()
  {
    return this.mPLType;
  }
  
  public int getPayCh()
  {
    return this.mChargeState;
  }
  
  public Object getPictureList()
  {
    return this.mPicList;
  }
  
  public long getPlayBackStart()
  {
    return this.mPlayBackStart;
  }
  
  public long getPlayBackTime()
  {
    return this.mPlayBackTime;
  }
  
  public long getPlayTime()
  {
    return this.mPlayTime;
  }
  
  public int getPrePlayCountPerDay()
  {
    return this.mPrePlayCountPerDay;
  }
  
  public long getPrePlayEndPos()
  {
    return this.mPrePlayEndPos;
  }
  
  public long getPrePlayStartPos()
  {
    return this.mPrePlayStartPos;
  }
  
  public long getPrePlayTime()
  {
    return this.mPrePlayTime;
  }
  
  public int getQueueRank()
  {
    return this.mQueueRank;
  }
  
  public String getQueueSessionKey()
  {
    return this.mQueueSessionKey;
  }
  
  public int getQueueStatus()
  {
    return this.mQueueStatus;
  }
  
  public int getQueueVipJump()
  {
    return this.mQueueVipJump;
  }
  
  public int getRestPrePlayCount()
  {
    return this.mRestPrePlayCount;
  }
  
  public int getRetCode()
  {
    return this.mRetCode;
  }
  
  public int getSt()
  {
    return this.mState;
  }
  
  public int getStartPos()
  {
    return this.mStartPos;
  }
  
  public int getStatus()
  {
    return this.mStatus;
  }
  
  public int getSubErrType()
  {
    return this.mSubErrType;
  }
  
  public SubTitle getSubIndex(String paramString)
  {
    Iterator localIterator = this.mSubTitleList.iterator();
    while (localIterator.hasNext())
    {
      SubTitle localSubTitle = (SubTitle)localIterator.next();
      if (localSubTitle.getmLang().equalsIgnoreCase(paramString)) {
        return localSubTitle;
      }
    }
    return null;
  }
  
  public ArrayList<SubTitle> getSubTitleList()
  {
    return this.mSubTitleList;
  }
  
  public long getSvrTick()
  {
    return this.mSvrTick;
  }
  
  public int getTestId()
  {
    return this.mTestId;
  }
  
  public int getTie()
  {
    return this.mTie;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public String getVid()
  {
    return this.mVid;
  }
  
  public HashMap<Integer, String> getVideoDownloadHostMap()
  {
    return this.mVideoDownloadHostMap;
  }
  
  public int getVst()
  {
    return this.mVst;
  }
  
  public float getWHRadio()
  {
    return this.mWHRadio;
  }
  
  public String getWanIP()
  {
    return this.mWanIP;
  }
  
  public ArrayList<TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo> getWatermarkInfos()
  {
    return this.mWatermarkInfos;
  }
  
  public boolean isHevc()
  {
    return this.mIsHevc;
  }
  
  public boolean isLocalVideo()
  {
    return this.mIsLocalVideo;
  }
  
  public void removeAudioTrack(AudioTrackInfo paramAudioTrackInfo)
  {
    if (this.mAudioTrackList == null) {
      return;
    }
    this.mAudioTrackList.remove(paramAudioTrackInfo);
  }
  
  public void removeDefinition(DefnInfo paramDefnInfo)
  {
    if (this.mDefinitionList == null)
    {
      this.mDefinitionList = new ArrayList();
      return;
    }
    this.mDefinitionList.remove(paramDefnInfo);
  }
  
  public void setCGIVideoInfo(TVKCGIVideoInfo paramTVKCGIVideoInfo)
  {
    this.mCGIVideoInfo = paramTVKCGIVideoInfo;
  }
  
  public void setCurAudioTrack(AudioTrackInfo paramAudioTrackInfo)
  {
    this.mCurAudioTrack = paramAudioTrackInfo;
  }
  
  public void setCurDefinition(DefnInfo paramDefnInfo)
  {
    this.mCurDefinition = paramDefnInfo;
  }
  
  public void setCurSubtitle(SubTitle paramSubTitle)
  {
    this.mCurSubtitle = paramSubTitle;
  }
  
  public void setDanmuState(int paramInt)
  {
    this.mDanmuState = paramInt;
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  public void setEndPos(int paramInt)
  {
    this.mEndPos = paramInt;
  }
  
  public void setErrInfo(String paramString)
  {
    this.mErrInfo = paramString;
  }
  
  public void setErrtitle(String paramString)
  {
    this.mErrTitle = paramString;
  }
  
  public void setExem(int paramInt)
  {
    this.mExem = paramInt;
  }
  
  public void setFileSize(long paramLong)
  {
    this.mFileSize = paramLong;
  }
  
  public void setHlsp2p(int paramInt)
  {
    this.mHlsP2p = paramInt;
  }
  
  public void setIretDetailCode(int paramInt)
  {
    this.mIRetDetailCode = paramInt;
  }
  
  public void setIsHevc(boolean paramBoolean)
  {
    this.mIsHevc = paramBoolean;
  }
  
  public void setLimit(int paramInt)
  {
    this.mLimit = paramInt;
  }
  
  public void setLnk(String paramString)
  {
    this.mLnk = paramString;
  }
  
  public void setLocalVideo(boolean paramBoolean)
  {
    this.mIsLocalVideo = paramBoolean;
  }
  
  public void setMediaVideoState(int paramInt)
  {
    this.mMediaVideoState = paramInt;
  }
  
  public void setMediaVideoType(int paramInt)
  {
    this.mVideoType = paramInt;
  }
  
  public void setNeedPay(int paramInt)
  {
    this.mNeedPay = paramInt;
  }
  
  public void setPLString(String paramString)
  {
    this.mPLString = paramString;
  }
  
  public void setPLType(int paramInt)
  {
    this.mPLType = paramInt;
  }
  
  public void setPay(int paramInt)
  {
    this.mIsPay = paramInt;
  }
  
  public void setPayCh(int paramInt)
  {
    this.mChargeState = paramInt;
  }
  
  public void setPictureList(Object paramObject)
  {
    this.mPicList = paramObject;
  }
  
  public void setPlayBackStart(long paramLong)
  {
    this.mPlayBackStart = paramLong;
  }
  
  public void setPlayBackTime(long paramLong)
  {
    this.mPlayBackTime = paramLong;
  }
  
  public void setPlayTime(long paramLong)
  {
    this.mPlayTime = paramLong;
  }
  
  public void setPrePlayCountPerDay(int paramInt)
  {
    this.mPrePlayCountPerDay = paramInt;
  }
  
  public void setPrePlayEndPos(long paramLong)
  {
    this.mPrePlayEndPos = paramLong;
  }
  
  public void setPrePlayStartPos(long paramLong)
  {
    this.mPrePlayStartPos = paramLong;
  }
  
  public void setPrePlayTime(long paramLong)
  {
    this.mPrePlayTime = paramLong;
  }
  
  public void setQueueRank(int paramInt)
  {
    this.mQueueRank = paramInt;
  }
  
  public void setQueueSessionKey(String paramString)
  {
    this.mQueueSessionKey = paramString;
  }
  
  public void setQueueStatus(int paramInt)
  {
    this.mQueueStatus = paramInt;
  }
  
  public void setQueueVipJump(int paramInt)
  {
    this.mQueueVipJump = paramInt;
  }
  
  public void setRestPrePlayCount(int paramInt)
  {
    this.mRestPrePlayCount = paramInt;
  }
  
  public void setRetCode(int paramInt)
  {
    this.mRetCode = paramInt;
  }
  
  public void setSt(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public void setStartPos(int paramInt)
  {
    this.mStartPos = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  public void setSubErrType(int paramInt)
  {
    this.mSubErrType = paramInt;
  }
  
  public void setSvrTick(long paramLong)
  {
    this.mSvrTick = paramLong;
  }
  
  public void setTestId(int paramInt)
  {
    this.mTestId = paramInt;
  }
  
  public void setTie(int paramInt)
  {
    this.mTie = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
  }
  
  public void setVid(String paramString)
  {
    this.mVid = paramString;
  }
  
  public void setVst(int paramInt)
  {
    this.mVst = paramInt;
  }
  
  public void setWHRadio(float paramFloat)
  {
    this.mWHRadio = paramFloat;
  }
  
  public void setWanIP(String paramString)
  {
    this.mWanIP = paramString;
  }
  
  public void setWatermarkInfos(ArrayList<TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo> paramArrayList)
  {
    this.mWatermarkInfos = paramArrayList;
  }
  
  public static class AudioTrackInfo
    implements Serializable
  {
    public static final int AAC = 1;
    public static final int DOLBY_ATMOS = 3;
    public static final int DOLBY_SURROUND = 2;
    private static final long serialVersionUID = -1L;
    private String mAction = null;
    private String mAudioPlayUrl = null;
    private long mAudioPrePlayTime;
    private String mAudioShowName;
    private String mAudioTrack;
    private int mAudioType;
    private ArrayList<String> mAudioUrlList = null;
    private int mIsVip;
    private String mKeyId;
    
    public String getAction()
    {
      return this.mAction;
    }
    
    public String getAudioPlayUrl()
    {
      return this.mAudioPlayUrl;
    }
    
    public long getAudioPrePlayTime()
    {
      return this.mAudioPrePlayTime;
    }
    
    public String getAudioShowName()
    {
      return this.mAudioShowName;
    }
    
    public String getAudioTrack()
    {
      return this.mAudioTrack;
    }
    
    public int getAudioType()
    {
      return this.mAudioType;
    }
    
    public ArrayList<String> getAudioUrlList()
    {
      return this.mAudioUrlList;
    }
    
    public String getKeyId()
    {
      return this.mKeyId;
    }
    
    public boolean isSameAudio(AudioTrackInfo paramAudioTrackInfo)
    {
      return ((paramAudioTrackInfo == null) && (TextUtils.isEmpty(this.mAudioTrack))) || ((paramAudioTrackInfo != null) && (TextUtils.isEmpty(paramAudioTrackInfo.getAudioTrack())) && (TextUtils.isEmpty(this.mAudioTrack))) || ((paramAudioTrackInfo != null) && (this.mAudioTrack != null) && (this.mAudioTrack.equals(paramAudioTrackInfo.getAudioTrack())));
    }
    
    public int isVip()
    {
      return this.mIsVip;
    }
    
    public void setAction(String paramString)
    {
      this.mAction = paramString;
    }
    
    public void setAudioPrePlayTime(long paramLong)
    {
      this.mAudioPrePlayTime = paramLong;
    }
    
    public void setAudioShowName(String paramString)
    {
      this.mAudioShowName = paramString;
    }
    
    public void setAudioTrack(String paramString)
    {
      this.mAudioTrack = paramString;
    }
    
    public void setAudioType(int paramInt)
    {
      this.mAudioType = paramInt;
    }
    
    public void setAudioUrlList(ArrayList<String> paramArrayList)
    {
      this.mAudioUrlList = paramArrayList;
      if ((this.mAudioUrlList == null) || (this.mAudioUrlList.size() == 0))
      {
        this.mAudioPlayUrl = null;
        return;
      }
      this.mAudioPlayUrl = ((String)this.mAudioUrlList.get(0));
    }
    
    public void setKeyId(String paramString)
    {
      this.mKeyId = paramString;
    }
    
    public void setVip(int paramInt)
    {
      this.mIsVip = paramInt;
    }
  }
  
  public static class DefnInfo
    implements Serializable, Cloneable
  {
    private static final long serialVersionUID = -1L;
    private int drm;
    private int isVip;
    private int mAudioCodec;
    private String mDefn;
    private int mDefnId;
    private String mDefnName;
    private String mDefnRate;
    private String mDefnShowName;
    private long mFileSize;
    private int mHdr10EnHance;
    private int mVideoCodec;
    
    public Object clone()
    {
      try
      {
        DefnInfo localDefnInfo = (DefnInfo)super.clone();
        return localDefnInfo;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        localCloneNotSupportedException.printStackTrace();
      }
      return null;
    }
    
    public int getAudioCodec()
    {
      return this.mAudioCodec;
    }
    
    public String getDefn()
    {
      return this.mDefn;
    }
    
    public int getDefnId()
    {
      return this.mDefnId;
    }
    
    public String getDefnName()
    {
      return this.mDefnName;
    }
    
    public String getDefnRate()
    {
      return this.mDefnRate;
    }
    
    public String getDefnShowName()
    {
      return this.mDefnShowName;
    }
    
    public int getDrm()
    {
      return this.drm;
    }
    
    public long getFileSize()
    {
      return this.mFileSize;
    }
    
    public String getFnName()
    {
      return this.mDefnName;
    }
    
    public int getHdr10EnHance()
    {
      return this.mHdr10EnHance;
    }
    
    public int getVideoCodec()
    {
      return this.mVideoCodec;
    }
    
    public boolean isAudioOnly()
    {
      return "audio".equalsIgnoreCase(this.mDefn);
    }
    
    public int isVip()
    {
      return this.isVip;
    }
    
    public void setAudioCodec(int paramInt)
    {
      this.mAudioCodec = paramInt;
    }
    
    public void setDefn(String paramString)
    {
      this.mDefn = paramString;
    }
    
    public void setDefnId(int paramInt)
    {
      this.mDefnId = paramInt;
    }
    
    public void setDefnName(String paramString)
    {
      this.mDefnName = paramString;
    }
    
    public void setDefnRate(String paramString)
    {
      this.mDefnRate = paramString;
    }
    
    public void setDefnShowName(String paramString)
    {
      this.mDefnShowName = paramString;
    }
    
    public void setDrm(int paramInt)
    {
      this.drm = paramInt;
    }
    
    public void setFileSize(long paramLong)
    {
      this.mFileSize = paramLong;
    }
    
    public void setFnName(String paramString)
    {
      this.mDefnName = paramString;
    }
    
    public void setHdr10EnHance(int paramInt)
    {
      this.mHdr10EnHance = paramInt;
    }
    
    public void setVideoCodec(int paramInt)
    {
      this.mVideoCodec = paramInt;
    }
    
    public void setVip(int paramInt)
    {
      this.isVip = paramInt;
    }
  }
  
  public static class SubTitle
    implements Serializable
  {
    private float mCaptionBottomHPercent;
    private float mCaptionTopHPercent;
    private String mKeyId;
    private String mLang;
    private String mName;
    private String mSubTitle;
    private List<String> mUrlList;
    
    public float getCaptionBottomHPercent()
    {
      return this.mCaptionBottomHPercent;
    }
    
    public float getCaptionTopHPercent()
    {
      return this.mCaptionTopHPercent;
    }
    
    public List<String> getUrlList()
    {
      return this.mUrlList;
    }
    
    public String getmKeyId()
    {
      return this.mKeyId;
    }
    
    public String getmLang()
    {
      return this.mLang;
    }
    
    public String getmName()
    {
      return this.mName;
    }
    
    public String getmSubTitle()
    {
      return this.mSubTitle;
    }
    
    public void setCaptionBottomHPercent(float paramFloat)
    {
      this.mCaptionBottomHPercent = paramFloat;
    }
    
    public void setCaptionTopHPercent(float paramFloat)
    {
      this.mCaptionTopHPercent = paramFloat;
    }
    
    public void setUrlList(List<String> paramList)
    {
      this.mUrlList = paramList;
    }
    
    public void setmKeyId(String paramString)
    {
      this.mKeyId = paramString;
    }
    
    public void setmLang(String paramString)
    {
      this.mLang = paramString;
    }
    
    public void setmName(String paramString)
    {
      this.mName = paramString;
    }
    
    public void setmSubTitle(String paramString)
    {
      this.mSubTitle = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo
 * JD-Core Version:    0.7.0.1
 */