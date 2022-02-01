package tencent.im.statsvc.getonline;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StatSvcStatSimpleget
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "rept_bind_qq", "int32_battrey_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
    public final PBInt32Field int32_battrey_status = PBField.initInt32(0);
    public final PBRepeatField<Long> rept_bind_qq = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_error_code", "str_errmsg", "uint32_hello_interval", "str_clientip" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "" }, RspBody.class);
    public final PBStringField str_clientip = PBField.initString("");
    public final PBStringField str_errmsg = PBField.initString("");
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hello_interval = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.statsvc.getonline.StatSvcStatSimpleget
 * JD-Core Version:    0.7.0.1
 */