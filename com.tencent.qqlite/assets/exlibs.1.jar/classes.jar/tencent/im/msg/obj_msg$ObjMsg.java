package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class obj_msg$ObjMsg
  extends MessageMicro
{
  public static final int BYTES_TITLE_EXT_FIELD_NUMBER = 5;
  public static final int BYTES_TITLE_FIELD_NUMBER = 2;
  public static final int MSG_CONTENT_INFO_FIELD_NUMBER = 7;
  public static final int RPT_BYTES_ABSTACT_FIELD_NUMBER = 3;
  public static final int RPT_MSG_PIC_FIELD_NUMBER = 6;
  public static final int UINT32_MSG_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_REPORT_ID_SHOW_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField msg_content_info = PBField.initRepeatMessage(obj_msg.MsgContentInfo.class);
  public final PBRepeatField rpt_bytes_abstact = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField rpt_msg_pic = PBField.initRepeatMessage(obj_msg.MsgPic.class);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_report_id_show = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 42, 50, 58, 64 }, new String[] { "uint32_msg_type", "bytes_title", "rpt_bytes_abstact", "bytes_title_ext", "rpt_msg_pic", "msg_content_info", "uint32_report_id_show" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, null, Integer.valueOf(0) }, ObjMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.obj_msg.ObjMsg
 * JD-Core Version:    0.7.0.1
 */