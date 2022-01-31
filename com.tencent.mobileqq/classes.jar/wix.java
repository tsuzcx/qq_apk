import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribeGetRecommendUserListRequest;

public class wix
{
  private long jdField_a_of_type_Long;
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private wiz jdField_a_of_type_Wiz;
  
  public COMM.StCommonExt a()
  {
    return this.jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramString = new SubscribeGetRecommendUserListRequest(paramString, this.jdField_a_of_type_NS_COMMCOMM$StCommonExt, 0, 1);
    VSNetworkHelper.a().a(paramString, new wiy(this));
  }
  
  public void a(wiz paramwiz)
  {
    this.jdField_a_of_type_Wiz = paramwiz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wix
 * JD-Core Version:    0.7.0.1
 */