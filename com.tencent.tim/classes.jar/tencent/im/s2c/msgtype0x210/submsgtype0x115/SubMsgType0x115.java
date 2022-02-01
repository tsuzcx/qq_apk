package tencent.im.s2c.msgtype0x210.submsgtype0x115;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x115
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public SubMsgType0x115.NotifyItem msg_notify_item = new SubMsgType0x115.NotifyItem();
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_from_uin", "uint64_to_uin", "msg_notify_item", "bytes_pb_reserve" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, localByteStringMicro }, MsgBody.class);
    }
  }
  
  public static final class NotifyItem
    extends MessageMicro<NotifyItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_event_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timeout_s = PBField.initUInt32(0);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint32_ime", "uint32_timeout_s", "uint64_timestamp", "uint32_event_type", "uint32_interval", "bytes_wording" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, NotifyItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x115.SubMsgType0x115
 * JD-Core Version:    0.7.0.1
 */