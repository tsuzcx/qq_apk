package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xb4
{
  public static final class BodyType
    extends MessageMicro<BodyType>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_torchbearer" }, new Object[] { null }, BodyType.class);
    public torch_transfer.TorchbearerInfo msg_torchbearer = new torch_transfer.TorchbearerInfo();
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_type", "msg_body_type" }, new Object[] { Integer.valueOf(0), null }, MsgBody.class);
    public submsgtype0xb4.BodyType msg_body_type = new submsgtype0xb4.BodyType();
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.olympic.submsgtype0xb4
 * JD-Core Version:    0.7.0.1
 */