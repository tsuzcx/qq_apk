package tencent.im.cs.nearby_troop_activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby_troop_activity
{
  public static final class ActivityDigest
    extends MessageMicro<ActivityDigest>
  {
    public static final int STR_ACTIVITY_ID_FIELD_NUMBER = 1;
    public static final int STR_COVER_URL_FIELD_NUMBER = 4;
    public static final int STR_LOC_NAME_FIELD_NUMBER = 5;
    public static final int STR_NAME_FIELD_NUMBER = 2;
    public static final int STR_TIME_FIELD_NUMBER = 3;
    public static final int STR_URL_INFO_FIELD_NUMBER = 7;
    public static final int UINT32_DISTANCE_FIELD_NUMBER = 8;
    public static final int UINT64_ENROLL_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 64 }, new String[] { "str_activity_id", "str_name", "str_time", "str_cover_url", "str_loc_name", "uint64_enroll", "str_url_info", "uint32_distance" }, new Object[] { "", "", "", "", "", Long.valueOf(0L), "", Integer.valueOf(0) }, ActivityDigest.class);
    public final PBStringField str_activity_id = PBField.initString("");
    public final PBStringField str_cover_url = PBField.initString("");
    public final PBStringField str_loc_name = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_time = PBField.initString("");
    public final PBStringField str_url_info = PBField.initString("");
    public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
    public final PBUInt64Field uint64_enroll = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int INT64_LATITUDE_FIELD_NUMBER = 2;
    public static final int INT64_LONGTITUDE_FIELD_NUMBER = 1;
    public static final int UINT64_DISTANCE_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int64_longtitude", "int64_latitude", "uint64_distance" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBInt64Field int64_latitude = PBField.initInt64(0L);
    public final PBInt64Field int64_longtitude = PBField.initInt64(0L);
    public final PBUInt64Field uint64_distance = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int RPT_ACTIVITY_FIELD_NUMBER = 6;
    public static final int STR_TITLE_FIELD_NUMBER = 3;
    public static final int STR_URL_LIST_FIELD_NUMBER = 5;
    public static final int STR_WORDING_FIELD_NUMBER = 4;
    public static final int UINT32_RET_FIELD_NUMBER = 1;
    public static final int UINT64_COUNT_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "uint32_ret", "uint64_count", "str_title", "str_wording", "str_url_list", "rpt_activity" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", "", "", null }, RspBody.class);
    public final PBRepeatMessageField<nearby_troop_activity.ActivityDigest> rpt_activity = PBField.initRepeatMessage(nearby_troop_activity.ActivityDigest.class);
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_url_list = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
    public final PBUInt64Field uint64_count = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_activity.nearby_troop_activity
 * JD-Core Version:    0.7.0.1
 */