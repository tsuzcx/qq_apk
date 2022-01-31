import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAuthKey;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class tow
  extends syn
{
  public stj a = new stj();
  
  public tow(qqstory_service.RspAuthKey paramRspAuthKey)
  {
    super(paramRspAuthKey.result);
    this.a.jdField_a_of_type_JavaLangString = paramRspAuthKey.user_ip.get().toStringUtf8();
    this.a.b = paramRspAuthKey.server_ip1.get().toStringUtf8();
    this.a.c = paramRspAuthKey.server_ip2.get().toStringUtf8();
    this.a.d = paramRspAuthKey.backup_server_ip1.get().toStringUtf8();
    this.a.e = paramRspAuthKey.backup_server_ip2.get().toStringUtf8();
    this.a.jdField_a_of_type_ArrayOfByte = paramRspAuthKey.auth_key.get().toByteArray();
    this.a.jdField_a_of_type_Long = (paramRspAuthKey.expire_time.get() * 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tow
 * JD-Core Version:    0.7.0.1
 */