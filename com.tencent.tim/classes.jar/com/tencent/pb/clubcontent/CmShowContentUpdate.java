package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CmShowContentUpdate
{
  public static final class STContInfo
    extends MessageMicro<STContInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field biz_id = PBField.initInt32(0);
    public final PBInt64Field item_id = PBField.initInt64(0L);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field ver = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "biz_id", "item_id", "name", "ver" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, STContInfo.class);
    }
  }
  
  public static final class STContUpdReq
    extends MessageMicro<STContUpdReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "app_id", "cont_list" }, new Object[] { Integer.valueOf(0), null }, STContUpdReq.class);
    public final PBInt32Field app_id = PBField.initInt32(0);
    public final PBRepeatMessageField<CmShowContentUpdate.STContInfo> cont_list = PBField.initRepeatMessage(CmShowContentUpdate.STContInfo.class);
  }
  
  public static final class STContUpdRsp
    extends MessageMicro<STContUpdRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "app_id", "domain_list", "cont_list", "intervals_ts" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0) }, STContUpdRsp.class);
    public final PBInt32Field app_id = PBField.initInt32(0);
    public final PBRepeatMessageField<CmShowContentUpdate.STVerInfo> cont_list = PBField.initRepeatMessage(CmShowContentUpdate.STVerInfo.class);
    public final PBRepeatMessageField<CmShowContentUpdate.STDomainInfo> domain_list = PBField.initRepeatMessage(CmShowContentUpdate.STDomainInfo.class);
    public final PBUInt32Field intervals_ts = PBField.initUInt32(0);
  }
  
  public static final class STDomainInfo
    extends MessageMicro<STDomainInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field domain_id = PBField.initInt32(0);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "domain_id", "url" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, STDomainInfo.class);
    }
  }
  
  public static final class STPatchInfo
    extends MessageMicro<STPatchInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field base_ver = PBField.initInt32(0);
    public final PBBytesField down_patch_file = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField patch_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field patch_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "base_ver", "patch_data", "patch_size", "down_patch_file" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, STPatchInfo.class);
    }
  }
  
  public static final class STVerInfo
    extends MessageMicro<STVerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field biz_id = PBField.initInt32(0);
    public final PBInt32Field domain_id = PBField.initInt32(0);
    public final PBBytesField down_file = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_patch = PBField.initUInt32(0);
    public final PBInt64Field item_id = PBField.initInt64(0L);
    public final PBBytesField md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public CmShowContentUpdate.STPatchInfo patch_info = new CmShowContentUpdate.STPatchInfo();
    public final PBInt32Field ver = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 56, 66, 72 }, new String[] { "biz_id", "item_id", "name", "ver", "down_file", "md5", "is_patch", "patch_info", "domain_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), null, Integer.valueOf(0) }, STVerInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.clubcontent.CmShowContentUpdate
 * JD-Core Version:    0.7.0.1
 */