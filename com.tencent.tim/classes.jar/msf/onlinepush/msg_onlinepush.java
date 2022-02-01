package msf.onlinepush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm.Msg;

public final class msg_onlinepush
{
  public static final class PbPushMsg
    extends MessageMicro<PbPushMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_push_token = PBField.initBytes(ByteStringMicro.EMPTY);
    public msg_comm.Msg msg = new msg_comm.Msg();
    public final PBUInt32Field ping_flag = PBField.initUInt32(0);
    public final PBInt32Field svrip = PBField.initInt32(0);
    public final PBUInt32Field uint32_general_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_bind_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 72, 80 }, new String[] { "msg", "svrip", "bytes_push_token", "ping_flag", "uint32_general_flag", "uint64_bind_uin" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, PbPushMsg.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msf.onlinepush.msg_onlinepush
 * JD-Core Version:    0.7.0.1
 */