package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xa8b
{
  public static final class DeletePoid
    extends MessageMicro<DeletePoid>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_poid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_poid" }, new Object[] { localByteStringMicro }, DeletePoid.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_msg_store_poid", "rpt_msg_delete_poid", "uint32_start_num" }, new Object[] { null, null, Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatMessageField<oidb_0xa8b.DeletePoid> rpt_msg_delete_poid = PBField.initRepeatMessage(oidb_0xa8b.DeletePoid.class);
    public final PBRepeatMessageField<oidb_0xa8b.StorePoid> rpt_msg_store_poid = PBField.initRepeatMessage(oidb_0xa8b.StorePoid.class);
    public final PBUInt32Field uint32_start_num = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_error_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_poid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Common.WifiPOIInfo> rpt_msg_favor_lists = PBField.initRepeatMessage(Common.WifiPOIInfo.class);
    public final PBUInt32Field uint32_next_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_poid", "bytes_msg_error_info", "rpt_msg_favor_lists", "uint32_next_num" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0) }, RspBody.class);
    }
  }
  
  public static final class StorePoid
    extends MessageMicro<StorePoid>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_poid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_poid" }, new Object[] { localByteStringMicro }, StorePoid.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0xa8b
 * JD-Core Version:    0.7.0.1
 */