package tencent.im.groupvideo.s2c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class gv_pstn_bill
{
  public static final class GroupVideoS2CBody
    extends MessageMicro<GroupVideoS2CBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_s2c_notify_bill_req" }, new Object[] { null }, GroupVideoS2CBody.class);
    public gv_pstn_bill.S2CNotifyBillReq msg_s2c_notify_bill_req = new gv_pstn_bill.S2CNotifyBillReq();
  }
  
  public static final class S2CNotifyBillReq
    extends MessageMicro<S2CNotifyBillReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 90, 98 }, new String[] { "uint32_seq", "uint32_busstype", "uint32_authmode", "uint32_groupcode", "uint64_uin", "uint32_room_num", "uint32_create_time", "uint32_close_time", "str_bill_msg", "str_bill_detail" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "" }, S2CNotifyBillReq.class);
    public final PBStringField str_bill_detail = PBField.initString("");
    public final PBStringField str_bill_msg = PBField.initString("");
    public final PBUInt32Field uint32_authmode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_busstype = PBField.initUInt32(0);
    public final PBUInt64Field uint32_close_time = PBField.initUInt64(0L);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_groupcode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_room_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.groupvideo.s2c.gv_pstn_bill
 * JD-Core Version:    0.7.0.1
 */