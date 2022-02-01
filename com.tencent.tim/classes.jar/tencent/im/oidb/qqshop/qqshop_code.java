package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqshop_code
{
  public static final class SReq
    extends MessageMicro<SReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "version", "appid", "redirect_uri" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, SReq.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField redirect_uri = PBField.initString("");
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class SRsp
    extends MessageMicro<SRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ret_code", "expired_time", "auth_code" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, SRsp.class);
    public final PBStringField auth_code = PBField.initString("");
    public final PBUInt32Field expired_time = PBField.initUInt32(0);
    public final PBInt32Field ret_code = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_code
 * JD-Core Version:    0.7.0.1
 */