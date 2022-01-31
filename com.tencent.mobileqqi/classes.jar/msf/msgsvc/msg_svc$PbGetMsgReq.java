package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbGetMsgReq
  extends MessageMicro
{
  public static final int CONTEXT_FLAG_FIELD_NUMBER = 7;
  public static final int LATEST_RAMBLE_NUMBER_FIELD_NUMBER = 4;
  public static final int ONLINE_SYNC_FLAG_FIELD_NUMBER = 6;
  public static final int OTHER_RAMBLE_NUMBER_FIELD_NUMBER = 5;
  public static final int RAMBLE_FLAG_FIELD_NUMBER = 3;
  public static final int SYNC_COOKIE_FIELD_NUMBER = 2;
  public static final int SYNC_FLAG_FIELD_NUMBER = 1;
  public static final int WHISPER_SESSION_ID_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field context_flag = PBField.initUInt32(0);
  public final PBUInt32Field latest_ramble_number = PBField.initUInt32(20);
  public final PBUInt32Field online_sync_flag = PBField.initUInt32(1);
  public final PBUInt32Field other_ramble_number = PBField.initUInt32(3);
  public final PBUInt32Field ramble_flag = PBField.initUInt32(1);
  public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
  public final PBEnumField sync_flag = PBField.initEnum(0);
  public final PBUInt32Field whisper_session_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8("");
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64 }, new String[] { "sync_flag", "sync_cookie", "ramble_flag", "latest_ramble_number", "other_ramble_number", "online_sync_flag", "context_flag", "whisper_session_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) }, PbGetMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetMsgReq
 * JD-Core Version:    0.7.0.1
 */