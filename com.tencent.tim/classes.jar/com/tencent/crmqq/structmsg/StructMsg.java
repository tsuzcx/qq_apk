package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StructMsg
{
  public static final class ButtonInfo
    extends MessageMicro<ButtonInfo>
  {
    public static final int AUTH_NONE = 0;
    public static final int AUTH_SID = 1;
    public static final int AUTH_VKEY = 2;
    public static final int CLICK = 1;
    public static final int EVENT = 3;
    public static final int URL = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 64, 74, 80, 88 }, new String[] { "id", "name", "key", "url", "auth_type", "type", "sub_button", "event_id", "event_param", "is_need_lbs", "item_id" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(1), null, Integer.valueOf(1), null, Boolean.valueOf(false), Integer.valueOf(0) }, ButtonInfo.class);
    public final PBEnumField auth_type = PBField.initEnum(0);
    public final PBEnumField event_id = PBField.initEnum(1);
    public final PBRepeatMessageField<StructMsg.ButtonInfo_EventInfoParam> event_param = PBField.initRepeatMessage(StructMsg.ButtonInfo_EventInfoParam.class);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBBoolField is_need_lbs = PBField.initBool(false);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
    public final PBStringField key = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<ButtonInfo> sub_button = PBField.initRepeatMessage(ButtonInfo.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class ButtonInfo_EventInfoParam
    extends MessageMicro<ButtonInfo_EventInfoParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, ButtonInfo_EventInfoParam.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
  }
  
  public static final class GetCRMMenuResponse
    extends MessageMicro<GetCRMMenuResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "ret_info", "seqno", "uin", "button_info", "update_type" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0) }, GetCRMMenuResponse.class);
    public final PBRepeatMessageField<StructMsg.ButtonInfo> button_info = PBField.initRepeatMessage(StructMsg.ButtonInfo.class);
    public StructMsg.RetInfo ret_info = new StructMsg.RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBUInt32Field update_type = PBField.initUInt32(0);
  }
  
  public static final class GetCrmQQMenuRequest
    extends MessageMicro<GetCrmQQMenuRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "seqno", "uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GetCrmQQMenuRequest.class);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "err_info" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBStringField err_info = PBField.initString("");
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
  }
  
  public static final class SendMenuEventRequest
    extends MessageMicro<SendMenuEventRequest>
  {
    public static final int CLICK = 1;
    public static final int EVENT = 3;
    public static final int URL = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 41, 49 }, new String[] { "uin", "key", "type", "is_need_lbs", "latitude", "longitude" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(1), Boolean.valueOf(false), Double.valueOf(0.0D), Double.valueOf(0.0D) }, SendMenuEventRequest.class);
    public final PBBoolField is_need_lbs = PBField.initBool(false);
    public final PBStringField key = PBField.initString("");
    public final PBDoubleField latitude = PBField.initDouble(0.0D);
    public final PBDoubleField longitude = PBField.initDouble(0.0D);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class SendMenuEventResponse
    extends MessageMicro<SendMenuEventResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "ret_info", "seqno" }, new Object[] { null, Integer.valueOf(0) }, SendMenuEventResponse.class);
    public StructMsg.RetInfo ret_info = new StructMsg.RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.crmqq.structmsg.StructMsg
 * JD-Core Version:    0.7.0.1
 */