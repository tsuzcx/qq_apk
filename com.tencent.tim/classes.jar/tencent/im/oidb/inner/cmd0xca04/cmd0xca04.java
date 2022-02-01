package tencent.im.oidb.inner.cmd0xca04;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xca04
{
  public static final class AppInfo
    extends MessageMicro<AppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "plat_type", "str_app_version" }, new Object[] { Integer.valueOf(1), "" }, AppInfo.class);
    public final PBEnumField plat_type = PBField.initEnum(1);
    public final PBStringField str_app_version = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint32_timestamp", "rpt_uint32_appids", "msg_app_info", "rpt_uint32_add_appids", "rpt_uint32_del_appids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public cmd0xca04.AppInfo msg_app_info = new cmd0xca04.AppInfo();
    public final PBRepeatField<Integer> rpt_uint32_add_appids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_appids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_del_appids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_res", "uint32_timestamp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBUInt32Field uint32_res = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.inner.cmd0xca04.cmd0xca04
 * JD-Core Version:    0.7.0.1
 */