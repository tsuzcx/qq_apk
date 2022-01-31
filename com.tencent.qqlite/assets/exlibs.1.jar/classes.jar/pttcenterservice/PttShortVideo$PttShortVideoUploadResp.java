package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$PttShortVideoUploadResp
  extends MessageMicro
{
  public static final int BYTES_UKEY_FIELD_NUMBER = 6;
  public static final int INT32_RET_CODE_FIELD_NUMBER = 1;
  public static final int RPT_DIFF_AREA_OUT_ADDR_FIELD_NUMBER = 4;
  public static final int RPT_SAME_AREA_OUT_ADDR_FIELD_NUMBER = 3;
  public static final int STR_FILEID_FIELD_NUMBER = 5;
  public static final int STR_RET_MSG_FIELD_NUMBER = 2;
  public static final int UINT32_FILE_EXIST_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_diff_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
  public final PBRepeatMessageField rpt_same_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
  public final PBStringField str_fileid = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBUInt32Field uint32_file_exist = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56 }, new String[] { "int32_ret_code", "str_ret_msg", "rpt_same_area_out_addr", "rpt_diff_area_out_addr", "str_fileid", "bytes_ukey", "uint32_file_exist" }, new Object[] { Integer.valueOf(0), "", null, null, "", localByteStringMicro, Integer.valueOf(0) }, PttShortVideoUploadResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.PttShortVideoUploadResp
 * JD-Core Version:    0.7.0.1
 */