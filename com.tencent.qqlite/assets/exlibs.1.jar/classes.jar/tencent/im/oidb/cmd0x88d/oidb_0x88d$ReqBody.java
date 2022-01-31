package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x88d$ReqBody
  extends MessageMicro
{
  public static final int STZREQGROUPINFO_FIELD_NUMBER = 2;
  public static final int UINT32_APPID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_appid", "stzreqgroupinfo" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public final PBRepeatMessageField stzreqgroupinfo = PBField.initRepeatMessage(oidb_0x88d.ReqGroupInfo.class);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody
 * JD-Core Version:    0.7.0.1
 */