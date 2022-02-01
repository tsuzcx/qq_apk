package tencent.im.oidb.cmd0x962;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x962
{
  public static final class ClientInfo
    extends MessageMicro<ClientInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_client_type", "bytes_version" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ClientInfo.class);
    }
  }
  
  public static final class FinishInfo
    extends MessageMicro<FinishInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_first_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_participate_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_first_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "bytes_text", "uint32_participate_num", "uint64_first_uin", "bytes_first_nick_name", "bytes_url" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3 }, FinishInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x962.ClientInfo msg_client_info = new oidb_0x962.ClientInfo();
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_times = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "uint64_group_code", "bytes_id", "uint32_times", "msg_client_info", "uint32_product_id", "uint32_cmd" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_already_pay_microseconds", "uint64_play_total_microseconds", "uint64_state_microseconds", "uint32_play_state", "msg_finish_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null }, RspBody.class);
    public oidb_0x962.FinishInfo msg_finish_info = new oidb_0x962.FinishInfo();
    public final PBUInt32Field uint32_play_state = PBField.initUInt32(0);
    public final PBUInt64Field uint64_already_pay_microseconds = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_play_total_microseconds = PBField.initUInt64(0L);
    public final PBRepeatField<Long> uint64_state_microseconds = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x962.oidb_0x962
 * JD-Core Version:    0.7.0.1
 */