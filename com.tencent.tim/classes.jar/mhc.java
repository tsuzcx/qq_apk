import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.AggregatedList;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.FeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;

public class mhc
{
  articlesummary.AggregatedList a;
  public ArrayList<mhc.a> kU;
  
  public static mhc a(articlesummary.AggregatedList paramAggregatedList)
  {
    if ((paramAggregatedList != null) && (paramAggregatedList.rpt_article_summary.has()))
    {
      mhc localmhc = new mhc();
      Object localObject = paramAggregatedList.rpt_article_summary.get();
      localmhc.kU = new ArrayList(((List)localObject).size());
      localmhc.a = paramAggregatedList;
      paramAggregatedList = ((List)localObject).iterator();
      while (paramAggregatedList.hasNext())
      {
        localObject = (articlesummary.ArticleSummary)paramAggregatedList.next();
        articlesummary.FeedsInfo localFeedsInfo = (articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject).msg_feeds_info.get();
        mhc.a locala = new mhc.a();
        locala.vd = ((articlesummary.ArticleSummary)localObject).msg_feeds_info.msg_social_feeds_info.uint64_feeds_id.get();
        locala.mAlgorithmID = ((articlesummary.ArticleSummary)localObject).uint64_algorithm_id.get();
        if (localFeedsInfo.feeds_type.has()) {
          locala.mFeedType = localFeedsInfo.feeds_type.get();
        }
        if (((articlesummary.ArticleSummary)localObject).uint32_strategy_id.has()) {
          locala.mStrategyId = ((articlesummary.ArticleSummary)localObject).uint32_strategy_id.get();
        }
        if (((articlesummary.ArticleSummary)localObject).uint64_recommend_seq.has()) {
          locala.mRecommendSeq = ((articlesummary.ArticleSummary)localObject).uint64_recommend_seq.get();
        }
        localmhc.kU.add(locala);
      }
      return localmhc;
    }
    return null;
  }
  
  public static boolean ac(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mExtraBiuBriefInfo != null) && (!paramBaseArticleInfo.isExtraBiuExpanded) && (paramBaseArticleInfo.mExtraBiuBriefInfo.kU != null) && (!paramBaseArticleInfo.mExtraBiuBriefInfo.kU.isEmpty());
  }
  
  public static boolean ad(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mExtraBiuBriefInfo != null) && (paramBaseArticleInfo.mExtraBiuBriefInfo.kU != null) && (!paramBaseArticleInfo.mExtraBiuBriefInfo.kU.isEmpty());
  }
  
  public byte[] getBytes()
  {
    return ((articlesummary.AggregatedList)this.a.get()).toByteArray();
  }
  
  public static class a
  {
    public long mAlgorithmID;
    public int mFeedType;
    public long mRecommendSeq = -1L;
    public int mStrategyId;
    public long vd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhc
 * JD-Core Version:    0.7.0.1
 */