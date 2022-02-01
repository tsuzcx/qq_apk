import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;

public class owj
  implements ryu<Object>
{
  public owj(QCircleFolderFragmentsPart paramQCircleFolderFragmentsPart) {}
  
  public void s(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      QLog.d("QCircleFolderFragmentsPart", 1, "preload requestTabData onReceive: dispatch Success:" + (Boolean)paramVarArgs[0] + " | retCode:" + (Long)paramVarArgs[1] + " | retMessage:" + (String)paramVarArgs[2]);
      QCircleFolderFragmentsPart.a(this.this$0).b(((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (FeedCloudRead.StGetBusiInfoRsp)paramVarArgs[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owj
 * JD-Core Version:    0.7.0.1
 */