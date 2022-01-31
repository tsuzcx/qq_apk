package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$ElemFlags2$Inst
  extends MessageMicro
{
  public static final int UINT32_APP_ID_FIELD_NUMBER = 1;
  public static final int UINT32_INST_ID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_app_id", "uint32_inst_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Inst.class);
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_inst_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.ElemFlags2.Inst
 * JD-Core Version:    0.7.0.1
 */