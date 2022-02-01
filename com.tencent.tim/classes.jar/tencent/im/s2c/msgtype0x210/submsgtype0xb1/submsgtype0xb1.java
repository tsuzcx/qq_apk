package tencent.im.s2c.msgtype0x210.submsgtype0xb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xb1
{
  public static final class DealInviteInfo
    extends MessageMicro<DealInviteInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_uin", "uint64_group_code", "str_id", "uint32_deal_result" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0) }, DealInviteInfo.class);
    public final PBStringField str_id = PBField.initString("");
    public final PBUInt32Field uint32_deal_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class InviteInfo
    extends MessageMicro<InviteInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_uin", "uint64_group_code", "uint32_expire_time", "str_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, InviteInfo.class);
    public final PBStringField str_id = PBField.initString("");
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_notify_type", "invite_info", "univite_info", "deal_info" }, new Object[] { Integer.valueOf(0), null, null, null }, MsgBody.class);
    public submsgtype0xb1.DealInviteInfo deal_info = new submsgtype0xb1.DealInviteInfo();
    public submsgtype0xb1.InviteInfo invite_info = new submsgtype0xb1.InviteInfo();
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public submsgtype0xb1.UninviteInfo univite_info = new submsgtype0xb1.UninviteInfo();
  }
  
  public static final class UninviteInfo
    extends MessageMicro<UninviteInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint64_group_code", "str_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, UninviteInfo.class);
    public final PBStringField str_id = PBField.initString("");
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1
 * JD-Core Version:    0.7.0.1
 */