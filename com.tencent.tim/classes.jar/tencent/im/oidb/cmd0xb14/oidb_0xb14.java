package tencent.im.oidb.cmd0xb14;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb14
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "type", "group_id", "uins" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "group_id", "infos", "interval" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, RspBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBRepeatMessageField<oidb_0xb14.UserInfo> infos = PBField.initRepeatMessage(oidb_0xb14.UserInfo.class);
    public final PBUInt32Field interval = PBField.initUInt32(0);
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uin", "id", "course", "name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "" }, UserInfo.class);
    public final PBStringField course = PBField.initString("");
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb14.oidb_0xb14
 * JD-Core Version:    0.7.0.1
 */