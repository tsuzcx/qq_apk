package tencent.im.s2c.msgtype0x210.submsgtype0x9d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x9d
{
  public static final class ModuleUpdateNotify
    extends MessageMicro<ModuleUpdateNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "module_id", "module_version", "module_state" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ModuleUpdateNotify.class);
    public final PBUInt32Field module_id = PBField.initUInt32(0);
    public final PBUInt32Field module_state = PBField.initUInt32(0);
    public final PBUInt32Field module_version = PBField.initUInt32(0);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_sub_cmd", "lola_module_update" }, new Object[] { Integer.valueOf(0), null }, MsgBody.class);
    public final PBRepeatMessageField<SubMsgType0x9d.ModuleUpdateNotify> lola_module_update = PBField.initRepeatMessage(SubMsgType0x9d.ModuleUpdateNotify.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x9d.SubMsgType0x9d
 * JD-Core Version:    0.7.0.1
 */