package tencent.im.oidb.cmd0xe0a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe0a
{
  public static final class App
    extends MessageMicro<App>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "appid", "name", "icon", "url", "disabled", "default_disabled" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, App.class);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public final PBUInt32Field default_disabled = PBField.initUInt32(0);
    public final PBUInt32Field disabled = PBField.initUInt32(0);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "client", "group_id", "group_type", "mode" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public cmd0xe0a.ClientInfo client = new cmd0xe0a.ClientInfo();
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    public final PBUInt32Field mode = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "cache_ts", "disabled", "app", "group_disabled", "redpoint_cache_ts" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatMessageField<cmd0xe0a.App> app = PBField.initRepeatMessage(cmd0xe0a.App.class);
    public final PBUInt32Field cache_ts = PBField.initUInt32(0);
    public final PBUInt32Field disabled = PBField.initUInt32(0);
    public final PBUInt32Field group_disabled = PBField.initUInt32(0);
    public final PBUInt32Field redpoint_cache_ts = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe0a.cmd0xe0a
 * JD-Core Version:    0.7.0.1
 */