package tencent.im.oidb.cmd0xe2e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe2e
{
  public static final class App
    extends MessageMicro<App>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56 }, new String[] { "appid", "type", "name", "icon", "url", "removable", "source" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, App.class);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field removable = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt64Field type = PBField.initUInt64(0L);
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
    public oidb_0xe2e.ClientInfo client = new oidb_0xe2e.ClientInfo();
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    public final PBUInt32Field mode = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "app" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xe2e.App> app = PBField.initRepeatMessage(oidb_0xe2e.App.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2e.oidb_0xe2e
 * JD-Core Version:    0.7.0.1
 */