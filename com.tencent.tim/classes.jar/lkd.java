import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadExposeReport.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class lkd
{
  private static List<ReportInfo> Q(List<ArticleInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = new ArrayList(paramList).iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (ArticleInfo)paramList.next();
        Object localObject2;
        if ((kxm.C((BaseArticleInfo)localObject1)) && (((ArticleInfo)localObject1).mNewPolymericInfo != null) && (((ArticleInfo)localObject1).mNewPolymericInfo.iP != null))
        {
          localObject1 = ((ArticleInfo)localObject1).mNewPolymericInfo.iP.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (mhr.a)((Iterator)localObject1).next();
            ReportInfo localReportInfo = new ReportInfo();
            localReportInfo.mUin = kxm.getLongAccountUin();
            localReportInfo.mOperation = 56;
            localReportInfo.mSourceArticleId = ((mhr.a)localObject2).articleID;
            localReportInfo.mInnerId = ((mhr.a)localObject2).ahs;
            localReportInfo.mAlgorithmId = ((int)((mhr.a)localObject2).algorithmID);
            localReportInfo.mGWCommonData = "";
            localArrayList.add(localReportInfo);
          }
        }
        else
        {
          localObject2 = new ReportInfo();
          ((ReportInfo)localObject2).mUin = kxm.getLongAccountUin();
          ((ReportInfo)localObject2).mOperation = 56;
          ((ReportInfo)localObject2).mSourceArticleId = ((ArticleInfo)localObject1).mArticleID;
          ((ReportInfo)localObject2).mInnerId = ((ArticleInfo)localObject1).innerUniqueID;
          ((ReportInfo)localObject2).mAlgorithmId = ((int)((ArticleInfo)localObject1).mAlgorithmID);
          ((ReportInfo)localObject2).mGWCommonData = ((ArticleInfo)localObject1).mGWCommonData;
          localArrayList.add(localObject2);
          if (((ArticleInfo)localObject1).hasOnlyTwoVideoFeeds())
          {
            localObject1 = (ArticleInfo)((ArticleInfo)localObject1).mSubArtilceList.get(0);
            localObject2 = new ReportInfo();
            ((ReportInfo)localObject2).mUin = kxm.getLongAccountUin();
            ((ReportInfo)localObject2).mOperation = 56;
            ((ReportInfo)localObject2).mSourceArticleId = ((ArticleInfo)localObject1).mArticleID;
            ((ReportInfo)localObject2).mInnerId = ((ArticleInfo)localObject1).innerUniqueID;
            ((ReportInfo)localObject2).mAlgorithmId = ((int)((ArticleInfo)localObject1).mAlgorithmID);
            ((ReportInfo)localObject2).mGWCommonData = ((ArticleInfo)localObject1).mGWCommonData;
            localArrayList.add(localObject2);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void d(boolean paramBoolean, long paramLong, int paramInt)
  {
    String str = kxm.getAccount();
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt));
    localHashMap.put("uin", str);
    AppRuntime localAppRuntime = kxm.getAppRuntime();
    if ((localAppRuntime == null) || (paramLong < 0L) || (paramLong > 30000L))
    {
      QLog.d("FeedsPreloadExposeReport", 1, "app is null or cost is not available, reportFeedsPreloadExposeMonitorData");
      return;
    }
    anpc.a(localAppRuntime.getApplication()).collectPerformance(str, "actFeedsPreloadExposeReport", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  public static void k(List<ArticleInfo> paramList, String paramString)
  {
    QLog.d("FeedsPreloadExposeReport", 1, "reportFeedsExposeRewrite.");
    Object localObject = (lcd)((QQAppInterface)kxm.getAppRuntime()).getManager(163);
    if (localObject != null)
    {
      localObject = ((lcd)localObject).b();
      lka.a().F(new FeedsPreloadExposeReport.1((lbz)localObject, paramList, paramString));
      return;
    }
    QLog.d("FeedsPreloadExposeReport", 1, "readInJoyLogicManager is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lkd
 * JD-Core Version:    0.7.0.1
 */