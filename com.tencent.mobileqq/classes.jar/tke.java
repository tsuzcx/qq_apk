import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqConvertGroupId;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspConvertGroupId;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupId;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;

public class tke
  extends syv<tkf>
{
  public static final String a;
  public List<String> a;
  public int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxp.a("StoryGroupSvc.convert_group_id");
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public syq a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspConvertGroupId localRspConvertGroupId = new qqstory_service.RspConvertGroupId();
    try
    {
      localRspConvertGroupId.mergeFrom(paramArrayOfByte);
      return new tkf(localRspConvertGroupId);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      veg.b("Q.qqstory.net:BatchNetHandler", a(), paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tke
 * JD-Core Version:    0.7.0.1
 */