package com.tencent.pb.remind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RemindPB
{
  public static final class RemindItem
    extends MessageMicro<RemindItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint32_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, RemindItem.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RemindQuota
    extends MessageMicro<RemindQuota>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_comm_quota", "uint32_svip_quota", "uint32_user_quota", "uint32_used" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RemindQuota.class);
    public final PBUInt32Field uint32_comm_quota = PBField.initUInt32(0);
    public final PBUInt32Field uint32_svip_quota = PBField.initUInt32(0);
    public final PBUInt32Field uint32_used = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_quota = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_method", "rep_set_info", "rep_clear_uin" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, ReqBody.class);
    public final PBRepeatField<Long> rep_clear_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<RemindPB.RemindItem> rep_set_info = PBField.initRepeatMessage(RemindPB.RemindItem.class);
    public final PBUInt32Field uint32_method = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "int32_ret", "uint32_method", "msg_result", "msg_quota", "rep_set_info", "rep_clear_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null, null, Long.valueOf(0L) }, RspBody.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public RemindPB.RemindQuota msg_quota = new RemindPB.RemindQuota();
    public final PBStringField msg_result = PBField.initString("");
    public final PBRepeatField<Long> rep_clear_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<RemindPB.RemindItem> rep_set_info = PBField.initRepeatMessage(RemindPB.RemindItem.class);
    public final PBUInt32Field uint32_method = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.remind.RemindPB
 * JD-Core Version:    0.7.0.1
 */