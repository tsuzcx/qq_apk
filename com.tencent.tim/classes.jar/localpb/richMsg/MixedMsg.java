package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MixedMsg
{
  public static final class Elem
    extends MessageMicro<Elem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "textMsg", "picMsg", "markfaceMsg", "sourceMsgInfo" }, new Object[] { "", null, null, "" }, Elem.class);
    public MarketFaceMsg.MarketFaceRec markfaceMsg = new MarketFaceMsg.MarketFaceRec();
    public RichMsg.PicRec picMsg = new RichMsg.PicRec();
    public final PBStringField sourceMsgInfo = PBField.initString("");
    public final PBStringField textMsg = PBField.initString("");
  }
  
  public static final class Msg
    extends MessageMicro<Msg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "elems" }, new Object[] { null }, Msg.class);
    public final PBRepeatMessageField<MixedMsg.Elem> elems = PBField.initRepeatMessage(MixedMsg.Elem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     localpb.richMsg.MixedMsg
 * JD-Core Version:    0.7.0.1
 */