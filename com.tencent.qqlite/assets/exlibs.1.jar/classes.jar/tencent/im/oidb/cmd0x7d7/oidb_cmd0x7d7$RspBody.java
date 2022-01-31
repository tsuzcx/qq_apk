package tencent.im.oidb.cmd0x7d7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x7d7$RspBody
  extends MessageMicro
{
  public static final int BYTES_COOKIES_FIELD_NUMBER = 2;
  public static final int RPT_MSG_FRDLIST_FIELD_NUMBER = 3;
  public static final int UINT32_REQUEST_GAP_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_msg_frdlist = PBField.initRepeatMessage(oidb_cmd0x7d7.recommendinfo.class);
  public final PBUInt32Field uint32_request_gap = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_request_gap", "bytes_cookies", "rpt_msg_frdlist" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7d7.oidb_cmd0x7d7.RspBody
 * JD-Core Version:    0.7.0.1
 */