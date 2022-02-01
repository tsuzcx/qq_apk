package tencent.im.oidb.cmd0x6ef;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x6ef
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "gc", "event_id", "seq" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L) }, ReqBody.class);
    public final PBStringField event_id = PBField.initString("");
    public final PBUInt64Field gc = PBField.initUInt64(0L);
    public final PBUInt64Field seq = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field gc = PBField.initUInt64(0L);
    public final PBUInt32Field is_create = PBField.initUInt32(0);
    public final PBUInt32Field is_join = PBField.initUInt32(0);
    public final PBBytesField remind_brief = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "gc", "seq", "remind_brief", "is_create", "is_join" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6ef.oidb_cmd0x6ef
 * JD-Core Version:    0.7.0.1
 */