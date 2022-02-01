import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchFeedComment;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class wsj
  extends wfm
{
  private static final String jdField_a_of_type_JavaLangString = weg.a("StorySvc.feed_comment_list_batch_775");
  private List<String> jdField_a_of_type_JavaUtilList;
  private int c;
  
  public wsj(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.c = i;
      return;
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public wfh a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBatchFeedComment localRspBatchFeedComment = new qqstory_service.RspBatchFeedComment();
    try
    {
      localRspBatchFeedComment.mergeFrom(paramArrayOfByte);
      return new wsk(localRspBatchFeedComment);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqBatchFeedComment localReqBatchFeedComment = new qqstory_service.ReqBatchFeedComment();
    List localList = a(this.jdField_a_of_type_JavaUtilList);
    localReqBatchFeedComment.feed_id_list.set(localList);
    localReqBatchFeedComment.source.set(this.c);
    return localReqBatchFeedComment.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsj
 * JD-Core Version:    0.7.0.1
 */