package tencent.im.nearfield_date;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_date$RespGetList
  extends MessageMicro
{
  public static final int BYTES_COOKIE_FIELD_NUMBER = 4;
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int RPT_MSG_USER_LIST_FIELD_NUMBER = 2;
  public static final int UINT32_ENDED_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public nearby_date.BusiRespHead msg_head = new nearby_date.BusiRespHead();
  public final PBRepeatMessageField rpt_msg_user_list = PBField.initRepeatMessage(nearby_date.UserProfile.class);
  public final PBUInt32Field uint32_ended = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_head", "rpt_msg_user_list", "uint32_ended", "bytes_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RespGetList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.nearfield_date.nearby_date.RespGetList
 * JD-Core Version:    0.7.0.1
 */