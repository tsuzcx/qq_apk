package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x5e0$RspBody
  extends MessageMicro
{
  public static final int BYTES_SVRCONTEXT_FIELD_NUMBER = 4;
  public static final int RPT_MSG_CONTENTITEM_FIELD_NUMBER = 1;
  public static final int RPT_MSG_PROFILELISTRESULT_FIELD_NUMBER = 3;
  public static final int UINT32_OVER_FLAG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_svrcontext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_msg_ProfileListResult = PBField.initRepeatMessage(Oidb_0x5e0.ProfileListResult.class);
  public final PBRepeatMessageField rpt_msg_contentItem = PBField.initRepeatMessage(Oidb_0x5e0.ContentItem.class);
  public final PBUInt32Field uint32_over_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "rpt_msg_contentItem", "uint32_over_flag", "rpt_msg_ProfileListResult", "bytes_svrcontext" }, new Object[] { null, Integer.valueOf(0), null, localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.RspBody
 * JD-Core Version:    0.7.0.1
 */