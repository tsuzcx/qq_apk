import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqConvertGroupId;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspConvertGroupId;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupId;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;

public class wqu
  extends wfm<wqv>
{
  public static final String a;
  public List<String> a;
  public int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = weg.a("StoryGroupSvc.convert_group_id");
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public wfh a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspConvertGroupId localRspConvertGroupId = new qqstory_service.RspConvertGroupId();
    try
    {
      localRspConvertGroupId.mergeFrom(paramArrayOfByte);
      return new wqv(localRspConvertGroupId);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ykq.b("Q.qqstory.net:BatchNetHandler", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqConvertGroupId localReqConvertGroupId = new qqstory_service.ReqConvertGroupId();
    localReqConvertGroupId.convert_from.set(this.c);
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        qqstory_struct.GroupId localGroupId = new qqstory_struct.GroupId();
        localGroupId.group_uin.set(Long.valueOf(str).longValue());
        localReqConvertGroupId.group_req_list.add(localGroupId);
      }
    }
    return localReqConvertGroupId.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqu
 * JD-Core Version:    0.7.0.1
 */