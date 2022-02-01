package tencent.im.profile.forward;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sysmsg_push
{
  public static final class AppointmentNot
    extends MessageMicro<AppointmentNot>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tips_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_notifytype = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_from_uin", "uint32_notifytype", "bytes_tips_content" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, AppointmentNot.class);
    }
  }
  
  public static final class ForwardBody
    extends MessageMicro<ForwardBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 162 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_appointment_not" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, ForwardBody.class);
    public sysmsg_push.AppointmentNot msg_appointment_not = new sysmsg_push.AppointmentNot();
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  }
  
  public static final class ForwardHead
    extends MessageMicro<ForwardHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 53, 61, 64, 72, 80 }, new String[] { "uint64_uin", "uint32_client_type", "uint32_req_type", "uint32_cmd", "uint32_sub_cmd", "fixed32_service_addr", "rpt_fixed32_client_addr", "uint32_sequence", "uint32_if_need_ack", "uint32_result" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ForwardHead.class);
    public final PBFixed32Field fixed32_service_addr = PBField.initFixed32(0);
    public final PBRepeatField<Integer> rpt_fixed32_client_addr = PBField.initRepeat(PBFixed32Field.__repeatHelper__);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_if_need_ack = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.profile.forward.sysmsg_push
 * JD-Core Version:    0.7.0.1
 */