package tencent.im.oidb.cmd0xea4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xea4
{
  public static final class AppInfo
    extends MessageMicro<AppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 66, 72, 80, 90 }, new String[] { "appid", "name", "url", "icon", "push_red_point", "status", "icon_simple_day", "icon_simple_night", "type", "source", "trace" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "" }, AppInfo.class);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField icon_simple_day = PBField.initString("");
    public final PBStringField icon_simple_night = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field push_red_point = PBField.initInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField trace = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class ClientInfo
    extends MessageMicro<ClientInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "platform", "version" }, new Object[] { Integer.valueOf(0), "" }, ClientInfo.class);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class ExtraInfo
    extends MessageMicro<ExtraInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tab_infos" }, new Object[] { null }, ExtraInfo.class);
    public final PBRepeatMessageField<oidb_0xea4.TabInfo> tab_infos = PBField.initRepeatMessage(oidb_0xea4.TabInfo.class);
  }
  
  public static final class ManageInfo
    extends MessageMicro<ManageInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "label", "url" }, new Object[] { "", "" }, ManageInfo.class);
    public final PBStringField label = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64 }, new String[] { "group_id", "client_info", "last_game_dynamic_ts", "page", "num", "mini_appids", "mini_app_disable", "mode" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public oidb_0xea4.ClientInfo client_info = new oidb_0xea4.ClientInfo();
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field last_game_dynamic_ts = PBField.initUInt32(0);
    public final PBUInt32Field mini_app_disable = PBField.initUInt32(0);
    public final PBRepeatField<Long> mini_appids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field mode = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field page = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "group_id", "infos", "extra_info", "add_limit", "manage_info" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0), null }, RspBody.class);
    public final PBUInt32Field add_limit = PBField.initUInt32(0);
    public oidb_0xea4.ExtraInfo extra_info = new oidb_0xea4.ExtraInfo();
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBRepeatMessageField<oidb_0xea4.AppInfo> infos = PBField.initRepeatMessage(oidb_0xea4.AppInfo.class);
    public oidb_0xea4.ManageInfo manage_info = new oidb_0xea4.ManageInfo();
  }
  
  public static final class TabInfo
    extends MessageMicro<TabInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 64 }, new String[] { "type", "name", "desc", "url", "num", "appid", "pic", "red_point" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0) }, TabInfo.class);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBStringField pic = PBField.initString("");
    public final PBInt32Field red_point = PBField.initInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xea4.oidb_0xea4
 * JD-Core Version:    0.7.0.1
 */