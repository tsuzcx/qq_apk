package tencent.im.s2c.msgtype0x210.submsgtype0xbe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xbe
{
  public static final class Medal
    extends MessageMicro<Medal>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "uint32_id", "uint32_level", "uint32_type", "str_icon_url", "str_flash_url", "str_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, Medal.class);
    public final PBStringField str_flash_url = PBField.initString("");
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_uin", "uint64_group_code", "uint32_notify_type", "uint32_online_level", "rpt_msg_medal_list" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, MsgBody.class);
    public final PBRepeatMessageField<SubMsgType0xbe.Medal> rpt_msg_medal_list = PBField.initRepeatMessage(SubMsgType0xbe.Medal.class);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe
 * JD-Core Version:    0.7.0.1
 */