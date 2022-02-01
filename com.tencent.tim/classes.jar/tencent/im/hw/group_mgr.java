package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_mgr
{
  public static final class CardCommInfo
    extends MessageMicro<CardCommInfo>
  {
    public static final int CARD_NAME_FIELD_NUMBER = 3;
    public static final int LEVEL_FIELD_NUMBER = 4;
    public static final int NICK_NAME_FIELD_NUMBER = 2;
    public static final int POINT_FIELD_NUMBER = 5;
    public static final int UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uin", "nick_name", "card_name", "level", "point" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0) }, CardCommInfo.class);
    public final PBStringField card_name = PBField.initString("");
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBStringField nick_name = PBField.initString("");
    public final PBUInt32Field point = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class CardHomeworkInfo
    extends MessageMicro<CardHomeworkInfo>
  {
    public static final int IDENTITY_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "identity" }, new Object[] { Integer.valueOf(0) }, CardHomeworkInfo.class);
    public final PBUInt32Field identity = PBField.initUInt32(0);
  }
  
  public static final class CardInfo
    extends MessageMicro<CardInfo>
  {
    public static final int COMMON_FIELD_NUMBER = 1;
    public static final int HWINFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "common", "hwinfo" }, new Object[] { null, null }, CardInfo.class);
    public group_mgr.CardCommInfo common = new group_mgr.CardCommInfo();
    public group_mgr.CardHomeworkInfo hwinfo = new group_mgr.CardHomeworkInfo();
  }
  
  public static final class GroupCommInfo
    extends MessageMicro<GroupCommInfo>
  {
    public static final int GROUP_CLASS_FIELD_NUMBER = 4;
    public static final int GROUP_NAME_FIELD_NUMBER = 2;
    public static final int GROUP_OPTION_FIELD_NUMBER = 1;
    public static final int GROUP_SIZE_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "group_option", "group_name", "group_size", "group_class" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, GroupCommInfo.class);
    public final PBUInt32Field group_class = PBField.initUInt32(0);
    public final PBStringField group_name = PBField.initString("");
    public final PBUInt32Field group_option = PBField.initUInt32(0);
    public final PBUInt32Field group_size = PBField.initUInt32(0);
  }
  
  public static final class GroupHomeworkInfo
    extends MessageMicro<GroupHomeworkInfo>
  {
    public static final int CITY_CODE_FIELD_NUMBER = 1;
    public static final int CL_CLASS_FIELD_NUMBER = 6;
    public static final int CL_ENROL_YEAR_FIELD_NUMBER = 4;
    public static final int CL_GRADE_FIELD_NUMBER = 5;
    public static final int SC_NAME_FIELD_NUMBER = 3;
    public static final int SC_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "city_code", "sc_type", "sc_name", "cl_enrol_year", "cl_grade", "cl_class" }, new Object[] { "", "", "", "", "", "" }, GroupHomeworkInfo.class);
    public final PBStringField city_code = PBField.initString("");
    public final PBStringField cl_class = PBField.initString("");
    public final PBStringField cl_enrol_year = PBField.initString("");
    public final PBStringField cl_grade = PBField.initString("");
    public final PBStringField sc_name = PBField.initString("");
    public final PBStringField sc_type = PBField.initString("");
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    public static final int COMMON_FIELD_NUMBER = 1;
    public static final int HWINFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "common", "hwinfo" }, new Object[] { null, null }, GroupInfo.class);
    public group_mgr.GroupCommInfo common = new group_mgr.GroupCommInfo();
    public group_mgr.GroupHomeworkInfo hwinfo = new group_mgr.GroupHomeworkInfo();
  }
  
  public static final class HwCreateGroupReq
    extends MessageMicro<HwCreateGroupReq>
  {
    public static final int GID_FIELD_NUMBER = 1;
    public static final int INFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "gid", "info" }, new Object[] { Long.valueOf(0L), null }, HwCreateGroupReq.class);
    public final PBUInt64Field gid = PBField.initUInt64(0L);
    public group_mgr.GroupInfo info = new group_mgr.GroupInfo();
  }
  
  public static final class HwCreateGroupRsp
    extends MessageMicro<HwCreateGroupRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], HwCreateGroupRsp.class);
  }
  
  public static final class HwListCardReq
    extends MessageMicro<HwListCardReq>
  {
    public static final int GID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "gid" }, new Object[] { Long.valueOf(0L) }, HwListCardReq.class);
    public final PBUInt64Field gid = PBField.initUInt64(0L);
  }
  
  public static final class HwListCardRsp
    extends MessageMicro<HwListCardRsp>
  {
    public static final int CARD_INFO_FIELD_NUMBER = 1;
    public static final int LEVEL_INFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "card_info", "level_info" }, new Object[] { null, null }, HwListCardRsp.class);
    public final PBRepeatMessageField<group_mgr.CardInfo> card_info = PBField.initRepeatMessage(group_mgr.CardInfo.class);
    public group_mgr.LevelInfo level_info = new group_mgr.LevelInfo();
  }
  
  public static final class HwModifyCardReq
    extends MessageMicro<HwModifyCardReq>
  {
    public static final int CARD_INFO_FIELD_NUMBER = 3;
    public static final int GID_FIELD_NUMBER = 1;
    public static final int TARGET_UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "gid", "target_uin", "card_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null }, HwModifyCardReq.class);
    public group_mgr.CardInfo card_info = new group_mgr.CardInfo();
    public final PBUInt64Field gid = PBField.initUInt64(0L);
    public final PBUInt64Field target_uin = PBField.initUInt64(0L);
  }
  
  public static final class HwModifyCardRsp
    extends MessageMicro<HwModifyCardRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], HwModifyCardRsp.class);
  }
  
  public static final class HwModifyGroupReq
    extends MessageMicro<HwModifyGroupReq>
  {
    public static final int GID_FIELD_NUMBER = 1;
    public static final int INFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "gid", "info" }, new Object[] { Long.valueOf(0L), null }, HwModifyGroupReq.class);
    public final PBUInt64Field gid = PBField.initUInt64(0L);
    public group_mgr.GroupInfo info = new group_mgr.GroupInfo();
  }
  
  public static final class HwModifyGroupRsp
    extends MessageMicro<HwModifyGroupRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], HwModifyGroupRsp.class);
  }
  
  public static final class HwQueryCardReq
    extends MessageMicro<HwQueryCardReq>
  {
    public static final int GID_FIELD_NUMBER = 1;
    public static final int TARGET_UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "gid", "target_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, HwQueryCardReq.class);
    public final PBUInt64Field gid = PBField.initUInt64(0L);
    public final PBUInt64Field target_uin = PBField.initUInt64(0L);
  }
  
  public static final class HwQueryCardRsp
    extends MessageMicro<HwQueryCardRsp>
  {
    public static final int CARD_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "card_info" }, new Object[] { null }, HwQueryCardRsp.class);
    public group_mgr.CardInfo card_info = new group_mgr.CardInfo();
  }
  
  public static final class HwRedoRsp
    extends MessageMicro<HwRedoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], HwRedoRsp.class);
  }
  
  public static final class LevelInfo
    extends MessageMicro<LevelInfo>
  {
    public static final int LEVELS_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "levels" }, new Object[] { null }, LevelInfo.class);
    public final PBRepeatMessageField<LevelName> levels = PBField.initRepeatMessage(LevelName.class);
    
    public static final class LevelName
      extends MessageMicro<LevelName>
    {
      public static final int LEVEL_FIELD_NUMBER = 1;
      public static final int NAME_FIELD_NUMBER = 2;
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "level", "name" }, new Object[] { Integer.valueOf(0), "" }, LevelName.class);
      public final PBUInt32Field level = PBField.initUInt32(0);
      public final PBStringField name = PBField.initString("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.hw.group_mgr
 * JD-Core Version:    0.7.0.1
 */