package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x501$SubCmd0x501ReqBody
  extends MessageMicro
{
  public static final int BYTES_LOGIN_SIG_TICKET_FIELD_NUMBER = 5;
  public static final int RPT_UINT32_SERVICE_TYPES_FIELD_NUMBER = 7;
  public static final int UINT32_APPID_FIELD_NUMBER = 3;
  public static final int UINT32_BID_FIELD_NUMBER = 8;
  public static final int UINT32_IDC_ID_FIELD_NUMBER = 2;
  public static final int UINT32_LOGIN_SIG_TYPE_FIELD_NUMBER = 4;
  public static final int UINT32_REQUEST_FLAG_FIELD_NUMBER = 6;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_login_sig_ticket = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField rpt_uint32_service_types = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_idc_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_login_sig_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_request_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64 }, new String[] { "uint64_uin", "uint32_idc_id", "uint32_appid", "uint32_login_sig_type", "bytes_login_sig_ticket", "uint32_request_flag", "rpt_uint32_service_types", "uint32_bid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x501ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501ReqBody
 * JD-Core Version:    0.7.0.1
 */