package tencent.im.oidb.cmd0xcf0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xcf0
{
  public static final class BindContactsFriendInfo
    extends MessageMicro<BindContactsFriendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, BindContactsFriendInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_expect_bind_contacts_frd_num" }, new Object[] { Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_expect_bind_contacts_frd_num = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_total_bind_contacts_frd_num", "rpt_msg_bind_contacts_frds" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
    public final PBRepeatMessageField<cmd0xcf0.BindContactsFriendInfo> rpt_msg_bind_contacts_frds = PBField.initRepeatMessage(cmd0xcf0.BindContactsFriendInfo.class);
    public final PBUInt32Field uint32_total_bind_contacts_frd_num = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcf0.cmd0xcf0
 * JD-Core Version:    0.7.0.1
 */