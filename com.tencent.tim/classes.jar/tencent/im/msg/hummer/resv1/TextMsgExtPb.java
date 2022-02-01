package tencent.im.msg.hummer.resv1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TextMsgExtPb
{
  public static final class ResvAttr
    extends MessageMicro<ResvAttr>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field text_analysis_result = PBField.initUInt32(0);
    public final PBBytesField wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "wording", "text_analysis_result" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ResvAttr.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.resv1.TextMsgExtPb
 * JD-Core Version:    0.7.0.1
 */