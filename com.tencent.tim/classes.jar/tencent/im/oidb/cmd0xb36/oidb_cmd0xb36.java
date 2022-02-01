package tencent.im.oidb.cmd0xb36;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb36
{
  public static final class ChainInfo
    extends MessageMicro<ChainInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64 }, new String[] { "id", "type", "uin", "desc", "pic", "created", "expired", "is_joined" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ChainInfo.class);
    public final PBUInt32Field created = PBField.initUInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field expired = PBField.initUInt32(0);
    public final PBUInt64Field id = PBField.initUInt64(0L);
    public final PBUInt32Field is_joined = PBField.initUInt32(0);
    public final PBRepeatField<String> pic = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class ChainList
    extends MessageMicro<ChainList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "infos", "group_role", "homework_role" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, ChainList.class);
    public final PBUInt32Field group_role = PBField.initUInt32(0);
    public final PBUInt32Field homework_role = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_cmd0xb36.ChainInfo> infos = PBField.initRepeatMessage(oidb_cmd0xb36.ChainInfo.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "group_id", "start", "num", "red_point_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field red_point_num = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "group_id", "toast", "chain_list" }, new Object[] { Long.valueOf(0L), null, null }, RspBody.class);
    public oidb_cmd0xb36.ChainList chain_list = new oidb_cmd0xb36.ChainList();
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public oidb_cmd0xb36.ToastInfo toast = new oidb_cmd0xb36.ToastInfo();
  }
  
  public static final class ToastInfo
    extends MessageMicro<ToastInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58 }, new String[] { "type", "wording", "id", "uins", "expired", "link", "icon" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", "" }, ToastInfo.class);
    public final PBUInt32Field expired = PBField.initUInt32(0);
    public final PBStringField icon = PBField.initString("");
    public final PBUInt64Field id = PBField.initUInt64(0L);
    public final PBStringField link = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField wording = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb36.oidb_cmd0xb36
 * JD-Core Version:    0.7.0.1
 */