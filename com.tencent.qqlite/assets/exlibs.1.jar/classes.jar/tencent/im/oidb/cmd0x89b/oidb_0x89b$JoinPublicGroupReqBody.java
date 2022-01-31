package tencent.im.oidb.cmd0x89b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.hotchat.LBS.Wifi;

public final class oidb_0x89b$JoinPublicGroupReqBody
  extends MessageMicro
{
  public static final int UINT64_VISITOR_UIN_FIELD_NUMBER = 1;
  public static final int WIFI_INFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_visitor_uin", "wifi_info" }, new Object[] { Long.valueOf(0L), null }, JoinPublicGroupReqBody.class);
  public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
  public LBS.Wifi wifi_info = new LBS.Wifi();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89b.oidb_0x89b.JoinPublicGroupReqBody
 * JD-Core Version:    0.7.0.1
 */