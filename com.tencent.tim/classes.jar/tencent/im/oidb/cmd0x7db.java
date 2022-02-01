package tencent.im.oidb;

import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.AppointInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7db
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "msg_appoint_id", "uint32_appoint_action", "uint32_overwrite", "rpt_msg_appoint_ids" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null }, ReqBody.class);
    public appoint_define.AppointID msg_appoint_id = new appoint_define.AppointID();
    public final PBRepeatMessageField<appoint_define.AppointID> rpt_msg_appoint_ids = PBField.initRepeatMessage(appoint_define.AppointID.class);
    public final PBUInt32Field uint32_appoint_action = PBField.initUInt32(0);
    public final PBUInt32Field uint32_overwrite = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_SigC2C = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.AppointInfo msg_appoint_info = new appoint_define.AppointInfo();
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field uint32_appoint_action = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "str_wording", "msg_appoint_info", "bytes_SigC2C", "uint32_appoint_action" }, new Object[] { "", null, localByteStringMicro, Integer.valueOf(0) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7db
 * JD-Core Version:    0.7.0.1
 */