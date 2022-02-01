package tencent.im.s2c.msgtype0x211.submsgtype0xb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0xb
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    public static final int MSG_MSG_HEADER_FIELD_NUMBER = 1;
    public static final int MSG_REJECT_MOTIFY_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_msg_header", "msg_reject_motify" }, new Object[] { null, null }, MsgBody.class);
    public MsgHeader msg_msg_header = new MsgHeader();
    public RejectNotify msg_reject_motify = new RejectNotify();
    
    public static final class MsgHeader
      extends MessageMicro<MsgHeader>
    {
      public static final int AUDIO_START_SUCCESS_NOTIFY = 102;
      public static final int REJECT_NOTIFY = 101;
      public static final int STR_TO_MOBILE_FIELD_NUMBER = 4;
      public static final int UINT32_BODY_TYPE_FIELD_NUMBER = 1;
      public static final int UINT32_SESSION_TYPE_FIELD_NUMBER = 2;
      public static final int UINT64_ROOM_ID_FIELD_NUMBER = 5;
      public static final int UINT64_TO_UIN_FIELD_NUMBER = 3;
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint32_body_type", "uint32_session_type", "uint64_to_uin", "str_to_mobile", "uint64_room_id" }, new Object[] { Integer.valueOf(101), Integer.valueOf(0), Long.valueOf(0L), "", Long.valueOf(0L) }, MsgHeader.class);
      public final PBStringField str_to_mobile = PBField.initString("");
      public final PBEnumField uint32_body_type = PBField.initEnum(101);
      public final PBUInt32Field uint32_session_type = PBField.initUInt32(0);
      public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    }
    
    public static final class RejectNotify
      extends MessageMicro<RejectNotify>
    {
      public static final int ENUM_REJECT_REASON_FIELD_NUMBER = 1;
      public static final int REJECT_BY_REASON_1 = 201;
      public static final int REJECT_BY_REASON_2 = 202;
      public static final int REJECT_BY_REASON_3 = 203;
      public static final int STR_MSG_FIELD_NUMBER = 2;
      public static final int STR_RING_FILENAME_FIELD_NUMBER = 3;
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "enum_reject_reason", "str_msg", "str_ring_filename" }, new Object[] { Integer.valueOf(201), "", "" }, RejectNotify.class);
      public final PBEnumField enum_reject_reason = PBField.initEnum(201);
      public final PBStringField str_msg = PBField.initString("");
      public final PBStringField str_ring_filename = PBField.initString("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb
 * JD-Core Version:    0.7.0.1
 */