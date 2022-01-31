package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8b8$ReqBody
  extends MessageMicro
{
  public static final int MSG_DEL_PIC_FIELD_NUMBER = 6;
  public static final int MSG_MODIFY_ORDER_FIELD_NUMBER = 4;
  public static final int MSG_SET_DEFAULT_FIELD_NUMBER = 5;
  public static final int UINT32_SEQUENCE_FIELD_NUMBER = 2;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 3;
  public static final int UINT64_GROUP_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "uint64_group_uin", "uint32_sequence", "uint32_subcmd", "msg_modify_order", "msg_set_default", "msg_del_pic" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, null }, ReqBody.class);
  public oidb_0x8b8.DelPicReq msg_del_pic = new oidb_0x8b8.DelPicReq();
  public oidb_0x8b8.ModifyOrderReq msg_modify_order = new oidb_0x8b8.ModifyOrderReq();
  public oidb_0x8b8.SetDefaultReq msg_set_default = new oidb_0x8b8.SetDefaultReq();
  public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b8.oidb_0x8b8.ReqBody
 * JD-Core Version:    0.7.0.1
 */