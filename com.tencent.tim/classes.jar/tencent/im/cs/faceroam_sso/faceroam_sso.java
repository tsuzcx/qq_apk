package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class faceroam_sso
{
  public static final class PlatInfo
    extends MessageMicro<PlatInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "implat", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, PlatInfo.class);
    public final PBInt64Field implat = PBField.initInt64(0L);
    public final PBStringField mqqver = PBField.initString("");
    public final PBStringField osver = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "comm", "uint64_uin", "uint32_sub_cmd", "reqcmd_0x01", "reqcmd_0x02" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), null, null }, ReqBody.class);
    public faceroam_sso.PlatInfo comm = new faceroam_sso.PlatInfo();
    public faceroam_sso.ReqUserInfo reqcmd_0x01 = new faceroam_sso.ReqUserInfo();
    public faceroam_sso.ReqDeleteItem reqcmd_0x02 = new faceroam_sso.ReqDeleteItem();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqDeleteItem
    extends MessageMicro<ReqDeleteItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "filename" }, new Object[] { "" }, ReqDeleteItem.class);
    public final PBRepeatField<String> filename = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class ReqUserInfo
    extends MessageMicro<ReqUserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqUserInfo.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "ret", "errmsg", "sub_cmd", "rspcmd_0x01", "rspcmd_0x02" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), null, null }, RspBody.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBInt64Field ret = PBField.initInt64(0L);
    public faceroam_sso.RspUserInfo rspcmd_0x01 = new faceroam_sso.RspUserInfo();
    public faceroam_sso.RspDeleteItem rspcmd_0x02 = new faceroam_sso.RspDeleteItem();
    public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class RspDeleteItem
    extends MessageMicro<RspDeleteItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "filename", "ret" }, new Object[] { "", Long.valueOf(0L) }, RspDeleteItem.class);
    public final PBRepeatField<String> filename = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<Long> ret = PBField.initRepeat(PBInt64Field.__repeatHelper__);
  }
  
  public static final class RspUserInfo
    extends MessageMicro<RspUserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "filename", "delete_file", "bid", "max_roam_size", "uint32_emoji_type" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, RspUserInfo.class);
    public final PBStringField bid = PBField.initString("");
    public final PBRepeatField<String> delete_file = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> filename = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field max_roam_size = PBField.initUInt32(0);
    public final PBRepeatField<Integer> uint32_emoji_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.faceroam_sso.faceroam_sso
 * JD-Core Version:    0.7.0.1
 */