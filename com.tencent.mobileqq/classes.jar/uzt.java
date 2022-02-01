import com.tencent.biz.qqcircle.bizparts.QCircleAggregationFragmentsPart;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;

public class uzt
  implements zzq<Object>
{
  public uzt(QCircleAggregationFragmentsPart paramQCircleAggregationFragmentsPart) {}
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      QLog.d("QCircleAggregationFragmentsPart", 1, "preload requestTabData onReceive: dispatch Success:" + (Boolean)paramVarArgs[0] + " | retCode:" + (Long)paramVarArgs[1] + " | retMessage:" + (String)paramVarArgs[2]);
      QCircleAggregationFragmentsPart.a(this.a).a(((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (FeedCloudRead.StGetBusiInfoRsp)paramVarArgs[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzt
 * JD-Core Version:    0.7.0.1
 */