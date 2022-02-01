package tencent.im.troop.activity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class troopactivity
{
  public static final class ActSSOReq
    extends MessageMicro<ActSSOReq>
  {
    public static final int BODY_FIELD_NUMBER = 3;
    public static final int CMD_FIELD_NUMBER = 1;
    public static final int GROUP_CODE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField cmd = PBField.initEnum(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "cmd", "group_code", "body" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, ActSSOReq.class);
    }
  }
  
  public static final class ActSSORsp
    extends MessageMicro<ActSSORsp>
  {
    public static final int BODY_FIELD_NUMBER = 4;
    public static final int CMD_FIELD_NUMBER = 3;
    public static final int ERR_CODE_FIELD_NUMBER = 1;
    public static final int ERR_MSG_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField cmd = PBField.initEnum(0);
    public final PBEnumField err_code = PBField.initEnum(10000);
    public final PBStringField err_msg = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "err_code", "err_msg", "cmd", "body" }, new Object[] { Integer.valueOf(10000), "", Integer.valueOf(0), localByteStringMicro }, ActSSORsp.class);
    }
  }
  
  public static final class Activity
    extends MessageMicro<Activity>
  {
    public static final int STR_ACTIVITY_ID_FIELD_NUMBER = 1;
    public static final int STR_COVER_URL_FIELD_NUMBER = 5;
    public static final int STR_END_TIME_FIELD_NUMBER = 4;
    public static final int STR_LOC_NAME_FIELD_NUMBER = 6;
    public static final int STR_NAME_FIELD_NUMBER = 2;
    public static final int STR_POI_LOC_NAME_FIELD_NUMBER = 8;
    public static final int STR_START_TIME_FIELD_NUMBER = 3;
    public static final int UINT64_FLAG_FIELD_NUMBER = 7;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66 }, new String[] { "str_activity_id", "str_name", "str_start_time", "str_end_time", "str_cover_url", "str_loc_name", "uint64_flag", "str_poi_loc_name" }, new Object[] { "", "", "", "", "", "", Long.valueOf(0L), "" }, Activity.class);
    public final PBStringField str_activity_id = PBField.initString("");
    public final PBStringField str_cover_url = PBField.initString("");
    public final PBStringField str_end_time = PBField.initString("");
    public final PBStringField str_loc_name = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_poi_loc_name = PBField.initString("");
    public final PBStringField str_start_time = PBField.initString("");
    public final PBUInt64Field uint64_flag = PBField.initUInt64(0L);
  }
  
  public static final class GroupInfoCardResp
    extends MessageMicro<GroupInfoCardResp>
  {
    public static final int ACTIVITYS_FIELD_NUMBER = 1;
    public static final int BEING_ACT_NUM_FIELD_NUMBER = 2;
    public static final int GROUP_ACT_URL_FIELD_NUMBER = 4;
    public static final int HISTORY_ACT_NUM_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "activitys", "being_act_num", "history_act_num", "group_act_url" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, GroupInfoCardResp.class);
    public final PBRepeatMessageField<troopactivity.Activity> activitys = PBField.initRepeatMessage(troopactivity.Activity.class);
    public final PBUInt32Field being_act_num = PBField.initUInt32(0);
    public final PBStringField group_act_url = PBField.initString("");
    public final PBUInt32Field history_act_num = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.troop.activity.troopactivity
 * JD-Core Version:    0.7.0.1
 */