package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5e0$ReqBody
  extends MessageMicro
{
  public static final int BYTES_SVRCONTEXT_FIELD_NUMBER = 2;
  public static final int RPT_MSG_UPDATE_PROFILE_LIST_FIELD_NUMBER = 1;
  public static final int RPT_UINT64_UINLIST_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_svrcontext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_msg_update_profile_list = PBField.initRepeatMessage(Oidb_0x5e0.UpdateProfileList.class);
  public final PBRepeatField rpt_uint64_uinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_msg_update_profile_list", "bytes_svrcontext", "rpt_uint64_uinlist" }, new Object[] { null, localByteStringMicro, Long.valueOf(0L) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ReqBody
 * JD-Core Version:    0.7.0.1
 */