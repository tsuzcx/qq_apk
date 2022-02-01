package tencent.im.oidb.cmd0x877;

import appoint.define.appoint_define.RichText;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x877
{
  public static final class FollowInfo
    extends MessageMicro<FollowInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "follow_word", "uint32_follow_count", "uint32_follow_flag", "uint64_follow_info_time" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, FollowInfo.class);
    public oidb_0x877.MsgWord follow_word = new oidb_0x877.MsgWord();
    public final PBUInt32Field uint32_follow_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_follow_info_time = PBField.initUInt64(0L);
  }
  
  public static final class InteractInfo
    extends MessageMicro<InteractInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "interact_word", "uint32_interact_count", "uint32_interact_flag", "uint64_interact_info_time" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, InteractInfo.class);
    public oidb_0x877.MsgWord interact_word = new oidb_0x877.MsgWord();
    public final PBUInt32Field uint32_interact_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interact_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_interact_info_time = PBField.initUInt64(0L);
  }
  
  public static final class MsgWord
    extends MessageMicro<MsgWord>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buluo_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_from_user = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_plain_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.RichText rich_fresh_word = new appoint_define.RichText();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_from_user", "bytes_plain_text", "bytes_buluo_word", "rich_fresh_word" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null }, MsgWord.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_refer" }, new Object[] { Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_refer = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "interact_info", "follow_info" }, new Object[] { null, null }, RspBody.class);
    public oidb_0x877.FollowInfo follow_info = new oidb_0x877.FollowInfo();
    public oidb_0x877.InteractInfo interact_info = new oidb_0x877.InteractInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x877.oidb_0x877
 * JD-Core Version:    0.7.0.1
 */