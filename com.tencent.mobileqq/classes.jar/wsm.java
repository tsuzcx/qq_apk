import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchFeedLike;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchFeedLike;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class wsm
  extends wfm
{
  public static final String a;
  private List<String> a;
  private int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = weg.a("StorySvc.feed_like_list_batch_715");
  }
  
  public wsm(List<String> paramList, boolean paramBoolean)
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
    qqstory_service.RspBatchFeedLike localRspBatchFeedLike = new qqstory_service.RspBatchFeedLike();
    try
    {
      localRspBatchFeedLike.mergeFrom(paramArrayOfByte);
      return new wsn(localRspBatchFeedLike);
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
    qqstory_service.ReqBatchFeedLike localReqBatchFeedLike = new qqstory_service.ReqBatchFeedLike();
    List localList = a(this.jdField_a_of_type_JavaUtilList);
    localReqBatchFeedLike.feed_id_list.set(localList);
    localReqBatchFeedLike.source.set(this.c);
    return localReqBatchFeedLike.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsm
 * JD-Core Version:    0.7.0.1
 */