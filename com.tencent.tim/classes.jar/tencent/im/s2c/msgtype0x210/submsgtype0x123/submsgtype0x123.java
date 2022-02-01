package tencent.im.s2c.msgtype0x210.submsgtype0x123;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x123
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_templ_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<submsgtype0x123.TemplParam> rpt_templ_param = PBField.initRepeatMessage(submsgtype0x123.TemplParam.class);
    public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_busi_type = PBField.initUInt64(0L);
    public final PBUInt32Field uint64_c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field uint64_ctrl_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint64_service_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_templ_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66 }, new String[] { "uint64_busi_type", "uint64_busi_id", "uint64_ctrl_flag", "uint64_c2c_type", "uint64_service_type", "uint64_templ_id", "rpt_templ_param", "bytes_templ_content" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, localByteStringMicro }, MsgBody.class);
    }
  }
  
  public static final class TemplParam
    extends MessageMicro<TemplParam>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "name", "value" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, TemplParam.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x123.submsgtype0x123
 * JD-Core Version:    0.7.0.1
 */