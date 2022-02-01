package tencent.im.cs.cmd0x3bb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x3bb
{
  public static final class AnonyMsg
    extends MessageMicro<AnonyMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 82, 90 }, new String[] { "uint32_cmd", "msg_anony_req", "msg_anony_rsp" }, new Object[] { Integer.valueOf(0), null, null }, AnonyMsg.class);
    public cmd0x3bb.ReqBody msg_anony_req = new cmd0x3bb.ReqBody();
    public cmd0x3bb.RspBody msg_anony_rsp = new cmd0x3bb.RspBody();
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  }
  
  public static final class AnonyStatus
    extends MessageMicro<AnonyStatus>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField str_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_forbid_talking = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 82 }, new String[] { "uint32_forbid_talking", "str_err_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, AnonyStatus.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint64_group_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField color = PBField.initString("");
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public cmd0x3bb.AnonyStatus msg_anony_status = new cmd0x3bb.AnonyStatus();
    public final PBBytesField str_anony_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bubble_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expired_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_portrait_index = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 82, 122 }, new String[] { "int32_ret", "uint64_group_code", "str_anony_name", "uint32_portrait_index", "uint32_bubble_index", "uint32_expired_time", "msg_anony_status", "color" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, "" }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x3bb.cmd0x3bb
 * JD-Core Version:    0.7.0.1
 */