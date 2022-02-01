package tencent.im.oidb.cmd0xafc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyConfig;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public final class cmd0xafc
{
  public static final class HeartBeat
    extends MessageMicro<HeartBeat>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], HeartBeat.class);
  }
  
  public static final class HeartBeatData
    extends MessageMicro<HeartBeatData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_timestamp", "uint32_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, HeartBeatData.class);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class Location
    extends MessageMicro<Location>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_lat", "int32_lon", "int32_coo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Location.class);
    public final PBInt32Field int32_coo = PBField.initInt32(0);
    public final PBInt32Field int32_lat = PBField.initInt32(0);
    public final PBInt32Field int32_lon = PBField.initInt32(0);
  }
  
  public static final class NearbyEnter
    extends MessageMicro<NearbyEnter>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_location" }, new Object[] { null }, NearbyEnter.class);
    public cmd0xafc.Location msg_location = new cmd0xafc.Location();
  }
  
  public static final class NearbyExit
    extends MessageMicro<NearbyExit>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], NearbyExit.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_nearby_enter", "msg_nearby_exit", "msg_heart_beat" }, new Object[] { null, null, null }, ReqBody.class);
    public cmd0xafc.HeartBeat msg_heart_beat = new cmd0xafc.HeartBeat();
    public cmd0xafc.NearbyEnter msg_nearby_enter = new cmd0xafc.NearbyEnter();
    public cmd0xafc.NearbyExit msg_nearby_exit = new cmd0xafc.NearbyExit();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_heart_beat_interval", "msg_self_info", "msg_config" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
    public oidb_0x8dd.NearbyConfig msg_config = new oidb_0x8dd.NearbyConfig();
    public oidb_0x8dd.SelfInfo msg_self_info = new oidb_0x8dd.SelfInfo();
    public final PBUInt32Field uint32_heart_beat_interval = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xafc.cmd0xafc
 * JD-Core Version:    0.7.0.1
 */