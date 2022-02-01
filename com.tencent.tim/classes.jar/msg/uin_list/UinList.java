package msg.uin_list;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UinList
{
  public static final class C2C
    extends MessageMicro<C2C>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "to_uin" }, new Object[] { Long.valueOf(0L) }, C2C.class);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  }
  
  public static final class UinListFetchReq
    extends MessageMicro<UinListFetchReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_store_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_store_key" }, new Object[] { localByteStringMicro }, UinListFetchReq.class);
    }
  }
  
  public static final class UinListFetchRsp
    extends MessageMicro<UinListFetchRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_result", "friend_list" }, new Object[] { Integer.valueOf(0), null }, UinListFetchRsp.class);
    public final PBRepeatMessageField<UinList.C2C> friend_list = PBField.initRepeatMessage(UinList.C2C.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
  }
  
  public static final class UinListUploadReq
    extends MessageMicro<UinListUploadReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_cmd", "friend_list" }, new Object[] { Integer.valueOf(0), null }, UinListUploadReq.class);
    public final PBRepeatMessageField<UinList.C2C> friend_list = PBField.initRepeatMessage(UinList.C2C.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  }
  
  public static final class UinListUploadRsp
    extends MessageMicro<UinListUploadRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_store_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBUInt32Field silence_period = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "int32_result", "bytes_store_key", "silence_period" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, UinListUploadRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msg.uin_list.UinList
 * JD-Core Version:    0.7.0.1
 */