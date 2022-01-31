import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribeGetRecommendUserListRequest;

public class xxp
{
  private long jdField_a_of_type_Long;
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private xxr jdField_a_of_type_Xxr;
  
  public COMM.StCommonExt a()
  {
    return this.jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramString = new SubscribeGetRecommendUserListRequest(paramString, this.jdField_a_of_type_NS_COMMCOMM$StCommonExt, 0, 1);
    VSNetworkHelper.a().a(paramString, new xxq(this));
  }
  
  public void a(xxr paramxxr)
  {
    this.jdField_a_of_type_Xxr = paramxxr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xxp
 * JD-Core Version:    0.7.0.1
 */