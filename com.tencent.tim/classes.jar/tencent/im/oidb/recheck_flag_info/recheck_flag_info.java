package tencent.im.oidb.recheck_flag_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class recheck_flag_info
{
  public static final class RecheckFlagInfo
    extends MessageMicro<RecheckFlagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_uin", "uint64_fuin", "bool_has_redtouch", "uint32_recheck_num", "rpt_recheck_list" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0), null }, RecheckFlagInfo.class);
    public final PBBoolField bool_has_redtouch = PBField.initBool(false);
    public final PBRepeatMessageField<recheck_flag_info.RecheckFlagItem> rpt_recheck_list = PBField.initRepeatMessage(recheck_flag_info.RecheckFlagItem.class);
    public final PBUInt32Field uint32_recheck_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RecheckFlagItem
    extends MessageMicro<RecheckFlagItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_flag", "uint32_cur_level", "uint32_lst_level" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RecheckFlagItem.class);
    public final PBInt32Field uint32_cur_level = PBField.initInt32(0);
    public final PBInt32Field uint32_flag = PBField.initInt32(0);
    public final PBInt32Field uint32_lst_level = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.recheck_flag_info.recheck_flag_info
 * JD-Core Version:    0.7.0.1
 */