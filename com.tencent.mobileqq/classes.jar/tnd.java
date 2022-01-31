import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetTagList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetTagList;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class tnd
  extends sys<toq>
{
  private static final String jdField_a_of_type_JavaLangString = sxm.a("StorySvc.get_label_list");
  private final boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private final String jdField_b_of_type_JavaLangString;
  private int c;
  private final int d;
  
  public tnd(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.c = paramInt1;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.d = paramInt2;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public tnd(String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.d = paramInt;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public syn a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetTagList localRspGetTagList = new qqstory_service.RspGetTagList();
    try
    {
      localRspGetTagList.mergeFrom(paramArrayOfByte);
      return new toq(localRspGetTagList);
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
    qqstory_service.ReqGetTagList localReqGetTagList = new qqstory_service.ReqGetTagList();
    if (this.jdField_a_of_type_Boolean)
    {
      localReqGetTagList.music_type.set(this.c);
      localReqGetTagList.music_id.set(this.jdField_b_of_type_Long);
    }
    localReqGetTagList.start_cookie.set(this.jdField_b_of_type_JavaLangString);
    localReqGetTagList.size.set(this.d);
    return localReqGetTagList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tnd
 * JD-Core Version:    0.7.0.1
 */