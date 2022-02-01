package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GroupAppPb
{
  public static final class AppInfo
    extends MessageMicro<AppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58 }, new String[] { "appid", "icon", "name", "url", "is_gray", "icon_simple_day", "icon_simple_night" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", "" }, AppInfo.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField icon_simple_day = PBField.initString("");
    public final PBStringField icon_simple_night = PBField.initString("");
    public final PBUInt32Field is_gray = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class AppList
    extends MessageMicro<AppList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "hash", "infos" }, new Object[] { "", null }, AppList.class);
    public final PBStringField hash = PBField.initString("");
    public final PBRepeatMessageField<GroupAppPb.AppInfo> infos = PBField.initRepeatMessage(GroupAppPb.AppInfo.class);
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48, 56 }, new String[] { "client", "group_id", "group_type", "full_list_hash", "group_gray_list_hash", "mini_app_disable", "mode" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public GroupAppPb.ClientInfo client = new GroupAppPb.ClientInfo();
    public final PBStringField full_list_hash = PBField.initString("");
    public final PBStringField group_gray_list_hash = PBField.initString("");
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    public final PBUInt32Field mini_app_disable = PBField.initUInt32(0);
    public final PBUInt32Field mode = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "full_list", "group_gray_list", "red_point_list", "cache_interval" }, new Object[] { null, null, null, Integer.valueOf(0) }, RspBody.class);
    public final PBUInt32Field cache_interval = PBField.initUInt32(0);
    public GroupAppPb.AppList full_list = new GroupAppPb.AppList();
    public GroupAppPb.AppList group_gray_list = new GroupAppPb.AppList();
    public GroupAppPb.AppList red_point_list = new GroupAppPb.AppList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.GroupAppPb
 * JD-Core Version:    0.7.0.1
 */