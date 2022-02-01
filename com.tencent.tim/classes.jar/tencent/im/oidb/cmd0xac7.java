package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xac7
{
  public static final class BinderSig
    extends MessageMicro<BinderSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_type", "uint64_uin", "bytes_sig" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, BinderSig.class);
    }
  }
  
  public static final class DeviceInfo
    extends MessageMicro<DeviceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_din = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_din", "bytes_name" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, DeviceInfo.class);
    }
  }
  
  public static final class ReceiveMessageDevices
    extends MessageMicro<ReceiveMessageDevices>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_devices" }, new Object[] { null }, ReceiveMessageDevices.class);
    public final PBRepeatMessageField<cmd0xac7.DeviceInfo> rpt_devices = PBField.initRepeatMessage(cmd0xac7.DeviceInfo.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_extd = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0xac7.BinderSig msg_binder_sig = new cmd0xac7.BinderSig();
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_din = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_cmd", "uint64_din", "bytes_extd", "msg_binder_sig" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_extd = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_extd" }, new Object[] { localByteStringMicro }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac7
 * JD-Core Version:    0.7.0.1
 */