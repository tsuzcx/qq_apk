package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$ModConfProfile
  extends MessageMicro
{
  public static final int RPT_MSG_PROFILE_INFOS_FIELD_NUMBER = 3;
  public static final int UINT32_CONF_UIN_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint32_conf_uin", "rpt_msg_profile_infos" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, ModConfProfile.class);
  public final PBRepeatMessageField rpt_msg_profile_infos = PBField.initRepeatMessage(SubMsgType0x27.ProfileInfo.class);
  public final PBUInt32Field uint32_conf_uin = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModConfProfile
 * JD-Core Version:    0.7.0.1
 */