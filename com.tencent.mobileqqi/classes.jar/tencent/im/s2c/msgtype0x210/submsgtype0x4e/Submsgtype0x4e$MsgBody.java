package tencent.im.s2c.msgtype0x210.submsgtype0x4e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0x4e$MsgBody
  extends MessageMicro
{
  public static final int MSG_GROUP_BULLETIN_FIELD_NUMBER = 4;
  public static final int UINT32_APPID_FIELD_NUMBER = 3;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
  public static final int UINT64_GROUP_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_group_id", "uint64_group_code", "uint32_appid", "msg_group_bulletin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null }, MsgBody.class);
  public Submsgtype0x4e.GroupBulletin msg_group_bulletin = new Submsgtype0x4e.GroupBulletin();
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.MsgBody
 * JD-Core Version:    0.7.0.1
 */