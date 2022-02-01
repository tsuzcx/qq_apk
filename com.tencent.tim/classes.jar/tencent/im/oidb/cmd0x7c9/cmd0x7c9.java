package tencent.im.oidb.cmd0x7c9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7c9
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_req_type", "uint32_has_data", "rpt_hello_type", "string_qua" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), null, "" }, ReqBody.class);
    public final PBRepeatMessageField<cmd0x7c9.ReqHelloType> rpt_hello_type = PBField.initRepeatMessage(cmd0x7c9.ReqHelloType.class);
    public final PBStringField string_qua = PBField.initString("");
    public final PBUInt32Field uint32_has_data = PBField.initUInt32(1);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  }
  
  public static final class ReqHelloType
    extends MessageMicro<ReqHelloType>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_req_type", "uint32_has_data", "string_qua" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), "" }, ReqHelloType.class);
    public final PBStringField string_qua = PBField.initString("");
    public final PBUInt32Field uint32_has_data = PBField.initUInt32(1);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_next_time_gap", "rpt_hello_content" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
    public final PBRepeatMessageField<cmd0x7c9.RspHelloContent> rpt_hello_content = PBField.initRepeatMessage(cmd0x7c9.RspHelloContent.class);
    public final PBUInt32Field uint32_next_time_gap = PBField.initUInt32(0);
  }
  
  public static final class RspHelloContent
    extends MessageMicro<RspHelloContent>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_req_type", "uint32_next_time_gap" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, RspHelloContent.class);
    public final PBUInt32Field uint32_next_time_gap = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c9.cmd0x7c9
 * JD-Core Version:    0.7.0.1
 */