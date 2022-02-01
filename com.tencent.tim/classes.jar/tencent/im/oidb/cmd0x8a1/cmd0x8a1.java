package tencent.im.oidb.cmd0x8a1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8a1
{
  public static final class ClientInfo
    extends MessageMicro<ClientInfo>
  {
    public static final int STRING_INST_ID_FIELD_NUMBER = 4;
    public static final int UINT32_APP_ID_FIELD_NUMBER = 3;
    public static final int UINT32_PUB_NO_FIELD_NUMBER = 1;
    public static final int UINT32_VERSION_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField string_inst_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pub_no = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_pub_no", "uint32_version", "uint32_app_id", "string_inst_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ClientInfo.class);
    }
  }
  
  public static final class CreateGroupInfo
    extends MessageMicro<CreateGroupInfo>
  {
    public static final int MSG_CLIENT_INFO_FIELD_NUMBER = 19;
    public static final int MSG_GROUP_GEO_INFO_FIELD_NUMBER = 20;
    public static final int STRING_ANSWER_FIELD_NUMBER = 17;
    public static final int STRING_GROUP_FINGER_MEMO_FIELD_NUMBER = 14;
    public static final int STRING_GROUP_MEMO_FIELD_NUMBER = 13;
    public static final int STRING_GROUP_NAME_FIELD_NUMBER = 10;
    public static final int STRING_GROUP_RICH_FINGER_MEMO_FIELD_NUMBER = 15;
    public static final int STRING_QUESTION_FIELD_NUMBER = 16;
    public static final int STRING_SIGN_FIELD_NUMBER = 18;
    public static final int UINT32_APP_ID_FIELD_NUMBER = 7;
    public static final int UINT32_CHECK_LIMIT_FLAG_FIELD_NUMBER = 12;
    public static final int UINT32_CONF_UIN_FIELD_NUMBER = 11;
    public static final int UINT32_GROUP_CLASS_EXT_FIELD_NUMBER = 5;
    public static final int UINT32_GROUP_CLASS_FIELD_NUMBER = 4;
    public static final int UINT32_GROUP_CODE_FIELD_NUMBER = 1;
    public static final int UINT32_GROUP_FACE_FIELD_NUMBER = 6;
    public static final int UINT32_GROUP_FACE_FLAG_FIELD_NUMBER = 22;
    public static final int UINT32_GROUP_OPTION_FIELD_NUMBER = 3;
    public static final int UINT32_GROUP_SIZE_FIELD_NUMBER = 8;
    public static final int UINT32_GROUP_TYPE_FLAG_FIELD_NUMBER = 21;
    public static final int UINT64_CREATE_FLAG_FIELD_NUMBER = 9;
    public static final int UINT64_OWNER_UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public cmd0x8a1.ClientInfo msg_client_info = new cmd0x8a1.ClientInfo();
    public cmd0x8a1.GroupGeoInfo msg_group_geo_info = new cmd0x8a1.GroupGeoInfo();
    public final PBBytesField string_answer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_group_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_group_memo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_group_rich_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_question = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_sign = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_check_limit_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_conf_uin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_class = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_class_ext = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_face = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_face_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_option = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_type_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_flag = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 88, 96, 106, 114, 122, 130, 138, 146, 154, 162, 168, 176 }, new String[] { "uint32_group_code", "uint64_owner_uin", "uint32_group_option", "uint32_group_class", "uint32_group_class_ext", "uint32_group_face", "uint32_app_id", "uint32_group_size", "uint64_create_flag", "string_group_name", "uint32_conf_uin", "uint32_check_limit_flag", "string_group_memo", "string_group_finger_memo", "string_group_rich_finger_memo", "string_question", "string_answer", "string_sign", "msg_client_info", "msg_group_geo_info", "uint32_group_type_flag", "uint32_group_face_flag" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, null, null, Integer.valueOf(0), Integer.valueOf(0) }, CreateGroupInfo.class);
    }
  }
  
  public static final class GroupGeoInfo
    extends MessageMicro<GroupGeoInfo>
  {
    public static final int STRING_GEO_CONTENT_FIELD_NUMBER = 4;
    public static final int UINT32_CITY_ID_FIELD_NUMBER = 1;
    public static final int UINT64_LATITUDE_FIELD_NUMBER = 3;
    public static final int UINT64_LONGTITUDE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField string_geo_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_city_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_latitude = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_longtitude = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_city_id", "uint64_longtitude", "uint64_latitude", "string_geo_content" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, GroupGeoInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_CREATE_GROUP_INFO_FIELD_NUMBER = 2;
    public static final int MSG_SELECT_GROUP_CODE_INFO_FIELD_NUMBER = 3;
    public static final int UINT32_CREATE_OPTION_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_create_option", "msg_create_group_info", "msg_select_group_code_info" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
    public cmd0x8a1.CreateGroupInfo msg_create_group_info = new cmd0x8a1.CreateGroupInfo();
    public cmd0x8a1.SelectGroupCodeInfo msg_select_group_code_info = new cmd0x8a1.SelectGroupCodeInfo();
    public final PBUInt32Field uint32_create_option = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int STRING_SIGN_FIELD_NUMBER = 6;
    public static final int UINT32_CREATE_OPTION_FIELD_NUMBER = 1;
    public static final int UINT32_GROUP_CODE_FIELD_NUMBER = 2;
    public static final int UINT32_GROUP_SIZE_FIELD_NUMBER = 5;
    public static final int UINT32_GROUP_UIN_FIELD_NUMBER = 3;
    public static final int UINT64_OWNER_UIN_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField string_sign = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_create_option = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_uin = PBField.initUInt32(0);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint32_create_option", "uint32_group_code", "uint32_group_uin", "uint64_owner_uin", "uint32_group_size", "string_sign" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class SelectGroupCodeInfo
    extends MessageMicro<SelectGroupCodeInfo>
  {
    public static final int UINT64_OWNER_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_owner_uin" }, new Object[] { Long.valueOf(0L) }, SelectGroupCodeInfo.class);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a1.cmd0x8a1
 * JD-Core Version:    0.7.0.1
 */