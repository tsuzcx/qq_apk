package tencent.im.oidb.cmd0xd23;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xd23
{
  public static final class AppInfo
    extends MessageMicro<AppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "appid", "organization_id", "group_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, AppInfo.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public Oidb_0xd23.GroupInfo group_info = new Oidb_0xd23.GroupInfo();
    public final PBUInt32Field organization_id = PBField.initUInt32(0);
  }
  
  public static final class CacheData
    extends MessageMicro<CacheData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_app_info" }, new Object[] { null }, CacheData.class);
    public final PBRepeatMessageField<Oidb_0xd23.AppInfo> rpt_app_info = PBField.initRepeatMessage(Oidb_0xd23.AppInfo.class);
  }
  
  public static final class CacheKey
    extends MessageMicro<CacheKey>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "cache_prefix", "appid" }, new Object[] { "sdk_group_bind_data", Integer.valueOf(0) }, CacheKey.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField cache_prefix = PBField.initString("sdk_group_bind_data");
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "group_code", "group_name" }, new Object[] { Long.valueOf(0L), "" }, GroupInfo.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBStringField group_name = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "app_info" }, new Object[] { null }, ReqBody.class);
    public Oidb_0xd23.AppInfo app_info = new Oidb_0xd23.AppInfo();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bind_flag", "group_code" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
    public final PBUInt32Field bind_flag = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd23.Oidb_0xd23
 * JD-Core Version:    0.7.0.1
 */