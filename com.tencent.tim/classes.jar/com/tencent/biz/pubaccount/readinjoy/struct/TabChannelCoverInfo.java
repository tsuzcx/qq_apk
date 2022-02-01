package com.tencent.biz.pubaccount.readinjoy.struct;

public class TabChannelCoverInfo
  extends ChannelCoverInfo
{
  public static int TYPE_CHANNEL_MY_CONFIG = 700;
  public static int TYPE_CHANNEL_RECOMMEND_CONFIG = 701;
  public long bid;
  public int bold_font;
  public long channelConfigType;
  public int dynamicSort;
  public long endTimestamp;
  public int fonts_color;
  public int frame_color;
  public int only_cover;
  public String proxy;
  public int reason;
  public a redPoint;
  public String redPointJson;
  public long sectionId;
  public int seq;
  public int show_cover;
  public int show_icon;
  public long startTimestamp;
  public String web_url;
  
  public TabChannelCoverInfo() {}
  
  public TabChannelCoverInfo(int paramInt, String paramString)
  {
    this.mChannelCoverId = paramInt;
    this.mChannelCoverName = paramString;
    this.reason = 1;
  }
  
  public TabChannelCoverInfo(int paramInt1, String paramString, int paramInt2)
  {
    this.mChannelCoverId = paramInt1;
    this.mChannelCoverName = paramString;
    this.reason = paramInt2;
  }
  
  public TabChannelCoverInfo(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.mChannelCoverId = paramInt1;
    this.mChannelCoverName = paramString1;
    this.reason = paramInt2;
    this.mChannelCoverIcon = paramString2;
  }
  
  public TabChannelCoverInfo clone()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)super.clone();
    if (this.redPoint != null)
    {
      localTabChannelCoverInfo.redPoint = new a();
      localTabChannelCoverInfo.redPoint.isShow = this.redPoint.isShow;
      localTabChannelCoverInfo.redPoint.endTimestamp = this.redPoint.endTimestamp;
      localTabChannelCoverInfo.redPoint.startTimestamp = this.redPoint.startTimestamp;
      localTabChannelCoverInfo.redPoint.vS = this.redPoint.vS;
      localTabChannelCoverInfo.redPoint.type = this.redPoint.type;
      localTabChannelCoverInfo.redPoint.titleText = this.redPoint.titleText;
      localTabChannelCoverInfo.redPoint.titleColor = this.redPoint.titleColor;
      localTabChannelCoverInfo.redPoint.wP = this.redPoint.wP;
    }
    return localTabChannelCoverInfo;
  }
  
  public String shortLogString()
  {
    return "TabChannelCoverInfo {channelConfigType = " + this.channelConfigType + "mChannelCoverId = " + this.mChannelCoverId + ", mChannelCoverName = " + this.mChannelCoverName + ", reason = " + this.reason + ", seq = " + this.seq + "}";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TabChannelCoverInfo{redPoint=");
    if (this.redPoint != null) {}
    for (String str = this.redPoint.toString();; str = "") {
      return str + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", reason=" + this.reason + ", bold_font=" + this.bold_font + ", show_icon=" + this.show_icon + ", show_cover=" + this.show_cover + ", frame_color=" + this.frame_color + ", fonts_color=" + this.fonts_color + ", web_url='" + this.web_url + '\'' + ", proxy='" + this.proxy + '\'' + ", channelConfigType=" + this.channelConfigType + ", seq=" + this.seq + ", mChannelId=" + this.mChannelId + ", mChannelCoverId=" + this.mChannelCoverId + ", mChannelCoverName='" + this.mChannelCoverName + '\'' + ", mChannelCoverStyle=" + this.mChannelCoverStyle + ", mChannelCoverSummary='" + this.mChannelCoverSummary + '\'' + ", mChannelCoverPicUrl='" + this.mChannelCoverPicUrl + '\'' + ", mChannelJumpUrl='" + this.mChannelJumpUrl + '\'' + ", mArticleId=" + this.mArticleId + ", mChannelType=" + this.mChannelType + ", mChannelCoverSpec='" + this.mChannelCoverSpec + '\'' + ", mFollowType=" + this.mFollowType + ", mColumnType=" + this.mColumnType + ", mTipsType=" + this.mTipsType + ", mTipsText='" + this.mTipsText + '\'' + ", mPreUpdateTime=" + this.mPreUpdateTime + ", mUpdateTime=" + this.mUpdateTime + ", isReport=" + this.isReport + ", mIconUrl='" + this.mIconUrl + '\'' + ", mFontColor=" + this.mFontColor + ", mFrameColor=" + this.mFrameColor + ", isExternalExposure=" + this.isExternalExposure + ", externalExposureBackgroundUrl='" + this.externalExposureBackgroundUrl + '\'' + ", isExternalExposurePersist=" + this.isExternalExposurePersist + ", hasFilterColor=" + this.hasFilterColor + ", filterColor=" + this.filterColor + ", mIsTopic=" + this.mIsTopic + ", isSelected=" + this.isSelected + ", sectionId=" + this.sectionId + ", bid=" + this.bid + ", mChannelCoverIcon=" + this.mChannelCoverIcon + ", mChannelVersion=" + this.mChannelVersion + '}';
    }
  }
  
  public static class a
  {
    public long endTimestamp;
    public boolean isShow;
    public long startTimestamp;
    public int titleColor;
    public String titleText;
    public int type;
    public long vS;
    public int wP;
    
    public String toString()
    {
      return "RedPoint{isShow=" + this.isShow + ", startTimestamp=" + this.startTimestamp + ", animationTimestamp=" + this.vS + ", endTimestamp=" + this.endTimestamp + ", type=" + this.type + ", titleText=" + this.titleText + ", titleColor=" + this.titleColor + ", titleBgColor=" + this.wP + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo
 * JD-Core Version:    0.7.0.1
 */