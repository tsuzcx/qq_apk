package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qav_gvideo_sdk_transfer
{
  public static final class Error
    extends MessageMicro<Error>
  {
    public static final int Call = -101;
    public static final int ParseFromArray = -102;
    public static final int ReqInfo = -103;
    public static final int Sucess = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Error.class);
  }
  
  public static final class GAudioInfo
    extends MessageMicro<GAudioInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_relationId", "uint32_relationType", "uint32_multiBusiType", "uint64_roomId", "uint32_roomCreateTime" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, GAudioInfo.class);
    public final PBUInt32Field uint32_multiBusiType = PBField.initUInt32(0);
    public final PBUInt32Field uint32_relationType = PBField.initUInt32(0);
    public final PBUInt32Field uint32_roomCreateTime = PBField.initUInt32(0);
    public final PBUInt64Field uint64_relationId = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_roomId = PBField.initUInt64(0L);
  }
  
  public static final class ReqInfo
    extends MessageMicro<ReqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "req_event", "gAudioInfo" }, new Object[] { Integer.valueOf(1), null }, ReqInfo.class);
    public qav_gvideo_sdk_transfer.GAudioInfo gAudioInfo = new qav_gvideo_sdk_transfer.GAudioInfo();
    public final PBEnumField req_event = PBField.initEnum(1);
  }
  
  public static final class Req_Event
    extends MessageMicro<Req_Event>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Req_Event.class);
    public static final int destroyRoom = 1;
    public static final int getRoomCreateTime = 4;
    public static final int getRoomId = 3;
    public static final int kickoutPstnUsers = 2;
  }
  
  public static final class RespInfo
    extends MessageMicro<RespInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "gAudioInfo" }, new Object[] { Integer.valueOf(0), null }, RespInfo.class);
    public qav_gvideo_sdk_transfer.GAudioInfo gAudioInfo = new qav_gvideo_sdk_transfer.GAudioInfo();
    public final PBEnumField uint32_result = PBField.initEnum(0);
  }
  
  public static final class gVideoAcceptType
    extends MessageMicro<gVideoAcceptType>
  {
    public static final int BIG = 2;
    public static final int SMALL = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_account", "video_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1) }, gVideoAcceptType.class);
    public final PBUInt64Field uint64_account = PBField.initUInt64(0L);
    public final PBEnumField video_type = PBField.initEnum(1);
  }
  
  public static final class gVideoDownChannelControl
    extends MessageMicro<gVideoDownChannelControl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_switch", "uint32_videoacceptTypeSize", "msg_video_accept_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, gVideoDownChannelControl.class);
    public final PBRepeatMessageField<qav_gvideo_sdk_transfer.gVideoAcceptType> msg_video_accept_type = PBField.initRepeatMessage(qav_gvideo_sdk_transfer.gVideoAcceptType.class);
    public final PBUInt32Field uint32_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_videoacceptTypeSize = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.qav_gvideo_sdk_transfer
 * JD-Core Version:    0.7.0.1
 */