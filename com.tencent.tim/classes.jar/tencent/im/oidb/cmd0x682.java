package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x682
{
  public static final class ChatInfo
    extends MessageMicro<ChatInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField express_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField express_tips_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_chatflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_curdayFlag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_curexpcount = PBField.initUInt32(0);
    public final PBUInt32Field uint32_goldflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_totalFlag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_totalexpcount = PBField.initUInt32(0);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 74 }, new String[] { "uint64_touin", "uint32_chatflag", "uint32_goldflag", "uint32_totalexpcount", "uint32_curexpcount", "uint32_totalFlag", "uint32_curdayFlag", "express_tips_msg", "express_msg" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, ChatInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_touinlist" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_touinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_chatinfo" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<cmd0x682.ChatInfo> rpt_msg_chatinfo = PBField.initRepeatMessage(cmd0x682.ChatInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x682
 * JD-Core Version:    0.7.0.1
 */