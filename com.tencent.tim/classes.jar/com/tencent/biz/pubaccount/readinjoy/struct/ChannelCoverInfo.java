package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;

public class ChannelCoverInfo
  extends Entity
  implements Cloneable
{
  public static final String FILTER_COLOR = "filterColor";
  public static final String TABLE_NAME = ChannelCoverInfo.class.getSimpleName();
  public final String TAG = "ChannelCoverInfo";
  public String externalExposureBackgroundUrl = "";
  public int filterColor;
  public boolean hasFilterColor;
  @notColumn
  public boolean isCurrent;
  public boolean isExternalExposure;
  public boolean isExternalExposurePersist;
  public boolean isReport;
  @notColumn
  public boolean isSelected;
  public long mArticleId = -1L;
  public String mChannelCoverIcon = "";
  public int mChannelCoverId = -1;
  public String mChannelCoverName = "";
  public String mChannelCoverPicUrl = "";
  public String mChannelCoverSpec = "";
  public int mChannelCoverStyle;
  public String mChannelCoverSummary = "";
  public int mChannelId = -1;
  public String mChannelJumpUrl = "";
  public int mChannelType = -1;
  public String mChannelVersion = "0";
  public int mColumnType = -1;
  public int mFollowType = -1;
  public int mFontColor = -1291845632;
  public int mFrameColor = -3355444;
  public String mIconUrl = "";
  public boolean mIsTopic;
  public long mPreUpdateTime = -1L;
  public String mTipsText = "";
  public int mTipsType = -1;
  public long mUpdateTime;
  @notColumn
  public int position;
  
  public ChannelCoverInfo clone()
  {
    try
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)super.clone();
      return localChannelCoverInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      QLog.e("ChannelCoverInfo", 1, "clone error,mes:" + localCloneNotSupportedException.toString());
    }
    return null;
  }
  
  public String toString()
  {
    return "ChannelCoverInfo{mChannelId=" + this.mChannelId + ", mChannelCoverId=" + this.mChannelCoverId + ", mChannelCoverName='" + this.mChannelCoverName + '\'' + ", mChannelCoverStyle=" + this.mChannelCoverStyle + ", mChannelCoverSummary='" + this.mChannelCoverSummary + '\'' + ", mChannelCoverPicUrl='" + this.mChannelCoverPicUrl + '\'' + ", mChannelJumpUrl='" + this.mChannelJumpUrl + '\'' + ", mArticleId=" + this.mArticleId + ", mChannelType=" + this.mChannelType + ", mChannelCoverSpec='" + this.mChannelCoverSpec + '\'' + ", mFollowType=" + this.mFollowType + ", mColumnType=" + this.mColumnType + ", mTipsType=" + this.mTipsType + ", mTipsText='" + this.mTipsText + '\'' + ", mPreUpdateTime=" + this.mPreUpdateTime + ", mUpdateTime=" + this.mUpdateTime + ", isReport=" + this.isReport + ", mIconUrl='" + this.mIconUrl + '\'' + ", mFontColor=" + this.mFontColor + ", mFrameColor=" + this.mFrameColor + ", isExternalExposure=" + this.isExternalExposure + ", externalExposureBackgroundUrl='" + this.externalExposureBackgroundUrl + '\'' + ", isExternalExposurePersist=" + this.isExternalExposurePersist + ", hasFilterColor=" + this.hasFilterColor + ", filterColor=" + this.filterColor + ", mIsTopic=" + this.mIsTopic + ", isSelected=" + this.isSelected + ", mChannelCoverIcon=" + this.mChannelCoverIcon + ", mChannelVersion=" + this.mChannelVersion + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo
 * JD-Core Version:    0.7.0.1
 */