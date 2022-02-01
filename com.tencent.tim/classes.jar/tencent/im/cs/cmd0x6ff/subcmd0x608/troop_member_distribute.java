package tencent.im.cs.cmd0x6ff.subcmd0x608;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class troop_member_distribute
{
  public static final class GenderNumber
    extends MessageMicro<GenderNumber>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_man_number", "uint32_woman_number", "uint32_unknow_number" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GenderNumber.class);
    public final PBUInt32Field uint32_man_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unknow_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_woman_number = PBField.initUInt32(0);
  }
  
  public static final class OStatisticInfo
    extends MessageMicro<OStatisticInfo>
  {
    public static final int STATISTIC_TYPE_CITY = 4;
    public static final int STATISTIC_TYPE_GENDER = 1;
    public static final int STATISTIC_TYPE_MARITAL = 3;
    public static final int STATISTIC_TYPE_YEAR = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_statistic_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_desc", "uint32_count", "uint32_statistic_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, OStatisticInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_group_code", "uint32_gender_number" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_gender_number = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50 }, new String[] { "uint32_result", "uint64_group_code", "uint32_group_max_member", "uint32_group_member", "rpt_msg_statistic", "msg_gender_number" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null }, RspBody.class);
    public troop_member_distribute.GenderNumber msg_gender_number = new troop_member_distribute.GenderNumber();
    public final PBRepeatMessageField<troop_member_distribute.OStatisticInfo> rpt_msg_statistic = PBField.initRepeatMessage(troop_member_distribute.OStatisticInfo.class);
    public final PBUInt32Field uint32_group_max_member = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_member = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute
 * JD-Core Version:    0.7.0.1
 */