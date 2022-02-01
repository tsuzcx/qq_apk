package com.tencent.troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_activity_info
{
  public static final class GroupActInfo
    extends MessageMicro<GroupActInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64 }, new String[] { "act_id", "title", "summary", "url", "small_pic", "big_pic", "start_time", "end_time" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, GroupActInfo.class);
    public final PBUInt64Field act_id = PBField.initUInt64(0L);
    public final PBStringField big_pic = PBField.initString("");
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBStringField small_pic = PBField.initString("");
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBStringField summary = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "type", "group_code", "act_id", "title", "summary", "url", "small_pic", "big_pic", "start_time", "end_time" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) }, ReqBody.class);
    public final PBBoolField act_id = PBField.initBool(false);
    public final PBBoolField big_pic = PBField.initBool(false);
    public final PBBoolField end_time = PBField.initBool(false);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBBoolField small_pic = PBField.initBool(false);
    public final PBBoolField start_time = PBField.initBool(false);
    public final PBBoolField summary = PBField.initBool(false);
    public final PBBoolField title = PBField.initBool(false);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBBoolField url = PBField.initBool(false);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "error_code", "group_code", "info_list" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null }, RspBody.class);
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBRepeatMessageField<group_activity_info.GroupActInfo> info_list = PBField.initRepeatMessage(group_activity_info.GroupActInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.troop.group_activity_info
 * JD-Core Version:    0.7.0.1
 */