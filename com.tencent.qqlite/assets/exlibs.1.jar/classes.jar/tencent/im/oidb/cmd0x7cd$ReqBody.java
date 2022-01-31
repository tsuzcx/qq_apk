package tencent.im.oidb;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7cd$ReqBody
  extends MessageMicro
{
  public static final int MSG_LBS_INFO_FIELD_NUMBER = 4;
  public static final int UINT32_STAMP_FIELD_NUMBER = 1;
  public static final int UINT32_START_FIELD_NUMBER = 2;
  public static final int UINT32_WANT_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_stamp", "uint32_start", "uint32_want", "msg_lbs_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ReqBody.class);
  public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
  public final PBUInt32Field uint32_stamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start = PBField.initUInt32(0);
  public final PBUInt32Field uint32_want = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7cd.ReqBody
 * JD-Core Version:    0.7.0.1
 */