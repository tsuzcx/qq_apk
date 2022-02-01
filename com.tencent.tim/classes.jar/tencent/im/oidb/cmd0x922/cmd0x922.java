package tencent.im.oidb.cmd0x922;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x922
{
  public static final class PushInfo
    extends MessageMicro<PushInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_prompt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_lst_checkin_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_open_func = PBField.initUInt32(0);
    public final PBUInt32Field uint32_red_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56, 64 }, new String[] { "uint32_type", "uint32_red_point", "uint32_day", "bytes_prompt", "bytes_url", "bytes_icon_url", "uint32_lst_checkin_time", "uint32_open_func" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, PushInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_timestamp" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_need_update_flag", "uint64_timestamp", "msg_push_info", "uint32_next_req_time" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0) }, RspBody.class);
    public cmd0x922.PushInfo msg_push_info = new cmd0x922.PushInfo();
    public final PBUInt32Field uint32_need_update_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_req_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x922.cmd0x922
 * JD-Core Version:    0.7.0.1
 */