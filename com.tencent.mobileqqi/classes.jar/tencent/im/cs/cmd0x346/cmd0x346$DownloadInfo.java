package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x346$DownloadInfo
  extends MessageMicro
{
  public static final int BYTES_DOWNLOAD_KEY_FIELD_NUMBER = 10;
  public static final int RPT_STR_DOWNLOADIP_LIST_FIELD_NUMBER = 60;
  public static final int STR_COOKIE_FIELD_NUMBER = 70;
  public static final int STR_DOWNLOAD_DOMAIN_FIELD_NUMBER = 30;
  public static final int STR_DOWNLOAD_IP_FIELD_NUMBER = 20;
  public static final int STR_DOWNLOAD_URL_FIELD_NUMBER = 50;
  public static final int UINT32_PORT_FIELD_NUMBER = 40;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField rpt_str_downloadip_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_cookie = PBField.initString("");
  public final PBStringField str_download_domain = PBField.initString("");
  public final PBStringField str_download_ip = PBField.initString("");
  public final PBStringField str_download_url = PBField.initString("");
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 162, 242, 320, 402, 482, 562 }, new String[] { "bytes_download_key", "str_download_ip", "str_download_domain", "uint32_port", "str_download_url", "rpt_str_downloadip_list", "str_cookie" }, new Object[] { localByteStringMicro, "", "", Integer.valueOf(0), "", "", "" }, DownloadInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */