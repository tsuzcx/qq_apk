package tencent.im.oidb.cmd0xb69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb69
{
  public static final class AppInfo
    extends MessageMicro<AppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "appid", "app_name", "switch_on", "order", "app_permission" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), null }, AppInfo.class);
    public final PBStringField app_name = PBField.initString("");
    public final PBRepeatMessageField<oidb_0xb69.AppPermission> app_permission = PBField.initRepeatMessage(oidb_0xb69.AppPermission.class);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public final PBUInt32Field order = PBField.initUInt32(0);
    public final PBUInt32Field switch_on = PBField.initUInt32(0);
  }
  
  public static final class AppPermission
    extends MessageMicro<AppPermission>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "permission_name", "permission_cn", "permission_desc", "switch_on" }, new Object[] { "", "", "", Integer.valueOf(0) }, AppPermission.class);
    public final PBStringField permission_cn = PBField.initString("");
    public final PBStringField permission_desc = PBField.initString("");
    public final PBStringField permission_name = PBField.initString("");
    public final PBUInt32Field switch_on = PBField.initUInt32(0);
  }
  
  public static final class ClientInfo
    extends MessageMicro<ClientInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "platform", "version" }, new Object[] { Integer.valueOf(0), "" }, ClientInfo.class);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "group_id", "client_info", "app_info" }, new Object[] { Long.valueOf(0L), null, null }, ReqBody.class);
    public final PBRepeatMessageField<oidb_0xb69.AppInfo> app_info = PBField.initRepeatMessage(oidb_0xb69.AppInfo.class);
    public oidb_0xb69.ClientInfo client_info = new oidb_0xb69.ClientInfo();
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "app_info" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xb69.AppInfo> app_info = PBField.initRepeatMessage(oidb_0xb69.AppInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb69.oidb_0xb69
 * JD-Core Version:    0.7.0.1
 */