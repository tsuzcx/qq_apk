package tencent.im.oidb;

import appoint.define.appoint_define.AppointInfo;
import appoint.define.appoint_define.LBSInfo;
import appoint.define.appoint_define.LocaleInfo;
import appoint.define.appoint_define.PublisherInfo;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7de
{
  public static final class BusiReqHead
    extends MessageMicro<BusiReqHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_version", "int32_seq" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, BusiReqHead.class);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
    public final PBInt32Field int32_version = PBField.initInt32(1);
  }
  
  public static final class BusiRespHead
    extends MessageMicro<BusiRespHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int32_version", "int32_seq", "int32_reply_code", "str_result" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), "" }, BusiRespHead.class);
    public final PBInt32Field int32_reply_code = PBField.initInt32(0);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
    public final PBInt32Field int32_version = PBField.initInt32(1);
    public final PBStringField str_result = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.LocaleInfo msg_destination = new appoint_define.LocaleInfo();
    public cmd0x7de.BusiReqHead msg_head = new cmd0x7de.BusiReqHead();
    public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
    public final PBUInt32Field uint32_age_low = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age_up = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subject = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 74, 82 }, new String[] { "msg_head", "msg_lbs_info", "uint32_time", "uint32_subject", "uint32_gender", "uint32_age_low", "uint32_age_up", "uint32_profession", "bytes_cookie", "msg_destination" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0x7de.BusiRespHead msg_head = new cmd0x7de.BusiRespHead();
    public final PBRepeatMessageField<cmd0x7de.UserProfile> rpt_msg_user_list = PBField.initRepeatMessage(cmd0x7de.UserProfile.class);
    public final PBUInt32Field uint32_ended = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_head", "rpt_msg_user_list", "uint32_ended", "bytes_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class UserProfile
    extends MessageMicro<UserProfile>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_publisher_info", "msg_appoints_info", "rpt_msg_vistor_info" }, new Object[] { null, null, null }, UserProfile.class);
    public appoint_define.AppointInfo msg_appoints_info = new appoint_define.AppointInfo();
    public appoint_define.PublisherInfo msg_publisher_info = new appoint_define.PublisherInfo();
    public final PBRepeatMessageField<appoint_define.StrangerInfo> rpt_msg_vistor_info = PBField.initRepeatMessage(appoint_define.StrangerInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7de
 * JD-Core Version:    0.7.0.1
 */