package tencent.im.secretfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQService$RspBody
  extends MessageMicro
{
  public static final int MSG_GETSECRETFILEINFO_RESP_FIELD_NUMBER = 3;
  public static final int MSG_SETSECRETFILEINFO_RESP_FIELD_NUMBER = 4;
  public static final int UINT32_CMD_FIELD_NUMBER = 1;
  public static final int UINT32_SEQ_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_cmd", "uint32_seq", "msg_getSecretFileInfo_resp", "msg_setSecretFileInfo_resp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, RspBody.class);
  public QQService.GetSecretFileInfoResp msg_getSecretFileInfo_resp = new QQService.GetSecretFileInfoResp();
  public QQService.SetSecretFileInfoResp msg_setSecretFileInfo_resp = new QQService.SetSecretFileInfoResp();
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.secretfile.QQService.RspBody
 * JD-Core Version:    0.7.0.1
 */