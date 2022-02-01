package tencent.im.oidb.cmd0xded;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xded
{
  public static final class ClassifyInfo
    extends MessageMicro<ClassifyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField icon_hover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xded.Node node = new oidb_0xded.Node();
    public final PBRepeatMessageField<oidb_0xded.Node> second_class = PBField.initRepeatMessage(oidb_0xded.Node.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "node", "second_class", "icon_url", "icon_hover_url", "color" }, new Object[] { null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ClassifyInfo.class);
    }
  }
  
  public static final class Node
    extends MessageMicro<Node>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field default_classify = PBField.initUInt32(0);
    public final PBRepeatField<Long> gc = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBytesField item = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField keyword = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField rule = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48 }, new String[] { "item", "keyword", "type", "default_classify", "rule", "gc" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L) }, Node.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqBody.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_classify_info" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xded.ClassifyInfo> rpt_classify_info = PBField.initRepeatMessage(oidb_0xded.ClassifyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xded.oidb_0xded
 * JD-Core Version:    0.7.0.1
 */