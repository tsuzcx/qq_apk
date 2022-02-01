import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgListHeadNode;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgListHeadNode;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class wfi
  extends vqr<wgt>
{
  private static final String jdField_a_of_type_JavaLangString = vpl.a("StoryLrSvc.msglist_head_node");
  private List<Long> jdField_a_of_type_JavaUtilList;
  private String b;
  private int c;
  
  public int a()
  {
    return this.c;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public vqm a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgListHeadNode localRspMsgListHeadNode = new qqstory_service.RspMsgListHeadNode();
    try
    {
      localRspMsgListHeadNode.mergeFrom(paramArrayOfByte);
      return new wgt(localRspMsgListHeadNode);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RecentTabHaloRequest", 2, "decodeResponse: failed. Message: exception: " + paramArrayOfByte);
        }
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqMsgListHeadNode localReqMsgListHeadNode = new qqstory_service.ReqMsgListHeadNode();
    PBBytesField localPBBytesField = localReqMsgListHeadNode.current_seq;
    if (this.b != null) {}
    for (String str = this.b;; str = "")
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localReqMsgListHeadNode.uin_list.set(this.jdField_a_of_type_JavaUtilList);
      localReqMsgListHeadNode.source.set(this.c);
      localReqMsgListHeadNode.setHasFlag(true);
      return localReqMsgListHeadNode.toByteArray();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RecentTabHaloRequest{");
    localStringBuilder.append("mCurrentSeq='").append(this.b).append('\'');
    localStringBuilder.append(", mUins=").append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", mWhen=").append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfi
 * JD-Core Version:    0.7.0.1
 */