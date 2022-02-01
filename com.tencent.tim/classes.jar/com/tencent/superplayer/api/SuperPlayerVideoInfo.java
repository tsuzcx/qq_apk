package com.tencent.superplayer.api;

import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo.Section;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.ArrayList;
import java.util.Arrays;

public class SuperPlayerVideoInfo
  implements Cloneable
{
  public static final int AUDIO_VOD_FORMAT_MP3 = 107;
  public static final int VIDEO_FORMAT_UNKNOWN = 204;
  public static final int VIDEO_LIVE_FORMAT_FLV = 202;
  public static final int VIDEO_LIVE_FORMAT_HLS = 201;
  public static final int VIDEO_LIVE_FORMAT_UNKNOWN = 203;
  public static final int VIDEO_SOURCE_DIRECT_URL = 3;
  public static final int VIDEO_SOURCE_TVIDEO = 1;
  public static final int VIDEO_VOD_FORMAT_HLS = 102;
  public static final int VIDEO_VOD_FORMAT_MP4 = 101;
  public static final int VIDEO_VOD_FORMAT_RTMP = 103;
  public static final int VIDEO_VOD_FORMAT_UNKNOWN = 104;
  private int mBusiPlatform;
  private ArrayList<String> mCookies = null;
  private String mFileId;
  private int mFormat;
  private boolean mIsDisableTVideoCache;
  private String mLocalSavePath;
  private String mPid;
  private String[] mPlayUrls;
  private String mRequestDefinition;
  private TPDownloadParamData mTPDownloadParamData = null;
  private ITPMediaAsset mTPMediaAssert;
  private String mTVideoLoginCookie;
  private TVideoNetInfo mTVideoNetInfo;
  private ArrayList<TVKVideoInfo.Section> mTVideoSectionList;
  private ArrayList<String> mUrlHostList = null;
  private String mVid;
  private long mVideoDurationMs;
  private int mVideoSource;
  private int mVideoType;
  
  protected SuperPlayerVideoInfo(int paramInt)
  {
    this.mVideoSource = paramInt;
  }
  
  protected SuperPlayerVideoInfo(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mBusiPlatform = paramInt3;
    this.mVid = paramString;
  }
  
  protected SuperPlayerVideoInfo(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mBusiPlatform = paramInt3;
    this.mVid = paramString1;
    this.mPid = paramString2;
  }
  
  protected SuperPlayerVideoInfo(int paramInt1, int paramInt2, String paramString)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mBusiPlatform = SuperPlayerSDKMgr.getPlatform();
    this.mVid = paramString;
  }
  
  protected SuperPlayerVideoInfo(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mBusiPlatform = SuperPlayerSDKMgr.getPlatform();
    this.mVid = paramString1;
    this.mPid = paramString2;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    label130:
    label154:
    label178:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool1;
                        bool1 = bool3;
                      } while (paramObject == null);
                      bool1 = bool3;
                    } while (getClass() != paramObject.getClass());
                    paramObject = (SuperPlayerVideoInfo)paramObject;
                    bool1 = bool3;
                  } while (this.mVideoSource != paramObject.mVideoSource);
                  bool1 = bool3;
                } while (this.mVideoType != paramObject.mVideoType);
                bool1 = bool3;
              } while (this.mBusiPlatform != paramObject.mBusiPlatform);
              if (this.mVid == null) {
                break;
              }
              bool1 = bool3;
            } while (!this.mVid.equals(paramObject.mVid));
            if (this.mPid == null) {
              break label232;
            }
            bool1 = bool3;
          } while (!this.mPid.equals(paramObject.mPid));
          if (this.mRequestDefinition == null) {
            break label241;
          }
          bool1 = bool3;
        } while (!this.mRequestDefinition.equals(paramObject.mRequestDefinition));
        if (this.mLocalSavePath == null) {
          break label250;
        }
        bool1 = bool3;
      } while (!this.mLocalSavePath.equals(paramObject.mLocalSavePath));
      if (this.mFileId == null) {
        break label259;
      }
      bool1 = bool3;
    } while (!this.mFileId.equals(paramObject.mFileId));
    label202:
    if (this.mCookies != null) {
      bool1 = this.mCookies.equals(paramObject.mCookies);
    }
    for (;;)
    {
      return bool1;
      if (paramObject.mVid == null) {
        break;
      }
      return false;
      label232:
      if (paramObject.mPid == null) {
        break label130;
      }
      return false;
      label241:
      if (paramObject.mRequestDefinition == null) {
        break label154;
      }
      return false;
      label250:
      if (paramObject.mLocalSavePath == null) {
        break label178;
      }
      return false;
      label259:
      if (paramObject.mFileId == null) {
        break label202;
      }
      return false;
      bool1 = bool2;
      if (paramObject.mCookies != null) {
        bool1 = false;
      }
    }
  }
  
  public int getBusiPlatform()
  {
    return this.mBusiPlatform;
  }
  
  public ArrayList<String> getCookie()
  {
    return this.mCookies;
  }
  
  public String getFileId()
  {
    return this.mFileId;
  }
  
  public int getFormat()
  {
    return this.mFormat;
  }
  
  public boolean getIsDisableTVideoCache()
  {
    return this.mIsDisableTVideoCache;
  }
  
  public String getLocalSavePath()
  {
    return this.mLocalSavePath;
  }
  
  public ITPMediaAsset getMediaAssert()
  {
    return this.mTPMediaAssert;
  }
  
  public String getPid()
  {
    return this.mPid;
  }
  
  public String getPlayUrl()
  {
    if ((this.mPlayUrls != null) && (this.mPlayUrls.length > 0)) {
      return this.mPlayUrls[0];
    }
    return null;
  }
  
  public String[] getPlayUrls()
  {
    return this.mPlayUrls;
  }
  
  public String getRequestDefinition()
  {
    if (this.mRequestDefinition == null) {
      return "";
    }
    return this.mRequestDefinition;
  }
  
  public TPDownloadParamData getTPDownloadParamData()
  {
    return this.mTPDownloadParamData;
  }
  
  public String getTVideoLoginCookie()
  {
    return this.mTVideoLoginCookie;
  }
  
  public TVideoNetInfo getTVideoNetInfo()
  {
    return this.mTVideoNetInfo;
  }
  
  public ArrayList<TVKVideoInfo.Section> getTVideoSectionList()
  {
    return this.mTVideoSectionList;
  }
  
  public ArrayList<String> getUrlHostList()
  {
    return this.mUrlHostList;
  }
  
  public String getVid()
  {
    return this.mVid;
  }
  
  public long getVideoDurationMs()
  {
    return this.mVideoDurationMs;
  }
  
  public int getVideoSource()
  {
    return this.mVideoSource;
  }
  
  public int getVideoType()
  {
    return this.mVideoType;
  }
  
  public int hashCode()
  {
    int i1 = 0;
    int i2 = this.mVideoSource;
    int i3 = this.mVideoType;
    int i4 = this.mBusiPlatform;
    int i;
    int j;
    label51:
    int k;
    label66:
    int m;
    if (this.mVid != null)
    {
      i = this.mVid.hashCode();
      if (this.mPid == null) {
        break label167;
      }
      j = this.mPid.hashCode();
      if (this.mRequestDefinition == null) {
        break label172;
      }
      k = this.mRequestDefinition.hashCode();
      if (this.mLocalSavePath == null) {
        break label177;
      }
      m = this.mLocalSavePath.hashCode();
      label82:
      if (this.mFileId == null) {
        break label183;
      }
    }
    label167:
    label172:
    label177:
    label183:
    for (int n = this.mFileId.hashCode();; n = 0)
    {
      if (this.mCookies != null) {
        i1 = this.mCookies.hashCode();
      }
      return (n + (m + (k + (j + (i + ((i2 * 31 + i3) * 31 + i4) * 31) * 31) * 31) * 31) * 31) * 31 + i1;
      i = 0;
      break;
      j = 0;
      break label51;
      k = 0;
      break label66;
      m = 0;
      break label82;
    }
  }
  
  public void setBusiPlatform(int paramInt)
  {
    this.mBusiPlatform = paramInt;
  }
  
  public void setCookies(ArrayList<String> paramArrayList)
  {
    this.mCookies = paramArrayList;
  }
  
  public void setFileId(String paramString)
  {
    this.mFileId = paramString;
  }
  
  public void setFormat(int paramInt)
  {
    this.mFormat = paramInt;
  }
  
  public void setIsDisableTVideoCache(boolean paramBoolean)
  {
    this.mIsDisableTVideoCache = paramBoolean;
  }
  
  public void setLocalSavePath(String paramString)
  {
    this.mLocalSavePath = paramString;
  }
  
  public void setMediaAssert(ITPMediaAsset paramITPMediaAsset)
  {
    this.mTPMediaAssert = paramITPMediaAsset;
  }
  
  public void setPlayUrl(String paramString)
  {
    this.mPlayUrls = new String[] { paramString };
  }
  
  void setPlayUrl(String[] paramArrayOfString)
  {
    this.mPlayUrls = paramArrayOfString;
  }
  
  public void setRequestDefinition(String paramString)
  {
    this.mRequestDefinition = paramString;
  }
  
  public void setTPDownloadParamData(TPDownloadParamData paramTPDownloadParamData)
  {
    this.mTPDownloadParamData = paramTPDownloadParamData;
  }
  
  public void setTVideoLoginCookie(String paramString)
  {
    this.mTVideoLoginCookie = paramString;
  }
  
  public void setTVideoNetInfo(TVideoNetInfo paramTVideoNetInfo)
  {
    this.mTVideoNetInfo = paramTVideoNetInfo;
  }
  
  public void setTVideoSectionList(ArrayList<TVKVideoInfo.Section> paramArrayList)
  {
    this.mTVideoSectionList = paramArrayList;
  }
  
  public void setUrlHostList(ArrayList<String> paramArrayList)
  {
    this.mUrlHostList = paramArrayList;
  }
  
  public void setVideoDurationMs(long paramLong)
  {
    this.mVideoDurationMs = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("SuperPlayerVideoInfo[ mVideoSource:");
    if (this.mVideoSource == 1) {}
    for (String str = "tvideo";; str = "directUrl")
    {
      localStringBuilder2.append(str).append(", ");
      localStringBuilder1.append("mVideoType:").append(this.mVideoType).append(", ");
      localStringBuilder1.append("mBusiPlatform:").append(this.mBusiPlatform).append(", ");
      localStringBuilder1.append("mVid:").append(this.mVid).append(", ");
      localStringBuilder1.append("mPid:").append(this.mPid).append(", ");
      localStringBuilder1.append("mPlayUrls:").append(Arrays.toString(this.mPlayUrls)).append(", ");
      localStringBuilder1.append("mRequestDefn:").append(this.mRequestDefinition).append(" ");
      localStringBuilder1.append("mFormat:").append(this.mFormat).append(" ");
      localStringBuilder1.append("]");
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerVideoInfo
 * JD-Core Version:    0.7.0.1
 */