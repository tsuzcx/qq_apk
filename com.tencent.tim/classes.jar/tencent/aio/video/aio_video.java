package tencent.aio.video;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_video
{
  public static final class ErrInfo
    extends MessageMicro<ErrInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "err_code", "err_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ErrInfo.class);
    }
  }
  
  public static final class ReqGetOpenIdByUin
    extends MessageMicro<ReqGetOpenIdByUin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "app_id", "target_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, ReqGetOpenIdByUin.class);
    public final PBUInt32Field app_id = PBField.initUInt32(0);
    public final PBUInt64Field target_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqGetUinByOpenId
    extends MessageMicro<ReqGetUinByOpenId>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field app_id = PBField.initUInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBBytesField open_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField open_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "app_id", "open_id", "open_key", "group_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L) }, ReqGetUinByOpenId.class);
    }
  }
  
  public static final class RspGetOpenIdByUin
    extends MessageMicro<RspGetOpenIdByUin>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public aio_video.ErrInfo err_info = new aio_video.ErrInfo();
    public final PBBytesField open_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "err_info", "open_id" }, new Object[] { null, localByteStringMicro }, RspGetOpenIdByUin.class);
    }
  }
  
  public static final class RspGetUinByOpenId
    extends MessageMicro<RspGetUinByOpenId>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "err_info", "uin" }, new Object[] { null, Long.valueOf(0L) }, RspGetUinByOpenId.class);
    public aio_video.ErrInfo err_info = new aio_video.ErrInfo();
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.aio.video.aio_video
 * JD-Core Version:    0.7.0.1
 */