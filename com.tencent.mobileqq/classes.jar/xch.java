import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqConvertUinAndUnionId;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspConvertUinAndUnionId;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xch
  extends wpa<xef>
{
  public String a;
  public List<wuo> a;
  public boolean a;
  public boolean b;
  public int c;
  public boolean c;
  
  public xch()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    return wnu.a("StorySvc.convert_uid_and_union_id");
  }
  
  public xef a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspConvertUinAndUnionId localRspConvertUinAndUnionId = new qqstory_service.RspConvertUinAndUnionId();
    try
    {
      localRspConvertUinAndUnionId.mergeFrom(paramArrayOfByte);
      return new xef(localRspConvertUinAndUnionId);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      yuk.d("Q.qqstory.user:ConvertUinAndUnionIdRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    int j = 1;
    qqstory_service.ReqConvertUinAndUnionId localReqConvertUinAndUnionId = new qqstory_service.ReqConvertUinAndUnionId();
    localReqConvertUinAndUnionId.convert_from.set(this.c);
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      wuo localwuo = (wuo)((Iterator)localObject).next();
      localReqConvertUinAndUnionId.user_id_list.add(localwuo.a());
    }
    localObject = localReqConvertUinAndUnionId.need_medal;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 1;
      ((PBUInt32Field)localObject).set(i);
      localObject = localReqConvertUinAndUnionId.need_grade_speed;
      if (!this.b) {
        break label121;
      }
    }
    label121:
    for (int i = j;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      return localReqConvertUinAndUnionId.toByteArray();
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xch
 * JD-Core Version:    0.7.0.1
 */