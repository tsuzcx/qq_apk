package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearfield_friend
{
  public static final class GPS
    extends MessageMicro<GPS>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "lat", "lng", "type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GPS.class);
    public final PBInt32Field lat = PBField.initInt32(0);
    public final PBInt32Field lng = PBField.initInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class ReqEnter
    extends MessageMicro<ReqEnter>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public nearfield_friend.GPS gps_info = new nearfield_friend.GPS();
    public final PBStringField number = PBField.initString("");
    public final PBStringField session_id = PBField.initString("");
    public final PBBytesField verify_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "session_id", "gps_info", "number", "verify_sig" }, new Object[] { "", null, "", localByteStringMicro }, ReqEnter.class);
    }
  }
  
  public static final class ReqExit
    extends MessageMicro<ReqExit>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "session_id" }, new Object[] { "" }, ReqExit.class);
    public final PBStringField session_id = PBField.initString("");
  }
  
  public static final class ReqHeartBeat
    extends MessageMicro<ReqHeartBeat>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "session_id", "uin_list" }, new Object[] { "", Long.valueOf(0L) }, ReqHeartBeat.class);
    public final PBStringField session_id = PBField.initString("");
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class ResultInfo
    extends MessageMicro<ResultInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field errcode = PBField.initUInt32(0);
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "errcode", "errmsg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ResultInfo.class);
    }
  }
  
  public static final class RspEnter
    extends MessageMicro<RspEnter>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBUInt32Field heartbeat_time = PBField.initUInt32(0);
    public nearfield_friend.ResultInfo result = new nearfield_friend.ResultInfo();
    public final PBUInt32Field security_level = PBField.initUInt32(0);
    public final PBBytesField verify_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "result", "security_level", "verify_url", "heartbeat_time", "expire_time" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RspEnter.class);
    }
  }
  
  public static final class RspExit
    extends MessageMicro<RspExit>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspExit.class);
    public nearfield_friend.ResultInfo result = new nearfield_friend.ResultInfo();
  }
  
  public static final class RspHeartBeat
    extends MessageMicro<RspHeartBeat>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "result", "uin_list" }, new Object[] { null, Long.valueOf(0L) }, RspHeartBeat.class);
    public nearfield_friend.ResultInfo result = new nearfield_friend.ResultInfo();
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.nearfield_friend.nearfield_friend
 * JD-Core Version:    0.7.0.1
 */