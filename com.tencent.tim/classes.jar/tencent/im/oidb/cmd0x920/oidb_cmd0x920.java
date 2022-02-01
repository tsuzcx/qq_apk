package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x920
{
  public static final class CancleMeeting
    extends MessageMicro<CancleMeeting>
  {
    public static final int RPT_MSG_MEETING_INFO2_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_meeting_info2" }, new Object[] { null }, CancleMeeting.class);
    public final PBRepeatMessageField<oidb_cmd0x920.MeetingInfo> rpt_msg_meeting_info2 = PBField.initRepeatMessage(oidb_cmd0x920.MeetingInfo.class);
  }
  
  public static final class CreateMeeting
    extends MessageMicro<CreateMeeting>
  {
    public static final int RPT_MSG_MEETING_INFO1_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_meeting_info1" }, new Object[] { null }, CreateMeeting.class);
    public final PBRepeatMessageField<oidb_cmd0x920.MeetingInfo> rpt_msg_meeting_info1 = PBField.initRepeatMessage(oidb_cmd0x920.MeetingInfo.class);
  }
  
  public static final class GetDiscussMeeting
    extends MessageMicro<GetDiscussMeeting>
  {
    public static final int UINT64_DISCUSS_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_discuss_uin" }, new Object[] { Long.valueOf(0L) }, GetDiscussMeeting.class);
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetSpecifiedMeeting
    extends MessageMicro<GetSpecifiedMeeting>
  {
    public static final int RPT_MSG_MEETING_INFO3_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_meeting_info3" }, new Object[] { null }, GetSpecifiedMeeting.class);
    public final PBRepeatMessageField<oidb_cmd0x920.MeetingInfo> rpt_msg_meeting_info3 = PBField.initRepeatMessage(oidb_cmd0x920.MeetingInfo.class);
  }
  
  public static final class GetUserMeeting
    extends MessageMicro<GetUserMeeting>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetUserMeeting.class);
  }
  
  public static final class MeetingInfo
    extends MessageMicro<MeetingInfo>
  {
    public static final int BYTES_ERROR_INFO_FIELD_NUMBER = 21;
    public static final int BYTES_MEETING_INTRO_FIELD_NUMBER = 6;
    public static final int RPT_UINT64_PARTICIPANTS_FIELD_NUMBER = 5;
    public static final int UINT32_BEGIN_TIME_FIELD_NUMBER = 3;
    public static final int UINT32_ENABLE_FIELD_NUMBER = 8;
    public static final int UINT32_END_TIME_FIELD_NUMBER = 4;
    public static final int UINT32_ERR_CODE_FIELD_NUMBER = 20;
    public static final int UINT32_TYPE_FIELD_NUMBER = 9;
    public static final int UINT64_CREATOR_UIN_FIELD_NUMBER = 2;
    public static final int UINT64_DISCUSS_UIN_FIELD_NUMBER = 1;
    public static final int UINT64_MEETING_SEQ_FIELD_NUMBER = 7;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_meeting_intro = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> rpt_uint64_participants = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_begin_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_enable = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_err_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_creator_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_meeting_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 64, 72, 160, 170 }, new String[] { "uint64_discuss_uin", "uint64_creator_uin", "uint32_begin_time", "uint32_end_time", "rpt_uint64_participants", "bytes_meeting_intro", "uint64_meeting_seq", "uint32_enable", "uint32_type", "uint32_err_code", "bytes_error_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, MeetingInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_CANCLE_MEETING_FIELD_NUMBER = 3;
    public static final int MSG_CREATE_MEETING_FIELD_NUMBER = 2;
    public static final int MSG_GET_DISCUSS_MEETING_FIELD_NUMBER = 4;
    public static final int MSG_GET_SPECIFIED_MEETING_FIELD_NUMBER = 6;
    public static final int MSG_GET_USER_MEETING_FIELD_NUMBER = 5;
    public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uint32_subcmd", "msg_create_meeting", "msg_cancle_meeting", "msg_get_discuss_meeting", "msg_get_user_meeting", "msg_get_specified_meeting" }, new Object[] { Integer.valueOf(0), null, null, null, null, null }, ReqBody.class);
    public oidb_cmd0x920.CancleMeeting msg_cancle_meeting = new oidb_cmd0x920.CancleMeeting();
    public oidb_cmd0x920.CreateMeeting msg_create_meeting = new oidb_cmd0x920.CreateMeeting();
    public oidb_cmd0x920.GetDiscussMeeting msg_get_discuss_meeting = new oidb_cmd0x920.GetDiscussMeeting();
    public oidb_cmd0x920.GetSpecifiedMeeting msg_get_specified_meeting = new oidb_cmd0x920.GetSpecifiedMeeting();
    public oidb_cmd0x920.GetUserMeeting msg_get_user_meeting = new oidb_cmd0x920.GetUserMeeting();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int MSG_CANCLE_MEETING_FIELD_NUMBER = 3;
    public static final int MSG_CREATE_MEETING_FIELD_NUMBER = 2;
    public static final int RPT_MSG_MEETING_INFO_FIELD_NUMBER = 4;
    public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_subcmd", "msg_create_meeting", "msg_cancle_meeting", "rpt_msg_meeting_info" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
    public oidb_cmd0x920.CancleMeeting msg_cancle_meeting = new oidb_cmd0x920.CancleMeeting();
    public oidb_cmd0x920.CreateMeeting msg_create_meeting = new oidb_cmd0x920.CreateMeeting();
    public final PBRepeatMessageField<oidb_cmd0x920.MeetingInfo> rpt_msg_meeting_info = PBField.initRepeatMessage(oidb_cmd0x920.MeetingInfo.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x920.oidb_cmd0x920
 * JD-Core Version:    0.7.0.1
 */