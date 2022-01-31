package tencent.im.oidb;

import appoint.define.appoint_define.AppointInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x7db$RspBody
  extends MessageMicro
{
  public static final int BYTES_SIGC2C_FIELD_NUMBER = 3;
  public static final int MSG_APPOINT_INFO_FIELD_NUMBER = 2;
  public static final int STR_WORDING_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_SigC2C = PBField.initBytes(ByteStringMicro.EMPTY);
  public appoint_define.AppointInfo msg_appoint_info = new appoint_define.AppointInfo();
  public final PBStringField str_wording = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_wording", "msg_appoint_info", "bytes_SigC2C" }, new Object[] { "", null, localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7db.RspBody
 * JD-Core Version:    0.7.0.1
 */