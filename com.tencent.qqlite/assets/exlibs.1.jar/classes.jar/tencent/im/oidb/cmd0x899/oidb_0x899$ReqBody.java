package tencent.im.oidb.cmd0x899;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x899$ReqBody
  extends MessageMicro
{
  public static final int MEMBERLIST_OPT_FIELD_NUMBER = 5;
  public static final int RPT_UINT64_UIN_LIST_FIELD_NUMBER = 4;
  public static final int UINT32_FILTER_METHOD_FIELD_NUMBER = 7;
  public static final int UINT32_IDENTIFY_FLAG_FIELD_NUMBER = 3;
  public static final int UINT32_MEMBER_NUM_FIELD_NUMBER = 6;
  public static final int UINT32_ONLINE_FLAG_FIELD_NUMBER = 8;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  public static final int UINT64_START_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64 }, new String[] { "uint64_group_code", "uint64_start_uin", "uint32_identify_flag", "rpt_uint64_uin_list", "memberlist_opt", "uint32_member_num", "uint32_filter_method", "uint32_online_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public oidb_0x899.memberlist memberlist_opt = new oidb_0x899.memberlist();
  public final PBRepeatField rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_filter_method = PBField.initUInt32(0);
  public final PBUInt32Field uint32_identify_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_online_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_start_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x899.oidb_0x899.ReqBody
 * JD-Core Version:    0.7.0.1
 */