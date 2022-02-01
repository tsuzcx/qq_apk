package tencent.im.oidb.cmd0x799;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x799
{
  public static final class LongNickInfo
    extends MessageMicro<LongNickInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField StrNick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField StrTopicId = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field Type = PBField.initUInt32(0);
    public final PBUInt32Field dwCreateTime = PBField.initUInt32(0);
    public final PBUInt32Field dwDelTime = PBField.initUInt32(0);
    public final PBUInt32Field dwModiTime = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "StrTopicId", "StrNick", "Type", "dwCreateTime", "dwModiTime", "dwDelTime" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, LongNickInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> StrTopicIdList = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "StrTopicIdList" }, new Object[] { localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "astLongNickInfoList" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x799.LongNickInfo> astLongNickInfoList = PBField.initRepeatMessage(oidb_0x799.LongNickInfo.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x799.oidb_0x799
 * JD-Core Version:    0.7.0.1
 */