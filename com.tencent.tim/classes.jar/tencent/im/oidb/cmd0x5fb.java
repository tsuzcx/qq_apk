package tencent.im.oidb;

import appoint.define.appoint_define.LBSInfo;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x5fb
{
  public static final class BusiReqHead
    extends MessageMicro<BusiReqHead>
  {
    public static final int INT32_SEQ_FIELD_NUMBER = 2;
    public static final int INT32_VERSION_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_version", "int32_seq" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, BusiReqHead.class);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
    public final PBInt32Field int32_version = PBField.initInt32(1);
  }
  
  public static final class BusiRespHead
    extends MessageMicro<BusiRespHead>
  {
    public static final int INT32_REPLY_CODE_FIELD_NUMBER = 3;
    public static final int INT32_SEQ_FIELD_NUMBER = 2;
    public static final int INT32_VERSION_FIELD_NUMBER = 1;
    public static final int STR_RESULT_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int32_version", "int32_seq", "int32_reply_code", "str_result" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), "" }, BusiRespHead.class);
    public final PBInt32Field int32_reply_code = PBField.initInt32(0);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
    public final PBInt32Field int32_version = PBField.initInt32(1);
    public final PBStringField str_result = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_LBS_INFO_FIELD_NUMBER = 2;
    public static final int REQ_INFO_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public cmd0x5fb.BusiReqHead msg_head = new cmd0x5fb.BusiReqHead();
    public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
    public final PBBytesField req_info = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_head", "msg_lbs_info", "req_info" }, new Object[] { null, null, localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class ReqInfo
    extends MessageMicro<ReqInfo>
  {
    public static final int BYTES_COOKIE_FIELD_NUMBER = 9;
    public static final int MSG_DESTINATION_FIELD_NUMBER = 10;
    public static final int UINT32_AGE_LOW_FIELD_NUMBER = 6;
    public static final int UINT32_AGE_UP_FIELD_NUMBER = 7;
    public static final int UINT32_GENDER_FIELD_NUMBER = 5;
    public static final int UINT32_PROFESSION_FIELD_NUMBER = 8;
    public static final int UINT32_SUBJECT_FIELD_NUMBER = 4;
    public static final int UINT32_TIME_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.LocaleInfo msg_destination = new appoint_define.LocaleInfo();
    public final PBUInt32Field uint32_age_low = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age_up = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subject = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 24, 32, 40, 48, 56, 64, 74, 82 }, new String[] { "uint32_time", "uint32_subject", "uint32_gender", "uint32_age_low", "uint32_age_up", "uint32_profession", "bytes_cookie", "msg_destination" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null }, ReqInfo.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_USER_LIST_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public cmd0x5fb.BusiRespHead msg_head = new cmd0x5fb.BusiRespHead();
    public final PBBytesField msg_user_list = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "msg_user_list" }, new Object[] { null, localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class UserProfile
    extends MessageMicro<UserProfile>
  {
    public static final int INT32_ID_TYPE_FIELD_NUMBER = 2;
    public static final int INT32_PIC_TYPE_FIELD_NUMBER = 4;
    public static final int INT32_SUB_PIC_TYPE_FIELD_NUMBER = 5;
    public static final int INT64_ID_FIELD_NUMBER = 1;
    public static final int PIC_URL_FIELD_NUMBER = 9;
    public static final int STR_CONTENT2_FIELD_NUMBER = 8;
    public static final int STR_CONTENT_FIELD_NUMBER = 7;
    public static final int STR_TITLE_FIELD_NUMBER = 6;
    public static final int STR_URL_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58, 66, 74 }, new String[] { "int64_id", "int32_id_type", "str_url", "int32_pic_type", "int32_sub_pic_type", "str_title", "str_content", "str_content2", "pic_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "" }, UserProfile.class);
    public final PBInt32Field int32_id_type = PBField.initInt32(0);
    public final PBInt32Field int32_pic_type = PBField.initInt32(0);
    public final PBInt32Field int32_sub_pic_type = PBField.initInt32(0);
    public final PBInt64Field int64_id = PBField.initInt64(0L);
    public final PBStringField pic_url = PBField.initString("");
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_content2 = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5fb
 * JD-Core Version:    0.7.0.1
 */