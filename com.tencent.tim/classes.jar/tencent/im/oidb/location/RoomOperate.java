package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RoomOperate
{
  public static final class ReqAssemblyPointOperation
    extends MessageMicro<ReqAssemblyPointOperation>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBDoubleField lat = PBField.initDouble(0.0D);
    public final PBDoubleField lon = PBField.initDouble(0.0D);
    public final PBBytesField poi_address = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField poi_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField point_operation = PBField.initEnum(1);
    public qq_lbs_share.RoomKey room_key = new qq_lbs_share.RoomKey();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 25, 33, 42, 50 }, new String[] { "room_key", "point_operation", "lon", "lat", "poi_name", "poi_address" }, new Object[] { null, Integer.valueOf(1), Double.valueOf(0.0D), Double.valueOf(0.0D), localByteStringMicro1, localByteStringMicro2 }, ReqAssemblyPointOperation.class);
    }
  }
  
  public static final class ReqReportLocation
    extends MessageMicro<ReqReportLocation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 17, 25, 33 }, new String[] { "room_key", "lon", "lat", "direction" }, new Object[] { null, Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D) }, ReqReportLocation.class);
    public final PBDoubleField direction = PBField.initDouble(0.0D);
    public final PBDoubleField lat = PBField.initDouble(0.0D);
    public final PBDoubleField lon = PBField.initDouble(0.0D);
    public qq_lbs_share.RoomKey room_key = new qq_lbs_share.RoomKey();
  }
  
  public static final class ReqRoomOperation
    extends MessageMicro<ReqRoomOperation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 33, 41 }, new String[] { "room_key", "room_operation", "client_type", "lon", "lat" }, new Object[] { null, Integer.valueOf(1), Integer.valueOf(1), Double.valueOf(0.0D), Double.valueOf(0.0D) }, ReqRoomOperation.class);
    public final PBEnumField client_type = PBField.initEnum(1);
    public final PBDoubleField lat = PBField.initDouble(0.0D);
    public final PBDoubleField lon = PBField.initDouble(0.0D);
    public qq_lbs_share.RoomKey room_key = new qq_lbs_share.RoomKey();
    public final PBEnumField room_operation = PBField.initEnum(1);
  }
  
  public static final class ReqRoomQuery
    extends MessageMicro<ReqRoomQuery>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "room_key", "no_limit", "client_type" }, new Object[] { null, Boolean.valueOf(false), Integer.valueOf(1) }, ReqRoomQuery.class);
    public final PBEnumField client_type = PBField.initEnum(1);
    public final PBBoolField no_limit = PBField.initBool(false);
    public qq_lbs_share.RoomKey room_key = new qq_lbs_share.RoomKey();
  }
  
  public static final class RspAssemblyPointOperation
    extends MessageMicro<RspAssemblyPointOperation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_result" }, new Object[] { null }, RspAssemblyPointOperation.class);
    public qq_lbs_share.ResultInfo msg_result = new qq_lbs_share.ResultInfo();
  }
  
  public static final class RspReportLocation
    extends MessageMicro<RspReportLocation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_result", "req_interval" }, new Object[] { null, Integer.valueOf(0) }, RspReportLocation.class);
    public qq_lbs_share.ResultInfo msg_result = new qq_lbs_share.ResultInfo();
    public final PBUInt32Field req_interval = PBField.initUInt32(0);
  }
  
  public static final class RspRoomOperation
    extends MessageMicro<RspRoomOperation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_result" }, new Object[] { null }, RspRoomOperation.class);
    public qq_lbs_share.ResultInfo msg_result = new qq_lbs_share.ResultInfo();
  }
  
  public static final class RspRoomQuery
    extends MessageMicro<RspRoomQuery>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56 }, new String[] { "msg_result", "user_list", "create_uin", "create_time", "room_state", "assembly_Point", "req_interval" }, new Object[] { null, null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), null, Integer.valueOf(0) }, RspRoomQuery.class);
    public qq_lbs_share.AssemblyPointData assembly_Point = new qq_lbs_share.AssemblyPointData();
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBUInt64Field create_uin = PBField.initUInt64(0L);
    public qq_lbs_share.ResultInfo msg_result = new qq_lbs_share.ResultInfo();
    public final PBUInt32Field req_interval = PBField.initUInt32(0);
    public final PBEnumField room_state = PBField.initEnum(1);
    public final PBRepeatMessageField<RoomOperate.UserData> user_list = PBField.initRepeatMessage(RoomOperate.UserData.class);
  }
  
  public static final class UserData
    extends MessageMicro<UserData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 25, 33, 41, 48 }, new String[] { "uin", "join_time", "lon", "lat", "direction", "lbs_update_ts" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D), Long.valueOf(0L) }, UserData.class);
    public final PBDoubleField direction = PBField.initDouble(0.0D);
    public final PBUInt64Field join_time = PBField.initUInt64(0L);
    public final PBDoubleField lat = PBField.initDouble(0.0D);
    public final PBUInt64Field lbs_update_ts = PBField.initUInt64(0L);
    public final PBDoubleField lon = PBField.initDouble(0.0D);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.location.RoomOperate
 * JD-Core Version:    0.7.0.1
 */