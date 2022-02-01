package com.tencent.biz.pubaccount;

import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kxm;
import ljc;
import lun;

public final class VideoReporter$1
  implements Runnable
{
  public VideoReporter$1(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ReportInfo.b paramb, int paramInt7, String paramString2, String paramString3) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = kxm.getLongAccountUin();
    localReportInfo.mSource = 0;
    localReportInfo.mOpSource = this.aHG;
    localReportInfo.mSourceArticleId = this.rI;
    localReportInfo.mInnerId = this.XV;
    localReportInfo.mChannelId = this.aHH;
    localReportInfo.mAlgorithmId = this.aHI;
    localReportInfo.mStrategyId = this.aHJ;
    localReportInfo.mOperation = this.val$operation;
    localReportInfo.mPlayTimeLength = this.aHK;
    localReportInfo.mVideoExtraRepoerData = this.a;
    localReportInfo.mColumnID = this.aHL;
    localReportInfo.videoReportInfo = this.XW;
    localReportInfo.firstVideoRowkey = this.XX;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("reportVideoUserOperationByOidbOfVideoFeedsmUin:").append(localReportInfo.mUin).append("; mSource:").append(localReportInfo.mSource).append("; mOpSource:").append(localReportInfo.mOpSource).append("; mSourceArticleId: ").append(localReportInfo.mSourceArticleId).append("; mInnerId:").append(localReportInfo.mInnerId).append("; mChannelId:").append(localReportInfo.mChannelId).append("; mAlgorithmId:").append(localReportInfo.mAlgorithmId).append("; mStrategyId:").append(localReportInfo.mStrategyId).append("; mOperation:").append(localReportInfo.mOperation).append("; mPlayTimeLength:").append(localReportInfo.mPlayTimeLength).append("; mColumnID:").append(localReportInfo.mColumnID).append("; videoReportInfo:").append(localReportInfo.videoReportInfo).append("; videoExtraRepoerData:");
      if (this.a == null) {
        break label344;
      }
    }
    label344:
    for (String str = this.a.toString();; str = "null")
    {
      QLog.d("VideoReporter", 2, str);
      localArrayList.add(localReportInfo);
      new ljc(null, null, lun.a(), null).cA(localArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoReporter.1
 * JD-Core Version:    0.7.0.1
 */