import android.os.Bundle;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDelFeedComment;

public class wpr
  extends wrj
{
  qqstory_service.RspDelFeedComment jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspDelFeedComment;
  wrk jdField_a_of_type_Wrk;
  
  public wpr(qqstory_service.RspDelFeedComment paramRspDelFeedComment, wrk paramwrk)
  {
    super(paramRspDelFeedComment.result);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspDelFeedComment = paramRspDelFeedComment;
    this.jdField_a_of_type_Wrk = paramwrk;
  }
  
  public wpr(wrk paramwrk)
  {
    this.jdField_a_of_type_Wrk = paramwrk;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wrk.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspDelFeedComment);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Wrk.a(paramInt, paramBundle);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Wrk.a(paramInt, paramString);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_Wrk.a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpr
 * JD-Core Version:    0.7.0.1
 */