import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAuthKey;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class qax
  extends ppu
{
  public pmm.b b = new pmm.b();
  
  public qax(qqstory_service.RspAuthKey paramRspAuthKey)
  {
    super(paramRspAuthKey.result);
    this.b.atM = paramRspAuthKey.user_ip.get().toStringUtf8();
    this.b.atN = paramRspAuthKey.server_ip1.get().toStringUtf8();
    this.b.atO = paramRspAuthKey.server_ip2.get().toStringUtf8();
    this.b.atP = paramRspAuthKey.backup_server_ip1.get().toStringUtf8();
    this.b.atQ = paramRspAuthKey.backup_server_ip2.get().toStringUtf8();
    this.b.bA = paramRspAuthKey.auth_key.get().toByteArray();
    this.b.expireTime = (paramRspAuthKey.expire_time.get() * 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qax
 * JD-Core Version:    0.7.0.1
 */