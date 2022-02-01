package tencent.im.cs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class head
{
  public static final class ContentHead
    extends MessageMicro<ContentHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_type", "uint32_subtype" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ContentHead.class);
    public final PBUInt32Field uint32_subtype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class Head
    extends MessageMicro<Head>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 98 }, new String[] { "msg_msg_head" }, new Object[] { null }, Head.class);
    public head.MsgHead msg_msg_head = new head.MsgHead();
  }
  
  public static final class MsgHead
    extends MessageMicro<MsgHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_content_head" }, new Object[] { null }, MsgHead.class);
    public head.ContentHead msg_content_head = new head.ContentHead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.head
 * JD-Core Version:    0.7.0.1
 */