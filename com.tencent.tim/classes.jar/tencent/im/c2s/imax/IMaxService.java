package tencent.im.c2s.imax;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class IMaxService
{
  public static final class ExposureMsg
    extends MessageMicro<ExposureMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_ad_id", "uint32_action_type", "uint64_uin" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L) }, ExposureMsg.class);
    public final PBStringField str_ad_id = PBField.initString("");
    public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class IgnoreADMsg
    extends MessageMicro<IgnoreADMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "str_ad_id" }, new Object[] { Long.valueOf(0L), "" }, IgnoreADMsg.class);
    public final PBStringField str_ad_id = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_type", "msg_exposure", "msg_ignoreAD" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
    public final PBInt32Field int32_type = PBField.initInt32(0);
    public IMaxService.ExposureMsg msg_exposure = new IMaxService.ExposureMsg();
    public IMaxService.IgnoreADMsg msg_ignoreAD = new IMaxService.IgnoreADMsg();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "int32_ret", "str_msg", "int32_type", "int32_exposure_flag" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBInt32Field int32_exposure_flag = PBField.initInt32(0);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBInt32Field int32_type = PBField.initInt32(0);
    public final PBStringField str_msg = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.c2s.imax.IMaxService
 * JD-Core Version:    0.7.0.1
 */