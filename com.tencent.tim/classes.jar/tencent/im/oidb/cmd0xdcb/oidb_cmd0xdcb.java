package tencent.im.oidb.cmd0xdcb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xdcb
{
  public static final class ExtraInfo
    extends MessageMicro<ExtraInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_report_json" }, new Object[] { "" }, ExtraInfo.class);
    public final PBStringField str_report_json = PBField.initString("");
  }
  
  public static final class IconInfo
    extends MessageMicro<IconInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "feeds_msg_icon_url", "feeds_default_icon_url", "uint32_is_use_gif", "str_jump_schema" }, new Object[] { "", "", Integer.valueOf(0), "" }, IconInfo.class);
    public final PBStringField feeds_default_icon_url = PBField.initString("");
    public final PBStringField feeds_msg_icon_url = PBField.initString("");
    public final PBStringField str_jump_schema = PBField.initString("");
    public final PBUInt32Field uint32_is_use_gif = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_req_param" }, new Object[] { null }, ReqBody.class);
    public oidb_cmd0xdcb.ReqParam msg_req_param = new oidb_cmd0xdcb.ReqParam();
  }
  
  public static final class ReqParam
    extends MessageMicro<ReqParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_req_type" }, new Object[] { Integer.valueOf(0) }, ReqParam.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_icon_info", "msg_extra_info" }, new Object[] { null, null }, RspBody.class);
    public oidb_cmd0xdcb.ExtraInfo msg_extra_info = new oidb_cmd0xdcb.ExtraInfo();
    public oidb_cmd0xdcb.IconInfo msg_icon_info = new oidb_cmd0xdcb.IconInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb
 * JD-Core Version:    0.7.0.1
 */