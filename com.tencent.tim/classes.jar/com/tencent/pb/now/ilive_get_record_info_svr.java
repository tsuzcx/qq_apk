package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_get_record_info_svr
{
  public static final class GetRecordInfoReq
    extends MessageMicro<GetRecordInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "vid", "platform", "filetype", "is_ipv6" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetRecordInfoReq.class);
    public final PBUInt32Field filetype = PBField.initUInt32(0);
    public final PBUInt32Field is_ipv6 = PBField.initUInt32(0);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField vid = PBField.initString("");
  }
  
  public static final class GetRecordInfoRsp
    extends MessageMicro<GetRecordInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "record_info" }, new Object[] { Integer.valueOf(0), null }, GetRecordInfoRsp.class);
    public ilive_get_record_info_svr.RecordInfo record_info = new ilive_get_record_info_svr.RecordInfo();
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class GetRoomStateReq
    extends MessageMicro<GetRoomStateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "roomid", "source" }, new Object[] { Integer.valueOf(0), "" }, GetRoomStateReq.class);
    public final PBUInt32Field roomid = PBField.initUInt32(0);
    public final PBStringField source = PBField.initString("");
  }
  
  public static final class GetRoomStateRsp
    extends MessageMicro<GetRoomStateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50 }, new String[] { "result", "is_on_live", "vid", "recorded_share_url", "another_live_room_id", "another_live_mqq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L), "" }, GetRoomStateRsp.class);
    public final PBStringField another_live_mqq = PBField.initString("");
    public final PBUInt64Field another_live_room_id = PBField.initUInt64(0L);
    public final PBUInt32Field is_on_live = PBField.initUInt32(0);
    public final PBStringField recorded_share_url = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField vid = PBField.initString("");
  }
  
  public static final class RecordInfo
    extends MessageMicro<RecordInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "record_video_url", "cmd5", "record_duration", "file_format", "vid_state" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RecordInfo.class);
    public final PBStringField cmd5 = PBField.initString("");
    public final PBUInt32Field file_format = PBField.initUInt32(0);
    public final PBUInt32Field record_duration = PBField.initUInt32(0);
    public final PBStringField record_video_url = PBField.initString("");
    public final PBUInt32Field vid_state = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_get_record_info_svr
 * JD-Core Version:    0.7.0.1
 */