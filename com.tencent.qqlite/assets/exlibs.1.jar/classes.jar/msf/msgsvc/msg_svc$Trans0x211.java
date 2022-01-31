package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.msg.im_msg_head.InstCtrl;

public final class msg_svc$Trans0x211
  extends MessageMicro
{
  public static final int C2C_TYPE_FIELD_NUMBER = 5;
  public static final int CC_CMD_FIELD_NUMBER = 2;
  public static final int INST_CTRL_FIELD_NUMBER = 3;
  public static final int SERVICE_TYPE_FIELD_NUMBER = 6;
  public static final int SIG_FIELD_NUMBER = 4;
  public static final int TO_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field c2c_type = PBField.initUInt32(0);
  public final PBUInt32Field cc_cmd = PBField.initUInt32(0);
  public im_msg_head.InstCtrl inst_ctrl = new im_msg_head.InstCtrl();
  public final PBUInt32Field service_type = PBField.initUInt32(0);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48 }, new String[] { "to_uin", "cc_cmd", "inst_ctrl", "sig", "c2c_type", "service_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, Trans0x211.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.Trans0x211
 * JD-Core Version:    0.7.0.1
 */