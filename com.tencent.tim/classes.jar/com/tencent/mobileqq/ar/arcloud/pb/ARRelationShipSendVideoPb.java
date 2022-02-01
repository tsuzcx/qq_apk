package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ARRelationShipSendVideoPb
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_share_info", "rpt_uint64_to_uin" }, new Object[] { null, Long.valueOf(0L) }, ReqBody.class);
    public ARRelationShipSendVideoPb.shareInfo msg_share_info = new ARRelationShipSendVideoPb.shareInfo();
    public final PBRepeatField<Long> rpt_uint64_to_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
  
  public static final class shareInfo
    extends MessageMicro<shareInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 72, 80, 162, 170, 178, 186 }, new String[] { "uint64_from_uin", "uint64_topic_id", "uint64_share_id", "enum_content_type", "uint64_create_time", "str_video_url", "str_cover_url", "str_desc", "uint32_duration", "uint32_size", "str_msg_url", "str_msg_picture_cover", "str_msg_title", "str_msg_summary" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), Long.valueOf(0L), "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "" }, shareInfo.class);
    public final PBEnumField enum_content_type = PBField.initEnum(1);
    public final PBStringField str_cover_url = PBField.initString("");
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_msg_picture_cover = PBField.initString("");
    public final PBStringField str_msg_summary = PBField.initString("");
    public final PBStringField str_msg_title = PBField.initString("");
    public final PBStringField str_msg_url = PBField.initString("");
    public final PBStringField str_video_url = PBField.initString("");
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_share_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipSendVideoPb
 * JD-Core Version:    0.7.0.1
 */