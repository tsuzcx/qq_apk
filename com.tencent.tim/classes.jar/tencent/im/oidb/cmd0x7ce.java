package tencent.im.oidb;

import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.AppointInfo;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.LBSInfo;
import appoint.define.appoint_define.PublisherInfo;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7ce
{
  public static final class AppintDetail
    extends MessageMicro<AppintDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_SigC2C = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.AppointInfo msg_appoints_info = new appoint_define.AppointInfo();
    public appoint_define.PublisherInfo msg_publisher_info = new appoint_define.PublisherInfo();
    public final PBRepeatMessageField<appoint_define.DateComment> rpt_msg_comment_list = PBField.initRepeatMessage(appoint_define.DateComment.class);
    public final PBRepeatMessageField<appoint_define.StrangerInfo> rpt_msg_stranger_info = PBField.initRepeatMessage(appoint_define.StrangerInfo.class);
    public final PBRepeatMessageField<appoint_define.StrangerInfo> rpt_msg_vistor_info = PBField.initRepeatMessage(appoint_define.StrangerInfo.class);
    public final PBStringField str_aio_errmsg = PBField.initString("");
    public final PBStringField str_profile_errmsg = PBField.initString("");
    public final PBUInt32Field uint32_can_aio = PBField.initUInt32(0);
    public final PBUInt32Field uint32_can_profile = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_next = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_limited = PBField.initUInt32(0);
    public final PBUInt32Field uint32_me_invited = PBField.initUInt32(0);
    public final PBUInt32Field uint32_me_join = PBField.initUInt32(0);
    public final PBUInt32Field uint32_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_view_next = PBField.initUInt32(0);
    public final PBUInt32Field uint32_view_over = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 64, 74, 80, 96, 106, 112, 122, 130, 136, 144, 154, 160, 184 }, new String[] { "msg_publisher_info", "msg_appoints_info", "uint32_score", "uint32_join_over", "uint32_join_next", "rpt_msg_stranger_info", "uint32_view_over", "uint32_view_next", "rpt_msg_vistor_info", "uint32_me_join", "uint32_can_profile", "str_profile_errmsg", "uint32_can_aio", "str_aio_errmsg", "bytes_SigC2C", "uint64_uin", "uint32_limited", "rpt_msg_comment_list", "uint32_comment_over", "uint32_me_invited" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, AppintDetail.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 800 }, new String[] { "rpt_appoint_ids", "uint32_join_start", "uint32_join_want", "uint32_view_start", "uint32_view_want", "msg_lbs_info", "rpt_uint64_uins", "uint32_view_comment_count", "uint64_request_uin" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
    public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
    public final PBRepeatMessageField<appoint_define.AppointID> rpt_appoint_ids = PBField.initRepeatMessage(appoint_define.AppointID.class);
    public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_join_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_want = PBField.initUInt32(0);
    public final PBUInt32Field uint32_view_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_view_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_view_want = PBField.initUInt32(0);
    public final PBUInt64Field uint64_request_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "rpt_msg_appoints_info", "uint32_secure_flag", "str_secure_tips" }, new Object[] { null, Integer.valueOf(0), "" }, RspBody.class);
    public final PBRepeatMessageField<cmd0x7ce.AppintDetail> rpt_msg_appoints_info = PBField.initRepeatMessage(cmd0x7ce.AppintDetail.class);
    public final PBStringField str_secure_tips = PBField.initString("");
    public final PBUInt32Field uint32_secure_flag = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7ce
 * JD-Core Version:    0.7.0.1
 */