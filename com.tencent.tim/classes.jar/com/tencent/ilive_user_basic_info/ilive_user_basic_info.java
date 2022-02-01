package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_user_basic_info
{
  public static final class BatchGetMedalInfoReq
    extends MessageMicro<BatchGetMedalInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "medal_id_list" }, new Object[] { Integer.valueOf(0) }, BatchGetMedalInfoReq.class);
    public final PBRepeatField<Integer> medal_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class BatchGetMedalInfoRsp
    extends MessageMicro<BatchGetMedalInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "medalinfo_list", "result" }, new Object[] { null, Integer.valueOf(0) }, BatchGetMedalInfoRsp.class);
    public final PBRepeatMessageField<ilive_user_basic_info.MedalInfo> medalinfo_list = PBField.initRepeatMessage(ilive_user_basic_info.MedalInfo.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class BatchGetUserInfoReq
    extends MessageMicro<BatchGetUserInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin_list", "op_type", "from_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, BatchGetUserInfoReq.class);
    public final PBUInt32Field from_type = PBField.initUInt32(0);
    public final PBUInt32Field op_type = PBField.initUInt32(0);
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class BatchGetUserInfoRsp
    extends MessageMicro<BatchGetUserInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "userinfo_list", "result" }, new Object[] { null, Integer.valueOf(0) }, BatchGetUserInfoRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBRepeatMessageField<ilive_user_basic_info.UserInfo> userinfo_list = PBField.initRepeatMessage(ilive_user_basic_info.UserInfo.class);
  }
  
  public static final class GetDisplayMinMedalLevelReq
    extends MessageMicro<GetDisplayMinMedalLevelReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "from_type" }, new Object[] { Integer.valueOf(0) }, GetDisplayMinMedalLevelReq.class);
    public final PBUInt32Field from_type = PBField.initUInt32(0);
  }
  
  public static final class GetDisplayMinMedalLevelRsp
    extends MessageMicro<GetDisplayMinMedalLevelRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "medal_id", "result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetDisplayMinMedalLevelRsp.class);
    public final PBUInt32Field medal_id = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class MedalInfo
    extends MessageMicro<MedalInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBUInt32Field medal_bg = PBField.initUInt32(0);
    public final PBBytesField medal_bg_img = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField medal_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field medal_end_time = PBField.initUInt64(0L);
    public final PBBytesField medal_face_bigger = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField medal_face_small = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field medal_frame = PBField.initUInt32(0);
    public final PBUInt32Field medal_id = PBField.initUInt32(0);
    public final PBUInt32Field medal_index = PBField.initUInt32(0);
    public final PBUInt32Field medal_level = PBField.initUInt32(0);
    public final PBBytesField medal_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field medal_point = PBField.initUInt32(0);
    public final PBUInt32Field medal_priority_level = PBField.initUInt32(0);
    public final PBUInt64Field medal_start_time = PBField.initUInt64(0L);
    public final PBUInt32Field medal_type = PBField.initUInt32(0);
    public final PBBytesField medal_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field medal_version = PBField.initUInt32(0);
    public final PBUInt64Field update_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 112, 120, 128, 136, 144, 154 }, new String[] { "medal_id", "medal_name", "medal_face_small", "medal_type", "medal_start_time", "medal_end_time", "medal_priority_level", "medal_desc", "medal_url", "medal_face_bigger", "medal_version", "medal_index", "medal_level", "medal_point", "create_time", "update_time", "medal_bg", "medal_frame", "medal_bg_img" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6 }, MedalInfo.class);
    }
  }
  
  public static final class ModifyUserMedalReq
    extends MessageMicro<ModifyUserMedalReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "uid", "op_type", "level", "point", "medal_id", "medal_level", "medal_point", "start_time", "end_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ModifyUserMedalReq.class);
    public final PBUInt64Field end_time = PBField.initUInt64(0L);
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBUInt32Field medal_id = PBField.initUInt32(0);
    public final PBUInt32Field medal_level = PBField.initUInt32(0);
    public final PBUInt32Field medal_point = PBField.initUInt32(0);
    public final PBUInt32Field op_type = PBField.initUInt32(0);
    public final PBUInt32Field point = PBField.initUInt32(0);
    public final PBUInt64Field start_time = PBField.initUInt64(0L);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
  }
  
  public static final class ModifyUserMedalRsp
    extends MessageMicro<ModifyUserMedalRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "result" }, new Object[] { Integer.valueOf(0) }, ModifyUserMedalRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class UserBasicInfo
    extends MessageMicro<UserBasicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin" }, new Object[] { Long.valueOf(0L) }, UserBasicInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class UserExtraInfo
    extends MessageMicro<UserExtraInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56 }, new String[] { "uin", "medal_info_list", "uint32_level", "uint32_point", "uint32_next_point", "uint32_pre_point", "version" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UserExtraInfo.class);
    public final PBRepeatMessageField<ilive_user_basic_info.MedalInfo> medal_info_list = PBField.initRepeatMessage(ilive_user_basic_info.MedalInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pre_point = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uin", "basic_info", "extra_info" }, new Object[] { Long.valueOf(0L), null, null }, UserInfo.class);
    public ilive_user_basic_info.UserBasicInfo basic_info = new ilive_user_basic_info.UserBasicInfo();
    public ilive_user_basic_info.UserExtraInfo extra_info = new ilive_user_basic_info.UserExtraInfo();
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ilive_user_basic_info.ilive_user_basic_info
 * JD-Core Version:    0.7.0.1
 */