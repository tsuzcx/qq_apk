package tencent.nearby;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby_ice_break
{
  public static final class IceReq
    extends MessageMicro<IceReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin", "tinyid" }, new Object[] { Long.valueOf(0L), "" }, IceReq.class);
    public final PBStringField tinyid = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class IceRsp
    extends MessageMicro<IceRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "err_msg" }, new Object[] { Integer.valueOf(0), "" }, IceRsp.class);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.nearby.nearby_ice_break
 * JD-Core Version:    0.7.0.1
 */