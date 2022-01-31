package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbBindUinMsgReadedConfirmResp
  extends MessageMicro
{
  public static final int ERRMSG_FIELD_NUMBER = 2;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int SYNC_COOKIE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "result", "errmsg", "sync_cookie" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro }, PbBindUinMsgReadedConfirmResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmResp
 * JD-Core Version:    0.7.0.1
 */