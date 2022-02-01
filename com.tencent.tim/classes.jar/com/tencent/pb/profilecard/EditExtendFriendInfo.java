package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class EditExtendFriendInfo
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_declaration = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_personalization = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_voice_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public EditExtendFriendInfo.SchoolInfo msg_school_info = new EditExtendFriendInfo.SchoolInfo();
    public final PBUInt32Field uint32_is_show_card = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_duration = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 66 }, new String[] { "uint64_uin", "bytes_declaration", "bytes_voice_url", "uint32_is_show_card", "uint32_voice_duration", "uint32_voice_attr", "bytes_personalization", "msg_school_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
  
  public static final class SchoolInfo
    extends MessageMicro<SchoolInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 800 }, new String[] { "uint32_category", "str_school_id", "str_school_name", "str_department_id", "str_department_name", "uint32_degree", "uint32_enrollment_year", "uint32_graduation_year", "uint32_allow_recommend", "uint32_create_source", "uint32_create_time", "uint32_update_source", "uint32_update_time", "uint32_hidden_flag", "uint32_verified", "uint32_idx" }, new Object[] { Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SchoolInfo.class);
    public final PBStringField str_department_id = PBField.initString("");
    public final PBStringField str_department_name = PBField.initString("");
    public final PBStringField str_school_id = PBField.initString("");
    public final PBStringField str_school_name = PBField.initString("");
    public final PBUInt32Field uint32_allow_recommend = PBField.initUInt32(0);
    public final PBUInt32Field uint32_category = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_degree = PBField.initUInt32(0);
    public final PBUInt32Field uint32_enrollment_year = PBField.initUInt32(0);
    public final PBUInt32Field uint32_graduation_year = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hidden_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_verified = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.profilecard.EditExtendFriendInfo
 * JD-Core Version:    0.7.0.1
 */