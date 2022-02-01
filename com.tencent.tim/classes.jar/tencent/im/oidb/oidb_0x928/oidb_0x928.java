package tencent.im.oidb.oidb_0x928;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x928
{
  public static final class NoticeInfo
    extends MessageMicro<NoticeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 72 }, new String[] { "id", "title", "summary", "url", "icon", "type", "app_id", "show_expire", "hide_mode" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, NoticeInfo.class);
    public final PBUInt64Field app_id = PBField.initUInt64(0L);
    public final PBUInt32Field hide_mode = PBField.initUInt32(0);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBUInt32Field show_expire = PBField.initUInt32(0);
    public final PBStringField summary = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "group_id", "platform", "version" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "group_id", "notice_info_list" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBRepeatMessageField<oidb_0x928.NoticeInfo> notice_info_list = PBField.initRepeatMessage(oidb_0x928.NoticeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x928.oidb_0x928
 * JD-Core Version:    0.7.0.1
 */