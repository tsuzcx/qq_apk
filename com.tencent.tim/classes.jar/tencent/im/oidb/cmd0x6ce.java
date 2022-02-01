package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x6ce
{
  public static final class ReadRedpointReq
    extends MessageMicro<ReadRedpointReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_taskid", "uint64_read_seq", "uint32_appid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ReadRedpointReq.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_taskid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_read_seq = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_read_req" }, new Object[] { null }, ReqBody.class);
    public final PBRepeatMessageField<cmd0x6ce.ReadRedpointReq> rpt_msg_read_req = PBField.initRepeatMessage(cmd0x6ce.ReadRedpointReq.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6ce
 * JD-Core Version:    0.7.0.1
 */