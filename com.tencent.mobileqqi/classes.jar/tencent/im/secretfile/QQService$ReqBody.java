package tencent.im.secretfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQService$ReqBody
  extends MessageMicro
{
  public static final int MSG_GETSECRETFILEINFO_REQ_FIELD_NUMBER = 3;
  public static final int MSG_SETSECRETFILEINFO_REQ_FIELD_NUMBER = 4;
  public static final int UINT32_CMD_FIELD_NUMBER = 1;
  public static final int UINT32_OPERTYPE_FIELD_NUMBER = 5;
  public static final int UINT32_SEQ_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_cmd", "uint32_seq", "msg_getSecretFileInfo_req", "msg_setSecretFileInfo_req", "uint32_opertype" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0) }, ReqBody.class);
  public QQService.GetSecretFileInfoReq msg_getSecretFileInfo_req = new QQService.GetSecretFileInfoReq();
  public QQService.SetSecretFileInfoReq msg_setSecretFileInfo_req = new QQService.SetSecretFileInfoReq();
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_opertype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.secretfile.QQService.ReqBody
 * JD-Core Version:    0.7.0.1
 */