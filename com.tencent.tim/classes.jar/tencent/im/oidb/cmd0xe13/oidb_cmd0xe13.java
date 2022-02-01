package tencent.im.oidb.cmd0xe13;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xe13
{
  public static final class ReportInfo
    extends MessageMicro<ReportInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_report = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_time", "bytes_report" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, ReportInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_report_info", "uint32_seq" }, new Object[] { null, Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatMessageField<oidb_cmd0xe13.ReportInfo> msg_report_info = PBField.initRepeatMessage(oidb_cmd0xe13.ReportInfo.class);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_result", "uint32_seq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe13.oidb_cmd0xe13
 * JD-Core Version:    0.7.0.1
 */