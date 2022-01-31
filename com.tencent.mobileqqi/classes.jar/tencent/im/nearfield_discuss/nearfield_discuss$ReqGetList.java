package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearfield_discuss$ReqGetList
  extends MessageMicro
{
  public static final int BYTES_COOKIE_FIELD_NUMBER = 5;
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int MSG_LBS_INFO_FIELD_NUMBER = 2;
  public static final int STR_NUMBER_FIELD_NUMBER = 3;
  public static final int UINT32_SESSION_ID_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public nearfield_discuss.BusiReqHead msg_head = new nearfield_discuss.BusiReqHead();
  public nearfield_discuss.LBSInfo msg_lbs_info = new nearfield_discuss.LBSInfo();
  public final PBStringField str_number = PBField.initString("");
  public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "msg_head", "msg_lbs_info", "str_number", "uint32_session_id", "bytes_cookie" }, new Object[] { null, null, "", Integer.valueOf(0), localByteStringMicro }, ReqGetList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.nearfield_discuss.nearfield_discuss.ReqGetList
 * JD-Core Version:    0.7.0.1
 */