package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x88d$GroupInfo
  extends MessageMicro
{
  public static final int GROUP_GEO_INFO_FIELD_NUMBER = 42;
  public static final int MSG_HEAD_PORTRAIT_FIELD_NUMBER = 44;
  public static final int RPT_TAG_RECORD_FIELD_NUMBER = 41;
  public static final int STRING_CERTIFICATION_TEXT_FIELD_NUMBER = 39;
  public static final int STRING_GROUP_AIO_SKIN_URL_FIELD_NUMBER = 32;
  public static final int STRING_GROUP_ANSWER_FIELD_NUMBER = 25;
  public static final int STRING_GROUP_BOARD_SKIN_URL_FIELD_NUMBER = 33;
  public static final int STRING_GROUP_CLASS_TEXT_FIELD_NUMBER = 18;
  public static final int STRING_GROUP_COVER_SKIN_URL_FIELD_NUMBER = 35;
  public static final int STRING_GROUP_FINGER_MEMO_FIELD_NUMBER = 17;
  public static final int STRING_GROUP_MEMO_FIELD_NUMBER = 16;
  public static final int STRING_GROUP_NAME_FIELD_NUMBER = 15;
  public static final int STRING_GROUP_QUESTION_FIELD_NUMBER = 24;
  public static final int STRING_GROUP_RICH_FINGER_MEMO_FIELD_NUMBER = 40;
  public static final int UINT32_ACTIVE_MEMBER_NUM_FIELD_NUMBER = 37;
  public static final int UINT32_CERTIFICATION_TYPE_FIELD_NUMBER = 38;
  public static final int UINT32_CMDUIN_FLAG_EX_FIELD_NUMBER = 51;
  public static final int UINT32_CMDUIN_JOIN_TIME_FIELD_NUMBER = 49;
  public static final int UINT32_CMDUIN_LAST_MSG_TIME_FIELD_NUMBER = 54;
  public static final int UINT32_CMDUIN_MSG_SEQ_FIELD_NUMBER = 48;
  public static final int UINT32_CMDUIN_NEW_MOBILE_FLAG_FIELD_NUMBER = 52;
  public static final int UINT32_CMDUIN_READ_MSG_SEQ_FIELD_NUMBER = 53;
  public static final int UINT32_CMDUIN_UIN_FLAG_FIELD_NUMBER = 50;
  public static final int UINT32_CREATE_SOURCE_FLAG_FIELD_NUMBER = 47;
  public static final int UINT32_GROUP_ADMIN_MAX_NUM_FIELD_NUMBER = 29;
  public static final int UINT32_GROUP_AIO_SKIN_TIMESTAMP_FIELD_NUMBER = 30;
  public static final int UINT32_GROUP_ALLIANCE_CODE_FIELD_NUMBER = 19;
  public static final int UINT32_GROUP_BOARD_SKIN_TIMESTAMP_FIELD_NUMBER = 31;
  public static final int UINT32_GROUP_CLASS_EXT_FIELD_NUMBER = 8;
  public static final int UINT32_GROUP_COVER_SKIN_TIMESTAMP_FIELD_NUMBER = 34;
  public static final int UINT32_GROUP_CREATE_TIME_FIELD_NUMBER = 2;
  public static final int UINT32_GROUP_CUR_MSG_SEQ_FIELD_NUMBER = 22;
  public static final int UINT32_GROUP_DEFAULT_PAGE_FIELD_NUMBER = 12;
  public static final int UINT32_GROUP_EXTRA_ADM_NUM_FIELD_NUMBER = 20;
  public static final int UINT32_GROUP_FACE_FIELD_NUMBER = 11;
  public static final int UINT32_GROUP_FLAG_EXT_FIELD_NUMBER = 4;
  public static final int UINT32_GROUP_FLAG_FIELD_NUMBER = 3;
  public static final int UINT32_GROUP_GRADE_FIELD_NUMBER = 36;
  public static final int UINT32_GROUP_INFO_SEQ_FIELD_NUMBER = 13;
  public static final int UINT32_GROUP_LAST_MSG_TIME_FIELD_NUMBER = 23;
  public static final int UINT32_GROUP_LEVEL_FIELD_NUMBER = 10;
  public static final int UINT32_GROUP_MEMBER_MAX_NUM_FIELD_NUMBER = 5;
  public static final int UINT32_GROUP_MEMBER_NUM_FIELD_NUMBER = 6;
  public static final int UINT32_GROUP_OPTION_FIELD_NUMBER = 7;
  public static final int UINT32_GROUP_ROAMING_TIME_FIELD_NUMBER = 14;
  public static final int UINT32_GROUP_SPECIAL_CLASS_FIELD_NUMBER = 9;
  public static final int UINT32_GROUP_TYPE_FLAG_FIELD_NUMBER = 55;
  public static final int UINT32_GROUP_VISITOR_CUR_NUM_FIELD_NUMBER = 27;
  public static final int UINT32_GROUP_VISITOR_MAX_NUM_FIELD_NUMBER = 26;
  public static final int UINT32_HEAD_PORTRAIT_SEQ_FIELD_NUMBER = 43;
  public static final int UINT32_LEVEL_NAME_SEQ_FIELD_NUMBER = 28;
  public static final int UINT32_SHUTUP_TIMESTAMP_FIELD_NUMBER = 45;
  public static final int UINT32_SHUTUP_TIMESTAMP_ME_FIELD_NUMBER = 46;
  public static final int UINT64_GROUP_OWNER_FIELD_NUMBER = 1;
  public static final int UINT64_GROUP_UIN_FIELD_NUMBER = 21;
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0x88d.GroupGeoInfo group_geo_info = new oidb_0x88d.GroupGeoInfo();
  public oidb_0x88d.GroupHeadPortrait msg_head_portrait = new oidb_0x88d.GroupHeadPortrait();
  public final PBRepeatMessageField rpt_tag_record = PBField.initRepeatMessage(oidb_0x88d.TagRecord.class);
  public final PBBytesField string_certification_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_aio_skin_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_answer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_board_skin_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_class_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_cover_skin_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_question = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_rich_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_active_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_certification_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_flag_ex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_join_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_last_msg_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_new_mobile_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_read_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_uin_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_create_source_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_admin_max_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_aio_skin_timestamp = PBField.initUInt32(0);
  public final PBRepeatField uint32_group_alliance_code = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_group_board_skin_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_class_ext = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_cover_skin_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_cur_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_default_page = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_extra_adm_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_face = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flag_ext = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_grade = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_info_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_last_msg_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_member_max_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_option = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_roaming_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_special_class = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_type_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_visitor_cur_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_visitor_max_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_head_portrait_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level_name_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_shutup_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_shutup_timestamp_me = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_owner = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 122, 130, 138, 146, 152, 160, 168, 176, 184, 194, 202, 208, 216, 224, 232, 240, 248, 258, 266, 272, 282, 288, 296, 304, 314, 322, 330, 338, 344, 354, 360, 368, 376, 384, 392, 400, 408, 416, 424, 432, 440 }, new String[] { "uint64_group_owner", "uint32_group_create_time", "uint32_group_flag", "uint32_group_flag_ext", "uint32_group_member_max_num", "uint32_group_member_num", "uint32_group_option", "uint32_group_class_ext", "uint32_group_special_class", "uint32_group_level", "uint32_group_face", "uint32_group_default_page", "uint32_group_info_seq", "uint32_group_roaming_time", "string_group_name", "string_group_memo", "string_group_finger_memo", "string_group_class_text", "uint32_group_alliance_code", "uint32_group_extra_adm_num", "uint64_group_uin", "uint32_group_cur_msg_seq", "uint32_group_last_msg_time", "string_group_question", "string_group_answer", "uint32_group_visitor_max_num", "uint32_group_visitor_cur_num", "uint32_level_name_seq", "uint32_group_admin_max_num", "uint32_group_aio_skin_timestamp", "uint32_group_board_skin_timestamp", "string_group_aio_skin_url", "string_group_board_skin_url", "uint32_group_cover_skin_timestamp", "string_group_cover_skin_url", "uint32_group_grade", "uint32_active_member_num", "uint32_certification_type", "string_certification_text", "string_group_rich_finger_memo", "rpt_tag_record", "group_geo_info", "uint32_head_portrait_seq", "msg_head_portrait", "uint32_shutup_timestamp", "uint32_shutup_timestamp_me", "uint32_create_source_flag", "uint32_cmduin_msg_seq", "uint32_cmduin_join_time", "uint32_cmduin_uin_flag", "uint32_cmduin_flag_ex", "uint32_cmduin_new_mobile_flag", "uint32_cmduin_read_msg_seq", "uint32_cmduin_last_msg_time", "uint32_group_type_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), localByteStringMicro9, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro10, localByteStringMicro11, null, null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo
 * JD-Core Version:    0.7.0.1
 */