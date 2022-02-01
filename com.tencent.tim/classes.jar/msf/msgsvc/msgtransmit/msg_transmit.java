package msf.msgsvc.msgtransmit;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import msf.msgcomm.msg_comm.Msg;

public final class msg_transmit
{
  public static final class PbMultiMsgItem
    extends MessageMicro<PbMultiMsgItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField fileName = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "fileName", "buffer" }, new Object[] { "", localByteStringMicro }, PbMultiMsgItem.class);
    }
  }
  
  public static final class PbMultiMsgNew
    extends MessageMicro<PbMultiMsgNew>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg" }, new Object[] { null }, PbMultiMsgNew.class);
    public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
  }
  
  public static final class PbMultiMsgTransmit
    extends MessageMicro<PbMultiMsgTransmit>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg", "pbItemList" }, new Object[] { null, null }, PbMultiMsgTransmit.class);
    public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
    public final PBRepeatMessageField<msg_transmit.PbMultiMsgItem> pbItemList = PBField.initRepeatMessage(msg_transmit.PbMultiMsgItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msf.msgsvc.msgtransmit.msg_transmit
 * JD-Core Version:    0.7.0.1
 */