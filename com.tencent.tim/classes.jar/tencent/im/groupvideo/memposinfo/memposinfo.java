package tencent.im.groupvideo.memposinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class memposinfo
{
  public static final class AccountExtInfo
    extends MessageMicro<AccountExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_common_info", "msg_mini_program_info" }, new Object[] { null, null }, AccountExtInfo.class);
    public memposinfo.CommonInfo msg_common_info = new memposinfo.CommonInfo();
    public memposinfo.MiniProgramInfo msg_mini_program_info = new memposinfo.MiniProgramInfo();
  }
  
  public static final class AccountExtInfoList
    extends MessageMicro<AccountExtInfoList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_account_ext_info" }, new Object[] { null }, AccountExtInfoList.class);
    public final PBRepeatMessageField<memposinfo.AccountExtInfo> msg_account_ext_info = PBField.initRepeatMessage(memposinfo.AccountExtInfo.class);
  }
  
  public static final class CommonInfo
    extends MessageMicro<CommonInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_account = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt64Field uint64_account = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_account", "bytes_account", "uint32_source" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, CommonInfo.class);
    }
  }
  
  public static final class MiniProgramInfo
    extends MessageMicro<MiniProgramInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], MiniProgramInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.groupvideo.memposinfo.memposinfo
 * JD-Core Version:    0.7.0.1
 */