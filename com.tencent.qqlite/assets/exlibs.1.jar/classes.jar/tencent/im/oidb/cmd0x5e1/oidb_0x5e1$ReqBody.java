package tencent.im.oidb.cmd0x5e1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5e1$ReqBody
  extends MessageMicro
{
  public static final int RPT_BYTES_OPENID_FIELD_NUMBER = 4;
  public static final int RPT_UINT64_UINS_FIELD_NUMBER = 1;
  public static final int UINT32_APPID_FIELD_NUMBER = 5;
  public static final int UINT32_MAX_PACKAGE_SIZE_FIELD_NUMBER = 3;
  public static final int UINT32_REQ_ALLOW_FIELD_NUMBER = 20014;
  public static final int UINT32_REQ_BASIC_CLI_FLAG_FIELD_NUMBER = 21007;
  public static final int UINT32_REQ_BASIC_SVR_FLAG_FIELD_NUMBER = 21006;
  public static final int UINT32_REQ_BIRTHDAY_FIELD_NUMBER = 20031;
  public static final int UINT32_REQ_BUBBLE_ID_FIELD_NUMBER = 20059;
  public static final int UINT32_REQ_CITY_FIELD_NUMBER = 20020;
  public static final int UINT32_REQ_CITY_ID_FIELD_NUMBER = 20032;
  public static final int UINT32_REQ_CITY_ZONE_ID_FIELD_NUMBER = 20041;
  public static final int UINT32_REQ_COMMON_PLACE1_FIELD_NUMBER = 20027;
  public static final int UINT32_REQ_COUNTRY_FIELD_NUMBER = 20003;
  public static final int UINT32_REQ_EXT_FLAG_FIELD_NUMBER = 21004;
  public static final int UINT32_REQ_FACE_ADDON_ID_FIELD_NUMBER = 27025;
  public static final int UINT32_REQ_FACE_ID_FIELD_NUMBER = 20015;
  public static final int UINT32_REQ_FULL_AGE_FIELD_NUMBER = 26005;
  public static final int UINT32_REQ_FULL_BIRTHDAY_FIELD_NUMBER = 26004;
  public static final int UINT32_REQ_GENDER_FIELD_NUMBER = 20009;
  public static final int UINT32_REQ_GROUP_MEM_CREDIT_FLAG_FIELD_NUMBER = 27022;
  public static final int UINT32_REQ_LANG1_FIELD_NUMBER = 20033;
  public static final int UINT32_REQ_LANG2_FIELD_NUMBER = 20034;
  public static final int UINT32_REQ_LANG3_FIELD_NUMBER = 20035;
  public static final int UINT32_REQ_LFLAG_FIELD_NUMBER = 21003;
  public static final int UINT32_REQ_MSS1_SERVICE_FIELD_NUMBER = 21002;
  public static final int UINT32_REQ_MSS2_IDENTITY_FIELD_NUMBER = 21001;
  public static final int UINT32_REQ_MSS3_BITMAPEXTRA_FIELD_NUMBER = 20030;
  public static final int UINT32_REQ_MSS_UPDATE_TIME_FIELD_NUMBER = 26011;
  public static final int UINT32_REQ_MUSIC_GENE_FIELD_NUMBER = 27026;
  public static final int UINT32_REQ_NICK_FIELD_NUMBER = 20002;
  public static final int UINT32_REQ_OIN_FIELD_NUMBER = 20056;
  public static final int UINT32_REQ_PENGYOU_FLAG_FIELD_NUMBER = 24118;
  public static final int UINT32_REQ_PENGYOU_GENDER_FIELD_NUMBER = 24103;
  public static final int UINT32_REQ_PENGYOU_REALNAME_FIELD_NUMBER = 24101;
  public static final int UINT32_REQ_PROVINCE_FIELD_NUMBER = 20004;
  public static final int UINT32_REQ_SIMPLE_UPDATE_TIME_FIELD_NUMBER = 26010;
  public static final int UINT32_START_TIME_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField rpt_bytes_openid = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_package_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_allow = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_basic_cli_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_basic_svr_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_bubble_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_city = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_city_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_city_zone_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_common_place1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_country = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_ext_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_face_addon_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_full_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_full_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_group_mem_credit_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lang1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lang2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lang3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss1_service = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss2_identity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss3_bitmapextra = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_music_gene = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_oin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pengyou_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pengyou_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pengyou_realname = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_province = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_simple_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 160016, 160024, 160032, 160072, 160112, 160120, 160160, 160216, 160240, 160248, 160256, 160264, 160272, 160280, 160328, 160448, 160472, 168008, 168016, 168024, 168032, 168048, 168056, 192808, 192824, 192944, 208032, 208040, 208080, 208088, 216176, 216200, 216208 }, new String[] { "rpt_uint64_uins", "uint32_start_time", "uint32_max_package_size", "rpt_bytes_openid", "uint32_appid", "uint32_req_nick", "uint32_req_country", "uint32_req_province", "uint32_req_gender", "uint32_req_allow", "uint32_req_face_id", "uint32_req_city", "uint32_req_common_place1", "uint32_req_mss3_bitmapextra", "uint32_req_birthday", "uint32_req_city_id", "uint32_req_lang1", "uint32_req_lang2", "uint32_req_lang3", "uint32_req_city_zone_id", "uint32_req_oin", "uint32_req_bubble_id", "uint32_req_mss2_identity", "uint32_req_mss1_service", "uint32_req_lflag", "uint32_req_ext_flag", "uint32_req_basic_svr_flag", "uint32_req_basic_cli_flag", "uint32_req_pengyou_realname", "uint32_req_pengyou_gender", "uint32_req_pengyou_flag", "uint32_req_full_birthday", "uint32_req_full_age", "uint32_req_simple_update_time", "uint32_req_mss_update_time", "uint32_req_group_mem_credit_flag", "uint32_req_face_addon_id", "uint32_req_music_gene" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e1.oidb_0x5e1.ReqBody
 * JD-Core Version:    0.7.0.1
 */