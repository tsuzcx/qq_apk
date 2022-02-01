package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8b8
{
  public static final class DelPicReq
    extends MessageMicro<DelPicReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_del_cnt", "rpt_uint32_del_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, DelPicReq.class);
    public final PBRepeatField<Integer> rpt_uint32_del_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_del_cnt = PBField.initUInt32(0);
  }
  
  public static final class GroupPicListInfo
    extends MessageMicro<GroupPicListInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_pic_id", "uint32_left_x", "uint32_left_y", "uint32_right_x", "uint32_right_y" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupPicListInfo.class);
    public final PBUInt32Field uint32_left_x = PBField.initUInt32(0);
    public final PBUInt32Field uint32_left_y = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_right_x = PBField.initUInt32(0);
    public final PBUInt32Field uint32_right_y = PBField.initUInt32(0);
  }
  
  public static final class ModifyOrderReq
    extends MessageMicro<ModifyOrderReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_pic_cnt", "rpt_uint32_pic_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ModifyOrderReq.class);
    public final PBRepeatField<Integer> rpt_uint32_pic_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 64 }, new String[] { "uint64_group_uin", "uint32_sequence", "uint32_subcmd", "msg_modify_order", "msg_set_default", "msg_del_pic", "uint32_client_ver" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, ReqBody.class);
    public oidb_0x8b8.DelPicReq msg_del_pic = new oidb_0x8b8.DelPicReq();
    public oidb_0x8b8.ModifyOrderReq msg_modify_order = new oidb_0x8b8.ModifyOrderReq();
    public oidb_0x8b8.SetDefaultReq msg_set_default = new oidb_0x8b8.SetDefaultReq();
    public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "uint32_result", "uint64_group_uin", "uint32_sequence", "uint32_subcmd", "uint32_default_id", "uint32_pic_cnt", "rpt_uint32_pic_list", "rpt_msg_pic_list_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x8b8.GroupPicListInfo> rpt_msg_pic_list_info = PBField.initRepeatMessage(oidb_0x8b8.GroupPicListInfo.class);
    public final PBRepeatField<Integer> rpt_uint32_pic_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_default_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  }
  
  public static final class SetDefaultReq
    extends MessageMicro<SetDefaultReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_default_id" }, new Object[] { Integer.valueOf(0) }, SetDefaultReq.class);
    public final PBUInt32Field uint32_default_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b8.oidb_0x8b8
 * JD-Core Version:    0.7.0.1
 */