package msf.msgcomm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_comm$ContentHead
  extends MessageMicro
{
  public static final int AUTO_REPLY_FIELD_NUMBER = 4;
  public static final int DIV_SEQ_FIELD_NUMBER = 3;
  public static final int PKG_INDEX_FIELD_NUMBER = 2;
  public static final int PKG_NUM_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "pkg_num", "pkg_index", "div_seq", "auto_reply" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ContentHead.class);
  public final PBUInt32Field auto_reply = PBField.initUInt32(0);
  public final PBUInt32Field div_seq = PBField.initUInt32(0);
  public final PBUInt32Field pkg_index = PBField.initUInt32(0);
  public final PBUInt32Field pkg_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     msf.msgcomm.msg_comm.ContentHead
 * JD-Core Version:    0.7.0.1
 */