package tencent.im.oidb.cmd0x7ba;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7ba
{
  public static final class PraiseInfo
    extends MessageMicro<PraiseInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 88, 96, 104 }, new String[] { "uint64_ddwuin", "uint32_praise_today_count", "uint32_rank_number", "uint32_praise_total_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PraiseInfo.class);
    public final PBUInt32Field uint32_praise_today_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_total_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rank_number = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ddwuin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 88, 96 }, new String[] { "uint64_uin", "uint32_start_index", "uint32_want_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 88, 96 }, new String[] { "rpt_info", "uint32_next_index", "uint32_complete" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x7ba.PraiseInfo> rpt_info = PBField.initRepeatMessage(oidb_0x7ba.PraiseInfo.class);
    public final PBUInt32Field uint32_complete = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_index = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7ba.oidb_0x7ba
 * JD-Core Version:    0.7.0.1
 */