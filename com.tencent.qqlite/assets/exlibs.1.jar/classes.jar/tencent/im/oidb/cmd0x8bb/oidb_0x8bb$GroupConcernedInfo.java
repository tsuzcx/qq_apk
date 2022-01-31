package tencent.im.oidb.cmd0x8bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8bb$GroupConcernedInfo
  extends MessageMicro
{
  public static final int RPT_MSG_CONCERNED_FIELD_NUMBER = 3;
  public static final int RPT_MSG_WORD_FIELD_NUMBER = 4;
  public static final int UINT32_UPDATE_TIME_FIELD_NUMBER = 2;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_group_code", "uint32_update_time", "rpt_msg_concerned", "rpt_msg_word" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null }, GroupConcernedInfo.class);
  public final PBRepeatMessageField rpt_msg_concerned = PBField.initRepeatMessage(oidb_0x8bb.UinInfo.class);
  public final PBRepeatMessageField rpt_msg_word = PBField.initRepeatMessage(oidb_0x8bb.WordInfo.class);
  public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8bb.oidb_0x8bb.GroupConcernedInfo
 * JD-Core Version:    0.7.0.1
 */