package tencent.im.oidb;

import appoint.define.appoint_define.AppointContent;
import appoint.define.appoint_define.GPS;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sync
{
  public static final class SyncAppointmentReq
    extends MessageMicro<SyncAppointmentReq>
  {
    public static final int MSG_APPOINTMENT_FIELD_NUMBER = 2;
    public static final int MSG_GPS_INFO_FIELD_NUMBER = 3;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_uin", "msg_appointment", "msg_gps_info" }, new Object[] { Long.valueOf(0L), null, null }, SyncAppointmentReq.class);
    public appoint_define.AppointContent msg_appointment = new appoint_define.AppointContent();
    public appoint_define.GPS msg_gps_info = new appoint_define.GPS();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SyncAppointmentRsp
    extends MessageMicro<SyncAppointmentRsp>
  {
    public static final int UINT32_RESULT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_result" }, new Object[] { Integer.valueOf(0) }, SyncAppointmentRsp.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.sync
 * JD-Core Version:    0.7.0.1
 */