package tencent.im.oidb.cmd0x2060;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x2060
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_bid", "string_pid" }, new Object[] { Long.valueOf(0L), "" }, ReqBody.class);
    public final PBStringField string_pid = PBField.initString("");
    public final PBUInt64Field uint64_bid = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_vote_total", "uint32_vote_yes_num", "uint32_vote_no_num", "uint32_vote_status" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBUInt32Field uint32_vote_no_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vote_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vote_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vote_yes_num = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x2060.oidb_cmd0x2060
 * JD-Core Version:    0.7.0.1
 */