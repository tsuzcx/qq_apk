package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xccd
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int64_uin", "uint32_appids", "platform" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt64Field int64_uin = PBField.initUInt64(0L);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBRepeatField<Integer> uint32_appids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class Result
    extends MessageMicro<Result>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_appid", "errcode", "errmsg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, Result.class);
    public final PBInt32Field errcode = PBField.initInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "errcode", "Results" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xccd.Result> Results = PBField.initRepeatMessage(oidb_0xccd.Result.class);
    public final PBInt32Field errcode = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xccd
 * JD-Core Version:    0.7.0.1
 */