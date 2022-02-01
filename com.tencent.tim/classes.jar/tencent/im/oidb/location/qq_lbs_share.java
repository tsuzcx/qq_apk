package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_lbs_share
{
  public static final class AssemblyPointData
    extends MessageMicro<AssemblyPointData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBDoubleField lat = PBField.initDouble(0.0D);
    public final PBDoubleField lon = PBField.initDouble(0.0D);
    public final PBEnumField operation = PBField.initEnum(1);
    public final PBUInt64Field operator = PBField.initUInt64(0L);
    public final PBBytesField poi_address = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField poi_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field update_ts = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 25, 33, 40, 50, 58 }, new String[] { "operator", "operation", "lon", "lat", "update_ts", "poi_name", "poi_address" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), Double.valueOf(0.0D), Double.valueOf(0.0D), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, AssemblyPointData.class);
    }
  }
  
  public static final class C2CRelationInfo
    extends MessageMicro<C2CRelationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "id1", "id2" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, C2CRelationInfo.class);
    public final PBUInt64Field id1 = PBField.initUInt64(0L);
    public final PBUInt64Field id2 = PBField.initUInt64(0L);
  }
  
  public static final class PushExtInfo
    extends MessageMicro<PushExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "peer_uin", "client_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1) }, PushExtInfo.class);
    public final PBEnumField client_type = PBField.initEnum(1);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  }
  
  public static final class ResultInfo
    extends MessageMicro<ResultInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_svr_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_result", "bytes_errmsg", "uint64_svr_time" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, ResultInfo.class);
    }
  }
  
  public static final class RoomKey
    extends MessageMicro<RoomKey>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "aio_type", "id1", "id2" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L) }, RoomKey.class);
    public final PBEnumField aio_type = PBField.initEnum(1);
    public final PBUInt64Field id1 = PBField.initUInt64(0L);
    public final PBUInt64Field id2 = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.location.qq_lbs_share
 * JD-Core Version:    0.7.0.1
 */