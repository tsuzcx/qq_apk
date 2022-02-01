package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc35
{
  public static final class ExposeItem
    extends MessageMicro<ExposeItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_addition = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_algo_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_action_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_entrance_Id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expose_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expose_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_page_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_friend = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66 }, new String[] { "uint64_friend", "uint32_page_id", "uint32_entrance_Id", "uint32_action_id", "uint32_expose_count", "uint32_expose_time", "bytes_algo_buffer", "bytes_addition" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, ExposeItem.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "rpt_msg_expose_info" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
    public final PBRepeatMessageField<oidb_0xc35.ExposeItem> rpt_msg_expose_info = PBField.initRepeatMessage(oidb_0xc35.ExposeItem.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc35
 * JD-Core Version:    0.7.0.1
 */