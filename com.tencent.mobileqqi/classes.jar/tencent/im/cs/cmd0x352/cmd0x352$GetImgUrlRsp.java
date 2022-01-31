package tencent.im.cs.cmd0x352;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x352$GetImgUrlRsp
  extends MessageMicro
{
  public static final int BYTES_BIG_DOWN_PARA_FIELD_NUMBER = 14;
  public static final int BYTES_DOWN_DOMAIN_FIELD_NUMBER = 12;
  public static final int BYTES_FAIL_MSG_FIELD_NUMBER = 4;
  public static final int BYTES_FILE_RESID_FIELD_NUMBER = 1;
  public static final int BYTES_ORIGINAL_DOWN_PARA_FIELD_NUMBER = 11;
  public static final int BYTES_THUMB_DOWN_PARA_FIELD_NUMBER = 10;
  public static final int MSG_IMG_INFO_FIELD_NUMBER = 7;
  public static final int RPT_BYTES_BIG_DOWN_URL_FIELD_NUMBER = 13;
  public static final int RPT_BYTES_ORIGINAL_DOWN_URL_FIELD_NUMBER = 6;
  public static final int RPT_BYTES_THUMB_DOWN_URL_FIELD_NUMBER = 5;
  public static final int RPT_UINT32_DOWN_IP_FIELD_NUMBER = 8;
  public static final int RPT_UINT32_DOWN_PORT_FIELD_NUMBER = 9;
  public static final int UINT32_CLIENT_IP_FIELD_NUMBER = 2;
  public static final int UINT32_RESULT_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_big_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_down_domain = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_original_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0x352.ImgInfo msg_img_info = new cmd0x352.ImgInfo();
  public final PBRepeatField rpt_bytes_big_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField rpt_bytes_original_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField rpt_bytes_thumb_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField rpt_uint32_down_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField rpt_uint32_down_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 64, 72, 82, 90, 98, 106, 114 }, new String[] { "bytes_file_resid", "uint32_client_ip", "uint32_result", "bytes_fail_msg", "rpt_bytes_thumb_down_url", "rpt_bytes_original_down_url", "msg_img_info", "rpt_uint32_down_ip", "rpt_uint32_down_port", "bytes_thumb_down_para", "bytes_original_down_para", "bytes_down_domain", "rpt_bytes_big_down_url", "bytes_big_down_para" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9 }, GetImgUrlRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlRsp
 * JD-Core Version:    0.7.0.1
 */