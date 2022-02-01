package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.persistence.Entity;
import java.util.Arrays;
import java.util.List;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;

public class ReportInfo
  extends Entity
  implements Cloneable
{
  public String firstVideoRowkey;
  public int mAlgorithmId;
  public int mArticleLength = -1;
  public int mChannelId;
  public String mCollectUrl;
  public int mColumnID = -1;
  public a mFeedsReportData;
  public int mFolderStatus;
  public String mGWCommonData;
  public byte[] mGalleryReportInfo;
  public String mHotWord;
  public String mInnerId;
  public boolean mIsGallery;
  public int mOpSource;
  public int mOperation;
  public int mPlayTimeLength;
  public long mPuin;
  public int mReadArticleLength = -1;
  public int mReadTimeLength;
  public String mSearchTagName;
  public byte[] mServerContext;
  public int mSource;
  public long mSourceArticleId;
  public int mStrategyId;
  public long mUin;
  public b mVideoExtraRepoerData;
  public int noDifferenceJump;
  public String replyID;
  public long replyUin = -1L;
  public oidb_cmd0x64e.SRTClickInfo srtClickInfo;
  public String videoReportInfo;
  
  public ReportInfo clone()
  {
    try
    {
      ReportInfo localReportInfo = (ReportInfo)super.clone();
      return localReportInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    return "ReportInfo{mUin=" + this.mUin + ", mSource=" + this.mSource + ", mSourceArticleId=" + this.mSourceArticleId + ", mChannelId=" + this.mChannelId + ", mAlgorithmId=" + this.mAlgorithmId + ", mStrategyId=" + this.mStrategyId + ", mOperation=" + this.mOperation + ", mOpSource=" + this.mOpSource + ", mInnerId='" + this.mInnerId + '\'' + ", mFolderStatus=" + this.mFolderStatus + ", mServerContext=" + Arrays.toString(this.mServerContext) + ", mSearchTagName='" + this.mSearchTagName + '\'' + ", replyUin='" + this.replyUin + '\'' + ", replyID='" + this.replyID + '\'' + ", videoReportInfo=" + this.videoReportInfo + '\'' + '}';
  }
  
  public static class a
    implements Cloneable
  {
    public int aSx;
    public int aSy;
    public List<Long> iR;
    public long vd;
    public long vg;
  }
  
  public static class b
    implements Cloneable
  {
    public int aSA = -1;
    public int aSB = -1;
    public int aSC = -1;
    public int aSD = -1;
    public int aSz = -1;
    public boolean amJ;
    public boolean amK;
    public int videoDuration = -1;
    
    public String toString()
    {
      return "VideoExtraRepoerData{JumpWayWhich=" + this.aSz + ", InOneThreeSource=" + this.aSA + ", videoTimePosition=" + this.aSC + ", videoDuration=" + this.videoDuration + ", needWhetherClickIn=" + this.amK + ", whetherClickIn=" + this.amJ + ", InVideoChannelSource=" + this.aSB + ", videoFromType=" + this.aSD + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo
 * JD-Core Version:    0.7.0.1
 */