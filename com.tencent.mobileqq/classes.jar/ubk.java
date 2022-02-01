import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;

public class ubk
{
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ozs.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
    localReportInfo.mChannelId = paramInt;
    localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
    localReportInfo.mOperation = 1;
    localReportInfo.mServerContext = paramArticleInfo.mServerContext;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = paramArticleInfo.innerUniqueID;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      localObject1 = new qxa();
      ((qxa)localObject1).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt != null) {
        ((qxa)localObject1).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long;
      }
      ((qxa)localObject1).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((qxa)localObject1).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.d;
      Object localObject2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        ((qxa)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          qxt localqxt = (qxt)((Iterator)localObject2).next();
          if (localqxt != null) {
            ((qxa)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqxt.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = ((qxa)localObject1);
    }
    if (pbd.c((int)paramArticleInfo.mChannelID)) {
      localReportInfo.mSearchTagName = ozs.g(paramArticleInfo);
    }
    Object localObject1 = ozo.a().a();
    if (localObject1 != null) {
      localReportInfo.srtClickInfo = ((oidb_cmd0x64e.SRTClickInfo)localObject1);
    }
    if ((paramArticleInfo != null) && (!quv.c(paramArticleInfo)) && (!ozo.a().a()) && (ozs.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
      localReportInfo.noDifferenceJump = 1;
    }
    localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    pfa.a().a((List)localObject1);
    pgo.a.b(paramInt, paramArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ubk
 * JD-Core Version:    0.7.0.1
 */