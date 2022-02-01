package com.tencent.jungle.nearby.nio.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_common
{
  public static final class CommParamReq
    extends MessageMicro<CommParamReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_version", "uint32_platform" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, CommParamReq.class);
    }
  }
  
  public static final class DataCardConfig
    extends MessageMicro<DataCardConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_card_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tail_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_card_wording_color = PBField.initUInt32(0);
    public final PBUInt32Field uint32_entry_ability = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tail_wording_color = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50 }, new String[] { "bytes_card_wording", "bytes_tail_wording", "uint32_entry_ability", "uint32_card_wording_color", "uint32_tail_wording_color", "bytes_icon_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, DataCardConfig.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.jungle.nearby.nio.proto.oidb_common
 * JD-Core Version:    0.7.0.1
 */